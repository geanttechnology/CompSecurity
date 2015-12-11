.class final Lbl$1;
.super Ljava/io/InputStream;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lbl;->a(Ljava/net/URLConnection;)Ljava/io/InputStream;
.end annotation


# instance fields
.field private synthetic a:Ljava/io/InputStream;

.field private synthetic b:Ljava/net/URLConnection;

.field private synthetic c:Lbl;


# direct methods
.method constructor <init>(Lbl;Ljava/io/InputStream;Ljava/net/URLConnection;)V
    .locals 0

    .prologue
    .line 224
    iput-object p1, p0, Lbl$1;->c:Lbl;

    iput-object p2, p0, Lbl$1;->a:Ljava/io/InputStream;

    iput-object p3, p0, Lbl$1;->b:Ljava/net/URLConnection;

    invoke-direct {p0}, Ljava/io/InputStream;-><init>()V

    return-void
.end method

.method private a(I)V
    .locals 4

    .prologue
    .line 268
    const/4 v0, -0x1

    if-ne p1, v0, :cond_0

    .line 269
    iget-object v0, p0, Lbl$1;->c:Lbl;

    iget-object v0, v0, Lbl;->a:Lbk;

    iget-object v1, p0, Lbl$1;->b:Ljava/net/URLConnection;

    invoke-virtual {v0, v1}, Lbk;->d(Ljava/net/URLConnection;)V

    .line 273
    :goto_0
    return-void

    .line 271
    :cond_0
    iget-object v0, p0, Lbl$1;->c:Lbl;

    iget-object v0, v0, Lbl;->a:Lbk;

    iget-object v1, p0, Lbl$1;->b:Ljava/net/URLConnection;

    int-to-long v2, p1

    invoke-static {v0, v1, v2, v3}, Lbk;->a(Lbk;Ljava/net/URLConnection;J)V

    goto :goto_0
.end method


# virtual methods
.method public final close()V
    .locals 2

    .prologue
    .line 263
    iget-object v0, p0, Lbl$1;->c:Lbl;

    iget-object v0, v0, Lbl;->a:Lbk;

    iget-object v1, p0, Lbl$1;->b:Ljava/net/URLConnection;

    invoke-virtual {v0, v1}, Lbk;->d(Ljava/net/URLConnection;)V

    .line 264
    iget-object v0, p0, Lbl$1;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->close()V

    .line 265
    return-void
.end method

.method public final read()I
    .locals 3

    .prologue
    .line 228
    :try_start_0
    iget-object v0, p0, Lbl$1;->a:Ljava/io/InputStream;

    invoke-virtual {v0}, Ljava/io/InputStream;->read()I

    move-result v0

    .line 229
    invoke-direct {p0, v0}, Lbl$1;->a(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 230
    return v0

    .line 231
    :catch_0
    move-exception v0

    .line 232
    iget-object v1, p0, Lbl$1;->c:Lbl;

    iget-object v1, v1, Lbl;->a:Lbk;

    iget-object v2, p0, Lbl$1;->b:Ljava/net/URLConnection;

    invoke-virtual {v1, v2, v0}, Lbk;->a(Ljava/net/URLConnection;Ljava/lang/Exception;)V

    .line 233
    throw v0
.end method

.method public final read([B)I
    .locals 3

    .prologue
    .line 240
    :try_start_0
    iget-object v0, p0, Lbl$1;->a:Ljava/io/InputStream;

    invoke-virtual {v0, p1}, Ljava/io/InputStream;->read([B)I

    move-result v0

    .line 241
    invoke-direct {p0, v0}, Lbl$1;->a(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 242
    return v0

    .line 243
    :catch_0
    move-exception v0

    .line 244
    iget-object v1, p0, Lbl$1;->c:Lbl;

    iget-object v1, v1, Lbl;->a:Lbk;

    iget-object v2, p0, Lbl$1;->b:Ljava/net/URLConnection;

    invoke-virtual {v1, v2, v0}, Lbk;->a(Ljava/net/URLConnection;Ljava/lang/Exception;)V

    .line 245
    throw v0
.end method

.method public final read([BII)I
    .locals 3

    .prologue
    .line 252
    :try_start_0
    iget-object v0, p0, Lbl$1;->a:Ljava/io/InputStream;

    invoke-virtual {v0, p1, p2, p3}, Ljava/io/InputStream;->read([BII)I

    move-result v0

    .line 253
    invoke-direct {p0, v0}, Lbl$1;->a(I)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 254
    return v0

    .line 255
    :catch_0
    move-exception v0

    .line 256
    iget-object v1, p0, Lbl$1;->c:Lbl;

    iget-object v1, v1, Lbl;->a:Lbk;

    iget-object v2, p0, Lbl$1;->b:Ljava/net/URLConnection;

    invoke-virtual {v1, v2, v0}, Lbk;->a(Ljava/net/URLConnection;Ljava/lang/Exception;)V

    .line 257
    throw v0
.end method
