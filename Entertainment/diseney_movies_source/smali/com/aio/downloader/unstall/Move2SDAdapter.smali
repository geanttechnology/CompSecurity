.class public Lcom/aio/downloader/unstall/Move2SDAdapter;
.super Landroid/widget/BaseAdapter;
.source "Move2SDAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;
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
    const/4 v0, 0x0

    .line 32
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 30
    iput-object v0, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->typeFace:Landroid/graphics/Typeface;

    iput-object v0, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->typeFace2:Landroid/graphics/Typeface;

    .line 33
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->inflate:Landroid/view/LayoutInflater;

    .line 34
    iput-object p2, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->infos:Ljava/util/List;

    .line 35
    iput-object p1, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->context:Landroid/content/Context;

    .line 37
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 38
    const-string v1, "Roboto-Light.ttf"

    .line 37
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->typeFace:Landroid/graphics/Typeface;

    .line 39
    invoke-virtual {p1}, Landroid/content/Context;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 40
    const-string v1, "Roboto-Condensed.ttf"

    .line 39
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->typeFace2:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 43
    :goto_0
    return-void

    .line 41
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/unstall/Move2SDAdapter;)Ljava/util/List;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->infos:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/unstall/Move2SDAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->context:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->infos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 48
    iget-object v0, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->infos:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 60
    add-int/lit8 v0, p1, 0x1

    int-to-long v0, v0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 67
    const/4 v4, 0x0

    .line 68
    .local v4, "holder":Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;
    if-nez p2, :cond_0

    .line 69
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->inflate:Landroid/view/LayoutInflater;

    const v8, 0x7f0300b7

    const/4 v9, 0x0

    invoke-virtual {v7, v8, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 70
    new-instance v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;

    .end local v4    # "holder":Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;
    invoke-direct {v4, p0}, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;-><init>(Lcom/aio/downloader/unstall/Move2SDAdapter;)V

    .line 71
    .restart local v4    # "holder":Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;
    const v7, 0x7f0703de

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    iput-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->name:Landroid/widget/TextView;

    .line 72
    const v7, 0x7f0702bc

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ImageView;

    iput-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->icon:Landroid/widget/ImageView;

    .line 74
    const v7, 0x7f0703e2

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 73
    iput-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall:Landroid/widget/TextView;

    .line 76
    const v7, 0x7f0703e0

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 75
    iput-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall_size:Landroid/widget/TextView;

    .line 78
    const v7, 0x7f0703df

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 77
    iput-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall_version:Landroid/widget/TextView;

    .line 79
    const v7, 0x7f0702f8

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    iput-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->view_up:Landroid/view/View;

    .line 80
    invoke-virtual {p2, v4}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 85
    :goto_0
    if-nez p1, :cond_1

    .line 86
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->view_up:Landroid/view/View;

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Landroid/view/View;->setVisibility(I)V

    .line 91
    :goto_1
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->name:Landroid/widget/TextView;

    iget-object v8, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 92
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall_size:Landroid/widget/TextView;

    iget-object v8, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 93
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall_version:Landroid/widget/TextView;

    iget-object v8, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->typeFace2:Landroid/graphics/Typeface;

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 95
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall:Landroid/widget/TextView;

    const-string v8, "Move2SD"

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 96
    iget-object v8, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->name:Landroid/widget/TextView;

    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->infos:Ljava/util/List;

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v7}, Lcom/aio/downloader/unstall/Info;->getName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 97
    iget-object v8, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->icon:Landroid/widget/ImageView;

    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->infos:Ljava/util/List;

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v7}, Lcom/aio/downloader/unstall/Info;->getIcon()Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v8, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 98
    new-instance v0, Lcom/aio/downloader/utils/MyAppInfo;

    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->context:Landroid/content/Context;

    invoke-direct {v0, v7}, Lcom/aio/downloader/utils/MyAppInfo;-><init>(Landroid/content/Context;)V

    .line 100
    .local v0, "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    const/4 v6, 0x0

    .line 102
    .local v6, "pI":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->context:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    .line 103
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->infos:Ljava/util/List;

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/unstall/Info;

    invoke-virtual {v7}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v7

    const/4 v9, 0x0

    .line 102
    invoke-virtual {v8, v7, v9}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v6

    .line 104
    new-instance v7, Ljava/io/File;

    iget-object v8, v6, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v8, v8, Landroid/content/pm/ApplicationInfo;->publicSourceDir:Ljava/lang/String;

    invoke-direct {v7, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 105
    invoke-virtual {v7}, Ljava/io/File;->length()J

    move-result-wide v7

    const-wide/16 v9, 0x400

    .line 104
    div-long v1, v7, v9

    .line 106
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

    .line 107
    .local v5, "lastSize":F
    const-wide/16 v7, 0x400

    cmp-long v7, v1, v7

    if-ltz v7, :cond_2

    .line 108
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall_size:Landroid/widget/TextView;

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

    .line 117
    .end local v1    # "appSize":J
    .end local v5    # "lastSize":F
    :goto_2
    :try_start_1
    iget-object v7, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->infos:Ljava/util/List;

    invoke-interface {v7, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/aio/downloader/unstall/Info;

    .line 118
    invoke-virtual {v7}, Lcom/aio/downloader/unstall/Info;->getPackagename()Ljava/lang/String;

    move-result-object v7

    .line 117
    invoke-virtual {v0, v7}, Lcom/aio/downloader/utils/MyAppInfo;->getAppVersion(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->appVersion:Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 124
    :goto_3
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall_version:Landroid/widget/TextView;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "Version:"

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/aio/downloader/unstall/Move2SDAdapter;->appVersion:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 126
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall:Landroid/widget/TextView;

    new-instance v8, Lcom/aio/downloader/unstall/Move2SDAdapter$1;

    invoke-direct {v8, p0, p1}, Lcom/aio/downloader/unstall/Move2SDAdapter$1;-><init>(Lcom/aio/downloader/unstall/Move2SDAdapter;I)V

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    return-object p2

    .line 82
    .end local v0    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .end local v6    # "pI":Landroid/content/pm/PackageInfo;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v4

    .end local v4    # "holder":Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;
    check-cast v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;

    .restart local v4    # "holder":Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;
    goto/16 :goto_0

    .line 88
    :cond_1
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->view_up:Landroid/view/View;

    const/16 v8, 0x8

    invoke-virtual {v7, v8}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_1

    .line 110
    .restart local v0    # "appInfo":Lcom/aio/downloader/utils/MyAppInfo;
    .restart local v1    # "appSize":J
    .restart local v5    # "lastSize":F
    .restart local v6    # "pI":Landroid/content/pm/PackageInfo;
    :cond_2
    :try_start_2
    iget-object v7, v4, Lcom/aio/downloader/unstall/Move2SDAdapter$ViewHold;->tv_uninstall_size:Landroid/widget/TextView;

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

    .line 112
    .end local v1    # "appSize":J
    .end local v5    # "lastSize":F
    :catch_0
    move-exception v3

    .line 113
    .local v3, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    invoke-virtual {v3}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V

    goto :goto_2

    .line 120
    .end local v3    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_1
    move-exception v3

    .line 122
    .local v3, "e":Ljava/lang/Exception;
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3
.end method
