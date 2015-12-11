.class public Lcom/amazon/retailsearch/log/AppLog;
.super Ljava/lang/Object;
.source "AppLog.java"


# static fields
.field public static final OFF:I = -0x1

.field private static appLog:Lcom/amazon/retailsearch/log/AppLog;


# instance fields
.field private volatile enabled:Z

.field private volatile level:I

.field private recorders:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/log/MessageRecorder;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 25
    const/4 v0, 0x0

    const/4 v1, -0x1

    invoke-direct {p0, v0, v1}, Lcom/amazon/retailsearch/log/AppLog;-><init>(ZI)V

    .line 26
    return-void
.end method

.method public constructor <init>(ZI)V
    .locals 1
    .param p1, "enabled"    # Z
    .param p2, "level"    # I

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/log/AppLog;->recorders:Ljava/util/List;

    .line 19
    iput-boolean p1, p0, Lcom/amazon/retailsearch/log/AppLog;->enabled:Z

    .line 20
    iput p2, p0, Lcom/amazon/retailsearch/log/AppLog;->level:I

    .line 21
    return-void
.end method

.method public static declared-synchronized getAppLog()Lcom/amazon/retailsearch/log/AppLog;
    .locals 2

    .prologue
    .line 90
    const-class v1, Lcom/amazon/retailsearch/log/AppLog;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/retailsearch/log/AppLog;->appLog:Lcom/amazon/retailsearch/log/AppLog;

    if-nez v0, :cond_0

    .line 92
    new-instance v0, Lcom/amazon/retailsearch/log/AppLog;

    invoke-direct {v0}, Lcom/amazon/retailsearch/log/AppLog;-><init>()V

    sput-object v0, Lcom/amazon/retailsearch/log/AppLog;->appLog:Lcom/amazon/retailsearch/log/AppLog;

    .line 95
    :cond_0
    sget-object v0, Lcom/amazon/retailsearch/log/AppLog;->appLog:Lcom/amazon/retailsearch/log/AppLog;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 90
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/retailsearch/log/MessageLogger;"
        }
    .end annotation

    .prologue
    .line 127
    .local p0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {}, Lcom/amazon/retailsearch/log/AppLog;->getAppLog()Lcom/amazon/retailsearch/log/AppLog;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/log/AppLog;->getLogFor(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    return-object v0
.end method

.method public static isEnabled()Z
    .locals 1

    .prologue
    .line 111
    invoke-static {}, Lcom/amazon/retailsearch/log/AppLog;->getAppLog()Lcom/amazon/retailsearch/log/AppLog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/log/AppLog;->enabled()Z

    move-result v0

    return v0
.end method

.method public static isEnabled(I)Z
    .locals 1
    .param p0, "level"    # I

    .prologue
    .line 119
    invoke-static {}, Lcom/amazon/retailsearch/log/AppLog;->getAppLog()Lcom/amazon/retailsearch/log/AppLog;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/retailsearch/log/AppLog;->enabled(I)Z

    move-result v0

    return v0
.end method

.method public static declared-synchronized setAppLog(Lcom/amazon/retailsearch/log/AppLog;)V
    .locals 2
    .param p0, "appLog"    # Lcom/amazon/retailsearch/log/AppLog;

    .prologue
    .line 103
    const-class v0, Lcom/amazon/retailsearch/log/AppLog;

    monitor-enter v0

    :try_start_0
    sput-object p0, Lcom/amazon/retailsearch/log/AppLog;->appLog:Lcom/amazon/retailsearch/log/AppLog;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 104
    monitor-exit v0

    return-void

    .line 103
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method


# virtual methods
.method public enabled()Z
    .locals 2

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/amazon/retailsearch/log/AppLog;->enabled:Z

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/amazon/retailsearch/log/AppLog;->level:I

    const/4 v1, -0x1

    if-le v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public enabled(I)Z
    .locals 1
    .param p1, "level"    # I

    .prologue
    .line 35
    invoke-virtual {p0}, Lcom/amazon/retailsearch/log/AppLog;->enabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/amazon/retailsearch/log/AppLog;->level:I

    if-lt p1, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLevel()I
    .locals 1

    .prologue
    .line 45
    iget v0, p0, Lcom/amazon/retailsearch/log/AppLog;->level:I

    return v0
.end method

.method public getLogFor(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/retailsearch/log/MessageLogger;"
        }
    .end annotation

    .prologue
    .line 66
    .local p1, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v0, Lcom/amazon/retailsearch/log/BoundMessageLogger;

    invoke-virtual {p1}, Ljava/lang/Class;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/log/BoundMessageLogger;-><init>(Lcom/amazon/retailsearch/log/AppLog;Ljava/lang/String;)V

    return-object v0
.end method

.method public getRecorders()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/log/MessageRecorder;",
            ">;"
        }
    .end annotation

    .prologue
    .line 55
    iget-object v0, p0, Lcom/amazon/retailsearch/log/AppLog;->recorders:Ljava/util/List;

    return-object v0
.end method

.method public log(Lcom/amazon/retailsearch/log/MessageLogger;ILjava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p1, "source"    # Lcom/amazon/retailsearch/log/MessageLogger;
    .param p2, "level"    # I
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 79
    iget-object v2, p0, Lcom/amazon/retailsearch/log/AppLog;->recorders:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/log/MessageRecorder;

    .line 81
    .local v1, "recorder":Lcom/amazon/retailsearch/log/MessageRecorder;
    invoke-interface {v1, p1, p2, p3, p4}, Lcom/amazon/retailsearch/log/MessageRecorder;->log(Lcom/amazon/retailsearch/log/MessageLogger;ILjava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 83
    .end local v1    # "recorder":Lcom/amazon/retailsearch/log/MessageRecorder;
    :cond_0
    return-void
.end method

.method public setEnabled(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 40
    iput-boolean p1, p0, Lcom/amazon/retailsearch/log/AppLog;->enabled:Z

    .line 41
    return-void
.end method

.method public setLevel(I)V
    .locals 0
    .param p1, "level"    # I

    .prologue
    .line 50
    iput p1, p0, Lcom/amazon/retailsearch/log/AppLog;->level:I

    .line 51
    return-void
.end method
