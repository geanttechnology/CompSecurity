.class public Lcom/livemixtapes/ui/AnimatedTabHostListener;
.super Ljava/lang/Object;
.source "AnimatedTabHostListener.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;


# static fields
.field private static final ANIMATION_TIME:I = 0xf0


# instance fields
.field private currentTab:I

.field private currentView:Landroid/view/View;

.field private previousView:Landroid/view/View;

.field private tabHost:Landroid/widget/TabHost;


# direct methods
.method public constructor <init>(Landroid/widget/TabHost;)V
    .locals 1
    .param p1, "tabHost"    # Landroid/widget/TabHost;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->tabHost:Landroid/widget/TabHost;

    .line 35
    invoke-virtual {p1}, Landroid/widget/TabHost;->getCurrentView()Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->previousView:Landroid/view/View;

    .line 36
    return-void
.end method

.method private inFromLeftAnimation()Landroid/view/animation/Animation;
    .locals 9

    .prologue
    const/4 v4, 0x0

    const/4 v1, 0x2

    .line 93
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/high16 v2, -0x40800000    # -1.0f

    move v3, v1

    move v5, v1

    move v6, v4

    move v7, v1

    move v8, v4

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 95
    .local v0, "inFromLeft":Landroid/view/animation/Animation;
    invoke-direct {p0, v0}, Lcom/livemixtapes/ui/AnimatedTabHostListener;->setProperties(Landroid/view/animation/Animation;)Landroid/view/animation/Animation;

    move-result-object v1

    return-object v1
.end method

.method private inFromRightAnimation()Landroid/view/animation/Animation;
    .locals 9

    .prologue
    const/4 v4, 0x0

    const/4 v1, 0x2

    .line 69
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/high16 v2, 0x3f800000    # 1.0f

    move v3, v1

    move v5, v1

    move v6, v4

    move v7, v1

    move v8, v4

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 71
    .local v0, "inFromRight":Landroid/view/animation/Animation;
    invoke-direct {p0, v0}, Lcom/livemixtapes/ui/AnimatedTabHostListener;->setProperties(Landroid/view/animation/Animation;)Landroid/view/animation/Animation;

    move-result-object v1

    return-object v1
.end method

.method private outToLeftAnimation()Landroid/view/animation/Animation;
    .locals 9

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x2

    .line 105
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/high16 v4, -0x40800000    # -1.0f

    move v3, v1

    move v5, v1

    move v6, v2

    move v7, v1

    move v8, v2

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 107
    .local v0, "outtoLeft":Landroid/view/animation/Animation;
    invoke-direct {p0, v0}, Lcom/livemixtapes/ui/AnimatedTabHostListener;->setProperties(Landroid/view/animation/Animation;)Landroid/view/animation/Animation;

    move-result-object v1

    return-object v1
.end method

.method private outToRightAnimation()Landroid/view/animation/Animation;
    .locals 9

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x2

    .line 81
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    const/high16 v4, 0x3f800000    # 1.0f

    move v3, v1

    move v5, v1

    move v6, v2

    move v7, v1

    move v8, v2

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 83
    .local v0, "outToRight":Landroid/view/animation/Animation;
    invoke-direct {p0, v0}, Lcom/livemixtapes/ui/AnimatedTabHostListener;->setProperties(Landroid/view/animation/Animation;)Landroid/view/animation/Animation;

    move-result-object v1

    return-object v1
.end method

.method private setProperties(Landroid/view/animation/Animation;)Landroid/view/animation/Animation;
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 117
    const-wide/16 v0, 0xf0

    invoke-virtual {p1, v0, v1}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 118
    new-instance v0, Landroid/view/animation/AccelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateInterpolator;-><init>()V

    invoke-virtual {p1, v0}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 119
    return-object p1
.end method


# virtual methods
.method public onTabChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "tabId"    # Ljava/lang/String;

    .prologue
    .line 45
    const-string v0, "AnimatedTabHost"

    const-string v1, "Tab switching..."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 46
    iget-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {v0}, Landroid/widget/TabHost;->getCurrentView()Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->currentView:Landroid/view/View;

    .line 47
    iget-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {v0}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result v0

    iget v1, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->currentTab:I

    if-le v0, v1, :cond_0

    .line 49
    iget-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->previousView:Landroid/view/View;

    invoke-direct {p0}, Lcom/livemixtapes/ui/AnimatedTabHostListener;->outToLeftAnimation()Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setAnimation(Landroid/view/animation/Animation;)V

    .line 50
    iget-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->currentView:Landroid/view/View;

    invoke-direct {p0}, Lcom/livemixtapes/ui/AnimatedTabHostListener;->inFromRightAnimation()Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setAnimation(Landroid/view/animation/Animation;)V

    .line 57
    :goto_0
    iget-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->currentView:Landroid/view/View;

    iput-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->previousView:Landroid/view/View;

    .line 58
    iget-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->tabHost:Landroid/widget/TabHost;

    invoke-virtual {v0}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result v0

    iput v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->currentTab:I

    .line 60
    return-void

    .line 54
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->previousView:Landroid/view/View;

    invoke-direct {p0}, Lcom/livemixtapes/ui/AnimatedTabHostListener;->outToRightAnimation()Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setAnimation(Landroid/view/animation/Animation;)V

    .line 55
    iget-object v0, p0, Lcom/livemixtapes/ui/AnimatedTabHostListener;->currentView:Landroid/view/View;

    invoke-direct {p0}, Lcom/livemixtapes/ui/AnimatedTabHostListener;->inFromLeftAnimation()Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setAnimation(Landroid/view/animation/Animation;)V

    goto :goto_0
.end method
