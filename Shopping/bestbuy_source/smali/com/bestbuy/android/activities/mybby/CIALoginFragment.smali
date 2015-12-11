.class public Lcom/bestbuy/android/activities/mybby/CIALoginFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# static fields
.field public static a:Z


# instance fields
.field b:Landroid/webkit/WebViewClient;

.field c:Landroid/webkit/WebChromeClient;

.field private g:Landroid/view/View;

.field private h:Lcm;

.field private i:Ljava/lang/String;

.field private j:Landroid/widget/ImageView;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Landroid/webkit/CookieManager;

.field private n:Landroid/webkit/WebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const/4 v0, 0x0

    sput-boolean v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 147
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 50
    new-instance v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$1;-><init>(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->b:Landroid/webkit/WebViewClient;

    .line 124
    new-instance v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$2;-><init>(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->c:Landroid/webkit/WebChromeClient;

    .line 149
    return-void
.end method

.method public static synthetic a(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->g:Landroid/view/View;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->k:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Lcm;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->h:Lcm;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->l:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->k:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->l:Ljava/lang/String;

    return-object v0
.end method

.method public static synthetic e(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/webkit/WebView;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V
    .locals 4

    .prologue
    .line 340
    if-eqz p1, :cond_0

    .line 342
    :try_start_0
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getRefreshToken()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->i:Ljava/lang/String;

    .line 343
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getUsername()Ljava/lang/String;

    move-result-object v0

    .line 344
    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->d(Ljava/lang/String;)V

    .line 345
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->i:Ljava/lang/String;

    const v1, 0x7f080068

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->i:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 347
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 348
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 349
    const-string v2, "bb.rzTier"

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getRzTierStatus()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 350
    sget-object v0, Llu;->c:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 355
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->g()Ljava/lang/String;

    move-result-object v0

    .line 356
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a(Ljava/lang/String;)V

    .line 357
    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 358
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 364
    :cond_0
    :goto_0
    return-void

    .line 360
    :catch_0
    move-exception v0

    .line 361
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 308
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    invoke-static {v0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 309
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    .line 310
    invoke-static {}, Lgw;->a()Lorg/apache/http/impl/client/DefaultHttpClient;

    move-result-object v0

    .line 311
    invoke-virtual {v0}, Lorg/apache/http/impl/client/DefaultHttpClient;->getCookieStore()Lorg/apache/http/client/CookieStore;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/client/CookieStore;->getCookies()Ljava/util/List;

    move-result-object v0

    .line 312
    if-eqz v0, :cond_1

    .line 313
    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 314
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v2

    .line 315
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    .line 317
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "; Domain="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getDomain()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 318
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v0

    const-string v5, "bby_rdp"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 319
    invoke-virtual {v2, p1, v4}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 321
    :cond_0
    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 334
    :catch_0
    move-exception v0

    .line 335
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 337
    :goto_1
    return-void

    .line 325
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->m:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->L()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 326
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->m:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->M()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 327
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->m:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->N()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 328
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->m:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->O()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 329
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 330
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->m:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->J()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 331
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->m:Landroid/webkit/CookieManager;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->K()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 333
    :cond_2
    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    return v0
.end method

.method public c()V
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->goBack()V

    .line 304
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 193
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 194
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 153
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 154
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    .line 155
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 159
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 160
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 161
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 164
    const v0, 0x7f030021

    invoke-virtual {p1, v0, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 165
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->g:Landroid/view/View;

    .line 166
    const v0, 0x7f0c00a2

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    .line 167
    new-instance v0, Lcm;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, p0, v2}, Lcm;-><init>(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->h:Lcm;

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->h:Lcm;

    const-string v3, "CIAJavaScriptInterface"

    invoke-virtual {v0, v2, v3}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 171
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->b:Landroid/webkit/WebViewClient;

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->c:Landroid/webkit/WebChromeClient;

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 174
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->m:Landroid/webkit/CookieManager;

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->m:Landroid/webkit/CookieManager;

    invoke-virtual {v0, v4}, Landroid/webkit/CookieManager;->setAcceptCookie(Z)V

    .line 176
    invoke-static {v4}, Landroid/webkit/CookieManager;->setAcceptFileSchemeCookies(Z)V

    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->n:Landroid/webkit/WebView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->h()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 179
    const v0, 0x7f0c00a1

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->j:Landroid/widget/ImageView;

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->j:Landroid/widget/ImageView;

    new-instance v2, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$3;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment$3;-><init>(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 188
    return-object v1
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 198
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 199
    return-void
.end method
