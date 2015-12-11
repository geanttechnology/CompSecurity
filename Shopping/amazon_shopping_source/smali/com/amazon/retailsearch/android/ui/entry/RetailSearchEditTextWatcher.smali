.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;
.super Ljava/lang/Object;
.source "RetailSearchEditTextWatcher.java"

# interfaces
.implements Landroid/text/TextWatcher;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$FilterResultValue;,
        Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;
    }
.end annotation


# static fields
.field public static final AUTHORITY:Ljava/lang/String; = "com.amazon.mShop.search.SuggestionsProvider"

.field public static final REFMARKER:Ljava/lang/String; = "REFMARKER"

.field public static final SEARCH_SCAN:Ljava/lang/String; = "sr_scan"

.field public static final SEARCH_SNAP:Ljava/lang/String; = "sr_snap"

.field public static final SEARCH_URL_LAST_SEGMENT:Ljava/lang/String; = "/search_suggest_query/"


# instance fields
.field private forceUpdatePastSearches:Z

.field private isFirstTimeEnter:Z

.field private isISSLatencyLogged:Z

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

.field protected final mContext:Landroid/content/Context;

.field private mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

.field protected mFirstPreCheck:Z

.field private final mISSLatencyLock:Ljava/lang/Object;

.field private final mSearchAlias:Ljava/lang/String;

.field protected final mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

.field private final mSuggestionLock:Ljava/lang/Object;

.field private final mSuggstionsListView:Landroid/widget/ListView;

.field private final mWorkingSpinner:Landroid/graphics/drawable/Drawable;

.field platform:Lcom/amazon/retailsearch/j2me/client/util/RetailSearchAndroidPlatform;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

.field private transientSearchChangeListener:Lcom/amazon/retailsearch/android/ui/entry/TransientSearchChangeListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/widget/ListView;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;Ljava/lang/String;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "suggestionsListView"    # Landroid/widget/ListView;
    .param p3, "searchEditText"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;
    .param p4, "searchAlias"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 79
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 61
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    .line 62
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mFirstPreCheck:Z

    .line 64
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->forceUpdatePastSearches:Z

    .line 65
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isFirstTimeEnter:Z

    .line 67
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isISSLatencyLogged:Z

    .line 70
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getSearchBoxLogger()Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    .line 74
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSuggestionLock:Ljava/lang/Object;

    .line 76
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mISSLatencyLock:Ljava/lang/Object;

    .line 80
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mContext:Landroid/content/Context;

    .line 81
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSuggstionsListView:Landroid/widget/ListView;

    .line 82
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    .line 83
    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchAlias:Ljava/lang/String;

    .line 85
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 89
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/4 v1, 0x4

    if-lt v0, v1, :cond_0

    .line 91
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->rs_search_spinner:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;

    .line 97
    :goto_0
    return-void

    .line 95
    :cond_0
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;

    goto :goto_0
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSuggestionLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSuggstionsListView:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Landroid/graphics/drawable/Drawable;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mWorkingSpinner:Landroid/graphics/drawable/Drawable;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isFirstTimeEnter:Z

    return v0
.end method

