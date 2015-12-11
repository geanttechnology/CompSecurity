.class Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;
.super Ljava/lang/Object;
.source "MinigameListviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/MinigameListviewAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

.field private final synthetic val$in_fo:Lcom/aio/downloader/model/MiniGameModel;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/MinigameListviewAdapter;Lcom/aio/downloader/model/MiniGameModel;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    iput-object p2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/model/MiniGameModel;

    .line 105
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 108
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1$1;

    iget-object v3, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/model/MiniGameModel;

    invoke-direct {v2, p0, v3}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1$1;-><init>(Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;Lcom/aio/downloader/model/MiniGameModel;)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 116
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 118
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/MinigameListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->access$0(Lcom/aio/downloader/adapter/MinigameListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/aio/downloader/activity/MiniGamePlayActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 119
    .local v0, "ti":Landroid/content/Intent;
    const-string v1, "playurl"

    iget-object v2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/MiniGameModel;->getPlay_url()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 120
    const-string v1, "proc"

    iget-object v2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/MiniGameModel;->getProc()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 121
    const-string v1, "sound"

    iget-object v2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;->val$in_fo:Lcom/aio/downloader/model/MiniGameModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/MiniGameModel;->getSound()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 122
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/MinigameListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/MinigameListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->access$0(Lcom/aio/downloader/adapter/MinigameListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 124
    return-void
.end method
