.class Lcom/amazon/mShop/search/viewit/ViewItItemView$2;
.super Ljava/lang/Object;
.source "ViewItItemView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/search/viewit/ViewItItemView;->onFinishInflate()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItItemView;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 117
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->showItemContent()V

    .line 118
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    invoke-static {v0}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$300(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItItemView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItItemView;

    # getter for: Lcom/amazon/mShop/search/viewit/ViewItItemView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    invoke-static {v1}, Lcom/amazon/mShop/search/viewit/ViewItItemView;->access$000(Lcom/amazon/mShop/search/viewit/ViewItItemView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->recoverUndo(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    .line 121
    :cond_0
    return-void
.end method
