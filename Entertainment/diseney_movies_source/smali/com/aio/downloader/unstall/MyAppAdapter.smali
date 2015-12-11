.class public Lcom/aio/downloader/unstall/MyAppAdapter;
.super Landroid/widget/BaseAdapter;
.source "MyAppAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/unstall/MyAppAdapter$Mya1;,
        Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private appVersion:Ljava/lang/String;

.field private context:Landroid/content/Context;

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

.field private list:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/mydownload/DownloadMovieItem;",
            ">;"
        }
    .end annotation
.end field

.field private mWindow:Landroid/widget/PopupWindow;

.field private model:Lcom/aio/downloader/mydownload/DownloadMovieItem;

.field private myididididid:Ljava/lang/String;

.field private typeFace:Landroid/graphics/Typeface;

.field private typeFace2:Landroid/graphics/Typeface;

.field private url:Ljava/lang/String;


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
    const/4 v0, 0x0

    .line 58
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 51
    iput-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->typeFace:Landroid/graphics/Typeface;

    iput-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->typeFace2:Landroid/graphics/Typeface;

    .line 53
    iput-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->url:Ljava/lang/String;

    .line 56
    iput-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->myididididid:Ljava/lang/String;

    .line 59
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->inflate:Landroid/view/LayoutInflater;

    .line 60
    iput-object p2, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->infos:Ljava/util/List;

    .line 61
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;

    .line 63
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 64
    const-string v1, "Roboto-Light.ttf"

    .line 63
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->typeFace:Landroid/graphics/Typeface;

    .line 65
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 66
    const-string v1, "Roboto-Condensed.ttf"

    .line 65
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->typeFace2:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 69
    :goto_0
    return-void

    .line 67
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/unstall/MyAppAdapter;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 53
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->url:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->list:Ljava/util/ArrayList;

    return-void
.end method

