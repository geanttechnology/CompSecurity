.class public Lcom/aio/downloader/activity/MiniGamePlayActivity;
.super Landroid/app/Activity;
.source "MiniGamePlayActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;
    }
.end annotation


# static fields
.field private static typeFace:Landroid/graphics/Typeface;


# instance fields
.field private adView:Lcom/google/ads/AdView;

.field private appbanner:Landroid/widget/LinearLayout;

.field private banner_type_name:Ljava/lang/String;

.field private detailfan:Landroid/widget/ImageView;

.field private gameplaywebview:Landroid/webkit/WebView;

.field private gamereload:Landroid/widget/ImageView;

.field private getproc:Ljava/lang/String;

.field private net_hint_img_pdt:Landroid/widget/ImageView;

.field private playbacktv:Landroid/widget/TextView;

.field private player:Lcom/aio/downloader/utils/Player;

.field private playurl:Ljava/lang/String;

.field private proc:Ljava/lang/String;

.field private progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private sound:Ljava/lang/String;

.field private sp_config:Landroid/content/SharedPreferences;

.field private webviewclient:Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 45
    const/4 v0, 0x0

    sput-object v0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->typeFace:Landroid/graphics/Typeface;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 40
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->playurl:Ljava/lang/String;

    .line 41
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->proc:Ljava/lang/String;

    .line 42
    const-string v0, ""

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->sound:Ljava/lang/String;

    .line 51
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->sp_config:Landroid/content/SharedPreferences;

    .line 34
    return-void
.end method

