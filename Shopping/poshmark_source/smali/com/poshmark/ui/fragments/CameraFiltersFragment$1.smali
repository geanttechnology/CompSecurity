.class Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;
.super Ljava/lang/Object;
.source "CameraFiltersFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CameraFiltersFragment;->setupActionBarNextActionButton()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 102
    new-instance v3, Landroid/content/Intent;

    invoke-direct {v3}, Landroid/content/Intent;-><init>()V

    .line 103
    .local v3, "i":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 104
    .local v0, "b":Landroid/os/Bundle;
    const-string v5, "ORIGINALFILE"

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v6, v6, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->fileName:Landroid/net/Uri;

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 105
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    if-eqz v5, :cond_0

    .line 106
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v5, v5, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->imageView:Lcom/poshmark/ui/customviews/PMListingImageView;

    invoke-virtual {v5}, Lcom/poshmark/ui/customviews/PMListingImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 107
    .local v1, "d":Landroid/graphics/drawable/Drawable;
    invoke-static {v1}, Lcom/poshmark/utils/ImageUtils;->saveDrawableToDisk(Landroid/graphics/drawable/Drawable;)Landroid/net/Uri;

    move-result-object v2

    .line 108
    .local v2, "filteredImageFileName":Landroid/net/Uri;
    const-string v5, "FILTEREDFILE"

    invoke-virtual {v0, v5, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 110
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v6, v6, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getFilterNameForType(Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;)Ljava/lang/String;
    invoke-static {v5, v6}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$000(Lcom/poshmark/ui/fragments/CameraFiltersFragment;Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;)Ljava/lang/String;

    move-result-object v4

    .line 111
    .local v4, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v5

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v6, v6, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v7, "listing"

    const-string v8, "image_filter_selected"

    invoke-virtual {v5, v6, v7, v8, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    .end local v1    # "d":Landroid/graphics/drawable/Drawable;
    .end local v2    # "filteredImageFileName":Landroid/net/Uri;
    .end local v4    # "label":Ljava/lang/String;
    :goto_0
    invoke-virtual {v3, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 118
    iget-object v5, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    const/4 v6, -0x1

    invoke-virtual {v5, v6, v3}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 119
    return-void

    .line 114
    :cond_0
    const-string v5, "FILTEREDFILE"

    iget-object v6, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v6, v6, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->fileName:Landroid/net/Uri;

    invoke-virtual {v0, v5, v6}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    goto :goto_0
.end method
