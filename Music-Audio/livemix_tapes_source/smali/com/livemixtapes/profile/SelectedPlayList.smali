.class public Lcom/livemixtapes/profile/SelectedPlayList;
.super Landroid/app/Fragment;
.source "SelectedPlayList.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;,
        Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;
    }
.end annotation


# static fields
.field public static flag:I

.field public static map:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

.field downloadButton:Landroid/widget/ImageButton;

.field isEditMode:Z

.field isSomethingChanged:Z

.field layoutBack:Landroid/widget/LinearLayout;

.field mContext:Landroid/content/Context;

.field private onDrop:Lcom/mobeta/android/dslv/DragSortListView$DropListener;

.field private onRemove:Lcom/mobeta/android/dslv/DragSortListView$RemoveListener;

.field playButton:Landroid/widget/ImageButton;

.field playListView:Lcom/mobeta/android/dslv/DragSortListView;

.field playlistName:Landroid/widget/EditText;

.field rootView:Landroid/view/View;

.field textViewAction:Landroid/widget/TextView;

.field textViewBack:Landroid/widget/TextView;

.field trackList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 55
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList;->trackList:Ljava/util/ArrayList;

    .line 315
    new-instance v0, Lcom/livemixtapes/profile/SelectedPlayList$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/profile/SelectedPlayList$1;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;)V

    iput-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList;->onDrop:Lcom/mobeta/android/dslv/DragSortListView$DropListener;

    .line 328
    new-instance v0, Lcom/livemixtapes/profile/SelectedPlayList$2;

    invoke-direct {v0, p0}, Lcom/livemixtapes/profile/SelectedPlayList$2;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;)V

    iput-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList;->onRemove:Lcom/mobeta/android/dslv/DragSortListView$RemoveListener;

    .line 55
    return-void
.end method

