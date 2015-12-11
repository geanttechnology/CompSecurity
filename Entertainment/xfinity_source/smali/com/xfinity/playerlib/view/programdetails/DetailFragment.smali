.class public abstract Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
.source "DetailFragment.java"

# interfaces
.implements Lcom/comcast/cim/downloads/DownloadServiceListener;
.implements Lcom/xfinity/playerlib/view/AnimatedFragment;
.implements Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;,
        Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;,
        Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;,
        Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;,
        Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;",
        "Lcom/comcast/cim/downloads/DownloadServiceListener",
        "<",
        "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
        ">;",
        "Lcom/xfinity/playerlib/view/AnimatedFragment;",
        "Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;"
    }
.end annotation


# instance fields
.field protected final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field protected alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field protected alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

.field protected androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field private animationsEnabled:Z

.field protected bodyContainer:Landroid/view/View;

.field protected bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

.field private commonSenseMediaLabel:Landroid/widget/TextView;

.field private commonSenseMediaTargetRating:Landroid/widget/TextView;

.field protected dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

.field protected downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field protected fetchCanceledListener:Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

.field protected filterByNetwork:Z

.field protected inBabyGuide:Z

.field protected instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field protected isFullScreen:Z

.field private loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

.field protected final logoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field protected playPressedListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

.field protected playerAndroidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field protected final programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

.field private rottenTomatoesCriticIcon:Landroid/widget/ImageView;

.field private rottenTomatoesCriticScore:Landroid/widget/TextView;

.field private rottenTomatoesFanIcon:Landroid/widget/ImageView;

.field private rottenTomatoesFanScore:Landroid/widget/TextView;

.field protected shouldSuppressNetworkLogos:Z

.field private speechListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;

.field protected uiUtil:Lcom/comcast/cim/utils/UIUtil;

