.class public final Lcom/squareup/okhttp/internal/http/CacheStrategy;
.super Ljava/lang/Object;
.source "CacheStrategy.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/squareup/okhttp/internal/http/CacheStrategy$Factory;
    }
.end annotation


# static fields
.field private static final EMPTY_BODY:Lcom/squareup/okhttp/internal/http/Response$Body;

.field private static final GATEWAY_TIMEOUT_STATUS_LINE:Lcom/squareup/okhttp/internal/http/StatusLine;


# instance fields
.field public final request:Lcom/squareup/okhttp/internal/http/Request;

.field public final response:Lcom/squareup/okhttp/internal/http/Response;

.field public final source:Lcom/squareup/okhttp/ResponseSource;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 23
    new-instance v1, Lcom/squareup/okhttp/internal/http/CacheStrategy$1;

    invoke-direct {v1}, Lcom/squareup/okhttp/internal/http/CacheStrategy$1;-><init>()V

    sput-object v1, Lcom/squareup/okhttp/internal/http/CacheStrategy;->EMPTY_BODY:Lcom/squareup/okhttp/internal/http/Response$Body;

    .line 41
    :try_start_0
    new-instance v1, Lcom/squareup/okhttp/internal/http/StatusLine;

    const-string/jumbo v2, "HTTP/1.1 504 Gateway Timeout"

    invoke-direct {v1, v2}, Lcom/squareup/okhttp/internal/http/StatusLine;-><init>(Ljava/lang/String;)V

    sput-object v1, Lcom/squareup/okhttp/internal/http/CacheStrategy;->GATEWAY_TIMEOUT_STATUS_LINE:Lcom/squareup/okhttp/internal/http/StatusLine;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 45
    return-void

    .line 42
    :catch_0
    move-exception v0

    .line 43
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Ljava/lang/AssertionError;

    invoke-direct {v1}, Ljava/lang/AssertionError;-><init>()V

    throw v1
.end method

.method private constructor <init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;)V
    .locals 0
    .param p1, "request"    # Lcom/squareup/okhttp/internal/http/Request;
    .param p2, "response"    # Lcom/squareup/okhttp/internal/http/Response;
    .param p3, "source"    # Lcom/squareup/okhttp/ResponseSource;

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object p1, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy;->request:Lcom/squareup/okhttp/internal/http/Request;

    .line 54
    iput-object p2, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy;->response:Lcom/squareup/okhttp/internal/http/Response;

    .line 55
    iput-object p3, p0, Lcom/squareup/okhttp/internal/http/CacheStrategy;->source:Lcom/squareup/okhttp/ResponseSource;

    .line 56
    return-void
.end method

.method synthetic constructor <init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;Lcom/squareup/okhttp/internal/http/CacheStrategy$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/squareup/okhttp/internal/http/Request;
    .param p2, "x1"    # Lcom/squareup/okhttp/internal/http/Response;
    .param p3, "x2"    # Lcom/squareup/okhttp/ResponseSource;
    .param p4, "x3"    # Lcom/squareup/okhttp/internal/http/CacheStrategy$1;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2, p3}, Lcom/squareup/okhttp/internal/http/CacheStrategy;-><init>(Lcom/squareup/okhttp/internal/http/Request;Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/ResponseSource;)V

    return-void
.end method

.method static synthetic access$000()Lcom/squareup/okhttp/internal/http/Response$Body;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/squareup/okhttp/internal/http/CacheStrategy;->EMPTY_BODY:Lcom/squareup/okhttp/internal/http/Response$Body;

    return-object v0
.end method

.method static synthetic access$100()Lcom/squareup/okhttp/internal/http/StatusLine;
    .locals 1

    .prologue
    .line 22
    sget-object v0, Lcom/squareup/okhttp/internal/http/CacheStrategy;->GATEWAY_TIMEOUT_STATUS_LINE:Lcom/squareup/okhttp/internal/http/StatusLine;

    return-object v0
.end method

.method public static isCacheable(Lcom/squareup/okhttp/internal/http/Response;Lcom/squareup/okhttp/internal/http/Request;)Z
    .locals 5
    .param p0, "response"    # Lcom/squareup/okhttp/internal/http/Response;
    .param p1, "request"    # Lcom/squareup/okhttp/internal/http/Request;

    .prologue
    const/4 v2, 0x0

    .line 65
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v1

    .line 66
    .local v1, "responseCode":I
    const/16 v3, 0xc8

    if-eq v1, v3, :cond_1

    const/16 v3, 0xcb

    if-eq v1, v3, :cond_1

    const/16 v3, 0x12c

    if-eq v1, v3, :cond_1

    const/16 v3, 0x12d

    if-eq v1, v3, :cond_1

    const/16 v3, 0x19a

    if-eq v1, v3, :cond_1

    .line 88
    :cond_0
    :goto_0
    return v2

    .line 76
    :cond_1
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Response;->cacheControl()Lcom/squareup/okhttp/CacheControl;

    move-result-object v0

    .line 77
    .local v0, "responseCaching":Lcom/squareup/okhttp/CacheControl;
    const-string/jumbo v3, "Authorization"

    invoke-virtual {p1, v3}, Lcom/squareup/okhttp/internal/http/Request;->header(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_2

    invoke-virtual {v0}, Lcom/squareup/okhttp/CacheControl;->isPublic()Z

    move-result v3

    if-nez v3, :cond_2

    invoke-virtual {v0}, Lcom/squareup/okhttp/CacheControl;->mustRevalidate()Z

    move-result v3

    if-nez v3, :cond_2

    invoke-virtual {v0}, Lcom/squareup/okhttp/CacheControl;->sMaxAgeSeconds()I

    move-result v3

    const/4 v4, -0x1

    if-eq v3, v4, :cond_0

    .line 84
    :cond_2
    invoke-virtual {v0}, Lcom/squareup/okhttp/CacheControl;->noStore()Z

    move-result v3

    if-nez v3, :cond_0

    .line 88
    const/4 v2, 0x1

    goto :goto_0
.end method
