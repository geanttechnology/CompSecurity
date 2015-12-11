.class public Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "FunActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/FunActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MyPagerAdapter"
.end annotation


# instance fields
.field private final TITLES:[Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/activity/FunActivity1;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/FunActivity1;Landroid/support/v4/app/FragmentManager;)V
    .locals 3
    .param p2, "fm"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 555
    iput-object p1, p0, Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;->this$0:Lcom/aio/downloader/activity/FunActivity1;

    .line 556
    invoke-direct {p0, p2}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 552
    const/4 v0, 0x7

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "new"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "Trending"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "Popular"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    .line 553
    const-string v2, "Adult"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "Gag"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string v2, "Gif"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "Video"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    .line 557
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 566
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 571
    const/4 v0, 0x0

    .line 572
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    packed-switch p1, :pswitch_data_0

    .line 597
    :goto_0
    return-object v0

    .line 574
    :pswitch_0
    new-instance v0, Lcom/aio/downloader/fragments/FunallFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/FunallFragment;-><init>()V

    .line 575
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 577
    :pswitch_1
    new-instance v0, Lcom/aio/downloader/fragments/FunTrendingFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/FunTrendingFragment;-><init>()V

    .line 578
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 580
    :pswitch_2
    new-instance v0, Lcom/aio/downloader/fragments/FunpopularFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/FunpopularFragment;-><init>()V

    .line 581
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 583
    :pswitch_3
    new-instance v0, Lcom/aio/downloader/fragments/FunadultFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/FunadultFragment;-><init>()V

    .line 584
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 586
    :pswitch_4
    new-instance v0, Lcom/aio/downloader/fragments/FungagFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/FungagFragment;-><init>()V

    .line 587
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 589
    :pswitch_5
    new-instance v0, Lcom/aio/downloader/fragments/FungifFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/FungifFragment;-><init>()V

    .line 590
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 592
    :pswitch_6
    new-instance v0, Lcom/aio/downloader/fragments/FunvideoFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/FunvideoFragment;-><init>()V

    .line 593
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 572
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public getPageTitle(I)Ljava/lang/CharSequence;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 561
    iget-object v0, p0, Lcom/aio/downloader/activity/FunActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method
