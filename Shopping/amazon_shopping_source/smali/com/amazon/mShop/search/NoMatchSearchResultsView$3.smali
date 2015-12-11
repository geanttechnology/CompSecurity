.class Lcom/amazon/mShop/search/NoMatchSearchResultsView$3;
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
    .line 67
    iput-object p1, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$3;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v1, 0x0

    .line 71
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView$3;->this$0:Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->access$000(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-static {v0, v1, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startDealsActivity(Landroid/content/Context;Lcom/amazon/mShop/goldbox/GoldboxLaunchParamters;Ljava/lang/String;)Z

    .line 72
    return-void
.end method
