.class public Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;
.super Landroid/widget/BaseAdapter;
.source "RetailSearchSuggestionAdapter.java"

# interfaces
.implements Landroid/widget/Filterable;


# instance fields
.field private boldStyleSpan:Landroid/text/style/StyleSpan;

.field private context:Landroid/content/Context;

.field private filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

.field private isCNJP:Z

.field private final layoutInflater:Landroid/view/LayoutInflater;

.field private listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

.field private pattern:Ljava/util/regex/Pattern;

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

.field private searchTerm:Ljava/lang/String;

.field private suggestionRows:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "listener"    # Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;",
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "querySubmitListener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    const/4 v1, 0x1

    .line 60
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 56
    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v1}, Landroid/text/style/StyleSpan;-><init>(I)V

    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->boldStyleSpan:Landroid/text/style/StyleSpan;

    .line 61
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 62
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->layoutInflater:Landroid/view/LayoutInflater;

    .line 63
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->context:Landroid/content/Context;

    .line 64
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    .line 65
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->querySubmitListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    .line 66
    invoke-static {}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getConfiguration()Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchConfiguration;->getRealm()Lcom/amazon/searchapp/retailsearch/client/SearchRealm;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/searchapp/retailsearch/client/SearchRealm;->getLocale()Ljava/lang/String;

    move-result-object v0

    .line 67
    .local v0, "locale":Ljava/lang/String;
    sget-object v2, Ljava/util/Locale;->CHINA:Ljava/util/Locale;

    invoke-virtual {v2}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    sget-object v2, Ljava/util/Locale;->JAPAN:Ljava/util/Locale;

    invoke-virtual {v2}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    :cond_0
    :goto_0
    iput-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->isCNJP:Z

    .line 68
    return-void

    .line 67
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;)Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    return-object v0
.end method

