.class Lcom/amazon/mShop/home/HomeView$8;
.super Ljava/lang/Object;
.source "HomeView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeView;->onHomeShoveler0Received(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeView;

.field final synthetic val$shoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeView;Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    .locals 0

    .prologue
    .line 928
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView$8;->this$0:Lcom/amazon/mShop/home/HomeView;

    iput-object p2, p0, Lcom/amazon/mShop/home/HomeView$8;->val$shoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 932
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView$8;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v1}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->cleanOldHomeShovelerContent()V

    .line 933
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView$8;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {v1}, Lcom/amazon/mShop/home/HomeView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 934
    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView$8;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v1}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/home/HomeView$8;->val$shoveler:Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->updateHomeShovelerItems(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    .line 939
    :cond_0
    :goto_0
    return-void

    .line 936
    :catch_0
    move-exception v0

    .line 937
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    const-string/jumbo v1, "HomeView"

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