.method private ApppopulistViewbottom()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 150
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;

    .line 151
    invoke-virtual {v1}, Landroid/webkit/WebView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 150
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 154
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/high16 v1, 0x42480000    # 50.0f

    invoke-static {p0, v1}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    .line 153
    invoke-virtual {v0, v2, v2, v2, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 155
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 157
    return-void
.end method

.method private ApppopulistViewbottom2()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 160
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;

    .line 161
    invoke-virtual {v1}, Landroid/webkit/WebView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 160
    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 164
    .local v0, "linearParams":Landroid/widget/RelativeLayout$LayoutParams;
    const/4 v1, 0x0

    invoke-static {p0, v1}, Lcom/aio/downloader/utils/DisplayUtil;->dip2px(Landroid/content/Context;F)I

    move-result v1

    .line 163
    invoke-virtual {v0, v2, v2, v2, v1}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 165
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 167
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->net_hint_img_pdt:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Landroid/webkit/WebView;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;

    return-object v0
.end method

.method static synthetic access$3(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->sound:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$4(Lcom/aio/downloader/activity/MiniGamePlayActivity;)Lcom/aio/downloader/utils/Player;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->player:Lcom/aio/downloader/utils/Player;

    return-object v0
.end method

.method private buildListener()V
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->detailfan:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 147
    return-void
.end method

.method private init()V
    .locals 3

    .prologue
    .line 120
    const v0, 0x7f0702d7

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gamereload:Landroid/widget/ImageView;

    .line 121
    const v0, 0x7f070098

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->detailfan:Landroid/widget/ImageView;

    .line 122
    const v0, 0x7f0702da

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->net_hint_img_pdt:Landroid/widget/ImageView;

    .line 123
    const v0, 0x7f0702d6

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->playbacktv:Landroid/widget/TextView;

    .line 124
    const v0, 0x7f0702d9

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;

    .line 125
    const v0, 0x7f070072

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->progress_wheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 126
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "playurl"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->playurl:Ljava/lang/String;

    .line 128
    const-string v0, "tyty"

    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->playurl:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "***"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 130
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "proc"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->proc:Ljava/lang/String;

    .line 131
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "sound"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->sound:Ljava/lang/String;

    .line 133
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    const-string v1, "font.ttf"

    .line 132
    invoke-static {v0, v1}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->typeFace:Landroid/graphics/Typeface;

    .line 134
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->playbacktv:Landroid/widget/TextView;

    sget-object v1, Lcom/aio/downloader/activity/MiniGamePlayActivity;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 136
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gamereload:Landroid/widget/ImageView;

    new-instance v1, Lcom/aio/downloader/activity/MiniGamePlayActivity$2;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity$2;-><init>(Lcom/aio/downloader/activity/MiniGamePlayActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 217
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 224
    :goto_0
    return-void

    .line 219
    :pswitch_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->finish()V

    goto :goto_0

    .line 217
    :pswitch_data_0
    .packed-switch 0x7f070098
        :pswitch_0
    .end packed-switch
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 2
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 105
    invoke-super {p0, p1}, Landroid/app/Activity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 108
    iget v0, p1, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 109
    const-string v0, "trtr"

    const-string v1, "\u6a2a\u5c4f"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 110
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->appbanner:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 111
    invoke-direct {p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->ApppopulistViewbottom2()V

    .line 117
    :cond_0
    :goto_0
    return-void

    .line 113
    :cond_1
    iget v0, p1, Landroid/content/res/Configuration;->orientation:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 114
    iget-object v0, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->appbanner:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 115
    invoke-direct {p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->ApppopulistViewbottom()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled"
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 58
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 59
    const v1, 0x7f030077

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->setContentView(I)V

    .line 60
    invoke-direct {p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->init()V

    .line 61
    invoke-direct {p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->buildListener()V

    .line 64
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->proc:Ljava/lang/String;

    invoke-static {v1}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->getproc:Ljava/lang/String;

    .line 65
    const-string v1, "getproc"

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->getproc:Ljava/lang/String;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "///"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 66
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 67
    .local v0, "settings":Landroid/webkit/WebSettings;
    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 68
    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setCacheMode(I)V

    .line 69
    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setAppCacheEnabled(Z)V

    .line 71
    new-instance v1, Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;

    invoke-direct {v1, p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;-><init>(Lcom/aio/downloader/activity/MiniGamePlayActivity;)V

    iput-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->webviewclient:Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;

    .line 72
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->webviewclient:Lcom/aio/downloader/activity/MiniGamePlayActivity$Mywebview;

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 73
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->gameplaywebview:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->playurl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 75
    :try_start_0
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/aio/downloader/activity/MiniGamePlayActivity$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/MiniGamePlayActivity$1;-><init>(Lcom/aio/downloader/activity/MiniGamePlayActivity;)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 85
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 90
    :goto_0
    const v1, 0x7f070059

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->appbanner:Landroid/widget/LinearLayout;

    .line 91
    const-string v1, "banner_type"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/aio/downloader/activity/MiniGamePlayActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->sp_config:Landroid/content/SharedPreferences;

    .line 93
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->sp_config:Landroid/content/SharedPreferences;

    const-string v2, "banner_type"

    const-string v3, "admob"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->banner_type_name:Ljava/lang/String;

    .line 94
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->banner_type_name:Ljava/lang/String;

    const-string v2, "admob"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 95
    new-instance v1, Lcom/google/ads/AdView;

    sget-object v2, Lcom/google/ads/AdSize;->SMART_BANNER:Lcom/google/ads/AdSize;

    .line 96
    const-string v3, "ca-app-pub-2192624499353475/5842010949"

    invoke-direct {v1, p0, v2, v3}, Lcom/google/ads/AdView;-><init>(Landroid/app/Activity;Lcom/google/ads/AdSize;Ljava/lang/String;)V

    .line 95
    iput-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->adView:Lcom/google/ads/AdView;

    .line 97
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->appbanner:Landroid/widget/LinearLayout;

    iget-object v2, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->adView:Lcom/google/ads/AdView;

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 98
    iget-object v1, p0, Lcom/aio/downloader/activity/MiniGamePlayActivity;->adView:Lcom/google/ads/AdView;

    new-instance v2, Lcom/google/ads/AdRequest;

    invoke-direct {v2}, Lcom/google/ads/AdRequest;-><init>()V

    invoke-virtual {v1, v2}, Lcom/google/ads/AdView;->loadAd(Lcom/google/ads/AdRequest;)V

    .line 101
    :cond_0
    return-void

    .line 86
    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 236
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 237
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 238
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 229
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 230
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 231
    return-void
.end method
