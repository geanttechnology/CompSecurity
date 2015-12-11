.class Lcom/aio/downloader/views/ClearView$1;
.super Ljava/lang/Thread;
.source "ClearView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/views/ClearView;->setAngle(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/ClearView;

.field private final synthetic val$angle:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/ClearView;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    iput p2, p0, Lcom/aio/downloader/views/ClearView$1;->val$angle:I

    .line 37
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const v3, -0x8a5807

    .line 39
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    # getter for: Lcom/aio/downloader/views/ClearView;->isRun:Z
    invoke-static {v1}, Lcom/aio/downloader/views/ClearView;->access$0(Lcom/aio/downloader/views/ClearView;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 67
    return-void

    .line 41
    :cond_0
    const-wide/16 v1, 0x8

    :try_start_0
    invoke-static {v1, v2}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 45
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    iget-boolean v1, v1, Lcom/aio/downloader/views/ClearView;->state:Z

    if-eqz v1, :cond_2

    .line 46
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    # getter for: Lcom/aio/downloader/views/ClearView;->sweepAngle:I
    invoke-static {v1}, Lcom/aio/downloader/views/ClearView;->access$1(Lcom/aio/downloader/views/ClearView;)I

    move-result v2

    add-int/lit8 v2, v2, -0x2

    invoke-static {v1, v2}, Lcom/aio/downloader/views/ClearView;->access$2(Lcom/aio/downloader/views/ClearView;I)V

    .line 47
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    # getter for: Lcom/aio/downloader/views/ClearView;->sweepAngle:I
    invoke-static {v1}, Lcom/aio/downloader/views/ClearView;->access$1(Lcom/aio/downloader/views/ClearView;)I

    move-result v1

    if-gtz v1, :cond_1

    .line 48
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    invoke-static {v1, v4}, Lcom/aio/downloader/views/ClearView;->access$2(Lcom/aio/downloader/views/ClearView;I)V

    .line 49
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    iput-boolean v4, v1, Lcom/aio/downloader/views/ClearView;->state:Z

    .line 58
    :cond_1
    :goto_2
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    # getter for: Lcom/aio/downloader/views/ClearView;->sweepAngle:I
    invoke-static {v1}, Lcom/aio/downloader/views/ClearView;->access$1(Lcom/aio/downloader/views/ClearView;)I

    move-result v1

    const/16 v2, 0x64

    if-ge v1, v2, :cond_3

    .line 59
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    invoke-static {v1, v3}, Lcom/aio/downloader/views/ClearView;->access$4(Lcom/aio/downloader/views/ClearView;I)V

    .line 65
    :goto_3
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    invoke-virtual {v1}, Lcom/aio/downloader/views/ClearView;->postInvalidate()V

    goto :goto_0

    .line 42
    :catch_0
    move-exception v0

    .line 43
    .local v0, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_1

    .line 52
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :cond_2
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    # getter for: Lcom/aio/downloader/views/ClearView;->sweepAngle:I
    invoke-static {v1}, Lcom/aio/downloader/views/ClearView;->access$1(Lcom/aio/downloader/views/ClearView;)I

    move-result v2

    add-int/lit8 v2, v2, 0x2

    invoke-static {v1, v2}, Lcom/aio/downloader/views/ClearView;->access$2(Lcom/aio/downloader/views/ClearView;I)V

    .line 53
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    # getter for: Lcom/aio/downloader/views/ClearView;->sweepAngle:I
    invoke-static {v1}, Lcom/aio/downloader/views/ClearView;->access$1(Lcom/aio/downloader/views/ClearView;)I

    move-result v1

    iget v2, p0, Lcom/aio/downloader/views/ClearView$1;->val$angle:I

    if-lt v1, v2, :cond_1

    .line 54
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    iget v2, p0, Lcom/aio/downloader/views/ClearView$1;->val$angle:I

    invoke-static {v1, v2}, Lcom/aio/downloader/views/ClearView;->access$2(Lcom/aio/downloader/views/ClearView;I)V

    .line 55
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    invoke-static {v1, v4}, Lcom/aio/downloader/views/ClearView;->access$3(Lcom/aio/downloader/views/ClearView;Z)V

    goto :goto_2

    .line 60
    :cond_3
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    # getter for: Lcom/aio/downloader/views/ClearView;->sweepAngle:I
    invoke-static {v1}, Lcom/aio/downloader/views/ClearView;->access$1(Lcom/aio/downloader/views/ClearView;)I

    move-result v1

    const/16 v2, 0xfa

    if-ge v1, v2, :cond_4

    .line 61
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    invoke-static {v1, v3}, Lcom/aio/downloader/views/ClearView;->access$4(Lcom/aio/downloader/views/ClearView;I)V

    goto :goto_3

    .line 63
    :cond_4
    iget-object v1, p0, Lcom/aio/downloader/views/ClearView$1;->this$0:Lcom/aio/downloader/views/ClearView;

    invoke-static {v1, v3}, Lcom/aio/downloader/views/ClearView;->access$4(Lcom/aio/downloader/views/ClearView;I)V

    goto :goto_3
.end method
