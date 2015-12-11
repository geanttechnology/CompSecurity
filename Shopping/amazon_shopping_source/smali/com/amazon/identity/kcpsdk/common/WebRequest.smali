.class public Lcom/amazon/identity/kcpsdk/common/WebRequest;
.super Ljava/lang/Object;
.source "WebRequest.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mAuthenticationRequired:Z

.field private mBody:[B

.field private final mHeaderNames:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mHeaders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mHost:Ljava/lang/String;

.field private mPath:Ljava/lang/String;

.field private mPathAndQueryString:Ljava/lang/String;

.field private mPort:Ljava/lang/String;

.field private mProtocol:Ljava/lang/String;

.field private mQueryParameters:Ljava/lang/String;

.field private mUrl:Ljava/lang/String;

.field private mVerb:Lcom/amazon/identity/kcpsdk/common/HttpVerb;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    const-string/jumbo v0, "http"

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mProtocol:Ljava/lang/String;

    .line 37
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->HttpVerbGet:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mVerb:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 39
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHeaders:Ljava/util/Map;

    .line 40
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHeaderNames:Ljava/util/List;

    .line 42
    const/4 v0, 0x0

    new-array v0, v0, [B

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mBody:[B

    .line 43
    return-void
.end method

.method public static isValidUrl(Ljava/lang/String;)Z
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 307
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/WebRequest;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;-><init>()V

    invoke-direct {v0, p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->tryToParseUrl(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method private tryToParseUrl(Ljava/lang/String;)Z
    .locals 7
    .param p1, "rawUrlStr"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 312
    if-eqz p1, :cond_0

    const-string/jumbo v4, ""

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 347
    :cond_0
    :goto_0
    return v3

    .line 319
    :cond_1
    :try_start_0
    new-instance v2, Ljava/net/URI;

    invoke-direct {v2, p1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    .line 320
    .local v2, "url":Ljava/net/URI;
    invoke-virtual {v2}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mProtocol:Ljava/lang/String;

    .line 321
    invoke-virtual {v2}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHost:Ljava/lang/String;

    .line 323
    invoke-virtual {v2}, Ljava/net/URI;->getPort()I

    move-result v1

    .line 324
    .local v1, "port":I
    const/4 v4, -0x1

    if-eq v1, v4, :cond_3

    .line 326
    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPort:Ljava/lang/String;

    .line 333
    :goto_1
    invoke-virtual {v2}, Ljava/net/URI;->getRawPath()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPath:Ljava/lang/String;

    .line 334
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPath:Ljava/lang/String;

    if-eqz v4, :cond_2

    const-string/jumbo v4, ""

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPath:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPath:Ljava/lang/String;

    const-string/jumbo v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 336
    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "/"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPath:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPath:Ljava/lang/String;

    .line 339
    :cond_2
    invoke-virtual {v2}, Ljava/net/URI;->getRawQuery()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    .line 340
    const/4 v3, 0x1

    goto :goto_0

    .line 330
    :cond_3
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPort:Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 342
    .end local v1    # "port":I
    .end local v2    # "url":Ljava/net/URI;
    :catch_0
    move-exception v0

    .line 344
    .local v0, "e":Ljava/net/URISyntaxException;
    sget-object v4, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "tryToParseUrl: URL is malformed: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public addQueryParameter(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 216
    if-eqz p1, :cond_0

    const-string/jumbo v1, ""

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    if-nez p2, :cond_1

    .line 218
    :cond_0
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "addQueryParameter: could not add query parameter because the supplied arguments are invalid (null or empty name or null value)."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 243
    :goto_0
    return-void

    .line 224
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    if-eqz v1, :cond_2

    .line 226
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "&"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    .line 235
    :goto_1
    :try_start_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "%s=%s"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string/jumbo v5, "UTF-8"

    invoke-static {p1, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    const-string/jumbo v5, "UTF-8"

    invoke-static {p2, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 238
    :catch_0
    move-exception v0

    .line 240
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "addQueryParameter: Could not add query parameter because of UnsupportedEncodingException: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 230
    .end local v0    # "e":Ljava/io/UnsupportedEncodingException;
    :cond_2
    const-string/jumbo v1, ""

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    goto :goto_1
.end method

.method public getAuthenticationRequired()Z
    .locals 1

    .prologue
    .line 162
    iget-boolean v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mAuthenticationRequired:Z

    return v0
.end method

.method public getBody()Ljava/lang/String;
    .locals 4

    .prologue
    .line 145
    :try_start_0
    new-instance v1, Ljava/lang/String;

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getBodyBytes()[B

    move-result-object v2

    const-string/jumbo v3, "UTF-8"

    invoke-direct {v1, v2, v3}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 151
    :goto_0
    return-object v1

    .line 147
    :catch_0
    move-exception v0

    .line 149
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "getBody: UnsupportedEncodingException error: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 151
    const-string/jumbo v1, ""

    goto :goto_0
.end method

.method public getBodyBytes()[B
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mBody:[B

    return-object v0
.end method

.method public getHeaderByName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 133
    if-nez p1, :cond_0

    .line 135
    const/4 v0, 0x0

    .line 138
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHeaders:Ljava/util/Map;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public getHeaderName(I)Ljava/lang/String;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 115
    if-ltz p1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getNumHeaders()I

    move-result v0

    if-lt p1, v0, :cond_1

    .line 117
    :cond_0
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "getHeader: index is out of range"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    const/4 v0, 0x0

    .line 121
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHeaderNames:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public getHeaderValue(I)Ljava/lang/String;
    .locals 2
    .param p1, "index"    # I

    .prologue
    .line 126
    invoke-virtual {p0, p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getHeaderName(I)Ljava/lang/String;

    move-result-object v0

    .line 128
    .local v0, "key":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getHeaderByName(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getNumHeaders()I
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHeaderNames:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getPathAndQueryString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 47
    const-string/jumbo v0, ""

    .line 48
    .local v0, "path":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPath:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 50
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPath:Ljava/lang/String;

    .line 53
    :cond_0
    const-string/jumbo v1, ""

    .line 54
    .local v1, "queryParameters":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 56
    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "?"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 59
    :cond_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPathAndQueryString:Ljava/lang/String;

    .line 61
    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPathAndQueryString:Ljava/lang/String;

    return-object v2
.end method

.method public getQueryString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 68
    const-string/jumbo v0, ""

    .line 71
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mQueryParameters:Ljava/lang/String;

    goto :goto_0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 76
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 77
    .local v0, "sb":Ljava/lang/StringBuilder;
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mProtocol:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mProtocol:Ljava/lang/String;

    :goto_0
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 78
    const-string/jumbo v1, "://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 79
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHost:Ljava/lang/String;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHost:Ljava/lang/String;

    :goto_1
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 81
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPort:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 83
    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, ":"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPort:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 86
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->getPathAndQueryString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 88
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mUrl:Ljava/lang/String;

    .line 90
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mUrl:Ljava/lang/String;

    return-object v1

    .line 77
    :cond_1
    const-string/jumbo v1, ""

    goto :goto_0

    .line 79
    :cond_2
    const-string/jumbo v1, ""

    goto :goto_1
.end method

.method public getVerb()Lcom/amazon/identity/kcpsdk/common/HttpVerb;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mVerb:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    return-object v0
.end method

.method public getVerbAsString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mVerb:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mVerb:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/common/HttpVerb;->getValue()Ljava/lang/String;

    move-result-object v0

    .line 105
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setAuthenticationRequired(Z)V
    .locals 0
    .param p1, "authenticationRequired"    # Z

    .prologue
    .line 291
    iput-boolean p1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mAuthenticationRequired:Z

    .line 292
    return-void
.end method

.method public setBody(Ljava/lang/String;)V
    .locals 5
    .param p1, "body"    # Ljava/lang/String;

    .prologue
    .line 275
    :try_start_0
    const-string/jumbo v2, "UTF-8"

    invoke-virtual {p1, v2}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v0

    .line 276
    .local v0, "bodyBytes":[B
    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->setBody([B)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 282
    .end local v0    # "bodyBytes":[B
    :goto_0
    return-void

    .line 278
    :catch_0
    move-exception v1

    .line 280
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    sget-object v2, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "setBody: UnsupportedEncodingException error: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public setBody([B)V
    .locals 0
    .param p1, "data"    # [B

    .prologue
    .line 286
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mBody:[B

    .line 287
    return-void
.end method

.method public setHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 252
    if-eqz p1, :cond_0

    const-string/jumbo v1, ""

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 254
    :cond_0
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "setHeader: failed because the given header name was null or empty."

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 269
    :goto_0
    return-void

    .line 258
    :cond_1
    if-nez p2, :cond_2

    .line 260
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHeaderNames:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 261
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHeaders:Ljava/util/Map;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 265
    :cond_2
    const-string/jumbo v1, "\n"

    const-string/jumbo v2, "\n "

    invoke-virtual {p2, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 267
    .local v0, "valueStr":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHeaderNames:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 268
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHeaders:Ljava/util/Map;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public setHost(Ljava/lang/String;)V
    .locals 0
    .param p1, "host"    # Ljava/lang/String;

    .prologue
    .line 179
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mHost:Ljava/lang/String;

    .line 180
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 6
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 196
    move-object v2, p1

    .line 197
    .local v2, "pathToSet":Ljava/lang/String;
    if-eqz p1, :cond_0

    const-string/jumbo v3, ""

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string/jumbo v3, "/"

    invoke-virtual {p1, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 199
    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "/"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 204
    :cond_0
    :try_start_0
    new-instance v0, Ljava/net/URI;

    const-string/jumbo v3, "http"

    const-string/jumbo v4, "www.amazon.com"

    const/4 v5, 0x0

    invoke-direct {v0, v3, v4, v2, v5}, Ljava/net/URI;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    .local v0, "dummy":Ljava/net/URI;
    invoke-virtual {v0}, Ljava/net/URI;->getRawPath()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPath:Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 211
    return-void

    .line 207
    .end local v0    # "dummy":Ljava/net/URI;
    :catch_0
    move-exception v1

    .line 209
    .local v1, "e":Ljava/net/URISyntaxException;
    sget-object v3, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "setPath: Could not set path because of URISyntaxException: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    new-instance v3, Ljava/lang/IllegalArgumentException;

    invoke-direct {v3, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v3
.end method

.method public setPort(I)V
    .locals 1
    .param p1, "port"    # I

    .prologue
    .line 184
    const/4 v0, -0x1

    if-eq p1, v0, :cond_0

    .line 186
    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPort:Ljava/lang/String;

    .line 192
    :goto_0
    return-void

    .line 190
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mPort:Ljava/lang/String;

    goto :goto_0
.end method

.method public setProtocol(Lcom/amazon/identity/kcpsdk/common/WebProtocol;)V
    .locals 1
    .param p1, "protocol"    # Lcom/amazon/identity/kcpsdk/common/WebProtocol;

    .prologue
    .line 167
    if-eqz p1, :cond_0

    .line 169
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebProtocol;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mProtocol:Ljava/lang/String;

    .line 175
    :goto_0
    return-void

    .line 173
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mProtocol:Ljava/lang/String;

    goto :goto_0
.end method

.method public setUrl(Ljava/lang/String;)Z
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 296
    invoke-direct {p0, p1}, Lcom/amazon/identity/kcpsdk/common/WebRequest;->tryToParseUrl(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 298
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "setUrl: url was malformed. Cannot be set."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    const/4 v0, 0x0

    .line 302
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public setVerb(Lcom/amazon/identity/kcpsdk/common/HttpVerb;)V
    .locals 0
    .param p1, "verb"    # Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .prologue
    .line 247
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/common/WebRequest;->mVerb:Lcom/amazon/identity/kcpsdk/common/HttpVerb;

    .line 248
    return-void
.end method
