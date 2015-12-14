.class Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$1;
.super Ljava/lang/Object;
.source "SeeAllList.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

.field private final synthetic val$map:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$1;->this$1:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    iput-object p2, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$1;->val$map:Ljava/util/Map;

    .line 269
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 272
    new-instance v0, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;

    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$1;->this$1:Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;

    # getter for: Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;
    invoke-static {v1}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->access$0(Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;)Lcom/livemixtapes/profile/SeeAllList;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;-><init>(Lcom/livemixtapes/profile/SeeAllList;)V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$1;->val$map:Ljava/util/Map;

    const-string v4, "playlist_id"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/livemixtapes/profile/SeeAllList$DeletePlaylist;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 273
    return-void
.end method
