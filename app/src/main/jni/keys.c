#include <jni.h>

JNIEXPORT jstring JNICALL
Java_com_wonmirzo_securekey_MainActivity_getPublicKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "long_public_key");
}

JNIEXPORT jstring JNICALL
Java_com_wonmirzo_securekey_MainActivity_getPrivateKey(JNIEnv *env, jobject instance) {
    return (*env)->NewStringUTF(env, "long_private_key");
}

JNIEXPORT jstring JNICALL
Java_com_wonmirzo_securekey_MyApplication_getApplicationKey(JNIEnv *env, jobject this
) {
    return (*env)->NewStringUTF(env, "That's application private key");
}
