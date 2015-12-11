.class public Lcom/poshmark/utils/FbDeferredDeepLinkManager;
.super Ljava/lang/Object;
.source "FbDeferredDeepLinkManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;,
        Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;
    }
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;


# instance fields
.field currentState:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

.field deepLinkInfo:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;

.field mutex:Ljava/lang/Object;

.field originalDeepLinkUrl:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    new-instance v0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    invoke-direct {v0}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;-><init>()V

    sput-object v0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/FbDeferredDeepLinkManager;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->mutex:Ljava/lang/Object;

    .line 23
    sget-object v0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;->INIT:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    iput-object v0, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    .line 29
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/utils/FbDeferredDeepLinkManager;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/utils/FbDeferredDeepLinkManager;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->extractDeepLinkInfo(Ljava/lang/String;)V

    return-void
.end method

.method private extractDeepLinkInfo(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 90
    if-eqz p1, :cond_0

    .line 91
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 92
    .local v1, "uri":Landroid/net/Uri;
    invoke-static {v1}, Lcom/poshmark/utils/DeepLinkUtils;->isValidDeepLink(Landroid/net/Uri;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 93
    const-string v2, "reg_screen_info"

    invoke-virtual {v1, v2}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 94
    .local v0, "json":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 95
    invoke-static {v0}, Lcom/poshmark/utils/DeepLinkUtils;->handleFbDeferredDeepLinkJSON(Ljava/lang/String;)Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->deepLinkInfo:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;

    .line 99
    .end local v0    # "json":Ljava/lang/String;
    .end local v1    # "uri":Landroid/net/Uri;
    :cond_0
    return-void
.end method


# virtual methods
.method public fetchFbDeferredDeepLink()V
    .locals 3

    .prologue
    .line 32
    iget-object v1, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 33
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    sget-object v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;->INIT:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    if-ne v0, v2, :cond_0

    .line 34
    sget-object v0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;->DL_REQUESTED:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    iput-object v0, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    .line 35
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v0

    new-instance v2, Lcom/poshmark/utils/FbDeferredDeepLinkManager$1;

    invoke-direct {v2, p0}, Lcom/poshmark/utils/FbDeferredDeepLinkManager$1;-><init>(Lcom/poshmark/utils/FbDeferredDeepLinkManager;)V

    invoke-static {v0, v2}, Lcom/facebook/applinks/AppLinkData;->fetchDeferredAppLinkData(Landroid/content/Context;Lcom/facebook/applinks/AppLinkData$CompletionHandler;)V

    .line 55
    :cond_0
    monitor-exit v1

    .line 56
    return-void

    .line 55
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getCurrentDeepLinkProcessingState()Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    return-object v0
.end method

.method public getDeepLinkUrl()Ljava/lang/String;
    .locals 6

    .prologue
    .line 73
    iget-object v4, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->mutex:Ljava/lang/Object;

    monitor-enter v4

    .line 74
    const/4 v2, 0x0

    .line 75
    .local v2, "json":Ljava/lang/String;
    :try_start_0
    iget-object v3, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->originalDeepLinkUrl:Ljava/lang/String;

    if-eqz v3, :cond_0

    .line 76
    new-instance v3, Lcom/google/gson/GsonBuilder;

    invoke-direct {v3}, Lcom/google/gson/GsonBuilder;-><init>()V

    invoke-virtual {v3}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 77
    .local v1, "gson":Lcom/google/gson/Gson;
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;

    invoke-direct {v0}, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;-><init>()V

    .line 78
    .local v0, "deepLink":Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;
    iget-object v3, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->originalDeepLinkUrl:Ljava/lang/String;

    iput-object v3, v0, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;->url:Ljava/lang/String;

    .line 79
    const-class v3, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;

    instance-of v5, v1, Lcom/google/gson/Gson;

    if-nez v5, :cond_1

    invoke-virtual {v1, v0, v3}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 81
    .end local v0    # "deepLink":Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;
    .end local v1    # "gson":Lcom/google/gson/Gson;
    :cond_0
    :goto_0
    monitor-exit v4

    return-object v2

    .line 79
    .restart local v0    # "deepLink":Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v0, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 82
    .end local v0    # "deepLink":Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 63
    iget-object v1, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 64
    :try_start_0
    iget-object v0, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->deepLinkInfo:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->deepLinkInfo:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;

    iget-object v0, v0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;->images:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 65
    iget-object v0, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->deepLinkInfo:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;

    iget-object v0, v0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DeferredDeepLinkInfo;->images:Ljava/util/List;

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    monitor-exit v1

    .line 67
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    .line 69
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public markAsExpired()V
    .locals 1

    .prologue
    .line 86
    sget-object v0, Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;->DL_EXPIRED:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    iput-object v0, p0, Lcom/poshmark/utils/FbDeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/FbDeferredDeepLinkManager$DL_STATE;

    .line 87
    return-void
.end method
