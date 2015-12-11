.class public Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;
.super Ljava/lang/Object;
.source "DefaultHttpRequestFactory.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpRequestFactory;


# static fields
.field private static final RFC2616_COMMON_METHODS:[Ljava/lang/String;

.field private static final RFC2616_ENTITY_ENC_METHODS:[Ljava/lang/String;

.field private static final RFC2616_SPECIAL_METHODS:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 44
    new-array v0, v3, [Ljava/lang/String;

    const-string v1, "GET"

    aput-object v1, v0, v2

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;->RFC2616_COMMON_METHODS:[Ljava/lang/String;

    .line 48
    new-array v0, v4, [Ljava/lang/String;

    const-string v1, "POST"

    aput-object v1, v0, v2

    const-string v1, "PUT"

    aput-object v1, v0, v3

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;->RFC2616_ENTITY_ENC_METHODS:[Ljava/lang/String;

    .line 53
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "HEAD"

    aput-object v1, v0, v2

    const-string v1, "OPTIONS"

    aput-object v1, v0, v3

    const-string v1, "DELETE"

    aput-object v1, v0, v4

    const/4 v1, 0x3

    const-string v2, "TRACE"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string v2, "CONNECT"

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;->RFC2616_SPECIAL_METHODS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    return-void
.end method

.method private static isOneOf([Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "methods"    # [Ljava/lang/String;
    .param p1, "method"    # Ljava/lang/String;

    .prologue
    .line 67
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v1, p0

    if-ge v0, v1, :cond_1

    .line 68
    aget-object v1, p0, v0

    invoke-virtual {v1, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 69
    const/4 v1, 0x1

    .line 72
    :goto_1
    return v1

    .line 67
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 72
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method


# virtual methods
.method public newHttpRequest(Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .locals 4
    .param p1, "requestline"    # Lcom/comcast/cim/httpcomponentsandroid/RequestLine;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/MethodNotSupportedException;
        }
    .end annotation

    .prologue
    .line 77
    if-nez p1, :cond_0

    .line 78
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Request line may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 80
    :cond_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v0

    .line 81
    .local v0, "method":Ljava/lang/String;
    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;->RFC2616_COMMON_METHODS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;->isOneOf([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 82
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;

    invoke-direct {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;-><init>(Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)V

    .line 86
    :goto_0
    return-object v1

    .line 83
    :cond_1
    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;->RFC2616_ENTITY_ENC_METHODS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;->isOneOf([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 84
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpEntityEnclosingRequest;

    invoke-direct {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpEntityEnclosingRequest;-><init>(Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)V

    goto :goto_0

    .line 85
    :cond_2
    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;->RFC2616_SPECIAL_METHODS:[Ljava/lang/String;

    invoke-static {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/DefaultHttpRequestFactory;->isOneOf([Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 86
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;

    invoke-direct {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;-><init>(Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)V

    goto :goto_0

    .line 88
    :cond_3
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/MethodNotSupportedException;

    new-instance v2, Ljava/lang/StringBuffer;

    invoke-direct {v2}, Ljava/lang/StringBuffer;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    const-string v3, " method not supported"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/MethodNotSupportedException;-><init>(Ljava/lang/String;)V

    throw v1
.end method
