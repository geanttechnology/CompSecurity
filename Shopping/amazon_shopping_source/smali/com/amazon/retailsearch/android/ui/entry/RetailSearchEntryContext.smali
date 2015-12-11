.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;
.super Ljava/lang/Object;
.source "RetailSearchEntryContext.java"


# instance fields
.field private currentDepartmentName:Ljava/lang/String;

.field private forceUpdatePastSearches:Z

.field private hasScanIt:Z

.field private hasSnapIt:Z

.field private isFirstTimeEnter:Z

.field private isFlowEnabled:Z

.field isISSLatencyLogged:Z

.field private searchAlias:Ljava/lang/String;

.field private showBarcodeEntry:Z

.field private showVisualScan:Z

.field private voiceEnabled:Z


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->showBarcodeEntry:Z

    .line 17
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->hasScanIt:Z

    .line 18
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->hasSnapIt:Z

    .line 19
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isFlowEnabled:Z

    .line 22
    const-string/jumbo v0, "aps"

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->searchAlias:Ljava/lang/String;

    .line 24
    iput-boolean v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->forceUpdatePastSearches:Z

    .line 25
    iput-boolean v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isFirstTimeEnter:Z

    .line 26
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isISSLatencyLogged:Z

    return-void
.end method


# virtual methods
.method public getCurrentDepartmentName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->currentDepartmentName:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchAlias()Ljava/lang/String;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->searchAlias:Ljava/lang/String;

    return-object v0
.end method

.method public hasScanIt()Z
    .locals 1

    .prologue
    .line 65
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->hasScanIt:Z

    return v0
.end method

.method public hasSnapIt()Z
    .locals 1

    .prologue
    .line 81
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->hasSnapIt:Z

    return v0
.end method

.method public isFirstTimeEnter()Z
    .locals 1

    .prologue
    .line 177
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isFirstTimeEnter:Z

    return v0
.end method

.method public isFlowEnabled()Z
    .locals 1

    .prologue
    .line 129
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isFlowEnabled:Z

    return v0
.end method

.method public isForceUpdatePastSearches()Z
    .locals 1

    .prologue
    .line 161
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->forceUpdatePastSearches:Z

    return v0
.end method

.method public isISSLatencyLogged()Z
    .locals 1

    .prologue
    .line 193
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isISSLatencyLogged:Z

    return v0
.end method

.method public setCurrentDepartmentName(Ljava/lang/String;)V
    .locals 0
    .param p1, "currentDepartmentName"    # Ljava/lang/String;

    .prologue
    .line 121
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->currentDepartmentName:Ljava/lang/String;

    .line 122
    return-void
.end method

.method public setFirstTimeEnter(Z)V
    .locals 0
    .param p1, "isFirstTimeEnter"    # Z

    .prologue
    .line 185
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isFirstTimeEnter:Z

    .line 186
    return-void
.end method

.method public setFlowEnabled(Z)V
    .locals 0
    .param p1, "isFlowEnabled"    # Z

    .prologue
    .line 137
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isFlowEnabled:Z

    .line 138
    return-void
.end method

.method public setForceUpdatePastSearches(Z)V
    .locals 0
    .param p1, "forceUpdatePastSearches"    # Z

    .prologue
    .line 169
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->forceUpdatePastSearches:Z

    .line 170
    return-void
.end method

.method public setHasScanIt(Z)V
    .locals 0
    .param p1, "hasScanIt"    # Z

    .prologue
    .line 73
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->hasScanIt:Z

    .line 74
    return-void
.end method

.method public setHasSnapIt(Z)V
    .locals 0
    .param p1, "hasSnapIt"    # Z

    .prologue
    .line 89
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->hasSnapIt:Z

    .line 90
    return-void
.end method

.method public setISSLatencyLogged(Z)V
    .locals 0
    .param p1, "isISSLatencyLogged"    # Z

    .prologue
    .line 201
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->isISSLatencyLogged:Z

    .line 202
    return-void
.end method

.method public setSearchAlias(Ljava/lang/String;)V
    .locals 0
    .param p1, "searchAlias"    # Ljava/lang/String;

    .prologue
    .line 153
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->searchAlias:Ljava/lang/String;

    .line 154
    return-void
.end method

.method public setShowBarcodeEntry(Z)V
    .locals 0
    .param p1, "showBarcodeEntry"    # Z

    .prologue
    .line 57
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->showBarcodeEntry:Z

    .line 58
    return-void
.end method

.method public setShowVisualScan(Z)V
    .locals 0
    .param p1, "showVisualScan"    # Z

    .prologue
    .line 105
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->showVisualScan:Z

    .line 106
    return-void
.end method

.method public setVoiceEnabled(Z)V
    .locals 0
    .param p1, "voiceEnabled"    # Z

    .prologue
    .line 41
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->voiceEnabled:Z

    .line 42
    return-void
.end method

.method public showBarcodeEntry()Z
    .locals 1

    .prologue
    .line 49
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->showBarcodeEntry:Z

    return v0
.end method

.method public showVisualScan()Z
    .locals 1

    .prologue
    .line 97
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->showVisualScan:Z

    return v0
.end method

.method public voiceEnabled()Z
    .locals 1

    .prologue
    .line 33
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->voiceEnabled:Z

    return v0
.end method
