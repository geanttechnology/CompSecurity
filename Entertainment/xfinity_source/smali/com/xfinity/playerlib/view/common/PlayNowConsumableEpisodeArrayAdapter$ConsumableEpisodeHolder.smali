.class Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;
.super Ljava/lang/Object;
.source "PlayNowConsumableEpisodeArrayAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConsumableEpisodeHolder"
.end annotation


# instance fields
.field protected downloadableIndicator:Landroid/view/View;

.field protected episodeNumText:Landroid/widget/TextView;

.field protected listItemContainer:Landroid/view/View;

.field protected newIndicator:Landroid/widget/ImageView;

.field protected progressIndicator:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

.field protected titleText:Landroid/widget/TextView;

.field protected watchingIndicator:Landroid/widget/ImageView;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)V
    .locals 0

    .prologue
    .line 246
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;->this$0:Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$1;

    .prologue
    .line 246
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$ConsumableEpisodeHolder;-><init>(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)V

    return-void
.end method
