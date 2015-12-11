.class public Lcom/amazon/retailsearch/log/SearchLog;
.super Lcom/amazon/retailsearch/log/AbstractMessageRecorder;
.source "SearchLog.java"


# instance fields
.field private final delegate:Lcom/amazon/retailsearch/log/MessageRecorder;

.field private searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/log/AppLog;)V
    .locals 1
    .param p1, "appLog"    # Lcom/amazon/retailsearch/log/AppLog;

    .prologue
    .line 22
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/log/AbstractMessageRecorder;-><init>(Lcom/amazon/retailsearch/log/AppLog;)V

    .line 18
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/log/SearchLog;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 23
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 24
    new-instance v0, Lcom/amazon/retailsearch/log/AndroidLog;

    invoke-direct {v0, p1}, Lcom/amazon/retailsearch/log/AndroidLog;-><init>(Lcom/amazon/retailsearch/log/AppLog;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/log/SearchLog;->delegate:Lcom/amazon/retailsearch/log/MessageRecorder;

    .line 25
    return-void
.end method


# virtual methods
.method public log(Lcom/amazon/retailsearch/log/MessageLogger;ILjava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "source"    # Lcom/amazon/retailsearch/log/MessageLogger;
    .param p2, "level"    # I
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/retailsearch/log/SearchLog;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    if-eqz v0, :cond_0

    const/4 v0, 0x6

    if-lt p2, v0, :cond_0

    .line 34
    iget-object v0, p0, Lcom/amazon/retailsearch/log/SearchLog;->searchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-interface {v0, p3, p4}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 39
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/log/SearchLog;->delegate:Lcom/amazon/retailsearch/log/MessageRecorder;

    if-eqz v0, :cond_1

    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/DebugMode;->enabled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 41
    iget-object v0, p0, Lcom/amazon/retailsearch/log/SearchLog;->delegate:Lcom/amazon/retailsearch/log/MessageRecorder;

    invoke-interface {v0, p1, p2, p3, p4}, Lcom/amazon/retailsearch/log/MessageRecorder;->log(Lcom/amazon/retailsearch/log/MessageLogger;ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 43
    :cond_1
    return-void
.end method
