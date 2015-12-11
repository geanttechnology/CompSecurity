.class public Lcom/aio/downloader/activity/ComingSongActivity;
.super Landroid/app/Activity;
.source "ComingSongActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static typeFace:Landroid/graphics/Typeface;


# instance fields
.field private appfan:Landroid/widget/ImageView;

.field private et_search_keywords:Landroid/widget/EditText;

.field private searchtitle:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const/4 v0, 0x0

    sput-object v0, Lcom/aio/downloader/activity/ComingSongActivity;->typeFace:Landroid/graphics/Typeface;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method

.method private buildListener()V
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/aio/downloader/activity/ComingSongActivity;->appfan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 53
    return-void
.end method

.method private init()V
    .locals 2

    .prologue
    .line 31
    const v0, 0x7f0700fd

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/ComingSongActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/ComingSongActivity;->appfan:Landroid/widget/ImageView;

    .line 32
    const v0, 0x7f07010e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/ComingSongActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/aio/downloader/activity/ComingSongActivity;->et_search_keywords:Landroid/widget/EditText;

    .line 33
    iget-object v0, p0, Lcom/aio/downloader/activity/ComingSongActivity;->et_search_keywords:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/aio/downloader/activity/ComingSongActivity;->searchtitle:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setHint(Ljava/lang/CharSequence;)V

    .line 35
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ComingSongActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "font.ttf"

    .line 34
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/activity/ComingSongActivity;->typeFace:Landroid/graphics/Typeface;

    .line 36
    iget-object v0, p0, Lcom/aio/downloader/activity/ComingSongActivity;->et_search_keywords:Landroid/widget/EditText;

    sget-object v1, Lcom/aio/downloader/activity/ComingSongActivity;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 37
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 42
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 48
    :goto_0
    return-void

    .line 44
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ComingSongActivity;->finish()V

    goto :goto_0

    .line 42
    :pswitch_data_0
    .packed-switch 0x7f0700fd
        :pswitch_0
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 23
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 24
    const v0, 0x7f030029

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/ComingSongActivity;->setContentView(I)V

    .line 25
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ComingSongActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "title"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/ComingSongActivity;->searchtitle:Ljava/lang/String;

    .line 26
    invoke-direct {p0}, Lcom/aio/downloader/activity/ComingSongActivity;->init()V

    .line 27
    invoke-direct {p0}, Lcom/aio/downloader/activity/ComingSongActivity;->buildListener()V

    .line 28
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 58
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 59
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 60
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 65
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 66
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 67
    return-void
.end method
