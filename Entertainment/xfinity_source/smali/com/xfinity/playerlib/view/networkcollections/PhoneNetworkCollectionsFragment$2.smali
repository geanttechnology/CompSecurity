.class Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$2;
.super Ljava/lang/Object;
.source "PhoneNetworkCollectionsFragment.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->getOnLongClickListenerForProgramDetail(Lcom/xfinity/playerlib/model/tags/FeaturedShow;)Landroid/view/View$OnLongClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

.field final synthetic val$featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;Lcom/xfinity/playerlib/model/tags/FeaturedShow;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    .prologue
    .line 301
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$2;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$2;->val$featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 304
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$2;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$2;->this$0:Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment;

    new-instance v2, Lcom/xfinity/playerlib/model/VideoFavorite;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$2;->val$featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    .line 305
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/networkcollections/PhoneNetworkCollectionsFragment$2;->val$featuredShow:Lcom/xfinity/playerlib/model/tags/FeaturedShow;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/tags/FeaturedShow;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V

    .line 304
    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 306
    const/4 v0, 0x1

    return v0
.end method
