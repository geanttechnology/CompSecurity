.class public Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;
.super Ljava/lang/Object;
.source "SlidingActivityHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;
    }
.end annotation


# instance fields
.field private mActivity:Landroid/app/Activity;

.field private mBroadcasting:Z

.field private mEnableSlide:Z

.field private mOnPostCreateCalled:Z

.field private mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

.field private mViewAbove:Landroid/view/View;

.field private mViewBehind:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    const/4 v0, 0x0

    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    iput-boolean v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mBroadcasting:Z

    .line 24
    iput-boolean v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mOnPostCreateCalled:Z

    .line 26
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mEnableSlide:Z

    .line 34
    iput-object p1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mActivity:Landroid/app/Activity;

    .line 35
    return-void
.end method

.method static synthetic access$000(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;)Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;
    .locals 1
    .param p0, "x0"    # Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    .prologue
    .line 12
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    return-object v0
.end method


# virtual methods
.method public findViewById(I)Landroid/view/View;
    .locals 2
    .param p1, "id"    # I

    .prologue
    .line 107
    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    if-eqz v1, :cond_0

    .line 108
    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v1, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 109
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 112
    .end local v0    # "v":Landroid/view/View;
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/jeremyfeinstein/slidingmenu/lib/R$layout;->slidingmenumain:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    iput-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    .line 44
    return-void
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 210
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->isMenuShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 211
    invoke-virtual {p0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->showContent()V

    .line 212
    const/4 v0, 0x1

    .line 214
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onPostCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x1

    .line 52
    iget-object v3, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mViewBehind:Landroid/view/View;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mViewAbove:Landroid/view/View;

    if-nez v3, :cond_1

    .line 53
    :cond_0
    new-instance v2, Ljava/lang/IllegalStateException;

    const-string v3, "Both setBehindContentView must be called in onCreate in addition to setContentView."

    invoke-direct {v2, v3}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 57
    :cond_1
    iput-boolean v2, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mOnPostCreateCalled:Z

    .line 59
    iget-object v3, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    iget-object v4, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mActivity:Landroid/app/Activity;

    iget-boolean v5, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mEnableSlide:Z

    if-eqz v5, :cond_2

    const/4 v2, 0x0

    :cond_2
    invoke-virtual {v3, v4, v2}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->attachToActivity(Landroid/app/Activity;I)V

    .line 64
    if-eqz p1, :cond_3

    .line 65
    const-string v2, "SlidingActivityHelper.open"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 66
    .local v0, "open":Z
    const-string v2, "SlidingActivityHelper.secondary"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 71
    .local v1, "secondary":Z
    :goto_0
    new-instance v2, Landroid/os/Handler;

    invoke-direct {v2}, Landroid/os/Handler;-><init>()V

    new-instance v3, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$1;

    invoke-direct {v3, p0, v0, v1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$1;-><init>(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;ZZ)V

    invoke-virtual {v2, v3}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 84
    return-void

    .line 68
    .end local v0    # "open":Z
    .end local v1    # "secondary":Z
    :cond_3
    const/4 v0, 0x0

    .line 69
    .restart local v0    # "open":Z
    const/4 v1, 0x0

    .restart local v1    # "secondary":Z
    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 123
    const-string v0, "SlidingActivityHelper.open"

    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->isMenuShowing()Z

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 124
    const-string v0, "SlidingActivityHelper.secondary"

    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->isSecondaryMenuShowing()Z

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 125
    return-void
.end method

.method public registerAboveContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 134
    iget-boolean v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mBroadcasting:Z

    if-nez v0, :cond_0

    .line 135
    iput-object p1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mViewAbove:Landroid/view/View;

    .line 136
    :cond_0
    return-void
.end method

.method public setBehindContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "layoutParams"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 160
    iput-object p1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mViewBehind:Landroid/view/View;

    .line 161
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mViewBehind:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setMenu(Landroid/view/View;)V

    .line 162
    return-void
.end method

.method public setContentView(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 148
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mBroadcasting:Z

    .line 149
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mActivity:Landroid/app/Activity;

    invoke-virtual {v0, p1}, Landroid/app/Activity;->setContentView(Landroid/view/View;)V

    .line 150
    return-void
.end method

.method public setMenuStateListener(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;

    .prologue
    .line 266
    new-instance v0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;

    invoke-direct {v0, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;-><init>(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;)V

    .line 267
    .local v0, "handler":Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler;
    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v1, v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setOnClosedListener(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnClosedListener;)V

    .line 268
    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v1, v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setOnCloseListener(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnCloseListener;)V

    .line 269
    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v1, v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setOnOpenedListener(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnOpenedListener;)V

    .line 270
    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v1, v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setOnOpenListener(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu$OnOpenListener;)V

    .line 271
    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v1, v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 272
    iget-object v1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v1, v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->setOnDragListener(Landroid/view/View$OnDragListener;)V

    .line 273
    return-void
.end method

.method public setSlidingActionBarEnabled(Z)V
    .locals 2
    .param p1, "slidingActionBarEnabled"    # Z

    .prologue
    .line 94
    iget-boolean v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mOnPostCreateCalled:Z

    if-eqz v0, :cond_0

    .line 95
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "enableSlidingActionBar must be called in onCreate."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 96
    :cond_0
    iput-boolean p1, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mEnableSlide:Z

    .line 97
    return-void
.end method

.method public showContent()V
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->showContent()V

    .line 185
    return-void
.end method

.method public showMenu()V
    .locals 1

    .prologue
    .line 191
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->showMenu()V

    .line 192
    return-void
.end method

.method public showSecondaryMenu()V
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->showSecondaryMenu()V

    .line 200
    return-void
.end method

.method public toggle()V
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->mSlidingMenu:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->toggle()V

    .line 178
    return-void
.end method