.method private setSuggestionBold(Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 7
    .param p1, "suggestionTextView"    # Landroid/widget/TextView;
    .param p2, "searchTerm"    # Ljava/lang/String;

    .prologue
    .line 266
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 295
    :cond_0
    :goto_0
    return-void

    .line 270
    :cond_1
    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 273
    .local v3, "suggestionText":Ljava/lang/String;
    const/4 v0, -0x1

    .line 274
    .local v0, "index":I
    iget-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->isCNJP:Z

    if-eqz v4, :cond_3

    .line 277
    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 288
    :cond_2
    :goto_1
    const/4 v4, -0x1

    if-le v0, v4, :cond_0

    .line 290
    new-instance v2, Landroid/text/SpannableString;

    invoke-direct {v2, v3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 291
    .local v2, "suggestionSpan":Landroid/text/SpannableString;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->boldStyleSpan:Landroid/text/style/StyleSpan;

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v5

    add-int/2addr v5, v0

    const/16 v6, 0x12

    invoke-virtual {v2, v4, v0, v5, v6}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 293
    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 279
    .end local v2    # "suggestionSpan":Landroid/text/SpannableString;
    :cond_3
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->pattern:Ljava/util/regex/Pattern;

    if-eqz v4, :cond_2

    .line 282
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->pattern:Ljava/util/regex/Pattern;

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    .line 283
    .local v1, "matcher":Ljava/util/regex/Matcher;
    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 285
    const/4 v4, 0x1

    invoke-virtual {v1, v4}, Ljava/util/regex/Matcher;->end(I)I

    move-result v0

    goto :goto_1
.end method

.method private updateActionView(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;Landroid/widget/LinearLayout;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "row"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    .param p3, "layout"    # Landroid/widget/LinearLayout;

    .prologue
    .line 244
    sget v3, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_suggestions:I

    invoke-virtual {p3, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 245
    .local v2, "suggestionsLayout":Landroid/widget/LinearLayout;
    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 247
    sget v3, Lcom/amazon/retailsearch/R$id;->rs_entry_action:I

    invoke-virtual {p3, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 248
    .local v0, "actionView":Landroid/widget/LinearLayout;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 250
    new-instance v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->querySubmitListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    invoke-direct {v1, v0, v3}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;-><init>(Landroid/widget/LinearLayout;Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V

    .line 251
    .local v1, "builder":Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->voiceEnabled()Z

    move-result v3

    iput-boolean v3, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showVoice:Z

    .line 252
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->showBarcode()Z

    move-result v3

    iput-boolean v3, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showScan:Z

    .line 253
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->hasSnap()Z

    move-result v3

    iput-boolean v3, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showSnap:Z

    .line 254
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->isFlowEnabled()Z

    move-result v3

    iput-boolean v3, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showFlow:Z

    .line 255
    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->showVisualScan()Z

    move-result v3

    iput-boolean v3, v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showVisualScan:Z

    .line 256
    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->build()V

    .line 257
    return-void
.end method

.method private updateItemView(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;Landroid/widget/LinearLayout;)Landroid/view/View;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "row"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    .param p3, "layout"    # Landroid/widget/LinearLayout;

    .prologue
    .line 124
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xa

    if-le v0, v1, :cond_0

    .line 126
    const/high16 v0, 0x3f800000    # 1.0f

    invoke-virtual {p3, v0}, Landroid/widget/LinearLayout;->setAlpha(F)V

    .line 132
    :goto_0
    sget-object v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->ICON:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    invoke-virtual {p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getRowType()Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 134
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->updateActionView(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;Landroid/widget/LinearLayout;)V

    .line 140
    :goto_1
    return-object p3

    .line 130
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p3, v0}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 138
    :cond_1
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->updateSuggestionItemView(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;Landroid/widget/LinearLayout;)V

    goto :goto_1
.end method

.method private updateSuggestionItemView(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;Landroid/widget/LinearLayout;)V
    .locals 18
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "row"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    .param p3, "layout"    # Landroid/widget/LinearLayout;

    .prologue
    .line 151
    sget v14, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_suggestions:I

    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/widget/LinearLayout;

    .line 152
    .local v12, "suggestionsLayout":Landroid/widget/LinearLayout;
    const/4 v14, 0x0

    invoke-virtual {v12, v14}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 154
    sget v14, Lcom/amazon/retailsearch/R$id;->rs_entry_action:I

    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 155
    .local v2, "actionView":Landroid/widget/LinearLayout;
    const/16 v14, 0x8

    invoke-virtual {v2, v14}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 157
    invoke-virtual/range {p2 .. p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getSuggestion()Ljava/lang/String;

    move-result-object v10

    .line 158
    .local v10, "searchSuggestion":Ljava/lang/String;
    sget v14, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_text:I

    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/TextView;

    .line 159
    .local v11, "suggestionTextView":Landroid/widget/TextView;
    invoke-virtual {v11, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 161
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->searchTerm:Ljava/lang/String;

    move-object/from16 v0, p0

    invoke-direct {v0, v11, v14}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->setSuggestionBold(Landroid/widget/TextView;Ljava/lang/String;)V

    .line 162
    invoke-virtual/range {p2 .. p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getSuggestionType()Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    move-result-object v14

    invoke-virtual {v14}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v13

    .line 163
    .local v13, "type":Ljava/lang/String;
    sget v14, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_clear:I

    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 164
    .local v4, "clearImage":Landroid/widget/ImageView;
    sget-object v14, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->PAST_SEARCHES:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v14}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v14, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-nez v14, :cond_0

    sget-object v14, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->MERGED:Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;

    invoke-virtual {v14}, Lcom/amazon/retailsearch/data/SuggestionDataItem$SuggestionType;->name()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v14, v13}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v14

    if-eqz v14, :cond_2

    .line 166
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    sget v15, Lcom/amazon/retailsearch/R$color;->rs_search_iss_pastsearches:I

    invoke-virtual {v14, v15}, Landroid/content/res/Resources;->getColor(I)I

    move-result v14

    invoke-virtual {v11, v14}, Landroid/widget/TextView;->setTextColor(I)V

    .line 167
    invoke-virtual/range {p2 .. p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getPastSearchId()Ljava/lang/String;

    move-result-object v9

    .line 168
    .local v9, "id":Ljava/lang/String;
    invoke-virtual/range {p2 .. p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getDeleteUrl()Ljava/lang/String;

    move-result-object v5

    .line 169
    .local v5, "deleteURL":Ljava/lang/String;
    const/4 v14, 0x0

    invoke-virtual {v4, v14}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 170
    new-instance v14, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$1;

    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v14, v0, v9, v5, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$1;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;Ljava/lang/String;Ljava/lang/String;Landroid/widget/LinearLayout;)V

    invoke-virtual {v4, v14}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 205
    .end local v5    # "deleteURL":Ljava/lang/String;
    .end local v9    # "id":Ljava/lang/String;
    :cond_1
    :goto_0
    sget v14, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_department:I

    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 207
    .local v7, "departmentTextView":Landroid/widget/TextView;
    invoke-virtual/range {p2 .. p2}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;->getDepartment()Ljava/lang/String;

    move-result-object v6

    .line 208
    .local v6, "departmentName":Ljava/lang/String;
    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_3

    .line 210
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    sget v15, Lcom/amazon/retailsearch/R$string;->rs_search_suggestions_department_text:I

    const/16 v16, 0x1

    move/from16 v0, v16

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v16, v0

    const/16 v17, 0x0

    aput-object v6, v16, v17

    invoke-virtual/range {v14 .. v16}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    .line 212
    .local v8, "formatDepartmentName":Ljava/lang/String;
    const/4 v14, 0x0

    invoke-virtual {v7, v14}, Landroid/widget/TextView;->setVisibility(I)V

    .line 213
    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 220
    .end local v8    # "formatDepartmentName":Ljava/lang/String;
    :goto_1
    sget v14, Lcom/amazon/retailsearch/R$id;->rs_search_dropdown_item_query_builder:I

    move-object/from16 v0, p3

    invoke-virtual {v0, v14}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 221
    .local v3, "builderView":Landroid/widget/ImageView;
    const/4 v14, 0x0

    invoke-virtual {v3, v14}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 222
    new-instance v14, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$2;

    move-object/from16 v0, p0

    invoke-direct {v14, v0, v10}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter$2;-><init>(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;Ljava/lang/String;)V

    invoke-virtual {v3, v14}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    return-void

    .line 197
    .end local v3    # "builderView":Landroid/widget/ImageView;
    .end local v6    # "departmentName":Ljava/lang/String;
    .end local v7    # "departmentTextView":Landroid/widget/TextView;
    :cond_2
    invoke-virtual/range {p1 .. p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    const v15, 0x106000c

    invoke-virtual {v14, v15}, Landroid/content/res/Resources;->getColor(I)I

    move-result v14

    invoke-virtual {v11, v14}, Landroid/widget/TextView;->setTextColor(I)V

    .line 198
    const/16 v14, 0x8

    invoke-virtual {v4, v14}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 199
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    if-eqz v14, :cond_1

    .line 201
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->listener:Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;

    invoke-interface {v14}, Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;->onA9SuggestionShow()V

    goto :goto_0

    .line 217
    .restart local v6    # "departmentName":Ljava/lang/String;
    .restart local v7    # "departmentTextView":Landroid/widget/TextView;
    :cond_3
    const/16 v14, 0x8

    invoke-virtual {v7, v14}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->suggestionRows:Ljava/util/List;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->suggestionRows:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    return-object v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 93
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->suggestionRows:Ljava/util/List;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->suggestionRows:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;

    goto :goto_0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 99
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 105
    move-object v0, p2

    check-cast v0, Landroid/widget/LinearLayout;

    .line 106
    .local v0, "dropdownLayout":Landroid/widget/LinearLayout;
    if-nez v0, :cond_0

    .line 108
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->layoutInflater:Landroid/view/LayoutInflater;

    sget v3, Lcom/amazon/retailsearch/R$layout;->rs_search_dropdown_item:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .end local v0    # "dropdownLayout":Landroid/widget/LinearLayout;
    check-cast v0, Landroid/widget/LinearLayout;

    .line 110
    .restart local v0    # "dropdownLayout":Landroid/widget/LinearLayout;
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->suggestionRows:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;

    .line 111
    .local v1, "row":Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->context:Landroid/content/Context;

    invoke-direct {p0, v2, v1, v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->updateItemView(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;Landroid/widget/LinearLayout;)Landroid/view/View;

    move-result-object p2

    .line 112
    return-object p2
.end method

.method public setFilter(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;)V
    .locals 0
    .param p1, "filter"    # Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    .prologue
    .line 75
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    .line 76
    return-void
.end method

.method public updateSuggestionContent(Ljava/lang/String;Ljava/util/List;)V
    .locals 2
    .param p1, "searchTerm"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 302
    .local p2, "suggestionRows":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow;>;"
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->searchTerm:Ljava/lang/String;

    .line 303
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->suggestionRows:Ljava/util/List;

    .line 304
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 306
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "(^|(?:\\s))"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/util/regex/Pattern;->quote(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->pattern:Ljava/util/regex/Pattern;

    .line 308
    :cond_0
    return-void
.end method
