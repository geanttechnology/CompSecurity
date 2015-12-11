.class public Lcom/aio/downloader/activity/ContentUsActivity;
.super Landroid/app/Activity;
.source "ContentUsActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;
    }
.end annotation


# static fields
.field private static typeFace:Landroid/graphics/Typeface;


# instance fields
.field private back:Landroid/widget/TextView;

.field private fan:Landroid/widget/ImageView;

.field private finishcha:Landroid/widget/ImageView;

.field private guanggao_url:Ljava/lang/String;

.field private guanggaowebview:Landroid/webkit/WebView;

.field private progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

.field private webviewclient:Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    sput-object v0, Lcom/aio/downloader/activity/ContentUsActivity;->typeFace:Landroid/graphics/Typeface;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 26
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 27
    iput-object v0, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggao_url:Ljava/lang/String;

    .line 33
    iput-object v0, p0, Lcom/aio/downloader/activity/ContentUsActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 26
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/ContentUsActivity;)Lcom/aio/downloader/utils/ProgressWheel;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/aio/downloader/activity/ContentUsActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    return-object v0
.end method

.method private bulidListenrn()V
    .locals 5

    .prologue
    .line 64
    iget-object v2, p0, Lcom/aio/downloader/activity/ContentUsActivity;->fan:Landroid/widget/ImageView;

    invoke-virtual {v2, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 65
    iget-object v2, p0, Lcom/aio/downloader/activity/ContentUsActivity;->finishcha:Landroid/widget/ImageView;

    invoke-virtual {v2, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 69
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggaowebview:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    sget-object v3, Lcom/aio/downloader/utils/Myutils;->setting_json:Lorg/json/JSONObject;

    const-string v4, "agent"

    invoke-virtual {v3, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 74
    :goto_0
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 75
    .local v1, "headers":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v2, "AIOD"

    const-string v3, "1"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    iget-object v2, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggaowebview:Landroid/webkit/WebView;

    iget-object v3, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggao_url:Ljava/lang/String;

    invoke-virtual {v2, v3, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;Ljava/util/Map;)V

    .line 78
    new-instance v2, Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;-><init>(Lcom/aio/downloader/activity/ContentUsActivity;)V

    iput-object v2, p0, Lcom/aio/downloader/activity/ContentUsActivity;->webviewclient:Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;

    .line 79
    iget-object v2, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggaowebview:Landroid/webkit/WebView;

    iget-object v3, p0, Lcom/aio/downloader/activity/ContentUsActivity;->webviewclient:Lcom/aio/downloader/activity/ContentUsActivity$Mywebview;

    invoke-virtual {v2, v3}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 81
    return-void

    .line 70
    .end local v1    # "headers":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Lorg/json/JSONException;
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_0
.end method

.method private init()V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled"
        }
    .end annotation

    .prologue
    .line 47
    const v1, 0x7f070072

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ContentUsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/utils/ProgressWheel;

    iput-object v1, p0, Lcom/aio/downloader/activity/ContentUsActivity;->progressWheel:Lcom/aio/downloader/utils/ProgressWheel;

    .line 48
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ContentUsActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string v2, "guanggao_url"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggao_url:Ljava/lang/String;

    .line 49
    const v1, 0x7f070150

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ContentUsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/webkit/WebView;

    iput-object v1, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggaowebview:Landroid/webkit/WebView;

    .line 50
    const v1, 0x7f07014e

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ContentUsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/ContentUsActivity;->fan:Landroid/widget/ImageView;

    .line 52
    const v1, 0x7f07014f

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ContentUsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/aio/downloader/activity/ContentUsActivity;->finishcha:Landroid/widget/ImageView;

    .line 53
    const v1, 0x7f070077

    invoke-virtual {p0, v1}, Lcom/aio/downloader/activity/ContentUsActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/aio/downloader/activity/ContentUsActivity;->back:Landroid/widget/TextView;

    .line 54
    sget-object v1, Lcom/aio/downloader/activity/ContentUsActivity;->typeFace:Landroid/graphics/Typeface;

    if-nez v1, :cond_0

    .line 55
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ContentUsActivity;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v1

    .line 56
    const-string v2, "font.ttf"

    .line 55
    invoke-static {v1, v2}, Landroid/graphics/Typeface;->createFromAsset(Landroid/content/res/AssetManager;Ljava/lang/String;)Landroid/graphics/Typeface;

    move-result-object v1

    sput-object v1, Lcom/aio/downloader/activity/ContentUsActivity;->typeFace:Landroid/graphics/Typeface;

    .line 58
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/activity/ContentUsActivity;->back:Landroid/widget/TextView;

    sget-object v2, Lcom/aio/downloader/activity/ContentUsActivity;->typeFace:Landroid/graphics/Typeface;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 59
    iget-object v1, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggaowebview:Landroid/webkit/WebView;

    invoke-virtual {v1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    .line 60
    .local v0, "settings":Landroid/webkit/WebSettings;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 61
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 85
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 102
    :goto_0
    return-void

    .line 87
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggaowebview:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Lcom/aio/downloader/activity/ContentUsActivity;->guanggaowebview:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->goBack()V

    goto :goto_0

    .line 92
    :cond_0
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ContentUsActivity;->finish()V

    goto :goto_0

    .line 97
    :pswitch_1
    invoke-virtual {p0}, Lcom/aio/downloader/activity/ContentUsActivity;->finish()V

    goto :goto_0

    .line 85
    :pswitch_data_0
    .packed-switch 0x7f07014e
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 37
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 38
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/ContentUsActivity;->requestWindowFeature(I)Z

    .line 39
    const v0, 0x7f03002a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/activity/ContentUsActivity;->setContentView(I)V

    .line 40
    invoke-direct {p0}, Lcom/aio/downloader/activity/ContentUsActivity;->init()V

    .line 41
    invoke-direct {p0}, Lcom/aio/downloader/activity/ContentUsActivity;->bulidListenrn()V

    .line 43
    return-void
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 145
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 146
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onPause(Landroid/content/Context;)V

    .line 147
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 138
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 139
    invoke-static {p0}, Lcom/umeng/analytics/MobclickAgent;->onResume(Landroid/content/Context;)V

    .line 140
    return-void
.end method
