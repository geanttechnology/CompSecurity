.class public Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static ctx:Landroid/content/Context;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static changeToBackActionBar(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 26
    sput-object p0, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->ctx:Landroid/content/Context;

    .line 27
    check-cast p0, Lcom/actionbarsherlock/app/SherlockFragmentActivity;

    invoke-virtual {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v0

    .line 28
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 29
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 30
    return-void
.end method

.method public static changeToNormalActionBar(Landroid/content/Context;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 33
    sput-object p0, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->ctx:Landroid/content/Context;

    .line 34
    check-cast p0, Lcom/actionbarsherlock/app/SherlockFragmentActivity;

    invoke-virtual {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v0

    .line 35
    const v1, 0x7f02011d

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setLogo(I)V

    .line 36
    invoke-virtual {v0, v2}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 37
    invoke-virtual {v0, v2}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 38
    const v1, 0x7f030016

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setCustomView(I)V

    .line 39
    return-void
.end method

.method public static hideOption(Lcom/actionbarsherlock/view/Menu;I)V
    .locals 2

    .prologue
    .line 104
    invoke-interface {p0, p1}, Lcom/actionbarsherlock/view/Menu;->findItem(I)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    .line 105
    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/actionbarsherlock/view/MenuItem;->setVisible(Z)Lcom/actionbarsherlock/view/MenuItem;

    .line 106
    return-void
.end method

.method public static initActionBar(Landroid/content/Context;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 17
    sput-object p0, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->ctx:Landroid/content/Context;

    .line 18
    check-cast p0, Lcom/actionbarsherlock/app/SherlockFragmentActivity;

    invoke-virtual {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v0

    .line 19
    const v1, 0x7f02011d

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setLogo(I)V

    .line 20
    invoke-virtual {v0, v2}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 21
    invoke-virtual {v0, v2}, Lcom/actionbarsherlock/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 22
    const v1, 0x7f0200ec

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/ActionBar;->setIcon(I)V

    .line 23
    return-void
.end method

.method public static setActionBarItems(Lcom/actionbarsherlock/view/Menu;ILandroid/content/Context;)V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/16 v5, 0x3e7

    const/4 v4, 0x2

    const/16 v3, 0xc

    const/4 v2, 0x6

    .line 43
    invoke-interface {p0, v5}, Lcom/actionbarsherlock/view/Menu;->findItem(I)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    .line 44
    if-eqz v0, :cond_0

    .line 45
    invoke-interface {v0}, Lcom/actionbarsherlock/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->clearFocus()V

    .line 46
    invoke-interface {v0}, Lcom/actionbarsherlock/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setFocusable(Z)V

    .line 49
    :cond_0
    invoke-static {p0, v5}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 50
    invoke-static {p0, v6}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 51
    invoke-static {p0, v4}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 52
    const/4 v0, 0x3

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 53
    const/4 v0, 0x7

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 54
    const/16 v0, 0x8

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 55
    const/16 v0, 0xa

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 56
    const/16 v0, 0xd

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 57
    const/16 v0, 0xb

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 58
    sget-object v0, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/actionbarsherlock/app/SherlockFragmentActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->setSupportProgressBarIndeterminateVisibility(Z)V

    .line 60
    packed-switch p1, :pswitch_data_0

    .line 97
    :cond_1
    :goto_0
    :pswitch_0
    return-void

    .line 62
    :pswitch_1
    invoke-static {p0, v6}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 63
    invoke-static {p0, v3}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 64
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    goto :goto_0

    .line 67
    :pswitch_2
    sget-object v0, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_1

    .line 68
    const/4 v0, 0x3

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    goto :goto_0

    .line 71
    :pswitch_3
    invoke-static {p0, v4}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 72
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 73
    invoke-static {p0, v3}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    goto :goto_0

    .line 76
    :pswitch_4
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 77
    invoke-static {p0, v3}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    goto :goto_0

    .line 80
    :pswitch_5
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 81
    invoke-static {p0, v3}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    goto :goto_0

    .line 84
    :pswitch_6
    invoke-static {p0, v4}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 85
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 86
    const/4 v0, 0x7

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 87
    invoke-static {p0, v3}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    goto :goto_0

    .line 90
    :pswitch_7
    invoke-static {p0, v5}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 91
    invoke-static {p0, v4}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 92
    const/16 v0, 0xd

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->showOption(Lcom/actionbarsherlock/view/Menu;I)V

    goto :goto_0

    .line 95
    :pswitch_8
    invoke-static {p0, v5}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 96
    sget-object v0, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/actionbarsherlock/app/SherlockFragmentActivity;

    invoke-virtual {v0, v6}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->setSupportProgressBarIndeterminateVisibility(Z)V

    goto :goto_0

    .line 60
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_5
        :pswitch_0
        :pswitch_6
        :pswitch_0
        :pswitch_7
        :pswitch_0
        :pswitch_8
    .end packed-switch
.end method

.method private static showOption(Lcom/actionbarsherlock/view/Menu;I)V
    .locals 2

    .prologue
    .line 109
    invoke-interface {p0, p1}, Lcom/actionbarsherlock/view/Menu;->findItem(I)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    .line 110
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/actionbarsherlock/view/MenuItem;->setVisible(Z)Lcom/actionbarsherlock/view/MenuItem;

    .line 111
    return-void
.end method
