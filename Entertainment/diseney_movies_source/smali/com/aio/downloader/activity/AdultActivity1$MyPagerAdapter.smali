.class public Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "AdultActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AdultActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MyPagerAdapter"
.end annotation


# instance fields
.field private final TITLES:[Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/activity/AdultActivity1;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/AdultActivity1;Landroid/support/v4/app/FragmentManager;)V
    .locals 3
    .param p2, "fm"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 549
    iput-object p1, p0, Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;->this$0:Lcom/aio/downloader/activity/AdultActivity1;

    .line 550
    invoke-direct {p0, p2}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 546
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "FEATURED"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "GAMES"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string v2, "DATING"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    .line 547
    const-string v2, "VIDEO"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    .line 551
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 560
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 565
    const/4 v0, 0x0

    .line 566
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    packed-switch p1, :pswitch_data_0

    .line 585
    :goto_0
    return-object v0

    .line 568
    :pswitch_0
    new-instance v0, Lcom/aio/downloader/fragments/AdultFeaturedFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/AdultFeaturedFragment;-><init>()V

    .line 569
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 572
    :pswitch_1
    new-instance v0, Lcom/aio/downloader/fragments/AdultGamesFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/AdultGamesFragment;-><init>()V

    .line 573
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 576
    :pswitch_2
    new-instance v0, Lcom/aio/downloader/fragments/AdultDatingFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/AdultDatingFragment;-><init>()V

    .line 577
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 580
    :pswitch_3
    new-instance v0, Lcom/aio/downloader/fragments/AdultVideoFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/AdultVideoFragment;-><init>()V

    .line 581
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 566
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public getPageTitle(I)Ljava/lang/CharSequence;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 555
    iget-object v0, p0, Lcom/aio/downloader/activity/AdultActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method
