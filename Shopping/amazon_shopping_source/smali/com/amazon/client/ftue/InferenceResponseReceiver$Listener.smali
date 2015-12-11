.class public interface abstract Lcom/amazon/client/ftue/InferenceResponseReceiver$Listener;
.super Ljava/lang/Object;
.source "InferenceResponseReceiver.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/ftue/InferenceResponseReceiver;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "Listener"
.end annotation


# virtual methods
.method public abstract onInferenceComplete(Landroid/content/Intent;)V
.end method

.method public abstract onInferenceRequiresInteraction(Landroid/content/Intent;)V
.end method
