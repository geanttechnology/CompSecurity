.class Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;
.super Ljava/lang/Object;
.source "MShopScaleGestoreDetector.java"

# interfaces
.implements Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "FroyoDetector"
.end annotation


# instance fields
.field private mDetector:Landroid/view/ScaleGestureDetector;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "scaleListener"    # Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 52
    new-instance v0, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector$1;-><init>(Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V

    iput-object v0, p0, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;->mDetector:Landroid/view/ScaleGestureDetector;

    .line 62
    return-void
.end method


# virtual methods
.method public isInProgress()Z
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;->mDetector:Landroid/view/ScaleGestureDetector;

    invoke-virtual {v0}, Landroid/view/ScaleGestureDetector;->isInProgress()Z

    move-result v0

    return v0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;->mDetector:Landroid/view/ScaleGestureDetector;

    invoke-virtual {v0, p1}, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 74
    const/4 v0, 0x0

    return v0
.end method
