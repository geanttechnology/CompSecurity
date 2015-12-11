.class public Lio/branch/referral/AnimatedDialog;
.super Landroid/app/Dialog;
.source "AnimatedDialog.java"


# instance fields
.field private isClosing_:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    invoke-direct {p0, p1}, Landroid/app/Dialog;-><init>(Landroid/content/Context;)V

    .line 22
    const/4 v0, 0x0

    iput-boolean v0, p0, Lio/branch/referral/AnimatedDialog;->isClosing_:Z

    .line 25
    invoke-direct {p0, p1}, Lio/branch/referral/AnimatedDialog;->init(Landroid/content/Context;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "theme"    # I

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 22
    const/4 v0, 0x0

    iput-boolean v0, p0, Lio/branch/referral/AnimatedDialog;->isClosing_:Z

    .line 30
    invoke-direct {p0, p1}, Lio/branch/referral/AnimatedDialog;->init(Landroid/content/Context;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cancelable"    # Z
    .param p3, "cancelListener"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2, p3}, Landroid/app/Dialog;-><init>(Landroid/content/Context;ZLandroid/content/DialogInterface$OnCancelListener;)V

    .line 22
    const/4 v0, 0x0

    iput-boolean v0, p0, Lio/branch/referral/AnimatedDialog;->isClosing_:Z

    .line 35
    invoke-direct {p0, p1}, Lio/branch/referral/AnimatedDialog;->init(Landroid/content/Context;)V

    .line 36
    return-void
.end method

.method static synthetic access$000(Lio/branch/referral/AnimatedDialog;)V
    .locals 0
    .param p0, "x0"    # Lio/branch/referral/AnimatedDialog;

    .prologue
    .line 21
    invoke-direct {p0}, Lio/branch/referral/AnimatedDialog;->slideClose()V

    return-void
.end method

.method private init(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 65
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->setDialogWindowAttributes()V

    .line 67
    new-instance v0, Lio/branch/referral/AnimatedDialog$1;

    invoke-direct {v0, p0}, Lio/branch/referral/AnimatedDialog$1;-><init>(Lio/branch/referral/AnimatedDialog;)V

    invoke-virtual {p0, v0}, Lio/branch/referral/AnimatedDialog;->setOnKeyListener(Landroid/content/DialogInterface$OnKeyListener;)V

    .line 76
    return-void
.end method

.method private slideClose()V
    .locals 9

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 112
    iget-boolean v3, p0, Lio/branch/referral/AnimatedDialog;->isClosing_:Z

    if-nez v3, :cond_0

    .line 113
    iput-boolean v1, p0, Lio/branch/referral/AnimatedDialog;->isClosing_:Z

    .line 114
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/high16 v8, 0x3f800000    # 1.0f

    move v3, v1

    move v4, v2

    move v5, v1

    move v6, v2

    move v7, v1

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 115
    .local v0, "slideDown":Landroid/view/animation/TranslateAnimation;
    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 116
    new-instance v1, Landroid/view/animation/DecelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/DecelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 118
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 119
    new-instance v1, Lio/branch/referral/AnimatedDialog$2;

    invoke-direct {v1, p0}, Lio/branch/referral/AnimatedDialog$2;-><init>(Lio/branch/referral/AnimatedDialog;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 134
    .end local v0    # "slideDown":Landroid/view/animation/TranslateAnimation;
    :cond_0
    return-void
.end method

.method private slideOpen()V
    .locals 9

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 101
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/high16 v6, 0x3f800000    # 1.0f

    move v3, v1

    move v4, v2

    move v5, v1

    move v7, v1

    move v8, v2

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 102
    .local v0, "slideUp":Landroid/view/animation/TranslateAnimation;
    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/TranslateAnimation;->setDuration(J)V

    .line 103
    new-instance v1, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v1}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    invoke-virtual {v0, v1}, Landroid/view/animation/TranslateAnimation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 104
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 105
    invoke-super {p0}, Landroid/app/Dialog;->show()V

    .line 106
    return-void
.end method


# virtual methods
.method public cancel()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Lio/branch/referral/AnimatedDialog;->slideClose()V

    .line 54
    return-void
.end method

.method public setContentView(I)V
    .locals 0
    .param p1, "layoutResID"    # I

    .prologue
    .line 58
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->setDialogWindowAttributes()V

    .line 59
    invoke-super {p0, p1}, Landroid/app/Dialog;->setContentView(I)V

    .line 60
    return-void
.end method

.method public setDialogWindowAttributes()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, -0x1

    .line 82
    invoke-virtual {p0, v5}, Lio/branch/referral/AnimatedDialog;->requestWindowFeature(I)Z

    .line 83
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    const/4 v3, 0x0

    invoke-direct {v2, v3}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v1, v2}, Landroid/view/Window;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 84
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/view/Window;->addFlags(I)V

    .line 85
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/16 v2, 0x400

    invoke-virtual {v1, v2}, Landroid/view/Window;->addFlags(I)V

    .line 86
    new-instance v0, Landroid/view/WindowManager$LayoutParams;

    invoke-direct {v0}, Landroid/view/WindowManager$LayoutParams;-><init>()V

    .line 87
    .local v0, "lp":Landroid/view/WindowManager$LayoutParams;
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/WindowManager$LayoutParams;->copyFrom(Landroid/view/WindowManager$LayoutParams;)I

    .line 88
    iput v4, v0, Landroid/view/WindowManager$LayoutParams;->width:I

    .line 89
    iput v4, v0, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 90
    const/16 v1, 0x50

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->gravity:I

    .line 91
    const v1, 0x3f4ccccd    # 0.8f

    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->dimAmount:F

    .line 92
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 93
    invoke-virtual {p0}, Lio/branch/referral/AnimatedDialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    const v2, 0x10a0002

    invoke-virtual {v1, v2}, Landroid/view/Window;->setWindowAnimations(I)V

    .line 94
    invoke-virtual {p0, v5}, Lio/branch/referral/AnimatedDialog;->setCanceledOnTouchOutside(Z)V

    .line 95
    return-void
.end method

.method public show()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lio/branch/referral/AnimatedDialog;->slideOpen()V

    .line 46
    return-void
.end method
