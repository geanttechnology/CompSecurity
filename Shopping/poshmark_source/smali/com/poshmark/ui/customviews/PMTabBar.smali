.class public Lcom/poshmark/ui/customviews/PMTabBar;
.super Landroid/widget/LinearLayout;
.source "PMTabBar.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;
    }
.end annotation


# instance fields
.field private currentActiveTab:Lcom/poshmark/ui/customviews/PMTabButton;

.field listener:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 37
    new-instance v0, Lcom/poshmark/ui/customviews/PMTabBar$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/PMTabBar$1;-><init>(Lcom/poshmark/ui/customviews/PMTabBar;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/PMTabBar;->listener:Landroid/view/View$OnClickListener;

    .line 20
    return-void
.end method

.method private activateTabContent(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 0
    .param p1, "button"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 72
    return-void
.end method


# virtual methods
.method public addTab(Lcom/poshmark/ui/customviews/PMTabButton;Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;)V
    .locals 1
    .param p1, "button"    # Lcom/poshmark/ui/customviews/PMTabButton;
    .param p2, "tabListener"    # Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    .prologue
    .line 53
    invoke-virtual {p0, p1}, Lcom/poshmark/ui/customviews/PMTabBar;->addView(Landroid/view/View;)V

    .line 54
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabBar;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMTabButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 55
    invoke-virtual {p1, p2}, Lcom/poshmark/ui/customviews/PMTabButton;->setTabListener(Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;)V

    .line 56
    return-void
.end method

.method public getActiveTab()Lcom/poshmark/ui/customviews/PMTabButton;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabBar;->currentActiveTab:Lcom/poshmark/ui/customviews/PMTabButton;

    return-object v0
.end method

.method public handleDoubleTap(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 0
    .param p1, "pmTabButton"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 84
    return-void
.end method

.method public handleSingleTap(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 0
    .param p1, "pmTabButton"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 79
    invoke-virtual {p0, p1}, Lcom/poshmark/ui/customviews/PMTabBar;->setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V

    .line 80
    return-void
.end method

.method protected onMeasure(II)V
    .locals 4
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 28
    invoke-super {p0, p1, p2}, Landroid/widget/LinearLayout;->onMeasure(II)V

    .line 29
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMTabBar;->getChildCount()I

    move-result v1

    .line 30
    .local v1, "count":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_0

    .line 31
    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/PMTabBar;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMTabButton;

    .line 32
    .local v0, "child":Lcom/poshmark/ui/customviews/PMTabButton;
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMTabBar;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v3}, Lcom/poshmark/ui/customviews/PMTabButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 33
    invoke-virtual {v0, p0}, Lcom/poshmark/ui/customviews/PMTabButton;->setParentTabBar(Lcom/poshmark/ui/customviews/PMTabBar;)V

    .line 30
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 35
    .end local v0    # "child":Lcom/poshmark/ui/customviews/PMTabButton;
    :cond_0
    return-void
.end method

.method public setActiveTab(Lcom/poshmark/ui/customviews/PMTabButton;)V
    .locals 2
    .param p1, "button"    # Lcom/poshmark/ui/customviews/PMTabButton;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabBar;->currentActiveTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eq v0, p1, :cond_1

    .line 60
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabBar;->currentActiveTab:Lcom/poshmark/ui/customviews/PMTabButton;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMTabBar;->currentActiveTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-virtual {v0}, Lcom/poshmark/ui/customviews/PMTabButton;->getTabListener()Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMTabBar;->currentActiveTab:Lcom/poshmark/ui/customviews/PMTabButton;

    invoke-interface {v0, v1}, Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;->onTabUnselected(Lcom/poshmark/ui/customviews/PMTabButton;)V

    .line 63
    :cond_0
    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMTabButton;->getTabListener()Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/poshmark/ui/customviews/PMTabBar$PMTabListener;->onTabSelected(Lcom/poshmark/ui/customviews/PMTabButton;)V

    .line 64
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMTabBar;->currentActiveTab:Lcom/poshmark/ui/customviews/PMTabButton;

    .line 69
    :cond_1
    return-void
.end method

.method setTabListener()V
    .locals 0

    .prologue
    .line 24
    return-void
.end method
