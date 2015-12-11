.class public final Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;
.super Ljava/lang/Object;
.source "HttpProtocolParams.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/params/CoreProtocolPNames;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    return-void
.end method

.method public static getHttpElementCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/lang/String;
    .locals 3
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 55
    if-nez p0, :cond_0

    .line 56
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP parameters may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 58
    :cond_0
    const-string v1, "http.protocol.element-charset"

    invoke-interface {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 60
    .local v0, "charset":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 61
    const-string v0, "US-ASCII"

    .line 63
    :cond_1
    return-object v0
.end method

.method public static getUserAgent(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/lang/String;
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 151
    if-nez p0, :cond_0

    .line 152
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 154
    :cond_0
    const-string v0, "http.useragent"

    invoke-interface {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public static getVersion(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 3
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 119
    if-nez p0, :cond_0

    .line 120
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP parameters may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 122
    :cond_0
    const-string v1, "http.protocol.version"

    invoke-interface {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 124
    .local v0, "param":Ljava/lang/Object;
    if-nez v0, :cond_1

    .line 125
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    .line 127
    .end local v0    # "param":Ljava/lang/Object;
    :goto_0
    return-object v0

    .restart local v0    # "param":Ljava/lang/Object;
    :cond_1
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    goto :goto_0
.end method

.method public static setContentCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .param p1, "charset"    # Ljava/lang/String;

    .prologue
    .line 105
    if-nez p0, :cond_0

    .line 106
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 108
    :cond_0
    const-string v0, "http.protocol.content-charset"

    invoke-interface {p0, v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 109
    return-void
.end method

.method public static setHttpElementCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .param p1, "charset"    # Ljava/lang/String;

    .prologue
    .line 73
    if-nez p0, :cond_0

    .line 74
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 76
    :cond_0
    const-string v0, "http.protocol.element-charset"

    invoke-interface {p0, v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 77
    return-void
.end method

.method public static setUseExpectContinue(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Z)V
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .param p1, "b"    # Z

    .prologue
    .line 192
    if-nez p0, :cond_0

    .line 193
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 195
    :cond_0
    const-string v0, "http.protocol.expect-continue"

    invoke-interface {p0, v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 196
    return-void
.end method

.method public static setUserAgent(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .param p1, "useragent"    # Ljava/lang/String;

    .prologue
    .line 164
    if-nez p0, :cond_0

    .line 165
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 167
    :cond_0
    const-string v0, "http.useragent"

    invoke-interface {p0, v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 168
    return-void
.end method

.method public static setVersion(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .param p1, "version"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    .prologue
    .line 137
    if-nez p0, :cond_0

    .line 138
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 140
    :cond_0
    const-string v0, "http.protocol.version"

    invoke-interface {p0, v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 141
    return-void
.end method

.method public static useExpectContinue(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Z
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 178
    if-nez p0, :cond_0

    .line 179
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 181
    :cond_0
    const-string v0, "http.protocol.expect-continue"

    const/4 v1, 0x0

    invoke-interface {p0, v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getBooleanParameter(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method
