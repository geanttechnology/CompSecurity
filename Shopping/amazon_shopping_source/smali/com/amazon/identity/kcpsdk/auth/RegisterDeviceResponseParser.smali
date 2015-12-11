.class public Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;
.super Lcom/amazon/identity/kcpsdk/common/WebResponseParser;
.source "RegisterDeviceResponseParser.java"

# interfaces
.implements Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser$1;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/identity/kcpsdk/common/WebResponseParser",
        "<",
        "Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;",
        ">;",
        "Lcom/amazon/identity/kcpsdk/auth/AmazonWebserviceCallResponseParser;"
    }
.end annotation


# static fields
.field public static final FIRS_KEY_ACCOUNT_POOL:Ljava/lang/String; = "account_pool"

.field public static final FIRS_KEY_ADP_TOKEN:Ljava/lang/String; = "adp_token"

.field public static final FIRS_KEY_ALIAS:Ljava/lang/String; = "alias"

.field public static final FIRS_KEY_COOKIES:Ljava/lang/String; = "cookies"

.field public static final FIRS_KEY_COR:Ljava/lang/String; = "country_of_residence"

.field public static final FIRS_KEY_DEVICE_EMAIL:Ljava/lang/String; = "kindle_email_address"

.field public static final FIRS_KEY_DEVICE_INFO:Ljava/lang/String; = "device_info"

.field public static final FIRS_KEY_DEVICE_NAME:Ljava/lang/String; = "user_device_name"

.field public static final FIRS_KEY_DIRECTEDID:Ljava/lang/String; = "user_directed_id"

.field public static final FIRS_KEY_HOME_REGION:Ljava/lang/String; = "home_region"

.field public static final FIRS_KEY_IDENTITY_TOKEN:Ljava/lang/String; = "identityTokenResponse"

.field public static final FIRS_KEY_NAME:Ljava/lang/String; = "name"

.field public static final FIRS_KEY_PFM:Ljava/lang/String; = "preferred_marketplace"

.field public static final FIRS_KEY_PRIVATE_KEY:Ljava/lang/String; = "device_private_key"

.field public static final FIRS_KEY_SOURCE_COR:Ljava/lang/String; = "source_of_cor"

.field public static final FIRS_KEY_STORE_COOKIE:Ljava/lang/String; = "store_authentication_cookie"

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mCookieParser:Lcom/amazon/identity/kcpsdk/auth/CookieParser;

.field private final mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

.field private mResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 60
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/common/WebResponseParser;-><init>(Ljava/lang/String;)V

    .line 62
    new-instance v0, Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/common/XMLParser;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    .line 63
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/CookieParser;

    invoke-direct {v0}, Lcom/amazon/identity/kcpsdk/auth/CookieParser;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mCookieParser:Lcom/amazon/identity/kcpsdk/auth/CookieParser;

    .line 64
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    .line 65
    return-void
.end method

.method private logAndThrowParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V
    .locals 5
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/common/ParseError;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;
        }
    .end annotation

    .prologue
    .line 325
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Seeing parse error  %s:%s!"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->getParserName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/ParseError;->name()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 326
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;

    invoke-direct {v0, p1}, Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;-><init>(Lcom/amazon/identity/kcpsdk/common/ParseError;)V

    throw v0
.end method

