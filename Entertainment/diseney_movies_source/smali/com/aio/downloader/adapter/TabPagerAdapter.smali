.class public Lcom/aio/downloader/adapter/TabPagerAdapter;
.super Landroid/support/v4/app/FragmentPagerAdapter;
.source "TabPagerAdapter.java"


# instance fields
.field private final mContent:[Ljava/lang/String;

.field private mContext:Landroid/content/Context;

.field private mTitles:[Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "fm"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 20
    invoke-direct {p0, p2}, Landroid/support/v4/app/FragmentPagerAdapter;-><init>(Landroid/support/v4/app/FragmentManager;)V

    .line 15
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "One"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "Two"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/aio/downloader/adapter/TabPagerAdapter;->mContent:[Ljava/lang/String;

    .line 21
    iput-object p1, p0, Lcom/aio/downloader/adapter/TabPagerAdapter;->mContext:Landroid/content/Context;

    .line 22
    iget-object v0, p0, Lcom/aio/downloader/adapter/TabPagerAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const/high16 v1, 0x7f060000

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/adapter/TabPagerAdapter;->mTitles:[Ljava/lang/String;

    .line 23
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/aio/downloader/adapter/TabPagerAdapter;->mTitles:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Landroid/support/v4/app/Fragment;
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 27
    const/4 v0, 0x0

    .line 28
    .local v0, "f":Landroid/support/v4/app/Fragment;
    if-nez p1, :cond_1

    .line 29
    new-instance v0, Lcom/aio/downloader/fragments/BackupAvailableFragment;

    .end local v0    # "f":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/BackupAvailableFragment;-><init>()V

    .line 33
    .restart local v0    # "f":Landroid/support/v4/app/Fragment;
    :cond_0
    :goto_0
    return-object v0

    .line 30
    :cond_1
    const/4 v1, 0x1

    if-ne p1, v1, :cond_0

    .line 31
    new-instance v0, Lcom/aio/downloader/fragments/BackedUpFragment;

    .end local v0    # "f":Landroid/support/v4/app/Fragment;
    invoke-direct {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;-><init>()V

    .restart local v0    # "f":Landroid/support/v4/app/Fragment;
    goto :goto_0
.end method

.method public getPageTitle(I)Ljava/lang/CharSequence;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 38
    iget-object v0, p0, Lcom/aio/downloader/adapter/TabPagerAdapter;->mTitles:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method
