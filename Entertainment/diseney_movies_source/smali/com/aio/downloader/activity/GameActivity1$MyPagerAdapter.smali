.class public Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "GameActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/GameActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MyPagerAdapter"
.end annotation


# instance fields
.field private final TITLES:[Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/activity/GameActivity1;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/GameActivity1;Landroid/support/v4/app/FragmentManager;)V
    .locals 3
    .param p2, "fm"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 547
    iput-object p1, p0, Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;->this$0:Lcom/aio/downloader/activity/GameActivity1;

    .line 548
    invoke-direct {p0, p2}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 544
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "FEATURED"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "GLOBAL TOP"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    .line 545
    const-string v2, "GLOBAL NEW"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "LOCAL TOP"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "LOCAL NEW"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    .line 549
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 558
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 563
    const/4 v0, 0x0

    .line 564
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    packed-switch p1, :pswitch_data_0

    .line 590
    :goto_0
    return-object v0

    .line 567
    :pswitch_0
    new-instance v0, Lcom/aio/downloader/fragments/GameFeaturedFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/GameFeaturedFragment;-><init>()V

    .line 568
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 572
    :pswitch_1
    new-instance v0, Lcom/aio/downloader/fragments/GameGlobalTopFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/GameGlobalTopFragment;-><init>()V

    .line 573
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 577
    :pswitch_2
    new-instance v0, Lcom/aio/downloader/fragments/GameGlobalNewFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/GameGlobalNewFragment;-><init>()V

    .line 578
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 581
    :pswitch_3
    new-instance v0, Lcom/aio/downloader/fragments/GameIndiaTopFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/GameIndiaTopFragment;-><init>()V

    .line 582
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 585
    :pswitch_4
    new-instance v0, Lcom/aio/downloader/fragments/GameIndiaNewFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/GameIndiaNewFragment;-><init>()V

    .line 586
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 564
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
    .line 553
    iget-object v0, p0, Lcom/aio/downloader/activity/GameActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method
