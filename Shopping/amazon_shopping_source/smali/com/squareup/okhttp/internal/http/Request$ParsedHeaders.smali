.class Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;
.super Ljava/lang/Object;
.source "Request.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/squareup/okhttp/internal/http/Request;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ParsedHeaders"
.end annotation


# instance fields
.field private proxyAuthorization:Ljava/lang/String;

.field private userAgent:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/squareup/okhttp/internal/http/Headers;)V
    .locals 4
    .param p1, "headers"    # Lcom/squareup/okhttp/internal/http/Headers;

    .prologue
    .line 137
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 138
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Headers;->size()I

    move-result v3

    if-ge v1, v3, :cond_2

    .line 139
    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;

    move-result-object v0

    .line 140
    .local v0, "fieldName":Ljava/lang/String;
    invoke-virtual {p1, v1}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;

    move-result-object v2

    .line 141
    .local v2, "value":Ljava/lang/String;
    const-string/jumbo v3, "User-Agent"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 142
    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;->userAgent:Ljava/lang/String;

    .line 138
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 143
    :cond_1
    const-string/jumbo v3, "Proxy-Authorization"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 144
    iput-object v2, p0, Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;->proxyAuthorization:Ljava/lang/String;

    goto :goto_1

    .line 147
    .end local v0    # "fieldName":Ljava/lang/String;
    .end local v2    # "value":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method static synthetic access$600(Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;

    .prologue
    .line 133
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;->userAgent:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$700(Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;

    .prologue
    .line 133
    iget-object v0, p0, Lcom/squareup/okhttp/internal/http/Request$ParsedHeaders;->proxyAuthorization:Ljava/lang/String;

    return-object v0
.end method
