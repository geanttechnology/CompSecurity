.class public Lcom/bestbuy/android/bbyobjects/MyBBYCertView;
.super Landroid/widget/FrameLayout;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/view/View;

.field private c:Landroid/content/Context;

.field private d:Landroid/view/animation/Animation;

.field private e:Landroid/view/animation/Animation;

.field private f:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 19
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->f:Z

    .line 23
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->c:Landroid/content/Context;

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 19
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->f:Z

    .line 28
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 31
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 19
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->f:Z

    .line 32
    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->d:Landroid/view/animation/Animation;

    if-ne p1, v0, :cond_1

    .line 58
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->removeAllViews()V

    .line 59
    iget-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->f:Z

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->b:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->addView(Landroid/view/View;)V

    .line 64
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->clearAnimation()V

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->e:Landroid/view/animation/Animation;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->setAnimation(Landroid/view/animation/Animation;)V

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->e:Landroid/view/animation/Animation;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 70
    :goto_1
    return-void

    .line 62
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->a:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 68
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->f:Z

    if-nez v0, :cond_2

    const/4 v0, 0x1

    :goto_2
    iput-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->f:Z

    goto :goto_1

    :cond_2
    const/4 v0, 0x0

    goto :goto_2
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 75
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 53
    return-void
.end method

.method public setViews(Landroid/view/View;Landroid/view/View;)V
    .locals 2

    .prologue
    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->a:Landroid/view/View;

    .line 36
    iput-object p2, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->b:Landroid/view/View;

    .line 37
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->addView(Landroid/view/View;)V

    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->c:Landroid/content/Context;

    const v1, 0x7f04000f

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->d:Landroid/view/animation/Animation;

    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->d:Landroid/view/animation/Animation;

    invoke-virtual {v0, p0}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->c:Landroid/content/Context;

    const v1, 0x7f040004

    invoke-static {v0, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->e:Landroid/view/animation/Animation;

    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/MyBBYCertView;->e:Landroid/view/animation/Animation;

    invoke-virtual {v0, p0}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 42
    return-void
.end method
