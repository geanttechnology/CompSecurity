.class public Lco/vine/android/FindFriendsNUXActivity;
.super Lco/vine/android/FindFriendsBaseActivity;
.source "FindFriendsNUXActivity.java"

# interfaces
.implements Landroid/text/TextWatcher;
.implements Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;
.implements Landroid/widget/TextView$OnEditorActionListener;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/FindFriendsNUXActivity$1;,
        Lco/vine/android/FindFriendsNUXActivity$FindFriendsNUXListener;,
        Lco/vine/android/FindFriendsNUXActivity$FilterableFriendsList;
    }
.end annotation


# static fields
.field public static final ARG_FROM_SIGN_UP:Ljava/lang/String; = "from_sign_up"

.field public static final ARG_TAKE_FOCUS:Ljava/lang/String; = "take_focus"


# instance fields
.field private mClear:Landroid/widget/ImageButton;

.field private mIsTwitterReg:Z

.field private mQuery:Landroid/widget/EditText;

.field private mSearch:Landroid/view/MenuItem;

.field private mUserIdsToFollow:Ljava/util/HashSet;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashSet",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Lco/vine/android/FindFriendsBaseActivity;-><init>()V

    .line 313
    return-void
.end method

.method private addContactsTab()V
    .locals 4

    .prologue
    .line 186
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    const-string v3, "address"

    invoke-virtual {v2, v3}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    .line 187
    .local v1, "tabSpec":Landroid/widget/TabHost$TabSpec;
    const v2, 0x7f0e008f

    const v3, 0x7f09004a

    invoke-direct {p0, v2, v3}, Lco/vine/android/FindFriendsNUXActivity;->getTabIndicator(II)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    .line 189
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 190
    .local v0, "bundle":Landroid/os/Bundle;
    iget-boolean v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mIsTwitterReg:Z

    if-eqz v2, :cond_0

    .line 191
    const-string v2, "take_focus"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 193
    :cond_0
    const-string v2, "empty_desc"

    const v3, 0x7f0e00e1

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 194
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    const-class v3, Lco/vine/android/FindFriendsNUXAddressFragment;

    invoke-virtual {v2, v1, v3, v0}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 195
    return-void
.end method

.method private addTwitterTab()V
    .locals 4

    .prologue
    .line 198
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    const-string v3, "twitter"

    invoke-virtual {v2, v3}, Lco/vine/android/widget/tabs/IconTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v1

    .line 199
    .local v1, "tabSpec":Landroid/widget/TabHost$TabSpec;
    const v2, 0x7f0e0250

    const v3, 0x7f09004c

    invoke-direct {p0, v2, v3}, Lco/vine/android/FindFriendsNUXActivity;->getTabIndicator(II)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    .line 201
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 202
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v2, "from_sign_up"

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 203
    const-string v2, "empty_desc"

    const v3, 0x7f0e00ef

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 204
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    const-class v3, Lco/vine/android/FindFriendsTwitterFragment;

    invoke-virtual {v2, v1, v3, v0}, Lco/vine/android/widget/tabs/TabsAdapter;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 205
    return-void
.end method

.method private getTabIndicator(II)Lco/vine/android/widget/tabs/TabIndicator;
    .locals 7
    .param p1, "tabTextId"    # I
    .param p2, "colorResId"    # I

    .prologue
    .line 208
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    const v4, 0x7f030062

    iget-object v5, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    const/4 v6, 0x0

    invoke-static {v3, v4, v5, p1, v6}, Lco/vine/android/widget/tabs/TabIndicator;->newTextIndicator(Landroid/view/LayoutInflater;ILandroid/widget/TabHost;IZ)Lco/vine/android/widget/tabs/TabIndicator;

    move-result-object v0

    .line 210
    .local v0, "indicator":Lco/vine/android/widget/tabs/TabIndicator;
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, p2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f090057

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-static {v3, v4}, Lco/vine/android/widget/tabs/TabIndicator;->createTextColorList(II)Landroid/content/res/ColorStateList;

    move-result-object v1

    .line 212
    .local v1, "indicatorStateList":Landroid/content/res/ColorStateList;
    invoke-virtual {v0}, Lco/vine/android/widget/tabs/TabIndicator;->getIndicatorText()Landroid/widget/TextView;

    move-result-object v2

    .line 213
    .local v2, "indicatorText":Landroid/widget/TextView;
    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v3

    iget-object v3, v3, Lco/vine/android/widget/Typefaces;->boldContent:Landroid/graphics/Typeface;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 214
    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setTextColor(Landroid/content/res/ColorStateList;)V

    .line 216
    return-object v0
