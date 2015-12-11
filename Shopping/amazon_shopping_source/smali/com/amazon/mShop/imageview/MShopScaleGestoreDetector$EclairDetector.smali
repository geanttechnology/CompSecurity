.class Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$EclairDetector;
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
    name = "EclairDetector"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$1;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$EclairDetector;-><init>()V

    return-void
.end method


# virtual methods
.method public isInProgress()Z
    .locals 1

    .prologue
    .line 39
    const/4 v0, 0x0

    return v0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 44
    const/4 v0, 0x0

    return v0
.end method
