.class public final Lcom/a/a/a/a/s;
.super Lcom/a/a/a/a/o;
.source "SourceFile"


# instance fields
.field final synthetic d:Lcom/a/a/a/a/r;


# direct methods
.method private constructor <init>(Lcom/a/a/a/a/r;Ljava/net/URL;Lcom/a/a/r;)V
    .locals 0

    .prologue
    .line 346
    iput-object p1, p0, Lcom/a/a/a/a/s;->d:Lcom/a/a/a/a/r;

    .line 347
    invoke-direct {p0, p2, p3}, Lcom/a/a/a/a/o;-><init>(Ljava/net/URL;Lcom/a/a/r;)V

    .line 348
    return-void
.end method

.method synthetic constructor <init>(Lcom/a/a/a/a/r;Ljava/net/URL;Lcom/a/a/r;B)V
    .locals 0

    .prologue
    .line 345
    invoke-direct {p0, p1, p2, p3}, Lcom/a/a/a/a/s;-><init>(Lcom/a/a/a/a/r;Ljava/net/URL;Lcom/a/a/r;)V

    return-void
.end method


# virtual methods
.method public final a()Ljava/net/HttpURLConnection;
    .locals 1

    .prologue
    .line 351
    iget-object v0, p0, Lcom/a/a/a/a/s;->d:Lcom/a/a/a/a/r;

    return-object v0
.end method

.method public final e()Ljava/net/SecureCacheResponse;
    .locals 1

    .prologue
    .line 355
    iget-object v0, p0, Lcom/a/a/a/a/s;->c:Lcom/a/a/a/a/h;

    instance-of v0, v0, Lcom/a/a/a/a/q;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/a/a/a/a/s;->c:Lcom/a/a/a/a/h;

    iget-object v0, v0, Lcom/a/a/a/a/h;->f:Ljava/net/CacheResponse;

    check-cast v0, Ljava/net/SecureCacheResponse;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
