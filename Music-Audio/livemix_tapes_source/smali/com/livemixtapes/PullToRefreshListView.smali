.class public Lcom/livemixtapes/PullToRefreshListView;
.super Landroid/widget/ListView;
.source "PullToRefreshListView.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;,
        Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;,
        Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;,
        Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;,
        Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;,
        Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;,
        Lcom/livemixtapes/PullToRefreshListView$State;
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State:[I = null

.field private static final BOUNCE_ANIMATION_DELAY:I = 0x64

.field private static final BOUNCE_ANIMATION_DURATION:I = 0x2bc

.field private static final BOUNCE_OVERSHOOT_TENSION:F = 1.4f

.field private static final PULL_RESISTANCE:F = 1.7f

.field private static final ROTATE_ARROW_ANIMATION_DURATION:I = 0xfa

.field private static measuredHeaderHeight:I


# instance fields
.field private final IDLE_DISTANCE:I

.field private bounceBackHeader:Z

.field private flipAnimation:Landroid/view/animation/RotateAnimation;

.field private hasResetHeader:Z

.field private header:Landroid/widget/RelativeLayout;

.field private headerContainer:Landroid/widget/LinearLayout;

.field private headerPadding:I

.field private image:Landroid/widget/ImageView;

.field private lastUpdated:J

.field private lastUpdatedDateFormat:Ljava/text/SimpleDateFormat;

.field private lastUpdatedText:Ljava/lang/String;

.field private lastUpdatedTextView:Landroid/widget/TextView;

.field private lockScrollWhileRefreshing:Z

.field private mScrollStartY:F

.field onBottomReachedListener:Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;

.field private onItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

.field private onItemLongClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

.field private onRefreshListener:Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;

.field private previousY:F

.field private pullToRefreshText:Ljava/lang/String;

.field private refreshingText:Ljava/lang/String;

.field private releaseToRefreshText:Ljava/lang/String;

.field private reverseFlipAnimation:Landroid/view/animation/RotateAnimation;

.field private scrollbarEnabled:Z

.field private showLastUpdatedText:Z

.field private spinner:Landroid/widget/ProgressBar;

.field private state:Lcom/livemixtapes/PullToRefreshListView$State;

.field private text:Landroid/widget/TextView;


# direct methods
.method static synthetic $SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State()[I
    .locals 3

    .prologue
    .line 38
    sget-object v0, Lcom/livemixtapes/PullToRefreshListView;->$SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/livemixtapes/PullToRefreshListView$State;->values()[Lcom/livemixtapes/PullToRefreshListView$State;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView$State;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_2

    :goto_1
    :try_start_1
    sget-object v1, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView$State;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_1

    :goto_2
    :try_start_2
    sget-object v1, Lcom/livemixtapes/PullToRefreshListView$State;->RELEASE_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-virtual {v1}, Lcom/livemixtapes/PullToRefreshListView$State;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_0

    :goto_3
    sput-object v0, Lcom/livemixtapes/PullToRefreshListView;->$SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_3

    :catch_1
    move-exception v1

    goto :goto_2

    :catch_2
    move-exception v1

    goto :goto_1
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 109
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 80
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "dd/MM HH:mm"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedDateFormat:Ljava/text/SimpleDateFormat;

    .line 85
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdated:J

    .line 100
    const/4 v0, 0x5

    iput v0, p0, Lcom/livemixtapes/PullToRefreshListView;->IDLE_DISTANCE:I

    .line 110
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->init()V

    .line 111
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 114
    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 80
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "dd/MM HH:mm"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedDateFormat:Ljava/text/SimpleDateFormat;

    .line 85
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdated:J

    .line 100
    const/4 v0, 0x5

    iput v0, p0, Lcom/livemixtapes/PullToRefreshListView;->IDLE_DISTANCE:I

    .line 115
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->init()V

    .line 116
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 119
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 80
    new-instance v0, Ljava/text/SimpleDateFormat;

    const-string v1, "dd/MM HH:mm"

    invoke-direct {v0, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedDateFormat:Ljava/text/SimpleDateFormat;

    .line 85
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdated:J

    .line 100
    const/4 v0, 0x5

    iput v0, p0, Lcom/livemixtapes/PullToRefreshListView;->IDLE_DISTANCE:I

    .line 120
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->init()V

    .line 121
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/PullToRefreshListView;)Lcom/livemixtapes/PullToRefreshListView$State;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    return-object v0
.end method

.method static synthetic access$1(Lcom/livemixtapes/PullToRefreshListView;)Z
    .locals 1

    .prologue
    .line 72
    iget-boolean v0, p0, Lcom/livemixtapes/PullToRefreshListView;->scrollbarEnabled:Z

    return v0
.end method

.method static synthetic access$10(I)V
    .locals 0

    .prologue
    .line 70
    sput p0, Lcom/livemixtapes/PullToRefreshListView;->measuredHeaderHeight:I

    return-void
.end method

.method static synthetic access$11(Lcom/livemixtapes/PullToRefreshListView;Z)V
    .locals 0

    .prologue
    .line 84
    iput-boolean p1, p0, Lcom/livemixtapes/PullToRefreshListView;->hasResetHeader:Z

    return-void
.end method

.method static synthetic access$12(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/AdapterView$OnItemClickListener;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->onItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    return-object v0
.end method

.method static synthetic access$13(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/AdapterView$OnItemLongClickListener;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->onItemLongClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

    return-object v0
.end method

.method static synthetic access$2()I
    .locals 1

    .prologue
    .line 70
    sget v0, Lcom/livemixtapes/PullToRefreshListView;->measuredHeaderHeight:I

    return v0
.end method

.method static synthetic access$3(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->headerContainer:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$4(Lcom/livemixtapes/PullToRefreshListView;I)V
    .locals 0

    .prologue
    .line 295
    invoke-direct {p0, p1}, Lcom/livemixtapes/PullToRefreshListView;->setHeaderPadding(I)V

    return-void
.end method

.method static synthetic access$5(Lcom/livemixtapes/PullToRefreshListView;)Z
    .locals 1

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/livemixtapes/PullToRefreshListView;->bounceBackHeader:Z

    return v0
.end method

.method static synthetic access$6(Lcom/livemixtapes/PullToRefreshListView;Z)V
    .locals 0

    .prologue
    .line 73
    iput-boolean p1, p0, Lcom/livemixtapes/PullToRefreshListView;->bounceBackHeader:Z

    return-void
.end method

.method static synthetic access$7(Lcom/livemixtapes/PullToRefreshListView;)V
    .locals 0

    .prologue
    .line 414
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->resetHeader()V

    return-void
.end method

.method static synthetic access$8(Lcom/livemixtapes/PullToRefreshListView;Lcom/livemixtapes/PullToRefreshListView$State;)V
    .locals 0

    .prologue
    .line 436
    invoke-direct {p0, p1}, Lcom/livemixtapes/PullToRefreshListView;->setState(Lcom/livemixtapes/PullToRefreshListView$State;)V

    return-void
.end method

.method static synthetic access$9(Lcom/livemixtapes/PullToRefreshListView;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method private bounceBackHeader()V
    .locals 11

    .prologue
    const/4 v10, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 398
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v4, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v3, v4, :cond_0

    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    invoke-virtual {v3}, Landroid/widget/RelativeLayout;->getHeight()I

    move-result v3

    iget-object v4, p0, Lcom/livemixtapes/PullToRefreshListView;->headerContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getHeight()I

    move-result v4

    sub-int v9, v3, v4

    .line 402
    .local v9, "yTranslate":I
    :goto_0
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    int-to-float v8, v9

    move v3, v1

    move v4, v2

    move v5, v1

    move v6, v2

    move v7, v1

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 404
    .local v0, "bounceAnimation":Landroid/view/animation/TranslateAnimation;
    const-wide/16 v2, 0x2bc

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 405
    invoke-virtual {v0, v10}, Landroid/view/animation/TranslateAnimation;->setFillEnabled(Z)V

    .line 406
    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setFillAfter(Z)V

    .line 407
    invoke-virtual {v0, v10}, Landroid/view/animation/TranslateAnimation;->setFillBefore(Z)V

    .line 408
    new-instance v1, Landroid/view/animation/OvershootInterpolator;

    const v2, 0x3fb33333    # 1.4f

    invoke-direct {v1, v2}, Landroid/view/animation/OvershootInterpolator;-><init>(F)V

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 409
    new-instance v1, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;

    invoke-direct {v1, p0, v9}, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;-><init>(Lcom/livemixtapes/PullToRefreshListView;I)V

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 411
    invoke-virtual {p0, v0}, Lcom/livemixtapes/PullToRefreshListView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 412
    return-void

    .line 399
    .end local v0    # "bounceAnimation":Landroid/view/animation/TranslateAnimation;
    .end local v9    # "yTranslate":I
    :cond_0
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->headerContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v3}, Landroid/widget/LinearLayout;->getHeight()I

    move-result v3

    neg-int v3, v3

    iget-object v4, p0, Lcom/livemixtapes/PullToRefreshListView;->headerContainer:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getTop()I

    move-result v4

    sub-int/2addr v3, v4

    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getPaddingTop()I

    move-result v4

    add-int v9, v3, v4

    goto :goto_0
.end method

.method private init()V
    .locals 14

    .prologue
    const/4 v1, 0x0

    const/high16 v2, -0x3ccc0000    # -180.0f

    const/4 v13, 0x0

    const/high16 v4, 0x3f000000    # 0.5f

    const/4 v3, 0x1

    .line 259
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/livemixtapes/PullToRefreshListView;->setVerticalFadingEdgeEnabled(Z)V

    .line 261
    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v5, 0x7f030035

    invoke-virtual {v0, v5, v13}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->headerContainer:Landroid/widget/LinearLayout;

    .line 262
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->headerContainer:Landroid/widget/LinearLayout;

    const v5, 0x7f0800f7

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    .line 263
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    const v5, 0x7f0800fb

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->text:Landroid/widget/TextView;

    .line 264
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    const v5, 0x7f0800fc

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedTextView:Landroid/widget/TextView;

    .line 265
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    const v5, 0x7f0800f8

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->image:Landroid/widget/ImageView;

    .line 266
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    const v5, 0x7f0800f9

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->spinner:Landroid/widget/ProgressBar;

    .line 268
    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getContext()Landroid/content/Context;

    move-result-object v0

    const v5, 0x7f0a003d

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->pullToRefreshText:Ljava/lang/String;

    .line 269
    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getContext()Landroid/content/Context;

    move-result-object v0

    const v5, 0x7f0a003e

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->releaseToRefreshText:Ljava/lang/String;

    .line 270
    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getContext()Landroid/content/Context;

    move-result-object v0

    const v5, 0x7f0a003f

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->refreshingText:Ljava/lang/String;

    .line 271
    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getContext()Landroid/content/Context;

    move-result-object v0

    const v5, 0x7f0a0040

    invoke-virtual {v0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedText:Ljava/lang/String;

    .line 273
    new-instance v0, Landroid/view/animation/RotateAnimation;

    move v5, v3

    move v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/view/animation/RotateAnimation;-><init>(FFIFIF)V

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->flipAnimation:Landroid/view/animation/RotateAnimation;

    .line 274
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->flipAnimation:Landroid/view/animation/RotateAnimation;

    new-instance v5, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v5}, Landroid/view/animation/LinearInterpolator;-><init>()V

    invoke-virtual {v0, v5}, Landroid/view/animation/RotateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 275
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->flipAnimation:Landroid/view/animation/RotateAnimation;

    const-wide/16 v5, 0xfa

    invoke-virtual {v0, v5, v6}, Landroid/view/animation/RotateAnimation;->setDuration(J)V

    .line 276
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->flipAnimation:Landroid/view/animation/RotateAnimation;

    invoke-virtual {v0, v3}, Landroid/view/animation/RotateAnimation;->setFillAfter(Z)V

    .line 278
    new-instance v5, Landroid/view/animation/RotateAnimation;

    move v6, v2

    move v7, v1

    move v8, v3

    move v9, v4

    move v10, v3

    move v11, v4

    invoke-direct/range {v5 .. v11}, Landroid/view/animation/RotateAnimation;-><init>(FFIFIF)V

    iput-object v5, p0, Lcom/livemixtapes/PullToRefreshListView;->reverseFlipAnimation:Landroid/view/animation/RotateAnimation;

    .line 279
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->reverseFlipAnimation:Landroid/view/animation/RotateAnimation;

    new-instance v1, Landroid/view/animation/LinearInterpolator;

    invoke-direct {v1}, Landroid/view/animation/LinearInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/RotateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 280
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->reverseFlipAnimation:Landroid/view/animation/RotateAnimation;

    const-wide/16 v1, 0xfa

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/RotateAnimation;->setDuration(J)V

    .line 281
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->reverseFlipAnimation:Landroid/view/animation/RotateAnimation;

    invoke-virtual {v0, v3}, Landroid/view/animation/RotateAnimation;->setFillAfter(Z)V

    .line 283
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->headerContainer:Landroid/widget/LinearLayout;

    invoke-virtual {p0, v0}, Lcom/livemixtapes/PullToRefreshListView;->addHeaderView(Landroid/view/View;)V

    .line 284
    sget-object v0, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-direct {p0, v0}, Lcom/livemixtapes/PullToRefreshListView;->setState(Lcom/livemixtapes/PullToRefreshListView$State;)V

    .line 285
    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->isVerticalScrollBarEnabled()Z

    move-result v0

    iput-boolean v0, p0, Lcom/livemixtapes/PullToRefreshListView;->scrollbarEnabled:Z

    .line 287
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v12

    .line 288
    .local v12, "vto":Landroid/view/ViewTreeObserver;
    new-instance v0, Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;

    invoke-direct {v0, p0, v13}, Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;-><init>(Lcom/livemixtapes/PullToRefreshListView;Lcom/livemixtapes/PullToRefreshListView$PTROnGlobalLayoutListener;)V

    invoke-virtual {v12, v0}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 290
    new-instance v0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;

    invoke-direct {v0, p0, v13}, Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;-><init>(Lcom/livemixtapes/PullToRefreshListView;Lcom/livemixtapes/PullToRefreshListView$PTROnItemClickListener;)V

    invoke-super {p0, v0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 291
    new-instance v0, Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;

    invoke-direct {v0, p0, v13}, Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;-><init>(Lcom/livemixtapes/PullToRefreshListView;Lcom/livemixtapes/PullToRefreshListView$PTROnItemLongClickListener;)V

    invoke-super {p0, v0}, Landroid/widget/ListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 292
    invoke-virtual {p0, p0}, Lcom/livemixtapes/PullToRefreshListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 293
    return-void
.end method

.method private resetHeader()V
    .locals 1

    .prologue
    .line 415
    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getFirstVisiblePosition()I

    move-result v0

    if-lez v0, :cond_0

    .line 416
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getHeight()I

    move-result v0

    neg-int v0, v0

    invoke-direct {p0, v0}, Lcom/livemixtapes/PullToRefreshListView;->setHeaderPadding(I)V

    .line 417
    sget-object v0, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-direct {p0, v0}, Lcom/livemixtapes/PullToRefreshListView;->setState(Lcom/livemixtapes/PullToRefreshListView$State;)V

    .line 427
    :goto_0
    return-void

    .line 421
    :cond_0
    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/animation/Animation;->hasEnded()Z

    move-result v0

    if-nez v0, :cond_1

    .line 422
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/livemixtapes/PullToRefreshListView;->bounceBackHeader:Z

    goto :goto_0

    .line 425
    :cond_1
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->bounceBackHeader()V

    goto :goto_0
.end method

.method private setHeaderPadding(I)V
    .locals 3
    .param p1, "padding"    # I

    .prologue
    const/4 v2, 0x0

    .line 296
    iput p1, p0, Lcom/livemixtapes/PullToRefreshListView;->headerPadding:I

    .line 298
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 299
    .local v0, "mlp":Landroid/view/ViewGroup$MarginLayoutParams;
    int-to-float v1, p1

    invoke-static {v1}, Ljava/lang/Math;->round(F)I

    move-result v1

    invoke-virtual {v0, v2, v1, v2, v2}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 300
    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 301
    return-void
.end method

.method private setState(Lcom/livemixtapes/PullToRefreshListView$State;)V
    .locals 8
    .param p1, "state"    # Lcom/livemixtapes/PullToRefreshListView$State;

    .prologue
    const/4 v2, 0x4

    const/4 v7, 0x0

    .line 437
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    .line 438
    invoke-static {}, Lcom/livemixtapes/PullToRefreshListView;->$SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State()[I

    move-result-object v0

    invoke-virtual {p1}, Lcom/livemixtapes/PullToRefreshListView$State;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 470
    :cond_0
    :goto_0
    return-void

    .line 440
    :pswitch_0
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->spinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 441
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 442
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->text:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView;->pullToRefreshText:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 444
    iget-boolean v0, p0, Lcom/livemixtapes/PullToRefreshListView;->showLastUpdatedText:Z

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdated:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 445
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedTextView:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 446
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedTextView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedText:Ljava/lang/String;

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedDateFormat:Ljava/text/SimpleDateFormat;

    new-instance v4, Ljava/util/Date;

    iget-wide v5, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdated:J

    invoke-direct {v4, v5, v6}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v3, v4}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v7

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 452
    :pswitch_1
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->spinner:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 453
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->image:Landroid/widget/ImageView;

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 454
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->text:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView;->releaseToRefreshText:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 458
    :pswitch_2
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->setUiRefreshing()V

    .line 460
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdated:J

    .line 461
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->onRefreshListener:Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;

    if-nez v0, :cond_1

    .line 462
    sget-object v0, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-direct {p0, v0}, Lcom/livemixtapes/PullToRefreshListView;->setState(Lcom/livemixtapes/PullToRefreshListView$State;)V

    goto :goto_0

    .line 465
    :cond_1
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->onRefreshListener:Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;

    invoke-interface {v0}, Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;->onRefresh()V

    goto :goto_0

    .line 438
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private setUiRefreshing()V
    .locals 2

    .prologue
    .line 430
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->spinner:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 431
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->image:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->clearAnimation()V

    .line 432
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->image:Landroid/widget/ImageView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 433
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->text:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/livemixtapes/PullToRefreshListView;->refreshingText:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 434
    return-void
.end method


# virtual methods
.method public getOnBottomReachedListener()Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->onBottomReachedListener:Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;

    return-object v0
.end method

.method public isRefreshing()Z
    .locals 2

    .prologue
    .line 160
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v1, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onRefreshComplete()V
    .locals 2

    .prologue
    .line 214
    sget-object v0, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    .line 215
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->resetHeader()V

    .line 216
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdated:J

    .line 217
    return-void
.end method

.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 4
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 309
    move-object v1, p1

    check-cast v1, Lcom/livemixtapes/PullToRefreshListView;

    .line 310
    .local v1, "scrollListView":Lcom/livemixtapes/PullToRefreshListView;
    add-int v0, p2, p3

    .line 313
    .local v0, "position":I
    if-ne v0, p4, :cond_1

    if-lez p4, :cond_1

    .line 315
    iget-object v2, v1, Lcom/livemixtapes/PullToRefreshListView;->onBottomReachedListener:Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;

    if-eqz v2, :cond_1

    .line 316
    iget-object v2, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v3, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v2, v3, :cond_0

    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/animation/Animation;->hasEnded()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 318
    :cond_0
    iget-object v2, v1, Lcom/livemixtapes/PullToRefreshListView;->onBottomReachedListener:Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;

    invoke-interface {v2}, Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;->onBottomReached()V

    .line 321
    :cond_1
    return-void
.end method

.method protected onScrollChanged(IIII)V
    .locals 2
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "oldl"    # I
    .param p4, "oldt"    # I

    .prologue
    .line 474
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ListView;->onScrollChanged(IIII)V

    .line 476
    iget-boolean v0, p0, Lcom/livemixtapes/PullToRefreshListView;->hasResetHeader:Z

    if-nez v0, :cond_1

    .line 477
    sget v0, Lcom/livemixtapes/PullToRefreshListView;->measuredHeaderHeight:I

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v1, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-eq v0, v1, :cond_0

    .line 478
    sget v0, Lcom/livemixtapes/PullToRefreshListView;->measuredHeaderHeight:I

    neg-int v0, v0

    invoke-direct {p0, v0}, Lcom/livemixtapes/PullToRefreshListView;->setHeaderPadding(I)V

    .line 481
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/livemixtapes/PullToRefreshListView;->hasResetHeader:Z

    .line 483
    :cond_1
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 306
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 6
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/high16 v5, -0x40800000    # -1.0f

    .line 327
    iget-boolean v3, p0, Lcom/livemixtapes/PullToRefreshListView;->lockScrollWhileRefreshing:Z

    if-eqz v3, :cond_1

    .line 328
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v4, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-eq v3, v4, :cond_0

    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getAnimation()Landroid/view/animation/Animation;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/animation/Animation;->hasEnded()Z

    move-result v3

    if-nez v3, :cond_1

    .line 329
    :cond_0
    const/4 v3, 0x1

    .line 394
    :goto_0
    return v3

    .line 332
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 394
    :cond_2
    :goto_1
    invoke-super {p0, p1}, Landroid/widget/ListView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v3

    goto :goto_0

    .line 334
    :pswitch_0
    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getFirstVisiblePosition()I

    move-result v3

    if-nez v3, :cond_3

    .line 335
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    iput v3, p0, Lcom/livemixtapes/PullToRefreshListView;->previousY:F

    .line 342
    :goto_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    iput v3, p0, Lcom/livemixtapes/PullToRefreshListView;->mScrollStartY:F

    goto :goto_1

    .line 338
    :cond_3
    iput v5, p0, Lcom/livemixtapes/PullToRefreshListView;->previousY:F

    goto :goto_2

    .line 347
    :pswitch_1
    iget v3, p0, Lcom/livemixtapes/PullToRefreshListView;->previousY:F

    cmpl-float v3, v3, v5

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v4, Lcom/livemixtapes/PullToRefreshListView$State;->RELEASE_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    if-eq v3, v4, :cond_4

    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getFirstVisiblePosition()I

    move-result v3

    if-nez v3, :cond_2

    .line 348
    :cond_4
    invoke-static {}, Lcom/livemixtapes/PullToRefreshListView;->$SWITCH_TABLE$com$livemixtapes$PullToRefreshListView$State()[I

    move-result-object v3

    iget-object v4, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-virtual {v4}, Lcom/livemixtapes/PullToRefreshListView$State;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_1

    goto :goto_1

    .line 356
    :pswitch_2
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->resetHeader()V

    goto :goto_1

    .line 350
    :pswitch_3
    sget-object v3, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-direct {p0, v3}, Lcom/livemixtapes/PullToRefreshListView;->setState(Lcom/livemixtapes/PullToRefreshListView$State;)V

    .line 351
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->bounceBackHeader()V

    goto :goto_1

    .line 363
    :pswitch_4
    iget v3, p0, Lcom/livemixtapes/PullToRefreshListView;->previousY:F

    cmpl-float v3, v3, v5

    if-eqz v3, :cond_2

    invoke-virtual {p0}, Lcom/livemixtapes/PullToRefreshListView;->getFirstVisiblePosition()I

    move-result v3

    if-nez v3, :cond_2

    .line 364
    iget v3, p0, Lcom/livemixtapes/PullToRefreshListView;->mScrollStartY:F

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    sub-float/2addr v3, v4

    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v3

    const/high16 v4, 0x40a00000    # 5.0f

    cmpl-float v3, v3, v4

    if-lez v3, :cond_2

    .line 365
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    .line 366
    .local v2, "y":F
    iget v3, p0, Lcom/livemixtapes/PullToRefreshListView;->previousY:F

    sub-float v0, v2, v3

    .line 367
    .local v0, "diff":F
    const/4 v3, 0x0

    cmpl-float v3, v0, v3

    if-lez v3, :cond_5

    .line 368
    const v3, 0x3fd9999a    # 1.7f

    div-float/2addr v0, v3

    .line 369
    :cond_5
    iput v2, p0, Lcom/livemixtapes/PullToRefreshListView;->previousY:F

    .line 371
    iget v3, p0, Lcom/livemixtapes/PullToRefreshListView;->headerPadding:I

    int-to-float v3, v3

    add-float/2addr v3, v0

    invoke-static {v3}, Ljava/lang/Math;->round(F)I

    move-result v3

    iget-object v4, p0, Lcom/livemixtapes/PullToRefreshListView;->header:Landroid/widget/RelativeLayout;

    invoke-virtual {v4}, Landroid/widget/RelativeLayout;->getHeight()I

    move-result v4

    neg-int v4, v4

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 373
    .local v1, "newHeaderPadding":I
    iget v3, p0, Lcom/livemixtapes/PullToRefreshListView;->headerPadding:I

    if-eq v1, v3, :cond_2

    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v4, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-eq v3, v4, :cond_2

    .line 374
    invoke-direct {p0, v1}, Lcom/livemixtapes/PullToRefreshListView;->setHeaderPadding(I)V

    .line 376
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v4, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v3, v4, :cond_6

    iget v3, p0, Lcom/livemixtapes/PullToRefreshListView;->headerPadding:I

    if-lez v3, :cond_6

    .line 377
    sget-object v3, Lcom/livemixtapes/PullToRefreshListView$State;->RELEASE_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-direct {p0, v3}, Lcom/livemixtapes/PullToRefreshListView;->setState(Lcom/livemixtapes/PullToRefreshListView$State;)V

    .line 379
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->image:Landroid/widget/ImageView;

    invoke-virtual {v3}, Landroid/widget/ImageView;->clearAnimation()V

    .line 380
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->image:Landroid/widget/ImageView;

    iget-object v4, p0, Lcom/livemixtapes/PullToRefreshListView;->flipAnimation:Landroid/view/animation/RotateAnimation;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_1

    .line 382
    :cond_6
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v4, Lcom/livemixtapes/PullToRefreshListView$State;->RELEASE_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v3, v4, :cond_2

    iget v3, p0, Lcom/livemixtapes/PullToRefreshListView;->headerPadding:I

    if-gez v3, :cond_2

    .line 383
    sget-object v3, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    invoke-direct {p0, v3}, Lcom/livemixtapes/PullToRefreshListView;->setState(Lcom/livemixtapes/PullToRefreshListView$State;)V

    .line 385
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->image:Landroid/widget/ImageView;

    invoke-virtual {v3}, Landroid/widget/ImageView;->clearAnimation()V

    .line 386
    iget-object v3, p0, Lcom/livemixtapes/PullToRefreshListView;->image:Landroid/widget/ImageView;

    iget-object v4, p0, Lcom/livemixtapes/PullToRefreshListView;->reverseFlipAnimation:Landroid/view/animation/RotateAnimation;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_1

    .line 332
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_4
    .end packed-switch

    .line 348
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public setLastUpdatedDateFormat(Ljava/text/SimpleDateFormat;)V
    .locals 0
    .param p1, "lastUpdatedDateFormat"    # Ljava/text/SimpleDateFormat;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedDateFormat:Ljava/text/SimpleDateFormat;

    .line 195
    return-void
.end method

.method public setLockScrollWhileRefreshing(Z)V
    .locals 0
    .param p1, "lockScrollWhileRefreshing"    # Z

    .prologue
    .line 170
    iput-boolean p1, p0, Lcom/livemixtapes/PullToRefreshListView;->lockScrollWhileRefreshing:Z

    .line 171
    return-void
.end method

.method public setOnBottomReachedListener(Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;)V
    .locals 0
    .param p1, "onBottomReachedListener"    # Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;

    .prologue
    .line 140
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView;->onBottomReachedListener:Lcom/livemixtapes/PullToRefreshListView$OnBottomReachedListener;

    .line 141
    return-void
.end method

.method public setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V
    .locals 0

    .prologue
    .line 125
    .local p1, "onItemClickListener":Landroid/widget/AdapterView$OnItemClickListener;, "Landroid/widget/AdapterView$OnItemClickListener;"
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView;->onItemClickListener:Landroid/widget/AdapterView$OnItemClickListener;

    .line 126
    return-void
.end method

.method public setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V
    .locals 0

    .prologue
    .line 130
    .local p1, "onItemLongClickListener":Landroid/widget/AdapterView$OnItemLongClickListener;, "Landroid/widget/AdapterView$OnItemLongClickListener;"
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView;->onItemLongClickListener:Landroid/widget/AdapterView$OnItemLongClickListener;

    .line 131
    return-void
.end method

.method public setOnRefreshListener(Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;)V
    .locals 0
    .param p1, "onRefreshListener"    # Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;

    .prologue
    .line 153
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView;->onRefreshListener:Lcom/livemixtapes/PullToRefreshListView$OnRefreshListener;

    .line 154
    return-void
.end method

.method public setRefreshing()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 203
    sget-object v0, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    iput-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    .line 204
    invoke-virtual {p0, v1, v1}, Lcom/livemixtapes/PullToRefreshListView;->scrollTo(II)V

    .line 205
    invoke-direct {p0}, Lcom/livemixtapes/PullToRefreshListView;->setUiRefreshing()V

    .line 206
    invoke-direct {p0, v1}, Lcom/livemixtapes/PullToRefreshListView;->setHeaderPadding(I)V

    .line 207
    return-void
.end method

.method public setShowLastUpdatedText(Z)V
    .locals 2
    .param p1, "showLastUpdatedText"    # Z

    .prologue
    .line 181
    iput-boolean p1, p0, Lcom/livemixtapes/PullToRefreshListView;->showLastUpdatedText:Z

    .line 182
    if-nez p1, :cond_0

    .line 183
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->lastUpdatedTextView:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 184
    :cond_0
    return-void
.end method

.method public setTextPullToRefresh(Ljava/lang/String;)V
    .locals 2
    .param p1, "pullToRefreshText"    # Ljava/lang/String;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView;->pullToRefreshText:Ljava/lang/String;

    .line 227
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v1, Lcom/livemixtapes/PullToRefreshListView$State;->PULL_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v0, v1, :cond_0

    .line 228
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->text:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 230
    :cond_0
    return-void
.end method

.method public setTextRefreshing(Ljava/lang/String;)V
    .locals 2
    .param p1, "refreshingText"    # Ljava/lang/String;

    .prologue
    .line 252
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView;->refreshingText:Ljava/lang/String;

    .line 253
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v1, Lcom/livemixtapes/PullToRefreshListView$State;->REFRESHING:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v0, v1, :cond_0

    .line 254
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->text:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 256
    :cond_0
    return-void
.end method

.method public setTextReleaseToRefresh(Ljava/lang/String;)V
    .locals 2
    .param p1, "releaseToRefreshText"    # Ljava/lang/String;

    .prologue
    .line 239
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView;->releaseToRefreshText:Ljava/lang/String;

    .line 240
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->state:Lcom/livemixtapes/PullToRefreshListView$State;

    sget-object v1, Lcom/livemixtapes/PullToRefreshListView$State;->RELEASE_TO_REFRESH:Lcom/livemixtapes/PullToRefreshListView$State;

    if-ne v0, v1, :cond_0

    .line 241
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView;->text:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 243
    :cond_0
    return-void
.end method
