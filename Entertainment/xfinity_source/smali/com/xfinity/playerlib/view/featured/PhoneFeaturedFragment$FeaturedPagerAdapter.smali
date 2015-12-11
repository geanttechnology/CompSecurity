.class Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;
.super Landroid/support/v4/view/PagerAdapter;
.source "PhoneFeaturedFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FeaturedPagerAdapter"
.end annotation


# instance fields
.field private labels:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private programLists:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/util/List",
            "<+",
            "Lcom/xfinity/playerlib/model/EditorialProgram;",
            ">;>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;)V
    .locals 1

    .prologue
    .line 219
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    .line 220
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 216
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->labels:Ljava/util/List;

    .line 217
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->programLists:Ljava/util/List;

    .line 221
    return-void
.end method


# virtual methods
.method public destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 0
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "i"    # I
    .param p3, "o"    # Ljava/lang/Object;

    .prologue
    .line 246
    check-cast p3, Landroid/view/View;

    .end local p3    # "o":Ljava/lang/Object;
    invoke-virtual {p1, p3}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 247
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->labels:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getPageTitle(I)Ljava/lang/CharSequence;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 251
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->labels:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/CharSequence;

    return-object v0
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 4
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "i"    # I

    .prologue
    .line 231
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    invoke-static {}, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->values()[Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    move-result-object v0

    aget-object v2, v0, p2

    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->programLists:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    invoke-virtual {p0, p2}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->getPageTitle(I)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-interface {v3}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v3

    # invokes: Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->buildCoverView(Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/featured/FeaturedSection;Ljava/util/List;Ljava/lang/String;)Landroid/view/View;
    invoke-static {v1, p1, v2, v0, v3}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->access$400(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/featured/FeaturedSection;Ljava/util/List;Ljava/lang/String;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "o"    # Ljava/lang/Object;

    .prologue
    .line 241
    if-ne p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setData(Lcom/xfinity/playerlib/model/editorial/FeaturedResource;)V
    .locals 3
    .param p1, "fr"    # Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    .prologue
    .line 224
    const/4 v0, 0x3

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getCoverVideoCollectionTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getSeriesCollectionTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getMovieCollectionTitle()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->labels:Ljava/util/List;

    .line 225
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getCoverVideos()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getSeries()Ljava/util/List;

    move-result-object v1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getMovies()Ljava/util/List;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->createList(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->programLists:Ljava/util/List;

    .line 226
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$FeaturedPagerAdapter;->notifyDataSetChanged()V

    .line 227
    return-void
.end method
