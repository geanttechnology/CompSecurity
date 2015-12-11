.class Lcom/aio/downloader/service/ServiceCleaner$1;
.super Ljava/lang/Object;
.source "ServiceCleaner.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceCleaner;->onCreate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private iv_neitui_cover:Landroid/widget/ImageView;

.field private iv_neitui_icon:Landroid/widget/ImageView;

.field private iv_neituicha:Landroid/widget/ImageView;

.field private lf_neitui:Lcom/aio/downloader/views/LFrameLayout;

.field private neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

.field final synthetic this$0:Lcom/aio/downloader/service/ServiceCleaner;

.field private tv_neitui_body:Landroid/widget/TextView;

.field private tv_neitui_bt:Landroid/widget/TextView;

.field private tv_neitui_title:Landroid/widget/TextView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceCleaner;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    .line 84
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/dialog/NeituiDialog;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/service/ServiceCleaner$1;)Lcom/aio/downloader/service/ServiceCleaner;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    return-object v0
.end method


# virtual methods
.method public run()V
    .locals 14

    .prologue
    const v13, 0x7f0200f8

    const v12, 0x7f0200f7

    const v11, 0x7f0200d0

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 99
    const/4 v1, 0x0

    .line 101
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceCleaner;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 102
    const-string v5, "com.allinone.callerid"

    const/4 v6, 0x0

    .line 101
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 107
    :goto_0
    const/4 v2, 0x0

    .line 109
    .local v2, "packageInfo_cleaner":Landroid/content/pm/PackageInfo;
    :try_start_1
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceCleaner;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 110
    const-string v5, "com.evzapp.cleanmaster"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v2

    .line 115
    :goto_1
    const/4 v3, 0x0

    .line 117
    .local v3, "packageInfo_crush":Landroid/content/pm/PackageInfo;
    :try_start_2
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceCleaner;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v4

    .line 118
    const-string v5, "com.freepezzle.hexcrush"

    const/4 v6, 0x0

    .line 117
    invoke-virtual {v4, v5, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v3

    .line 124
    :goto_2
    if-eqz v1, :cond_0

    if-eqz v2, :cond_0

    .line 125
    if-nez v3, :cond_2

    .line 126
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceCleaner;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "interpolate_show"

    invoke-static {v4, v5}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 127
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-virtual {v4}, Lcom/aio/downloader/service/ServiceCleaner;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    .line 128
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    const-wide/32 v7, 0x2932e00

    add-long/2addr v5, v7

    .line 127
    invoke-static {v4, v5, v6}, Lcom/aio/downloader/utils/SharedPreferencesConfig;->Setneitui(Landroid/content/Context;J)V

    .line 129
    new-instance v4, Lcom/aio/downloader/dialog/NeituiDialog;

    .line 130
    iget-object v5, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-virtual {v5}, Lcom/aio/downloader/service/ServiceCleaner;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    .line 131
    const v6, 0x7f0c000e

    invoke-direct {v4, v5, v6}, Lcom/aio/downloader/dialog/NeituiDialog;-><init>(Landroid/content/Context;I)V

    .line 129
    iput-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    .line 132
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    invoke-virtual {v4, v10}, Lcom/aio/downloader/dialog/NeituiDialog;->setCanceledOnTouchOutside(Z)V

    .line 133
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/NeituiDialog;->getWindow()Landroid/view/Window;

    move-result-object v4

    .line 134
    const/16 v5, 0x7d3

    .line 133
    invoke-virtual {v4, v5}, Landroid/view/Window;->setType(I)V

    .line 135
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    invoke-virtual {v4}, Lcom/aio/downloader/dialog/NeituiDialog;->show()V

    .line 137
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    .line 138
    const v5, 0x7f070361

    invoke-virtual {v4, v5}, Lcom/aio/downloader/dialog/NeituiDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 137
    iput-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_cover:Landroid/widget/ImageView;

    .line 139
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    .line 140
    const v5, 0x7f070363

    invoke-virtual {v4, v5}, Lcom/aio/downloader/dialog/NeituiDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    .line 139
    iput-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_icon:Landroid/widget/ImageView;

    .line 141
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    .line 142
    const v5, 0x7f070364

    invoke-virtual {v4, v5}, Lcom/aio/downloader/dialog/NeituiDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 141
    iput-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_title:Landroid/widget/TextView;

    .line 143
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    .line 144
    const v5, 0x7f070367

    invoke-virtual {v4, v5}, Lcom/aio/downloader/dialog/NeituiDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 143
    iput-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_bt:Landroid/widget/TextView;

    .line 145
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    .line 146
    const v5, 0x7f070365

    invoke-virtual {v4, v5}, Lcom/aio/downloader/dialog/NeituiDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 145
    iput-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_body:Landroid/widget/TextView;

    .line 147
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    .line 148
    const v5, 0x7f070366

    invoke-virtual {v4, v5}, Lcom/aio/downloader/dialog/NeituiDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/aio/downloader/views/LFrameLayout;

    .line 147
    iput-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->lf_neitui:Lcom/aio/downloader/views/LFrameLayout;

    .line 149
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->neituidialog:Lcom/aio/downloader/dialog/NeituiDialog;

    const v5, 0x7f070362

    invoke-virtual {v4, v5}, Lcom/aio/downloader/dialog/NeituiDialog;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/ImageView;

    iput-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neituicha:Landroid/widget/ImageView;

    .line 150
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neituicha:Landroid/widget/ImageView;

    new-instance v5, Lcom/aio/downloader/service/ServiceCleaner$1$1;

    invoke-direct {v5, p0}, Lcom/aio/downloader/service/ServiceCleaner$1$1;-><init>(Lcom/aio/downloader/service/ServiceCleaner$1;)V

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 158
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v5

    const-wide/high16 v7, 0x4008000000000000L    # 3.0

    mul-double/2addr v5, v7

    double-to-int v5, v5

    add-int/lit8 v5, v5, 0x1

    invoke-static {v4, v5}, Lcom/aio/downloader/service/ServiceCleaner;->access$0(Lcom/aio/downloader/service/ServiceCleaner;I)V

    .line 159
    const-string v4, "tag"

    new-instance v5, Ljava/lang/StringBuilder;

    const-string v6, "mRandom="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->mRandom:I
    invoke-static {v6}, Lcom/aio/downloader/service/ServiceCleaner;->access$1(Lcom/aio/downloader/service/ServiceCleaner;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 160
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceCleaner;->access$1(Lcom/aio/downloader/service/ServiceCleaner;)I

    move-result v4

    if-ne v4, v10, :cond_3

    if-nez v1, :cond_3

    .line 161
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-static {v4, v9}, Lcom/aio/downloader/service/ServiceCleaner;->access$2(Lcom/aio/downloader/service/ServiceCleaner;Z)V

    .line 162
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_cover:Landroid/widget/ImageView;

    .line 163
    const v5, 0x7f020151

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 164
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_icon:Landroid/widget/ImageView;

    .line 165
    invoke-virtual {v4, v12}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 166
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_title:Landroid/widget/TextView;

    const-string v5, "Caller ID & Block"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 167
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_body:Landroid/widget/TextView;

    .line 168
    const-string v5, "Identify unknown calls and block unwanted calls!"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 169
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_bt:Landroid/widget/TextView;

    const-string v5, "Try Now"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 170
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->lf_neitui:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v5, Lcom/aio/downloader/service/ServiceCleaner$1$2;

    invoke-direct {v5, p0}, Lcom/aio/downloader/service/ServiceCleaner$1$2;-><init>(Lcom/aio/downloader/service/ServiceCleaner$1;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 379
    :cond_1
    :goto_3
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->biaoshi:Z
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceCleaner;->access$10(Lcom/aio/downloader/service/ServiceCleaner;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 381
    if-nez v2, :cond_5

    .line 382
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_cover:Landroid/widget/ImageView;

    .line 383
    const v5, 0x7f020152

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 384
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_icon:Landroid/widget/ImageView;

    .line 385
    invoke-virtual {v4, v13}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 386
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_title:Landroid/widget/TextView;

    .line 387
    const-string v5, "Cleaner&Speed Booster"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 388
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_body:Landroid/widget/TextView;

    .line 389
    const-string v5, "Keep your Android Phone clean, safe and fast!"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 390
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_bt:Landroid/widget/TextView;

    const-string v5, "Free to Boost"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 392
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->lf_neitui:Lcom/aio/downloader/views/LFrameLayout;

    .line 393
    new-instance v5, Lcom/aio/downloader/service/ServiceCleaner$1$5;

    invoke-direct {v5, p0}, Lcom/aio/downloader/service/ServiceCleaner$1$5;-><init>(Lcom/aio/downloader/service/ServiceCleaner$1;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 620
    :cond_2
    :goto_4
    return-void

    .line 103
    .end local v2    # "packageInfo_cleaner":Landroid/content/pm/PackageInfo;
    .end local v3    # "packageInfo_crush":Landroid/content/pm/PackageInfo;
    :catch_0
    move-exception v0

    .line 104
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_0

    .line 111
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v2    # "packageInfo_cleaner":Landroid/content/pm/PackageInfo;
    :catch_1
    move-exception v0

    .line 112
    .restart local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_1

    .line 119
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v3    # "packageInfo_crush":Landroid/content/pm/PackageInfo;
    :catch_2
    move-exception v0

    .line 120
    .restart local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto/16 :goto_2

    .line 238
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_3
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceCleaner;->access$1(Lcom/aio/downloader/service/ServiceCleaner;)I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_4

    if-nez v2, :cond_4

    .line 239
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-static {v4, v9}, Lcom/aio/downloader/service/ServiceCleaner;->access$2(Lcom/aio/downloader/service/ServiceCleaner;Z)V

    .line 240
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_cover:Landroid/widget/ImageView;

    .line 241
    const v5, 0x7f020152

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 242
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_icon:Landroid/widget/ImageView;

    .line 243
    invoke-virtual {v4, v13}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 244
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_title:Landroid/widget/TextView;

    const-string v5, "Cleaner&Speed Booster"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 245
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_body:Landroid/widget/TextView;

    .line 246
    const-string v5, "Keep your Android Phone clean, safe and fast!"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 247
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_bt:Landroid/widget/TextView;

    const-string v5, "Free to Boost"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 249
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->lf_neitui:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v5, Lcom/aio/downloader/service/ServiceCleaner$1$3;

    invoke-direct {v5, p0}, Lcom/aio/downloader/service/ServiceCleaner$1$3;-><init>(Lcom/aio/downloader/service/ServiceCleaner$1;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_3

    .line 308
    :cond_4
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    # getter for: Lcom/aio/downloader/service/ServiceCleaner;->mRandom:I
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceCleaner;->access$1(Lcom/aio/downloader/service/ServiceCleaner;)I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_1

    if-nez v3, :cond_1

    .line 309
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->this$0:Lcom/aio/downloader/service/ServiceCleaner;

    invoke-static {v4, v9}, Lcom/aio/downloader/service/ServiceCleaner;->access$2(Lcom/aio/downloader/service/ServiceCleaner;Z)V

    .line 310
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_cover:Landroid/widget/ImageView;

    .line 311
    const v5, 0x7f020153

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 312
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_icon:Landroid/widget/ImageView;

    .line 313
    invoke-virtual {v4, v11}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 314
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_title:Landroid/widget/TextView;

    const-string v5, "HEX Crush"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 315
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_body:Landroid/widget/TextView;

    .line 316
    const-string v5, "An easy to understand yet fun to master puzzle game."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 317
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_bt:Landroid/widget/TextView;

    const-string v5, "Free to Play"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 318
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->lf_neitui:Lcom/aio/downloader/views/LFrameLayout;

    new-instance v5, Lcom/aio/downloader/service/ServiceCleaner$1$4;

    invoke-direct {v5, p0}, Lcom/aio/downloader/service/ServiceCleaner$1$4;-><init>(Lcom/aio/downloader/service/ServiceCleaner$1;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_3

    .line 458
    :cond_5
    if-nez v3, :cond_6

    .line 459
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_cover:Landroid/widget/ImageView;

    .line 460
    const v5, 0x7f020153

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 461
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_icon:Landroid/widget/ImageView;

    .line 462
    invoke-virtual {v4, v11}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 463
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_title:Landroid/widget/TextView;

    const-string v5, "HEX Crush"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 464
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_body:Landroid/widget/TextView;

    .line 465
    const-string v5, "An easy to understand yet fun to master puzzle game."

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 466
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_bt:Landroid/widget/TextView;

    const-string v5, "Free to Play"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 467
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->lf_neitui:Lcom/aio/downloader/views/LFrameLayout;

    .line 468
    new-instance v5, Lcom/aio/downloader/service/ServiceCleaner$1$6;

    invoke-direct {v5, p0}, Lcom/aio/downloader/service/ServiceCleaner$1$6;-><init>(Lcom/aio/downloader/service/ServiceCleaner$1;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_4

    .line 531
    :cond_6
    if-nez v1, :cond_2

    .line 532
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_cover:Landroid/widget/ImageView;

    .line 533
    const v5, 0x7f020151

    invoke-virtual {v4, v5}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 534
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->iv_neitui_icon:Landroid/widget/ImageView;

    .line 535
    invoke-virtual {v4, v12}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 536
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_title:Landroid/widget/TextView;

    const-string v5, "Caller ID & Block"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 537
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_body:Landroid/widget/TextView;

    .line 538
    const-string v5, "Identify unknown calls and block unwanted calls!"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 539
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->tv_neitui_bt:Landroid/widget/TextView;

    const-string v5, "Try Now"

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 540
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceCleaner$1;->lf_neitui:Lcom/aio/downloader/views/LFrameLayout;

    .line 541
    new-instance v5, Lcom/aio/downloader/service/ServiceCleaner$1$7;

    invoke-direct {v5, p0}, Lcom/aio/downloader/service/ServiceCleaner$1$7;-><init>(Lcom/aio/downloader/service/ServiceCleaner$1;)V

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_4
.end method
