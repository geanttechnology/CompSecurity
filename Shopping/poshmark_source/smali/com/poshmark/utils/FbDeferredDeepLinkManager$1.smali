.class Lcom/poshmark/utils/FbDeferredDeepLinkManager$1;
.super Ljava/lang/Object;
.source "FbDeferredDeepLinkManager.java"

# interfaces
.implements Lcom/facebook/applinks/AppLinkData$CompletionHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/FbDeferredDeepLinkManager;->fetchFbDeferredDeepLink()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/FbDeferredDeepLinkManager;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/FbDeferredDeepLinkManager;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDeferredAppLinkDataFetched(Lcom/facebook/applinks/AppLinkData;)V
    .locals 4
    .param p1, "appLinkData"    # Lcom/facebook/applinks/AppLinkData;

    .prologue
    .line 39
    if-eqz p1, :cond_0

    .line 40
    iget-object v1, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    sget-object v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;->DL_RECEIVED:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    iput-object v2, v1, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    .line 41
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 42
    .local v0, "trackingInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "ev"

    const-string v2, "fbdl"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    const-string v1, "s"

    const-string v2, "dlf"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    const-string v1, "lrf"

    sget-object v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {v2}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->getDeepLinkUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 45
    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->trackDeepLink(Ljava/util/HashMap;)V

    .line 46
    iget-object v1, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-virtual {p1}, Lcom/facebook/applinks/AppLinkData;->getArgumentBundle()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "com.facebook.platform.APPLINK_NATIVE_URL"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, v1, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->originalDeepLinkUrl:Ljava/lang/String;

    .line 47
    iget-object v1, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    iget-object v2, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    iget-object v2, v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->originalDeepLinkUrl:Ljava/lang/String;

    # invokes: Lcom/poshmark/utils/FbDeferredDeepLinkManager;->extractDeepLinkInfo(Ljava/lang/String;)V
    invoke-static {v1, v2}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->access$000(Lcom/poshmark/utils/FbDeferredDeepLinkManager;Ljava/lang/String;)V

    .line 48
    const-string v1, "com.poshmark.intents.PROFILE_UPDATED"

    invoke-static {v1}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 50
    .end local v0    # "trackingInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    return-void
.end method
