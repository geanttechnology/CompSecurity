.class public final Lcom/squareup/okhttp/internal/http/HttpAuthenticator;
.super Ljava/lang/Object;
.source "HttpAuthenticator.java"


# static fields
.field public static final SYSTEM_DEFAULT:Lcom/squareup/okhttp/OkAuthenticator;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    new-instance v0, Lcom/squareup/okhttp/internal/http/HttpAuthenticator$1;

    invoke-direct {v0}, Lcom/squareup/okhttp/internal/http/HttpAuthenticator$1;-><init>()V

    sput-object v0, Lcom/squareup/okhttp/internal/http/HttpAuthenticator;->SYSTEM_DEFAULT:Lcom/squareup/okhttp/OkAuthenticator;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 85
    return-void
.end method

.method private static parseChallenges(Lcom/squareup/okhttp/internal/http/Headers;Ljava/lang/String;)Ljava/util/List;
    .locals 12
    .param p0, "responseHeaders"    # Lcom/squareup/okhttp/internal/http/Headers;
    .param p1, "challengeHeader"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/squareup/okhttp/internal/http/Headers;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/squareup/okhttp/OkAuthenticator$Challenge;",
            ">;"
        }
    .end annotation

    .prologue
    .line 129
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 130
    .local v9, "result":Ljava/util/List;, "Ljava/util/List<Lcom/squareup/okhttp/OkAuthenticator$Challenge;>;"
    const/4 v6, 0x0

    .local v6, "h":I
    :goto_0
    invoke-virtual {p0}, Lcom/squareup/okhttp/internal/http/Headers;->size()I

    move-result v1

    if-ge v6, v1, :cond_2

    .line 131
    invoke-virtual {p0, v6}, Lcom/squareup/okhttp/internal/http/Headers;->name(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 130
    :cond_0
    add-int/lit8 v6, v6, 0x1

    goto :goto_0

    .line 134
    :cond_1
    invoke-virtual {p0, v6}, Lcom/squareup/okhttp/internal/http/Headers;->value(I)Ljava/lang/String;

    move-result-object v0

    .line 135
    .local v0, "value":Ljava/lang/String;
    const/4 v2, 0x0

    .line 136
    .local v2, "pos":I
    :goto_1
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-ge v2, v1, :cond_0

    .line 137
    move v11, v2

    .line 138
    .local v11, "tokenStart":I
    const-string/jumbo v1, " "

    invoke-static {v0, v2, v1}, Lcom/squareup/okhttp/internal/http/HeaderParser;->skipUntil(Ljava/lang/String;ILjava/lang/String;)I

    move-result v2

    .line 140
    invoke-virtual {v0, v11, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v10

    .line 141
    .local v10, "scheme":Ljava/lang/String;
    invoke-static {v0, v2}, Lcom/squareup/okhttp/internal/http/HeaderParser;->skipWhitespace(Ljava/lang/String;I)I

    move-result v2

    .line 147
    const/4 v1, 0x1

    const-string/jumbo v3, "realm=\""

    const/4 v4, 0x0

    const-string/jumbo v5, "realm=\""

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    invoke-virtual/range {v0 .. v5}, Ljava/lang/String;->regionMatches(ZILjava/lang/String;II)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 151
    const-string/jumbo v1, "realm=\""

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v2, v1

    .line 152
    move v8, v2

    .line 153
    .local v8, "realmStart":I
    const-string/jumbo v1, "\""

    invoke-static {v0, v2, v1}, Lcom/squareup/okhttp/internal/http/HeaderParser;->skipUntil(Ljava/lang/String;ILjava/lang/String;)I

    move-result v2

    .line 154
    invoke-virtual {v0, v8, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    .line 155
    .local v7, "realm":Ljava/lang/String;
    add-int/lit8 v2, v2, 0x1

    .line 156
    const-string/jumbo v1, ","

    invoke-static {v0, v2, v1}, Lcom/squareup/okhttp/internal/http/HeaderParser;->skipUntil(Ljava/lang/String;ILjava/lang/String;)I

    move-result v2

    .line 157
    add-int/lit8 v2, v2, 0x1

    .line 158
    invoke-static {v0, v2}, Lcom/squareup/okhttp/internal/http/HeaderParser;->skipWhitespace(Ljava/lang/String;I)I

    move-result v2

    .line 159
    new-instance v1, Lcom/squareup/okhttp/OkAuthenticator$Challenge;

    invoke-direct {v1, v10, v7}, Lcom/squareup/okhttp/OkAuthenticator$Challenge;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v9, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 162
    .end local v0    # "value":Ljava/lang/String;
    .end local v2    # "pos":I
    .end local v7    # "realm":Ljava/lang/String;
    .end local v8    # "realmStart":I
    .end local v10    # "scheme":Ljava/lang/String;
    .end local v11    # "tokenStart":I
    :cond_2
    return-object v9
.end method

.method public static processAuthHeader(Lcom/squareup/okhttp/OkAuthenticator;Lcom/squareup/okhttp/internal/http/Response;Ljava/net/Proxy;)Lcom/squareup/okhttp/internal/http/Request;
    .locals 9
    .param p0, "authenticator"    # Lcom/squareup/okhttp/OkAuthenticator;
    .param p1, "response"    # Lcom/squareup/okhttp/internal/http/Response;
    .param p2, "proxy"    # Ljava/net/Proxy;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    const/16 v8, 0x197

    .line 96
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v6

    const/16 v7, 0x191

    if-ne v6, v7, :cond_1

    .line 97
    const-string/jumbo v4, "WWW-Authenticate"

    .line 98
    .local v4, "responseField":Ljava/lang/String;
    const-string/jumbo v3, "Authorization"

    .line 105
    .local v3, "requestField":Ljava/lang/String;
    :goto_0
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->headers()Lcom/squareup/okhttp/internal/http/Headers;

    move-result-object v6

    invoke-static {v6, v4}, Lcom/squareup/okhttp/internal/http/HttpAuthenticator;->parseChallenges(Lcom/squareup/okhttp/internal/http/Headers;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 106
    .local v0, "challenges":Ljava/util/List;, "Ljava/util/List<Lcom/squareup/okhttp/OkAuthenticator$Challenge;>;"
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 115
    :cond_0
    :goto_1
    return-object v5

    .line 99
    .end local v0    # "challenges":Ljava/util/List;, "Ljava/util/List<Lcom/squareup/okhttp/OkAuthenticator$Challenge;>;"
    .end local v3    # "requestField":Ljava/lang/String;
    .end local v4    # "responseField":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v6

    if-ne v6, v8, :cond_2

    .line 100
    const-string/jumbo v4, "Proxy-Authenticate"

    .line 101
    .restart local v4    # "responseField":Ljava/lang/String;
    const-string/jumbo v3, "Proxy-Authorization"

    .restart local v3    # "requestField":Ljava/lang/String;
    goto :goto_0

    .line 103
    .end local v3    # "requestField":Ljava/lang/String;
    .end local v4    # "responseField":Ljava/lang/String;
    :cond_2
    new-instance v5, Ljava/lang/IllegalArgumentException;

    invoke-direct {v5}, Ljava/lang/IllegalArgumentException;-><init>()V

    throw v5

    .line 108
    .restart local v0    # "challenges":Ljava/util/List;, "Ljava/util/List<Lcom/squareup/okhttp/OkAuthenticator$Challenge;>;"
    .restart local v3    # "requestField":Ljava/lang/String;
    .restart local v4    # "responseField":Ljava/lang/String;
    :cond_3
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->request()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v2

    .line 109
    .local v2, "request":Lcom/squareup/okhttp/internal/http/Request;
    invoke-virtual {p1}, Lcom/squareup/okhttp/internal/http/Response;->code()I

    move-result v6

    if-ne v6, v8, :cond_4

    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v6

    invoke-interface {p0, p2, v6, v0}, Lcom/squareup/okhttp/OkAuthenticator;->authenticateProxy(Ljava/net/Proxy;Ljava/net/URL;Ljava/util/List;)Lcom/squareup/okhttp/OkAuthenticator$Credential;

    move-result-object v1

    .line 112
    .local v1, "credential":Lcom/squareup/okhttp/OkAuthenticator$Credential;
    :goto_2
    if-eqz v1, :cond_0

    .line 115
    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->newBuilder()Lcom/squareup/okhttp/internal/http/Request$Builder;

    move-result-object v5

    invoke-virtual {v1}, Lcom/squareup/okhttp/OkAuthenticator$Credential;->getHeaderValue()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v3, v6}, Lcom/squareup/okhttp/internal/http/Request$Builder;->header(Ljava/lang/String;Ljava/lang/String;)Lcom/squareup/okhttp/internal/http/Request$Builder;

    move-result-object v5

    invoke-virtual {v5}, Lcom/squareup/okhttp/internal/http/Request$Builder;->build()Lcom/squareup/okhttp/internal/http/Request;

    move-result-object v5

    goto :goto_1

    .line 109
    .end local v1    # "credential":Lcom/squareup/okhttp/OkAuthenticator$Credential;
    :cond_4
    invoke-virtual {v2}, Lcom/squareup/okhttp/internal/http/Request;->url()Ljava/net/URL;

    move-result-object v6

    invoke-interface {p0, p2, v6, v0}, Lcom/squareup/okhttp/OkAuthenticator;->authenticate(Ljava/net/Proxy;Ljava/net/URL;Ljava/util/List;)Lcom/squareup/okhttp/OkAuthenticator$Credential;

    move-result-object v1

    goto :goto_2
.end method
