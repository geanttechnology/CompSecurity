.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;
.super Landroid/widget/Filter;
.source "RetailSearchEditTextWatcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "CursorFilter"
.end annotation


# static fields
.field private static final ALIAS_APS:Ljava/lang/String; = "aps"

.field public static final LOG_COLUMN_LOG_IS_FALLBACK:Ljava/lang/String; = "suggest_log_is_fallback"

.field public static final LOG_COLUMN_LOG_IS_SPELL_CORRECTED:Ljava/lang/String; = "suggest_log_is_spell_corrected"

.field public static final LOG_COLUMN_LOG_IS_XCAT:Ljava/lang/String; = "suggest_log_is_xcat"

.field public static final LOG_COLUMN_LOG_POS:Ljava/lang/String; = "suggest_log_pos"

.field public static final LOG_COLUMN_LOG_QUERY:Ljava/lang/String; = "suggest_log_query"

.field public static final LOG_COLUMN_LOG_XCAT_POS:Ljava/lang/String; = "suggest_log_xcat_pos"


# instance fields
.field private final SUGGESTION_COLUMN:[Ljava/lang/String;

.field mCursor:Landroid/database/Cursor;

.field private mLastConstraint:Ljava/lang/CharSequence;

.field private mSearchAlias:Ljava/lang/String;

.field private mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Lcom/amazon/retailsearch/data/ISuggestionDataProvider;Ljava/lang/String;)V
    .locals 3
    .param p2, "searchSuggestionProvider"    # Lcom/amazon/retailsearch/data/ISuggestionDataProvider;
    .param p3, "alias"    # Ljava/lang/String;

    .prologue
    .line 236
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .line 237
    invoke-direct {p0}, Landroid/widget/Filter;-><init>()V

    .line 209
    const/16 v0, 0xe

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string/jumbo v2, "_id"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string/jumbo v2, "suggest_icon_1"

    aput-object v2, v0, v1

    const/4 v1, 0x2

    const-string/jumbo v2, "suggest_text_1"

    aput-object v2, v0, v1

    const/4 v1, 0x3

    const-string/jumbo v2, "suggest_text_2"

    aput-object v2, v0, v1

    const/4 v1, 0x4

    const-string/jumbo v2, "suggest_text_2_url"

    aput-object v2, v0, v1

    const/4 v1, 0x5

    const-string/jumbo v2, "suggest_intent_data"

    aput-object v2, v0, v1

    const/4 v1, 0x6

    const-string/jumbo v2, "intent_extra_data_key"

    aput-object v2, v0, v1

    const/4 v1, 0x7

    const-string/jumbo v2, "suggest_intent_extra_data"

    aput-object v2, v0, v1

    const/16 v1, 0x8

    const-string/jumbo v2, "suggest_log_query"

    aput-object v2, v0, v1

    const/16 v1, 0x9

    const-string/jumbo v2, "suggest_log_pos"

    aput-object v2, v0, v1

    const/16 v1, 0xa

    const-string/jumbo v2, "suggest_log_xcat_pos"

    aput-object v2, v0, v1

    const/16 v1, 0xb

    const-string/jumbo v2, "suggest_log_is_spell_corrected"

    aput-object v2, v0, v1

    const/16 v1, 0xc

    const-string/jumbo v2, "suggest_log_is_xcat"

    aput-object v2, v0, v1

    const/16 v1, 0xd

    const-string/jumbo v2, "suggest_log_is_fallback"

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->SUGGESTION_COLUMN:[Ljava/lang/String;

    .line 233
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mCursor:Landroid/database/Cursor;

    .line 238
    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSuggestionLock:Ljava/lang/Object;
    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$100(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 240
    :try_start_0
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    .line 241
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 242
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mSearchAlias:Ljava/lang/String;

    .line 243
    return-void

    .line 241
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method static synthetic access$002(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;
    .param p1, "x1"    # Ljava/lang/CharSequence;

    .prologue
    .line 200
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mLastConstraint:Ljava/lang/CharSequence;

    return-object p1
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    .prologue
    .line 200
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->getSearchMagnifierImage()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;)Lcom/amazon/retailsearch/data/ISuggestionDataProvider;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    .prologue
    .line 200
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    return-object v0
.end method

.method private appendBarcodeEntries(Landroid/database/MatrixCursor;)V
    .locals 5
    .param p1, "cursor"    # Landroid/database/MatrixCursor;

    .prologue
    const/4 v4, 0x0

    .line 374
    const/4 v0, 0x0

    .line 376
    .local v0, "flags":I
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->voiceEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 378
    or-int/lit8 v0, v0, 0x1

    .line 381
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->showBarcodeEntry()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 383
    or-int/lit8 v0, v0, 0x2

    .line 386
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->isFlowEnabled()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 388
    or-int/lit8 v0, v0, 0x8

    .line 391
    :cond_2
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->hasSnapIt()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 393
    or-int/lit8 v0, v0, 0x4

    .line 396
    :cond_3
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v1, v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->showVisualScan()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 398
    or-int/lit8 v0, v0, 0x10

    .line 401
    :cond_4
    const/16 v1, 0xe

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string/jumbo v3, "0"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    aput-object v4, v1, v2

    const/4 v2, 0x3

    aput-object v4, v1, v2

    const/4 v2, 0x4

    aput-object v4, v1, v2

    const/4 v2, 0x5

    aput-object v4, v1, v2

    const/4 v2, 0x6

    aput-object v4, v1, v2

    const/4 v2, 0x7

    aput-object v4, v1, v2

    const/16 v2, 0x8

    aput-object v4, v1, v2

    const/16 v2, 0x9

    aput-object v4, v1, v2

    const/16 v2, 0xa

    aput-object v4, v1, v2

    const/16 v2, 0xb

    aput-object v4, v1, v2

    const/16 v2, 0xc

    aput-object v4, v1, v2

    const/16 v2, 0xd

    aput-object v4, v1, v2

    invoke-virtual {p1, v1}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    .line 402
    return-void
.end method

.method private appendSuggestionData(Landroid/database/MatrixCursor;Ljava/util/List;)V
    .locals 5
    .param p1, "cursor"    # Landroid/database/MatrixCursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/database/MatrixCursor;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 322
    .local p2, "suggestions":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 332
    :cond_0
    return-void

    .line 327
    :cond_1
    const/4 v0, 0x0

    .line 328
    .local v0, "i":I
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    .line 330
    .local v3, "s":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    add-int/lit8 v1, v0, 0x1

    .end local v0    # "i":I
    .local v1, "i":I
    invoke-direct {p0, v0, v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->makeSuggestionRow(ILcom/amazon/retailsearch/data/SuggestionDataItem;)[Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    move v0, v1

    .end local v1    # "i":I
    .restart local v0    # "i":I
    goto :goto_0
.end method

.method private getSearchMagnifierImage()Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    .line 567
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->rs_search_bar_mag_glass:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    return-object v0
.end method

.method private getSuggestionsCursor(Ljava/lang/CharSequence;)Landroid/database/Cursor;
    .locals 10
    .param p1, "constraint"    # Ljava/lang/CharSequence;

    .prologue
    const/4 v9, 0x0

    .line 284
    new-instance v1, Landroid/database/MatrixCursor;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->SUGGESTION_COLUMN:[Ljava/lang/String;

    invoke-direct {v1, v4}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    .line 287
    .local v1, "cursor":Landroid/database/MatrixCursor;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v4, v4, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getCurrentDepartmentName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isFirstTimeEnter:Z
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$400(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 290
    :cond_0
    new-instance v0, Landroid/database/MatrixCursor;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->SUGGESTION_COLUMN:[Ljava/lang/String;

    invoke-direct {v0, v4}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;)V

    .line 291
    .local v0, "barcodeEntriesCursor":Landroid/database/MatrixCursor;
    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->appendBarcodeEntries(Landroid/database/MatrixCursor;)V

    .line 292
    new-instance v2, Landroid/widget/Filter$FilterResults;

    invoke-direct {v2}, Landroid/widget/Filter$FilterResults;-><init>()V

    .line 293
    .local v2, "results":Landroid/widget/Filter$FilterResults;
    new-instance v5, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    move-object v4, p1

    check-cast v4, Ljava/lang/String;

    invoke-direct {v5, v6, v0, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Landroid/database/Cursor;Ljava/lang/String;)V

    iput-object v5, v2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 294
    invoke-virtual {p0, p1, v2, v9}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;Z)V

    .line 297
    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->appendBarcodeEntries(Landroid/database/MatrixCursor;)V

    .line 300
    .end local v0    # "barcodeEntriesCursor":Landroid/database/MatrixCursor;
    .end local v2    # "results":Landroid/widget/Filter$FilterResults;
    :cond_1
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    if-eqz v4, :cond_2

    .line 303
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSuggestionLock:Ljava/lang/Object;
    invoke-static {v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$100(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Ljava/lang/Object;

    move-result-object v5

    monitor-enter v5

    .line 305
    :try_start_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mSearchAlias:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->forceUpdatePastSearches:Z
    invoke-static {v8}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$500(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Z

    move-result v8

    invoke-interface {v4, v6, v7, v8}, Lcom/amazon/retailsearch/data/ISuggestionDataProvider;->getSuggestions(Ljava/lang/String;Ljava/lang/String;Z)Ljava/util/List;

    move-result-object v3

    .line 306
    .local v3, "suggestionData":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    const/4 v6, 0x0

    # setter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->forceUpdatePastSearches:Z
    invoke-static {v4, v6}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$502(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Z)Z

    .line 307
    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 308
    invoke-direct {p0, v1, v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->appendSuggestionData(Landroid/database/MatrixCursor;Ljava/util/List;)V

    .line 310
    .end local v3    # "suggestionData":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/data/SuggestionDataItem;>;"
    :cond_2
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mLastConstraint:Ljava/lang/CharSequence;

    .line 311
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # setter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isFirstTimeEnter:Z
    invoke-static {v4, v9}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$402(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Z)Z

    .line 312
    return-object v1

    .line 307
    :catchall_0
    move-exception v4

    :try_start_1
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v4
.end method

.method private makeSuggestionRow(ILcom/amazon/retailsearch/data/SuggestionDataItem;)[Ljava/lang/String;
    .locals 7
    .param p1, "id"    # I
    .param p2, "s"    # Lcom/amazon/retailsearch/data/SuggestionDataItem;

    .prologue
    .line 342
    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getSuggestion()Ljava/lang/String;

    move-result-object v3

    .line 343
    .local v3, "query":Ljava/lang/String;
    const-string/jumbo v4, "paramText"

    invoke-virtual {p0, v4, v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->makeQuery(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 344
    .local v2, "intentData":Ljava/lang/String;
    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getSearchAlias()Ljava/lang/String;

    move-result-object v1

    .line 345
    .local v1, "filters":Ljava/lang/String;
    const-string/jumbo v4, "aps"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    const/4 v0, 0x0

    .line 346
    .local v0, "departmentName":Ljava/lang/String;
    :goto_0
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 348
    const-string/jumbo v4, "paramSuggestionDepartmentName"

    invoke-virtual {p0, v2, v4, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->addQueryParam(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 350
    :cond_0
    const-string/jumbo v4, "paramSuggestionDepartmentFilter"

    invoke-virtual {p0, v2, v4, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->addQueryParam(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 351
    const/16 v4, 0xe

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-string/jumbo v6, "-1"

    aput-object v6, v4, v5

    const/4 v5, 0x2

    aput-object v3, v4, v5

    const/4 v5, 0x3

    aput-object v0, v4, v5

    const/4 v5, 0x4

    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getDeleteURL()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x5

    aput-object v2, v4, v5

    const/4 v5, 0x6

    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getId()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x7

    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getType()Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0x8

    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getQuery()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0x9

    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getPos()I

    move-result v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0xa

    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getXcatPos()I

    move-result v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0xb

    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isSpellCorrected()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0xc

    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isXcat()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/16 v5, 0xd

    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->isFallback()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    return-object v4

    .line 345
    .end local v0    # "departmentName":Ljava/lang/String;
    :cond_1
    invoke-virtual {p2}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getDepartmentName()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0
.end method


# virtual methods
.method public addQueryParam(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 366
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 368
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "&"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p3}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    .line 370
    .end local p1    # "query":Ljava/lang/String;
    :cond_0
    return-object p1
.end method

.method public makeQuery(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 357
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 359
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p2}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 361
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "?"

    goto :goto_0
.end method

.method protected performFiltering(Ljava/lang/CharSequence;)Landroid/widget/Filter$FilterResults;
    .locals 5
    .param p1, "s"    # Ljava/lang/CharSequence;

    .prologue
    .line 251
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v3, v3, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->showBarcodeEntry()Z

    move-result v3

    if-nez v3, :cond_0

    .line 255
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v3, v3, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v4, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;

    invoke-direct {v4, p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$1;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;)V

    invoke-virtual {v3, v4}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    .line 270
    :cond_0
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->getSuggestionsCursor(Ljava/lang/CharSequence;)Landroid/database/Cursor;

    move-result-object v0

    .line 271
    .local v0, "cursor":Landroid/database/Cursor;
    new-instance v1, Landroid/widget/Filter$FilterResults;

    invoke-direct {v1}, Landroid/widget/Filter$FilterResults;-><init>()V

    .line 272
    .local v1, "results":Landroid/widget/Filter$FilterResults;
    new-instance v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    check-cast p1, Ljava/lang/String;

    .end local p1    # "s":Ljava/lang/CharSequence;
    invoke-direct {v2, v3, v0, p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Landroid/database/Cursor;Ljava/lang/String;)V

    .line 273
    .local v2, "value":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;
    iput-object v2, v1, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    .line 274
    return-object v1
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;)V
    .locals 1
    .param p1, "constraint"    # Ljava/lang/CharSequence;
    .param p2, "results"    # Landroid/widget/Filter$FilterResults;

    .prologue
    .line 407
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;Z)V

    .line 408
    return-void
.end method

.method protected publishResults(Ljava/lang/CharSequence;Landroid/widget/Filter$FilterResults;Z)V
    .locals 5
    .param p1, "constraint"    # Ljava/lang/CharSequence;
    .param p2, "results"    # Landroid/widget/Filter$FilterResults;
    .param p3, "hideSpinner"    # Z

    .prologue
    const/4 v3, 0x0

    const/4 v4, 0x0

    .line 418
    if-eqz p2, :cond_0

    iget-object v2, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    if-nez v2, :cond_1

    .line 558
    :cond_0
    :goto_0
    return-void

    .line 426
    :cond_1
    iget-object v2, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    check-cast v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;

    iget-object v0, v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;->mCursor:Landroid/database/Cursor;

    .line 427
    .local v0, "cursor":Landroid/database/Cursor;
    iget-object v2, p2, Landroid/widget/Filter$FilterResults;->values:Ljava/lang/Object;

    check-cast v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;

    iget-object v1, v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;->mSearchTerm:Ljava/lang/String;

    .line 429
    .local v1, "searchTerm":Ljava/lang/String;
    if-nez v0, :cond_2

    .line 432
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v2, v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$200(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 434
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;
    invoke-static {v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->access$200(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v2, v3, v3}, Landroid/graphics/drawable/Drawable;->setVisible(ZZ)Z

    .line 435
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v2, v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->getSearchMagnifierImage()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v2, v3, v4, v4, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 442
    :cond_2
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->this$0:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    iget-object v2, v2, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;

    new-instance v3, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;

    invoke-direct {v3, p0, p3, v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter$2;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;ZLandroid/database/Cursor;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;->invokeLater(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
