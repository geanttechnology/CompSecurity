.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.source "EndCardState.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 0
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 18
    return-void
.end method

.method private showEndCard()V
    .locals 8

    .prologue
    .line 39
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getNextVideoItem()Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object v1

    .line 40
    .local v1, "nextVideo":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;>;"
    if-eqz v1, :cond_0

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 41
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shouldUseDownloadFile()Z

    move-result v5

    if-nez v5, :cond_0

    .line 43
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 45
    .local v4, "sb":Ljava/lang/StringBuilder;
    iget-object v2, v1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 46
    .local v2, "nextVideoFacade":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    iget-object v3, v1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v3, Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 48
    .local v3, "nextWatchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->play:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    .line 49
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    .line 50
    invoke-interface {v3}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getNextItemDisplayTitle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "?"

    .line 51
    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 53
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v5

    invoke-direct {v0, v5}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 54
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 56
    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v6

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$string;->play_next_episode_dialog_title:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    const/4 v6, 0x0

    .line 57
    invoke-virtual {v5, v6}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    const-string v6, "Yes"

    new-instance v7, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;

    invoke-direct {v7, p0, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$2;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 58
    invoke-virtual {v5, v6, v7}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v5

    const-string v6, "No"

    new-instance v7, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$1;

    invoke-direct {v7, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;)V

    .line 65
    invoke-virtual {v5, v6, v7}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 72
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v5

    invoke-virtual {v5}, Landroid/app/AlertDialog;->show()V

    .line 76
    .end local v0    # "builder":Landroid/app/AlertDialog$Builder;
    .end local v2    # "nextVideoFacade":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v3    # "nextWatchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    .end local v4    # "sb":Ljava/lang/StringBuilder;
    :goto_0
    return-void

    .line 74
    :cond_0
    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v6, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;

    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v6, v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/QuitState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method


# virtual methods
.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    const-string v0, "EndCardState"

    return-object v0
.end method

.method public run()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->showEndCard()V

    .line 35
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 21
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/MobileDataWarningState;

    if-eqz v0, :cond_0

    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/EndCardState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 26
    :goto_0
    return-void

    .line 24
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
