.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;
.super Ljava/lang/Object;
.source "AuthSchemeBase.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/auth/ContextAwareAuthScheme;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private proxy:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    return-void
.end method


# virtual methods
.method public authenticate(Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1
    .param p1, "credentials"    # Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/AuthenticationException;
        }
    .end annotation

    .prologue
    .line 124
    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;->authenticate(Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public isProxy()Z
    .locals 1

    .prologue
    .line 138
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;->proxy:Z

    return v0
.end method

.method protected abstract parseChallenge(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;II)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;
        }
    .end annotation
.end method

.method public processChallenge(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 9
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;
        }
    .end annotation

    .prologue
    .line 76
    if-nez p1, :cond_0

    .line 77
    new-instance v6, Ljava/lang/IllegalArgumentException;

    const-string v7, "Header may not be null"

    invoke-direct {v6, v7}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 79
    :cond_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v0

    .line 80
    .local v0, "authheader":Ljava/lang/String;
    const-string v6, "WWW-Authenticate"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 81
    const/4 v6, 0x0

    iput-boolean v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;->proxy:Z

    .line 90
    :goto_0
    instance-of v6, p1, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    if-eqz v6, :cond_3

    move-object v6, p1

    .line 91
    check-cast v6, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;->getBuffer()Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    move-result-object v2

    .line 92
    .local v2, "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;

    .end local p1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/FormattedHeader;->getValuePos()I

    move-result v4

    .line 102
    .local v4, "pos":I
    :goto_1
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v6

    if-ge v4, v6, :cond_5

    invoke-virtual {v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v6

    invoke-static {v6}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HTTP;->isWhitespace(C)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 103
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 82
    .end local v2    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    .end local v4    # "pos":I
    .restart local p1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_1
    const-string v6, "Proxy-Authenticate"

    invoke-virtual {v0, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 83
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;->proxy:Z

    goto :goto_0

    .line 85
    :cond_2
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Unexpected header name: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 94
    :cond_3
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v5

    .line 95
    .local v5, "s":Ljava/lang/String;
    if-nez v5, :cond_4

    .line 96
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;

    const-string v7, "Header value is null"

    invoke-direct {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 98
    :cond_4
    new-instance v2, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v6

    invoke-direct {v2, v6}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;-><init>(I)V

    .line 99
    .restart local v2    # "buffer":Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;
    invoke-virtual {v2, v5}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->append(Ljava/lang/String;)V

    .line 100
    const/4 v4, 0x0

    .restart local v4    # "pos":I
    goto :goto_1

    .line 105
    .end local v5    # "s":Ljava/lang/String;
    .end local p1    # "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_5
    move v1, v4

    .line 106
    .local v1, "beginIndex":I
    :goto_2
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v6

    if-ge v4, v6, :cond_6

    invoke-virtual {v2, v4}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->charAt(I)C

    move-result v6

    invoke-static {v6}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HTTP;->isWhitespace(C)Z

    move-result v6

    if-nez v6, :cond_6

    .line 107
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 109
    :cond_6
    move v3, v4

    .line 110
    .local v3, "endIndex":I
    invoke-virtual {v2, v1, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 111
    .restart local v5    # "s":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;->getSchemeName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_7

    .line 112
    new-instance v6, Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Invalid scheme identifier: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/comcast/cim/httpcomponentsandroid/auth/MalformedChallengeException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 115
    :cond_7
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;->length()I

    move-result v6

    invoke-virtual {p0, v2, v4, v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;->parseChallenge(Lcom/comcast/cim/httpcomponentsandroid/util/CharArrayBuffer;II)V

    .line 116
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/auth/AuthSchemeBase;->getSchemeName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
