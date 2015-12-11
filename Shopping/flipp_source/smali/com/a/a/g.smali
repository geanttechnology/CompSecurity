.class final Lcom/a/a/g;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/a/a/t;


# instance fields
.field final synthetic a:Lcom/a/a/f;


# direct methods
.method constructor <init>(Lcom/a/a/f;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/a/a/g;->a:Lcom/a/a/f;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Ljava/net/URI;Ljava/net/URLConnection;)Ljava/net/CacheRequest;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/a/a/g;->a:Lcom/a/a/f;

    invoke-virtual {v0, p1, p2}, Lcom/a/a/f;->put(Ljava/net/URI;Ljava/net/URLConnection;)Ljava/net/CacheRequest;

    move-result-object v0

    return-object v0
.end method

.method public final a(Ljava/net/URI;Ljava/lang/String;Ljava/util/Map;)Ljava/net/CacheResponse;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)",
            "Ljava/net/CacheResponse;"
        }
    .end annotation

    .prologue
    .line 149
    iget-object v0, p0, Lcom/a/a/g;->a:Lcom/a/a/f;

    invoke-virtual {v0, p1, p2, p3}, Lcom/a/a/f;->get(Ljava/net/URI;Ljava/lang/String;Ljava/util/Map;)Ljava/net/CacheResponse;

    move-result-object v0

    return-object v0
.end method

.method public final a()V
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/a/a/g;->a:Lcom/a/a/f;

    invoke-static {v0}, Lcom/a/a/f;->a(Lcom/a/a/f;)V

    .line 167
    return-void
.end method

.method public final a(Lcom/a/a/u;)V
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/a/a/g;->a:Lcom/a/a/f;

    invoke-static {v0, p1}, Lcom/a/a/f;->a(Lcom/a/a/f;Lcom/a/a/u;)V

    .line 171
    return-void
.end method

.method public final a(Ljava/lang/String;Ljava/net/URI;)V
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/a/a/g;->a:Lcom/a/a/f;

    invoke-static {v0, p1, p2}, Lcom/a/a/f;->a(Lcom/a/a/f;Ljava/lang/String;Ljava/net/URI;)Z

    .line 158
    return-void
.end method

.method public final a(Ljava/net/CacheResponse;Ljava/net/HttpURLConnection;)V
    .locals 0

    .prologue
    .line 162
    invoke-static {p1, p2}, Lcom/a/a/f;->a(Ljava/net/CacheResponse;Ljava/net/HttpURLConnection;)V

    .line 163
    return-void
.end method
