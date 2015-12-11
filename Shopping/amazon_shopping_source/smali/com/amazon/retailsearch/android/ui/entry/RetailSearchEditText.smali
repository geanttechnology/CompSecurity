.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;
.super Lcom/amazon/retailsearch/android/ui/ClearableEditText;
.source "RetailSearchEditText.java"


# instance fields
.field private currentDepartmentName:Ljava/lang/String;

.field private hasSnapIt:Z

.field private isFlowEnabled:Z

.field private listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;"
        }
    .end annotation
.end field

.field protected mWatcher:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

.field platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private showBarcodeEntry:Z

.field private showVisualScan:Z

.field private voiceEnabled:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    .line 40
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 32
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->showBarcodeEntry:Z

    .line 33
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->hasSnapIt:Z

    .line 34
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->isFlowEnabled:Z

    .line 41
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 42
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getCompoundDrawablePadding()I

    move-result v0

    invoke-virtual {p0, v1, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setClearTextButtonPadding(II)V

    .line 43
    return-void
.end method


# virtual methods
.method public addTextChangedListener(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)V
    .locals 0
    .param p1, "watcher"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 118
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 119
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->mWatcher:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .line 120
    return-void
.end method

.method protected doSearch(Ljava/lang/String;)V
    .locals 2
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 138
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    if-eqz v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    new-instance v1, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-direct {v1, p1}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;->onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/Query;)V

    .line 142
    :cond_0
    return-void
.end method

.method public getCurrentDepartmentName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->currentDepartmentName:Ljava/lang/String;

    return-object v0
.end method

.method public getTextChangedListener()Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->mWatcher:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    return-object v0
.end method

.method public hasSnapIt()Z
    .locals 1

    .prologue
    .line 181
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->hasSnapIt:Z

    return v0
.end method

.method public isFlowEnabled()Z
    .locals 1

    .prologue
    .line 229
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->isFlowEnabled:Z

    return v0
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 4
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/16 v3, 0x42

    const/4 v1, 0x1

    .line 87
    if-eq p1, v3, :cond_0

    const/16 v2, 0x17

    if-ne p1, v2, :cond_3

    .line 89
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 90
    .local v0, "query":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 94
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->doSearch(Ljava/lang/String;)V

    .line 107
    .end local v0    # "query":Ljava/lang/String;
    :cond_1
    :goto_0
    return v1

    .line 97
    .restart local v0    # "query":Ljava/lang/String;
    :cond_2
    if-eq p1, v3, :cond_1

    .line 107
    .end local v0    # "query":Ljava/lang/String;
    :cond_3
    invoke-super {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public onWindowFocusChanged(Z)V
    .locals 2
    .param p1, "hasWindowFocus"    # Z

    .prologue
    .line 61
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->onWindowFocusChanged(Z)V

    .line 63
    if-eqz p1, :cond_0

    .line 67
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText$1;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 78
    :cond_0
    return-void
.end method

.method public setCurrentDepartmentName(Ljava/lang/String;)V
    .locals 0
    .param p1, "currentDepartmentName"    # Ljava/lang/String;

    .prologue
    .line 221
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->currentDepartmentName:Ljava/lang/String;

    .line 222
    return-void
.end method

.method public setFlowEnabled(Z)V
    .locals 0
    .param p1, "isFlowEnabled"    # Z

    .prologue
    .line 237
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->isFlowEnabled:Z

    .line 238
    return-void
.end method

.method public setHasSnapIt(Z)V
    .locals 0
    .param p1, "hasSnapIt"    # Z

    .prologue
    .line 189
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->hasSnapIt:Z

    .line 190
    return-void
.end method

.method public setListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 51
    .local p1, "listener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    .line 52
    return-void
.end method

.method public setShowBarcodeEntry(Z)V
    .locals 0
    .param p1, "showBarcodeEntry"    # Z

    .prologue
    .line 173
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->showBarcodeEntry:Z

    .line 174
    return-void
.end method

.method public setShowVisualScan(Z)V
    .locals 0
    .param p1, "showVisualScan"    # Z

    .prologue
    .line 205
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->showVisualScan:Z

    .line 206
    return-void
.end method

.method public setVoiceEnabled(Z)V
    .locals 0
    .param p1, "voiceEnabled"    # Z

    .prologue
    .line 157
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->voiceEnabled:Z

    .line 158
    return-void
.end method

.method public showBarcodeEntry()Z
    .locals 1

    .prologue
    .line 165
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->showBarcodeEntry:Z

    return v0
.end method

.method public showVisualScan()Z
    .locals 1

    .prologue
    .line 197
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->showVisualScan:Z

    return v0
.end method

.method public voiceEnabled()Z
    .locals 1

    .prologue
    .line 149
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->voiceEnabled:Z

    return v0
.end method
