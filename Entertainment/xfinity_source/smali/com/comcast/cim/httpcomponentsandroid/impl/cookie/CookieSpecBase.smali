.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieSpec;
.source "CookieSpecBase.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/AbstractCookieSpec;-><init>()V

    return-void
.end method

.method protected static getDefaultDomain(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/lang/String;
    .locals 1
    .param p0, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    .prologue
    .line 66
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;->getHost()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected static getDefaultPath(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/lang/String;
    .locals 3
    .param p0, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    .prologue
    .line 53
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 54
    .local v0, "defaultPath":Ljava/lang/String;
    const/16 v2, 0x2f

    invoke-virtual {v0, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    .line 55
    .local v1, "lastSlashIndex":I
    if-ltz v1, :cond_1

    .line 56
    if-nez v1, :cond_0

    .line 58
    const/4 v1, 0x1

    .line 60
    :cond_0
    const/4 v2, 0x0

    invoke-virtual {v0, v2, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 62
    :cond_1
    return-object v0
.end method


# virtual methods
.method public match(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Z
    .locals 4
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    .prologue
    .line 115
    if-nez p1, :cond_0

    .line 116
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Cookie may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 118
    :cond_0
    if-nez p2, :cond_1

    .line 119
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Cookie origin may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 121
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;->getAttribHandlers()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;

    .line 122
    .local v0, "handler":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;->match(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 123
    const/4 v2, 0x0

    .line 126
    .end local v0    # "handler":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
    :goto_0
    return v2

    :cond_3
    const/4 v2, 0x1

    goto :goto_0
.end method

.method protected parse([Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;
    .locals 16
    .param p1, "elems"    # [Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;",
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

    .prologue
    .line 71
    new-instance v5, Ljava/util/ArrayList;

    move-object/from16 v0, p1

    array-length v14, v0

    invoke-direct {v5, v14}, Ljava/util/ArrayList;-><init>(I)V

    .line 72
    .local v5, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;>;"
    move-object/from16 v1, p1

    .local v1, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v10, v1

    .local v10, "len$":I
    const/4 v8, 0x0

    .local v8, "i$":I
    :goto_0
    if-ge v8, v10, :cond_4

    aget-object v7, v1, v8

    .line 73
    .local v7, "headerelement":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-interface {v7}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v11

    .line 74
    .local v11, "name":Ljava/lang/String;
    invoke-interface {v7}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v13

    .line 75
    .local v13, "value":Ljava/lang/String;
    if-eqz v11, :cond_0

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v14

    if-nez v14, :cond_1

    .line 76
    :cond_0
    new-instance v14, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    const-string v15, "Cookie name may not be empty"

    invoke-direct {v14, v15}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 79
    :cond_1
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie;

    invoke-direct {v4, v11, v13}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    .local v4, "cookie":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie;
    invoke-static/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;->getDefaultPath(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v4, v14}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie;->setPath(Ljava/lang/String;)V

    .line 81
    invoke-static/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;->getDefaultDomain(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v4, v14}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie;->setDomain(Ljava/lang/String;)V

    .line 84
    invoke-interface {v7}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getParameters()[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v3

    .line 85
    .local v3, "attribs":[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    array-length v14, v3

    add-int/lit8 v9, v14, -0x1

    .local v9, "j":I
    :goto_1
    if-ltz v9, :cond_3

    .line 86
    aget-object v2, v3, v9

    .line 87
    .local v2, "attrib":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v14

    sget-object v15, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v14, v15}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v12

    .line 89
    .local v12, "s":Ljava/lang/String;
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v4, v12, v14}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;->findAttribHandler(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;

    move-result-object v6

    .line 92
    .local v6, "handler":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
    if-eqz v6, :cond_2

    .line 93
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v14

    invoke-interface {v6, v4, v14}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;->parse(Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;Ljava/lang/String;)V

    .line 85
    :cond_2
    add-int/lit8 v9, v9, -0x1

    goto :goto_1

    .line 96
    .end local v2    # "attrib":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .end local v6    # "handler":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
    .end local v12    # "s":Ljava/lang/String;
    :cond_3
    invoke-interface {v5, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 72
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 98
    .end local v3    # "attribs":[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .end local v4    # "cookie":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie;
    .end local v7    # "headerelement":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v9    # "j":I
    .end local v11    # "name":Ljava/lang/String;
    .end local v13    # "value":Ljava/lang/String;
    :cond_4
    return-object v5
.end method

.method public validate(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)V
    .locals 4
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;
        }
    .end annotation

    .prologue
    .line 103
    if-nez p1, :cond_0

    .line 104
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Cookie may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 106
    :cond_0
    if-nez p2, :cond_1

    .line 107
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string v3, "Cookie origin may not be null"

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 109
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;->getAttribHandlers()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;

    .line 110
    .local v0, "handler":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;->validate(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)V

    goto :goto_0

    .line 112
    .end local v0    # "handler":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
    :cond_2
    return-void
.end method
