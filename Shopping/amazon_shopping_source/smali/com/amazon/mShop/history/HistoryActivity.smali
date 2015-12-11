.class public Lcom/amazon/mShop/history/HistoryActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "HistoryActivity.java"


# instance fields
.field private mHistoryView:Lcom/amazon/mShop/history/HistoryView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 16
    sget-object v0, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_RVI:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ClickStreamTag;->getTag()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/history/HistoryActivity;->setClickStreamOrigin(Ljava/lang/String;)V

    .line 17
    new-instance v0, Lcom/amazon/mShop/history/HistoryView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/history/HistoryView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryActivity;->mHistoryView:Lcom/amazon/mShop/history/HistoryView;

    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryActivity;->mHistoryView:Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/history/HistoryActivity;->setRootView(Landroid/view/View;)V

    .line 19
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 23
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 24
    new-instance v0, Lcom/amazon/mShop/history/HistoryView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/history/HistoryView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/history/HistoryActivity;->mHistoryView:Lcom/amazon/mShop/history/HistoryView;

    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryActivity;->mHistoryView:Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/history/HistoryActivity;->setRootView(Landroid/view/View;)V

    .line 26
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 30
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStop()V

    .line 31
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryActivity;->mHistoryView:Lcom/amazon/mShop/history/HistoryView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryActivity;->mHistoryView:Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {v0}, Lcom/amazon/mShop/history/HistoryView;->deleteAsinsFromDB()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryActivity;->mHistoryView:Lcom/amazon/mShop/history/HistoryView;

    invoke-virtual {v0}, Lcom/amazon/mShop/history/HistoryView;->refresh()V

    .line 34
    :cond_0
    return-void
.end method
