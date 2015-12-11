.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicSecureHandler;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieAttributeHandler;
.source "BasicSecureHandler.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieAttributeHandler;-><init>()V

    .line 45
    return-void
.end method


# virtual methods
.method public match(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Z
    .locals 2
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    .prologue
    .line 57
    if-nez p1, :cond_0

    .line 58
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 60
    :cond_0
    if-nez p2, :cond_1

    .line 61
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie origin may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 63
    :cond_1
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;->isSecure()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-virtual {p2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;->isSecure()Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_2
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public parse(Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;Ljava/lang/String;)V
    .locals 2
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 49
    if-nez p1, :cond_0

    .line 50
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :cond_0
    const/4 v0, 0x1

    invoke-interface {p1, v0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;->setSecure(Z)V

    .line 53
    return-void
.end method
