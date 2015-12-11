.class Lcom/amazon/device/ads/AndroidTargetUtils$JellyBeanTargetUtils;
.super Ljava/lang/Object;
.source "AndroidTargetUtils.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x10
.end annotation

.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AndroidTargetUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "JellyBeanTargetUtils"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 347
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static setBackgroundForLinerLayout(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p0, "view"    # Landroid/view/View;
    .param p1, "background"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 356
    invoke-virtual {p0, p1}, Landroid/view/View;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 357
    return-void
.end method

.method protected static setImageButtonAlpha(Landroid/widget/ImageButton;I)V
    .locals 0
    .param p0, "imageButton"    # Landroid/widget/ImageButton;
    .param p1, "alpha"    # I

    .prologue
    .line 366
    invoke-virtual {p0, p1}, Landroid/widget/ImageButton;->setImageAlpha(I)V

    .line 367
    return-void
.end method