.method private walk(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .locals 20
    .param p1, "xmlDoc"    # Lorg/w3c/dom/Document;

    .prologue
    .line 98
    invoke-interface/range {p1 .. p1}, Lorg/w3c/dom/Document;->getDocumentElement()Lorg/w3c/dom/Element;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {v1}, Lorg/w3c/dom/Element;->getTagName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "response"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    :cond_0
    const/4 v8, 0x0

    .line 100
    .local v8, "response":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :goto_0
    if-nez v8, :cond_1

    .line 102
    invoke-virtual/range {p0 .. p1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->parseErrorResponse(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v8

    .line 105
    :cond_1
    return-object v8

    .line 98
    .end local v8    # "response":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    :cond_2
    const-string/jumbo v2, "serverTime"

    invoke-static {v1, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getNextChildElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    new-instance v8, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    invoke-direct {v8, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    const-string/jumbo v2, "adp_token"

    invoke-static {v1, v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getNextChildElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v2

    const-string/jumbo v3, "device_private_key"

    invoke-static {v1, v3}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getNextChildElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v3

    const-string/jumbo v4, "name"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v5

    const-string/jumbo v4, "user_device_name"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v6

    const-string/jumbo v4, "alias"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v7

    const-string/jumbo v4, "kindle_email_address"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v9

    const-string/jumbo v4, "cookies"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v10

    const-string/jumbo v4, "store_authentication_cookie"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getNextChildElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v11

    const-string/jumbo v4, "user_directed_id"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v12

    const-string/jumbo v4, "account_pool"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v13

    const-string/jumbo v4, "home_region"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v14

    const-string/jumbo v4, "country_of_residence"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v15

    const-string/jumbo v4, "source_of_cor"

    invoke-static {v15, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v16

    const-string/jumbo v4, "preferred_marketplace"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v17

    const-string/jumbo v4, "identityTokenResponse"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v18

    const-string/jumbo v4, "device_info"

    invoke-static {v1, v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getMapOfChildElements(Lorg/w3c/dom/Element;)Ljava/util/Map;

    move-result-object v19

    invoke-static {v2}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v3}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v5}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v6}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v7}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v7

    invoke-static {v9}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v12}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v9

    invoke-static {v13}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v12

    invoke-static {v14}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v13

    invoke-static {v15}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstTextElementValue(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v14

    invoke-static/range {v16 .. v16}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v15

    invoke-static/range {v17 .. v17}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v16

    if-eqz v6, :cond_4

    const-string/jumbo v17, ""

    move-object/from16 v0, v17

    invoke-virtual {v6, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_4

    :goto_1
    if-nez v4, :cond_6

    if-nez v5, :cond_6

    if-nez v3, :cond_6

    if-nez v2, :cond_6

    const/4 v8, 0x0

    goto/16 :goto_0

    :cond_4
    if-eqz v7, :cond_5

    const-string/jumbo v6, ""

    invoke-virtual {v7, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "@kindle.com"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    :cond_5
    const/4 v6, 0x0

    goto :goto_1

    :cond_6
    const-string/jumbo v7, "deviceCredentials"

    invoke-static {v1, v7}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getFirstElementWithTag(Lorg/w3c/dom/Element;Ljava/lang/String;)Lorg/w3c/dom/Element;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/kcpsdk/auth/BatchCredentialsParser;->parseBatchCredentialsResponse(Lorg/w3c/dom/Element;)Ljava/util/Map;

    move-result-object v17

    new-instance v1, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    const/4 v7, 0x0

    invoke-direct/range {v1 .. v7}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    invoke-static/range {v18 .. v18}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_7

    sget-object v3, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Received embedded Panda response: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->parse(Ljava/lang/String;)Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;

    move-result-object v2

    if-eqz v2, :cond_7

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->getExpirySeconds()I

    move-result v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setAccessTokenExpiresIn(I)V

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->getAccessToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setAccessToken(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->getRefreshToken()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setRefreshToken(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/auth/register/PandaTokenExchangeResponse;->getCookies()Lorg/json/JSONArray;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setPandaCookies(Lorg/json/JSONArray;)V

    :cond_7
    invoke-static {v11}, Lcom/amazon/identity/kcpsdk/common/XMLParserHelpers;->getTextContent(Lorg/w3c/dom/Element;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setStoreAuthenticationCookie(Ljava/lang/String;)V

    invoke-virtual {v1, v9}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setDirectedId(Ljava/lang/String;)V

    invoke-virtual {v1, v12}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setAccountPool(Ljava/lang/String;)V

    invoke-virtual {v1, v13}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setCustomerRegion(Ljava/lang/String;)V

    invoke-virtual {v1, v14}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setCor(Ljava/lang/String;)V

    invoke-virtual {v1, v15}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setSourceOfCor(Ljava/lang/String;)V

    move-object/from16 v0, v16

    invoke-virtual {v1, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setPfm(Ljava/lang/String;)V

    move-object/from16 v0, v19

    invoke-virtual {v1, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setDeviceInfo(Ljava/util/Map;)V

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mCookieParser:Lcom/amazon/identity/kcpsdk/auth/CookieParser;

    invoke-virtual {v2, v10}, Lcom/amazon/identity/kcpsdk/auth/CookieParser;->parseStandardKindleCookieResponse(Lorg/w3c/dom/Element;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->addAllFIRSCookies(Ljava/util/List;)V

    move-object/from16 v0, v17

    invoke-virtual {v1, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->setCredentialsReceived(Ljava/util/Map;)V

    move-object v8, v1

    goto/16 :goto_0
.end method


# virtual methods
.method public getErrorCode(Ljava/net/HttpURLConnection;)Ljava/lang/String;
    .locals 7
    .param p1, "connection"    # Ljava/net/HttpURLConnection;

    .prologue
    .line 339
    :try_start_0
    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 350
    .local v2, "inputStream":Ljava/io/InputStream;
    :goto_0
    const/4 v0, 0x0

    .line 351
    .local v0, "data":[B
    if-eqz v2, :cond_0

    .line 358
    :try_start_1
    invoke-static {v2}, Lcom/amazon/identity/auth/device/utils/StreamUtils;->readInputStream(Ljava/io/InputStream;)[B
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v0

    .line 366
    :cond_0
    if-nez v0, :cond_1

    .line 368
    const-string/jumbo v5, "CannotGetError"

    .line 388
    :goto_1
    return-object v5

    .line 347
    .end local v0    # "data":[B
    .end local v2    # "inputStream":Ljava/io/InputStream;
    :catch_0
    move-exception v5

    invoke-virtual {p1}, Ljava/net/HttpURLConnection;->getErrorStream()Ljava/io/InputStream;

    move-result-object v2

    .restart local v2    # "inputStream":Ljava/io/InputStream;
    goto :goto_0

    .line 362
    .restart local v0    # "data":[B
    :catch_1
    move-exception v5

    const-string/jumbo v5, "CannotGetError"

    goto :goto_1

    .line 371
    :cond_1
    new-instance v3, Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-direct {v3}, Lcom/amazon/identity/kcpsdk/common/XMLParser;-><init>()V

    .line 372
    .local v3, "parser":Lcom/amazon/identity/kcpsdk/common/XMLParser;
    array-length v5, v0

    int-to-long v5, v5

    invoke-virtual {v3, v0, v5, v6}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseChunk([BJ)Z

    move-result v5

    if-nez v5, :cond_2

    .line 374
    const-string/jumbo v5, "CannotGetError"

    goto :goto_1

    .line 377
    :cond_2
    invoke-virtual {v3}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseEndOfDocument()Lorg/w3c/dom/Document;

    move-result-object v4

    .line 378
    .local v4, "xmlDoc":Lorg/w3c/dom/Document;
    if-nez v4, :cond_3

    .line 380
    const-string/jumbo v5, "CannotGetError"

    goto :goto_1

    .line 382
    :cond_3
    invoke-static {v4}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorParser;->parseError(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/common/FIRSError;

    move-result-object v1

    .line 383
    .local v1, "firsError":Lcom/amazon/identity/kcpsdk/common/FIRSError;
    if-nez v1, :cond_4

    .line 385
    const/4 v5, 0x0

    goto :goto_1

    .line 388
    :cond_4
    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/common/FIRSError;->getErrorType()Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->getErrorCode()Ljava/lang/String;

    move-result-object v5

    goto :goto_1
.end method

.method public getParsedResponse()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    return-object v0
.end method

.method public bridge synthetic getParsedResponse()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->getParsedResponse()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v0

    return-object v0
.end method

.method protected internalEndParse()V
    .locals 2

    .prologue
    .line 85
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v1}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseEndOfDocument()Lorg/w3c/dom/Document;

    move-result-object v0

    .line 86
    .local v0, "xmlDoc":Lorg/w3c/dom/Document;
    if-nez v0, :cond_0

    .line 88
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {p0, v1}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z

    .line 94
    :goto_0
    return-void

    .line 92
    :cond_0
    invoke-direct {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->walk(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    goto :goto_0
.end method

.method protected internalParseBodyChunk([BJ)V
    .locals 1
    .param p1, "data"    # [B
    .param p2, "length"    # J

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseChunk([BJ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 78
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-virtual {p0, v0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->setParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)Z

    .line 80
    :cond_0
    return-void
.end method

.method public parse(Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;[B)Ljava/lang/Object;
    .locals 9
    .param p1, "responseHeaders"    # Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;
    .param p2, "data"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/identity/kcpsdk/auth/ParseErrorException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 285
    invoke-virtual {p1}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->getStatusCode()J

    move-result-wide v0

    .line 289
    .local v0, "httpCode":J
    const-wide/16 v4, 0x19c

    cmp-long v4, v0, v4

    if-eqz v4, :cond_0

    const-wide/16 v4, 0xc8

    cmp-long v4, v0, v4

    if-ltz v4, :cond_3

    const-wide/16 v4, 0x12c

    cmp-long v4, v0, v4

    if-gez v4, :cond_3

    .line 292
    :cond_0
    if-eqz p2, :cond_1

    .line 294
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    array-length v5, p2

    int-to-long v5, v5

    invoke-virtual {v4, p2, v5, v6}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseChunk([BJ)Z

    move-result v4

    if-nez v4, :cond_1

    .line 296
    sget-object v4, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-direct {p0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->logAndThrowParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V

    .line 300
    :cond_1
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Request complete"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 302
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mParser:Lcom/amazon/identity/kcpsdk/common/XMLParser;

    invoke-virtual {v4}, Lcom/amazon/identity/kcpsdk/common/XMLParser;->parseEndOfDocument()Lorg/w3c/dom/Document;

    move-result-object v3

    .line 303
    .local v3, "xmlDoc":Lorg/w3c/dom/Document;
    if-nez v3, :cond_2

    .line 305
    sget-object v4, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorMalformedBody:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-direct {p0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->logAndThrowParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V

    .line 319
    .end local v3    # "xmlDoc":Lorg/w3c/dom/Document;
    :goto_0
    iget-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    return-object v4

    .line 309
    .restart local v3    # "xmlDoc":Lorg/w3c/dom/Document;
    :cond_2
    invoke-direct {p0, v3}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->walk(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->mResponse:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    goto :goto_0

    .line 314
    .end local v3    # "xmlDoc":Lorg/w3c/dom/Document;
    :cond_3
    const-class v4, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    .line 315
    .local v2, "parserName":Ljava/lang/String;
    sget-object v4, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "%s: HTTP Error: %d"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v2, v6, v7

    const/4 v7, 0x1

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 316
    sget-object v4, Lcom/amazon/identity/kcpsdk/common/ParseError;->ParseErrorHttpError:Lcom/amazon/identity/kcpsdk/common/ParseError;

    invoke-direct {p0, v4}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->logAndThrowParseError(Lcom/amazon/identity/kcpsdk/common/ParseError;)V

    goto :goto_0
.end method

.method parseErrorResponse(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
    .locals 10
    .param p1, "rootNode"    # Lorg/w3c/dom/Document;

    .prologue
    const/4 v5, 0x0

    const/4 v1, 0x0

    .line 206
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognized:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 210
    .local v7, "errorType":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorParser;->parseError(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/common/FIRSError;

    move-result-object v8

    .line 211
    .local v8, "firsError":Lcom/amazon/identity/kcpsdk/common/FIRSError;
    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorParser;->parseError(Lorg/w3c/dom/Document;)Lcom/amazon/identity/kcpsdk/common/KindleWebserviceError;

    move-result-object v9

    .line 213
    .local v9, "kindleError":Lcom/amazon/identity/kcpsdk/common/KindleWebserviceError;
    if-eqz v8, :cond_1

    .line 215
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser$1;->$SwitchMap$com$amazon$identity$kcpsdk$common$FIRSErrorType:[I

    invoke-virtual {v8}, Lcom/amazon/identity/kcpsdk/common/FIRSError;->getErrorType()Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/FIRSErrorType;->ordinal()I

    move-result v2

    aget v0, v0, v2

    packed-switch v0, :pswitch_data_0

    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedFirs:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    .line 222
    :cond_0
    :goto_0
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "RegisterDeviceResponseParser: response received a %s error."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v7}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->getErrorString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v0, v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 223
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "FIRS returned error: "

    invoke-direct {v0, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Lcom/amazon/identity/kcpsdk/common/XMLElement;->convertElementToString(Lorg/w3c/dom/Node;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 224
    new-instance v6, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    invoke-direct {v6, v7}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;-><init>(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;)V

    .line 226
    .local v6, "error":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    new-instance v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    move-object v2, v1

    move-object v3, v1

    move-object v4, v1

    move-object v5, v1

    invoke-direct/range {v0 .. v6}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    return-object v0

    .line 215
    .end local v6    # "error":Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    :pswitch_0
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeCustomerNotFound:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :pswitch_1
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :pswitch_2
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :pswitch_3
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInternal:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    :pswitch_4
    const-string/jumbo v0, "PrimaryAccountDeregisteredWhenRegisterSecondary"

    new-array v2, v5, [Ljava/lang/String;

    invoke-static {v0, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypePrimaryAccountDeregisteredWhenRegisterSecondary:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_0

    .line 217
    :cond_1
    if-eqz v9, :cond_0

    .line 219
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponseParser$1;->$SwitchMap$com$amazon$identity$kcpsdk$common$KindleWebserviceErrorType:[I

    invoke-virtual {v9}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceError;->getErrorType()Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/identity/kcpsdk/common/KindleWebserviceErrorType;->ordinal()I

    move-result v2

    aget v0, v0, v2

    packed-switch v0, :pswitch_data_1

    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeUnrecognizedKindle:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    :goto_1
    goto :goto_0

    :pswitch_5
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDeviceAlreadyRegistered:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_1

    :pswitch_6
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeDuplicateDeviceName:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_1

    :pswitch_7
    sget-object v7, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;->RegisterDeviceErrorTypeInternal:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceErrorType;

    goto :goto_1

    .line 215
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch

    .line 219
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method
