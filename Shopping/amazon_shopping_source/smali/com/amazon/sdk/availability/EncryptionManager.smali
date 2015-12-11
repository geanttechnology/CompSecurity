.class interface abstract Lcom/amazon/sdk/availability/EncryptionManager;
.super Ljava/lang/Object;
.source "EncryptionManager.java"


# virtual methods
.method public abstract decrypt([B)Ljava/lang/String;
.end method

.method public abstract encrypt(Lorg/json/JSONObject;)[B
.end method

.method public abstract getEncryptionAlgorithm()Ljava/lang/String;
.end method

.method public abstract getKey()Ljava/lang/String;
.end method
