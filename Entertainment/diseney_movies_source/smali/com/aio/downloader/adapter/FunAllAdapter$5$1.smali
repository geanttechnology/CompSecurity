.class Lcom/aio/downloader/adapter/FunAllAdapter$5$1;
.super Ljava/lang/Thread;
.source "FunAllAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/FunAllAdapter$5;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/adapter/FunAllAdapter$5;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/FunAllAdapter$5;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$5$1;->this$1:Lcom/aio/downloader/adapter/FunAllAdapter$5;

    .line 389
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 394
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 395
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter$5$1;->this$1:Lcom/aio/downloader/adapter/FunAllAdapter$5;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter$5;->url_video:Ljava/lang/String;
    invoke-static {v0}, Lcom/aio/downloader/adapter/FunAllAdapter$5;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter$5;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    .line 397
    return-void
.end method
