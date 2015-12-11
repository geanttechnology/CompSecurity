.class public Lcom/pinterest/android/pdk/PDKClient;
.super Ljava/lang/Object;
.source "PDKClient.java"


# static fields
.field private static final BOARDS:Ljava/lang/String; = "boards/"

.field private static final FOLLOWERS:Ljava/lang/String; = "followers/"

.field private static final FOLLOWING:Ljava/lang/String; = "following/"

.field private static final INTERESTS:Ljava/lang/String; = "interests/"

.field private static final LIKES:Ljava/lang/String; = "likes/"

.field private static final ME:Ljava/lang/String; = "me/"

.field private static final PDKCLIENT_EXTRA_APPID:Ljava/lang/String; = "PDKCLIENT_EXTRA_APPID"

.field private static final PDKCLIENT_EXTRA_APPNAME:Ljava/lang/String; = "PDKCLIENT_EXTRA_APPNAME"

.field private static final PDKCLIENT_EXTRA_PERMISSIONS:Ljava/lang/String; = "PDKCLIENT_EXTRA_PERMISSIONS"

.field private static final PDKCLIENT_EXTRA_RESULT:Ljava/lang/String; = "PDKCLIENT_EXTRA_RESULT"

.field public static final PDKCLIENT_PERMISSION_READ_PRIVATE:Ljava/lang/String; = "read_private"

.field public static final PDKCLIENT_PERMISSION_READ_PUBLIC:Ljava/lang/String; = "read_public"

.field public static final PDKCLIENT_PERMISSION_READ_RELATIONSHIPS:Ljava/lang/String; = "read_relationships"

.field public static final PDKCLIENT_PERMISSION_WRITE_PRIVATE:Ljava/lang/String; = "write_private"

.field public static final PDKCLIENT_PERMISSION_WRITE_PUBLIC:Ljava/lang/String; = "write_public"

.field public static final PDKCLIENT_PERMISSION_WRITE_RELATIONSHIPS:Ljava/lang/String; = "write_relationships"

.field private static final PDKCLIENT_REQUEST_CODE:I = 0x2244

.field public static final PDKCLIENT_VERSION_CODE:Ljava/lang/String; = "1.0"

.field public static final PDK_QUERY_PARAM_CURSOR:Ljava/lang/String; = "cursor"

.field public static final PDK_QUERY_PARAM_FIELDS:Ljava/lang/String; = "fields"

.field private static final PDK_SHARED_PREF_FILE_KEY:Ljava/lang/String; = "com.pinterest.android.pdk.PREF_FILE_KEY"

.field private static final PDK_SHARED_PREF_SCOPES_KEY:Ljava/lang/String; = "PDK_SHARED_PREF_SCOPES_KEY"

.field private static final PDK_SHARED_PREF_TOKEN_KEY:Ljava/lang/String; = "PDK_SHARED_PREF_TOKEN_KEY"

.field private static final PINS:Ljava/lang/String; = "pins/"

.field private static final PINTEREST_OAUTH_ACTIVITY:Ljava/lang/String; = "com.pinterest.sdk.PinterestOauthActivity"

.field private static final PINTEREST_PACKAGE:Ljava/lang/String; = "com.pinterest"

.field private static final PROD_BASE_API_URL:Ljava/lang/String; = "https://api.pinterest.com/v1/"

.field private static final PROD_WEB_OAUTH_URL:Ljava/lang/String; = "https://api.pinterest.com/oauth/"

.field private static final USER:Ljava/lang/String; = "users/"

.field private static final VOLLEY_TAG:Ljava/lang/String; = "volley_tag"

.field private static _accessToken:Ljava/lang/String;

.field private static _clientId:Ljava/lang/String;

.field private static _context:Landroid/content/Context;

.field private static _debugMode:Z

.field private static _isAuthenticated:Z

.field private static _isConfigured:Z

.field private static _mInstance:Lcom/pinterest/android/pdk/PDKClient;

.field private static _requestQueue:Lcom/android/volley/RequestQueue;

.field private static _requestedScopes:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private static _scopes:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private _authCallback:Lcom/pinterest/android/pdk/PDKCallback;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    const/4 v0, 0x0

    sput-object v0, Lcom/pinterest/android/pdk/PDKClient;->_mInstance:Lcom/pinterest/android/pdk/PDKClient;

    .line 78
    const/4 v0, 0x0

    sput-boolean v0, Lcom/pinterest/android/pdk/PDKClient;->_isAuthenticated:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    return-void
.end method

.method static synthetic access$000(Lcom/pinterest/android/pdk/PDKClient;Ljava/lang/Object;)Z
    .locals 1
    .param p0, "x0"    # Lcom/pinterest/android/pdk/PDKClient;
    .param p1, "x1"    # Ljava/lang/Object;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/pinterest/android/pdk/PDKClient;->verifyAccessToken(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$102(Z)Z
    .locals 0
    .param p0, "x0"    # Z

    .prologue
    .line 30
    sput-boolean p0, Lcom/pinterest/android/pdk/PDKClient;->_isAuthenticated:Z

    return p0
.end method

.method static synthetic access$200(Lcom/pinterest/android/pdk/PDKClient;)Lcom/pinterest/android/pdk/PDKCallback;
    .locals 1
    .param p0, "x0"    # Lcom/pinterest/android/pdk/PDKClient;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKClient;->_authCallback:Lcom/pinterest/android/pdk/PDKCallback;

    return-object v0
.end method

.method static synthetic access$300(Lcom/pinterest/android/pdk/PDKClient;Landroid/content/Context;Ljava/util/List;)V
    .locals 0
    .param p0, "x0"    # Lcom/pinterest/android/pdk/PDKClient;
    .param p1, "x1"    # Landroid/content/Context;
    .param p2, "x2"    # Ljava/util/List;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/pinterest/android/pdk/PDKClient;->initiateLogin(Landroid/content/Context;Ljava/util/List;)V

    return-void
.end method

