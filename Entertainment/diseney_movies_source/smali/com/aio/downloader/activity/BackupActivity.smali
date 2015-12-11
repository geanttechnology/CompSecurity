.class public Lcom/aio/downloader/activity/BackupActivity;
.super Landroid/support/v4/app/FragmentActivity;
.source "BackupActivity.java"


# instance fields
.field private header_left_aoto:Lcom/aio/downloader/views/LImageButton;

.field private lineTabIndicator:Lcom/aio/downloader/views/LTabIndicator;

.field private vp_aoto:Landroid/support/v4/view/ViewPager;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 18
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "arg0"    # Landroid/os/Bundle;

    .prologue
    .line 26
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/BackupActivity;->requestWindowFeature(I)Z

    .line 28
    const v0, 0x7f03001f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/BackupActivity;->setContentView(I)V

    .line 29
    const v0, 0x7f070120

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/BackupActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LImageButton;

    iput-object v0, p0, Lcom/aio/downloader/activity/BackupActivity;->header_left_aoto:Lcom/aio/downloader/views/LImageButton;

    .line 30
    const v0, 0x7f070121

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/BackupActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/views/LTabIndicator;

    iput-object v0, p0, Lcom/aio/downloader/activity/BackupActivity;->lineTabIndicator:Lcom/aio/downloader/views/LTabIndicator;

    .line 31
    const v0, 0x7f070122

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/BackupActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lcom/aio/downloader/activity/BackupActivity;->vp_aoto:Landroid/support/v4/view/ViewPager;

    .line 32
    iget-object v0, p0, Lcom/aio/downloader/activity/BackupActivity;->header_left_aoto:Lcom/aio/downloader/views/LImageButton;

    new-instance v1, Lcom/aio/downloader/activity/BackupActivity$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/BackupActivity$1;-><init>(Lcom/aio/downloader/activity/BackupActivity;)V

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 40
    invoke-static {}, Lcom/stericson/RootTools/RootTools;->isRootAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 41
    iget-object v0, p0, Lcom/aio/downloader/activity/BackupActivity;->vp_aoto:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/aio/downloader/adapter/TabPagerAdapter;

    .line 42
    invoke-virtual {p0}, Lcom/aio/downloader/activity/BackupActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Lcom/aio/downloader/adapter/TabPagerAdapter;-><init>(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;)V

    .line 41
    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 43
    iget-object v0, p0, Lcom/aio/downloader/activity/BackupActivity;->lineTabIndicator:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v1, p0, Lcom/aio/downloader/activity/BackupActivity;->vp_aoto:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LTabIndicator;->setViewPager(Landroid/support/v4/view/ViewPager;)V

    .line 51
    :goto_0
    return-void

    .line 45
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/BackupActivity;->vp_aoto:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/aio/downloader/adapter/BackupNoRootAdapter;

    .line 46
    invoke-virtual {p0}, Lcom/aio/downloader/activity/BackupActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Lcom/aio/downloader/adapter/BackupNoRootAdapter;-><init>(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;)V

    .line 45
    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 47
    iget-object v0, p0, Lcom/aio/downloader/activity/BackupActivity;->lineTabIndicator:Lcom/aio/downloader/views/LTabIndicator;

    iget-object v1, p0, Lcom/aio/downloader/activity/BackupActivity;->vp_aoto:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LTabIndicator;->setViewPager(Landroid/support/v4/view/ViewPager;)V

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 63
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 64
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 65
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 56
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 57
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 58
    return-void
.end method
