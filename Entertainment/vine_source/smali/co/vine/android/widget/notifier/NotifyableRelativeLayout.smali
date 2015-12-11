.class public Lco/vine/android/widget/notifier/NotifyableRelativeLayout;
.super Landroid/widget/RelativeLayout;
.source "NotifyableRelativeLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;
    }
.end annotation


# instance fields
.field private mCount:I

.field private mListener:Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;

.field private mNotificationMargin:I

.field private mVineGreen:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 35
    invoke-virtual {p0, p1}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->init(Landroid/content/Context;)V

    .line 36
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 41
    invoke-virtual {p0, p1}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->init(Landroid/content/Context;)V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 46
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 47
    invoke-virtual {p0, p1}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->init(Landroid/content/Context;)V

    .line 48
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/widget/notifier/NotifyableRelativeLayout;)Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/notifier/NotifyableRelativeLayout;

    .prologue
    .line 21
    iget-object v0, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mListener:Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;

    return-object v0
.end method

.method static synthetic access$100(Lco/vine/android/widget/notifier/NotifyableRelativeLayout;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/widget/notifier/NotifyableRelativeLayout;

    .prologue
    .line 21
    invoke-direct {p0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->hideNotification()V

    return-void
.end method

.method private hideNotification()V
    .locals 4

    .prologue
    .line 116
    const v1, 0x7f0a00f9

    invoke-virtual {p0, v1}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 117
    .local v0, "v":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    const-wide/16 v2, 0x3e8

    invoke-virtual {v1, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v1

    new-instance v2, Lco/vine/android/recorder/ViewGoneAnimationListener;

    invoke-direct {v2, v0}, Lco/vine/android/recorder/ViewGoneAnimationListener;-><init>(Landroid/view/View;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    .line 118
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 119
    return-void
.end method

.method private showNotification()V
    .locals 2

    .prologue
    .line 111
    const v1, 0x7f0a00f9

    invoke-virtual {p0, v1}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 112
    .local v0, "v":Landroid/view/View;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 113
    return-void
.end method


# virtual methods
.method public indicate(I)V
    .locals 6
    .param p1, "count"    # I

    .prologue
    .line 100
    if-gtz p1, :cond_0

    .line 101
    invoke-direct {p0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->hideNotification()V

    .line 107
    :goto_0
    iput p1, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mCount:I

    .line 108
    return-void

    .line 103
    :cond_0
    const v1, 0x7f0a00f9

    invoke-virtual {p0, v1}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 104
    .local v0, "t":Landroid/widget/TextView;
    invoke-virtual {p0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x7f0d0000

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v1, v2, p1, v3}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    invoke-direct {p0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->showNotification()V

    goto :goto_0
.end method

.method public init(Landroid/content/Context;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 51
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 52
    .local v2, "res":Landroid/content/res/Resources;
    const-string v5, "layout_inflater"

    invoke-virtual {p1, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/LayoutInflater;

    .line 54
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v5, 0x7f030042

    const/4 v6, 0x0

    invoke-virtual {v1, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    .line 55
    .local v4, "v":Landroid/view/View;
    const v5, 0x7f0a00f9

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 57
    .local v3, "t":Landroid/widget/TextView;
    const v5, 0x7f020289

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 58
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    const v5, 0x7f090096

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    iput v5, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mVineGreen:I

    .line 59
    iget v5, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mVineGreen:I

    sget-object v6, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v5, v6}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 61
    invoke-static {v3, v0}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 63
    invoke-virtual {p0, v4}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->addView(Landroid/view/View;)V

    .line 65
    const v5, 0x7f0b0084

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v5

    const v6, 0x7f0b005f

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v6

    add-int/2addr v5, v6

    iput v5, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mNotificationMargin:I

    .line 68
    new-instance v5, Lco/vine/android/widget/notifier/NotifyableRelativeLayout$1;

    invoke-direct {v5, p0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout$1;-><init>(Lco/vine/android/widget/notifier/NotifyableRelativeLayout;)V

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 77
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 5
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 82
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->getChildCount()I

    move-result v3

    if-ge v1, v3, :cond_1

    .line 83
    invoke-virtual {p0, v1}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 84
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getId()I

    move-result v3

    const v4, 0x7f0a00f8

    if-ne v3, v4, :cond_0

    .line 85
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout$LayoutParams;

    .line 87
    .local v2, "params":Landroid/widget/RelativeLayout$LayoutParams;
    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 88
    iget v3, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mNotificationMargin:I

    iput v3, v2, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 89
    invoke-virtual {p0, v0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->bringChildToFront(Landroid/view/View;)V

    .line 82
    .end local v2    # "params":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 92
    .end local v0    # "child":Landroid/view/View;
    :cond_1
    invoke-super/range {p0 .. p5}, Landroid/widget/RelativeLayout;->onLayout(ZIIII)V

    .line 93
    return-void
.end method

.method public personalizeColor(I)V
    .locals 4
    .param p1, "color"    # I

    .prologue
    .line 122
    const v2, 0x7f0a00f9

    invoke-virtual {p0, v2}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 123
    .local v1, "t":Landroid/widget/TextView;
    invoke-virtual {p0}, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f020289

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 124
    .local v0, "d":Landroid/graphics/drawable/Drawable;
    iget v2, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mVineGreen:I

    if-eq p1, v2, :cond_0

    .line 125
    const v2, 0x3e75c28f    # 0.24f

    invoke-static {p1, v2}, Lco/vine/android/util/Util;->getColorWithBlackPercentage(IF)I

    move-result p1

    .line 127
    :cond_0
    sget-object v2, Landroid/graphics/PorterDuff$Mode;->SRC_ATOP:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, p1, v2}, Landroid/graphics/drawable/Drawable;->setColorFilter(ILandroid/graphics/PorterDuff$Mode;)V

    .line 128
    invoke-static {v1, v0}, Lco/vine/android/util/ViewUtil;->setBackground(Landroid/view/View;Landroid/graphics/drawable/Drawable;)V

    .line 129
    return-void
.end method

.method public setNotifierListener(Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;

    .prologue
    .line 96
    iput-object p1, p0, Lco/vine/android/widget/notifier/NotifyableRelativeLayout;->mListener:Lco/vine/android/widget/notifier/NotifyableRelativeLayout$NotifierClickListener;

    .line 97
    return-void
.end method
