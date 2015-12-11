.class public Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "SearchedTextEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/SearchedText;


# instance fields
.field private alias:Ljava/lang/String;

.field private deleteUrl:Ljava/lang/String;

.field private displayAlias:Ljava/lang/String;

.field private eventTimestamp:J

.field private id:Ljava/lang/String;

.field private keywords:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->alias:Ljava/lang/String;

    return-object v0
.end method

.method public getDeleteUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->deleteUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->displayAlias:Ljava/lang/String;

    return-object v0
.end method

.method public getEventTimestamp()J
    .locals 2

    .prologue
    .line 76
    iget-wide v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->eventTimestamp:J

    return-wide v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getKeywords()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->keywords:Ljava/lang/String;

    return-object v0
.end method

.method public setAlias(Ljava/lang/String;)V
    .locals 0
    .param p1, "alias"    # Ljava/lang/String;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->alias:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public setDeleteUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "deleteUrl"    # Ljava/lang/String;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->deleteUrl:Ljava/lang/String;

    .line 127
    return-void
.end method

.method public setDisplayAlias(Ljava/lang/String;)V
    .locals 0
    .param p1, "displayAlias"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->displayAlias:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public setEventTimestamp(J)V
    .locals 0
    .param p1, "eventTimestamp"    # J

    .prologue
    .line 86
    iput-wide p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->eventTimestamp:J

    .line 87
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 146
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->id:Ljava/lang/String;

    .line 147
    return-void
.end method

.method public setKeywords(Ljava/lang/String;)V
    .locals 0
    .param p1, "keywords"    # Ljava/lang/String;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/SearchedTextEntity;->keywords:Ljava/lang/String;

    .line 107
    return-void
.end method
