.class public interface abstract Lcom/amazon/sdk/availability/DataStore;
.super Ljava/lang/Object;
.source "DataStore.java"


# virtual methods
.method public abstract close()V
.end method

.method public abstract getMeasurementsAfter(J)Lcom/amazon/sdk/availability/DataStoreIterator;
.end method

.method public abstract open(Landroid/content/Context;Lcom/amazon/sdk/availability/EncryptionManager;)V
.end method

.method public abstract put(Lorg/json/JSONObject;)Z
.end method
