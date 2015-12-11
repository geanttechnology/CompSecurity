.class Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
.super Ljava/lang/Object;
.source "CameraPreview.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/CameraPreview;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SizeAndRatio"
.end annotation


# instance fields
.field ratio:D

.field size:Landroid/hardware/Camera$Size;

.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/CameraPreview;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/viewit/CameraPreview;Landroid/hardware/Camera$Size;D)V
    .locals 0
    .param p2, "s"    # Landroid/hardware/Camera$Size;
    .param p3, "r"    # D

    .prologue
    .line 355
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->this$0:Lcom/amazon/mShop/search/viewit/CameraPreview;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 356
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    .line 357
    iput-wide p3, p0, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->ratio:D

    .line 358
    return-void
.end method
