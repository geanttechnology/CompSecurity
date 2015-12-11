.class public Lco/vine/android/SearchActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "SearchActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/TextView$OnEditorActionListener;
.implements Landroid/text/TextWatcher;


# static fields
.field public static final TAB_TAGS:Ljava/lang/String; = "tags"

.field public static final TAB_USERS:Ljava/lang/String; = "users"


# instance fields
.field private mClear:Landroid/widget/ImageButton;

.field private mCurrentFragment:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/BaseSearchFragment;",
            ">;"
        }
    .end annotation
.end field

.field private mQuery:Landroid/widget/EditText;

.field private mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method private performSearch()V
    .locals 2

    .prologue
    .line 188
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->clearFocus()V

    .line 189
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 190
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 191
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/BaseSearchFragment;

    iget-object v1, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lco/vine/android/BaseSearchFragment;->setQueryText(Ljava/lang/String;)V

    .line 192
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/BaseSearchFragment;

    invoke-virtual {v0}, Lco/vine/android/BaseSearchFragment;->performSearch()V

    .line 194
    :cond_0
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "editable"    # Landroid/text/Editable;

    .prologue
    .line 136
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 132
    return-void
.end method

.method public clearQueryText()V
    .locals 2

    .prologue
    .line 207
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 208
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->requestFocus()Z

    .line 209
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 210
    return-void
.end method

