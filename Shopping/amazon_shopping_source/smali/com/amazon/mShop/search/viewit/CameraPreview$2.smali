.class Lcom/amazon/mShop/search/viewit/CameraPreview$2;
.super Ljava/lang/Object;
.source "CameraPreview.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/CameraPreview;->calculateBestPreviewSizeAndAdjustLayout(Landroid/hardware/Camera;Landroid/graphics/Rect;III)Landroid/hardware/Camera$Size;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/CameraPreview;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/CameraPreview;)V
    .locals 0

    .prologue
    .line 284
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/CameraPreview$2;->this$0:Lcom/amazon/mShop/search/viewit/CameraPreview;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;)I
    .locals 2
    .param p1, "a_lhs"    # Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;
    .param p2, "a_rhs"    # Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;

    .prologue
    .line 287
    iget-object v0, p2, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    iget v0, v0, Landroid/hardware/Camera$Size;->height:I

    iget-object v1, p1, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;->size:Landroid/hardware/Camera$Size;

    iget v1, v1, Landroid/hardware/Camera$Size;->height:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 284
    check-cast p1, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/CameraPreview$2;->compare(Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;Lcom/amazon/mShop/search/viewit/CameraPreview$SizeAndRatio;)I

    move-result v0

    return v0
.end method
