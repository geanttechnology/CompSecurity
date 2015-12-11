.class public Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;
.super Landroid/widget/LinearLayout;
.source "RetailSearchQueryEntry.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/api/display/input/SearchEntry;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;,
        Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;
    }
.end annotation


# static fields
.field public static final TAG:Ljava/lang/String;


# instance fields
.field private adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

.field private entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

.field private filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

.field private mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

.field private mInputManager:Landroid/view/inputmethod/InputMethodManager;

.field private final mQueryListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;>;"
        }
    .end annotation
.end field

.field private searchMagnifier:Landroid/graphics/drawable/Drawable;

.field private suggestionDataProvider:Lcom/amazon/retailsearch/data/SuggestionDataProvider;

.field private workingSpinner:Landroid/graphics/drawable/Drawable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 64
    const-class v0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 82
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 83
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 92
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 93
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 105
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 67
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mQueryListeners:Ljava/util/Set;

    .line 107
    new-instance v0, Lcom/amazon/retailsearch/data/SuggestionDataProvider;

    invoke-direct {v0, p1}, Lcom/amazon/retailsearch/data/SuggestionDataProvider;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->suggestionDataProvider:Lcom/amazon/retailsearch/data/SuggestionDataProvider;

    .line 108
    const-string/jumbo v0, "input_method"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mInputManager:Landroid/view/inputmethod/InputMethodManager;

    .line 109
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->rs_search_spinner:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->workingSpinner:Landroid/graphics/drawable/Drawable;

    .line 110
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->rs_search_bar_mag_glass:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->searchMagnifier:Landroid/graphics/drawable/Drawable;

    .line 111
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    .line 113
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setUpViews()V

    .line 114
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setUpAutoComplete()V

    .line 115
    invoke-direct {p0, p2, p3}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->processAttributes(Landroid/util/AttributeSet;I)V

    .line 118
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setAddStatesFromChildren(Z)V

    .line 120
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setFocusable(Z)V

    .line 121
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mQueryListeners:Ljava/util/Set;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    return-object v0
.end method

