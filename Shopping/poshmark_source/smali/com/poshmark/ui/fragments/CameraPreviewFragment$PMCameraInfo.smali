.class Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;
.super Ljava/lang/Object;
.source "CameraPreviewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/ui/fragments/CameraPreviewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PMCameraInfo"
.end annotation


# instance fields
.field cameraId:I

.field info:Landroid/hardware/Camera$CameraInfo;

.field final synthetic this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CameraPreviewFragment;ILandroid/hardware/Camera$CameraInfo;)V
    .locals 0
    .param p2, "id"    # I
    .param p3, "info"    # Landroid/hardware/Camera$CameraInfo;

    .prologue
    .line 843
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->this$0:Lcom/poshmark/ui/fragments/CameraPreviewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 844
    iput p2, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->cameraId:I

    .line 845
    iput-object p3, p0, Lcom/poshmark/ui/fragments/CameraPreviewFragment$PMCameraInfo;->info:Landroid/hardware/Camera$CameraInfo;

    .line 846
    return-void
.end method
