.class public Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;
.super Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;
.source "PhoneCoverAdapter.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field protected static coverImageHeightPx:I


# instance fields
.field protected final configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->LOG:Lorg/slf4j/Logger;

    .line 36
    const/4 v0, 0x0

    sput v0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->coverImageHeightPx:I

    return-void
.end method

.method public constructor <init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Lcom/xfinity/playerlib/config/PlayerConfiguration;Ljava/lang/String;)V
    .locals 7
    .param p1, "layoutInflator"    # Landroid/view/LayoutInflater;
    .param p2, "coverArtImageLoader"    # Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .param p3, "networkLogoLoader"    # Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .param p4, "configuration"    # Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .param p5, "listHeadingForAccessibility"    # Ljava/lang/String;

    .prologue
    .line 46
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p5

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;-><init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/lang/String;Lcom/xfinity/playerlib/view/ScrollStateTracker;)V

    .line 47
    iput-object p4, p0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 49
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->getCoverImageHeight()Landroid/graphics/Point;

    move-result-object v6

    .line 51
    .local v6, "point":Landroid/graphics/Point;
    iget v0, v6, Landroid/graphics/Point;->y:I

    sput v0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->coverImageHeightPx:I

    .line 52
    return-void
.end method


# virtual methods
.method protected adjustImageHeight(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 68
    sget v2, Lcom/xfinity/playerlib/R$id;->cover_art:I

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 70
    .local v0, "coverImage":Landroid/widget/ImageView;
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, -0x1

    sget v3, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->coverImageHeightPx:I

    invoke-direct {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 75
    .local v1, "params":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 76
    invoke-virtual {v0}, Landroid/widget/ImageView;->requestLayout()V

    .line 77
    return-void
.end method

.method protected getCoverImageHeight()Landroid/graphics/Point;
    .locals 5

    .prologue
    .line 88
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->context:Landroid/content/Context;

    const-string v3, "window"

    invoke-virtual {v2, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowManager;

    .line 89
    .local v1, "wm":Landroid/view/WindowManager;
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 91
    .local v0, "display":Landroid/view/Display;
    new-instance v2, Landroid/graphics/Point;

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v3

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    invoke-direct {v2, v3, v4}, Landroid/graphics/Point;-><init>(II)V

    return-object v2
.end method

.method public getImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;
    .locals 5
    .param p1, "imageWidth"    # I
    .param p2, "imageHeight"    # I
    .param p3, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 121
    sget-object v0, Ljava/util/Locale;->US:Ljava/util/Locale;

    const-string v1, "%s/%d/%d/%d?noRedir=true"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 122
    invoke-virtual {v4}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getEntityThumbnailUri()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    .line 123
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    .line 121
    invoke-static {v0, v1, v2}, Ljava/lang/String;->format(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getImageUrl(Lcom/xfinity/playerlib/model/EditorialProgram;)Ljava/lang/String;
    .locals 3
    .param p1, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;

    .prologue
    .line 109
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getImageKey()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getImageKey()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 110
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getImageKey()Ljava/lang/String;

    move-result-object v0

    .line 111
    :goto_0
    return-object v0

    .line 110
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->context:Landroid/content/Context;

    .line 111
    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$dimen;->editorial_cover_src_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->context:Landroid/content/Context;

    .line 112
    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$dimen;->editorial_cover_src_height:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    .line 113
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    .line 111
    invoke-virtual {p0, v0, v1, v2}, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->getImageUrl(IILcom/xfinity/playerlib/model/MerlinId;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "i"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    .line 61
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 62
    .local v0, "ret":Landroid/view/View;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->adjustImageHeight(Landroid/view/View;)V

    .line 63
    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 56
    sget v0, Lcom/xfinity/playerlib/R$layout;->phone_cover_item:I

    return v0
.end method

.method protected setupLockedIndicator(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 1
    .param p1, "lockedView"    # Landroid/widget/ImageView;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;
    .param p3, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 131
    const/16 v0, 0x8

    invoke-virtual {p0, p1, p2, p3, v0}, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->setupLockedIndicator(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;I)V

    .line 132
    return-void
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
    .line 139
    .local p4, "premiumNetworks":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/xfinity/playerlib/model/tags/Network;>;"
    const/16 v5, 0x8

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->setupNetworkLogo(Landroid/widget/ImageView;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/util/Map;I)V

    .line 140
    return-void
.end method

.method protected setupProgramArt(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;Lcom/xfinity/playerlib/model/EditorialProgram;)V
    .locals 1
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;
    .param p2, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;

    .prologue
    .line 102
    const/4 v0, 0x1

    invoke-virtual {p0, p1, p2, v0}, Lcom/xfinity/playerlib/view/featured/PhoneCoverAdapter;->setupProgramArt(Lcom/xfinity/playerlib/view/featured/FeaturedAdapter$VideoViewHolder;Lcom/xfinity/playerlib/model/EditorialProgram;Z)V

    .line 103
    return-void
.end method
