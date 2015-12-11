.class public Lco/vine/android/NotificationSettingsFragment;
.super Lco/vine/android/BaseArrayListFragment;
.source "NotificationSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/NotificationSettingsFragment$NotificationSettingsSpinnerAdapter;,
        Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter;,
        Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;
    }
.end annotation


# instance fields
.field private mFetched:Z

.field private mSucceeded:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 37
    invoke-direct {p0}, Lco/vine/android/BaseArrayListFragment;-><init>()V

    .line 38
    iput-boolean v0, p0, Lco/vine/android/NotificationSettingsFragment;->mFetched:Z

    .line 39
    iput-boolean v0, p0, Lco/vine/android/NotificationSettingsFragment;->mSucceeded:Z

    .line 257
    return-void
.end method

.method static synthetic access$002(Lco/vine/android/NotificationSettingsFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/NotificationSettingsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lco/vine/android/NotificationSettingsFragment;->mFetched:Z

    return p1
.end method

.method static synthetic access$102(Lco/vine/android/NotificationSettingsFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/NotificationSettingsFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lco/vine/android/NotificationSettingsFragment;->mSucceeded:Z

    return p1
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 43
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 44
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/NotificationSettingsFragment;->mRefreshable:Z

    .line 45
    new-instance v0, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;

    invoke-direct {v0, p0}, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsListener;-><init>(Lco/vine/android/NotificationSettingsFragment;)V

    iput-object v0, p0, Lco/vine/android/NotificationSettingsFragment;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 46
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lco/vine/android/NotificationSettingsFragment;->setHasOptionsMenu(Z)V

    .line 48
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 4
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    const v3, 0x7f0a0245

    const/4 v2, 0x1

    .line 67
    iget-boolean v1, p0, Lco/vine/android/NotificationSettingsFragment;->mSucceeded:Z

    if-eqz v1, :cond_0

    .line 68
    const v1, 0x7f100012

    invoke-virtual {p2, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 69
    invoke-interface {p1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    .line 70
    .local v0, "menuItem":Landroid/view/MenuItem;
    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 71
    invoke-interface {p1, v3}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 73
    .end local v0    # "menuItem":Landroid/view/MenuItem;
    :cond_0
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 313
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 322
    invoke-super {p0, p1}, Lco/vine/android/BaseArrayListFragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    :goto_0
    return v1

    .line 315
    :pswitch_0
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    if-eqz v1, :cond_0

    .line 316
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment;->mAdapter:Landroid/widget/BaseAdapter;

    check-cast v1, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter;

    invoke-virtual {v1}, Lco/vine/android/NotificationSettingsFragment$NotificationSettingsAdapter;->getMap()Ljava/util/HashMap;

    move-result-object v0

    .line 317
    .local v0, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1, v0}, Lco/vine/android/client/AppController;->saveNotificationSettings(Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lco/vine/android/NotificationSettingsFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 319
    .end local v0    # "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    const/4 v1, 0x1

    goto :goto_0

    .line 313
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0245
        :pswitch_0
    .end packed-switch
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 76
    invoke-super {p0}, Lco/vine/android/BaseArrayListFragment;->onResume()V

    .line 77
    iget-object v0, p0, Lco/vine/android/NotificationSettingsFragment;->mListView:Landroid/widget/ListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 78
    iget-object v0, p0, Lco/vine/android/NotificationSettingsFragment;->mListView:Landroid/widget/ListView;

    check-cast v0, Lcom/twitter/android/widget/RefreshableListView;

    invoke-virtual {v0}, Lcom/twitter/android/widget/RefreshableListView;->disablePTR()V

    .line 79
    iget-boolean v0, p0, Lco/vine/android/NotificationSettingsFragment;->mFetched:Z

    if-nez v0, :cond_0

    .line 80
    iget-object v0, p0, Lco/vine/android/NotificationSettingsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0}, Lco/vine/android/client/AppController;->fetchNotificationSettings()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/NotificationSettingsFragment;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 82
    :cond_0
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 52
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseArrayListFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 53
    invoke-virtual {p0}, Lco/vine/android/NotificationSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f030063

    invoke-virtual {v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 55
    .local v0, "alertsRowHeader":Landroid/view/View;
    new-instance v1, Lco/vine/android/NotificationSettingsFragment$1;

    invoke-direct {v1, p0}, Lco/vine/android/NotificationSettingsFragment$1;-><init>(Lco/vine/android/NotificationSettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 62
    iget-object v1, p0, Lco/vine/android/NotificationSettingsFragment;->mListView:Landroid/widget/ListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v0, v3, v2}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 63
    return-void
.end method
