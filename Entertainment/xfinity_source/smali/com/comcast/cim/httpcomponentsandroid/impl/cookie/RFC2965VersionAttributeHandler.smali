.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965VersionAttributeHandler;
.super Ljava/lang/Object;
.source "RFC2965VersionAttributeHandler.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    return-void
.end method


# virtual methods
.method public match(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Z
    .locals 1
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    .prologue
    .line 95
    const/4 v0, 0x1

    return v0
.end method

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
    .line 58
    if-nez p1, :cond_0

    .line 59
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Cookie may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 61
    :cond_0
    if-nez p2, :cond_1

    .line 62
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    const-string v3, "Missing value for version attribute"

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 65
    :cond_1
    const/4 v1, -0x1

    .line 67
    .local v1, "version":I
    :try_start_0
    invoke-static {p2}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 71
    :goto_0
    if-gez v1, :cond_2

    .line 72
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    const-string v3, "Invalid cookie version."

    invoke-direct {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 68
    :catch_0
    move-exception v0

    .line 69
    .local v0, "e":Ljava/lang/NumberFormatException;
    const/4 v1, -0x1

    goto :goto_0

    .line 74
    .end local v0    # "e":Ljava/lang/NumberFormatException;
    :cond_2
    invoke-interface {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;->setVersion(I)V

    .line 75
    return-void
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
    .line 82
    if-nez p1, :cond_0

    .line 83
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 85
    :cond_0
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie2;

    if-eqz v0, :cond_1

    .line 86
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/cookie/ClientCookie;

    if-eqz v0, :cond_1

    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/cookie/ClientCookie;

    .end local p1    # "cookie":Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    const-string v0, "version"

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/ClientCookie;->containsAttribute(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 88
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieRestrictionViolationException;

    const-string v1, "Violates RFC 2965. Version attribute is required."

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieRestrictionViolationException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 92
    :cond_1
    return-void
.end method
