.class public abstract Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;
.super Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;
.source "FlyinMenuSettingsFragmentActivity.java"


# instance fields
.field private LOG:Lorg/slf4j/Logger;

.field private actionBar:Landroid/app/ActionBar;

.field private actionBarTitle:Landroid/widget/TextView;

.field private sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;-><init>()V

    .line 15
    const-class v0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->LOG:Lorg/slf4j/Logger;

    .line 20
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    return-void
.end method


# virtual methods
.method protected abstract getSideMenuBuilder()Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;
.end method

.method protected abstract getSideRibbonDelegateBuilder()Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->handleBackPressed()Z

    move-result v0

    if-nez v0, :cond_1

    .line 89
    :cond_0
    invoke-super {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->onBackPressed()V

    .line 91
    :cond_1
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBar:Landroid/app/ActionBar;

    .line 29
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBar:Landroid/app/ActionBar;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBar:Landroid/app/ActionBar;

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 30
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBar:Landroid/app/ActionBar;

    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    sget v1, Lcom/comcast/cim/android/R$id;->title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBarTitle:Landroid/widget/TextView;

    .line 33
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBarTitle:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->getTitle()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 35
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->getSideRibbonDelegateBuilder()Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;->build(Landroid/app/Activity;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .line 36
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->init()V

    .line 37
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->getSideMenuBuilder()Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v2}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getRibbonContainer()Landroid/view/ViewGroup;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-interface {v1, p0, v2, v3}, Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;->build(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->setRibbonContentView(Landroid/view/View;)V

    .line 40
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 56
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 63
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    .line 67
    :cond_0
    :goto_0
    const/4 v0, 0x1

    return v0

    .line 58
    :pswitch_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->sideRibbon:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->toggleSlideIn()V

    goto :goto_0

    .line 56
    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method

.method protected setActionBarIcon(I)V
    .locals 1
    .param p1, "resourceID"    # I

    .prologue
    .line 47
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBar:Landroid/app/ActionBar;

    invoke-virtual {v0, p1}, Landroid/app/ActionBar;->setIcon(I)V

    .line 48
    return-void
.end method

.method public setTitle(I)V
    .locals 1
    .param p1, "titleId"    # I

    .prologue
    .line 80
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->setTitle(I)V

    .line 81
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBarTitle:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBarTitle:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(I)V

    .line 84
    :cond_0
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 72
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/settings/SettingsFragmentActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 73
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBarTitle:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuSettingsFragmentActivity;->actionBarTitle:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 76
    :cond_0
    return-void
.end method
