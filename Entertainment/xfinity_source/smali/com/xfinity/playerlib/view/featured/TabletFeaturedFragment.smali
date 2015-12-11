.class public Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;
.super Lcom/xfinity/playerlib/view/featured/FeaturedFragment;
.source "TabletFeaturedFragment.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field protected final configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

.field protected coverVideoCollectionHeader:Landroid/widget/TextView;

.field private coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

.field private coverVideoGalleryScrollState:I

.field private fade:Lcom/comcast/cim/android/view/common/Fade;

.field protected isAccessibilityEnabled:Z

.field private lastCoverVideoCollectionPositionIndex:I

.field protected lastMovieCollectionPositionIndex:I

.field private lastSeriesCollectionPositionIndex:I

.field lastWatched:Landroid/widget/RelativeLayout;

.field lastWatchedContainer:Landroid/view/View;

.field lastWatchedDelete:Landroid/widget/ImageView;

.field lastWatchedHeader:Landroid/widget/TextView;

.field lastWatchedImage:Landroid/widget/ImageView;

.field lastWatchedPlaceHolderText:Landroid/widget/TextView;

.field protected movieCollectionHeader:Landroid/widget/TextView;

.field private movieGallery:Lit/sephiroth/android/library/widget/HListView;

.field private movieGalleryScrollState:I

.field protected programListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field progressBar:Landroid/widget/ProgressBar;

.field protected seriesCollectionHeader:Landroid/widget/TextView;

.field private seriesGallery:Lit/sephiroth/android/library/widget/HListView;

.field private seriesGalleryScrollState:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 51
    const-class v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;-><init>()V

    .line 76
    new-instance v0, Lcom/comcast/cim/android/view/common/Fade;

    invoke-direct {v0}, Lcom/comcast/cim/android/view/common/Fade;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->fade:Lcom/comcast/cim/android/view/common/Fade;

    .line 82
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 83
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)Lit/sephiroth/android/library/widget/HListView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)Lcom/comcast/cim/android/view/common/Fade;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->fade:Lcom/comcast/cim/android/view/common/Fade;

    return-object v0
.end method

.method static synthetic access$200()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 49
    sget-object v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showLastWatchTitle(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;
    .param p1, "x1"    # Lit/sephiroth/android/library/widget/HListView;
    .param p2, "x2"    # Landroid/widget/ImageView;
    .param p3, "x3"    # Landroid/widget/ImageView;

    .prologue
    .line 49
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->adjustScrollShadows(Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    return-void
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)Lit/sephiroth/android/library/widget/HListView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)Lit/sephiroth/android/library/widget/HListView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    return-object v0
.end method

