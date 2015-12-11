.class Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;

.field final synthetic val$params:[Ljava/lang/Integer;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;[Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;->val$params:[Ljava/lang/Integer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 367
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->endList:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-nez v0, :cond_1

    .line 406
    :cond_0
    :goto_0
    return-void

    .line 369
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorType:Ljava/lang/String;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->title:Ljava/lang/String;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;->val$params:[Ljava/lang/Integer;

    const/4 v3, 0x0

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    add-int/lit8 v2, v2, 0x1

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSearchUrl(Ljava/lang/String;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    .line 370
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1$1;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask$1;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_0
.end method
