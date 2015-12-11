.class Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;
.super Landroid/os/AsyncTask;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;


# direct methods
.method private constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;)V
    .locals 0

    .prologue
    .line 292
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;)V
    .locals 0

    .prologue
    .line 292
    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;-><init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 292
    check-cast p1, [Ljava/lang/Integer;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->doInBackground([Ljava/lang/Integer;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Integer;)[Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 300
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-nez v0, :cond_0

    .line 350
    :goto_0
    return-object v2

    .line 302
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;

    invoke-direct {v1, p0, p1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;[Ljava/lang/Integer;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 292
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->onPostExecute([Ljava/lang/String;)V

    return-void
.end method

.method protected onPostExecute([Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 295
    invoke-super {p0, p1}, Landroid/os/AsyncTask;->onPostExecute(Ljava/lang/Object;)V

    .line 296
    return-void
.end method
