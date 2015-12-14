.class Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener$1;
.super Ljava/lang/Object;
.source "PullToRefreshListView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->onAnimationEnd(Landroid/view/animation/Animation;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;


# direct methods
.method constructor <init>(Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener$1;->this$1:Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;

    .line 525
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 529
    iget-object v0, p0, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener$1;->this$1:Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;

    # getter for: Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->this$0:Lcom/livemixtapes/PullToRefreshListView;
    invoke-static {v0}, Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;->access$0(Lcom/livemixtapes/PullToRefreshListView$HeaderAnimationListener;)Lcom/livemixtapes/PullToRefreshListView;

    move-result-object v0

    # invokes: Lcom/livemixtapes/PullToRefreshListView;->resetHeader()V
    invoke-static {v0}, Lcom/livemixtapes/PullToRefreshListView;->access$7(Lcom/livemixtapes/PullToRefreshListView;)V

    .line 530
    return-void
.end method
