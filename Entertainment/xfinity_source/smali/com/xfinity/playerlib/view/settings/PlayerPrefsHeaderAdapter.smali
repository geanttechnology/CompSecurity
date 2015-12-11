.class public Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;
.super Landroid/widget/ArrayAdapter;
.source "PlayerPrefsHeaderAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Landroid/preference/PreferenceActivity$Header;",
        ">;"
    }
.end annotation


# instance fields
.field private androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private inflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Landroid/preference/PreferenceActivity$Header;",
            ">;",
            "Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;",
            ")V"
        }
    .end annotation

    .prologue
    .line 37
    .local p2, "objects":Ljava/util/List;, "Ljava/util/List<Landroid/preference/PreferenceActivity$Header;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0, p2}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 38
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 39
    iput-object p3, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 40
    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;)Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    return-object v0
.end method

.method private refreshView(Landroid/view/View;J)Z
    .locals 4
    .param p1, "convertView"    # Landroid/view/View;
    .param p2, "headerId"    # J

    .prologue
    const/4 v0, 0x1

    .line 150
    sget v1, Lcom/xfinity/playerlib/R$id;->settings_about:I

    int-to-long v2, v1

    cmp-long v1, p2, v2

    if-nez v1, :cond_1

    sget v1, Lcom/xfinity/playerlib/R$id;->about_header_layout:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    if-nez v1, :cond_1

    .line 156
    :cond_0
    :goto_0
    return v0

    .line 152
    :cond_1
    sget v1, Lcom/xfinity/playerlib/R$id;->settings_about:I

    int-to-long v2, v1

    cmp-long v1, p2, v2

    if-eqz v1, :cond_2

    sget v1, Lcom/xfinity/playerlib/R$id;->header_layout:I

    invoke-virtual {p1, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 156
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 18
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 44
    invoke-virtual/range {p0 .. p1}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Landroid/preference/PreferenceActivity$Header;

    .line 47
    .local v5, "header":Landroid/preference/PreferenceActivity$Header;
    if-eqz p2, :cond_0

    iget-wide v14, v5, Landroid/preference/PreferenceActivity$Header;->id:J

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1, v14, v15}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->refreshView(Landroid/view/View;J)Z

    move-result v14

    if-eqz v14, :cond_2

    .line 48
    :cond_0
    new-instance v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;

    const/4 v14, 0x0

    invoke-direct {v6, v14}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;-><init>(Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;)V

    .line 49
    .local v6, "holder":Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;
    iget-wide v14, v5, Landroid/preference/PreferenceActivity$Header;->id:J

    sget v16, Lcom/xfinity/playerlib/R$id;->settings_about:I

    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v16, v0

    cmp-long v14, v14, v16

    if-nez v14, :cond_1

    .line 50
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->inflater:Landroid/view/LayoutInflater;

    sget v15, Lcom/xfinity/playerlib/R$layout;->about_preference:I

    const/16 v16, 0x0

    move-object/from16 v0, p3

    move/from16 v1, v16

    invoke-virtual {v14, v15, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v13

    .line 55
    .local v13, "view":Landroid/view/View;
    :goto_0
    iput-object v13, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->layout:Landroid/view/View;

    .line 56
    const v14, 0x1020016

    invoke-virtual {v13, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->title:Landroid/widget/TextView;

    .line 57
    const v14, 0x1020010

    invoke-virtual {v13, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->summary:Landroid/widget/TextView;

    .line 58
    invoke-virtual {v13, v6}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 64
    :goto_1
    iget-wide v14, v5, Landroid/preference/PreferenceActivity$Header;->id:J

    sget v16, Lcom/xfinity/playerlib/R$id;->settings_about:I

    move/from16 v0, v16

    int-to-long v0, v0

    move-wide/from16 v16, v0

    cmp-long v14, v14, v16

    if-nez v14, :cond_3

    .line 65
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    invoke-virtual {v14}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v14

    invoke-virtual {v14}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v9

    .line 66
    .local v9, "packageName":Ljava/lang/String;
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    sget v15, Lcom/xfinity/playerlib/R$string;->settings_app_version:I

    invoke-virtual {v14, v15}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-direct {v12, v14}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 68
    .local v12, "versionStringBuilder":Ljava/lang/StringBuilder;
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    invoke-virtual {v14}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v14

    const/4 v15, 0x0

    invoke-virtual {v14, v9, v15}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v14

    iget-object v14, v14, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 69
    const-string v14, " "

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 70
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v14

    invoke-virtual {v14}, Lcom/comcast/cim/container/PlayerContainer;->getConfigurationVersion()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 75
    :goto_2
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 76
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->layout:Landroid/view/View;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/view/View;->setEnabled(Z)V

    .line 77
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->layout:Landroid/view/View;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/view/View;->setClickable(Z)V

    .line 78
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->layout:Landroid/view/View;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 80
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 81
    .local v2, "builder":Landroid/text/SpannableStringBuilder;
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    sget v15, Lcom/xfinity/playerlib/R$string;->made_with_prefix:I

    invoke-virtual {v14, v15}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v14

    invoke-virtual {v2, v14}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 82
    invoke-virtual {v2}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v7

    .line 83
    .local v7, "lengthOfPart1":I
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    sget v15, Lcom/xfinity/playerlib/R$string;->in_philly_postfix:I

    invoke-virtual {v14, v15}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v14

    invoke-virtual {v2, v14}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 84
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    invoke-virtual {v14}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    sget v15, Lcom/xfinity/playerlib/R$drawable;->love:I

    invoke-virtual {v14, v15}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v3

    .line 85
    .local v3, "d":Landroid/graphics/drawable/Drawable;
    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v16

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v17

    move/from16 v0, v16

    move/from16 v1, v17

    invoke-virtual {v3, v14, v15, v0, v1}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 86
    new-instance v8, Landroid/text/style/ImageSpan;

    invoke-direct {v8, v3}, Landroid/text/style/ImageSpan;-><init>(Landroid/graphics/drawable/Drawable;)V

    .line 87
    .local v8, "myImage":Landroid/text/style/ImageSpan;
    add-int/lit8 v14, v7, 0x1

    const/16 v15, 0x21

    invoke-virtual {v2, v8, v7, v14, v15}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 88
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->summary:Landroid/widget/TextView;

    invoke-virtual {v14, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 139
    .end local v2    # "builder":Landroid/text/SpannableStringBuilder;
    .end local v3    # "d":Landroid/graphics/drawable/Drawable;
    .end local v7    # "lengthOfPart1":I
    .end local v8    # "myImage":Landroid/text/style/ImageSpan;
    .end local v9    # "packageName":Ljava/lang/String;
    .end local v12    # "versionStringBuilder":Ljava/lang/StringBuilder;
    :goto_3
    return-object v13

    .line 52
    .end local v13    # "view":Landroid/view/View;
    :cond_1
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->inflater:Landroid/view/LayoutInflater;

    sget v15, Lcom/xfinity/playerlib/R$layout;->preference_header_item:I

    const/16 v16, 0x0

    move-object/from16 v0, p3

    move/from16 v1, v16

    invoke-virtual {v14, v15, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v13

    .restart local v13    # "view":Landroid/view/View;
    goto/16 :goto_0

    .line 60
    .end local v6    # "holder":Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;
    .end local v13    # "view":Landroid/view/View;
    :cond_2
    move-object/from16 v13, p2

    .line 61
    .restart local v13    # "view":Landroid/view/View;
    invoke-virtual {v13}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;

    .restart local v6    # "holder":Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;
    goto/16 :goto_1

    .line 71
    .restart local v9    # "packageName":Ljava/lang/String;
    .restart local v12    # "versionStringBuilder":Ljava/lang/StringBuilder;
    :catch_0
    move-exception v4

    .line 72
    .local v4, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    sget v15, Lcom/xfinity/playerlib/R$string;->content_description_not_available:I

    invoke-virtual {v14, v15}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v12, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_2

    .line 90
    .end local v4    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .end local v9    # "packageName":Ljava/lang/String;
    .end local v12    # "versionStringBuilder":Ljava/lang/StringBuilder;
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    invoke-virtual {v14}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    invoke-virtual {v5, v14}, Landroid/preference/PreferenceActivity$Header;->getTitle(Landroid/content/res/Resources;)Ljava/lang/CharSequence;

    move-result-object v11

    check-cast v11, Ljava/lang/String;

    .line 91
    .local v11, "titleText":Ljava/lang/String;
    if-eqz v11, :cond_4

    invoke-virtual {v11}, Ljava/lang/String;->isEmpty()Z

    move-result v14

    if-eqz v14, :cond_6

    .line 92
    :cond_4
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->title:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 98
    :goto_4
    const v14, 0x1020010

    invoke-virtual {v13, v14}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    check-cast v14, Landroid/widget/TextView;

    iput-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->summary:Landroid/widget/TextView;

    .line 99
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;->getContext()Landroid/content/Context;

    move-result-object v14

    invoke-virtual {v14}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    invoke-virtual {v5, v14}, Landroid/preference/PreferenceActivity$Header;->getSummary(Landroid/content/res/Resources;)Ljava/lang/CharSequence;

    move-result-object v10

    check-cast v10, Ljava/lang/String;

    .line 100
    .local v10, "summaryText":Ljava/lang/String;
    if-eqz v10, :cond_5

    invoke-virtual {v10}, Ljava/lang/String;->isEmpty()Z

    move-result v14

    if-eqz v14, :cond_7

    .line 101
    :cond_5
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->summary:Landroid/widget/TextView;

    const/16 v15, 0x8

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 109
    :goto_5
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->layout:Landroid/view/View;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/view/View;->setSoundEffectsEnabled(Z)V

    .line 110
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->layout:Landroid/view/View;

    new-instance v15, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;

    move-object/from16 v0, p0

    move/from16 v1, p1

    invoke-direct {v15, v0, v5, v1}, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$1;-><init>(Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter;Landroid/preference/PreferenceActivity$Header;I)V

    invoke-virtual {v14, v15}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_3

    .line 94
    .end local v10    # "summaryText":Ljava/lang/String;
    :cond_6
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->title:Landroid/widget/TextView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 95
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {v14, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_4

    .line 103
    .restart local v10    # "summaryText":Ljava/lang/String;
    :cond_7
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->summary:Landroid/widget/TextView;

    const/4 v15, 0x0

    invoke-virtual {v14, v15}, Landroid/widget/TextView;->setVisibility(I)V

    .line 104
    iget-object v14, v6, Lcom/xfinity/playerlib/view/settings/PlayerPrefsHeaderAdapter$HeaderViewHolder;->summary:Landroid/widget/TextView;

    invoke-virtual {v14, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_5
.end method
