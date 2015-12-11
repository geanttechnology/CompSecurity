.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
.super Ljava/lang/Object;
.source "CookieAttributeHandler.java"


# virtual methods
.method public abstract match(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Z
.end method

.method public abstract parse(Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation
.end method

.method public abstract validate(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation
.end method
