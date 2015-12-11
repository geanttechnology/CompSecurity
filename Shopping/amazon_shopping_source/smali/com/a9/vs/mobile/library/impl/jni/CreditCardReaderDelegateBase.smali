.class public Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;
.super Ljava/lang/Object;
.source "CreditCardReaderDelegateBase.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 78
    invoke-static {}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_CreditCardReaderDelegateBase()J

    move-result-wide v0

    invoke-direct {p0, v0, v1, v3}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;-><init>(JZ)V

    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    iget-boolean v2, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCMemOwn:Z

    invoke-static {p0, v0, v1, v2, v3}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_director_connect(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;JZZ)V

    .line 80
    return-void
.end method

.method protected constructor <init>(JZ)V
    .locals 0
    .param p1, "cPtr"    # J
    .param p3, "cMemoryOwn"    # Z

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    .line 18
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    goto :goto_0
.end method


# virtual methods
.method public declared-synchronized delete()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 29
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_CreditCardReaderDelegateBase(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 36
    :cond_1
    monitor-exit p0

    return-void

    .line 29
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public detectBlackScreen()V
    .locals 2

    .prologue
    .line 70
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectBlackScreen(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    .line 71
    :goto_0
    return-void

    .line 70
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectBlackScreenSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    goto :goto_0
.end method

.method public detectCard(I)V
    .locals 2
    .param p1, "detectedCardLines"    # I

    .prologue
    .line 54
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectCard(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;I)V

    .line 55
    :goto_0
    return-void

    .line 54
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectCardSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;I)V

    goto :goto_0
.end method

.method public detectCardPromising()V
    .locals 2

    .prologue
    .line 62
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectCardPromising(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    .line 63
    :goto_0
    return-void

    .line 62
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectCardPromisingSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    goto :goto_0
.end method

.method public detectCardStabilized()V
    .locals 2

    .prologue
    .line 58
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectCardStabilized(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    .line 59
    :goto_0
    return-void

    .line 58
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectCardStabilizedSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    goto :goto_0
.end method

.method public detectDarkScene()V
    .locals 2

    .prologue
    .line 74
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectDarkScene(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    .line 75
    :goto_0
    return-void

    .line 74
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_detectDarkSceneSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    goto :goto_0
.end method

.method protected finalize()V
    .locals 0

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->delete()V

    .line 26
    return-void
.end method

.method public recognizeCreditCard(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V
    .locals 6
    .param p1, "result"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;

    .prologue
    .line 66
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    if-ne v0, v1, :cond_0

    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_recognizeCreditCard(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V

    .line 67
    :goto_0
    return-void

    .line 66
    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_recognizeCreditCardSwigExplicitCreditCardReaderDelegateBase(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;JLcom/a9/vs/mobile/library/impl/jni/CreditCardInfo;)V

    goto :goto_0
.end method

.method protected swigDirectorDisconnect()V
    .locals 1

    .prologue
    .line 39
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCMemOwn:Z

    .line 40
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->delete()V

    .line 41
    return-void
.end method

.method public swigReleaseOwnership()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 44
    iput-boolean v2, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCMemOwn:Z

    .line 45
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_change_ownership(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;JZ)V

    .line 46
    return-void
.end method

.method public swigTakeOwnership()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 49
    iput-boolean v2, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCMemOwn:Z

    .line 50
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->swigCPtr:J

    invoke-static {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderDelegateBase_change_ownership(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;JZ)V

    .line 51
    return-void
.end method
