.class public Lco/vine/android/WebViewActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "WebViewActivity.java"


# static fields
.field public static final EXTRA_TYPE:Ljava/lang/String; = "type"

.field public static final TYPE_ATTRIBUTION:I = 0x5

.field public static final TYPE_PRIVACY_POLICY_TWITTER:I = 0x3

.field public static final TYPE_PRIVACY_POLICY_VINE:I = 0x1

.field public static final TYPE_TOS_TWITTER:I = 0x4

.field public static final TYPE_TOS_VINE:I = 0x2


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method public static start(Landroid/content/Context;Landroid/net/Uri;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "data"    # Landroid/net/Uri;

    .prologue
    .line 111
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/WebViewActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, p1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 112
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 35
    const v5, 0x7f0300a9

    const/4 v6, 0x0

    invoke-super {p0, p1, v5, v6}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 37
    const v5, 0x7f0a00e1

    invoke-virtual {p0, v5}, Lco/vine/android/WebViewActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/webkit/WebView;

    .line 38
    .local v4, "webView":Landroid/webkit/WebView;
    new-instance v5, Landroid/webkit/WebViewClient;

    invoke-direct {v5}, Landroid/webkit/WebViewClient;-><init>()V

    invoke-virtual {v4, v5}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 39
    invoke-virtual {v4}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v5

    invoke-virtual {v5, v7}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 40
    invoke-virtual {p0}, Lco/vine/android/WebViewActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 41
    .local v0, "b":Landroid/os/Bundle;
    if-eqz v0, :cond_3

    .line 42
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2, v7}, Ljava/util/HashMap;-><init>(I)V

    .line 43
    .local v2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v3

    .line 44
    .local v3, "language":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 45
    const-string v5, "Accept-Language"

    invoke-interface {v2, v5, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    const-string v5, "X-Vine-Client"

    invoke-static {p0}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v6

    invoke-virtual {v6}, Lco/vine/android/client/VineAPI;->getVineClientHeader()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v2, v5, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    :cond_0
    const-string v5, "type"

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v5

    packed-switch v5, :pswitch_data_0

    .line 86
    .end local v2    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "language":Ljava/lang/String;
    :cond_1
    :goto_0
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {p0, v5, v8, v8, v8}, Lco/vine/android/WebViewActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 88
    return-void

    .line 51
    .restart local v2    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v3    # "language":Ljava/lang/String;
    :pswitch_0
    const v5, 0x7f0e018c

    invoke-virtual {p0, v5}, Lco/vine/android/WebViewActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 55
    :pswitch_1
    const v5, 0x7f0e024e

    invoke-virtual {p0, v5}, Lco/vine/android/WebViewActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 59
    :pswitch_2
    const v5, 0x7f0e018b

    invoke-virtual {p0, v5}, Lco/vine/android/WebViewActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 63
    :pswitch_3
    const v5, 0x7f0e024d

    invoke-virtual {p0, v5}, Lco/vine/android/WebViewActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 67
    :pswitch_4
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isAStar()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 69
    const-string v5, "file:///android_asset/astar_attribution.html"

    invoke-virtual {v4, v5}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0

    .line 71
    :cond_2
    const v5, 0x7f0e0050

    invoke-virtual {p0, v5}, Lco/vine/android/WebViewActivity;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0

    .line 80
    .end local v2    # "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "language":Ljava/lang/String;
    :cond_3
    invoke-virtual {p0}, Lco/vine/android/WebViewActivity;->getIntent()Landroid/content/Intent;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    .line 81
    .local v1, "data":Landroid/net/Uri;
    if-eqz v1, :cond_1

    .line 82
    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0

    .line 49
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v2, 0x1

    .line 92
    invoke-virtual {p0}, Lco/vine/android/WebViewActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    const v1, 0x7f100004

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 93
    const v0, 0x7f0a0245

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v2}, Landroid/view/MenuItem;->setEnabled(Z)Landroid/view/MenuItem;

    .line 94
    return v2
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 99
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 105
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerActionBarActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 101
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/WebViewActivity;->finish()V

    .line 102
    const/4 v0, 0x1

    goto :goto_0

    .line 99
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a0245
        :pswitch_0
    .end packed-switch
.end method
