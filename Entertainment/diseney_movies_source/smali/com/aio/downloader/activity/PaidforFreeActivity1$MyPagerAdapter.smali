.class public Lcom/aio/downloader/activity/PaidforFreeActivity1$MyPagerAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "PaidforFreeActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/PaidforFreeActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MyPagerAdapter"
.end annotation


# instance fields
.field private final TITLES:[Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/PaidforFreeActivity1;Landroid/support/v4/app/FragmentManager;)V
    .locals 3
    .param p2, "fm"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 550
    iput-object p1, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$MyPagerAdapter;->this$0:Lcom/aio/downloader/activity/PaidforFreeActivity1;

    .line 551
    invoke-direct {p0, p2}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 547
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "FEATURED"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "HOT GAMES"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "NEW GAMES"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    .line 548
    const-string v2, "HOT APPS"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "NEW APPS"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    .line 552
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 561
    iget-object v0, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 566
    const/4 v0, 0x0

    .line 567
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    packed-switch p1, :pswitch_data_0

    .line 586
    :goto_0
    return-object v0

    .line 569
    :pswitch_0
    new-instance v0, Lcom/aio/downloader/fragments/PaidFeaturedFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/PaidFeaturedFragment;-><init>()V

    .line 570
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 572
    :pswitch_1
    new-instance v0, Lcom/aio/downloader/fragments/PaidHotGamesFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/PaidHotGamesFragment;-><init>()V

    .line 573
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 575
    :pswitch_2
    new-instance v0, Lcom/aio/downloader/fragments/PaidNewGamesFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/PaidNewGamesFragment;-><init>()V

    .line 576
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 578
    :pswitch_3
    new-instance v0, Lcom/aio/downloader/fragments/PaidHotAppsFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/PaidHotAppsFragment;-><init>()V

    .line 579
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 581
    :pswitch_4
    new-instance v0, Lcom/aio/downloader/fragments/PaidNewAppsFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/PaidNewAppsFragment;-><init>()V

    .line 582
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 567
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public getPageTitle(I)Ljava/lang/CharSequence;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 556
    iget-object v0, p0, Lcom/aio/downloader/activity/PaidforFreeActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method
