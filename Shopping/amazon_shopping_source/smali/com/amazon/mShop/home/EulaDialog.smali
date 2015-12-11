.class public Lcom/amazon/mShop/home/EulaDialog;
.super Lcom/amazon/mShop/AmazonAlertDialog;
.source "EulaDialog.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field private final mEulaScroller:Landroid/widget/ScrollView;

.field private final mMShopActivity:Lcom/amazon/mShop/AmazonActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 17
    .param p1, "mShopActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 70
    invoke-direct/range {p0 .. p1}, Lcom/amazon/mShop/AmazonAlertDialog;-><init>(Landroid/content/Context;)V

    .line 71
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/amazon/mShop/home/EulaDialog;->mMShopActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 75
    const/4 v12, 0x0

    .line 77
    .local v12, "in":Ljava/io/BufferedReader;
    :try_start_0
    invoke-virtual/range {p1 .. p1}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$raw;->eula:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->openRawResource(I)Ljava/io/InputStream;

    move-result-object v14

    .line 78
    .local v14, "is":Ljava/io/InputStream;
    new-instance v13, Ljava/io/BufferedReader;

    new-instance v2, Ljava/io/InputStreamReader;

    invoke-direct {v2, v14}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v13, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 80
    .end local v12    # "in":Ljava/io/BufferedReader;
    .local v13, "in":Ljava/io/BufferedReader;
    :try_start_1
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    .line 81
    .local v8, "buffer":Ljava/lang/StringBuilder;
    :goto_0
    invoke-virtual {v13}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v16

    .local v16, "line":Ljava/lang/String;
    if-eqz v16, :cond_1

    .line 82
    move-object/from16 v0, v16

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const/16 v3, 0xa

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    goto :goto_0

    .line 85
    .end local v8    # "buffer":Ljava/lang/StringBuilder;
    .end local v16    # "line":Ljava/lang/String;
    :catch_0
    move-exception v9

    move-object v12, v13

    .line 86
    .end local v13    # "in":Ljava/io/BufferedReader;
    .end local v14    # "is":Ljava/io/InputStream;
    .local v9, "e":Ljava/io/IOException;
    .restart local v12    # "in":Ljava/io/BufferedReader;
    :goto_1
    :try_start_2
    invoke-virtual {v9}, Ljava/io/IOException;->printStackTrace()V

    .line 87
    const-string/jumbo v10, ""
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 89
    .local v10, "eula":Ljava/lang/CharSequence;
    if-eqz v12, :cond_0

    .line 91
    :try_start_3
    invoke-virtual {v12}, Ljava/io/BufferedReader;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_2

    .line 98
    .end local v9    # "e":Ljava/io/IOException;
    :cond_0
    :goto_2
    invoke-static/range {p1 .. p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v15

    .line 99
    .local v15, "layoutInflater":Landroid/view/LayoutInflater;
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->eula:I

    const/4 v3, 0x0

    invoke-virtual {v15, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ScrollView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/amazon/mShop/home/EulaDialog;->mEulaScroller:Landroid/widget/ScrollView;

    .line 100
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/home/EulaDialog;->mEulaScroller:Landroid/widget/ScrollView;

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->eula_text:I

    invoke-virtual {v2, v3}, Landroid/widget/ScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/TextView;

    .line 101
    .local v11, "eulaTextView":Landroid/widget/TextView;
    invoke-virtual {v11, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 104
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->eula_title:I

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/home/EulaDialog;->setTitle(I)V

    .line 105
    const/4 v2, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/home/EulaDialog;->setCancelable(Z)V

    .line 106
    const/4 v2, -0x1

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->eula_accept:I

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/AmazonActivity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v3

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-virtual {v0, v2, v3, v1}, Lcom/amazon/mShop/home/EulaDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 107
    const/4 v2, -0x2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->eula_dont_accept:I

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/AmazonActivity;->getText(I)Ljava/lang/CharSequence;

    move-result-object v3

    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-virtual {v0, v2, v3, v1}, Lcom/amazon/mShop/home/EulaDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 108
    move-object/from16 v0, p0

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/home/EulaDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 109
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/amazon/mShop/home/EulaDialog;->mEulaScroller:Landroid/widget/ScrollView;

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    move-object/from16 v2, p0

    invoke-virtual/range {v2 .. v7}, Lcom/amazon/mShop/home/EulaDialog;->setView(Landroid/view/View;IIII)V

    .line 110
    const/4 v2, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/home/EulaDialog;->setCanceledOnTouchOutside(Z)V

    .line 111
    return-void

    .line 84
    .end local v10    # "eula":Ljava/lang/CharSequence;
    .end local v11    # "eulaTextView":Landroid/widget/TextView;
    .end local v12    # "in":Ljava/io/BufferedReader;
    .end local v15    # "layoutInflater":Landroid/view/LayoutInflater;
    .restart local v8    # "buffer":Ljava/lang/StringBuilder;
    .restart local v13    # "in":Ljava/io/BufferedReader;
    .restart local v14    # "is":Ljava/io/InputStream;
    .restart local v16    # "line":Ljava/lang/String;
    :cond_1
    move-object v10, v8

    .line 89
    .restart local v10    # "eula":Ljava/lang/CharSequence;
    if-eqz v13, :cond_3

    .line 91
    :try_start_4
    invoke-virtual {v13}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    move-object v12, v13

    .line 94
    .end local v13    # "in":Ljava/io/BufferedReader;
    .restart local v12    # "in":Ljava/io/BufferedReader;
    goto :goto_2

    .line 92
    .end local v12    # "in":Ljava/io/BufferedReader;
    .restart local v13    # "in":Ljava/io/BufferedReader;
    :catch_1
    move-exception v2

    move-object v12, v13

    .line 94
    .end local v13    # "in":Ljava/io/BufferedReader;
    .restart local v12    # "in":Ljava/io/BufferedReader;
    goto :goto_2

    .line 89
    .end local v8    # "buffer":Ljava/lang/StringBuilder;
    .end local v10    # "eula":Ljava/lang/CharSequence;
    .end local v14    # "is":Ljava/io/InputStream;
    .end local v16    # "line":Ljava/lang/String;
    :catchall_0
    move-exception v2

    :goto_3
    if-eqz v12, :cond_2

    .line 91
    :try_start_5
    invoke-virtual {v12}, Ljava/io/BufferedReader;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 94
    :cond_2
    :goto_4
    throw v2

    .line 92
    .restart local v9    # "e":Ljava/io/IOException;
    .restart local v10    # "eula":Ljava/lang/CharSequence;
    :catch_2
    move-exception v2

    goto :goto_2

    .end local v9    # "e":Ljava/io/IOException;
    .end local v10    # "eula":Ljava/lang/CharSequence;
    :catch_3
    move-exception v3

    goto :goto_4

    .line 89
    .end local v12    # "in":Ljava/io/BufferedReader;
    .restart local v13    # "in":Ljava/io/BufferedReader;
    .restart local v14    # "is":Ljava/io/InputStream;
    :catchall_1
    move-exception v2

    move-object v12, v13

    .end local v13    # "in":Ljava/io/BufferedReader;
    .restart local v12    # "in":Ljava/io/BufferedReader;
    goto :goto_3

    .line 85
    .end local v14    # "is":Ljava/io/InputStream;
    :catch_4
    move-exception v9

    goto/16 :goto_1

    .end local v12    # "in":Ljava/io/BufferedReader;
    .restart local v8    # "buffer":Ljava/lang/StringBuilder;
    .restart local v10    # "eula":Ljava/lang/CharSequence;
    .restart local v13    # "in":Ljava/io/BufferedReader;
    .restart local v14    # "is":Ljava/io/InputStream;
    .restart local v16    # "line":Ljava/lang/String;
    :cond_3
    move-object v12, v13

    .end local v13    # "in":Ljava/io/BufferedReader;
    .restart local v12    # "in":Ljava/io/BufferedReader;
    goto/16 :goto_2
.end method

.method public static mustShowEula(Lcom/amazon/mShop/AmazonActivity;)Z
    .locals 5
    .param p0, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    const/4 v2, 0x0

    .line 39
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->config_hasEula:I

    invoke-static {p0, v3}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v3

    if-nez v3, :cond_1

    .line 49
    :cond_0
    :goto_0
    return v2

    .line 42
    :cond_1
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->eula_version:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 43
    .local v1, "currentVersion":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v3

    const-string/jumbo v4, "acceptedEulaVersion"

    invoke-interface {v3, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 46
    .local v0, "acceptedVersion":Ljava/lang/String;
    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 49
    const/4 v2, 0x1

    goto :goto_0
.end method

.method private onAccepted()V
    .locals 3

    .prologue
    .line 114
    iget-object v1, p0, Lcom/amazon/mShop/home/EulaDialog;->mMShopActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->eula_version:I

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/AmazonActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 115
    .local v0, "currentVersion":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v2, "acceptedEulaVersion"

    invoke-interface {v1, v2, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    iget-object v1, p0, Lcom/amazon/mShop/home/EulaDialog;->mMShopActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->onEulaAccepted()V

    .line 117
    return-void
.end method

.method private onRefused()V
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/mShop/home/EulaDialog;->mMShopActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 121
    return-void
.end method

.method public static showEulaIfNeeded(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 1
    .param p0, "mShopActivity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 61
    invoke-static {p0}, Lcom/amazon/mShop/home/EulaDialog;->mustShowEula(Lcom/amazon/mShop/AmazonActivity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 62
    new-instance v0, Lcom/amazon/mShop/home/EulaDialog;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/home/EulaDialog;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    invoke-virtual {v0}, Lcom/amazon/mShop/home/EulaDialog;->show()V

    .line 64
    :cond_0
    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 177
    invoke-direct {p0}, Lcom/amazon/mShop/home/EulaDialog;->onRefused()V

    .line 178
    return-void
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 185
    const/4 v0, -0x1

    if-ne v0, p2, :cond_0

    .line 186
    invoke-direct {p0}, Lcom/amazon/mShop/home/EulaDialog;->onAccepted()V

    .line 190
    :goto_0
    return-void

    .line 188
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/home/EulaDialog;->onRefused()V

    goto :goto_0
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/mShop/home/EulaDialog;->mEulaScroller:Landroid/widget/ScrollView;

    invoke-virtual {v0, p2}, Landroid/widget/ScrollView;->executeKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 153
    const/4 v0, 0x1

    .line 155
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/AmazonAlertDialog;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/mShop/home/EulaDialog;->mEulaScroller:Landroid/widget/ScrollView;

    invoke-virtual {v0, p2}, Landroid/widget/ScrollView;->executeKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 167
    const/4 v0, 0x1

    .line 169
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/AmazonAlertDialog;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public show()V
    .locals 2

    .prologue
    .line 132
    invoke-super {p0}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 137
    const/4 v1, -0x2

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/home/EulaDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v0

    .line 138
    .local v0, "button":Landroid/widget/Button;
    if-eqz v0, :cond_0

    .line 139
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setFocusableInTouchMode(Z)V

    .line 140
    invoke-virtual {v0}, Landroid/widget/Button;->requestFocus()Z

    .line 142
    :cond_0
    return-void
.end method
