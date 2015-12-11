.class public abstract Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;
.source "FlyinMenuActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;


# instance fields
.field private LOG:Lorg/slf4j/Logger;

.field private sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;-><init>()V

    .line 16
    const-class v0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->LOG:Lorg/slf4j/Logger;

    .line 18
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    return-void
.end method


# virtual methods
.method protected abstract getLayoutId()I
.end method

.method protected abstract getSideMenuBuilder()Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;
.end method

.method protected abstract getSideRibbonDelegateBuilder()Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->handleBackPressed()Z

    move-result v0

    if-nez v0, :cond_1

    .line 72
    :cond_0
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onBackPressed()V

    .line 74
    :cond_1
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 25
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onCreate(Landroid/os/Bundle;)V

    .line 26
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->getLayoutId()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->setContentView(I)V

    .line 30
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 31
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    .line 32
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 33
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->getSideRibbonDelegateBuilder()Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->build(Landroid/app/Activity;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .line 34
    iget-object v1, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->init()V

    .line 35
    iget-object v1, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->getSideMenuBuilder()Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getRibbonContainer()Landroid/view/ViewGroup;

    move-result-object v3

    iget-object v4, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-interface {v2, p0, v3, v4}, Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;->build(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->setRibbonContentView(Landroid/view/View;)V

    .line 36
    iget-object v1, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v1, p0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->addRibbonStateChangeListener(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;)V

    .line 37
    iget-object v1, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v1, p0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->addPassiveStateChangeListener(Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;)V

    .line 40
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 55
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 62
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    .line 66
    :cond_0
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 57
    :pswitch_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    if-eqz v0, :cond_0

    .line 58
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->toggleSlideIn()V

    goto :goto_0

    .line 55
    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method

.method public onSideRibbonStateChanged(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V
    .locals 0
    .param p1, "state"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    .prologue
    .line 50
    return-void
.end method
