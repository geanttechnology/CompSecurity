.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965DiscardAttributeHandler;
.super Ljava/lang/Object;
.source "RFC2965DiscardAttributeHandler.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    return-void
.end method


# virtual methods
.method public match(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Z
    .locals 1
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    .prologue
    .line 64
    const/4 v0, 0x1

    return v0
.end method

.method public parse(Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;Ljava/lang/String;)V
    .locals 2
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;
    .param p2, "commenturl"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 53
    instance-of v1, p1, Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie2;

    if-eqz v1, :cond_0

    move-object v0, p1

    .line 54
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie2;

    .line 55
    .local v0, "cookie2":Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie2;
    const/4 v1, 0x1

    invoke-interface {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie2;->setDiscard(Z)V

    .line 57
    .end local v0    # "cookie2":Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie2;
    :cond_0
    return-void
.end method

.method public validate(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)V
    .locals 0
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 61
    return-void
.end method
