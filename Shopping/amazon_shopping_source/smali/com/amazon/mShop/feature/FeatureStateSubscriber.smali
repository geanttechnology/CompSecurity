.class public interface abstract Lcom/amazon/mShop/feature/FeatureStateSubscriber;
.super Ljava/lang/Object;
.source "FeatureStateSubscriber.java"


# virtual methods
.method public abstract onCancel()V
.end method

.method public abstract onError(Ljava/lang/Exception;)V
.end method

.method public abstract onFeatureStateReceived(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;)V"
        }
    .end annotation
.end method