.method static synthetic access$402(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;
    .param p1, "x1"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isFirstTimeEnter:Z

    return p1
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->forceUpdatePastSearches:Z

    return v0
.end method

.method static synthetic access$502(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;
    .param p1, "x1"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->forceUpdatePastSearches:Z

    return p1
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mISSLatencyLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$900(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isISSLatencyLogged:Z

    return v0
.end method

.method static synthetic access$902(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;
    .param p1, "x1"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isISSLatencyLogged:Z

    return p1
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 595
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 590
    return-void
.end method

.method protected closeSearchSuggestionCursor()V
    .locals 2

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 154
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 155
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mCursor:Landroid/database/Cursor;

    .line 157
    :cond_0
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 118
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->isISSLatencyLogged:Z

    if-nez v0, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 120
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;->searchSuggestionsFirstKeyStroke()V

    .line 122
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->updateSuggestions(Ljava/lang/CharSequence;Z)V

    .line 123
    return-void
.end method

.method protected processSuggestionItemClick(Landroid/database/Cursor;I)V
    .locals 9
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "position"    # I

    .prologue
    .line 172
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/UIUtils;->closeSoftKeyboard(Landroid/view/View;)V

    .line 174
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    if-eqz v0, :cond_0

    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->isActionRow(Landroid/database/Cursor;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 176
    invoke-interface {p1, p2}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 177
    const-string/jumbo v0, "suggest_intent_data"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 178
    .local v6, "intentData":Ljava/lang/String;
    invoke-static {v6}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v7

    .line 179
    .local v7, "intentUri":Landroid/net/Uri;
    const-string/jumbo v0, "paramText"

    invoke-virtual {v7, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 180
    .local v4, "keyword":Ljava/lang/String;
    const-string/jumbo v0, "paramSuggestionDepartmentFilter"

    invoke-virtual {v7, v0}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 181
    .local v3, "department":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    .line 183
    .local v5, "rawUserInput":Ljava/lang/String;
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchEditText:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;

    invoke-virtual {v0, v4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditText;->setText(Ljava/lang/CharSequence;)V

    .line 184
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchAlias:Ljava/lang/String;

    move-object v0, p1

    move v1, p2

    invoke-static/range {v0 .. v5}, Lcom/amazon/retailsearch/metrics/IssLogger;->createLogData(Landroid/database/Cursor;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v8

    .line 185
    .local v8, "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    new-instance v1, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    invoke-direct {v1, v3, v4, v5, v8}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;->onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/Query;)V

    .line 187
    .end local v3    # "department":Ljava/lang/String;
    .end local v4    # "keyword":Ljava/lang/String;
    .end local v5    # "rawUserInput":Ljava/lang/String;
    .end local v6    # "intentData":Ljava/lang/String;
    .end local v7    # "intentUri":Landroid/net/Uri;
    .end local v8    # "issEngagementData":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_0
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
    .line 104
    .local p1, "listener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->listener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    .line 105
    return-void
.end method

.method public setListener(Lcom/amazon/retailsearch/android/ui/entry/TransientSearchChangeListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/ui/entry/TransientSearchChangeListener;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->transientSearchChangeListener:Lcom/amazon/retailsearch/android/ui/entry/TransientSearchChangeListener;

    .line 113
    return-void
.end method

.method protected updateSuggestions(Ljava/lang/CharSequence;Z)V
    .locals 3
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "isForceUpdate"    # Z

    .prologue
    .line 129
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 131
    const-string/jumbo p1, ""

    .line 132
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->transientSearchChangeListener:Lcom/amazon/retailsearch/android/ui/entry/TransientSearchChangeListener;

    if-eqz v0, :cond_0

    .line 134
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->transientSearchChangeListener:Lcom/amazon/retailsearch/android/ui/entry/TransientSearchChangeListener;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/entry/TransientSearchChangeListener;->onQueryCleared()V

    .line 138
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    if-nez v0, :cond_1

    .line 140
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    new-instance v1, Lcom/amazon/retailsearch/data/SuggestionDataProvider;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mContext:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;-><init>(Landroid/content/Context;)V

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mSearchAlias:Ljava/lang/String;

    invoke-direct {v0, p0, v1, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;Lcom/amazon/retailsearch/data/ISuggestionDataProvider;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    .line 143
    :cond_1
    if-eqz p2, :cond_2

    .line 145
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->mLastConstraint:Ljava/lang/CharSequence;
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->access$002(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;Ljava/lang/CharSequence;)Ljava/lang/CharSequence;

    .line 147
    :cond_2
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher;->mCursorFilter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEditTextWatcher$CursorFilter;->filter(Ljava/lang/CharSequence;)V

    .line 148
    return-void
.end method
