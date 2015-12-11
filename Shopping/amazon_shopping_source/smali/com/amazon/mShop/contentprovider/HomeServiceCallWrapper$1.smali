.class final Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;
.super Ljava/lang/Object;
.source "HomeServiceCallWrapper.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/HomeResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->startHomeCall(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private finishAction()V
    .locals 1

    .prologue
    .line 59
    const/4 v0, 0x0

    # setter for: Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->sHomeServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v0}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->access$102(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 60
    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->finishAction()V

    .line 38
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->finishAction()V

    .line 56
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "arg0"    # Ljava/lang/Exception;
    .param p2, "arg1"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 42
    invoke-direct {p0}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->finishAction()V

    .line 46
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->cleanOldHomeShovelerContent()V

    .line 47
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sendContentUpdatedIntent(Landroid/content/Context;)V
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    .line 51
    :goto_0
    return-void

    .line 48
    :catch_0
    move-exception v0

    .line 49
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    # getter for: Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->access$000()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public receivedCartItems(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "cartItems"    # Lcom/amazon/rio/j2me/client/services/mShop/CartItems;
    .param p2, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 63
    return-void
.end method

.method public receivedCompletedRemembersItemIds(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 66
    .local p1, "value":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    return-void
.end method

.method public receivedLoginData(Lcom/amazon/rio/j2me/client/services/mShop/LoginData;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "loginData"    # Lcom/amazon/rio/j2me/client/services/mShop/LoginData;
    .param p2, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 69
    return-void
.end method

.method public receivedNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "notification"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;
    .param p2, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 72
    return-void
.end method

.method public receivedPromoSlot0(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "promoSlot"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .param p2, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 75
    return-void
.end method

.method public receivedPromoSlot1(Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "promoSlot"    # Lcom/amazon/rio/j2me/client/services/mShop/PromoSlot;
    .param p2, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 78
    return-void
.end method

.method public receivedShoveler0(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "homeShoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .param p2, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 84
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->cleanOldHomeShovelerContent()V

    .line 85
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->val$context:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 86
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->updateHomeShovelerItems(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    .line 91
    :cond_0
    :goto_0
    return-void

    .line 88
    :catch_0
    move-exception v0

    .line 89
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    # getter for: Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->access$000()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public receivedShoveler1(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "homeShoveler"    # Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;
    .param p2, "serviceCall"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 96
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->val$context:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 97
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->getInstance(Landroid/content/Context;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;->updateHomeShovelerItems(Lcom/amazon/rio/j2me/client/services/mShop/HomeShoveler;)V

    .line 99
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper$1;->val$context:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/contentprovider/WidgetContentProvider;->sendContentUpdatedIntent(Landroid/content/Context;)V
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0

    .line 103
    :goto_0
    return-void

    .line 100
    :catch_0
    move-exception v0

    .line 101
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    # getter for: Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/contentprovider/HomeServiceCallWrapper;->access$000()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
