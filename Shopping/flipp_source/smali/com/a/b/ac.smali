.class public final Lcom/a/b/ac;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/b/s;


# instance fields
.field private final a:Lcom/a/a/r;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 41
    invoke-static {p1}, Lcom/a/b/ba;->b(Landroid/content/Context;)Ljava/io/File;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/a/b/ac;-><init>(Ljava/io/File;)V

    .line 42
    return-void
.end method

.method private constructor <init>(Lcom/a/a/r;)V
    .locals 0

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 84
    iput-object p1, p0, Lcom/a/b/ac;->a:Lcom/a/a/r;

    .line 85
    return-void
.end method

.method private constructor <init>(Ljava/io/File;)V
    .locals 2

    .prologue
    .line 51
    invoke-static {p1}, Lcom/a/b/ba;->a(Ljava/io/File;)J

    move-result-wide v0

    invoke-direct {p0, p1, v0, v1}, Lcom/a/b/ac;-><init>(Ljava/io/File;J)V

    .line 52
    return-void
.end method

.method private constructor <init>(Ljava/io/File;J)V
    .locals 2

    .prologue
    .line 72
    new-instance v0, Lcom/a/a/r;

    invoke-direct {v0}, Lcom/a/a/r;-><init>()V

    invoke-direct {p0, v0}, Lcom/a/b/ac;-><init>(Lcom/a/a/r;)V

    .line 74
    :try_start_0
    iget-object v0, p0, Lcom/a/b/ac;->a:Lcom/a/a/r;

    new-instance v1, Lcom/a/a/f;

    invoke-direct {v1, p1, p2, p3}, Lcom/a/a/f;-><init>(Ljava/io/File;J)V

    iput-object v1, v0, Lcom/a/a/r;->f:Ljava/net/ResponseCache;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 77
    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public final a(Landroid/net/Uri;Z)Lcom/a/b/t;
    .locals 4

    .prologue
    .line 99
    iget-object v0, p0, Lcom/a/b/ac;->a:Lcom/a/a/r;

    new-instance v1, Ljava/net/URL;

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/a/a/r;->a(Ljava/net/URL;)Ljava/net/HttpURLConnection;

    move-result-object v1

    const/16 v0, 0x3a98

    invoke-virtual {v1, v0}, Ljava/net/HttpURLConnection;->setConnectTimeout(I)V

    const/16 v0, 0x4e20

    invoke-virtual {v1, v0}, Ljava/net/HttpURLConnection;->setReadTimeout(I)V

    .line 100
    const/4 v0, 0x1

    invoke-virtual {v1, v0}, Ljava/net/HttpURLConnection;->setUseCaches(Z)V

    .line 101
    if-eqz p2, :cond_0

    .line 102
    const-string v0, "Cache-Control"

    const-string v2, "only-if-cached,max-age=2147483647"

    invoke-virtual {v1, v0, v2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    :cond_0
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v0

    .line 106
    const/16 v2, 0x12c

    if-lt v0, v2, :cond_1

    .line 107
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 108
    new-instance v2, Lcom/a/b/u;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/a/b/u;-><init>(Ljava/lang/String;)V

    throw v2

    .line 111
    :cond_1
    const-string v0, "OkHttp-Response-Source"

    invoke-virtual {v1, v0}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 112
    if-nez v0, :cond_2

    .line 113
    const-string v0, "X-Android-Response-Source"

    invoke-virtual {v1, v0}, Ljava/net/HttpURLConnection;->getHeaderField(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 115
    :cond_2
    invoke-static {v0}, Lcom/a/b/ba;->a(Ljava/lang/String;)Z

    move-result v0

    .line 117
    new-instance v2, Lcom/a/b/t;

    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v1

    invoke-direct {v2, v1, v0}, Lcom/a/b/t;-><init>(Ljava/io/InputStream;Z)V

    return-object v2
.end method
