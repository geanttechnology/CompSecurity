.class Lcom/amazon/mShop/search/NoMatchSearchResultsView$4;
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
    .line 82
    iput-object p1, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$4;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 86
    iget-object v1, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$4;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mResultsType:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->access$100(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$4;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mResultsType:Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->access$100(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "scanItSearchResultsType"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 87
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$4;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->access$000(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    const-class v2, Lcom/amazon/mShop/barcodeSearch/HelpWithBarcodeScansActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 88
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x20000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 89
    iget-object v1, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$4;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->access$000(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/AmazonActivity;->startActivity(Landroid/content/Intent;)V

    .line 91
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_0
    return-void
.end method
