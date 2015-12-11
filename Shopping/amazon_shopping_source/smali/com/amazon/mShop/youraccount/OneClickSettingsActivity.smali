.class public Lcom/amazon/mShop/youraccount/OneClickSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "OneClickSettingsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 11
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 12
    new-instance v0, Lcom/amazon/mShop/youraccount/OneClickSettingsView;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/mShop/youraccount/OneClickSettingsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Z)V

    .line 13
    .local v0, "oneClickView":Lcom/amazon/mShop/youraccount/OneClickSettingsView;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/youraccount/OneClickSettingsActivity;->pushView(Landroid/view/View;)V

    .line 14
    return-void
.end method
