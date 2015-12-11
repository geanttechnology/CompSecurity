.class public abstract Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;
.super Ljava/lang/Object;
.source "AbstractHttpMessage.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpMessage;


# instance fields
.field protected headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

.field protected params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;-><init>(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V

    .line 57
    return-void
.end method

.method protected constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 1
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    .line 52
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 53
    return-void
.end method


# virtual methods
.method public addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 1
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 86
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 87
    return-void
.end method

.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 91
    if-nez p1, :cond_0

    .line 92
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Header name may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 94
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    invoke-direct {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->addHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 95
    return-void
.end method

.method public containsHeader(Ljava/lang/String;)Z
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 61
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->containsHeader(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->getHeaders(Ljava/lang/String;)[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    return-object v0
.end method

.method public getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    if-nez v0, :cond_0

    .line 146
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/params/BasicHttpParams;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 148
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    return-object v0
.end method

.method public headerIterator()Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->iterator()Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v0

    return-object v0
.end method

.method public headerIterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 140
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->iterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v0

    return-object v0
.end method

.method public removeHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 1
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->removeHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 118
    return-void
.end method

.method public removeHeaders(Ljava/lang/String;)V
    .locals 3
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 122
    if-nez p1, :cond_1

    .line 131
    :cond_0
    return-void

    .line 125
    :cond_1
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->iterator()Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v1

    .local v1, "i":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 126
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 127
    .local v0, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 128
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0
.end method

.method public setHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 1
    .param p1, "header"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 99
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->updateHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 100
    return-void
.end method

.method public setHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 104
    if-nez p1, :cond_0

    .line 105
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Header name may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 107
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    invoke-direct {v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->updateHeader(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 108
    return-void
.end method

.method public setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 1
    .param p1, "headers"    # [Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 112
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;->setHeaders([Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 113
    return-void
.end method

.method public setParams(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 2
    .param p1, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 153
    if-nez p1, :cond_0

    .line 154
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 156
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 157
    return-void
.end method
