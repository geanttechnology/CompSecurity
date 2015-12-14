.class public Lcom/livemixtapes/User;
.super Ljava/lang/Object;
.source "User.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/User$SignupCallback;,
        Lcom/livemixtapes/User$UserCallback;,
        Lcom/livemixtapes/User$UserData;
    }
.end annotation


# static fields
.field private static final AUTH_KEY:Ljava/lang/String; = "auth"

.field public static final EXCEPTION:I = 0x4

.field public static final INVALID_AUTH:I = 0x0

.field public static final INVALID_CREDENTIALS:I = 0x1

.field public static final INVALID_JSON:I = 0x2

.field private static final LOGIN_URL:Ljava/lang/String; = "https://api.livemixtapes.com/api/user/login"

.field public static final OFFLINE:I = 0x3

.field private static final SIGNUP_URL:Ljava/lang/String; = "https://api.livemixtapes.com/api/user/signup"

.field private static final USER_FILE:Ljava/lang/String; = "user"

.field private static final USER_URL:Ljava/lang/String; = "https://api.livemixtapes.com/api/user/login"

.field private static userData:Lcom/livemixtapes/User$UserData;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 75
    const/4 v0, 0x0

    sput-object v0, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Ljava/lang/String;)Ljava/util/Map;
    .locals 1

    .prologue
    .line 307
    invoke-static {p0}, Lcom/livemixtapes/User;->getJsonMap(Ljava/lang/String;)Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1(Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 271
    invoke-static {p0}, Lcom/livemixtapes/User;->setUserData(Ljava/util/Map;)V

    return-void
.end method

.method static synthetic access$2()Lcom/livemixtapes/User$UserData;
    .locals 1

    .prologue
    .line 75
    sget-object v0, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    return-object v0
.end method

.method static synthetic access$3(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 94
    invoke-static {p0}, Lcom/livemixtapes/User;->setAuth(Ljava/lang/String;)V

    return-void
.end method

.method public static addFavoriteMixtape(Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 299
    .local p0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v1, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    if-nez v1, :cond_0

    .line 305
    :goto_0
    return-void

    .line 301
    :cond_0
    const-string v1, "id"

    invoke-interface {p0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 303
    .local v0, "mapId":Ljava/lang/String;
    sget-object v1, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    iget-object v1, v1, Lcom/livemixtapes/User$UserData;->favoriteMixtapeIds:Ljava/util/Set;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 304
    sget-object v1, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    iget-object v1, v1, Lcom/livemixtapes/User$UserData;->favoriteMixtapes:Ljava/util/List;

    invoke-interface {v1, p0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public static getAuth()Ljava/lang/String;
    .locals 3

    .prologue
    .line 91
    invoke-static {}, Lcom/livemixtapes/User;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "auth"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getData()Lcom/livemixtapes/User$UserData;
    .locals 1

    .prologue
    .line 78
    sget-object v0, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    return-object v0
.end method

.method private static getInt(Ljava/lang/Object;)I
    .locals 2
    .param p0, "number"    # Ljava/lang/Object;

    .prologue
    .line 318
    const/4 v0, 0x0

    .line 321
    .local v0, "value":I
    :try_start_0
    check-cast p0, Ljava/lang/String;

    .end local p0    # "number":Ljava/lang/Object;
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 324
    :goto_0
    return v0

    .line 322
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private static getJsonMap(Ljava/lang/String;)Ljava/util/Map;
    .locals 2
    .param p0, "data"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 308
    const/4 v0, 0x0

    .line 311
    .local v0, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :try_start_0
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, p0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 314
    :goto_0
    return-object v0

    .line 312
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private static getPreferences()Landroid/content/SharedPreferences;
    .locals 3

    .prologue
    .line 87
    sget-object v0, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    const-string v1, "user"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method public static hasAuth()Ljava/lang/Boolean;
    .locals 2

    .prologue
    .line 115
    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method public static isGuest()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 111
    invoke-static {}, Lcom/livemixtapes/User;->isLogged()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static isLogged()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 107
    sget-object v0, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method public static login(Ljava/lang/String;Ljava/lang/String;Lcom/livemixtapes/User$UserCallback;)V
    .locals 4
    .param p0, "username"    # Ljava/lang/String;
    .param p1, "password"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/livemixtapes/User$UserCallback;

    .prologue
    .line 218
    invoke-static {}, Lcom/livemixtapes/User;->logout()V

    .line 220
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 221
    .local v0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "username"

    invoke-interface {v0, v1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 222
    const-string v1, "password"

    invoke-static {p1}, Lcom/livemixtapes/User;->md5(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 224
    new-instance v1, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v1}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    const-string v2, "https://api.livemixtapes.com/api/user/login"

    new-instance v3, Lcom/livemixtapes/User$3;

    invoke-direct {v3, p2}, Lcom/livemixtapes/User$3;-><init>(Lcom/livemixtapes/User$UserCallback;)V

    invoke-virtual {v1, v2, v0, v3}, Lcom/livemixtapes/AsyncHttp;->post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 264
    return-void
.end method

.method public static logout()V
    .locals 1

    .prologue
    .line 267
    const/4 v0, 0x0

    sput-object v0, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    .line 268
    const-string v0, ""

    invoke-static {v0}, Lcom/livemixtapes/User;->setAuth(Ljava/lang/String;)V

    .line 269
    return-void
.end method

.method public static md5(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "s"    # Ljava/lang/String;

    .prologue
    .line 330
    :try_start_0
    const-string v5, "MD5"

    invoke-static {v5}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 331
    .local v0, "digest":Ljava/security/MessageDigest;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/security/MessageDigest;->update([B)V

    .line 332
    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v3

    .line 335
    .local v3, "messageDigest":[B
    new-instance v4, Ljava/lang/StringBuffer;

    invoke-direct {v4}, Ljava/lang/StringBuffer;-><init>()V

    .line 336
    .local v4, "sb":Ljava/lang/StringBuffer;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v5, v3

    if-lt v2, v5, :cond_0

    .line 343
    invoke-virtual {v4}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    .line 348
    .end local v0    # "digest":Ljava/security/MessageDigest;
    .end local v2    # "i":I
    .end local v3    # "messageDigest":[B
    .end local v4    # "sb":Ljava/lang/StringBuffer;
    :goto_1
    return-object v5

    .line 337
    .restart local v0    # "digest":Ljava/security/MessageDigest;
    .restart local v2    # "i":I
    .restart local v3    # "messageDigest":[B
    .restart local v4    # "sb":Ljava/lang/StringBuffer;
    :cond_0
    aget-byte v5, v3, v2

    and-int/lit16 v5, v5, 0xff

    const/16 v6, 0x10

    if-ge v5, v6, :cond_1

    .line 338
    const/16 v5, 0x30

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    .line 340
    :cond_1
    aget-byte v5, v3, v2

    and-int/lit16 v5, v5, 0xff

    invoke-static {v5}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    .line 336
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 345
    .end local v0    # "digest":Ljava/security/MessageDigest;
    .end local v2    # "i":I
    .end local v3    # "messageDigest":[B
    .end local v4    # "sb":Ljava/lang/StringBuffer;
    :catch_0
    move-exception v1

    .line 346
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    invoke-virtual {v1}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    .line 348
    const-string v5, ""

    goto :goto_1
.end method

.method public static refresh(Lcom/livemixtapes/User$UserCallback;)V
    .locals 4
    .param p0, "callback"    # Lcom/livemixtapes/User$UserCallback;

    .prologue
    .line 119
    invoke-static {}, Lcom/livemixtapes/User;->hasAuth()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 120
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 121
    .local v0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "auth"

    invoke-static {}, Lcom/livemixtapes/User;->getAuth()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 123
    new-instance v1, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v1}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    const-string v2, "https://api.livemixtapes.com/api/user/login"

    new-instance v3, Lcom/livemixtapes/User$1;

    invoke-direct {v3, p0}, Lcom/livemixtapes/User$1;-><init>(Lcom/livemixtapes/User$UserCallback;)V

    invoke-virtual {v1, v2, v0, v3}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 161
    .end local v0    # "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    return-void
.end method

.method public static removeFavoriteMixtape(I)V
    .locals 4
    .param p0, "id"    # I

    .prologue
    .line 284
    sget-object v2, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    if-nez v2, :cond_1

    .line 296
    :cond_0
    :goto_0
    return-void

    .line 286
    :cond_1
    sget-object v2, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    iget-object v2, v2, Lcom/livemixtapes/User$UserData;->favoriteMixtapeIds:Ljava/util/Set;

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 288
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    sget-object v2, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    iget-object v2, v2, Lcom/livemixtapes/User$UserData;->favoriteMixtapes:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 289
    sget-object v2, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    iget-object v2, v2, Lcom/livemixtapes/User$UserData;->favoriteMixtapes:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    const-string v3, "id"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 291
    .local v1, "mapId":Ljava/lang/String;
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    if-ne v2, p0, :cond_2

    .line 292
    sget-object v2, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    iget-object v2, v2, Lcom/livemixtapes/User$UserData;->favoriteMixtapes:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    goto :goto_0

    .line 288
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method private static setAuth(Ljava/lang/String;)V
    .locals 2
    .param p0, "auth"    # Ljava/lang/String;

    .prologue
    .line 95
    invoke-static {}, Lcom/livemixtapes/User;->getPreferences()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 97
    .local v0, "pref":Landroid/content/SharedPreferences$Editor;
    if-nez p0, :cond_0

    .line 98
    const-string v1, "auth"

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 103
    :goto_0
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 104
    return-void

    .line 100
    :cond_0
    const-string v1, "auth"

    invoke-interface {v0, v1, p0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    goto :goto_0
.end method

.method private static setUserData(Ljava/util/Map;)V
    .locals 8
    .param p0, "map"    # Ljava/util/Map;

    .prologue
    .line 272
    new-instance v0, Lcom/livemixtapes/User$UserData;

    .line 273
    const-string v1, "username"

    invoke-interface {p0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 274
    const-string v2, "userid"

    invoke-interface {p0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/livemixtapes/User;->getInt(Ljava/lang/Object;)I

    move-result v2

    .line 275
    const-string v3, "firstname"

    invoke-interface {p0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 276
    const-string v4, "lastname"

    invoke-interface {p0, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 277
    const-string v5, "favorites_playlist"

    invoke-interface {p0, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-static {v5}, Lcom/livemixtapes/User;->getInt(Ljava/lang/Object;)I

    move-result v5

    .line 278
    const-string v6, "playlists_complete"

    invoke-interface {p0, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/List;

    .line 279
    const-string v7, "favorite_mixtapes"

    invoke-interface {p0, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/List;

    .line 272
    invoke-direct/range {v0 .. v7}, Lcom/livemixtapes/User$UserData;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V

    sput-object v0, Lcom/livemixtapes/User;->userData:Lcom/livemixtapes/User$UserData;

    .line 281
    return-void
.end method

.method public static signup(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/livemixtapes/User$SignupCallback;)V
    .locals 4
    .param p0, "username"    # Ljava/lang/String;
    .param p1, "email"    # Ljava/lang/String;
    .param p2, "password"    # Ljava/lang/String;
    .param p3, "firstname"    # Ljava/lang/String;
    .param p4, "lastname"    # Ljava/lang/String;
    .param p5, "country"    # Ljava/lang/String;
    .param p6, "postalcode"    # Ljava/lang/String;
    .param p7, "gender"    # Ljava/lang/String;
    .param p8, "dob_month"    # Ljava/lang/String;
    .param p9, "dob_day"    # Ljava/lang/String;
    .param p10, "dob_year"    # Ljava/lang/String;
    .param p11, "callback"    # Lcom/livemixtapes/User$SignupCallback;

    .prologue
    .line 165
    invoke-static {}, Lcom/livemixtapes/User;->logout()V

    .line 172
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 173
    .local v0, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "country"

    invoke-interface {v0, v1, p5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 174
    const-string v1, "dob_day"

    invoke-interface {v0, v1, p9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 175
    const-string v1, "dob_month"

    invoke-interface {v0, v1, p8}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 176
    const-string v1, "dob_year"

    invoke-interface {v0, v1, p10}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 177
    const-string v1, "email"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 178
    const-string v1, "firstname"

    invoke-interface {v0, v1, p3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    const-string v1, "gender"

    invoke-interface {v0, v1, p7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    const-string v1, "lastname"

    invoke-interface {v0, v1, p4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    const-string v1, "password"

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 182
    const-string v1, "username"

    invoke-interface {v0, v1, p0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 183
    const-string v1, "tos"

    const-string v2, "1"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    const-string v1, "zip"

    invoke-interface {v0, v1, p6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 186
    new-instance v1, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v1}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    const-string v2, "https://api.livemixtapes.com/api/user/signup"

    new-instance v3, Lcom/livemixtapes/User$2;

    invoke-direct {v3, p11}, Lcom/livemixtapes/User$2;-><init>(Lcom/livemixtapes/User$SignupCallback;)V

    invoke-virtual {v1, v2, v0, v3}, Lcom/livemixtapes/AsyncHttp;->post(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 214
    return-void
.end method

.method public static updatePlayList()V
    .locals 0

    .prologue
    .line 84
    return-void
.end method
