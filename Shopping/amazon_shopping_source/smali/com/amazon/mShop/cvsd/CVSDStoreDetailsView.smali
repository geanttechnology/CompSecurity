.class public Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;
.super Landroid/widget/ListView;
.source "CVSDStoreDetailsView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$1;,
        Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;
    }
.end annotation


# instance fields
.field private adapter:Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;

.field private final amazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private final layoutInflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 2
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 31
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 32
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->layoutInflater:Landroid/view/LayoutInflater;

    .line 34
    new-instance v0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;-><init>(Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$1;)V

    iput-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->adapter:Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;

    .line 35
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->adapter:Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->adapter:Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 37
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;)Landroid/view/LayoutInflater;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->layoutInflater:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 41
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_ship_to_the_selected_store:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
