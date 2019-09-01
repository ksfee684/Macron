package org.ksfee.android.macaron.library.model

import com.google.android.gms.tasks.OnCanceledListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import io.reactivex.Completable
import org.ksfee.android.macaron.library.controller.CollectionDeleter
import org.ksfee.android.macaron.library.controller.rx.exception.TaskCancelException
import org.ksfee.android.macaron.library.controller.rx.exception.TaskFailureException

abstract class CollectionModel {
    var documentReference: DocumentReference? = null

    fun delete() = CollectionDeleter().apply {
        enqueueTask(documentReference?.delete()
            ?: throw IllegalStateException("User doesn't have a document reference."))
    }

    fun deleteAsCompletable() = Completable.create { emitter ->
        delete()
            .addOnSuccessListener(OnSuccessListener {
                emitter.onComplete()
            })
            .addOnCanceledListener(OnCanceledListener {
                emitter.onError(TaskCancelException())
            })
            .addOnFailureListener(OnFailureListener {
                emitter.onError(TaskFailureException())
            })
    }
}
