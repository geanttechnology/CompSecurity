.class Lcom/poshmark/utils/DeferredDeepLinkManager$1;
.super Ljava/lang/Object;
.source "DeferredDeepLinkManager.java"

# interfaces
.implements Lio/branch/referral/Branch$BranchReferralInitListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/DeferredDeepLinkManager;->init(Landroid/net/Uri;Landroid/app/Activity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/DeferredDeepLinkManager;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onInitFinished(Lorg/json/JSONObject;Lio/branch/referral/BranchError;)V
    .locals 7
    .param p1, "referringParams"    # Lorg/json/JSONObject;
    .param p2, "error"    # Lio/branch/referral/BranchError;

    .prologue
    .line 47
    if-nez p2, :cond_0

    .line 48
    iget-object v4, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    iget-object v4, v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->builder:Lcom/google/gson/GsonBuilder;

    invoke-virtual {v4}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 49
    .local v1, "gson":Lcom/google/gson/Gson;
    instance-of v4, p1, Lorg/json/JSONObject;

    if-nez v4, :cond_1

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    .line 50
    .end local p1    # "referringParams":Lorg/json/JSONObject;
    .local v2, "json":Ljava/lang/String;
    :goto_0
    iget-object v5, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    const-class v6, Lcom/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus;

    instance-of v4, v1, Lcom/google/gson/Gson;

    if-nez v4, :cond_2

    invoke-virtual {v1, v2, v6}, Lcom/google/gson/Gson;->fromJson(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    :goto_1
    check-cast v4, Lcom/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus;

    iput-object v4, v5, Lcom/poshmark/utils/DeferredDeepLinkManager;->status:Lcom/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus;

    .line 51
    iget-object v4, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    iget-object v4, v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    sget-object v5, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->INIT:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    if-ne v4, v5, :cond_0

    .line 52
    iget-object v4, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    iget-object v4, v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->status:Lcom/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus;

    iget-boolean v4, v4, Lcom/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus;->clicked_branch_link:Z

    if-eqz v4, :cond_3

    .line 53
    iget-object v4, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    sget-object v5, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_RECEIVED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    iput-object v5, v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    .line 54
    iget-object v4, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    iput-object v2, v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->branchDeepLinkJSON:Ljava/lang/String;

    .line 55
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 56
    .local v3, "trackingInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v4, "ev"

    const-string v5, "brhdl"

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    const-string v4, "s"

    const-string v5, "dlf"

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    const-string v4, "brparams"

    iget-object v5, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    iget-object v5, v5, Lcom/poshmark/utils/DeferredDeepLinkManager;->branchDeepLinkJSON:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    invoke-static {v3}, Lcom/poshmark/http/api/PMApi;->trackDeepLink(Ljava/util/HashMap;)V

    .line 74
    .end local v1    # "gson":Lcom/google/gson/Gson;
    .end local v2    # "json":Ljava/lang/String;
    .end local v3    # "trackingInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    :goto_2
    return-void

    .line 49
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    .restart local p1    # "referringParams":Lorg/json/JSONObject;
    :cond_1
    check-cast p1, Lorg/json/JSONObject;

    .end local p1    # "referringParams":Lorg/json/JSONObject;
    invoke-static {p1}, Lcom/newrelic/agent/android/instrumentation/JSONObjectInstrumentation;->toString(Lorg/json/JSONObject;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .restart local v2    # "json":Ljava/lang/String;
    :cond_2
    move-object v4, v1

    .line 50
    check-cast v4, Lcom/google/gson/Gson;

    invoke-static {v4, v2, v6}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->fromJson(Lcom/google/gson/Gson;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    goto :goto_1

    .line 61
    :cond_3
    iget-object v4, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    iget-object v4, v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->savedUri:Landroid/net/Uri;

    if-eqz v4, :cond_0

    .line 62
    iget-object v4, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    iget-object v5, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    iget-object v5, v5, Lcom/poshmark/utils/DeferredDeepLinkManager;->savedUri:Landroid/net/Uri;

    invoke-virtual {v5}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->originalDeepLinkUrl:Ljava/lang/String;

    .line 64
    iget-object v4, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    sget-object v5, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_RECEIVED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    iput-object v5, v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    .line 65
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;

    invoke-direct {v0}, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;-><init>()V

    .line 66
    .local v0, "deepLink":Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;
    iget-object v4, p0, Lcom/poshmark/utils/DeferredDeepLinkManager$1;->this$0:Lcom/poshmark/utils/DeferredDeepLinkManager;

    iget-object v4, v4, Lcom/poshmark/utils/DeferredDeepLinkManager;->originalDeepLinkUrl:Ljava/lang/String;

    iput-object v4, v0, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;->url:Ljava/lang/String;

    .line 67
    const-class v4, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;

    instance-of v5, v1, Lcom/google/gson/Gson;

    if-nez v5, :cond_4

    invoke-virtual {v1, v0, v4}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 68
    .end local v1    # "gson":Lcom/google/gson/Gson;
    :goto_3
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 69
    .restart local v3    # "trackingInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v4, "drct"

    invoke-virtual {v3, v4, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    invoke-static {v3}, Lcom/poshmark/http/api/PMApi;->trackDeepLink(Ljava/util/HashMap;)V

    goto :goto_2

    .line 67
    .end local v3    # "trackingInfo":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_4
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v0, v4}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    goto :goto_3
.end method
