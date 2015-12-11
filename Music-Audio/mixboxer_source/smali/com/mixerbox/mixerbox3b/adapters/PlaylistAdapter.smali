.class public Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;
.super Landroid/widget/BaseAdapter;
.source "SourceFile"


# instance fields
.field private array:Ljava/util/ArrayList;

.field private ctx:Landroid/content/Context;

.field mInflater:Landroid/view/LayoutInflater;

.field mMode:Lcom/actionbarsherlock/view/ActionMode;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/ArrayList;)V
    .locals 2

    .prologue
    .line 39
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 40
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p2}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->array:Ljava/util/ArrayList;

    .line 42
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 43
    return-void
.end method

.method static synthetic access$100(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 161
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 166
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2

    .prologue
    .line 171
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 56
    if-nez p2, :cond_0

    .line 57
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->mInflater:Landroid/view/LayoutInflater;

    const v1, 0x7f03004c

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 59
    new-instance v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;

    invoke-direct {v1, v2}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;-><init>(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;)V

    .line 60
    const v0, 0x7f07011c

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->tvName:Landroid/widget/TextView;

    .line 61
    const v0, 0x7f07011d

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->tvOwner:Landroid/widget/TextView;

    .line 62
    const v0, 0x7f07011b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->tvItemCount:Landroid/widget/TextView;

    .line 63
    const v0, 0x7f070119

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    .line 64
    const v0, 0x7f07011a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->ivQuickPlay:Landroid/widget/ImageView;

    .line 65
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 70
    :goto_0
    iget-object v2, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->tvName:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 71
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_1

    .line 72
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->tvOwner:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 73
    iget-object v2, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->tvOwner:Landroid/widget/TextView;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800d1

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, " "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    :goto_1
    iget-object v2, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->tvItemCount:Landroid/widget/TextView;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 80
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;->array:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v0

    .line 81
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    iget-object v3, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v2, v0, v3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 83
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->ivQuickPlay:Landroid/widget/ImageView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;

    invoke-direct {v1, p0, p1}, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$1;-><init>(Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter;I)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 156
    return-object p2

    .line 67
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;

    move-object v1, v0

    goto/16 :goto_0

    .line 77
    :cond_1
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/adapters/PlaylistAdapter$ViewHolder;->tvOwner:Landroid/widget/TextView;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method
