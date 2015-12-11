.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;
.source "NetscapeDraftSpec.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private final datepatterns:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 81
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;-><init>([Ljava/lang/String;)V

    .line 82
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 3
    .param p1, "datepatterns"    # [Ljava/lang/String;

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;-><init>()V

    .line 65
    if-eqz p1, :cond_0

    .line 66
    invoke-virtual {p1}, [Ljava/lang/String;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->datepatterns:[Ljava/lang/String;

    .line 70
    :goto_0
    const-string v0, "path"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicPathHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicPathHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 71
    const-string v0, "domain"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDomainHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDomainHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 72
    const-string v0, "max-age"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicMaxAgeHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicMaxAgeHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 73
    const-string v0, "secure"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicSecureHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicSecureHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 74
    const-string v0, "comment"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicCommentHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicCommentHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 75
    const-string v0, "expires"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicExpiresHandler;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->datepatterns:[Ljava/lang/String;

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicExpiresHandler;-><init>([Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 77
    return-void

    .line 68
    :cond_0
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "EEE, dd-MMM-yy HH:mm:ss z"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->datepatterns:[Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public formatCookies(Ljava/util/List;)Ljava/util/List;
    .locals 7
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

    .prologue
    .line 141
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;>;"
    if-nez p1, :cond_0

    .line 142
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "List of cookies may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 144
    :cond_0
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 145
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "List of cookies may not be empty"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 147
    :cond_1
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    mul-int/lit8 v5, v5, 0x14

    invoke-direct {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 148
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    const-string v5, "Cookie"

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 149
    const-string v5, ": "

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 150
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-ge v3, v5, :cond_4

    .line 151
    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;

    .line 152
    .local v1, "cookie":Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    if-lez v3, :cond_2

    .line 153
    const-string v5, "; "

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 155
    :cond_2
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 156
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 157
    .local v4, "s":Ljava/lang/String;
    if-eqz v4, :cond_3

    .line 158
    const-string v5, "="

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 159
    invoke-virtual {v0, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 150
    :cond_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 162
    .end local v1    # "cookie":Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .end local v4    # "s":Ljava/lang/String;
    :cond_4
    new-instance v2, Ljava/util/ArrayList;

    const/4 v5, 0x1

    invoke-direct {v2, v5}, Ljava/util/ArrayList;-><init>(I)V

    .line 163
    .local v2, "headers":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    new-instance v5, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;

    invoke-direct {v5, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;-><init>(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)V

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 164
    return-object v2
.end method

.method public getVersion()I
    .locals 1

    .prologue
    .line 168
    const/4 v0, 0x0

    return v0
.end method

.method public getVersionHeader()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 172
    const/4 v0, 0x0

    return-object v0
.end method

.method public parse(Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;
    .locals 7
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
    const/4 v6, 0x0

    .line 110
    if-nez p1, :cond_0

    .line 111
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Header may not be null"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 113
    :cond_0
    if-nez p2, :cond_1

    .line 114
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Cookie origin may not be null"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 116
    :cond_1
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "Set-Cookie"

    invoke-virtual {v4, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 117
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Unrecognized cookie header \'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\'"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 120
    :cond_2
    sget-object v2, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;

    .line 123
    .local v2, "parser":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;
    instance-of v4, p1, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    if-eqz v4, :cond_3

    move-object v4, p1

    .line 124
    check-cast v4, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;->getBuffer()Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v0

    .line 125
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    .end local p1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;->getValuePos()I

    move-result v4

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v5

    invoke-direct {v1, v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    .line 137
    .local v1, "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    :goto_0
    const/4 v4, 0x1

    new-array v4, v4, [Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    invoke-virtual {v2, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;->parseHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {p0, v4, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftSpec;->parse([Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;

    move-result-object v4

    return-object v4

    .line 129
    .end local v0    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .end local v1    # "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    .restart local p1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_3
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v3

    .line 130
    .local v3, "s":Ljava/lang/String;
    if-nez v3, :cond_4

    .line 131
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    const-string v5, "Header value is null"

    invoke-direct {v4, v5}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 133
    :cond_4
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    invoke-direct {v0, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 134
    .restart local v0    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    invoke-virtual {v0, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 135
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v4

    invoke-direct {v1, v6, v4}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    .restart local v1    # "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 177
    const-string v0, "netscape"

    return-object v0
.end method
