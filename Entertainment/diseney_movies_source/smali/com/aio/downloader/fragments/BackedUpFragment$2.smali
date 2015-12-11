.class Lcom/aio/downloader/fragments/BackedUpFragment$2;
.super Landroid/content/BroadcastReceiver;
.source "BackedUpFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/fragments/BackedUpFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/BackedUpFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    .line 310
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/BackedUpFragment$2;)Lcom/aio/downloader/fragments/BackedUpFragment;
    .locals 1

    .prologue
    .line 310
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    return-object v0
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "arg0"    # Landroid/content/Context;
    .param p2, "arg1"    # Landroid/content/Intent;

    .prologue
    .line 315
    const-string v0, "backup"

    const-string v1, "onClickReceiver"

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 316
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$5(Lcom/aio/downloader/fragments/BackedUpFragment;Ljava/util/List;)V

    .line 318
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    .line 319
    const-string v1, "mounted"

    .line 318
    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 319
    if-eqz v0, :cond_1

    .line 320
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$3(Lcom/aio/downloader/fragments/BackedUpFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 326
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/aio/downloader/fragments/BackedUpFragment$2$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/fragments/BackedUpFragment$2$1;-><init>(Lcom/aio/downloader/fragments/BackedUpFragment$2;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 336
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 343
    :cond_0
    :goto_0
    return-void

    .line 339
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpFragment$2;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;

    invoke-virtual {v0}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 340
    const-string v1, "Please insert an external storage device.."

    .line 341
    const/4 v2, 0x1

    .line 339
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 341
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method
