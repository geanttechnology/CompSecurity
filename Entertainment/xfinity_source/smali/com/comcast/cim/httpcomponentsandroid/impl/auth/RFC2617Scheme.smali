.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/auth/RFC2617Scheme;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;
.source "RFC2617Scheme.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private params:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;-><init>()V

    .line 62
    return-void
.end method


# virtual methods
.method public getParameter(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 100
    if-nez p1, :cond_0

    .line 101
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Parameter name may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/RFC2617Scheme;->params:Ljava/util/Map;

    if-nez v0, :cond_1

    .line 104
    const/4 v0, 0x0

    .line 106
    :goto_0
    return-object v0

    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/RFC2617Scheme;->params:Ljava/util/Map;

    sget-object v1, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {p1, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method protected getParameters()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/RFC2617Scheme;->params:Ljava/util/Map;

    if-nez v0, :cond_0

    .line 87
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/RFC2617Scheme;->params:Ljava/util/Map;

    .line 89
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/RFC2617Scheme;->params:Ljava/util/Map;

    return-object v0
.end method

.method public getRealm()Ljava/lang/String;
    .locals 1

    .prologue
    .line 115
    const-string v0, "realm"

    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/RFC2617Scheme;->getParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected parseChallenge(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;II)V
    .locals 10
    .param p1, "buffer"    # Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .param p2, "pos"    # I
    .param p3, "len"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;
        }
    .end annotation

    .prologue
    .line 67
    sget-object v6, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;->DEFAULT:Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderValueParser;

    .line 68
    .local v6, "parser":Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v7

    invoke-direct {v1, p2, v7}, Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;-><init>(II)V

    .line 69
    .local v1, "cursor":Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;
    invoke-interface {v6, p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderValueParser;->parseElements(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;Lcom/comcast/cim/httpcomponentsandroid/message/ParserCursor;)[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v3

    .line 70
    .local v3, "elements":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v7, v3

    if-nez v7, :cond_0

    .line 71
    new-instance v7, Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;

    const-string v8, "Authentication challenge is empty"

    invoke-direct {v7, v8}, Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 74
    :cond_0
    new-instance v7, Ljava/util/HashMap;

    array-length v8, v3

    invoke-direct {v7, v8}, Ljava/util/HashMap;-><init>(I)V

    iput-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/RFC2617Scheme;->params:Ljava/util/Map;

    .line 75
    move-object v0, v3

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_1

    aget-object v2, v0, v4

    .line 76
    .local v2, "element":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/RFC2617Scheme;->params:Ljava/util/Map;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v7, v8, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 78
    .end local v2    # "element":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    :cond_1
    return-void
.end method
