.class Lcom/livemixtapes/profile/SelectedPlayList$2;
.super Ljava/lang/Object;
.source "SelectedPlayList.java"

# interfaces
.implements Lcom/mobeta/android/dslv/DragSortListView$RemoveListener;


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
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$2;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    .line 328
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public remove(I)V
    .locals 2
    .param p1, "which"    # I

    .prologue
    .line 331
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$2;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList$2;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v1, v1, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    invoke-virtual {v1, p1}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    # invokes: Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->remove(Ljava/lang/Object;)V
    invoke-static {v0, v1}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->access$0(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;Ljava/lang/Object;)V

    .line 332
    return-void
.end method
