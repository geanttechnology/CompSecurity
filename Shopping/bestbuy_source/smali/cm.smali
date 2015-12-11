.class public Lcm;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 206
    iput-object p1, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 207
    iput-object p2, p0, Lcm;->b:Landroid/content/Context;

    .line 208
    return-void
.end method


# virtual methods
.method public a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 8

    .prologue
    const/4 v2, 0x0

    .line 262
    const-string v0, ""

    .line 263
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    .line 264
    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 265
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v1

    .line 266
    invoke-virtual {v1, p1}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 267
    if-eqz v1, :cond_0

    .line 268
    const-string v3, ";"

    invoke-virtual {v1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 269
    if-eqz v3, :cond_0

    .line 270
    array-length v4, v3

    move v1, v2

    :goto_0
    if-ge v1, v4, :cond_0

    aget-object v5, v3, v1

    .line 271
    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 272
    array-length v6, v5

    const/4 v7, 0x2

    if-lt v6, v7, :cond_1

    .line 273
    aget-object v6, v5, v2

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    .line 274
    invoke-virtual {v6, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 275
    const/4 v0, 0x1

    aget-object v0, v5, v0

    .line 282
    :cond_0
    return-object v0

    .line 270
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method public eventBusCallback(Ljava/lang/String;)V
    .locals 4
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 287
    const/4 v0, 0x0

    .line 288
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 289
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 290
    :cond_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iget-object v2, p0, Lcm;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080031

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 291
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 292
    iget-object v1, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const/4 v2, -0x1

    invoke-virtual {v1, v2, v0}, Landroid/app/Activity;->setResult(ILandroid/content/Intent;)V

    .line 293
    iget-object v0, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 294
    iget-object v0, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f040005

    const v2, 0x7f040008

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 295
    return-void
.end method

.method public eventBusRegister()V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 212
    iget-object v0, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->e(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/webkit/WebView;

    move-result-object v0

    const v1, 0x7f080195

    iget-object v2, p0, Lcm;->b:Landroid/content/Context;

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 213
    iget-object v0, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->e(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/webkit/WebView;

    move-result-object v0

    const v1, 0x7f0800ed

    iget-object v2, p0, Lcm;->b:Landroid/content/Context;

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 214
    return-void
.end method

.method public executeMainCSS()V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 258
    iget-object v0, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->e(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/webkit/WebView;

    move-result-object v0

    const v1, 0x7f08021e

    iget-object v2, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->e(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v1, v2}, Lnl;->a(ILandroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 259
    return-void
.end method

.method public showHTML(Ljava/lang/String;)V
    .locals 6
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 235
    if-eqz p1, :cond_0

    .line 236
    const-string v0, "\\<[^>]*>"

    const-string v1, ""

    invoke-virtual {p1, v0, v1}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 238
    :try_start_0
    iget-object v1, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    const v2, 0x7f080155

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 239
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 240
    const-string v0, "status"

    const-string v2, ""

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 241
    const-string v2, "success"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 242
    const-string v0, "userToken"

    const-string v2, ""

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 243
    const-string v0, "accessToken"

    const-string v2, ""

    invoke-virtual {v1, v0, v2}, Lorg/json/JSONObject;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 244
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->e(Z)V

    .line 245
    if-eqz v5, :cond_0

    if-eqz v4, :cond_0

    .line 246
    iget-object v0, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->f:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->d(Z)V

    .line 247
    new-instance v0, Lio;

    iget-object v1, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v3, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->a(Lcom/bestbuy/android/activities/mybby/CIALoginFragment;)Landroid/view/View;

    move-result-object v3

    invoke-direct/range {v0 .. v5}, Lio;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lio;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 254
    :cond_0
    :goto_0
    return-void

    .line 250
    :catch_0
    move-exception v0

    .line 251
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method public updateCartCount(Ljava/lang/String;)V
    .locals 4
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 218
    const/4 v0, 0x0

    .line 219
    const-string v1, "CartItemCount"

    invoke-virtual {p0, p1, v1}, Lcm;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 221
    if-eqz v1, :cond_0

    :try_start_0
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 222
    invoke-static {v1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    .line 223
    :cond_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    iget-object v2, p0, Lcm;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080031

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 224
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 225
    iget-object v1, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const/4 v2, -0x1

    invoke-virtual {v1, v2, v0}, Landroid/app/Activity;->setResult(ILandroid/content/Intent;)V

    .line 226
    iget-object v0, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 227
    iget-object v0, p0, Lcm;->a:Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->d:Landroid/app/Activity;

    const v1, 0x7f040005

    const v2, 0x7f040008

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->overridePendingTransition(II)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 231
    :goto_0
    return-void

    .line 228
    :catch_0
    move-exception v0

    .line 229
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
