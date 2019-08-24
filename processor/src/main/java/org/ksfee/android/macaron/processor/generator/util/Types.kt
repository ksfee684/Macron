package org.ksfee.android.macaron.processor.generator.util

import com.squareup.kotlinpoet.ClassName

object Types {
    // Firestore
    val FirestoreQuery =
        ClassName("com.google.firebase.firestore", "Query")
    val FirestoreDatabase =
        ClassName("com.google.firebase.firestore", "FirebaseFirestore")
    val CollectionReference =
        ClassName("com.google.firebase.firestore", "CollectionReference")
    val OnSuccessListener =
        ClassName("com.google.android.gms.tasks", "OnSuccessListener")
    val OnFailureListener =
        ClassName("com.google.android.gms.tasks", "OnFailureListener")
    val OnCanceledListener: ClassName =
        ClassName("com.google.android.gms.tasks", "OnCanceledListener")

    // library module
    val TypedValue =
        ClassName("org.ksfee.android.macaron.library.ext", "typedValue")
    val TypedNullableValue =
        ClassName("org.ksfee.android.macaron.library.ext", "typedNullableValue")
}
