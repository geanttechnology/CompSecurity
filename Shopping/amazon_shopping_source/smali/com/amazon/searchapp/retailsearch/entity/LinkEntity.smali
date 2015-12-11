.class public Lcom/amazon/searchapp/retailsearch/entity/LinkEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "LinkEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Link;


# instance fields
.field private text:Ljava/lang/String;

.field private type:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/LinkEntity;->text:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/LinkEntity;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/LinkEntity;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setText(Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/LinkEntity;->text:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/LinkEntity;->type:Ljava/lang/String;

    .line 78
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 37
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/LinkEntity;->url:Ljava/lang/String;

    .line 38
    return-void
.end method
