.class public Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;
.super Landroid/widget/BaseAdapter;
.source "SourceFile"


# instance fields
.field public array:Ljava/util/ArrayList;

.field private ctx:Landroid/content/Context;

.field currentPlaylistId:Ljava/lang/String;

.field mInflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    .line 36
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    .line 37
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 38
    iput-object p3, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    .line 39
    return-void
.end method

.method static synthetic access$100(Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2

    .prologue
    .line 161
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11

    .prologue
    const/4 v10, 0x0

    const/high16 v9, 0x41200000    # 10.0f

    const/high16 v8, 0x40a00000    # 5.0f

    const v7, 0x7f07011e

    const/16 v6, 0x8

    .line 51
    if-nez p2, :cond_2

    .line 52
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->mInflater:Landroid/view/LayoutInflater;

    const v1, 0x7f03004f

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 54
    new-instance v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;

    const/4 v0, 0x0

    invoke-direct {v1, v0}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;-><init>(Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;)V

    .line 55
    const v0, 0x7f070121

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->tvName:Landroid/widget/TextView;

    .line 56
    const v0, 0x7f070120

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->tvTime:Landroid/widget/TextView;

    .line 57
    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    .line 58
    const v0, 0x7f070122

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    .line 59
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 64
    :goto_0
    iget-object v2, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->tvName:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 65
    iget-object v2, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->tvTime:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongTime()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongTime(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 68
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    const-string v2, "PLAYLISTMP3ID"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    const-string v2, "PLAYLISTMP3ALBUMID"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    const-string v2, "PLAYLISTMP3PLAYLISTID"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    const-string v2, "PLAYLISTMP3ARTISTID"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 71
    :cond_0
    const-string v0, "content://media/external/audio/albumart"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 72
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 73
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-static {v2, v3, v4}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v0

    .line 74
    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    .line 109
    :goto_1
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    iget-object v3, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v2, v0, v3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 111
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    const-string v2, "PLAYLISTMP3ID"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    const-string v2, "PLAYLISTMP3ALBUMID"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    const-string v2, "PLAYLISTMP3PLAYLISTID"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    const-string v2, "PLAYLISTMP3ARTISTID"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 114
    :cond_1
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 146
    :goto_2
    return-object p2

    .line 61
    :cond_2
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;

    move-object v1, v0

    goto/16 :goto_0

    .line 77
    :cond_3
    const-string v0, ""

    goto :goto_1

    .line 79
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    const/4 v2, 0x3

    if-ne v0, v2, :cond_6

    .line 80
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xf

    if-lt v0, v2, :cond_5

    .line 81
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0b0041

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0b0042

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    invoke-direct {v0, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 84
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v9

    float-to-int v2, v2

    .line 85
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v8

    float-to-int v3, v3

    .line 86
    invoke-virtual {v0, v2, v3, v10, v3}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 87
    iget-object v2, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 89
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongThumbnail()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 91
    :cond_6
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xf

    if-lt v0, v2, :cond_7

    .line 92
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://i.ytimg.com/vi/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/mqdefault.jpg"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 93
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0b0041

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0b0042

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-direct {v0, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 96
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v9

    float-to-int v3, v3

    .line 97
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v4, v8

    float-to-int v4, v4

    .line 98
    invoke-virtual {v0, v3, v4, v10, v4}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 99
    iget-object v3, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v3, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 101
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->tvTime:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout$LayoutParams;

    .line 102
    invoke-virtual {v0, v6, v7}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 103
    const/4 v3, 0x7

    invoke-virtual {v0, v3, v7}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 104
    iget-object v3, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->tvTime:Landroid/widget/TextView;

    invoke-virtual {v3, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    move-object v0, v2

    .line 105
    goto/16 :goto_1

    .line 107
    :cond_7
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://i.ytimg.com/vi/"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "/default.jpg"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_1

    .line 116
    :cond_8
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    if-ne v0, v6, :cond_9

    .line 117
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    const v2, 0x7f0200c7

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 118
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;

    invoke-direct {v1, p0, p1}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$1;-><init>(Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;I)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_2

    .line 126
    :cond_9
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    if-eq v0, v6, :cond_a

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->ctx:Landroid/content/Context;

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    const/16 v2, 0x9

    if-ne v0, v2, :cond_b

    :cond_a
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->currentPlaylistId:Ljava/lang/String;

    const-string v2, "PLAYLISTHISTORYID"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 130
    :cond_b
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    const v2, 0x7f020103

    invoke-virtual {v0, v2}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 133
    :cond_c
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;

    invoke-direct {v1, p0, p1}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter$2;-><init>(Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;I)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_2
.end method
