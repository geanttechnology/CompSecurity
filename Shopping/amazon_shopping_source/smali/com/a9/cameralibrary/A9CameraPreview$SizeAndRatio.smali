.class Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;
.super Ljava/lang/Object;
.source "A9CameraPreview.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/a9/cameralibrary/A9CameraPreview;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SizeAndRatio"
.end annotation


# instance fields
.field ratio:D

.field size:Landroid/hardware/Camera$Size;

.field final synthetic this$0:Lcom/a9/cameralibrary/A9CameraPreview;


# direct methods
.method public constructor <init>(Lcom/a9/cameralibrary/A9CameraPreview;Landroid/hardware/Camera$Size;D)V
    .locals 0
    .param p2, "s"    # Landroid/hardware/Camera$Size;
    .param p3, "r"    # D

    .prologue
    .line 610
    iput-object p1, p0, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->this$0:Lcom/a9/cameralibrary/A9CameraPreview;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 611
    iput-object p2, p0, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    .line 612
    iput-wide p3, p0, Lcom/a9/cameralibrary/A9CameraPreview$SizeAndRatio;->ratio:D

    .line 613
    return-void
.end method
