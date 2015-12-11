.class public Lcom/flow/android/engine/library/impl/FlowEventCallback;
.super Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;
.source "FlowEventCallback.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flow/android/engine/library/impl/FlowEventCallback$1;
    }
.end annotation


# instance fields
.field private m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

.field private m_networkErrorMode:Z


# direct methods
.method public constructor <init>(Lcom/flow/android/engine/library/FlowStateEngineInterface;)V
    .locals 2
    .param p1, "a_interface"    # Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .prologue
    const/4 v1, 0x0

    .line 30
    invoke-direct {p0}, Lcom/a9/vs/mobile/library/impl/jni/EventDelegateBase;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .line 27
    iput-boolean v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_networkErrorMode:Z

    .line 31
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .line 32
    iput-boolean v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_networkErrorMode:Z

    .line 33
    return-void
.end method


# virtual methods
.method public didDecode(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
    .locals 3
    .param p1, "objInfoOut"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .prologue
    .line 57
    sget-object v1, Lcom/flow/android/engine/library/impl/FlowEventCallback$1;->$SwitchMap$com$a9$vs$mobile$library$impl$jni$ObjectID:[I

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getObjType()Lcom/a9/vs/mobile/library/impl/jni/ObjectID;

    move-result-object v2

    invoke-virtual {v2}, Lcom/a9/vs/mobile/library/impl/jni/ObjectID;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 91
    :goto_0
    return-void

    .line 59
    :pswitch_0
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;

    invoke-direct {v0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 60
    .local v0, "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v1, v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveImageMatchSuccess(Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;)V

    goto :goto_0

    .line 64
    .end local v0    # "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;
    :pswitch_1
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;

    invoke-direct {v0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 65
    .local v0, "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v1, v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveBarcodeDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;)V

    goto :goto_0

    .line 69
    .end local v0    # "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;
    :pswitch_2
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getEntityType()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "DATA-MATRIX"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 70
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowQrCodeObjectInfo;

    invoke-direct {v0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowQrCodeObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 71
    .local v0, "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowQrCodeObjectInfo;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v1, v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveQRCodeDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowQrCodeObjectInfo;)V

    goto :goto_0

    .line 73
    .end local v0    # "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowQrCodeObjectInfo;
    :cond_0
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;

    invoke-direct {v0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 74
    .local v0, "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v1, v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveDataMatrixDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;)V

    goto :goto_0

    .line 79
    .end local v0    # "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;
    :pswitch_3
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;

    invoke-direct {v0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 80
    .local v0, "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v1, v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveTextSuccess(Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;)V

    goto :goto_0

    .line 84
    .end local v0    # "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;
    :pswitch_4
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;

    invoke-direct {v0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 85
    .local v0, "flowObjInfo":Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v1, v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveLogoResponse(Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;)V

    goto :goto_0

    .line 57
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public didDecodeFreeText(Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;Ljava/lang/String;)V
    .locals 7
    .param p1, "nounsBrandsModelnums"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .param p2, "words"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;
    .param p3, "layout"    # Ljava/lang/String;

    .prologue
    .line 106
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 107
    .local v1, "nounsBrandsModelnumList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    int-to-long v3, v0

    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-gez v3, :cond_0

    .line 108
    invoke-virtual {p1, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 107
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 110
    :cond_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 111
    .local v2, "wordList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const/4 v0, 0x0

    :goto_1
    int-to-long v3, v0

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->size()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-gez v3, :cond_1

    .line 112
    invoke-virtual {p2, v0}, Lcom/a9/vs/mobile/library/impl/jni/VectorOfString;->get(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 111
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 114
    :cond_1
    iget-object v3, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v3, v1, v2, p3}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveFreeText(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V

    .line 115
    return-void
.end method

.method public didDecodeTextCanvas(ILjava/lang/String;)V
    .locals 2
    .param p1, "sessionId"    # I
    .param p2, "uniqueId"    # Ljava/lang/String;

    .prologue
    .line 124
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;

    invoke-direct {v0, p1, p2}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;-><init>(ILjava/lang/String;)V

    .line 125
    .local v0, "info":Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v1, v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didDecodeTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V

    .line 126
    return-void
.end method

.method public didDetectInterestPoints(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
    .locals 2
    .param p1, "points"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    .prologue
    .line 119
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-static {p1}, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;->getPoints(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveInterestPoints(Ljava/util/ArrayList;)V

    .line 120
    return-void
.end method

.method public didProcessFrame(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/StatusID;II)V
    .locals 1
    .param p1, "objectType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "status"    # Lcom/a9/vs/mobile/library/impl/jni/StatusID;
    .param p3, "processFrameID"    # I
    .param p4, "info"    # I

    .prologue
    .line 181
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v0, p1, p3, p4}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didProcessFrame(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;II)V

    .line 182
    return-void
.end method

.method public didReceieveBadTextCanvasDecode()V
    .locals 1

    .prologue
    .line 176
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceieveBadTextCanvasDecode()V

    .line 177
    return-void
.end method

.method public didReceiveServerError(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;)V
    .locals 2
    .param p1, "objectType"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectID;
    .param p2, "reason"    # Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;

    .prologue
    .line 191
    sget-object v0, Lcom/flow/android/engine/library/impl/FlowEventCallback$1;->$SwitchMap$com$a9$vs$mobile$library$impl$jni$ServerFailure:[I

    invoke-virtual {p2}, Lcom/a9/vs/mobile/library/impl/jni/ServerFailure;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 207
    :goto_0
    return-void

    .line 193
    :pswitch_0
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->NO_NETWORK:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    invoke-interface {v0, v1}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveServerFailure(Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;)V

    goto :goto_0

    .line 196
    :pswitch_1
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->SERVER_ERROR:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    invoke-interface {v0, v1}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveServerFailure(Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;)V

    goto :goto_0

    .line 199
    :pswitch_2
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->UNAUTHORIZED_ACCESS:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    invoke-interface {v0, v1}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveServerFailure(Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;)V

    goto :goto_0

    .line 202
    :pswitch_3
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    sget-object v1, Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;->UNKNOWN:Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;

    invoke-interface {v0, v1}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveServerFailure(Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;)V

    goto :goto_0

    .line 191
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public didStopTrackingTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
    .locals 2
    .param p1, "canvas"    # Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    .prologue
    .line 171
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    new-instance v1, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;

    invoke-direct {v1, p1}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    invoke-interface {v0, v1}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didStopTrackingTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V

    .line 172
    return-void
.end method

.method public didTrack(ILcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)V
    .locals 4
    .param p1, "id"    # I
    .param p2, "loc"    # Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;

    .prologue
    .line 95
    invoke-static {p2}, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;->getPointsAndCentroid(Lcom/a9/vs/mobile/library/impl/jni/VectorOfPoint2f;)Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;

    move-result-object v0

    .line 96
    .local v0, "pc":Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    iget-object v2, v0, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;->m_points:Ljava/util/ArrayList;

    iget-object v3, v0, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo$PointsAndCentroid;->m_centroid:Landroid/graphics/PointF;

    invoke-interface {v1, p1, v2, v3}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveTrack(ILjava/util/ArrayList;Landroid/graphics/PointF;)V

    .line 97
    return-void
.end method

.method public didTrackFail(I)V
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 101
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v0, p1}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveTrackFail(I)V

    .line 102
    return-void
.end method

.method public didTrackTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
    .locals 2
    .param p1, "canvas"    # Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    .prologue
    .line 157
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;

    invoke-direct {v0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    .line 158
    .local v0, "info":Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v1, v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didTrackTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V

    .line 167
    return-void
.end method

.method public didUpdateTextCanvas(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
    .locals 2
    .param p1, "canvas"    # Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    .prologue
    .line 130
    new-instance v0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;

    invoke-direct {v0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V

    .line 131
    .local v0, "info":Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;
    iget-object v1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v1, v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didUpdateTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V

    .line 153
    return-void
.end method

.method public setInterface(Lcom/flow/android/engine/library/FlowStateEngineInterface;)V
    .locals 0
    .param p1, "a_interface"    # Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    .line 41
    return-void
.end method

.method public setNetworkErrorMode(Z)V
    .locals 0
    .param p1, "a_networkErrorMode"    # Z

    .prologue
    .line 36
    iput-boolean p1, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_networkErrorMode:Z

    .line 37
    return-void
.end method

.method public showMessage(Ljava/lang/String;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 186
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v0, p1}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->showMessage(Ljava/lang/String;)V

    .line 187
    return-void
.end method

.method public suggestBoringEvent()V
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceieveScannerBoring()V

    .line 53
    return-void
.end method

.method public suggestStuckEvent()V
    .locals 1

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_networkErrorMode:Z

    if-nez v0, :cond_0

    .line 46
    iget-object v0, p0, Lcom/flow/android/engine/library/impl/FlowEventCallback;->m_delegate:Lcom/flow/android/engine/library/FlowStateEngineInterface;

    invoke-interface {v0}, Lcom/flow/android/engine/library/FlowStateEngineInterface;->didReceiveScannerStuck()V

    .line 48
    :cond_0
    return-void
.end method
