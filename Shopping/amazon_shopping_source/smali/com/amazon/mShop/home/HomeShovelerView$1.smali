.class Lcom/amazon/mShop/home/HomeShovelerView$1;
.super Ljava/lang/Object;
.source "HomeShovelerView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeShovelerView;->setUpTitleContainerClickListener(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeShovelerView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeShovelerView;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeShovelerView$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 92
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerView$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerView;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerView;->access$000(Lcom/amazon/mShop/home/HomeShovelerView;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerView$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerView;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerView;->access$000(Lcom/amazon/mShop/home/HomeShovelerView;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getMoreLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v3

    if-nez v3, :cond_1

    .line 114
    :cond_0
    :goto_0
    return-void

    .line 96
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerView$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerView;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerView;->mMoreLinkRefMarker:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerView;->access$100(Lcom/amazon/mShop/home/HomeShovelerView;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 97
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerView$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerView;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerView;->mMoreLinkRefMarker:Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerView;->access$100(Lcom/amazon/mShop/home/HomeShovelerView;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 100
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerView$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerView;

    invoke-virtual {v3}, Lcom/amazon/mShop/home/HomeShovelerView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 101
    .local v0, "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerView$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerView;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerView;->access$000(Lcom/amazon/mShop/home/HomeShovelerView;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getMoreLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;->getUri()Ljava/lang/String;

    move-result-object v1

    .line 102
    .local v1, "uriString":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_3

    new-instance v3, Lcom/amazon/mShop/mash/nav/AmazonNavManager;

    invoke-direct {v3}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;-><init>()V

    invoke-virtual {v3, v1, v0}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;->navigate(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 106
    :cond_3
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerView$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerView;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerView;->access$000(Lcom/amazon/mShop/home/HomeShovelerView;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getMoreLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 107
    .local v2, "url":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 108
    iget-object v3, p0, Lcom/amazon/mShop/home/HomeShovelerView$1;->this$0:Lcom/amazon/mShop/home/HomeShovelerView;

    # getter for: Lcom/amazon/mShop/home/HomeShovelerView;->mHomeShoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    invoke-static {v3}, Lcom/amazon/mShop/home/HomeShovelerView;->access$000(Lcom/amazon/mShop/home/HomeShovelerView;)Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;->getDisplayType()Ljava/lang/Integer;

    move-result-object v3

    const/4 v4, 0x1

    invoke-static {v3, v4}, Lcom/amazon/mShop/util/DataUtil;->isEqual(Ljava/lang/Integer;I)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 109
    const/4 v3, 0x0

    invoke-static {v0, v2, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startAIVWebActivity(Landroid/content/Context;Ljava/lang/String;Z)V

    goto :goto_0

    .line 111
    :cond_4
    invoke-static {v0, v2}, Lcom/amazon/mShop/util/WebUtils;->openWebview(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0
.end method
