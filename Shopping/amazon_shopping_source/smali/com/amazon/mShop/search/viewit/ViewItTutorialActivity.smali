.class public Lcom/amazon/mShop/search/viewit/ViewItTutorialActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "ViewItTutorialActivity.java"


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
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 15
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 17
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItTutorialView1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialView1;-><init>(Landroid/content/Context;)V

    .line 18
    .local v0, "contentView":Lcom/amazon/mShop/search/viewit/ViewItTutorialView1;
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItTutorialActivity;->pushView(Landroid/view/View;Z)V

    .line 20
    const-string/jumbo v1, "fl_tutor_show"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 21
    return-void
.end method

.method public pushView(Landroid/view/View;Z)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "useAnimation"    # Z

    .prologue
    .line 25
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;Z)V

    .line 26
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItTutorialActivity;->setActionBarAndSeparatorDecoratorVisibility(I)V

    .line 27
    return-void
.end method
