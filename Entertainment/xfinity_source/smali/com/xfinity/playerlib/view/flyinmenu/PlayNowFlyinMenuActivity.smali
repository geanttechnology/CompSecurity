.class public abstract Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
.super Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;
.source "PlayNowFlyinMenuActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;
.implements Lcom/comcast/cim/android/view/common/Searchable;
.implements Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HostingActivity;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$PlayNowFlyinMenuSpeechListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private appirater:Lcom/ijsbrandslob/appirater/Appirater;

.field private clearSearchButton:Landroid/view/View;

.field protected focusToggleState:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/view/View;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private handler:Landroid/os/Handler;

.field private inputMethodManager:Landroid/view/inputmethod/InputMethodManager;

.field private isInSearchMode:Z

.field private optionsMenuWasInvalidatedAfterSearchExpansion:Z

.field private searchDropDownUnderlay:Landroid/view/View;

.field private searchEditText:Landroid/widget/EditText;

.field protected searchMenuItem:Landroid/view/MenuItem;

.field private searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchQuery;",
            ">;"
        }
    .end annotation
.end field

.field protected searchResultsFragment:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

.field private sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

.field private sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

.field protected userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private voiceSearchButton:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 62
    const-class v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;-><init>()V

    .line 55
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 56
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInputMethodManager()Landroid/view/inputmethod/InputMethodManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->inputMethodManager:Landroid/view/inputmethod/InputMethodManager;

    .line 57
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSideRibbonDelegateBuilder()Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    .line 58
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSideMenuBuilder()Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    .line 59
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 60
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAppirater()Lcom/ijsbrandslob/appirater/Appirater;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    .line 61
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSearchQueryProvider()Lcom/comcast/cim/cmasl/utils/provider/Provider;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchQueryProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 71
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->handler:Landroid/os/Handler;

    .line 79
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->focusToggleState:Ljava/util/HashMap;

    .line 414
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Landroid/widget/EditText;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->clearSearchButton:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Landroid/view/inputmethod/InputMethodManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->inputMethodManager:Landroid/view/inputmethod/InputMethodManager;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 48
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->optionsMenuWasInvalidatedAfterSearchExpansion:Z

    return v0
.end method

