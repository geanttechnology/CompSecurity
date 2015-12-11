.class public Lcom/aio/downloader/activity/AppActivity1$MyPagerAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "AppActivity1.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/AppActivity1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MyPagerAdapter"
.end annotation


# instance fields
.field private final TITLES:[Ljava/lang/String;

.field final synthetic this$0:Lcom/aio/downloader/activity/AppActivity1;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/activity/AppActivity1;Landroid/support/v4/app/FragmentManager;)V
    .locals 3
    .param p2, "fm"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 568
    iput-object p1, p0, Lcom/aio/downloader/activity/AppActivity1$MyPagerAdapter;->this$0:Lcom/aio/downloader/activity/AppActivity1;

    .line 569
    invoke-direct {p0, p2}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 565
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "FEATURED"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "GLOBAL TOP"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    .line 566
    const-string v2, "GLOBAL NEW"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string v2, "LOCAL TOP"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "LOCAL NEW"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/aio/downloader/activity/AppActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    .line 570
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 579
    iget-object v0, p0, Lcom/aio/downloader/activity/AppActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 584
    const/4 v0, 0x0

    .line 585
    .local v0, "fragment":Landroid/support/v4/app/Fragment;
    packed-switch p1, :pswitch_data_0

    .line 609
    :goto_0
    return-object v0

    .line 587
    :pswitch_0
    new-instance v0, Lcom/aio/downloader/fragments/AppFeaturedFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/AppFeaturedFragment;-><init>()V

    .line 588
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 592
    :pswitch_1
    new-instance v0, Lcom/aio/downloader/fragments/AppGlobalTopFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/AppGlobalTopFragment;-><init>()V

    .line 593
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 596
    :pswitch_2
    new-instance v0, Lcom/aio/downloader/fragments/AppGlobalNewFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/AppGlobalNewFragment;-><init>()V

    .line 597
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 600
    :pswitch_3
    new-instance v0, Lcom/aio/downloader/fragments/AppIndiaTopFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/AppIndiaTopFragment;-><init>()V

    .line 601
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 604
    :pswitch_4
    new-instance v0, Lcom/aio/downloader/fragments/AppIndiaNewFragment;

    .end local v0    # "fragment":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/AppIndiaNewFragment;-><init>()V

    .line 605
    .restart local v0    # "fragment":Landroid/support/v4/app/Fragment;
    goto :goto_0

    .line 585
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
    .line 574
    iget-object v0, p0, Lcom/aio/downloader/activity/AppActivity1$MyPagerAdapter;->TITLES:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method
