.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;
.super Ljava/lang/Object;
.source "TabletFeaturedFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->setupViews(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 155
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/16 v2, 0x8

    .line 160
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGallery:Lit/sephiroth/android/library/widget/HListView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$000(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)Lit/sephiroth/android/library/widget/HListView;

    move-result-object v0

    if-nez v0, :cond_0

    .line 172
    :goto_0
    return-void

    .line 164
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-boolean v0, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->isAccessibilityEnabled:Z

    if-eqz v0, :cond_1

    .line 165
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 170
    :goto_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setShowLastWatched(Z)V

    .line 171
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V

    goto :goto_0

    .line 167
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->fade:Lcom/comcast/cim/android/view/common/Fade;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$100(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)Lcom/comcast/cim/android/view/common/Fade;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$1;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->lastWatchedContainer:Landroid/view/View;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/view/common/Fade;->hide(Landroid/view/View;I)V

    goto :goto_1
.end method
