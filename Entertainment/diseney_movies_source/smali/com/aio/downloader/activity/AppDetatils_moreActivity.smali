.class public Lcom/aio/downloader/activity/AppDetatils_moreActivity;
.super Landroid/app/Activity;
.source "AppDetatils_moreActivity.java"


# instance fields
.field private iv_dea_back:Landroid/widget/ImageView;

.field private tv_dea_download:Landroid/widget/TextView;

.field private tv_dea_sheart:Landroid/widget/TextView;

.field private tv_dea_size:Landroid/widget/TextView;

.field private tv_dea_title:Landroid/widget/TextView;

.field private tv_dea_up:Landroid/widget/TextView;

.field private tv_dea_ver:Landroid/widget/TextView;

.field private tv_dea_zhengwen:Landroid/widget/TextView;

.field private typeFace:Landroid/graphics/Typeface;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 15
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->typeFace:Landroid/graphics/Typeface;

    .line 15
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 29
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 30
    const v3, 0x7f030079

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->setContentView(I)V

    .line 31
    const v3, 0x7f0702df

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_title:Landroid/widget/TextView;

    .line 32
    const v3, 0x7f0702de

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->iv_dea_back:Landroid/widget/ImageView;

    .line 33
    const v3, 0x7f0702e0

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_sheart:Landroid/widget/TextView;

    .line 34
    const v3, 0x7f0702e1

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_zhengwen:Landroid/widget/TextView;

    .line 35
    const v3, 0x7f0702e2

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_ver:Landroid/widget/TextView;

    .line 36
    const v3, 0x7f0702e4

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_up:Landroid/widget/TextView;

    .line 37
    const v3, 0x7f0702e3

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_download:Landroid/widget/TextView;

    .line 38
    const v3, 0x7f0702e5

    invoke-virtual {p0, v3}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_size:Landroid/widget/TextView;

    .line 39
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "dea_title"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 40
    .local v2, "dea_titile":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "dea_sheart"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 41
    .local v1, "dea_sheart":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "dea_dea"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 42
    .local v0, "dea_dea":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "dea_up"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    .line 43
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "dea_ver"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    .line 44
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "dea_down"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    .line 45
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "dea_size"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    .line 48
    :try_start_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v3

    .line 49
    const-string v4, "Roboto-Light.ttf"

    .line 47
    invoke-static {v3, v4}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v3

    iput-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->typeFace:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 53
    :goto_0
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_sheart:Landroid/widget/TextView;

    iget-object v4, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 54
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_title:Landroid/widget/TextView;

    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 55
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_sheart:Landroid/widget/TextView;

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 56
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_zhengwen:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 57
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_ver:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "dea_ver"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 58
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_up:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "dea_up"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 59
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_download:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    const-string v6, "dea_down"

    invoke-virtual {v5, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 60
    const-string v5, "downloads"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 59
    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 61
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->tv_dea_size:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string v5, "dea_size"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 62
    iget-object v3, p0, Lcom/aio/downloader/activity/AppDetatils_moreActivity;->iv_dea_back:Landroid/widget/ImageView;

    new-instance v4, Lcom/aio/downloader/activity/AppDetatils_moreActivity$1;

    invoke-direct {v4, p0}, Lcom/aio/downloader/activity/AppDetatils_moreActivity$1;-><init>(Lcom/aio/downloader/activity/AppDetatils_moreActivity;)V

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 70
    return-void

    .line 50
    :catch_0
    move-exception v3

    goto/16 :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 81
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 82
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 83
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 74
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 75
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 76
    return-void
.end method