.method private processAttributes(Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "attrs"    # Landroid/util/AttributeSet;
    .param p2, "defStyle"    # I

    .prologue
    .line 243
    return-void
.end method

.method private resetDropDownAnchor()V
    .locals 2

    .prologue
    .line 137
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->getId()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setDropDownAnchor(I)V

    .line 138
    return-void
.end method

.method private setUpAutoComplete()V
    .locals 8

    .prologue
    const/4 v3, 0x0

    const/4 v7, 0x0

    .line 142
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0, v3}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setThreshold(I)V

    .line 143
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->enableClearTextButton(Z)V

    .line 144
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->searchMagnifier:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1, v7, v7, v7}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 145
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$string;->rs_search:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setHint(Ljava/lang/CharSequence;)V

    .line 146
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$dimen;->rs_action_bar_clear_button_padding_left:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {v0, v3, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setClearTextButtonPadding(II)V

    .line 148
    new-instance v5, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->workingSpinner:Landroid/graphics/drawable/Drawable;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->searchMagnifier:Landroid/graphics/drawable/Drawable;

    invoke-direct {v5, v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;-><init>(Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 149
    .local v5, "filterListener":Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;
    new-instance v6, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->suggestionDataProvider:Lcom/amazon/retailsearch/data/SuggestionDataProvider;

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-direct {v6, v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;-><init>(Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;Lcom/amazon/retailsearch/data/SuggestionDataProvider;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;)V

    .line 151
    .local v6, "suggestionsItemListener":Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->suggestionDataProvider:Lcom/amazon/retailsearch/data/SuggestionDataProvider;

    const-string/jumbo v2, "aps"

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;-><init>(Lcom/amazon/retailsearch/data/ISuggestionDataProvider;Ljava/lang/String;Landroid/widget/EditText;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilterListener;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    .line 152
    new-instance v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, v6, v7}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;-><init>(Landroid/content/Context;Lcom/amazon/retailsearch/android/ui/entry/SuggestionsItemListener;Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    .line 153
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    invoke-virtual {v5, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$FilterListener;->setAdapter(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;)V

    .line 154
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    invoke-virtual {v6, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$SearchSuggestionsItemListener;->setFilter(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;)V

    .line 155
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->filter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;->setFilter(Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionFilter;)V

    .line 157
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$1;-><init>(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 197
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$2;-><init>(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 222
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$3;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry$3;-><init>(Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setClearButtonEventListener(Lcom/amazon/retailsearch/android/ui/ClearButtonEventListener;)V

    .line 230
    return-void
.end method

.method private setUpViews()V
    .locals 3

    .prologue
    .line 125
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$layout;->retail_search_query_entry:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 128
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setOrientation(I)V

    .line 129
    const/16 v0, 0x10

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setGravity(I)V

    .line 131
    sget v0, Lcom/amazon/retailsearch/R$id;->query_entry_autocomplete_text_view:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    .line 132
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->resetDropDownAnchor()V

    .line 133
    return-void
.end method


# virtual methods
.method public addListener(Landroid/view/View$OnFocusChangeListener;)V
    .locals 1
    .param p1, "listener"    # Landroid/view/View$OnFocusChangeListener;

    .prologue
    .line 514
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 515
    return-void
.end method

.method public addListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V
    .locals 1
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
    .line 261
    .local p1, "listener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mQueryListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 262
    return-void
.end method

.method public clearInputFocus()V
    .locals 1

    .prologue
    .line 526
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->clearFocus()V

    .line 527
    return-void
.end method

.method public dismissSearch()V
    .locals 3

    .prologue
    .line 295
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mInputManager:Landroid/view/inputmethod/InputMethodManager;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 296
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->clearFocus()V

    .line 297
    return-void
.end method

.method public getSearchBoxInfo()Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;
    .locals 3

    .prologue
    .line 557
    new-instance v1, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;

    invoke-direct {v1}, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;-><init>()V

    .line 558
    .local v1, "v":Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;
    const/4 v2, 0x2

    new-array v0, v2, [I

    .line 559
    .local v0, "location":[I
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v2, v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getLocationOnScreen([I)V

    .line 560
    invoke-virtual {v1, v0}, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;->setCoords([I)V

    .line 561
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getWidth()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;->setWidth(I)V

    .line 562
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getHeight()I

    move-result v2

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/api/display/input/SearchEntry$ViewInfo;->setHeight(I)V

    .line 563
    return-object v1
.end method

.method public getViewLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .prologue
    .line 539
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method public hasFocus()Z
    .locals 1

    .prologue
    .line 544
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->hasFocus()Z

    move-result v0

    return v0
.end method

.method public hide()V
    .locals 1

    .prologue
    .line 472
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setVisibility(I)V

    .line 473
    return-void
.end method

.method protected onAttachedToWindow()V
    .locals 2

    .prologue
    .line 247
    invoke-super {p0}, Landroid/widget/LinearLayout;->onAttachedToWindow()V

    .line 250
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 251
    return-void
.end method

.method public onBackPressed()V
    .locals 0

    .prologue
    .line 509
    return-void
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 504
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 489
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 484
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 494
    return-void
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 499
    return-void
.end method

.method public openSearch()V
    .locals 3

    .prologue
    .line 285
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->requestFocus()Z

    .line 286
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mInputManager:Landroid/view/inputmethod/InputMethodManager;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 287
    return-void
.end method

.method public removeListener(Landroid/view/View$OnFocusChangeListener;)V
    .locals 2
    .param p1, "listener"    # Landroid/view/View$OnFocusChangeListener;

    .prologue
    .line 520
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setOnFocusChangeListener(Landroid/view/View$OnFocusChangeListener;)V

    .line 521
    return-void
.end method

.method public removeListener(Landroid/view/View$OnLongClickListener;)V
    .locals 2
    .param p1, "onLongClickListener"    # Landroid/view/View$OnLongClickListener;

    .prologue
    .line 575
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 576
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;

    .prologue
    .line 466
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->removeKeyPreImeListener()V

    .line 467
    return-void
.end method

.method public removeListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V
    .locals 1
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
    .line 460
    .local p1, "listener":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mQueryListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 461
    return-void
.end method

.method public requestSearchBoxFocus()V
    .locals 3

    .prologue
    .line 550
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->requestFocus()Z

    .line 551
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mInputManager:Landroid/view/inputmethod/InputMethodManager;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 552
    return-void
.end method

.method public setListener(Landroid/view/View$OnLongClickListener;)V
    .locals 1
    .param p1, "onLongClickListener"    # Landroid/view/View$OnLongClickListener;

    .prologue
    .line 569
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 570
    return-void
.end method

.method public setListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;)V
    .locals 1
    .param p1, "keyPreImeListener"    # Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;

    .prologue
    .line 454
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setKeyPreImeListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;)V

    .line 455
    return-void
.end method

.method public setQuery(Ljava/lang/String;)V
    .locals 2
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 273
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    const/4 v0, 0x0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    invoke-virtual {v1, v0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 274
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 275
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->mAutoCompleteTextView:Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->adapter:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionAdapter;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 276
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->entryContext:Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/entry/RetailSearchEntryContext;->setForceUpdatePastSearches(Z)V

    .line 277
    return-void
.end method

.method public setViewLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 0
    .param p1, "newParams"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 533
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 534
    return-void
.end method

.method public show()V
    .locals 1

    .prologue
    .line 478
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/input/RetailSearchQueryEntry;->setVisibility(I)V

    .line 479
    return-void
.end method
