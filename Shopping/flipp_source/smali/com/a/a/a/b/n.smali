.class final Lcom/a/a/a/b/n;
.super Ljava/io/InputStream;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/a/a/a/b/m;


# direct methods
.method constructor <init>(Lcom/a/a/a/b/m;)V
    .locals 0

    .prologue
    .line 247
    iput-object p1, p0, Lcom/a/a/a/b/n;->a:Lcom/a/a/a/b/m;

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    return-void
.end method


# virtual methods
.method public final close()V
    .locals 1

    .prologue
    .line 260
    iget-object v0, p0, Lcom/a/a/a/b/n;->a:Lcom/a/a/a/b/m;

    iget-object v0, v0, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v0}, Ljava/io/DataInputStream;->close()V

    .line 261
    return-void
.end method

.method public final read()I
    .locals 1

    .prologue
    .line 249
    invoke-static {p0}, Lcom/a/a/a/u;->a(Ljava/io/InputStream;)I

    move-result v0

    return v0
.end method

.method public final read([BII)I
    .locals 3

    .prologue
    .line 253
    iget-object v0, p0, Lcom/a/a/a/b/n;->a:Lcom/a/a/a/b/m;

    iget v0, v0, Lcom/a/a/a/b/m;->b:I

    invoke-static {p3, v0}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 254
    iget-object v1, p0, Lcom/a/a/a/b/n;->a:Lcom/a/a/a/b/m;

    iget-object v1, v1, Lcom/a/a/a/b/m;->a:Ljava/io/DataInputStream;

    invoke-virtual {v1, p1, p2, v0}, Ljava/io/DataInputStream;->read([BII)I

    move-result v0

    .line 255
    iget-object v1, p0, Lcom/a/a/a/b/n;->a:Lcom/a/a/a/b/m;

    iget v2, v1, Lcom/a/a/a/b/m;->b:I

    sub-int/2addr v2, v0

    iput v2, v1, Lcom/a/a/a/b/m;->b:I

    .line 256
    return v0
.end method
