.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;
.super Landroid/widget/CursorAdapter;
.source "RetailSearchSuggestionCursorAdapter.java"


# instance fields
.field private listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

.field private mContext:Landroid/content/Context;

.field private mCursor:Landroid/database/Cursor;

.field private mPattern:Ljava/util/regex/Pattern;

.field private mSearchTerm:Ljava/lang/String;

.field private querySubmitListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;ZLjava/lang/String;Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "c"    # Landroid/database/Cursor;
    .param p3, "autoRequery"    # Z
    .param p4, "searchTerm"    # Ljava/lang/String;
    .param p5, "listener"    # Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/database/Cursor;",
            "Z",
            "Ljava/lang/String;",
            "Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;",
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 55
    .local p6, "querySubmitListener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;Z)V

    .line 56
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 57
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mContext:Landroid/content/Context;

    .line 58
    invoke-virtual {p0, p4}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->updateSearchTerm(Ljava/lang/String;)V

    .line 59
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mCursor:Landroid/database/Cursor;

    .line 60
    iput-object p5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    .line 61
    iput-object p6, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->querySubmitListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    .line 62
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;)Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    return-object v0
.end method

.method public static isActionRow(Landroid/database/Cursor;)Z
    .locals 3
    .param p0, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 87
    const-string/jumbo v1, "suggest_icon_1"

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 88
    .local v0, "iconColumn":I
    invoke-interface {p0, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    const/4 v2, -0x1

    if-le v1, v2, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private setSuggestionBold(Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 8
    .param p1, "suggestionTextView"    # Landroid/widget/TextView;
    .param p2, "searchTerm"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x1

    .line 246
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 275
    :cond_0
    :goto_0
    return-void

    .line 250
    :cond_1
    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 251
    .local v4, "suggestionText":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getLocale()Ljava/lang/String;

    move-result-object v1

    .line 253
    .local v1, "locale":Ljava/lang/String;
    const/4 v0, -0x1

    .line 254
    .local v0, "index":I
    sget-object v5, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    invoke-virtual {v5}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    sget-object v5, Ljava/util/Locale;->JAPAN:Ljava/util/Locale;

    invoke-virtual {v5}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 257
    :cond_2
    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 268
    :cond_3
    :goto_1
    const/4 v5, -0x1

    if-le v0, v5, :cond_0

    .line 270
    new-instance v3, Landroid/text/SpannableString;

    invoke-direct {v3, v4}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 271
    .local v3, "suggestionSpan":Landroid/text/SpannableString;
    new-instance v5, Landroid/text/style/StyleSpan;

    invoke-direct {v5, v7}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v6

    add-int/2addr v6, v0

    const/16 v7, 0x12

    invoke-virtual {v3, v5, v0, v6, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 273
    invoke-virtual {p1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 259
    .end local v3    # "suggestionSpan":Landroid/text/SpannableString;
    :cond_4
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mPattern:Ljava/util/regex/Pattern;

    if-eqz v5, :cond_3

    .line 262
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mPattern:Ljava/util/regex/Pattern;

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 263
    .local v2, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->find()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 265
    invoke-virtual {v2, v7}, Ljava/util/regex/Matcher;->end(I)I

    move-result v0

    goto :goto_1
.end method

.method private updateActionView(Landroid/content/Context;Landroid/database/Cursor;Landroid/widget/LinearLayout;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "layout"    # Landroid/widget/LinearLayout;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 221
    sget v5, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_suggestions:I

    invoke-virtual {p3, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 222
    .local v4, "suggestionsLayout":Landroid/widget/LinearLayout;
    const/16 v5, 0x8

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 224
    sget v5, Lcom/amazon/retailsearch/R$id;->rs_entry_action:I

    invoke-virtual {p3, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 225
    .local v0, "actionView":Landroid/widget/LinearLayout;
    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 227
    const-string/jumbo v5, "suggest_icon_1"

    invoke-interface {p2, v5}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    .line 228
    .local v3, "iconColumn":I
    invoke-interface {p2, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v2

    .line 230
    .local v2, "flags":I
    new-instance v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->querySubmitListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    invoke-direct {v1, v0, v5}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;-><init>(Landroid/widget/LinearLayout;Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V

    .line 231
    .local v1, "builder":Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;
    and-int/lit8 v5, v2, 0x1

    if-eqz v5, :cond_0

    move v5, v6

    :goto_0
    iput-boolean v5, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showVoice:Z

    .line 232
    and-int/lit8 v5, v2, 0x2

    if-eqz v5, :cond_1

    move v5, v6

    :goto_1
    iput-boolean v5, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showScan:Z

    .line 233
    and-int/lit8 v5, v2, 0x4

    if-eqz v5, :cond_2

    move v5, v6

    :goto_2
    iput-boolean v5, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showSnap:Z

    .line 234
    and-int/lit8 v5, v2, 0x8

    if-eqz v5, :cond_3

    move v5, v6

    :goto_3
    iput-boolean v5, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showFlow:Z

    .line 235
    and-int/lit8 v5, v2, 0x10

    if-eqz v5, :cond_4

    :goto_4
    iput-boolean v6, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showVisualScan:Z

    .line 236
    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->build()V

    .line 237
    return-void

    :cond_0
    move v5, v7

    .line 231
    goto :goto_0

    :cond_1
    move v5, v7

    .line 232
    goto :goto_1

    :cond_2
    move v5, v7

    .line 233
    goto :goto_2

    :cond_3
    move v5, v7

    .line 234
    goto :goto_3

    :cond_4
    move v6, v7

    .line 235
    goto :goto_4
.end method

.method private updateItemView(Landroid/content/Context;Landroid/database/Cursor;Landroid/widget/LinearLayout;)Landroid/view/View;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "layout"    # Landroid/widget/LinearLayout;

    .prologue
    .line 100
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xa

    if-le v0, v1, :cond_0

    .line 102
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-virtual {p3, v0}, Landroid/widget/LinearLayout;->setAlpha(F)V

    .line 108
    :goto_0
    invoke-static {p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->isActionRow(Landroid/database/Cursor;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 110
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->updateActionView(Landroid/content/Context;Landroid/database/Cursor;Landroid/widget/LinearLayout;)V

    .line 116
    :goto_1
    return-object p3

    .line 106
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 114
    :cond_1
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->updateSuggestionItemView(Landroid/content/Context;Landroid/database/Cursor;Landroid/widget/LinearLayout;)V

    goto :goto_1
.end method

.method private updateSuggestionItemView(Landroid/content/Context;Landroid/database/Cursor;Landroid/widget/LinearLayout;)V
    .locals 21
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "layout"    # Landroid/widget/LinearLayout;

    .prologue
    .line 127
    sget v17, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_suggestions:I

    move-object/from16 v0, p3

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v15

    check-cast v15, Landroid/widget/LinearLayout;

    .line 128
    .local v15, "suggestionsLayout":Landroid/widget/LinearLayout;
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 129
    sget v17, Lcom/amazon/retailsearch/R$id;->rs_entry_action:I

    move-object/from16 v0, p3

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 130
    .local v3, "actionView":Landroid/widget/LinearLayout;
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v3, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 132
    const-string/jumbo v17, "suggest_text_1"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v13

    .line 133
    .local v13, "searchSuggestionColumn":I
    move-object/from16 v0, p2

    invoke-interface {v0, v13}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    .line 134
    .local v12, "searchSuggestion":Ljava/lang/String;
    sget v17, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_text:I

    move-object/from16 v0, p3

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    .line 135
    .local v14, "suggestionTextView":Landroid/widget/TextView;
    invoke-virtual {v14, v12}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 137
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mSearchTerm:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v14, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->setSuggestionBold(Landroid/widget/TextView;Ljava/lang/String;)V

    .line 138
    const-string/jumbo v17, "suggest_intent_extra_data"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v17

    move-object/from16 v0, p2

    move/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v16

    .line 139
    .local v16, "type":Ljava/lang/String;
    sget v17, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_clear:I

    move-object/from16 v0, p3

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    .line 140
    .local v5, "clearImage":Landroid/widget/ImageView;
    sget-object v17, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->PAST_SEARCHES:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual/range {v17 .. v17}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-nez v17, :cond_0

    sget-object v17, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->MERGED:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual/range {v17 .. v17}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v17

    if-eqz v17, :cond_2

    .line 142
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    sget v18, Lcom/amazon/retailsearch/R$color;->rs_search_iss_pastsearches:I

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getColor(I)I

    move-result v17

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 143
    const-string/jumbo v17, "intent_extra_data_key"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v17

    move-object/from16 v0, p2

    move/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 144
    .local v10, "id":Ljava/lang/String;
    const-string/jumbo v17, "suggest_text_2_url"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v17

    move-object/from16 v0, p2

    move/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 145
    .local v6, "deleteURL":Ljava/lang/String;
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 146
    new-instance v17, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    move-object/from16 v2, p3

    invoke-direct {v0, v1, v10, v6, v2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$1;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;Ljava/lang/String;Ljava/lang/String;Landroid/widget/LinearLayout;)V

    move-object/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 181
    .end local v6    # "deleteURL":Ljava/lang/String;
    .end local v10    # "id":Ljava/lang/String;
    :cond_1
    :goto_0
    const-string/jumbo v17, "suggest_text_2"

    move-object/from16 v0, p2

    move-object/from16 v1, v17

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v11

    .line 182
    .local v11, "searchDepartmentNameColumn":I
    sget v17, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_department:I

    move-object/from16 v0, p3

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 184
    .local v8, "departmentTextView":Landroid/widget/TextView;
    move-object/from16 v0, p2

    invoke-interface {v0, v11}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 185
    .local v7, "departmentName":Ljava/lang/String;
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v17

    if-nez v17, :cond_3

    .line 187
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mContext:Landroid/content/Context;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    sget v18, Lcom/amazon/retailsearch/R$string;->rs_search_suggestions_department_text:I

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v7, v19, v20

    invoke-virtual/range {v17 .. v19}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    .line 189
    .local v9, "formatDepartmentName":Ljava/lang/String;
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setVisibility(I)V

    .line 190
    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 197
    .end local v9    # "formatDepartmentName":Ljava/lang/String;
    :goto_1
    sget v17, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_query_builder:I

    move-object/from16 v0, p3

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 198
    .local v4, "builderView":Landroid/widget/ImageView;
    const/16 v17, 0x0

    move/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 199
    new-instance v17, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$2;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v12}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter$2;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;Ljava/lang/String;)V

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 210
    return-void

    .line 173
    .end local v4    # "builderView":Landroid/widget/ImageView;
    .end local v7    # "departmentName":Ljava/lang/String;
    .end local v8    # "departmentTextView":Landroid/widget/TextView;
    .end local v11    # "searchDepartmentNameColumn":I
    :cond_2
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    const v18, 0x106000c

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getColor(I)I

    move-result v17

    move/from16 v0, v17

    invoke-virtual {v14, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 174
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 175
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    move-object/from16 v17, v0

    if-eqz v17, :cond_1

    .line 177
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    move-object/from16 v17, v0

    invoke-interface/range {v17 .. v17}, Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;->onA9SuggestionShow()V

    goto/16 :goto_0

    .line 194
    .restart local v7    # "departmentName":Ljava/lang/String;
    .restart local v8    # "departmentTextView":Landroid/widget/TextView;
    .restart local v11    # "searchDepartmentNameColumn":I
    :cond_3
    const/16 v17, 0x8

    move/from16 v0, v17

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 67
    move-object v0, p1

    check-cast v0, Landroid/widget/LinearLayout;

    .line 68
    .local v0, "layout":Landroid/widget/LinearLayout;
    invoke-direct {p0, p2, p3, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->updateItemView(Landroid/content/Context;Landroid/database/Cursor;Landroid/widget/LinearLayout;)Landroid/view/View;

    .line 69
    return-void
.end method

.method public convertToString(Landroid/database/Cursor;)Ljava/lang/CharSequence;
    .locals 2
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 280
    const-string/jumbo v1, "suggest_text_1"

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    .line 281
    .local v0, "searchSuggestionColumn":I
    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 305
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mCursor:Landroid/database/Cursor;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    goto :goto_0
.end method

.method public getCursor()Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mCursor:Landroid/database/Cursor;

    return-object v0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 74
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 75
    .local v0, "inflater":Landroid/view/LayoutInflater;
    sget v2, Lcom/amazon/retailsearch/R$layout;->rs_search_dropdown_item:I

    const/4 v3, 0x0

    invoke-virtual {v0, v2, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 76
    .local v1, "layout":Landroid/widget/LinearLayout;
    invoke-direct {p0, p1, p2, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->updateItemView(Landroid/content/Context;Landroid/database/Cursor;Landroid/widget/LinearLayout;)Landroid/view/View;

    move-result-object v2

    return-object v2
.end method

.method public updateContent(Ljava/lang/String;Landroid/database/Cursor;)V
    .locals 0
    .param p1, "searchTerm"    # Ljava/lang/String;
    .param p2, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 289
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->updateSearchTerm(Ljava/lang/String;)V

    .line 290
    invoke-virtual {p0, p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 291
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mCursor:Landroid/database/Cursor;

    .line 292
    return-void
.end method

.method public updateSearchTerm(Ljava/lang/String;)V
    .locals 2
    .param p1, "searchTerm"    # Ljava/lang/String;

    .prologue
    .line 314
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mSearchTerm:Ljava/lang/String;

    .line 315
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 317
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "(^|(?:\\s))"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mSearchTerm:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/regex/Pattern;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionCursorAdapter;->mPattern:Ljava/util/regex/Pattern;

    .line 319
    :cond_0
    return-void
.end method
