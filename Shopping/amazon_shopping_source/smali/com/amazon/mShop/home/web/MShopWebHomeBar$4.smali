.class Lcom/amazon/mShop/home/web/MShopWebHomeBar$4;
.super Ljava/lang/Object;
.source "MShopWebHomeBar.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/web/MShopWebHomeBar;->onHomeShoveler1Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

.field final synthetic val$shoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/web/MShopWebHomeBar;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 0

    .prologue
    .line 275
    iput-object p1, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$4;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    iput-object p2, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$4;->val$shoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 279
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$4;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    invoke-virtual {v1}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 280
    iget-object v1, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$4;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mActivity:Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;
    invoke-static {v1}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$200(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$4;->val$shoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->updateHomeShovelerItems(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V

    .line 283
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/home/web/MShopWebHomeBar$4;->this$0:Lcom/amazon/mShop/home/web/MShopWebHomeBar;

    # getter for: Lcom/amazon/mShop/home/web/MShopWebHomeBar;->mActivity:Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;
    invoke-static {v1}, Lcom/amazon/mShop/home/web/MShopWebHomeBar;->access$200(Lcom/amazon/mShop/home/web/MShopWebHomeBar;)Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sendContentUpdatedIntent(Landroid/content/Context;)V
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    .line 287
    :goto_0
    return-void

    .line 284
    :catch_0
    move-exception v0

    .line 285
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    const-string/jumbo v1, "WebHomeBar"

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
