.class public Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;
.super Ljava/lang/Object;
.source "LoggingSessionInputBuffer.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;
.implements Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final charset:Ljava/lang/String;

.field private final eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

.field private final in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

.field private final wire:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;Ljava/lang/String;)V
    .locals 1
    .param p1, "in"    # Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .param p2, "wire"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;
    .param p3, "charset"    # Ljava/lang/String;

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 67
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    .line 68
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    .end local p1    # "in":Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    :goto_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    .line 69
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->wire:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;

    .line 70
    if-eqz p3, :cond_1

    .end local p3    # "charset":Ljava/lang/String;
    :goto_1
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->charset:Ljava/lang/String;

    .line 71
    return-void

    .line 68
    .restart local p1    # "in":Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    .restart local p3    # "charset":Ljava/lang/String;
    :cond_0
    const/4 p1, 0x0

    goto :goto_0

    .line 70
    .end local p1    # "in":Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;
    :cond_1
    const-string p3, "ASCII"

    goto :goto_1
.end method


# virtual methods
.method public getMetrics()Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->getMetrics()Lcom/comcast/cim/httpcomponentsandroid/io/HttpTransportMetrics;

    move-result-object v0

    return-object v0
.end method

.method public isDataAvailable(I)Z
    .locals 1
    .param p1, "timeout"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 78
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-interface {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->isDataAvailable(I)Z

    move-result v0

    return v0
.end method

.method public isEof()Z
    .locals 1

    .prologue
    .line 130
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    if-eqz v0, :cond_0

    .line 131
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->eofSensor:Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/io/EofSensor;->isEof()Z

    move-result v0

    .line 133
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public read()I
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 90
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->read()I

    move-result v0

    .line 91
    .local v0, "l":I
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->wire:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;->enabled()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 92
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->wire:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;

    invoke-virtual {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;->input(I)V

    .line 94
    :cond_0
    return v0
.end method

.method public read([BII)I
    .locals 2
    .param p1, "b"    # [B
    .param p2, "off"    # I
    .param p3, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 82
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-interface {v1, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->read([BII)I

    move-result v0

    .line 83
    .local v0, "l":I
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->wire:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;

    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;->enabled()Z

    move-result v1

    if-eqz v1, :cond_0

    if-lez v0, :cond_0

    .line 84
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->wire:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;

    invoke-virtual {v1, p1, p2, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;->input([BII)V

    .line 86
    :cond_0
    return v0
.end method

.method public readLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)I
    .locals 6
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 115
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->in:Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;

    invoke-interface {v4, p1}, Lcom/comcast/cim/httpcomponentsandroid/io/SessionInputBuffer;->readLine(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)I

    move-result v0

    .line 116
    .local v0, "l":I
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->wire:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;

    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;->enabled()Z

    move-result v4

    if-eqz v4, :cond_0

    if-ltz v0, :cond_0

    .line 117
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v4

    sub-int v1, v4, v0

    .line 118
    .local v1, "pos":I
    new-instance v2, Ljava/lang/String;

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->buffer()[C

    move-result-object v4

    invoke-direct {v2, v4, v1, v0}, Ljava/lang/String;-><init>([CII)V

    .line 119
    .local v2, "s":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\r\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 120
    .local v3, "tmp":Ljava/lang/String;
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->wire:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;

    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/LoggingSessionInputBuffer;->charset:Ljava/lang/String;

    invoke-virtual {v3, v5}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/Wire;->input([B)V

    .line 122
    .end local v1    # "pos":I
    .end local v2    # "s":Ljava/lang/String;
    .end local v3    # "tmp":Ljava/lang/String;
    :cond_0
    return v0
.end method
