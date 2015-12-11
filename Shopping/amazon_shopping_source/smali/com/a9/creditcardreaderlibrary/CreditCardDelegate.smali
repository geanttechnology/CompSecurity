.class public Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;
.super Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;
.source "CreditCardDelegate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;
    }
.end annotation


# instance fields
.field m_interface:Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;


# direct methods
.method constructor <init>(Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;)V
    .locals 0
    .param p1, "a_interface"    # Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;->m_interface:Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;

    .line 21
    return-void
.end method


# virtual methods
.method public detectCard(I)V
    .locals 1
    .param p1, "detectedCardLines"    # I

    .prologue
    .line 25
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;->m_interface:Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;

    invoke-interface {v0, p1}, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;->onDetectedCardLines(I)V

    .line 26
    return-void
.end method

.method public detectCardPromising()V
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;->m_interface:Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;

    invoke-interface {v0}, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;->onPromisingCardDetection()V

    .line 36
    return-void
.end method

.method public detectCardStabilized()V
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;->m_interface:Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;

    invoke-interface {v0}, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;->onStabilizedCardDetection()V

    .line 41
    return-void
.end method

.method public recognizeCreditCard(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V
    .locals 1
    .param p1, "result"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate;->m_interface:Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;

    invoke-interface {v0, p1}, Lcom/a9/creditcardreaderlibrary/CreditCardDelegate$CreditCardCallbackInterface;->onRecognizedCreditCard(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V

    .line 31
    return-void
.end method
