.class public Lcom/amazon/ansel/fetch/tools/web/apache/apache40/DefaultApacheWebClientFactory;
.super Ljava/lang/Object;
.source "DefaultApacheWebClientFactory.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;


# instance fields
.field private webClient:Lcom/amazon/ansel/fetch/tools/web/WebClient;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public declared-synchronized getWebClient()Lcom/amazon/ansel/fetch/tools/web/WebClient;
    .locals 1

    .prologue
    .line 11
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/DefaultApacheWebClientFactory;->webClient:Lcom/amazon/ansel/fetch/tools/web/WebClient;

    if-nez v0, :cond_0

    .line 12
    new-instance v0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebClient;

    invoke-direct {v0}, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/ApacheWebClient;-><init>()V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/DefaultApacheWebClientFactory;->webClient:Lcom/amazon/ansel/fetch/tools/web/WebClient;

    .line 15
    :cond_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/DefaultApacheWebClientFactory;->webClient:Lcom/amazon/ansel/fetch/tools/web/WebClient;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 11
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
