.class Lcom/amazon/mShop/search/NoMatchSearchResultsView$1;
.super Ljava/lang/Object;
.source "NoMatchSearchResultsView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/NoMatchSearchResultsView;->init(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$1;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$1;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->access$000(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/SearchActivity;

    iget-object v1, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$1;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->access$000(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/search/SearchActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/search/SearchActivity;->setSearchEntryViewAsRoot(Landroid/content/Intent;Z)V

    .line 49
    return-void
.end method
