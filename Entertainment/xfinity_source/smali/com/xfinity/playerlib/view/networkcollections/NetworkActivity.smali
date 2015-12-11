.class public abstract Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;
.super Lcom/xfinity/playerlib/view/PlayNowActivity;
.source "NetworkActivity.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/networkcollections/NetworkActionBarController;


# instance fields
.field private collectionTitle:Landroid/widget/TextView;

.field private networkLogo:Landroid/widget/ImageView;

.field private final networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field protected title:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/PlayNowActivity;-><init>()V

    .line 17
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createNetworkLogoImageLoader()Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    return-void
.end method

.method private setCategory(Lcom/xfinity/playerlib/model/tags/Tag;)V
    .locals 2
    .param p1, "category"    # Lcom/xfinity/playerlib/model/tags/Tag;

    .prologue
    .line 81
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->collectionTitle:Landroid/widget/TextView;

    invoke-interface {p1}, Lcom/xfinity/playerlib/model/tags/Tag;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 82
    return-void
.end method

.method private setNetworkName(Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 77
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->title:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    return-void
.end method


# virtual methods
.method public loadNetworkLogo(Lcom/xfinity/playerlib/model/tags/Network;)V
    .locals 3
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 36
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->setNetworkName(Ljava/lang/String;)V

    .line 38
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v0

    if-nez v0, :cond_1

    .line 39
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->title:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 56
    :cond_0
    :goto_0
    return-void

    .line 41
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->networkLogo:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->networkLogo:Landroid/widget/ImageView;

    new-instance v2, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity$1;-><init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;)V

    invoke-virtual {v0, p1, v1, v2}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->loadNetworkLogoLarge(Lcom/xfinity/playerlib/model/tags/Network;Landroid/widget/ImageView;Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;)V

    goto :goto_0
.end method

.method public loadNetworkLogoAndCategory(Lcom/xfinity/playerlib/model/tags/Network;Lcom/xfinity/playerlib/model/tags/Tag;)V
    .locals 0
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .param p2, "category"    # Lcom/xfinity/playerlib/model/tags/Tag;

    .prologue
    .line 60
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->loadNetworkLogo(Lcom/xfinity/playerlib/model/tags/Network;)V

    .line 61
    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->setCategory(Lcom/xfinity/playerlib/model/tags/Tag;)V

    .line 62
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 24
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/PlayNowActivity;->onCreate(Landroid/os/Bundle;)V

    .line 26
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    .line 27
    .local v0, "customAbView":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->network_logo:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->networkLogo:Landroid/widget/ImageView;

    .line 28
    sget v1, Lcom/xfinity/playerlib/R$id;->title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->title:Landroid/widget/TextView;

    .line 29
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->collection_title:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->collectionTitle:Landroid/widget/TextView;

    .line 31
    return-void
.end method

.method public setNetworkNameAndCategory(Lcom/xfinity/playerlib/model/tags/Network;Lcom/xfinity/playerlib/model/tags/Tag;)V
    .locals 1
    .param p1, "network"    # Lcom/xfinity/playerlib/model/tags/Network;
    .param p2, "category"    # Lcom/xfinity/playerlib/model/tags/Tag;

    .prologue
    .line 66
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/tags/Network;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->setNetworkName(Ljava/lang/String;)V

    .line 67
    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/view/networkcollections/NetworkActivity;->setCategory(Lcom/xfinity/playerlib/model/tags/Tag;)V

    .line 68
    return-void
.end method
