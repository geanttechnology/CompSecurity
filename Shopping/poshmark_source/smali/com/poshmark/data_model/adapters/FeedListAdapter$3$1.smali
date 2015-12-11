.class Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;
.super Ljava/lang/Object;
.source "FeedListAdapter.java"

# interfaces
.implements Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/data_model/adapters/FeedListAdapter$3;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/poshmark/data_model/adapters/FeedListAdapter$3;

.field final synthetic val$feedItem:Lcom/poshmark/data_model/models/ListingSocial;

.field final synthetic val$v:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/FeedListAdapter$3;Landroid/view/View;Lcom/poshmark/data_model/models/ListingSocial;)V
    .locals 0

    .prologue
    .line 106
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;->this$1:Lcom/poshmark/data_model/adapters/FeedListAdapter$3;

    iput-object p2, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;->val$v:Landroid/view/View;

    iput-object p3, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;->val$feedItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoadingCancelled(Ljava/lang/String;Landroid/view/View;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 121
    return-void
.end method

.method public onLoadingComplete(Ljava/lang/String;Landroid/view/View;Landroid/graphics/Bitmap;)V
    .locals 5
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "imgView"    # Landroid/view/View;
    .param p3, "loadedImage"    # Landroid/graphics/Bitmap;

    .prologue
    .line 110
    const-string v3, "ListingCoverShot.jpg"

    invoke-static {p3, v3}, Lcom/poshmark/utils/ImageUtils;->saveBitmapToDisk(Landroid/graphics/Bitmap;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 111
    .local v1, "imgUri":Landroid/net/Uri;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 112
    .local v0, "b":Landroid/os/Bundle;
    const-string v3, "MODE"

    sget-object v4, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v4}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->name()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    const-string v3, "IMAGE_URI"

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    iget-object v3, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;->val$v:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/PMActivity;

    .line 115
    .local v2, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v3, Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v4, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;->val$feedItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v2, v0, v3, v4}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 116
    return-void
.end method

.method public onLoadingFailed(Ljava/lang/String;Landroid/view/View;Lcom/nostra13/universalimageloader/core/assist/FailReason;)V
    .locals 4
    .param p1, "imageUri"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "failReason"    # Lcom/nostra13/universalimageloader/core/assist/FailReason;

    .prologue
    .line 130
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 131
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->SHARE_MODE_LISTING:Lcom/poshmark/utils/ShareManager$SHARE_MODE;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager$SHARE_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 132
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;->val$v:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/PMActivity;

    .line 133
    .local v1, "parentActivity":Lcom/poshmark/ui/PMActivity;
    const-class v2, Lcom/poshmark/ui/fragments/ShareFragment;

    iget-object v3, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;->val$feedItem:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v1, v0, v2, v3}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 134
    return-void
.end method

.method public onLoadingStarted(Ljava/lang/String;Landroid/view/View;)V
    .locals 0
    .param p1, "s"    # Ljava/lang/String;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 126
    return-void
.end method