.end method

.method public static start(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 310
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/FindFriendsNUXActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 311
    return-void
.end method


# virtual methods
.method public addUserToFollow(J)V
    .locals 2
    .param p1, "userId"    # J

    .prologue
    .line 220
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mUserIdsToFollow:Ljava/util/HashSet;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 221
    return-void
.end method

.method public addUsersToFollow(Ljava/util/ArrayList;Lco/vine/android/Friendships;)V
    .locals 5
    .param p2, "friendships"    # Lco/vine/android/Friendships;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;",
            "Lco/vine/android/Friendships;",
            ")V"
        }
    .end annotation

    .prologue
    .line 224
    .local p1, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineUser;

    .line 225
    .local v1, "user":Lco/vine/android/api/VineUser;
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mUserIdsToFollow:Ljava/util/HashSet;

    iget-wide v3, v1, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    .line 226
    iget-wide v2, v1, Lco/vine/android/api/VineUser;->userId:J

    invoke-virtual {p2, v2, v3}, Lco/vine/android/Friendships;->addFollowing(J)V

    goto :goto_0

    .line 228
    .end local v1    # "user":Lco/vine/android/api/VineUser;
    :cond_0
    return-void
.end method

.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 289
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 272
    return-void
.end method

.method public clearSearch()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 115
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 116
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mClear:Landroid/widget/ImageButton;

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 117
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->clearFocus()V

    .line 118
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v7/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 119
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 120
    return-void
.end method

