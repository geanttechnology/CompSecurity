.class Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;
.super Ljava/lang/Object;
.source "SeriesEpisodeListFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    .prologue
    .line 390
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;->this$1:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create(Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;)Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter$OnInfoClickListener;
    .locals 1
    .param p1, "adapter"    # Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    .prologue
    .line 393
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;)V

    return-object v0
.end method
