.class public Lcom/comcast/cim/httpcomponentsandroid/client/protocol/ResponseContentEncoding;
.super Ljava/lang/Object;
.source "ResponseContentEncoding.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpResponseInterceptor;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public process(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 11
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 72
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v5

    .line 75
    .local v5, "entity":Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    if-eqz v5, :cond_1

    .line 76
    invoke-interface {v5}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentEncoding()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v1

    .line 77
    .local v1, "ceheader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v1, :cond_1

    .line 78
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getElements()[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v4

    .line 79
    .local v4, "codecs":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    move-object v0, v4

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    array-length v7, v0

    .local v7, "len$":I
    const/4 v6, 0x0

    .local v6, "i$":I
    if-ge v6, v7, :cond_1

    aget-object v2, v0, v6

    .line 80
    .local v2, "codec":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v8

    sget-object v9, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v8, v9}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v3

    .line 81
    .local v3, "codecname":Ljava/lang/String;
    const-string v8, "gzip"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_0

    const-string v8, "x-gzip"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 82
    :cond_0
    new-instance v8, Lcom/comcast/cim/httpcomponentsandroid/client/entity/GzipDecompressingEntity;

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/client/entity/GzipDecompressingEntity;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    invoke-interface {p1, v8}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 97
    .end local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v1    # "ceheader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .end local v2    # "codec":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v3    # "codecname":Ljava/lang/String;
    .end local v4    # "codecs":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v6    # "i$":I
    .end local v7    # "len$":I
    :cond_1
    :goto_0
    return-void

    .line 84
    .restart local v0    # "arr$":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v1    # "ceheader":Lcom/comcast/cim/httpcomponentsandroid/Header;
    .restart local v2    # "codec":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v3    # "codecname":Ljava/lang/String;
    .restart local v4    # "codecs":[Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v6    # "i$":I
    .restart local v7    # "len$":I
    :cond_2
    const-string v8, "deflate"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 85
    new-instance v8, Lcom/comcast/cim/httpcomponentsandroid/client/entity/DeflateDecompressingEntity;

    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/client/entity/DeflateDecompressingEntity;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    invoke-interface {p1, v8}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    goto :goto_0

    .line 87
    :cond_3
    const-string v8, "identity"

    invoke-virtual {v8, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 92
    new-instance v8, Lcom/comcast/cim/httpcomponentsandroid/HttpException;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Unsupported Content-Coding: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>(Ljava/lang/String;)V

    throw v8
.end method
