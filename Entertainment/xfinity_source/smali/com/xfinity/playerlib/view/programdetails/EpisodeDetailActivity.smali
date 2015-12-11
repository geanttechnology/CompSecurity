.class public Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;
.super Lcom/xfinity/playerlib/view/programdetails/DetailActivity;
.source "EpisodeDetailActivity.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 20
    sget v0, Lcom/xfinity/playerlib/R$layout;->flyin_episode_detail:I

    return v0
.end method

.method public onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 66
    invoke-static {p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/content/Intent;

    move-result-object v0

    .line 67
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "reset"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 68
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 69
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->startActivity(Landroid/content/Intent;)V

    .line 70
    return-void
.end method

.method public onResumeInternal()V
    .locals 3

    .prologue
    .line 25
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->onResumeInternal()V

    .line 26
    sget-object v1, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;->LOG:Lorg/slf4j/Logger;

    const-string v2, "onResumeInternal"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 30
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;)V

    .line 61
    .local v0, "showOptionsOnceAsyncTask":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Ljava/lang/Boolean;>;"
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 62
    return-void
.end method
