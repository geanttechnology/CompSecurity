.class Lcom/livemixtapes/SearchFragment$2;
.super Ljava/lang/Object;
.source "SearchFragment.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/SearchFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private previousLast:I

.field final synthetic this$0:Lcom/livemixtapes/SearchFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SearchFragment;)V
    .locals 1

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SearchFragment$2;->this$0:Lcom/livemixtapes/SearchFragment;

    .line 201
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 202
    const/4 v0, -0x1

    iput v0, p0, Lcom/livemixtapes/SearchFragment$2;->previousLast:I

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
    .line 210
    add-int v0, p2, p3

    .line 211
    .local v0, "lastItem":I
    if-ne v0, p4, :cond_0

    const/4 v1, 0x1

    if-le p4, v1, :cond_0

    iget v1, p0, Lcom/livemixtapes/SearchFragment$2;->previousLast:I

    if-eq v0, v1, :cond_0

    .line 212
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$2;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v1, v1, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v1}, Lcom/livemixtapes/LazyAdapterSearch;->isTopArtistSearch()Z

    move-result v1

    if-nez v1, :cond_1

    .line 213
    iput v0, p0, Lcom/livemixtapes/SearchFragment$2;->previousLast:I

    .line 214
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$2;->this$0:Lcom/livemixtapes/SearchFragment;

    iget v2, v1, Lcom/livemixtapes/SearchFragment;->curPage:I

    add-int/lit8 v2, v2, 0x1

    iput v2, v1, Lcom/livemixtapes/SearchFragment;->curPage:I

    .line 215
    iget-object v1, p0, Lcom/livemixtapes/SearchFragment$2;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v2, p0, Lcom/livemixtapes/SearchFragment$2;->this$0:Lcom/livemixtapes/SearchFragment;

    iget-object v2, v2, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v2}, Lcom/livemixtapes/ui/widgets/SearchView;->getQuery()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SearchFragment;->loadSearchResults(Ljava/lang/String;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SearchFragment;->access$1(Lcom/livemixtapes/SearchFragment;Ljava/lang/String;)V

    .line 220
    :cond_0
    :goto_0
    return-void

    .line 217
    :cond_1
    const/4 v1, -0x1

    iput v1, p0, Lcom/livemixtapes/SearchFragment$2;->previousLast:I

    goto :goto_0
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "view"    # Landroid/widget/AbsListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 206
    return-void
.end method
