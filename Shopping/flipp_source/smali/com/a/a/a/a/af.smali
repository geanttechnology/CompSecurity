.class final Lcom/a/a/a/a/af;
.super Lcom/a/a/a/a/a;
.source "SourceFile"


# instance fields
.field private d:Z


# direct methods
.method constructor <init>(Ljava/io/InputStream;Ljava/net/CacheRequest;Lcom/a/a/a/a/h;)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0, p1, p3, p2}, Lcom/a/a/a/a/a;-><init>(Ljava/io/InputStream;Lcom/a/a/a/a/h;Ljava/net/CacheRequest;)V

    .line 31
    return-void
.end method


# virtual methods
.method public final available()I
    .locals 1

    .prologue
    .line 50
    invoke-virtual {p0}, Lcom/a/a/a/a/af;->a()V

    .line 51
    iget-object v0, p0, Lcom/a/a/a/a/af;->a:Ljava/io/InputStream;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/af;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->available()I

    move-result v0

    goto :goto_0
.end method

.method public final close()V
    .locals 1

    .prologue
    .line 55
    iget-boolean v0, p0, Lcom/a/a/a/a/af;->c:Z

    if-eqz v0, :cond_1

    .line 62
    :cond_0
    :goto_0
    return-void

    .line 58
    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/af;->c:Z

    .line 59
    iget-boolean v0, p0, Lcom/a/a/a/a/af;->d:Z

    if-nez v0, :cond_0

    .line 60
    invoke-virtual {p0}, Lcom/a/a/a/a/af;->c()V

    goto :goto_0
.end method

.method public final read([BII)I
    .locals 2

    .prologue
    const/4 v0, -0x1

    .line 34
    array-length v1, p1

    invoke-static {v1, p2, p3}, Lcom/a/a/a/u;->a(III)V

    .line 35
    invoke-virtual {p0}, Lcom/a/a/a/a/af;->a()V

    .line 36
    iget-object v1, p0, Lcom/a/a/a/a/af;->a:Ljava/io/InputStream;

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lcom/a/a/a/a/af;->d:Z

    if-eqz v1, :cond_1

    .line 46
    :cond_0
    :goto_0
    return v0

    .line 39
    :cond_1
    iget-object v1, p0, Lcom/a/a/a/a/af;->a:Ljava/io/InputStream;

    invoke-virtual {v1, p1, p2, p3}, Ljava/io/InputStream;->read([BII)I

    move-result v1

    .line 40
    if-ne v1, v0, :cond_2

    .line 41
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/a/a/a/a/af;->d:Z

    .line 42
    invoke-virtual {p0}, Lcom/a/a/a/a/af;->b()V

    goto :goto_0

    .line 45
    :cond_2
    invoke-virtual {p0, p1, p2, v1}, Lcom/a/a/a/a/af;->a([BII)V

    move v0, v1

    .line 46
    goto :goto_0
.end method
