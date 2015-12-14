.class public Lcom/livemixtapes/SearchActivity;
.super Lcom/livemixtapes/ui/BaseActivity;
.source "SearchActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/livemixtapes/ui/BaseActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 3

    .prologue
    .line 65
    invoke-virtual {p0}, Lcom/livemixtapes/SearchActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "MIXTAPE"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    .line 68
    .local v0, "fragment":Landroid/app/Fragment;
    if-eqz v0, :cond_0

    .line 70
    invoke-virtual {p0}, Lcom/livemixtapes/SearchActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->popBackStack()V

    .line 74
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 53
    const v0, 0x7f030038

    invoke-super {p0, p1, v0}, Lcom/livemixtapes/ui/BaseActivity;->onCreate(Landroid/os/Bundle;I)V

    .line 55
    invoke-virtual {p0}, Lcom/livemixtapes/SearchActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 56
    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 57
    const v1, 0x7f0800cc

    new-instance v2, Lcom/livemixtapes/SearchFragment;

    invoke-direct {v2}, Lcom/livemixtapes/SearchFragment;-><init>()V

    invoke-virtual {v0, v1, v2}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 58
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 59
    return-void
.end method

.method public bridge synthetic onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3, p4}, Lcom/livemixtapes/ui/BaseActivity;->onCreateView(Landroid/view/View;Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1

    .prologue
    .line 1
    invoke-super {p0, p1, p2, p3}, Lcom/livemixtapes/ui/BaseActivity;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 40
    invoke-super {p0}, Lcom/livemixtapes/ui/BaseActivity;->onResume()V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 42
    const-string v3, "LOGGING SEARCH ACTIVITY"

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 43
    invoke-virtual {p0}, Lcom/livemixtapes/SearchActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/App;

    .line 45
    .local v0, "application":Lcom/livemixtapes/App;
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    const-string v2, "Image~SearchActivity"

    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->setScreenName(Ljava/lang/String;)V

    .line 48
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;

    invoke-direct {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;->build()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->send(Ljava/util/Map;)V

    .line 49
    return-void
.end method
