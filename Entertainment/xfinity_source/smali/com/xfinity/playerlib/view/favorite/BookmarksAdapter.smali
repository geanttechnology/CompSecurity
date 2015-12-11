.class public Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;
.super Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;
.source "BookmarksAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;,
        Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter",
        "<",
        "Lcom/xfinity/playerlib/model/Favorite;",
        "Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private bookmarks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;"
        }
    .end annotation
.end field

.field protected context:Landroid/content/Context;

.field private final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

.field private final isInBabyGuide:Z

.field private isTablet:Z

.field private liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const-class v0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Z)V
    .locals 1
    .param p1, "layoutInflater"    # Landroid/view/LayoutInflater;
    .param p2, "coverArtImageLoader"    # Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .param p3, "isInBabyGuide"    # Z

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 33
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->bookmarks:Ljava/util/List;

    .line 46
    iput-object p2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 47
    iput-boolean p3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->isInBabyGuide:Z

    .line 49
    invoke-virtual {p1}, Landroid/view/LayoutInflater;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->context:Landroid/content/Context;

    .line 50
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    .prologue
    .line 29
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->isTablet:Z

    return v0
.end method


# virtual methods
.method protected bindItem(Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;Lcom/xfinity/playerlib/model/Favorite;)V
    .locals 12
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;
    .param p2, "favorite"    # Lcom/xfinity/playerlib/model/Favorite;

    .prologue
    const/4 v11, 0x0

    .line 79
    iget-object v7, p1, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/Favorite;->getTitle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 84
    iget-object v7, p1, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    sget v8, Lcom/xfinity/playerlib/R$color;->MissingImage:I

    invoke-virtual {v7, v8}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 85
    iget-object v7, p1, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->title:Landroid/widget/TextView;

    invoke-virtual {v7, v11}, Landroid/widget/TextView;->setVisibility(I)V

    .line 86
    const/4 v2, 0x0

    .line 87
    .local v2, "isEntitled":Z
    instance-of v7, p2, Lcom/xfinity/playerlib/model/VideoFavorite;

    if-eqz v7, :cond_2

    .line 88
    iget-object v8, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object v7, p2

    check-cast v7, Lcom/xfinity/playerlib/model/VideoFavorite;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v7

    iget-object v9, p1, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    new-instance v10, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;

    invoke-direct {v10, p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;)V

    invoke-virtual {v8, v7, v9, v10}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 89
    iget-object v8, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-object v7, p2

    check-cast v7, Lcom/xfinity/playerlib/model/VideoFavorite;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v7

    invoke-interface {v8, v7}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v4

    .line 90
    .local v4, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v7, v4}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v2

    .line 105
    .end local v4    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_0
    :goto_0
    if-eqz v2, :cond_3

    .line 106
    iget-object v7, p1, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->lockedIndicator:Landroid/widget/ImageView;

    const/4 v8, 0x4

    invoke-virtual {v7, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 111
    :goto_1
    iget-boolean v7, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->isTablet:Z

    if-eqz v7, :cond_1

    .line 112
    iget-object v7, p1, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->container:Landroid/view/View;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/Favorite;->getTitle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 114
    :cond_1
    return-void

    .line 92
    :cond_2
    iget-object v7, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->context:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$dimen;->cover_art_src_width:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 93
    .local v1, "imageWidth":I
    iget-object v7, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->context:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$dimen;->cover_art_src_height:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .local v0, "imageHeight":I
    move-object v7, p2

    .line 94
    check-cast v7, Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getArtworkUrl()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v1, v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getArtworkUrl(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v6

    .line 96
    .local v6, "url":Ljava/lang/String;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v8, p1, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    new-instance v9, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;

    invoke-direct {v9, p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$CoverArtLoadListener;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;)V

    invoke-virtual {v7, v6, v8, v9}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 98
    iget-object v8, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    move-object v7, p2

    check-cast v7, Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getStreamId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->getLiveStream(Ljava/lang/String;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v3

    .line 99
    .local v3, "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    if-eqz v3, :cond_0

    .line 100
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v5

    .line 101
    .local v5, "providerCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v8, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v7

    new-array v7, v7, [Ljava/lang/String;

    invoke-interface {v5, v7}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v7

    check-cast v7, [Ljava/lang/String;

    invoke-virtual {v8, v7}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitledToList([Ljava/lang/String;)Z

    move-result v2

    goto :goto_0

    .line 108
    .end local v0    # "imageHeight":I
    .end local v1    # "imageWidth":I
    .end local v3    # "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .end local v5    # "providerCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v6    # "url":Ljava/lang/String;
    :cond_3
    iget-object v7, p1, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->lockedIndicator:Landroid/widget/ImageView;

    invoke-virtual {v7, v11}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1
.end method

.method protected bridge synthetic bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 29
    check-cast p1, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;

    check-cast p2, Lcom/xfinity/playerlib/model/Favorite;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->bindItem(Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;Lcom/xfinity/playerlib/model/Favorite;)V

    return-void
.end method

.method protected createViewHolder()Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;
    .locals 1

    .prologue
    .line 118
    new-instance v0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;-><init>()V

    return-object v0
.end method

.method protected bridge synthetic createViewHolder()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->createViewHolder()Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->bookmarks:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getData()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;"
        }
    .end annotation

    .prologue
    .line 147
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->bookmarks:Ljava/util/List;

    return-object v0
.end method

.method public getItem(I)Lcom/xfinity/playerlib/model/Favorite;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 137
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->bookmarks:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/Favorite;

    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 29
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->getItem(I)Lcom/xfinity/playerlib/model/Favorite;

    move-result-object v0

    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->isInBabyGuide:Z

    if-eqz v0, :cond_0

    .line 124
    sget v0, Lcom/xfinity/playerlib/R$layout;->bookmarks_item_babyguide:I

    .line 126
    :goto_0
    return v0

    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$layout;->bookmarks_item:I

    goto :goto_0
.end method

.method protected initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "viewGroup"    # Landroid/view/ViewGroup;
    .param p3, "holder"    # Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;

    .prologue
    .line 67
    iput-object p1, p3, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->layout:Landroid/view/View;

    .line 68
    sget v0, Lcom/xfinity/playerlib/R$id;->cover_art:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->coverArt:Landroid/widget/ImageView;

    .line 69
    sget v0, Lcom/xfinity/playerlib/R$id;->favorite_title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->title:Landroid/widget/TextView;

    .line 70
    sget v0, Lcom/xfinity/playerlib/R$id;->locked_indicator:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->lockedIndicator:Landroid/widget/ImageView;

    .line 71
    sget v0, Lcom/xfinity/playerlib/R$id;->favorite_container:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p3, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->container:Landroid/view/View;

    .line 73
    iget-object v0, p3, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;->container:Landroid/view/View;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->isTablet:Z

    .line 74
    return-void

    .line 73
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected bridge synthetic initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 29
    check-cast p3, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;

    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter$ViewHolder;)V

    return-void
.end method

.method public removeItems(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 152
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/Favorite;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->bookmarks:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    .line 153
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->notifyDataSetChanged()V

    .line 154
    return-void
.end method

.method public setData(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 142
    .local p1, "items":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/Favorite;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->bookmarks:Ljava/util/List;

    .line 143
    return-void
.end method

.method public setDibicResource(Lcom/xfinity/playerlib/model/dibic/DibicResource;)V
    .locals 0
    .param p1, "dibicResource"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .prologue
    .line 61
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 62
    return-void
.end method

.method public setLiveStreamResource(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;)V
    .locals 0
    .param p1, "liveStreamResource"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .prologue
    .line 57
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 58
    return-void
.end method

.method public setVideoEntitlement(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 0
    .param p1, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 54
    return-void
.end method
