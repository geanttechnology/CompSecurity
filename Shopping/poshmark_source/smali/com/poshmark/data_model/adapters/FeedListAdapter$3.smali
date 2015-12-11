.class Lcom/poshmark/data_model/adapters/FeedListAdapter$3;
.super Ljava/lang/Object;
.source "FeedListAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/adapters/FeedListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/data_model/adapters/FeedListAdapter;


# direct methods
.method constructor <init>(Lcom/poshmark/data_model/adapters/FeedListAdapter;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/FeedListAdapter$3;->this$0:Lcom/poshmark/data_model/adapters/FeedListAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 103
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ListingSocial;

    .line 104
    .local v0, "feedItem":Lcom/poshmark/data_model/models/ListingSocial;
    move-object v1, p1

    .line 106
    .local v1, "v":Landroid/view/View;
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingSocial;->getCovershot()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;

    invoke-direct {v4, p0, v1, v0}, Lcom/poshmark/data_model/adapters/FeedListAdapter$3$1;-><init>(Lcom/poshmark/data_model/adapters/FeedListAdapter$3;Landroid/view/View;Lcom/poshmark/data_model/models/ListingSocial;)V

    invoke-virtual {v2, v3, v4}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 136
    return-void
.end method
