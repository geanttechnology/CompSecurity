.class public Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
.super Lcom/xfinity/playerlib/view/BaseInstanceState;
.source "SeriesEpisodeListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InstanceState"
.end annotation


# static fields
.field protected static final EXTRA_BUNDLE_PARAMS:Ljava/lang/String;


# instance fields
.field public seriesDetailSelected:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 518
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->EXTRA_BUNDLE_PARAMS:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 516
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/BaseInstanceState;-><init>()V

    .line 520
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->seriesDetailSelected:Z

    return-void
.end method

.method public static fromBundle(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    .locals 1
    .param p0, "in"    # Landroid/os/Bundle;

    .prologue
    .line 538
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->EXTRA_BUNDLE_PARAMS:Ljava/lang/String;

    invoke-virtual {p0, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    return-object v0
.end method


# virtual methods
.method public addToBundle(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .param p1, "out"    # Landroid/os/Bundle;

    .prologue
    .line 532
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->EXTRA_BUNDLE_PARAMS:Ljava/lang/String;

    invoke-virtual {p1, v0, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 533
    return-object p1
.end method

.method public resetWatchableInfo()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 523
    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 524
    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->nonEpisodeVideoId:Ljava/lang/Long;

    .line 527
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->seriesDetailSelected:Z

    .line 528
    return-void
.end method
