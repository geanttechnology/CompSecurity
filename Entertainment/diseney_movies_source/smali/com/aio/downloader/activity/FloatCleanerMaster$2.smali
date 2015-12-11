.class Lcom/aio/downloader/activity/FloatCleanerMaster$2;
.super Ljava/lang/Object;
.source "FloatCleanerMaster.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/activity/FloatCleanerMaster;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FloatCleanerMaster;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$2;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    .line 1272
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 1276
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 1284
    :goto_0
    return-void

    .line 1279
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$2;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$2;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/activity/FloatCleanerMaster;->clearMemory(Landroid/content/Context;)V

    .line 1280
    iget-object v0, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$2;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    # getter for: Lcom/aio/downloader/activity/FloatCleanerMaster;->cv:Lcom/aio/downloader/views/ClearView;
    invoke-static {v0}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$1(Lcom/aio/downloader/activity/FloatCleanerMaster;)Lcom/aio/downloader/views/ClearView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$2;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    iget-object v2, p0, Lcom/aio/downloader/activity/FloatCleanerMaster$2;->this$0:Lcom/aio/downloader/activity/FloatCleanerMaster;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    # invokes: Lcom/aio/downloader/activity/FloatCleanerMaster;->formatMemory(Landroid/content/Context;)I
    invoke-static {v1, v2}, Lcom/aio/downloader/activity/FloatCleanerMaster;->access$2(Lcom/aio/downloader/activity/FloatCleanerMaster;Landroid/content/Context;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/ClearView;->setAngle(I)V

    goto :goto_0

    .line 1276
    nop

    :pswitch_data_0
    .packed-switch 0x7f0701d5
        :pswitch_0
    .end packed-switch
.end method
