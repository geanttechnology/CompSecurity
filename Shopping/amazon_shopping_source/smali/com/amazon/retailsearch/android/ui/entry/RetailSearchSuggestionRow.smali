.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
.super Ljava/lang/Object;
.source "RetailSearchSuggestionRow.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;
    }
.end annotation


# instance fields
.field private a9SuggestionSize:I

.field private deleteUrl:Ljava/lang/String;

.field private department:Ljava/lang/String;

.field private hasSnap:Z

.field private intentData:Ljava/lang/String;

.field private isFallBack:Z

.field private isFlowEnabled:Z

.field private isSpellCorrected:Z

.field private isXcat:Z

.field private pastSearchId:Ljava/lang/String;

.field private pos:I

.field private query:Ljava/lang/String;

.field private rowType:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

.field private showBarcode:Z

.field private showVisualScan:Z

.field private suggestion:Ljava/lang/String;

.field private suggestionType:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

.field private voiceEnabled:Z

.field private xcatPos:I

.field private xcatSize:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    return-void
.end method


# virtual methods
.method public getA9SuggestionSize()I
    .locals 1

    .prologue
    .line 328
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->a9SuggestionSize:I

    return v0
.end method

.method public getDeleteUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->deleteUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getDepartment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->department:Ljava/lang/String;

    return-object v0
.end method

.method public getIntentData()Ljava/lang/String;
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->intentData:Ljava/lang/String;

    return-object v0
.end method

.method public getPastSearchId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->pastSearchId:Ljava/lang/String;

    return-object v0
.end method

.method public getPos()I
    .locals 1

    .prologue
    .line 166
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->pos:I

    return v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->query:Ljava/lang/String;

    return-object v0
.end method

.method public getRowType()Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->rowType:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    return-object v0
.end method

.method public getSuggestion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->suggestion:Ljava/lang/String;

    return-object v0
.end method

.method public getSuggestionType()Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->suggestionType:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    return-object v0
.end method

.method public getXcatPos()I
    .locals 1

    .prologue
    .line 180
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->xcatPos:I

    return v0
.end method

.method public getXcatSize()I
    .locals 1

    .prologue
    .line 314
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->xcatSize:I

    return v0
.end method

.method public hasSnap()Z
    .locals 1

    .prologue
    .line 269
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->hasSnap:Z

    return v0
.end method

.method public isFallBack()Z
    .locals 1

    .prologue
    .line 222
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isFallBack:Z

    return v0
.end method

.method public isFlowEnabled()Z
    .locals 1

    .prologue
    .line 283
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isFlowEnabled:Z

    return v0
.end method

.method public isSpellCorrected()Z
    .locals 1

    .prologue
    .line 194
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isSpellCorrected:Z

    return v0
.end method

.method public isXcat()Z
    .locals 1

    .prologue
    .line 208
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isXcat:Z

    return v0
.end method

.method public setA9SuggestionSize(I)V
    .locals 0
    .param p1, "a9SuggestionSize"    # I

    .prologue
    .line 335
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->a9SuggestionSize:I

    .line 336
    return-void
.end method

.method public setDeleteUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "deleteUrl"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->deleteUrl:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setDepartment(Ljava/lang/String;)V
    .locals 0
    .param p1, "department"    # Ljava/lang/String;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->department:Ljava/lang/String;

    .line 76
    return-void
.end method

.method public setFallBack(Z)V
    .locals 0
    .param p1, "isFallBack"    # Z

    .prologue
    .line 229
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isFallBack:Z

    .line 230
    return-void
.end method

.method public setFlowEnabled(Z)V
    .locals 0
    .param p1, "isFlowEnabled"    # Z

    .prologue
    .line 290
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isFlowEnabled:Z

    .line 291
    return-void
.end method

.method public setHasSnap(Z)V
    .locals 0
    .param p1, "hasSnap"    # Z

    .prologue
    .line 276
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->hasSnap:Z

    .line 277
    return-void
.end method

.method public setIntentData(Ljava/lang/String;)V
    .locals 0
    .param p1, "intentData"    # Ljava/lang/String;

    .prologue
    .line 145
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->intentData:Ljava/lang/String;

    .line 146
    return-void
.end method

.method public setPastSearchId(Ljava/lang/String;)V
    .locals 0
    .param p1, "pastSearchId"    # Ljava/lang/String;

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->pastSearchId:Ljava/lang/String;

    .line 104
    return-void
.end method

.method public setPos(I)V
    .locals 0
    .param p1, "pos"    # I

    .prologue
    .line 173
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->pos:I

    .line 174
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 0
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 159
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->query:Ljava/lang/String;

    .line 160
    return-void
.end method

.method public setRowType(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;)V
    .locals 0
    .param p1, "rowType"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->rowType:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    .line 118
    return-void
.end method

.method public setShowBarcode(Z)V
    .locals 0
    .param p1, "showBarcode"    # Z

    .prologue
    .line 261
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->showBarcode:Z

    .line 262
    return-void
.end method

.method public setShowVisualScan(Z)V
    .locals 0
    .param p1, "showVisualScan"    # Z

    .prologue
    .line 306
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->showVisualScan:Z

    .line 307
    return-void
.end method

.method public setSpellCorrected(Z)V
    .locals 0
    .param p1, "isSpellCorrected"    # Z

    .prologue
    .line 201
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isSpellCorrected:Z

    .line 202
    return-void
.end method

.method public setSuggestion(Ljava/lang/String;)V
    .locals 0
    .param p1, "suggestion"    # Ljava/lang/String;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->suggestion:Ljava/lang/String;

    .line 62
    return-void
.end method

.method public setSuggestionType(Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;)V
    .locals 0
    .param p1, "suggestionType"    # Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->suggestionType:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    .line 132
    return-void
.end method

.method public setVoiceEnabled(Z)V
    .locals 0
    .param p1, "voiceEnabled"    # Z

    .prologue
    .line 245
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->voiceEnabled:Z

    .line 246
    return-void
.end method

.method public setXcat(Z)V
    .locals 0
    .param p1, "isXcat"    # Z

    .prologue
    .line 215
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isXcat:Z

    .line 216
    return-void
.end method

.method public setXcatPos(I)V
    .locals 0
    .param p1, "xcatPos"    # I

    .prologue
    .line 187
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->xcatPos:I

    .line 188
    return-void
.end method

.method public setXcatSize(I)V
    .locals 0
    .param p1, "xcatSize"    # I

    .prologue
    .line 321
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->xcatSize:I

    .line 322
    return-void
.end method

.method public showBarcode()Z
    .locals 1

    .prologue
    .line 253
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->showBarcode:Z

    return v0
.end method

.method public showVisualScan()Z
    .locals 1

    .prologue
    .line 298
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->showVisualScan:Z

    return v0
.end method

.method public voiceEnabled()Z
    .locals 1

    .prologue
    .line 237
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->voiceEnabled:Z

    return v0
.end method
