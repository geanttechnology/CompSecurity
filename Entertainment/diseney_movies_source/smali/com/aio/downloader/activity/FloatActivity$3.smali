.class Lcom/aio/downloader/activity/FloatActivity$3;
.super Ljava/lang/Object;
.source "FloatActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FloatActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FloatActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FloatActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FloatActivity$3;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    .line 429
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 434
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatActivity$3;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    # getter for: Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v1}, Lcom/aio/downloader/activity/FloatActivity;->access$0(Lcom/aio/downloader/activity/FloatActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v1

    .line 435
    invoke-virtual {v1}, Lcom/aio/downloader/views/DeletableEditText;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 436
    const-string v2, "input_method"

    .line 435
    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 434
    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 438
    .local v0, "inputManager":Landroid/view/inputmethod/InputMethodManager;
    iget-object v1, p0, Lcom/aio/downloader/activity/FloatActivity$3;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    # getter for: Lcom/aio/downloader/activity/FloatActivity;->float_search_view:Lcom/aio/downloader/views/DeletableEditText;
    invoke-static {v1}, Lcom/aio/downloader/activity/FloatActivity;->access$0(Lcom/aio/downloader/activity/FloatActivity;)Lcom/aio/downloader/views/DeletableEditText;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/views/DeletableEditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    .line 437
    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 439
    return-void
.end method
