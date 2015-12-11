.class Lcom/localytics/android/MarketingHandler$13$1;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
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
.field final synthetic this$1:Lcom/localytics/android/MarketingHandler$13;


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingHandler$13;)V
    .locals 0

    .prologue
    .line 2298
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler$13$1;->this$1:Lcom/localytics/android/MarketingHandler$13;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2298
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingHandler$13$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 2302
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$13$1;->this$1:Lcom/localytics/android/MarketingHandler$13;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$13;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler;->mLocalyticsDao:Lcom/localytics/android/LocalyticsDao;

    invoke-interface {v0}, Lcom/localytics/android/LocalyticsDao;->getPushRegistrationId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 2298
    check-cast p1, Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingHandler$13$1;->onPostExecute(Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/String;)V
    .locals 4
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    const/4 v3, 0x1

    .line 2309
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2311
    invoke-static {}, Lcom/localytics/android/DatapointHelper;->getApiLevel()I

    move-result v0

    const/16 v1, 0xb

    if-ge v0, v1, :cond_0

    .line 2313
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$13$1;->this$1:Lcom/localytics/android/MarketingHandler$13;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$13;->val$appContext:Landroid/content/Context;

    const-string v1, "clipboard"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/text/ClipboardManager;

    .line 2314
    invoke-virtual {v0, p1}, Landroid/text/ClipboardManager;->setText(Ljava/lang/CharSequence;)V

    .line 2321
    :goto_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$13$1;->this$1:Lcom/localytics/android/MarketingHandler$13;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$13;->val$appContext:Landroid/content/Context;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " has been copied to the clipboard."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 2327
    :goto_1
    return-void

    .line 2318
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$13$1;->this$1:Lcom/localytics/android/MarketingHandler$13;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$13;->val$appContext:Landroid/content/Context;

    const-string v1, "clipboard"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipboardManager;

    .line 2319
    invoke-virtual {v0, p1}, Landroid/content/ClipboardManager;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 2325
    :cond_1
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$13$1;->this$1:Lcom/localytics/android/MarketingHandler$13;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$13;->val$appContext:Landroid/content/Context;

    const-string v1, "No push token found. Please check your integration."

    invoke-static {v0, v1, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_1
.end method
