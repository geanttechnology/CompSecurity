.class public Lcom/aio/downloader/activity/AnzhuangActivity;
.super Lcom/aio/downloader/mydownload/BaseActivity;
.source "AnzhuangActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private PRO_DIR:Ljava/io/File;

.field private PRO_DIR_FOME:Ljava/io/File;

.field private PRO_DIR_TO:Ljava/io/File;

.field private appid:Ljava/lang/String;

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

.field private iv_icon_ins:Landroid/widget/ImageView;

.field pI:Landroid/content/pm/PackageInfo;

.field private progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private publictools:Lcom/aio/downloader/utils/publicTools;

.field private spnetworkre:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 47
    invoke-direct {p0}, Lcom/aio/downloader/mydownload/BaseActivity;-><init>()V

    .line 48
    new-instance v0, Lcom/aio/downloader/activity/AnzhuangActivity$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AnzhuangActivity$1;-><init>(Lcom/aio/downloader/activity/AnzhuangActivity;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->handler:Landroid/os/Handler;

    .line 85
    iput-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    .line 89
    iput-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 93
    iput-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->pI:Landroid/content/pm/PackageInfo;

    .line 94
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 95
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

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR_FOME:Ljava/io/File;

    .line 96
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 97
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

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR_TO:Ljava/io/File;

    .line 303
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 304
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

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR:Ljava/io/File;

    .line 47
    return-void
.end method

.method private Mydialog()V
    .locals 3

    .prologue
    .line 493
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 494
    const v1, 0x7f0b0034

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AnzhuangActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 495
    const-string v1, "It has been in downloading list already."

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 496
    const-string v1, "Ok"

    .line 497
    new-instance v2, Lcom/aio/downloader/activity/AnzhuangActivity$8;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/AnzhuangActivity$8;-><init>(Lcom/aio/downloader/activity/AnzhuangActivity;)V

    .line 496
    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 504
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 506
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/AnzhuangActivity;)V
    .locals 0

    .prologue
    .line 492
    invoke-direct {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->Mydialog()V

    return-void
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/AnzhuangActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR_TO:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/AnzhuangActivity;)Ljava/io/File;
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR_FOME:Ljava/io/File;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/AnzhuangActivity;)V
    .locals 0

    .prologue
    .line 308
    invoke-direct {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->installApk()V

    return-void
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/AnzhuangActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/activity/AnzhuangActivity;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->default_options:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/activity/AnzhuangActivity;)Lcom/aio/downloader/utils/publicTools;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/activity/AnzhuangActivity;)Lnet/tsz/afinal/FinalDBChen;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    return-object v0
.end method

.method private buildListener()V
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->cleanercancel:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 191
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->cleanerupdate:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 192
    return-void
.end method

