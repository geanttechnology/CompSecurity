.class final Lcom/a/a/a/g;
.super Ljava/io/FilterOutputStream;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/a/a/a/f;


# direct methods
.method private constructor <init>(Lcom/a/a/a/f;Ljava/io/OutputStream;)V
    .locals 0

    .prologue
    .line 833
    iput-object p1, p0, Lcom/a/a/a/g;->a:Lcom/a/a/a/f;

    .line 834
    invoke-direct {p0, p2}, Ljava/io/FilterOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 835
    return-void
.end method

.method synthetic constructor <init>(Lcom/a/a/a/f;Ljava/io/OutputStream;B)V
    .locals 0

    .prologue
    .line 832
    invoke-direct {p0, p1, p2}, Lcom/a/a/a/g;-><init>(Lcom/a/a/a/f;Ljava/io/OutputStream;)V

    return-void
.end method


# virtual methods
.method public final close()V
    .locals 2

    .prologue
    .line 855
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/g;->out:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 859
    :goto_0
    return-void

    .line 857
    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/a/a/a/g;->a:Lcom/a/a/a/f;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/a/a/a/f;->c:Z

    goto :goto_0
.end method

.method public final flush()V
    .locals 2

    .prologue
    .line 863
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/g;->out:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->flush()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 867
    :goto_0
    return-void

    .line 865
    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/a/a/a/g;->a:Lcom/a/a/a/f;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/a/a/a/f;->c:Z

    goto :goto_0
.end method

.method public final write(I)V
    .locals 2

    .prologue
    .line 839
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/g;->out:Ljava/io/OutputStream;

    invoke-virtual {v0, p1}, Ljava/io/OutputStream;->write(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 843
    :goto_0
    return-void

    .line 841
    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/a/a/a/g;->a:Lcom/a/a/a/f;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/a/a/a/f;->c:Z

    goto :goto_0
.end method

.method public final write([BII)V
    .locals 2

    .prologue
    .line 847
    :try_start_0
    iget-object v0, p0, Lcom/a/a/a/g;->out:Ljava/io/OutputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/OutputStream;->write([BII)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 851
    :goto_0
    return-void

    .line 849
    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/a/a/a/g;->a:Lcom/a/a/a/f;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/a/a/a/f;->c:Z

    goto :goto_0
.end method