.method static synthetic access$10(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->url:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$11(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->myididididid:Ljava/lang/String;

    return-void
.end method

.method static synthetic access$2(Lcom/aio/downloader/unstall/MyAppAdapter;Lcom/aio/downloader/mydownload/DownloadMovieItem;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-void
.end method

.method static synthetic access$3(Lcom/aio/downloader/unstall/MyAppAdapter;)Lcom/aio/downloader/mydownload/DownloadMovieItem;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->model:Lcom/aio/downloader/mydownload/DownloadMovieItem;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/unstall/MyAppAdapter;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->list:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$5(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$6(Lcom/aio/downloader/unstall/MyAppAdapter;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->myididididid:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$7(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 185
    invoke-direct {p0, p1}, Lcom/aio/downloader/unstall/MyAppAdapter;->popuWindow(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$8(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/widget/PopupWindow;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;

    return-object v0
.end method

.method static synthetic access$9(Lcom/aio/downloader/unstall/MyAppAdapter;)Landroid/view/LayoutInflater;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->inflate:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method private backupApplication(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p1, "appId"    # Ljava/lang/String;
    .param p2, "dest"    # Ljava/lang/String;

    .prologue
    .line 383
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v10

    if-eqz v10, :cond_0

    if-eqz p2, :cond_0

    .line 384
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v10

    if-nez v10, :cond_2

    .line 385
    :cond_0
    const-string v10, "illegal parameters"

    .line 441
    :cond_1
    :goto_0
    return-object v10

    .line 390
    :cond_2
    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "/data/app/"

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "-1.apk"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 391
    .local v1, "apkPath":Ljava/lang/String;
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 392
    .local v0, "apkFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v10

    if-nez v10, :cond_3

    .line 393
    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "/data/app/"

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "-2.apk"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 394
    new-instance v0, Ljava/io/File;

    .end local v0    # "apkFile":Ljava/io/File;
    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 395
    .restart local v0    # "apkFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v10

    if-nez v10, :cond_3

    .line 396
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v11

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v11, " doesn\'t exist!"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    goto :goto_0

    .line 399
    :cond_3
    const/4 v6, 0x0

    .line 401
    .local v6, "in":Ljava/io/FileInputStream;
    :try_start_0
    new-instance v6, Ljava/io/FileInputStream;

    .end local v6    # "in":Ljava/io/FileInputStream;
    invoke-direct {v6, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 407
    .restart local v6    # "in":Ljava/io/FileInputStream;
    const/16 v10, 0x2f

    invoke-virtual {p2, v10}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v5

    .line 408
    .local v5, "i":I
    const/4 v10, -0x1

    if-eq v5, v10, :cond_4

    .line 409
    new-instance v3, Ljava/io/File;

    const/4 v10, 0x0

    invoke-virtual {p2, v10, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v3, v10}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 410
    .local v3, "dirs":Ljava/io/File;
    invoke-virtual {v3}, Ljava/io/File;->mkdirs()Z

    .line 414
    .end local v3    # "dirs":Ljava/io/File;
    :cond_4
    const/16 v10, 0x400

    new-array v2, v10, [B

    .line 416
    .local v2, "c":[B
    const/4 v7, 0x0

    .line 418
    .local v7, "out":Ljava/io/FileOutputStream;
    :try_start_1
    new-instance v8, Ljava/io/FileOutputStream;

    invoke-direct {v8, p2}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_8
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 419
    .end local v7    # "out":Ljava/io/FileOutputStream;
    .local v8, "out":Ljava/io/FileOutputStream;
    :goto_1
    const/4 v10, 0x0

    :try_start_2
    array-length v11, v2

    invoke-virtual {v6, v2, v10, v11}, Ljava/io/FileInputStream;->read([BII)I
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result v9

    .local v9, "slen":I
    const/4 v10, -0x1

    if-ne v9, v10, :cond_7

    .line 425
    if-eqz v8, :cond_5

    .line 427
    :try_start_3
    invoke-virtual {v8}, Ljava/io/FileOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_6

    .line 432
    :cond_5
    if-eqz v6, :cond_6

    .line 434
    :try_start_4
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_7

    .line 441
    :cond_6
    const-string v10, "success"

    goto/16 :goto_0

    .line 402
    .end local v2    # "c":[B
    .end local v5    # "i":I
    .end local v6    # "in":Ljava/io/FileInputStream;
    .end local v8    # "out":Ljava/io/FileOutputStream;
    .end local v9    # "slen":I
    :catch_0
    move-exception v4

    .line 403
    .local v4, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v4}, Ljava/io/FileNotFoundException;->printStackTrace()V

    .line 404
    invoke-virtual {v4}, Ljava/io/FileNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 420
    .end local v4    # "e":Ljava/io/FileNotFoundException;
    .restart local v2    # "c":[B
    .restart local v5    # "i":I
    .restart local v6    # "in":Ljava/io/FileInputStream;
    .restart local v8    # "out":Ljava/io/FileOutputStream;
    .restart local v9    # "slen":I
    :cond_7
    const/4 v10, 0x0

    :try_start_5
    invoke-virtual {v8, v2, v10, v9}, Ljava/io/FileOutputStream;->write([BII)V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    goto :goto_1

    .line 421
    .end local v9    # "slen":I
    :catch_1
    move-exception v4

    move-object v7, v8

    .line 422
    .end local v8    # "out":Ljava/io/FileOutputStream;
    .local v4, "e":Ljava/io/IOException;
    .restart local v7    # "out":Ljava/io/FileOutputStream;
    :goto_2
    :try_start_6
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 423
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    move-result-object v10

    .line 425
    if-eqz v7, :cond_8

    .line 427
    :try_start_7
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_3

    .line 432
    :cond_8
    if-eqz v6, :cond_1

    .line 434
    :try_start_8
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_8
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_2

    goto/16 :goto_0

    .line 435
    :catch_2
    move-exception v4

    .line 436
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 437
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 428
    :catch_3
    move-exception v4

    .line 429
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 430
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 424
    .end local v4    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v10

    .line 425
    :goto_3
    if-eqz v7, :cond_9

    .line 427
    :try_start_9
    invoke-virtual {v7}, Ljava/io/FileOutputStream;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_4

    .line 432
    :cond_9
    if-eqz v6, :cond_a

    .line 434
    :try_start_a
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_5

    .line 440
    :cond_a
    throw v10

    .line 428
    :catch_4
    move-exception v4

    .line 429
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 430
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 435
    .end local v4    # "e":Ljava/io/IOException;
    :catch_5
    move-exception v4

    .line 436
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 437
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 428
    .end local v4    # "e":Ljava/io/IOException;
    .end local v7    # "out":Ljava/io/FileOutputStream;
    .restart local v8    # "out":Ljava/io/FileOutputStream;
    .restart local v9    # "slen":I
    :catch_6
    move-exception v4

    .line 429
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 430
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 435
    .end local v4    # "e":Ljava/io/IOException;
    :catch_7
    move-exception v4

    .line 436
    .restart local v4    # "e":Ljava/io/IOException;
    invoke-virtual {v4}, Ljava/io/IOException;->printStackTrace()V

    .line 437
    invoke-virtual {v4}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v10

    goto/16 :goto_0

    .line 424
    .end local v4    # "e":Ljava/io/IOException;
    .end local v9    # "slen":I
    :catchall_1
    move-exception v10

    move-object v7, v8

    .end local v8    # "out":Ljava/io/FileOutputStream;
    .restart local v7    # "out":Ljava/io/FileOutputStream;
    goto :goto_3

    .line 421
    :catch_8
    move-exception v4

    goto :goto_2
.end method

.method public static dip2px(Landroid/content/Context;F)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dpValue"    # F

    .prologue
    .line 299
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v0, v1, Landroid/util/DisplayMetrics;->density:F

    .line 301
    .local v0, "scale":F
    mul-float v1, p1, v0

    const/high16 v2, 0x3f000000    # 0.5f

    add-float/2addr v1, v2

    float-to-int v1, v1

    return v1
.end method

.method private popuWindow(Ljava/lang/String;)V
    .locals 11
    .param p1, "myPackageNmae"    # Ljava/lang/String;

    .prologue
    const/4 v10, -0x2

    .line 187
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;

    invoke-static {v8}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    .line 188
    .local v1, "inflater":Landroid/view/LayoutInflater;
    const v8, 0x7f03009b

    const/4 v9, 0x0

    invoke-virtual {v1, v8, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v7

    .line 190
    .local v7, "view":Landroid/view/View;
    const v8, 0x7f07035c

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 189
    check-cast v5, Lcom/aio/downloader/views/LFrameLayout;

    .line 193
    .local v5, "rl_show_app_info":Lcom/aio/downloader/views/LFrameLayout;
    const v8, 0x7f07035d

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 192
    check-cast v2, Lcom/aio/downloader/views/LFrameLayout;

    .line 195
    .local v2, "rl_open_this_app":Lcom/aio/downloader/views/LFrameLayout;
    const v8, 0x7f07035e

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 194
    check-cast v6, Lcom/aio/downloader/views/LFrameLayout;

    .line 197
    .local v6, "rl_uninstall":Lcom/aio/downloader/views/LFrameLayout;
    const v8, 0x7f07035f

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    .line 196
    check-cast v3, Lcom/aio/downloader/views/LFrameLayout;

    .line 199
    .local v3, "rl_private_options":Lcom/aio/downloader/views/LFrameLayout;
    const v8, 0x7f070360

    invoke-virtual {v7, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 198
    check-cast v4, Lcom/aio/downloader/views/LFrameLayout;

    .line 201
    .local v4, "rl_share_with_friend":Lcom/aio/downloader/views/LFrameLayout;
    new-instance v8, Lcom/aio/downloader/unstall/MyAppAdapter$2;

    invoke-direct {v8, p0, p1}, Lcom/aio/downloader/unstall/MyAppAdapter$2;-><init>(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V

    invoke-virtual {v5, v8}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 213
    new-instance v8, Lcom/aio/downloader/unstall/MyAppAdapter$3;

    invoke-direct {v8, p0, p1}, Lcom/aio/downloader/unstall/MyAppAdapter$3;-><init>(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V

    invoke-virtual {v2, v8}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    new-instance v8, Lcom/aio/downloader/unstall/MyAppAdapter$4;

    invoke-direct {v8, p0, p1}, Lcom/aio/downloader/unstall/MyAppAdapter$4;-><init>(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V

    invoke-virtual {v6, v8}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 263
    new-instance v8, Lcom/aio/downloader/unstall/MyAppAdapter$5;

    invoke-direct {v8, p0}, Lcom/aio/downloader/unstall/MyAppAdapter$5;-><init>(Lcom/aio/downloader/unstall/MyAppAdapter;)V

    invoke-virtual {v3, v8}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 270
    new-instance v8, Lcom/aio/downloader/unstall/MyAppAdapter$6;

    invoke-direct {v8, p0, p1}, Lcom/aio/downloader/unstall/MyAppAdapter$6;-><init>(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V

    invoke-virtual {v4, v8}, Lcom/aio/downloader/views/LFrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 281
    new-instance v8, Landroid/widget/PopupWindow;

    invoke-direct {v8, v7}, Landroid/widget/PopupWindow;-><init>(Landroid/view/View;)V

    iput-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;

    .line 282
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v8, v10}, Landroid/widget/PopupWindow;->setWidth(I)V

    .line 283
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v8, v10}, Landroid/widget/PopupWindow;->setHeight(I)V

    .line 284
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;

    const/4 v9, 0x1

    invoke-virtual {v8, v9}, Landroid/widget/PopupWindow;->setFocusable(Z)V

    .line 286
    new-instance v0, Landroid/graphics/drawable/ColorDrawable;

    const/4 v8, 0x0

    invoke-direct {v0, v8}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    .line 287
    .local v0, "dw":Landroid/graphics/drawable/ColorDrawable;
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->mWindow:Landroid/widget/PopupWindow;

    invoke-virtual {v8, v0}, Landroid/widget/PopupWindow;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 288
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->infos:Ljava/util/List;

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
    .line 446
    const-wide/16 v1, 0x0

    .line 447
    .local v1, "s":J
    invoke-virtual {p1}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 448
    const/4 v0, 0x0

    .line 449
    .local v0, "fis":Ljava/io/FileInputStream;
    new-instance v0, Ljava/io/FileInputStream;

    .end local v0    # "fis":Ljava/io/FileInputStream;
    invoke-direct {v0, p1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    .line 450
    .restart local v0    # "fis":Ljava/io/FileInputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->available()I

    move-result v3

    int-to-long v1, v3

    .line 454
    .end local v0    # "fis":Ljava/io/FileInputStream;
    :goto_0
    return-wide v1

    .line 452
    :cond_0
    invoke-virtual {p1}, Ljava/io/File;->createNewFile()Z

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->infos:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 86
    add-int/lit8 v0, p1, 0x1

    int-to-long v0, v0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 93
    const/4 v4, 0x0

    .line 94
    .local v4, "holder":Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;
    if-nez p2, :cond_0

    .line 95
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->inflate:Landroid/view/LayoutInflater;

    const v9, 0x7f030080

    const/4 v10, 0x0

    invoke-virtual {v8, v9, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 96
    new-instance v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;

    .end local v4    # "holder":Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;
    invoke-direct {v4, p0}, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;-><init>(Lcom/aio/downloader/unstall/MyAppAdapter;)V

    .line 98
    .restart local v4    # "holder":Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;
    const v8, 0x7f0702fa

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 97
    iput-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->name:Landroid/widget/TextView;

    .line 100
    const v8, 0x7f0702f9

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/ImageView;

    .line 99
    iput-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->icon:Landroid/widget/ImageView;

    .line 102
    const v8, 0x7f0702fd

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 101
    iput-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->tv_uninstall_size:Landroid/widget/TextView;

    .line 104
    const v8, 0x7f0702fc

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 103
    iput-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->tv_uninstall_version:Landroid/widget/TextView;

    .line 106
    const v8, 0x7f0702fb

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Lcom/aio/downloader/views/LImageButton;

    .line 105
    iput-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->myapp_bt:Lcom/aio/downloader/views/LImageButton;

    .line 107
    const v8, 0x7f0702f8

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    iput-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->view_up:Landroid/view/View;

    .line 108
    invoke-virtual {p2, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 112
    :goto_0
    if-nez p1, :cond_1

    .line 113
    iget-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->view_up:Landroid/view/View;

    const/4 v9, 0x0

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    .line 117
    :goto_1
    iget-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->name:Landroid/widget/TextView;

    iget-object v9, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 118
    iget-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->tv_uninstall_size:Landroid/widget/TextView;

    iget-object v9, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 119
    iget-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->tv_uninstall_version:Landroid/widget/TextView;

    iget-object v9, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 121
    iget-object v9, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->name:Landroid/widget/TextView;

    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->infos:Ljava/util/List;

    invoke-interface {v8, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v8}, Lcom/aio/downloader/unstall/Info;->getName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v9, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 122
    iget-object v9, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->icon:Landroid/widget/ImageView;

    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->infos:Ljava/util/List;

    invoke-interface {v8, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v8}, Lcom/aio/downloader/unstall/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v8

    invoke-virtual {v9, v8}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 123
    new-instance v0, Lcom/aio/downloader/utils/MyAppInfo;

    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;

    invoke-direct {v0, v8}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 125
    .local v0, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    const/4 v7, 0x0

    .line 127
    .local v7, "pI":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->context:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v9

    .line 128
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->infos:Ljava/util/List;

    invoke-interface {v8, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v8}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v8

    const/4 v10, 0x0

    .line 127
    invoke-virtual {v9, v8, v10}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v7

    .line 129
    new-instance v8, Ljava/io/File;

    iget-object v9, v7, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v9, v9, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    invoke-direct {v8, v9}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 130
    invoke-virtual {v8}, Ljava/io/File;->length()J

    move-result-wide v8

    const-wide/16 v10, 0x400

    .line 129
    div-long v1, v8, v10

    .line 131
    .local v1, "appSize":J
    long-to-double v8, v1

    const-wide/high16 v10, 0x4090000000000000L    # 1024.0

    div-double/2addr v8, v10

    const-wide/high16 v10, 0x4059000000000000L    # 100.0

    mul-double/2addr v8, v10

    double-to-int v8, v8

    int-to-double v8, v8

    const-wide/high16 v10, 0x4059000000000000L    # 100.0

    div-double/2addr v8, v10

    double-to-float v5, v8

    .line 132
    .local v5, "lastSize":F
    const-wide/16 v8, 0x400

    cmp-long v8, v1, v8

    if-ltz v8, :cond_2

    .line 133
    iget-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->tv_uninstall_size:Landroid/widget/TextView;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "MB"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 140
    .end local v1    # "appSize":J
    .end local v5    # "lastSize":F
    :goto_2
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->infos:Ljava/util/List;

    invoke-interface {v8, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v8}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v6

    .line 142
    .local v6, "myPackageNmae":Ljava/lang/String;
    :try_start_1
    iget-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->infos:Ljava/util/List;

    invoke-interface {v8, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/aio/downloader/unstall/Info;

    .line 143
    invoke-virtual {v8}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v8

    .line 142
    invoke-virtual {v0, v8}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    iput-object v8, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->appVersion:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 149
    :goto_3
    iget-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->tv_uninstall_version:Landroid/widget/TextView;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Version:"

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v10, p0, Lcom/aio/downloader/unstall/MyAppAdapter;->appVersion:Ljava/lang/String;

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 150
    iget-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->myapp_bt:Lcom/aio/downloader/views/LImageButton;

    new-instance v9, Lcom/aio/downloader/unstall/MyAppAdapter$1;

    invoke-direct {v9, p0, v6}, Lcom/aio/downloader/unstall/MyAppAdapter$1;-><init>(Lcom/aio/downloader/unstall/MyAppAdapter;Ljava/lang/String;)V

    invoke-virtual {v8, v9}, Lcom/aio/downloader/views/LImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 182
    return-object p2

    .line 110
    .end local v0    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v6    # "myPackageNmae":Ljava/lang/String;
    .end local v7    # "pI":Landroid/content/pm/PackageInfo;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "holder":Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;
    check-cast v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;

    .restart local v4    # "holder":Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;
    goto/16 :goto_0

    .line 115
    :cond_1
    iget-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->view_up:Landroid/view/View;

    const/16 v9, 0x8

    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 135
    .restart local v0    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .restart local v1    # "appSize":J
    .restart local v5    # "lastSize":F
    .restart local v7    # "pI":Landroid/content/pm/PackageInfo;
    :cond_2
    :try_start_2
    iget-object v8, v4, Lcom/aio/downloader/unstall/MyAppAdapter$ViewHolder;->tv_uninstall_size:Landroid/widget/TextView;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "KB"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_2
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_2

    .line 137
    .end local v1    # "appSize":J
    .end local v5    # "lastSize":F
    :catch_0
    move-exception v3

    .line 138
    .local v3, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 145
    .end local v3    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    .restart local v6    # "myPackageNmae":Ljava/lang/String;
    :catch_1
    move-exception v3

    .line 147
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3
.end method
