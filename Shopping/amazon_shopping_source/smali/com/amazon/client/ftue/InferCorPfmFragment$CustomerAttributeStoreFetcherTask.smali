.class Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;
.super Landroid/os/AsyncTask;
.source "InferCorPfmFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/ftue/InferCorPfmFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "CustomerAttributeStoreFetcherTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private final masClientCustomerAttributeStore:Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;

.field final synthetic this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/client/ftue/InferCorPfmFragment;Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;)V
    .locals 0
    .param p2, "masClientCustomerAttributeStore"    # Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;

    .prologue
    .line 296
    iput-object p1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 297
    iput-object p2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->masClientCustomerAttributeStore:Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;

    .line 298
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 284
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 9
    .param p1, "object"    # [Ljava/lang/Void;

    .prologue
    .line 302
    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v6, v6, Lcom/amazon/client/ftue/InferCorPfmFragment;->accountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    if-eqz v6, :cond_1

    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v6, v6, Lcom/amazon/client/ftue/InferCorPfmFragment;->accountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_1

    .line 303
    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v6, v6, Lcom/amazon/client/ftue/InferCorPfmFragment;->accountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v2

    .line 305
    .local v2, "directedId":Ljava/lang/String;
    :try_start_0
    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->masClientCustomerAttributeStore:Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;

    const-string/jumbo v7, "PFM"

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v2, v8}, Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;->getAttribute(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v5

    .line 307
    .local v5, "pfm":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->masClientCustomerAttributeStore:Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;

    const-string/jumbo v7, "COR"

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v2, v8}, Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;->getAttribute(Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v1

    .line 310
    .local v1, "cor":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->masClientCustomerAttributeStore:Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;

    const-string/jumbo v7, "com.amazon.dcp.sso.token.device.accountpool"

    invoke-virtual {v6, v7, v2}, Lcom/amazon/mas/client/authentication/MASClientCustomerAttributeStore;->getAttribute(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 314
    .local v0, "accountPool":Ljava/lang/String;
    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    invoke-static {v5}, Lcom/amazon/venezia/web/Marketplace;->fromEMID(Ljava/lang/String;)Lcom/amazon/venezia/web/Marketplace;

    move-result-object v7

    # setter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->marketplace:Lcom/amazon/venezia/web/Marketplace;
    invoke-static {v6, v7}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$002(Lcom/amazon/client/ftue/InferCorPfmFragment;Lcom/amazon/venezia/web/Marketplace;)Lcom/amazon/venezia/web/Marketplace;

    .line 315
    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v7, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    # getter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->marketplace:Lcom/amazon/venezia/web/Marketplace;
    invoke-static {v7}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$000(Lcom/amazon/client/ftue/InferCorPfmFragment;)Lcom/amazon/venezia/web/Marketplace;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/venezia/web/Marketplace;->getStack()Lcom/amazon/venezia/web/SSRStack;

    move-result-object v7

    # setter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->stack:Lcom/amazon/venezia/web/SSRStack;
    invoke-static {v6, v7}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$102(Lcom/amazon/client/ftue/InferCorPfmFragment;Lcom/amazon/venezia/web/SSRStack;)Lcom/amazon/venezia/web/SSRStack;

    .line 316
    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v6, v6, Lcom/amazon/client/ftue/InferCorPfmFragment;->pageUrlFactory:Lcom/amazon/venezia/web/PageUrlFactory;

    iget-object v7, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    # getter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->stack:Lcom/amazon/venezia/web/SSRStack;
    invoke-static {v7}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$100(Lcom/amazon/client/ftue/InferCorPfmFragment;)Lcom/amazon/venezia/web/SSRStack;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/amazon/venezia/web/PageUrlFactory;->getPfmCorUrl(Lcom/amazon/venezia/web/SSRStack;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->url:Ljava/lang/String;

    .line 318
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 320
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->url:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "&"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "accountPool"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->url:Ljava/lang/String;

    .line 323
    :cond_0
    iget-object v6, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    # invokes: Lcom/amazon/client/ftue/InferCorPfmFragment;->buildMinifiedMasDeviceInfoCookie(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    invoke-static {v6, v5, v1}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$200(Lcom/amazon/client/ftue/InferCorPfmFragment;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 329
    .end local v0    # "accountPool":Ljava/lang/String;
    .end local v1    # "cor":Ljava/lang/String;
    .end local v2    # "directedId":Ljava/lang/String;
    .end local v5    # "pfm":Ljava/lang/String;
    :goto_0
    return-object v4

    .line 325
    .restart local v2    # "directedId":Ljava/lang/String;
    :catch_0
    move-exception v3

    .line 326
    .local v3, "interruptedException":Ljava/lang/InterruptedException;
    # getter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->LOG:Lcom/amazon/logging/Logger;
    invoke-static {}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$300()Lcom/amazon/logging/Logger;

    move-result-object v6

    const-string/jumbo v7, "Failed to obtain pfm and cor"

    invoke-virtual {v6, v7, v3}, Lcom/amazon/logging/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 329
    .end local v2    # "directedId":Ljava/lang/String;
    .end local v3    # "interruptedException":Ljava/lang/InterruptedException;
    :cond_1
    const/4 v4, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 284
    check-cast p1, Ljava/lang/String;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 4
    .param p1, "masDeviceInfoCookie"    # Ljava/lang/String;

    .prologue
    .line 334
    if-eqz p1, :cond_0

    .line 335
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v1, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->url:Ljava/lang/String;

    # invokes: Lcom/amazon/client/ftue/InferCorPfmFragment;->setMasDeviceInfoCookie(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, p1}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$400(Lcom/amazon/client/ftue/InferCorPfmFragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 336
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    new-instance v1, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

    iget-object v2, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    iget-object v3, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->url:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;-><init>(Lcom/amazon/client/ftue/InferCorPfmFragment;Ljava/lang/String;)V

    # setter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->cookieSetterTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;
    invoke-static {v0, v1}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$502(Lcom/amazon/client/ftue/InferCorPfmFragment;Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;)Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

    .line 337
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    # getter for: Lcom/amazon/client/ftue/InferCorPfmFragment;->cookieSetterTask:Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;
    invoke-static {v0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$500(Lcom/amazon/client/ftue/InferCorPfmFragment;)Lcom/amazon/client/ftue/InferCorPfmFragment$CookieSetterTask;

    move-result-object v0

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-static {v0, v1}, Lcom/amazon/venezia/concurrent/AsyncTasks;->executeInParallel(Landroid/os/AsyncTask;[Ljava/lang/Object;)V

    .line 341
    :goto_0
    return-void

    .line 339
    :cond_0
    iget-object v0, p0, Lcom/amazon/client/ftue/InferCorPfmFragment$CustomerAttributeStoreFetcherTask;->this$0:Lcom/amazon/client/ftue/InferCorPfmFragment;

    # invokes: Lcom/amazon/client/ftue/InferCorPfmFragment;->setInferenceFailed()V
    invoke-static {v0}, Lcom/amazon/client/ftue/InferCorPfmFragment;->access$600(Lcom/amazon/client/ftue/InferCorPfmFragment;)V

    goto :goto_0
.end method
