.class Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$1;
.super Ljava/lang/Object;
.source "ViewItSlidingDrawerView.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


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


# direct methods
.method constructor <init>(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V
    .locals 0

    .prologue
    .line 285
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$1;->this$0:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 288
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 289
    return-void
.end method
