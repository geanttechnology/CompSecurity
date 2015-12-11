.class public abstract Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;
.super Ljava/lang/Object;
.source "AuthenticatedUrlConnectionAdapter.java"

# interfaces
.implements Lcom/amazon/identity/auth/request/IRequestAdapter;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/net/HttpURLConnection;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/identity/auth/request/IRequestAdapter;"
    }
.end annotation


# instance fields
.field private final mUrlConnection:Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/net/HttpURLConnection;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 15
    .local p0, "this":Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;, "Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter<TT;>;"
    .local p1, "urlConnection":Ljava/net/HttpURLConnection;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object p1, p0, Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;->mUrlConnection:Ljava/net/HttpURLConnection;

    .line 17
    return-void
.end method


# virtual methods
.method public abstract getBody()[B
.end method

.method public getHeader(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 22
    .local p0, "this":Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;, "Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;->mUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1}, Ljava/net/HttpURLConnection;->getRequestProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHeaders()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 49
    .local p0, "this":Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;, "Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;->mUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestProperties()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method public getHttpVerb()Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    .local p0, "this":Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;, "Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;->mUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getRequestMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 34
    .local p0, "this":Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;, "Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;->mUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getURL()Ljava/net/URL;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method protected getUrlConnection()Ljava/net/HttpURLConnection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 54
    .local p0, "this":Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;, "Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;->mUrlConnection:Ljava/net/HttpURLConnection;

    return-object v0
.end method

.method public setHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 28
    .local p0, "this":Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;, "Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter<TT;>;"
    iget-object v0, p0, Lcom/amazon/identity/auth/request/AuthenticatedUrlConnectionAdapter;->mUrlConnection:Ljava/net/HttpURLConnection;

    invoke-virtual {v0, p1, p2}, Ljava/net/HttpURLConnection;->setRequestProperty(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    return-void
.end method