.method private static addToRequestQueue(Lcom/android/volley/Request;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/android/volley/Request",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 559
    .local p0, "req":Lcom/android/volley/Request;, "Lcom/android/volley/Request<TT;>;"
    const-string v0, "volley_tag"

    invoke-virtual {p0, v0}, Lcom/android/volley/Request;->setTag(Ljava/lang/Object;)Lcom/android/volley/Request;

    .line 560
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getRequestQueue()Lcom/android/volley/RequestQueue;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/android/volley/RequestQueue;->add(Lcom/android/volley/Request;)Lcom/android/volley/Request;

    .line 561
    return-void
.end method

.method private static cancelPendingRequests()V
    .locals 2

    .prologue
    .line 564
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_requestQueue:Lcom/android/volley/RequestQueue;

    const-string v1, "volley_tag"

    invoke-virtual {v0, v1}, Lcom/android/volley/RequestQueue;->cancelAll(Ljava/lang/Object;)V

    .line 565
    return-void
.end method

.method public static configureInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/pinterest/android/pdk/PDKClient;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "clientId"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x1

    .line 97
    sput-object p1, Lcom/pinterest/android/pdk/PDKClient;->_clientId:Ljava/lang/String;

    .line 98
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    sput-object v1, Lcom/pinterest/android/pdk/PDKClient;->_context:Landroid/content/Context;

    .line 99
    sput-boolean v0, Lcom/pinterest/android/pdk/PDKClient;->_isConfigured:Z

    .line 101
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->restoreAccessToken()Ljava/lang/String;

    move-result-object v1

    sput-object v1, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    .line 102
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->restoreScopes()Ljava/util/Set;

    move-result-object v1

    sput-object v1, Lcom/pinterest/android/pdk/PDKClient;->_scopes:Ljava/util/Set;

    .line 103
    sget-object v1, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    if-eqz v1, :cond_0

    :goto_0
    sput-boolean v0, Lcom/pinterest/android/pdk/PDKClient;->_isAuthenticated:Z

    .line 104
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v0

    return-object v0

    .line 103
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private createAuthIntent(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "appId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Landroid/content/Intent;"
        }
    .end annotation

    .prologue
    .line 464
    .local p3, "permissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "com.pinterest"

    const-string v2, "com.pinterest.sdk.PinterestOauthActivity"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    const-string v1, "PDKCLIENT_EXTRA_APPID"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    const-string v1, "PDKCLIENT_EXTRA_APPNAME"

    const-string v2, "appName"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    const-string v1, "PDKCLIENT_EXTRA_PERMISSIONS"

    const-string v2, ","

    invoke-static {v2, p3}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method private static deleteRequest(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)Lcom/android/volley/Request;
    .locals 8
    .param p0, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pinterest/android/pdk/PDKCallback;",
            ")",
            "Lcom/android/volley/Request;"
        }
    .end annotation

    .prologue
    .local p1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v7, 0x0

    .line 648
    const-string v1, "PDK DELETE: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p0, v2, v7

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    new-array v2, v7, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/pinterest/android/pdk/Utils;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 650
    new-instance v6, Ljava/util/LinkedList;

    invoke-direct {v6}, Ljava/util/LinkedList;-><init>()V

    .line 651
    .local v6, "queryParams":Ljava/util/List;
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "access_token"

    sget-object v3, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v6, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 652
    invoke-static {p0, v6}, Lcom/pinterest/android/pdk/Utils;->getUrlWithQueryParams(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object p0

    .line 654
    if-nez p2, :cond_0

    new-instance p2, Lcom/pinterest/android/pdk/PDKCallback;

    .end local p2    # "callback":Lcom/pinterest/android/pdk/PDKCallback;
    invoke-direct {p2}, Lcom/pinterest/android/pdk/PDKCallback;-><init>()V

    .line 656
    .restart local p2    # "callback":Lcom/pinterest/android/pdk/PDKCallback;
    :cond_0
    new-instance v0, Lcom/pinterest/android/pdk/PDKRequest;

    const/4 v1, 0x3

    const/4 v3, 0x0

    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getHeaders()Ljava/util/Map;

    move-result-object v5

    move-object v2, p0

    move-object v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/pinterest/android/pdk/PDKRequest;-><init>(ILjava/lang/String;Lorg/json/JSONObject;Lcom/pinterest/android/pdk/PDKCallback;Ljava/util/Map;)V

    .line 657
    .local v0, "request":Lcom/pinterest/android/pdk/PDKRequest;
    invoke-virtual {v0, v7}, Lcom/pinterest/android/pdk/PDKRequest;->setShouldCache(Z)Lcom/android/volley/Request;

    .line 658
    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKClient;->addToRequestQueue(Lcom/android/volley/Request;)V

    .line 659
    return-object v0
.end method

.method private static getHeaders()Ljava/util/Map;
    .locals 6
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
    .line 578
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 579
    .local v0, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "User-Agent"

    const-string v2, "PDK %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    const-string v5, "1.0"

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 580
    return-object v0
.end method

.method public static getInstance()Lcom/pinterest/android/pdk/PDKClient;
    .locals 1

    .prologue
    .line 88
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_mInstance:Lcom/pinterest/android/pdk/PDKClient;

    if-nez v0, :cond_0

    .line 90
    new-instance v0, Lcom/pinterest/android/pdk/PDKClient;

    invoke-direct {v0}, Lcom/pinterest/android/pdk/PDKClient;-><init>()V

    sput-object v0, Lcom/pinterest/android/pdk/PDKClient;->_mInstance:Lcom/pinterest/android/pdk/PDKClient;

    .line 91
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getRequestQueue()Lcom/android/volley/RequestQueue;

    move-result-object v0

    sput-object v0, Lcom/pinterest/android/pdk/PDKClient;->_requestQueue:Lcom/android/volley/RequestQueue;

    .line 93
    :cond_0
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_mInstance:Lcom/pinterest/android/pdk/PDKClient;

    return-object v0
.end method

.method private getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;
    .locals 2
    .param p1, "fields"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 572
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 573
    .local v0, "map":Ljava/util/HashMap;
    const-string v1, "fields"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 574
    return-object v0
.end method

.method private static getRequest(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)Lcom/android/volley/Request;
    .locals 9
    .param p0, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pinterest/android/pdk/PDKCallback;",
            ")",
            "Lcom/android/volley/Request;"
        }
    .end annotation

    .prologue
    .local p1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x0

    .line 617
    const-string v2, "PDK GET: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p0, v3, v1

    invoke-static {v2, v3}, Lcom/pinterest/android/pdk/Utils;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 618
    new-instance v8, Ljava/util/LinkedList;

    invoke-direct {v8}, Ljava/util/LinkedList;-><init>()V

    .line 619
    .local v8, "paramList":Ljava/util/List;
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "access_token"

    sget-object v4, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 620
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/util/Map;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 621
    invoke-virtual {p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map$Entry;

    .line 622
    .local v6, "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-direct {v4, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v8, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 625
    .end local v6    # "e":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v7    # "i$":Ljava/util/Iterator;
    :cond_0
    invoke-static {p0, v8}, Lcom/pinterest/android/pdk/Utils;->getUrlWithQueryParams(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object p0

    .line 627
    if-nez p2, :cond_1

    new-instance p2, Lcom/pinterest/android/pdk/PDKCallback;

    .end local p2    # "callback":Lcom/pinterest/android/pdk/PDKCallback;
    invoke-direct {p2}, Lcom/pinterest/android/pdk/PDKCallback;-><init>()V

    .line 628
    .restart local p2    # "callback":Lcom/pinterest/android/pdk/PDKCallback;
    :cond_1
    new-instance v0, Lcom/pinterest/android/pdk/PDKRequest;

    const/4 v3, 0x0

    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getHeaders()Ljava/util/Map;

    move-result-object v5

    move-object v2, p0

    move-object v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/pinterest/android/pdk/PDKRequest;-><init>(ILjava/lang/String;Lorg/json/JSONObject;Lcom/pinterest/android/pdk/PDKCallback;Ljava/util/Map;)V

    .line 629
    .local v0, "request":Lcom/pinterest/android/pdk/PDKRequest;
    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKClient;->addToRequestQueue(Lcom/android/volley/Request;)V

    .line 630
    return-object v0
.end method

.method private static getRequestQueue()Lcom/android/volley/RequestQueue;
    .locals 1

    .prologue
    .line 552
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_requestQueue:Lcom/android/volley/RequestQueue;

    if-nez v0, :cond_0

    .line 553
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_context:Landroid/content/Context;

    invoke-static {v0}, Lcom/android/volley/toolbox/Volley;->newRequestQueue(Landroid/content/Context;)Lcom/android/volley/RequestQueue;

    move-result-object v0

    sput-object v0, Lcom/pinterest/android/pdk/PDKClient;->_requestQueue:Lcom/android/volley/RequestQueue;

    .line 555
    :cond_0
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_requestQueue:Lcom/android/volley/RequestQueue;

    return-object v0
.end method

.method private initiateLogin(Landroid/content/Context;Ljava/util/List;)V
    .locals 3
    .param p1, "c"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 421
    .local p2, "permissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    sget-object v1, Lcom/pinterest/android/pdk/PDKClient;->_context:Landroid/content/Context;

    invoke-static {v1}, Lcom/pinterest/android/pdk/PDKClient;->pinterestInstalled(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 422
    sget-object v1, Lcom/pinterest/android/pdk/PDKClient;->_context:Landroid/content/Context;

    sget-object v2, Lcom/pinterest/android/pdk/PDKClient;->_clientId:Ljava/lang/String;

    invoke-direct {p0, v1, v2, p2}, Lcom/pinterest/android/pdk/PDKClient;->createAuthIntent(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;)Landroid/content/Intent;

    move-result-object v0

    .line 423
    .local v0, "intent":Landroid/content/Intent;
    if-eqz v0, :cond_0

    .line 424
    invoke-direct {p0, p1, v0}, Lcom/pinterest/android/pdk/PDKClient;->openPinterestAppForLogin(Landroid/content/Context;Landroid/content/Intent;)V

    .line 431
    .end local v0    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 426
    .restart local v0    # "intent":Landroid/content/Intent;
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/pinterest/android/pdk/PDKClient;->initiateWebLogin(Landroid/content/Context;Ljava/util/List;)V

    goto :goto_0

    .line 429
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-direct {p0, p1, p2}, Lcom/pinterest/android/pdk/PDKClient;->initiateWebLogin(Landroid/content/Context;Ljava/util/List;)V

    goto :goto_0
.end method

.method private initiateWebLogin(Landroid/content/Context;Ljava/util/List;)V
    .locals 8
    .param p1, "c"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 435
    .local p2, "permissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :try_start_0
    new-instance v2, Ljava/util/LinkedList;

    invoke-direct {v2}, Ljava/util/LinkedList;-><init>()V

    .line 436
    .local v2, "paramList":Ljava/util/List;
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "client_id"

    sget-object v6, Lcom/pinterest/android/pdk/PDKClient;->_clientId:Ljava/lang/String;

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 437
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "scope"

    const-string v6, ","

    invoke-static {v6, p2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 438
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "redirect_uri"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "pdk"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v7, Lcom/pinterest/android/pdk/PDKClient;->_clientId:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "://"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 439
    new-instance v4, Lorg/apache/http/message/BasicNameValuePair;

    const-string v5, "response_type"

    const-string v6, "token"

    invoke-direct {v4, v5, v6}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v2, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 441
    const-string v4, "https://api.pinterest.com/oauth/"

    invoke-static {v4, v2}, Lcom/pinterest/android/pdk/Utils;->getUrlWithQueryParams(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object v3

    .line 442
    .local v3, "url":Ljava/lang/String;
    new-instance v1, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-direct {v1, v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 443
    .local v1, "oauthIntent":Landroid/content/Intent;
    invoke-virtual {p1, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 448
    .end local v1    # "oauthIntent":Landroid/content/Intent;
    .end local v2    # "paramList":Ljava/util/List;
    .end local v3    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 445
    :catch_0
    move-exception v0

    .line 446
    .local v0, "e":Ljava/lang/Exception;
    const-string v4, "PDK: Error initiating web oauth"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v4, v5}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static isDebugMode()Z
    .locals 1

    .prologue
    .line 117
    sget-boolean v0, Lcom/pinterest/android/pdk/PDKClient;->_debugMode:Z

    return v0
.end method

.method private static meetsRequirements()Z
    .locals 2

    .prologue
    .line 497
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private onOauthResponse(Ljava/lang/String;)V
    .locals 8
    .param p1, "result"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 397
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 398
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 399
    .local v3, "uri":Landroid/net/Uri;
    const-string v4, "access_token"

    invoke-virtual {v3, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 400
    const-string v4, "access_token"

    invoke-virtual {v3, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 402
    .local v2, "token":Ljava/lang/String;
    :try_start_0
    const-string v4, "UTF-8"

    invoke-static {v2, v4}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 406
    :goto_0
    sput-object v2, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    .line 407
    sput-boolean v7, Lcom/pinterest/android/pdk/PDKClient;->_isAuthenticated:Z

    .line 408
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getInstance()Lcom/pinterest/android/pdk/PDKClient;

    move-result-object v4

    iget-object v5, p0, Lcom/pinterest/android/pdk/PDKClient;->_authCallback:Lcom/pinterest/android/pdk/PDKCallback;

    invoke-virtual {v4, v5}, Lcom/pinterest/android/pdk/PDKClient;->getMe(Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 409
    sget-object v4, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    invoke-direct {p0, v4}, Lcom/pinterest/android/pdk/PDKClient;->saveAccessToken(Ljava/lang/String;)V

    .line 411
    .end local v2    # "token":Ljava/lang/String;
    :cond_0
    const-string v4, "error"

    invoke-virtual {v3, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 412
    const-string v4, "error"

    invoke-virtual {v3, v4}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 413
    .local v1, "error":Ljava/lang/String;
    const-string v4, "PDK: authentication error: %s"

    new-array v5, v7, [Ljava/lang/Object;

    aput-object v1, v5, v6

    invoke-static {v4, v5}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 416
    .end local v1    # "error":Ljava/lang/String;
    .end local v3    # "uri":Landroid/net/Uri;
    :cond_1
    sget-object v4, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    if-nez v4, :cond_2

    .line 417
    iget-object v4, p0, Lcom/pinterest/android/pdk/PDKClient;->_authCallback:Lcom/pinterest/android/pdk/PDKCallback;

    new-instance v5, Lcom/pinterest/android/pdk/PDKException;

    const-string v6, "PDK: authentication failed"

    invoke-direct {v5, v6}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v5}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 418
    :cond_2
    return-void

    .line 403
    .restart local v2    # "token":Ljava/lang/String;
    .restart local v3    # "uri":Landroid/net/Uri;
    :catch_0
    move-exception v0

    .line 404
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    new-array v5, v6, [Ljava/lang/Object;

    invoke-static {v4, v5}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private openPinterestAppForLogin(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 453
    :try_start_0
    check-cast p1, Landroid/app/Activity;

    .end local p1    # "c":Landroid/content/Context;
    const/16 v1, 0x2244

    invoke-virtual {p1, p2, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 460
    :goto_0
    return-void

    .line 454
    :catch_0
    move-exception v0

    .line 457
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    const-string v1, "PDK: failed to open Pinterest App for login"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private static pinterestInstalled(Landroid/content/Context;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, 0x0

    .line 507
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->meetsRequirements()Z

    move-result v4

    if-nez v4, :cond_0

    .line 524
    :goto_0
    return v3

    .line 510
    :cond_0
    const/4 v2, 0x0

    .line 512
    .local v2, "installed":Z
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    const-string v5, "com.pinterest"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 513
    .local v1, "info":Landroid/content/pm/PackageInfo;
    if-eqz v1, :cond_1

    .line 514
    iget v4, v1, Landroid/content/pm/PackageInfo;->versionCode:I

    const/16 v5, 0x10

    if-lt v4, v5, :cond_3

    const/4 v2, 0x1

    .line 518
    :cond_1
    :goto_1
    if-nez v2, :cond_2

    .line 519
    const-string v4, "PDK: Pinterest App not installed or version too low!"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v4, v5}, Lcom/pinterest/android/pdk/Utils;->log(Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local v1    # "info":Landroid/content/pm/PackageInfo;
    :cond_2
    :goto_2
    move v3, v2

    .line 524
    goto :goto_0

    .restart local v1    # "info":Landroid/content/pm/PackageInfo;
    :cond_3
    move v2, v3

    .line 514
    goto :goto_1

    .line 520
    .end local v1    # "info":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v0

    .line 521
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v4

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v4, v3}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 522
    const/4 v2, 0x0

    goto :goto_2
.end method

.method private static postRequest(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)Lcom/android/volley/Request;
    .locals 7
    .param p0, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pinterest/android/pdk/PDKCallback;",
            ")",
            "Lcom/android/volley/Request;"
        }
    .end annotation

    .prologue
    .local p1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v1, 0x1

    const/4 v4, 0x0

    .line 634
    const-string v2, "PDK POST: %s"

    new-array v3, v1, [Ljava/lang/Object;

    aput-object p0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    invoke-static {v2, v3}, Lcom/pinterest/android/pdk/Utils;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 635
    if-nez p1, :cond_0

    new-instance p1, Ljava/util/HashMap;

    .end local p1    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p1}, Ljava/util/HashMap;-><init>()V

    .line 637
    .restart local p1    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    new-instance v6, Ljava/util/LinkedList;

    invoke-direct {v6}, Ljava/util/LinkedList;-><init>()V

    .line 638
    .local v6, "queryParams":Ljava/util/List;
    new-instance v2, Lorg/apache/http/message/BasicNameValuePair;

    const-string v3, "access_token"

    sget-object v4, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    invoke-direct {v2, v3, v4}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v6, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 639
    invoke-static {p0, v6}, Lcom/pinterest/android/pdk/Utils;->getUrlWithQueryParams(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object p0

    .line 641
    if-nez p2, :cond_1

    new-instance p2, Lcom/pinterest/android/pdk/PDKCallback;

    .end local p2    # "callback":Lcom/pinterest/android/pdk/PDKCallback;
    invoke-direct {p2}, Lcom/pinterest/android/pdk/PDKCallback;-><init>()V

    .line 642
    .restart local p2    # "callback":Lcom/pinterest/android/pdk/PDKCallback;
    :cond_1
    new-instance v0, Lcom/pinterest/android/pdk/PDKRequest;

    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, p1}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getHeaders()Ljava/util/Map;

    move-result-object v5

    move-object v2, p0

    move-object v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/pinterest/android/pdk/PDKRequest;-><init>(ILjava/lang/String;Lorg/json/JSONObject;Lcom/pinterest/android/pdk/PDKCallback;Ljava/util/Map;)V

    .line 643
    .local v0, "request":Lcom/pinterest/android/pdk/PDKRequest;
    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKClient;->addToRequestQueue(Lcom/android/volley/Request;)V

    .line 644
    return-object v0
.end method

.method private static putRequest(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)Lcom/android/volley/Request;
    .locals 7
    .param p0, "url"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pinterest/android/pdk/PDKCallback;",
            ")",
            "Lcom/android/volley/Request;"
        }
    .end annotation

    .prologue
    .local p1, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v3, 0x0

    .line 663
    const-string v1, "PDK PUT: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p0, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/pinterest/android/pdk/Utils;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 664
    if-nez p1, :cond_0

    new-instance p1, Ljava/util/HashMap;

    .end local p1    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p1}, Ljava/util/HashMap;-><init>()V

    .line 666
    .restart local p1    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
    new-instance v6, Ljava/util/LinkedList;

    invoke-direct {v6}, Ljava/util/LinkedList;-><init>()V

    .line 667
    .local v6, "queryParams":Ljava/util/List;
    new-instance v1, Lorg/apache/http/message/BasicNameValuePair;

    const-string v2, "access_token"

    sget-object v3, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v6, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 668
    invoke-static {p0, v6}, Lcom/pinterest/android/pdk/Utils;->getUrlWithQueryParams(Ljava/lang/String;Ljava/util/List;)Ljava/lang/String;

    move-result-object p0

    .line 670
    if-nez p2, :cond_1

    new-instance p2, Lcom/pinterest/android/pdk/PDKCallback;

    .end local p2    # "callback":Lcom/pinterest/android/pdk/PDKCallback;
    invoke-direct {p2}, Lcom/pinterest/android/pdk/PDKCallback;-><init>()V

    .line 671
    .restart local p2    # "callback":Lcom/pinterest/android/pdk/PDKCallback;
    :cond_1
    new-instance v0, Lcom/pinterest/android/pdk/PDKRequest;

    const/4 v1, 0x2

    new-instance v3, Lorg/json/JSONObject;

    invoke-direct {v3, p1}, Lorg/json/JSONObject;-><init>(Ljava/util/Map;)V

    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->getHeaders()Ljava/util/Map;

    move-result-object v5

    move-object v2, p0

    move-object v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/pinterest/android/pdk/PDKRequest;-><init>(ILjava/lang/String;Lorg/json/JSONObject;Lcom/pinterest/android/pdk/PDKCallback;Ljava/util/Map;)V

    .line 672
    .local v0, "request":Lcom/pinterest/android/pdk/PDKRequest;
    invoke-static {v0}, Lcom/pinterest/android/pdk/PDKClient;->addToRequestQueue(Lcom/android/volley/Request;)V

    .line 673
    return-object v0
.end method

.method private static restoreAccessToken()Ljava/lang/String;
    .locals 4

    .prologue
    .line 535
    sget-object v1, Lcom/pinterest/android/pdk/PDKClient;->_context:Landroid/content/Context;

    const-string v2, "com.pinterest.android.pdk.PREF_FILE_KEY"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 536
    .local v0, "sharedPref":Landroid/content/SharedPreferences;
    const-string v1, "PDK_SHARED_PREF_TOKEN_KEY"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static restoreScopes()Ljava/util/Set;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 547
    sget-object v1, Lcom/pinterest/android/pdk/PDKClient;->_context:Landroid/content/Context;

    const-string v2, "com.pinterest.android.pdk.PREF_FILE_KEY"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 548
    .local v0, "sharedPref":Landroid/content/SharedPreferences;
    const-string v1, "PDK_SHARED_PREF_SCOPES_KEY"

    new-instance v2, Ljava/util/HashSet;

    invoke-direct {v2}, Ljava/util/HashSet;-><init>()V

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getStringSet(Ljava/lang/String;Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    return-object v1
.end method

.method private saveAccessToken(Ljava/lang/String;)V
    .locals 5
    .param p1, "accessToken"    # Ljava/lang/String;

    .prologue
    .line 528
    sget-object v2, Lcom/pinterest/android/pdk/PDKClient;->_context:Landroid/content/Context;

    const-string v3, "com.pinterest.android.pdk.PREF_FILE_KEY"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 529
    .local v1, "sharedPref":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 530
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "PDK_SHARED_PREF_TOKEN_KEY"

    invoke-interface {v0, v2, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 531
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 532
    return-void
.end method

.method private saveScopes(Ljava/util/Set;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 540
    .local p1, "perms":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    sget-object v2, Lcom/pinterest/android/pdk/PDKClient;->_context:Landroid/content/Context;

    const-string v3, "com.pinterest.android.pdk.PREF_FILE_KEY"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 541
    .local v1, "sharedPref":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 542
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "PDK_SHARED_PREF_SCOPES_KEY"

    invoke-interface {v0, v2, p1}, Landroid/content/SharedPreferences$Editor;->putStringSet(Ljava/lang/String;Ljava/util/Set;)Landroid/content/SharedPreferences$Editor;

    .line 543
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 544
    return-void
.end method

.method public static setDebugMode(Z)V
    .locals 0
    .param p0, "debugMode"    # Z

    .prologue
    .line 126
    sput-boolean p0, Lcom/pinterest/android/pdk/PDKClient;->_debugMode:Z

    .line 127
    return-void
.end method

.method private static validateScopes(Ljava/util/Set;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 568
    .local p0, "requestedScopes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_scopes:Ljava/util/Set;

    invoke-interface {v0, p0}, Ljava/util/Set;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method private verifyAccessToken(Ljava/lang/Object;)Z
    .locals 14
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 584
    const/4 v9, 0x0

    .line 585
    .local v9, "verified":Z
    const-string v1, ""

    .line 586
    .local v1, "appId":Ljava/lang/String;
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 588
    .local v3, "appScopes":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :try_start_0
    move-object v0, p1

    check-cast v0, Lorg/json/JSONObject;

    move-object v6, v0

    .line 589
    .local v6, "jsonObject":Lorg/json/JSONObject;
    const-string v10, "app"

    invoke-virtual {v6, v10}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 590
    const-string v10, "app"

    invoke-virtual {v6, v10}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    .line 591
    .local v2, "appObj":Lorg/json/JSONObject;
    const-string v10, "id"

    invoke-virtual {v2, v10}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_0

    .line 592
    const-string v10, "id"

    invoke-virtual {v2, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 595
    .end local v2    # "appObj":Lorg/json/JSONObject;
    :cond_0
    const-string v10, "scopes"

    invoke-virtual {v6, v10}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_1

    .line 596
    const-string v10, "scopes"

    invoke-virtual {v6, v10}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v7

    .line 597
    .local v7, "scopesArray":Lorg/json/JSONArray;
    invoke-virtual {v7}, Lorg/json/JSONArray;->length()I

    move-result v8

    .line 598
    .local v8, "size":I
    const/4 v5, 0x0

    .local v5, "i":I
    :goto_0
    if-ge v5, v8, :cond_1

    .line 599
    invoke-virtual {v7, v5}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v3, v10}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 598
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 602
    .end local v5    # "i":I
    .end local v6    # "jsonObject":Lorg/json/JSONObject;
    .end local v7    # "scopesArray":Lorg/json/JSONArray;
    .end local v8    # "size":I
    :catch_0
    move-exception v4

    .line 603
    .local v4, "exception":Lorg/json/JSONException;
    const-string v10, "PDK: "

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    invoke-virtual {v4}, Lorg/json/JSONException;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-static {v10, v11}, Lcom/pinterest/android/pdk/Utils;->loge(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 605
    .end local v4    # "exception":Lorg/json/JSONException;
    :cond_1
    invoke-static {v3}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/util/Collection;)Z

    move-result v10

    if-nez v10, :cond_2

    .line 606
    invoke-direct {p0, v3}, Lcom/pinterest/android/pdk/PDKClient;->saveScopes(Ljava/util/Set;)V

    .line 608
    :cond_2
    invoke-static {v1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v10

    if-nez v10, :cond_3

    invoke-static {v3}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/util/Collection;)Z

    move-result v10

    if-nez v10, :cond_3

    .line 609
    sget-object v10, Lcom/pinterest/android/pdk/PDKClient;->_clientId:Ljava/lang/String;

    invoke-virtual {v1, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_3

    sget-object v10, Lcom/pinterest/android/pdk/PDKClient;->_requestedScopes:Ljava/util/Set;

    invoke-interface {v3, v10}, Ljava/util/Set;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_3

    .line 610
    const/4 v9, 0x1

    .line 613
    :cond_3
    return v9
.end method


# virtual methods
.method public createBoard(Ljava/lang/String;Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "desc"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 349
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 350
    if-eqz p3, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Board name cannot be empty"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 357
    :cond_0
    :goto_0
    return-void

    .line 353
    :cond_1
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 354
    .local v0, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "name"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 355
    invoke-static {p2}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v1, "description"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 356
    :cond_2
    const-string v1, "boards/"

    invoke-virtual {p0, v1, v0, p3}, Lcom/pinterest/android/pdk/PDKClient;->postPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    goto :goto_0
.end method

.method public createPin(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "note"    # Ljava/lang/String;
    .param p2, "boardId"    # Ljava/lang/String;
    .param p3, "imageUrl"    # Ljava/lang/String;
    .param p4, "link"    # Ljava/lang/String;
    .param p5, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 371
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p2}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p3}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 372
    :cond_0
    if-eqz p5, :cond_1

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Board Id, note, Image cannot be empty"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p5, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 381
    :cond_1
    :goto_0
    return-void

    .line 375
    :cond_2
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 376
    .local v0, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "board"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 377
    const-string v1, "note"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 378
    invoke-static {p4}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "link"

    invoke-virtual {v0, v1, p4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 379
    :cond_3
    invoke-static {p3}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4

    const-string v1, "image_url"

    invoke-virtual {v0, v1, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 380
    :cond_4
    const-string v1, "pins/"

    invoke-virtual {p0, v1, v0, p5}, Lcom/pinterest/android/pdk/PDKClient;->postPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    goto :goto_0
.end method

.method public deleteBoard(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "boardId"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 341
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 342
    if-eqz p2, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Board Id cannot be empty"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 344
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "boards/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 345
    .local v0, "path":Ljava/lang/String;
    invoke-virtual {p0, v0, p2}, Lcom/pinterest/android/pdk/PDKClient;->deletePath(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 346
    return-void
.end method

.method public deletePath(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 244
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 245
    if-eqz p2, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Invalid path"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 251
    :cond_0
    :goto_0
    return-void

    .line 248
    :cond_1
    if-eqz p2, :cond_2

    invoke-virtual {p2, p1}, Lcom/pinterest/android/pdk/PDKCallback;->setPath(Ljava/lang/String;)V

    .line 249
    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "https://api.pinterest.com/v1/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 250
    .local v0, "url":Ljava/lang/String;
    const/4 v1, 0x0

    invoke-static {v0, v1, p2}, Lcom/pinterest/android/pdk/PDKClient;->deleteRequest(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)Lcom/android/volley/Request;

    goto :goto_0
.end method

.method public deletePin(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "pinId"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 384
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 385
    if-eqz p2, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Pin Id cannot be empty"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p2, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 387
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "pins/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 388
    .local v0, "path":Ljava/lang/String;
    invoke-virtual {p0, v0, p2}, Lcom/pinterest/android/pdk/PDKClient;->deletePath(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 389
    return-void
.end method

.method public getAccessToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 148
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    return-object v0
.end method

.method public getBoard(Ljava/lang/String;Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "boardId"    # Ljava/lang/String;
    .param p2, "fields"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 323
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 324
    if-eqz p3, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Invalid board Id"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 329
    :cond_0
    :goto_0
    return-void

    .line 327
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "boards/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 328
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p2}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p3}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    goto :goto_0
.end method

.method public getBoardPins(Ljava/lang/String;Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "boardId"    # Ljava/lang/String;
    .param p2, "fields"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 332
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 333
    if-eqz p3, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Invalid board Id"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 338
    :cond_0
    :goto_0
    return-void

    .line 336
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "boards/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pins/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 337
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p2}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p3}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    goto :goto_0
.end method

.method public getMe(Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 1
    .param p1, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 267
    const-string v0, "me/"

    invoke-virtual {p0, v0, p1}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 268
    return-void
.end method

.method public getMe(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 2
    .param p1, "fields"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 271
    const-string v0, "me/"

    invoke-direct {p0, p1}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 272
    return-void
.end method

.method public getMyBoards(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 2
    .param p1, "fields"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 280
    const-string v0, "me/boards/"

    .line 281
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 282
    return-void
.end method

.method public getMyFollowedBoards(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 2
    .param p1, "fields"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 300
    const-string v0, "me/following/boards/"

    .line 301
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 302
    return-void
.end method

.method public getMyFollowedInterests(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 2
    .param p1, "fields"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 305
    const-string v0, "me/following/interests/"

    .line 306
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 307
    return-void
.end method

.method public getMyFollowedUsers(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 2
    .param p1, "fields"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 295
    const-string v0, "me/following/users/"

    .line 296
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 297
    return-void
.end method

.method public getMyFollowers(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 2
    .param p1, "fields"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 290
    const-string v0, "me/followers/"

    .line 291
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 292
    return-void
.end method

.method public getMyLikes(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 2
    .param p1, "fields"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 285
    const-string v0, "me/likes/"

    .line 286
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 287
    return-void
.end method

.method public getMyPins(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 2
    .param p1, "fields"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 275
    const-string v0, "me/pins/"

    .line 276
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 277
    return-void
.end method

.method public getPath(Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 1
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 218
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0, p2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    .line 219
    return-void
.end method

.method public getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "path"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pinterest/android/pdk/PDKCallback;",
            ")V"
        }
    .end annotation

    .prologue
    .line 222
    .local p2, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 223
    if-eqz p3, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Invalid path"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 231
    :cond_0
    :goto_0
    return-void

    .line 226
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "https://api.pinterest.com/v1/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 227
    .local v0, "url":Ljava/lang/String;
    if-nez p2, :cond_2

    new-instance p2, Ljava/util/HashMap;

    .end local p2    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p2}, Ljava/util/HashMap;-><init>()V

    .line 228
    .restart local p2    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_2
    if-eqz p3, :cond_3

    invoke-virtual {p3, p1}, Lcom/pinterest/android/pdk/PDKCallback;->setPath(Ljava/lang/String;)V

    .line 229
    :cond_3
    if-eqz p3, :cond_4

    invoke-virtual {p3, p2}, Lcom/pinterest/android/pdk/PDKCallback;->setParams(Ljava/util/HashMap;)V

    .line 230
    :cond_4
    invoke-static {v0, p2, p3}, Lcom/pinterest/android/pdk/PDKClient;->getRequest(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)Lcom/android/volley/Request;

    goto :goto_0
.end method

.method public getPin(Ljava/lang/String;Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "pinId"    # Ljava/lang/String;
    .param p2, "fields"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 362
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 363
    if-eqz p3, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Invalid pin Id"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 368
    :cond_0
    :goto_0
    return-void

    .line 366
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "pins/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 367
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p2}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p3}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    goto :goto_0
.end method

.method public getUser(Ljava/lang/String;Ljava/lang/String;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "userId"    # Ljava/lang/String;
    .param p2, "fields"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;

    .prologue
    .line 312
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 313
    if-eqz p3, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Invalid user name/Id"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 318
    :cond_0
    :goto_0
    return-void

    .line 316
    :cond_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "users/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 317
    .local v0, "path":Ljava/lang/String;
    invoke-direct {p0, p2}, Lcom/pinterest/android/pdk/PDKClient;->getMapWithFields(Ljava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {p0, v0, v1, p3}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    goto :goto_0
.end method

.method public login(Landroid/content/Context;Ljava/util/List;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pinterest/android/pdk/PDKCallback;",
            ")V"
        }
    .end annotation

    .prologue
    .line 159
    .local p2, "permissions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p3, p0, Lcom/pinterest/android/pdk/PDKClient;->_authCallback:Lcom/pinterest/android/pdk/PDKCallback;

    .line 160
    invoke-static {p2}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 161
    if-eqz p3, :cond_0

    new-instance v0, Lcom/pinterest/android/pdk/PDKException;

    const-string v1, "Scopes cannot be empty"

    invoke-direct {v0, v1}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v0}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 190
    :cond_0
    :goto_0
    return-void

    .line 164
    :cond_1
    instance-of v0, p1, Landroid/app/Activity;

    if-nez v0, :cond_2

    .line 165
    if-eqz p3, :cond_0

    new-instance v0, Lcom/pinterest/android/pdk/PDKException;

    const-string v1, "Please pass Activity context with login request"

    invoke-direct {v0, v1}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v0}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    goto :goto_0

    .line 168
    :cond_2
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    sput-object v0, Lcom/pinterest/android/pdk/PDKClient;->_requestedScopes:Ljava/util/Set;

    .line 169
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_requestedScopes:Ljava/util/Set;

    invoke-interface {v0, p2}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 170
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    invoke-static {v0}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_scopes:Ljava/util/Set;

    invoke-static {v0}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 171
    const-string v0, "oauth/inspect"

    const/4 v1, 0x0

    new-instance v2, Lcom/pinterest/android/pdk/PDKClient$1;

    invoke-direct {v2, p0, p1, p2}, Lcom/pinterest/android/pdk/PDKClient$1;-><init>(Lcom/pinterest/android/pdk/PDKClient;Landroid/content/Context;Ljava/util/List;)V

    invoke-virtual {p0, v0, v1, v2}, Lcom/pinterest/android/pdk/PDKClient;->getPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V

    goto :goto_0

    .line 188
    :cond_3
    invoke-direct {p0, p1, p2}, Lcom/pinterest/android/pdk/PDKClient;->initiateLogin(Landroid/content/Context;Ljava/util/List;)V

    goto :goto_0
.end method

.method public logout()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 152
    sput-object v0, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    .line 153
    sput-object v0, Lcom/pinterest/android/pdk/PDKClient;->_scopes:Ljava/util/Set;

    .line 154
    invoke-static {}, Lcom/pinterest/android/pdk/PDKClient;->cancelPendingRequests()V

    .line 155
    invoke-direct {p0, v0}, Lcom/pinterest/android/pdk/PDKClient;->saveAccessToken(Ljava/lang/String;)V

    .line 156
    invoke-direct {p0, v0}, Lcom/pinterest/android/pdk/PDKClient;->saveScopes(Ljava/util/Set;)V

    .line 157
    return-void
.end method

.method public onConnect(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 205
    instance-of v2, p1, Landroid/app/Activity;

    if-nez v2, :cond_1

    .line 206
    iget-object v2, p0, Lcom/pinterest/android/pdk/PDKClient;->_authCallback:Lcom/pinterest/android/pdk/PDKCallback;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/pinterest/android/pdk/PDKClient;->_authCallback:Lcom/pinterest/android/pdk/PDKCallback;

    new-instance v3, Lcom/pinterest/android/pdk/PDKException;

    const-string v4, "Please pass Activity context with onConnect request"

    invoke-direct {v3, v4}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 215
    :cond_0
    :goto_0
    return-void

    :cond_1
    move-object v0, p1

    .line 209
    check-cast v0, Landroid/app/Activity;

    .line 210
    .local v0, "activity":Landroid/app/Activity;
    const-string v2, "android.intent.action.VIEW"

    invoke-virtual {v0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 211
    invoke-virtual {v0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    .line 212
    .local v1, "uri":Landroid/net/Uri;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "pdk"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcom/pinterest/android/pdk/PDKClient;->_clientId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "://"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 213
    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/pinterest/android/pdk/PDKClient;->onOauthResponse(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onOauthResponse(IILandroid/content/Intent;)V
    .locals 4
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v3, 0x0

    .line 193
    const/16 v0, 0x2244

    if-ne p1, v0, :cond_0

    .line 194
    const/4 v0, -0x1

    if-ne p2, v0, :cond_1

    .line 195
    const-string v0, "PDK: result - %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const-string v2, "PDKCLIENT_EXTRA_RESULT"

    invoke-virtual {p3, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Lcom/pinterest/android/pdk/Utils;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 196
    const-string v0, "PDKCLIENT_EXTRA_RESULT"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/pinterest/android/pdk/PDKClient;->onOauthResponse(Ljava/lang/String;)V

    .line 202
    :cond_0
    :goto_0
    return-void

    .line 198
    :cond_1
    const-string v0, "PDK: Authentication failed"

    new-array v1, v3, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/pinterest/android/pdk/Utils;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 199
    iget-object v0, p0, Lcom/pinterest/android/pdk/PDKClient;->_authCallback:Lcom/pinterest/android/pdk/PDKCallback;

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Authentication failed"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    goto :goto_0
.end method

.method public postPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "path"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pinterest/android/pdk/PDKCallback;",
            ")V"
        }
    .end annotation

    .prologue
    .line 234
    .local p2, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 235
    if-eqz p3, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Invalid path"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 241
    :cond_0
    :goto_0
    return-void

    .line 238
    :cond_1
    if-eqz p3, :cond_2

    invoke-virtual {p3, p1}, Lcom/pinterest/android/pdk/PDKCallback;->setPath(Ljava/lang/String;)V

    .line 239
    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "https://api.pinterest.com/v1/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 240
    .local v0, "url":Ljava/lang/String;
    invoke-static {v0, p2, p3}, Lcom/pinterest/android/pdk/PDKClient;->postRequest(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)Lcom/android/volley/Request;

    goto :goto_0
.end method

.method public putPath(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)V
    .locals 3
    .param p1, "path"    # Ljava/lang/String;
    .param p3, "callback"    # Lcom/pinterest/android/pdk/PDKCallback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/pinterest/android/pdk/PDKCallback;",
            ")V"
        }
    .end annotation

    .prologue
    .line 254
    .local p2, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p1}, Lcom/pinterest/android/pdk/Utils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 255
    if-eqz p3, :cond_0

    new-instance v1, Lcom/pinterest/android/pdk/PDKException;

    const-string v2, "Invalid path"

    invoke-direct {v1, v2}, Lcom/pinterest/android/pdk/PDKException;-><init>(Ljava/lang/String;)V

    invoke-virtual {p3, v1}, Lcom/pinterest/android/pdk/PDKCallback;->onFailure(Lcom/pinterest/android/pdk/PDKException;)V

    .line 261
    :cond_0
    :goto_0
    return-void

    .line 258
    :cond_1
    if-eqz p3, :cond_2

    invoke-virtual {p3, p1}, Lcom/pinterest/android/pdk/PDKCallback;->setPath(Ljava/lang/String;)V

    .line 259
    :cond_2
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "https://api.pinterest.com/v1/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 260
    .local v0, "url":Ljava/lang/String;
    invoke-static {v0, p2, p3}, Lcom/pinterest/android/pdk/PDKClient;->putRequest(Ljava/lang/String;Ljava/util/HashMap;Lcom/pinterest/android/pdk/PDKCallback;)Lcom/android/volley/Request;

    goto :goto_0
.end method

.method public setAccessToken(Ljava/lang/String;)V
    .locals 1
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 138
    sput-object p1, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    .line 139
    sget-object v0, Lcom/pinterest/android/pdk/PDKClient;->_accessToken:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/pinterest/android/pdk/PDKClient;->saveAccessToken(Ljava/lang/String;)V

    .line 140
    return-void
.end method
