.class Lcom/amazon/mShop/imageview/PinchImageView$ScaleListener;
.super Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;
.source "PinchImageView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/imageview/PinchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ScaleListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/imageview/PinchImageView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/imageview/PinchImageView;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/amazon/mShop/imageview/PinchImageView$ScaleListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    invoke-direct {p0}, Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onScale(Landroid/view/ScaleGestureDetector;)Z
    .locals 1
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 111
    iget-object v0, p0, Lcom/amazon/mShop/imageview/PinchImageView$ScaleListener;->this$0:Lcom/amazon/mShop/imageview/PinchImageView;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/imageview/PinchImageView;->updateScale(Landroid/view/ScaleGestureDetector;)V

    .line 112
    const/4 v0, 0x1

    return v0
.end method
