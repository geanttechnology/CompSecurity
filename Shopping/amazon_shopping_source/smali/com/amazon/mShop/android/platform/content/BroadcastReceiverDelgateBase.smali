.class public abstract Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;
.super Ljava/lang/Object;
.source "BroadcastReceiverDelgateBase.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Landroid/content/BroadcastReceiver;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field protected final mReceiverProxy:Landroid/content/BroadcastReceiver;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/BroadcastReceiver;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 11
    .local p0, "this":Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;, "Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase<TT;>;"
    .local p1, "receiverProxy":Landroid/content/BroadcastReceiver;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;->mReceiverProxy:Landroid/content/BroadcastReceiver;

    .line 13
    return-void
.end method


# virtual methods
.method public getProxy()Landroid/content/BroadcastReceiver;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 18
    .local p0, "this":Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;, "Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase<TT;>;"
    iget-object v0, p0, Lcom/amazon/mShop/android/platform/content/BroadcastReceiverDelgateBase;->mReceiverProxy:Landroid/content/BroadcastReceiver;

    return-object v0
.end method

.method public abstract onReceive_impl(Landroid/content/Context;Landroid/content/Intent;)V
.end method
