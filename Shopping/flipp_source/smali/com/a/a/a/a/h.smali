.class public Lcom/a/a/a/a/h;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final k:Ljava/net/CacheResponse;


# instance fields
.field protected final a:Lcom/a/a/a/a/u;

.field protected final b:Lcom/a/a/r;

.field protected final c:Ljava/lang/String;

.field protected d:Lcom/a/a/b;

.field protected e:Lcom/a/a/a/a/ac;

.field f:Ljava/net/CacheResponse;

.field g:J

.field public final h:Ljava/net/URI;

.field public final i:Lcom/a/a/a/a/x;

.field j:Lcom/a/a/a/a/z;

.field private l:Lcom/a/a/u;

.field private m:Ljava/io/OutputStream;

.field private n:Lcom/a/a/a/a/ae;

.field private o:Ljava/io/InputStream;

.field private p:Ljava/io/InputStream;

.field private q:Ljava/net/CacheRequest;

.field private r:Z

.field private s:Lcom/a/a/a/a/z;

.field private t:Ljava/io/InputStream;

.field private u:Z

.field private v:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 79
    new-instance v0, Lcom/a/a/a/a/i;

    invoke-direct {v0}, Lcom/a/a/a/a/i;-><init>()V

    sput-object v0, Lcom/a/a/a/a/h;->k:Ljava/net/CacheResponse;

    return-void
.end method