.method private shake(Landroid/content/Context;Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "callback"    # Ljava/lang/Runnable;

    .prologue
    .line 466
    const v1, 0x7f04000c

    invoke-static {p1, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 468
    .local v0, "anim":Landroid/view/animation/Animation;
    new-instance v1, Lcom/livemixtapes/profile/SelectedPlayList$7;

    invoke-direct {v1, p0, p3}, Lcom/livemixtapes/profile/SelectedPlayList$7;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 486
    invoke-virtual {p2, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 487
    return-void
.end method


# virtual methods
.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflater"    # Landroid/view/MenuInflater;

    .prologue
    .line 338
    const v0, 0x7f100002

    invoke-virtual {p2, v0, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 340
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 78
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    if-nez v1, :cond_0

    .line 79
    invoke-virtual {p0}, Lcom/livemixtapes/profile/SelectedPlayList;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->mContext:Landroid/content/Context;

    .line 80
    const v1, 0x7f03002f

    invoke-virtual {p1, v1, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    .line 81
    iput-boolean v4, p0, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    .line 82
    iput-boolean v4, p0, Lcom/livemixtapes/profile/SelectedPlayList;->isSomethingChanged:Z

    .line 83
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    const v2, 0x7f0800e6

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/mobeta/android/dslv/DragSortListView;

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playListView:Lcom/mobeta/android/dslv/DragSortListView;

    .line 84
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    const v2, 0x7f0800e8

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playButton:Landroid/widget/ImageButton;

    .line 85
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    const v2, 0x7f0800e9

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->downloadButton:Landroid/widget/ImageButton;

    .line 88
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    const v2, 0x7f08006d

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->layoutBack:Landroid/widget/LinearLayout;

    .line 89
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    const v2, 0x7f08006f

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->textViewBack:Landroid/widget/TextView;

    .line 90
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    const v2, 0x7f0800e5

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->textViewAction:Landroid/widget/TextView;

    .line 92
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->layoutBack:Landroid/widget/LinearLayout;

    new-instance v2, Lcom/livemixtapes/profile/SelectedPlayList$3;

    invoke-direct {v2, p0}, Lcom/livemixtapes/profile/SelectedPlayList$3;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->textViewAction:Landroid/widget/TextView;

    const-string v2, "Edit"

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->textViewAction:Landroid/widget/TextView;

    new-instance v2, Lcom/livemixtapes/profile/SelectedPlayList$4;

    invoke-direct {v2, p0}, Lcom/livemixtapes/profile/SelectedPlayList$4;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 139
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playButton:Landroid/widget/ImageButton;

    new-instance v2, Lcom/livemixtapes/profile/SelectedPlayList$5;

    invoke-direct {v2, p0}, Lcom/livemixtapes/profile/SelectedPlayList$5;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 146
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    const v2, 0x7f0800e7

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    .line 147
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    sget-object v2, Lcom/livemixtapes/profile/SelectedPlayList;->map:Ljava/util/Map;

    const-string v3, "title"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 148
    new-instance v1, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    invoke-virtual {p0}, Lcom/livemixtapes/profile/SelectedPlayList;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;Landroid/app/Activity;)V

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    .line 149
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playListView:Lcom/mobeta/android/dslv/DragSortListView;

    iget-object v2, p0, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    invoke-virtual {v1, v2}, Lcom/mobeta/android/dslv/DragSortListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 151
    sget-object v1, Lcom/livemixtapes/profile/SelectedPlayList;->map:Ljava/util/Map;

    const-string v2, "tracks"

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    iput-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->trackList:Ljava/util/ArrayList;

    .line 152
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playListView:Lcom/mobeta/android/dslv/DragSortListView;

    iget-object v2, p0, Lcom/livemixtapes/profile/SelectedPlayList;->onDrop:Lcom/mobeta/android/dslv/DragSortListView$DropListener;

    invoke-virtual {v1, v2}, Lcom/mobeta/android/dslv/DragSortListView;->setDropListener(Lcom/mobeta/android/dslv/DragSortListView$DropListener;)V

    .line 153
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playListView:Lcom/mobeta/android/dslv/DragSortListView;

    iget-object v2, p0, Lcom/livemixtapes/profile/SelectedPlayList;->onRemove:Lcom/mobeta/android/dslv/DragSortListView$RemoveListener;

    invoke-virtual {v1, v2}, Lcom/mobeta/android/dslv/DragSortListView;->setRemoveListener(Lcom/mobeta/android/dslv/DragSortListView$RemoveListener;)V

    .line 155
    new-instance v0, Lcom/mobeta/android/dslv/DragSortController;

    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playListView:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-direct {v0, v1}, Lcom/mobeta/android/dslv/DragSortController;-><init>(Lcom/mobeta/android/dslv/DragSortListView;)V

    .line 156
    .local v0, "controller":Lcom/mobeta/android/dslv/DragSortController;
    const v1, 0x7f08013a

    invoke-virtual {v0, v1}, Lcom/mobeta/android/dslv/DragSortController;->setDragHandleId(I)V

    .line 158
    invoke-virtual {v0, v4}, Lcom/mobeta/android/dslv/DragSortController;->setRemoveEnabled(Z)V

    .line 159
    invoke-virtual {v0, v5}, Lcom/mobeta/android/dslv/DragSortController;->setSortEnabled(Z)V

    .line 160
    invoke-virtual {v0, v5}, Lcom/mobeta/android/dslv/DragSortController;->setDragInitMode(I)V

    .line 163
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playListView:Lcom/mobeta/android/dslv/DragSortListView;

    new-instance v2, Lcom/livemixtapes/profile/SelectedPlayList$6;

    invoke-direct {v2, p0}, Lcom/livemixtapes/profile/SelectedPlayList$6;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;)V

    invoke-virtual {v1, v2}, Lcom/mobeta/android/dslv/DragSortListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 172
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playListView:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v1, v0}, Lcom/mobeta/android/dslv/DragSortListView;->setFloatViewManager(Lcom/mobeta/android/dslv/DragSortListView$FloatViewManager;)V

    .line 173
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playListView:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v1, v0}, Lcom/mobeta/android/dslv/DragSortListView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 174
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playListView:Lcom/mobeta/android/dslv/DragSortListView;

    invoke-virtual {v1, v5}, Lcom/mobeta/android/dslv/DragSortListView;->setDragEnabled(Z)V

    .line 180
    .end local v0    # "controller":Lcom/mobeta/android/dslv/DragSortController;
    :cond_0
    iget-object v1, p0, Lcom/livemixtapes/profile/SelectedPlayList;->rootView:Landroid/view/View;

    return-object v1
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 8
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v7, 0x4

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 345
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 379
    :goto_0
    invoke-super {p0, p1}, Landroid/app/Fragment;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v3

    return v3

    .line 347
    :pswitch_0
    iget-boolean v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    if-eqz v3, :cond_2

    move v3, v4

    :goto_1
    iput-boolean v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    .line 348
    iget-boolean v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    if-nez v3, :cond_0

    iget-boolean v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->isSomethingChanged:Z

    if-eqz v3, :cond_0

    .line 350
    iput-boolean v4, p0, Lcom/livemixtapes/profile/SelectedPlayList;->isSomethingChanged:Z

    .line 351
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 352
    .local v2, "trackDBIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->trackList:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_3

    .line 354
    const-string v3, ","

    invoke-static {v3, v2}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v0

    .line 355
    .local v0, "joinedStr":Ljava/lang/String;
    new-instance v3, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;

    invoke-direct {v3, p0, v5}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;I)V

    new-array v6, v5, [Ljava/lang/String;

    aput-object v0, v6, v4

    invoke-virtual {v3, v6}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 358
    .end local v0    # "joinedStr":Ljava/lang/String;
    .end local v2    # "trackDBIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    iget-boolean v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    if-eqz v3, :cond_4

    .line 360
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3, v5}, Landroid/widget/EditText;->setFocusable(Z)V

    .line 361
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3, v5}, Landroid/widget/EditText;->setFocusableInTouchMode(Z)V

    .line 362
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3, v5}, Landroid/widget/EditText;->setCursorVisible(Z)V

    .line 363
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->downloadButton:Landroid/widget/ImageButton;

    invoke-virtual {v3, v7}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 364
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playButton:Landroid/widget/ImageButton;

    invoke-virtual {v3, v7}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 365
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->requestFocus()Z

    .line 366
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    iget-object v4, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v4

    invoke-interface {v4}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setSelection(I)V

    .line 376
    :cond_1
    :goto_3
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->adapter:Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;

    invoke-virtual {v3}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->notifyDataSetChanged()V

    goto :goto_0

    :cond_2
    move v3, v5

    .line 347
    goto :goto_1

    .line 352
    .restart local v2    # "trackDBIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map;

    .line 353
    .local v1, "obj":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v6, "track_dbid"

    invoke-interface {v1, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v2, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 370
    .end local v1    # "obj":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v2    # "trackDBIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_4
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v3, v4}, Landroid/widget/EditText;->setFocusable(Z)V

    .line 371
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->downloadButton:Landroid/widget/ImageButton;

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 372
    iget-object v3, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playButton:Landroid/widget/ImageButton;

    invoke-virtual {v3, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 373
    sget-object v3, Lcom/livemixtapes/profile/SelectedPlayList;->map:Ljava/util/Map;

    const-string v6, "title"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v6, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-interface {v6}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 374
    new-instance v3, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;

    const/4 v6, 0x3

    invoke-direct {v3, p0, v6}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;-><init>(Lcom/livemixtapes/profile/SelectedPlayList;I)V

    new-array v5, v5, [Ljava/lang/String;

    iget-object v6, p0, Lcom/livemixtapes/profile/SelectedPlayList;->playlistName:Landroid/widget/EditText;

    invoke-virtual {v6}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v6

    invoke-interface {v6}, Landroid/text/Editable;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v4

    invoke-virtual {v3, v5}, Lcom/livemixtapes/profile/SelectedPlayList$ReorderOrDeleteTracks;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_3

    .line 345
    nop

    :pswitch_data_0
    .packed-switch 0x7f08013e
        :pswitch_0
    .end packed-switch
.end method

.method openNowPlaying(I)V
    .locals 3
    .param p1, "position"    # I

    .prologue
    const/4 v2, 0x0

    .line 185
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList;->mContext:Landroid/content/Context;

    sget-object v1, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    invoke-direct {p0, v0, v1, v2}, Lcom/livemixtapes/profile/SelectedPlayList;->shake(Landroid/content/Context;Landroid/view/View;Ljava/lang/Runnable;)V

    .line 186
    sget-object v0, Lcom/livemixtapes/profile/SelectedPlayList;->map:Ljava/util/Map;

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->playList:Ljava/util/Map;

    .line 187
    sput-object v2, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    .line 188
    sput p1, Lcom/livemixtapes/NowPlayingActivity;->position:I

    .line 189
    const/4 v0, 0x3

    sput v0, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    .line 190
    const/4 v0, 0x1

    sput-boolean v0, Lcom/livemixtapes/MainActivity;->isPlaying:Z

    .line 191
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->initializeAndReload()V

    .line 193
    sget-object v0, Lcom/livemixtapes/MainActivity;->nowplayingbutton:Landroid/widget/ImageView;

    const v1, 0x7f0200f8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 223
    return-void
.end method
