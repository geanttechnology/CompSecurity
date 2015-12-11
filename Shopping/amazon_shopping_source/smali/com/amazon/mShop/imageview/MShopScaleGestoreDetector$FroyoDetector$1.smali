.class Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector$1;
.super Landroid/view/ScaleGestureDetector;
.source "MShopScaleGestoreDetector.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;-><init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/Context;
    .param p3, "x1"    # Landroid/view/ScaleGestureDetector$OnScaleGestureListener;

    .prologue
    .line 52
    iput-object p1, p0, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector$1;->this$0:Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;

    invoke-direct {p0, p2, p3}, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V

    return-void
.end method


# virtual methods
.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 56
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    const/4 v1, 0x2

    if-lt v0, v1, :cond_0

    .line 57
    invoke-super {p0, p1}, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    .line 59
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
