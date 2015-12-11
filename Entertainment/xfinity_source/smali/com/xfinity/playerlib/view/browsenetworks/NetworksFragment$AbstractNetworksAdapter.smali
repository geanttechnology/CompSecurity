.class abstract Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AbstractNetworksAdapter;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;
.source "NetworksFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "AbstractNetworksAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter",
        "<",
        "Lcom/xfinity/playerlib/model/tags/Network;",
        "Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;Landroid/view/LayoutInflater;)V
    .locals 0
    .param p2, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 315
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AbstractNetworksAdapter;->this$0:Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment;

    .line 316
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;-><init>(Landroid/view/LayoutInflater;)V

    .line 317
    return-void
.end method


# virtual methods
.method protected abstract bindImageViewItem(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;Lcom/xfinity/playerlib/model/tags/Network;)V
.end method

.method protected bindItem(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;Lcom/xfinity/playerlib/model/tags/Network;)V
    .locals 4
    .param p1, "holder"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;
    .param p2, "network"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 334
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;->textViewItem:Landroid/widget/TextView;

    if-eqz v1, :cond_0

    .line 335
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;->textViewItem:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 336
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;->textViewItem:Landroid/widget/TextView;

    .line 344
    .local v0, "view":Landroid/view/View;
    :goto_0
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 345
    return-void

    .line 337
    .end local v0    # "view":Landroid/view/View;
    :cond_0
    iget-object v1, p1, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;->imageViewItem:Landroid/widget/ImageView;

    if-eqz v1, :cond_1

    .line 338
    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AbstractNetworksAdapter;->bindImageViewItem(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;Lcom/xfinity/playerlib/model/tags/Network;)V

    .line 339
    iget-object v0, p1, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;->imageViewItem:Landroid/widget/ImageView;

    .restart local v0    # "view":Landroid/view/View;
    goto :goto_0

    .line 341
    .end local v0    # "view":Landroid/view/View;
    :cond_1
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unexpected view type for network: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method protected bridge synthetic bindItem(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 313
    check-cast p1, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;

    check-cast p2, Lcom/xfinity/playerlib/model/tags/Network;

    invoke-virtual {p0, p1, p2}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AbstractNetworksAdapter;->bindItem(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;Lcom/xfinity/playerlib/model/tags/Network;)V

    return-void
.end method

.method protected createViewHolder()Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;
    .locals 2

    .prologue
    .line 321
    new-instance v0, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;-><init>(Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$1;)V

    return-object v0
.end method

.method protected bridge synthetic createViewHolder()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 313
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AbstractNetworksAdapter;->createViewHolder()Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;

    move-result-object v0

    return-object v0
.end method

.method protected initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "viewGroup"    # Landroid/view/ViewGroup;
    .param p3, "holder"    # Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;

    .prologue
    .line 327
    sget v0, Lcom/xfinity/playerlib/R$id;->network_textview_item:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;->textViewItem:Landroid/widget/TextView;

    .line 328
    sget v0, Lcom/xfinity/playerlib/R$id;->network_imageview_item:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p3, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;->imageViewItem:Landroid/widget/ImageView;

    .line 329
    return-void
.end method

.method protected bridge synthetic initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 313
    check-cast p3, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;

    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$AbstractNetworksAdapter;->initializeViewHolder(Landroid/view/View;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browsenetworks/NetworksFragment$NetworkViewHolder;)V

    return-void
.end method
