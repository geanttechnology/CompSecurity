.class public Lcom/amazon/searchapp/retailsearch/entity/SelectedOptionEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "SelectedOptionEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/SelectedOption;


# instance fields
.field private id:Ljava/lang/String;

.field private link:Lcom/amazon/searchapp/retailsearch/model/Link;

.field private selected:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SelectedOptionEntity;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getLink()Lcom/amazon/searchapp/retailsearch/model/Link;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SelectedOptionEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    return-object v0
.end method

.method public getSelected()Z
    .locals 1

    .prologue
    .line 28
    iget-boolean v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SelectedOptionEntity;->selected:Z

    return v0
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SelectedOptionEntity;->id:Ljava/lang/String;

    .line 79
    return-void
.end method

.method public setLink(Lcom/amazon/searchapp/retailsearch/model/Link;)V
    .locals 0
    .param p1, "link"    # Lcom/amazon/searchapp/retailsearch/model/Link;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SelectedOptionEntity;->link:Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 59
    return-void
.end method

.method public setSelected(Z)V
    .locals 0
    .param p1, "selected"    # Z

    .prologue
    .line 38
    iput-boolean p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SelectedOptionEntity;->selected:Z

    .line 39
    return-void
.end method
