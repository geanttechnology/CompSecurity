.class public Lcom/amazon/retailsearch/android/ui/results/layout/UserState;
.super Ljava/lang/Object;
.source "UserState.java"


# instance fields
.field private currentDataInFocus:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

.field private entryAsin:Ljava/lang/String;

.field private entryIndex:I

.field private selectedModel:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    return-void
.end method


# virtual methods
.method public getCurrentDataInFocus()Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->currentDataInFocus:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    return-object v0
.end method

.method public getEntryAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->entryAsin:Ljava/lang/String;

    return-object v0
.end method

.method public getEntryIndex()I
    .locals 1

    .prologue
    .line 86
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->entryIndex:I

    return v0
.end method

.method protected getSelectedModel()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->selectedModel:Ljava/lang/Object;

    return-object v0
.end method

.method public setCurrentDataInFocus(Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 0
    .param p1, "currentDataInFocus"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->currentDataInFocus:Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .line 62
    return-void
.end method

.method public setEntryAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->entryAsin:Ljava/lang/String;

    .line 79
    return-void
.end method

.method public setEntryIndex(I)V
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 95
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->entryIndex:I

    .line 96
    return-void
.end method

.method protected setSelectedModel(Ljava/lang/Object;)V
    .locals 0
    .param p1, "selectedModel"    # Ljava/lang/Object;

    .prologue
    .line 111
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->selectedModel:Ljava/lang/Object;

    .line 112
    return-void
.end method
