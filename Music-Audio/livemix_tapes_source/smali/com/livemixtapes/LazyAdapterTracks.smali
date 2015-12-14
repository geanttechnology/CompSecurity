.class public Lcom/livemixtapes/LazyAdapterTracks;
.super Landroid/widget/BaseAdapter;
.source "LazyAdapterTracks.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;
    }
.end annotation


# instance fields
.field public data:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field public imageLoader:Lcom/livemixtapes/ImageLoader;

.field private inflater:Landroid/view/LayoutInflater;

.field public mixTape:Lcom/livemixtapes/Mixtape;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/Mixtape;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "mt"    # Lcom/livemixtapes/Mixtape;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/livemixtapes/Mixtape;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p2, "d":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 20
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/livemixtapes/LazyAdapterTracks;->inflater:Landroid/view/LayoutInflater;

    .line 29
    iput-object p2, p0, Lcom/livemixtapes/LazyAdapterTracks;->data:Ljava/util/ArrayList;

    .line 30
    iput-object p1, p0, Lcom/livemixtapes/LazyAdapterTracks;->mixTape:Lcom/livemixtapes/Mixtape;

    .line 31
    invoke-virtual {p1}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/livemixtapes/LazyAdapterTracks;->inflater:Landroid/view/LayoutInflater;

    .line 32
    new-instance v0, Lcom/livemixtapes/ImageLoader;

    invoke-virtual {p1}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/LazyAdapterTracks;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 33
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterTracks;->data:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 48
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 52
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x4

    const/4 v7, 0x0

    .line 66
    move-object v4, p2

    .line 68
    .local v4, "vi":Landroid/view/View;
    new-instance v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;

    invoke-direct {v0}, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;-><init>()V

    .line 71
    .local v0, "holder":Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;
    new-instance v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;

    .end local v0    # "holder":Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;
    invoke-direct {v0}, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;-><init>()V

    .line 72
    .restart local v0    # "holder":Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;
    iget-object v5, p0, Lcom/livemixtapes/LazyAdapterTracks;->inflater:Landroid/view/LayoutInflater;

    const v6, 0x7f03003f

    invoke-virtual {v5, v6, p3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 76
    const v5, 0x7f080136

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->id:Landroid/widget/TextView;

    .line 77
    const v5, 0x7f080139

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    iput-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->title:Landroid/widget/TextView;

    .line 78
    const v5, 0x7f080138

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ProgressBar;

    iput-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->progressBar:Landroid/widget/ProgressBar;

    .line 79
    const v5, 0x7f0800df

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageButton;

    iput-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->downloadBtn:Landroid/widget/ImageButton;

    .line 80
    const v5, 0x7f080134

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    iput-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->selectionView:Landroid/view/View;

    .line 86
    iget-object v5, p0, Lcom/livemixtapes/LazyAdapterTracks;->data:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/HashMap;

    const-string v6, "track_id"

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 89
    .local v3, "trackId":Ljava/lang/String;
    iget-object v5, p0, Lcom/livemixtapes/LazyAdapterTracks;->mixTape:Lcom/livemixtapes/Mixtape;

    iget-object v5, v5, Lcom/livemixtapes/Mixtape;->playlistMode:Ljava/lang/Boolean;

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 91
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->downloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v5, v9}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 92
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v5, v9}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 93
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->selectionView:Landroid/view/View;

    invoke-virtual {v5, v7}, Landroid/view/View;->setVisibility(I)V

    .line 94
    iget-object v5, p0, Lcom/livemixtapes/LazyAdapterTracks;->mixTape:Lcom/livemixtapes/Mixtape;

    iget-object v5, v5, Lcom/livemixtapes/Mixtape;->selectedPlayListTracks:Ljava/util/ArrayList;

    invoke-virtual {v5, v3}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 95
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->selectionView:Landroid/view/View;

    const-string v6, "#000080"

    invoke-static {v6}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/view/View;->setBackgroundColor(I)V

    .line 149
    :goto_0
    iget-object v6, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->id:Landroid/widget/TextView;

    new-instance v7, Ljava/lang/StringBuilder;

    const/16 v5, 0x9

    if-ge p1, v5, :cond_5

    const-string v5, "0"

    :goto_1
    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    add-int/lit8 v5, p1, 0x1

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v7, "."

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 150
    iget-object v5, p0, Lcom/livemixtapes/LazyAdapterTracks;->data:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/HashMap;

    .line 151
    const-string v6, "track_duration"

    .line 150
    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v5

    invoke-static {v5, v6}, Lcom/livemixtapes/Utils;->formatDuration(D)Ljava/lang/String;

    move-result-object v1

    .line 152
    .local v1, "length":Ljava/lang/String;
    iget-object v6, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->title:Landroid/widget/TextView;

    new-instance v7, Ljava/lang/StringBuilder;

    iget-object v5, p0, Lcom/livemixtapes/LazyAdapterTracks;->data:Ljava/util/ArrayList;

    invoke-virtual {v5, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/HashMap;

    const-string v8, "track_title"

    invoke-virtual {v5, v8}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v7, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, " ("

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 153
    const-string v7, ")"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 152
    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 154
    return-object v4

    .line 97
    .end local v1    # "length":Ljava/lang/String;
    :cond_0
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->selectionView:Landroid/view/View;

    const v6, 0x7f020062

    invoke-virtual {v5, v6}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_0

    .line 101
    :cond_1
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->selectionView:Landroid/view/View;

    invoke-virtual {v5, v9}, Landroid/view/View;->setVisibility(I)V

    .line 104
    iget-object v5, p0, Lcom/livemixtapes/LazyAdapterTracks;->mixTape:Lcom/livemixtapes/Mixtape;

    invoke-virtual {v5}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v5

    invoke-static {v5, v3}, Lcom/livemixtapes/Utils;->isFileExists(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_4

    .line 106
    iget-object v5, p0, Lcom/livemixtapes/LazyAdapterTracks;->mixTape:Lcom/livemixtapes/Mixtape;

    iget-object v5, v5, Lcom/livemixtapes/Mixtape;->downloadProgressList:Ljava/util/HashMap;

    invoke-virtual {v5, v3}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 108
    iget-object v5, p0, Lcom/livemixtapes/LazyAdapterTracks;->mixTape:Lcom/livemixtapes/Mixtape;

    invoke-virtual {v5, v3}, Lcom/livemixtapes/Mixtape;->getIndividualFileProgress(Ljava/lang/String;)I

    move-result v2

    .line 109
    .local v2, "progress":I
    const/16 v5, 0x64

    if-ne v2, v5, :cond_2

    .line 111
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->downloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v5, v8}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 112
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v5, v8}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 135
    .end local v2    # "progress":I
    :goto_2
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->downloadBtn:Landroid/widget/ImageButton;

    new-instance v6, Lcom/livemixtapes/LazyAdapterTracks$1;

    invoke-direct {v6, p0, p1}, Lcom/livemixtapes/LazyAdapterTracks$1;-><init>(Lcom/livemixtapes/LazyAdapterTracks;I)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0

    .line 116
    .restart local v2    # "progress":I
    :cond_2
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->downloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v5, v7}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 117
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v5, v7}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 118
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->downloadBtn:Landroid/widget/ImageButton;

    const v6, 0x7f0200bd

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 119
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v5, v2}, Landroid/widget/ProgressBar;->setProgress(I)V

    goto :goto_2

    .line 124
    .end local v2    # "progress":I
    :cond_3
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->downloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v5, v8}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 125
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v5, v8}, Landroid/widget/ProgressBar;->setVisibility(I)V

    goto :goto_2

    .line 130
    :cond_4
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->downloadBtn:Landroid/widget/ImageButton;

    invoke-virtual {v5, v7}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 131
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->progressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v5, v7}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 132
    iget-object v5, v0, Lcom/livemixtapes/LazyAdapterTracks$ViewHolder;->downloadBtn:Landroid/widget/ImageButton;

    const v6, 0x7f020095

    invoke-virtual {v5, v6}, Landroid/widget/ImageButton;->setImageResource(I)V

    goto :goto_2

    .line 149
    :cond_5
    const-string v5, ""

    goto/16 :goto_1
.end method

.method public setData(Lcom/livemixtapes/Mixtape;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "mt"    # Lcom/livemixtapes/Mixtape;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/livemixtapes/Mixtape;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 40
    .local p2, "d":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    iput-object p1, p0, Lcom/livemixtapes/LazyAdapterTracks;->mixTape:Lcom/livemixtapes/Mixtape;

    .line 41
    iput-object p2, p0, Lcom/livemixtapes/LazyAdapterTracks;->data:Ljava/util/ArrayList;

    .line 42
    invoke-virtual {p1}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 43
    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 42
    iput-object v0, p0, Lcom/livemixtapes/LazyAdapterTracks;->inflater:Landroid/view/LayoutInflater;

    .line 44
    new-instance v0, Lcom/livemixtapes/ImageLoader;

    invoke-virtual {p1}, Lcom/livemixtapes/Mixtape;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/LazyAdapterTracks;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 45
    return-void
.end method
