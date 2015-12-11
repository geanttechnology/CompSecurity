.class public interface abstract Lcom/flow/android/engine/library/FlowStateEngineInterface;
.super Ljava/lang/Object;
.source "FlowStateEngineInterface.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;
    }
.end annotation


# virtual methods
.method public abstract didDecodeTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V
.end method

.method public abstract didProcessFrame(Lcom/a9/vs/mobile/library/impl/jni/ObjectID;II)V
.end method

.method public abstract didReceieveBadTextCanvasDecode()V
.end method

.method public abstract didReceieveScannerBoring()V
.end method

.method public abstract didReceiveBarcodeDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowBarcodeObjectInfo;)V
.end method

.method public abstract didReceiveDataMatrixDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;)V
.end method

.method public abstract didReceiveFreeText(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation
.end method

.method public abstract didReceiveImageMatchSuccess(Lcom/flow/android/engine/library/objectinfo/FlowImageMatchObjectInfo;)V
.end method

.method public abstract didReceiveInterestPoints(Ljava/util/ArrayList;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/graphics/PointF;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract didReceiveLogoResponse(Lcom/flow/android/engine/library/objectinfo/FlowLogoMatchObjectInfo;)V
.end method

.method public abstract didReceiveQRCodeDecodeSuccess(Lcom/flow/android/engine/library/objectinfo/FlowQrCodeObjectInfo;)V
.end method

.method public abstract didReceiveScannerStuck()V
.end method

.method public abstract didReceiveServerFailure(Lcom/flow/android/engine/library/FlowStateEngineInterface$CallbackServerFailure;)V
.end method

.method public abstract didReceiveTextSuccess(Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;)V
.end method

.method public abstract didReceiveTrack(ILjava/util/ArrayList;Landroid/graphics/PointF;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/graphics/PointF;",
            ">;",
            "Landroid/graphics/PointF;",
            ")V"
        }
    .end annotation
.end method

.method public abstract didReceiveTrackFail(I)V
.end method

.method public abstract didStopTrackingTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V
.end method

.method public abstract didTrackTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V
.end method

.method public abstract didUpdateTextCanvas(Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;)V
.end method

.method public abstract showMessage(Ljava/lang/String;)V
.end method
