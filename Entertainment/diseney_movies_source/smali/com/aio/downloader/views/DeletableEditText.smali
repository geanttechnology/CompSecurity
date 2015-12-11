.class public Lcom/aio/downloader/views/DeletableEditText;
.super Landroid/widget/EditText;
.source "DeletableEditText.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;,
        Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;
    }
.end annotation


# instance fields
.field private isHasFocus:Z

.field private mRightDrawable:Landroid/graphics/drawable/Drawable;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 27
    invoke-direct {p0}, Lcom/aio/downloader/views/DeletableEditText;->init()V

    .line 28
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Landroid/widget/EditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    invoke-direct {p0}, Lcom/aio/downloader/views/DeletableEditText;->init()V

    .line 32
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 35
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/EditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 36
    invoke-direct {p0}, Lcom/aio/downloader/views/DeletableEditText;->init()V

    .line 37
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/DeletableEditText;Z)V
    .locals 0

    .prologue
    .line 23
    iput-boolean p1, p0, Lcom/aio/downloader/views/DeletableEditText;->isHasFocus:Z

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/views/DeletableEditText;)Z
    .locals 1

    .prologue
    .line 23
    iget-boolean v0, p0, Lcom/aio/downloader/views/DeletableEditText;->isHasFocus:Z

    return v0
.end method

.method private init()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 42
    invoke-virtual {p0}, Lcom/aio/downloader/views/DeletableEditText;->getCompoundDrawables()[Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 46
    .local v0, "drawables":[Landroid/graphics/drawable/Drawable;
    const/4 v1, 0x2

    aget-object v1, v0, v1

    iput-object v1, p0, Lcom/aio/downloader/views/DeletableEditText;->mRightDrawable:Landroid/graphics/drawable/Drawable;

    .line 49
    new-instance v1, Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;

    invoke-direct {v1, p0, v2}, Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;-><init>(Lcom/aio/downloader/views/DeletableEditText;Lcom/aio/downloader/views/DeletableEditText$FocusChangeListenerImpl;)V

    invoke-virtual {p0, v1}, Lcom/aio/downloader/views/DeletableEditText;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 51
    new-instance v1, Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;

    invoke-direct {v1, p0, v2}, Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;-><init>(Lcom/aio/downloader/views/DeletableEditText;Lcom/aio/downloader/views/DeletableEditText$TextWatcherImpl;)V

    invoke-virtual {p0, v1}, Lcom/aio/downloader/views/DeletableEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 53
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/aio/downloader/views/DeletableEditText;->setClearDrawableVisible(Z)V

    .line 54
    return-void
.end method


# virtual methods
.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 73
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 86
    :cond_0
    :goto_0
    invoke-super {p0, p1}, Landroid/widget/EditText;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    return v1

    .line 76
    :pswitch_0
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p0}, Lcom/aio/downloader/views/DeletableEditText;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/aio/downloader/views/DeletableEditText;->getTotalPaddingRight()I

    move-result v3

    sub-int/2addr v2, v3

    int-to-float v2, v2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_1

    .line 77
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p0}, Lcom/aio/downloader/views/DeletableEditText;->getWidth()I

    move-result v2

    invoke-virtual {p0}, Lcom/aio/downloader/views/DeletableEditText;->getPaddingRight()I

    move-result v3

    sub-int/2addr v2, v3

    int-to-float v2, v2

    .line 76
    cmpg-float v1, v1, v2

    if-gez v1, :cond_1

    const/4 v0, 0x1

    .line 78
    .local v0, "isClean":Z
    :goto_1
    if-eqz v0, :cond_0

    .line 79
    const-string v1, ""

    invoke-virtual {p0, v1}, Lcom/aio/downloader/views/DeletableEditText;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 76
    .end local v0    # "isClean":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    .line 73
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method protected setClearDrawableVisible(Z)V
    .locals 5
    .param p1, "isVisible"    # Z

    .prologue
    .line 126
    if-eqz p1, :cond_0

    .line 127
    iget-object v0, p0, Lcom/aio/downloader/views/DeletableEditText;->mRightDrawable:Landroid/graphics/drawable/Drawable;

    .line 132
    .local v0, "rightDrawable":Landroid/graphics/drawable/Drawable;
    :goto_0
    invoke-virtual {p0}, Lcom/aio/downloader/views/DeletableEditText;->getCompoundDrawables()[Landroid/graphics/drawable/Drawable;

    move-result-object v1

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-virtual {p0}, Lcom/aio/downloader/views/DeletableEditText;->getCompoundDrawables()[Landroid/graphics/drawable/Drawable;

    move-result-object v2

    const/4 v3, 0x1

    aget-object v2, v2, v3

    .line 133
    invoke-virtual {p0}, Lcom/aio/downloader/views/DeletableEditText;->getCompoundDrawables()[Landroid/graphics/drawable/Drawable;

    move-result-object v3

    const/4 v4, 0x3

    aget-object v3, v3, v4

    .line 132
    invoke-virtual {p0, v1, v2, v0, v3}, Lcom/aio/downloader/views/DeletableEditText;->setCompoundDrawables(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 134
    return-void

    .line 129
    .end local v0    # "rightDrawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    const/4 v0, 0x0

    .restart local v0    # "rightDrawable":Landroid/graphics/drawable/Drawable;
    goto :goto_0
.end method

.method public setShakeAnimation()V
    .locals 1

    .prologue
    .line 138
    const/4 v0, 0x5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/DeletableEditText;->shakeAnimation(I)Landroid/view/animation/Animation;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/DeletableEditText;->startAnimation(Landroid/view/animation/Animation;)V

    .line 140
    return-void
.end method

.method public shakeAnimation(I)Landroid/view/animation/Animation;
    .locals 3
    .param p1, "CycleTimes"    # I

    .prologue
    const/high16 v2, 0x41200000    # 10.0f

    const/4 v1, 0x0

    .line 144
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    invoke-direct {v0, v1, v2, v1, v2}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .line 145
    .local v0, "translateAnimation":Landroid/view/animation/Animation;
    new-instance v1, Landroid/view/animation/CycleInterpolator;

    int-to-float v2, p1

    invoke-direct {v1, v2}, Landroid/view/animation/CycleInterpolator;-><init>(F)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 146
    const-wide/16 v1, 0x3e8

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 147
    return-object v0
.end method
