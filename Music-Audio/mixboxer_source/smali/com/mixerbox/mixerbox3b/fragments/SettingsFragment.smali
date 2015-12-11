.class public Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;
.super Landroid/support/v4/app/Fragment;
.source "SourceFile"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "SetJavaScriptEnabled"
    }
.end annotation


# instance fields
.field btnLogout:Landroid/widget/Button;

.field public btnSleep:Landroid/widget/Button;

.field cbBackground:Landroid/widget/CheckBox;

.field public cbHD:Landroid/widget/CheckBox;

.field public checkbox:Landroid/widget/CheckBox;

.field public shouldOpenConfirmDialog:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 61
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->shouldOpenConfirmDialog:Z

    return-void
.end method


# virtual methods
.method public loadContent()V
    .locals 2

    .prologue
    .line 72
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 80
    :goto_0
    return-void

    .line 75
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->cbHD:Landroid/widget/CheckBox;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getHighQuality(Landroid/content/Context;)Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 76
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->shouldOpenConfirmDialog:Z

    .line 77
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->checkbox:Landroid/widget/CheckBox;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getPostFB(Landroid/content/Context;)Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 78
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->shouldOpenConfirmDialog:Z

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 67
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 69
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 11

    .prologue
    .line 84
    const v0, 0x7f030034

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    .line 86
    const v0, 0x7f07008f

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 87
    const v1, 0x7f070091

    invoke-virtual {v6, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    .line 88
    const v2, 0x7f07009d

    invoke-virtual {v6, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->btnLogout:Landroid/widget/Button;

    .line 89
    const v2, 0x7f070097

    invoke-virtual {v6, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 90
    const v3, 0x7f070092

    invoke-virtual {v6, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/CheckBox;

    iput-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->checkbox:Landroid/widget/CheckBox;

    .line 91
    const v3, 0x7f070098

    invoke-virtual {v6, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 92
    const v4, 0x7f070095

    invoke-virtual {v6, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->btnSleep:Landroid/widget/Button;

    .line 93
    const v4, 0x7f070094

    invoke-virtual {v6, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/CheckBox;

    iput-object v4, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->cbHD:Landroid/widget/CheckBox;

    .line 94
    const v4, 0x7f070096

    invoke-virtual {v6, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    .line 96
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getHasShownFAQ(Landroid/content/Context;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 97
    new-instance v5, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v7

    invoke-direct {v5, v7}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 98
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f0800ef

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 99
    new-instance v7, Landroid/webkit/WebView;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v8

    invoke-direct {v7, v8}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 100
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "file:///android_asset/"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v9

    invoke-virtual {v9}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v10, 0x7f080107

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ".html"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 101
    new-instance v8, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$1;

    invoke-direct {v8, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v7, v8}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 120
    invoke-virtual {v5, v7}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 121
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f08007e

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    new-instance v8, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$2;

    invoke-direct {v8, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$2;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v5, v7, v8}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 126
    invoke-virtual {v5}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 127
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putHasShownFAQ(Landroid/content/Context;)V

    .line 131
    :cond_0
    :try_start_0
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getLastAd(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    .line 132
    const-string v7, ""

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 133
    const/16 v5, 0x8

    invoke-virtual {v2, v5}, Landroid/widget/Button;->setVisibility(I)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 191
    :goto_0
    const v2, 0x7f070099

    invoke-virtual {v6, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 192
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v5

    invoke-static {v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getFAQUrl(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    .line 193
    const-string v7, ""

    invoke-virtual {v5, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 194
    const/16 v5, 0x8

    invoke-virtual {v2, v5}, Landroid/widget/Button;->setVisibility(I)V

    .line 240
    :goto_1
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v2, v2, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v2, :cond_3

    .line 241
    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 242
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 250
    :goto_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->btnLogout:Landroid/widget/Button;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$5;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$5;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 269
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->checkbox:Landroid/widget/CheckBox;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 292
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->btnSleep:Landroid/widget/Button;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v5, 0x7f0800f0

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v5, 0x7f08007c

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 293
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->btnSleep:Landroid/widget/Button;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$7;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$7;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 317
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->cbHD:Landroid/widget/CheckBox;

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$8;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$8;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 339
    const v0, 0x7f07009a

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 340
    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$9;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$9;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 362
    const v0, 0x7f070090

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 363
    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$10;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 384
    const v0, 0x7f07009b

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 385
    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$11;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$11;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 406
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$12;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$12;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v4, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 442
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$13;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$13;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v3, v0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 455
    const v0, 0x7f07009c

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 456
    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$14;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 496
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->loadContent()V

    .line 498
    return-object v6

    .line 136
    :cond_1
    :try_start_1
    new-instance v7, Lorg/json/JSONObject;

    invoke-direct {v7, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 137
    const-string v5, "msg"

    invoke-virtual {v7, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 138
    new-instance v5, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;

    invoke-direct {v5, p0, v7}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$3;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;Lorg/json/JSONObject;)V

    invoke-virtual {v2, v5}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0

    .line 186
    :catch_0
    move-exception v5

    .line 187
    invoke-virtual {v5}, Lorg/json/JSONException;->printStackTrace()V

    .line 188
    const/16 v5, 0x8

    invoke-virtual {v2, v5}, Landroid/widget/Button;->setVisibility(I)V

    goto/16 :goto_0

    .line 197
    :cond_2
    new-instance v7, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;

    invoke-direct {v7, p0, v5}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$4;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;Ljava/lang/String;)V

    invoke-virtual {v2, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_1

    .line 245
    :cond_3
    const/16 v0, 0x8

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 246
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->btnLogout:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 247
    const/16 v0, 0x8

    invoke-virtual {v3, v0}, Landroid/widget/Button;->setVisibility(I)V

    goto/16 :goto_2
.end method

.method updateSysinfo()V
    .locals 4

    .prologue
    .line 504
    :try_start_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->MIXERBOX_URL_PARAMETER:Ljava/lang/String;

    const-string v1, "&appVer="

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 505
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getPackageName()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    .line 507
    iget v0, v0, Landroid/content/pm/PackageInfo;->versionCode:I

    .line 508
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->MIXERBOX_URL_PARAMETER:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&appVer="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->MIXERBOX_URL_PARAMETER:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 512
    :cond_0
    :goto_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 514
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putLocale(Landroid/content/Context;Ljava/lang/String;)V

    .line 515
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getFirstLaunchTime(Landroid/content/Context;)J

    move-result-wide v1

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSysInfoUrl(Ljava/lang/Long;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 516
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;-><init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 566
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method
