.class Lcom/amazon/mShop/search/SearchResultsContainer$1;
.super Ljava/lang/Object;
.source "SearchResultsContainer.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/SearchResultsContainer;->setupVoiceSearch(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryBar;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/SearchResultsContainer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/SearchResultsContainer;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/amazon/mShop/search/SearchResultsContainer$1;->this$0:Lcom/amazon/mShop/search/SearchResultsContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/search/SearchResultsContainer$1;->this$0:Lcom/amazon/mShop/search/SearchResultsContainer;

    # getter for: Lcom/amazon/mShop/search/SearchResultsContainer;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/SearchResultsContainer;->access$000(Lcom/amazon/mShop/search/SearchResultsContainer;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 105
    invoke-static {}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->getInstance()Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/SearchResultsContainer$1;->this$0:Lcom/amazon/mShop/search/SearchResultsContainer;

    # getter for: Lcom/amazon/mShop/search/SearchResultsContainer;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/SearchResultsContainer;->access$000(Lcom/amazon/mShop/search/SearchResultsContainer;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->openVoiceSearch(Landroid/app/Activity;Z)V

    .line 107
    :cond_0
    return-void
.end method
