.class public Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;
.super Ljava/lang/Object;
.source "CreditCardReaderFacade.java"


# instance fields
.field protected swigCMemOwn:Z

.field private swigCPtr:J


# direct methods
.method protected constructor <init>(JZ)V
    .locals 0
    .param p1, "cPtr"    # J
    .param p3, "cMemoryOwn"    # Z

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean p3, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCMemOwn:Z

    .line 17
    iput-wide p1, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    .line 18
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)V
    .locals 3
    .param p1, "processProperty"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;

    .prologue
    .line 39
    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)J

    move-result-wide v0

    invoke-static {v0, v1, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->new_CreditCardReaderFacade(JLcom/a9/vs/mobile/library/impl/jni/CreditCardProcessProperty;)J

    move-result-wide v0

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;-><init>(JZ)V

    .line 40
    return-void
.end method

.method protected static getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;)J
    .locals 2
    .param p0, "obj"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;

    .prologue
    .line 21
    if-nez p0, :cond_0

    const-wide/16 v0, 0x0

    :goto_0
    return-wide v0

    :cond_0
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

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
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    cmp-long v0, v0, v2

    if-eqz v0, :cond_1

    .line 30
    iget-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCMemOwn:Z

    if-eqz v0, :cond_0

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCMemOwn:Z

    .line 32
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-static {v0, v1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->delete_CreditCardReaderFacade(J)V

    .line 34
    :cond_0
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J
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

.method protected finalize()V
    .locals 0

    .prologue
    .line 25
    invoke-virtual {p0}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->delete()V

    .line 26
    return-void
.end method

.method public generateReportAndClear(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)V
    .locals 9
    .param p1, "intMap"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;
    .param p2, "doubleMap"    # Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;

    .prologue
    .line 79
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;)J

    move-result-wide v3

    invoke-static {p2}, Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)J

    move-result-wide v6

    move-object v2, p0

    move-object v5, p1

    move-object v8, p2

    invoke-static/range {v0 .. v8}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_generateReportAndClear(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToUInt;JLcom/a9/vs/mobile/library/impl/jni/MapOfStringToDouble;)V

    .line 80
    return-void
.end method

.method public getCreditCardImage(Lcom/a9/vs/mobile/library/impl/jni/ImageByteData;)V
    .locals 6
    .param p1, "image"    # Lcom/a9/vs/mobile/library/impl/jni/ImageByteData;

    .prologue
    .line 63
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/ImageByteData;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/ImageByteData;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_getCreditCardImage(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;JLcom/a9/vs/mobile/library/impl/jni/ImageByteData;)V

    .line 64
    return-void
.end method

.method public getOptimalSize(IILcom/a9/vs/mobile/library/impl/jni/CardRegion;)V
    .locals 8
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "cardRegion"    # Lcom/a9/vs/mobile/library/impl/jni/CardRegion;

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-static {p3}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CardRegion;)J

    move-result-wide v5

    move-object v2, p0

    move v3, p1

    move v4, p2

    move-object v7, p3

    invoke-static/range {v0 .. v7}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_getOptimalSize__SWIG_0(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;IIJLcom/a9/vs/mobile/library/impl/jni/CardRegion;)V

    .line 56
    return-void
.end method

.method public getOptimalSize(IILcom/a9/vs/mobile/library/impl/jni/Orientation;Lcom/a9/vs/mobile/library/impl/jni/CardRegion;)V
    .locals 9
    .param p1, "width"    # I
    .param p2, "height"    # I
    .param p3, "orient"    # Lcom/a9/vs/mobile/library/impl/jni/Orientation;
    .param p4, "cardRegion"    # Lcom/a9/vs/mobile/library/impl/jni/CardRegion;

    .prologue
    .line 59
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-virtual {p3}, Lcom/a9/vs/mobile/library/impl/jni/Orientation;->swigValue()I

    move-result v5

    invoke-static {p4}, Lcom/a9/vs/mobile/library/impl/jni/CardRegion;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CardRegion;)J

    move-result-wide v6

    move-object v2, p0

    move v3, p1

    move v4, p2

    move-object v8, p4

    invoke-static/range {v0 .. v8}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_getOptimalSize__SWIG_1(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;IIIJLcom/a9/vs/mobile/library/impl/jni/CardRegion;)V

    .line 60
    return-void
.end method

.method public loadDigitModel(Ljava/lang/String;)Z
    .locals 2
    .param p1, "digitModelFile"    # Ljava/lang/String;

    .prologue
    .line 51
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-static {v0, v1, p0, p1}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_loadDigitModel(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public process([BIIIIII)V
    .locals 10
    .param p1, "imgData"    # [B
    .param p2, "numRows"    # I
    .param p3, "numCols"    # I
    .param p4, "xDisp"    # I
    .param p5, "yDisp"    # I
    .param p6, "widthDisp"    # I
    .param p7, "heightDisp"    # I

    .prologue
    .line 75
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    move-object v2, p0

    move-object v3, p1

    move v4, p2

    move v5, p3

    move v6, p4

    move v7, p5

    move/from16 v8, p6

    move/from16 v9, p7

    invoke-static/range {v0 .. v9}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_process(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;[BIIIIII)V

    .line 76
    return-void
.end method

.method public setDelegate(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V
    .locals 6
    .param p1, "_delegate"    # Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;

    .prologue
    .line 43
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-static {p1}, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;->getCPtr(Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)J

    move-result-wide v3

    move-object v2, p0

    move-object v5, p1

    invoke-static/range {v0 .. v5}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_setDelegate(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderDelegateBase;)V

    .line 44
    return-void
.end method

.method public setOrientation(Lcom/a9/vs/mobile/library/impl/jni/Orientation;)V
    .locals 3
    .param p1, "orient"    # Lcom/a9/vs/mobile/library/impl/jni/Orientation;

    .prologue
    .line 47
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/Orientation;->swigValue()I

    move-result v2

    invoke-static {v0, v1, p0, v2}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_setOrientation(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;I)V

    .line 48
    return-void
.end method

.method public start()V
    .locals 2

    .prologue
    .line 67
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_start(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;)V

    .line 68
    return-void
.end method

.method public stop()V
    .locals 2

    .prologue
    .line 71
    iget-wide v0, p0, Lcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;->swigCPtr:J

    invoke-static {v0, v1, p0}, Lcom/a9/vs/mobile/library/impl/jni/A9VSMobileJNI;->CreditCardReaderFacade_stop(JLcom/a9/vs/mobile/library/impl/jni/CreditCardReaderFacade;)V

    .line 72
    return-void
.end method
