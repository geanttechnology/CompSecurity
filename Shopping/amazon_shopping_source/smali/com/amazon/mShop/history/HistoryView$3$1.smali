.class Lcom/amazon/mShop/history/HistoryView$3$1;
.super Ljava/lang/Object;
.source "HistoryView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/history/HistoryView$3;->onActionButtonClick(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/history/HistoryView$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/history/HistoryView$3;)V
    .locals 0

    .prologue
    .line 279
    iput-object p1, p0, Lcom/amazon/mShop/history/HistoryView$3$1;->this$1:Lcom/amazon/mShop/history/HistoryView$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 283
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$3$1;->this$1:Lcom/amazon/mShop/history/HistoryView$3;

    iget-object v0, v0, Lcom/amazon/mShop/history/HistoryView$3;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # invokes: Lcom/amazon/mShop/history/HistoryView;->showLoadingStatus()V
    invoke-static {v0}, Lcom/amazon/mShop/history/HistoryView;->access$400(Lcom/amazon/mShop/history/HistoryView;)V

    .line 284
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryView$3$1;->this$1:Lcom/amazon/mShop/history/HistoryView$3;

    iget-object v0, v0, Lcom/amazon/mShop/history/HistoryView$3;->this$0:Lcom/amazon/mShop/history/HistoryView;

    # getter for: Lcom/amazon/mShop/history/HistoryView;->mBrowser:Lcom/amazon/mShop/control/history/HistoryBrowser;
    invoke-static {v0}, Lcom/amazon/mShop/history/HistoryView;->access$300(Lcom/amazon/mShop/history/HistoryView;)Lcom/amazon/mShop/control/history/HistoryBrowser;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/history/HistoryBrowser;->replayPageRequest()V

    .line 285
    return-void
.end method
