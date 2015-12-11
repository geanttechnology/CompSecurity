.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2109VersionHandler;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieAttributeHandler;
.source "RFC2109VersionHandler.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieAttributeHandler;-><init>()V

    .line 46
    return-void
.end method


# virtual methods
.method public parse(Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;Ljava/lang/String;)V
    .locals 4
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 50
    if-nez p1, :cond_0

    .line 51
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Cookie may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 53
    :cond_0
    if-nez p2, :cond_1

    .line 54
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    const-string v2, "Missing value for version attribute"

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 56
    :cond_1
    invoke-virtual {p2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_2

    .line 57
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    const-string v2, "Blank value for version attribute"

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 60
    :cond_2
    :try_start_0
    invoke-static {p2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    invoke-interface {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;->setVersion(I)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 65
    return-void

    .line 61
    :catch_0
    move-exception v0

    .line 62
    .local v0, "e":Ljava/lang/NumberFormatException;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Invalid version: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/NumberFormatException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public validate(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)V
    .locals 2
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 70
    if-nez p1, :cond_0

    .line 71
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 73
    :cond_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;->getVersion()I

    move-result v0

    if-gez v0, :cond_1

    .line 74
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieRestrictionViolationException;

    const-string v1, "Cookie version may not be negative"

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieRestrictionViolationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 76
    :cond_1
    return-void
.end method
