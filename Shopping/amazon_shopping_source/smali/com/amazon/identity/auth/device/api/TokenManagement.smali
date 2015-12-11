.class public Lcom/amazon/identity/auth/device/api/TokenManagement;
.super Ljava/lang/Object;
.source "TokenManagement.java"


# static fields
.field public static final ERROR_INVALID_PARAMETER:I = 0x1

.field public static final KEY_ERROR_CODE:Ljava/lang/String; = "com.amazon.dcp.sso.ErrorCode"

.field public static final KEY_ERROR_MESSAGE:Ljava/lang/String; = "com.amazon.dcp.sso.ErrorMessage"

.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field public static final TAG:Ljava/lang/String;

.field public static final VALUE_KEY:Ljava/lang/String; = "value_key"


# instance fields
.field private final mContext:Landroid/content/Context;

.field private mTokenManagementImpl:Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 59
    const-class v0, Lcom/amazon/identity/auth/device/api/TokenManagement;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/TokenManagement;->TAG:Ljava/lang/String;

    .line 61
    const-class v0, Lcom/amazon/identity/auth/device/api/TokenManagement;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/TokenManagement;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 73
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/TokenManagement;->mContext:Landroid/content/Context;

    .line 74
    return-void
.end method

.method private declared-synchronized getTokenManagerDefinition()Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;
    .locals 2

    .prologue
    .line 240
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/TokenManagement;->mTokenManagementImpl:Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;

    if-nez v0, :cond_0

    .line 242
    new-instance v0, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/TokenManagement;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/token/CentralTokenManagementCommunication;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/TokenManagement;->mTokenManagementImpl:Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;

    .line 245
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/TokenManagement;->mTokenManagementImpl:Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 240
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public getCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 170
    const-string/jumbo v0, "TokenManagement:GetCookies"

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 171
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    sget-object v0, Lcom/amazon/identity/auth/device/api/TokenManagement;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v1, "getCookies"

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v6

    .line 172
    .local v6, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getTokenManagerDefinition()Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;

    move-result-object v0

    invoke-static {v5, v6, p4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-interface/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;->getCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    return-object v0
.end method

.method public getToken(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "token"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Landroid/os/Bundle;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 117
    const-string/jumbo v0, "TokenManagement:GetToken"

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 118
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    sget-object v0, Lcom/amazon/identity/auth/device/api/TokenManagement;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v1, "getToken"

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v6

    .line 119
    .local v6, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getTokenManagerDefinition()Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;

    move-result-object v0

    invoke-static {v5, v6, p4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-interface/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;->getToken(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    return-object v0
.end method

.method public getValue(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;J)Ljava/lang/String;
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "token"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "timeoutMs"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;,
            Ljava/lang/InterruptedException;,
            Ljava/util/concurrent/ExecutionException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 233
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getToken(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    .line 234
    sget-object v1, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v0, p4, p5, v1}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get(JLjava/util/concurrent/TimeUnit;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/Bundle;

    .line 235
    const-string/jumbo v1, "value_key"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public peekCookies(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")",
            "Lcom/amazon/identity/auth/device/api/MAPFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;"
        }
    .end annotation

    .prologue
    .line 201
    const-string/jumbo v0, "TokenManagement:PeekCookies"

    invoke-static {v0}, Lcom/amazon/identity/auth/device/framework/Tracer;->getNewTracer(Ljava/lang/String;)Lcom/amazon/identity/auth/device/framework/Tracer;

    move-result-object v5

    .line 202
    .local v5, "tracer":Lcom/amazon/identity/auth/device/framework/Tracer;
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 204
    sget-object v0, Lcom/amazon/identity/auth/device/api/TokenManagement;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Directed Id given was null. Cannot peek cookies for a deregistered device"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 206
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Directed Id given was null. Cannot peek cookies for a deregistered device"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 208
    :cond_0
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 209
    .local v3, "options":Landroid/os/Bundle;
    const-string/jumbo v0, "com.amazon.identity.auth.device.internal.cookiekeys.options.ignorefresh"

    const/4 v1, 0x1

    invoke-virtual {v3, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 210
    sget-object v0, Lcom/amazon/identity/auth/device/api/TokenManagement;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v1, "peekCookies"

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startVerboseTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v6

    .line 211
    .local v6, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getTokenManagerDefinition()Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;

    move-result-object v0

    invoke-static {v5, v6, p3}, Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/auth/device/framework/Tracer;Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    move-object v1, p1

    move-object v2, p2

    invoke-interface/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/TokenManagementDefinition;->getCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v0

    return-object v0
.end method
