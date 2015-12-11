.class Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItemOnClickListener;
.super Ljava/lang/Object;
.source "BottomToolBar.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/ui/BottomToolBar;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ToolBarItemOnClickListener"
.end annotation


# instance fields
.field mItem:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

.field final synthetic this$0:Lcom/amazon/mShop/ui/BottomToolBar;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/ui/BottomToolBar;Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;)V
    .locals 0
    .param p2, "item"    # Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .prologue
    .line 190
    iput-object p1, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItemOnClickListener;->this$0:Lcom/amazon/mShop/ui/BottomToolBar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 191
    iput-object p2, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItemOnClickListener;->mItem:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    .line 192
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 196
    iget-object v0, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItemOnClickListener;->this$0:Lcom/amazon/mShop/ui/BottomToolBar;

    # getter for: Lcom/amazon/mShop/ui/BottomToolBar;->mToolBarParent:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;
    invoke-static {v0}, Lcom/amazon/mShop/ui/BottomToolBar;->access$000(Lcom/amazon/mShop/ui/BottomToolBar;)Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 197
    iget-object v0, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItemOnClickListener;->this$0:Lcom/amazon/mShop/ui/BottomToolBar;

    # getter for: Lcom/amazon/mShop/ui/BottomToolBar;->mToolBarParent:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;
    invoke-static {v0}, Lcom/amazon/mShop/ui/BottomToolBar;->access$000(Lcom/amazon/mShop/ui/BottomToolBar;)Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItemOnClickListener;->mItem:Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/ui/BottomToolBar$ToolBarParent;->onToolBarItemSelected(Lcom/amazon/mShop/ui/BottomToolBar$ToolBarItem;)V

    .line 199
    :cond_0
    return-void
.end method
