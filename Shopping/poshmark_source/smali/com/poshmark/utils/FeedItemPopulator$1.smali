.class final Lcom/poshmark/utils/FeedItemPopulator$1;
.super Ljava/lang/Object;
.source "FeedItemPopulator.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/FeedItemPopulator;->populateImages(Landroid/content/Context;Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;Lcom/poshmark/data_model/models/FeedItem;Lcom/poshmark/utils/view_holders/FeedItemViewHolder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 145
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 149
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/FeedItem;

    .line 150
    .local v2, "savedFeedItem":Lcom/poshmark/data_model/models/FeedItem;
    iget-object v4, v2, Lcom/poshmark/data_model/models/FeedItem;->contentArray:Ljava/util/List;

    invoke-interface {v4, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PoshmarkPost;

    .line 151
    .local v1, "post":Lcom/poshmark/data_model/models/PoshmarkPost;
    iget-object v4, v1, Lcom/poshmark/data_model/models/PoshmarkPost;->target:Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;

    if-eqz v4, :cond_0

    iget-object v4, v1, Lcom/poshmark/data_model/models/PoshmarkPost;->target:Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;

    iget-object v4, v4, Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;->url:Ljava/lang/String;

    if-eqz v4, :cond_0

    .line 152
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 153
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    instance-of v4, v0, Lcom/poshmark/ui/MainActivity;

    if-eqz v4, :cond_0

    .line 154
    iget-object v4, v1, Lcom/poshmark/data_model/models/PoshmarkPost;->target:Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;

    iget-object v4, v4, Lcom/poshmark/data_model/models/PoshmarkPost$PostTarget;->url:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 155
    .local v3, "uri":Landroid/net/Uri;
    check-cast v0, Lcom/poshmark/ui/MainActivity;

    .end local v0    # "parentActivity":Lcom/poshmark/ui/PMActivity;
    invoke-virtual {v0, v3, v5}, Lcom/poshmark/ui/MainActivity;->handleDeepLinkLaunch(Landroid/net/Uri;Z)V

    .line 158
    .end local v3    # "uri":Landroid/net/Uri;
    :cond_0
    return-void
.end method