.method static synthetic access$702(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;
    .param p1, "x1"    # I

    .prologue
    .line 49
    iput p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGalleryScrollState:I

    return p1
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 49
    iget v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGalleryScrollState:I

    return v0
.end method

.method static synthetic access$802(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;
    .param p1, "x1"    # I

    .prologue
    .line 49
    iput p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGalleryScrollState:I

    return p1
.end method

.method static synthetic access$902(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;
    .param p1, "x1"    # I

    .prologue
    .line 49
    iput p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGalleryScrollState:I

    return p1
.end method

.method private adjustScrollShadows(Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V
    .locals 6
    .param p1, "hScrollView"    # Lit/sephiroth/android/library/widget/HListView;
    .param p2, "leftShadow"    # Landroid/widget/ImageView;
    .param p3, "rightShadow"    # Landroid/widget/ImageView;

    .prologue
    const/4 v5, 0x4

    const/4 v4, 0x0

    .line 181
    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/HListView;->getScrollX()I

    move-result v1

    .line 182
    .local v1, "scrollXPos":I
    if-lez v1, :cond_0

    .line 183
    invoke-virtual {p2, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 184
    invoke-virtual {p2}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    invoke-virtual {p2}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v3

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v3

    invoke-static {v1, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 189
    :goto_0
    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/HListView;->getMaxScrollAmount()I

    move-result v0

    .line 190
    .local v0, "scrollMaxX":I
    if-ge v1, v0, :cond_1

    .line 191
    invoke-virtual {p3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 192
    invoke-virtual {p3}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    sub-int v3, v0, v1

    invoke-virtual {p3}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v4}, Landroid/graphics/drawable/Drawable;->getIntrinsicWidth()I

    move-result v4

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    iput v3, v2, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 196
    :goto_1
    return-void

    .line 186
    .end local v0    # "scrollMaxX":I
    :cond_0
    invoke-virtual {p2, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 194
    .restart local v0    # "scrollMaxX":I
    :cond_1
    invoke-virtual {p3, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1
.end method

.method private getCurrentPositionIndex(Lit/sephiroth/android/library/widget/HListView;)I
    .locals 1
    .param p1, "hListView"    # Lit/sephiroth/android/library/widget/HListView;

    .prologue
    .line 216
    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/HListView;->getSelectedItemPosition()I

    move-result v0

    .line 218
    .local v0, "pos":I
    if-gez v0, :cond_0

    .line 219
    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/HListView;->getFirstVisiblePosition()I

    move-result v0

    .line 221
    :cond_0
    return v0
.end method

.method private persistGalleryPositions()V
    .locals 1

    .prologue
    .line 200
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getCurrentPositionIndex(Lit/sephiroth/android/library/widget/HListView;)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastSeriesCollectionPositionIndex:I

    .line 201
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getCurrentPositionIndex(Lit/sephiroth/android/library/widget/HListView;)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastCoverVideoCollectionPositionIndex:I

    .line 202
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getCurrentPositionIndex(Lit/sephiroth/android/library/widget/HListView;)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastMovieCollectionPositionIndex:I

    .line 203
    return-void
.end method

.method private setupViews(Landroid/view/View;)V
    .locals 2
    .param p1, "layout"    # Landroid/view/View;

    .prologue
    .line 142
    sget v0, Lcom/xfinity/playerlib/R$id;->justAiredHeader:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesCollectionHeader:Landroid/widget/TextView;

    .line 143
    sget v0, Lcom/xfinity/playerlib/R$id;->mustSeeHeader:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoCollectionHeader:Landroid/widget/TextView;

    .line 144
    sget v0, Lcom/xfinity/playerlib/R$id;->newMoviesHeader:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieCollectionHeader:Landroid/widget/TextView;

    .line 146
    sget v0, Lcom/xfinity/playerlib/R$id;->lastWatchedProgressBar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->progressBar:Landroid/widget/ProgressBar;

    .line 147
    sget v0, Lcom/xfinity/playerlib/R$id;->cover_art:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedImage:Landroid/widget/ImageView;

    .line 148
    sget v0, Lcom/xfinity/playerlib/R$id;->lastWatchedHeader:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedHeader:Landroid/widget/TextView;

    .line 149
    sget v0, Lcom/xfinity/playerlib/R$id;->lastWatched:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatched:Landroid/widget/RelativeLayout;

    .line 150
    sget v0, Lcom/xfinity/playerlib/R$id;->lastWatchedDelete:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedDelete:Landroid/widget/ImageView;

    .line 151
    sget v0, Lcom/xfinity/playerlib/R$id;->placeholder_title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedPlaceHolderText:Landroid/widget/TextView;

    .line 153
    sget v0, Lcom/xfinity/playerlib/R$id;->lastWatchedContainer:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    .line 155
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedDelete:Landroid/widget/ImageView;

    new-instance v1, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 175
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->setupJustAiredGallery(Landroid/view/View;)V

    .line 176
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->setupMustSeeGallery(Landroid/view/View;)V

    .line 177
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->setupNewMoviesGallery(Landroid/view/View;)V

    .line 178
    return-void
.end method

.method private showLastWatchTitle(Ljava/lang/String;)V
    .locals 2
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 381
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedPlaceHolderText:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 382
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedPlaceHolderText:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 383
    return-void
.end method

.method private showLastWatched(Lcom/xfinity/playerlib/bookmarks/Bookmark;Landroid/widget/ProgressBar;)V
    .locals 12
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;
    .param p2, "pBar"    # Landroid/widget/ProgressBar;

    .prologue
    .line 235
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedPlaceHolderText:Landroid/widget/TextView;

    const/4 v8, 0x4

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 237
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTitle()Ljava/lang/String;

    move-result-object v5

    .line 239
    .local v5, "title":Ljava/lang/String;
    instance-of v7, p1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    if-eqz v7, :cond_3

    move-object v7, p1

    .line 241
    check-cast v7, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    .line 243
    .local v4, "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v8, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedImage:Landroid/widget/ImageView;

    new-instance v9, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;

    invoke-direct {v9, p0, v4, v5}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V

    invoke-virtual {v7, v4, v8, v9}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 271
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->isFinished()Z

    move-result v7

    if-eqz v7, :cond_1

    const/4 v7, 0x0

    :goto_0
    invoke-virtual {p2, v7}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 272
    const/4 v7, 0x0

    invoke-virtual {p2, v7}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 274
    iget-boolean v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->isAccessibilityEnabled:Z

    if-eqz v7, :cond_2

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    .line 275
    .local v2, "lastWatchedClickable":Landroid/view/View;
    :goto_1
    new-instance v7, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$3;

    invoke-direct {v7, p0, p1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$3;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lcom/xfinity/playerlib/bookmarks/Bookmark;)V

    invoke-virtual {v2, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 327
    .end local v2    # "lastWatchedClickable":Landroid/view/View;
    .end local v4    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :goto_2
    iget-boolean v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->isAccessibilityEnabled:Z

    if-eqz v7, :cond_7

    .line 329
    instance-of v7, p1, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    if-eqz v7, :cond_5

    .line 331
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    sget v8, Lcom/xfinity/playerlib/R$string;->content_description_last_watched_live_stream:I

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    .line 332
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTitle()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    .line 331
    invoke-virtual {p0, v8, v9}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 378
    :cond_0
    :goto_3
    return-void

    .line 271
    .restart local v4    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :cond_1
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getPercentWatched()I

    move-result v7

    goto :goto_0

    .line 274
    :cond_2
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatched:Landroid/widget/RelativeLayout;

    goto :goto_1

    .end local v4    # "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    :cond_3
    move-object v3, p1

    .line 290
    check-cast v3, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 292
    .local v3, "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$dimen;->live_stream_poster_art_width:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 293
    .local v1, "imageWidth":I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$dimen;->live_stream_poster_art_height:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    .line 294
    .local v0, "imageHeight":I
    invoke-virtual {v3}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getArtworkUrl()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7, v1, v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getArtworkUrl(Ljava/lang/String;II)Ljava/lang/String;

    move-result-object v6

    .line 296
    .local v6, "url":Ljava/lang/String;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    const/4 v8, 0x0

    iget-object v9, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedImage:Landroid/widget/ImageView;

    const/4 v10, 0x0

    invoke-virtual {v7, v6, v8, v9, v10}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)Z

    move-result v7

    if-nez v7, :cond_4

    .line 297
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedImage:Landroid/widget/ImageView;

    const/4 v8, 0x0

    invoke-virtual {v7, v8}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 299
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v8, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedImage:Landroid/widget/ImageView;

    const/4 v9, 0x0

    new-instance v10, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$4;

    invoke-direct {v10, p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$4;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v7, v6, v8, v9, v10}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    .line 310
    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showLastWatchTitle(Ljava/lang/String;)V

    .line 316
    :goto_4
    const/16 v7, 0x8

    invoke-virtual {p2, v7}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 318
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatched:Landroid/widget/RelativeLayout;

    new-instance v8, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$5;

    invoke-direct {v8, p0, v3}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$5;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    invoke-virtual {v7, v8}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_2

    .line 313
    :cond_4
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedPlaceHolderText:Landroid/widget/TextView;

    const/16 v8, 0x8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_4

    .line 336
    .end local v0    # "imageHeight":I
    .end local v1    # "imageWidth":I
    .end local v3    # "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    .end local v6    # "url":Ljava/lang/String;
    :cond_5
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->isFinished()Z

    move-result v7

    if-nez v7, :cond_6

    .line 337
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    sget v8, Lcom/xfinity/playerlib/R$string;->content_description_last_watched:I

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    .line 338
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTitle()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getPercentWatched()I

    move-result v11

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    .line 337
    invoke-virtual {p0, v8, v9}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    :goto_5
    move-object v7, p1

    .line 344
    check-cast v7, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->isMovie()Z

    move-result v7

    if-nez v7, :cond_0

    .line 346
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->programProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v8, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;

    invoke-direct {v8, p0, p1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$6;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lcom/xfinity/playerlib/bookmarks/Bookmark;)V

    invoke-interface {v7, v8}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v7

    iput-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->programListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto/16 :goto_3

    .line 340
    :cond_6
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    sget v8, Lcom/xfinity/playerlib/R$string;->content_description_last_watched_finished:I

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    .line 341
    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/Bookmark;->getTitle()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    .line 340
    invoke-virtual {p0, v8, v9}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_5

    .line 376
    :cond_7
    iget-object v7, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->fade:Lcom/comcast/cim/android/view/common/Fade;

    iget-object v8, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    invoke-virtual {v7, v8}, Lcom/comcast/cim/android/view/common/Fade;->show(Landroid/view/View;)V

    goto/16 :goto_3
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 508
    sget v0, Lcom/xfinity/playerlib/R$layout;->featured_w600:I

    return v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x0

    .line 105
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 107
    if-eqz p1, :cond_0

    .line 108
    const-string v0, "tvPosition"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastSeriesCollectionPositionIndex:I

    .line 109
    const-string v0, "mustSeePosition"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastCoverVideoCollectionPositionIndex:I

    .line 110
    const-string v0, "moviesPosition"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastMovieCollectionPositionIndex:I

    .line 112
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 99
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onAttach(Landroid/app/Activity;)V

    .line 100
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->fade:Lcom/comcast/cim/android/view/common/Fade;

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/android/view/common/Fade;->setDuration(J)V

    .line 101
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 92
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onCreate(Landroid/os/Bundle;)V

    .line 93
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->isAccessibilityEnabled:Z

    .line 94
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 117
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 119
    .local v0, "layout":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->setupViews(Landroid/view/View;)V

    .line 121
    return-object v0
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 126
    invoke-super {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onPause()V

    .line 128
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->persistGalleryPositions()V

    .line 129
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 207
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 209
    const-string v0, "tvPosition"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getCurrentPositionIndex(Lit/sephiroth/android/library/widget/HListView;)I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 210
    const-string v0, "mustSeePosition"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getCurrentPositionIndex(Lit/sephiroth/android/library/widget/HListView;)I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 211
    const-string v0, "moviesPosition"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->getCurrentPositionIndex(Lit/sephiroth/android/library/widget/HListView;)I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 212
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 133
    invoke-super {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->onStop()V

    .line 135
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->programListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    if-eqz v0, :cond_0

    .line 136
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->programProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->programListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 138
    :cond_0
    return-void
.end method

.method protected postOnResourceFetched(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 514
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/editorial/FeaturedResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/comcast/cim/cmasl/utils/container/Option<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;>;"
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    move-object/from16 v16, v0

    check-cast v16, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 515
    .local v16, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    move-object/from16 v0, p1

    iget-object v14, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    check-cast v14, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    .line 516
    .local v14, "featuredResource":Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    check-cast v2, Lcom/comcast/cim/cmasl/utils/container/Option;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/utils/container/Option;->getValue()Ljava/lang/Object;

    move-result-object v15

    check-cast v15, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .line 518
    .local v15, "lastWatchedBookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    move-object/from16 v0, p0

    invoke-virtual {v0, v15}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->setupLastWatched(Lcom/xfinity/playerlib/bookmarks/Bookmark;)V

    .line 520
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesCollectionHeader:Landroid/widget/TextView;

    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getSeriesCollectionTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 521
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoCollectionHeader:Landroid/widget/TextView;

    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getCoverVideoCollectionTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 522
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieCollectionHeader:Landroid/widget/TextView;

    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getMovieCollectionTitle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 524
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/HListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/image/VideoAdapter;

    .line 525
    .local v1, "seriesAdapter":Lcom/xfinity/playerlib/image/VideoAdapter;
    if-nez v1, :cond_0

    .line 526
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$16;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$16;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnScrollListener(Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;)V

    .line 538
    new-instance v6, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$17;

    move-object/from16 v0, p0

    invoke-direct {v6, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$17;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    .line 545
    .local v6, "scrollStateTracker":Lcom/xfinity/playerlib/view/ScrollStateTracker;
    new-instance v1, Lcom/xfinity/playerlib/image/VideoAdapter;

    .end local v1    # "seriesAdapter":Lcom/xfinity/playerlib/image/VideoAdapter;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->layoutInflator:Landroid/view/LayoutInflater;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 546
    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getSeriesCollectionTitle()Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v1 .. v6}, Lcom/xfinity/playerlib/image/VideoAdapter;-><init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/lang/String;Lcom/xfinity/playerlib/view/ScrollStateTracker;)V

    .line 547
    .restart local v1    # "seriesAdapter":Lcom/xfinity/playerlib/image/VideoAdapter;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-virtual {v2, v1}, Lit/sephiroth/android/library/widget/HListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 549
    .end local v6    # "scrollStateTracker":Lcom/xfinity/playerlib/view/ScrollStateTracker;
    :cond_0
    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getSeries()Ljava/util/List;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->premiumNetworks:Ljava/util/Map;

    move-object/from16 v0, v16

    invoke-virtual {v1, v2, v0, v3}, Lcom/xfinity/playerlib/image/VideoAdapter;->setData(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/util/Map;)V

    .line 550
    invoke-virtual {v1}, Lcom/xfinity/playerlib/image/VideoAdapter;->notifyDataSetChanged()V

    .line 551
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastSeriesCollectionPositionIndex:I

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setSelection(I)V

    .line 553
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/HListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v7

    check-cast v7, Lcom/xfinity/playerlib/view/featured/CoverAdapter;

    .line 554
    .local v7, "coverVideoAdapter":Lcom/xfinity/playerlib/view/featured/CoverAdapter;
    if-nez v7, :cond_1

    .line 556
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$18;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$18;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnScrollListener(Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;)V

    .line 568
    new-instance v6, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$19;

    move-object/from16 v0, p0

    invoke-direct {v6, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$19;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    .line 575
    .restart local v6    # "scrollStateTracker":Lcom/xfinity/playerlib/view/ScrollStateTracker;
    new-instance v7, Lcom/xfinity/playerlib/view/featured/CoverAdapter;

    .end local v7    # "coverVideoAdapter":Lcom/xfinity/playerlib/view/featured/CoverAdapter;
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->layoutInflator:Landroid/view/LayoutInflater;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 576
    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getCoverVideoCollectionTitle()Ljava/lang/String;

    move-result-object v11

    move-object v12, v6

    invoke-direct/range {v7 .. v12}, Lcom/xfinity/playerlib/view/featured/CoverAdapter;-><init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/lang/String;Lcom/xfinity/playerlib/view/ScrollStateTracker;)V

    .line 577
    .restart local v7    # "coverVideoAdapter":Lcom/xfinity/playerlib/view/featured/CoverAdapter;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-virtual {v2, v7}, Lit/sephiroth/android/library/widget/HListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 579
    .end local v6    # "scrollStateTracker":Lcom/xfinity/playerlib/view/ScrollStateTracker;
    :cond_1
    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getCoverVideos()Ljava/util/List;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->premiumNetworks:Ljava/util/Map;

    move-object/from16 v0, v16

    invoke-virtual {v7, v2, v0, v3}, Lcom/xfinity/playerlib/view/featured/CoverAdapter;->setData(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/util/Map;)V

    .line 580
    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/featured/CoverAdapter;->notifyDataSetChanged()V

    .line 581
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastCoverVideoCollectionPositionIndex:I

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setSelection(I)V

    .line 583
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-virtual {v2}, Lit/sephiroth/android/library/widget/HListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v8

    check-cast v8, Lcom/xfinity/playerlib/image/VideoAdapter;

    .line 584
    .local v8, "movieAdapter":Lcom/xfinity/playerlib/image/VideoAdapter;
    if-nez v8, :cond_2

    .line 585
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$20;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$20;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnScrollListener(Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;)V

    .line 597
    new-instance v6, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$21;

    move-object/from16 v0, p0

    invoke-direct {v6, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$21;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    .line 604
    .restart local v6    # "scrollStateTracker":Lcom/xfinity/playerlib/view/ScrollStateTracker;
    new-instance v8, Lcom/xfinity/playerlib/image/VideoAdapter;

    .end local v8    # "movieAdapter":Lcom/xfinity/playerlib/image/VideoAdapter;
    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->layoutInflator:Landroid/view/LayoutInflater;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 605
    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getMovieCollectionTitle()Ljava/lang/String;

    move-result-object v12

    move-object v13, v6

    invoke-direct/range {v8 .. v13}, Lcom/xfinity/playerlib/image/VideoAdapter;-><init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/lang/String;Lcom/xfinity/playerlib/view/ScrollStateTracker;)V

    .line 606
    .restart local v8    # "movieAdapter":Lcom/xfinity/playerlib/image/VideoAdapter;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    invoke-virtual {v2, v8}, Lit/sephiroth/android/library/widget/HListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 608
    .end local v6    # "scrollStateTracker":Lcom/xfinity/playerlib/view/ScrollStateTracker;
    :cond_2
    invoke-virtual {v14}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getMovies()Ljava/util/List;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->premiumNetworks:Ljava/util/Map;

    move-object/from16 v0, v16

    invoke-virtual {v8, v2, v0, v3}, Lcom/xfinity/playerlib/image/VideoAdapter;->setData(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/util/Map;)V

    .line 609
    invoke-virtual {v8}, Lcom/xfinity/playerlib/image/VideoAdapter;->notifyDataSetChanged()V

    .line 610
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    move-object/from16 v0, p0

    iget v3, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastMovieCollectionPositionIndex:I

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setSelection(I)V

    .line 612
    return-void
.end method

.method protected setupJustAiredGallery(Landroid/view/View;)V
    .locals 4
    .param p1, "layout"    # Landroid/view/View;

    .prologue
    .line 386
    sget v2, Lcom/xfinity/playerlib/R$id;->justAiredGallery:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lit/sephiroth/android/library/widget/HListView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    .line 387
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$7;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$7;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnItemClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;)V

    .line 395
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$8;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$8;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnItemLongClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;)V

    .line 405
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->isAccessibilityEnabled:Z

    if-nez v2, :cond_0

    .line 406
    sget v2, Lcom/xfinity/playerlib/R$id;->just_aired_shadow_left:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 407
    .local v0, "justAiredShadowLeft":Landroid/widget/ImageView;
    sget v2, Lcom/xfinity/playerlib/R$id;->just_aired_shadow_right:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 409
    .local v1, "justAiredShadowRight":Landroid/widget/ImageView;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$9;

    invoke-direct {v3, p0, v0, v1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$9;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnScrollListener(Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;)V

    .line 421
    .end local v0    # "justAiredShadowLeft":Landroid/widget/ImageView;
    .end local v1    # "justAiredShadowRight":Landroid/widget/ImageView;
    :cond_0
    return-void
.end method

.method protected setupLastWatched(Lcom/xfinity/playerlib/bookmarks/Bookmark;)V
    .locals 2
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .prologue
    .line 225
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getShowLastWatched()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 226
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->progressBar:Landroid/widget/ProgressBar;

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showLastWatched(Lcom/xfinity/playerlib/bookmarks/Bookmark;Landroid/widget/ProgressBar;)V

    .line 230
    :goto_0
    return-void

    .line 228
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method protected setupMustSeeGallery(Landroid/view/View;)V
    .locals 4
    .param p1, "layout"    # Landroid/view/View;

    .prologue
    .line 424
    sget v2, Lcom/xfinity/playerlib/R$id;->mustSeeGallery:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lit/sephiroth/android/library/widget/HListView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    .line 425
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$10;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$10;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnItemClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;)V

    .line 433
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$11;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$11;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnItemLongClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;)V

    .line 450
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->isAccessibilityEnabled:Z

    if-nez v2, :cond_0

    .line 451
    sget v2, Lcom/xfinity/playerlib/R$id;->must_see_shadow_left:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 452
    .local v0, "mustSeeShadowLeft":Landroid/widget/ImageView;
    sget v2, Lcom/xfinity/playerlib/R$id;->must_see_shadow_right:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 454
    .local v1, "mustSeeShadowRight":Landroid/widget/ImageView;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$12;

    invoke-direct {v3, p0, v0, v1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$12;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnScrollListener(Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;)V

    .line 466
    .end local v0    # "mustSeeShadowLeft":Landroid/widget/ImageView;
    .end local v1    # "mustSeeShadowRight":Landroid/widget/ImageView;
    :cond_0
    return-void
.end method

.method protected setupNewMoviesGallery(Landroid/view/View;)V
    .locals 4
    .param p1, "layout"    # Landroid/view/View;

    .prologue
    .line 469
    sget v2, Lcom/xfinity/playerlib/R$id;->newMoviesGallery:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lit/sephiroth/android/library/widget/HListView;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    .line 470
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$13;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$13;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnItemClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;)V

    .line 478
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$14;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$14;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnItemLongClickListener(Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;)V

    .line 488
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->isAccessibilityEnabled:Z

    if-nez v2, :cond_0

    .line 489
    sget v2, Lcom/xfinity/playerlib/R$id;->new_movies_shadow_left:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 490
    .local v0, "newMoviesShadowLeft":Landroid/widget/ImageView;
    sget v2, Lcom/xfinity/playerlib/R$id;->new_movies_shadow_right:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 492
    .local v1, "newMoviesShadowRight":Landroid/widget/ImageView;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;

    new-instance v3, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;

    invoke-direct {v3, p0, v0, v1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    invoke-virtual {v2, v3}, Lit/sephiroth/android/library/widget/HListView;->setOnScrollListener(Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;)V

    .line 504
    .end local v0    # "newMoviesShadowLeft":Landroid/widget/ImageView;
    .end local v1    # "newMoviesShadowRight":Landroid/widget/ImageView;
    :cond_0
    return-void
.end method
