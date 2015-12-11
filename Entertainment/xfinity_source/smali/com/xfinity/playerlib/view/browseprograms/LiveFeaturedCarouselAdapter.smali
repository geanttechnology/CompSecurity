.class public Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;
.super Landroid/support/v13/app/FragmentStatePagerAdapter;
.source "LiveFeaturedCarouselAdapter.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$HalLiveFeaturedContentContainer;


# instance fields
.field private final imageHeight:I

.field private final imageWidth:I

.field private liveFeaturedContentList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/FragmentManager;Ljava/util/List;II)V
    .locals 0
    .param p1, "fm"    # Landroid/app/FragmentManager;
    .param p3, "imageWidth"    # I
    .param p4, "imageHeight"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/FragmentManager;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;II)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p2, "liveFeaturedContentList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;>;"
    invoke-direct {p0, p1}, Landroid/support/v13/app/FragmentStatePagerAdapter;-><init>(Landroid/app/FragmentManager;)V

    .line 23
    iput-object p2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;->liveFeaturedContentList:Ljava/util/List;

    .line 24
    iput p3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;->imageWidth:I

    .line 25
    iput p4, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;->imageHeight:I

    .line 26
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;->liveFeaturedContentList:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;->liveFeaturedContentList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getItem(I)Landroid/app/Fragment;
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 30
    new-instance v1, Lcom/xfinity/playerlib/view/CarouselItemFragment;

    invoke-direct {v1}, Lcom/xfinity/playerlib/view/CarouselItemFragment;-><init>()V

    .line 32
    .local v1, "cif":Landroid/app/Fragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 34
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "imageHeight"

    iget v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;->imageHeight:I

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 35
    const-string v2, "imageWidth"

    iget v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;->imageWidth:I

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 36
    const-string v3, "content"

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;->liveFeaturedContentList:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Parcelable;

    invoke-virtual {v0, v3, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 37
    invoke-virtual {v1, v0}, Landroid/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 39
    return-object v1
.end method

.method public setLiveFeaturedContentList(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 49
    .local p1, "liveFeaturedContentList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;->liveFeaturedContentList:Ljava/util/List;

    .line 50
    return-void
.end method
