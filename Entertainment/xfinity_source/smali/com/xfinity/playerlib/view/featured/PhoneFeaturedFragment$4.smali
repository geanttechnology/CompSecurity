.class Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;
.super Ljava/lang/Object;
.source "PhoneFeaturedFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->buildCoverView(Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/featured/FeaturedSection;Ljava/util/List;Ljava/lang/String;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

.field final synthetic val$featuredSection:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

.field final synthetic val$gallery:Landroid/widget/ListView;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;Lcom/xfinity/playerlib/view/featured/FeaturedSection;Landroid/widget/ListView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    .prologue
    .line 176
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->val$featuredSection:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->val$gallery:Landroid/widget/ListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 7
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .line 181
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->val$featuredSection:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    sget-object v3, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->TV_SERIES:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    if-ne v2, v3, :cond_1

    .line 182
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->val$gallery:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v2

    invoke-interface {v2, p3}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/EditorialTVSeries;

    .line 183
    .local v1, "editorial":Lcom/xfinity/playerlib/model/EditorialProgram;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    new-instance v4, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 185
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    .line 186
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getTitle()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V

    .line 183
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 206
    .end local v1    # "editorial":Lcom/xfinity/playerlib/model/EditorialProgram;
    :cond_0
    :goto_0
    const/4 v2, 0x1

    return v2

    .line 188
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->val$featuredSection:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    sget-object v3, Lcom/xfinity/playerlib/view/featured/FeaturedSection;->MOVIES:Lcom/xfinity/playerlib/view/featured/FeaturedSection;

    if-ne v2, v3, :cond_2

    .line 189
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->val$gallery:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v2

    invoke-interface {v2, p3}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/EditorialMovie;

    .line 190
    .restart local v1    # "editorial":Lcom/xfinity/playerlib/model/EditorialProgram;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    new-instance v4, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 191
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/EditorialProgram;->getTitle()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V

    .line 190
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    goto :goto_0

    .line 193
    .end local v1    # "editorial":Lcom/xfinity/playerlib/model/EditorialProgram;
    :cond_2
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/CoverVideo;

    .line 194
    .local v0, "cover":Lcom/xfinity/playerlib/model/CoverVideo;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getEntityType()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Movie"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 195
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    new-instance v4, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 197
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getTitle()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V

    .line 195
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    goto :goto_0

    .line 198
    :cond_3
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getEntityType()Ljava/lang/String;

    move-result-object v2

    const-string v3, "TvSeries"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 199
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment$4;->this$0:Lcom/xfinity/playerlib/view/featured/PhoneFeaturedFragment;

    new-instance v4, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 201
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    .line 202
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getTitle()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V

    .line 199
    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    goto :goto_0
.end method
