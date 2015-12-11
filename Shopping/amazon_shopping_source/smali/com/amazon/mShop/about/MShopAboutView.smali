.class public Lcom/amazon/mShop/about/MShopAboutView;
.super Lcom/amazon/mShop/StandardView;
.source "MShopAboutView.java"


# instance fields
.field private mClickTimes:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->more_about_button:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/about/MShopAboutView;-><init>(Landroid/content/Context;Ljava/lang/Integer;)V

    .line 38
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/Integer;)V
    .locals 21
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "titleResourceId"    # Ljava/lang/Integer;

    .prologue
    .line 41
    invoke-direct/range {p0 .. p2}, Lcom/amazon/mShop/StandardView;-><init>(Landroid/content/Context;Ljava/lang/Integer;)V

    .line 34
    const/16 v18, 0x0

    move/from16 v0, v18

    move-object/from16 v1, p0

    iput v0, v1, Lcom/amazon/mShop/about/MShopAboutView;->mClickTimes:I

    .line 43
    sget v18, Lcom/amazon/mShop/android/lib/R$layout;->about:I

    move-object/from16 v0, p1

    move/from16 v1, v18

    move-object/from16 v2, p0

    invoke-static {v0, v1, v2}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v13

    .line 44
    .local v13, "content":Landroid/view/View;
    sget v18, Lcom/amazon/mShop/android/lib/R$id;->about_app_info:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 45
    .local v3, "aboutAppInfoGroup":Landroid/view/View;
    new-instance v18, Lcom/amazon/mShop/about/MShopAboutView$1;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/amazon/mShop/about/MShopAboutView$1;-><init>(Lcom/amazon/mShop/about/MShopAboutView;)V

    move-object/from16 v0, v18

    invoke-virtual {v3, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 73
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/util/BuildUtils;->getVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v17

    .line 74
    .local v17, "versionName":Ljava/lang/String;
    if-nez v17, :cond_0

    .line 75
    sget v18, Lcom/amazon/mShop/android/lib/R$string;->about_missing_placeholder:I

    move-object/from16 v0, p1

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v17

    .line 78
    :cond_0
    sget v18, Lcom/amazon/mShop/android/lib/R$string;->about_version:I

    move-object/from16 v0, p1

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 79
    .local v7, "aboutVersionFormat":Ljava/lang/String;
    const/16 v18, 0x1

    move/from16 v0, v18

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v18, v0

    const/16 v19, 0x0

    aput-object v17, v18, v19

    move-object/from16 v0, v18

    invoke-static {v7, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    .line 81
    .local v8, "aboutVersionString":Ljava/lang/String;
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/util/BuildUtils;->getPartnerName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v16

    .line 82
    .local v16, "partnerName":Ljava/lang/String;
    invoke-static/range {v16 .. v16}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v18

    if-nez v18, :cond_1

    .line 83
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v18

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, " ("

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, ")"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 86
    :cond_1
    sget v18, Lcom/amazon/mShop/android/lib/R$id;->about_version:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 87
    .local v9, "aboutVersionTextView":Landroid/widget/TextView;
    invoke-virtual {v9, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    invoke-static/range {p1 .. p1}, Lcom/amazon/mShop/util/BuildUtils;->getRevisionNumber(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v10

    .line 95
    .local v10, "buildVersionString":Ljava/lang/String;
    if-nez v10, :cond_2

    .line 96
    sget v18, Lcom/amazon/mShop/android/lib/R$string;->about_missing_placeholder:I

    move-object/from16 v0, p1

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v10

    .line 99
    :cond_2
    sget v18, Lcom/amazon/mShop/android/lib/R$string;->about_build:I

    move-object/from16 v0, p1

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 101
    .local v4, "aboutBuildFormat":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Lcom/amazon/mShop/platform/AppLocale;->getDefaultLocale()Ljava/lang/String;

    move-result-object v14

    .line 106
    .local v14, "defaultLocale":Ljava/lang/String;
    sget v18, Lcom/amazon/mShop/android/lib/R$string;->config_marketplace_id:I

    move-object/from16 v0, p1

    move/from16 v1, v18

    invoke-static {v0, v1, v14}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 107
    .local v15, "marketPlaceId":Ljava/lang/String;
    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v19, 0x1

    move/from16 v0, v19

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v19, v0

    const/16 v20, 0x0

    aput-object v10, v19, v20

    move-object/from16 v0, v19

    invoke-static {v4, v0}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v19

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string/jumbo v19, "-"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    invoke-virtual {v0, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 109
    .local v5, "aboutBuildString":Ljava/lang/String;
    sget v18, Lcom/amazon/mShop/android/lib/R$id;->about_build:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 110
    .local v6, "aboutBuildTextView":Landroid/widget/TextView;
    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 112
    move-object/from16 v11, p1

    .line 114
    .local v11, "c":Landroid/content/Context;
    sget v18, Lcom/amazon/mShop/android/lib/R$id;->check_upgrade_button:I

    move/from16 v0, v18

    invoke-virtual {v13, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/widget/Button;

    .line 115
    .local v12, "checkForUpgradeButton":Landroid/widget/Button;
    new-instance v18, Lcom/amazon/mShop/about/MShopAboutView$2;

    move-object/from16 v0, v18

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v11}, Lcom/amazon/mShop/about/MShopAboutView$2;-><init>(Lcom/amazon/mShop/about/MShopAboutView;Landroid/content/Context;)V

    move-object/from16 v0, v18

    invoke-virtual {v12, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 173
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/about/MShopAboutView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/about/MShopAboutView;

    .prologue
    .line 32
    iget v0, p0, Lcom/amazon/mShop/about/MShopAboutView;->mClickTimes:I

    return v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/about/MShopAboutView;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/about/MShopAboutView;
    .param p1, "x1"    # I

    .prologue
    .line 32
    iput p1, p0, Lcom/amazon/mShop/about/MShopAboutView;->mClickTimes:I

    return p1
.end method

.method static synthetic access$008(Lcom/amazon/mShop/about/MShopAboutView;)I
    .locals 2
    .param p0, "x0"    # Lcom/amazon/mShop/about/MShopAboutView;

    .prologue
    .line 32
    iget v0, p0, Lcom/amazon/mShop/about/MShopAboutView;->mClickTimes:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/amazon/mShop/about/MShopAboutView;->mClickTimes:I

    return v0
.end method


# virtual methods
.method public showNoUpgradeDialog()V
    .locals 2

    .prologue
    .line 176
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-virtual {p0}, Lcom/amazon/mShop/about/MShopAboutView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 177
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->no_available_upgrade:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 178
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 179
    return-void
.end method
