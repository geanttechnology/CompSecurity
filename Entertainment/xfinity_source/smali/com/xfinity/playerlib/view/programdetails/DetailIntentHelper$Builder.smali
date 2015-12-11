.class public Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
.super Ljava/lang/Object;
.source "DetailIntentHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

.field private companyId:Ljava/lang/Long;

.field private currentlyPlayingVideoId:Ljava/lang/Long;

.field private episodeId:Lcom/xfinity/playerlib/model/MerlinId;

.field private favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

.field private inBabyGuide:Z

.field private instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

.field private loadAsActivity:Z

.field private merlinId:Lcom/xfinity/playerlib/model/MerlinId;

.field private noReferenceObject:Z

.field private overrideNamespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

.field private program:Lcom/xfinity/playerlib/model/dibic/DibicProgram;

.field private seriesId:Lcom/xfinity/playerlib/model/MerlinId;

.field private seriesWatchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

.field private shouldHideSeriesTitle:Z

.field private showDetail:Z

.field private showPanelFittedLayout:Z

.field private showSeriesArt:Z

.field private video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

.field private wantsSubscriptionOnly:Z

.field private watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 1
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    .line 63
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 64
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 2
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    const/4 v1, 0x1

    .line 55
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    .line 56
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 57
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 58
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 59
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    .line 60
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 1
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    .line 71
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 72
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 1
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    .line 79
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesWatchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 80
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    .line 67
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 68
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V
    .locals 1
    .param p1, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    .line 75
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .line 76
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 1
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    .line 89
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->program:Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 90
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/view/BaseInstanceState;Lcom/xfinity/playerlib/model/MerlinId$Namespace;)V
    .locals 1
    .param p1, "instanceState"    # Lcom/xfinity/playerlib/view/BaseInstanceState;
    .param p2, "namespace"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 42
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    .line 83
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    .line 84
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 85
    iget-object v0, p1, Lcom/xfinity/playerlib/view/BaseInstanceState;->currentlyPlayingVideoId:Ljava/lang/Long;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 86
    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/MerlinId;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showSeriesArt:Z

    return v0
.end method

