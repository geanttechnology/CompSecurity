.class Lcom/amazon/mShop/ui/HorizontalListView$3$1;
.super Ljava/lang/Object;
.source "HorizontalListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/ui/HorizontalListView$3;->onSingleTapUp(Landroid/view/MotionEvent;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/ui/HorizontalListView$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/ui/HorizontalListView$3;)V
    .locals 0

    .prologue
    .line 498
    iput-object p1, p0, Lcom/amazon/mShop/ui/HorizontalListView$3$1;->this$1:Lcom/amazon/mShop/ui/HorizontalListView$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 501
    iget-object v0, p0, Lcom/amazon/mShop/ui/HorizontalListView$3$1;->this$1:Lcom/amazon/mShop/ui/HorizontalListView$3;

    iget-object v0, v0, Lcom/amazon/mShop/ui/HorizontalListView$3;->this$0:Lcom/amazon/mShop/ui/HorizontalListView;

    # invokes: Lcom/amazon/mShop/ui/HorizontalListView;->setHighlightItemToNormalBackground()V
    invoke-static {v0}, Lcom/amazon/mShop/ui/HorizontalListView;->access$400(Lcom/amazon/mShop/ui/HorizontalListView;)V

    .line 502
    return-void
.end method
