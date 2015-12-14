.class Lcom/livemixtapes/ui/widgets/SearchView$3;
.super Ljava/lang/Object;
.source "SearchView.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/ui/widgets/SearchView;->attachEvents()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/ui/widgets/SearchView;


# direct methods
.method constructor <init>(Lcom/livemixtapes/ui/widgets/SearchView;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView$3;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    .line 129
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 2
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 134
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$3;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->isExpanded:Z
    invoke-static {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->access$2(Lcom/livemixtapes/ui/widgets/SearchView;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$3;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$3(Lcom/livemixtapes/ui/widgets/SearchView;Z)V

    .line 137
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/SearchView$3;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$3;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->isExpanded:Z
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$2(Lcom/livemixtapes/ui/widgets/SearchView;)Z

    move-result v1

    # invokes: Lcom/livemixtapes/ui/widgets/SearchView;->startAnimation(Z)V
    invoke-static {v0, v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$4(Lcom/livemixtapes/ui/widgets/SearchView;Z)V

    .line 139
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
