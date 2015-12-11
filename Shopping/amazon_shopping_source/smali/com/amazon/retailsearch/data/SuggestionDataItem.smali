.class public Lcom/amazon/retailsearch/data/SuggestionDataItem;
.super Ljava/lang/Object;
.source "SuggestionDataItem.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;
    }
.end annotation


# instance fields
.field private deleteURL:Ljava/lang/String;

.field private departmentName:Ljava/lang/String;

.field private displayText:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private isFallback:Z

.field private isSpellCorrected:Z

.field private isXcat:Z

.field private pos:I

.field private query:Ljava/lang/String;

.field private searchAlias:Ljava/lang/String;

.field private suggestion:Ljava/lang/String;

.field private type:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

.field private xcatPos:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    return-void
.end method


# virtual methods
.method public getDeleteURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->deleteURL:Ljava/lang/String;

    return-object v0
.end method

.method public getDepartmentName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->departmentName:Ljava/lang/String;

    return-object v0
.end method

.method public getDisplayText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->displayText:Ljava/lang/String;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getPos()I
    .locals 1

    .prologue
    .line 162
    iget v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->pos:I

    return v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->searchAlias:Ljava/lang/String;

    return-object v0
.end method

.method public getSuggestion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->suggestion:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->type:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    return-object v0
.end method

.method public getXcatPos()I
    .locals 1

    .prologue
    .line 176
    iget v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->xcatPos:I

    return v0
.end method

.method public isFallback()Ljava/lang/String;
    .locals 1

    .prologue
    .line 232
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isFallback:Z

    if-eqz v0, :cond_0

    const-string/jumbo v0, "1"

    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "0"

    goto :goto_0
.end method

.method public isFallbackValue()Z
    .locals 1

    .prologue
    .line 239
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isFallback:Z

    return v0
.end method

.method public isSpellCorrected()Ljava/lang/String;
    .locals 1

    .prologue
    .line 190
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isSpellCorrected:Z

    if-eqz v0, :cond_0

    const-string/jumbo v0, "1"

    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "0"

    goto :goto_0
.end method

.method public isSpellCorrectedValue()Z
    .locals 1

    .prologue
    .line 197
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isSpellCorrected:Z

    return v0
.end method

.method public isXcat()Ljava/lang/String;
    .locals 1

    .prologue
    .line 211
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isXcat:Z

    if-eqz v0, :cond_0

    const-string/jumbo v0, "1"

    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "0"

    goto :goto_0
.end method

.method public isXcatValue()Z
    .locals 1

    .prologue
    .line 218
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isXcat:Z

    return v0
.end method

.method public setDeleteURL(Ljava/lang/String;)V
    .locals 0
    .param p1, "deleteURL"    # Ljava/lang/String;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->deleteURL:Ljava/lang/String;

    .line 142
    return-void
.end method

.method public setDepartmentName(Ljava/lang/String;)V
    .locals 0
    .param p1, "departmentName"    # Ljava/lang/String;

    .prologue
    .line 99
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->departmentName:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setDisplayText(Ljava/lang/String;)V
    .locals 0
    .param p1, "displayText"    # Ljava/lang/String;

    .prologue
    .line 85
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->displayText:Ljava/lang/String;

    .line 86
    return-void
.end method

.method public setFallback(Z)V
    .locals 0
    .param p1, "isFallback"    # Z

    .prologue
    .line 246
    iput-boolean p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isFallback:Z

    .line 247
    return-void
.end method

.method public setId(Ljava/lang/String;)V
    .locals 0
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->id:Ljava/lang/String;

    .line 58
    return-void
.end method

.method public setPos(I)V
    .locals 0
    .param p1, "pos"    # I

    .prologue
    .line 169
    iput p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->pos:I

    .line 170
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->query:Ljava/lang/String;

    .line 156
    return-void
.end method

.method public setSearchAlias(Ljava/lang/String;)V
    .locals 0
    .param p1, "searchAlias"    # Ljava/lang/String;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->searchAlias:Ljava/lang/String;

    .line 114
    return-void
.end method

.method public setSpellCorrected(Z)V
    .locals 0
    .param p1, "isSpellCorrected"    # Z

    .prologue
    .line 204
    iput-boolean p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isSpellCorrected:Z

    .line 205
    return-void
.end method

.method public setSuggestion(Ljava/lang/String;)V
    .locals 0
    .param p1, "suggestion"    # Ljava/lang/String;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->suggestion:Ljava/lang/String;

    .line 72
    return-void
.end method

.method public setType(Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;)V
    .locals 0
    .param p1, "type"    # Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    .prologue
    .line 127
    iput-object p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->type:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    .line 128
    return-void
.end method

.method public setXcat(Z)V
    .locals 0
    .param p1, "isXcat"    # Z

    .prologue
    .line 225
    iput-boolean p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isXcat:Z

    .line 226
    return-void
.end method

.method public setXcatPos(I)V
    .locals 0
    .param p1, "xcatPos"    # I

    .prologue
    .line 183
    iput p1, p0, Lcom/amazon/retailsearch/data/SuggestionDataItem;->xcatPos:I

    .line 184
    return-void
.end method
