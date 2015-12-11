.class public interface abstract Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;
.super Ljava/lang/Object;
.source "CreditCardDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "CreditCardCallbackInterface"
.end annotation


# virtual methods
.method public abstract onDetectedCardLines(I)V
.end method

.method public abstract onPromisingCardDetection()V
.end method

.method public abstract onRecognizedCreditCard(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V
.end method

.method public abstract onStabilizedCardDetection()V
.end method
