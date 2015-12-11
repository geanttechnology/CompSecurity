.class Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AllNetworksAdapter;
.super Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AbstractNetworksAdapter;
.source "NetworksFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AllNetworksAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Landroid/view/LayoutInflater;)V
    .locals 0
    .param p2, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 371
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AllNetworksAdapter;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .line 372
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AbstractNetworksAdapter;-><init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Landroid/view/LayoutInflater;)V

    .line 373
    return-void
.end method


# virtual methods
.method protected bindImageViewItem(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;Lcom/xfinity/playerlib/model/tags/Network;)V
    .locals 8
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;
    .param p2, "network"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 382
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AllNetworksAdapter;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # invokes: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->getNetworkNameDrawable(Lcom/xfinity/playerlib/model/tags/Network;)Landroid/graphics/drawable/Drawable;
    invoke-static {v0, p2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$1700(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Lcom/xfinity/playerlib/model/tags/Network;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    .line 383
    .local v5, "networkNameDrawable":Landroid/graphics/drawable/Drawable;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AllNetworksAdapter;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;->access$1800(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;)Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v1

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v2

    iget-object v4, p1, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;->imageViewItem:Landroid/widget/ImageView;

    const/4 v7, 0x0

    move-object v6, v5

    invoke-virtual/range {v1 .. v7}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadNetworkLogoSmall(JLandroid/widget/ImageView;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Z)V

    .line 385
    return-void
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 377
    sget v0, Lcom/xfinity/playerlib/R$layout;->network_item_std:I

    return v0
.end method
