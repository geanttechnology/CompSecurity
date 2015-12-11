.class public Lcom/xfinity/playerlib/view/DimmingPageTransformer;
.super Ljava/lang/Object;
.source "DimmingPageTransformer.java"

# interfaces
.implements Landroid/support/v4/view/ViewPager$PageTransformer;


# static fields
.field public static MAX_ALPHA:F

.field public static MIN_ALPHA:F


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 7
    const v0, 0x3e99999a    # 0.3f

    sput v0, Lcom/xfinity/playerlib/view/DimmingPageTransformer;->MIN_ALPHA:F

    .line 8
    const/high16 v0, 0x3f800000    # 1.0f

    sput v0, Lcom/xfinity/playerlib/view/DimmingPageTransformer;->MAX_ALPHA:F

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public transformPage(Landroid/view/View;F)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;
    .param p2, "position"    # F

    .prologue
    .line 11
    invoke-static {p2}, Ljava/lang/Math;->abs(F)F

    move-result v0

    .line 12
    .local v0, "absolutePosition":F
    sget v2, Lcom/xfinity/playerlib/view/DimmingPageTransformer;->MAX_ALPHA:F

    sget v3, Lcom/xfinity/playerlib/view/DimmingPageTransformer;->MAX_ALPHA:F

    sget v4, Lcom/xfinity/playerlib/view/DimmingPageTransformer;->MIN_ALPHA:F

    sub-float/2addr v3, v4

    mul-float/2addr v3, v0

    sub-float v1, v2, v3

    .line 13
    .local v1, "alpha":F
    invoke-virtual {p1, v1}, Landroid/view/View;->setAlpha(F)V

    .line 14
    return-void
.end method