.method private downwifi()V
    .locals 4

    .prologue
    .line 463
    new-instance v0, Lcom/aio/downloader/dialog/LianwangDialog;

    .line 464
    const v3, 0x7f0c000e

    .line 463
    invoke-direct {v0, p0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;-><init>(Landroid/content/Context;I)V

    .line 465
    .local v0, "dialog":Lcom/aio/downloader/dialog/LianwangDialog;
    const/4 v3, 0x0

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->setCanceledOnTouchOutside(Z)V

    .line 466
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/LianwangDialog;->show()V

    .line 467
    const v3, 0x7f070141

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 468
    .local v1, "networkcancel":Landroid/widget/Button;
    const v3, 0x7f070142

    invoke-virtual {v0, v3}, Lcom/aio/downloader/dialog/LianwangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 469
    .local v2, "networkok":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/activity/AnzhuangActivity$6;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity$6;-><init>(Lcom/aio/downloader/activity/AnzhuangActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 478
    new-instance v3, Lcom/aio/downloader/activity/AnzhuangActivity$7;

    invoke-direct {v3, p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity$7;-><init>(Lcom/aio/downloader/activity/AnzhuangActivity;Lcom/aio/downloader/dialog/LianwangDialog;)V

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 489
    return-void
.end method

.method private getAssetFile()Ljava/io/File;
    .locals 10

    .prologue
    .line 564
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 565
    .local v0, "asset":Landroid/content/res/AssetManager;
    const/4 v3, 0x0

    .line 567
    .local v3, "f":Ljava/io/File;
    :try_start_0
    iget-object v8, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->mkdirs()Z

    .line 568
    const-string v8, "cleaner.apk"

    invoke-virtual {v0, v8}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v6

    .line 569
    .local v6, "is":Ljava/io/InputStream;
    new-instance v4, Ljava/io/File;

    iget-object v8, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR:Ljava/io/File;

    const-string v9, "cleaner.apk"

    invoke-direct {v4, v8, v9}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 570
    .end local v3    # "f":Ljava/io/File;
    .local v4, "f":Ljava/io/File;
    :try_start_1
    invoke-virtual {v4}, Ljava/io/File;->createNewFile()Z

    .line 571
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 572
    .local v5, "fOut":Ljava/io/FileOutputStream;
    const/16 v8, 0x400

    new-array v1, v8, [B

    .line 573
    .local v1, "buffer":[B
    const/4 v7, 0x0

    .line 574
    .local v7, "len":I
    :goto_0
    invoke-virtual {v6, v1}, Ljava/io/InputStream;->read([B)I

    move-result v7

    const/4 v8, -0x1

    if-ne v7, v8, :cond_0

    .line 577
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->flush()V

    .line 578
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V

    .line 579
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->close()V

    move-object v3, v4

    .line 584
    .end local v1    # "buffer":[B
    .end local v4    # "f":Ljava/io/File;
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v7    # "len":I
    .restart local v3    # "f":Ljava/io/File;
    :goto_1
    return-object v4

    .line 575
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

    .line 581
    .end local v1    # "buffer":[B
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v7    # "len":I
    :catch_0
    move-exception v2

    move-object v3, v4

    .line 582
    .end local v4    # "f":Ljava/io/File;
    .end local v6    # "is":Ljava/io/InputStream;
    .local v2, "e":Ljava/io/IOException;
    .restart local v3    # "f":Ljava/io/File;
    :goto_2
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .line 584
    const/4 v4, 0x0

    goto :goto_1

    .line 581
    .end local v2    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    goto :goto_2
.end method

.method private init()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 128
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "appname"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->appname:Ljava/lang/String;

    .line 129
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "size"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->appsize:Ljava/lang/String;

    .line 130
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "appid"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->appid:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 132
    :try_start_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->appid:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->pI:Landroid/content/pm/PackageInfo;
    :try_end_1
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 137
    :goto_0
    :try_start_2
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->pI:Landroid/content/pm/PackageInfo;

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    .line 139
    .local v7, "icon":Landroid/graphics/drawable/Drawable;
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->iv_icon_ins:Landroid/widget/ImageView;

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 140
    const v0, 0x7f070093

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->descriptiontv:Landroid/widget/TextView;

    .line 143
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->descriptiontv:Landroid/widget/TextView;

    .line 145
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "<font color=\'#3463b4\'> <b>"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 146
    iget-object v2, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->appname:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 147
    const-string v2, "</b></font> installed, you can delete its unneeded apk file to save <font color=\'#3261b4\'><b>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 148
    iget-object v2, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->appsize:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".</b></font>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 145
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    .line 144
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 159
    .end local v7    # "icon":Landroid/graphics/drawable/Drawable;
    :goto_1
    const v0, 0x7f070090

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->cleanercancel:Landroid/widget/Button;

    .line 160
    const v0, 0x7f070092

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->cleanerupdate:Landroid/widget/Button;

    .line 161
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 162
    new-instance v0, Lcom/aio/downloader/utils/publicTools;

    invoke-direct {v0, p0}, Lcom/aio/downloader/utils/publicTools;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->publictools:Lcom/aio/downloader/utils/publicTools;

    .line 163
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->default_options:Ljava/util/HashMap;

    .line 164
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "save_cookie"

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 165
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "send_cookie"

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 166
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "show_header"

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 167
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->default_options:Ljava/util/HashMap;

    const-string v1, "redirect"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 169
    :try_start_3
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    invoke-virtual {p0, v2}, Lcom/aio/downloader/activity/AnzhuangActivity;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 170
    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 169
    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 171
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 172
    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 171
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->ds:Ljava/util/List;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 177
    :goto_2
    const-string v0, "network"

    invoke-virtual {p0, v0, v8}, Lcom/aio/downloader/activity/AnzhuangActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->spnetworkre:Landroid/content/SharedPreferences;

    .line 180
    :try_start_4
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;

    if-nez v0, :cond_0

    .line 181
    new-instance v0, Lcom/aio/downloader/db/TypeDbUtils;

    invoke-direct {v0, p0}, Lcom/aio/downloader/db/TypeDbUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->dbUtils:Lcom/aio/downloader/db/TypeDbUtils;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    .line 186
    :cond_0
    :goto_3
    return-void

    .line 133
    :catch_0
    move-exception v6

    .line 134
    .local v6, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :try_start_5
    invoke-virtual {v6}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto/16 :goto_0

    .line 156
    .end local v6    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_1
    move-exception v0

    goto/16 :goto_1

    .line 183
    :catch_2
    move-exception v0

    goto :goto_3

    .line 174
    :catch_3
    move-exception v0

    goto :goto_2
.end method

.method private installApk()V
    .locals 3

    .prologue
    .line 309
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 311
    .local v0, "aa":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR:Ljava/io/File;

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

    .line 312
    const-string v2, "application/vnd.android.package-archive"

    .line 310
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 313
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->startActivity(Landroid/content/Intent;)V

    .line 314
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

    .line 318
    sput-object p1, Lcom/aio/downloader/utils/publicTools;->keyid:Ljava/lang/String;

    .line 320
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v6, 0x3e8

    div-long/2addr v0, v6

    long-to-double v0, v0

    invoke-static {v0, v1}, Ljava/lang/Math;->floor(D)D

    move-result-wide v0

    double-to-long v4, v0

    .line 321
    .local v4, "local_time":J
    invoke-static {p1, v4, v5}, Lcom/aio/downloader/utils/publicTools;->getCode(Ljava/lang/String;J)Ljava/lang/String;

    move-result-object v3

    .line 323
    .local v3, "stamp":Ljava/lang/String;
    const-string v0, ""

    invoke-virtual {v3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 325
    const-string v0, "Failed to connect server. Please try again."

    .line 324
    invoke-static {p0, v0, v9}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 326
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 459
    :goto_0
    return-void

    .line 329
    :cond_0
    new-instance v0, Lcom/aio/downloader/activity/AnzhuangActivity$5;

    move-object v1, p0

    move-object v2, p1

    move-object v6, p2

    move-object v7, p3

    move v8, p4

    invoke-direct/range {v0 .. v8}, Lcom/aio/downloader/activity/AnzhuangActivity$5;-><init>(Lcom/aio/downloader/activity/AnzhuangActivity;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;I)V

    new-array v1, v9, [Ljava/lang/Void;

    .line 456
    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/AnzhuangActivity$5;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public initView()V
    .locals 6

    .prologue
    .line 531
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->initView()V

    .line 534
    :try_start_0
    new-instance v0, Lnet/tsz/afinal/FinalDBChen;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getmContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "download2.db"

    new-instance v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-direct {v3}, Lcom/aio/downloader/mydownload/DownloadMovieItem;-><init>()V

    .line 535
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 534
    invoke-direct/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 541
    :goto_0
    return-void

    .line 536
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 196
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 301
    :goto_0
    :pswitch_0
    return-void

    .line 198
    :pswitch_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->finish()V

    goto :goto_0

    .line 202
    :pswitch_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "Installpop_click"

    invoke-static {v3, v4}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 203
    new-instance v3, Lcom/aio/downloader/activity/AnzhuangActivity$3;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/AnzhuangActivity$3;-><init>(Lcom/aio/downloader/activity/AnzhuangActivity;)V

    .line 213
    invoke-virtual {v3}, Lcom/aio/downloader/activity/AnzhuangActivity$3;->start()V

    .line 214
    const/4 v2, 0x0

    .line 216
    .local v2, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 217
    const-string v4, "com.evzapp.cleanmaster"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 221
    :goto_1
    if-nez v2, :cond_2

    .line 222
    iget-object v3, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR_FOME:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 223
    invoke-direct {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->installApk()V

    .line 247
    :cond_0
    :goto_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->finish()V

    goto :goto_0

    .line 218
    :catch_0
    move-exception v0

    .line 219
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_1

    .line 224
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :cond_1
    iget-object v3, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->PRO_DIR_TO:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 225
    new-instance v3, Lcom/aio/downloader/activity/AnzhuangActivity$4;

    invoke-direct {v3, p0}, Lcom/aio/downloader/activity/AnzhuangActivity$4;-><init>(Lcom/aio/downloader/activity/AnzhuangActivity;)V

    new-array v4, v6, [Ljava/lang/Void;

    .line 240
    invoke-virtual {v3, v4}, Lcom/aio/downloader/activity/AnzhuangActivity$4;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2

    .line 243
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 244
    const-string v4, "com.evzapp.cleanmaster"

    .line 243
    invoke-virtual {v3, v4}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 245
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/AnzhuangActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_2

    .line 196
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
    .line 101
    invoke-super {p0, p1}, Lcom/aio/downloader/mydownload/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 102
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->requestWindowFeature(I)Z

    .line 104
    const v0, 0x7f030010

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->setContentView(I)V

    .line 105
    const v0, 0x7f070095

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->iv_icon_ins:Landroid/widget/ImageView;

    .line 108
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->initView()V

    .line 109
    invoke-direct {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->init()V

    .line 110
    invoke-direct {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->buildListener()V

    .line 112
    new-instance v0, Lcom/aio/downloader/activity/AnzhuangActivity$2;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/AnzhuangActivity$2;-><init>(Lcom/aio/downloader/activity/AnzhuangActivity;)V

    .line 121
    invoke-virtual {v0}, Lcom/aio/downloader/activity/AnzhuangActivity$2;->start()V

    .line 122
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Installpop"

    invoke-static {v0, v1}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 123
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 552
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onPause()V

    .line 553
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 555
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 546
    invoke-super {p0}, Lcom/aio/downloader/mydownload/BaseActivity;->onResume()V

    .line 547
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 548
    return-void
.end method

.method public toDownload(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 7
    .param p1, "down"    # Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .prologue
    .line 511
    const/4 v0, 0x7

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->setDownloadState(Ljava/lang/Integer;)V

    .line 512
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AnzhuangActivity;->getMyApp()Lcom/aio/downloader/mydownload/MyApplcation;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/aio/downloader/mydownload/MyApplcation;->setStartDownloadMovieItem(Lcom/aio/downloader/mydownload/DownloadMovieItem;)V

    .line 513
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    const-string v1, "download_aio"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/AnzhuangActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 516
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    .line 517
    const-string v1, "movieName"

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v2

    const-class v3, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    .line 518
    const-string v4, "downloadtask2"

    const/4 v5, 0x0

    .line 516
    invoke-virtual/range {v0 .. v5}, Lnet/tsz/afinal/FinalDBChen;->findItemsByWhereAndWhereValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v6

    .line 519
    .local v6, "ls":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/mydownload/DownloadMovieItem;>;"
    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 521
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    invoke-virtual {v0, p1, v1}, Lnet/tsz/afinal/FinalDBChen;->insertObject(Ljava/lang/Object;Ljava/lang/String;)J

    .line 527
    :goto_0
    return-void

    .line 524
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/activity/AnzhuangActivity;->db:Lnet/tsz/afinal/FinalDBChen;

    const-string v1, "downloadtask2"

    const-string v2, "movieName=?"

    .line 525
    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {p1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getMovieName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 524
    invoke-virtual {v0, v1, v2, v3, p1}, Lnet/tsz/afinal/FinalDBChen;->updateValuesByJavaBean(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