.method public onBackPressed()V
    .locals 2

    .prologue
    .line 247
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->hasFocus()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 248
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->clearSearch()V

    .line 252
    :cond_1
    :goto_0
    return-void

    .line 249
    :cond_2
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    if-lez v0, :cond_1

    .line 250
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lco/vine/android/FindFriendsNUXActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 106
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 112
    :goto_0
    return-void

    .line 108
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->clearSearch()V

    goto :goto_0

    .line 106
    :pswitch_data_0
    .packed-switch 0x7f0a01e9
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 12
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 54
    invoke-super {p0, p1}, Lco/vine/android/FindFriendsBaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 56
    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    const v8, 0x7f0e00de

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    invoke-virtual {p0, v6, v7, v8, v9}, Lco/vine/android/FindFriendsNUXActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 58
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 59
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_0

    .line 60
    invoke-virtual {v0, v11}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 61
    const v6, 0x7f03008a

    invoke-virtual {v0, v6}, Landroid/support/v7/app/ActionBar;->setCustomView(I)V

    .line 63
    invoke-virtual {v0}, Landroid/support/v7/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    .line 64
    .local v2, "customView":Landroid/view/View;
    const/16 v6, 0x8

    invoke-virtual {v2, v6}, Landroid/view/View;->setVisibility(I)V

    .line 66
    const v6, 0x7f0a01a9

    invoke-virtual {v2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    .line 67
    .local v4, "query":Landroid/widget/EditText;
    const v6, 0x3f8ccccd    # 1.1f

    const/high16 v7, 0x41400000    # 12.0f

    new-array v8, v11, [Landroid/widget/TextView;

    aput-object v4, v8, v10

    invoke-static {p0, v6, v7, v8}, Lco/vine/android/util/ViewUtil;->reduceTextSizeViaFontScaleIfNeeded(Landroid/content/Context;FF[Landroid/widget/TextView;)V

    .line 68
    invoke-virtual {v4, p0}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 69
    invoke-virtual {v4, p0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 70
    const/high16 v6, 0x80000

    invoke-virtual {v4, v6}, Landroid/widget/EditText;->setInputType(I)V

    .line 71
    iput-object v4, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    .line 73
    const v6, 0x7f0a01e9

    invoke-virtual {v2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 74
    .local v1, "clear":Landroid/widget/ImageButton;
    invoke-virtual {v1, p0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 75
    iput-object v1, p0, Lco/vine/android/FindFriendsNUXActivity;->mClear:Landroid/widget/ImageButton;

    .line 78
    .end local v1    # "clear":Landroid/widget/ImageButton;
    .end local v2    # "customView":Landroid/view/View;
    .end local v4    # "query":Landroid/widget/EditText;
    :cond_0
    new-instance v6, Lco/vine/android/FindFriendsNUXActivity$FindFriendsNUXListener;

    const/4 v7, 0x0

    invoke-direct {v6, p0, v7}, Lco/vine/android/FindFriendsNUXActivity$FindFriendsNUXListener;-><init>(Lco/vine/android/FindFriendsNUXActivity;Lco/vine/android/FindFriendsNUXActivity$1;)V

    iput-object v6, p0, Lco/vine/android/FindFriendsNUXActivity;->mAppSessionListener:Lco/vine/android/client/AppSessionListener;

    .line 80
    iget-object v5, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    .line 81
    .local v5, "tabHost":Lco/vine/android/widget/tabs/IconTabHost;
    iget-object v6, p0, Lco/vine/android/FindFriendsNUXActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    const/4 v7, 0x2

    invoke-virtual {v6, v7}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setRange(I)V

    .line 82
    iget-object v6, p0, Lco/vine/android/FindFriendsNUXActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v6, v11}, Landroid/support/v4/view/ViewPager;->setOffscreenPageLimit(I)V

    .line 83
    new-instance v6, Lco/vine/android/widget/tabs/TabsAdapter;

    iget-object v7, p0, Lco/vine/android/FindFriendsNUXActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    iget-object v8, p0, Lco/vine/android/FindFriendsNUXActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    invoke-direct {v6, p0, v5, v7, v8}, Lco/vine/android/widget/tabs/TabsAdapter;-><init>(Lco/vine/android/BaseControllerActionBarActivity;Landroid/widget/TabHost;Landroid/support/v4/view/ViewPager;Lco/vine/android/widget/tabs/ViewPagerScrollBar;)V

    iput-object v6, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    .line 85
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    .line 86
    .local v3, "intent":Landroid/content/Intent;
    if-eqz v3, :cond_1

    .line 87
    const-string v6, "is_twitter_reg"

    invoke-virtual {v3, v6, v10}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v6

    iput-boolean v6, p0, Lco/vine/android/FindFriendsNUXActivity;->mIsTwitterReg:Z

    .line 90
    :cond_1
    invoke-virtual {v5, p0}, Lco/vine/android/widget/tabs/IconTabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 91
    invoke-virtual {v5, p0}, Lco/vine/android/widget/tabs/IconTabHost;->setOnTabClickedListener(Lco/vine/android/widget/tabs/IconTabHost$OnTabClickedListener;)V

    .line 93
    iget-boolean v6, p0, Lco/vine/android/FindFriendsNUXActivity;->mIsTwitterReg:Z

    if-eqz v6, :cond_2

    .line 94
    invoke-direct {p0}, Lco/vine/android/FindFriendsNUXActivity;->addTwitterTab()V

    .line 95
    invoke-direct {p0}, Lco/vine/android/FindFriendsNUXActivity;->addContactsTab()V

    .line 101
    :goto_0
    new-instance v6, Ljava/util/HashSet;

    invoke-direct {v6}, Ljava/util/HashSet;-><init>()V

    iput-object v6, p0, Lco/vine/android/FindFriendsNUXActivity;->mUserIdsToFollow:Ljava/util/HashSet;

    .line 102
    return-void

    .line 97
    :cond_2
    invoke-direct {p0}, Lco/vine/android/FindFriendsNUXActivity;->addContactsTab()V

    .line 98
    invoke-direct {p0}, Lco/vine/android/FindFriendsNUXActivity;->addTwitterTab()V

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 4
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 124
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 131
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v2

    const v3, 0x7f10000d

    invoke-virtual {v2, v3, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 136
    :goto_0
    const v2, 0x7f0a00e4

    invoke-interface {p1, v2}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v1

    .line 137
    .local v1, "search":Landroid/view/MenuItem;
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v2}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 138
    .local v0, "currentFragment":Landroid/support/v4/app/Fragment;
    instance-of v2, v0, Lco/vine/android/FindFriendsNUXActivity$FilterableFriendsList;

    if-eqz v2, :cond_0

    if-eqz v1, :cond_0

    .line 139
    check-cast v0, Lco/vine/android/FindFriendsNUXActivity$FilterableFriendsList;

    .end local v0    # "currentFragment":Landroid/support/v4/app/Fragment;
    invoke-interface {v0}, Lco/vine/android/FindFriendsNUXActivity$FilterableFriendsList;->shouldShowSearchIcon()Z

    move-result v2

    invoke-interface {v1, v2}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 141
    :cond_0
    iput-object v1, p0, Lco/vine/android/FindFriendsNUXActivity;->mSearch:Landroid/view/MenuItem;

    .line 143
    const/4 v2, 0x1

    return v2

    .line 126
    .end local v1    # "search":Landroid/view/MenuItem;
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v2

    const v3, 0x7f10000c

    invoke-virtual {v2, v3, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    goto :goto_0

    .line 124
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onCurrentTabClicked()V
    .locals 0

    .prologue
    .line 260
    return-void
.end method

.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x0

    .line 293
    invoke-virtual {p1}, Landroid/widget/TextView;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 304
    :cond_0
    :goto_0
    return v0

    .line 295
    :pswitch_0
    const/4 v1, 0x3

    if-eq p2, v1, :cond_1

    if-eqz p3, :cond_0

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    const/16 v2, 0x42

    if-ne v1, v2, :cond_0

    .line 297
    :cond_1
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->clearFocus()V

    .line 298
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    invoke-static {p0, v1, v0}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 299
    const/4 v0, 0x1

    goto :goto_0

    .line 293
    :pswitch_data_0
    .packed-switch 0x7f0a01a9
        :pswitch_0
    .end packed-switch
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 5
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 148
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v2

    sparse-switch v2, :sswitch_data_0

    .line 163
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mUserIdsToFollow:Ljava/util/HashSet;

    invoke-virtual {v2}, Ljava/util/HashSet;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 164
    new-instance v0, Landroid/app/ProgressDialog;

    const v2, 0x7f0f0037

    invoke-direct {v0, p0, v2}, Landroid/app/ProgressDialog;-><init>(Landroid/content/Context;I)V

    .line 165
    .local v0, "dialog":Landroid/app/ProgressDialog;
    iput-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 166
    invoke-virtual {v0, v3}, Landroid/app/ProgressDialog;->setProgressStyle(I)V

    .line 167
    const v2, 0x7f0e0103

    invoke-virtual {p0, v2}, Lco/vine/android/FindFriendsNUXActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 169
    :try_start_0
    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 173
    :goto_0
    new-instance v1, Ljava/util/ArrayList;

    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mUserIdsToFollow:Ljava/util/HashSet;

    invoke-direct {v1, v2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 174
    .local v1, "userIdsToFollow":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, p0, Lco/vine/android/FindFriendsNUXActivity;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    invoke-virtual {v2, v3, v1}, Lco/vine/android/client/AppController;->bulkFollowUsers(Lco/vine/android/client/Session;Ljava/util/ArrayList;)Ljava/lang/String;

    .line 182
    .end local v0    # "dialog":Landroid/app/ProgressDialog;
    .end local v1    # "userIdsToFollow":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    :goto_1
    return v4

    .line 150
    :sswitch_0
    invoke-interface {p1, v3}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 151
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v7/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 152
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mClear:Landroid/widget/ImageButton;

    invoke-virtual {v2, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 153
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->requestFocus()Z

    .line 154
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mQuery:Landroid/widget/EditText;

    invoke-static {p0, v2, v4}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    goto :goto_1

    .line 158
    :sswitch_1
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2, v4}, Landroid/support/v4/view/ViewPager;->setCurrentItem(I)V

    goto :goto_1

    .line 176
    :cond_0
    invoke-static {p0, v4}, Lco/vine/android/StartActivity;->toStart(Landroid/content/Context;Z)V

    .line 177
    invoke-virtual {p0}, Lco/vine/android/FindFriendsNUXActivity;->finish()V

    goto :goto_1

    .line 170
    .restart local v0    # "dialog":Landroid/app/ProgressDialog;
    :catch_0
    move-exception v2

    goto :goto_0

    .line 148
    nop

    :sswitch_data_0
    .sparse-switch
        0x7f0a00e4 -> :sswitch_0
        0x7f0a0246 -> :sswitch_1
    .end sparse-switch
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 276
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabsAdapter:Lco/vine/android/widget/tabs/TabsAdapter;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/TabsAdapter;->getCurrentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 277
    .local v0, "currentFragment":Landroid/support/v4/app/Fragment;
    instance-of v1, v0, Lco/vine/android/FindFriendsNUXActivity$FilterableFriendsList;

    if-eqz v1, :cond_0

    .line 278
    check-cast v0, Lco/vine/android/FindFriendsNUXActivity$FilterableFriendsList;

    .end local v0    # "currentFragment":Landroid/support/v4/app/Fragment;
    invoke-interface {v0, p1, p2, p3, p4}, Lco/vine/android/FindFriendsNUXActivity$FilterableFriendsList;->onTextChanged(Ljava/lang/CharSequence;III)V

    .line 280
    :cond_0
    return-void
.end method

.method public removeUserToFollow(J)V
    .locals 2
    .param p1, "userId"    # J

    .prologue
    .line 231
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mUserIdsToFollow:Ljava/util/HashSet;

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 232
    return-void
.end method

.method setCurrentTabByTag(Ljava/lang/String;)V
    .locals 3
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 263
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mTabHost:Lco/vine/android/widget/tabs/IconTabHost;

    .line 264
    .local v0, "tabHost":Landroid/widget/TabHost;
    invoke-virtual {v0}, Landroid/widget/TabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 265
    invoke-virtual {v0, p1}, Landroid/widget/TabHost;->setCurrentTabByTag(Ljava/lang/String;)V

    .line 267
    :cond_0
    iget-object v1, p0, Lco/vine/android/FindFriendsNUXActivity;->mScrollBar:Lco/vine/android/widget/tabs/ViewPagerScrollBar;

    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v2}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v2

    invoke-virtual {v1, v2}, Lco/vine/android/widget/tabs/ViewPagerScrollBar;->setPosition(I)V

    .line 268
    return-void
.end method

.method public showSearchIcon(Z)V
    .locals 1
    .param p1, "show"    # Z

    .prologue
    .line 255
    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mSearch:Landroid/view/MenuItem;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/FindFriendsNUXActivity;->mSearch:Landroid/view/MenuItem;

    invoke-interface {v0, p1}, Landroid/view/MenuItem;->setVisible(Z)Landroid/view/MenuItem;

    .line 256
    :cond_0
    return-void
.end method

.method public toggleFollowAll(ZLjava/util/ArrayList;Lco/vine/android/Friendships;)V
    .locals 5
    .param p1, "selectAll"    # Z
    .param p3, "friendships"    # Lco/vine/android/Friendships;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;",
            "Lco/vine/android/Friendships;",
            ")V"
        }
    .end annotation

    .prologue
    .line 235
    .local p2, "users":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineUser;>;"
    if-eqz p1, :cond_1

    .line 236
    invoke-virtual {p0, p2, p3}, Lco/vine/android/FindFriendsNUXActivity;->addUsersToFollow(Ljava/util/ArrayList;Lco/vine/android/Friendships;)V

    .line 243
    :cond_0
    return-void

    .line 238
    :cond_1
    invoke-virtual {p2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineUser;

    .line 239
    .local v1, "user":Lco/vine/android/api/VineUser;
    iget-object v2, p0, Lco/vine/android/FindFriendsNUXActivity;->mUserIdsToFollow:Ljava/util/HashSet;

    iget-wide v3, v1, Lco/vine/android/api/VineUser;->userId:J

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/HashSet;->remove(Ljava/lang/Object;)Z

    .line 240
    iget-wide v2, v1, Lco/vine/android/api/VineUser;->userId:J

    invoke-virtual {p3, v2, v3}, Lco/vine/android/Friendships;->removeFollowing(J)V

    goto :goto_0
.end method
