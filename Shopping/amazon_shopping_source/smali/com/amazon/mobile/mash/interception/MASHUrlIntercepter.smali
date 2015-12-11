.class public Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;
.super Ljava/lang/Object;
.source "MASHUrlIntercepter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;

.field private static sShouldInterceptUrl:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;->TAG:Ljava/lang/String;

    .line 29
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;->sShouldInterceptUrl:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    return-void
.end method

.method public static declared-synchronized setShouldInterceptUrl(Z)V
    .locals 2
    .param p0, "value"    # Z

    .prologue
    .line 44
    const-class v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    monitor-enter v0

    :try_start_0
    sput-boolean p0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;->sShouldInterceptUrl:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 45
    monitor-exit v0

    return-void

    .line 44
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized shouldInterceptUrl()Z
    .locals 2

    .prologue
    .line 36
    const-class v0, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;

    monitor-enter v0

    :try_start_0
    sget-boolean v1, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;->sShouldInterceptUrl:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method


# virtual methods
.method public buildHandler(Ljava/lang/String;Landroid/content/Context;)Lcom/amazon/mobile/mash/interception/UrlInterceptionHandler;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 54
    const/4 v0, 0x0

    return-object v0
.end method

.method public getConfigEntryForUri(Landroid/net/Uri;)Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;
    .locals 7
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 64
    invoke-static {}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->getInstance()Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigManager;->getUrlConfigList()Ljava/util/ArrayList;

    move-result-object v2

    .line 68
    .local v2, "urlConfigList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;>;"
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/mobile/mash/util/MASHUtil;->removeEverythingAfterRefMarker(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 69
    .local v3, "urlToMatch":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 73
    .local v1, "configIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 74
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;

    .line 75
    .local v0, "configEntry":Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;
    invoke-virtual {v0, v3}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->matches(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 76
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 77
    sget-object v4, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Found entry for: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " Matched: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;->getDestination()Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter$UrlDestination;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 82
    .end local v0    # "configEntry":Lcom/amazon/mobile/mash/interception/UrlIntercepterConfigEntry;
    :cond_1
    :goto_0
    return-object v0

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
