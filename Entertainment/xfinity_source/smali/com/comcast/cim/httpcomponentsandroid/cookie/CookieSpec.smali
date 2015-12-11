.class public interface abstract Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieSpec;
.super Ljava/lang/Object;
.source "CookieSpec.java"


# virtual methods
.method public abstract formatCookies(Ljava/util/List;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getVersion()I
.end method

.method public abstract getVersionHeader()Lcom/comcast/cim/httpcomponentsandroid/Header;
.end method

.method public abstract match(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Z
.end method

.method public abstract parse(Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;",
            ">;"
        }
    .end annotation

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
