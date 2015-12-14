.class Lcom/livemixtapes/profile/SeeAllList$4;
.super Ljava/lang/Object;
.source "SeeAllList.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SeeAllList;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
.field final synthetic this$0:Lcom/livemixtapes/profile/SeeAllList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SeeAllList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    .line 151
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 10
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
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
    .line 156
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-boolean v5, v5, Lcom/livemixtapes/profile/SeeAllList;->isAddTracksToPlayList:Z

    if-eqz v5, :cond_1

    .line 159
    new-instance v6, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;

    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    const/4 v7, 0x2

    invoke-direct {v6, v5, v7}, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;-><init>(Lcom/livemixtapes/profile/SeeAllList;I)V

    const/4 v5, 0x3

    new-array v7, v5, [Ljava/lang/String;

    const/4 v5, 0x0

    const-string v8, "playlist/add"

    aput-object v8, v7, v5

    const/4 v8, 0x1

    .line 160
    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v5, v5, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v5, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map;

    const-string v9, "playlist_id"

    invoke-interface {v5, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 161
    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v7, v8

    const/4 v5, 0x2

    .line 162
    iget-object v8, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-virtual {v8}, Lcom/livemixtapes/profile/SeeAllList;->getArguments()Landroid/os/Bundle;

    move-result-object v8

    const-string v9, "tracks"

    invoke-virtual {v8, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v5

    .line 159
    invoke-virtual {v6, v7}, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 192
    :cond_0
    :goto_0
    return-void

    .line 164
    :cond_1
    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget v5, v5, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    const/4 v6, 0x1

    if-ne v5, v6, :cond_2

    .line 166
    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v5, v5, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v5, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map;

    sput-object v5, Lcom/livemixtapes/profile/SelectedPlayList;->map:Ljava/util/Map;

    .line 167
    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-virtual {v5}, Lcom/livemixtapes/profile/SeeAllList;->getActivity()Landroid/app/Activity;

    move-result-object v5

    check-cast v5, Lcom/livemixtapes/ui/BaseActivity;

    invoke-virtual {v5}, Lcom/livemixtapes/ui/BaseActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 168
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v3, Lcom/livemixtapes/profile/SelectedPlayList;

    invoke-direct {v3}, Lcom/livemixtapes/profile/SelectedPlayList;-><init>()V

    .line 169
    .local v3, "selectedPlaylist":Lcom/livemixtapes/profile/SelectedPlayList;
    const v5, 0x7f0800cc

    const-string v6, "SELECTED"

    invoke-virtual {v1, v5, v3, v6}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 170
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_0

    .line 172
    .end local v1    # "fragmentTransaction":Landroid/app/FragmentTransaction;
    .end local v3    # "selectedPlaylist":Lcom/livemixtapes/profile/SelectedPlayList;
    :cond_2
    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget v5, v5, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    const/4 v6, 0x2

    if-ne v5, v6, :cond_3

    .line 173
    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v5, v5, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v5, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    .line 174
    .local v2, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v5, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;

    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-direct {v5, v6}, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;-><init>(Lcom/livemixtapes/profile/SeeAllList;)V

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    const-string v8, "albumId"

    invoke-interface {v2, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    .line 175
    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    .line 174
    invoke-virtual {v5, v6}, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 177
    .end local v2    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_3
    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget v5, v5, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    const/4 v6, 0x3

    if-ne v5, v6, :cond_0

    .line 178
    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v5, v5, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v5, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    .line 181
    .restart local v2    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v5, "tracks"

    invoke-interface {v2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    .line 183
    .local v4, "trackmap":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap;>;"
    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    .line 187
    .local v0, "firsttrackmap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v6, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;

    iget-object v5, p0, Lcom/livemixtapes/profile/SeeAllList$4;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-direct {v6, v5}, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;-><init>(Lcom/livemixtapes/profile/SeeAllList;)V

    const/4 v5, 0x1

    new-array v7, v5, [Ljava/lang/String;

    const/4 v8, 0x0

    const-string v5, "track_album"

    invoke-virtual {v0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 188
    invoke-virtual {v5}, Ljava/lang/String;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v7, v8

    .line 187
    invoke-virtual {v6, v7}, Lcom/livemixtapes/profile/SeeAllList$LoadMixtapeData;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0
.end method