.method public getQueryText()Ljava/lang/String;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected modernShowDivider()V
    .locals 3
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 106
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xb

    if-lt v1, v2, :cond_0

    .line 107
    iget-object v1, p0, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    invoke-virtual {v1}, Lco/vine/android/widget/tabs/FragmentTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v0

    .line 108
    .local v0, "tabWidget":Landroid/widget/TabWidget;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TabWidget;->setShowDividers(I)V

    .line 110
    .end local v0    # "tabWidget":Landroid/widget/TabWidget;
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 140
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 163
    :cond_0
    :goto_0
    return-void

    .line 142
    :sswitch_0
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    goto :goto_0

    .line 146
    :sswitch_1
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mClear:Landroid/widget/ImageButton;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 147
    invoke-virtual {p0}, Lco/vine/android/SearchActivity;->clearQueryText()V

    .line 148
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 149
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/BaseSearchFragment;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lco/vine/android/BaseSearchFragment;->setQueryText(Ljava/lang/String;)V

    .line 150
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/BaseSearchFragment;

    invoke-virtual {v0}, Lco/vine/android/BaseSearchFragment;->cleanSearchResults()V

    goto :goto_0

    .line 156
    :sswitch_2
    invoke-direct {p0}, Lco/vine/android/SearchActivity;->performSearch()V

    goto :goto_0

    .line 140
    :sswitch_data_0
    .sparse-switch
        0x7f0a01a9 -> :sswitch_0
        0x7f0a01e9 -> :sswitch_1
        0x7f0a01ec -> :sswitch_2
        0x7f0a01ee -> :sswitch_2
    .end sparse-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 21
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 44
    const v17, 0x7f03008b

    const/16 v18, 0x1

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v17

    move/from16 v3, v18

    invoke-super {v0, v1, v2, v3}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 46
    const/16 v17, 0x1

    invoke-static/range {v17 .. v17}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v17

    const/16 v18, 0x1

    invoke-static/range {v18 .. v18}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v18

    const/16 v19, 0x0

    const/16 v20, 0x1

    invoke-static/range {v20 .. v20}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v20

    move-object/from16 v0, p0

    move-object/from16 v1, v17

    move-object/from16 v2, v18

    move-object/from16 v3, v19

    move-object/from16 v4, v20

    invoke-virtual {v0, v1, v2, v3, v4}, Lco/vine/android/SearchActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 48
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SearchActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v5

    .line 49
    .local v5, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v5, :cond_0

    .line 50
    const/16 v17, 0x1

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/support/v7/app/ActionBar;->setDisplayShowCustomEnabled(Z)V

    .line 51
    const v17, 0x7f03008a

    move/from16 v0, v17

    invoke-virtual {v5, v0}, Landroid/support/v7/app/ActionBar;->setCustomView(I)V

    .line 54
    :cond_0
    invoke-virtual {v5}, Landroid/support/v7/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v17

    const v18, 0x7f0a01a9

    invoke-virtual/range {v17 .. v18}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/EditText;

    .line 56
    .local v9, "query":Landroid/widget/EditText;
    const v17, 0x3f8ccccd    # 1.1f

    const/high16 v18, 0x41400000    # 12.0f

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Landroid/widget/TextView;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v9, v19, v20

    move-object/from16 v0, p0

    move/from16 v1, v17

    move/from16 v2, v18

    move-object/from16 v3, v19

    invoke-static {v0, v1, v2, v3}, Lco/vine/android/util/ViewUtil;->reduceTextSizeViaFontScaleIfNeeded(Landroid/content/Context;FF[Landroid/widget/TextView;)V

    .line 58
    move-object/from16 v0, p0

    invoke-virtual {v9, v0}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 59
    move-object/from16 v0, p0

    invoke-virtual {v9, v0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 60
    const/high16 v17, 0x80000

    move/from16 v0, v17

    invoke-virtual {v9, v0}, Landroid/widget/EditText;->setInputType(I)V

    .line 61
    invoke-virtual {v9}, Landroid/widget/EditText;->requestFocus()Z

    .line 62
    move-object/from16 v0, p0

    iput-object v9, v0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    .line 64
    const v17, 0x7f0a01e9

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/SearchActivity;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ImageButton;

    .line 65
    .local v6, "clear":Landroid/widget/ImageButton;
    move-object/from16 v0, p0

    invoke-virtual {v6, v0}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 66
    move-object/from16 v0, p0

    iput-object v6, v0, Lco/vine/android/SearchActivity;->mClear:Landroid/widget/ImageButton;

    .line 68
    if-nez p1, :cond_1

    .line 69
    const v17, 0x7f0a01ea

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/SearchActivity;->findViewById(I)Landroid/view/View;

    move-result-object v17

    check-cast v17, Lco/vine/android/widget/tabs/FragmentTabHost;

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    .line 70
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    move-object/from16 v17, v0

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SearchActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v18

    const v19, 0x7f0a01eb

    move-object/from16 v0, v17

    move-object/from16 v1, p0

    move-object/from16 v2, v18

    move/from16 v3, v19

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/widget/tabs/FragmentTabHost;->setup(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;I)V

    .line 72
    invoke-static/range {p0 .. p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v8

    .line 73
    .local v8, "li":Landroid/view/LayoutInflater;
    new-instance v14, Landroid/os/Bundle;

    invoke-direct {v14}, Landroid/os/Bundle;-><init>()V

    .line 74
    .local v14, "usersArgs":Landroid/os/Bundle;
    const-string v17, "empty_desc"

    const v18, 0x7f0e0154

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v14, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 75
    const-string v17, "refresh"

    const/16 v18, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v14, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 76
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    move-object/from16 v17, v0

    const-string v18, "users"

    invoke-virtual/range {v17 .. v18}, Lco/vine/android/widget/tabs/FragmentTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v16

    .line 77
    .local v16, "usersSpec":Landroid/widget/TabHost$TabSpec;
    const v17, 0x7f03008d

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lco/vine/android/widget/tabs/FragmentTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v18

    const/16 v19, 0x0

    move/from16 v0, v17

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v8, v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v15

    .line 79
    .local v15, "usersIndicator":Landroid/view/View;
    const v17, 0x7f0a01f0

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    check-cast v13, Landroid/widget/TextView;

    .line 80
    .local v13, "title":Landroid/widget/TextView;
    const v17, 0x7f0e0173

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/SearchActivity;->getString(I)Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 81
    const v17, 0x7f0a01ef

    move/from16 v0, v17

    invoke-virtual {v15, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageView;

    .line 82
    .local v7, "icon":Landroid/widget/ImageView;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SearchActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    const v18, 0x7f020267

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v7, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 83
    move-object/from16 v0, v16

    invoke-virtual {v0, v15}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    .line 84
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    move-object/from16 v17, v0

    const-class v18, Lco/vine/android/UserSearchFragment;

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    move-object/from16 v2, v18

    invoke-virtual {v0, v1, v2, v14}, Lco/vine/android/widget/tabs/FragmentTabHost;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 86
    new-instance v10, Landroid/os/Bundle;

    invoke-direct {v10}, Landroid/os/Bundle;-><init>()V

    .line 87
    .local v10, "tagsArgs":Landroid/os/Bundle;
    const-string v17, "empty_desc"

    const v18, 0x7f0e0155

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v10, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 88
    const-string v17, "refresh"

    const/16 v18, 0x0

    move-object/from16 v0, v17

    move/from16 v1, v18

    invoke-virtual {v10, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 89
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    move-object/from16 v17, v0

    const-string v18, "tags"

    invoke-virtual/range {v17 .. v18}, Lco/vine/android/widget/tabs/FragmentTabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v12

    .line 90
    .local v12, "tagsSpec":Landroid/widget/TabHost$TabSpec;
    const v17, 0x7f03008d

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    move-object/from16 v18, v0

    invoke-virtual/range {v18 .. v18}, Lco/vine/android/widget/tabs/FragmentTabHost;->getTabWidget()Landroid/widget/TabWidget;

    move-result-object v18

    const/16 v19, 0x0

    move/from16 v0, v17

    move-object/from16 v1, v18

    move/from16 v2, v19

    invoke-virtual {v8, v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v11

    .line 92
    .local v11, "tagsIndicator":Landroid/view/View;
    const v17, 0x7f0a01f0

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v13

    .end local v13    # "title":Landroid/widget/TextView;
    check-cast v13, Landroid/widget/TextView;

    .line 93
    .restart local v13    # "title":Landroid/widget/TextView;
    const v17, 0x7f0e0241

    move-object/from16 v0, p0

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lco/vine/android/SearchActivity;->getString(I)Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v13, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    const v17, 0x7f0a01ef

    move/from16 v0, v17

    invoke-virtual {v11, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .end local v7    # "icon":Landroid/widget/ImageView;
    check-cast v7, Landroid/widget/ImageView;

    .line 95
    .restart local v7    # "icon":Landroid/widget/ImageView;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SearchActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v17

    const v18, 0x7f02026d

    invoke-virtual/range {v17 .. v18}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v17

    move-object/from16 v0, v17

    invoke-virtual {v7, v0}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 96
    invoke-virtual {v12, v11}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    .line 97
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    move-object/from16 v17, v0

    const-class v18, Lco/vine/android/TagSearchFragment;

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    invoke-virtual {v0, v12, v1, v10}, Lco/vine/android/widget/tabs/FragmentTabHost;->addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 100
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/SearchActivity;->modernShowDivider()V

    .line 102
    .end local v7    # "icon":Landroid/widget/ImageView;
    .end local v8    # "li":Landroid/view/LayoutInflater;
    .end local v10    # "tagsArgs":Landroid/os/Bundle;
    .end local v11    # "tagsIndicator":Landroid/view/View;
    .end local v12    # "tagsSpec":Landroid/widget/TabHost$TabSpec;
    .end local v13    # "title":Landroid/widget/TextView;
    .end local v14    # "usersArgs":Landroid/os/Bundle;
    .end local v15    # "usersIndicator":Landroid/view/View;
    .end local v16    # "usersSpec":Landroid/widget/TabHost$TabSpec;
    :cond_1
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 214
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onDestroy()V

    .line 215
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/SearchActivity;->mTabHost:Lco/vine/android/widget/tabs/FragmentTabHost;

    .line 216
    return-void
.end method

.method public onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "v"    # Landroid/widget/TextView;
    .param p2, "actionId"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 167
    invoke-virtual {p1}, Landroid/widget/TextView;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 184
    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1

    .line 169
    :pswitch_0
    const/4 v0, 0x2

    .line 170
    .local v0, "minimumQueryLength":I
    iget-object v1, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 171
    iget-object v1, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/BaseSearchFragment;

    invoke-virtual {v1}, Lco/vine/android/BaseSearchFragment;->getMinimumSearchQueryLength()I

    move-result v0

    .line 173
    :cond_1
    const/4 v1, 0x3

    if-ne p2, v1, :cond_0

    iget-object v1, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v1

    if-lt v1, v0, :cond_0

    .line 175
    invoke-direct {p0}, Lco/vine/android/SearchActivity;->performSearch()V

    .line 176
    const/4 v1, 0x1

    goto :goto_0

    .line 167
    :pswitch_data_0
    .packed-switch 0x7f0a01a9
        :pswitch_0
    .end packed-switch
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 4
    .param p1, "charSequence"    # Ljava/lang/CharSequence;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 114
    const v1, 0x7f0a01e9

    invoke-virtual {p0, v1}, Lco/vine/android/SearchActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 115
    .local v0, "cancel":Landroid/widget/ImageButton;
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v1

    if-lez v1, :cond_1

    .line 116
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 121
    :goto_0
    iget-object v1, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 122
    invoke-interface {p1}, Ljava/lang/CharSequence;->length()I

    move-result v2

    iget-object v1, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/BaseSearchFragment;

    invoke-virtual {v1}, Lco/vine/android/BaseSearchFragment;->getMinimumSearchQueryLength()I

    move-result v1

    if-lt v2, v1, :cond_2

    .line 123
    iget-object v1, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/BaseSearchFragment;

    invoke-virtual {p0}, Lco/vine/android/SearchActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lco/vine/android/BaseSearchFragment;->showSearchHint(Landroid/content/res/Resources;Ljava/lang/String;)V

    .line 128
    :cond_0
    :goto_1
    return-void

    .line 118
    :cond_1
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0

    .line 125
    :cond_2
    iget-object v1, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/BaseSearchFragment;

    invoke-virtual {v1}, Lco/vine/android/BaseSearchFragment;->hideSearchHint()V

    goto :goto_1
.end method

.method public restoreQueryText(Ljava/lang/String;)V
    .locals 2
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 197
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 198
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->clearFocus()V

    .line 199
    iget-object v0, p0, Lco/vine/android/SearchActivity;->mQuery:Landroid/widget/EditText;

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lco/vine/android/util/Util;->setSoftKeyboardVisibility(Landroid/content/Context;Landroid/view/View;Z)V

    .line 200
    return-void
.end method

.method public setCurrentTab(Lco/vine/android/BaseSearchFragment;)V
    .locals 1
    .param p1, "fragment"    # Lco/vine/android/BaseSearchFragment;

    .prologue
    .line 219
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lco/vine/android/SearchActivity;->mCurrentFragment:Ljava/lang/ref/WeakReference;

    .line 220
    return-void
.end method
