.class Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$2;
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
    .line 296
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$2;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$2;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 299
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$2;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 300
    return-void
.end method
