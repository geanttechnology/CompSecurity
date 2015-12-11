.class public Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;
.super Ljava/lang/Object;
.source "KindleStoreCredentialsRequestAction.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mBackCompatDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

.field private final mContext:Landroid/content/Context;

.field private final mCookieParser:Lcom/amazon/identity/kcpsdk/auth/CookieParser;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->mContext:Landroid/content/Context;

    .line 46
    new-instance v0, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->mBackCompatDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    .line 48
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/CookieParser;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/auth/CookieParser;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->mCookieParser:Lcom/amazon/identity/kcpsdk/auth/CookieParser;

    .line 49
    return-void
.end method

.method private createGetStoreCredentialsUrl()Ljava/net/URL;
    .locals 3

    .prologue
    .line 150
    :try_start_0
    new-instance v1, Landroid/net/Uri$Builder;

    invoke-direct {v1}, Landroid/net/Uri$Builder;-><init>()V

    const-string/jumbo v2, "https"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getFIRSHost()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string/jumbo v2, "FirsProxy"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    const-string/jumbo v2, "getStoreCredentials"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    .line 156
    .local v0, "uriBuilder":Landroid/net/Uri$Builder;
    new-instance v1, Ljava/net/URL;

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 163
    .end local v0    # "uriBuilder":Landroid/net/Uri$Builder;
    :goto_0
    return-object v1

    .line 160
    :catch_0
    move-exception v1

    sget-object v1, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot construct store credentials request"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private parseResponse(Ljava/net/HttpURLConnection;)Lcom/amazon/identity/auth/device/storage/CookieJar;
    .locals 12
    .param p1, "conn"    # Ljava/net/HttpURLConnection;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 103
    const/4 v6, 0x0

    .line 106
    .local v6, "stream":Ljava/io/InputStream;
    :try_start_0
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v6

    .line 107
    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->readInputStream(Ljava/io/InputStream;)[B

    move-result-object v4

    .line 109
    .local v4, "response":[B
    new-instance v3, Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-direct {v3}, Lcom/amazon/identity/kcpsdk/common/XMLParser;-><init>()V

    .line 110
    .local v3, "parser":Lcom/amazon/identity/kcpsdk/common/XMLParser;
    array-length v9, v4

    int-to-long v9, v9

    invoke-virtual {v3, v4, v9, v10}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseChunk([BJ)Z

    move-result v9

    if-nez v9, :cond_0

    .line 112
    sget-object v9, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Parsing XML Chunk was invalid"

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    :cond_0
    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseEndOfDocument()Lorg/w3c/dom/Document;

    move-result-object v7

    .line 116
    .local v7, "xmlDoc":Lorg/w3c/dom/Document;
    if-nez v7, :cond_1

    .line 118
    sget-object v9, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Could not parse get Store credentials response XML"

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 119
    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    .line 142
    :goto_0
    return-object v8

    .line 122
    :cond_1
    :try_start_1
    invoke-interface {v7}, Lorg/w3c/dom/Document;->getDocumentElement()Lorg/w3c/dom/Element;

    move-result-object v5

    .line 123
    .local v5, "responseNode":Lorg/w3c/dom/Element;
    if-eqz v5, :cond_2

    invoke-interface {v5}, Lorg/w3c/dom/Element;->getTagName()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v10, "response"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-nez v9, :cond_3

    .line 125
    :cond_2
    sget-object v9, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->TAG:Ljava/lang/String;

    const-string/jumbo v10, "Get Store Credentials request form was invalid. Could not get cookies"

    invoke-static {v9, v10}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    sget-object v9, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->TAG:Ljava/lang/String;

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    new-instance v11, Ljava/lang/String;

    invoke-direct {v11, v4}, Ljava/lang/String;-><init>([B)V

    aput-object v11, v9, v10
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 127
    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    goto :goto_0

    .line 130
    :cond_3
    :try_start_2
    const-string/jumbo v8, "cookies"

    invoke-static {v5, v8}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v1

    .line 131
    .local v1, "cookiesNode":Lorg/w3c/dom/Element;
    iget-object v8, p0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->mCookieParser:Lcom/amazon/identity/kcpsdk/auth/CookieParser;

    invoke-virtual {v8, v1}, Lcom/amazon/identity/kcpsdk/auth/CookieParser;->parseStandardKindleCookieResponse(Lorg/w3c/dom/Element;)Ljava/util/List;

    move-result-object v0

    .line 133
    .local v0, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/kcpsdk/auth/Cookie;>;"
    new-instance v8, Lcom/amazon/identity/auth/device/storage/CookieJar;

    invoke-direct {v8, v0}, Lcom/amazon/identity/auth/device/storage/CookieJar;-><init>(Ljava/util/List;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 142
    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    goto :goto_0

    .line 135
    .end local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/kcpsdk/auth/Cookie;>;"
    .end local v1    # "cookiesNode":Lorg/w3c/dom/Element;
    .end local v3    # "parser":Lcom/amazon/identity/kcpsdk/common/XMLParser;
    .end local v4    # "response":[B
    .end local v5    # "responseNode":Lorg/w3c/dom/Element;
    .end local v7    # "xmlDoc":Lorg/w3c/dom/Document;
    :catch_0
    move-exception v2

    .line 137
    .local v2, "e":Ljava/io/IOException;
    :try_start_3
    const-string/jumbo v8, "Get Kindle Store Credentials Service"

    invoke-static {p1, v8}, Lcom/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers;->writeErrorStream(Ljava/net/HttpURLConnection;Ljava/lang/String;)V

    .line 138
    throw v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 142
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v8

    invoke-static {v6}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->closeStream(Ljava/io/Closeable;)V

    throw v8
.end method


# virtual methods
.method public getStoreCredentialsCookies(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CookieJar;
    .locals 11
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 74
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->createGetStoreCredentialsUrl()Ljava/net/URL;

    move-result-object v4

    .line 75
    .local v4, "url":Ljava/net/URL;
    if-nez v4, :cond_0

    .line 98
    .end local v4    # "url":Ljava/net/URL;
    :goto_0
    return-object v5

    .line 80
    .restart local v4    # "url":Ljava/net/URL;
    :cond_0
    new-instance v6, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;

    iget-object v7, p0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->mContext:Landroid/content/Context;

    invoke-direct {v6, v7, p1}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 82
    sget-object v7, Lcom/amazon/identity/auth/device/api/AuthenticationType;->ADPAuthenticator:Lcom/amazon/identity/auth/device/api/AuthenticationType;

    invoke-virtual {v6, v7}, Lcom/amazon/identity/auth/device/api/AuthenticationMethodFactory;->newAuthenticationMethod(Lcom/amazon/identity/auth/device/api/AuthenticationType;)Lcom/amazon/identity/auth/device/api/AuthenticationMethod;

    move-result-object v0

    .line 85
    .local v0, "authMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    invoke-static {v4, v0}, Lcom/amazon/identity/auth/device/framework/AmazonUrlConnectionHelpers;->openConnection(Ljava/net/URL;Lcom/amazon/identity/auth/device/api/AuthenticationMethod;)Ljava/net/HttpURLConnection;

    move-result-object v1

    .line 86
    .local v1, "conn":Ljava/net/HttpURLConnection;
    const-string/jumbo v6, "GET"

    invoke-virtual {v1, v6}, Ljava/net/HttpURLConnection;->setRequestMethod(Ljava/lang/String;)V

    .line 88
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v3

    .line 89
    .local v3, "responseCode":I
    sget-object v6, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Recieved Response %d from Firs Proxy getStoreCredentials"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v7, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->parseResponse(Ljava/net/HttpURLConnection;)Lcom/amazon/identity/auth/device/storage/CookieJar;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    goto :goto_0

    .line 93
    .end local v0    # "authMethod":Lcom/amazon/identity/auth/device/api/AuthenticationMethod;
    .end local v1    # "conn":Ljava/net/HttpURLConnection;
    .end local v3    # "responseCode":I
    .end local v4    # "url":Ljava/net/URL;
    :catch_0
    move-exception v2

    .line 95
    .local v2, "e":Ljava/io/IOException;
    sget-object v6, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->TAG:Ljava/lang/String;

    const-string/jumbo v7, "Could not get cookies because we could not reach get Store Cookies endpoint."

    invoke-static {v6, v7, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public updateStoreCredentialCookies(Ljava/lang/String;)Z
    .locals 4
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 53
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->getStoreCredentialsCookies(Ljava/lang/String;)Lcom/amazon/identity/auth/device/storage/CookieJar;

    move-result-object v0

    .line 54
    .local v0, "cookieJar":Lcom/amazon/identity/auth/device/storage/CookieJar;
    if-nez v0, :cond_0

    .line 56
    sget-object v1, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Cannot update store credential cookies"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    const/4 v1, 0x0

    .line 67
    :goto_0
    return v1

    .line 60
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->mBackCompatDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.cookie.xmain"

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/CookieJar;->getXmain()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, p1, v2, v3}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/KindleStoreCredentialsRequestAction;->mBackCompatDataStorage:Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies"

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/CookieJar;->getInternationalXMainAndXAcbCookies()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, p1, v2, v3}, Lcom/amazon/identity/auth/device/storage/BackwardsCompatiableDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    const/4 v1, 0x1

    goto :goto_0
.end method
