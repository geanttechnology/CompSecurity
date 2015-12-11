.class Lcom/amazon/mShop/home/HomeView$2;
.super Ljava/lang/Object;
.source "HomeView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeView;->onPushViewCompleted()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeView;)V
    .locals 0

    .prologue
    .line 375
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView$2;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 378
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$2;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startCategoryBrowseActivity(Landroid/content/Context;)Z

    .line 380
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$2;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 381
    const-string/jumbo v0, "hm_br_land"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 386
    :goto_0
    return-void

    .line 383
    :cond_0
    const-string/jumbo v0, "hm_br_port"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method
