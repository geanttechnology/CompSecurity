.class public interface abstract Lcom/amazon/mShop/control/ObjectSubscriber;
.super Ljava/lang/Object;
.source "ObjectSubscriber.java"

# interfaces
.implements Lcom/amazon/mShop/control/GenericSubscriber;


# virtual methods
.method public abstract onAvailableCountReceived(I)V
.end method

.method public abstract onCancelled()V
.end method

.method public abstract onObjectReceived(Ljava/lang/Object;I)V
.end method

.method public abstract onObjectsReceived()V
.end method

.method public abstract onPageComplete()V
.end method
