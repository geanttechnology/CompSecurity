.class public Lcom/amazon/mShop/search/SearchDebugSettingsActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "SearchDebugSettingsActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, -0x1

    .line 24
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 25
    new-instance v0, Landroid/widget/ScrollView;

    invoke-direct {v0, p0}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 26
    .local v0, "rootView":Landroid/widget/ScrollView;
    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 28
    new-instance v1, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;-><init>(Landroid/content/Context;)V

    invoke-virtual {v0, v1}, Landroid/widget/ScrollView;->addView(Landroid/view/View;)V

    .line 29
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/SearchDebugSettingsActivity;->setRootView(Landroid/view/View;)V

    .line 30
    return-void
.end method
