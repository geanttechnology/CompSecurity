.class public Lcom/xfinity/playerlib/view/programdetails/BabyGuideSeriesEntityActivity;
.super Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;
.source "BabyGuideSeriesEntityActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected getEpisodeDetailActivityClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 10
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/BabyGuideEpisodeDetailActivity;

    return-object v0
.end method
