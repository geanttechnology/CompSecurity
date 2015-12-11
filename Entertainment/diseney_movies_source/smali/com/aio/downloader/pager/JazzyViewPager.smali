.class public Lcom/aio/downloader/pager/JazzyViewPager;
.super Landroid/support/v4/view/ViewPager;
.source "JazzyViewPager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/pager/JazzyViewPager$State;,
        Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect:[I = null

.field private static final API_11:Z

.field private static final ROT_MAX:F = 15.0f

.field private static final SCALE_MAX:F = 0.5f

.field public static final TAG:Ljava/lang/String; = "JazzyViewPager"

.field private static final ZOOM_MAX:F = 0.5f

.field public static sOutlineColor:I


# instance fields
.field private mCamera:Landroid/graphics/Camera;

.field private mEffect:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

.field private mEnabled:Z

.field private mFadeEnabled:Z

.field private mLeft:Landroid/view/View;

.field private mMatrix:Landroid/graphics/Matrix;

.field private mObjs:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Integer;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private mOutlineEnabled:Z

.field private mRight:Landroid/view/View;

.field private mRot:F

.field private mScale:F

.field private mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

.field private mTempFloat2:[F

.field private mTrans:F

.field private oldPage:I


# direct methods
.method static synthetic $SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect()[I
    .locals 3

    .prologue
    .line 23
    sget-object v0, Lcom/aio/downloader/pager/JazzyViewPager;->$SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->values()[Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->Accordion:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/16 v2, 0xc

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_b

    :goto_1
    :try_start_1
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->CubeIn:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_a

    :goto_2
    :try_start_2
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->CubeOut:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_9

    :goto_3
    :try_start_3
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->FlipHorizontal:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_8

    :goto_4
    :try_start_4
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->FlipVertical:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_7

    :goto_5
    :try_start_5
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->RotateDown:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/16 v2, 0xb

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_6

    :goto_6
    :try_start_6
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->RotateUp:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/16 v2, 0xa

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_5

    :goto_7
    :try_start_7
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->Stack:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_4

    :goto_8
    :try_start_8
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->Standard:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_3

    :goto_9
    :try_start_9
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->Tablet:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_2

    :goto_a
    :try_start_a
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ZoomIn:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_1

    :goto_b
    :try_start_b
    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ZoomOut:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v1}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v1

    const/16 v2, 0x9

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_0

    :goto_c
    sput-object v0, Lcom/aio/downloader/pager/JazzyViewPager;->$SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_c

    :catch_1
    move-exception v1

    goto :goto_b

    :catch_2
    move-exception v1

    goto :goto_a

    :catch_3
    move-exception v1

    goto :goto_9

    :catch_4
    move-exception v1

    goto :goto_8

    :catch_5
    move-exception v1

    goto :goto_7

    :catch_6
    move-exception v1

    goto :goto_6

    :catch_7
    move-exception v1

    goto :goto_5

    :catch_8
    move-exception v1

    goto :goto_4

    :catch_9
    move-exception v1

    goto :goto_3

    :catch_a
    move-exception v1

    goto :goto_2

    :catch_b
    move-exception v1

    goto/16 :goto_1
.end method

.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 29
    const/4 v0, -0x1

    sput v0, Lcom/aio/downloader/pager/JazzyViewPager;->sOutlineColor:I

    .line 56
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/aio/downloader/pager/JazzyViewPager;->API_11:Z

    .line 57
    return-void

    .line 56
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 60
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/pager/JazzyViewPager;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 61
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 65
    invoke-direct {p0, p1, p2}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    iput-boolean v6, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mEnabled:Z

    .line 27
    iput-boolean v5, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mFadeEnabled:Z

    .line 28
    iput-boolean v5, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mOutlineEnabled:Z

    .line 30
    sget-object v3, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->RotateUp:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    iput-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mEffect:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    .line 32
    new-instance v3, Ljava/util/LinkedHashMap;

    invoke-direct {v3}, Ljava/util/LinkedHashMap;-><init>()V

    iput-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mObjs:Ljava/util/HashMap;

    .line 438
    new-instance v3, Landroid/graphics/Matrix;

    invoke-direct {v3}, Landroid/graphics/Matrix;-><init>()V

    iput-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mMatrix:Landroid/graphics/Matrix;

    .line 439
    new-instance v3, Landroid/graphics/Camera;

    invoke-direct {v3}, Landroid/graphics/Camera;-><init>()V

    iput-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mCamera:Landroid/graphics/Camera;

    .line 440
    new-array v3, v7, [F

    iput-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTempFloat2:[F

    .line 66
    invoke-virtual {p0, v5}, Lcom/aio/downloader/pager/JazzyViewPager;->setClipChildren(Z)V

    .line 68
    sget-object v3, Lcom/aio/downloader/R$styleable;->JazzyViewPager:[I

    invoke-virtual {p1, p2, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v1

    .line 69
    .local v1, "ta":Landroid/content/res/TypedArray;
    invoke-virtual {v1, v5, v5}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v0

    .line 70
    .local v0, "effect":I
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f060001

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v2

    .line 71
    .local v2, "transitions":[Ljava/lang/String;
    aget-object v3, v2, v0

    invoke-static {v3}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->valueOf(Ljava/lang/String;)Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->setTransitionEffect(Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;)V

    .line 72
    invoke-virtual {v1, v6, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    invoke-virtual {p0, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->setFadeEnabled(Z)V

    .line 73
    invoke-virtual {v1, v7, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v3

    invoke-virtual {p0, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->setOutlineEnabled(Z)V

    .line 74
    const/4 v3, 0x3

    const/4 v4, -0x1

    invoke-virtual {v1, v3, v4}, Landroid/content/res/TypedArray;->getColor(II)I

    move-result v3

    invoke-virtual {p0, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->setOutlineColor(I)V

    .line 75
    invoke-static {}, Lcom/aio/downloader/pager/JazzyViewPager;->$SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect()[I

    move-result-object v3

    iget-object v4, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mEffect:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v4}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 80
    :goto_0
    :pswitch_0
    invoke-virtual {v1}, Landroid/content/res/TypedArray;->recycle()V

    .line 81
    return-void

    .line 78
    :pswitch_1
    invoke-virtual {p0, v6}, Lcom/aio/downloader/pager/JazzyViewPager;->setFadeEnabled(Z)V

    goto :goto_0

    .line 75
    :pswitch_data_0
    .packed-switch 0xa
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private animateAccordion(Landroid/view/View;Landroid/view/View;F)V
    .locals 4
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;
    .param p3, "positionOffset"    # F

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 271
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v1, :cond_1

    .line 272
    if-eqz p1, :cond_0

    .line 273
    invoke-direct {p0, p1, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 274
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 275
    invoke-static {p1, v2}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 276
    const/high16 v0, 0x3f800000    # 1.0f

    sub-float/2addr v0, p3

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setScaleX(Landroid/view/View;F)V

    .line 278
    :cond_0
    if-eqz p2, :cond_1

    .line 279
    invoke-direct {p0, p2, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 280
    invoke-static {p2, v2}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 281
    invoke-static {p2, v2}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 282
    invoke-static {p2, p3}, Lcom/nineoldandroids/view/ViewHelper;->setScaleX(Landroid/view/View;F)V

    .line 285
    :cond_1
    return-void
.end method

.method private animateCube(Landroid/view/View;Landroid/view/View;FZ)V
    .locals 6
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;
    .param p3, "positionOffset"    # F
    .param p4, "in"    # Z

    .prologue
    const/4 v5, 0x1

    const/high16 v1, 0x42b40000    # 90.0f

    const/high16 v4, 0x3f000000    # 0.5f

    const/high16 v2, -0x3d4c0000    # -90.0f

    .line 252
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v3, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v3, :cond_1

    .line 253
    if-eqz p1, :cond_0

    .line 254
    invoke-direct {p0, p1, v5}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 255
    if-eqz p4, :cond_2

    move v0, v1

    :goto_0
    mul-float/2addr v0, p3

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 256
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 257
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v4

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 258
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationY(Landroid/view/View;F)V

    .line 260
    :cond_0
    if-eqz p2, :cond_1

    .line 261
    invoke-direct {p0, p2, v5}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 262
    if-eqz p4, :cond_3

    :goto_1
    neg-float v0, v1

    const/high16 v1, 0x3f800000    # 1.0f

    sub-float/2addr v1, p3

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 263
    const/4 v0, 0x0

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 264
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v4

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 265
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationY(Landroid/view/View;F)V

    .line 268
    :cond_1
    return-void

    :cond_2
    move v0, v2

    .line 255
    goto :goto_0

    :cond_3
    move v1, v2

    .line 262
    goto :goto_1
.end method

.method private animateFlipHorizontal(Landroid/view/View;Landroid/view/View;FI)V
    .locals 6
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;
    .param p3, "positionOffset"    # F
    .param p4, "positionOffsetPixels"    # I

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v3, 0x4

    const/high16 v2, 0x3f000000    # 0.5f

    .line 334
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v1, :cond_1

    .line 335
    if-eqz p1, :cond_0

    .line 336
    invoke-direct {p0, p1, v5}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 337
    const/high16 v0, 0x43340000    # 180.0f

    mul-float/2addr v0, p3

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 338
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    const/high16 v1, 0x42b40000    # 90.0f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_2

    .line 339
    invoke-virtual {p1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 350
    :cond_0
    :goto_0
    if-eqz p2, :cond_1

    .line 351
    invoke-direct {p0, p2, v5}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 352
    const/high16 v0, -0x3ccc0000    # -180.0f

    const/high16 v1, 0x3f800000    # 1.0f

    sub-float/2addr v1, p3

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 353
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    const/high16 v1, -0x3d4c0000    # -90.0f

    cmpg-float v0, v0, v1

    if-gez v0, :cond_4

    .line 354
    invoke-virtual {p2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 366
    :cond_1
    :goto_1
    return-void

    .line 341
    :cond_2
    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-ne v0, v3, :cond_3

    .line 342
    invoke-virtual {p1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 343
    :cond_3
    int-to-float v0, p4

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    .line 344
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 345
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 346
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 347
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationY(Landroid/view/View;F)V

    goto :goto_0

    .line 356
    :cond_4
    invoke-virtual {p2}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-ne v0, v3, :cond_5

    .line 357
    invoke-virtual {p2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 358
    :cond_5
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getWidth()I

    move-result v0

    neg-int v0, v0

    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getPageMargin()I

    move-result v1

    sub-int/2addr v0, v1

    add-int/2addr v0, p4

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    .line 359
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 360
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 361
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 362
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationY(Landroid/view/View;F)V

    goto :goto_1
.end method

.method private animateFlipVertical(Landroid/view/View;Landroid/view/View;FI)V
    .locals 6
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;
    .param p3, "positionOffset"    # F
    .param p4, "positionOffsetPixels"    # I

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    const/4 v3, 0x4

    const/high16 v2, 0x3f000000    # 0.5f

    .line 369
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v1, :cond_1

    .line 370
    if-eqz p1, :cond_0

    .line 371
    invoke-direct {p0, p1, v5}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 372
    const/high16 v0, 0x43340000    # 180.0f

    mul-float/2addr v0, p3

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 373
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    const/high16 v1, 0x42b40000    # 90.0f

    cmpl-float v0, v0, v1

    if-lez v0, :cond_2

    .line 374
    invoke-virtual {p1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 385
    :cond_0
    :goto_0
    if-eqz p2, :cond_1

    .line 386
    invoke-direct {p0, p2, v5}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 387
    const/high16 v0, -0x3ccc0000    # -180.0f

    const/high16 v1, 0x3f800000    # 1.0f

    sub-float/2addr v1, p3

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 388
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    const/high16 v1, -0x3d4c0000    # -90.0f

    cmpg-float v0, v0, v1

    if-gez v0, :cond_4

    .line 389
    invoke-virtual {p2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 401
    :cond_1
    :goto_1
    return-void

    .line 376
    :cond_2
    invoke-virtual {p1}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-ne v0, v3, :cond_3

    .line 377
    invoke-virtual {p1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 378
    :cond_3
    int-to-float v0, p4

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    .line 379
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 380
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 381
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 382
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationX(Landroid/view/View;F)V

    goto :goto_0

    .line 391
    :cond_4
    invoke-virtual {p2}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-ne v0, v3, :cond_5

    .line 392
    invoke-virtual {p2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 393
    :cond_5
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getWidth()I

    move-result v0

    neg-int v0, v0

    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getPageMargin()I

    move-result v1

    sub-int/2addr v0, v1

    add-int/2addr v0, p4

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    .line 394
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 395
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 396
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 397
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationX(Landroid/view/View;F)V

    goto :goto_1
.end method

.method private animateRotate(Landroid/view/View;Landroid/view/View;FZ)V
    .locals 9
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;
    .param p3, "positionOffset"    # F
    .param p4, "up"    # Z

    .prologue
    .line 311
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v1, :cond_1

    .line 312
    if-eqz p1, :cond_0

    .line 313
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 314
    if-eqz p4, :cond_2

    const/4 v0, 0x1

    :goto_0
    int-to-float v0, v0

    const/high16 v1, 0x41700000    # 15.0f

    mul-float/2addr v1, p3

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 315
    if-eqz p4, :cond_3

    const/4 v0, -0x1

    :goto_1
    int-to-float v0, v0

    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getMeasuredHeight()I

    move-result v1

    int-to-double v1, v1

    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getMeasuredHeight()I

    move-result v3

    int-to-double v3, v3

    iget v5, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    float-to-double v5, v5

    const-wide v7, 0x400921fb54442d18L    # Math.PI

    mul-double/2addr v5, v7

    const-wide v7, 0x4066800000000000L    # 180.0

    div-double/2addr v5, v7

    invoke-static {v5, v6}, Ljava/lang/Math;->cos(D)D

    move-result-wide v5

    mul-double/2addr v3, v5

    sub-double/2addr v1, v3

    double-to-float v1, v1

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    .line 316
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x3f000000    # 0.5f

    mul-float/2addr v0, v1

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 317
    if-eqz p4, :cond_4

    const/4 v0, 0x0

    :goto_2
    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 318
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationY(Landroid/view/View;F)V

    .line 319
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotation(Landroid/view/View;F)V

    .line 321
    :cond_0
    if-eqz p2, :cond_1

    .line 322
    const/4 v0, 0x1

    invoke-direct {p0, p2, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 323
    if-eqz p4, :cond_5

    const/4 v0, 0x1

    :goto_3
    int-to-float v0, v0

    const/high16 v1, -0x3e900000    # -15.0f

    const/high16 v2, 0x41700000    # 15.0f

    mul-float/2addr v2, p3

    add-float/2addr v1, v2

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 324
    if-eqz p4, :cond_6

    const/4 v0, -0x1

    :goto_4
    int-to-float v0, v0

    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getMeasuredHeight()I

    move-result v1

    int-to-double v1, v1

    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getMeasuredHeight()I

    move-result v3

    int-to-double v3, v3

    iget v5, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    float-to-double v5, v5

    const-wide v7, 0x400921fb54442d18L    # Math.PI

    mul-double/2addr v5, v7

    const-wide v7, 0x4066800000000000L    # 180.0

    div-double/2addr v5, v7

    invoke-static {v5, v6}, Ljava/lang/Math;->cos(D)D

    move-result-wide v5

    mul-double/2addr v3, v5

    sub-double/2addr v1, v3

    double-to-float v1, v1

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    .line 325
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x3f000000    # 0.5f

    mul-float/2addr v0, v1

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 326
    if-eqz p4, :cond_7

    const/4 v0, 0x0

    :goto_5
    int-to-float v0, v0

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 327
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationY(Landroid/view/View;F)V

    .line 328
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotation(Landroid/view/View;F)V

    .line 331
    :cond_1
    return-void

    .line 314
    :cond_2
    const/4 v0, -0x1

    goto/16 :goto_0

    .line 315
    :cond_3
    const/4 v0, 0x1

    goto/16 :goto_1

    .line 317
    :cond_4
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    goto :goto_2

    .line 323
    :cond_5
    const/4 v0, -0x1

    goto :goto_3

    .line 324
    :cond_6
    const/4 v0, 0x1

    goto :goto_4

    .line 326
    :cond_7
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    goto :goto_5
.end method

.method private animateZoom(Landroid/view/View;Landroid/view/View;FZ)V
    .locals 6
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;
    .param p3, "positionOffset"    # F
    .param p4, "in"    # Z

    .prologue
    const/4 v5, 0x1

    const/high16 v4, 0x3fc00000    # 1.5f

    const/high16 v3, 0x3f800000    # 1.0f

    const/high16 v2, 0x3f000000    # 0.5f

    .line 288
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v1, :cond_1

    .line 289
    if-eqz p1, :cond_0

    .line 290
    invoke-direct {p0, p1, v5}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 291
    if-eqz p4, :cond_2

    sub-float v0, v3, p3

    mul-float/2addr v0, v2

    add-float/2addr v0, v2

    :goto_0
    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mScale:F

    .line 293
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 294
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 295
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mScale:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setScaleX(Landroid/view/View;F)V

    .line 296
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mScale:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setScaleY(Landroid/view/View;F)V

    .line 298
    :cond_0
    if-eqz p2, :cond_1

    .line 299
    invoke-direct {p0, p2, v5}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 300
    if-eqz p4, :cond_3

    mul-float v0, v2, p3

    add-float/2addr v0, v2

    :goto_1
    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mScale:F

    .line 302
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 303
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v2

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 304
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mScale:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setScaleX(Landroid/view/View;F)V

    .line 305
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mScale:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setScaleY(Landroid/view/View;F)V

    .line 308
    :cond_1
    return-void

    .line 292
    :cond_2
    sub-float v0, v3, p3

    mul-float/2addr v0, v2

    sub-float v0, v4, v0

    goto :goto_0

    .line 301
    :cond_3
    mul-float v0, v2, p3

    sub-float v0, v4, v0

    goto :goto_1
.end method

.method private disableHardwareLayer()V
    .locals 4
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 429
    sget-boolean v2, Lcom/aio/downloader/pager/JazzyViewPager;->API_11:Z

    if-nez v2, :cond_1

    .line 436
    :cond_0
    return-void

    .line 431
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getChildCount()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 432
    invoke-virtual {p0, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 433
    .local v1, "v":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getLayerType()I

    move-result v2

    if-eqz v2, :cond_2

    .line 434
    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 431
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method private isSmall(F)Z
    .locals 4
    .param p1, "positionOffset"    # F

    .prologue
    .line 557
    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    move-result v0

    float-to-double v0, v0

    const-wide v2, 0x3f1a36e2eb1c432dL    # 1.0E-4

    cmpg-double v0, v0, v2

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private logState(Landroid/view/View;Ljava/lang/String;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "title"    # Ljava/lang/String;

    .prologue
    .line 205
    const-string v0, "JazzyViewPager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ": ROT ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p1}, Lcom/nineoldandroids/view/ViewHelper;->getRotation(Landroid/view/View;)F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 206
    invoke-static {p1}, Lcom/nineoldandroids/view/ViewHelper;->getRotationX(Landroid/view/View;)F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 207
    invoke-static {p1}, Lcom/nineoldandroids/view/ViewHelper;->getRotationY(Landroid/view/View;)F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "), TRANS ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 208
    invoke-static {p1}, Lcom/nineoldandroids/view/ViewHelper;->getTranslationX(Landroid/view/View;)F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 209
    invoke-static {p1}, Lcom/nineoldandroids/view/ViewHelper;->getTranslationY(Landroid/view/View;)F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "), SCALE ("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 210
    invoke-static {p1}, Lcom/nineoldandroids/view/ViewHelper;->getScaleX(Landroid/view/View;)F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 211
    invoke-static {p1}, Lcom/nineoldandroids/view/ViewHelper;->getScaleY(Landroid/view/View;)F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "), ALPHA "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 212
    invoke-static {p1}, Lcom/nineoldandroids/view/ViewHelper;->getAlpha(Landroid/view/View;)F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 205
    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 213
    return-void
.end method

.method private manageLayer(Landroid/view/View;Z)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "enableHardware"    # Z
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 421
    sget-boolean v1, Lcom/aio/downloader/pager/JazzyViewPager;->API_11:Z

    if-nez v1, :cond_1

    .line 425
    :cond_0
    :goto_0
    return-void

    .line 422
    :cond_1
    if-eqz p2, :cond_2

    const/4 v0, 0x2

    .line 423
    .local v0, "layerType":I
    :goto_1
    invoke-virtual {p1}, Landroid/view/View;->getLayerType()I

    move-result v1

    if-eq v0, v1, :cond_0

    .line 424
    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    goto :goto_0

    .line 422
    .end local v0    # "layerType":I
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private wrapChild(Landroid/view/View;)Landroid/view/View;
    .locals 3
    .param p1, "child"    # Landroid/view/View;

    .prologue
    const/4 v2, -0x1

    .line 120
    iget-boolean v1, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mOutlineEnabled:Z

    if-eqz v1, :cond_0

    instance-of v1, p1, Lcom/aio/downloader/pager/OutlineContainer;

    if-eqz v1, :cond_1

    :cond_0
    move-object v0, p1

    .line 126
    :goto_0
    return-object v0

    .line 121
    :cond_1
    new-instance v0, Lcom/aio/downloader/pager/OutlineContainer;

    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/aio/downloader/pager/OutlineContainer;-><init>(Landroid/content/Context;)V

    .line 122
    .local v0, "out":Lcom/aio/downloader/pager/OutlineContainer;
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/pager/OutlineContainer;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 123
    new-instance v1, Landroid/widget/FrameLayout$LayoutParams;

    .line 124
    invoke-direct {v1, v2, v2}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 123
    invoke-virtual {p1, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 125
    invoke-virtual {v0, p1}, Lcom/aio/downloader/pager/OutlineContainer;->addView(Landroid/view/View;)V

    goto :goto_0
.end method

.method private wrapWithOutlines()V
    .locals 3

    .prologue
    .line 110
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getChildCount()I

    move-result v2

    if-lt v0, v2, :cond_0

    .line 117
    return-void

    .line 111
    :cond_0
    invoke-virtual {p0, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 112
    .local v1, "v":Landroid/view/View;
    instance-of v2, v1, Lcom/aio/downloader/pager/OutlineContainer;

    if-nez v2, :cond_1

    .line 113
    invoke-virtual {p0, v1}, Lcom/aio/downloader/pager/JazzyViewPager;->removeView(Landroid/view/View;)V

    .line 114
    invoke-direct {p0, v1}, Lcom/aio/downloader/pager/JazzyViewPager;->wrapChild(Landroid/view/View;)Landroid/view/View;

    move-result-object v2

    invoke-super {p0, v2, v0}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;I)V

    .line 110
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method


# virtual methods
.method public addView(Landroid/view/View;)V
    .locals 1
    .param p1, "child"    # Landroid/view/View;

    .prologue
    .line 130
    invoke-direct {p0, p1}, Lcom/aio/downloader/pager/JazzyViewPager;->wrapChild(Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;)V

    .line 131
    return-void
.end method

.method public addView(Landroid/view/View;I)V
    .locals 1
    .param p1, "child"    # Landroid/view/View;
    .param p2, "index"    # I

    .prologue
    .line 134
    invoke-direct {p0, p1}, Lcom/aio/downloader/pager/JazzyViewPager;->wrapChild(Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    invoke-super {p0, v0, p2}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;I)V

    .line 135
    return-void
.end method

.method public addView(Landroid/view/View;II)V
    .locals 1
    .param p1, "child"    # Landroid/view/View;
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    .line 142
    invoke-direct {p0, p1}, Lcom/aio/downloader/pager/JazzyViewPager;->wrapChild(Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    invoke-super {p0, v0, p2, p3}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;II)V

    .line 143
    return-void
.end method

.method public addView(Landroid/view/View;ILandroid/support/v4/view/ViewPager$LayoutParams;)V
    .locals 1
    .param p1, "child"    # Landroid/view/View;
    .param p2, "index"    # I
    .param p3, "params"    # Landroid/support/v4/view/ViewPager$LayoutParams;

    .prologue
    .line 146
    invoke-direct {p0, p1}, Lcom/aio/downloader/pager/JazzyViewPager;->wrapChild(Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    invoke-super {p0, v0, p2, p3}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    .line 147
    return-void
.end method

.method public addView(Landroid/view/View;Landroid/support/v4/view/ViewPager$LayoutParams;)V
    .locals 1
    .param p1, "child"    # Landroid/view/View;
    .param p2, "params"    # Landroid/support/v4/view/ViewPager$LayoutParams;

    .prologue
    .line 138
    invoke-direct {p0, p1}, Lcom/aio/downloader/pager/JazzyViewPager;->wrapChild(Landroid/view/View;)Landroid/view/View;

    move-result-object v0

    invoke-super {p0, v0, p2}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 139
    return-void
.end method

.method protected animateFade(Landroid/view/View;Landroid/view/View;F)V
    .locals 1
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;
    .param p3, "positionOffset"    # F

    .prologue
    .line 458
    if-eqz p1, :cond_0

    .line 459
    const/high16 v0, 0x3f800000    # 1.0f

    sub-float/2addr v0, p3

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setAlpha(Landroid/view/View;F)V

    .line 461
    :cond_0
    if-eqz p2, :cond_1

    .line 462
    invoke-static {p2, p3}, Lcom/nineoldandroids/view/ViewHelper;->setAlpha(Landroid/view/View;F)V

    .line 464
    :cond_1
    return-void
.end method

.method protected animateOutline(Landroid/view/View;Landroid/view/View;)V
    .locals 4
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    const/high16 v2, 0x3f800000    # 1.0f

    .line 467
    instance-of v0, p1, Lcom/aio/downloader/pager/OutlineContainer;

    if-nez v0, :cond_1

    .line 484
    .end local p1    # "left":Landroid/view/View;
    .end local p2    # "right":Landroid/view/View;
    :cond_0
    :goto_0
    return-void

    .line 469
    .restart local p1    # "left":Landroid/view/View;
    .restart local p2    # "right":Landroid/view/View;
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v1, :cond_3

    .line 470
    if-eqz p1, :cond_2

    .line 471
    invoke-direct {p0, p1, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 472
    check-cast p1, Lcom/aio/downloader/pager/OutlineContainer;

    .end local p1    # "left":Landroid/view/View;
    invoke-virtual {p1, v2}, Lcom/aio/downloader/pager/OutlineContainer;->setOutlineAlpha(F)V

    .line 474
    :cond_2
    if-eqz p2, :cond_0

    .line 475
    invoke-direct {p0, p2, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 476
    check-cast p2, Lcom/aio/downloader/pager/OutlineContainer;

    .end local p2    # "right":Landroid/view/View;
    invoke-virtual {p2, v2}, Lcom/aio/downloader/pager/OutlineContainer;->setOutlineAlpha(F)V

    goto :goto_0

    .line 479
    .restart local p1    # "left":Landroid/view/View;
    .restart local p2    # "right":Landroid/view/View;
    :cond_3
    if-eqz p1, :cond_4

    .line 480
    check-cast p1, Lcom/aio/downloader/pager/OutlineContainer;

    .end local p1    # "left":Landroid/view/View;
    invoke-virtual {p1}, Lcom/aio/downloader/pager/OutlineContainer;->start()V

    .line 481
    :cond_4
    if-eqz p2, :cond_0

    .line 482
    check-cast p2, Lcom/aio/downloader/pager/OutlineContainer;

    .end local p2    # "right":Landroid/view/View;
    invoke-virtual {p2}, Lcom/aio/downloader/pager/OutlineContainer;->start()V

    goto :goto_0
.end method

.method protected animateScroll(IF)V
    .locals 7
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F

    .prologue
    const/high16 v6, 0x3f000000    # 0.5f

    .line 216
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v1, :cond_0

    .line 217
    const-wide/high16 v0, 0x3ff0000000000000L    # 1.0

    const-wide v2, 0x401921fb54442d18L    # 6.283185307179586

    float-to-double v4, p2

    mul-double/2addr v2, v4

    invoke-static {v2, v3}, Ljava/lang/Math;->cos(D)D

    move-result-wide v2

    sub-double/2addr v0, v2

    double-to-float v0, v0

    const/high16 v1, 0x40000000    # 2.0f

    div-float/2addr v0, v1

    const/high16 v1, 0x41f00000    # 30.0f

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 218
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_RIGHT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-ne v0, v1, :cond_1

    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    :goto_0
    invoke-static {p0, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationY(Landroid/view/View;F)V

    .line 219
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v6

    invoke-static {p0, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 220
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v6

    invoke-static {p0, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 222
    :cond_0
    return-void

    .line 218
    :cond_1
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    neg-float v0, v0

    goto :goto_0
.end method

.method protected animateStack(Landroid/view/View;Landroid/view/View;FI)V
    .locals 3
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;
    .param p3, "positionOffset"    # F
    .param p4, "positionOffsetPixels"    # I

    .prologue
    const/high16 v2, 0x3f000000    # 0.5f

    .line 404
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v1, :cond_1

    .line 405
    if-eqz p2, :cond_0

    .line 406
    const/4 v0, 0x1

    invoke-direct {p0, p2, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 407
    mul-float v0, v2, p3

    add-float/2addr v0, v2

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mScale:F

    .line 408
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getWidth()I

    move-result v0

    neg-int v0, v0

    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getPageMargin()I

    move-result v1

    sub-int/2addr v0, v1

    add-int/2addr v0, p4

    int-to-float v0, v0

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    .line 409
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mScale:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setScaleX(Landroid/view/View;F)V

    .line 410
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mScale:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setScaleY(Landroid/view/View;F)V

    .line 411
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 413
    :cond_0
    if-eqz p1, :cond_1

    .line 414
    invoke-virtual {p1}, Landroid/view/View;->bringToFront()V

    .line 417
    :cond_1
    return-void
.end method

.method protected animateTablet(Landroid/view/View;Landroid/view/View;F)V
    .locals 5
    .param p1, "left"    # Landroid/view/View;
    .param p2, "right"    # Landroid/view/View;
    .param p3, "positionOffset"    # F

    .prologue
    const/4 v4, 0x1

    const/high16 v3, 0x3f000000    # 0.5f

    .line 225
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v1, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-eq v0, v1, :cond_1

    .line 226
    if-eqz p1, :cond_0

    .line 227
    invoke-direct {p0, p1, v4}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 228
    const/high16 v0, 0x41f00000    # 30.0f

    mul-float/2addr v0, p3

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 229
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 230
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    .line 229
    invoke-virtual {p0, v0, v1, v2}, Lcom/aio/downloader/pager/JazzyViewPager;->getOffsetXForRotation(FII)F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    .line 231
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 232
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    div-int/lit8 v0, v0, 0x2

    int-to-float v0, v0

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 233
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 234
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p1, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationY(Landroid/view/View;F)V

    .line 235
    const-string v0, "Left"

    invoke-direct {p0, p1, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->logState(Landroid/view/View;Ljava/lang/String;)V

    .line 237
    :cond_0
    if-eqz p2, :cond_1

    .line 238
    invoke-direct {p0, p2, v4}, Lcom/aio/downloader/pager/JazzyViewPager;->manageLayer(Landroid/view/View;Z)V

    .line 239
    const/high16 v0, -0x3e100000    # -30.0f

    const/high16 v1, 0x3f800000    # 1.0f

    sub-float/2addr v1, p3

    mul-float/2addr v0, v1

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    .line 240
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-virtual {p2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v1

    .line 241
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    .line 240
    invoke-virtual {p0, v0, v1, v2}, Lcom/aio/downloader/pager/JazzyViewPager;->getOffsetXForRotation(FII)F

    move-result v0

    iput v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    .line 242
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredWidth()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v3

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotX(Landroid/view/View;F)V

    .line 243
    invoke-virtual {p2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    int-to-float v0, v0

    mul-float/2addr v0, v3

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setPivotY(Landroid/view/View;F)V

    .line 244
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTrans:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setTranslationX(Landroid/view/View;F)V

    .line 245
    iget v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRot:F

    invoke-static {p2, v0}, Lcom/nineoldandroids/view/ViewHelper;->setRotationY(Landroid/view/View;F)V

    .line 246
    const-string v0, "Right"

    invoke-direct {p0, p2, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->logState(Landroid/view/View;Ljava/lang/String;)V

    .line 249
    :cond_1
    return-void
.end method

.method public findViewFromObject(I)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I

    .prologue
    const/4 v4, 0x0

    .line 565
    iget-object v5, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mObjs:Ljava/util/HashMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    .line 566
    .local v2, "o":Ljava/lang/Object;
    if-nez v2, :cond_1

    move-object v3, v4

    .line 576
    :cond_0
    :goto_0
    return-object v3

    .line 569
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getAdapter()Landroid/support/v4/view/PagerAdapter;

    move-result-object v0

    .line 571
    .local v0, "a":Landroid/support/v4/view/PagerAdapter;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getChildCount()I

    move-result v5

    if-lt v1, v5, :cond_2

    move-object v3, v4

    .line 576
    goto :goto_0

    .line 572
    :cond_2
    invoke-virtual {p0, v1}, Lcom/aio/downloader/pager/JazzyViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 573
    .local v3, "v":Landroid/view/View;
    invoke-virtual {v0, v3, v2}, Landroid/support/v4/view/PagerAdapter;->isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 571
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method public getFadeEnabled()Z
    .locals 1

    .prologue
    .line 97
    iget-boolean v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mFadeEnabled:Z

    return v0
.end method

.method protected getOffsetXForRotation(FII)F
    .locals 5
    .param p1, "degrees"    # F
    .param p2, "width"    # I
    .param p3, "height"    # I

    .prologue
    const/4 v4, 0x0

    const/high16 v3, 0x3f000000    # 0.5f

    .line 443
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0}, Landroid/graphics/Matrix;->reset()V

    .line 444
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mCamera:Landroid/graphics/Camera;

    invoke-virtual {v0}, Landroid/graphics/Camera;->save()V

    .line 445
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mCamera:Landroid/graphics/Camera;

    invoke-static {p1}, Ljava/lang/Math;->abs(F)F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Camera;->rotateY(F)V

    .line 446
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mCamera:Landroid/graphics/Camera;

    iget-object v1, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/Camera;->getMatrix(Landroid/graphics/Matrix;)V

    .line 447
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mCamera:Landroid/graphics/Camera;

    invoke-virtual {v0}, Landroid/graphics/Camera;->restore()V

    .line 449
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mMatrix:Landroid/graphics/Matrix;

    neg-int v1, p2

    int-to-float v1, v1

    mul-float/2addr v1, v3

    neg-int v2, p3

    int-to-float v2, v2

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Matrix;->preTranslate(FF)Z

    .line 450
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mMatrix:Landroid/graphics/Matrix;

    int-to-float v1, p2

    mul-float/2addr v1, v3

    int-to-float v2, p3

    mul-float/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 451
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTempFloat2:[F

    int-to-float v1, p2

    aput v1, v0, v4

    .line 452
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTempFloat2:[F

    const/4 v1, 0x1

    int-to-float v2, p3

    aput v2, v0, v1

    .line 453
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTempFloat2:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->mapPoints([F)V

    .line 454
    int-to-float v0, p2

    iget-object v1, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mTempFloat2:[F

    aget v1, v1, v4

    sub-float v1, v0, v1

    const/4 v0, 0x0

    cmpl-float v0, p1, v0

    if-lez v0, :cond_0

    const/high16 v0, 0x3f800000    # 1.0f

    :goto_0
    mul-float/2addr v0, v1

    return v0

    :cond_0
    const/high16 v0, -0x40800000    # -1.0f

    goto :goto_0
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "arg0"    # Landroid/view/MotionEvent;

    .prologue
    .line 151
    iget-boolean v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mEnabled:Z

    if-eqz v0, :cond_0

    invoke-super {p0, p1}, Landroid/support/v4/view/ViewPager;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onPageScrolled(IFI)V
    .locals 7
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    const/4 v5, 0x0

    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 488
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v6, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-ne v2, v6, :cond_0

    cmpl-float v2, p2, v5

    if-lez v2, :cond_0

    .line 489
    invoke-virtual {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->getCurrentItem()I

    move-result v2

    iput v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->oldPage:I

    .line 490
    iget v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->oldPage:I

    if-ne p1, v2, :cond_5

    sget-object v2, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_RIGHT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    :goto_0
    iput-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    .line 492
    :cond_0
    iget v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->oldPage:I

    if-ne p1, v2, :cond_6

    move v1, v3

    .line 493
    .local v1, "goingRight":Z
    :goto_1
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v6, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_RIGHT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-ne v2, v6, :cond_7

    if-nez v1, :cond_7

    .line 494
    sget-object v2, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_LEFT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    iput-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    .line 498
    :cond_1
    :goto_2
    invoke-direct {p0, p2}, Lcom/aio/downloader/pager/JazzyViewPager;->isSmall(F)Z

    move-result v2

    if-eqz v2, :cond_8

    move v0, v5

    .line 502
    .local v0, "effectOffset":F
    :goto_3
    invoke-virtual {p0, p1}, Lcom/aio/downloader/pager/JazzyViewPager;->findViewFromObject(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    .line 503
    add-int/lit8 v2, p1, 0x1

    invoke-virtual {p0, v2}, Lcom/aio/downloader/pager/JazzyViewPager;->findViewFromObject(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    .line 505
    iget-boolean v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mFadeEnabled:Z

    if-eqz v2, :cond_2

    .line 506
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v6, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-virtual {p0, v2, v6, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->animateFade(Landroid/view/View;Landroid/view/View;F)V

    .line 507
    :cond_2
    iget-boolean v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mOutlineEnabled:Z

    if-eqz v2, :cond_3

    .line 508
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v6, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-virtual {p0, v2, v6}, Lcom/aio/downloader/pager/JazzyViewPager;->animateOutline(Landroid/view/View;Landroid/view/View;)V

    .line 510
    :cond_3
    invoke-static {}, Lcom/aio/downloader/pager/JazzyViewPager;->$SWITCH_TABLE$com$aio$downloader$pager$JazzyViewPager$TransitionEffect()[I

    move-result-object v2

    iget-object v6, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mEffect:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    invoke-virtual {v6}, Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;->ordinal()I

    move-result v6

    aget v2, v2, v6

    packed-switch v2, :pswitch_data_0

    .line 547
    :goto_4
    :pswitch_0
    invoke-super {p0, p1, p2, p3}, Landroid/support/v4/view/ViewPager;->onPageScrolled(IFI)V

    .line 549
    cmpl-float v2, v0, v5

    if-nez v2, :cond_4

    .line 550
    invoke-direct {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->disableHardwareLayer()V

    .line 551
    sget-object v2, Lcom/aio/downloader/pager/JazzyViewPager$State;->IDLE:Lcom/aio/downloader/pager/JazzyViewPager$State;

    iput-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    .line 554
    :cond_4
    return-void

    .line 490
    .end local v0    # "effectOffset":F
    .end local v1    # "goingRight":Z
    :cond_5
    sget-object v2, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_LEFT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    goto :goto_0

    :cond_6
    move v1, v4

    .line 492
    goto :goto_1

    .line 495
    .restart local v1    # "goingRight":Z
    :cond_7
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    sget-object v6, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_LEFT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    if-ne v2, v6, :cond_1

    if-eqz v1, :cond_1

    .line 496
    sget-object v2, Lcom/aio/downloader/pager/JazzyViewPager$State;->GOING_RIGHT:Lcom/aio/downloader/pager/JazzyViewPager$State;

    iput-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mState:Lcom/aio/downloader/pager/JazzyViewPager$State;

    goto :goto_2

    :cond_8
    move v0, p2

    .line 498
    goto :goto_3

    .line 514
    .restart local v0    # "effectOffset":F
    :pswitch_1
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-virtual {p0, v2, v3, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->animateTablet(Landroid/view/View;Landroid/view/View;F)V

    goto :goto_4

    .line 517
    :pswitch_2
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v4, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-direct {p0, v2, v4, v0, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->animateCube(Landroid/view/View;Landroid/view/View;FZ)V

    goto :goto_4

    .line 520
    :pswitch_3
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-direct {p0, v2, v3, v0, v4}, Lcom/aio/downloader/pager/JazzyViewPager;->animateCube(Landroid/view/View;Landroid/view/View;FZ)V

    goto :goto_4

    .line 523
    :pswitch_4
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-direct {p0, v2, v3, p2, p3}, Lcom/aio/downloader/pager/JazzyViewPager;->animateFlipVertical(Landroid/view/View;Landroid/view/View;FI)V

    goto :goto_4

    .line 526
    :pswitch_5
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-direct {p0, v2, v3, v0, p3}, Lcom/aio/downloader/pager/JazzyViewPager;->animateFlipHorizontal(Landroid/view/View;Landroid/view/View;FI)V

    .line 528
    :pswitch_6
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-virtual {p0, v2, v3, v0, p3}, Lcom/aio/downloader/pager/JazzyViewPager;->animateStack(Landroid/view/View;Landroid/view/View;FI)V

    goto :goto_4

    .line 531
    :pswitch_7
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v4, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-direct {p0, v2, v4, v0, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->animateZoom(Landroid/view/View;Landroid/view/View;FZ)V

    goto :goto_4

    .line 534
    :pswitch_8
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-direct {p0, v2, v3, v0, v4}, Lcom/aio/downloader/pager/JazzyViewPager;->animateZoom(Landroid/view/View;Landroid/view/View;FZ)V

    goto :goto_4

    .line 537
    :pswitch_9
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v4, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-direct {p0, v2, v4, v0, v3}, Lcom/aio/downloader/pager/JazzyViewPager;->animateRotate(Landroid/view/View;Landroid/view/View;FZ)V

    goto :goto_4

    .line 540
    :pswitch_a
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-direct {p0, v2, v3, v0, v4}, Lcom/aio/downloader/pager/JazzyViewPager;->animateRotate(Landroid/view/View;Landroid/view/View;FZ)V

    goto :goto_4

    .line 543
    :pswitch_b
    iget-object v2, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mLeft:Landroid/view/View;

    iget-object v3, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mRight:Landroid/view/View;

    invoke-direct {p0, v2, v3, v0}, Lcom/aio/downloader/pager/JazzyViewPager;->animateAccordion(Landroid/view/View;Landroid/view/View;F)V

    goto :goto_4

    .line 510
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
    .end packed-switch
.end method

.method public setFadeEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 93
    iput-boolean p1, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mFadeEnabled:Z

    .line 94
    return-void
.end method

.method public setObjectForPosition(Ljava/lang/Object;I)V
    .locals 2
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "position"    # I

    .prologue
    .line 561
    iget-object v0, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mObjs:Ljava/util/HashMap;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 562
    return-void
.end method

.method public setOutlineColor(I)V
    .locals 0
    .param p1, "color"    # I

    .prologue
    .line 106
    sput p1, Lcom/aio/downloader/pager/JazzyViewPager;->sOutlineColor:I

    .line 107
    return-void
.end method

.method public setOutlineEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 101
    iput-boolean p1, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mOutlineEnabled:Z

    .line 102
    invoke-direct {p0}, Lcom/aio/downloader/pager/JazzyViewPager;->wrapWithOutlines()V

    .line 103
    return-void
.end method

.method public setPagingEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 89
    iput-boolean p1, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mEnabled:Z

    .line 90
    return-void
.end method

.method public setTransitionEffect(Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;)V
    .locals 0
    .param p1, "effect"    # Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/aio/downloader/pager/JazzyViewPager;->mEffect:Lcom/aio/downloader/pager/JazzyViewPager$TransitionEffect;

    .line 86
    return-void
.end method
