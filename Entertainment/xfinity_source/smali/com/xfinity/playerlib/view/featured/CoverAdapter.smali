.class public Lcom/xfinity/playerlib/view/featured/CoverAdapter;
.super Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;
.source "CoverAdapter.java"


# direct methods
.method public constructor <init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/lang/String;Lcom/xfinity/playerlib/view/ScrollStateTracker;)V
    .locals 0
    .param p1, "layoutInflator"    # Landroid/view/LayoutInflater;
    .param p2, "coverArtImageLoader"    # Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .param p3, "networkLogoLoader"    # Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .param p4, "listHeadingForAccessibility"    # Ljava/lang/String;
    .param p5, "scrollStateTracker"    # Lcom/xfinity/playerlib/view/ScrollStateTracker;

    .prologue
    .line 13
    invoke-direct/range {p0 .. p5}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;-><init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/lang/String;Lcom/xfinity/playerlib/view/ScrollStateTracker;)V

    .line 14
    return-void
.end method


# virtual methods
.method protected getImageUrl(Lcom/xfinity/playerlib/model/EditorialProgram;)Ljava/lang/String;
    .locals 1
    .param p1, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;

    .prologue
    .line 18
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getImageKey()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 23
    sget v0, Lcom/xfinity/playerlib/R$layout;->featured_cover_item:I

    return v0
.end method
