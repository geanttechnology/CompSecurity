.class Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;
.super Ljava/lang/Object;
.source "ViewItSlidingDrawerView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->onToolBarItemSelected(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

.field final synthetic val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;Lcom/amazon/mShop/AmazonAlertDialog;)V
    .locals 0

    .prologue
    .line 304
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 308
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->deleteAllObjects()V

    .line 309
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # invokes: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->hideProgressBar()V
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$100(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    .line 310
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mHeaderContent:Landroid/view/View;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$200(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Landroid/view/View;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 311
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mBottomToolBar:Lcom/amazon/mShop/ui/BottomToolBar;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$400(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/ui/BottomToolBar;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mDeleteAllButton:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;
    invoke-static {v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/ui/BottomToolBar;->setToolBarItemEnabled(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;Z)V

    .line 313
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->mAdapter:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->access$500(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->notifyDataSetChanged()V

    .line 314
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->animateClose()V
    :try_end_0
    .catch Lcom/amazon/mShop/util/DBException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 318
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 320
    :goto_0
    return-void

    .line 315
    :catch_0
    move-exception v0

    .line 316
    .local v0, "e":Lcom/amazon/mShop/util/DBException;
    :try_start_1
    invoke-virtual {v0}, Lcom/amazon/mShop/util/DBException;->printStackTrace()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 318
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    goto :goto_0

    .end local v0    # "e":Lcom/amazon/mShop/util/DBException;
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$3;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    throw v1
.end method
