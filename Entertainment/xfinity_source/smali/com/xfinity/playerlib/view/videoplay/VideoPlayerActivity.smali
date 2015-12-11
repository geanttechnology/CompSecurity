.class public Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;
.source "VideoPlayerActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;
.implements Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;
.implements Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;
.implements Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$VideoPlayOrResumePressedListener;
.implements Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;
.implements Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;
.implements Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;
.implements Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$AdobePlayerActivitySpeechRecognizer;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private final appirater:Lcom/ijsbrandslob/appirater/Appirater;

.field private appiraterCallback:Ljava/lang/Runnable;

.field private handler:Landroid/os/Handler;

.field private orientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

.field private final playerConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 47
    const-class v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;-><init>()V

    .line 60
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 61
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 62
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAppirater()Lcom/ijsbrandslob/appirater/Appirater;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    .line 63
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->playerConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 281
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$2;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->orientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    .line 345
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;)Lcom/ijsbrandslob/appirater/Appirater;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->appirater:Lcom/ijsbrandslob/appirater/Appirater;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;)Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    return-object v0
.end method

.method public static createBundle(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JJ)Landroid/os/Bundle;
    .locals 4
    .param p0, "id"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p1, "parentId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "companyId"    # J
    .param p4, "playbackStartTimeInMillis"    # J

    .prologue
    const-wide/16 v2, 0x0

    .line 189
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 190
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "merlinId"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 191
    const-string v1, "parentMerlinId"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 193
    cmp-long v1, p2, v2

    if-lez v1, :cond_0

    .line 194
    const-string v1, "companyId"

    invoke-virtual {v0, v1, p2, p3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 198
    :cond_0
    cmp-long v1, p4, v2

    if-lez v1, :cond_1

    .line 199
    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/PlayerVideoIntent;->POSITION:Lcom/xfinity/playerlib/view/videoplay/PlayerVideoIntent;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerVideoIntent;->name()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, p4, p5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 202
    :cond_1
    return-object v0
.end method

.method public static createBundle(Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "streamName"    # Ljava/lang/String;

    .prologue
    .line 207
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 208
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "liveStreamName"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 209
    return-object v0
.end method

.method public static createBundle(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "streamName"    # Ljava/lang/String;
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 213
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 214
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "liveStreamName"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    const-string v1, "liveEventID"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 216
    return-object v0
.end method

.method public static createBundleForPlayer(Lcom/xfinity/playerlib/model/MerlinId;J)Landroid/os/Bundle;
    .locals 3
    .param p0, "parentMerlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p1, "videoId"    # J

    .prologue
    .line 147
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 148
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "parentMerlinId"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 149
    const-string v1, "videoId"

    invoke-virtual {v0, v1, p1, p2}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 150
    return-object v0
.end method

.method public static createBundleForPlayer(Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "liveStreamId"    # Ljava/lang/String;

    .prologue
    .line 154
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 155
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "liveStreamID"

    invoke-virtual {v0, v1, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 156
    return-object v0
.end method

.method public static createBundleForPlayer(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;
    .locals 2
    .param p0, "liveStreamId"    # Ljava/lang/String;
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 160
    invoke-static {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundleForPlayer(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 161
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "liveEventID"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 162
    return-object v0
.end method

.method public static createIntentForPlayer(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)Landroid/content/Intent;
    .locals 4
    .param p0, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 166
    invoke-virtual {p0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getVideoId()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/MerlinId;J)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static createIntentForPlayer(Lcom/xfinity/playerlib/model/MerlinId;J)Landroid/content/Intent;
    .locals 5
    .param p0, "parentMerlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p1, "videoId"    # J

    .prologue
    .line 140
    new-instance v1, Landroid/content/Intent;

    invoke-static {}, Lcom/xfinity/playerlib/PlayerApplication;->getInstance()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    const-class v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 141
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {p0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundleForPlayer(Lcom/xfinity/playerlib/model/MerlinId;J)Landroid/os/Bundle;

    move-result-object v0

    .line 142
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 143
    return-object v1
.end method

.method public static createIntentForPlayer(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/content/Intent;
    .locals 4
    .param p0, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 170
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/MerlinId;J)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method public static createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;
    .locals 4
    .param p0, "liveStreamId"    # Ljava/lang/String;

    .prologue
    .line 174
    new-instance v1, Landroid/content/Intent;

    invoke-static {}, Lcom/xfinity/playerlib/PlayerApplication;->getInstance()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    const-class v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 175
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundleForPlayer(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 176
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 177
    return-object v1
.end method

.method public static createIntentForPlayer(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    .locals 4
    .param p0, "liveStreamId"    # Ljava/lang/String;
    .param p1, "eventId"    # Ljava/lang/String;

    .prologue
    .line 181
    new-instance v1, Landroid/content/Intent;

    invoke-static {}, Lcom/xfinity/playerlib/PlayerApplication;->getInstance()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    const-class v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 182
    .local v1, "intent":Landroid/content/Intent;
    invoke-static {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundleForPlayer(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 183
    .local v0, "bundle":Landroid/os/Bundle;
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 184
    return-object v1
.end method


# virtual methods
.method protected addDefaultActivitySpeechListener()V
    .locals 2

    .prologue
    .line 342
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$AdobePlayerActivitySpeechRecognizer;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$AdobePlayerActivitySpeechRecognizer;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$1;)V

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 343
    return-void
.end method

.method public getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
    .locals 1

    .prologue
    .line 290
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->orientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    return-object v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 337
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    return-object v0
.end method

.method protected getUserManager()Lcom/comcast/cim/model/user/UserManager;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/model/user/UserManager",
            "<",
            "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
            "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 70
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method public onBackPressed()V
    .locals 3

    .prologue
    .line 131
    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Back system button hit"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 133
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 134
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 135
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onBackPressed()V

    .line 137
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 75
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onCreate(Landroid/os/Bundle;)V

    .line 77
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isKindle()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 78
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x400

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 81
    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$layout;->video_player:I

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->setContentView(I)V

    .line 82
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->handler:Landroid/os/Handler;

    .line 84
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity$1;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->appiraterCallback:Ljava/lang/Runnable;

    .line 91
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->appiraterCallback:Ljava/lang/Runnable;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->playerConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getTimeElapsedWithoutLeavingThePlayerBeforeRatingsPrompt()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 92
    return-void
.end method

.method protected onDestroy()V
    .locals 2

    .prologue
    .line 125
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onDestroy()V

    .line 126
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->appiraterCallback:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 127
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 295
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 296
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onVolumeHardwareKeyPressed(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 297
    const/4 v1, 0x1

    .line 299
    :goto_0
    return v1

    :cond_0
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public onLiveEventClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "eventId"    # Ljava/lang/String;

    .prologue
    .line 313
    return-void
.end method

.method public onLiveStreamClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 3
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 304
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 305
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 306
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onLiveStreamClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 308
    :cond_0
    return-void
.end method

.method public onLiveStreamPlayOrResumePressed(Ljava/lang/String;)V
    .locals 3
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 317
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 318
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 319
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onLiveStreamPlayOrResumePressed(Ljava/lang/String;)V

    .line 321
    :cond_0
    return-void
.end method

.method public onNewIntent(Landroid/content/Intent;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 96
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 97
    .local v0, "action":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string v2, "reset"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 98
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->setIntent(Landroid/content/Intent;)V

    .line 99
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v2, v3}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 100
    .local v1, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v1, :cond_0

    .line 101
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->reset()V

    .line 104
    .end local v1    # "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 119
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onPause()V

    .line 120
    sget-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "onPause"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 121
    return-void
.end method

.method public onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 3
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 244
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 245
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 246
    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 248
    :cond_0
    return-void
.end method

.method public onResumeInternal()V
    .locals 3

    .prologue
    .line 108
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onResumeInternal()V

    .line 109
    sget-object v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->LOG:Lorg/slf4j/Logger;

    const-string v2, "onResume"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 111
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 112
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "reset"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 113
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 114
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->checkTalkBackModeOnResume(Landroid/content/Intent;)V

    .line 115
    return-void
.end method

.method public onSpeechSwipe()V
    .locals 3

    .prologue
    .line 326
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 328
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 329
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onSpeechSwiped()V

    .line 332
    :cond_0
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingActivity;->onSpeechSwipe()V

    .line 333
    return-void
.end method

.method public onVideoPlayOrResumePressed(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 3
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 252
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 253
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 254
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onVideoPlayOrResumePressed(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 256
    :cond_0
    return-void
.end method

.method public playLiveStream(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
    .locals 3
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    .prologue
    .line 229
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 230
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 231
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playLiveStream(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V

    .line 233
    :cond_0
    return-void
.end method

.method public shouldShowSeriesListItemsChecked()Z
    .locals 1

    .prologue
    .line 277
    const/4 v0, 0x0

    return v0
.end method

.method public showDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/Long;)V
    .locals 3
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .param p2, "currentlyPlayingVideoId"    # Ljava/lang/Long;

    .prologue
    .line 237
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 238
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 239
    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->showDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/Long;)V

    .line 241
    :cond_0
    return-void
.end method

.method public showDetail(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 3
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 221
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 222
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 223
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->showDetail(Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 225
    :cond_0
    return-void
.end method

.method public showSeriesDetail()V
    .locals 3

    .prologue
    .line 260
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 261
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 262
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->showSeriesDetail()V

    .line 264
    :cond_0
    return-void
.end method

.method public showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 3
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 268
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->main_player_fragment:I

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .line 270
    .local v0, "fragment":Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    if-eqz v0, :cond_0

    .line 271
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    .line 273
    :cond_0
    return-void
.end method
