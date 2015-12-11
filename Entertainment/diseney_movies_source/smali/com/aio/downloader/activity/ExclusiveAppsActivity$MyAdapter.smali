.class Lcom/aio/downloader/activity/ExclusiveAppsActivity$MyAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "ExclusiveAppsActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/ExclusiveAppsActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "MyAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/ExclusiveAppsActivity;Landroid/support/v4/app/FragmentManager;)V
    .locals 0
    .param p2, "fm"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 433
    iput-object p1, p0, Lcom/aio/downloader/activity/ExclusiveAppsActivity$MyAdapter;->this$0:Lcom/aio/downloader/activity/ExclusiveAppsActivity;

    .line 434
    invoke-direct {p0, p2}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 436
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 450
    const/4 v0, 0x1

    return v0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 440
    const/4 v0, 0x0

    .line 441
    .local v0, "f":Landroid/support/v4/app/Fragment;
    if-nez p1, :cond_0

    .line 442
    new-instance v0, Lcom/aio/downloader/fragments/ExclusiveAppsFragment;

    .end local v0    # "f":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/ExclusiveAppsFragment;-><init>()V

    .line 444
    .restart local v0    # "f":Landroid/support/v4/app/Fragment;
    :cond_0
    return-object v0
.end method
