.class public Lcom/aio/downloader/activity/OpenActivity;
.super Landroid/app/Activity;
.source "OpenActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private getopenid:Ljava/lang/String;

.field private getopenimgpath:Ljava/lang/String;

.field private gettitle:Ljava/lang/String;

.field private openbtn:Landroid/widget/Button;

.field private openfinish:Landroid/widget/RelativeLayout;

.field private openimg:Landroid/widget/ImageView;

.field private opentitle:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private buindlistener()V
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/activity/OpenActivity;->openfinish:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    iget-object v0, p0, Lcom/aio/downloader/activity/OpenActivity;->openbtn:Landroid/widget/Button;

    invoke-virtual {v0, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    return-void
.end method

.method private init()V
    .locals 1

    .prologue
    .line 55
    const v0, 0x7f07034e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/OpenActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/activity/OpenActivity;->openfinish:Landroid/widget/RelativeLayout;

    .line 56
    const v0, 0x7f07034f

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/OpenActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/OpenActivity;->openimg:Landroid/widget/ImageView;

    .line 57
    const v0, 0x7f07031a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/OpenActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/OpenActivity;->opentitle:Landroid/widget/TextView;

    .line 58
    const v0, 0x7f070350

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/OpenActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/activity/OpenActivity;->openbtn:Landroid/widget/Button;

    .line 59
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 69
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 89
    :goto_0
    :pswitch_0
    const-string v1, ""

    sput-object v1, Lcom/aio/downloader/utils/publicTools;->openid:Ljava/lang/String;

    .line 90
    return-void

    .line 72
    :pswitch_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/OpenActivity;->finish()V

    goto :goto_0

    .line 78
    :pswitch_2
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/OpenActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 79
    iget-object v2, p0, Lcom/aio/downloader/activity/OpenActivity;->getopenid:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 80
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/OpenActivity;->startActivity(Landroid/content/Intent;)V

    .line 82
    invoke-virtual {p0}, Lcom/aio/downloader/activity/OpenActivity;->finish()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 83
    .end local v0    # "intent":Landroid/content/Intent;
    :catch_0
    move-exception v1

    goto :goto_0

    .line 69
    nop

    :pswitch_data_0
    .packed-switch 0x7f07034e
        :pswitch_1
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 36
    const v1, 0x7f030097

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/OpenActivity;->setContentView(I)V

    .line 38
    sget-object v1, Lcom/aio/downloader/utils/publicTools;->openimgpath:Ljava/lang/String;

    iput-object v1, p0, Lcom/aio/downloader/activity/OpenActivity;->getopenimgpath:Ljava/lang/String;

    .line 39
    sget-object v1, Lcom/aio/downloader/utils/publicTools;->openid:Ljava/lang/String;

    iput-object v1, p0, Lcom/aio/downloader/activity/OpenActivity;->getopenid:Ljava/lang/String;

    .line 40
    sget-object v1, Lcom/aio/downloader/utils/publicTools;->opentitle:Ljava/lang/String;

    iput-object v1, p0, Lcom/aio/downloader/activity/OpenActivity;->gettitle:Ljava/lang/String;

    .line 42
    invoke-direct {p0}, Lcom/aio/downloader/activity/OpenActivity;->init()V

    .line 43
    invoke-direct {p0}, Lcom/aio/downloader/activity/OpenActivity;->buindlistener()V

    .line 45
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 46
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "com.ywh.imgcache"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 47
    const-string v2, "allicon"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "com.ywh.imgcache"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 48
    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "allicon"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 49
    iget-object v2, p0, Lcom/aio/downloader/activity/OpenActivity;->getopenimgpath:Ljava/lang/String;

    invoke-static {v2}, Lcom/aio/downloader/utils/MD5;->enlode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 45
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 50
    .local v0, "path":Ljava/lang/String;
    iget-object v1, p0, Lcom/aio/downloader/activity/OpenActivity;->opentitle:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/aio/downloader/activity/OpenActivity;->gettitle:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 51
    iget-object v1, p0, Lcom/aio/downloader/activity/OpenActivity;->openimg:Landroid/widget/ImageView;

    invoke-static {v0}, Lcom/aio/downloader/utils/Myutils;->getImage(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 52
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 97
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 99
    const-string v0, ""

    sput-object v0, Lcom/aio/downloader/utils/publicTools;->openid:Ljava/lang/String;

    .line 101
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method
