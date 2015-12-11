.class public Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector;
.super Ljava/lang/Object;
.source "MShopScaleGestoreDetector.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$1;,
        Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;,
        Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$EclairDetector;,
        Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    return-void
.end method

.method public static newInstance(Landroid/content/Context;Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;)Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "scaleListener"    # Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;

    .prologue
    .line 25
    sget-object v2, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    .line 26
    .local v1, "sdkVersion":I
    const/4 v0, 0x0

    .line 27
    .local v0, "detector":Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    const/16 v2, 0x8

    if-ge v1, v2, :cond_0

    .line 28
    new-instance v0, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$EclairDetector;

    .end local v0    # "detector":Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    const/4 v2, 0x0

    invoke-direct {v0, v2}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$EclairDetector;-><init>(Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$1;)V

    .line 32
    .restart local v0    # "detector":Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    :goto_0
    return-object v0

    .line 30
    :cond_0
    new-instance v0, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;

    .end local v0    # "detector":Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    invoke-direct {v0, p0, p1}, Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$FroyoDetector;-><init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$SimpleOnScaleGestureListener;)V

    .restart local v0    # "detector":Lcom/amazon/mShop/imageview/MShopScaleGestoreDetector$VersionedGestureDetector;
    goto :goto_0
.end method
