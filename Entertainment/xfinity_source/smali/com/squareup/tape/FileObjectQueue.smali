.class public Lcom/squareup/tape/FileObjectQueue;
.super Ljava/lang/Object;
.source "FileObjectQueue.java"

# interfaces
.implements Lcom/squareup/tape/ObjectQueue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;,
        Lcom/squareup/tape/FileObjectQueue$Converter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/squareup/tape/ObjectQueue",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final bytes:Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;

.field private final converter:Lcom/squareup/tape/FileObjectQueue$Converter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/squareup/tape/FileObjectQueue$Converter",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final file:Ljava/io/File;

.field private listener:Lcom/squareup/tape/ObjectQueue$Listener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/squareup/tape/ObjectQueue$Listener",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final queueFile:Lcom/squareup/tape/QueueFile;


# direct methods
.method public constructor <init>(Ljava/io/File;Lcom/squareup/tape/FileObjectQueue$Converter;)V
    .locals 1
    .param p1, "file"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/File;",
            "Lcom/squareup/tape/FileObjectQueue$Converter",
            "<TT;>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 32
    .local p0, "this":Lcom/squareup/tape/FileObjectQueue;, "Lcom/squareup/tape/FileObjectQueue<TT;>;"
    .local p2, "converter":Lcom/squareup/tape/FileObjectQueue$Converter;, "Lcom/squareup/tape/FileObjectQueue$Converter<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    new-instance v0, Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;

    invoke-direct {v0}, Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;-><init>()V

    iput-object v0, p0, Lcom/squareup/tape/FileObjectQueue;->bytes:Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;

    .line 33
    iput-object p1, p0, Lcom/squareup/tape/FileObjectQueue;->file:Ljava/io/File;

    .line 34
    iput-object p2, p0, Lcom/squareup/tape/FileObjectQueue;->converter:Lcom/squareup/tape/FileObjectQueue$Converter;

    .line 35
    new-instance v0, Lcom/squareup/tape/QueueFile;

    invoke-direct {v0, p1}, Lcom/squareup/tape/QueueFile;-><init>(Ljava/io/File;)V

    iput-object v0, p0, Lcom/squareup/tape/FileObjectQueue;->queueFile:Lcom/squareup/tape/QueueFile;

    .line 36
    return-void
.end method

.method static synthetic access$000(Lcom/squareup/tape/FileObjectQueue;)Lcom/squareup/tape/FileObjectQueue$Converter;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/tape/FileObjectQueue;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/squareup/tape/FileObjectQueue;->converter:Lcom/squareup/tape/FileObjectQueue$Converter;

    return-object v0
.end method


