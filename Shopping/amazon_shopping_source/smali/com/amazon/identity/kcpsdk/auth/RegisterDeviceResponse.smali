.class public Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;
.super Ljava/lang/Object;
.source "RegisterDeviceResponse.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mAccessToken:Ljava/lang/String;

.field private mAccessTokenExpiresIn:I

.field private mAccountPool:Ljava/lang/String;

.field private mAdpToken:Ljava/lang/String;

.field private mChallenge:Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

.field private mCookiesFromFIRS:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/kcpsdk/auth/Cookie;",
            ">;"
        }
    .end annotation
.end field

.field private mCookiesFromPanda:Lorg/json/JSONArray;

.field private mCor:Ljava/lang/String;

.field private mCredentialsReceived:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private mCustomerRegion:Ljava/lang/String;

.field private mDeviceEmail:Ljava/lang/String;

.field private mDeviceInfo:Ljava/util/Map;
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

.field private mDeviceName:Ljava/lang/String;

.field private mDirectedId:Ljava/lang/String;

.field private mError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

.field private mPfm:Ljava/lang/String;

.field private mPrivateKey:Ljava/lang/String;

.field private mRefreshToken:Ljava/lang/String;

.field private mServerTime:Ljava/lang/String;

.field private mSourceOfCor:Ljava/lang/String;

.field private mStoreAuthenticationCookie:Ljava/lang/String;

.field private mUserName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V
    .locals 13
    .param p1, "challenge"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .param p2, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    .prologue
    const/4 v1, 0x0

    .line 104
    const/4 v4, 0x0

    move-object v0, p0

    move-object v2, v1

    move-object v3, v1

    move-object v5, v1

    move-object v6, v1

    move-object v7, v1

    move-object v8, v1

    move-object v9, v1

    move-object v10, v1

    move-object v11, p1

    move-object v12, p2

    invoke-direct/range {v0 .. v12}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    .line 105
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "serverTime"    # Ljava/lang/String;

    .prologue
    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromPanda:Lorg/json/JSONArray;

    .line 76
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mServerTime:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V
    .locals 13
    .param p1, "adpToken"    # Ljava/lang/String;
    .param p2, "refreshToken"    # Ljava/lang/String;
    .param p3, "accessToken"    # Ljava/lang/String;
    .param p4, "accessTokenExpiresIn"    # I
    .param p5, "privateKey"    # Ljava/lang/String;
    .param p6, "directedId"    # Ljava/lang/String;
    .param p7, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    .prologue
    .line 87
    const/4 v5, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object/from16 v3, p3

    move/from16 v4, p4

    move-object/from16 v6, p5

    move-object/from16 v9, p6

    move-object/from16 v12, p7

    invoke-direct/range {v0 .. v12}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    .line 100
    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V
    .locals 1
    .param p1, "adpToken"    # Ljava/lang/String;
    .param p2, "refreshToken"    # Ljava/lang/String;
    .param p3, "accessToken"    # Ljava/lang/String;
    .param p4, "accessTokenExpiresIn"    # I
    .param p5, "deviceName"    # Ljava/lang/String;
    .param p6, "privateKey"    # Ljava/lang/String;
    .param p7, "userName"    # Ljava/lang/String;
    .param p8, "deviceEmail"    # Ljava/lang/String;
    .param p9, "directedId"    # Ljava/lang/String;
    .param p11, "challenge"    # Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .param p12, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;",
            "Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;",
            ")V"
        }
    .end annotation

    .prologue
    .line 145
    .local p10, "deviceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 43
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0}, Lorg/json/JSONArray;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromPanda:Lorg/json/JSONArray;

    .line 146
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAdpToken:Ljava/lang/String;

    .line 147
    iput-object p2, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mRefreshToken:Ljava/lang/String;

    .line 148
    iput-object p3, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAccessToken:Ljava/lang/String;

    .line 149
    iput p4, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAccessTokenExpiresIn:I

    .line 150
    iput-object p5, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDeviceName:Ljava/lang/String;

    .line 151
    iput-object p6, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mPrivateKey:Ljava/lang/String;

    .line 152
    iput-object p7, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mUserName:Ljava/lang/String;

    .line 153
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromFIRS:Ljava/util/List;

    .line 154
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCredentialsReceived:Ljava/util/Map;

    .line 155
    iput-object p8, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDeviceEmail:Ljava/lang/String;

    .line 156
    iput-object p9, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDirectedId:Ljava/lang/String;

    .line 157
    iput-object p10, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDeviceInfo:Ljava/util/Map;

    .line 158
    iput-object p11, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mChallenge:Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    .line 159
    iput-object p12, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    .line 160
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V
    .locals 13
    .param p1, "adpToken"    # Ljava/lang/String;
    .param p2, "refreshToken"    # Ljava/lang/String;
    .param p3, "accessToken"    # Ljava/lang/String;
    .param p4, "accessTokenExpiresIn"    # I
    .param p5, "deviceName"    # Ljava/lang/String;
    .param p6, "privateKey"    # Ljava/lang/String;
    .param p7, "userName"    # Ljava/lang/String;
    .param p8, "deviceEmail"    # Ljava/lang/String;
    .param p9, "directedId"    # Ljava/lang/String;
    .param p11, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "I",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;",
            ")V"
        }
    .end annotation

    .prologue
    .line 119
    .local p10, "deviceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v11, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object/from16 v3, p3

    move/from16 v4, p4

    move-object/from16 v5, p5

    move-object/from16 v6, p6

    move-object/from16 v7, p7

    move-object/from16 v8, p8

    move-object/from16 v9, p9

    move-object/from16 v10, p10

    move-object/from16 v12, p11

    invoke-direct/range {v0 .. v12}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    .line 131
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V
    .locals 12
    .param p1, "adpToken"    # Ljava/lang/String;
    .param p2, "deviceName"    # Ljava/lang/String;
    .param p3, "privateKey"    # Ljava/lang/String;
    .param p4, "userName"    # Ljava/lang/String;
    .param p5, "deviceEmail"    # Ljava/lang/String;
    .param p6, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    .prologue
    .line 71
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v9, 0x0

    const/4 v10, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v5, p2

    move-object v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p5

    move-object/from16 v11, p6

    invoke-direct/range {v0 .. v11}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    .line 72
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V
    .locals 13
    .param p1, "adpToken"    # Ljava/lang/String;
    .param p2, "deviceName"    # Ljava/lang/String;
    .param p3, "privateKey"    # Ljava/lang/String;
    .param p4, "userName"    # Ljava/lang/String;
    .param p5, "deviceEmail"    # Ljava/lang/String;
    .param p7, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;",
            ")V"
        }
    .end annotation

    .prologue
    .line 61
    .local p6, "deviceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v9, 0x0

    const/4 v11, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v5, p2

    move-object/from16 v6, p3

    move-object/from16 v7, p4

    move-object/from16 v8, p5

    move-object/from16 v10, p6

    move-object/from16 v12, p7

    invoke-direct/range {v0 .. v12}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V

    .line 62
    return-void
