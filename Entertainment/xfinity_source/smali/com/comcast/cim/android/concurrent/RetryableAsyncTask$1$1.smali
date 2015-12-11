.class Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;
.super Ljava/lang/Object;
.source "RetryableAsyncTask.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;

    .prologue
    .line 96
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;"
    iput-object p1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;->this$1:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public tryAgain()V
    .locals 2

    .prologue
    .line 99
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;"
    iget-object v0, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;->this$1:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;

    iget-object v0, v0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->this$0:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;->this$1:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;

    iget-object v1, v1, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->getNewInstance(Landroid/app/Activity;)Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;->this$1:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;

    iget-object v1, v1, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->this$0:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    # getter for: Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->originalParams:[Ljava/lang/Object;
    invoke-static {v1}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->access$100(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;)[Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 100
    return-void
.end method
