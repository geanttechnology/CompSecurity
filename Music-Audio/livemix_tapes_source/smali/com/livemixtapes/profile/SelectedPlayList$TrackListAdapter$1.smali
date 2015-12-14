.class Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;
.super Ljava/lang/Object;
.source "SelectedPlayList.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

.field private final synthetic val$trackMap:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;->this$1:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    iput-object p2, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;->val$trackMap:Ljava/util/Map;

    .line 294
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 297
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;->this$1:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    # getter for: Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;
    invoke-static {v0}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->access$2(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;)Lcom/livemixtapes/profile/SelectedPlayList;

    move-result-object v0

    iget-object v0, v0, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;->val$trackMap:Ljava/util/Map;

    # invokes: Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->remove(Ljava/lang/Object;)V
    invoke-static {v0, v1}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->access$0(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;Ljava/lang/Object;)V

    .line 298
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;->this$1:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    # getter for: Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;
    invoke-static {v0}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->access$2(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;)Lcom/livemixtapes/profile/SelectedPlayList;

    move-result-object v0

    iget-object v0, v0, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    invoke-virtual {v0}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->notifyDataSetChanged()V

    .line 299
    new-instance v0, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;

    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;->this$1:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    # getter for: Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;
    invoke-static {v1}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->access$2(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;)Lcom/livemixtapes/profile/SelectedPlayList;

    move-result-object v1

    const/4 v2, 0x2

    invoke-direct {v0, v1, v2}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;I)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;->val$trackMap:Ljava/util/Map;

    const-string v4, "track_dbid"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 300
    return-void
.end method
