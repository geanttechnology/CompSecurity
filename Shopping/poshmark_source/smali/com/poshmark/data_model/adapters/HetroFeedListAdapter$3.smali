.class Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$3;
.super Ljava/lang/Object;
.source "HetroFeedListAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$3;->this$0:Lcom/poshmark/data_model/adapters/HetroFeedListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 100
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 101
    .local v0, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    move-object v1, p1

    .line 102
    .local v1, "v":Landroid/view/View;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v2

    const-string v3, "listings_feed_screen"

    const-string v4, "listing"

    const-string v5, "share_button_tapped"

    const/4 v6, 0x0

    invoke-virtual {v2, v3, v4, v5, v6}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 104
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getCovershot()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$3$1;

    invoke-direct {v4, p0, v1, v0}, Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$3$1;-><init>(Lcom/poshmark/data_model/adapters/HetroFeedListAdapter$3;Landroid/view/View;Lcom/poshmark/data_model/models/ListingSocial;)V

    invoke-virtual {v2, v3, v4}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 134
    return-void
.end method
