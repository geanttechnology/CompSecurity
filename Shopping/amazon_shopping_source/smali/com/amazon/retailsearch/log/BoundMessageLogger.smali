.class public Lcom/amazon/retailsearch/log/BoundMessageLogger;
.super Ljava/lang/Object;
.source "BoundMessageLogger.java"

# interfaces
.implements Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private final appLog:Lcom/amazon/retailsearch/log/AppLog;

.field private final tag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/log/AppLog;Ljava/lang/String;)V
    .locals 0
    .param p1, "appLog"    # Lcom/amazon/retailsearch/log/AppLog;
    .param p2, "tag"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/amazon/retailsearch/log/BoundMessageLogger;->appLog:Lcom/amazon/retailsearch/log/AppLog;

    .line 16
    iput-object p2, p0, Lcom/amazon/retailsearch/log/BoundMessageLogger;->tag:Ljava/lang/String;

    .line 17
    return-void
.end method


# virtual methods
.method public debug(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 56
    const/4 v0, 0x3

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;)V

    .line 57
    return-void
.end method

.method public debug(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 62
    const/4 v0, 0x3

    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 63
    return-void
.end method

.method public enabled()Z
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/retailsearch/log/BoundMessageLogger;->appLog:Lcom/amazon/retailsearch/log/AppLog;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/log/AppLog;->enabled()Z

    move-result v0

    return v0
.end method

.method public enabled(I)Z
    .locals 1
    .param p1, "level"    # I

    .prologue
    .line 38
    iget-object v0, p0, Lcom/amazon/retailsearch/log/BoundMessageLogger;->appLog:Lcom/amazon/retailsearch/log/AppLog;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/log/AppLog;->enabled(I)Z

    move-result v0

    return v0
.end method

.method public error(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 92
    const/4 v0, 0x6

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;)V

    .line 93
    return-void
.end method

.method public error(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 98
    const/4 v0, 0x6

    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 99
    return-void
.end method

.method public getAppLog()Lcom/amazon/retailsearch/log/AppLog;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/retailsearch/log/BoundMessageLogger;->appLog:Lcom/amazon/retailsearch/log/AppLog;

    return-object v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/retailsearch/log/BoundMessageLogger;->tag:Ljava/lang/String;

    return-object v0
.end method

.method public info(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 68
    const/4 v0, 0x4

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;)V

    .line 69
    return-void
.end method

.method public info(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 74
    const/4 v0, 0x4

    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 75
    return-void
.end method

.method public log(ILjava/lang/String;)V
    .locals 1
    .param p1, "level"    # I
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 104
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 105
    return-void
.end method

.method public log(ILjava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "level"    # I
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/retailsearch/log/BoundMessageLogger;->appLog:Lcom/amazon/retailsearch/log/AppLog;

    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/amazon/retailsearch/log/AppLog;->log(Lcom/amazon/retailsearch/log/MessageLogger;ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 111
    return-void
.end method

.method public verbose(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 44
    const/4 v0, 0x2

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;)V

    .line 45
    return-void
.end method

.method public verbose(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 50
    const/4 v0, 0x2

    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 51
    return-void
.end method

.method public warn(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 80
    const/4 v0, 0x5

    invoke-virtual {p0, v0, p1}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;)V

    .line 81
    return-void
.end method

.method public warn(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 86
    const/4 v0, 0x5

    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/retailsearch/log/BoundMessageLogger;->log(ILjava/lang/String;Ljava/lang/Throwable;)V

    .line 87
    return-void
.end method
