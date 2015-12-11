.class Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$1;
.super Ljava/lang/Object;
.source "HistoryAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->showInProgressInfo(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$ViewHolder;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

.field final synthetic val$playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    .prologue
    .line 444
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$1;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$1;->val$playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 447
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$1;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->access$000(Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;)Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$1;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->context:Landroid/content/Context;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter$1;->val$playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-interface {v0, v1, v2}, Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;->onCancelDownloadPressed(Landroid/content/Context;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    .line 448
    return-void
.end method
