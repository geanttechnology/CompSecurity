.class public abstract Lcom/amazon/rio/j2me/client/trans/ServerConnection;
.super Ljava/lang/Object;
.source "ServerConnection.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/trans/IServiceConnection;


# instance fields
.field public final CANCELLED_STATE:Ljava/lang/Object;

.field public final CLOSED_STATE:Ljava/lang/Object;

.field public final EXECUTING_STATE:Ljava/lang/Object;

.field public final INVOKED_STATE:Ljava/lang/Object;

.field public final READY_STATE:Ljava/lang/Object;

.field private state:Ljava/lang/Object;

.field private final url:Ljava/lang/String;


# direct methods
.method protected constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    const-string/jumbo v0, "READY"

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->READY_STATE:Ljava/lang/Object;

    .line 15
    const-string/jumbo v0, "EXECUTING"

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->EXECUTING_STATE:Ljava/lang/Object;

    .line 16
    const-string/jumbo v0, "INVOKED"

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->INVOKED_STATE:Ljava/lang/Object;

    .line 17
    const-string/jumbo v0, "CLOSED"

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->CLOSED_STATE:Ljava/lang/Object;

    .line 18
    const-string/jumbo v0, "CANCELLED"

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->CANCELLED_STATE:Ljava/lang/Object;

    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->READY_STATE:Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;

    .line 23
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->url:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public declared-synchronized cancel()V
    .locals 2

    .prologue
    .line 120
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->CLOSED_STATE:Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v0, v1, :cond_0

    .line 126
    :goto_0
    monitor-exit p0

    return-void

    .line 124
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->releaseNetworkConnection()V

    .line 125
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->CANCELLED_STATE:Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 120
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized close()V
    .locals 2

    .prologue
    .line 102
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;

    iget-object v1, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->CLOSED_STATE:Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-ne v0, v1, :cond_0

    .line 110
    :goto_0
    monitor-exit p0

    return-void

    .line 108
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->releaseNetworkConnection()V

    .line 109
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->CLOSED_STATE:Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 102
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method protected abstract getInputStream()Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method protected abstract getOutputStream()Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->url:Ljava/lang/String;

    return-object v0
.end method

.method protected abstract initializeNetworkConnection(I)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method

.method protected abstract releaseNetworkConnection()V
.end method

.method public send([[B)Ljava/io/InputStream;
    .locals 7
    .param p1, "data"    # [[B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 50
    monitor-enter p0

    .line 51
    :try_start_0
    iget-object v4, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;

    iget-object v5, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->READY_STATE:Ljava/lang/Object;

    if-eq v4, v5, :cond_0

    .line 52
    new-instance v4, Ljava/io/IOException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "ServerConnection.send() bad state.  Expected state=\""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->READY_STATE:Ljava/lang/Object;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "\": "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 63
    :catchall_0
    move-exception v4

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4

    .line 55
    :cond_0
    :try_start_1
    iget-object v4, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->EXECUTING_STATE:Ljava/lang/Object;

    iput-object v4, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;

    .line 57
    const/4 v2, 0x0

    .line 58
    .local v2, "msgLength":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v4, p1

    if-ge v0, v4, :cond_1

    .line 59
    aget-object v4, p1, v0

    array-length v4, v4

    add-int/2addr v2, v4

    .line 58
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 62
    :cond_1
    invoke-virtual {p0, v2}, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->initializeNetworkConnection(I)V

    .line 63
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 65
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v3

    .line 68
    .local v3, "os":Ljava/io/OutputStream;
    const/4 v0, 0x0

    :goto_1
    array-length v4, p1

    if-ge v0, v4, :cond_3

    .line 69
    aget-object v4, p1, v0

    if-eqz v4, :cond_2

    aget-object v4, p1, v0

    array-length v4, v4

    if-lez v4, :cond_2

    .line 70
    aget-object v4, p1, v0

    invoke-virtual {v3, v4}, Ljava/io/OutputStream;->write([B)V

    .line 68
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 74
    :cond_3
    invoke-virtual {v3}, Ljava/io/OutputStream;->flush()V

    .line 76
    monitor-enter p0

    .line 77
    :try_start_2
    iget-object v4, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;

    iget-object v5, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->EXECUTING_STATE:Ljava/lang/Object;

    if-eq v4, v5, :cond_4

    .line 78
    new-instance v4, Ljava/io/IOException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "ServerConnection.send() bad state.  Expected state=\""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->EXECUTING_STATE:Ljava/lang/Object;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, "\": "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 82
    :catchall_1
    move-exception v4

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v4

    .line 81
    :cond_4
    :try_start_3
    iget-object v4, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->INVOKED_STATE:Ljava/lang/Object;

    iput-object v4, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;

    .line 82
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 84
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    .line 86
    .local v1, "is":Ljava/io/InputStream;
    return-object v1
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 31
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 32
    .local v0, "sb":Ljava/lang/StringBuffer;
    const/16 v1, 0x5b

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 33
    const-string/jumbo v1, "url="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->url:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 34
    const-string/jumbo v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    const-string/jumbo v2, "state="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/trans/ServerConnection;->state:Ljava/lang/Object;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 35
    const/16 v1, 0x5d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 37
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
