.class public Lcom/xfinity/playerlib/image/VideoAdapter;
.super Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;
.source "VideoAdapter.java"


# direct methods
.method public constructor <init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/lang/String;Lcom/xfinity/playerlib/view/ScrollStateTracker;)V
    .locals 0
    .param p1, "layoutInflator"    # Landroid/view/LayoutInflater;
    .param p2, "coverArtImageLoader"    # Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .param p3, "networkLogoLoader"    # Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .param p4, "listHeadingForAccessibility"    # Ljava/lang/String;
    .param p5, "scrollStateTracker"    # Lcom/xfinity/playerlib/view/ScrollStateTracker;

    .prologue
    .line 12
    invoke-direct/range {p0 .. p5}, Lcom/xfinity/playerlib/view/featured/FeaturedAdapter;-><init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Ljava/lang/String;Lcom/xfinity/playerlib/view/ScrollStateTracker;)V

    .line 13
    return-void
.end method


# virtual methods
.method protected getImageUrl(Lcom/xfinity/playerlib/model/EditorialProgram;)Ljava/lang/String;
    .locals 1
    .param p1, "program"    # Lcom/xfinity/playerlib/model/EditorialProgram;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/xfinity/playerlib/image/VideoAdapter;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->getImageUrl(Lcom/xfinity/playerlib/model/Program;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 22
    sget v0, Lcom/xfinity/playerlib/R$layout;->browse_program_item:I

    return v0
.end method
