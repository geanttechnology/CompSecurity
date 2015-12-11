.class Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

.field final synthetic val$params:[Ljava/lang/Integer;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;[Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 225
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->val$params:[Ljava/lang/Integer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 228
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->endList:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-nez v0, :cond_1

    .line 263
    :cond_0
    :goto_0
    return-void

    .line 231
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->val$params:[Ljava/lang/Integer;

    const/4 v2, 0x0

    aget-object v1, v1, v2

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getNewsfeedUrl(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 232
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;->this$1:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v3, v3, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {v3}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1$1;-><init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask$1;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_0
.end method
