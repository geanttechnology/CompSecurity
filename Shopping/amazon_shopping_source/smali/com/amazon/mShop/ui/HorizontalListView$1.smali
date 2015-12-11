.class Lcom/amazon/mShop/ui/HorizontalListView$1;
.super Landroid/database/DataSetObserver;
.source "HorizontalListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/ui/HorizontalListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/ui/HorizontalListView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/ui/HorizontalListView;)V
    .locals 0

    .prologue
    .line 152
    iput-object p1, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 3

    .prologue
    .line 156
    iget-object v1, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    monitor-enter v1

    .line 157
    :try_start_0
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    const/4 v2, 0x1

    # setter for: Lcom/amazon/mShop/ui/HorizontalListView;->mDataChanged:Z
    invoke-static {v0, v2}, Lcom/amazon/mShop/ui/HorizontalListView;->access$002(Lcom/amazon/mShop/ui/HorizontalListView;Z)Z

    .line 158
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->invalidate()V

    .line 160
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->requestLayout()V

    .line 161
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/ui/HorizontalListView;->mCanReceiveKeyEvent:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->access$102(Lcom/amazon/mShop/ui/HorizontalListView;Z)Z

    .line 162
    return-void

    .line 158
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public onInvalidated()V
    .locals 2

    .prologue
    .line 166
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # invokes: Lcom/amazon/mShop/ui/HorizontalListView;->reset()V
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$200(Lcom/amazon/mShop/ui/HorizontalListView;)V

    .line 167
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->invalidate()V

    .line 168
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    invoke-virtual {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->requestLayout()V

    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$1;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/ui/HorizontalListView;->mCanReceiveKeyEvent:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/ui/HorizontalListView;->access$102(Lcom/amazon/mShop/ui/HorizontalListView;Z)Z

    .line 170
    return-void
.end method
