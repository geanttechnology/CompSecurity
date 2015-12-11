.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2109Spec;
.source "RFC2965Spec.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 63
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;-><init>([Ljava/lang/String;Z)V

    .line 64
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;Z)V
    .locals 2
    .param p1, "datepatterns"    # [Ljava/lang/String;
    .param p2, "oneHeader"    # Z

    .prologue
    .line 67
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2109Spec;-><init>([Ljava/lang/String;Z)V

    .line 68
    const-string v0, "domain"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965DomainAttributeHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965DomainAttributeHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 69
    const-string v0, "port"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965PortAttributeHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965PortAttributeHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 70
    const-string v0, "commenturl"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965CommentUrlAttributeHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965CommentUrlAttributeHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 71
    const-string v0, "discard"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965DiscardAttributeHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965DiscardAttributeHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 72
    const-string v0, "version"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965VersionAttributeHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965VersionAttributeHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 73
    return-void
.end method

.method private static adjustEffectiveHost(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    .locals 8
    .param p0, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    .prologue
    .line 211
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;->getHost()Ljava/lang/String;

    move-result-object v1

    .line 215
    .local v1, "host":Ljava/lang/String;
    const/4 v3, 0x1

    .line 216
    .local v3, "isLocalHost":Z
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v4

    if-ge v2, v4, :cond_1

    .line 217
    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 218
    .local v0, "ch":C
    const/16 v4, 0x2e

    if-eq v0, v4, :cond_0

    const/16 v4, 0x3a

    if-ne v0, v4, :cond_3

    .line 219
    :cond_0
    const/4 v3, 0x0

    .line 223
    .end local v0    # "ch":C
    :cond_1
    if-eqz v3, :cond_2

    .line 224
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ".local"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 225
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;->getPort()I

    move-result v5

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;->getPath()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;->isSecure()Z

    move-result v7

    invoke-direct {v4, v1, v5, v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;-><init>(Ljava/lang/String;ILjava/lang/String;Z)V

    move-object p0, v4

    .line 231
    .end local p0    # "origin":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    :cond_2
    return-object p0

    .line 216
    .restart local v0    # "ch":C
    .restart local p0    # "origin":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method private createCookies([Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;
    .locals 22
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
    .line 105
    new-instance v7, Ljava/util/ArrayList;

    move-object/from16 v0, p1

    array-length v0, v0

    move/from16 v19, v0

    move/from16 v0, v19

    invoke-direct {v7, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 106
    .local v7, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;>;"
    move-object/from16 v2, p1

    .local v2, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v14, v2

    .local v14, "len$":I
    const/4 v11, 0x0

    .local v11, "i$":I
    move v12, v11

    .end local v11    # "i$":I
    .local v12, "i$":I
    :goto_0
    if-ge v12, v14, :cond_5

    aget-object v10, v2, v12

    .line 107
    .local v10, "headerelement":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-interface {v10}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v15

    .line 108
    .local v15, "name":Ljava/lang/String;
    invoke-interface {v10}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v18

    .line 109
    .local v18, "value":Ljava/lang/String;
    if-eqz v15, :cond_0

    invoke-virtual {v15}, Ljava/lang/String;->length()I

    move-result v19

    if-nez v19, :cond_1

    .line 110
    :cond_0
    new-instance v19, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    const-string v20, "Cookie name may not be empty"

    invoke-direct/range {v19 .. v20}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v19

    .line 113
    :cond_1
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie2;

    move-object/from16 v0, v18

    invoke-direct {v6, v15, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie2;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    .local v6, "cookie":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie2;
    invoke-static/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->getDefaultPath(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie2;->setPath(Ljava/lang/String;)V

    .line 115
    invoke-static/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->getDefaultDomain(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie2;->setDomain(Ljava/lang/String;)V

    .line 116
    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [I

    move-object/from16 v19, v0

    const/16 v20, 0x0

    invoke-virtual/range {p2 .. p2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;->getPort()I

    move-result v21

    aput v21, v19, v20

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie2;->setPorts([I)V

    .line 118
    invoke-interface {v10}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getParameters()[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v5

    .line 122
    .local v5, "attribs":[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    new-instance v4, Ljava/util/HashMap;

    array-length v0, v5

    move/from16 v19, v0

    move/from16 v0, v19

    invoke-direct {v4, v0}, Ljava/util/HashMap;-><init>(I)V

    .line 124
    .local v4, "attribmap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    array-length v0, v5

    move/from16 v19, v0

    add-int/lit8 v13, v19, -0x1

    .local v13, "j":I
    :goto_1
    if-ltz v13, :cond_2

    .line 125
    aget-object v16, v5, v13

    .line 126
    .local v16, "param":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    invoke-interface/range {v16 .. v16}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v19

    sget-object v20, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    move-object/from16 v1, v16

    invoke-interface {v4, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 124
    add-int/lit8 v13, v13, -0x1

    goto :goto_1

    .line 128
    .end local v16    # "param":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    :cond_2
    invoke-interface {v4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v19

    invoke-interface/range {v19 .. v19}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .end local v12    # "i$":I
    .local v11, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_2
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v19

    if-eqz v19, :cond_4

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map$Entry;

    .line 129
    .local v8, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    invoke-interface {v8}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    .line 130
    .local v3, "attrib":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v19

    sget-object v20, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual/range {v19 .. v20}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v17

    .line 132
    .local v17, "s":Ljava/lang/String;
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v17

    move-object/from16 v1, v19

    invoke-virtual {v6, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie2;->setAttribute(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->findAttribHandler(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;

    move-result-object v9

    .line 135
    .local v9, "handler":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
    if-eqz v9, :cond_3

    .line 136
    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v19

    move-object/from16 v0, v19

    invoke-interface {v9, v6, v0}, Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;->parse(Lcom/comcast/cim/httpcomponentsandroid/cookie/SetCookie;Ljava/lang/String;)V

    goto :goto_2

    .line 139
    .end local v3    # "attrib":Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .end local v8    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    .end local v9    # "handler":Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;
    .end local v17    # "s":Ljava/lang/String;
    :cond_4
    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 106
    add-int/lit8 v11, v12, 0x1

    .local v11, "i$":I
    move v12, v11

    .end local v11    # "i$":I
    .restart local v12    # "i$":I
    goto/16 :goto_0

    .line 141
    .end local v4    # "attribmap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;>;"
    .end local v5    # "attribs":[Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;
    .end local v6    # "cookie":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicClientCookie2;
    .end local v10    # "headerelement":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v13    # "j":I
    .end local v15    # "name":Ljava/lang/String;
    .end local v18    # "value":Ljava/lang/String;
    :cond_5
    return-object v7
.end method


# virtual methods
.method protected formatCookieAsVer(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;I)V
    .locals 6
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .param p3, "version"    # I

    .prologue
    .line 175
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2109Spec;->formatCookieAsVer(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;I)V

    .line 177
    instance-of v4, p2, Lcom/comcast/cim/httpcomponentsandroid/cookie/ClientCookie;

    if-eqz v4, :cond_2

    move-object v4, p2

    .line 179
    check-cast v4, Lcom/comcast/cim/httpcomponentsandroid/cookie/ClientCookie;

    const-string v5, "port"

    invoke-interface {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/cookie/ClientCookie;->getAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 180
    .local v3, "s":Ljava/lang/String;
    if-eqz v3, :cond_2

    .line 181
    const-string v4, "; $Port"

    invoke-virtual {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 182
    const-string v4, "=\""

    invoke-virtual {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 183
    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_1

    .line 184
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;->getPorts()[I

    move-result-object v2

    .line 185
    .local v2, "ports":[I
    if-eqz v2, :cond_1

    .line 186
    const/4 v0, 0x0

    .local v0, "i":I
    array-length v1, v2

    .local v1, "len":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 187
    if-lez v0, :cond_0

    .line 188
    const-string v4, ","

    invoke-virtual {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 190
    :cond_0
    aget v4, v2, v0

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 186
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 194
    .end local v0    # "i":I
    .end local v1    # "len":I
    .end local v2    # "ports":[I
    :cond_1
    const-string v4, "\""

    invoke-virtual {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 197
    .end local v3    # "s":Ljava/lang/String;
    :cond_2
    return-void
.end method

.method public getVersion()I
    .locals 1

    .prologue
    .line 237
    const/4 v0, 0x1

    return v0
.end method

.method public getVersionHeader()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 2

    .prologue
    .line 242
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    const/16 v1, 0x28

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 243
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    const-string v1, "Cookie2"

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 244
    const-string v1, ": "

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 245
    const-string v1, "$Version="

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 246
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->getVersion()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 247
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;

    invoke-direct {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;-><init>(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)V

    return-object v1
.end method

.method public match(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Z
    .locals 2
    .param p1, "cookie"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    .prologue
    .line 159
    if-nez p1, :cond_0

    .line 160
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 162
    :cond_0
    if-nez p2, :cond_1

    .line 163
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie origin may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 165
    :cond_1
    invoke-static {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->adjustEffectiveHost(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    move-result-object p2

    .line 166
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2109Spec;->match(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Z

    move-result v0

    return v0
.end method

.method public parse(Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;
    .locals 4
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;
    .param p2, "origin"    # Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;
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

    .prologue
    .line 79
    if-nez p1, :cond_0

    .line 80
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Header may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 82
    :cond_0
    if-nez p2, :cond_1

    .line 83
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Cookie origin may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 85
    :cond_1
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Set-Cookie2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 86
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unrecognized cookie header \'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\'"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 89
    :cond_2
    invoke-static {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->adjustEffectiveHost(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    move-result-object p2

    .line 90
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v0

    .line 91
    .local v0, "elems":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-direct {p0, v0, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->createCookies([Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;

    move-result-object v1

    return-object v1
.end method

.method protected parse([Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;
    .locals 1
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
    .line 98
    invoke-static {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->adjustEffectiveHost(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    move-result-object p2

    .line 99
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->createCookies([Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 252
    const-string v0, "rfc2965"

    return-object v0
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
    .line 147
    if-nez p1, :cond_0

    .line 148
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 150
    :cond_0
    if-nez p2, :cond_1

    .line 151
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Cookie origin may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 153
    :cond_1
    invoke-static {p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2965Spec;->adjustEffectiveHost(Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;

    move-result-object p2

    .line 154
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/RFC2109Spec;->validate(Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)V

    .line 155
    return-void
.end method
