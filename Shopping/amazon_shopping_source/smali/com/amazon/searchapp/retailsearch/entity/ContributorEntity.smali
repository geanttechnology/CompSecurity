.class public Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "ContributorEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Contributor;


# instance fields
.field private displayableRole:Ljava/lang/String;

.field private name:Ljava/lang/String;

.field private role:Ljava/lang/String;

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
.method public getDisplayableRole()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;->displayableRole:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getRole()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;->role:Ljava/lang/String;

    return-object v0
.end method

.method public getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;->url:Ljava/lang/String;

    return-object v0
.end method

.method public setDisplayableRole(Ljava/lang/String;)V
    .locals 0
    .param p1, "displayableRole"    # Ljava/lang/String;

    .prologue
    .line 60
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;->displayableRole:Ljava/lang/String;

    .line 61
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;->name:Ljava/lang/String;

    .line 101
    return-void
.end method

.method public setRole(Ljava/lang/String;)V
    .locals 0
    .param p1, "role"    # Ljava/lang/String;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;->role:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/ContributorEntity;->url:Ljava/lang/String;

    .line 41
    return-void
.end method
