.class Lcom/livemixtapes/MixtapeList$1;
.super Ljava/lang/Object;
.source "MixtapeList.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/MixtapeList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private previousLast:I

.field final synthetic this$0:Lcom/livemixtapes/MixtapeList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/MixtapeList;)V
    .locals 1

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/MixtapeList$1;->this$0:Lcom/livemixtapes/MixtapeList;

    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 103
    const/4 v0, -0x1

    iput v0, p0, Lcom/livemixtapes/MixtapeList$1;->previousLast:I

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 3
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "visibleItemCount"    # I
    .param p4, "totalItemCount"    # I

    .prologue
    .line 111
    add-int v0, p2, p3

    .line 112
    .local v0, "lastItem":I
    if-ne v0, p4, :cond_0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    iget v1, p0, Lcom/livemixtapes/MixtapeList$1;->previousLast:I

    if-eq v0, v1, :cond_0

    .line 113
    iput v0, p0, Lcom/livemixtapes/MixtapeList$1;->previousLast:I

    .line 114
    iget-object v1, p0, Lcom/livemixtapes/MixtapeList$1;->this$0:Lcom/livemixtapes/MixtapeList;

    iget v2, v1, Lcom/livemixtapes/MixtapeList;->curPage:I

    add-int/lit8 v2, v2, 0x1

    iput v2, v1, Lcom/livemixtapes/MixtapeList;->curPage:I

    .line 115
    iget-object v1, p0, Lcom/livemixtapes/MixtapeList$1;->this$0:Lcom/livemixtapes/MixtapeList;

    # invokes: Lcom/livemixtapes/MixtapeList;->loadNextPage()V
    invoke-static {v1}, Lcom/livemixtapes/MixtapeList;->access$0(Lcom/livemixtapes/MixtapeList;)V

    .line 117
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 107
    return-void
.end method
