.class public Lcom/amazon/searchapp/retailsearch/entity/PageEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "PageEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Page;


# instance fields
.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private page:I

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PageEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getPage()I
    .locals 1

    .prologue
    .line 68
    iget v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PageEntity;->page:I

    return v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/PageEntity;->type:Ljava/lang/String;

    return-object v0
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PageEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 59
    return-void
.end method

.method public setPage(I)V
    .locals 0
    .param p1, "page"    # I

    .prologue
    .line 78
    iput p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PageEntity;->page:I

    .line 79
    return-void
.end method

.method public setType(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/PageEntity;->type:Ljava/lang/String;

    .line 39
    return-void
.end method
