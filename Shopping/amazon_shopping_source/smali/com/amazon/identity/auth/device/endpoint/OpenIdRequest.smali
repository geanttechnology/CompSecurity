.class public Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;
.super Ljava/lang/Object;
.source "OpenIdRequest.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$TOKEN_SCOPE;,
        Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;,
        Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$Values;,
        Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$Tags;
    }
.end annotation


# static fields
.field public static final CLAIMED_ID_VALUE_SUBSTRING:Ljava/lang/String; = "/ap/id/"

.field public static final DEFAULT_AUTH_PORTAL_REGISTER_ENDPOINT:Ljava/lang/String; = "/ap/register"

.field public static final DEFAULT_AUTH_PORTAL_RETURN_TO_END_POINT:Ljava/lang/String; = "/gp/yourstore/home"

.field public static final DEFAULT_AUTH_PORTAL_SIGNIN_ENDPOINT:Ljava/lang/String; = "/ap/signin"

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mDebugParams:Ljava/util/Map;
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

.field private final mOptions:Landroid/os/Bundle;

.field private final mParams:Ljava/util/Map;
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

.field private mReturnToUrl:Ljava/lang/String;

.field private final mType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

.field private final mUriBuilder:Landroid/net/Uri$Builder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 134
    const-class v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;Landroid/os/Bundle;)V
    .locals 4
    .param p1, "clientId"    # Ljava/lang/String;
    .param p2, "type"    # Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .param p3, "options"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/lang/NullPointerException;
        }
    .end annotation

    .prologue
    .line 157
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 137
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    .line 158
    iput-object p2, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    .line 159
    iput-object p3, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mOptions:Landroid/os/Bundle;

    .line 161
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mOptions:Landroid/os/Bundle;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getRequestUriFromOptions(Landroid/os/Bundle;)Landroid/net/Uri;

    move-result-object v0

    .line 165
    .local v0, "requestUri":Landroid/net/Uri;
    if-nez v0, :cond_4

    .line 167
    new-instance v1, Landroid/net/Uri$Builder;

    invoke-direct {v1}, Landroid/net/Uri$Builder;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    .line 174
    :goto_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    const/4 v1, 0x0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v0}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v1

    :cond_0
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    :cond_1
    invoke-static {}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getInstance()Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;

    move-result-object v1

    iget-object v3, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mOptions:Landroid/os/Bundle;

    invoke-static {v3}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getPartialAmazonDomainFromAPIBundle(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/amazon/identity/auth/device/utils/EnvironmentUtils;->getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    :cond_2
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 176
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    const-string/jumbo v2, "https"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 178
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 180
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    sget-object v2, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->REGISTER:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    if-ne v1, v2, :cond_6

    .line 182
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    const-string/jumbo v2, "/ap/register"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 191
    :cond_3
    :goto_1
    const-string/jumbo v1, "amzn_device_na"

    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setAssociationHandle(Ljava/lang/String;)V

    .line 195
    invoke-direct {p0, p3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setClientOptions(Landroid/os/Bundle;)V

    .line 198
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.ns"

    const-string/jumbo v3, "http://specs.openid.net/auth/2.0"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 199
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.mode"

    const-string/jumbo v3, "checkid_setup"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 200
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.claimed_id"

    const-string/jumbo v3, "http://specs.openid.net/auth/2.0/identifier_select"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 201
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.identity"

    const-string/jumbo v3, "http://specs.openid.net/auth/2.0/identifier_select"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 202
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.ns.pape"

    const-string/jumbo v3, "http://specs.openid.net/extensions/pape/1.0"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 203
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.response_type"

    const-string/jumbo v3, "token"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 204
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.ns.oa2"

    const-string/jumbo v3, "http://www.amazon.com/ap/ext/oauth/2"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 205
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "accountStatusPolicy"

    const-string/jumbo v3, "P1"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 207
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v2, "openid.oa2.scope"

    const-string/jumbo v3, "device_auth_access"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 210
    const-string/jumbo v1, "0"

    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setMaxAuthAge(Ljava/lang/String;)V

    .line 213
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getDefaultReturnToURL()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setReturnToUrl(Ljava/lang/String;)V

    .line 217
    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setClientId(Ljava/lang/String;)V

    .line 219
    sget-object v1, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "OpenIdRequest created with reqType="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " host="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getHost()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 220
    return-void

    .line 171
    :cond_4
    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    goto/16 :goto_0

    .line 174
    :cond_5
    const-string/jumbo v1, "An unexpected error has occurred! Received null for URI host. This should not happen"

    sget-object v2, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    invoke-static {v2, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Ljava/lang/NullPointerException;

    invoke-direct {v2, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 186
    :cond_6
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    const-string/jumbo v2, "/ap/signin"

    invoke-virtual {v1, v2}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto/16 :goto_1
.end method

.method private appendParameterList(Landroid/net/Uri$Builder;)V
    .locals 4
    .param p1, "requestUrlBuilder"    # Landroid/net/Uri$Builder;

    .prologue
    .line 434
    iget-object v2, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mDebugParams:Ljava/util/Map;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mDebugParams:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 436
    iget-object v2, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mDebugParams:Ljava/util/Map;

    invoke-interface {v2, v3}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 437
    iget-object v2, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mDebugParams:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->clear()V

    .line 440
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 442
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p1, v2, v3}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    goto :goto_0

    .line 444
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    return-void
.end method

.method public static getRequestUriFromOptions(Landroid/os/Bundle;)Landroid/net/Uri;
    .locals 7
    .param p0, "options"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 513
    if-nez p0, :cond_1

    .line 560
    :cond_0
    :goto_0
    return-object v4

    .line 518
    :cond_1
    const-string/jumbo v5, "com.amazon.identity.auth.ChallengeException"

    invoke-virtual {p0, v5}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 519
    .local v0, "challenge":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 524
    const-string/jumbo v5, "com.amazon.identity.auth.ChallengeException.oAuthURI"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 525
    .local v2, "oAuthURI":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 531
    invoke-static {v2}, Landroid/webkit/URLUtil;->isValidUrl(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-static {v2}, Landroid/webkit/URLUtil;->isHttpsUrl(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 533
    :cond_2
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "Unusable OpenID URL received"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 534
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Unusable OpenID URL received: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_0

    .line 538
    :cond_3
    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 539
    .local v3, "uri":Landroid/net/Uri;
    invoke-virtual {v3}, Landroid/net/Uri;->isAbsolute()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-virtual {v3}, Landroid/net/Uri;->isHierarchical()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-virtual {v3}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_5

    .line 541
    :cond_4
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "Unusable OpenID URL received"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 542
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Unusable OpenID URL received: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto :goto_0

    .line 547
    :cond_5
    invoke-virtual {v3}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_6

    invoke-virtual {v3}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 549
    :cond_6
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v6, "Unusable OpenID URL received"

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 550
    sget-object v5, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Unusable OpenID URL received: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    goto/16 :goto_0

    .line 554
    :cond_7
    invoke-static {}, Lcom/amazon/identity/kcpsdk/common/LocaleUtil;->getLocaleAsJavaLocaleFormat()Ljava/lang/String;

    move-result-object v1

    .line 558
    .local v1, "languageTag":Ljava/lang/String;
    invoke-virtual {v3}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v4

    const-string/jumbo v5, "language"

    invoke-virtual {v4, v5, v1}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v4

    invoke-virtual {v4}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v4

    goto/16 :goto_0
.end method

.method private setClientOptions(Landroid/os/Bundle;)V
    .locals 13
    .param p1, "options"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    const/4 v12, 0x0

    .line 224
    if-nez p1, :cond_1

    .line 276
    :cond_0
    return-void

    .line 231
    :cond_1
    const-string/jumbo v8, "com.amazon.identity.ap.pageid"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 232
    .local v5, "pageId":Ljava/lang/String;
    if-eqz v5, :cond_2

    .line 234
    invoke-virtual {p0, v5}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setPageID(Ljava/lang/String;)V

    .line 237
    :cond_2
    const-string/jumbo v8, "com.amazon.identity.ap.assoc_handle"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    if-nez v8, :cond_5

    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getHost()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/identity/auth/device/utils/InternationalizationUtil;->getAuthPortalAssociationHandleForSpecificAmazonDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 242
    .local v0, "assocHandle":Ljava/lang/String;
    :goto_0
    if-eqz v0, :cond_3

    .line 244
    invoke-virtual {p0, v0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setAssociationHandle(Ljava/lang/String;)V

    .line 247
    :cond_3
    const-string/jumbo v8, "com.amazon.identity.ap.clientContext"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 249
    .local v1, "clientContext":Ljava/lang/String;
    if-eqz v1, :cond_4

    .line 251
    invoke-virtual {p0, v1}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->setClientContext(Ljava/lang/String;)V

    .line 255
    :cond_4
    const-string/jumbo v8, "com.amazon.identity.ap.request.parameters"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v6

    .line 257
    .local v6, "requestParameters":Landroid/os/Bundle;
    if-eqz v6, :cond_0

    .line 259
    invoke-virtual {v6}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 261
    .local v4, "key":Ljava/lang/String;
    invoke-virtual {v6, v4}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    .line 262
    .local v7, "value":Ljava/lang/Object;
    instance-of v8, v7, Ljava/lang/String;

    if-eqz v8, :cond_6

    .line 264
    iget-object v8, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    check-cast v7, Ljava/lang/String;

    .end local v7    # "value":Ljava/lang/Object;
    invoke-interface {v8, v4, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 237
    .end local v0    # "assocHandle":Ljava/lang/String;
    .end local v1    # "clientContext":Ljava/lang/String;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "key":Ljava/lang/String;
    .end local v6    # "requestParameters":Landroid/os/Bundle;
    :cond_5
    const-string/jumbo v8, "com.amazon.identity.ap.assoc_handle"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 269
    .restart local v0    # "assocHandle":Ljava/lang/String;
    .restart local v1    # "clientContext":Ljava/lang/String;
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "key":Ljava/lang/String;
    .restart local v6    # "requestParameters":Landroid/os/Bundle;
    .restart local v7    # "value":Ljava/lang/Object;
    :cond_6
    const-string/jumbo v8, "Invalid value type passed in for AuthPortalOptions.KEY_REQUEST_PARAMETERS, only strings are allowed, please us Bundle.putString. Object in violation key: %s object type: %s"

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v4, v9, v12

    const/4 v10, 0x1

    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 273
    .local v2, "error":Ljava/lang/String;
    sget-object v8, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->LOG_TAG:Ljava/lang/String;

    invoke-static {v8, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    new-instance v8, Ljava/lang/IllegalArgumentException;

    new-array v9, v12, [Ljava/lang/Object;

    invoke-static {v2, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v8
.end method


# virtual methods
.method public buildParameterList()Ljava/lang/String;
    .locals 2

    .prologue
    .line 425
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    .line 426
    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 427
    .local v0, "requestUrlBuilder":Landroid/net/Uri$Builder;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->appendParameterList(Landroid/net/Uri$Builder;)V

    .line 429
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->getEncodedQuery()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getCookieUrl()Ljava/lang/String;
    .locals 7

    .prologue
    .line 464
    iget-object v3, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    invoke-virtual {v3}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v2

    .line 465
    .local v2, "uri":Landroid/net/Uri;
    invoke-virtual {v2}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v1

    .line 466
    .local v1, "scheme":Ljava/lang/String;
    invoke-virtual {v2}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v0

    .line 468
    .local v0, "authority":Ljava/lang/String;
    sget-object v3, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string/jumbo v4, "%s://%s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v1, v5, v6

    const/4 v6, 0x1

    aput-object v0, v5, v6

    invoke-static {v3, v4, v5}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public getDefaultReturnToURL()Ljava/lang/String;
    .locals 2

    .prologue
    .line 486
    new-instance v0, Landroid/net/Uri$Builder;

    invoke-direct {v0}, Landroid/net/Uri$Builder;-><init>()V

    .line 487
    .local v0, "url":Landroid/net/Uri$Builder;
    const-string/jumbo v1, "https"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 488
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->getHost()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 489
    const-string/jumbo v1, "/gp/yourstore/home"

    invoke-virtual {v0, v1}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 491
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getHost()Ljava/lang/String;
    .locals 1

    .prologue
    .line 476
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getRequestType()Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;
    .locals 1

    .prologue
    .line 496
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mType:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    return-object v0
.end method

.method public getRequestUrl()Ljava/lang/String;
    .locals 2

    .prologue
    .line 455
    iget-object v1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    .line 456
    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    .line 457
    .local v0, "requestUrlBuilder":Landroid/net/Uri$Builder;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->appendParameterList(Landroid/net/Uri$Builder;)V

    .line 459
    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getReturnToUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 481
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mReturnToUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setAssociationHandle(Ljava/lang/String;)V
    .locals 2
    .param p1, "assocHandle"    # Ljava/lang/String;

    .prologue
    .line 370
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "openid.assoc_handle"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 371
    return-void
.end method

.method public setClaimedId(Ljava/lang/String;)V
    .locals 2
    .param p1, "claimedID"    # Ljava/lang/String;

    .prologue
    .line 352
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "openid.claimed_id"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 353
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "openid.identity"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 354
    return-void
.end method

.method public setClientContext(Ljava/lang/String;)V
    .locals 2
    .param p1, "clientContext"    # Ljava/lang/String;

    .prologue
    .line 386
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "clientContext"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 387
    return-void
.end method

.method public setClientId(Ljava/lang/String;)V
    .locals 4
    .param p1, "clientId"    # Ljava/lang/String;

    .prologue
    .line 408
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "openid.oa2.client_id"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "device:"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 409
    return-void
.end method

.method public setClientInfo(Ljava/lang/String;)V
    .locals 2
    .param p1, "clientInfo"    # Ljava/lang/String;

    .prologue
    .line 417
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "clientInfo"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 418
    return-void
.end method

.method public setDebugParams(Ljava/util/Map;)V
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
    .line 448
    .local p1, "debugParams":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mDebugParams:Ljava/util/Map;

    .line 449
    return-void
.end method

.method public setDisableLoginPrepopulate(Ljava/lang/String;)V
    .locals 2
    .param p1, "disableLoginPrepopulate"    # Ljava/lang/String;

    .prologue
    .line 344
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "disableLoginPrepopulate"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 345
    return-void
.end method

.method public setIgnoreAuthCookiesOnResponse(Z)V
    .locals 3
    .param p1, "ignoreAuthCookies"    # Z

    .prologue
    .line 329
    if-eqz p1, :cond_0

    .line 331
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "authCookies"

    const-string/jumbo v2, "0"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 337
    :goto_0
    return-void

    .line 335
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "authCookies"

    const-string/jumbo v2, "1"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public setMaxAuthAge(Ljava/lang/String;)V
    .locals 2
    .param p1, "maxAuthAge"    # Ljava/lang/String;

    .prologue
    .line 316
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "openid.pape.max_auth_age"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 317
    return-void
.end method

.method public setPageID(Ljava/lang/String;)V
    .locals 2
    .param p1, "pageId"    # Ljava/lang/String;

    .prologue
    .line 378
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "pageId"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 379
    return-void
.end method

.method public setPath(Ljava/lang/String;)V
    .locals 2
    .param p1, "path"    # Ljava/lang/String;

    .prologue
    .line 395
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 397
    new-instance v0, Ljava/lang/NullPointerException;

    const-string/jumbo v1, "AuthPortal end point cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 400
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mUriBuilder:Landroid/net/Uri$Builder;

    invoke-virtual {v0, p1}, Landroid/net/Uri$Builder;->path(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 401
    return-void
.end method

.method public setReturnToUrl(Ljava/lang/String;)V
    .locals 2
    .param p1, "returnToUrl"    # Ljava/lang/String;

    .prologue
    .line 361
    iput-object p1, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mReturnToUrl:Ljava/lang/String;

    .line 362
    iget-object v0, p0, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest;->mParams:Ljava/util/Map;

    const-string/jumbo v1, "openid.return_to"

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 363
    return-void
.end method
