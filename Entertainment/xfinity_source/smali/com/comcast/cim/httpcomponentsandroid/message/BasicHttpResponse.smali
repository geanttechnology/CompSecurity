.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;
.super Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;
.source "BasicHttpResponse.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;


# instance fields
.field private entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

.field private locale:Ljava/util/Locale;

.field private reasonCatalog:Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;

.field private statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V
    .locals 2
    .param p1, "ver"    # Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .param p2, "code"    # I
    .param p3, "reason"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 99
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    invoke-direct {v0, p1, p2, p3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    invoke-direct {p0, v0, v1, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;Ljava/util/Locale;)V

    .line 100
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V
    .locals 1
    .param p1, "statusline"    # Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .prologue
    const/4 v0, 0x0

    .line 83
    invoke-direct {p0, p1, v0, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;-><init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;Ljava/util/Locale;)V

    .line 84
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;Ljava/util/Locale;)V
    .locals 2
    .param p1, "statusline"    # Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
    .param p2, "catalog"    # Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;
    .param p3, "locale"    # Ljava/util/Locale;

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/message/AbstractHttpMessage;-><init>()V

    .line 67
    if-nez p1, :cond_0

    .line 68
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Status line may not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 70
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .line 71
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->reasonCatalog:Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;

    .line 72
    if-eqz p3, :cond_1

    .end local p3    # "locale":Ljava/util/Locale;
    :goto_0
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->locale:Ljava/util/Locale;

    .line 73
    return-void

    .line 72
    .restart local p3    # "locale":Ljava/util/Locale;
    :cond_1
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object p3

    goto :goto_0
.end method


# virtual methods
.method public getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    return-object v0
.end method

.method public getLocale()Ljava/util/Locale;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->locale:Ljava/util/Locale;

    return-object v0
.end method

.method public getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    return-object v0
.end method

.method protected getReason(I)Ljava/lang/String;
    .locals 2
    .param p1, "code"    # I

    .prologue
    .line 190
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->reasonCatalog:Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->reasonCatalog:Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->locale:Ljava/util/Locale;

    invoke-interface {v0, p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/ReasonPhraseCatalog;->getReason(ILjava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getStatusLine()Lcom/comcast/cim/httpcomponentsandroid/StatusLine;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    return-object v0
.end method

.method public setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    .locals 0
    .param p1, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .prologue
    .line 166
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .line 167
    return-void
.end method

.method public setLocale(Ljava/util/Locale;)V
    .locals 4
    .param p1, "loc"    # Ljava/util/Locale;

    .prologue
    .line 171
    if-nez p1, :cond_0

    .line 172
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Locale may not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 174
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->locale:Ljava/util/Locale;

    .line 175
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v0

    .line 176
    .local v0, "code":I
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v2

    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->getReason(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v0, v3}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .line 178
    return-void
.end method

.method public setReasonPhrase(Ljava/lang/String;)V
    .locals 3
    .param p1, "reason"    # Ljava/lang/String;

    .prologue
    .line 154
    if-eqz p1, :cond_1

    const/16 v0, 0xa

    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-gez v0, :cond_0

    const/16 v0, 0xd

    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(I)I

    move-result v0

    if-ltz v0, :cond_1

    .line 157
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Line break in reason phrase."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 159
    :cond_1
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v1

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getStatusCode()I

    move-result v2

    invoke-direct {v0, v1, v2, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .line 162
    return-void
.end method

.method public setStatusCode(I)V
    .locals 3
    .param p1, "code"    # I

    .prologue
    .line 147
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/StatusLine;->getProtocolVersion()Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;

    move-result-object v0

    .line 148
    .local v0, "ver":Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;

    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->getReason(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v0, p1, v2}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicStatusLine;-><init>(Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;ILjava/lang/String;)V

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .line 149
    return-void
.end method

.method public setStatusLine(Lcom/comcast/cim/httpcomponentsandroid/StatusLine;)V
    .locals 2
    .param p1, "statusline"    # Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .prologue
    .line 125
    if-nez p1, :cond_0

    .line 126
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Status line may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 128
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    .line 129
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 195
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->statusline:Lcom/comcast/cim/httpcomponentsandroid/StatusLine;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpResponse;->headergroup:Lcom/comcast/cim/httpcomponentsandroid/message/HeaderGroup;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
