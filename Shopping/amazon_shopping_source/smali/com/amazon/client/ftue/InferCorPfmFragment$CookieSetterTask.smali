.class Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;
.super Landroid/os/AsyncTask;
.source "InferCorPfmFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/ftue/InferCorPfmFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "CookieSetterTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

.field private final url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/client/ftue/InferCorPfmFragment;Ljava/lang/String;)V
    .locals 0
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 412
    iput-object p1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 413
    iput-object p2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->url:Ljava/lang/String;

    .line 414
    return-void
.end method

.method private setUpIdentityCookies()V
    .locals 5

    .prologue
    .line 427
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v2, v2, Lcom/amazon/client/ftue/InferCorPfmFragment;->authCookieHelper:Ldagger/Lazy;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    # getter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->stack:Lcom/amazon/venezia/web/SSRStack;
    invoke-static {v2}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$100(Lcom/amazon/client/ftue/InferCorPfmFragment;)Lcom/amazon/venezia/web/SSRStack;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 428
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 429
    .local v1, "requestedCookies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mas/client/authentication/AuthCookie;>;"
    sget-object v2, Lcom/amazon/mas/client/authentication/AuthCookie;->X_MAIN:Lcom/amazon/mas/client/authentication/AuthCookie;

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 430
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v2, v2, Lcom/amazon/client/ftue/InferCorPfmFragment;->authCookieHelper:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/venezia/web/AuthCookieHelper;

    iget-object v3, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    # getter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->stack:Lcom/amazon/venezia/web/SSRStack;
    invoke-static {v3}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$100(Lcom/amazon/client/ftue/InferCorPfmFragment;)Lcom/amazon/venezia/web/SSRStack;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/venezia/web/SSRStack;->getMapCompliantDomain()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v1, v3, v4}, Lcom/amazon/venezia/web/AuthCookieHelper;->getMapCookies(Ljava/util/List;Ljava/lang/String;Z)Ljava/util/Map;

    move-result-object v0

    .line 432
    .local v0, "mapCookies":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/mas/client/authentication/AuthCookie;Ljava/lang/String;>;"
    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v2, v2, Lcom/amazon/client/ftue/InferCorPfmFragment;->authCookieHelper:Ldagger/Lazy;

    invoke-interface {v2}, Ldagger/Lazy;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/venezia/web/AuthCookieHelper;

    iget-object v3, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->url:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    # getter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->stack:Lcom/amazon/venezia/web/SSRStack;
    invoke-static {v4}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$100(Lcom/amazon/client/ftue/InferCorPfmFragment;)Lcom/amazon/venezia/web/SSRStack;

    move-result-object v4

    invoke-virtual {v2, v0, v3, v4}, Lcom/amazon/venezia/web/AuthCookieHelper;->setDomainCompliantCookie(Ljava/util/Map;Ljava/lang/String;Lcom/amazon/venezia/web/SSRStack;)Landroid/webkit/CookieManager;

    .line 434
    .end local v0    # "mapCookies":Ljava/util/Map;, "Ljava/util/Map<Lcom/amazon/mas/client/authentication/AuthCookie;Ljava/lang/String;>;"
    .end local v1    # "requestedCookies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mas/client/authentication/AuthCookie;>;"
    :cond_0
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 403
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 1
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 418
    invoke-direct {p0}, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->setUpIdentityCookies()V

    .line 419
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 403
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 438
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    # getter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->webview:Landroid/webkit/WebView;
    invoke-static {v0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$700(Lcom/amazon/client/ftue/InferCorPfmFragment;)Landroid/webkit/WebView;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;->url:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 439
    return-void
.end method
