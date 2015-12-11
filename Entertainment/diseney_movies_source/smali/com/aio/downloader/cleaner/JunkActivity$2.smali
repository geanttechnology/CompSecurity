.class Lcom/aio/downloader/cleaner/JunkActivity$2;
.super Ljava/lang/Object;
.source "JunkActivity.java"

# interfaces
.implements Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/cleaner/JunkActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/cleaner/JunkActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/JunkActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/JunkActivity$2;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    .line 259
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public ClickGroupCheckBox(I)V
    .locals 3
    .param p1, "num"    # I

    .prologue
    .line 263
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$2;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    invoke-static {v0, p1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$53(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    .line 264
    const-string v0, "fff"

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "2num"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/cleaner/JunkActivity$2;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->num2:I
    invoke-static {v2}, Lcom/aio/downloader/cleaner/JunkActivity;->access$54(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 265
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$2;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->num2:I
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$54(Lcom/aio/downloader/cleaner/JunkActivity;)I

    move-result v0

    if-eqz v0, :cond_0

    .line 266
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$2;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    # getter for: Lcom/aio/downloader/cleaner/JunkActivity;->adapter:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/JunkActivity;->access$52(Lcom/aio/downloader/cleaner/JunkActivity;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->notifyDataSetChanged()V

    .line 267
    iget-object v0, p0, Lcom/aio/downloader/cleaner/JunkActivity$2;->this$0:Lcom/aio/downloader/cleaner/JunkActivity;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/aio/downloader/cleaner/JunkActivity;->access$53(Lcom/aio/downloader/cleaner/JunkActivity;I)V

    .line 269
    :cond_0
    return-void
.end method
