.class public abstract Lcom/amazon/mShop/SearchBar;
.super Landroid/widget/LinearLayout;
.source "SearchBar.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mIsFirstTimeEnter:Z

.field private mIsTapped:Z

.field private mSearchBar:Landroid/view/View;

.field private mSearchBarPlate:Landroid/view/View;

.field private mSearchBarcode:Landroid/widget/ImageView;

.field private mSearchInput:Landroid/widget/EditText;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    const-class v0, Lcom/amazon/mShop/SearchBar;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/SearchBar;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 64
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/SearchBar;->mIsTapped:Z

    .line 65
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/SearchBar;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 66
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/SearchBar;->mIsFirstTimeEnter:Z

    .line 67
    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->initSearchBar()V

    .line 68
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 54
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/SearchBar;->mIsTapped:Z

    .line 55
    check-cast p1, Lcom/amazon/mShop/AmazonActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/SearchBar;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 56
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/SearchBar;->mIsFirstTimeEnter:Z

    .line 57
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/SearchBar;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/SearchBar;
    .param p1, "x1"    # Z

    .prologue
    .line 30
    iput-boolean p1, p0, Lcom/amazon/mShop/SearchBar;->mIsTapped:Z

    return p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/SearchBar;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/SearchBar;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarcode:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/SearchBar;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/SearchBar;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/SearchBar;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/SearchBar;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarPlate:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$400()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/amazon/mShop/SearchBar;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method private setupVoiceSearch()V
    .locals 5

    .prologue
    .line 262
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->voiceAllowed()Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-static {}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->voiceSearchInNavEnabled()Z

    move-result v3

    if-eqz v3, :cond_4

    .line 263
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->vs_nav_voice_btn_stub:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/SearchBar;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewStub;

    .line 265
    .local v1, "stub":Landroid/view/ViewStub;
    if-eqz v1, :cond_0

    .line 266
    invoke-virtual {v1}, Landroid/view/ViewStub;->inflate()Landroid/view/View;

    .line 269
    :cond_0
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->vs_nav_voice_btn:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/SearchBar;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 271
    .local v2, "view":Landroid/view/View;
    if-nez v2, :cond_3

    .line 272
    sget-object v3, Lcom/amazon/mShop/SearchBar;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Voice button not found"

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 300
    .end local v1    # "stub":Landroid/view/ViewStub;
    :cond_1
    :goto_0
    iget-object v3, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarcode:Landroid/widget/ImageView;

    if-eqz v3, :cond_2

    .line 301
    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->voiceAllowed()Z

    move-result v3

    if-eqz v3, :cond_5

    invoke-static {}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->getInstance()Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/shopapp/voice/mshop/MShopVoiceModule;->barcodeSearchEnabled()Z

    move-result v3

    if-nez v3, :cond_5

    .line 302
    iget-object v3, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarcode:Landroid/widget/ImageView;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 310
    .end local v2    # "view":Landroid/view/View;
    :cond_2
    :goto_1
    return-void

    .line 274
    .restart local v1    # "stub":Landroid/view/ViewStub;
    .restart local v2    # "view":Landroid/view/View;
    :cond_3
    new-instance v3, Lcom/amazon/mShop/SearchBar$6;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/SearchBar$6;-><init>(Lcom/amazon/mShop/SearchBar;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 290
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 307
    .end local v1    # "stub":Landroid/view/ViewStub;
    .end local v2    # "view":Landroid/view/View;
    :catch_0
    move-exception v0

    .line 308
    .local v0, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/mShop/SearchBar;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Failed to setup voice in search bar"

    invoke-static {v3, v4, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 293
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_4
    :try_start_1
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->vs_nav_voice_btn:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/SearchBar;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 295
    .restart local v2    # "view":Landroid/view/View;
    if-eqz v2, :cond_1

    .line 296
    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 304
    :cond_5
    iget-object v3, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarcode:Landroid/widget/ImageView;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method


# virtual methods
.method protected checkPreviousSearchTerm()V
    .locals 3

    .prologue
    .line 323
    invoke-static {}, Lcom/amazon/mShop/search/SearchActivity;->getPreviousSearchTerm()Ljava/lang/String;

    move-result-object v0

    .line 327
    .local v0, "previousSearchTerm":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 328
    iget-object v2, p0, Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;

    invoke-virtual {v2, v0}, Landroid/widget/EditText;->setTextKeepState(Ljava/lang/CharSequence;)V

    .line 330
    iget-object v2, p0, Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    .line 331
    .local v1, "searchInputEditable":Landroid/text/Editable;
    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v2

    invoke-static {v1, v2}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;I)V

    .line 333
    .end local v1    # "searchInputEditable":Landroid/text/Editable;
    :cond_0
    return-void
.end method

.method protected doBarcodeScan()V
    .locals 2

    .prologue
    .line 339
    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->getBarcodeScanIntent()Landroid/content/Intent;

    move-result-object v0

    .line 340
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/amazon/mShop/SearchBar;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/AmazonActivity;->startActivity(Landroid/content/Intent;)V

    .line 341
    return-void
.end method

.method protected getBarcodeScanIntent()Landroid/content/Intent;
    .locals 3

    .prologue
    .line 347
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->getContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/amazon/mShop/search/SearchActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 348
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "android.intent.action.VIEW"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 349
    const-string/jumbo v1, "BARCODE_SEARCH_QUERY_KEYWORD"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 350
    return-object v0
.end method

.method public getSearchBar()Landroid/view/View;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBar:Landroid/view/View;

    return-object v0
.end method

.method public getSearchBarcodeView()Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarcode:Landroid/widget/ImageView;

    return-object v0
.end method

.method public getSearchInputView()Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;

    return-object v0
.end method

.method public getTextWatcher()Landroid/text/TextWatcher;
    .locals 1

    .prologue
    .line 214
    new-instance v0, Lcom/amazon/mShop/SearchBar$5;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/SearchBar$5;-><init>(Lcom/amazon/mShop/SearchBar;)V

    return-object v0
.end method

.method protected goToSearchEntry(Ljava/lang/String;Z)V
    .locals 1
    .param p1, "searchTerm"    # Ljava/lang/String;
    .param p2, "selectInitialQuery"    # Z

    .prologue
    .line 359
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/AmazonActivity;->onSearchRequested(Ljava/lang/String;Z)Z

    .line 360
    return-void
.end method

.method protected initSearchBar()V
    .locals 4

    .prologue
    .line 96
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->search_bar:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBar:Landroid/view/View;

    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBar:Landroid/view/View;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, -0x2

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 98
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBar:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/SearchBar;->addView(Landroid/view/View;)V

    .line 101
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBar:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->search_mag_glass:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->search_bar_mag_glass:I

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBar:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->search_bar_plate:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarPlate:Landroid/view/View;

    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBar:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->search_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;

    .line 105
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBar:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->search_right_barcode_btn:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarcode:Landroid/widget/ImageView;

    .line 107
    invoke-direct {p0}, Lcom/amazon/mShop/SearchBar;->setupVoiceSearch()V

    .line 109
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarPlate:Landroid/view/View;

    new-instance v1, Lcom/amazon/mShop/SearchBar$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/SearchBar$1;-><init>(Lcom/amazon/mShop/SearchBar;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 120
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchBarcode:Landroid/widget/ImageView;

    new-instance v1, Lcom/amazon/mShop/SearchBar$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/SearchBar$2;-><init>(Lcom/amazon/mShop/SearchBar;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 136
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;

    new-instance v1, Lcom/amazon/mShop/SearchBar$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/SearchBar$3;-><init>(Lcom/amazon/mShop/SearchBar;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 178
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;

    new-instance v1, Lcom/amazon/mShop/SearchBar$4;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/SearchBar$4;-><init>(Lcom/amazon/mShop/SearchBar;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 205
    iget-object v0, p0, Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;

    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->getTextWatcher()Landroid/text/TextWatcher;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 207
    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->checkPreviousSearchTerm()V

    .line 208
    return-void
.end method

.method public abstract logRefMarker()V
.end method

.method protected onFinishInflate()V
    .locals 0

    .prologue
    .line 88
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 89
    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->initSearchBar()V

    .line 90
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasWindowFocus"    # Z

    .prologue
    .line 243
    if-eqz p1, :cond_1

    .line 244
    iget-boolean v0, p0, Lcom/amazon/mShop/SearchBar;->mIsFirstTimeEnter:Z

    if-eqz v0, :cond_0

    .line 245
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/SearchBar;->mIsFirstTimeEnter:Z

    .line 247
    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->requestFocus()Z

    .line 251
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->checkPreviousSearchTerm()V

    .line 253
    invoke-direct {p0}, Lcom/amazon/mShop/SearchBar;->setupVoiceSearch()V

    .line 255
    :cond_1
    return-void
.end method

.method protected startSearch()V
    .locals 5

    .prologue
    .line 366
    iget-object v4, p0, Lcom/amazon/mShop/SearchBar;->mSearchInput:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    .line 367
    .local v1, "editable":Landroid/text/Editable;
    if-eqz v1, :cond_0

    .line 368
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/control/search/AdvSearchResultsBrowser;->validateQuery(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 369
    .local v2, "query":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 370
    invoke-virtual {p0}, Lcom/amazon/mShop/SearchBar;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 371
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    new-instance v3, Lcom/amazon/mShop/search/SearchIntentBuilder;

    invoke-direct {v3, v0}, Lcom/amazon/mShop/search/SearchIntentBuilder;-><init>(Landroid/content/Context;)V

    .line 372
    .local v3, "searchIntentBuilder":Lcom/amazon/mShop/search/SearchIntentBuilder;
    invoke-virtual {v3, v2}, Lcom/amazon/mShop/search/SearchIntentBuilder;->query(Ljava/lang/String;)Lcom/amazon/mShop/search/SearchIntentBuilder;

    .line 373
    invoke-virtual {v3}, Lcom/amazon/mShop/search/SearchIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/AmazonActivity;->startActivity(Landroid/content/Intent;)V

    .line 376
    .end local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    .end local v2    # "query":Ljava/lang/String;
    .end local v3    # "searchIntentBuilder":Lcom/amazon/mShop/search/SearchIntentBuilder;
    :cond_0
    return-void
.end method

.method protected voiceAllowed()Z
    .locals 1

    .prologue
    .line 316
    const/4 v0, 0x1

    return v0
.end method
