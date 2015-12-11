.class final Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;
.super Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;
.source "OptionsHttp11Response.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final statusLine:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

.field private final version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;


# direct methods
.method constructor <init>()V
    .locals 4

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;-><init>()V

    .line 51
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    const/16 v2, 0x1f5

    const-string v3, ""

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->statusLine:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .line 53
    sget-object v0, Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;->HTTP_1_1:Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    return-void
.end method


# virtual methods
.method public addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 0
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 127
    return-void
.end method

.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 132
    return-void
.end method

.method public containsHeader(Ljava/lang/String;)Z
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 101
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->containsHeader(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .locals 1

    .prologue
    .line 80
    const/4 v0, 0x0

    return-object v0
.end method

.method public getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 111
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 106
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public getLocale()Ljava/util/Locale;
    .locals 1

    .prologue
    .line 88
    const/4 v0, 0x0

    return-object v0
.end method

.method public getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    if-nez v0, :cond_0

    .line 172
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 174
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    return-object v0
.end method

.method public getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->version:Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    return-object v0
.end method

.method public getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->statusLine:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    return-object v0
.end method

.method public headerIterator()Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->iterator()Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v0

    return-object v0
.end method

.method public headerIterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/cache/OptionsHttp11Response;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->iterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v0

    return-object v0
.end method

.method public removeHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 0
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 152
    return-void
.end method

.method public removeHeaders(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 157
    return-void
.end method

.method public setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    .locals 0
    .param p1, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .prologue
    .line 85
    return-void
.end method

.method public setHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 0
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 137
    return-void
.end method

.method public setHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 142
    return-void
.end method

.method public setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 0
    .param p1, "headers"    # [Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 147
    return-void
.end method

.method public setLocale(Ljava/util/Locale;)V
    .locals 0
    .param p1, "loc"    # Ljava/util/Locale;

    .prologue
    .line 93
    return-void
.end method

.method public setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 0
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 180
    return-void
.end method

.method public setReasonPhrase(Ljava/lang/String;)V
    .locals 0
    .param p1, "reason"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 77
    return-void
.end method

.method public setStatusCode(I)V
    .locals 0
    .param p1, "code"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 73
    return-void
.end method

.method public setStatusLine(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V
    .locals 0
    .param p1, "statusline"    # Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .prologue
    .line 61
    return-void
.end method
