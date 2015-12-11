.class Lcom/localytics/android/MarketingHandler$15$1;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Lcom/localytics/android/MarketingMessage;",
        "Ljava/lang/Void;",
        "[",
        "Ljava/lang/Object;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/localytics/android/MarketingHandler$15;

.field final synthetic val$marketingMessage:Lcom/localytics/android/MarketingMessage;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingHandler$15;Lcom/localytics/android/MarketingMessage;)V
    .locals 0

    .prologue
    .line 2375
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iput-object p2, p0, Lcom/localytics/android/MarketingHandler$15$1;->val$marketingMessage:Lcom/localytics/android/MarketingMessage;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2375
    check-cast p1, [Lcom/localytics/android/MarketingMessage;

    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingHandler$15$1;->doInBackground([Lcom/localytics/android/MarketingMessage;)[Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Lcom/localytics/android/MarketingMessage;)[Ljava/lang/Object;
    .locals 5

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x0

    .line 2390
    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$15;->this$0:Lcom/localytics/android/MarketingHandler;

    aget-object v3, p1, v4

    # invokes: Lcom/localytics/android/MarketingHandler;->_updateDisplayingCandidate(Lcom/localytics/android/MarketingMessage;)Z
    invoke-static {v0, v3}, Lcom/localytics/android/MarketingHandler;->access$900(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingMessage;)Z

    move-result v0

    if-eqz v0, :cond_0

    aget-object v0, p1, v4

    :goto_0
    aput-object v0, v2, v4

    const/4 v0, 0x1

    iget-object v3, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v3, v3, Lcom/localytics/android/MarketingHandler$15;->this$0:Lcom/localytics/android/MarketingHandler;

    # invokes: Lcom/localytics/android/MarketingHandler;->_getJavaScriptClientCallbacks(Ljava/util/Map;)Landroid/util/SparseArray;
    invoke-static {v3, v1}, Lcom/localytics/android/MarketingHandler;->access$1000(Lcom/localytics/android/MarketingHandler;Ljava/util/Map;)Landroid/util/SparseArray;

    move-result-object v1

    aput-object v1, v2, v0

    return-object v2

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 2375
    check-cast p1, [Ljava/lang/Object;

    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingHandler$15$1;->onPostExecute([Ljava/lang/Object;)V

    return-void
.end method

.method protected onPostExecute([Ljava/lang/Object;)V
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 2396
    aget-object v0, p1, v0

    check-cast v0, Lcom/localytics/android/MarketingMessage;

    .line 2397
    const/4 v1, 0x1

    aget-object v1, p1, v1

    check-cast v1, Landroid/util/SparseArray;

    .line 2400
    if-nez v0, :cond_1

    .line 2402
    :try_start_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$15;->val$appContext:Landroid/content/Context;

    const-string v1, "The downloaded campaign file is broken."

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 2425
    :cond_0
    :goto_0
    return-void

    .line 2406
    :cond_1
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v2, v2, Lcom/localytics/android/MarketingHandler$15;->this$0:Lcom/localytics/android/MarketingHandler;

    # getter for: Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;
    invoke-static {v2}, Lcom/localytics/android/MarketingHandler;->access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v2, v2, Lcom/localytics/android/MarketingHandler$15;->this$0:Lcom/localytics/android/MarketingHandler;

    # getter for: Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;
    invoke-static {v2}, Lcom/localytics/android/MarketingHandler;->access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "marketing_dialog"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "campaign_id"

    invoke-virtual {v0, v4}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/support/v4/app/ah;->a(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    if-nez v2, :cond_0

    .line 2411
    invoke-static {}, Lcom/localytics/android/MarketingDialogFragment;->newInstance()Lcom/localytics/android/MarketingDialogFragment;

    move-result-object v2

    .line 2412
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/localytics/android/MarketingDialogFragment;->setRetainInstance(Z)V

    .line 2413
    invoke-virtual {v2, v0}, Lcom/localytics/android/MarketingDialogFragment;->setData(Lcom/localytics/android/MarketingMessage;)Lcom/localytics/android/MarketingDialogFragment;

    move-result-object v2

    iget-object v3, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v3, v3, Lcom/localytics/android/MarketingHandler$15;->this$0:Lcom/localytics/android/MarketingHandler;

    invoke-virtual {v3}, Lcom/localytics/android/MarketingHandler;->getDialogCallbacks()Landroid/util/SparseArray;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/localytics/android/MarketingDialogFragment;->setCallbacks(Landroid/util/SparseArray;)Lcom/localytics/android/MarketingDialogFragment;

    move-result-object v2

    new-instance v3, Lcom/localytics/android/JavaScriptClient;

    invoke-direct {v3, v1}, Lcom/localytics/android/JavaScriptClient;-><init>(Landroid/util/SparseArray;)V

    invoke-virtual {v2, v3}, Lcom/localytics/android/MarketingDialogFragment;->setJavaScriptClient(Lcom/localytics/android/JavaScriptClient;)Lcom/localytics/android/MarketingDialogFragment;

    move-result-object v1

    iget-object v2, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v2, v2, Lcom/localytics/android/MarketingHandler$15;->this$0:Lcom/localytics/android/MarketingHandler;

    # getter for: Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;
    invoke-static {v2}, Lcom/localytics/android/MarketingHandler;->access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "marketing_dialog"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "campaign_id"

    invoke-virtual {v0, v4}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/localytics/android/MarketingDialogFragment;->show(Landroid/support/v4/app/ah;Ljava/lang/String;)V

    .line 2419
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$15;->this$0:Lcom/localytics/android/MarketingHandler;

    # getter for: Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;
    invoke-static {v0}, Lcom/localytics/android/MarketingHandler;->access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/ah;->b()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 2421
    :catch_0
    move-exception v0

    .line 2423
    const-class v1, Ljava/lang/RuntimeException;

    const-string v2, "Localytics library threw an uncaught exception"

    invoke-static {v1, v2, v0}, Lcom/localytics/android/LocalyticsManager;->throwOrLogError(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Exception;)Ljava/lang/Object;

    goto/16 :goto_0
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 2379
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$15$1;->val$marketingMessage:Lcom/localytics/android/MarketingMessage;

    const-string v1, "_id"

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 2380
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v1, v1, Lcom/localytics/android/MarketingHandler$15;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v2, p0, Lcom/localytics/android/MarketingHandler$15$1;->val$marketingMessage:Lcom/localytics/android/MarketingMessage;

    # invokes: Lcom/localytics/android/MarketingHandler;->_getRemoteFileURL(Lcom/localytics/android/MarketingMessage;)Ljava/lang/String;
    invoke-static {v1, v2}, Lcom/localytics/android/MarketingHandler;->access$700(Lcom/localytics/android/MarketingHandler;Lcom/localytics/android/MarketingMessage;)Ljava/lang/String;

    move-result-object v1

    const-string v2, ".zip"

    invoke-virtual {v1, v2}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    .line 2381
    iget-object v2, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v2, v2, Lcom/localytics/android/MarketingHandler$15;->this$0:Lcom/localytics/android/MarketingHandler;

    # invokes: Lcom/localytics/android/MarketingHandler;->_doesCreativeExist(IZ)Z
    invoke-static {v2, v0, v1}, Lcom/localytics/android/MarketingHandler;->access$800(Lcom/localytics/android/MarketingHandler;IZ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2383
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$15$1;->this$1:Lcom/localytics/android/MarketingHandler$15;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$15;->val$appContext:Landroid/content/Context;

    const-string v1, "Downloading the campaign...\nIt\'ll be shown in few seconds."

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 2385
    :cond_0
    return-void
.end method
