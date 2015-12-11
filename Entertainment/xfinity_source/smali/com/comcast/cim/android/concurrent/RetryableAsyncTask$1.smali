.class Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;
.super Ljava/lang/Object;
.source "RetryableAsyncTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->onPostExecute(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

.field final synthetic val$activity:Landroid/app/Activity;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;Landroid/app/Activity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    .prologue
    .line 94
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;"
    iput-object p1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->this$0:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    iput-object p2, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->val$activity:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 96
    .local p0, "this":Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;, "Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;"
    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->this$0:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    iget-object v1, v1, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    iget-object v2, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->this$0:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    # getter for: Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->exception:Ljava/lang/Exception;
    invoke-static {v2}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->access$000(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;)Ljava/lang/Exception;

    move-result-object v2

    new-instance v3, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;

    invoke-direct {v3, p0}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1$1;-><init>(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;)V

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    .line 103
    .local v0, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->this$0:Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;

    # getter for: Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->errorDialogCancelListener:Landroid/content/DialogInterface$OnCancelListener;
    invoke-static {v1}, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;->access$200(Lcom/comcast/cim/android/concurrent/RetryableAsyncTask;)Landroid/content/DialogInterface$OnCancelListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 104
    iget-object v1, p0, Lcom/comcast/cim/android/concurrent/RetryableAsyncTask$1;->val$activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "caldialogfragment"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 105
    return-void
.end method
