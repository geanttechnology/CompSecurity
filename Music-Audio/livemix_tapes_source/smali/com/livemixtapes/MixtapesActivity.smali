.class public Lcom/livemixtapes/MixtapesActivity;
.super Lcom/livemixtapes/ui/BaseActivity;
.source "MixtapesActivity.java"


# instance fields
.field public day_mixtapes:I

.field public dbHelper:Lcom/livemixtapes/database/DBHelper;

.field public unreleased_mixtapes:I

.field public week_mixtapes:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/livemixtapes/ui/BaseActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 2

    .prologue
    .line 108
    invoke-virtual {p0}, Lcom/livemixtapes/MixtapesActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    .line 110
    .local v0, "count":I
    if-eqz v0, :cond_0

    .line 113
    invoke-virtual {p0}, Lcom/livemixtapes/MixtapesActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->popBackStack()V

    .line 115
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 75
    const v0, 0x7f03002a

    invoke-super {p0, p1, v0}, Lcom/livemixtapes/ui/BaseActivity;->onCreate(Landroid/os/Bundle;I)V

    .line 82
    invoke-static {p0}, Lcom/livemixtapes/database/DBHelper;->sharedInstance(Landroid/content/Context;)Lcom/livemixtapes/database/DBHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    .line 84
    iget-object v0, p0, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    const-string v1, "week_mixtapes"

    invoke-virtual {v0, v1}, Lcom/livemixtapes/database/DBHelper;->mixtapeCount(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/livemixtapes/MixtapesActivity;->week_mixtapes:I

    .line 85
    iget-object v0, p0, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    const-string v1, "day_mixtapes"

    invoke-virtual {v0, v1}, Lcom/livemixtapes/database/DBHelper;->mixtapeCount(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/livemixtapes/MixtapesActivity;->day_mixtapes:I

    .line 86
    iget-object v0, p0, Lcom/livemixtapes/MixtapesActivity;->dbHelper:Lcom/livemixtapes/database/DBHelper;

    const-string v1, "unreleased_mixtapes"

    invoke-virtual {v0, v1}, Lcom/livemixtapes/database/DBHelper;->mixtapeCount(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/livemixtapes/MixtapesActivity;->unreleased_mixtapes:I

    .line 89
    if-nez p1, :cond_0

    .line 90
    invoke-virtual {p0}, Lcom/livemixtapes/MixtapesActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 91
    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 92
    const v1, 0x7f0800cc

    new-instance v2, Lcom/livemixtapes/Mixtapes;

    invoke-direct {v2}, Lcom/livemixtapes/Mixtapes;-><init>()V

    invoke-virtual {v0, v1, v2}, Landroid/app/FragmentTransaction;->add(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 93
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 95
    :cond_0
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 120
    invoke-super {p0, p1}, Lcom/livemixtapes/ui/BaseActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
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
    .line 61
    invoke-super {p0}, Lcom/livemixtapes/ui/BaseActivity;->onResume()V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    .line 63
    const-string v3, "LOGGING MIXTAPES ACTIVITY"

    aput-object v3, v1, v2

    invoke-static {v1}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 64
    invoke-virtual {p0}, Lcom/livemixtapes/MixtapesActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/livemixtapes/App;

    .line 66
    .local v0, "application":Lcom/livemixtapes/App;
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    const-string v2, "Image~MixtapesActivity"

    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->setScreenName(Ljava/lang/String;)V

    .line 69
    invoke-virtual {v0}, Lcom/livemixtapes/App;->getDefaultTracker()Lcom/google/android/gms/analytics/Tracker;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;

    invoke-direct {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/google/android/gms/analytics/HitBuilders$ScreenViewBuilder;->build()Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gms/analytics/Tracker;->send(Ljava/util/Map;)V

    .line 71
    return-void
.end method
