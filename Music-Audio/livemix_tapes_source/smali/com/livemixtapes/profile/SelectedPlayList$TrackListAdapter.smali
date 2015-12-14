.class public Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;
.super Landroid/widget/BaseAdapter;
.source "SelectedPlayList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/profile/SelectedPlayList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "TrackListAdapter"
.end annotation


# instance fields
.field private activity:Landroid/app/Activity;

.field private inflater:Landroid/view/LayoutInflater;

.field final synthetic this$0:Lcom/livemixtapes/profile/SelectedPlayList;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/profile/SelectedPlayList;Landroid/app/Activity;)V
    .locals 0
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 229
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 230
    iput-object p2, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->activity:Landroid/app/Activity;

    .line 231
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 248
    invoke-direct {p0, p1}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->remove(Ljava/lang/Object;)V

    return-void
.end method

.method static synthetic access$1(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;Ljava/lang/Object;I)V
    .locals 0

    .prologue
    .line 253
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->insert(Ljava/lang/Object;I)V

    return-void
.end method

.method static synthetic access$2(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;)Lcom/livemixtapes/profile/SelectedPlayList;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    return-object v0
.end method

.method private insert(Ljava/lang/Object;I)V
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;
    .param p2, "position"    # I

    .prologue
    .line 255
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SelectedPlayList;->trackList:Ljava/util/ArrayList;

    check-cast p1, Ljava/util/Map;

    .end local p1    # "obj":Ljava/lang/Object;
    invoke-virtual {v0, p2, p1}, Ljava/util/ArrayList;->add(ILjava/lang/Object;)V

    .line 256
    return-void
.end method

.method private remove(Ljava/lang/Object;)V
    .locals 1
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 250
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SelectedPlayList;->trackList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 251
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 235
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SelectedPlayList;->trackList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "location"    # I

    .prologue
    .line 240
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SelectedPlayList;->trackList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 245
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 261
    iget-object v8, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->inflater:Landroid/view/LayoutInflater;

    if-nez v8, :cond_0

    .line 262
    iget-object v8, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->activity:Landroid/app/Activity;

    .line 263
    const-string v9, "layout_inflater"

    invoke-virtual {v8, v9}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/LayoutInflater;

    .line 262
    iput-object v8, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 264
    :cond_0
    iget-object v8, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v9, 0x7f030040

    const/4 v10, 0x0

    invoke-virtual {v8, v9, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 266
    iget-object v8, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-object v8, v8, Lcom/livemixtapes/profile/SelectedPlayList;->trackList:Ljava/util/ArrayList;

    invoke-virtual {v8, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/util/Map;

    .line 268
    .local v7, "trackMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const v8, 0x7f080136

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 270
    .local v3, "id":Landroid/widget/TextView;
    const v8, 0x7f080139

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 269
    check-cast v5, Landroid/widget/TextView;

    .line 271
    .local v5, "title":Landroid/widget/TextView;
    const v8, 0x7f0800f0

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 272
    .local v0, "deleteButton":Landroid/widget/ImageButton;
    const v8, 0x7f08013a

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 273
    .local v2, "handle":Landroid/widget/LinearLayout;
    const v8, 0x7f080137

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/FrameLayout;

    .line 280
    .local v1, "frameLayout":Landroid/widget/FrameLayout;
    new-instance v9, Ljava/lang/StringBuilder;

    const/16 v8, 0x9

    if-ge p1, v8, :cond_1

    const-string v8, "0"

    :goto_0
    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v9, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    add-int/lit8 v8, p1, 0x1

    invoke-virtual {v9, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "."

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 281
    .local v6, "trackId":Ljava/lang/String;
    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 284
    const-string v8, "track_duration"

    .line 283
    invoke-interface {v7, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    .line 284
    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    .line 283
    invoke-static {v8}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v8

    invoke-static {v8, v9}, Lcom/livemixtapes/Utils;->formatDuration(D)Ljava/lang/String;

    move-result-object v4

    .line 285
    .local v4, "length":Ljava/lang/String;
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "track_title"

    invoke-interface {v7, v9}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, " ("

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    .line 286
    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ")"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 285
    invoke-virtual {v5, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 287
    iget-object v8, p0, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    iget-boolean v8, v8, Lcom/livemixtapes/profile/SelectedPlayList;->isEditMode:Z

    if-eqz v8, :cond_2

    .line 289
    const/4 v8, 0x0

    invoke-virtual {v0, v8}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 290
    const/4 v8, 0x0

    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 291
    const/16 v8, 0x8

    invoke-virtual {v1, v8}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 292
    const-string v8, ""

    invoke-virtual {v3, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 294
    new-instance v8, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;

    invoke-direct {v8, p0, v7}, Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter$1;-><init>(Lcom/livemixtapes/profile/SelectedPlayList$TrackListAdapter;Ljava/util/Map;)V

    invoke-virtual {v0, v8}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 311
    :goto_1
    return-object p2

    .line 280
    .end local v4    # "length":Ljava/lang/String;
    .end local v6    # "trackId":Ljava/lang/String;
    :cond_1
    const-string v8, ""

    goto :goto_0

    .line 305
    .restart local v4    # "length":Ljava/lang/String;
    .restart local v6    # "trackId":Ljava/lang/String;
    :cond_2
    const/4 v8, 0x0

    invoke-virtual {v3, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 306
    const/16 v8, 0x8

    invoke-virtual {v0, v8}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 307
    const/16 v8, 0x8

    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 308
    const/4 v8, 0x0

    invoke-virtual {v1, v8}, Landroid/widget/FrameLayout;->setVisibility(I)V

    goto :goto_1
.end method
