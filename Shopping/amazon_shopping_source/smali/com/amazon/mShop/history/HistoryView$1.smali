.class Lcom/amazon/mShop/history/HistoryView$1;
.super Ljava/lang/Object;
.source "HistoryView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/history/HistoryView;-><init>(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/history/HistoryView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/history/HistoryView;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/mShop/history/HistoryView$1;->this$0:Lcom/amazon/mShop/history/HistoryView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x1

    .line 86
    iget-object v2, p0, Lcom/amazon/mShop/history/HistoryView$1;->this$0:Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {v2}, Lcom/amazon/mShop/history/HistoryView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 87
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    new-instance v2, Lcom/amazon/mShop/search/SearchIntentBuilder;

    invoke-direct {v2, v0}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->showSearchEntryView(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->selectInitialQuery(Z)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_RVI:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->clickStreamOrigin(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v1

    .line 92
    .local v1, "searchIntent":Landroid/content/Intent;
    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ActivityUtils;->startSearchActivity(Lcom/amazon/mShop/AmazonActivity;Landroid/content/Intent;)Z

    .line 93
    return-void
.end method
