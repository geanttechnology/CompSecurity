.class public Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;
.super Landroid/widget/BaseAdapter;
.source "BackupNoRootAdapterlist.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;
    }
.end annotation


# instance fields
.field private final BACKUP:Ljava/lang/String;

.field private appVersion:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;

.field private inflate:Landroid/view/LayoutInflater;

.field private infos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/unstall/Info;",
            ">;"
        }
    .end annotation
.end field

.field private pd:Landroid/app/ProgressDialog;

.field private typeFace:Landroid/graphics/Typeface;

.field private typeFace2:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/unstall/Info;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p2, "info":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/unstall/Info;>;"
    const/4 v1, 0x0

    .line 46
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 41
    iput-object v1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->typeFace:Landroid/graphics/Typeface;

    iput-object v1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->typeFace2:Landroid/graphics/Typeface;

    .line 43
    const-string v0, "backup"

    iput-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->BACKUP:Ljava/lang/String;

    .line 44
    iput-object v1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;

    .line 47
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->inflate:Landroid/view/LayoutInflater;

    .line 48
    iput-object p2, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;

    .line 49
    iput-object p1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;

    .line 51
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 52
    const-string v1, "Roboto-Light.ttf"

    .line 51
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->typeFace:Landroid/graphics/Typeface;

    .line 53
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 54
    const-string v1, "Roboto-Condensed.ttf"

    .line 53
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->typeFace2:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 57
    :goto_0
    return-void

    .line 55
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Lcom/aio/downloader/db/TypeDbUtilsBackup;
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;Lcom/aio/downloader/db/TypeDbUtilsBackup;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Ljava/util/List;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 1

    .prologue
    .line 318
    invoke-direct {p0, p1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->drawable2Bitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;Landroid/app/ProgressDialog;)V
    .locals 0

    .prologue
    .line 42
    iput-object p1, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->pd:Landroid/app/ProgressDialog;

    return-void
.end method

.method static synthetic access$6(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)Landroid/app/ProgressDialog;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->pd:Landroid/app/ProgressDialog;

    return-object v0
.end method