.method public constructor <init>(Lcom/a/a/r;Lcom/a/a/a/a/u;Ljava/lang/String;Lcom/a/a/a/a/v;Lcom/a/a/b;Lcom/a/a/a/a/ab;)V
    .locals 3

    .prologue
    .line 151
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 111
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/a/a/a/a/h;->g:J

    .line 152
    iput-object p1, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    .line 153
    iput-object p2, p0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    .line 154
    iput-object p3, p0, Lcom/a/a/a/a/h;->c:Ljava/lang/String;

    .line 155
    iput-object p5, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    .line 156
    iput-object p6, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    .line 159
    :try_start_0
    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    invoke-interface {p2}, Lcom/a/a/a/a/u;->getURL()Ljava/net/URL;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/m;->a(Ljava/net/URL;)Ljava/net/URI;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 164
    new-instance v0, Lcom/a/a/a/a/x;

    iget-object v1, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    new-instance v2, Lcom/a/a/a/a/v;

    invoke-direct {v2, p4}, Lcom/a/a/a/a/v;-><init>(Lcom/a/a/a/a/v;)V

    invoke-direct {v0, v1, v2}, Lcom/a/a/a/a/x;-><init>(Ljava/net/URI;Lcom/a/a/a/a/v;)V

    iput-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    .line 165
    return-void

    .line 160
    :catch_0
    move-exception v0

    .line 161
    new-instance v1, Ljava/io/IOException;

    invoke-virtual {v0}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static a(Ljava/net/URL;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 564
    invoke-virtual {p0}, Ljava/net/URL;->getFile()Ljava/lang/String;

    move-result-object v0

    .line 565
    if-nez v0, :cond_1

    .line 566
    const-string v0, "/"

    .line 570
    :cond_0
    :goto_0
    return-object v0

    .line 567
    :cond_1
    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 568
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "/"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private a(Lcom/a/a/a/a/z;Ljava/io/InputStream;)V
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/a/a/a/a/h;->p:Ljava/io/InputStream;

    if-eqz v0, :cond_0

    .line 326
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 328
    :cond_0
    iput-object p1, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    .line 329
    if-eqz p2, :cond_1

    .line 330
    invoke-direct {p0, p2}, Lcom/a/a/a/a/h;->a(Ljava/io/InputStream;)V

    .line 332
    :cond_1
    return-void
.end method

.method private a(Ljava/io/InputStream;)V
    .locals 2

    .prologue
    .line 450
    iput-object p1, p0, Lcom/a/a/a/a/h;->o:Ljava/io/InputStream;

    .line 451
    iget-boolean v0, p0, Lcom/a/a/a/a/h;->r:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    const-string v1, "gzip"

    iget-object v0, v0, Lcom/a/a/a/a/z;->r:Ljava/lang/String;

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 459
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/a/a/a/a/z;->r:Ljava/lang/String;

    iget-object v0, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    const-string v1, "Content-Encoding"

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    .line 460
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    const/4 v1, -0x1

    iput v1, v0, Lcom/a/a/a/a/z;->s:I

    iget-object v0, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    const-string v1, "Content-Length"

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    .line 461
    new-instance v0, Ljava/util/zip/GZIPInputStream;

    invoke-direct {v0, p1}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    iput-object v0, p0, Lcom/a/a/a/a/h;->p:Ljava/io/InputStream;

    .line 465
    :goto_0
    return-void

    .line 463
    :cond_0
    iput-object p1, p0, Lcom/a/a/a/a/h;->p:Ljava/io/InputStream;

    goto :goto_0
.end method

.method public static b(Ljava/net/URL;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 594
    invoke-virtual {p0}, Ljava/net/URL;->getPort()I

    move-result v1

    .line 595
    invoke-virtual {p0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v0

    .line 596
    if-lez v1, :cond_0

    invoke-virtual {p0}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/a/a/a/u;->a(Ljava/lang/String;)I

    move-result v2

    if-eq v1, v2, :cond_0

    .line 597
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ":"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 599
    :cond_0
    return-object v0
.end method

.method public static m()Ljava/lang/String;
    .locals 2

    .prologue
    .line 589
    const-string v0, "http.agent"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 590
    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "Java"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "java.version"

    invoke-static {v1}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private p()Ljava/lang/String;
    .locals 4

    .prologue
    .line 544
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget v0, v0, Lcom/a/a/b;->j:I

    if-eqz v0, :cond_1

    :cond_0
    const-string v0, "HTTP/1.1"

    .line 546
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/a/a/a/a/h;->c:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v1, p0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v1}, Lcom/a/a/a/a/u;->getURL()Ljava/net/URL;

    move-result-object v1

    invoke-virtual {p0}, Lcom/a/a/a/a/h;->l()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-virtual {v1}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_1
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 544
    :cond_1
    const-string v0, "HTTP/1.0"

    goto :goto_0

    .line 546
    :cond_2
    invoke-static {v1}, Lcom/a/a/a/a/h;->a(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method


# virtual methods
.method public final a()V
    .locals 14

    .prologue
    .line 177
    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    if-eqz v0, :cond_1

    .line 208
    :cond_0
    :goto_0
    return-void

    .line 181
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    invoke-direct {p0}, Lcom/a/a/a/a/h;->p()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;)V

    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->j:Ljava/lang/String;

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    invoke-static {}, Lcom/a/a/a/a/h;->m()Ljava/lang/String;

    move-result-object v1

    iget-object v2, v0, Lcom/a/a/a/a/x;->j:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "User-Agent"

    invoke-virtual {v2, v3}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    :cond_2
    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "User-Agent"

    invoke-virtual {v2, v3, v1}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, v0, Lcom/a/a/a/a/x;->j:Ljava/lang/String;

    :cond_3
    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->k:Ljava/lang/String;

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v1, p0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v1}, Lcom/a/a/a/a/u;->getURL()Ljava/net/URL;

    move-result-object v1

    invoke-static {v1}, Lcom/a/a/a/a/h;->b(Ljava/net/URL;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, v0, Lcom/a/a/a/a/x;->k:Ljava/lang/String;

    if-eqz v2, :cond_4

    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "Host"

    invoke-virtual {v2, v3}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    :cond_4
    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "Host"

    invoke-virtual {v2, v3, v1}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, v0, Lcom/a/a/a/a/x;->k:Ljava/lang/String;

    :cond_5
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget v0, v0, Lcom/a/a/b;->j:I

    if-eqz v0, :cond_8

    :cond_6
    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->l:Ljava/lang/String;

    if-nez v0, :cond_8

    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    const-string v1, "Keep-Alive"

    iget-object v2, v0, Lcom/a/a/a/a/x;->l:Ljava/lang/String;

    if-eqz v2, :cond_7

    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "Connection"

    invoke-virtual {v2, v3}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    :cond_7
    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "Connection"

    invoke-virtual {v2, v3, v1}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, v0, Lcom/a/a/a/a/x;->l:Ljava/lang/String;

    :cond_8
    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->m:Ljava/lang/String;

    if-nez v0, :cond_a

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/h;->r:Z

    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    const-string v1, "gzip"

    iget-object v2, v0, Lcom/a/a/a/a/x;->m:Ljava/lang/String;

    if-eqz v2, :cond_9

    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "Accept-Encoding"

    invoke-virtual {v2, v3}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    :cond_9
    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "Accept-Encoding"

    invoke-virtual {v2, v3, v1}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, v0, Lcom/a/a/a/a/x;->m:Ljava/lang/String;

    :cond_a
    invoke-virtual {p0}, Lcom/a/a/a/a/h;->c()Z

    move-result v0

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->n:Ljava/lang/String;

    if-nez v0, :cond_c

    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    const-string v1, "application/x-www-form-urlencoded"

    iget-object v2, v0, Lcom/a/a/a/a/x;->n:Ljava/lang/String;

    if-eqz v2, :cond_b

    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "Content-Type"

    invoke-virtual {v2, v3}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    :cond_b
    iget-object v2, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v3, "Content-Type"

    invoke-virtual {v2, v3, v1}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v1, v0, Lcom/a/a/a/a/x;->n:Ljava/lang/String;

    :cond_c
    iget-object v0, p0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v0}, Lcom/a/a/a/a/u;->getIfModifiedSince()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-eqz v2, :cond_d

    iget-object v2, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    new-instance v3, Ljava/util/Date;

    invoke-direct {v3, v0, v1}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v2, v3}, Lcom/a/a/a/a/x;->a(Ljava/util/Date;)V

    :cond_d
    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->e:Ljava/net/CookieHandler;

    if-eqz v0, :cond_e

    iget-object v1, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v2, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    iget-object v3, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v3, v3, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/a/a/a/a/v;->a(Z)Ljava/util/Map;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/net/CookieHandler;->get(Ljava/net/URI;Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/a/a/a/a/x;->a(Ljava/util/Map;)V

    .line 182
    :cond_e
    sget-object v0, Lcom/a/a/u;->c:Lcom/a/a/u;

    iput-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    iget-object v0, p0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v0}, Lcom/a/a/a/a/u;->getUseCaches()Z

    move-result v0

    if-eqz v0, :cond_10

    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    invoke-virtual {v0}, Lcom/a/a/r;->a()Lcom/a/a/t;

    move-result-object v0

    if-eqz v0, :cond_10

    iget-object v1, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    iget-object v2, p0, Lcom/a/a/a/a/h;->c:Ljava/lang/String;

    iget-object v3, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v3, v3, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Lcom/a/a/a/a/v;->a(Z)Ljava/util/Map;

    move-result-object v3

    invoke-interface {v0, v1, v2, v3}, Lcom/a/a/t;->a(Ljava/net/URI;Ljava/lang/String;Ljava/util/Map;)Ljava/net/CacheResponse;

    move-result-object v6

    if-eqz v6, :cond_10

    invoke-virtual {v6}, Ljava/net/CacheResponse;->getHeaders()Ljava/util/Map;

    move-result-object v0

    invoke-virtual {v6}, Ljava/net/CacheResponse;->getBody()Ljava/io/InputStream;

    move-result-object v1

    iput-object v1, p0, Lcom/a/a/a/a/h;->t:Ljava/io/InputStream;

    invoke-virtual {p0, v6}, Lcom/a/a/a/a/h;->a(Ljava/net/CacheResponse;)Z

    move-result v1

    if-eqz v1, :cond_f

    if-eqz v0, :cond_f

    iget-object v1, p0, Lcom/a/a/a/a/h;->t:Ljava/io/InputStream;

    if-nez v1, :cond_14

    :cond_f
    iget-object v0, p0, Lcom/a/a/a/a/h;->t:Ljava/io/InputStream;

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 183
    :cond_10
    :goto_1
    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    invoke-virtual {v0}, Lcom/a/a/r;->a()Lcom/a/a/t;

    move-result-object v0

    .line 184
    if-eqz v0, :cond_11

    .line 185
    iget-object v1, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    invoke-interface {v0, v1}, Lcom/a/a/t;->a(Lcom/a/a/u;)V

    .line 192
    :cond_11
    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-boolean v0, v0, Lcom/a/a/a/a/x;->f:Z

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    invoke-virtual {v0}, Lcom/a/a/u;->a()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 193
    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    sget-object v1, Lcom/a/a/u;->b:Lcom/a/a/u;

    if-ne v0, v1, :cond_12

    .line 194
    iget-object v0, p0, Lcom/a/a/a/a/h;->t:Ljava/io/InputStream;

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 196
    :cond_12
    sget-object v0, Lcom/a/a/u;->a:Lcom/a/a/u;

    iput-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    .line 197
    sget-object v0, Lcom/a/a/a/a/h;->k:Ljava/net/CacheResponse;

    iput-object v0, p0, Lcom/a/a/a/a/h;->f:Ljava/net/CacheResponse;

    .line 198
    iget-object v0, p0, Lcom/a/a/a/a/h;->f:Ljava/net/CacheResponse;

    invoke-virtual {v0}, Ljava/net/CacheResponse;->getHeaders()Ljava/util/Map;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/a/v;->a(Ljava/util/Map;)Lcom/a/a/a/a/v;

    move-result-object v0

    .line 199
    new-instance v1, Lcom/a/a/a/a/z;

    iget-object v2, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-direct {v1, v2, v0}, Lcom/a/a/a/a/z;-><init>(Ljava/net/URI;Lcom/a/a/a/a/v;)V

    iget-object v0, p0, Lcom/a/a/a/a/h;->f:Ljava/net/CacheResponse;

    invoke-virtual {v0}, Ljava/net/CacheResponse;->getBody()Ljava/io/InputStream;

    move-result-object v0

    invoke-direct {p0, v1, v0}, Lcom/a/a/a/a/h;->a(Lcom/a/a/a/a/z;Ljava/io/InputStream;)V

    .line 202
    :cond_13
    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    invoke-virtual {v0}, Lcom/a/a/u;->a()Z

    move-result v0

    if-eqz v0, :cond_43

    .line 203
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-nez v0, :cond_3f

    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-nez v0, :cond_3f

    iget-object v0, p0, Lcom/a/a/a/a/h;->e:Lcom/a/a/a/a/ac;

    if-nez v0, :cond_31

    iget-object v0, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-virtual {v0}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_2f

    new-instance v0, Ljava/net/UnknownHostException;

    iget-object v1, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-virtual {v1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/net/UnknownHostException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 182
    :cond_14
    invoke-static {v0}, Lcom/a/a/a/a/v;->a(Ljava/util/Map;)Lcom/a/a/a/a/v;

    move-result-object v0

    new-instance v1, Lcom/a/a/a/a/z;

    iget-object v2, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-direct {v1, v2, v0}, Lcom/a/a/a/a/z;-><init>(Ljava/net/URI;Lcom/a/a/a/a/v;)V

    iput-object v1, p0, Lcom/a/a/a/a/h;->s:Lcom/a/a/a/a/z;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-object v7, p0, Lcom/a/a/a/a/h;->s:Lcom/a/a/a/a/z;

    iget-object v8, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    invoke-virtual {v7, v8}, Lcom/a/a/a/a/z;->a(Lcom/a/a/a/a/x;)Z

    move-result v0

    if-eqz v0, :cond_2b

    iget-boolean v0, v8, Lcom/a/a/a/a/x;->b:Z

    if-nez v0, :cond_15

    invoke-virtual {v8}, Lcom/a/a/a/a/x;->a()Z

    move-result v0

    if-eqz v0, :cond_16

    :cond_15
    sget-object v0, Lcom/a/a/u;->c:Lcom/a/a/u;

    :goto_2
    iput-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    sget-object v1, Lcom/a/a/u;->a:Lcom/a/a/u;

    if-ne v0, v1, :cond_2c

    iput-object v6, p0, Lcom/a/a/a/a/h;->f:Ljava/net/CacheResponse;

    iget-object v0, p0, Lcom/a/a/a/a/h;->s:Lcom/a/a/a/a/z;

    iget-object v1, p0, Lcom/a/a/a/a/h;->t:Ljava/io/InputStream;

    invoke-direct {p0, v0, v1}, Lcom/a/a/a/a/h;->a(Lcom/a/a/a/a/z;Ljava/io/InputStream;)V

    goto/16 :goto_1

    :cond_16
    iget-object v0, v7, Lcom/a/a/a/a/z;->g:Ljava/util/Date;

    if-eqz v0, :cond_1e

    const-wide/16 v0, 0x0

    iget-wide v4, v7, Lcom/a/a/a/a/z;->k:J

    iget-object v9, v7, Lcom/a/a/a/a/z;->g:Ljava/util/Date;

    invoke-virtual {v9}, Ljava/util/Date;->getTime()J

    move-result-wide v10

    sub-long/2addr v4, v10

    invoke-static {v0, v1, v4, v5}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    :goto_3
    iget v4, v7, Lcom/a/a/a/a/z;->p:I

    const/4 v5, -0x1

    if-eq v4, v5, :cond_17

    sget-object v4, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    iget v5, v7, Lcom/a/a/a/a/z;->p:I

    int-to-long v10, v5

    invoke-virtual {v4, v10, v11}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v4

    invoke-static {v0, v1, v4, v5}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v0

    :cond_17
    iget-wide v4, v7, Lcom/a/a/a/a/z;->k:J

    iget-wide v10, v7, Lcom/a/a/a/a/z;->j:J

    sub-long/2addr v4, v10

    iget-wide v10, v7, Lcom/a/a/a/a/z;->k:J

    sub-long/2addr v2, v10

    add-long/2addr v0, v4

    add-long v10, v0, v2

    iget v0, v7, Lcom/a/a/a/a/z;->m:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_1f

    sget-object v0, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    iget v1, v7, Lcom/a/a/a/a/z;->m:I

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v0

    :cond_18
    :goto_4
    iget v2, v8, Lcom/a/a/a/a/x;->c:I

    const/4 v3, -0x1

    if-eq v2, v3, :cond_19

    sget-object v2, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    iget v3, v8, Lcom/a/a/a/a/x;->c:I

    int-to-long v4, v3

    invoke-virtual {v2, v4, v5}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v2

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    :cond_19
    const-wide/16 v2, 0x0

    iget v4, v8, Lcom/a/a/a/a/x;->e:I

    const/4 v5, -0x1

    if-eq v4, v5, :cond_1a

    sget-object v2, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    iget v3, v8, Lcom/a/a/a/a/x;->e:I

    int-to-long v4, v3

    invoke-virtual {v2, v4, v5}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v2

    :cond_1a
    const-wide/16 v4, 0x0

    iget-boolean v9, v7, Lcom/a/a/a/a/z;->n:Z

    if-nez v9, :cond_1b

    iget v9, v8, Lcom/a/a/a/a/x;->d:I

    const/4 v12, -0x1

    if-eq v9, v12, :cond_1b

    sget-object v4, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    iget v5, v8, Lcom/a/a/a/a/x;->d:I

    int-to-long v12, v5

    invoke-virtual {v4, v12, v13}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v4

    :cond_1b
    iget-boolean v9, v7, Lcom/a/a/a/a/z;->l:Z

    if-nez v9, :cond_26

    add-long v12, v10, v2

    add-long/2addr v4, v0

    cmp-long v4, v12, v4

    if-gez v4, :cond_26

    add-long/2addr v2, v10

    cmp-long v0, v2, v0

    if-ltz v0, :cond_1c

    iget-object v0, v7, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    const-string v1, "Warning"

    const-string v2, "110 HttpURLConnection \"Response is stale\""

    invoke-virtual {v0, v1, v2}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1c
    const-wide/32 v0, 0x5265c00

    cmp-long v0, v10, v0

    if-lez v0, :cond_1d

    iget v0, v7, Lcom/a/a/a/a/z;->m:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_25

    iget-object v0, v7, Lcom/a/a/a/a/z;->i:Ljava/util/Date;

    if-nez v0, :cond_25

    const/4 v0, 0x1

    :goto_5
    if-eqz v0, :cond_1d

    iget-object v0, v7, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    const-string v1, "Warning"

    const-string v2, "113 HttpURLConnection \"Heuristic expiration\""

    invoke-virtual {v0, v1, v2}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1d
    sget-object v0, Lcom/a/a/u;->a:Lcom/a/a/u;

    goto/16 :goto_2

    :cond_1e
    const-wide/16 v0, 0x0

    goto/16 :goto_3

    :cond_1f
    iget-object v0, v7, Lcom/a/a/a/a/z;->i:Ljava/util/Date;

    if-eqz v0, :cond_21

    iget-object v0, v7, Lcom/a/a/a/a/z;->g:Ljava/util/Date;

    if-eqz v0, :cond_20

    iget-object v0, v7, Lcom/a/a/a/a/z;->g:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    :goto_6
    iget-object v2, v7, Lcom/a/a/a/a/z;->i:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    sub-long v0, v2, v0

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-gtz v2, :cond_18

    const-wide/16 v0, 0x0

    goto/16 :goto_4

    :cond_20
    iget-wide v0, v7, Lcom/a/a/a/a/z;->k:J

    goto :goto_6

    :cond_21
    iget-object v0, v7, Lcom/a/a/a/a/z;->h:Ljava/util/Date;

    if-eqz v0, :cond_24

    iget-object v0, v7, Lcom/a/a/a/a/z;->e:Ljava/net/URI;

    invoke-virtual {v0}, Ljava/net/URI;->getRawQuery()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_24

    iget-object v0, v7, Lcom/a/a/a/a/z;->g:Ljava/util/Date;

    if-eqz v0, :cond_22

    iget-object v0, v7, Lcom/a/a/a/a/z;->g:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    :goto_7
    iget-object v2, v7, Lcom/a/a/a/a/z;->h:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/16 v2, 0x0

    cmp-long v2, v0, v2

    if-lez v2, :cond_23

    const-wide/16 v2, 0xa

    div-long/2addr v0, v2

    goto/16 :goto_4

    :cond_22
    iget-wide v0, v7, Lcom/a/a/a/a/z;->j:J

    goto :goto_7

    :cond_23
    const-wide/16 v0, 0x0

    goto/16 :goto_4

    :cond_24
    const-wide/16 v0, 0x0

    goto/16 :goto_4

    :cond_25
    const/4 v0, 0x0

    goto :goto_5

    :cond_26
    iget-object v0, v7, Lcom/a/a/a/a/z;->h:Ljava/util/Date;

    if-eqz v0, :cond_2a

    iget-object v0, v7, Lcom/a/a/a/a/z;->h:Ljava/util/Date;

    invoke-virtual {v8, v0}, Lcom/a/a/a/a/x;->a(Ljava/util/Date;)V

    :cond_27
    :goto_8
    iget-object v0, v7, Lcom/a/a/a/a/z;->o:Ljava/lang/String;

    if-eqz v0, :cond_29

    iget-object v0, v7, Lcom/a/a/a/a/z;->o:Ljava/lang/String;

    iget-object v1, v8, Lcom/a/a/a/a/x;->o:Ljava/lang/String;

    if-eqz v1, :cond_28

    iget-object v1, v8, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v2, "If-None-Match"

    invoke-virtual {v1, v2}, Lcom/a/a/a/a/v;->d(Ljava/lang/String;)V

    :cond_28
    iget-object v1, v8, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    const-string v2, "If-None-Match"

    invoke-virtual {v1, v2, v0}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    iput-object v0, v8, Lcom/a/a/a/a/x;->o:Ljava/lang/String;

    :cond_29
    invoke-virtual {v8}, Lcom/a/a/a/a/x;->a()Z

    move-result v0

    if-eqz v0, :cond_2b

    sget-object v0, Lcom/a/a/u;->b:Lcom/a/a/u;

    goto/16 :goto_2

    :cond_2a
    iget-object v0, v7, Lcom/a/a/a/a/z;->g:Ljava/util/Date;

    if-eqz v0, :cond_27

    iget-object v0, v7, Lcom/a/a/a/a/z;->g:Ljava/util/Date;

    invoke-virtual {v8, v0}, Lcom/a/a/a/a/x;->a(Ljava/util/Date;)V

    goto :goto_8

    :cond_2b
    sget-object v0, Lcom/a/a/u;->c:Lcom/a/a/u;

    goto/16 :goto_2

    :cond_2c
    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    sget-object v1, Lcom/a/a/u;->b:Lcom/a/a/u;

    if-ne v0, v1, :cond_2d

    iput-object v6, p0, Lcom/a/a/a/a/h;->f:Ljava/net/CacheResponse;

    goto/16 :goto_1

    :cond_2d
    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    sget-object v1, Lcom/a/a/u;->c:Lcom/a/a/u;

    if-ne v0, v1, :cond_2e

    iget-object v0, p0, Lcom/a/a/a/a/h;->t:Ljava/io/InputStream;

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    goto/16 :goto_1

    :cond_2e
    new-instance v0, Ljava/lang/AssertionError;

    invoke-direct {v0}, Ljava/lang/AssertionError;-><init>()V

    throw v0

    .line 203
    :cond_2f
    const/4 v3, 0x0

    const/4 v4, 0x0

    iget-object v0, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-virtual {v0}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    const-string v2, "https"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_30

    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v3, v0, Lcom/a/a/r;->g:Ljavax/net/ssl/SSLSocketFactory;

    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v4, v0, Lcom/a/a/r;->h:Ljavax/net/ssl/HostnameVerifier;

    :cond_30
    new-instance v0, Lcom/a/a/a;

    iget-object v2, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-static {v2}, Lcom/a/a/a/u;->a(Ljava/net/URI;)I

    move-result v2

    iget-object v5, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v5, v5, Lcom/a/a/r;->i:Lcom/a/a/o;

    iget-object v6, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v6, v6, Lcom/a/a/r;->b:Ljava/net/Proxy;

    iget-object v7, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v7, v7, Lcom/a/a/r;->c:Ljava/util/List;

    invoke-direct/range {v0 .. v7}, Lcom/a/a/a;-><init>(Ljava/lang/String;ILjavax/net/ssl/SSLSocketFactory;Ljavax/net/ssl/HostnameVerifier;Lcom/a/a/o;Ljava/net/Proxy;Ljava/util/List;)V

    new-instance v1, Lcom/a/a/a/a/ac;

    iget-object v3, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    iget-object v2, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v4, v2, Lcom/a/a/r;->d:Ljava/net/ProxySelector;

    iget-object v2, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v5, v2, Lcom/a/a/r;->j:Lcom/a/a/c;

    sget-object v6, Lcom/a/a/a/j;->a:Lcom/a/a/a/j;

    iget-object v2, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v7, v2, Lcom/a/a/r;->a:Lcom/a/a/w;

    move-object v2, v0

    invoke-direct/range {v1 .. v7}, Lcom/a/a/a/a/ac;-><init>(Lcom/a/a/a;Ljava/net/URI;Ljava/net/ProxySelector;Lcom/a/a/c;Lcom/a/a/a/j;Lcom/a/a/w;)V

    iput-object v1, p0, Lcom/a/a/a/a/h;->e:Lcom/a/a/a/a/ac;

    :cond_31
    iget-object v0, p0, Lcom/a/a/a/a/h;->e:Lcom/a/a/a/a/ac;

    iget-object v1, p0, Lcom/a/a/a/a/h;->c:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/ac;->a(Ljava/lang/String;)Lcom/a/a/b;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-boolean v0, v0, Lcom/a/a/b;->h:Z

    if-nez v0, :cond_3e

    iget-object v2, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget v1, v0, Lcom/a/a/r;->l:I

    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget v3, v0, Lcom/a/a/r;->m:I

    invoke-virtual {p0}, Lcom/a/a/a/a/h;->o()Lcom/a/a/x;

    move-result-object v4

    iget-boolean v0, v2, Lcom/a/a/b;->h:Z

    if-eqz v0, :cond_32

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "already connected"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_32
    const/4 v0, 0x1

    iput-boolean v0, v2, Lcom/a/a/b;->h:Z

    iget-object v0, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v0, v0, Lcom/a/a/v;->b:Ljava/net/Proxy;

    invoke-virtual {v0}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v0

    sget-object v5, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    if-eq v0, v5, :cond_35

    new-instance v0, Ljava/net/Socket;

    iget-object v5, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v5, v5, Lcom/a/a/v;->b:Ljava/net/Proxy;

    invoke-direct {v0, v5}, Ljava/net/Socket;-><init>(Ljava/net/Proxy;)V

    :goto_9
    iput-object v0, v2, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    move-result-object v0

    iget-object v5, v2, Lcom/a/a/b;->e:Ljava/net/Socket;

    iget-object v6, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v6, v6, Lcom/a/a/v;->c:Ljava/net/InetSocketAddress;

    invoke-virtual {v0, v5, v6, v1}, Lcom/a/a/a/m;->a(Ljava/net/Socket;Ljava/net/InetSocketAddress;I)V

    iget-object v0, v2, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0, v3}, Ljava/net/Socket;->setSoTimeout(I)V

    iget-object v0, v2, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getInputStream()Ljava/io/InputStream;

    move-result-object v0

    iput-object v0, v2, Lcom/a/a/b;->f:Ljava/io/InputStream;

    iget-object v0, v2, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0}, Ljava/net/Socket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v0

    iput-object v0, v2, Lcom/a/a/b;->g:Ljava/io/OutputStream;

    iget-object v0, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v0, v0, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v0, v0, Lcom/a/a/a;->d:Ljavax/net/ssl/SSLSocketFactory;

    if-eqz v0, :cond_3a

    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    move-result-object v3

    iget-object v0, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v0, v0, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v0, v0, Lcom/a/a/a;->d:Ljavax/net/ssl/SSLSocketFactory;

    if-eqz v0, :cond_36

    iget-object v0, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v0, v0, Lcom/a/a/v;->b:Ljava/net/Proxy;

    invoke-virtual {v0}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v0

    sget-object v1, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    if-ne v0, v1, :cond_36

    const/4 v0, 0x1

    :goto_a
    if-eqz v0, :cond_33

    invoke-virtual {v2, v4}, Lcom/a/a/b;->a(Lcom/a/a/x;)V

    :cond_33
    iget-object v0, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v0, v0, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v0, v0, Lcom/a/a/a;->d:Ljavax/net/ssl/SSLSocketFactory;

    iget-object v1, v2, Lcom/a/a/b;->e:Ljava/net/Socket;

    iget-object v4, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v4, v4, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v4, v4, Lcom/a/a/a;->b:Ljava/lang/String;

    iget-object v5, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v5, v5, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget v5, v5, Lcom/a/a/a;->c:I

    const/4 v6, 0x1

    invoke-virtual {v0, v1, v4, v5, v6}, Ljavax/net/ssl/SSLSocketFactory;->createSocket(Ljava/net/Socket;Ljava/lang/String;IZ)Ljava/net/Socket;

    move-result-object v0

    iput-object v0, v2, Lcom/a/a/b;->e:Ljava/net/Socket;

    iget-object v0, v2, Lcom/a/a/b;->e:Ljava/net/Socket;

    check-cast v0, Ljavax/net/ssl/SSLSocket;

    iget-object v1, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-boolean v1, v1, Lcom/a/a/v;->d:Z

    if-eqz v1, :cond_37

    iget-object v1, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v1, v1, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v1, v1, Lcom/a/a/a;->b:Ljava/lang/String;

    invoke-virtual {v3, v0, v1}, Lcom/a/a/a/m;->a(Ljavax/net/ssl/SSLSocket;Ljava/lang/String;)V

    :goto_b
    iget-object v1, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-boolean v1, v1, Lcom/a/a/v;->d:Z

    if-eqz v1, :cond_38

    iget-object v1, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v1, v1, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v1, v1, Lcom/a/a/a;->g:Ljava/util/List;

    const-string v4, "spdy/3"

    invoke-interface {v1, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_38

    const/4 v1, 0x1

    :goto_c
    if-eqz v1, :cond_34

    sget-object v4, Lcom/a/a/b;->a:[B

    invoke-virtual {v3, v0, v4}, Lcom/a/a/a/m;->a(Ljavax/net/ssl/SSLSocket;[B)V

    :cond_34
    invoke-virtual {v0}, Ljavax/net/ssl/SSLSocket;->startHandshake()V

    iget-object v4, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v4, v4, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v4, v4, Lcom/a/a/a;->e:Ljavax/net/ssl/HostnameVerifier;

    iget-object v5, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v5, v5, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v5, v5, Lcom/a/a/a;->b:Ljava/lang/String;

    invoke-virtual {v0}, Ljavax/net/ssl/SSLSocket;->getSession()Ljavax/net/ssl/SSLSession;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Ljavax/net/ssl/HostnameVerifier;->verify(Ljava/lang/String;Ljavax/net/ssl/SSLSession;)Z

    move-result v4

    if-nez v4, :cond_39

    new-instance v0, Ljava/io/IOException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "Hostname \'"

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v2, v2, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v2, v2, Lcom/a/a/a;->b:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\' was not verified"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_35
    new-instance v0, Ljava/net/Socket;

    invoke-direct {v0}, Ljava/net/Socket;-><init>()V

    goto/16 :goto_9

    :cond_36
    const/4 v0, 0x0

    goto/16 :goto_a

    :cond_37
    invoke-static {v0}, Lcom/a/a/a/m;->a(Ljavax/net/ssl/SSLSocket;)V

    goto :goto_b

    :cond_38
    const/4 v1, 0x0

    goto :goto_c

    :cond_39
    invoke-virtual {v0}, Ljavax/net/ssl/SSLSocket;->getOutputStream()Ljava/io/OutputStream;

    move-result-object v4

    iput-object v4, v2, Lcom/a/a/b;->g:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljavax/net/ssl/SSLSocket;->getInputStream()Ljava/io/InputStream;

    move-result-object v4

    iput-object v4, v2, Lcom/a/a/b;->f:Ljava/io/InputStream;

    if-eqz v1, :cond_3a

    invoke-virtual {v3, v0}, Lcom/a/a/a/m;->b(Ljavax/net/ssl/SSLSocket;)[B

    move-result-object v1

    if-eqz v1, :cond_3a

    sget-object v3, Lcom/a/a/b;->b:[B

    invoke-static {v1, v3}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v3

    if-eqz v3, :cond_40

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljavax/net/ssl/SSLSocket;->setSoTimeout(I)V

    new-instance v0, Lcom/a/a/a/b/u;

    iget-object v1, v2, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v1, v1, Lcom/a/a/v;->a:Lcom/a/a/a;

    iget-object v1, v1, Lcom/a/a/a;->b:Ljava/lang/String;

    iget-object v3, v2, Lcom/a/a/b;->f:Ljava/io/InputStream;

    iget-object v4, v2, Lcom/a/a/b;->g:Ljava/io/OutputStream;

    invoke-direct {v0, v1, v3, v4}, Lcom/a/a/a/b/u;-><init>(Ljava/lang/String;Ljava/io/InputStream;Ljava/io/OutputStream;)V

    new-instance v1, Lcom/a/a/a/b/q;

    const/4 v3, 0x0

    invoke-direct {v1, v0, v3}, Lcom/a/a/a/b/q;-><init>(Lcom/a/a/a/b/u;B)V

    iput-object v1, v2, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    iget-object v0, v2, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    iget-object v0, v0, Lcom/a/a/a/b/q;->d:Lcom/a/a/a/b/d;

    invoke-interface {v0}, Lcom/a/a/a/b/d;->a()V

    :cond_3a
    invoke-static {}, Lcom/a/a/a/m;->a()Lcom/a/a/a/m;

    move-result-object v0

    iget-object v1, v2, Lcom/a/a/b;->e:Ljava/net/Socket;

    invoke-virtual {v0, v1}, Lcom/a/a/a/m;->a(Ljava/net/Socket;)I

    move-result v0

    const/16 v1, 0x400

    if-ge v0, v1, :cond_3b

    const/16 v0, 0x400

    :cond_3b
    const/16 v1, 0x2000

    if-le v0, v1, :cond_3c

    const/16 v0, 0x2000

    :cond_3c
    new-instance v1, Ljava/io/BufferedInputStream;

    iget-object v3, v2, Lcom/a/a/b;->f:Ljava/io/InputStream;

    invoke-direct {v1, v3, v0}, Ljava/io/BufferedInputStream;-><init>(Ljava/io/InputStream;I)V

    iput-object v1, v2, Lcom/a/a/b;->f:Ljava/io/InputStream;

    new-instance v1, Ljava/io/BufferedOutputStream;

    iget-object v3, v2, Lcom/a/a/b;->g:Ljava/io/OutputStream;

    invoke-direct {v1, v3, v0}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V

    iput-object v1, v2, Lcom/a/a/b;->g:Ljava/io/OutputStream;

    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v1, v0, Lcom/a/a/r;->j:Lcom/a/a/c;

    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-object v2, v1, Lcom/a/a/c;->b:Ljava/util/concurrent/ExecutorService;

    iget-object v3, v1, Lcom/a/a/c;->c:Ljava/util/concurrent/Callable;

    invoke-interface {v2, v3}, Ljava/util/concurrent/ExecutorService;->submit(Ljava/util/concurrent/Callable;)Ljava/util/concurrent/Future;

    invoke-virtual {v0}, Lcom/a/a/b;->e()Z

    move-result v2

    if-eqz v2, :cond_3d

    invoke-virtual {v0}, Lcom/a/a/b;->a()Z

    move-result v2

    if-eqz v2, :cond_3d

    monitor-enter v1

    :try_start_0
    iget-object v2, v1, Lcom/a/a/c;->a:Ljava/util/LinkedList;

    invoke-virtual {v2, v0}, Ljava/util/LinkedList;->addFirst(Ljava/lang/Object;)V

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_3d
    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->a:Lcom/a/a/w;

    iget-object v1, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-object v1, v1, Lcom/a/a/b;->d:Lcom/a/a/v;

    invoke-virtual {v0, v1}, Lcom/a/a/w;->a(Lcom/a/a/v;)V

    :cond_3e
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    invoke-virtual {p0, v0}, Lcom/a/a/a/a/h;->a(Lcom/a/a/b;)V

    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-object v0, v0, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v0, v0, Lcom/a/a/v;->b:Ljava/net/Proxy;

    iget-object v1, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v1, v1, Lcom/a/a/r;->b:Ljava/net/Proxy;

    if-eq v0, v1, :cond_3f

    iget-object v0, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    iget-object v0, v0, Lcom/a/a/a/a/x;->a:Lcom/a/a/a/a/v;

    invoke-direct {p0}, Lcom/a/a/a/a/h;->p()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;)V

    :cond_3f
    iget-object v0, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    if-eqz v0, :cond_41

    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    :cond_40
    sget-object v0, Lcom/a/a/b;->c:[B

    invoke-static {v1, v0}, Ljava/util/Arrays;->equals([B[B)Z

    move-result v0

    if-nez v0, :cond_3a

    new-instance v0, Ljava/io/IOException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unexpected NPN transport "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v3, Ljava/lang/String;

    const-string v4, "ISO-8859-1"

    invoke-direct {v3, v1, v4}, Ljava/lang/String;-><init>([BLjava/lang/String;)V

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_41
    iget-object v1, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-object v0, v1, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    if-eqz v0, :cond_42

    new-instance v0, Lcom/a/a/a/a/ad;

    iget-object v1, v1, Lcom/a/a/b;->i:Lcom/a/a/a/b/q;

    invoke-direct {v0, p0, v1}, Lcom/a/a/a/a/ad;-><init>(Lcom/a/a/a/a/h;Lcom/a/a/a/b/q;)V

    :goto_d
    check-cast v0, Lcom/a/a/a/a/ae;

    iput-object v0, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    invoke-virtual {p0}, Lcom/a/a/a/a/h;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    invoke-interface {v0}, Lcom/a/a/a/a/ae;->a()Ljava/io/OutputStream;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    goto/16 :goto_0

    :cond_42
    new-instance v0, Lcom/a/a/a/a/j;

    iget-object v2, v1, Lcom/a/a/b;->g:Ljava/io/OutputStream;

    iget-object v1, v1, Lcom/a/a/b;->f:Ljava/io/InputStream;

    invoke-direct {v0, p0, v2, v1}, Lcom/a/a/a/a/j;-><init>(Lcom/a/a/a/a/h;Ljava/io/OutputStream;Ljava/io/InputStream;)V

    goto :goto_d

    .line 204
    :cond_43
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-eqz v0, :cond_0

    .line 205
    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->j:Lcom/a/a/c;

    iget-object v1, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    invoke-virtual {v0, v1}, Lcom/a/a/c;->a(Lcom/a/a/b;)V

    .line 206
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    goto/16 :goto_0
.end method

.method public final a(Lcom/a/a/a/a/v;)V
    .locals 3

    .prologue
    .line 667
    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->e:Ljava/net/CookieHandler;

    .line 668
    if-eqz v0, :cond_0

    .line 669
    iget-object v1, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    const/4 v2, 0x1

    invoke-virtual {p1, v2}, Lcom/a/a/a/a/v;->a(Z)Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/net/CookieHandler;->put(Ljava/net/URI;Ljava/util/Map;)V

    .line 671
    :cond_0
    return-void
.end method

.method protected a(Lcom/a/a/b;)V
    .locals 0

    .prologue
    .line 307
    return-void
.end method

.method public final a(Z)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 431
    iget-object v0, p0, Lcom/a/a/a/a/h;->p:Ljava/io/InputStream;

    iget-object v1, p0, Lcom/a/a/a/a/h;->t:Ljava/io/InputStream;

    if-ne v0, v1, :cond_0

    .line 432
    iget-object v0, p0, Lcom/a/a/a/a/h;->p:Ljava/io/InputStream;

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 435
    :cond_0
    iget-boolean v0, p0, Lcom/a/a/a/a/h;->v:Z

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-eqz v0, :cond_2

    .line 436
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/h;->v:Z

    .line 438
    iget-object v0, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    iget-object v1, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    iget-object v2, p0, Lcom/a/a/a/a/h;->o:Ljava/io/InputStream;

    invoke-interface {v0, p1, v1, v2}, Lcom/a/a/a/a/ae;->a(ZLjava/io/OutputStream;Ljava/io/InputStream;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 440
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 441
    iput-object v3, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    .line 447
    :cond_2
    :goto_0
    return-void

    .line 442
    :cond_3
    iget-boolean v0, p0, Lcom/a/a/a/a/h;->u:Z

    if-eqz v0, :cond_2

    .line 443
    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->j:Lcom/a/a/c;

    iget-object v1, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    invoke-virtual {v0, v1}, Lcom/a/a/c;->a(Lcom/a/a/b;)V

    .line 444
    iput-object v3, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    goto :goto_0
.end method

.method protected a(Ljava/net/CacheResponse;)Z
    .locals 1

    .prologue
    .line 389
    const/4 v0, 0x1

    return v0
.end method

.method public final b()V
    .locals 4

    .prologue
    .line 314
    iget-wide v0, p0, Lcom/a/a/a/a/h;->g:J

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    .line 315
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 317
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/a/a/a/a/h;->g:J

    .line 318
    return-void
.end method

.method final c()Z
    .locals 2

    .prologue
    .line 335
    iget-object v0, p0, Lcom/a/a/a/a/h;->c:Ljava/lang/String;

    const-string v1, "POST"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/a/h;->c:Ljava/lang/String;

    const-string v1, "PUT"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final d()Ljava/io/OutputStream;
    .locals 1

    .prologue
    .line 340
    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    if-nez v0, :cond_0

    .line 341
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 343
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    return-object v0
.end method

.method public final e()Z
    .locals 1

    .prologue
    .line 347
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final f()Lcom/a/a/a/a/z;
    .locals 1

    .prologue
    .line 355
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    if-nez v0, :cond_0

    .line 356
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 358
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    return-object v0
.end method

.method public final g()I
    .locals 1

    .prologue
    .line 362
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    if-nez v0, :cond_0

    .line 363
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 365
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget-object v0, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    iget v0, v0, Lcom/a/a/a/a/v;->d:I

    return v0
.end method

.method public final h()Ljava/io/InputStream;
    .locals 1

    .prologue
    .line 369
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    if-nez v0, :cond_0

    .line 370
    new-instance v0, Ljava/lang/IllegalStateException;

    invoke-direct {v0}, Ljava/lang/IllegalStateException;-><init>()V

    throw v0

    .line 372
    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/h;->p:Ljava/io/InputStream;

    return-object v0
.end method

.method public final i()Lcom/a/a/b;
    .locals 1

    .prologue
    .line 380
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    return-object v0
.end method

.method public final j()V
    .locals 2

    .prologue
    .line 417
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/a/a/h;->u:Z

    .line 418
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/a/a/a/a/h;->v:Z

    if-eqz v0, :cond_0

    .line 419
    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    iget-object v0, v0, Lcom/a/a/r;->j:Lcom/a/a/c;

    iget-object v1, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    invoke-virtual {v0, v1}, Lcom/a/a/c;->a(Lcom/a/a/b;)V

    .line 420
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    .line 422
    :cond_0
    return-void
.end method

.method public final k()Z
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 472
    iget-object v2, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget-object v2, v2, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    iget v2, v2, Lcom/a/a/a/a/v;->d:I

    .line 475
    iget-object v3, p0, Lcom/a/a/a/a/h;->c:Ljava/lang/String;

    const-string v4, "HEAD"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 492
    :cond_0
    :goto_0
    return v0

    .line 479
    :cond_1
    const/16 v3, 0x64

    if-lt v2, v3, :cond_2

    const/16 v3, 0xc8

    if-lt v2, v3, :cond_3

    :cond_2
    const/16 v3, 0xcc

    if-eq v2, v3, :cond_3

    const/16 v3, 0x130

    if-eq v2, v3, :cond_3

    move v0, v1

    .line 482
    goto :goto_0

    .line 488
    :cond_3
    iget-object v2, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget v2, v2, Lcom/a/a/a/a/z;->s:I

    const/4 v3, -0x1

    if-ne v2, v3, :cond_4

    iget-object v2, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    invoke-virtual {v2}, Lcom/a/a/a/a/z;->a()Z

    move-result v2

    if-eqz v2, :cond_0

    :cond_4
    move v0, v1

    .line 489
    goto :goto_0
.end method

.method protected l()Z
    .locals 2

    .prologue
    .line 583
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v0}, Lcom/a/a/a/a/u;->usingProxy()Z

    move-result v0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/a/a/a/a/h;->d:Lcom/a/a/b;

    iget-object v0, v0, Lcom/a/a/b;->d:Lcom/a/a/v;

    iget-object v0, v0, Lcom/a/a/v;->b:Ljava/net/Proxy;

    invoke-virtual {v0}, Ljava/net/Proxy;->type()Ljava/net/Proxy$Type;

    move-result-object v0

    sget-object v1, Ljava/net/Proxy$Type;->HTTP:Ljava/net/Proxy$Type;

    if-ne v0, v1, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final n()V
    .locals 9

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 607
    invoke-virtual {p0}, Lcom/a/a/a/a/h;->e()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 608
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget-object v1, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/z;->a(Lcom/a/a/u;)V

    .line 660
    :cond_0
    :goto_0
    return-void

    .line 612
    :cond_1
    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    if-nez v0, :cond_2

    .line 613
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "readResponse() without sendRequest()"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 616
    :cond_2
    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    invoke-virtual {v0}, Lcom/a/a/u;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 620
    iget-wide v4, p0, Lcom/a/a/a/a/h;->g:J

    const-wide/16 v6, -0x1

    cmp-long v0, v4, v6

    if-nez v0, :cond_4

    .line 621
    iget-object v0, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    instance-of v0, v0, Lcom/a/a/a/a/ab;

    if-eqz v0, :cond_3

    .line 622
    iget-object v0, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    check-cast v0, Lcom/a/a/a/a/ab;

    invoke-virtual {v0}, Lcom/a/a/a/a/ab;->b()I

    move-result v0

    .line 623
    iget-object v3, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    int-to-long v4, v0

    invoke-virtual {v3, v4, v5}, Lcom/a/a/a/a/x;->a(J)V

    .line 625
    :cond_3
    iget-object v0, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    invoke-interface {v0}, Lcom/a/a/a/a/ae;->c()V

    .line 628
    :cond_4
    iget-object v0, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    if-eqz v0, :cond_5

    .line 629
    iget-object v0, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    invoke-virtual {v0}, Ljava/io/OutputStream;->close()V

    .line 630
    iget-object v0, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    instance-of v0, v0, Lcom/a/a/a/a/ab;

    if-eqz v0, :cond_5

    .line 631
    iget-object v3, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    iget-object v0, p0, Lcom/a/a/a/a/h;->m:Ljava/io/OutputStream;

    check-cast v0, Lcom/a/a/a/a/ab;

    invoke-interface {v3, v0}, Lcom/a/a/a/a/ae;->a(Lcom/a/a/a/a/ab;)V

    .line 635
    :cond_5
    iget-object v0, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    invoke-interface {v0}, Lcom/a/a/a/a/ae;->b()V

    .line 637
    iget-object v0, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    invoke-interface {v0}, Lcom/a/a/a/a/ae;->d()Lcom/a/a/a/a/z;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    .line 638
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget-wide v4, p0, Lcom/a/a/a/a/h;->g:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    iput-wide v4, v0, Lcom/a/a/a/a/z;->j:J

    iget-object v3, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    sget-object v8, Lcom/a/a/a/a/z;->a:Ljava/lang/String;

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v8, v4}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    iput-wide v6, v0, Lcom/a/a/a/a/z;->k:J

    iget-object v0, v0, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    sget-object v3, Lcom/a/a/a/a/z;->b:Ljava/lang/String;

    invoke-static {v6, v7}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lcom/a/a/a/a/v;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 639
    iget-object v0, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget-object v3, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    invoke-virtual {v0, v3}, Lcom/a/a/a/a/z;->a(Lcom/a/a/u;)V

    .line 641
    iget-object v0, p0, Lcom/a/a/a/a/h;->l:Lcom/a/a/u;

    sget-object v3, Lcom/a/a/u;->b:Lcom/a/a/u;

    if-ne v0, v3, :cond_9

    .line 642
    iget-object v0, p0, Lcom/a/a/a/a/h;->s:Lcom/a/a/a/a/z;

    iget-object v3, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget-object v4, v3, Lcom/a/a/a/a/z;->f:Lcom/a/a/a/a/v;

    iget v4, v4, Lcom/a/a/a/a/v;->d:I

    const/16 v5, 0x130

    if-ne v4, v5, :cond_6

    move v0, v1

    :goto_1
    if-eqz v0, :cond_8

    .line 643
    invoke-virtual {p0, v2}, Lcom/a/a/a/a/h;->a(Z)V

    .line 644
    iget-object v0, p0, Lcom/a/a/a/a/h;->s:Lcom/a/a/a/a/z;

    iget-object v1, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    invoke-virtual {v0, v1}, Lcom/a/a/a/a/z;->a(Lcom/a/a/a/a/z;)Lcom/a/a/a/a/z;

    move-result-object v0

    .line 645
    iget-object v1, p0, Lcom/a/a/a/a/h;->t:Ljava/io/InputStream;

    invoke-direct {p0, v0, v1}, Lcom/a/a/a/a/h;->a(Lcom/a/a/a/a/z;Ljava/io/InputStream;)V

    .line 646
    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    invoke-virtual {v0}, Lcom/a/a/r;->a()Lcom/a/a/t;

    move-result-object v0

    .line 647
    invoke-interface {v0}, Lcom/a/a/t;->a()V

    .line 648
    iget-object v1, p0, Lcom/a/a/a/a/h;->f:Ljava/net/CacheResponse;

    iget-object v2, p0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v2}, Lcom/a/a/a/a/u;->a()Ljava/net/HttpURLConnection;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/a/a/t;->a(Ljava/net/CacheResponse;Ljava/net/HttpURLConnection;)V

    goto/16 :goto_0

    .line 642
    :cond_6
    iget-object v4, v0, Lcom/a/a/a/a/z;->h:Ljava/util/Date;

    if-eqz v4, :cond_7

    iget-object v4, v3, Lcom/a/a/a/a/z;->h:Ljava/util/Date;

    if-eqz v4, :cond_7

    iget-object v3, v3, Lcom/a/a/a/a/z;->h:Ljava/util/Date;

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    iget-object v0, v0, Lcom/a/a/a/a/z;->h:Ljava/util/Date;

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    cmp-long v0, v4, v6

    if-gez v0, :cond_7

    move v0, v1

    goto :goto_1

    :cond_7
    move v0, v2

    goto :goto_1

    .line 651
    :cond_8
    iget-object v0, p0, Lcom/a/a/a/a/h;->t:Ljava/io/InputStream;

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/io/Closeable;)V

    .line 655
    :cond_9
    invoke-virtual {p0}, Lcom/a/a/a/a/h;->k()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 656
    iget-object v0, p0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v0}, Lcom/a/a/a/a/u;->getUseCaches()Z

    move-result v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/a/a/a/a/h;->b:Lcom/a/a/r;

    invoke-virtual {v0}, Lcom/a/a/r;->a()Lcom/a/a/t;

    move-result-object v0

    if-eqz v0, :cond_a

    iget-object v1, p0, Lcom/a/a/a/a/h;->a:Lcom/a/a/a/a/u;

    invoke-interface {v1}, Lcom/a/a/a/a/u;->a()Ljava/net/HttpURLConnection;

    move-result-object v1

    iget-object v2, p0, Lcom/a/a/a/a/h;->j:Lcom/a/a/a/a/z;

    iget-object v3, p0, Lcom/a/a/a/a/h;->i:Lcom/a/a/a/a/x;

    invoke-virtual {v2, v3}, Lcom/a/a/a/a/z;->a(Lcom/a/a/a/a/x;)Z

    move-result v2

    if-nez v2, :cond_b

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-interface {v0, v1, v2}, Lcom/a/a/t;->a(Ljava/lang/String;Ljava/net/URI;)V

    .line 659
    :cond_a
    :goto_2
    iget-object v0, p0, Lcom/a/a/a/a/h;->n:Lcom/a/a/a/a/ae;

    iget-object v1, p0, Lcom/a/a/a/a/h;->q:Ljava/net/CacheRequest;

    invoke-interface {v0, v1}, Lcom/a/a/a/a/ae;->a(Ljava/net/CacheRequest;)Ljava/io/InputStream;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/a/a/a/a/h;->a(Ljava/io/InputStream;)V

    goto/16 :goto_0

    .line 656
    :cond_b
    iget-object v2, p0, Lcom/a/a/a/a/h;->h:Ljava/net/URI;

    invoke-interface {v0, v2, v1}, Lcom/a/a/t;->a(Ljava/net/URI;Ljava/net/URLConnection;)Ljava/net/CacheRequest;

    move-result-object v0

    iput-object v0, p0, Lcom/a/a/a/a/h;->q:Ljava/net/CacheRequest;

    goto :goto_2
.end method

.method protected o()Lcom/a/a/x;
    .locals 1

    .prologue
    .line 663
    const/4 v0, 0x0

    return-object v0
.end method