.method static synthetic access$402(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 48
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->optionsMenuWasInvalidatedAfterSearchExpansion:Z

    return p1
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->handler:Landroid/os/Handler;

    return-object v0
.end method

.method private stopGapMenuInit()V
    .locals 2

    .prologue
    .line 351
    new-instance v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V

    .line 383
    .local v0, "showOptionsOnceAsyncTask":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/Boolean;>;"
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 384
    return-void
.end method


# virtual methods
.method protected addDefaultActivitySpeechListener()V
    .locals 1

    .prologue
    .line 114
    new-instance v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$PlayNowFlyinMenuSpeechListener;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$PlayNowFlyinMenuSpeechListener;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 115
    return-void
.end method

.method protected addSearchResultsFragmentIfApplicable()Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    .locals 4

    .prologue
    .line 170
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 171
    .local v0, "fm":Landroid/app/FragmentManager;
    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 172
    .local v2, "ft":Landroid/app/FragmentTransaction;
    const-string v3, "SEARCH_RESULTS_FRAGMENT_TAG"

    invoke-virtual {v0, v3}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .line 173
    .local v1, "fragment":Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    if-nez v1, :cond_0

    .line 174
    new-instance v1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .end local v1    # "fragment":Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    invoke-direct {v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;-><init>()V

    .line 175
    .restart local v1    # "fragment":Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
    const-string v3, "SEARCH_RESULTS_FRAGMENT_TAG"

    invoke-virtual {v2, v1, v3}, Landroid/app/FragmentTransaction;->add(Landroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 176
    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->commit()I

    .line 178
    :cond_0
    return-object v1
.end method

.method protected enterSearchMode()V
    .locals 6

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 308
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchDropDownUnderlay:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    .line 309
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->getSearchBackIcon()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->setActionBarIcon(I)V

    .line 313
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$7;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$7;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 320
    iput-boolean v4, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->isInSearchMode:Z

    .line 323
    const v0, 0x1020002

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 324
    .local v2, "root":Landroid/view/ViewGroup;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->focusToggleState:Ljava/util/HashMap;

    move-object v3, v2

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->toggleScreenFocus(Ljava/util/HashMap;Landroid/view/ViewGroup;Landroid/view/ViewGroup;ZZ)V

    .line 325
    return-void
.end method

.method protected exitSearchMode()V
    .locals 6

    .prologue
    const/4 v4, 0x0

    .line 328
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchDropDownUnderlay:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 329
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->resetActionBarIcon()V

    .line 331
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->inputMethodManager:Landroid/view/inputmethod/InputMethodManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v4}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 332
    iput-boolean v4, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->isInSearchMode:Z

    .line 334
    const v0, 0x1020002

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 335
    .local v2, "root":Landroid/view/ViewGroup;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->focusToggleState:Ljava/util/HashMap;

    move-object v3, v2

    move v5, v4

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->toggleScreenFocus(Ljava/util/HashMap;Landroid/view/ViewGroup;Landroid/view/ViewGroup;ZZ)V

    .line 337
    return-void
.end method

.method public abstract getSearchBackIcon()I
.end method

.method public getSearchEditText()Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 343
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    return-object v0
.end method

.method protected getSideMenuBuilder()Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;
    .locals 1

    .prologue
    .line 397
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->sideMenuBuilder:Lcom/comcast/cim/android/sideribbon/SideMenuBuilder;

    return-object v0
.end method

.method protected getSideRibbonDelegateBuilder()Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;
    .locals 1

    .prologue
    .line 402
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->sideRibbonDelegateBuilder:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder;

    return-object v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 411
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    return-object v0
.end method

.method protected getUserManager()Lcom/comcast/cim/model/user/UserManager;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/UserManager",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 166
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method public isSearching()Z
    .locals 1

    .prologue
    .line 407
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->isInSearchMode:Z

    return v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, -0x1

    .line 90
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->onCreate(Landroid/os/Bundle;)V

    .line 92
    if-eqz p1, :cond_0

    .line 93
    const-string v0, "EXTRA_IS_IN_SEARCH_MODE"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->isInSearchMode:Z

    .line 95
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->addSearchResultsFragmentIfApplicable()Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchResultsFragment:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .line 100
    new-instance v0, Landroid/widget/FrameLayout;

    invoke-direct {v0, p0}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchDropDownUnderlay:Landroid/view/View;

    .line 101
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchDropDownUnderlay:Landroid/view/View;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$color;->TranslucentBlack:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 102
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchDropDownUnderlay:Landroid/view/View;

    new-instance v1, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$1;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchDropDownUnderlay:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 108
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchDropDownUnderlay:Landroid/view/View;

    new-instance v1, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v1, v3, v3}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->addContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 110
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 183
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    .line 185
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$menu;->app_menu:I

    invoke-virtual {v1, v2, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 187
    sget v1, Lcom/xfinity/playerlib/R$id;->menu_item_search:I

    invoke-interface {p1, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchMenuItem:Landroid/view/MenuItem;

    .line 188
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v1}, Landroid/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    .line 189
    .local v0, "searchActionView":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->search_edit_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    .line 191
    sget v1, Lcom/xfinity/playerlib/R$id;->clear_search:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->clearSearchButton:Landroid/view/View;

    .line 192
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->clearSearchButton:Landroid/view/View;

    new-instance v2, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$2;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$2;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 199
    sget v1, Lcom/xfinity/playerlib/R$id;->speech_search:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->voiceSearchButton:Landroid/view/View;

    .line 201
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 203
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->voiceSearchButton:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 205
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->voiceSearchButton:Landroid/view/View;

    new-instance v2, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$3;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$3;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 215
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    new-instance v2, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$4;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$4;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 231
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    new-instance v2, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$5;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$5;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 242
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchMenuItem:Landroid/view/MenuItem;

    new-instance v2, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;-><init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setOnActionExpandListener(Landroid/view/MenuItem$OnActionExpandListener;)Landroid/view/MenuItem;

    .line 300
    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->isInSearchMode:Z

    if-eqz v1, :cond_1

    .line 301
    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v1}, Landroid/view/MenuItem;->expandActionView()Z

    .line 304
    :cond_1
    const/4 v1, 0x1

    return v1
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 155
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method protected onPause()V
    .locals 3

    .prologue
    .line 143
    invoke-super {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->onPause()V

    .line 145
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    invoke-virtual {v0}, Lcom/ijsbrandslob/appirater/Appirater;->dismiss()V

    .line 147
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    if-eqz v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 151
    :cond_0
    return-void
.end method

.method public onResumeInternal()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 119
    invoke-super {p0}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->onResumeInternal()V

    .line 121
    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 123
    .local v1, "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenCellularEnabledMessage()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 124
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenUpgradeMessage()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 125
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenParentalControlsMessage()Z

    move-result v2

    if-nez v2, :cond_1

    .line 126
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;

    invoke-direct {v0, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 127
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v2, 0x20000000

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 128
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->startActivity(Landroid/content/Intent;)V

    .line 131
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->stopGapMenuInit()V

    .line 133
    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    invoke-virtual {v2, v4, p0}, Lcom/ijsbrandslob/appirater/Appirater;->appEnteredForeground(ZLandroid/app/Activity;)V

    .line 135
    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    if-eqz v2, :cond_2

    .line 136
    iget-object v2, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchEditText:Landroid/widget/EditText;

    invoke-virtual {v2, v3, v4}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 139
    :cond_2
    return-void
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 84
    const-string v0, "EXTRA_IS_IN_SEARCH_MODE"

    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->isInSearchMode:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 85
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->expandActionView()Z

    .line 161
    const/4 v0, 0x1

    return v0
.end method

.method public onSideRibbonStateChanged(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V
    .locals 1
    .param p1, "state"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    .prologue
    .line 388
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/flow/flyinmenu/FlyinMenuActivity;->onSideRibbonStateChanged(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V

    .line 390
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->isInSearchMode:Z

    if-eqz v0, :cond_0

    .line 391
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->collapseActionView()Z

    .line 393
    :cond_0
    return-void
.end method
