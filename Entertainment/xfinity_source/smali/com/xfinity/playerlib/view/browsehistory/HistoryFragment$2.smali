.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$2;
.super Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;
.source "HistoryFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/downloads/SimpleDownloadServiceListener",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 124
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-direct {p0}, Lcom/comcast/cim/downloads/SimpleDownloadServiceListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onFileListUpdated()V
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$2;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyAdapter:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$400(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->notifyDataSetChanged()V

    .line 128
    return-void
.end method
