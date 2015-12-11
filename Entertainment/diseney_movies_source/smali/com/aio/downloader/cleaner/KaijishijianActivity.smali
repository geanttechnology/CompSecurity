.class public Lcom/aio/downloader/cleaner/KaijishijianActivity;
.super Landroid/app/Activity;
.source "KaijishijianActivity.java"


# instance fields
.field private PRO_DIR:Ljava/io/File;

.field private aiojiasu:I

.field private btn_cancel_kaiji:Landroid/widget/Button;

.field private btn_ok_kaiji:Landroid/widget/Button;

.field private dabai:I

.field private iv_back_kaiji:Landroid/widget/ImageView;

.field private kaiji_lala:Landroid/widget/TextView;

.field private kaiji_message:Landroid/widget/TextView;

.field private kaiji_shijan:Landroid/widget/TextView;

.field private kaiji_title:Landroid/widget/TextView;

.field private kaijishijian:I


# direct methods
.method public constructor <init>()V
    .locals 6

    .prologue
    const-wide/high16 v4, 0x4034000000000000L    # 20.0

    .line 26
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 32
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v0

    mul-double/2addr v0, v4

    add-double/2addr v0, v4

    double-to-int v0, v0

    iput v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->kaijishijian:I

    .line 33
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v0

    const-wide/high16 v2, 0x4010000000000000L    # 4.0

    mul-double/2addr v0, v2

    const-wide/high16 v2, 0x3ff0000000000000L    # 1.0

    add-double/2addr v0, v2

    double-to-int v0, v0

    iput v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->aiojiasu:I

    .line 34
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v0

    mul-double/2addr v0, v4

    const-wide v2, 0x4052c00000000000L    # 75.0

    add-double/2addr v0, v2

    double-to-int v0, v0

    iput v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->dabai:I

    .line 98
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    .line 99
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

    iput-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->PRO_DIR:Ljava/io/File;

    .line 26
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/cleaner/KaijishijianActivity;)V
    .locals 0

    .prologue
    .line 101
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->installApk()V

    return-void
.end method

.method private getAssetFile()Ljava/io/File;
    .locals 10

    .prologue
    .line 110
    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 111
    .local v0, "asset":Landroid/content/res/AssetManager;
    const/4 v3, 0x0

    .line 113
    .local v3, "f":Ljava/io/File;
    :try_start_0
    iget-object v8, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->PRO_DIR:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->mkdirs()Z

    .line 114
    const-string v8, "cleaner.apk"

    invoke-virtual {v0, v8}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v6

    .line 115
    .local v6, "is":Ljava/io/InputStream;
    new-instance v4, Ljava/io/File;

    iget-object v8, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->PRO_DIR:Ljava/io/File;

    const-string v9, "cleaner.apk"

    invoke-direct {v4, v8, v9}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 116
    .end local v3    # "f":Ljava/io/File;
    .local v4, "f":Ljava/io/File;
    :try_start_1
    invoke-virtual {v4}, Ljava/io/File;->createNewFile()Z

    .line 117
    new-instance v5, Ljava/io/FileOutputStream;

    invoke-direct {v5, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 118
    .local v5, "fOut":Ljava/io/FileOutputStream;
    const/16 v8, 0x400

    new-array v1, v8, [B

    .line 119
    .local v1, "buffer":[B
    const/4 v7, 0x0

    .line 120
    .local v7, "len":I
    :goto_0
    invoke-virtual {v6, v1}, Ljava/io/InputStream;->read([B)I

    move-result v7

    const/4 v8, -0x1

    if-ne v7, v8, :cond_0

    .line 123
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->flush()V

    .line 124
    invoke-virtual {v6}, Ljava/io/InputStream;->close()V

    .line 125
    invoke-virtual {v5}, Ljava/io/FileOutputStream;->close()V

    move-object v3, v4

    .line 130
    .end local v1    # "buffer":[B
    .end local v4    # "f":Ljava/io/File;
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v6    # "is":Ljava/io/InputStream;
    .end local v7    # "len":I
    .restart local v3    # "f":Ljava/io/File;
    :goto_1
    return-object v4

    .line 121
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

    .line 127
    .end local v1    # "buffer":[B
    .end local v5    # "fOut":Ljava/io/FileOutputStream;
    .end local v7    # "len":I
    :catch_0
    move-exception v2

    move-object v3, v4

    .line 128
    .end local v4    # "f":Ljava/io/File;
    .end local v6    # "is":Ljava/io/InputStream;
    .local v2, "e":Ljava/io/IOException;
    .restart local v3    # "f":Ljava/io/File;
    :goto_2
    invoke-virtual {v2}, Ljava/io/IOException;->printStackTrace()V

    .line 130
    const/4 v4, 0x0

    goto :goto_1

    .line 127
    .end local v2    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v2

    goto :goto_2
.end method

.method private installApk()V
    .locals 3

    .prologue
    .line 102
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 104
    .local v0, "aa":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->PRO_DIR:Ljava/io/File;

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

    .line 105
    const-string v2, "application/vnd.android.package-archive"

    .line 103
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 106
    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->startActivity(Landroid/content/Intent;)V

    .line 107
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 41
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 42
    const v0, 0x7f030064

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->setContentView(I)V

    .line 43
    const v0, 0x7f07025c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->kaiji_title:Landroid/widget/TextView;

    .line 44
    const v0, 0x7f070263

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->btn_cancel_kaiji:Landroid/widget/Button;

    .line 45
    const v0, 0x7f070264

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->btn_ok_kaiji:Landroid/widget/Button;

    .line 46
    const v0, 0x7f070261

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->kaiji_lala:Landroid/widget/TextView;

    .line 47
    const v0, 0x7f07025d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->kaiji_shijan:Landroid/widget/TextView;

    .line 48
    const v0, 0x7f070260

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->kaiji_message:Landroid/widget/TextView;

    .line 49
    const v0, 0x7f07025e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->iv_back_kaiji:Landroid/widget/ImageView;

    .line 51
    iget-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->kaiji_shijan:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    iget v2, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->kaijishijian:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "s"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 52
    iget-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->kaiji_message:Landroid/widget/TextView;

    .line 53
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Speed up by AIO Cleaner:<font color=\'#0AA3FA\'><b>"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 54
    iget v2, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->aiojiasu:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "s"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</b></font>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 53
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    .line 52
    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 55
    iget-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->iv_back_kaiji:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/cleaner/KaijishijianActivity$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/KaijishijianActivity$1;-><init>(Lcom/aio/downloader/cleaner/KaijishijianActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    iget-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->btn_cancel_kaiji:Landroid/widget/Button;

    new-instance v1, Lcom/aio/downloader/cleaner/KaijishijianActivity$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/KaijishijianActivity$2;-><init>(Lcom/aio/downloader/cleaner/KaijishijianActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 71
    iget-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->btn_ok_kaiji:Landroid/widget/Button;

    new-instance v1, Lcom/aio/downloader/cleaner/KaijishijianActivity$3;

    invoke-direct {v1, p0}, Lcom/aio/downloader/cleaner/KaijishijianActivity$3;-><init>(Lcom/aio/downloader/cleaner/KaijishijianActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 93
    iget-object v0, p0, Lcom/aio/downloader/cleaner/KaijishijianActivity;->kaiji_lala:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    .line 94
    const-string v2, "fonts/Roboto-Light.ttf"

    .line 93
    invoke-static {v1, v2}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 95
    invoke-direct {p0}, Lcom/aio/downloader/cleaner/KaijishijianActivity;->getAssetFile()Ljava/io/File;

    .line 96
    return-void
.end method
