.class final Lcom/adobe/mediacore/VideoEngineDispatcher;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/VideoEngineDispatcher$1;
    }
.end annotation


# instance fields
.field private final _adBreakManifestLoadCompleteListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _adBreakPlacementCompletedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _adBreakPlacementFailedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/AdBreakPlacementFailedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _adBreakRemovalCompletedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/AdBreakRemovalCompletedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _adManifestLoadCompleteListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/AdManifestLoadCompleteListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _adManifestLoadFailedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/AdManifestLoadFailedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _adPlaybackEventListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _audioTrackFailedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/AudioTrackFailedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _blackoutsEventListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/MediaPlayer$BlackoutsEventListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _bufferingCompletedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/BufferingCompletedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _bufferingFullListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/BufferingFullListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _bufferingStartedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/BufferingStartedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _clickListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ViewClickListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _contentChangedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ContentChangedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _contentMarkerListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ContentMarkerListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _contentPlacementCompleteListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ContentPlacementCompletedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _drmEventListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _drmMetadataListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/DRMMetadataListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _errorListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/VideoErrorListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _itemCreatedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ItemCreatedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _itemReadyListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ItemReadyListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _itemUpdatedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ItemUpdatedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _loadInfoListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/LoadInfoListener;",
            ">;"
        }
    .end annotation
.end field

.field private _notificationHistory:Lcom/adobe/mediacore/session/NotificationHistory;

.field private final _opportunityFailedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/OpportunityHandledListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _opportunityHandledListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/OpportunityHandledListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _playbackEventListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _profileChangedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ProfileChangedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _qosEventListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _resourceLoadedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/ResourceLoadedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _seekAdjustCompletedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/SeekAdjustCompletedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _seekCompletedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/SeekCompletedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _seekStartedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/SeekStartedListener;",
            ">;"
        }
    .end annotation
.end field

