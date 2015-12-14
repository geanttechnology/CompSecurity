.class Lcom/livemixtapes/profile/SelectedPlayList$1;
.super Ljava/lang/Object;
.source "SelectedPlayList.java"

# interfaces
.implements Lcom/mobeta/android/dslv/DragSortListView$DropListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/profile/SelectedPlayList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/profile/SelectedPlayList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SelectedPlayList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$1;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    .line 315
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public drop(II)V
    .locals 3
    .param p1, "from"    # I
    .param p2, "to"    # I

    .prologue
    .line 318
    if-eq p1, p2, :cond_0

    .line 319
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList$1;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    const/4 v2, 0x1

    iput-boolean v2, v1, Lcom/livemixtapes/profile/SelectedPlayList;->isSomethingChanged:Z

    .line 320
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList$1;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    invoke-virtual {v1, p1}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    .line 321
    .local v0, "item":Ljava/lang/Object;
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList$1;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    # invokes: Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->remove(Ljava/lang/Object;)V
    invoke-static {v1, v0}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->access$0(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;Ljava/lang/Object;)V

    .line 322
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList$1;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    # invokes: Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->insert(Ljava/lang/Object;I)V
    invoke-static {v1, v0, p2}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->access$1(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;Ljava/lang/Object;I)V

    .line 323
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList$1;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    invoke-virtual {v1}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->notifyDataSetChanged()V

    .line 325
    .end local v0    # "item":Ljava/lang/Object;
    :cond_0
    return-void
.end method