.end method


# virtual methods
.method public addAllFIRSCookies(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/kcpsdk/auth/Cookie;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 360
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/kcpsdk/auth/Cookie;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromFIRS:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 361
    return-void
.end method

.method public addFIRSCookie(Lcom/amazon/identity/kcpsdk/auth/Cookie;)V
    .locals 1
    .param p1, "cookie"    # Lcom/amazon/identity/kcpsdk/auth/Cookie;

    .prologue
    .line 355
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromFIRS:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 356
    return-void
.end method

.method public getAccessToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAccessToken:Ljava/lang/String;

    return-object v0
.end method

.method public getAccessTokenExpiresIn()I
    .locals 1

    .prologue
    .line 259
    iget v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAccessTokenExpiresIn:I

    return v0
.end method

.method public getAccountPool()Ljava/lang/String;
    .locals 1

    .prologue
    .line 320
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAccountPool:Ljava/lang/String;

    return-object v0
.end method

.method public getAdpToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 244
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAdpToken:Ljava/lang/String;

    return-object v0
.end method

.method public getChallenge()Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;
    .locals 1

    .prologue
    .line 381
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mChallenge:Lcom/amazon/identity/kcpsdk/auth/AuthenticationChallenge;

    return-object v0
.end method

.method public getCookieRetrievedFromFIRS(J)Lcom/amazon/identity/kcpsdk/auth/Cookie;
    .locals 2
    .param p1, "index"    # J

    .prologue
    .line 279
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->getNumCookiesRetrievedFromFIRS()J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 281
    sget-object v0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "RegisterDeviceResponse: getCookie: index out of range."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 282
    const/4 v0, 0x0

    .line 285
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromFIRS:Ljava/util/List;

    long-to-int v1, p1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/Cookie;

    goto :goto_0
.end method

.method public getCookiesRetrievedFromFIRS()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/kcpsdk/auth/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 290
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromFIRS:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getCookiesRetrievedFromPanda()Lorg/json/JSONArray;
    .locals 1

    .prologue
    .line 371
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromPanda:Lorg/json/JSONArray;

    return-object v0
.end method

.method public getCor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCor:Ljava/lang/String;

    return-object v0
.end method

.method public getCredentialsReceived()Ljava/util/Map;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 348
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 349
    .local v0, "credentialsMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCredentialsReceived:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 350
    return-object v0
.end method

.method public getCustomerRegion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 343
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCustomerRegion:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceInfo()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 386
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDeviceInfo:Ljava/util/Map;

    return-object v0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDeviceName:Ljava/lang/String;

    return-object v0
.end method

.method public getDirectedId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 310
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDirectedId:Ljava/lang/String;

    return-object v0
.end method

.method public getEmail()Ljava/lang/String;
    .locals 1

    .prologue
    .line 300
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDeviceEmail:Ljava/lang/String;

    return-object v0
.end method

.method public getError()Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    return-object v0
.end method

.method public getNumCookiesRetrievedFromFIRS()J
    .locals 2

    .prologue
    .line 274
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromFIRS:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    int-to-long v0, v0

    return-wide v0
.end method

.method public getPfm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mPfm:Ljava/lang/String;

    return-object v0
.end method

.method public getPrivateKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 269
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mPrivateKey:Ljava/lang/String;

    return-object v0
.end method

.method public getRefreshToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 249
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mRefreshToken:Ljava/lang/String;

    return-object v0
.end method

.method public getServerTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 396
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mServerTime:Ljava/lang/String;

    return-object v0
.end method

.method public getSourceOfCor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mSourceOfCor:Ljava/lang/String;

    return-object v0
.end method

.method public getStoreAuthenticationCookie()Ljava/lang/String;
    .locals 1

    .prologue
    .line 305
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mStoreAuthenticationCookie:Ljava/lang/String;

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 295
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mUserName:Ljava/lang/String;

    return-object v0
.end method

.method setAccessToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 174
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAccessToken:Ljava/lang/String;

    .line 175
    return-void
.end method

.method setAccessTokenExpiresIn(I)V
    .locals 0
    .param p1, "expiresIn"    # I

    .prologue
    .line 179
    iput p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAccessTokenExpiresIn:I

    .line 180
    return-void
.end method

.method public setAccountPool(Ljava/lang/String;)V
    .locals 0
    .param p1, "accountPool"    # Ljava/lang/String;

    .prologue
    .line 219
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAccountPool:Ljava/lang/String;

    .line 220
    return-void
.end method

.method setAdpToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 164
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mAdpToken:Ljava/lang/String;

    .line 165
    return-void
.end method

.method setCor(Ljava/lang/String;)V
    .locals 0
    .param p1, "cor"    # Ljava/lang/String;

    .prologue
    .line 224
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCor:Ljava/lang/String;

    .line 225
    return-void
.end method

.method public setCredentialsReceived(Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 365
    .local p1, "credentialsReceived":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;>;"
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCredentialsReceived:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 366
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCredentialsReceived:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 367
    return-void
.end method

.method public setCustomerRegion(Ljava/lang/String;)V
    .locals 0
    .param p1, "customerRegion"    # Ljava/lang/String;

    .prologue
    .line 239
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCustomerRegion:Ljava/lang/String;

    .line 240
    return-void
.end method

.method public setDeviceInfo(Ljava/util/Map;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 391
    .local p1, "deviceInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDeviceInfo:Ljava/util/Map;

    .line 392
    return-void
.end method

.method setDeviceName(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceName"    # Ljava/lang/String;

    .prologue
    .line 184
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDeviceName:Ljava/lang/String;

    .line 185
    return-void
.end method

.method setDirectedId(Ljava/lang/String;)V
    .locals 0
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 209
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDirectedId:Ljava/lang/String;

    .line 210
    return-void
.end method

.method setEmail(Ljava/lang/String;)V
    .locals 0
    .param p1, "deviceEmail"    # Ljava/lang/String;

    .prologue
    .line 204
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mDeviceEmail:Ljava/lang/String;

    .line 205
    return-void
.end method

.method setError(Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;)V
    .locals 0
    .param p1, "error"    # Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    .prologue
    .line 214
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mError:Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceError;

    .line 215
    return-void
.end method

.method public setPandaCookies(Lorg/json/JSONArray;)V
    .locals 0
    .param p1, "cookies"    # Lorg/json/JSONArray;

    .prologue
    .line 376
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mCookiesFromPanda:Lorg/json/JSONArray;

    .line 377
    return-void
.end method

.method setPfm(Ljava/lang/String;)V
    .locals 0
    .param p1, "pfm"    # Ljava/lang/String;

    .prologue
    .line 234
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mPfm:Ljava/lang/String;

    .line 235
    return-void
.end method

.method setPrivateKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "privateKey"    # Ljava/lang/String;

    .prologue
    .line 189
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mPrivateKey:Ljava/lang/String;

    .line 190
    return-void
.end method

.method setRefreshToken(Ljava/lang/String;)V
    .locals 0
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 169
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mRefreshToken:Ljava/lang/String;

    .line 170
    return-void
.end method

.method setSourceOfCor(Ljava/lang/String;)V
    .locals 0
    .param p1, "sourceOfCor"    # Ljava/lang/String;

    .prologue
    .line 229
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mSourceOfCor:Ljava/lang/String;

    .line 230
    return-void
.end method

.method public setStoreAuthenticationCookie(Ljava/lang/String;)V
    .locals 0
    .param p1, "storeAuthenticationCookie"    # Ljava/lang/String;

    .prologue
    .line 199
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mStoreAuthenticationCookie:Ljava/lang/String;

    .line 200
    return-void
.end method

.method setUserName(Ljava/lang/String;)V
    .locals 0
    .param p1, "userName"    # Ljava/lang/String;

    .prologue
    .line 194
    iput-object p1, p0, Lcom/amazon/identity/kcpsdk/auth/RegisterDeviceResponse;->mUserName:Ljava/lang/String;

    .line 195
    return-void
.end method
