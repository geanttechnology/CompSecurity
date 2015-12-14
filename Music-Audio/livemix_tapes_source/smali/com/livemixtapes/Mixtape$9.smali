.class Lcom/livemixtapes/Mixtape$9;
.super Ljava/lang/Object;
.source "Mixtape.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtape;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtape;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtape;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    .line 680
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 684
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const-string v3, "mixtape"

    const-string v4, "track clicked"

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 688
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->tracks:Landroid/widget/ListView;
    invoke-static {v3}, Lcom/livemixtapes/Mixtape;->access$32(Lcom/livemixtapes/Mixtape;)Landroid/widget/ListView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v3

    sub-int/2addr p3, v3

    .line 690
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    .line 691
    const-string v4, "tracks"

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 695
    .local v0, "d":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    :try_start_0
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->playlistMode:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 696
    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/HashMap;

    const-string v4, "track_id"

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 697
    .local v2, "trackId":Ljava/lang/String;
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 699
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 701
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    const/4 v4, 0x0

    invoke-virtual {v3, p3, v4}, Lcom/livemixtapes/Mixtape;->updatePlayListSelectionBackground(IZ)V

    .line 751
    .end local v2    # "trackId":Ljava/lang/String;
    :goto_0
    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/HashMap;

    const-string v4, "track_title"

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 752
    iget-object v4, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    # getter for: Lcom/livemixtapes/Mixtape;->cover:Landroid/widget/ImageView;
    invoke-static {v4}, Lcom/livemixtapes/Mixtape;->access$29(Lcom/livemixtapes/Mixtape;)Landroid/widget/ImageView;

    move-result-object v4

    .line 751
    invoke-static {v3, v4}, Lcom/livemixtapes/App;->showNotification(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 756
    :goto_1
    return-void

    .line 705
    .restart local v2    # "trackId":Ljava/lang/String;
    :cond_0
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 706
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    const/4 v4, 0x1

    invoke-virtual {v3, p3, v4}, Lcom/livemixtapes/Mixtape;->updatePlayListSelectionBackground(IZ)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 753
    .end local v2    # "trackId":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 754
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 712
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_1
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    iget-object v3, v3, Lcom/livemixtapes/Mixtape;->mixtape:Ljava/util/Map;

    sput-object v3, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    .line 713
    sput p3, Lcom/livemixtapes/NowPlayingActivity;->position:I

    .line 714
    const/4 v3, 0x1

    sput v3, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    .line 715
    const/4 v3, 0x1

    sput-boolean v3, Lcom/livemixtapes/MainActivity;->isPlaying:Z

    .line 716
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->initializeAndReload()V

    .line 717
    sget-object v3, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    const v4, 0x7f0200f8

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 718
    iget-object v3, p0, Lcom/livemixtapes/Mixtape$9;->this$0:Lcom/livemixtapes/Mixtape;

    sget-object v4, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    const/4 v5, 0x0

    # invokes: Lcom/livemixtapes/Mixtape;->shake(Landroid/view/View;Ljava/lang/Runnable;)V
    invoke-static {v3, v4, v5}, Lcom/livemixtapes/Mixtape;->access$33(Lcom/livemixtapes/Mixtape;Landroid/view/View;Ljava/lang/Runnable;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method
