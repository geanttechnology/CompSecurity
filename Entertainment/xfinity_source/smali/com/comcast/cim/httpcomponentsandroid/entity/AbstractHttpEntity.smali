.class public abstract Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;
.super Ljava/lang/Object;
.source "AbstractHttpEntity.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;


# instance fields
.field protected chunked:Z

.field protected contentEncoding:Lcom/comcast/cim/httpcomponentsandroid/Header;

.field protected contentType:Lcom/comcast/cim/httpcomponentsandroid/Header;


# direct methods
.method protected constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    return-void
.end method


# virtual methods
.method public getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;->contentEncoding:Lcom/comcast/cim/httpcomponentsandroid/Header;

    return-object v0
.end method

.method public getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;->contentType:Lcom/comcast/cim/httpcomponentsandroid/Header;

    return-object v0
.end method

.method public isChunked()Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;->chunked:Z

    return v0
.end method

.method public setChunked(Z)V
    .locals 0
    .param p1, "b"    # Z

    .prologue
    .line 169
    iput-boolean p1, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;->chunked:Z

    .line 170
    return-void
.end method

.method public setContentEncoding(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 0
    .param p1, "contentEncoding"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 134
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;->contentEncoding:Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 135
    return-void
.end method

.method public setContentEncoding(Ljava/lang/String;)V
    .locals 2
    .param p1, "ceString"    # Ljava/lang/String;

    .prologue
    .line 146
    const/4 v0, 0x0

    .line 147
    .local v0, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz p1, :cond_0

    .line 148
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    .end local v0    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    const-string v1, "Content-Encoding"

    invoke-direct {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 150
    .restart local v0    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_0
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;->setContentEncoding(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 151
    return-void
.end method

.method public setContentType(Lcom/comcast/cim/httpcomponentsandroid/Header;)V
    .locals 0
    .param p1, "contentType"    # Lcom/comcast/cim/httpcomponentsandroid/Header;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;->contentType:Lcom/comcast/cim/httpcomponentsandroid/Header;

    .line 106
    return-void
.end method

.method public setContentType(Ljava/lang/String;)V
    .locals 2
    .param p1, "ctString"    # Ljava/lang/String;

    .prologue
    .line 117
    const/4 v0, 0x0

    .line 118
    .local v0, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz p1, :cond_0

    .line 119
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;

    .end local v0    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    const-string v1, "Content-Type"

    invoke-direct {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeader;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    .restart local v0    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_0
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/entity/AbstractHttpEntity;->setContentType(Lcom/comcast/cim/httpcomponentsandroid/Header;)V

    .line 122
    return-void
.end method
