.class public Lcom/aio/downloader/activity/UnInstallActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "UnInstallActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private appname:Ljava/lang/String;

.field private appsize:Ljava/lang/String;

.field private cleanercancel:Landroid/widget/Button;

.field private cleanerupdate:Landroid/widget/Button;

.field private db:Lnet/tsz/afinal/FinalDBChen;

.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

.field private default_options:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private descriptiontv:Landroid/widget/TextView;

.field private ds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field handler:Landroid/os/Handler;

.field private progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private spnetworkre:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 45
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 46
    new-instance v0, Lcom/aio/downloader/activity/UnInstallActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/UnInstallActivity$1;-><init>(Lcom/aio/downloader/activity/UnInstallActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->handler:Landroid/os/Handler;

    .line 83
    iput-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 87
    iput-object v1, p0, Lcom/aio/downloader/activity/UnInstallActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 91
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 92
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 93
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    .line 94
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner/cleaner.swf"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 287
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 288
    invoke-virtual {v2}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "/cleaner"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR:Ljava/io/File;

    .line 45
    return-void
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 475
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 476
    const v1, 0x7f0b0034

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/UnInstallActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 477
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 478
    const-string v1, "Ok"

    .line 479
    new-instance v2, Lcom/aio/downloader/activity/UnInstallActivity$8;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/UnInstallActivity$8;-><init>(Lcom/aio/downloader/activity/UnInstallActivity;)V

    .line 478
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 486
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 488
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/UnInstallActivity;)V
    .locals 0

    .prologue
    .line 474
    invoke-direct {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->Mydialog()V

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/UnInstallActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/UnInstallActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/UnInstallActivity;)V
    .locals 0

    .prologue
    .line 290
    invoke-direct {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->installApk()V

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/UnInstallActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/UnInstallActivity;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/UnInstallActivity;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 87
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/UnInstallActivity;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method private buildListener()V
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->cleanercancel:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 171
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->cleanerupdate:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 172
    return-void
.end method

.method private downwifi()V
    .locals 4

    .prologue
    .line 445
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    .line 446
    const v3, 0x7f0c000e

    .line 445
    invoke-direct {v0, p0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 447
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 448
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 449
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 450
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 451
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/activity/UnInstallActivity$6;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity$6;-><init>(Lcom/aio/downloader/activity/UnInstallActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 460
    new-instance v3, Lcom/aio/downloader/activity/UnInstallActivity$7;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity$7;-><init>(Lcom/aio/downloader/activity/UnInstallActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 471
    return-void
.end method

.method private getAssetFile()Ljava/io/File;
    .locals 10

    .prologue
    .line 546
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 547
    .local v0, "asset":Landroid/content/res/AssetManager;
    const/4 v3, 0x0

    .line 549
    .local v3, "f":Ljava/io/File;
    :try_start_0
    iget-object v8, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->mkdirs()Z

    .line 550
    const-string v8, "cleaner.apk"

    invoke-virtual {v0, v8}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v6

    .line 551
    .local v6, "is":Ljava/io/InputStream;
    new-instance v4, Ljava/io/File;

    iget-object v8, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR:Ljava/io/File;

    const-string v9, "cleaner.apk"

    invoke-direct {v4, v8, v9}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 552
    .end local v3    # "f":Ljava/io/File;
    .local v4, "f":Ljava/io/File;
    :try_start_1
    invoke-virtual {v4}, Ljava/io/File;->createNewFile()Z

    .line 553
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 554
    .local v5, "fOut":Ljava/io/FileOutputStream;
    const/16 v8, 0x400

    new-array v1, v8, [B

    .line 555
    .local v1, "buffer":[B
    const/4 v7, 0x0

    .line 556
    .local v7, "len":I
    :goto_0
    invoke-virtual {v6, v1}, Ljava/io/InputStream;->read([B)I

    move-result v7

    const/4 v8, -0x1

    if-ne v7, v8, :cond_0

    .line 559
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->flush()V

    .line 560
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V

    .line 561
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->close()V

    move-object v3, v4

    .line 566
    .end local v1    # "buffer":[B
    .end local v4    # "f":Ljava/io/File;
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v7    # "len":I
    .restart local v3    # "f":Ljava/io/File;
    :goto_1
    return-object v4

    .line 557
    .end local v3    # "f":Ljava/io/File;
    .restart local v1    # "buffer":[B
    .restart local v4    # "f":Ljava/io/File;
    .restart local v5    # "fOut":Ljava/io/FileOutputStream;
    .restart local v6    # "is":Ljava/io/InputStream;
    .restart local v7    # "len":I
    :cond_0
    const/4 v8, 0x0

    invoke-virtual {v5, v1, v8, v7}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 563
    .end local v1    # "buffer":[B
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v7    # "len":I
    :catch_0
    move-exception v2

    move-object v3, v4

    .line 564
    .end local v4    # "f":Ljava/io/File;
    .end local v6    # "is":Ljava/io/InputStream;
    .local v2, "e":Ljava/io/IOException;
    .restart local v3    # "f":Ljava/io/File;
    :goto_2
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .line 566
    const/4 v4, 0x0

    goto :goto_1

    .line 563
    .end local v2    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    goto :goto_2
.end method

.method private init()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 124
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "appname"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->appname:Ljava/lang/String;

    .line 125
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "size"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->appsize:Ljava/lang/String;

    .line 126
    const v0, 0x7f070093

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->descriptiontv:Landroid/widget/TextView;

    .line 130
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->descriptiontv:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "<font color=\'#3261b4\'> <b>"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 131
    iget-object v2, p0, Lcom/aio/downloader/activity/UnInstallActivity;->appname:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</b></font>  left <font color=\'#3261b4\'><b>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 132
    iget-object v2, p0, Lcom/aio/downloader/activity/UnInstallActivity;->appsize:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " </b></font> residual files. \n Use "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 133
    const-string v2, "<font color=\'#3261b4\'> <b>AIO Cleaner"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 134
    const-string v2, "</b></font> to get rid of them!"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 130
    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 139
    :goto_0
    const v0, 0x7f070090

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->cleanercancel:Landroid/widget/Button;

    .line 140
    const v0, 0x7f070092

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->cleanerupdate:Landroid/widget/Button;

    .line 141
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 142
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p0}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 143
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->default_options:Ljava/util/HashMap;

    .line 144
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 145
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 147
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 149
    :try_start_1
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/UnInstallActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 150
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 149
    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 151
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 152
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 151
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->ds:Ljava/util/List;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 157
    :goto_1
    const-string v0, "network"

    invoke-virtual {p0, v0, v6}, Lcom/aio/downloader/activity/UnInstallActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->spnetworkre:Landroid/content/SharedPreferences;

    .line 160
    :try_start_2
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 161
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 166
    :cond_0
    :goto_2
    return-void

    .line 163
    :catch_0
    move-exception v0

    goto :goto_2

    .line 154
    :catch_1
    move-exception v0

    goto :goto_1

    .line 136
    :catch_2
    move-exception v0

    goto/16 :goto_0
.end method

.method private installApk()V
    .locals 3

    .prologue
    .line 291
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 293
    .local v0, "aa":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "cleaner.apk"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 294
    const-string v2, "application/vnd.android.package-archive"

    .line 292
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 295
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity;->startActivity(Landroid/content/Intent;)V

    .line 296
    return-void
.end method


# virtual methods
.method public MydownloadApk(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 10
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "title"    # Ljava/lang/String;
    .param p3, "icon"    # Ljava/lang/String;
    .param p4, "appserial"    # I

    .prologue
    const/4 v9, 0x0

    .line 300
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 302
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 303
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 305
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 307
    const-string v0, "Failed to connect server. Please try again."

    .line 306
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 308
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 441
    :goto_0
    return-void

    .line 311
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/UnInstallActivity$5;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/activity/UnInstallActivity$5;-><init>(Lcom/aio/downloader/activity/UnInstallActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 438
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/UnInstallActivity$5;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public initView()V
    .locals 6

    .prologue
    .line 513
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->initView()V

    .line 516
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    new-instance v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 517
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 516
    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 523
    :goto_0
    return-void

    .line 518
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 176
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 285
    :goto_0
    :pswitch_0
    return-void

    .line 178
    :pswitch_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->finish()V

    goto :goto_0

    .line 182
    :pswitch_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "UnInstall_click"

    invoke-static {v3, v4}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 183
    new-instance v3, Lcom/aio/downloader/activity/UnInstallActivity$3;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/UnInstallActivity$3;-><init>(Lcom/aio/downloader/activity/UnInstallActivity;)V

    .line 193
    invoke-virtual {v3}, Lcom/aio/downloader/activity/UnInstallActivity$3;->start()V

    .line 195
    const/4 v2, 0x0

    .line 197
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 198
    const-string v4, "com.evzapp.cleanmaster"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 202
    :goto_1
    if-nez v2, :cond_2

    .line 203
    iget-object v3, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR_FOME:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 204
    invoke-direct {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->installApk()V

    .line 228
    :cond_0
    :goto_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->finish()V

    goto :goto_0

    .line 199
    :catch_0
    move-exception v0

    .line 200
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 205
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v3, p0, Lcom/aio/downloader/activity/UnInstallActivity;->PRO_DIR_TO:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 206
    new-instance v3, Lcom/aio/downloader/activity/UnInstallActivity$4;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/UnInstallActivity$4;-><init>(Lcom/aio/downloader/activity/UnInstallActivity;)V

    new-array v4, v6, [Ljava/lang/Void;

    .line 221
    invoke-virtual {v3, v4}, Lcom/aio/downloader/activity/UnInstallActivity$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2

    .line 224
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 225
    const-string v4, "com.evzapp.cleanmaster"

    .line 224
    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 226
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/UnInstallActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 176
    nop

    :pswitch_data_0
    .packed-switch 0x7f070090
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 99
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 100
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity;->requestWindowFeature(I)Z

    .line 102
    const v0, 0x7f0300b5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity;->setContentView(I)V

    .line 103
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->initView()V

    .line 104
    invoke-direct {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->init()V

    .line 105
    invoke-direct {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->buildListener()V

    .line 106
    invoke-direct {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getAssetFile()Ljava/io/File;

    .line 107
    new-instance v0, Lcom/aio/downloader/activity/UnInstallActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/UnInstallActivity$2;-><init>(Lcom/aio/downloader/activity/UnInstallActivity;)V

    .line 117
    invoke-virtual {v0}, Lcom/aio/downloader/activity/UnInstallActivity$2;->start()V

    .line 118
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "UnInstallpop"

    invoke-static {v0, v1}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 119
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 534
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 535
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 537
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 528
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onResume()V

    .line 529
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 530
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 493
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 494
    invoke-virtual {p0}, Lcom/aio/downloader/activity/UnInstallActivity;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 495
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "download_aio"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/UnInstallActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 498
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 499
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 500
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 498
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 501
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 503
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 509
    :goto_0
    return-void

    .line 506
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/UnInstallActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 507
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 506
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