.field private final _stateChangedListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/VideoStateChangedListener;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_resourceLoadedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemCreatedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemUpdatedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemReadyListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadCompleteListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadFailedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakManifestLoadCompleteListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementCompletedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementFailedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakRemovalCompletedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentPlacementCompleteListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentChangedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentMarkerListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_profileChangedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekStartedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekCompletedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekAdjustCompletedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingStartedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingCompletedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingFullListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_audioTrackFailedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_loadInfoListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmMetadataListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_stateChangedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_errorListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_clickListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityFailedListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityHandledListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_blackoutsEventListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmEventListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V
    .locals 3

    sget-object v0, Lcom/adobe/mediacore/VideoEngineDispatcher$1;->$SwitchMap$com$adobe$mediacore$MediaPlayer$Event:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayer$Event;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unsupported event type.["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :goto_0
    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_4
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_blackoutsEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$BlackoutsEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V
    .locals 3

    sget-object v0, Lcom/adobe/mediacore/VideoEngineDispatcher$1;->$SwitchMap$com$adobe$mediacore$MediaPlayerEvent$Type:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unsupported event type.["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_resourceLoadedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ResourceLoadedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :goto_0
    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemCreatedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ItemCreatedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemUpdatedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ItemUpdatedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemReadyListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ItemReadyListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_4
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_5
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementFailedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_6
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakRemovalCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdBreakRemovalCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_7
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentPlacementCompleteListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ContentPlacementCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_8
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadCompleteListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdManifestLoadCompleteListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_9
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadFailedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdManifestLoadFailedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_a
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakManifestLoadCompleteListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_b
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentChangedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ContentChangedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_c
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentMarkerListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ContentMarkerListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_d
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_profileChangedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ProfileChangedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_e
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekStartedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/SeekStartedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_f
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/SeekCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_10
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekAdjustCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_11
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingStartedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/BufferingStartedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_12
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/BufferingCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_13
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingFullListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/BufferingFullListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_14
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_audioTrackFailedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AudioTrackFailedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_15
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_loadInfoListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/LoadInfoListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_16
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmMetadataListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/DRMMetadataListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_17
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_stateChangedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/VideoStateChangedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_18
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_errorListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/VideoErrorListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_19
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_clickListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ViewClickListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_1a
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityHandledListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/OpportunityHandledListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_1b
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityFailedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/OpportunityHandledListener;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_17
        :pswitch_18
        :pswitch_19
        :pswitch_1a
        :pswitch_1b
    .end packed-switch
.end method

.method public clear()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_resourceLoadedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemCreatedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemUpdatedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemReadyListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementFailedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentPlacementCompleteListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadCompleteListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadFailedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakManifestLoadCompleteListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentChangedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentMarkerListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_profileChangedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekStartedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekAdjustCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingStartedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingFullListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_loadInfoListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmMetadataListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_stateChangedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_errorListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_audioTrackFailedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_clickListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityHandledListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityFailedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakRemovalCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_blackoutsEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    return-void
.end method

.method public createNotificationHistory()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_notificationHistory:Lcom/adobe/mediacore/session/NotificationHistory;

    if-nez v0, :cond_0

    new-instance v0, Lcom/adobe/mediacore/session/NotificationHistory;

    invoke-direct {v0}, Lcom/adobe/mediacore/session/NotificationHistory;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_notificationHistory:Lcom/adobe/mediacore/session/NotificationHistory;

    :cond_0
    return-void
.end method

.method public destroyNotificationHistory()V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_notificationHistory:Lcom/adobe/mediacore/session/NotificationHistory;

    return-void
.end method

.method public dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V
    .locals 6

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_notificationHistory:Lcom/adobe/mediacore/session/NotificationHistory;

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerEvent;->getNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_notificationHistory:Lcom/adobe/mediacore/session/NotificationHistory;

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/session/NotificationHistory;->addNotification(Lcom/adobe/mediacore/MediaPlayerNotification;)V

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/VideoEngineDispatcher$1;->$SwitchMap$com$adobe$mediacore$MediaPlayerEvent$Type:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerEvent;->getType()Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unsupported event type.["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerEvent;->getType()Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_resourceLoadedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ResourceLoadedListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/ResourceLoadedListener;->onLoaded()V

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemCreatedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ItemCreatedListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/ItemCreatedListener;->onCreated()V

    goto :goto_1

    :pswitch_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemUpdatedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ItemUpdatedListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/ItemUpdatedListener;->onUpdated()V

    goto :goto_2

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onReplaceMediaPlayerItem()V

    goto :goto_3

    :pswitch_4
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemReadyListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ItemReadyListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/ItemReadyListener;->onReady()V

    goto :goto_4

    :pswitch_5
    check-cast p1, Lcom/adobe/mediacore/AdBreakPlacementEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_5
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdBreakPlacementEvent;->getProposedAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdBreakPlacementEvent;->getAcceptedAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;->onCompleted(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V

    goto :goto_5

    :pswitch_6
    check-cast p1, Lcom/adobe/mediacore/AdBreakPlacementEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementFailedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_6
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdBreakPlacementEvent;->getProposedAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/AdBreakPlacementFailedListener;->onFailed(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V

    goto :goto_6

    :pswitch_7
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakRemovalCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_7
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/AdBreakRemovalCompletedListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/AdBreakRemovalCompletedListener;->onCompleted()V

    goto :goto_7

    :pswitch_8
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentPlacementCompleteListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_8
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ContentPlacementCompletedListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/ContentPlacementCompletedListener;->onCompleted()V

    goto :goto_8

    :pswitch_9
    check-cast p1, Lcom/adobe/mediacore/AdManifestLoadEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadCompleteListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_9
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/AdManifestLoadCompleteListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdManifestLoadEvent;->getContentId()I

    move-result v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdManifestLoadEvent;->getHandle()I

    move-result v3

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdManifestLoadEvent;->getDuration()J

    move-result-wide v4

    invoke-interface {v0, v2, v3, v4, v5}, Lcom/adobe/mediacore/AdManifestLoadCompleteListener;->onCompleted(IIJ)V

    goto :goto_9

    :pswitch_a
    check-cast p1, Lcom/adobe/mediacore/AdManifestLoadEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadFailedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/AdManifestLoadFailedListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdManifestLoadEvent;->getContentId()I

    move-result v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/AdManifestLoadFailedListener;->onError(I)V

    goto :goto_a

    :pswitch_b
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakManifestLoadCompleteListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;->onComplete()V

    goto :goto_b

    :pswitch_c
    check-cast p1, Lcom/adobe/mediacore/ContentChangedEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentChangedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_c
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ContentChangedListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/ContentChangedEvent;->getContentId()I

    move-result v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/ContentChangedEvent;->getPosition()J

    move-result-wide v4

    invoke-interface {v0, v2, v4, v5}, Lcom/adobe/mediacore/ContentChangedListener;->onChanged(IJ)V

    goto :goto_c

    :pswitch_d
    check-cast p1, Lcom/adobe/mediacore/ContentMarkerEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentMarkerListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_d
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ContentMarkerListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/ContentMarkerEvent;->getContentId()I

    move-result v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/ContentMarkerEvent;->getPosition()J

    move-result-wide v4

    invoke-interface {v0, v2, v4, v5}, Lcom/adobe/mediacore/ContentMarkerListener;->onContentMarker(IJ)V

    goto :goto_d

    :pswitch_e
    check-cast p1, Lcom/adobe/mediacore/ProfileChangedEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_profileChangedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_e
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ProfileChangedListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/ProfileChangedEvent;->getProfile()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/ProfileChangedEvent;->getPosition()J

    move-result-wide v4

    invoke-interface {v0, v2, v3, v4, v5}, Lcom/adobe/mediacore/ProfileChangedListener;->onChanged(JJ)V

    goto :goto_e

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_f
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/ProfileChangedEvent;->getProfile()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/ProfileChangedEvent;->getPosition()J

    move-result-wide v4

    invoke-interface {v0, v2, v3, v4, v5}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onProfileChanged(JJ)V

    goto :goto_f

    :pswitch_f
    check-cast p1, Lcom/adobe/mediacore/SeekEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekStartedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_10
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/SeekStartedListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/SeekEvent;->getPosition()J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/SeekStartedListener;->onStarted(J)V

    goto :goto_10

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_11
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;->onSeekStart()V

    goto :goto_11

    :pswitch_10
    check-cast p1, Lcom/adobe/mediacore/SeekEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_12
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/SeekCompletedListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/SeekEvent;->getPosition()J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/SeekCompletedListener;->onCompleted(J)V

    goto :goto_12

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_13
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/SeekEvent;->getPosition()J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;->onSeekComplete(J)V

    goto :goto_13

    :pswitch_11
    check-cast p1, Lcom/adobe/mediacore/SeekEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekAdjustCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_14
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/SeekEvent;->getPosition()J

    move-result-wide v2

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/SeekAdjustCompletedListener;->onAdjustCompleted(J)V

    goto :goto_14

    :pswitch_12
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingStartedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_15
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/BufferingStartedListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/BufferingStartedListener;->onStarted()V

    goto :goto_15

    :cond_4
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_16
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;->onBufferStart()V

    goto :goto_16

    :pswitch_13
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingCompletedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_17
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/BufferingCompletedListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/BufferingCompletedListener;->onCompleted()V

    goto :goto_17

    :cond_5
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_18
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;->onBufferComplete()V

    goto :goto_18

    :pswitch_14
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingFullListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_19
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/BufferingFullListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/BufferingFullListener;->onFull()V

    goto :goto_19

    :pswitch_15
    move-object v0, p1

    check-cast v0, Lcom/adobe/mediacore/AudioTrackEvent;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_audioTrackFailedListeners:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1a
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_8

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/AudioTrackFailedListener;

    invoke-virtual {v0}, Lcom/adobe/mediacore/AudioTrackEvent;->getAudioTrack()Lcom/adobe/mediacore/info/AudioTrack;

    move-result-object v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerEvent;->getNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v2

    check-cast v2, Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    invoke-interface {v1, v4, v2}, Lcom/adobe/mediacore/AudioTrackFailedListener;->onFailed(Lcom/adobe/mediacore/info/AudioTrack;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    goto :goto_1a

    :pswitch_16
    check-cast p1, Lcom/adobe/mediacore/LoadInfoEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_loadInfoListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/LoadInfoListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/LoadInfoEvent;->getLoadInfo()Lcom/adobe/mediacore/qos/LoadInfo;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/LoadInfoListener;->onInfo(Lcom/adobe/mediacore/qos/LoadInfo;)V

    goto :goto_1b

    :cond_6
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1c
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/LoadInfoEvent;->getLoadInfo()Lcom/adobe/mediacore/qos/LoadInfo;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;->onLoadInfo(Lcom/adobe/mediacore/qos/LoadInfo;)V

    goto :goto_1c

    :pswitch_17
    check-cast p1, Lcom/adobe/mediacore/DRMMetadataEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmMetadataListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1d
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/DRMMetadataListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataEvent;->getDrmMetadataInfo()Lcom/adobe/mediacore/DRMMetadataInfo;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/DRMMetadataListener;->onDRMMetadata(Lcom/adobe/mediacore/DRMMetadataInfo;)V

    goto :goto_1d

    :cond_7
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1e
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/DRMMetadataEvent;->getDrmMetadataInfo()Lcom/adobe/mediacore/DRMMetadataInfo;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;->onDRMMetadata(Lcom/adobe/mediacore/DRMMetadataInfo;)V

    goto :goto_1e

    :pswitch_18
    check-cast p1, Lcom/adobe/mediacore/ErrorEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_errorListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1f
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/VideoErrorListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/ErrorEvent;->getNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/VideoErrorListener;->onError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    goto :goto_1f

    :pswitch_19
    check-cast p1, Lcom/adobe/mediacore/OperationFailedEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_20
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/OperationFailedEvent;->getNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;->onOperationFailed(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V

    goto :goto_20

    :pswitch_1a
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_21
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onPrepared()V

    goto :goto_21

    :pswitch_1b
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_22
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onUpdated()V

    goto :goto_22

    :pswitch_1c
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_23
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onTimelineUpdated()V

    goto :goto_23

    :pswitch_1d
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_24
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onPlayStart()V

    goto :goto_24

    :pswitch_1e
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_25
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onPlayComplete()V

    goto :goto_25

    :pswitch_1f
    check-cast p1, Lcom/adobe/mediacore/StateChangedEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_26
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/StateChangedEvent;->getCurrentState()Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/StateChangedEvent;->getNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onStateChanged(Lcom/adobe/mediacore/MediaPlayer$PlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)V

    goto :goto_26

    :pswitch_20
    check-cast p1, Lcom/adobe/mediacore/VideoStateChangedEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_stateChangedListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_27
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/VideoStateChangedListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoStateChangedEvent;->getPlayerState()Lcom/adobe/mediacore/MediaPlayerState;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoStateChangedEvent;->getNotification()Lcom/adobe/mediacore/MediaPlayerNotification;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/VideoStateChangedListener;->onStateChanged(Lcom/adobe/mediacore/MediaPlayerState;Lcom/adobe/mediacore/MediaPlayerNotification;)V

    goto :goto_27

    :pswitch_21
    check-cast p1, Lcom/adobe/mediacore/VideoSizeChangedEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_28
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoSizeChangedEvent;->getHeight()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoSizeChangedEvent;->getWidth()I

    move-result v4

    int-to-long v4, v4

    invoke-interface {v0, v2, v3, v4, v5}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onSizeAvailable(JJ)V

    goto :goto_28

    :pswitch_22
    check-cast p1, Lcom/adobe/mediacore/TimedMetadataAddedEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_29
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->getTimedMetadata()Lcom/adobe/mediacore/metadata/TimedMetadata;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onTimedMetadata(Lcom/adobe/mediacore/metadata/TimedMetadata;)V

    goto :goto_29

    :pswitch_23
    check-cast p1, Lcom/adobe/mediacore/TimedMetadataAddedEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_blackoutsEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2a
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$BlackoutsEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/TimedMetadataAddedEvent;->getTimedMetadata()Lcom/adobe/mediacore/metadata/TimedMetadata;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/MediaPlayer$BlackoutsEventListener;->onTimedMetadataInBackgroundItem(Lcom/adobe/mediacore/metadata/TimedMetadata;)V

    goto :goto_2a

    :pswitch_24
    check-cast p1, Lcom/adobe/mediacore/AdBreakPlaybackEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2b
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;->onAdBreakStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    goto :goto_2b

    :pswitch_25
    check-cast p1, Lcom/adobe/mediacore/AdBreakPlaybackEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2c
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;->onAdBreakComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    goto :goto_2c

    :pswitch_26
    check-cast p1, Lcom/adobe/mediacore/AdBreakPlaybackEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2d
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;->onAdBreakSkipped(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    goto :goto_2d

    :pswitch_27
    check-cast p1, Lcom/adobe/mediacore/AdPlaybackEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2e
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdPlaybackEvent;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdPlaybackEvent;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;->onAdStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V

    goto :goto_2e

    :pswitch_28
    check-cast p1, Lcom/adobe/mediacore/AdPlaybackEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2f
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdPlaybackEvent;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdPlaybackEvent;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdPlaybackEvent;->getProgress()I

    move-result v4

    invoke-interface {v0, v2, v3, v4}, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;->onAdProgress(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)V

    goto :goto_2f

    :pswitch_29
    check-cast p1, Lcom/adobe/mediacore/AdPlaybackEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_30
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdPlaybackEvent;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdPlaybackEvent;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;->onAdComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V

    goto :goto_30

    :pswitch_2a
    check-cast p1, Lcom/adobe/mediacore/AdClickEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_31
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdClickEvent;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdClickEvent;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdClickEvent;->getAdClick()Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v4

    invoke-interface {v0, v2, v3, v4}, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;->onAdClick(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;Lcom/adobe/mediacore/timeline/advertising/AdClick;)V

    goto :goto_31

    :pswitch_2b
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_clickListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_32
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/ViewClickListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/ViewClickListener;->onClick()V

    goto :goto_32

    :pswitch_2c
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityHandledListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_33
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/OpportunityHandledListener;

    move-object v1, p1

    check-cast v1, Lcom/adobe/mediacore/OpportunityHandledEvent;

    invoke-virtual {v1}, Lcom/adobe/mediacore/OpportunityHandledEvent;->getTime()J

    move-result-wide v4

    invoke-interface {v0, v4, v5}, Lcom/adobe/mediacore/OpportunityHandledListener;->onOpportunityHandled(J)V

    goto :goto_33

    :pswitch_2d
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityHandledListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_34
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/OpportunityHandledListener;

    move-object v1, p1

    check-cast v1, Lcom/adobe/mediacore/OpportunityHandledEvent;

    invoke-virtual {v1}, Lcom/adobe/mediacore/OpportunityHandledEvent;->getTime()J

    move-result-wide v4

    invoke-interface {v0, v4, v5}, Lcom/adobe/mediacore/OpportunityHandledListener;->onOpportunityHandled(J)V

    goto :goto_34

    :pswitch_2e
    check-cast p1, Lcom/adobe/mediacore/PlaybackRateEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_35
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/PlaybackRateEvent;->getRate()F

    move-result v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onRateSelected(F)V

    goto :goto_35

    :pswitch_2f
    check-cast p1, Lcom/adobe/mediacore/PlaybackRateEvent;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_36
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-virtual {p1}, Lcom/adobe/mediacore/PlaybackRateEvent;->getRate()F

    move-result v2

    invoke-interface {v0, v2}, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;->onRatePlaying(F)V

    goto :goto_36

    :pswitch_30
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_blackoutsEventListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_37
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$BlackoutsEventListener;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayer$BlackoutsEventListener;->onBackgroundManifestFailed()V

    goto :goto_37

    :cond_8
    return-void

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_17
        :pswitch_20
        :pswitch_18
        :pswitch_2b
        :pswitch_2c
        :pswitch_2d
        :pswitch_3
        :pswitch_19
        :pswitch_1a
        :pswitch_1b
        :pswitch_1c
        :pswitch_1d
        :pswitch_1e
        :pswitch_1f
        :pswitch_21
        :pswitch_22
        :pswitch_23
        :pswitch_24
        :pswitch_25
        :pswitch_26
        :pswitch_27
        :pswitch_28
        :pswitch_29
        :pswitch_2a
        :pswitch_2e
        :pswitch_2f
        :pswitch_30
    .end packed-switch
.end method

.method public getNotificationHistory()Lcom/adobe/mediacore/session/NotificationHistory;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_notificationHistory:Lcom/adobe/mediacore/session/NotificationHistory;

    return-object v0
.end method

.method public removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/VideoEngineDispatcher$1;->$SwitchMap$com$adobe$mediacore$MediaPlayer$Event:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayer$Event;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    :goto_0
    return-void

    :pswitch_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_qosEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$QOSEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$DRMEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adPlaybackEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$PlaybackEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_4
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_playbackEventListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/MediaPlayer$BlackoutsEventListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V
    .locals 3

    sget-object v0, Lcom/adobe/mediacore/VideoEngineDispatcher$1;->$SwitchMap$com$adobe$mediacore$MediaPlayerEvent$Type:[I

    invoke-virtual {p1}, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unsupported event type.["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_resourceLoadedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ResourceLoadedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    :goto_0
    return-void

    :pswitch_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemCreatedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ItemCreatedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemUpdatedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ItemUpdatedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_itemReadyListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ItemReadyListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_4
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_5
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakPlacementFailedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_6
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakRemovalCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdBreakRemovalCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_7
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentPlacementCompleteListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ContentPlacementCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_8
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadCompleteListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdManifestLoadCompleteListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_9
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adManifestLoadFailedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdManifestLoadFailedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_a
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_adBreakManifestLoadCompleteListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_b
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentChangedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ContentChangedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_c
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_contentMarkerListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ContentMarkerListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_d
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_profileChangedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ProfileChangedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_e
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekStartedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/SeekStartedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_f
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/SeekCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_10
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_seekAdjustCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/SeekAdjustCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    :pswitch_11
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingStartedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/BufferingStartedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_12
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingCompletedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/BufferingCompletedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_13
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_bufferingFullListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/BufferingFullListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_14
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_audioTrackFailedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/AudioTrackFailedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_15
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_loadInfoListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/LoadInfoListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_16
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_drmMetadataListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/DRMMetadataListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_17
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_stateChangedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/VideoStateChangedListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_18
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_errorListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/VideoErrorListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_19
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_clickListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/ViewClickListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_1a
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityHandledListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/OpportunityHandledListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :pswitch_1b
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineDispatcher;->_opportunityFailedListeners:Ljava/util/List;

    check-cast p2, Lcom/adobe/mediacore/OpportunityHandledListener;

    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto/16 :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_d
        :pswitch_e
        :pswitch_f
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_13
        :pswitch_14
        :pswitch_15
        :pswitch_16
        :pswitch_17
        :pswitch_18
        :pswitch_19
        :pswitch_1a
        :pswitch_1b
    .end packed-switch
.end method
