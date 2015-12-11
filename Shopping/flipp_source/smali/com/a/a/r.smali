.class public final Lcom/a/a/r;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/net/URLStreamHandlerFactory;


# static fields
.field private static final n:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public final a:Lcom/a/a/w;

.field public b:Ljava/net/Proxy;

.field public c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public d:Ljava/net/ProxySelector;

.field public e:Ljava/net/CookieHandler;

.field public f:Ljava/net/ResponseCache;

.field public g:Ljavax/net/ssl/SSLSocketFactory;

.field public h:Ljavax/net/ssl/HostnameVerifier;

.field public i:Lcom/a/a/o;

.field public j:Lcom/a/a/c;

.field public k:Z

.field public l:I

.field public m:I

.field private final o:Lcom/a/a/e;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 42
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "spdy/3"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "http/1.1"

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/a/a/a/u;->a(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    sput-object v0, Lcom/a/a/r;->n:Ljava/util/List;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 60
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/r;->k:Z

    .line 61
    new-instance v0, Lcom/a/a/w;

    invoke-direct {v0}, Lcom/a/a/w;-><init>()V

    iput-object v0, p0, Lcom/a/a/r;->a:Lcom/a/a/w;

    .line 62
    new-instance v0, Lcom/a/a/e;

    invoke-direct {v0}, Lcom/a/a/e;-><init>()V

    iput-object v0, p0, Lcom/a/a/r;->o:Lcom/a/a/e;

    .line 63
    return-void
.end method

.method private constructor <init>(Lcom/a/a/r;)V
    .locals 1

    .prologue
    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/a/a/r;->k:Z

    .line 66
    iget-object v0, p1, Lcom/a/a/r;->a:Lcom/a/a/w;

    iput-object v0, p0, Lcom/a/a/r;->a:Lcom/a/a/w;

    .line 67
    iget-object v0, p1, Lcom/a/a/r;->o:Lcom/a/a/e;

    iput-object v0, p0, Lcom/a/a/r;->o:Lcom/a/a/e;

    .line 68
    return-void
.end method


# virtual methods
.method public final a()Lcom/a/a/t;
    .locals 2

    .prologue
    .line 183
    iget-object v0, p0, Lcom/a/a/r;->f:Ljava/net/ResponseCache;

    instance-of v0, v0, Lcom/a/a/f;

    if-eqz v0, :cond_0

    .line 184
    iget-object v0, p0, Lcom/a/a/r;->f:Ljava/net/ResponseCache;

    check-cast v0, Lcom/a/a/f;

    iget-object v0, v0, Lcom/a/a/f;->a:Lcom/a/a/t;

    .line 188
    :goto_0
    return-object v0

    .line 185
    :cond_0
    iget-object v0, p0, Lcom/a/a/r;->f:Ljava/net/ResponseCache;

    if-eqz v0, :cond_1

    .line 186
    new-instance v0, Lcom/a/a/a/a/t;

    iget-object v1, p0, Lcom/a/a/r;->f:Ljava/net/ResponseCache;

    invoke-direct {v0, v1}, Lcom/a/a/a/a/t;-><init>(Ljava/net/ResponseCache;)V

    goto :goto_0

    .line 188
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final a(Ljava/net/URL;)Ljava/net/HttpURLConnection;
    .locals 1

    .prologue
    .line 339
    iget-object v0, p0, Lcom/a/a/r;->b:Ljava/net/Proxy;

    invoke-virtual {p0, p1, v0}, Lcom/a/a/r;->a(Ljava/net/URL;Ljava/net/Proxy;)Ljava/net/HttpURLConnection;

    move-result-object v0

    return-object v0
.end method

.method final a(Ljava/net/URL;Ljava/net/Proxy;)Ljava/net/HttpURLConnection;
    .locals 4

    .prologue
    .line 343
    invoke-virtual {p1}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v1

    .line 344
    new-instance v2, Lcom/a/a/r;

    invoke-direct {v2, p0}, Lcom/a/a/r;-><init>(Lcom/a/a/r;)V

    iget-object v0, p0, Lcom/a/a/r;->b:Ljava/net/Proxy;

    iput-object v0, v2, Lcom/a/a/r;->b:Ljava/net/Proxy;

    iget-object v0, p0, Lcom/a/a/r;->d:Ljava/net/ProxySelector;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/r;->d:Ljava/net/ProxySelector;

    :goto_0
    iput-object v0, v2, Lcom/a/a/r;->d:Ljava/net/ProxySelector;

    iget-object v0, p0, Lcom/a/a/r;->e:Ljava/net/CookieHandler;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/a/a/r;->e:Ljava/net/CookieHandler;

    :goto_1
    iput-object v0, v2, Lcom/a/a/r;->e:Ljava/net/CookieHandler;

    iget-object v0, p0, Lcom/a/a/r;->f:Ljava/net/ResponseCache;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/a/a/r;->f:Ljava/net/ResponseCache;

    :goto_2
    iput-object v0, v2, Lcom/a/a/r;->f:Ljava/net/ResponseCache;

    iget-object v0, p0, Lcom/a/a/r;->g:Ljavax/net/ssl/SSLSocketFactory;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/a/a/r;->g:Ljavax/net/ssl/SSLSocketFactory;

    :goto_3
    iput-object v0, v2, Lcom/a/a/r;->g:Ljavax/net/ssl/SSLSocketFactory;

    iget-object v0, p0, Lcom/a/a/r;->h:Ljavax/net/ssl/HostnameVerifier;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/a/a/r;->h:Ljavax/net/ssl/HostnameVerifier;

    :goto_4
    iput-object v0, v2, Lcom/a/a/r;->h:Ljavax/net/ssl/HostnameVerifier;

    iget-object v0, p0, Lcom/a/a/r;->i:Lcom/a/a/o;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/a/a/r;->i:Lcom/a/a/o;

    :goto_5
    iput-object v0, v2, Lcom/a/a/r;->i:Lcom/a/a/o;

    iget-object v0, p0, Lcom/a/a/r;->j:Lcom/a/a/c;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/a/a/r;->j:Lcom/a/a/c;

    :goto_6
    iput-object v0, v2, Lcom/a/a/r;->j:Lcom/a/a/c;

    iget-boolean v0, p0, Lcom/a/a/r;->k:Z

    iput-boolean v0, v2, Lcom/a/a/r;->k:Z

    iget-object v0, p0, Lcom/a/a/r;->c:Ljava/util/List;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/a/a/r;->c:Ljava/util/List;

    :goto_7
    iput-object v0, v2, Lcom/a/a/r;->c:Ljava/util/List;

    iget v0, p0, Lcom/a/a/r;->l:I

    iput v0, v2, Lcom/a/a/r;->l:I

    iget v0, p0, Lcom/a/a/r;->m:I

    iput v0, v2, Lcom/a/a/r;->m:I

    .line 345
    iput-object p2, v2, Lcom/a/a/r;->b:Ljava/net/Proxy;

    .line 347
    const-string v0, "http"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    new-instance v0, Lcom/a/a/a/a/o;

    invoke-direct {v0, p1, v2}, Lcom/a/a/a/a/o;-><init>(Ljava/net/URL;Lcom/a/a/r;)V

    .line 348
    :goto_8
    return-object v0

    .line 344
    :cond_0
    invoke-static {}, Ljava/net/ProxySelector;->getDefault()Ljava/net/ProxySelector;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-static {}, Ljava/net/CookieHandler;->getDefault()Ljava/net/CookieHandler;

    move-result-object v0

    goto :goto_1

    :cond_2
    invoke-static {}, Ljava/net/ResponseCache;->getDefault()Ljava/net/ResponseCache;

    move-result-object v0

    goto :goto_2

    :cond_3
    invoke-static {}, Ljavax/net/ssl/HttpsURLConnection;->getDefaultSSLSocketFactory()Ljavax/net/ssl/SSLSocketFactory;

    move-result-object v0

    goto :goto_3

    :cond_4
    sget-object v0, Lcom/a/a/a/c/b;->a:Lcom/a/a/a/c/b;

    goto :goto_4

    :cond_5
    sget-object v0, Lcom/a/a/a/a/d;->a:Lcom/a/a/o;

    goto :goto_5

    :cond_6
    invoke-static {}, Lcom/a/a/c;->a()Lcom/a/a/c;

    move-result-object v0

    goto :goto_6

    :cond_7
    sget-object v0, Lcom/a/a/r;->n:Ljava/util/List;

    goto :goto_7

    .line 348
    :cond_8
    const-string v0, "https"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    new-instance v0, Lcom/a/a/a/a/r;

    invoke-direct {v0, p1, v2}, Lcom/a/a/a/a/r;-><init>(Ljava/net/URL;Lcom/a/a/r;)V

    goto :goto_8

    .line 349
    :cond_9
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Unexpected protocol: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public final createURLStreamHandler(Ljava/lang/String;)Ljava/net/URLStreamHandler;
    .locals 1

    .prologue
    .line 390
    const-string v0, "http"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "https"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    .line 392
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/a/a/s;

    invoke-direct {v0, p0, p1}, Lcom/a/a/s;-><init>(Lcom/a/a/r;Ljava/lang/String;)V

    goto :goto_0
.end method
