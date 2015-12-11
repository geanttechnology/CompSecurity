.class public final Lcom/amazon/mobile/mash/MASHApplicationFactory;
.super Ljava/lang/Object;
.source "MASHApplicationFactory.java"


# static fields
.field private static sMASHApplication:Lcom/amazon/mobile/mash/MASHApplication;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static declared-synchronized getInstance()Lcom/amazon/mobile/mash/MASHApplication;
    .locals 2

    .prologue
    .line 36
    const-class v0, Lcom/amazon/mobile/mash/MASHApplicationFactory;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/amazon/mobile/mash/MASHApplicationFactory;->sMASHApplication:Lcom/amazon/mobile/mash/MASHApplication;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized setInstance(Lcom/amazon/mobile/mash/MASHApplication;)V
    .locals 2
    .param p0, "mashApplication"    # Lcom/amazon/mobile/mash/MASHApplication;

    .prologue
    .line 23
    const-class v1, Lcom/amazon/mobile/mash/MASHApplicationFactory;

    monitor-enter v1

    :try_start_0
    sput-object p0, Lcom/amazon/mobile/mash/MASHApplicationFactory;->sMASHApplication:Lcom/amazon/mobile/mash/MASHApplication;

    .line 24
    invoke-interface {p0}, Lcom/amazon/mobile/mash/MASHApplication;->isDebugEnabled()Z

    move-result v0

    invoke-static {v0}, Lcom/amazon/mobile/mash/util/MASHDebug;->setEnabled(Z)V

    .line 26
    invoke-interface {p0}, Lcom/amazon/mobile/mash/MASHApplication;->shouldInterceptUrls()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 27
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;->setShouldInterceptUrl(Z)V

    .line 28
    invoke-static {}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->init()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 30
    :cond_0
    monitor-exit v1

    return-void

    .line 23
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
