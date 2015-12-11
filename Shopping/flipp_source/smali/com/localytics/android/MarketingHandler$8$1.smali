.class Lcom/localytics/android/MarketingHandler$8$1;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/localytics/android/MarketingHandler$8;

.field final synthetic val$campaignId:I


# direct methods
.method constructor <init>(Lcom/localytics/android/MarketingHandler$8;I)V
    .locals 0

    .prologue
    .line 2069
    iput-object p1, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iput p2, p0, Lcom/localytics/android/MarketingHandler$8$1;->val$campaignId:I

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Boolean;
    .locals 2

    .prologue
    .line 2073
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$8;->this$0:Lcom/localytics/android/MarketingHandler;

    iget v1, p0, Lcom/localytics/android/MarketingHandler$8$1;->val$campaignId:I

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingHandler;->setMarketingMessageAsDisplayed(I)Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 2069
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingHandler$8$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method protected onPostExecute(Ljava/lang/Boolean;)V
    .locals 3

    .prologue
    .line 2079
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2081
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$8;->this$0:Lcom/localytics/android/MarketingHandler;

    # getter for: Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;
    invoke-static {v0}, Lcom/localytics/android/MarketingHandler;->access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 2083
    invoke-static {}, Lcom/localytics/android/MarketingDialogFragment;->newInstance()Lcom/localytics/android/MarketingDialogFragment;

    move-result-object v0

    .line 2084
    iget-object v1, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v1, v1, Lcom/localytics/android/MarketingHandler$8;->val$marketingMessage:Lcom/localytics/android/MarketingMessage;

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingDialogFragment;->setData(Lcom/localytics/android/MarketingMessage;)Lcom/localytics/android/MarketingDialogFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v1, v1, Lcom/localytics/android/MarketingHandler$8;->this$0:Lcom/localytics/android/MarketingHandler;

    invoke-virtual {v1}, Lcom/localytics/android/MarketingHandler;->getDialogCallbacks()Landroid/util/SparseArray;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingDialogFragment;->setCallbacks(Landroid/util/SparseArray;)Lcom/localytics/android/MarketingDialogFragment;

    move-result-object v0

    new-instance v1, Lcom/localytics/android/JavaScriptClient;

    iget-object v2, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v2, v2, Lcom/localytics/android/MarketingHandler$8;->val$jsCallbacks:Landroid/util/SparseArray;

    invoke-direct {v1, v2}, Lcom/localytics/android/JavaScriptClient;-><init>(Landroid/util/SparseArray;)V

    invoke-virtual {v0, v1}, Lcom/localytics/android/MarketingDialogFragment;->setJavaScriptClient(Lcom/localytics/android/JavaScriptClient;)Lcom/localytics/android/MarketingDialogFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v1, v1, Lcom/localytics/android/MarketingHandler$8;->this$0:Lcom/localytics/android/MarketingHandler;

    # getter for: Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;
    invoke-static {v1}, Lcom/localytics/android/MarketingHandler;->access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;

    move-result-object v1

    const-string v2, "marketing_dialog"

    invoke-virtual {v0, v1, v2}, Lcom/localytics/android/MarketingDialogFragment;->show(Landroid/support/v4/app/ah;Ljava/lang/String;)V

    .line 2089
    invoke-static {}, Lcom/localytics/android/Constants;->isTestModeEnabled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 2091
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$8;->this$0:Lcom/localytics/android/MarketingHandler;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler;->listeners:Lcom/localytics/android/BaseHandler$ListenersSet;

    check-cast v0, Lcom/localytics/android/MessagingListener;

    invoke-interface {v0}, Lcom/localytics/android/MessagingListener;->localyticsWillDisplayInAppMessage()V

    .line 2098
    :cond_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$8;->this$0:Lcom/localytics/android/MarketingHandler;

    # getter for: Lcom/localytics/android/MarketingHandler;->mFragmentManager:Landroid/support/v4/app/ah;
    invoke-static {v0}, Lcom/localytics/android/MarketingHandler;->access$300(Lcom/localytics/android/MarketingHandler;)Landroid/support/v4/app/ah;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/ah;->b()Z

    .line 2107
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$8;->this$0:Lcom/localytics/android/MarketingHandler;

    const/4 v1, 0x0

    # setter for: Lcom/localytics/android/MarketingHandler;->mCampaignDisplaying:Z
    invoke-static {v0, v1}, Lcom/localytics/android/MarketingHandler;->access$402(Lcom/localytics/android/MarketingHandler;Z)Z

    .line 2108
    return-void

    .line 2104
    :cond_2
    iget-object v0, p0, Lcom/localytics/android/MarketingHandler$8$1;->this$1:Lcom/localytics/android/MarketingHandler$8;

    iget-object v0, v0, Lcom/localytics/android/MarketingHandler$8;->this$0:Lcom/localytics/android/MarketingHandler;

    iget v1, p0, Lcom/localytics/android/MarketingHandler$8$1;->val$campaignId:I

    # invokes: Lcom/localytics/android/MarketingHandler;->setMarketingMessageAsNotDisplayed(I)V
    invoke-static {v0, v1}, Lcom/localytics/android/MarketingHandler;->access$500(Lcom/localytics/android/MarketingHandler;I)V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 2069
    check-cast p1, Ljava/lang/Boolean;

    invoke-virtual {p0, p1}, Lcom/localytics/android/MarketingHandler$8$1;->onPostExecute(Ljava/lang/Boolean;)V

    return-void
.end method
