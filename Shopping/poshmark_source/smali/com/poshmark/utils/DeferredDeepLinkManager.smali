.class public Lcom/poshmark/utils/DeferredDeepLinkManager;
.super Ljava/lang/Object;
.source "DeferredDeepLinkManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus;,
        Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;
    }
.end annotation


# static fields
.field public static final INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;


# instance fields
.field branchDeepLinkJSON:Ljava/lang/String;

.field builder:Lcom/google/gson/GsonBuilder;

.field currentState:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

.field mutex:Ljava/lang/Object;

.field originalDeepLinkUrl:Ljava/lang/String;

.field savedUri:Landroid/net/Uri;

.field status:Lcom/poshmark/utils/DeferredDeepLinkManager$BranchDeepLinkStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    new-instance v0, Lcom/poshmark/utils/DeferredDeepLinkManager;

    invoke-direct {v0}, Lcom/poshmark/utils/DeferredDeepLinkManager;-><init>()V

    sput-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager;->INSTANCE:Lcom/poshmark/utils/DeferredDeepLinkManager;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->mutex:Ljava/lang/Object;

    .line 26
    sget-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->INIT:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    iput-object v0, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    .line 35
    new-instance v0, Lcom/google/gson/GsonBuilder;

    invoke-direct {v0}, Lcom/google/gson/GsonBuilder;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->builder:Lcom/google/gson/GsonBuilder;

    .line 36
    return-void
.end method

.method private extractDeepLinkInfo(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 108
    return-void
.end method


# virtual methods
.method public getBranchDeepLinkJson()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->branchDeepLinkJSON:Ljava/lang/String;

    return-object v0
.end method

.method public getCurrentDeepLinkProcessingState()Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    return-object v0
.end method

.method public getDirectDeepLinkJson()Ljava/lang/String;
    .locals 5

    .prologue
    .line 88
    const/4 v2, 0x0

    .line 89
    .local v2, "json":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->originalDeepLinkUrl:Ljava/lang/String;

    if-eqz v3, :cond_0

    .line 91
    iget-object v3, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->builder:Lcom/google/gson/GsonBuilder;

    invoke-virtual {v3}, Lcom/google/gson/GsonBuilder;->create()Lcom/google/gson/Gson;

    move-result-object v1

    .line 92
    .local v1, "gson":Lcom/google/gson/Gson;
    new-instance v0, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;

    invoke-direct {v0}, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;-><init>()V

    .line 93
    .local v0, "deepLink":Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;
    iget-object v3, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->originalDeepLinkUrl:Ljava/lang/String;

    iput-object v3, v0, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;->url:Ljava/lang/String;

    .line 94
    const-class v3, Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;

    instance-of v4, v1, Lcom/google/gson/Gson;

    if-nez v4, :cond_1

    invoke-virtual {v1, v0, v3}, Lcom/google/gson/Gson;->toJson(Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    .line 96
    .end local v0    # "deepLink":Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;
    .end local v1    # "gson":Lcom/google/gson/Gson;
    :cond_0
    :goto_0
    return-object v2

    .line 94
    .restart local v0    # "deepLink":Lcom/poshmark/utils/DeepLinkUtils$DeepLinkWrapper;
    .restart local v1    # "gson":Lcom/google/gson/Gson;
    :cond_1
    check-cast v1, Lcom/google/gson/Gson;

    .end local v1    # "gson":Lcom/google/gson/Gson;
    invoke-static {v1, v0, v3}, Lcom/newrelic/agent/android/instrumentation/GsonInstrumentation;->toJson(Lcom/google/gson/Gson;Ljava/lang/Object;Ljava/lang/reflect/Type;)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public init(Landroid/net/Uri;Landroid/app/Activity;)V
    .locals 2
    .param p1, "data"    # Landroid/net/Uri;
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 39
    if-eqz p1, :cond_0

    .line 40
    iput-object p1, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->savedUri:Landroid/net/Uri;

    .line 43
    :cond_0
    invoke-static {}, Lio/branch/referral/Branch;->getInstance()Lio/branch/referral/Branch;

    move-result-object v0

    .line 44
    .local v0, "branch":Lio/branch/referral/Branch;
    new-instance v1, Lcom/poshmark/utils/DeferredDeepLinkManager$1;

    invoke-direct {v1, p0}, Lcom/poshmark/utils/DeferredDeepLinkManager$1;-><init>(Lcom/poshmark/utils/DeferredDeepLinkManager;)V

    invoke-virtual {v0, v1, p1, p2}, Lio/branch/referral/Branch;->initSession(Lio/branch/referral/Branch$BranchReferralInitListener;Landroid/net/Uri;Landroid/app/Activity;)Z

    .line 77
    return-void
.end method

.method public markAsExpired()V
    .locals 1

    .prologue
    .line 102
    sget-object v0, Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;->DL_EXPIRED:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    iput-object v0, p0, Lcom/poshmark/utils/DeferredDeepLinkManager;->currentState:Lcom/poshmark/utils/DeferredDeepLinkManager$DL_STATE;

    .line 103
    return-void
.end method