# virtual methods
.method public final add(Ljava/lang/Object;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 44
    .local p0, "this":Lcom/squareup/tape/FileObjectQueue;, "Lcom/squareup/tape/FileObjectQueue<TT;>;"
    .local p1, "entry":Ljava/lang/Object;, "TT;"
    :try_start_0
    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue;->bytes:Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;

    invoke-virtual {v1}, Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;->reset()V

    .line 45
    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue;->converter:Lcom/squareup/tape/FileObjectQueue$Converter;

    iget-object v2, p0, Lcom/squareup/tape/FileObjectQueue;->bytes:Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;

    invoke-interface {v1, p1, v2}, Lcom/squareup/tape/FileObjectQueue$Converter;->toStream(Ljava/lang/Object;Ljava/io/OutputStream;)V

    .line 46
    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue;->queueFile:Lcom/squareup/tape/QueueFile;

    iget-object v2, p0, Lcom/squareup/tape/FileObjectQueue;->bytes:Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;

    invoke-virtual {v2}, Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;->getArray()[B

    move-result-object v2

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/squareup/tape/FileObjectQueue;->bytes:Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;

    invoke-virtual {v4}, Lcom/squareup/tape/FileObjectQueue$DirectByteArrayOutputStream;->size()I

    move-result v4

    invoke-virtual {v1, v2, v3, v4}, Lcom/squareup/tape/QueueFile;->add([BII)V

    .line 47
    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue;->listener:Lcom/squareup/tape/ObjectQueue$Listener;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue;->listener:Lcom/squareup/tape/ObjectQueue$Listener;

    invoke-interface {v1, p0, p1}, Lcom/squareup/tape/ObjectQueue$Listener;->onAdd(Lcom/squareup/tape/ObjectQueue;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 51
    :cond_0
    return-void

    .line 48
    :catch_0
    move-exception v0

    .line 49
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/squareup/tape/FileException;

    const-string v2, "Failed to add entry."

    iget-object v3, p0, Lcom/squareup/tape/FileObjectQueue;->file:Ljava/io/File;

    invoke-direct {v1, v2, v0, v3}, Lcom/squareup/tape/FileException;-><init>(Ljava/lang/String;Ljava/io/IOException;Ljava/io/File;)V

    throw v1
.end method

.method public peek()Ljava/lang/Object;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 55
    .local p0, "this":Lcom/squareup/tape/FileObjectQueue;, "Lcom/squareup/tape/FileObjectQueue<TT;>;"
    :try_start_0
    iget-object v2, p0, Lcom/squareup/tape/FileObjectQueue;->queueFile:Lcom/squareup/tape/QueueFile;

    invoke-virtual {v2}, Lcom/squareup/tape/QueueFile;->peek()[B

    move-result-object v0

    .line 56
    .local v0, "bytes":[B
    if-nez v0, :cond_0

    const/4 v2, 0x0

    .line 57
    :goto_0
    return-object v2

    :cond_0
    iget-object v2, p0, Lcom/squareup/tape/FileObjectQueue;->converter:Lcom/squareup/tape/FileObjectQueue$Converter;

    invoke-interface {v2, v0}, Lcom/squareup/tape/FileObjectQueue$Converter;->from([B)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    goto :goto_0

    .line 58
    .end local v0    # "bytes":[B
    :catch_0
    move-exception v1

    .line 59
    .local v1, "e":Ljava/io/IOException;
    new-instance v2, Lcom/squareup/tape/FileException;

    const-string v3, "Failed to peek."

    iget-object v4, p0, Lcom/squareup/tape/FileObjectQueue;->file:Ljava/io/File;

    invoke-direct {v2, v3, v1, v4}, Lcom/squareup/tape/FileException;-><init>(Ljava/lang/String;Ljava/io/IOException;Ljava/io/File;)V

    throw v2
.end method

.method public final remove()V
    .locals 4

    .prologue
    .line 65
    .local p0, "this":Lcom/squareup/tape/FileObjectQueue;, "Lcom/squareup/tape/FileObjectQueue<TT;>;"
    :try_start_0
    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue;->queueFile:Lcom/squareup/tape/QueueFile;

    invoke-virtual {v1}, Lcom/squareup/tape/QueueFile;->remove()V

    .line 66
    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue;->listener:Lcom/squareup/tape/ObjectQueue$Listener;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue;->listener:Lcom/squareup/tape/ObjectQueue$Listener;

    invoke-interface {v1, p0}, Lcom/squareup/tape/ObjectQueue$Listener;->onRemove(Lcom/squareup/tape/ObjectQueue;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 70
    :cond_0
    return-void

    .line 67
    :catch_0
    move-exception v0

    .line 68
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/squareup/tape/FileException;

    const-string v2, "Failed to remove."

    iget-object v3, p0, Lcom/squareup/tape/FileObjectQueue;->file:Ljava/io/File;

    invoke-direct {v1, v2, v0, v3}, Lcom/squareup/tape/FileException;-><init>(Ljava/lang/String;Ljava/io/IOException;Ljava/io/File;)V

    throw v1
.end method

.method public setListener(Lcom/squareup/tape/ObjectQueue$Listener;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/squareup/tape/ObjectQueue$Listener",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 73
    .local p0, "this":Lcom/squareup/tape/FileObjectQueue;, "Lcom/squareup/tape/FileObjectQueue<TT;>;"
    .local p1, "listener":Lcom/squareup/tape/ObjectQueue$Listener;, "Lcom/squareup/tape/ObjectQueue$Listener<TT;>;"
    if-eqz p1, :cond_0

    .line 75
    :try_start_0
    iget-object v1, p0, Lcom/squareup/tape/FileObjectQueue;->queueFile:Lcom/squareup/tape/QueueFile;

    new-instance v2, Lcom/squareup/tape/FileObjectQueue$1;

    invoke-direct {v2, p0, p1}, Lcom/squareup/tape/FileObjectQueue$1;-><init>(Lcom/squareup/tape/FileObjectQueue;Lcom/squareup/tape/ObjectQueue$Listener;)V

    invoke-virtual {v1, v2}, Lcom/squareup/tape/QueueFile;->forEach(Lcom/squareup/tape/QueueFile$ElementReader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 88
    :cond_0
    iput-object p1, p0, Lcom/squareup/tape/FileObjectQueue;->listener:Lcom/squareup/tape/ObjectQueue$Listener;

    .line 89
    return-void

    .line 84
    :catch_0
    move-exception v0

    .line 85
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/squareup/tape/FileException;

    const-string v2, "Unable to iterate over QueueFile contents."

    iget-object v3, p0, Lcom/squareup/tape/FileObjectQueue;->file:Ljava/io/File;

    invoke-direct {v1, v2, v0, v3}, Lcom/squareup/tape/FileException;-><init>(Ljava/lang/String;Ljava/io/IOException;Ljava/io/File;)V

    throw v1
.end method

.method public size()I
    .locals 1

    .prologue
    .line 39
    .local p0, "this":Lcom/squareup/tape/FileObjectQueue;, "Lcom/squareup/tape/FileObjectQueue<TT;>;"
    iget-object v0, p0, Lcom/squareup/tape/FileObjectQueue;->queueFile:Lcom/squareup/tape/QueueFile;

    invoke-virtual {v0}, Lcom/squareup/tape/QueueFile;->size()I

    move-result v0

    return v0
.end method
