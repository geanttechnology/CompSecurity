.class Lcom/amazon/mShop/home/web/MShopWebHomeBar$1;
.super Ljava/lang/Object;
.source "MShopWebHomeBar.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/web/MShopWebHomeBar;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)V
    .locals 0

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$1;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$1;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startCategoryBrowseActivity(Landroid/content/Context;)Z

    .line 88
    iget-object v0, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$1;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v0

    iget v0, v0, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 89
    const-string/jumbo v0, "hm_br_land"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 94
    :goto_0
    return-void

    .line 91
    :cond_0
    const-string/jumbo v0, "hm_br_port"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method
