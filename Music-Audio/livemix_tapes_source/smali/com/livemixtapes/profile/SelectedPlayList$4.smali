.class Lcom/livemixtapes/profile/SelectedPlayList$4;
.super Ljava/lang/Object;
.source "SelectedPlayList.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SelectedPlayList;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    .line 103
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 8
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x4

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 106
    iget-object v6, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-boolean v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    if-eqz v3, :cond_2

    move v3, v4

    :goto_0
    iput-boolean v3, v6, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    .line 107
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-boolean v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-boolean v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->isSomethingChanged:Z

    if-eqz v3, :cond_0

    .line 109
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iput-boolean v4, v3, Lcom/livemixtapes/profile/SelectedPlayList;->isSomethingChanged:Z

    .line 110
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 111
    .local v2, "trackDBIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->trackList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_3

    .line 113
    const-string v3, ","

    invoke-static {v3, v2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v0

    .line 114
    .local v0, "joinedStr":Ljava/lang/String;
    new-instance v3, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;

    iget-object v6, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    invoke-direct {v3, v6, v5}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;I)V

    new-array v6, v5, [Ljava/lang/String;

    aput-object v0, v6, v4

    invoke-virtual {v3, v6}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 117
    .end local v0    # "joinedStr":Ljava/lang/String;
    .end local v2    # "trackDBIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-boolean v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    if-eqz v3, :cond_4

    .line 119
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3, v5}, Landroid/widget/EditText;->setFocusable(Z)V

    .line 120
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3, v5}, Landroid/widget/EditText;->setFocusableInTouchMode(Z)V

    .line 121
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3, v5}, Landroid/widget/EditText;->setCursorVisible(Z)V

    .line 122
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->downloadButton:Landroid/widget/ImageButton;

    invoke-virtual {v3, v7}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 123
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->playButton:Landroid/widget/ImageButton;

    invoke-virtual {v3, v7}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 124
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->requestFocus()Z

    .line 125
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    iget-object v4, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v4, v4, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-interface {v4}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setSelection(I)V

    .line 135
    :cond_1
    :goto_2
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    invoke-virtual {v3}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->notifyDataSetChanged()V

    .line 136
    return-void

    :cond_2
    move v3, v5

    .line 106
    goto/16 :goto_0

    .line 111
    .restart local v2    # "trackDBIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 112
    .local v1, "obj":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v6, "track_dbid"

    invoke-interface {v1, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 129
    .end local v1    # "obj":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v2    # "trackDBIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_4
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setFocusable(Z)V

    .line 130
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->downloadButton:Landroid/widget/ImageButton;

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 131
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v3, v3, Lcom/livemixtapes/profile/SelectedPlayList;->playButton:Landroid/widget/ImageButton;

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 132
    sget-object v3, Lcom/livemixtapes/profile/SelectedPlayList;->map:Ljava/util/Map;

    const-string v6, "title"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v6, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v6, v6, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-interface {v6}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 133
    new-instance v3, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;

    iget-object v6, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    const/4 v7, 0x3

    invoke-direct {v3, v6, v7}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;I)V

    new-array v5, v5, [Ljava/lang/String;

    iget-object v6, p0, Lcom/livemixtapes/profile/SelectedPlayList$4;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v6, v6, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-interface {v6}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v4

    invoke-virtual {v3, v5}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2
.end method