.method public static bitmaptoString(Landroid/graphics/Bitmap;)Ljava/lang/String;
    .locals 5
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 310
    const/4 v2, 0x0

    .line 311
    .local v2, "string":Ljava/lang/String;
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 312
    .local v0, "bStream":Ljava/io/ByteArrayOutputStream;
    sget-object v3, Landroid/graphics/Bitmap$CompressFormat;->PNG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v4, 0x64

    invoke-virtual {p0, v3, v4, v0}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 313
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v1

    .line 314
    .local v1, "bytes":[B
    const/4 v3, 0x0

    invoke-static {v1, v3}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v2

    .line 315
    return-object v2
.end method

.method private drawable2Bitmap(Landroid/graphics/drawable/Drawable;)Landroid/graphics/Bitmap;
    .locals 7
    .param p1, "drawable"    # Landroid/graphics/drawable/Drawable;

    .prologue
    const/4 v6, 0x0

    .line 319
    instance-of v2, p1, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v2, :cond_0

    .line 320
    check-cast p1, Landroid/graphics/drawable/BitmapDrawable;

    .end local p1    # "drawable":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 334
    :goto_0
    return-object v0

    .line 321
    .restart local p1    # "drawable":Landroid/graphics/drawable/Drawable;
    :cond_0
    instance-of v2, p1, Landroid/graphics/drawable/NinePatchDrawable;

    if-eqz v2, :cond_2

    .line 324
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    .line 325
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v4

    .line 326
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getOpacity()I

    move-result v2

    const/4 v5, -0x1

    if-eq v2, v5, :cond_1

    sget-object v2, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    .line 323
    :goto_1
    invoke-static {v3, v4, v2}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 328
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    new-instance v1, Landroid/graphics/Canvas;

    invoke-direct {v1, v0}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 329
    .local v1, "canvas":Landroid/graphics/Canvas;
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v2

    .line 330
    invoke-virtual {p1}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v3

    .line 329
    invoke-virtual {p1, v6, v6, v2, v3}, Landroid/graphics/drawable/Drawable;->setBounds(IIII)V

    .line 331
    invoke-virtual {p1, v1}, Landroid/graphics/drawable/Drawable;->draw(Landroid/graphics/Canvas;)V

    goto :goto_0

    .line 327
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "canvas":Landroid/graphics/Canvas;
    :cond_1
    sget-object v2, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    goto :goto_1

    .line 334
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getFileSizes(Ljava/io/File;)J
    .locals 4
    .param p1, "f"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 296
    const-wide/16 v1, 0x0

    .line 297
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 298
    const/4 v0, 0x0

    .line 299
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 300
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 304
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 302
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 74
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 81
    const/4 v4, 0x0

    .line 82
    .local v4, "holder":Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;
    if-nez p2, :cond_0

    .line 83
    iget-object v7, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->inflate:Landroid/view/LayoutInflater;

    const v8, 0x7f0300b7

    const/4 v9, 0x0

    invoke-virtual {v7, v8, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 84
    new-instance v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;

    .end local v4    # "holder":Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;
    invoke-direct {v4, p0}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;-><init>(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;)V

    .line 85
    .restart local v4    # "holder":Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;
    const v7, 0x7f0703de

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    iput-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->name:Landroid/widget/TextView;

    .line 86
    const v7, 0x7f0702bc

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageView;

    iput-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->icon:Landroid/widget/ImageView;

    .line 88
    const v7, 0x7f0703e2

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 87
    iput-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall:Landroid/widget/TextView;

    .line 90
    const v7, 0x7f0703e0

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 89
    iput-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall_size:Landroid/widget/TextView;

    .line 92
    const v7, 0x7f0703df

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 91
    iput-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall_version:Landroid/widget/TextView;

    .line 93
    const v7, 0x7f0702f8

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    iput-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->view_up:Landroid/view/View;

    .line 94
    invoke-virtual {p2, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 99
    :goto_0
    if-nez p1, :cond_1

    .line 100
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->view_up:Landroid/view/View;

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Landroid/view/View;->setVisibility(I)V

    .line 105
    :goto_1
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->name:Landroid/widget/TextView;

    iget-object v8, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 106
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall_size:Landroid/widget/TextView;

    iget-object v8, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 107
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall_version:Landroid/widget/TextView;

    iget-object v8, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 109
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall:Landroid/widget/TextView;

    const-string v8, "BackUp"

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 110
    iget-object v8, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->name:Landroid/widget/TextView;

    iget-object v7, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v7}, Lcom/aio/downloader/unstall/Info;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 111
    iget-object v8, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->icon:Landroid/widget/ImageView;

    iget-object v7, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v7}, Lcom/aio/downloader/unstall/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v8, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 112
    new-instance v0, Lcom/aio/downloader/utils/MyAppInfo;

    iget-object v7, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;

    invoke-direct {v0, v7}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 114
    .local v0, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    const/4 v6, 0x0

    .line 116
    .local v6, "pI":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v7, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->context:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 117
    iget-object v7, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v7}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v7

    const/4 v9, 0x0

    .line 116
    invoke-virtual {v8, v7, v9}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v6

    .line 118
    new-instance v7, Ljava/io/File;

    iget-object v8, v6, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    invoke-direct {v7, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 119
    invoke-virtual {v7}, Ljava/io/File;->length()J

    move-result-wide v7

    const-wide/16 v9, 0x400

    .line 118
    div-long v1, v7, v9

    .line 120
    .local v1, "appSize":J
    long-to-double v7, v1

    const-wide/high16 v9, 0x4090000000000000L    # 1024.0

    div-double/2addr v7, v9

    const-wide/high16 v9, 0x4059000000000000L    # 100.0

    mul-double/2addr v7, v9

    double-to-int v7, v7

    int-to-double v7, v7

    const-wide/high16 v9, 0x4059000000000000L    # 100.0

    div-double/2addr v7, v9

    double-to-float v5, v7

    .line 121
    .local v5, "lastSize":F
    const-wide/16 v7, 0x400

    cmp-long v7, v1, v7

    if-ltz v7, :cond_2

    .line 122
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall_size:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "MB"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 131
    .end local v1    # "appSize":J
    .end local v5    # "lastSize":F
    :goto_2
    :try_start_1
    iget-object v7, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->infos:Ljava/util/List;

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/unstall/Info;

    .line 132
    invoke-virtual {v7}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v7

    .line 131
    invoke-virtual {v0, v7}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->appVersion:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 138
    :goto_3
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall_version:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Version:"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;->appVersion:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 140
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall:Landroid/widget/TextView;

    new-instance v8, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;

    invoke-direct {v8, p0, p1}, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$1;-><init>(Lcom/aio/downloader/unstall/BackupNoRootAdapterlist;I)V

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 285
    return-object p2

    .line 96
    .end local v0    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v6    # "pI":Landroid/content/pm/PackageInfo;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "holder":Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;
    check-cast v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;

    .restart local v4    # "holder":Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;
    goto/16 :goto_0

    .line 102
    :cond_1
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->view_up:Landroid/view/View;

    const/16 v8, 0x8

    invoke-virtual {v7, v8}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 124
    .restart local v0    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .restart local v1    # "appSize":J
    .restart local v5    # "lastSize":F
    .restart local v6    # "pI":Landroid/content/pm/PackageInfo;
    :cond_2
    :try_start_2
    iget-object v7, v4, Lcom/aio/downloader/unstall/BackupNoRootAdapterlist$ViewHold;->tv_uninstall_size:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "KB"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_2

    .line 126
    .end local v1    # "appSize":J
    .end local v5    # "lastSize":F
    :catch_0
    move-exception v3

    .line 127
    .local v3, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 134
    .end local v3    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_1
    move-exception v3

    .line 136
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3
.end method
