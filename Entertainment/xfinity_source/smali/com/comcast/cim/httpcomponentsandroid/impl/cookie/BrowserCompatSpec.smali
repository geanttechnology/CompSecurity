.class public Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;
.source "BrowserCompatSpec.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# static fields
.field protected static final DATE_PATTERNS:[Ljava/lang/String;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation
.end field

.field private static final DEFAULT_DATE_PATTERNS:[Ljava/lang/String;


# instance fields
.field private final datepatterns:[Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 59
    const/16 v0, 0xe

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "EEE, dd MMM yyyy HH:mm:ss zzz"

    aput-object v1, v0, v3

    const-string v1, "EEEE, dd-MMM-yy HH:mm:ss zzz"

    aput-object v1, v0, v4

    const-string v1, "EEE MMM d HH:mm:ss yyyy"

    aput-object v1, v0, v5

    const-string v1, "EEE, dd-MMM-yyyy HH:mm:ss z"

    aput-object v1, v0, v6

    const-string v1, "EEE, dd-MMM-yyyy HH-mm-ss z"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "EEE, dd MMM yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "EEE dd-MMM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "EEE dd MMM yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "EEE dd-MMM-yyyy HH-mm-ss z"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "EEE dd-MMM-yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "EEE dd MMM yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "EEE,dd-MMM-yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "EEE,dd-MMM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "EEE, dd-MM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->DATE_PATTERNS:[Ljava/lang/String;

    .line 76
    const/16 v0, 0xe

    new-array v0, v0, [Ljava/lang/String;

    const-string v1, "EEE, dd MMM yyyy HH:mm:ss zzz"

    aput-object v1, v0, v3

    const-string v1, "EEEE, dd-MMM-yy HH:mm:ss zzz"

    aput-object v1, v0, v4

    const-string v1, "EEE MMM d HH:mm:ss yyyy"

    aput-object v1, v0, v5

    const-string v1, "EEE, dd-MMM-yyyy HH:mm:ss z"

    aput-object v1, v0, v6

    const-string v1, "EEE, dd-MMM-yyyy HH-mm-ss z"

    aput-object v1, v0, v7

    const/4 v1, 0x5

    const-string v2, "EEE, dd MMM yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string v2, "EEE dd-MMM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string v2, "EEE dd MMM yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string v2, "EEE dd-MMM-yyyy HH-mm-ss z"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string v2, "EEE dd-MMM-yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string v2, "EEE dd MMM yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string v2, "EEE,dd-MMM-yy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string v2, "EEE,dd-MMM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string v2, "EEE, dd-MM-yyyy HH:mm:ss z"

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->DEFAULT_DATE_PATTERNS:[Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 114
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;-><init>([Ljava/lang/String;)V

    .line 115
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 3
    .param p1, "datepatterns"    # [Ljava/lang/String;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/CookieSpecBase;-><init>()V

    .line 98
    if-eqz p1, :cond_0

    .line 99
    invoke-virtual {p1}, [Ljava/lang/String;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->datepatterns:[Ljava/lang/String;

    .line 103
    :goto_0
    const-string v0, "path"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicPathHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicPathHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 104
    const-string v0, "domain"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicDomainHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicDomainHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 105
    const-string v0, "max-age"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicMaxAgeHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicMaxAgeHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 106
    const-string v0, "secure"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicSecureHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicSecureHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 107
    const-string v0, "comment"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicCommentHandler;

    invoke-direct {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicCommentHandler;-><init>()V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 108
    const-string v0, "expires"

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicExpiresHandler;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->datepatterns:[Ljava/lang/String;

    invoke-direct {v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BasicExpiresHandler;-><init>([Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->registerAttribHandler(Ljava/lang/String;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieAttributeHandler;)V

    .line 110
    return-void

    .line 101
    :cond_0
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->DEFAULT_DATE_PATTERNS:[Ljava/lang/String;

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->datepatterns:[Ljava/lang/String;

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
    .line 167
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;>;"
    if-nez p1, :cond_0

    .line 168
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "List of cookies may not be null"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 170
    :cond_0
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 171
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string v6, "List of cookies may not be empty"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 173
    :cond_1
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    mul-int/lit8 v5, v5, 0x14

    invoke-direct {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 174
    .local v0, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    const-string v5, "Cookie"

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 175
    const-string v5, ": "

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 176
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-ge v3, v5, :cond_4

    .line 177
    invoke-interface {p1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;

    .line 178
    .local v1, "cookie":Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    if-lez v3, :cond_2

    .line 179
    const-string v5, "; "

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 181
    :cond_2
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 182
    const-string v5, "="

    invoke-virtual {v0, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 183
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 184
    .local v4, "s":Ljava/lang/String;
    if-eqz v4, :cond_3

    .line 185
    invoke-virtual {v0, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 176
    :cond_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 188
    .end local v1    # "cookie":Lcom/comcast/cim/httpcomponentsandroid/cookie/Cookie;
    .end local v4    # "s":Ljava/lang/String;
    :cond_4
    new-instance v2, Ljava/util/ArrayList;

    const/4 v5, 0x1

    invoke-direct {v2, v5}, Ljava/util/ArrayList;-><init>(I)V

    .line 189
    .local v2, "headers":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    new-instance v5, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;

    invoke-direct {v5, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BufferedHeader;-><init>(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;)V

    invoke-interface {v2, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 190
    return-object v2
.end method

.method public getVersion()I
    .locals 1

    .prologue
    .line 194
    const/4 v0, 0x0

    return v0
.end method

.method public getVersionHeader()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 198
    const/4 v0, 0x0

    return-object v0
.end method

.method public parse(Lcom/comcast/cim/httpcomponentsandroid/Header;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;
    .locals 17
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
    .line 119
    if-nez p1, :cond_0

    .line 120
    new-instance v14, Ljava/lang/IllegalArgumentException;

    const-string v15, "Header may not be null"

    invoke-direct {v14, v15}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 122
    :cond_0
    if-nez p2, :cond_1

    .line 123
    new-instance v14, Ljava/lang/IllegalArgumentException;

    const-string v15, "Cookie origin may not be null"

    invoke-direct {v14, v15}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 125
    :cond_1
    invoke-interface/range {p1 .. p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v5

    .line 126
    .local v5, "headername":Ljava/lang/String;
    const-string v14, "Set-Cookie"

    invoke-virtual {v5, v14}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_2

    .line 127
    new-instance v14, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    new-instance v15, Ljava/lang/StringBuilder;

    invoke-direct {v15}, Ljava/lang/StringBuilder;-><init>()V

    const-string v16, "Unrecognized cookie header \'"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual/range {p1 .. p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "\'"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-direct {v14, v15}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 130
    :cond_2
    invoke-interface/range {p1 .. p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v7

    .line 131
    .local v7, "helems":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const/4 v13, 0x0

    .line 132
    .local v13, "versioned":Z
    const/4 v10, 0x0

    .line 133
    .local v10, "netscape":Z
    move-object v2, v7

    .local v2, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v9, v2

    .local v9, "len$":I
    const/4 v8, 0x0

    .local v8, "i$":I
    :goto_0
    if-ge v8, v9, :cond_5

    aget-object v6, v2, v8

    .line 134
    .local v6, "helem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const-string v14, "version"

    invoke-interface {v6, v14}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getParameterByName(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v14

    if-eqz v14, :cond_3

    .line 135
    const/4 v13, 0x1

    .line 137
    :cond_3
    const-string v14, "expires"

    invoke-interface {v6, v14}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getParameterByName(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/NameValuePair;

    move-result-object v14

    if-eqz v14, :cond_4

    .line 138
    const/4 v10, 0x1

    .line 133
    :cond_4
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 141
    .end local v6    # "helem":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_5
    if-nez v10, :cond_6

    if-nez v13, :cond_7

    .line 144
    :cond_6
    sget-object v11, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;

    .line 147
    .local v11, "parser":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;
    move-object/from16 v0, p1

    instance-of v14, v0, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    if-eqz v14, :cond_8

    move-object/from16 v14, p1

    .line 148
    check-cast v14, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    invoke-interface {v14}, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;->getBuffer()Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v3

    .line 149
    .local v3, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    .end local p1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface/range {p1 .. p1}, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;->getValuePos()I

    move-result v14

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v15

    invoke-direct {v4, v14, v15}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    .line 161
    .local v4, "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    :goto_1
    const/4 v14, 0x1

    new-array v7, v14, [Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    .end local v7    # "helems":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    const/4 v14, 0x0

    invoke-virtual {v11, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;->parseHeader(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v15

    aput-object v15, v7, v14

    .line 163
    .end local v3    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .end local v4    # "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    .end local v11    # "parser":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;
    .restart local v7    # "helems":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_7
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-virtual {v0, v7, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/BrowserCompatSpec;->parse([Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;Lcom/comcast/cim/httpcomponentsandroid/cookie/CookieOrigin;)Ljava/util/List;

    move-result-object v14

    return-object v14

    .line 153
    .restart local v11    # "parser":Lcom/comcast/cim/httpcomponentsandroid/impl/cookie/NetscapeDraftHeaderParser;
    .restart local p1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_8
    invoke-interface/range {p1 .. p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v12

    .line 154
    .local v12, "s":Ljava/lang/String;
    if-nez v12, :cond_9

    .line 155
    new-instance v14, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;

    const-string v15, "Header value is null"

    invoke-direct {v14, v15}, Lcom/comcast/cim/httpcomponentsandroid/cookie/MalformedCookieException;-><init>(Ljava/lang/String;)V

    throw v14

    .line 157
    :cond_9
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v12}, Ljava/lang/String;->length()I

    move-result v14

    invoke-direct {v3, v14}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 158
    .restart local v3    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    invoke-virtual {v3, v12}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 159
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    const/4 v14, 0x0

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v15

    invoke-direct {v4, v14, v15}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    .restart local v4    # "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    goto :goto_1
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 203
    const-string v0, "compatibility"

    return-object v0
.end method