.field protected wantsSubscriptionOnly:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;-><init>()V

    .line 82
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createNetworkLogoImageLoader()Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->logoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 83
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createProgramDetailArtImageLoader()Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    .line 84
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoBookmarkDAO()Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    .line 85
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUIUtil()Lcom/comcast/cim/utils/UIUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    .line 86
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->shouldSuppressNetworkLogos()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->shouldSuppressNetworkLogos:Z

    .line 87
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAlternateInterfaceUtil()Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    .line 88
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->playerAndroidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    .line 89
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 96
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 101
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    .line 104
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->animationsEnabled:Z

    .line 106
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 109
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->speechListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;

    .line 1179
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)Lorg/slf4j/Logger;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;ZLandroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    .param p1, "x1"    # Z
    .param p2, "x2"    # Landroid/view/View;

    .prologue
    .line 80
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->toggleProgressState(ZLandroid/view/View;)V

    return-void
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "x2"    # Landroid/view/View;

    .prologue
    .line 80
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadAvailableState(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)Landroid/widget/LinearLayout;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "x2"    # Landroid/view/View;

    .prologue
    .line 80
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showCustomDownloadWaitingState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;)Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "x2"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p3, "x3"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    .prologue
    .line 80
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->buildPlayLaunchClickListener(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;)Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "x2"    # Landroid/view/View;

    .prologue
    .line 80
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->setupCancelDownloadButton(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getEngineStatus()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "x2"    # Landroid/view/View;
    .param p3, "x3"    # Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .prologue
    .line 80
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    return-void
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->inBabyGuide()Z

    move-result v0

    return v0
.end method

.method private buildPlayLaunchClickListener(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;)Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;
    .locals 3
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p3, "playPressedListener"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    .prologue
    .line 1044
    new-instance v0, Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$3;

    invoke-direct {v2, p0, p3, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$3;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/view/common/ConnectivityRequiredOnClickListener;-><init>(Lcom/comcast/cim/utils/UIUtil;Ljava/lang/Runnable;)V

    return-object v0
.end method

.method private buildPlayLaunchDownloadClickListener(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;)Landroid/view/View$OnClickListener;
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p3, "playPressedListener"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    .prologue
    .line 1053
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;

    invoke-direct {v0, p0, p3, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    return-object v0
.end method

.method private getEngineStatus()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .locals 4

    .prologue
    .line 218
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getDownloadEngineStatus()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v2

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 223
    .local v1, "engineStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    :goto_0
    return-object v1

    .line 219
    .end local v1    # "engineStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    :catch_0
    move-exception v0

    .line 220
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->LOG:Lorg/slf4j/Logger;

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadServiceException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 221
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .restart local v1    # "engineStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    goto :goto_0
.end method

.method private inBabyGuide()Z
    .locals 2

    .prologue
    .line 1024
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->inBabyGuide:Z

    if-nez v0, :cond_0

    .line 1025
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1026
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/xfinity/playerlib/view/programdetails/BabyGuideMovieActivity;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1027
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/xfinity/playerlib/view/programdetails/BabyGuideEpisodeDetailActivity;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1028
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    const-class v1, Lcom/xfinity/playerlib/view/programdetails/BabyGuideSeriesEntityActivity;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setProgessBarEnabledState(Landroid/view/View;Z)V
    .locals 1
    .param p1, "layout"    # Landroid/view/View;
    .param p2, "isEnabled"    # Z

    .prologue
    .line 321
    sget v0, Lcom/xfinity/playerlib/R$id;->progress_bar:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p2}, Landroid/view/View;->setEnabled(Z)V

    .line 323
    return-void
.end method

.method private setupCancelDownloadButton(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)V
    .locals 2
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "layout"    # Landroid/view/View;

    .prologue
    .line 393
    sget v1, Lcom/xfinity/playerlib/R$id;->cancel_download:I

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 395
    .local v0, "cancelButton":Landroid/widget/ImageView;
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 417
    return-void
.end method

.method private showCustomDownloadWaitingState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V
    .locals 3
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "layout"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 376
    if-nez p2, :cond_0

    .line 381
    :goto_0
    return-void

    .line 379
    :cond_0
    invoke-direct {p0, p2, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->setProgessBarEnabledState(Landroid/view/View;Z)V

    .line 380
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->download_header_waiting:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0, p2, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->updateDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Ljava/lang/String;Landroid/view/View;Z)V

    goto :goto_0
.end method

.method private showDownloadAvailableState(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Landroid/view/View;)Landroid/widget/LinearLayout;
    .locals 10
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "layout"    # Landroid/view/View;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 255
    sget v5, Lcom/xfinity/playerlib/R$id;->download_item_button:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 256
    .local v2, "downloadButton":Landroid/widget/LinearLayout;
    sget v5, Lcom/xfinity/playerlib/R$id;->d2g_status:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 257
    .local v0, "d2gStatus":Landroid/widget/TextView;
    sget v5, Lcom/xfinity/playerlib/R$id;->d2g_progress:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 261
    .local v4, "videoSize":Landroid/widget/TextView;
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->inBabyGuide()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 262
    invoke-virtual {p2, v9, v7}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 263
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->download_header_babyguide_avail:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 264
    .local v1, "d2gStatusText":Ljava/lang/String;
    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v5}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v5

    if-nez v5, :cond_0

    .line 267
    invoke-virtual {v0, v9}, Landroid/widget/TextView;->setSelected(Z)V

    .line 274
    :cond_0
    :goto_0
    sget v5, Lcom/xfinity/playerlib/R$id;->d2g_graphic:I

    invoke-virtual {p2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 275
    .local v3, "downloadIndicator":Landroid/widget/ImageView;
    sget v5, Lcom/xfinity/playerlib/R$drawable;->icn_downloadable_metadata:I

    invoke-virtual {v3, v5}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 276
    invoke-virtual {v3, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 278
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isDownloadable()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->inBabyGuide()Z

    move-result v5

    if-nez v5, :cond_2

    .line 279
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDefaultDownloadProfile()Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getContentSizeInBytes()J

    move-result-wide v6

    invoke-static {v6, v7}, Lcom/comcast/cim/utils/UIPresentationUtil;->bytesToMB(J)J

    move-result-wide v6

    long-to-int v5, v6

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {p0, v4, v0, v5, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->updateVideoSize(Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;)V

    .line 286
    :goto_1
    return-object v2

    .line 270
    .end local v1    # "d2gStatusText":Ljava/lang/String;
    .end local v3    # "downloadIndicator":Landroid/widget/ImageView;
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->available_for_download:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 271
    .restart local v1    # "d2gStatusText":Ljava/lang/String;
    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 281
    .restart local v3    # "downloadIndicator":Landroid/widget/ImageView;
    :cond_2
    invoke-virtual {p0, v4, v0, v7, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->updateVideoSize(Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;)V

    .line 282
    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 283
    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_1
.end method

.method private showDownloadErrorState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V
    .locals 4
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "layout"    # Landroid/view/View;

    .prologue
    const/4 v3, 0x0

    .line 290
    if-nez p2, :cond_0

    .line 301
    :goto_0
    return-void

    .line 294
    :cond_0
    invoke-direct {p0, p2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->setProgessBarEnabledState(Landroid/view/View;Z)V

    .line 296
    sget v0, Lcom/xfinity/playerlib/R$id;->d2g_status:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->download_header_blocked:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 297
    sget v0, Lcom/xfinity/playerlib/R$id;->d2g_progress:I

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 300
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->download_header_blocked:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0, p2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->updateDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Ljava/lang/String;Landroid/view/View;Z)V

    goto :goto_0
.end method

.method private showDownloadFinishedState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V
    .locals 8
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "layout"    # Landroid/view/View;

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 327
    if-nez p2, :cond_1

    .line 354
    :cond_0
    :goto_0
    return-void

    .line 331
    :cond_1
    sget v3, Lcom/xfinity/playerlib/R$id;->progress_layout:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/view/View;->setVisibility(I)V

    .line 332
    sget v3, Lcom/xfinity/playerlib/R$id;->buttons_layout:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v6}, Landroid/view/View;->setVisibility(I)V

    .line 334
    sget v3, Lcom/xfinity/playerlib/R$id;->d2g_status:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 335
    .local v0, "downloadHeadingCaption":Landroid/widget/TextView;
    sget v3, Lcom/xfinity/playerlib/R$id;->d2g_progress:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 337
    .local v2, "progressCaption":Landroid/widget/TextView;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpectedFileSizeInMb()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->download_header_complete:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v2, v0, v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->updateVideoSize(Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;)V

    .line 338
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$color;->LightBlue:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 340
    sget v3, Lcom/xfinity/playerlib/R$id;->d2g_graphic:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 341
    .local v1, "downloadIndicator":Landroid/widget/ImageView;
    sget v3, Lcom/xfinity/playerlib/R$drawable;->icn_downloaded_metadata:I

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 342
    invoke-virtual {v1, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 344
    sget v3, Lcom/xfinity/playerlib/R$id;->playback_button:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideo()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v4

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->playPressedListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    invoke-direct {p0, v4, v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->buildPlayLaunchDownloadClickListener(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;)Landroid/view/View$OnClickListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 346
    sget v3, Lcom/xfinity/playerlib/R$id;->download_item_button:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3, v7}, Landroid/view/View;->setVisibility(I)V

    .line 348
    sget v3, Lcom/xfinity/playerlib/R$id;->d2g_section:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$color;->black:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/view/View;->setBackgroundColor(I)V

    .line 350
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v3

    sget-object v4, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->NOT_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    if-eq v3, v4, :cond_0

    .line 352
    invoke-direct {p0, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadOVPState(Landroid/view/View;)V

    goto/16 :goto_0
.end method

.method private showDownloadOVPState(Landroid/view/View;)V
    .locals 3
    .param p1, "layout"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    const/16 v1, 0x8

    .line 305
    if-nez p1, :cond_0

    .line 317
    :goto_0
    return-void

    .line 310
    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$id;->progress_layout:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 311
    sget v0, Lcom/xfinity/playerlib/R$id;->video_details:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 312
    sget v0, Lcom/xfinity/playerlib/R$id;->download_item_button:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 313
    sget v0, Lcom/xfinity/playerlib/R$id;->playback_button:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 315
    sget v0, Lcom/xfinity/playerlib/R$id;->buttons_layout:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 316
    sget v0, Lcom/xfinity/playerlib/R$id;->expired_state:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method private showDownloadPausedState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V
    .locals 2
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "layout"    # Landroid/view/View;

    .prologue
    .line 368
    sget v0, Lcom/xfinity/playerlib/R$string;->download_header_paused:I

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;IZ)V

    .line 369
    return-void
.end method

.method private showDownloadProgressState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Z)V
    .locals 2
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "layout"    # Landroid/view/View;
    .param p3, "isDownloading"    # Z

    .prologue
    .line 358
    if-nez p2, :cond_0

    .line 365
    :goto_0
    return-void

    .line 362
    :cond_0
    const/4 v0, 0x1

    invoke-direct {p0, p2, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->setProgessBarEnabledState(Landroid/view/View;Z)V

    .line 364
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->download_header_in_progress_ind:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0, p2, p3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->updateDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Ljava/lang/String;Landroid/view/View;Z)V

    goto :goto_0
.end method

.method private showDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;IZ)V
    .locals 1
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "layout"    # Landroid/view/View;
    .param p3, "download_header_paused"    # I
    .param p4, "isDownloading"    # Z

    .prologue
    .line 384
    if-nez p2, :cond_0

    .line 389
    :goto_0
    return-void

    .line 387
    :cond_0
    const/4 v0, 0x0

    invoke-direct {p0, p2, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->setProgessBarEnabledState(Landroid/view/View;Z)V

    .line 388
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0, p2, p4}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->updateDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Ljava/lang/String;Landroid/view/View;Z)V

    goto :goto_0
.end method

.method private showDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V
    .locals 2
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "layout"    # Landroid/view/View;
    .param p3, "engineStatus"    # Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .prologue
    .line 228
    if-nez p2, :cond_0

    .line 251
    :goto_0
    return-void

    .line 232
    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getAsset()Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-result-object v1

    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    .line 234
    .local v0, "status":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v0, v1, :cond_1

    .line 235
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadFinishedState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V

    goto :goto_0

    .line 236
    :cond_1
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v0, v1, :cond_2

    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v0, v1, :cond_6

    .line 237
    :cond_2
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {p3, v1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 238
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadPausedState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V

    goto :goto_0

    .line 239
    :cond_3
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {p3, v1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 240
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadErrorState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V

    goto :goto_0

    .line 242
    :cond_4
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v0, v1, :cond_5

    .line 243
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadWaitingState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V

    goto :goto_0

    .line 245
    :cond_5
    const/4 v1, 0x1

    invoke-direct {p0, p1, p2, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadProgressState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Z)V

    goto :goto_0

    .line 249
    :cond_6
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadErrorState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V

    goto :goto_0
.end method

.method private showDownloadWaitingState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V
    .locals 2
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "layout"    # Landroid/view/View;

    .prologue
    .line 372
    sget v0, Lcom/xfinity/playerlib/R$string;->download_header_waiting:I

    const/4 v1, 0x0

    invoke-direct {p0, p1, p2, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;IZ)V

    .line 373
    return-void
.end method

.method private toggleProgressState(ZLandroid/view/View;)V
    .locals 5
    .param p1, "onOff"    # Z
    .param p2, "layout"    # Landroid/view/View;

    .prologue
    const/16 v3, 0x8

    const/4 v4, 0x0

    .line 1032
    if-nez p2, :cond_0

    .line 1041
    :goto_0
    return-void

    .line 1036
    :cond_0
    sget v2, Lcom/xfinity/playerlib/R$id;->buttons_layout:I

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 1037
    .local v0, "buttons":Landroid/view/View;
    sget v2, Lcom/xfinity/playerlib/R$id;->progress_layout:I

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 1039
    .local v1, "progress":Landroid/view/View;
    if-eqz p1, :cond_1

    move v2, v3

    :goto_1
    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 1040
    if-eqz p1, :cond_2

    :goto_2
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    :cond_1
    move v2, v4

    .line 1039
    goto :goto_1

    :cond_2
    move v4, v3

    .line 1040
    goto :goto_2
.end method

.method private updateDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Ljava/lang/String;Landroid/view/View;Z)V
    .locals 8
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .param p2, "state"    # Ljava/lang/String;
    .param p3, "layout"    # Landroid/view/View;
    .param p4, "isDownloading"    # Z

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 187
    if-nez p3, :cond_1

    .line 212
    :cond_0
    :goto_0
    return-void

    .line 191
    :cond_1
    sget v3, Lcom/xfinity/playerlib/R$id;->d2g_status:I

    invoke-virtual {p3, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 193
    .local v1, "statusTextView":Landroid/widget/TextView;
    invoke-virtual {v1, p2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 195
    sget v3, Lcom/xfinity/playerlib/R$id;->progress_bar:I

    invoke-virtual {p3, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    .line 197
    .local v0, "progressBar":Landroid/widget/ProgressBar;
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getPercentComplete()I

    move-result v3

    if-le v3, v4, :cond_2

    .line 198
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getPercentComplete()I

    move-result v3

    invoke-virtual {v0, v3}, Landroid/widget/ProgressBar;->setProgress(I)V

    .line 204
    :goto_1
    invoke-virtual {v0, p4}, Landroid/widget/ProgressBar;->setEnabled(Z)V

    .line 206
    if-eqz p1, :cond_0

    .line 207
    sget v3, Lcom/xfinity/playerlib/R$id;->d2g_progress:I

    invoke-virtual {p3, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 208
    .local v2, "videoSize":Landroid/widget/TextView;
    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setFocusable(Z)V

    .line 209
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 210
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v6, Lcom/xfinity/playerlib/R$string;->download_MB_text:I

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpectedFileSizeInMb()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v4, v5

    invoke-virtual {v3, v6, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 201
    .end local v2    # "videoSize":Landroid/widget/TextView;
    :cond_2
    if-eqz p4, :cond_3

    move v3, v4

    :goto_2
    invoke-virtual {v0, v3}, Landroid/widget/ProgressBar;->setProgress(I)V

    goto :goto_1

    :cond_3
    move v3, v5

    goto :goto_2
.end method


# virtual methods
.method protected addVideoItems(Ljava/util/Map;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/Watchable;Ljava/util/SortedSet;Landroid/view/ViewGroup;Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;Ljava/lang/Long;)V
    .locals 17
    .param p2, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p3, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p5, "videoItemContainer"    # Landroid/view/ViewGroup;
    .param p6, "layoutInflator"    # Landroid/view/LayoutInflater;
    .param p7, "playPressedListener"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;
    .param p8, "currentlyPlayingVideoId"    # Ljava/lang/Long;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            "Ljava/util/SortedSet",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            ">;",
            "Landroid/view/ViewGroup;",
            "Landroid/view/LayoutInflater;",
            "Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;",
            "Ljava/lang/Long;",
            ")V"
        }
    .end annotation

    .prologue
    .line 618
    .local p1, "bookmarks":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    .local p4, "sortedVideos":Ljava/util/SortedSet;, "Ljava/util/SortedSet<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)V

    .line 620
    .local v2, "videoItemAdapter":Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;
    invoke-virtual/range {p5 .. p5}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 622
    invoke-interface/range {p4 .. p4}, Ljava/util/SortedSet;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_9

    .line 624
    const/4 v14, 0x0

    .line 625
    .local v14, "countVideosToShow":I
    const/4 v13, 0x0

    .line 628
    .local v13, "currentVideoNumber":I
    invoke-interface/range {p4 .. p4}, Ljava/util/SortedSet;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 629
    .local v3, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v8

    if-eqz v8, :cond_0

    .line 630
    add-int/lit8 v14, v14, 0x1

    goto :goto_0

    .line 634
    .end local v3    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_1
    const/4 v5, 0x1

    if-le v14, v5, :cond_2

    .line 635
    const/4 v13, 0x1

    .line 638
    :cond_2
    invoke-interface/range {p4 .. p4}, Ljava/util/SortedSet;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :cond_3
    :goto_1
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_a

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 640
    .restart local v3    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v5

    if-eqz v5, :cond_6

    .line 641
    move-object/from16 v0, p1

    invoke-interface {v0, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 642
    .local v4, "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProviderCode()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p2

    invoke-virtual {v0, v5}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v7

    .line 643
    .local v7, "isEntitled":Z
    if-nez v7, :cond_4

    if-nez v7, :cond_6

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->wantsSubscriptionOnly:Z

    if-nez v5, :cond_6

    :cond_4
    move-object/from16 v0, p0

    iget-boolean v5, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->filterByNetwork:Z

    if-eqz v5, :cond_5

    move-object/from16 v0, p0

    iget-boolean v5, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->filterByNetwork:Z

    if-eqz v5, :cond_6

    .line 644
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v8

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v5, v5, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->companyId:Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    cmp-long v5, v8, v10

    if-nez v5, :cond_6

    .line 645
    :cond_5
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v8

    invoke-virtual {v5, v8, v9}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v6

    .line 647
    .local v6, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    if-eqz p8, :cond_7

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v8

    invoke-virtual/range {p8 .. p8}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    cmp-long v5, v8, v10

    if-nez v5, :cond_7

    const/4 v12, 0x1

    .line 649
    .local v12, "shouldShowOnNowInd":Z
    :goto_2
    if-eqz p8, :cond_8

    const/4 v5, 0x1

    :goto_3
    move-object/from16 v0, p0

    iput-boolean v5, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->inBabyGuide:Z

    .line 653
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isDownloadable()Z

    move-result v11

    move-object/from16 v5, p3

    move-object/from16 v8, p6

    move-object/from16 v9, p5

    move-object/from16 v10, p7

    .line 651
    invoke-virtual/range {v2 .. v14}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->createView(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;ZLandroid/view/LayoutInflater;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;ZZII)Landroid/view/View;

    move-result-object v15

    .line 655
    .local v15, "videoItem":Landroid/view/View;
    move-object/from16 v0, p5

    invoke-virtual {v0, v15}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 659
    .end local v4    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .end local v6    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .end local v7    # "isEntitled":Z
    .end local v12    # "shouldShowOnNowInd":Z
    .end local v15    # "videoItem":Landroid/view/View;
    :cond_6
    const/4 v5, 0x1

    if-le v14, v5, :cond_3

    .line 660
    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_videos_to_choose_from:I

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-static {v14}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    move-object/from16 v0, p0

    invoke-virtual {v0, v5, v8}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/view/ViewGroup;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 661
    const/4 v5, 0x1

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/view/ViewGroup;->setFocusable(Z)V

    .line 662
    const/4 v5, 0x1

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/view/ViewGroup;->setFocusableInTouchMode(Z)V

    .line 663
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    const/4 v8, 0x1

    move-object/from16 v0, p5

    invoke-virtual {v5, v0, v8}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 664
    add-int/lit8 v13, v13, 0x1

    goto/16 :goto_1

    .line 647
    .restart local v4    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .restart local v6    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .restart local v7    # "isEntitled":Z
    :cond_7
    const/4 v12, 0x0

    goto :goto_2

    .line 649
    .restart local v12    # "shouldShowOnNowInd":Z
    :cond_8
    const/4 v5, 0x0

    goto :goto_3

    .line 668
    .end local v3    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v4    # "bookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .end local v6    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .end local v7    # "isEntitled":Z
    .end local v12    # "shouldShowOnNowInd":Z
    .end local v13    # "currentVideoNumber":I
    .end local v14    # "countVideosToShow":I
    :cond_9
    move-object/from16 v0, p6

    move-object/from16 v1, p5

    invoke-virtual {v2, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$VideoItemAdapter;->createUnavailableView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    move-object/from16 v0, p5

    invoke-virtual {v0, v5}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 670
    :cond_a
    return-void
.end method

.method public extractDataFromBundle(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 554
    invoke-static {p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->fromBundle(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    .line 558
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->companyId:Ljava/lang/Long;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->filterByNetwork:Z

    .line 561
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-boolean v0, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->wantsSubscriptionOnly:Z

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->wantsSubscriptionOnly:Z

    .line 562
    return-void

    .line 558
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected formatAvailability(Ljava/util/Date;)Ljava/lang/String;
    .locals 6
    .param p1, "date"    # Ljava/util/Date;

    .prologue
    .line 125
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 126
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->month_day_year_format:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lorg/apache/commons/lang3/time/FastDateFormat;->getInstance(Ljava/lang/String;)Lorg/apache/commons/lang3/time/FastDateFormat;

    move-result-object v0

    .line 127
    .local v0, "dateFormat":Lorg/apache/commons/lang3/time/FastDateFormat;
    invoke-virtual {v0, p1}, Lorg/apache/commons/lang3/time/FastDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    .line 128
    .local v1, "formattedDate":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->available_until_date_display_format:I

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v1, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method abstract getDetailLayoutId()I
.end method

.method public getFirstPlayButton()Landroid/widget/LinearLayout;
    .locals 3

    .prologue
    .line 1114
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->bodyContainer:Landroid/view/View;

    sget v2, Lcom/xfinity/playerlib/R$id;->playback_button:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 1115
    .local v0, "playButton":Landroid/widget/LinearLayout;
    return-object v0
.end method

.method protected getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    .locals 1

    .prologue
    .line 1105
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    return-object v0
.end method

.method protected getSortedVideos(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/Watchable;)Ljava/util/SortedSet;
    .locals 2
    .param p1, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            ")",
            "Ljava/util/SortedSet",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            ">;"
        }
    .end annotation

    .prologue
    .line 710
    new-instance v0, Ljava/util/TreeSet;

    new-instance v1, Lcom/xfinity/playerlib/model/consumable/VideoComparator;

    invoke-direct {v1, p1}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;-><init>(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    invoke-direct {v0, v1}, Ljava/util/TreeSet;-><init>(Ljava/util/Comparator;)V

    .line 711
    .local v0, "sortedVideos":Ljava/util/TreeSet;, "Ljava/util/TreeSet<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/TreeSet;->addAll(Ljava/util/Collection;)Z

    .line 713
    return-object v0
.end method

.method public abstract getVideoItemViewContainer()Landroid/view/ViewGroup;
.end method

.method public abstract loadScreenInfo()V
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 455
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 456
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->speechListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 458
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->playerAndroidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 459
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 461
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 465
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onAttach(Landroid/app/Activity;)V

    .line 467
    instance-of v2, p1, Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

    if-eqz v2, :cond_1

    move-object v2, p1

    .line 468
    check-cast v2, Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->fetchCanceledListener:Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

    :goto_0
    move-object v2, p1

    .line 473
    check-cast v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->playPressedListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    .line 476
    invoke-virtual {p1}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 477
    .local v0, "fm":Landroid/app/FragmentManager;
    sget-object v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->FRAGMENT_TAG:Ljava/lang/String;

    invoke-virtual {v0, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .line 478
    .local v1, "preDownloadFlowFragment":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    if-eqz v1, :cond_0

    .line 479
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Reattached to pre download flow fragment in progress"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 480
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$FlowEventListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$1;)V

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->setFlowEventListener(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;)V

    .line 483
    :cond_0
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 484
    return-void

    .line 470
    .end local v0    # "fm":Landroid/app/FragmentManager;
    .end local v1    # "preDownloadFlowFragment":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .restart local p1    # "activity":Landroid/app/Activity;
    :cond_1
    iput-object p0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->fetchCanceledListener:Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

    goto :goto_0
.end method

.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 1063
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V

    .line 1064
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 509
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v6

    .line 510
    .local v6, "bundle":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 511
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 514
    :cond_0
    if-eqz p3, :cond_1

    .line 515
    invoke-virtual {v6, p3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 517
    :cond_1
    invoke-virtual {p0, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->extractDataFromBundle(Landroid/os/Bundle;)V

    .line 520
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getDetailLayoutId()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/view/ViewGroup;

    .line 522
    .local v7, "layout":Landroid/view/ViewGroup;
    sget v0, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {v7, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 523
    .local v2, "bodyContainer":Landroid/view/ViewGroup;
    sget v0, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    invoke-virtual {v7, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    .line 524
    .local v3, "loadingIndicator":Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    new-instance v5, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$2;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)V

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;-><init>(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    .line 531
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    sget v1, Lcom/xfinity/playerlib/R$id;->touchy_parent:I

    invoke-interface {v0, v7, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->setupPassiveGestureDetector(Landroid/view/View;I)V

    .line 532
    return-object v7
.end method

.method public onDetach()V
    .locals 2

    .prologue
    .line 488
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onDetach()V

    .line 489
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->speechListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 490
    return-void
.end method

.method public onDownloadEngineStatusChanged(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V
    .locals 6
    .param p1, "status"    # Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    .prologue
    .line 181
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 182
    .local v0, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getVideoItemViewContainer()Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v2

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v3

    invoke-direct {p0, v0, v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    goto :goto_0

    .line 184
    .end local v0    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_0
    return-void
.end method

.method public onDownloadServiceConnected()V
    .locals 0

    .prologue
    .line 134
    return-void
.end method

.method public bridge synthetic onFileDownloadError(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 80
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onFileDownloadError(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadError(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 4
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 159
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 160
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getVideoItemViewContainer()Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadErrorState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V

    .line 162
    :cond_0
    return-void
.end method

.method public bridge synthetic onFileDownloadFinished(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 80
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadFinished(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 4
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 145
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 146
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getVideoItemViewContainer()Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadFinishedState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;)V

    .line 148
    :cond_0
    return-void
.end method

.method public bridge synthetic onFileDownloadStarted(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 80
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onFileDownloadStarted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileDownloadStarted(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 4
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 138
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 139
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getVideoItemViewContainer()Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadProgressState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Z)V

    .line 141
    :cond_0
    return-void
.end method

.method public onFileListUpdated()V
    .locals 8

    .prologue
    .line 166
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->firstTimeLoadStarted()Z

    move-result v2

    if-nez v2, :cond_1

    .line 167
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadScreenInfo()V

    .line 176
    :cond_0
    return-void

    .line 169
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 170
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getEngineStatus()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v1

    .line 171
    .local v1, "status":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/downloads/DownloadFile;

    .local v0, "file":Lcom/comcast/cim/downloads/DownloadFile;
    move-object v2, v0

    .line 172
    check-cast v2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getVideoItemViewContainer()Landroid/view/ViewGroup;

    move-result-object v4

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .end local v0    # "file":Lcom/comcast/cim/downloads/DownloadFile;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v4

    invoke-direct {p0, v2, v4, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    goto :goto_0
.end method

.method public bridge synthetic onFileProgressUpdated(Lcom/comcast/cim/downloads/DownloadFile;)V
    .locals 0

    .prologue
    .line 80
    check-cast p1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    return-void
.end method

.method public onFileProgressUpdated(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 4
    .param p1, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 152
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->resourcesLoaded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 153
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getVideoItemViewContainer()Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->showDownloadProgressState(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;Landroid/view/View;Z)V

    .line 155
    :cond_0
    return-void
.end method

.method public onInflate(Landroid/app/Activity;Landroid/util/AttributeSet;Landroid/os/Bundle;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 429
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onInflate(Landroid/app/Activity;Landroid/util/AttributeSet;Landroid/os/Bundle;)V

    .line 431
    sget-object v1, Lcom/xfinity/playerlib/R$styleable;->com_xfinity_playerlib_view_programdetails_DetailFragment:[I

    invoke-virtual {p1, p2, v1}, Landroid/app/Activity;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 432
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v1, Lcom/xfinity/playerlib/R$styleable;->com_xfinity_playerlib_view_programdetails_DetailFragment_isFullScreen:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->isFullScreen:Z

    .line 433
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 434
    return-void
.end method

.method protected onLoadingFailed()V
    .locals 1

    .prologue
    .line 545
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 546
    return-void
.end method

.method protected onLoadingFailed(I)V
    .locals 1
    .param p1, "messageResId"    # I

    .prologue
    .line 541
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed(I)V

    .line 542
    return-void
.end method

.method protected onLoadingFinished()V
    .locals 2

    .prologue
    .line 549
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFinished()V

    .line 550
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 551
    return-void
.end method

.method public onStartInternal()V
    .locals 1

    .prologue
    .line 438
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStartInternal()V

    .line 439
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStart()V

    .line 441
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getVideoItemViewContainer()Landroid/view/ViewGroup;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 442
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v0, p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->addDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 444
    :cond_0
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 448
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStop()V

    .line 449
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStop()V

    .line 450
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v0, p0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->removeDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 451
    return-void
.end method

.method public onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 537
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onViewCreated(Landroid/view/View;Landroid/os/Bundle;)V

    .line 538
    return-void
.end method

.method protected presentReviews(Ljava/util/List;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalReview;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "reviews":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalReview;>;"
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 1129
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;

    .line 1130
    .local v2, "review":Lcom/xfinity/playerlib/model/consumable/hal/HalReview;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->isRottenTomatoes()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 1131
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->getRottenTomatoesCriticScore()I

    move-result v0

    .line 1132
    .local v0, "criticScore":I
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->getRottenTomatoesFanScore()I

    move-result v1

    .line 1134
    .local v1, "fanScore":I
    if-ltz v0, :cond_1

    .line 1135
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesCriticScore:Landroid/widget/TextView;

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1136
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesCriticScore:Landroid/widget/TextView;

    sget v6, Lcom/xfinity/playerlib/R$string;->rotten_tomatoes_score:I

    new-array v7, v10, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-virtual {p0, v6, v7}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1138
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesCriticIcon:Landroid/widget/ImageView;

    invoke-virtual {v4, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1139
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesCriticIcon:Landroid/widget/ImageView;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->isRottenTomatoesCriticFresh()Z

    move-result v4

    if-eqz v4, :cond_2

    sget v4, Lcom/xfinity/playerlib/R$drawable;->icn_rt_tomato_fresh:I

    :goto_1
    invoke-virtual {v6, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 1142
    :cond_1
    if-ltz v1, :cond_0

    .line 1143
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesFanScore:Landroid/widget/TextView;

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1144
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesFanScore:Landroid/widget/TextView;

    sget v6, Lcom/xfinity/playerlib/R$string;->rotten_tomatoes_score:I

    new-array v7, v10, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-virtual {p0, v6, v7}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1146
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesFanIcon:Landroid/widget/ImageView;

    invoke-virtual {v4, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 1147
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesFanIcon:Landroid/widget/ImageView;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->isRottenTomatoesFanFresh()Z

    move-result v4

    if-eqz v4, :cond_3

    sget v4, Lcom/xfinity/playerlib/R$drawable;->icn_rt_popcorn_full:I

    :goto_2
    invoke-virtual {v6, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 1139
    :cond_2
    sget v4, Lcom/xfinity/playerlib/R$drawable;->icn_rt_tomato_rotten:I

    goto :goto_1

    .line 1147
    :cond_3
    sget v4, Lcom/xfinity/playerlib/R$drawable;->icn_rt_popcorn_spilled:I

    goto :goto_2

    .line 1149
    .end local v0    # "criticScore":I
    .end local v1    # "fanScore":I
    :cond_4
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->isCommonSenseMedia()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 1150
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalReview;->getCommonSenseMediaTargetAge()I

    move-result v3

    .line 1151
    .local v3, "targetAge":I
    if-lez v3, :cond_0

    .line 1152
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->commonSenseMediaLabel:Landroid/widget/TextView;

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1154
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->commonSenseMediaTargetRating:Landroid/widget/TextView;

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1155
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->commonSenseMediaTargetRating:Landroid/widget/TextView;

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 1159
    .end local v2    # "review":Lcom/xfinity/playerlib/model/consumable/hal/HalReview;
    .end local v3    # "targetAge":I
    :cond_5
    return-void
.end method

.method public setAnimationEnabled(Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "animationsEnabled"    # Ljava/lang/Boolean;

    .prologue
    .line 1110
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->animationsEnabled:Z

    .line 1111
    return-void
.end method

.method protected setDisplayTitle(Ljava/lang/String;Landroid/widget/TextView;)V
    .locals 3
    .param p1, "displayTitle"    # Ljava/lang/String;
    .param p2, "inlineDisplayTitle"    # Landroid/widget/TextView;

    .prologue
    .line 570
    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->isFullScreen:Z

    if-eqz v1, :cond_1

    .line 573
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 574
    .local v0, "activity":Landroid/app/Activity;
    if-eqz v0, :cond_0

    .line 575
    invoke-virtual {v0, p1}, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V

    .line 577
    :cond_0
    const/16 v1, 0x8

    invoke-virtual {p2, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 585
    .end local v0    # "activity":Landroid/app/Activity;
    :goto_0
    return-void

    .line 580
    :cond_1
    invoke-virtual {p2, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 581
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 582
    const/4 v1, 0x0

    invoke-virtual {p2, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method protected setupReviews(Landroid/view/View;)V
    .locals 1
    .param p1, "layout"    # Landroid/view/View;

    .prologue
    .line 1119
    sget v0, Lcom/xfinity/playerlib/R$id;->rotten_tomatoes_critic_score:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesCriticScore:Landroid/widget/TextView;

    .line 1120
    sget v0, Lcom/xfinity/playerlib/R$id;->rotten_tomatoes_fan_score:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesFanScore:Landroid/widget/TextView;

    .line 1121
    sget v0, Lcom/xfinity/playerlib/R$id;->rotten_tomatoes_critic_score_icon:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesCriticIcon:Landroid/widget/ImageView;

    .line 1122
    sget v0, Lcom/xfinity/playerlib/R$id;->rotten_tomatoes_fan_score_icon:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->rottenTomatoesFanIcon:Landroid/widget/ImageView;

    .line 1123
    sget v0, Lcom/xfinity/playerlib/R$id;->common_sense_media_rating:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->commonSenseMediaTargetRating:Landroid/widget/TextView;

    .line 1124
    sget v0, Lcom/xfinity/playerlib/R$id;->common_sense_media_age:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->commonSenseMediaLabel:Landroid/widget/TextView;

    .line 1125
    return-void
.end method

.method public showDuration(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 3
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 1068
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getView()Landroid/view/View;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->duration:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 1070
    .local v0, "duration":Landroid/widget/TextView;
    if-eqz v0, :cond_1

    .line 1071
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v1

    if-nez v1, :cond_2

    .line 1072
    :cond_0
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1079
    :cond_1
    :goto_0
    return-void

    .line 1074
    :cond_2
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1075
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v2

    invoke-static {v1, v2}, Lcom/comcast/cim/utils/UIPresentationUtil;->getDuration(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1076
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v2

    invoke-static {v1, v2}, Lcom/comcast/cim/utils/UIPresentationUtil;->getDurationSpoken(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method

.method abstract showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V
.end method

.method protected varargs updateCompoundTextView(Landroid/widget/TextView;[Ljava/lang/Object;)V
    .locals 7
    .param p1, "textView"    # Landroid/widget/TextView;
    .param p2, "items"    # [Ljava/lang/Object;

    .prologue
    const/4 v4, 0x0

    .line 589
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 591
    .local v0, "compoundText":Ljava/lang/StringBuilder;
    array-length v5, p2

    move v3, v4

    :goto_0
    if-ge v3, v5, :cond_2

    aget-object v1, p2, v3

    .line 592
    .local v1, "item":Ljava/lang/Object;
    if-eqz v1, :cond_1

    .line 593
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v6

    if-lez v6, :cond_0

    .line 594
    const-string v6, " | "

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 596
    :cond_0
    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 591
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 599
    .end local v1    # "item":Ljava/lang/Object;
    :cond_2
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_3

    .line 600
    invoke-virtual {p1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 601
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 606
    :goto_1
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 607
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_season:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 608
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->content_description_episode:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 606
    invoke-static {v3, v4, v5}, Lcom/comcast/cim/utils/UIPresentationUtil;->getSeriesStringSpoken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 610
    .local v2, "seriesString":Ljava/lang/String;
    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 611
    return-void

    .line 603
    .end local v2    # "seriesString":Ljava/lang/String;
    :cond_3
    const/16 v3, 0x8

    invoke-virtual {p1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method protected updateVideoSize(Landroid/widget/TextView;Landroid/widget/TextView;Ljava/lang/Integer;Ljava/lang/String;)V
    .locals 5
    .param p1, "videoSize"    # Landroid/widget/TextView;
    .param p2, "d2goStatus"    # Landroid/widget/TextView;
    .param p3, "megaBytes"    # Ljava/lang/Integer;
    .param p4, "s2goStatusCaption"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1085
    if-nez p3, :cond_0

    .line 1086
    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_add_pause:I

    new-array v2, v4, [Ljava/lang/Object;

    aput-object p4, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 1091
    .local v0, "speak":Ljava/lang/String;
    :goto_0
    invoke-virtual {p1, v3}, Landroid/widget/TextView;->setFocusable(Z)V

    .line 1092
    if-eqz p3, :cond_1

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " MB"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_1
    invoke-virtual {p1, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1093
    const/4 v1, 0x0

    invoke-virtual {p1, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1095
    invoke-virtual {p2, v4}, Landroid/widget/TextView;->setFocusable(Z)V

    .line 1096
    invoke-virtual {p2, p4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1097
    invoke-virtual {p2, v0}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 1098
    return-void

    .line 1088
    .end local v0    # "speak":Ljava/lang/String;
    :cond_0
    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_avail_for_download:I

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p4, v2, v3

    aput-object p3, v2, v4

    invoke-virtual {p0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "speak":Ljava/lang/String;
    goto :goto_0

    .line 1092
    :cond_1
    const-string v1, ""

    goto :goto_1
.end method
