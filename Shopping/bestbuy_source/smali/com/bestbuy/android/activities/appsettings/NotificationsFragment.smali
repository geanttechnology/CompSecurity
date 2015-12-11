.class public Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field a:Landroid/support/v4/app/FragmentManager;

.field b:Landroid/support/v4/app/FragmentTransaction;

.field private c:Landroid/app/Activity;

.field private g:Landroid/content/SharedPreferences;

.field private h:Landroid/widget/FrameLayout;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 34
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->g:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->c:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a(Z)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 150
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->a:Landroid/support/v4/app/FragmentManager;

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->a:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->b:Landroid/support/v4/app/FragmentTransaction;

    .line 152
    if-eqz p1, :cond_0

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->h:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v3}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->g:Landroid/content/SharedPreferences;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08008b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, v3}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 155
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->b:Landroid/support/v4/app/FragmentTransaction;

    const v2, 0x7f0c0056

    new-instance v3, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;

    invoke-direct {v3, v0}, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;-><init>(Z)V

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->b:Landroid/support/v4/app/FragmentTransaction;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 160
    :goto_0
    return-void

    .line 158
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->h:Landroid/widget/FrameLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 47
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 48
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->c:Landroid/app/Activity;

    .line 40
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 43
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 44
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 62
    const v0, 0x7f030085

    invoke-virtual {p1, v0, p2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 63
    const v0, 0x7f0c0056

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->h:Landroid/widget/FrameLayout;

    .line 64
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->g:Landroid/content/SharedPreferences;

    .line 65
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->f:Lnb;

    .line 68
    const v0, 0x7f0c01ee

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    .line 69
    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->g:Landroid/content/SharedPreferences;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f08004b

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 70
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setChecked(Z)V

    .line 71
    new-instance v2, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$1;-><init>(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 91
    const v0, 0x7f0c01ef

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    .line 92
    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->g:Landroid/content/SharedPreferences;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f08003e

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 93
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setChecked(Z)V

    .line 94
    new-instance v2, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$2;-><init>(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 114
    const v0, 0x7f0c01f0

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Switch;

    .line 115
    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->g:Landroid/content/SharedPreferences;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f08008a

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v6}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    .line 116
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/Switch;->setChecked(Z)V

    .line 117
    iget-object v3, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->g:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    .line 118
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f08008b

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v6}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 119
    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 120
    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->a(Z)V

    .line 121
    new-instance v2, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment$3;-><init>(Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/Switch;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 146
    return-object v1
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 164
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->c:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->c:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->f:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 167
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 51
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->c:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 53
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 54
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 56
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->c:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->c:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/NotificationsFragment;->c:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 58
    return-void
.end method
