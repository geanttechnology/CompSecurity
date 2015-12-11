.class Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;
.super Ljava/lang/Object;
.source "PlayNowConsumableEpisodeArrayAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

.field final synthetic val$position:I

.field final synthetic val$watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;I)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;->this$0:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;->val$watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    iput p3, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 115
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;->this$0:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    # getter for: Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->onInfoClickListener:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->access$200(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 116
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;->this$0:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    # getter for: Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->onInfoClickListener:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->access$200(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;->val$watchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    iget v2, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;->val$position:I

    invoke-interface {v0, v1, v2}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;->onClick(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;I)V

    .line 118
    :cond_0
    return-void
.end method
