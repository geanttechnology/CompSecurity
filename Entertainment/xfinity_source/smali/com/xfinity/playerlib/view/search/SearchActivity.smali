.class public Lcom/xfinity/playerlib/view/search/SearchActivity;
.super Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.source "SearchActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/search/SearchActivity$SearchActivitySpeechListener;
    }
.end annotation


# instance fields
.field private handler:Landroid/os/Handler;

.field private inputMethodManager:Landroid/view/inputmethod/InputMethodManager;

.field private searchEditText:Landroid/widget/EditText;

.field private final sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;-><init>()V

    .line 20
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSensorIfHasKeyboardOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    .line 21
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->handler:Landroid/os/Handler;

    .line 22
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInputMethodManager()Landroid/view/inputmethod/InputMethodManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->inputMethodManager:Landroid/view/inputmethod/InputMethodManager;

    .line 148
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/search/SearchActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchActivity;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->loadSearchTermsIfAvail()Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/search/SearchActivity;)Landroid/view/inputmethod/InputMethodManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->inputMethodManager:Landroid/view/inputmethod/InputMethodManager;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/search/SearchActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/search/SearchActivity;)Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchActivity;

    .prologue
    .line 18
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getSearchResultsFragment()Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/search/SearchActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/search/SearchActivity;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->searchEditText:Landroid/widget/EditText;

    return-object v0
.end method

.method private getSearchResultsFragment()Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .locals 2

    .prologue
    .line 89
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->main_fragment:I

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    return-object v0
.end method

.method private loadSearchTermsIfAvail()Z
    .locals 4

    .prologue
    .line 104
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 106
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->isAccessibilityEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    if-eqz v0, :cond_0

    .line 108
    const-string v3, "KEY_TERMS"

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 110
    .local v2, "terms":[Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 111
    const-string v3, " "

    invoke-static {v2, v3}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 112
    .local v1, "searchText":Ljava/lang/String;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->searchEditText:Landroid/widget/EditText;

    invoke-virtual {v3, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 113
    const/4 v3, 0x1

    .line 117
    .end local v1    # "searchText":Ljava/lang/String;
    .end local v2    # "terms":[Ljava/lang/String;
    :goto_0
    return v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected addDefaultActivitySpeechListener()V
    .locals 1

    .prologue
    .line 145
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchActivity$SearchActivitySpeechListener;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/search/SearchActivity$SearchActivitySpeechListener;-><init>(Lcom/xfinity/playerlib/view/search/SearchActivity;)V

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 146
    return-void
.end method

.method protected addSearchResultsFragmentIfApplicable()Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .locals 1

    .prologue
    .line 85
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getSearchResultsFragment()Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-result-object v0

    return-object v0
.end method

.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 94
    sget v0, Lcom/xfinity/playerlib/R$layout;->search:I

    return v0
.end method

.method public getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
    .locals 1

    .prologue
    .line 99
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->sensorIfHasKeyboardOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    return-object v0
.end method

.method public getSearchBackIcon()I
    .locals 1

    .prologue
    .line 80
    sget v0, Lcom/xfinity/playerlib/R$drawable;->ico_search:I

    return v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 140
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 27
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->onCreate(Landroid/os/Bundle;)V

    .line 28
    sget v0, Lcom/xfinity/playerlib/R$string;->search:I

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 29
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 33
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    .line 35
    .local v0, "result":Z
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v1}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->search_edit_text:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->searchEditText:Landroid/widget/EditText;

    .line 36
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->searchMenuItem:Landroid/view/MenuItem;

    new-instance v2, Lcom/xfinity/playerlib/view/search/SearchActivity$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/search/SearchActivity$1;-><init>(Lcom/xfinity/playerlib/view/search/SearchActivity;)V

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setOnActionExpandListener(Landroid/view/MenuItem$OnActionExpandListener;)Landroid/view/MenuItem;

    .line 73
    iget-object v1, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v1}, Landroid/view/MenuItem;->expandActionView()Z

    .line 74
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getSearchBackIcon()I

    move-result v1

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/search/SearchActivity;->setActionBarIcon(I)V

    .line 75
    return v0
.end method

.method public onSpeechSwipe()V
    .locals 4

    .prologue
    .line 123
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getSearchResultsFragment()Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->onSpeechSwiped()V

    .line 125
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 126
    .local v1, "intent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 128
    .local v0, "bundle":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 129
    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 132
    :cond_0
    const-string v2, "KEY_SEARCH_TERMS"

    iget-object v3, p0, Lcom/xfinity/playerlib/view/search/SearchActivity;->searchEditText:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->stopSpeaking()V

    .line 135
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    move-result-object v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchActivity;->getSpeechRecognizerClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->getSpeechInput(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 136
    return-void
.end method
