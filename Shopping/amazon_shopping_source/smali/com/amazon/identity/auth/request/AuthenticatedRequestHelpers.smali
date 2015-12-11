.class public final Lcom/amazon/identity/auth/request/AuthenticatedRequestHelpers;
.super Ljava/lang/Object;
.source "AuthenticatedRequestHelpers.java"


# static fields
.field public static final DEFAULT_CONNECT_TO_SSO_TIMEOUT:J

.field public static final EXTRA_RESPONSE_HEADERS:Ljava/lang/String; = "auth.headers"

.field public static final IDENTITY_SIGNING_AUTH_TYPE:Ljava/lang/String; = "BustedIdentityADPAuthenticator"

.field public static final INTENT_ACTION_AUTH_REQUEST:Ljava/lang/String; = "com.amazon.dcp.sso.action.GET_DEVICE_CREDENTIALS"

.field public static final RESPONSE_CODE_CONNECTION_PROBLEM:I = 0x6

.field public static final RESPONSE_CODE_INVALID_ALGORITHM:I = 0x5

.field public static final RESPONSE_CODE_NO_CREDENTIALS:I = 0x2

.field public static final RESPONSE_CODE_REQUEST_BLACKLISTED:I = 0x3

.field public static final RESPONSE_CODE_SUCCESS:I = 0x1

.field public static final RESPONSE_CODE_UNKNOWN_ERROR:I = 0x5

.field public static final RESPONSE_CODE_UNRECONGIZED_AUTH_TYPE:I = 0x4


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 14
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0x14

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/request/AuthenticatedRequestHelpers;->DEFAULT_CONNECT_TO_SSO_TIMEOUT:J

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    return-void
.end method

.method public static getHeadersBundleInResponseBundle(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .param p0, "response"    # Landroid/os/Bundle;

    .prologue
    .line 70
    const-string/jumbo v0, "auth.headers"

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 71
    return-object v0
.end method

.method public static getHeadersInBundle(Landroid/os/Bundle;)Ljava/util/Map;
    .locals 5
    .param p0, "response"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Bundle;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 52
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 53
    .local v1, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v4, "auth.headers"

    invoke-virtual {p0, v4}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 55
    .local v0, "headerBundle":Landroid/os/Bundle;
    if-nez v0, :cond_1

    .line 65
    :cond_0
    return-object v1

    .line 60
    :cond_1
    invoke-virtual {v0}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 62
    .local v3, "key":Ljava/lang/String;
    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static setHeaderInBundle(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "response"    # Landroid/os/Bundle;
    .param p1, "headerName"    # Ljava/lang/String;
    .param p2, "headerValue"    # Ljava/lang/String;

    .prologue
    .line 39
    const-string/jumbo v1, "auth.headers"

    invoke-virtual {p0, v1}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 41
    .local v0, "headerBundle":Landroid/os/Bundle;
    if-nez v0, :cond_0

    .line 43
    new-instance v0, Landroid/os/Bundle;

    .end local v0    # "headerBundle":Landroid/os/Bundle;
    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 44
    .restart local v0    # "headerBundle":Landroid/os/Bundle;
    const-string/jumbo v1, "auth.headers"

    invoke-virtual {p0, v1, v0}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 47
    :cond_0
    invoke-virtual {v0, p1, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    return-void
.end method
