.class public Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Landroid/widget/LinearLayout;

.field private c:Landroid/content/SharedPreferences;

.field private g:I


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 57
    const/4 v0, -0x1

    iput v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->g:I

    .line 60
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;)I
    .locals 1

    .prologue
    .line 52
    iget v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->g:I

    return v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;I)I
    .locals 0

    .prologue
    .line 52
    iput p1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->g:I

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;)Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->c:Landroid/content/SharedPreferences;

    return-object v0
.end method


# virtual methods
.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 64
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 65
    iput-object p1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    .line 66
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 12

    .prologue
    .line 70
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->c:Landroid/content/SharedPreferences;

    .line 71
    const v0, 0x7f030009

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 74
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "envsettings.json"

    invoke-virtual {v0, v1}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v0

    .line 75
    invoke-static {v0}, Lni;->a(Ljava/io/InputStream;)Ljava/lang/String;

    move-result-object v0

    .line 76
    new-instance v1, Lms;

    invoke-direct {v1, v0}, Lms;-><init>(Ljava/lang/String;)V

    .line 78
    invoke-virtual {v1}, Lms;->a()Ljava/util/ArrayList;

    move-result-object v1

    .line 79
    const v0, 0x7f0c004e

    invoke-virtual {v4, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->b:Landroid/widget/LinearLayout;

    .line 81
    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v0, -0x1

    const/4 v2, -0x2

    invoke-direct {v5, v0, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 82
    const/4 v0, 0x0

    const/16 v2, 0xa

    const/4 v3, 0x0

    const/16 v6, 0xa

    invoke-virtual {v5, v0, v2, v3, v6}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 84
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lmt;

    .line 85
    const v1, 0x7f030029

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    .line 86
    const/16 v1, 0x8

    invoke-virtual {v7, v1}, Landroid/view/View;->setVisibility(I)V

    .line 87
    const v1, 0x7f0c00af

    invoke-virtual {v7, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;

    invoke-direct {v2, p0, v7}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$1;-><init>(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;Landroid/view/View;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    new-instance v8, Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    invoke-direct {v8, v1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 125
    const/4 v1, 0x1

    invoke-virtual {v8, v1}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 126
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0063

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v8, v1}, Landroid/widget/LinearLayout;->setBackgroundColor(I)V

    .line 127
    const/16 v1, 0x8

    const/16 v2, 0x8

    const/16 v3, 0x8

    const/16 v9, 0x8

    invoke-virtual {v8, v1, v2, v3, v9}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 128
    invoke-virtual {v8, v5}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 129
    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    invoke-direct {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;-><init>(Landroid/content/Context;)V

    .line 130
    invoke-virtual {v0}, Lmt;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 131
    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v9, 0x7f080024

    invoke-virtual {v3, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v9, 0x0

    invoke-virtual {v1, v2, v3, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    .line 132
    iget-object v2, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    const-string v3, "AvenirNextforBestBuy-Regular"

    const/4 v9, 0x0

    invoke-virtual {v1, v2, v3, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    .line 133
    invoke-virtual {v8, v1}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 135
    invoke-virtual {v0}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    new-array v9, v1, [Landroid/widget/RadioButton;

    .line 136
    new-instance v10, Landroid/widget/RadioGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    invoke-direct {v10, v1}, Landroid/widget/RadioGroup;-><init>(Landroid/content/Context;)V

    .line 137
    const/4 v1, 0x1

    invoke-virtual {v10, v1}, Landroid/widget/RadioGroup;->setOrientation(I)V

    .line 138
    const/4 v1, 0x0

    move v2, v1

    :goto_1
    array-length v1, v9

    if-ge v2, v1, :cond_0

    .line 139
    new-instance v1, Landroid/widget/RadioButton;

    iget-object v3, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->a:Landroid/app/Activity;

    invoke-direct {v1, v3}, Landroid/widget/RadioButton;-><init>(Landroid/content/Context;)V

    aput-object v1, v9, v2

    .line 140
    aget-object v3, v9, v2

    invoke-virtual {v0}, Lmt;->b()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v3, v1}, Landroid/widget/RadioButton;->setText(Ljava/lang/CharSequence;)V

    .line 142
    aget-object v1, v9, v2

    new-instance v3, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;

    invoke-direct {v3, p0, v0, v2, v7}, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment$2;-><init>(Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;Lmt;ILandroid/view/View;)V

    invoke-virtual {v1, v3}, Landroid/widget/RadioButton;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 225
    aget-object v1, v9, v2

    invoke-virtual {v10, v1}, Landroid/widget/RadioGroup;->addView(Landroid/view/View;)V

    .line 138
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_1

    .line 227
    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->c:Landroid/content/SharedPreferences;

    invoke-virtual {v0}, Lmt;->a()Ljava/lang/String;

    move-result-object v2

    const/4 v3, -0x1

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v3

    .line 229
    const/4 v1, -0x1

    if-ne v3, v1, :cond_3

    .line 230
    const/4 v2, 0x0

    :goto_2
    invoke-virtual {v0}, Lmt;->c()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v2, v1, :cond_3

    .line 231
    invoke-virtual {v0}, Lmt;->c()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {v0}, Lmt;->d()I

    move-result v11

    if-ne v1, v11, :cond_2

    move v0, v2

    .line 237
    :goto_3
    aget-object v0, v9, v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/RadioButton;->setChecked(Z)V

    .line 238
    invoke-virtual {v8, v10}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 239
    invoke-virtual {v8, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/activities/appsettings/AppSettingsEnvironmentFragment;->b:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 242
    :catch_0
    move-exception v0

    .line 243
    const-string v1, "AppSettingsEnvironmentFragment"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not create AppSettingsEnvironmentFragment: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 245
    :cond_1
    return-object v4

    .line 230
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    :cond_3
    move v0, v3

    goto :goto_3
.end method