.method static synthetic access$1400(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Ljava/lang/Long;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->companyId:Ljava/lang/Long;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->wantsSubscriptionOnly:Z

    return v0
.end method

.method static synthetic access$1600(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/VideoFavorite;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity:Z

    return v0
.end method

.method static synthetic access$2000(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesWatchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/view/BaseInstanceState;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->instanceState:Lcom/xfinity/playerlib/view/BaseInstanceState;

    return-object v0
.end method

.method static synthetic access$2200(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->program:Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Lcom/xfinity/playerlib/view/BaseInstanceState;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .param p2, "x2"    # Z

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getInstanceStateForNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Lcom/xfinity/playerlib/view/BaseInstanceState;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Landroid/app/Fragment;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .prologue
    .line 24
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getFragmentForNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Landroid/app/Fragment;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Ljava/lang/Long;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideoId:Ljava/lang/Long;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->inBabyGuide:Z

    return v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Ljava/lang/Class;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .param p2, "x2"    # Z

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getDetailActivityClassForNameSpace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Ljava/lang/Class;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    return v0
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    .prologue
    .line 24
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showPanelFittedLayout:Z

    return v0
.end method

.method private getDetailActivityClassForNameSpace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Ljava/lang/Class;
    .locals 1
    .param p1, "namespace"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .param p2, "forBabyGuide"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/MerlinId$Namespace;",
            "Z)",
            "Ljava/lang/Class",
            "<+",
            "Landroid/app/Activity;",
            ">;"
        }
    .end annotation

    .prologue
    .line 172
    if-eqz p2, :cond_1

    .line 173
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {p1, v0}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-class v0, Lcom/xfinity/playerlib/view/programdetails/BabyGuideMovieActivity;

    .line 176
    :goto_0
    return-object v0

    .line 173
    :cond_0
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/BabyGuideSeriesEntityActivity;

    goto :goto_0

    .line 176
    :cond_1
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {p1, v0}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-class v0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailActivity;

    goto :goto_0

    :cond_2
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    goto :goto_0
.end method

.method private getFragmentForNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Landroid/app/Fragment;
    .locals 3
    .param p1, "namespace"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .prologue
    .line 235
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$1;->$SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace:[I

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 251
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Didn\'t expect "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 239
    :pswitch_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showDetail:Z

    if-eqz v0, :cond_0

    .line 240
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;-><init>()V

    .line 248
    :goto_0
    return-object v0

    .line 242
    :cond_0
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;-><init>()V

    goto :goto_0

    .line 245
    :pswitch_1
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;-><init>()V

    goto :goto_0

    .line 248
    :pswitch_2
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;-><init>()V

    goto :goto_0

    .line 235
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private getInstanceStateForNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/BaseInstanceState;
    .locals 3
    .param p1, "namespace"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .prologue
    .line 194
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->hasNoReferenceObject()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->program:Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    if-eqz v0, :cond_2

    .line 195
    :cond_0
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {p1, v0}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 196
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;-><init>()V

    .line 226
    :goto_0
    return-object v0

    .line 198
    :cond_1
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;-><init>()V

    goto :goto_0

    .line 202
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-eqz v0, :cond_5

    .line 204
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->isMovie()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 205
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;-><init>()V

    goto :goto_0

    .line 207
    :cond_3
    if-eqz p1, :cond_4

    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {p1, v0}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 208
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;-><init>()V

    goto :goto_0

    .line 210
    :cond_4
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;-><init>()V

    goto :goto_0

    .line 214
    :cond_5
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$1;->$SwitchMap$com$xfinity$playerlib$model$MerlinId$Namespace:[I

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 229
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Didn\'t expect "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 217
    :pswitch_0
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showDetail:Z

    if-eqz v0, :cond_6

    .line 218
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;-><init>()V

    goto :goto_0

    .line 220
    :cond_6
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;-><init>()V

    goto :goto_0

    .line 223
    :pswitch_1
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;-><init>()V

    goto :goto_0

    .line 226
    :pswitch_2
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;-><init>()V

    goto :goto_0

    .line 214
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private getInstanceStateForNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;Z)Lcom/xfinity/playerlib/view/BaseInstanceState;
    .locals 1
    .param p1, "namespace"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .param p2, "loadAsActivity"    # Z

    .prologue
    .line 183
    if-eqz p2, :cond_0

    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    if-eq p1, v0, :cond_0

    .line 184
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;-><init>()V

    .line 187
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->getInstanceStateForNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/BaseInstanceState;

    move-result-object v0

    goto :goto_0
.end method

.method private getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    if-eqz v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 281
    :goto_0
    return-object v0

    .line 261
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    if-eqz v0, :cond_1

    .line 262
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->bookmark:Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    goto :goto_0

    .line 264
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesWatchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    if-eqz v0, :cond_2

    .line 265
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->seriesWatchable:Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    goto :goto_0

    .line 267
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    if-eqz v0, :cond_3

    .line 268
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->favorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    goto :goto_0

    .line 270
    :cond_3
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    if-eqz v0, :cond_4

    .line 271
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    goto :goto_0

    .line 273
    :cond_4
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->program:Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    if-eqz v0, :cond_5

    .line 274
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->program:Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    goto :goto_0

    .line 276
    :cond_5
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-eqz v0, :cond_7

    .line 277
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->isMovie()Z

    move-result v0

    if-eqz v0, :cond_6

    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    goto :goto_0

    :cond_6
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    goto :goto_0

    .line 281
    :cond_7
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    .locals 2

    .prologue
    .line 93
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$1;)V

    return-object v0
.end method

.method public companyId(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "networkId"    # Ljava/lang/Long;

    .prologue
    .line 157
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->companyId:Ljava/lang/Long;

    .line 158
    return-object p0
.end method

.method public currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "currentlyPlayingVideoId"    # Ljava/lang/Long;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 103
    return-object p0
.end method

.method public episodeId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "episodeId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 142
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 143
    return-object p0
.end method

.method protected hasNoReferenceObject()Z
    .locals 1

    .prologue
    .line 167
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->noReferenceObject:Z

    return v0
.end method

.method public isInBabyGuide(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "inBabyGuide"    # Z

    .prologue
    .line 97
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->inBabyGuide:Z

    .line 98
    return-object p0
.end method

.method public loadAsActivity(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "loadAsActivity"    # Z

    .prologue
    .line 117
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity:Z

    .line 118
    return-object p0
.end method

.method public overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "overrideNamespace"    # Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .prologue
    .line 127
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 128
    return-object p0
.end method

.method public shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "shouldHideSeriesTitle"    # Z

    .prologue
    .line 107
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle:Z

    .line 108
    return-object p0
.end method

.method public showDetail(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "showDetail"    # Z

    .prologue
    .line 132
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showDetail:Z

    .line 133
    return-object p0
.end method

.method public showPanelFittedLayout(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "showPanelFittedLayout"    # Z

    .prologue
    .line 112
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showPanelFittedLayout:Z

    .line 113
    return-object p0
.end method

.method public showSeriesArt(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "showSeriesArt"    # Z

    .prologue
    .line 137
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showSeriesArt:Z

    .line 138
    return-object p0
.end method

.method public wantsSubscriptionOnly(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;
    .locals 0
    .param p1, "wantsSubscriptionOnly"    # Z

    .prologue
    .line 162
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->wantsSubscriptionOnly:Z

    .line 163
    return-object p0
.end method
