.class public abstract Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;
.source "FeaturedAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter",
        "<",
        "Lcom/xfinity/playerlib/model/EditorialProgram;",
        "Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field protected context:Landroid/content/Context;

.field protected coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

.field private handler:Landroid/os/Handler;

.field private listHeadingForAccessibility:Ljava/lang/String;

.field private networkLogoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field private premiumNetworks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field

.field private programs:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<+",
            "Lcom/xfinity/playerlib/model/EditorialProgram;",
            ">;"
        }
    .end annotation
.end field

.field private final scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

.field private final shouldSuppressNetworkLogos:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const-class v0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/lang/String;Lcom/xfinity/playerlib/view/ScrollStateTracker;)V
    .locals 1
    .param p1, "layoutInflator"    # Landroid/view/LayoutInflater;
    .param p2, "coverArtImageLoader"    # Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .param p3, "networkLogoLoader"    # Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .param p4, "listHeadingForAccessibility"    # Ljava/lang/String;
    .param p5, "scrollStateTracker"    # Lcom/xfinity/playerlib/view/ScrollStateTracker;

    .prologue
    .line 51
    invoke-direct {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/ViewHolderBaseAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 31
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->handler:Landroid/os/Handler;

    .line 32
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->programs:Ljava/util/List;

    .line 43
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->shouldSuppressNetworkLogos()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->shouldSuppressNetworkLogos:Z

    .line 52
    iput-object p2, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 53
    iput-object p3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->networkLogoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 54
    iput-object p4, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->listHeadingForAccessibility:Ljava/lang/String;

    .line 55
    iput-object p5, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

    .line 57
    invoke-virtual {p1}, Landroid/view/LayoutInflater;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->context:Landroid/content/Context;

    .line 58
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->programs:Ljava/util/List;

    return-object v0
.end method

.method private getBestTitle(Lcom/xfinity/playerlib/model/EditorialProgram;)Ljava/lang/String;
    .locals 5
    .param p1, "selectedVideo"    # Lcom/xfinity/playerlib/model/EditorialProgram;

    .prologue
    .line 171
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getEpisodeTitle()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 172
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getSeasonNumber()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getEpisodeNumber()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 173
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->context:Landroid/content/Context;

    .line 174
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->featured_title_text:I

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    .line 175
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getSeasonNumber()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    .line 176
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getEpisodeNumber()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    .line 177
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getEpisodeTitle()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 174
    invoke-virtual {v0, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 179
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getTitle()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private getContentDescription(Lcom/xfinity/playerlib/model/EditorialProgram;)Ljava/lang/String;
    .locals 7
    .param p1, "selectedVideo"    # Lcom/xfinity/playerlib/model/EditorialProgram;

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 151
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getEpisodeTitle()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 152
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getSeasonNumber()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getEpisodeNumber()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 154
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_featured_tv_series_title_text:I

    const/4 v2, 0x5

    new-array v2, v2, [Ljava/lang/Object;

    .line 156
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getTitle()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    .line 157
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getSeasonNumber()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    .line 158
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getEpisodeNumber()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    const/4 v3, 0x3

    .line 159
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getEpisodeTitle()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x4

    iget-object v4, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->listHeadingForAccessibility:Ljava/lang/String;

    aput-object v4, v2, v3

    .line 155
    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 162
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->context:Landroid/content/Context;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_featured_movie_title_text:I

    new-array v2, v6, [Ljava/lang/Object;

    .line 163
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getTitle()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->listHeadingForAccessibility:Ljava/lang/String;

    aput-object v3, v2, v5

    .line 162
    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method protected bindItem(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;Lcom/xfinity/playerlib/model/EditorialProgram;)V
    .locals 3
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;

    .prologue
    .line 76
    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->setupProgramArt(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;Lcom/xfinity/playerlib/model/EditorialProgram;)V

    .line 78
    iget-object v0, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->lockedIndicator:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->lockedIndicator:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {p0, v0, p2, v1}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->setupLockedIndicator(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 82
    :cond_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->shouldSuppressNetworkLogos:Z

    if-eqz v0, :cond_2

    .line 83
    iget-object v0, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->networkLogo:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 87
    :cond_1
    :goto_0
    return-void

    .line 84
    :cond_2
    iget-object v0, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->networkLogo:Landroid/widget/ImageView;

    if-eqz v0, :cond_1

    .line 85
    iget-object v0, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->networkLogo:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->networkLogoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->premiumNetworks:Ljava/util/Map;

    invoke-virtual {p0, v0, p2, v1, v2}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->setupNetworkLogo(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/util/Map;)V

    goto :goto_0
.end method

.method protected bridge synthetic bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 29
    check-cast p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;

    check-cast p2, Lcom/xfinity/playerlib/model/EditorialProgram;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->bindItem(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;Lcom/xfinity/playerlib/model/EditorialProgram;)V

    return-void
.end method

.method protected createViewHolder()Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;
    .locals 1

    .prologue
    .line 62
    new-instance v0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;-><init>()V

    return-object v0
.end method

.method protected bridge synthetic createViewHolder()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 29
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->createViewHolder()Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;

    move-result-object v0

    return-object v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->programs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method protected abstract getImageUrl(Lcom/xfinity/playerlib/model/EditorialProgram;)Ljava/lang/String;
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 233
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->programs:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 237
    int-to-long v0, p1

    return-wide v0
.end method

.method protected initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "viewGroup"    # Landroid/view/ViewGroup;
    .param p3, "holder"    # Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;

    .prologue
    .line 67
    sget v0, Lcom/xfinity/playerlib/R$id;->cover_art:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->videoImage:Landroid/widget/ImageView;

    .line 68
    sget v0, Lcom/xfinity/playerlib/R$id;->placeholder_title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->placeholderTitle:Landroid/widget/TextView;

    .line 69
    sget v0, Lcom/xfinity/playerlib/R$id;->locked_indicator:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->lockedIndicator:Landroid/widget/ImageView;

    .line 70
    sget v0, Lcom/xfinity/playerlib/R$id;->network_logo:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->networkLogo:Landroid/widget/ImageView;

    .line 71
    iput-object p1, p3, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->container:Landroid/view/View;

    .line 72
    return-void
.end method

.method protected bridge synthetic initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 29
    check-cast p3, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;

    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;)V

    return-void
.end method

.method public setData(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/util/Map;)V
    .locals 0
    .param p2, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<+",
            "Lcom/xfinity/playerlib/model/EditorialProgram;",
            ">;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 187
    .local p1, "programs":Ljava/util/List;, "Ljava/util/List<+Lcom/xfinity/playerlib/model/EditorialProgram;>;"
    .local p3, "premiumNetworks":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/xfinity/playerlib/model/tags/Network;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->programs:Ljava/util/List;

    .line 188
    iput-object p2, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 189
    iput-object p3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->premiumNetworks:Ljava/util/Map;

    .line 190
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->notifyDataSetChanged()V

    .line 191
    return-void
.end method

.method protected setupLockedIndicator(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 1
    .param p1, "lockedView"    # Landroid/widget/ImageView;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;
    .param p3, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 194
    const/16 v0, 0x8

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->setupLockedIndicator(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;I)V

    .line 195
    return-void
.end method

.method protected setupLockedIndicator(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;I)V
    .locals 1
    .param p1, "lockedView"    # Landroid/widget/ImageView;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;
    .param p3, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p4, "stateWhenNotShowing"    # I

    .prologue
    .line 200
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/EditorialProgram;->getProviderCode()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitledToList(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 201
    invoke-virtual {p1, p4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 205
    :goto_0
    return-void

    .line 203
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method protected setupNetworkLogo(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/util/Map;)V
    .locals 6
    .param p1, "networkLogoView"    # Landroid/widget/ImageView;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;
    .param p3, "networkLogoImageLoader"    # Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/ImageView;",
            "Lcom/xfinity/playerlib/model/EditorialProgram;",
            "Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 211
    .local p4, "premiumNetworks":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/xfinity/playerlib/model/tags/Network;>;"
    const/16 v5, 0x8

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->setupNetworkLogo(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/util/Map;I)V

    .line 212
    return-void
.end method

.method protected setupNetworkLogo(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/util/Map;I)V
    .locals 4
    .param p1, "networkLogoView"    # Landroid/widget/ImageView;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;
    .param p3, "networkLogoImageLoader"    # Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .param p5, "stateWhenNotShowing"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/ImageView;",
            "Lcom/xfinity/playerlib/model/EditorialProgram;",
            "Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 218
    .local p4, "premiumNetworks":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/xfinity/playerlib/model/tags/Network;>;"
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/EditorialProgram;->getBrand()Ljava/lang/String;

    move-result-object v1

    .line 219
    .local v1, "networkBrand":Ljava/lang/String;
    invoke-interface {p4, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 220
    invoke-interface {p4, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/Network;

    .line 221
    .local v0, "network":Lcom/xfinity/playerlib/model/tags/Network;
    const/4 v2, 0x0

    invoke-virtual {p1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 222
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v2

    invoke-virtual {p3, v2, v3, p1}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadNetworkLogoSmall(JLandroid/widget/ImageView;)V

    .line 226
    .end local v0    # "network":Lcom/xfinity/playerlib/model/tags/Network;
    :goto_0
    return-void

    .line 224
    :cond_0
    invoke-virtual {p1, p5}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method protected setupProgramArt(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;Lcom/xfinity/playerlib/model/EditorialProgram;)V
    .locals 1
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;

    .prologue
    .line 91
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->setupProgramArt(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;Lcom/xfinity/playerlib/model/EditorialProgram;Z)V

    .line 93
    return-void
.end method

.method protected setupProgramArt(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;Lcom/xfinity/playerlib/model/EditorialProgram;Z)V
    .locals 7
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;
    .param p3, "leavePlaceHolderOn"    # Z

    .prologue
    const/4 v3, 0x0

    const/4 v6, 0x0

    .line 97
    iget-object v4, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->placeholderTitle:Landroid/widget/TextView;

    if-eqz v4, :cond_1

    const/4 v2, 0x1

    .line 99
    .local v2, "placeholderTitleIsPresent":Z
    :goto_0
    iget-object v4, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->container:Landroid/view/View;

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->getContentDescription(Lcom/xfinity/playerlib/model/EditorialProgram;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 101
    if-eqz v2, :cond_0

    .line 102
    iget-object v4, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->placeholderTitle:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 103
    iget-object v3, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->placeholderTitle:Landroid/widget/TextView;

    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->getBestTitle(Lcom/xfinity/playerlib/model/EditorialProgram;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 106
    :cond_0
    invoke-virtual {p0, p2}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->getImageUrl(Lcom/xfinity/playerlib/model/EditorialProgram;)Ljava/lang/String;

    move-result-object v0

    .line 107
    .local v0, "imageUrl":Ljava/lang/String;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v4, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->videoImage:Landroid/widget/ImageView;

    invoke-virtual {v3, v0, v6, v4}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImageFromMemory(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)Z

    move-result v1

    .line 110
    .local v1, "loadedFromMemory":Z
    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->scrollStateTracker:Lcom/xfinity/playerlib/view/ScrollStateTracker;

    invoke-interface {v3}, Lcom/xfinity/playerlib/view/ScrollStateTracker;->isFlinging()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 113
    iget-object v3, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->videoImage:Landroid/widget/ImageView;

    invoke-virtual {v3, v6}, Landroid/widget/ImageView;->setTag(Ljava/lang/Object;)V

    .line 114
    if-nez v1, :cond_2

    .line 115
    iget-object v3, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->videoImage:Landroid/widget/ImageView;

    invoke-virtual {v3, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 146
    :goto_1
    return-void

    .end local v0    # "imageUrl":Ljava/lang/String;
    .end local v1    # "loadedFromMemory":Z
    .end local v2    # "placeholderTitleIsPresent":Z
    :cond_1
    move v2, v3

    .line 97
    goto :goto_0

    .line 117
    .restart local v0    # "imageUrl":Ljava/lang/String;
    .restart local v1    # "loadedFromMemory":Z
    .restart local v2    # "placeholderTitleIsPresent":Z
    :cond_2
    iget-object v3, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->placeholderTitle:Landroid/widget/TextView;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 120
    :cond_3
    iget-object v3, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->videoImage:Landroid/widget/ImageView;

    invoke-virtual {v3, v6}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 123
    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v4, p1, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;->videoImage:Landroid/widget/ImageView;

    new-instance v5, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;

    invoke-direct {v5, p0, p3, v2, p1}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$1;-><init>(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;ZZLcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;)V

    invoke-virtual {v3, v0, v4, v5}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->loadImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    goto :goto_1
.end method
