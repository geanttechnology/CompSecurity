.class Lcom/livemixtapes/SearchFragment$4;
.super Ljava/lang/Object;
.source "SearchFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SearchFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SearchFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SearchFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SearchFragment$4;->this$0:Lcom/livemixtapes/SearchFragment;

    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 6
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v5, 0x0

    .line 79
    new-instance v0, Landroid/graphics/Rect;

    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$4;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->getLeft()I

    move-result v1

    iget-object v2, p0, Lcom/livemixtapes/SearchFragment$4;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v2, v2, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v2}, Lcom/livemixtapes/ui/widgets/SearchView;->getTop()I

    move-result v2

    iget-object v3, p0, Lcom/livemixtapes/SearchFragment$4;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v3, v3, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v3}, Lcom/livemixtapes/ui/widgets/SearchView;->getRight()I

    move-result v3

    iget-object v4, p0, Lcom/livemixtapes/SearchFragment$4;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v4, v4, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v4}, Lcom/livemixtapes/ui/widgets/SearchView;->getBottom()I

    move-result v4

    invoke-direct {v0, v1, v2, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 80
    .local v0, "rect":Landroid/graphics/Rect;
    invoke-virtual {p1}, Landroid/view/View;->getLeft()I

    move-result v1

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v2

    float-to-int v2, v2

    add-int/2addr v1, v2

    invoke-virtual {p1}, Landroid/view/View;->getTop()I

    move-result v2

    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    float-to-int v3, v3

    add-int/2addr v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/graphics/Rect;->contains(II)Z

    move-result v1

    if-nez v1, :cond_0

    .line 81
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$4;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v1, v5}, Lcom/livemixtapes/ui/widgets/SearchView;->setExpand(Z)V

    .line 83
    :cond_0
    return v5
.end method
