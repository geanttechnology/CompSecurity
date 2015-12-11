.class public Lnu;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field public static a:Z


# instance fields
.field b:Landroid/os/Handler;

.field private c:Ljava/lang/String;

.field private d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

.field private e:Landroid/content/Context;

.field private f:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    sput-boolean v0, Lnu;->a:Z

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const-class v0, Lnu;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lnu;->c:Ljava/lang/String;

    .line 31
    const/4 v0, 0x0

    iput-boolean v0, p0, Lnu;->f:Z

    .line 232
    new-instance v0, Lnu$5;

    invoke-direct {v0, p0}, Lnu$5;-><init>(Lnu;)V

    iput-object v0, p0, Lnu;->b:Landroid/os/Handler;

    .line 44
    iput-object p2, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    .line 45
    iput-object p1, p0, Lnu;->e:Landroid/content/Context;

    .line 46
    iput-boolean p3, p0, Lnu;->f:Z

    .line 47
    return-void
.end method

.method static synthetic a(Lnu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    return-object v0
.end method

.method static synthetic b(Lnu;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lnu;->e:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 209
    const-string v0, ""

    .line 210
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    .line 211
    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 212
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v1

    .line 213
    invoke-virtual {v1, p1}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 214
    if-eqz v1, :cond_0

    .line 215
    const-string v3, ";"

    invoke-virtual {v1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 216
    if-eqz v3, :cond_0

    .line 217
    array-length v4, v3

    move v1, v2

    :goto_0
    if-ge v1, v4, :cond_0

    aget-object v5, v3, v1

    .line 218
    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 219
    array-length v6, v5

    const/4 v7, 0x2

    if-lt v6, v7, :cond_1

    .line 220
    aget-object v6, v5, v2

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    .line 221
    invoke-virtual {v6, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 222
    const/4 v0, 0x1

    aget-object v0, v5, v0

    .line 229
    :cond_0
    return-object v0

    .line 217
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public eventBusCallback(Ljava/lang/String;)V
    .locals 5
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 82
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 83
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->G()Z

    move-result v1

    if-nez v1, :cond_0

    .line 84
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iget-object v2, p0, Lnu;->e:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080031

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 85
    if-nez v0, :cond_2

    .line 86
    sget-boolean v0, Lnu;->a:Z

    if-eqz v0, :cond_1

    .line 87
    iget-object v0, p0, Lnu;->b:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 94
    :cond_0
    :goto_0
    return-void

    .line 89
    :cond_1
    iget-object v0, p0, Lnu;->b:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_0

    .line 91
    :cond_2
    iget-object v0, p0, Lnu;->b:Landroid/os/Handler;

    invoke-virtual {v0, v4}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    goto :goto_0
.end method

.method public eventBusRegister()V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const v1, 0x7f080195

    iget-object v2, p0, Lnu;->e:Landroid/content/Context;

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 72
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const v1, 0x7f0800ed

    iget-object v2, p0, Lnu;->e:Landroid/content/Context;

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 73
    return-void
.end method

.method public executeErrorContent()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 122
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    new-instance v1, Lnu$2;

    invoke-direct {v1, p0}, Lnu$2;-><init>(Lnu;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->post(Ljava/lang/Runnable;)Z

    .line 133
    return-void
.end method

.method public executeHtmlContent()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 106
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    new-instance v1, Lnu$1;

    invoke-direct {v1, p0}, Lnu$1;-><init>(Lnu;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->post(Ljava/lang/Runnable;)Z

    .line 118
    return-void
.end method

.method public executeMainCSS()V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 51
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const v1, 0x7f08021e

    iget-object v2, p0, Lnu;->e:Landroid/content/Context;

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 52
    return-void
.end method

.method public goBack()V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 66
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const v1, 0x7f0801cd

    iget-object v2, p0, Lnu;->e:Landroid/content/Context;

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 67
    return-void
.end method

.method public orderEventBusCallback(Ljava/lang/String;)V
    .locals 1
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 98
    const-string v0, "thank"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 99
    const/4 v0, 0x1

    sput-boolean v0, Lnu;->a:Z

    .line 101
    :cond_0
    return-void
.end method

.method public orderEventBusRegister()V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 77
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const v1, 0x7f080360

    iget-object v2, p0, Lnu;->e:Landroid/content/Context;

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 78
    return-void
.end method

.method public orderStatusCSS()V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 56
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const v1, 0x7f080294

    iget-object v2, p0, Lnu;->e:Landroid/content/Context;

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 57
    return-void
.end method

.method public processHTML(Ljava/lang/String;)V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 137
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    new-instance v1, Lnu$3;

    invoke-direct {v1, p0, p1}, Lnu$3;-><init>(Lnu;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->post(Ljava/lang/Runnable;)Z

    .line 147
    :cond_0
    return-void
.end method

.method public processHTMLError(Ljava/lang/String;)V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 151
    const-string v0, "BBYWebViewJavaScriptInterface"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "The error content is "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 152
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    .line 153
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    new-instance v1, Lnu$4;

    invoke-direct {v1, p0, p1}, Lnu$4;-><init>(Lnu;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->post(Ljava/lang/Runnable;)Z

    .line 161
    :cond_0
    return-void
.end method

.method public thankYouPage()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 165
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const-string v1, "javascript:(function() { document.getElementsByClassName(\'addressBlock\')[0].getElementsByTagName(\'a\')[0].removeAttribute(\'href\');document.getElementsByClassName(\'addressBlock\')[0].getElementsByTagName(\'a\')[0].setAttribute(\'style\', \'color:#000000!important\');document.getElementsByClassName(\'addressBlock\')[2].getElementsByTagName(\'a\')[0].removeAttribute(\'href\');document.getElementsByClassName(\'addressBlock\')[2].getElementsByTagName(\'a\')[0].setAttribute(\'style\', \'color:#000000!important\');document.getElementsByClassName(\'addressBlock\')[2].getElementsByTagName(\'a\')[1].removeAttribute(\'href\');document.getElementsByClassName(\'addressBlock\')[2].getElementsByTagName(\'a\')[1].setAttribute(\'style\', \'color:#000000!important\');})()"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 179
    return-void
.end method

.method public updateCartBadge()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 200
    iget-object v0, p0, Lnu;->b:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 201
    return-void
.end method

.method public updateCartBadgeAndShowCart()V
    .locals 2
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 205
    iget-object v0, p0, Lnu;->b:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 206
    return-void
.end method

.method public updateCartCount(Ljava/lang/String;)V
    .locals 4
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 183
    const/4 v0, 0x0

    .line 184
    const-string v1, "CartItemCount"

    invoke-virtual {p0, p1, v1}, Lnu;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 186
    if-eqz v1, :cond_0

    :try_start_0
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 187
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 188
    :cond_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iget-object v2, p0, Lnu;->e:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080031

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 189
    if-nez v0, :cond_1

    .line 190
    iget-object v0, p0, Lnu;->b:Landroid/os/Handler;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z

    .line 196
    :goto_0
    return-void

    .line 192
    :cond_1
    iget-object v0, p0, Lnu;->b:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendEmptyMessage(I)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 193
    :catch_0
    move-exception v0

    .line 194
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public weeklyAdCSS()V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 61
    iget-object v0, p0, Lnu;->d:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    const v1, 0x7f080385

    iget-object v2, p0, Lnu;->e:Landroid/content/Context;

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 62
    return-void
.end method
