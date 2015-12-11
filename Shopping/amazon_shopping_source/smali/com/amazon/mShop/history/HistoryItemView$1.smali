.class Lcom/amazon/mShop/history/HistoryItemView$1;
.super Ljava/lang/Object;
.source "HistoryItemView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/history/HistoryItemView;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/history/HistoryItemView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/history/HistoryItemView;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/amazon/mShop/history/HistoryItemView$1;->this$0:Lcom/amazon/mShop/history/HistoryItemView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryItemView$1;->this$0:Lcom/amazon/mShop/history/HistoryItemView;

    invoke-virtual {v0}, Lcom/amazon/mShop/history/HistoryItemView;->showUndoGroup()V

    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryItemView$1;->this$0:Lcom/amazon/mShop/history/HistoryItemView;

    # getter for: Lcom/amazon/mShop/history/HistoryItemView;->mObserver:Lcom/amazon/mShop/history/ObjectDeletingObserver;
    invoke-static {v0}, Lcom/amazon/mShop/history/HistoryItemView;->access$000(Lcom/amazon/mShop/history/HistoryItemView;)Lcom/amazon/mShop/history/ObjectDeletingObserver;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/history/HistoryItemView$1;->this$0:Lcom/amazon/mShop/history/HistoryItemView;

    # getter for: Lcom/amazon/mShop/history/HistoryItemView;->mObserver:Lcom/amazon/mShop/history/ObjectDeletingObserver;
    invoke-static {v0}, Lcom/amazon/mShop/history/HistoryItemView;->access$000(Lcom/amazon/mShop/history/HistoryItemView;)Lcom/amazon/mShop/history/ObjectDeletingObserver;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/history/HistoryItemView$1;->this$0:Lcom/amazon/mShop/history/HistoryItemView;

    # getter for: Lcom/amazon/mShop/history/HistoryItemView;->mIndex:I
    invoke-static {v1}, Lcom/amazon/mShop/history/HistoryItemView;->access$100(Lcom/amazon/mShop/history/HistoryItemView;)I

    move-result v1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/history/ObjectDeletingObserver;->deleteObjectInIndex(I)Z

    .line 66
    :cond_0
    return-void
.end method
