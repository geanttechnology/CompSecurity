.class public Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;
.super Ljava/lang/Object;
.source "SideRibbonDelegateBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Configuration"
.end annotation


# static fields
.field private static final DEFAULT_ANIMATION_INTERPOLATOR:Landroid/view/animation/Interpolator;


# instance fields
.field private animationInterpolator:Landroid/view/animation/Interpolator;

.field private backgroundColor:Ljava/lang/Integer;

.field private backgroundDrawable:Landroid/graphics/drawable/Drawable;

.field private backgroundResource:Ljava/lang/Integer;

.field private ribbonWidth:I

.field private shadowColor:I

.field private shadowDrawable:Landroid/graphics/drawable/Drawable;

.field private shadowResource:Ljava/lang/Integer;

.field private shadowWidth:I

.field private slideDuration:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 83
    new-instance v0, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    sput-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->DEFAULT_ANIMATION_INTERPOLATOR:Landroid/view/animation/Interpolator;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    const/16 v0, 0xc8

    iput v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->ribbonWidth:I

    .line 86
    const-wide/16 v0, 0xc8

    iput-wide v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->slideDuration:J

    .line 87
    sget-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->DEFAULT_ANIMATION_INTERPOLATOR:Landroid/view/animation/Interpolator;

    iput-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->animationInterpolator:Landroid/view/animation/Interpolator;

    .line 88
    iput-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->backgroundResource:Ljava/lang/Integer;

    .line 89
    iput-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->backgroundColor:Ljava/lang/Integer;

    .line 90
    iput-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->backgroundDrawable:Landroid/graphics/drawable/Drawable;

    .line 91
    const/4 v0, 0x2

    iput v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->shadowWidth:I

    .line 92
    const/high16 v0, -0x1000000

    iput v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->shadowColor:I

    .line 93
    iput-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->shadowResource:Ljava/lang/Integer;

    .line 94
    iput-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->shadowDrawable:Landroid/graphics/drawable/Drawable;

    return-void
.end method

.method static synthetic access$002(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;I)I
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;
    .param p1, "x1"    # I

    .prologue
    .line 80
    iput p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->ribbonWidth:I

    return p1
.end method

.method static synthetic access$102(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;J)J
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;
    .param p1, "x1"    # J

    .prologue
    .line 80
    iput-wide p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->slideDuration:J

    return-wide p1
.end method

.method static synthetic access$302(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;Ljava/lang/Integer;)Ljava/lang/Integer;
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;
    .param p1, "x1"    # Ljava/lang/Integer;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->backgroundResource:Ljava/lang/Integer;

    return-object p1
.end method


# virtual methods
.method public getAnimationInterpolator()Landroid/view/animation/Interpolator;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->animationInterpolator:Landroid/view/animation/Interpolator;

    return-object v0
.end method

.method public getBackgroundColor()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->backgroundColor:Ljava/lang/Integer;

    return-object v0
.end method

.method public getBackgroundDrawable()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->backgroundDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getBackgroundResource()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->backgroundResource:Ljava/lang/Integer;

    return-object v0
.end method

.method public getRibbonWidth()I
    .locals 1

    .prologue
    .line 97
    iget v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->ribbonWidth:I

    return v0
.end method

.method public getShadowColor()I
    .locals 1

    .prologue
    .line 121
    iget v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->shadowColor:I

    return v0
.end method

.method public getShadowDrawable()Landroid/graphics/drawable/Drawable;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->shadowDrawable:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method public getShadowResource()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->shadowResource:Ljava/lang/Integer;

    return-object v0
.end method

.method public getShadowWidth()I
    .locals 1

    .prologue
    .line 117
    iget v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->shadowWidth:I

    return v0
.end method

.method public getSlideDuration()J
    .locals 2

    .prologue
    .line 101
    iget-wide v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->slideDuration:J

    return-wide v0
.end method
