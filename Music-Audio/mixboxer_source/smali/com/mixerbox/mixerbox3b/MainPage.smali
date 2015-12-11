.class public Lcom/mixerbox/mixerbox3b/MainPage;
.super Lcom/actionbarsherlock/app/SherlockFragmentActivity;
.source "SourceFile"


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "NewApi"
    }
.end annotation


# static fields
.field private static final Msg_What_Page_reload:I = 0x2

.field private static final Msg_What_Timer_finish:I = 0x1

.field static PLAYER_REPEAT:I = 0x0

.field static PLAYER_SHUFFLE:Z = false

.field private static final REAUTH_ACTIVITY_CODE:I = 0x64

.field static bundle:Landroid/os/Bundle;

.field static defaultPortrait:Z

.field static isPageLoaded:Z

.field static playerType:I

.field public static stackCurrentFragmentId:Ljava/util/Stack;


# instance fields
.field public DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

.field JS_Player_H:I

.field JS_Player_H_F:I

.field JS_Player_W:I

.field JS_Player_W_F:I

.field PERMISSIONS:Ljava/util/List;

.field SCREEN_STATE:I

.field final SOME_ACTION:Ljava/lang/String;

.field adView:Lcom/google/android/gms/ads/AdView;

.field afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

.field am:Landroid/media/AudioManager;

.field public arrayDJs:Ljava/util/List;

.field public arrayLocalNotificationList:Ljava/util/ArrayList;

.field public arrayMP3:Ljava/util/ArrayList;

.field public arrayMyPlaylists:Ljava/util/ArrayList;

.field public arrayMySubsPlaylists:Ljava/util/ArrayList;

.field public arrayNewsfeed:Ljava/util/List;

.field public arrayPlayingSong:Ljava/util/ArrayList;

.field public arraySong:Ljava/util/ArrayList;

.field public arraySystemList:Ljava/util/List;

.field binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

.field btnAdd:Landroid/widget/ImageButton;

.field btnDJs:Landroid/widget/RelativeLayout;

.field btnDiscover:Landroid/widget/RelativeLayout;

.field btnExpand:Landroid/widget/ImageButton;

.field btnFullScreen:Landroid/widget/ImageButton;

.field btnNewsfeed:Landroid/widget/RelativeLayout;

.field btnPlay:Landroid/widget/ImageButton;

.field btnPlaylists:Landroid/widget/RelativeLayout;

.field btnQuality:Landroid/widget/ImageButton;

.field btnSettings:Landroid/widget/RelativeLayout;

.field btnShare:Landroid/widget/ImageButton;

.field private callback:Lcom/facebook/Session$StatusCallback;

.field public canPlay:Z

.field public canSetLocalNotification:Z

.field canUpdateSeekbar:Z

.field private conn:Landroid/content/ServiceConnection;

.field curOri:I

.field public currentFragment:I

.field currentTime:I

.field public dialogDevice:Landroid/app/Dialog;

.field earphoneReceiver:Lcom/mixerbox/mixerbox3b/services/EarphoneReceiver;

.field errorCount:I

.field public fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

.field fragmentDiscover:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

.field fragmentManager:Landroid/support/v4/app/FragmentManager;

.field fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

.field public fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

.field public fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

.field public fragmentSignUp:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

.field public guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

.field final handler:Landroid/os/Handler;

.field public hasSetCanAuto:Z

.field hasSetLocalNotification:Z

.field isBackground:Z

.field isForeground:Z

.field public isLogIn:Z

.field isReady:Z

.field ivSoundCloud:Landroid/widget/ImageView;

.field ivWebViewCover:Landroid/widget/ImageView;

.field llBottomtab:Landroid/widget/LinearLayout;

.field private mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

.field mPhoneStateListener:Landroid/telephony/PhoneStateListener;

.field mReceiver:Lcom/mixerbox/mixerbox3b/services/PlayerReceiver;

.field mSherlock:Lcom/actionbarsherlock/ActionBarSherlock;

.field public menu:Lcom/actionbarsherlock/view/Menu;

.field messenger:Landroid/os/Messenger;

.field public myPlaylists:Ljava/util/ArrayList;

.field private myReceiver:Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;

.field public mySubscriptions:Ljava/util/ArrayList;

.field name:Ljava/util/ArrayList;

.field public nm:Landroid/app/NotificationManager;

.field oriVideoId:Ljava/lang/String;

.field playerHeight:I

.field public playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

.field public playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

.field public playingSongIndex:I

.field preOri:I

.field r:Lcom/mixerbox/mixerbox3b/services/MyReceiver;

.field private rCheckHistory:Ljava/lang/Runnable;

.field rLocalNotificationList:Ljava/lang/Runnable;

.field rSendInitInfo:Ljava/lang/Runnable;

.field resetTime:I

.field rlHint:Landroid/widget/RelativeLayout;

.field rlPanelBottom:Landroid/widget/RelativeLayout;

.field rlPanelPopup:Landroid/widget/LinearLayout;

.field rlPanelTop:Landroid/widget/RelativeLayout;

.field public rlVideoPlayer:Landroid/widget/RelativeLayout;

.field seekbar:Landroid/widget/SeekBar;

.field shouldChangeBackToWebView:Z

.field shouldCheckNotificationBtn:Z

.field public shouldCloseApp:Z

.field public shouldLogin:Z

.field shouldPlay:I

.field public shouldPlayAfterReady:Z

.field shouldResetTime:Z

.field public shouldSendNoti:Z

.field shuffleCount:I

.field shuffleIndexArray:[I

.field sr:Lcom/mixerbox/mixerbox3b/services/SleepReceiver;

.field public stack:Ljava/util/Stack;

.field public tvNoInternet:Landroid/widget/TextView;

.field tvNoNet:Landroid/widget/TextView;

.field tvSwitch:Landroid/widget/TextView;

.field tvTimeStart:Landroid/widget/TextView;

.field private uiHelper:Lcom/facebook/UiLifecycleHelper;

.field public videoState:I

.field public wv:Landroid/webkit/WebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 215
    const/4 v0, 0x0

    sput v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    return-void
.end method

.method public constructor <init>()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 184
    invoke-direct {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;-><init>()V

    .line 257
    const-string v0, "PlayerBroadcastReceiver"

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->SOME_ACTION:Ljava/lang/String;

    .line 271
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->errorCount:I

    .line 273
    invoke-static {p0}, Lcom/actionbarsherlock/ActionBarSherlock;->wrap(Landroid/app/Activity;)Lcom/actionbarsherlock/ActionBarSherlock;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mSherlock:Lcom/actionbarsherlock/ActionBarSherlock;

    .line 276
    iput-object v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    .line 283
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetLocalNotification:Z

    .line 284
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canSetLocalNotification:Z

    .line 285
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isBackground:Z

    .line 294
    new-array v0, v3, [Ljava/lang/String;

    const-string v1, "publish_actions"

    aput-object v1, v0, v2

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->PERMISSIONS:Ljava/util/List;

    .line 296
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$1;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$1;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->callback:Lcom/facebook/Session$StatusCallback;

    .line 1230
    iput-object v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    .line 1231
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$14;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$14;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->conn:Landroid/content/ServiceConnection;

    .line 1242
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$15;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$15;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->handler:Landroid/os/Handler;

    .line 1248
    new-instance v0, Landroid/os/Messenger;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->handler:Landroid/os/Handler;

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->messenger:Landroid/os/Messenger;

    .line 1656
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$29;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$29;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mPhoneStateListener:Landroid/telephony/PhoneStateListener;

    .line 1743
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$30;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$30;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    .line 1916
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldCheckNotificationBtn:Z

    .line 2353
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$36;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$36;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rCheckHistory:Ljava/lang/Runnable;

    .line 3464
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldChangeBackToWebView:Z

    .line 3882
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$48;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$48;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rLocalNotificationList:Ljava/lang/Runnable;

    .line 4163
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->resetTime:I

    .line 4164
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldResetTime:Z

    .line 4165
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->oriVideoId:Ljava/lang/String;

    .line 4355
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$50;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$50;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rSendInitInfo:Ljava/lang/Runnable;

    return-void
.end method

.method static synthetic access$000(Lcom/mixerbox/mixerbox3b/MainPage;Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 184
    invoke-direct {p0, p1, p2, p3}, Lcom/mixerbox/mixerbox3b/MainPage;->onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V

    return-void
.end method

.method static synthetic access$1000(Lcom/mixerbox/mixerbox3b/MainPage;Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 184
    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage;->autocomplete(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    return-object v0
.end method

.method static synthetic access$300(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 184
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->genShuffleIndexArray()V

    return-void
.end method

.method static synthetic access$400(IFFFF)Landroid/view/animation/Animation;
    .locals 1

    .prologue
    .line 184
    invoke-static {p0, p1, p2, p3, p4}, Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$500(Lcom/mixerbox/mixerbox3b/MainPage;Ljava/lang/String;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 184
    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage;->getMP3Thumbnail(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$600(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 184
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setWebViewTouchListener()V

    return-void
.end method

.method static synthetic access$700(Lcom/mixerbox/mixerbox3b/MainPage;Lcom/facebook/Session;)V
    .locals 0

    .prologue
    .line 184
    invoke-direct {p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage;->requestPublishPermissions(Lcom/facebook/Session;)V

    return-void
.end method

.method private autocomplete(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 9

    .prologue
    const/4 v2, 0x0

    .line 3967
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 3968
    const-string v0, ""

    .line 3970
    :try_start_0
    const-string v1, "utf8"

    invoke-static {p1, v1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_3

    move-result-object v0

    .line 3974
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "-"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 3977
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "http://suggestqueries.google.com/complete/search?ds=yt&client=android&hl="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "&oe=UTF-8&q="

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3979
    const/4 v1, 0x0

    .line 3980
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 3982
    :try_start_1
    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, v0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 3983
    invoke-virtual {v5}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    check-cast v0, Ljava/net/HttpURLConnection;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 3984
    :try_start_2
    new-instance v1, Ljava/io/InputStreamReader;

    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v5

    invoke-direct {v1, v5}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    .line 3987
    const/16 v5, 0x400

    new-array v5, v5, [C

    .line 3988
    :goto_1
    invoke-virtual {v1, v5}, Ljava/io/InputStreamReader;->read([C)I

    move-result v6

    const/4 v7, -0x1

    if-eq v6, v7, :cond_2

    .line 3989
    const/4 v7, 0x0

    invoke-virtual {v4, v5, v7, v6}, Ljava/lang/StringBuilder;->append([CII)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    goto :goto_1

    .line 3993
    :catch_0
    move-exception v1

    :goto_2
    if-eqz v0, :cond_0

    .line 3994
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 3999
    :cond_0
    :goto_3
    :try_start_3
    new-instance v5, Lorg/json/JSONArray;

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v5, v0}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    move v1, v2

    .line 4000
    :goto_4
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v1, v0, :cond_5

    .line 4001
    invoke-virtual {v5, v1}, Lorg/json/JSONArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lorg/json/JSONArray;

    if-eqz v0, :cond_4

    .line 4002
    invoke-virtual {v5, v1}, Lorg/json/JSONArray;->getJSONArray(I)Lorg/json/JSONArray;

    move-result-object v4

    move v0, v2

    .line 4003
    :goto_5
    invoke-virtual {v4}, Lorg/json/JSONArray;->length()I

    move-result v6

    if-ge v0, v6, :cond_4

    .line 4004
    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_1

    .line 4005
    invoke-virtual {v4, v0}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1

    .line 4003
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 3993
    :cond_2
    if-eqz v0, :cond_0

    .line 3994
    invoke-virtual {v0}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_3

    .line 3993
    :catchall_0
    move-exception v0

    :goto_6
    if-eqz v1, :cond_3

    .line 3994
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_3
    throw v0

    .line 4000
    :cond_4
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_4

    :catch_1
    move-exception v0

    .line 4013
    :cond_5
    return-object v3

    .line 3993
    :catchall_1
    move-exception v1

    move-object v8, v1

    move-object v1, v0

    move-object v0, v8

    goto :goto_6

    :catch_2
    move-exception v0

    move-object v0, v1

    goto :goto_2

    :catch_3
    move-exception v1

    goto/16 :goto_0
.end method

.method private closeDB()V
    .locals 1

    .prologue
    .line 4352
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->close()V

    .line 4353
    return-void
.end method

.method private genShuffleIndexArray()V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 2901
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 2913
    :cond_0
    return-void

    .line 2903
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [I

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    move v0, v1

    .line 2904
    :goto_0
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 2905
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    aput v0, v2, v0

    .line 2904
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2906
    :cond_2
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    .line 2907
    :goto_1
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 2908
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {v0, v2}, Ljava/util/Random;->nextInt(I)I

    move-result v2

    .line 2909
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    aget v3, v3, v2

    .line 2910
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    aget v5, v5, v1

    aput v5, v4, v2

    .line 2911
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    aput v3, v2, v1

    .line 2907
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method private getMP3Thumbnail(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 1824
    const-string v0, ""

    .line 1825
    const-string v1, "content://media/external/audio/albumart"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 1826
    invoke-static {p1}, Ljava/lang/Long;->valueOf(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-static {v1, v2, v3}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v1

    .line 1827
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    .line 1829
    :try_start_0
    invoke-virtual {v2, v1}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 1830
    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 1834
    :cond_0
    :goto_0
    return-object v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private getShuffleIndex(I)I
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 2917
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 2918
    :cond_0
    const/4 v0, -0x1

    .line 2933
    :goto_0
    return v0

    .line 2919
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge p1, v0, :cond_2

    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleCount:I

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    array-length v0, v0

    if-lt p1, v0, :cond_3

    .line 2921
    :cond_2
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->genShuffleIndexArray()V

    .line 2922
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleCount:I

    .line 2924
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    array-length v0, v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-eq v0, v1, :cond_4

    .line 2925
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->genShuffleIndexArray()V

    .line 2926
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleCount:I

    .line 2928
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    aget v0, v0, p1

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lt v0, v1, :cond_5

    .line 2929
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->genShuffleIndexArray()V

    .line 2930
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleCount:I

    .line 2932
    :cond_5
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleCount:I

    .line 2933
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleIndexArray:[I

    aget v0, v0, p1

    goto :goto_0
.end method

.method private onSessionStateChange(Lcom/facebook/Session;Lcom/facebook/SessionState;Ljava/lang/Exception;)V
    .locals 1

    .prologue
    .line 2823
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/facebook/Session;->isOpened()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2824
    sget-object v0, Lcom/facebook/SessionState;->OPENED_TOKEN_UPDATED:Lcom/facebook/SessionState;

    invoke-virtual {p2, v0}, Lcom/facebook/SessionState;->equals(Ljava/lang/Object;)Z

    .line 2831
    :cond_0
    return-void
.end method

.method private openDB()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 4276
    .line 4277
    const-string v0, "mixerboxdb.db"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getDatabasePath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v5

    .line 4278
    invoke-virtual {v5}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_9

    move v0, v1

    .line 4281
    :goto_0
    new-instance v3, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-direct {v3, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;-><init>(Landroid/content/Context;)V

    iput-object v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    .line 4283
    if-nez v0, :cond_4

    .line 4284
    new-instance v0, Ljava/lang/Thread;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rSendInitInfo:Ljava/lang/Runnable;

    invoke-direct {v0, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 4287
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 4289
    const/16 v3, 0x80

    invoke-virtual {v0, v3}, Landroid/content/pm/PackageManager;->getInstalledApplications(I)Ljava/util/List;

    move-result-object v0

    .line 4290
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    move v3, v1

    move v4, v1

    :goto_1
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ApplicationInfo;

    .line 4291
    iget-object v7, v0, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v8, "com.mixerbox.mixerbox2"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    move v4, v2

    .line 4293
    :cond_0
    iget-object v0, v0, Landroid/content/pm/ApplicationInfo;->packageName:Ljava/lang/String;

    const-string v7, "com.mixerbox.mixerbox2b"

    invoke-virtual {v0, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    move v0, v2

    :goto_2
    move v3, v0

    .line 4294
    goto :goto_1

    .line 4296
    :cond_1
    if-nez v4, :cond_2

    if-eqz v3, :cond_3

    .line 4297
    :cond_2
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldLogin:Z

    .line 4298
    const-string v0, "http://bit.ly/MB3AndroidHasMB2MB2b"

    new-instance v3, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v3}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v9, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 4302
    :cond_3
    :try_start_0
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v3

    .line 4303
    invoke-virtual {v3}, Ljava/io/File;->canWrite()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 4304
    new-instance v0, Ljava/io/File;

    const-string v4, "//Download/mixerboxdb.db"

    invoke-direct {v0, v3, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 4305
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_5

    move-object v6, v0

    .line 4326
    :goto_3
    if-eqz v2, :cond_4

    .line 4327
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->close()V

    .line 4329
    new-instance v0, Ljava/io/FileInputStream;

    invoke-direct {v0, v6}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v0}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v1

    .line 4330
    new-instance v0, Ljava/io/FileOutputStream;

    invoke-direct {v0, v5}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v0}, Ljava/io/FileOutputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v0

    .line 4331
    const-wide/16 v2, 0x0

    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v4

    invoke-virtual/range {v0 .. v5}, Ljava/nio/channels/FileChannel;->transferFrom(Ljava/nio/channels/ReadableByteChannel;JJ)J

    .line 4332
    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->close()V

    .line 4333
    invoke-virtual {v0}, Ljava/nio/channels/FileChannel;->close()V

    .line 4335
    new-instance v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    .line 4337
    invoke-virtual {v6}, Ljava/io/File;->delete()Z

    .line 4349
    :cond_4
    :goto_4
    return-void

    .line 4309
    :cond_5
    new-instance v0, Ljava/io/File;

    const-string v4, "//Download/mixerbox2b0db.db"

    invoke-direct {v0, v3, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 4310
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 4312
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldLogin:Z

    move-object v6, v0

    goto :goto_3

    .line 4315
    :cond_6
    new-instance v0, Ljava/io/File;

    const-string v4, "//Download/mixerbox2b1db.db"

    invoke-direct {v0, v3, v4}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 4316
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 4317
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldLogin:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object v6, v0

    .line 4318
    goto :goto_3

    :cond_7
    move-object v6, v0

    move v2, v1

    .line 4321
    goto :goto_3

    .line 4340
    :catch_0
    move-exception v0

    .line 4341
    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4342
    const-string v0, "http://bit.ly/MB3AndroidImportFail"

    new-instance v1, Lcom/loopj/android/http/AsyncHttpResponseHandler;

    invoke-direct {v1}, Lcom/loopj/android/http/AsyncHttpResponseHandler;-><init>()V

    invoke-static {v0, v9, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 4343
    invoke-static {}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getExportFailUrl()Ljava/lang/String;

    move-result-object v0

    .line 4344
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    invoke-static {v0, v9, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_4

    :cond_8
    move v0, v3

    goto/16 :goto_2

    :cond_9
    move v0, v2

    goto/16 :goto_0
.end method

.method private requestPublishPermissions(Lcom/facebook/Session;)V
    .locals 2

    .prologue
    .line 2748
    if-eqz p1, :cond_0

    .line 2749
    new-instance v0, Lcom/facebook/Session$NewPermissionsRequest;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->PERMISSIONS:Ljava/util/List;

    invoke-direct {v0, p0, v1}, Lcom/facebook/Session$NewPermissionsRequest;-><init>(Landroid/app/Activity;Ljava/util/List;)V

    const/16 v1, 0x64

    invoke-virtual {v0, v1}, Lcom/facebook/Session$NewPermissionsRequest;->setRequestCode(I)Lcom/facebook/Session$NewPermissionsRequest;

    move-result-object v0

    .line 2751
    invoke-virtual {p1, v0}, Lcom/facebook/Session;->requestNewPublishPermissions(Lcom/facebook/Session$NewPermissionsRequest;)V

    .line 2753
    :cond_0
    return-void
.end method

.method private setWebViewTouchListener()V
    .locals 2

    .prologue
    .line 2834
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$39;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$39;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 2897
    return-void
.end method

.method private showPlayerGuide()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 2369
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstPlay(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2370
    const/16 v0, 0xc

    new-array v1, v1, [Z

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    .line 2376
    :cond_0
    :goto_0
    return-void

    .line 2371
    :cond_1
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipSecondPlay(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 2372
    const/16 v0, 0xd

    new-array v1, v1, [Z

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    goto :goto_0

    .line 2373
    :cond_2
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipThirdPlay(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2374
    const/16 v0, 0xe

    new-array v1, v1, [Z

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    goto :goto_0
.end method

.method private static slideAnim(IFFFF)Landroid/view/animation/Animation;
    .locals 9

    .prologue
    const/4 v1, 0x1

    .line 3586
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    move v2, p1

    move v3, v1

    move v4, p2

    move v5, v1

    move v6, p3

    move v7, v1

    move v8, p4

    invoke-direct/range {v0 .. v8}, Landroid/view/animation/TranslateAnimation;-><init>(IFIFIFIF)V

    .line 3588
    int-to-long v1, p0

    invoke-virtual {v0, v1, v2}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 3589
    return-object v0
.end method


# virtual methods
.method public addLocalNotificationList(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 10

    .prologue
    .line 3929
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/16 v1, 0x9

    if-lt v0, v1, :cond_0

    .line 3930
    const/4 v0, 0x1

    .line 3940
    :goto_0
    return v0

    .line 3931
    :cond_0
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v6, ""

    const/4 v8, 0x2

    const/4 v9, 0x1

    move-object v1, p1

    move-object v2, p2

    move-object/from16 v3, p6

    move-object v4, p3

    move-object v5, p5

    move-object v7, p4

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 3932
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v1, p1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getHasPushed(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 3933
    const/4 v1, 0x0

    move v2, v1

    :goto_1
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v2, v1, :cond_2

    .line 3934
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 3935
    const/4 v0, 0x0

    goto :goto_0

    .line 3933
    :cond_1
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_1

    .line 3937
    :cond_2
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3938
    const/4 v0, 0x1

    goto :goto_0

    .line 3940
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public backToPreviousFragment()V
    .locals 7

    .prologue
    const v6, 0x7f0700b6

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, -0x1

    .line 3422
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 3423
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 3424
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v2, "VectorFragment"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v2, "SongFragment"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v2, "MP3Fragment"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v2, "WebFragment"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 3428
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentTransaction;->remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 3431
    :goto_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->stackCurrentFragmentId:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    .line 3432
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->stackCurrentFragmentId:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3434
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 3435
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentTransaction;->show(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 3436
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I

    move-result v0

    const/4 v2, 0x1

    if-ne v0, v2, :cond_3

    .line 3437
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->changeToNormalActionBar(Landroid/content/Context;)V

    .line 3438
    :cond_3
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 3439
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->stackCurrentFragmentId:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 3440
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->menu:Lcom/actionbarsherlock/view/Menu;

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->stackCurrentFragmentId:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {v1, v0, p0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->setActionBarItems(Lcom/actionbarsherlock/view/Menu;ILandroid/content/Context;)V

    .line 3442
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    const-string v1, "SongFragment"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 3443
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    if-nez v0, :cond_6

    .line 3445
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->menu:Lcom/actionbarsherlock/view/Menu;

    const/16 v1, 0xb

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 3448
    :cond_6
    const v0, 0x7f0700d0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 3449
    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v2, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 3450
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/support/v4/app/Fragment;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    const-string v3, "WebFragment"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 3451
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 3452
    invoke-virtual {v2, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 3453
    const v1, 0x7f0700cf

    invoke-virtual {v2, v4, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 3454
    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 3461
    :goto_1
    return-void

    .line 3430
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentTransaction;->hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    goto/16 :goto_0

    .line 3456
    :cond_8
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    const/4 v3, 0x0

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 3457
    const v1, 0x7f0700d1

    invoke-virtual {v2, v4, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 3458
    invoke-virtual {v2, v5, v6}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 3459
    invoke-virtual {v0, v2}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_1
.end method

.method public changeQuality(Z)V
    .locals 3

    .prologue
    .line 1578
    if-nez p1, :cond_0

    .line 1579
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnQuality:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f02010d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1580
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:setQuality("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ",false)"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1581
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putHighQuality(Landroid/content/Context;Z)V

    .line 1587
    :goto_0
    return-void

    .line 1583
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnQuality:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200dd

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1584
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:setQuality("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ",true)"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1585
    const/4 v0, 0x1

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putHighQuality(Landroid/content/Context;Z)V

    goto :goto_0
.end method

.method changeToMediaPlayer(Z)V
    .locals 2

    .prologue
    .line 3467
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldChangeBackToWebView:Z

    .line 3468
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    .line 3469
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->oriVideoId:Ljava/lang/String;

    .line 3470
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_1

    if-nez p1, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    if-eqz v0, :cond_1

    .line 3471
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->playMusic(Ljava/lang/String;)V

    .line 3472
    new-instance v0, Ljava/lang/Thread;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rCheckHistory:Ljava/lang/Runnable;

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 3473
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->sendNotification()V

    .line 3475
    :cond_1
    return-void
.end method

.method public checkBundle()V
    .locals 13

    .prologue
    const/4 v3, 0x4

    const/4 v4, 0x5

    const/4 v8, 0x3

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 1048
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v0, :cond_7

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "tab"

    invoke-virtual {v0, v1, v9}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    if-eqz v0, :cond_7

    .line 1049
    const-string v0, "action:press_notification"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 1050
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "tab"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 1051
    if-ne v0, v10, :cond_1

    .line 1052
    invoke-virtual {p0, v9}, Lcom/mixerbox/mixerbox3b/MainPage;->setPlaylists(Z)V

    .line 1063
    :goto_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "playlistId"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 1064
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v2, "playlistId"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v3, "playlistName"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v4, "artistId"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v5, "artist"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    sget-object v5, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v6, "itemCount"

    const-string v7, ""

    invoke-virtual {v5, v6, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, ""

    sget-object v7, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v11, "url"

    invoke-virtual {v7, v11}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 1067
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 1068
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    move-result-object v12

    .line 1069
    iput-object v0, v12, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    .line 1070
    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v2, "play"

    invoke-virtual {v1, v2, v9}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    if-eq v1, v10, :cond_6

    .line 1071
    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v2, "play"

    invoke-virtual {v1, v2, v9}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    const/4 v2, -0x1

    if-ne v1, v2, :cond_5

    .line 1073
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v8

    const/4 v11, -0x1

    move-object v7, p0

    invoke-static/range {v7 .. v12}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    .line 1082
    :goto_1
    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v2, "subscribe"

    invoke-virtual {v1, v2, v9}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1083
    invoke-virtual {p0, v0, v10}, Lcom/mixerbox/mixerbox3b/MainPage;->subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V

    .line 1203
    :cond_0
    :goto_2
    return-void

    .line 1053
    :cond_1
    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 1054
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setNewsfeed()V

    goto/16 :goto_0

    .line 1055
    :cond_2
    if-eq v0, v8, :cond_4

    .line 1056
    if-ne v0, v3, :cond_3

    .line 1058
    invoke-virtual {p0, v10}, Lcom/mixerbox/mixerbox3b/MainPage;->setDJs(I)V

    goto/16 :goto_0

    .line 1059
    :cond_3
    if-ne v0, v4, :cond_4

    .line 1060
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setSettings()V

    goto/16 :goto_0

    .line 1062
    :cond_4
    new-array v0, v9, [Z

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setDiscover([Z)V

    goto/16 :goto_0

    .line 1075
    :cond_5
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_6

    .line 1076
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v8

    const/4 v11, -0x1

    move-object v7, p0

    invoke-static/range {v7 .. v12}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    goto :goto_1

    .line 1079
    :cond_6
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v8

    move-object v7, p0

    move v11, v9

    invoke-static/range {v7 .. v12}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadSong(Landroid/content/Context;Ljava/lang/String;ZIILcom/mixerbox/mixerbox3b/fragments/SongFragment;)V

    goto :goto_1

    .line 1085
    :cond_7
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "data"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 1086
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "data"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1087
    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 1088
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v9, v1}, Ljava/lang/String;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1089
    :cond_8
    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 1092
    array-length v1, v0

    if-ne v1, v4, :cond_a

    .line 1093
    aget-object v1, v0, v8

    const-string v2, "list"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 1094
    aget-object v0, v0, v3

    .line 1095
    const-string v1, "playlist"

    invoke-static {v0, v9, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getVectorUrl(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 1096
    const/4 v2, 0x0

    new-instance v3, Lcom/mixerbox/mixerbox3b/MainPage$11;

    invoke-direct {v3, p0, p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage$11;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;Ljava/lang/String;)V

    invoke-static {v1, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto/16 :goto_2

    .line 1124
    :cond_9
    aget-object v0, v0, v8

    const-string v1, "user"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    goto/16 :goto_2

    .line 1127
    :cond_a
    array-length v1, v0

    const/4 v2, 0x6

    if-ne v1, v2, :cond_0

    .line 1128
    aget-object v1, v0, v8

    const-string v2, "music"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1129
    aget-object v1, v0, v3

    const-string v2, "0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 1130
    aget-object v1, v0, v4

    .line 1131
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "http://gdata.youtube.com/feeds/api/videos/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    aget-object v0, v0, v4

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "?alt=json&v=2"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 1132
    const/4 v2, 0x0

    new-instance v3, Lcom/mixerbox/mixerbox3b/MainPage$12;

    invoke-direct {v3, p0, p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage$12;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;Ljava/lang/String;)V

    invoke-static {v0, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto/16 :goto_2

    .line 1159
    :cond_b
    aget-object v1, v0, v4

    .line 1160
    aget-object v0, v0, v3

    .line 1161
    const-string v2, "playlist"

    invoke-static {v0, v9, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getVectorUrl(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1162
    const/4 v3, 0x0

    new-instance v4, Lcom/mixerbox/mixerbox3b/MainPage$13;

    invoke-direct {v4, p0, p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage$13;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v2, v3, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto/16 :goto_2
.end method

.method public checkButton()V
    .locals 3

    .prologue
    .line 1936
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    .line 1937
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1938
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200ed

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1941
    :cond_0
    return-void
.end method

.method public checkMP3CountAndLoad()V
    .locals 6

    .prologue
    .line 2049
    const/4 v0, 0x0

    :try_start_0
    new-array v2, v0, [Ljava/lang/String;

    .line 2052
    const-string v3, "is_music != 0"

    .line 2053
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Landroid/provider/MediaStore$Audio$Media;->EXTERNAL_CONTENT_URI:Landroid/net/Uri;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 2054
    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v1

    .line 2055
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 2056
    if-lez v1, :cond_0

    .line 2058
    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->loadMP3(I)V

    .line 2064
    :goto_0
    return-void

    .line 2060
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMP3:Ljava/util/ArrayList;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public closePlayer()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 3001
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    .line 3003
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetCanAuto:Z

    if-nez v0, :cond_0

    .line 3004
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlHint:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 3006
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 3007
    const/16 v0, 0x320

    const/high16 v1, -0x40800000    # -1.0f

    invoke-static {v0, v2, v2, v2, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->slideAnim(IFFFF)Landroid/view/animation/Animation;

    move-result-object v0

    .line 3008
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$40;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$40;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 3025
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 3026
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopPlayer()V

    .line 3027
    return-void
.end method

.method public handleAnnounce()V
    .locals 4

    .prologue
    .line 2697
    new-instance v0, Lcom/loopj/android/http/AsyncHttpClient;

    invoke-direct {v0}, Lcom/loopj/android/http/AsyncHttpClient;-><init>()V

    .line 2698
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "https://graph.facebook.com/me/permissions?access_token="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getFacebookToken(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    new-instance v3, Lcom/mixerbox/mixerbox3b/MainPage$37;

    invoke-direct {v3, p0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$37;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/loopj/android/http/AsyncHttpClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 2743
    return-void
.end method

.method public loadMP3(I)V
    .locals 11

    .prologue
    .line 680
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMP3:Ljava/util/ArrayList;

    .line 681
    iget-object v10, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMP3:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, "PLAYLISTMP3ID"

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080128

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    const-string v4, ""

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    const-string v6, "0"

    const-string v7, ""

    const/16 v8, 0x8

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 683
    return-void
.end method

.method public musicPlayPause()V
    .locals 6

    .prologue
    const v5, 0x7f0200ef

    const v4, 0x7f0200ed

    const/4 v2, 0x3

    const/4 v1, 0x2

    const/4 v3, 0x1

    .line 1944
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    if-eq v0, v2, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    if-ne v0, v1, :cond_4

    .line 1946
    :cond_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 1947
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1948
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 1949
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1955
    :cond_1
    :goto_0
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->sendNotification()V

    .line 1973
    :cond_2
    :goto_1
    return-void

    .line 1951
    :cond_3
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->start()V

    .line 1952
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 1956
    :cond_4
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldChangeBackToWebView:Z

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    if-eqz v0, :cond_6

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isBackground:Z

    if-eqz v0, :cond_6

    .line 1957
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->getIsPlaying()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 1958
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->pauseMusic()V

    .line 1961
    :goto_2
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->sendNotification()V

    goto :goto_1

    .line 1960
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->playMusic()V

    goto :goto_2

    .line 1963
    :cond_6
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v3, :cond_7

    .line 1964
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1965
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 1966
    :cond_7
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-ne v0, v1, :cond_2

    .line 1967
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->am:Landroid/media/AudioManager;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    invoke-virtual {v0, v1, v2, v3}, Landroid/media/AudioManager;->requestAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I

    .line 1968
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:playVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1969
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1970
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    const-wide/16 v1, 0xfa0

    invoke-virtual {v0, v3, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_1
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 4

    .prologue
    .line 2757
    invoke-super {p0, p1, p2, p3}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 2758
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0, p1, p2, p3}, Lcom/facebook/UiLifecycleHelper;->onActivityResult(IILandroid/content/Intent;)V

    .line 2759
    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v0

    invoke-virtual {v0, p0, p1, p2, p3}, Lcom/facebook/Session;->onActivityResult(Landroid/app/Activity;IILandroid/content/Intent;)Z

    .line 2760
    packed-switch p1, :pswitch_data_0

    .line 2820
    :goto_0
    return-void

    .line 2762
    :pswitch_0
    new-instance v0, Lcom/loopj/android/http/AsyncHttpClient;

    invoke-direct {v0}, Lcom/loopj/android/http/AsyncHttpClient;-><init>()V

    .line 2763
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "https://graph.facebook.com/me/permissions?access_token="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getFacebookToken(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x0

    new-instance v3, Lcom/mixerbox/mixerbox3b/MainPage$38;

    invoke-direct {v3, p0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$38;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/loopj/android/http/AsyncHttpClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    goto :goto_0

    .line 2760
    nop

    :pswitch_data_0
    .packed-switch 0x64
        :pswitch_0
    .end packed-switch
.end method

.method public onBackPressed()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 3479
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->isShown()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3480
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->performClick()Z

    .line 3500
    :goto_0
    return-void

    .line 3483
    :cond_0
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_1

    .line 3484
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setUnFullScreen(Z)V

    goto :goto_0

    .line 3487
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I

    move-result v0

    if-le v0, v2, :cond_2

    .line 3488
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->backToPreviousFragment()V

    goto :goto_0

    .line 3491
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_4

    .line 3492
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getEnableBackgroundPlay(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 3493
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->changeToMediaPlayer(Z)V

    .line 3494
    :cond_3
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->moveTaskToBack(Z)Z

    .line 3499
    :goto_1
    invoke-static {p0}, Lcom/flurry/android/FlurryAgent;->onEndSession(Landroid/content/Context;)V

    goto :goto_0

    .line 3496
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "about:blank"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 3497
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->finish()V

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 9
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled"
        }
    .end annotation

    .prologue
    const/high16 v8, 0x4000000

    const/4 v7, 0x2

    const v6, 0x7f020071

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 308
    const/4 v0, 0x0

    invoke-super {p0, v0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 310
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "EXECUTION TIME = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/lang/System;->nanoTime()J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 312
    const-wide/16 v0, 0x5

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->requestWindowFeature(J)V

    .line 313
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->initActionBar(Landroid/content/Context;)V

    .line 314
    const v0, 0x7f030040

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setContentView(I)V

    .line 316
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    sput-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    .line 318
    sget-boolean v0, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->shouldOnCreate:Z

    if-eqz v0, :cond_0

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "isLogIn"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 319
    :cond_0
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 320
    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v1, :cond_1

    .line 321
    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 322
    :cond_1
    invoke-virtual {v0, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 323
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->startActivity(Landroid/content/Intent;)V

    .line 326
    :cond_2
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-nez v0, :cond_3

    .line 327
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    .line 329
    :cond_3
    sput-boolean v2, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->shouldOnCreate:Z

    .line 330
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isForeground:Z

    .line 332
    new-instance v0, Lcom/facebook/UiLifecycleHelper;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->callback:Lcom/facebook/Session$StatusCallback;

    invoke-direct {v0, p0, v1}, Lcom/facebook/UiLifecycleHelper;-><init>(Landroid/app/Activity;Lcom/facebook/Session$StatusCallback;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    .line 333
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0, p1}, Lcom/facebook/UiLifecycleHelper;->onCreate(Landroid/os/Bundle;)V

    .line 335
    new-instance v0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    invoke-virtual {v0, v6}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageOnLoading(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0, v6}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageForEmptyUri(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0, v6}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageOnFail(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0, v3}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc(Z)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v0

    .line 337
    new-instance v1, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v1, v4}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v1, v0}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->defaultDisplayImageOptions(Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration$Builder;->build()Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    move-result-object v0

    .line 339
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->init(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;)V

    .line 348
    :try_start_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "isLogIn"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 355
    :goto_0
    const v0, 0x7f0700d1

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    .line 356
    const v0, 0x7f0700cf

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/ads/AdView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->adView:Lcom/google/android/gms/ads/AdView;

    .line 357
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getShouldShowAd(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 358
    new-instance v0, Lcom/google/android/gms/ads/AdRequest$Builder;

    invoke-direct {v0}, Lcom/google/android/gms/ads/AdRequest$Builder;-><init>()V

    invoke-virtual {v0}, Lcom/google/android/gms/ads/AdRequest$Builder;->build()Lcom/google/android/gms/ads/AdRequest;

    move-result-object v0

    .line 359
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->adView:Lcom/google/android/gms/ads/AdView;

    invoke-virtual {v1, v0}, Lcom/google/android/gms/ads/AdView;->loadAd(Lcom/google/android/gms/ads/AdRequest;)V

    .line 364
    :goto_1
    const-string v0, "phone"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .line 365
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mPhoneStateListener:Landroid/telephony/PhoneStateListener;

    const/16 v4, 0x20

    invoke-virtual {v0, v1, v4}, Landroid/telephony/TelephonyManager;->listen(Landroid/telephony/PhoneStateListener;I)V

    .line 367
    const-string v0, "audio"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->am:Landroid/media/AudioManager;

    .line 369
    sput-boolean v3, Lcom/mixerbox/mixerbox3b/MainPage;->defaultPortrait:Z

    .line 370
    const-string v0, "window"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/WindowManager;

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Display;->getRotation()I

    move-result v0

    .line 372
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    .line 373
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xd

    if-lt v4, v5, :cond_d

    .line 374
    new-instance v4, Landroid/util/DisplayMetrics;

    invoke-direct {v4}, Landroid/util/DisplayMetrics;-><init>()V

    .line 375
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 376
    iget v1, v4, Landroid/util/DisplayMetrics;->heightPixels:I

    iput v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    .line 377
    iget v1, v4, Landroid/util/DisplayMetrics;->widthPixels:I

    iput v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    .line 385
    :goto_2
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    if-le v1, v4, :cond_e

    if-eqz v0, :cond_e

    .line 386
    sput-boolean v3, Lcom/mixerbox/mixerbox3b/MainPage;->defaultPortrait:Z

    .line 394
    :cond_4
    :goto_3
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    if-le v0, v1, :cond_1c

    move v1, v2

    .line 397
    :goto_4
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    if-le v0, v4, :cond_5

    .line 398
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    .line 399
    iget v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    iput v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    .line 400
    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    .line 403
    :cond_5
    const-string v0, "notification"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->nm:Landroid/app/NotificationManager;

    .line 404
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopPlayer()V

    .line 406
    sget-object v0, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getMobileBuildNumber(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 407
    invoke-static {p0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPlayerType(Landroid/content/Context;I)V

    .line 408
    sput v2, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    .line 409
    sget-object v0, Landroid/os/Build;->FINGERPRINT:Ljava/lang/String;

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putMobileBuildNumber(Landroid/content/Context;Ljava/lang/String;)V

    .line 412
    :cond_6
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setVideoPlayer()V

    .line 414
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldLogin:Z

    .line 415
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->openDB()V

    .line 416
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldLogin:Z

    if-eqz v0, :cond_11

    .line 417
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canPlay:Z

    .line 421
    :goto_5
    if-nez v1, :cond_7

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "accelerometer_rotation"

    invoke-static {v0, v1, v2}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    if-eq v0, v3, :cond_12

    .line 422
    :cond_7
    const/4 v0, 0x7

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setRequestedOrientation(I)V

    .line 427
    :goto_6
    const-string v0, "connectivity"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 428
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v0

    .line 429
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 430
    if-eqz v0, :cond_15

    invoke-virtual {v0}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v4

    if-eqz v4, :cond_15

    .line 431
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v4

    if-ne v4, v3, :cond_13

    .line 432
    const-string v0, "status"

    const-string v4, "wifi"

    invoke-interface {v1, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 444
    :goto_7
    const-string v0, "status:network_status"

    invoke-static {v0, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 446
    const v0, 0x3b9ac9ff

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shuffleCount:I

    .line 448
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldCloseApp:Z

    .line 449
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    .line 450
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetCanAuto:Z

    .line 451
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlay:I

    .line 452
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isReady:Z

    .line 453
    sput-boolean v2, Lcom/mixerbox/mixerbox3b/MainPage;->isPageLoaded:Z

    .line 454
    iput-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlayAfterReady:Z

    .line 455
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->errorCount:I

    .line 456
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canUpdateSeekbar:Z

    .line 458
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    .line 459
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    .line 460
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySong:Ljava/util/ArrayList;

    .line 461
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    .line 462
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    .line 463
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    .line 464
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    .line 465
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    .line 466
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    .line 468
    const v0, 0x7f0700d3

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlaylists:Landroid/widget/RelativeLayout;

    .line 469
    const v0, 0x7f0700d7

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnNewsfeed:Landroid/widget/RelativeLayout;

    .line 470
    const v0, 0x7f0700da

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDiscover:Landroid/widget/RelativeLayout;

    .line 471
    const v0, 0x7f0700de

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDJs:Landroid/widget/RelativeLayout;

    .line 472
    const v0, 0x7f0700e1

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnSettings:Landroid/widget/RelativeLayout;

    .line 473
    const v0, 0x7f0700d2

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvNoInternet:Landroid/widget/TextView;

    .line 475
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    .line 476
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->stackCurrentFragmentId:Ljava/util/Stack;

    .line 477
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentManager:Landroid/support/v4/app/FragmentManager;

    .line 479
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_8

    .line 480
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->saveAuthLoginInfo(Landroid/content/Context;)V

    .line 482
    :cond_8
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    .line 483
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    .line 484
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDiscover:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    .line 485
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    .line 486
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    .line 487
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSignUp:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    .line 489
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setSignUp()V

    .line 491
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldLogin:Z

    if-nez v0, :cond_18

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_18

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getOnboardingFinish(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_18

    .line 492
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-nez v0, :cond_9

    .line 493
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->parseDBMyPlaylists()V

    .line 494
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->parseDefaultSubsPlaylists()V

    .line 497
    :cond_9
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setPlaylists(Z)V

    .line 498
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->onboardingSubscribeArtists()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->name:Ljava/util/ArrayList;

    .line 500
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->name:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_16

    .line 501
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->onboardingPlayMusic()V

    .line 502
    const v0, 0x7f0700dd

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 503
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 504
    new-array v0, v2, [Z

    invoke-virtual {p0, v3, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    .line 532
    :goto_8
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlaylists:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$2;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 538
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnNewsfeed:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$3;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$3;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 544
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDiscover:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$4;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$4;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 550
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDJs:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$5;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$5;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 556
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnSettings:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$6;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$6;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 563
    const/4 v0, -0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->preOri:I

    .line 564
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$7;

    invoke-direct {v0, p0, p0, v7}, Lcom/mixerbox/mixerbox3b/MainPage$7;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;I)V

    .line 608
    invoke-virtual {v0}, Landroid/view/OrientationEventListener;->enable()V

    .line 610
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "PlayerBroadcastReceiver"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 611
    new-instance v1, Lcom/mixerbox/mixerbox3b/services/PlayerReceiver;

    invoke-direct {v1}, Lcom/mixerbox/mixerbox3b/services/PlayerReceiver;-><init>()V

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mReceiver:Lcom/mixerbox/mixerbox3b/services/PlayerReceiver;

    .line 612
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mReceiver:Lcom/mixerbox/mixerbox3b/services/PlayerReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 613
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "SleepService"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 614
    new-instance v1, Lcom/mixerbox/mixerbox3b/services/SleepReceiver;

    invoke-direct {v1}, Lcom/mixerbox/mixerbox3b/services/SleepReceiver;-><init>()V

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->sr:Lcom/mixerbox/mixerbox3b/services/SleepReceiver;

    .line 615
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->sr:Lcom/mixerbox/mixerbox3b/services/SleepReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 616
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Lcom/mixerbox/mixerbox3b/MainPage$1;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myReceiver:Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;

    .line 617
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.HEADSET_PLUG"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 618
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myReceiver:Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 619
    new-instance v0, Lcom/mixerbox/mixerbox3b/services/EarphoneReceiver;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/services/EarphoneReceiver;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->earphoneReceiver:Lcom/mixerbox/mixerbox3b/services/EarphoneReceiver;

    .line 620
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->earphoneReceiver:Lcom/mixerbox/mixerbox3b/services/EarphoneReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "Earphone"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 621
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->am:Landroid/media/AudioManager;

    new-instance v1, Landroid/content/ComponentName;

    const-class v2, Lcom/mixerbox/mixerbox3b/services/RemoteControlReceiver;

    invoke-direct {v1, p0, v2}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->registerMediaButtonEventReceiver(Landroid/content/ComponentName;)V

    .line 623
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "MyService"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 624
    new-instance v1, Lcom/mixerbox/mixerbox3b/services/MyReceiver;

    invoke-direct {v1}, Lcom/mixerbox/mixerbox3b/services/MyReceiver;-><init>()V

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->r:Lcom/mixerbox/mixerbox3b/services/MyReceiver;

    .line 625
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->r:Lcom/mixerbox/mixerbox3b/services/MyReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 627
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getHasRated(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_a

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getOpenTimeCount(Landroid/content/Context;)I

    move-result v0

    rem-int/lit8 v0, v0, 0x14

    const/16 v1, 0x13

    if-ne v0, v1, :cond_a

    .line 629
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->AskRateAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 630
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 631
    invoke-static {p0, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putHasRated(Landroid/content/Context;Z)V

    .line 634
    :cond_a
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getOpenTimeCount(Landroid/content/Context;)I

    move-result v0

    if-le v0, v7, :cond_b

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getLastAd(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b

    .line 637
    :try_start_1
    new-instance v0, Lorg/json/JSONObject;

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getLastAd(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 638
    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_b

    const-string v1, "id"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getPreviousAdId(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_b

    const-string v1, "open"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 640
    const-string v1, "id"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPreviousAdId(Landroid/content/Context;Ljava/lang/String;)V

    .line 641
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 642
    new-instance v2, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;-><init>(Landroid/content/Context;)V

    .line 643
    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v3

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 644
    new-instance v3, Landroid/webkit/WebChromeClient;

    invoke-direct {v3}, Landroid/webkit/WebChromeClient;-><init>()V

    invoke-virtual {v2, v3}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 645
    const-string v3, "link"

    invoke-virtual {v0, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;->loadUrl(Ljava/lang/String;)V

    .line 646
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$8;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$8;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v2, v0}, Lcom/mixerbox/mixerbox3b/classes/MyFocusableWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 665
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    .line 666
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v2, 0x7f08007e

    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    new-instance v2, Lcom/mixerbox/mixerbox3b/MainPage$9;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/MainPage$9;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v1, v0, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 671
    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    move-result-object v0

    .line 672
    invoke-virtual {v0}, Landroid/app/AlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 677
    :cond_b
    :goto_9
    return-void

    .line 350
    :catch_0
    move-exception v0

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 351
    invoke-virtual {v0, v8}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 352
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 361
    :cond_c
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->removeAds()V

    goto/16 :goto_1

    .line 379
    :cond_d
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 380
    invoke-virtual {v1}, Landroid/view/Display;->getHeight()I

    move-result v4

    iput v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    .line 381
    invoke-virtual {v1}, Landroid/view/Display;->getWidth()I

    move-result v1

    iput v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    goto/16 :goto_2

    .line 387
    :cond_e
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    if-le v1, v4, :cond_f

    if-nez v0, :cond_f

    .line 388
    sput-boolean v2, Lcom/mixerbox/mixerbox3b/MainPage;->defaultPortrait:Z

    goto/16 :goto_3

    .line 389
    :cond_f
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    if-ge v1, v4, :cond_10

    if-nez v0, :cond_10

    .line 390
    sput-boolean v3, Lcom/mixerbox/mixerbox3b/MainPage;->defaultPortrait:Z

    goto/16 :goto_3

    .line 391
    :cond_10
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    iget v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    if-ge v1, v4, :cond_4

    if-eqz v0, :cond_4

    .line 392
    sput-boolean v2, Lcom/mixerbox/mixerbox3b/MainPage;->defaultPortrait:Z

    goto/16 :goto_3

    .line 419
    :cond_11
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canPlay:Z

    goto/16 :goto_5

    .line 424
    :cond_12
    const/4 v0, 0x6

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setRequestedOrientation(I)V

    goto/16 :goto_6

    .line 434
    :cond_13
    invoke-virtual {v0}, Landroid/net/NetworkInfo;->getType()I

    move-result v0

    if-nez v0, :cond_14

    .line 435
    const-string v0, "status"

    const-string v4, "mobile"

    invoke-interface {v1, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_7

    .line 438
    :cond_14
    const-string v0, "status"

    const-string v4, "unknown"

    invoke-interface {v1, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_7

    .line 442
    :cond_15
    const-string v0, "status"

    const-string v4, "notConnected"

    invoke-interface {v1, v0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_7

    .line 506
    :cond_16
    const-string v0, "action:no_auto_subscription"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 507
    invoke-static {p0, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putOnboardingFinish(Landroid/content/Context;Z)V

    .line 508
    const v0, 0x7f0700d6

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 509
    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 526
    :cond_17
    :goto_a
    new-array v0, v2, [Z

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setDiscover([Z)V

    goto/16 :goto_8

    .line 513
    :cond_18
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_1a

    .line 514
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v0, :cond_19

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "tab"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    if-eqz v0, :cond_19

    .line 515
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->checkBundle()V

    goto/16 :goto_8

    .line 516
    :cond_19
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstDiscover(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_17

    .line 517
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setNewsfeed()V

    goto/16 :goto_8

    .line 521
    :cond_1a
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->parseDBMyPlaylists()V

    .line 522
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->parseDefaultSubsPlaylists()V

    .line 523
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v0, :cond_1b

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "tab"

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    if-eqz v0, :cond_1b

    .line 524
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->checkBundle()V

    goto/16 :goto_8

    .line 525
    :cond_1b
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getOpenTimeCount(Landroid/content/Context;)I

    goto :goto_a

    .line 674
    :catch_1
    move-exception v0

    .line 675
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    goto/16 :goto_9

    :cond_1c
    move v1, v3

    goto/16 :goto_4
.end method

.method public onCreateOptionsMenu(Lcom/actionbarsherlock/view/Menu;)Z
    .locals 12

    .prologue
    const/4 v11, 0x3

    const/4 v10, 0x2

    const/4 v9, 0x6

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 3594
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->menu:Lcom/actionbarsherlock/view/Menu;

    .line 3595
    sput-object p0, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->ctx:Landroid/content/Context;

    .line 3597
    const-string v0, "layout_inflater"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 3598
    const v1, 0x7f030017

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 3599
    invoke-virtual {v2, v8}, Landroid/view/View;->setFocusable(Z)V

    .line 3605
    const v0, 0x7f070049

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/AutoCompleteTextView;

    .line 3606
    const v1, 0x7f07004a

    invoke-virtual {v2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 3607
    invoke-virtual {v0, v8}, Landroid/widget/AutoCompleteTextView;->setThreshold(I)V

    .line 3610
    new-instance v3, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;

    const v4, 0x109000a

    invoke-direct {v3, p0, p0, v4}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;I)V

    invoke-virtual {v0, v3}, Landroid/widget/AutoCompleteTextView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 3612
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f08013e

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 3613
    new-instance v4, Landroid/text/SpannableString;

    invoke-direct {v4, v3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 3614
    new-instance v5, Landroid/text/style/RelativeSizeSpan;

    const v6, 0x3f333333    # 0.7f

    invoke-direct {v5, v6}, Landroid/text/style/RelativeSizeSpan;-><init>(F)V

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v6, 0x21

    invoke-virtual {v4, v5, v7, v3, v6}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 3615
    invoke-virtual {v0, v4}, Landroid/widget/AutoCompleteTextView;->setHint(Ljava/lang/CharSequence;)V

    .line 3617
    new-instance v3, Lcom/mixerbox/mixerbox3b/MainPage$43;

    invoke-direct {v3, p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage$43;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/widget/AutoCompleteTextView;)V

    invoke-virtual {v0, v3}, Landroid/widget/AutoCompleteTextView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 3624
    new-instance v3, Lcom/mixerbox/mixerbox3b/MainPage$44;

    invoke-direct {v3, p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage$44;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/widget/AutoCompleteTextView;)V

    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 3631
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$45;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$45;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 3659
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0800e0

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v7, v10, v10, v0}, Lcom/actionbarsherlock/view/Menu;->addSubMenu(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/SubMenu;

    move-result-object v0

    .line 3661
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v3, 0x7f080064

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v7, v9, v9, v1}, Lcom/actionbarsherlock/view/SubMenu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    .line 3663
    const/4 v1, 0x7

    const/4 v3, 0x7

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f080071

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v7, v1, v3, v4}, Lcom/actionbarsherlock/view/SubMenu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    .line 3665
    const/16 v1, 0x8

    const/16 v3, 0x8

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0800e1

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v7, v1, v3, v4}, Lcom/actionbarsherlock/view/SubMenu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    .line 3668
    const/16 v1, 0xa

    const/16 v3, 0xa

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f080093

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v7, v1, v3, v4}, Lcom/actionbarsherlock/view/SubMenu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    .line 3670
    const/16 v1, 0xc

    const/16 v3, 0xc

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f080053

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v7, v1, v3, v4}, Lcom/actionbarsherlock/view/SubMenu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    .line 3672
    const/16 v1, 0xb

    const/16 v3, 0xb

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f080100

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v7, v1, v3, v4}, Lcom/actionbarsherlock/view/SubMenu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    .line 3675
    invoke-interface {v0}, Lcom/actionbarsherlock/view/SubMenu;->getItem()Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    .line 3676
    invoke-interface {v0, v9}, Lcom/actionbarsherlock/view/MenuItem;->setShowAsAction(I)V

    .line 3678
    const/16 v0, 0x3e7

    const/16 v1, 0x3e7

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f08008e

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {p1, v7, v0, v1, v3}, Lcom/actionbarsherlock/view/Menu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    const v1, 0x7f020100

    invoke-interface {v0, v1}, Lcom/actionbarsherlock/view/MenuItem;->setIcon(I)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v2}, Lcom/actionbarsherlock/view/MenuItem;->setActionView(Landroid/view/View;)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    const/16 v1, 0x9

    invoke-interface {v0, v1}, Lcom/actionbarsherlock/view/MenuItem;->setShowAsAction(I)V

    .line 3682
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080067

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v7, v8, v8, v0}, Lcom/actionbarsherlock/view/Menu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    const v1, 0x7f0200e8

    invoke-interface {v0, v1}, Lcom/actionbarsherlock/view/MenuItem;->setIcon(I)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v8}, Lcom/actionbarsherlock/view/MenuItem;->setShowAsAction(I)V

    .line 3685
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080070

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v7, v11, v11, v0}, Lcom/actionbarsherlock/view/Menu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    const v1, 0x7f0200de

    invoke-interface {v0, v1}, Lcom/actionbarsherlock/view/MenuItem;->setIcon(I)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v8}, Lcom/actionbarsherlock/view/MenuItem;->setShowAsAction(I)V

    .line 3689
    const/16 v0, 0xd

    const/16 v1, 0xd

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800e9

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, v7, v0, v1, v2}, Lcom/actionbarsherlock/view/Menu;->add(IIILjava/lang/CharSequence;)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    invoke-interface {v0, v9}, Lcom/actionbarsherlock/view/MenuItem;->setShowAsAction(I)V

    .line 3693
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-nez v0, :cond_0

    .line 3694
    invoke-static {p1, v8}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 3695
    :cond_0
    invoke-static {p1, v10}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 3696
    invoke-static {p1, v11}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 3697
    const/4 v0, 0x7

    invoke-static {p1, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 3698
    const/16 v0, 0x8

    invoke-static {p1, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 3699
    const/16 v0, 0xd

    invoke-static {p1, v0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->hideOption(Lcom/actionbarsherlock/view/Menu;I)V

    .line 3701
    const/16 v0, 0x3e7

    invoke-interface {p1, v0}, Lcom/actionbarsherlock/view/Menu;->findItem(I)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    .line 3702
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$46;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$46;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-interface {v0, v1}, Lcom/actionbarsherlock/view/MenuItem;->setOnActionExpandListener(Lcom/actionbarsherlock/view/MenuItem$OnActionExpandListener;)Lcom/actionbarsherlock/view/MenuItem;

    .line 3717
    return v8
.end method

.method public onDestroy()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 4225
    :try_start_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "isLogIn"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetLocalNotification:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canSetLocalNotification:Z

    if-eqz v0, :cond_0

    .line 4226
    const-string v0, "SET LOCAL NOTIFICATION"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4227
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetLocalNotification:Z

    .line 4228
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setLocalNotification()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 4233
    :cond_0
    :goto_0
    const-string v0, "ON DESTROY"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4234
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0}, Lcom/facebook/UiLifecycleHelper;->onDestroy()V

    .line 4235
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "about:blank"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 4236
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isForeground:Z

    .line 4238
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->isShown()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 4239
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->performClick()Z

    .line 4242
    :cond_1
    const-string v0, "alarm"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 4243
    new-instance v1, Landroid/content/Intent;

    const-string v2, "SleepService"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 4244
    invoke-static {p0, v3, v1, v3}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 4245
    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 4247
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mReceiver:Lcom/mixerbox/mixerbox3b/services/PlayerReceiver;

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 4248
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->sr:Lcom/mixerbox/mixerbox3b/services/SleepReceiver;

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 4249
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myReceiver:Lcom/mixerbox/mixerbox3b/MainPage$MusicIntentReceiver;

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 4250
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->earphoneReceiver:Lcom/mixerbox/mixerbox3b/services/EarphoneReceiver;

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 4251
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->r:Lcom/mixerbox/mixerbox3b/services/MyReceiver;

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 4252
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->am:Landroid/media/AudioManager;

    new-instance v1, Landroid/content/ComponentName;

    const-class v2, Lcom/mixerbox/mixerbox3b/services/RemoteControlReceiver;

    invoke-direct {v1, p0, v2}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->unregisterMediaButtonEventReceiver(Landroid/content/ComponentName;)V

    .line 4253
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopPlayer()V

    .line 4254
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->closeDB()V

    .line 4255
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/ImageLoader;->clearDiscCache()V

    .line 4256
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->adView:Lcom/google/android/gms/ads/AdView;

    invoke-virtual {v0}, Lcom/google/android/gms/ads/AdView;->destroy()V

    .line 4258
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    if-eqz v0, :cond_2

    .line 4259
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->conn:Landroid/content/ServiceConnection;

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->unbindService(Landroid/content/ServiceConnection;)V

    .line 4260
    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    .line 4263
    :try_start_1
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-eq v0, v4, :cond_3

    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    const/4 v1, 0x3

    if-eq v0, v1, :cond_3

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v0, :cond_3

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "isLogIn"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetLocalNotification:Z

    if-nez v0, :cond_3

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canSetLocalNotification:Z

    if-eqz v0, :cond_3

    .line 4265
    const-string v0, "SET LOCAL NOTIFICATION"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4266
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetLocalNotification:Z

    .line 4267
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setLocalNotification()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 4271
    :cond_3
    :goto_1
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onDestroy()V

    .line 4272
    return-void

    :catch_0
    move-exception v0

    goto :goto_1

    :catch_1
    move-exception v0

    goto/16 :goto_0
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 4144
    const-string v0, "ON NEW INTENT"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4145
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 4146
    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage;->setIntent(Landroid/content/Intent;)V

    .line 4149
    :try_start_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 4150
    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v1, :cond_0

    .line 4151
    new-instance v0, Landroid/os/Bundle;

    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    invoke-direct {v0, v1}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 4152
    :cond_0
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 4153
    sput-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v1, :cond_1

    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v2, "isLogIn"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    const-string v1, "isLogIn"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 4154
    sget-object v1, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v2, "isLogIn"

    const-string v3, "isLogIn"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    invoke-virtual {v1, v2, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 4155
    :cond_1
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->checkBundle()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4161
    :goto_0
    return-void

    .line 4157
    :catch_0
    move-exception v0

    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/MixerBox;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 4158
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 4159
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z
    .locals 9

    .prologue
    const/4 v4, 0x0

    const v5, 0x7f0800e9

    const/4 v2, 0x1

    .line 3722
    invoke-interface {p1}, Lcom/actionbarsherlock/view/MenuItem;->getItemId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 3853
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onOptionsItemSelected(Lcom/actionbarsherlock/view/MenuItem;)Z

    move-result v2

    :cond_0
    :goto_0
    :sswitch_0
    return v2

    .line 3724
    :sswitch_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->size()I

    move-result v0

    if-le v0, v2, :cond_0

    .line 3725
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->backToPreviousFragment()V

    goto :goto_0

    .line 3728
    :sswitch_2
    invoke-interface {p1}, Lcom/actionbarsherlock/view/MenuItem;->getActionView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f070049

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/AutoCompleteTextView;

    .line 3729
    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/AutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 3732
    :sswitch_3
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f08010f

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 3733
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v4

    .line 3734
    const/4 v0, 0x2

    invoke-virtual {v4, v0}, Ljava/util/Calendar;->get(I)I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    .line 3735
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3736
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-ne v1, v2, :cond_1

    .line 3737
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "0"

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3738
    :cond_1
    const/4 v1, 0x5

    invoke-virtual {v4, v1}, Ljava/util/Calendar;->get(I)I

    move-result v1

    .line 3739
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, ""

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 3740
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v5

    if-ne v5, v2, :cond_2

    .line 3741
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "0"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 3742
    :cond_2
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, " ("

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v4, v2}, Ljava/util/Calendar;->get(I)I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ")"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3743
    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;

    invoke-direct {v1, p0, v2, v0}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;-><init>(Landroid/content/Context;ILjava/lang/String;)V

    .line 3744
    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/dialogs/CreatePlaylistDialog;->show()Landroid/app/AlertDialog;

    goto/16 :goto_0

    .line 3747
    :sswitch_4
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 3748
    const-string v3, "id"

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3749
    const-string v0, "action:playlist_edit"

    invoke-static {v0, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0

    .line 3752
    :sswitch_5
    const-string v0, "action:invite_friends"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 3753
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->sendRequestDialog()V

    goto/16 :goto_0

    .line 3756
    :sswitch_6
    new-instance v1, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, p0, v0}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 3758
    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/dialogs/RenamePlaylistDialog;->show()Landroid/app/AlertDialog;

    goto/16 :goto_0

    .line 3764
    :sswitch_7
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_3

    .line 3765
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->unsubsPlaylist(Landroid/content/Context;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 3767
    :cond_3
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->deletePlaylist(Ljava/lang/String;)I

    .line 3768
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 3769
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    goto/16 :goto_0

    .line 3773
    :sswitch_8
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v1}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v3

    const/4 v5, 0x0

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;-><init>(Landroid/content/Context;ILjava/lang/String;Lcom/mixerbox/mixerbox3b/classes/SongItem;I)V

    .line 3775
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/RemoveDialog;->show()Landroid/app/AlertDialog;

    goto/16 :goto_0

    .line 3780
    :sswitch_9
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v1

    .line 3781
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    .line 3783
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 3784
    const-string v5, "id"

    invoke-interface {v3, v5, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3785
    const-string v5, "action:share_playlist"

    invoke-static {v5, v3}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 3786
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "http://www.mixerbox.com/list/"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3787
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0800ba

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0800b8

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 3788
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f0800b9

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 3789
    new-instance v6, Landroid/content/Intent;

    const-string v7, "android.intent.action.SEND"

    invoke-direct {v6, v7}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 3790
    const-string v7, "text/plain"

    invoke-virtual {v6, v7}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 3791
    const-string v7, "android.intent.extra.SUBJECT"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3792
    const-string v7, "android.intent.extra.TEXT"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v7, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3793
    invoke-static {v6, v4}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 3796
    :sswitch_a
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setReorder()V

    .line 3797
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstReorder(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3798
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->TipFirstReorderAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 3799
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 3800
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putTipFirstReorder(Landroid/content/Context;)V

    goto/16 :goto_0

    .line 3804
    :sswitch_b
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    iget-object v3, v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->array:Ljava/util/ArrayList;

    .line 3805
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-nez v0, :cond_4

    .line 3806
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    iget-object v4, v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->pid:Ljava/lang/String;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->array:Ljava/util/ArrayList;

    invoke-virtual {v1, v4, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->reorderMyPlaylist(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 3807
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->backToPreviousFragment()V

    .line 3808
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iput-object v3, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    .line 3809
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->notifyDataSetChanged()V

    .line 3810
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 3812
    :cond_4
    new-instance v4, Lcom/loopj/android/http/RequestParams;

    invoke-direct {v4}, Lcom/loopj/android/http/RequestParams;-><init>()V

    .line 3813
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    move v1, v0

    :goto_1
    if-ltz v1, :cond_5

    .line 3814
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "music["

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v5

    sub-int/2addr v5, v1

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "]"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v5, v0}, Lcom/loopj/android/http/RequestParams;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 3813
    add-int/lit8 v0, v1, -0x1

    move v1, v0

    goto :goto_1

    .line 3816
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->pid:Ljava/lang/String;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->reorderUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 3817
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$47;

    invoke-direct {v1, p0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$47;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;)V

    invoke-static {v0, v4, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->post(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 3847
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->backToPreviousFragment()V

    .line 3848
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iput-object v3, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    .line 3849
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->notifyDataSetChanged()V

    goto/16 :goto_0

    .line 3722
    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_3
        0x2 -> :sswitch_4
        0x3 -> :sswitch_5
        0x6 -> :sswitch_6
        0x7 -> :sswitch_0
        0x8 -> :sswitch_7
        0xa -> :sswitch_9
        0xb -> :sswitch_a
        0xc -> :sswitch_8
        0xd -> :sswitch_b
        0x3e7 -> :sswitch_2
        0x102002c -> :sswitch_1
    .end sparse-switch
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 4215
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0}, Lcom/facebook/UiLifecycleHelper;->onPause()V

    .line 4216
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->adView:Lcom/google/android/gms/ads/AdView;

    invoke-virtual {v0}, Lcom/google/android/gms/ads/AdView;->pause()V

    .line 4217
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isForeground:Z

    .line 4218
    const-string v0, "ON PAUSE"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4219
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onPause()V

    .line 4220
    return-void
.end method

.method protected onRestart()V
    .locals 1

    .prologue
    .line 4408
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onRestart()V

    .line 4409
    const-string v0, "ON RESTART"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4410
    return-void
.end method

.method protected onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v1, 0x0

    .line 4169
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onResume()V

    .line 4170
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isForeground:Z

    .line 4171
    const-string v0, "ON RESUME"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4172
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0}, Lcom/facebook/UiLifecycleHelper;->onResume()V

    .line 4173
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->adView:Lcom/google/android/gms/ads/AdView;

    invoke-virtual {v0}, Lcom/google/android/gms/ads/AdView;->resume()V

    .line 4174
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->nm:Landroid/app/NotificationManager;

    const/16 v2, 0x3021

    invoke-virtual {v0, v2}, Landroid/app/NotificationManager;->cancel(I)V

    .line 4175
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetLocalNotification:Z

    .line 4177
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldChangeBackToWebView:Z

    if-eqz v0, :cond_1

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getEnableBackgroundPlay(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 4179
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldChangeBackToWebView:Z

    .line 4181
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    const/4 v2, 0x3

    if-eq v0, v2, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    const/4 v2, 0x2

    if-ne v0, v2, :cond_2

    .line 4183
    :cond_0
    iput v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->resetTime:I

    .line 4185
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldResetTime:Z

    .line 4205
    :cond_1
    :goto_0
    return-void

    .line 4189
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    if-eqz v0, :cond_5

    .line 4190
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->getIsPlaying()Z

    move-result v0

    .line 4191
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->getCurrentTime()I

    move-result v2

    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->resetTime:I

    .line 4194
    :goto_1
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldResetTime:Z

    .line 4195
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->pauseMusic()V

    .line 4196
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->oriVideoId:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 4197
    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_0

    .line 4198
    :cond_3
    if-eqz v0, :cond_4

    .line 4199
    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_0

    .line 4201
    :cond_4
    iput-boolean v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldResetTime:Z

    .line 4202
    iput v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->resetTime:I

    goto :goto_0

    :cond_5
    move v0, v1

    goto :goto_1
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 4209
    invoke-super {p0, p1}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 4210
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->uiHelper:Lcom/facebook/UiLifecycleHelper;

    invoke-virtual {v0, p1}, Lcom/facebook/UiLifecycleHelper;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 4211
    return-void
.end method

.method protected onStart()V
    .locals 1

    .prologue
    .line 4414
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onStart()V

    .line 4415
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isForeground:Z

    .line 4416
    const-string v0, "ON START"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4417
    const-string v0, "Z8QPYZT3PBG8R6ZNSDXQ"

    invoke-static {p0, v0}, Lcom/flurry/android/FlurryAgent;->onStartSession(Landroid/content/Context;Ljava/lang/String;)V

    .line 4418
    return-void
.end method

.method protected onStop()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 4392
    :try_start_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    if-eq v0, v1, :cond_1

    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    const/4 v1, 0x3

    if-eq v0, v1, :cond_1

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    if-eqz v0, :cond_1

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->bundle:Landroid/os/Bundle;

    const-string v1, "isLogIn"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetLocalNotification:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canSetLocalNotification:Z

    if-eqz v0, :cond_1

    .line 4394
    const-string v0, "SET LOCAL NOTIFICATION"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4395
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetLocalNotification:Z

    .line 4396
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setLocalNotification()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4400
    :cond_1
    :goto_0
    const-string v0, "ON STOP"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4401
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isForeground:Z

    .line 4402
    invoke-static {p0}, Lcom/flurry/android/FlurryAgent;->onEndSession(Landroid/content/Context;)V

    .line 4403
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onStop()V

    .line 4404
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method protected onUserLeaveHint()V
    .locals 1

    .prologue
    .line 4381
    const-string v0, "onUserLeaveHint"

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 4382
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 4383
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getEnableBackgroundPlay(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 4384
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->changeToMediaPlayer(Z)V

    .line 4386
    :cond_0
    invoke-super {p0}, Lcom/actionbarsherlock/app/SherlockFragmentActivity;->onUserLeaveHint()V

    .line 4387
    return-void
.end method

.method public onboardingPlayMusic()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x0

    const/16 v2, 0x8

    .line 1976
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_3

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetCanAuto:Z

    if-nez v0, :cond_3

    .line 1977
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlHint:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1978
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v4}, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1979
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1980
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1981
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1990
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-ne v0, v2, :cond_1

    .line 1991
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$32;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$32;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2022
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 2023
    const-string v0, "audio"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/media/AudioManager;

    .line 2024
    const/4 v1, 0x3

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2, v3}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 2025
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusicWithoutShowingPage(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;)V

    .line 2027
    :cond_2
    return-void

    .line 1982
    :cond_3
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    if-nez v0, :cond_0

    .line 1983
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvSwitch:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 1984
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v4}, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 1985
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1986
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1987
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public onboardingSubscribeArtists()Ljava/util/ArrayList;
    .locals 17

    .prologue
    .line 686
    new-instance v13, Ljava/util/ArrayList;

    invoke-direct {v13}, Ljava/util/ArrayList;-><init>()V

    .line 688
    invoke-virtual/range {p0 .. p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    if-eqz v1, :cond_7

    invoke-virtual/range {p0 .. p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "fav_artists"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_7

    .line 689
    const-string v1, "artists.json"

    move-object/from16 v0, p0

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->loadJSONFromAsset(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 690
    sget-object v2, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v4

    .line 691
    new-instance v14, Lorg/json/JSONArray;

    invoke-direct {v14}, Lorg/json/JSONArray;-><init>()V

    .line 692
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 694
    :try_start_0
    new-instance v5, Lorg/json/JSONArray;

    invoke-direct {v5, v1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 695
    invoke-virtual/range {p0 .. p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v3, "fav_artists"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getStringArrayList(Ljava/lang/String;)Ljava/util/ArrayList;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 696
    const/4 v1, 0x0

    move v3, v1

    :goto_0
    :try_start_1
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v3, v1, :cond_2

    .line 697
    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v4, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 698
    const/4 v1, 0x0

    :goto_1
    invoke-virtual {v5}, Lorg/json/JSONArray;->length()I

    move-result v6

    if-ge v1, v6, :cond_0

    .line 700
    invoke-virtual {v5, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    .line 701
    const-string v7, "artistName"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    const-string v7, "representativePlaylist"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    const-string v7, "representativePlaylist"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    const-string v8, "size"

    invoke-virtual {v7, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 703
    const-string v7, "artistName"

    invoke-virtual {v6, v7}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    sget-object v8, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-virtual {v7, v8}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 705
    const-string v1, "representativePlaylist"

    invoke-virtual {v6, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    invoke-virtual {v14, v1}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_2

    .line 696
    :cond_0
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_0

    .line 699
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    :cond_2
    move-object v11, v2

    .line 713
    :goto_2
    const/4 v1, 0x0

    move v12, v1

    :goto_3
    invoke-virtual {v14}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-ge v12, v1, :cond_5

    .line 715
    :try_start_2
    invoke-virtual {v14, v12}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v15

    .line 716
    const-string v1, "ref"

    invoke-virtual {v15, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "title"

    invoke-virtual {v15, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "owner"

    invoke-virtual {v15, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "size"

    invoke-virtual {v15, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "thumbnailHQ"

    invoke-virtual {v15, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    const-string v1, "ownerId"

    invoke-virtual {v15, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    move-result v1

    if-eqz v1, :cond_4

    .line 713
    :cond_3
    :goto_4
    add-int/lit8 v1, v12, 0x1

    move v12, v1

    goto :goto_3

    .line 710
    :catch_0
    move-exception v1

    move-object/from16 v16, v1

    move-object v1, v2

    move-object/from16 v2, v16

    .line 711
    :goto_5
    invoke-virtual {v2}, Lorg/json/JSONException;->printStackTrace()V

    move-object v11, v1

    goto :goto_2

    .line 719
    :cond_4
    :try_start_3
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v2, "ref"

    invoke-virtual {v15, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v15, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "ownerId"

    invoke-virtual {v15, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "owner"

    invoke-virtual {v15, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "size"

    invoke-virtual {v15, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    const-string v8, "thumbnailHQ"

    invoke-virtual {v15, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x2

    const/4 v10, 0x1

    invoke-direct/range {v1 .. v10}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 722
    const/4 v2, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V

    .line 724
    const-string v1, "owner"

    invoke-virtual {v15, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v13, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_4

    .line 725
    :catch_1
    move-exception v1

    .line 726
    invoke-virtual {v1}, Lorg/json/JSONException;->printStackTrace()V

    goto :goto_4

    .line 729
    :cond_5
    invoke-virtual/range {p0 .. p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "hasPickedArtist"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 730
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 731
    const-string v2, "artists"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 732
    const-string v2, "playlists"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v14}, Lorg/json/JSONArray;->length()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 733
    const-string v2, "action:local_artist_auto_subscribe"

    invoke-static {v2, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 735
    :cond_6
    new-instance v1, Ljava/lang/Thread;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rLocalNotificationList:Ljava/lang/Runnable;

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 737
    :cond_7
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    .line 738
    return-object v13

    .line 710
    :catch_2
    move-exception v1

    move-object/from16 v16, v1

    move-object v1, v2

    move-object/from16 v2, v16

    goto/16 :goto_5
.end method

.method public parseDBMyPlaylists()V
    .locals 14

    .prologue
    .line 3504
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 3505
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 3508
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 3509
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 3513
    :goto_1
    iget-object v10, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, "-999"

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800a1

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    const-string v4, ""

    const-string v5, "0"

    const-string v6, ""

    const-string v7, ""

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3516
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getMyPlaylist()Landroid/database/Cursor;

    move-result-object v11

    .line 3517
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v12

    .line 3518
    invoke-interface {v11}, Landroid/database/Cursor;->moveToLast()Z

    .line 3519
    const/4 v0, 0x0

    move v10, v0

    :goto_2
    if-ge v10, v12, :cond_2

    .line 3520
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const/4 v1, 0x0

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getSongCount(Ljava/lang/String;)I

    move-result v5

    .line 3521
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const/4 v1, 0x0

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getPlaylistCover(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 3522
    iget-object v13, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const/4 v1, 0x0

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x3

    invoke-interface {v11, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x4

    invoke-interface {v11, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-static {v5}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x6

    invoke-interface {v11, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/16 v8, 0x8

    invoke-interface {v11, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v8

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3524
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    const/4 v1, 0x0

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3525
    invoke-interface {v11}, Landroid/database/Cursor;->moveToPrevious()Z

    .line 3519
    add-int/lit8 v0, v10, 0x1

    move v10, v0

    goto :goto_2

    .line 3507
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    goto/16 :goto_0

    .line 3511
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    goto/16 :goto_1

    .line 3527
    :cond_2
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    .line 3529
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://i.ytimg.com/vi/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getLastHistory()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/mqdefault.jpg"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 3530
    iget-object v10, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMyPlaylists:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, "PLAYLISTHISTORYID"

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080111

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    const-string v3, ""

    const-string v4, ""

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, ""

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v8, "PLAYLISTHISTORYID"

    invoke-virtual {v6, v8}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getSongCount(Ljava/lang/String;)I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const-string v6, ""

    const/4 v8, 0x6

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3533
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->checkMP3CountAndLoad()V

    .line 3534
    return-void
.end method

.method public parseDefaultSubsPlaylists()V
    .locals 14

    .prologue
    .line 3537
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 3538
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 3541
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 3542
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 3545
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getPlaylistCount()I

    move-result v0

    if-nez v0, :cond_4

    .line 3548
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080154

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 3549
    const-string v1, "array"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v11

    .line 3550
    const/4 v0, 0x0

    move v10, v0

    :goto_2
    invoke-virtual {v11}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v10, v0, :cond_3

    .line 3551
    invoke-virtual {v11, v10}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v12

    .line 3553
    const-string v0, "cover"

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 3554
    const-string v0, "cover"

    invoke-virtual {v12, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 3557
    :goto_3
    iget-object v13, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const-string v1, "_id"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "name"

    invoke-virtual {v12, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "owner"

    invoke-virtual {v12, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "ownerName"

    invoke-virtual {v12, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "itemCount"

    invoke-virtual {v12, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "subsCnt"

    invoke-virtual {v12, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const/4 v8, 0x2

    const/4 v9, 0x0

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3560
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const-string v1, "_id"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3561
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    const-string v1, "_id"

    invoke-virtual {v12, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "name"

    invoke-virtual {v12, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "owner"

    invoke-virtual {v12, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "ownerName"

    invoke-virtual {v12, v4}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "itemCount"

    invoke-virtual {v12, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "subsCnt"

    invoke-virtual {v12, v6}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    const/4 v8, 0x2

    const/4 v9, 0x0

    invoke-virtual/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->addPlaylist(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 3550
    add-int/lit8 v0, v10, 0x1

    move v10, v0

    goto/16 :goto_2

    .line 3540
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    goto/16 :goto_0

    .line 3544
    :cond_1
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    goto/16 :goto_1

    .line 3556
    :cond_2
    :try_start_1
    const-string v7, ""
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_3

    .line 3565
    :catch_0
    move-exception v0

    .line 3566
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 3583
    :cond_3
    :goto_4
    return-void

    .line 3569
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getPlaylist()Landroid/database/Cursor;

    move-result-object v11

    .line 3570
    invoke-interface {v11}, Landroid/database/Cursor;->getCount()I

    move-result v12

    .line 3571
    invoke-interface {v11}, Landroid/database/Cursor;->moveToLast()Z

    .line 3572
    const/4 v0, 0x0

    move v10, v0

    :goto_5
    if-ge v10, v12, :cond_6

    .line 3573
    const/4 v9, 0x0

    .line 3574
    const/16 v0, 0x9

    invoke-interface {v11, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_5

    .line 3575
    const/4 v9, 0x1

    .line 3576
    :cond_5
    iget-object v13, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    const/4 v1, 0x1

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    invoke-interface {v11, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x3

    invoke-interface {v11, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x4

    invoke-interface {v11, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x5

    invoke-interface {v11, v5}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x6

    invoke-interface {v11, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x7

    invoke-interface {v11, v7}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    const/16 v8, 0x8

    invoke-interface {v11, v8}, Landroid/database/Cursor;->getInt(I)I

    move-result v8

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v13, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3578
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    const/4 v1, 0x1

    invoke-interface {v11, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3579
    invoke-interface {v11}, Landroid/database/Cursor;->moveToPrevious()Z

    .line 3572
    add-int/lit8 v0, v10, 0x1

    move v10, v0

    goto :goto_5

    .line 3581
    :cond_6
    invoke-interface {v11}, Landroid/database/Cursor;->close()V

    goto :goto_4
.end method

.method public playLocalMusic()V
    .locals 8

    .prologue
    const/4 v4, 0x4

    const/16 v7, 0x8

    const/4 v3, -0x1

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 2067
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    if-nez v0, :cond_0

    .line 2068
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvSwitch:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 2069
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setWebViewTouchListener()V

    .line 2071
    :cond_0
    iput-boolean v6, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldCheckNotificationBtn:Z

    .line 2072
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->am:Landroid/media/AudioManager;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    const/4 v2, 0x3

    invoke-virtual {v0, v1, v2, v6}, Landroid/media/AudioManager;->requestAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I

    .line 2073
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200ed

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 2074
    const v0, 0x7f0700be

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 2075
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 2076
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnQuality:Landroid/widget/ImageButton;

    invoke-virtual {v0, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 2077
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnAdd:Landroid/widget/ImageButton;

    invoke-virtual {v0, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 2078
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnShare:Landroid/widget/ImageButton;

    invoke-virtual {v0, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 2079
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-ne v0, v7, :cond_1

    .line 2080
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$34;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$34;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2109
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    invoke-virtual {v0, v6}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 2110
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    const-wide/16 v1, 0xfa0

    invoke-virtual {v0, v6, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 2111
    iput-boolean v6, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    .line 2112
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->sendNotification()V

    .line 2114
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistType()I

    move-result v0

    if-ne v0, v7, :cond_7

    .line 2116
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2117
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v0, v5, v5, v5, v5}, Landroid/widget/ImageView;->setPadding(IIII)V

    .line 2118
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playerHeight:I

    div-int/lit8 v0, v0, 0x8

    .line 2120
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getMP3Thumbnail(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 2121
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v2

    if-lez v2, :cond_6

    .line 2122
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 2124
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v2, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 2125
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 2130
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivSoundCloud:Landroid/widget/ImageView;

    invoke-virtual {v0, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2132
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_2

    .line 2134
    :try_start_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_3

    .line 2138
    :cond_2
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongTime()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setSongTime(I)V

    .line 2139
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_3

    .line 2140
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 2141
    :cond_3
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_4

    .line 2142
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 2143
    :cond_4
    const/4 v0, 0x0

    sput-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 2144
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 2146
    :try_start_1
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 2147
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/services/MyService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2148
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 2151
    :goto_2
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 2152
    const-string v1, "source"

    const-string v2, "mp3"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2153
    const-string v1, "action:videos_played"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 2202
    :cond_5
    :goto_3
    return-void

    .line 2127
    :cond_6
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    const v2, 0x7f02011d

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 2128
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    mul-int/lit8 v2, v0, 0x3

    mul-int/lit8 v3, v0, 0x3

    mul-int/lit8 v4, v0, 0x3

    mul-int/lit8 v0, v0, 0x3

    invoke-virtual {v1, v2, v3, v4, v0}, Landroid/widget/ImageView;->setPadding(IIII)V

    goto :goto_0

    .line 2154
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_5

    .line 2155
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2156
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v0, v5, v5, v5, v5}, Landroid/widget/ImageView;->setPadding(IIII)V

    .line 2157
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    const v1, 0x7f02011d

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 2158
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongThumbnail()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_c

    .line 2159
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 2161
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 2162
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongThumbnail()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 2163
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v0, v5, v5, v5, v5}, Landroid/widget/ImageView;->setPadding(IIII)V

    .line 2168
    :goto_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivSoundCloud:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2169
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_8

    .line 2171
    :try_start_2
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    .line 2175
    :cond_8
    :goto_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongTime()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setSongTime(I)V

    .line 2176
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_9

    .line 2177
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 2178
    :cond_9
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_a

    .line 2179
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 2180
    :cond_a
    const/4 v0, 0x0

    sput-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 2181
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 2183
    :try_start_3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "https://api.soundcloud.com/tracks/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/stream?client_id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->SOUNDCLOUD_ID:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 2185
    sget-object v1, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v1, v0}, Landroid/media/MediaPlayer;->setDataSource(Ljava/lang/String;)V

    .line 2186
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/services/MyService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2187
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    .line 2190
    :goto_6
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 2191
    const-string v1, "source"

    const-string v2, "soundcloud"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2192
    const-string v1, "action:videos_played"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 2194
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getRequestedOrientation()I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_b

    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    if-ne v0, v6, :cond_b

    .line 2196
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setFullScreen()V

    .line 2199
    :cond_b
    new-instance v0, Ljava/lang/Thread;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rCheckHistory:Ljava/lang/Runnable;

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto/16 :goto_3

    .line 2165
    :cond_c
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playerHeight:I

    div-int/lit8 v0, v0, 0x8

    .line 2166
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    mul-int/lit8 v2, v0, 0x3

    mul-int/lit8 v3, v0, 0x3

    mul-int/lit8 v4, v0, 0x3

    mul-int/lit8 v0, v0, 0x3

    invoke-virtual {v1, v2, v3, v4, v0}, Landroid/widget/ImageView;->setPadding(IIII)V

    goto/16 :goto_4

    :catch_0
    move-exception v0

    goto :goto_6

    :catch_1
    move-exception v0

    goto/16 :goto_5

    :catch_2
    move-exception v0

    goto/16 :goto_2

    :catch_3
    move-exception v0

    goto/16 :goto_1
.end method

.method public playMusic(Z)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x2

    const/16 v5, 0x8

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 2205
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canPlay:Z

    if-nez v0, :cond_0

    .line 2351
    :goto_0
    return-void

    .line 2208
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    if-ne v0, v6, :cond_2

    .line 2210
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 2211
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->playLocalMusic()V

    goto :goto_0

    .line 2215
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_3

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldChangeBackToWebView:Z

    if-eqz v0, :cond_3

    .line 2216
    iput-boolean v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isBackground:Z

    .line 2217
    invoke-virtual {p0, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->changeToMediaPlayer(Z)V

    .line 2218
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v1, "javascript:pauseVideo()"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0

    .line 2222
    :cond_3
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isBackground:Z

    .line 2223
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_4

    .line 2224
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 2225
    :cond_4
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_5

    .line 2226
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 2227
    :cond_5
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_6

    .line 2228
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 2229
    :cond_6
    sput-object v7, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 2230
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 2231
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivSoundCloud:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2233
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 2234
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopPlayer()V

    goto :goto_0

    .line 2237
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvNoInternet:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    if-nez v0, :cond_8

    .line 2238
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvNoInternet:Landroid/widget/TextView;

    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 2241
    :cond_8
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_a

    .line 2242
    :cond_9
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080049

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto/16 :goto_0

    .line 2246
    :cond_a
    sget-boolean v0, Lcom/mixerbox/mixerbox3b/MainPage;->isPageLoaded:Z

    if-nez v0, :cond_b

    .line 2247
    iput-boolean v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlayAfterReady:Z

    .line 2248
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    invoke-virtual {v0, v6}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 2249
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    const-wide/16 v1, 0x1388

    invoke-virtual {v0, v6, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    goto/16 :goto_0

    .line 2251
    :cond_b
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isReady:Z

    if-nez v0, :cond_c

    .line 2252
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080074

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, v4}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 2253
    iput-boolean v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlayAfterReady:Z

    goto/16 :goto_0

    .line 2257
    :cond_c
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->errorCount:I

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/lit8 v1, v1, 0x2

    if-le v0, v1, :cond_d

    .line 2258
    iput v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->errorCount:I

    goto/16 :goto_0

    .line 2262
    :cond_d
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getRequestedOrientation()I

    move-result v0

    const/4 v1, 0x6

    if-ne v0, v1, :cond_e

    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    if-ne v0, v4, :cond_e

    .line 2264
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setFullScreen()V

    .line 2267
    :cond_e
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    invoke-virtual {v0, v4}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 2268
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    const-wide/16 v1, 0xfa0

    invoke-virtual {v0, v4, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 2270
    if-eqz p1, :cond_f

    .line 2271
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->showPlayerGuide()V

    .line 2274
    :cond_f
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 2275
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnQuality:Landroid/widget/ImageButton;

    invoke-virtual {v0, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 2276
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnAdd:Landroid/widget/ImageButton;

    invoke-virtual {v0, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 2277
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnShare:Landroid/widget/ImageButton;

    invoke-virtual {v0, v3}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 2279
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlayAfterReady:Z

    .line 2280
    iput-boolean v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    .line 2282
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->sendNotification()V

    .line 2284
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 2285
    const-string v1, "f"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2286
    const-string v1, "source"

    const-string v2, "youtube"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2287
    const-string v1, "action:videos_played"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 2289
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->am:Landroid/media/AudioManager;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    const/4 v2, 0x3

    invoke-virtual {v0, v1, v2, v4}, Landroid/media/AudioManager;->requestAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I

    .line 2291
    iput v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentTime:I

    .line 2293
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    if-ne v0, v6, :cond_12

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->hasSetCanAuto:Z

    if-nez v0, :cond_12

    .line 2294
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlHint:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2295
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v7}, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 2296
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2297
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2298
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 2307
    :cond_10
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200ed

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 2308
    const v0, 0x7f0700be

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 2309
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 2310
    const v0, 0x7f0700cb

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 2311
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongTime()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongTime(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 2312
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-ne v0, v5, :cond_11

    .line 2313
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$35;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$35;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 2343
    :cond_11
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->seekbar:Landroid/widget/SeekBar;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongTime()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setMax(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 2347
    :goto_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:loadVideoById(\'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongYtId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\',0)"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 2349
    new-instance v0, Ljava/lang/Thread;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rCheckHistory:Ljava/lang/Runnable;

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto/16 :goto_0

    .line 2299
    :cond_12
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    if-nez v0, :cond_10

    .line 2300
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvSwitch:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 2301
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v7}, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 2302
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2303
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 2304
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_1

    .line 2345
    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->seekbar:Landroid/widget/SeekBar;

    const/16 v1, 0x258

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setMax(I)V

    goto :goto_2
.end method

.method playMusicWithoutShowingPage(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;)V
    .locals 3

    .prologue
    .line 2030
    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSongUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 2031
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/MainPage$33;

    invoke-direct {v2, p0, p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$33;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 2046
    return-void
.end method

.method public playNextSong()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 2937
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 2964
    :cond_0
    :goto_0
    return-void

    .line 2939
    :cond_1
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_REPEAT:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_3

    .line 2941
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-eqz v0, :cond_0

    .line 2943
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    add-int/lit8 v0, v0, 0x1

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    rem-int/2addr v0, v1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 2945
    sget-boolean v0, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_SHUFFLE:Z

    if-eqz v0, :cond_2

    .line 2946
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    invoke-direct {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getShuffleIndex(I)I

    move-result v0

    .line 2947
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 2949
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    rem-int/2addr v0, v1

    .line 2950
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 2951
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_0

    .line 2953
    :cond_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 2954
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_0

    .line 2957
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-eqz v0, :cond_0

    .line 2959
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_4

    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    if-gez v0, :cond_5

    .line 2960
    :cond_4
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 2961
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 2962
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_0
.end method

.method public playPreviousSong()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 2967
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 2998
    :cond_0
    :goto_0
    return-void

    .line 2969
    :cond_1
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_REPEAT:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_5

    .line 2971
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 2972
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-eqz v0, :cond_0

    .line 2974
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    if-gez v0, :cond_2

    .line 2975
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 2976
    :cond_2
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-lt v0, v1, :cond_3

    .line 2977
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 2979
    :cond_3
    sget-boolean v0, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_SHUFFLE:Z

    if-eqz v0, :cond_4

    .line 2980
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    invoke-direct {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getShuffleIndex(I)I

    move-result v0

    .line 2981
    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 2983
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    rem-int/2addr v0, v1

    .line 2984
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 2985
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_0

    .line 2987
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 2988
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto :goto_0

    .line 2991
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-eqz v0, :cond_0

    .line 2993
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v0, v1, :cond_6

    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    if-gez v0, :cond_7

    .line 2994
    :cond_6
    iput v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    .line 2995
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayPlayingSong:Ljava/util/ArrayList;

    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSongIndex:I

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/SongItem;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    .line 2996
    invoke-virtual {p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->playMusic(Z)V

    goto/16 :goto_0
.end method

.method public removeAds()V
    .locals 5

    .prologue
    const/4 v4, -0x1

    const/4 v3, 0x0

    .line 2688
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->adView:Lcom/google/android/gms/ads/AdView;

    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, 0x3

    invoke-direct {v1, v4, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Lcom/google/android/gms/ads/AdView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 2689
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v1, -0x2

    invoke-direct {v0, v4, v1}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 2691
    invoke-virtual {v0, v3, v3, v3, v3}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 2692
    const/16 v1, 0xc

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 2693
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 2694
    return-void
.end method

.method sendNotification()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 1758
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v2}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v2

    const/16 v3, 0x8

    if-eq v2, v3, :cond_0

    iget-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldCloseApp:Z

    if-eq v2, v0, :cond_0

    iget-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldSendNoti:Z

    if-nez v2, :cond_1

    .line 1759
    :cond_0
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopPlayer()V

    .line 1821
    :goto_0
    return-void

    .line 1765
    :cond_1
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v2

    const/4 v3, 0x3

    if-eq v2, v3, :cond_2

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v2

    const/4 v3, 0x2

    if-ne v2, v3, :cond_5

    .line 1767
    :cond_2
    sget-object v2, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v2, :cond_3

    .line 1768
    sget-object v2, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v2}, Landroid/media/MediaPlayer;->isPlaying()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1787
    :cond_3
    :goto_1
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/mixerbox/mixerbox3b/MainPage$31;

    invoke-direct {v2, p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage$31;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Z)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    goto :goto_0

    :cond_4
    move v0, v1

    .line 1771
    goto :goto_1

    .line 1774
    :cond_5
    iget-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldChangeBackToWebView:Z

    if-eqz v2, :cond_6

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    if-eqz v2, :cond_6

    iget-boolean v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isBackground:Z

    if-eqz v2, :cond_6

    .line 1775
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    invoke-virtual {v2}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->getIsPlaying()Z

    move-result v2

    if-nez v2, :cond_3

    move v0, v1

    .line 1778
    goto :goto_1

    .line 1780
    :cond_6
    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldPlay:I

    if-eq v2, v0, :cond_3

    move v0, v1

    .line 1783
    goto :goto_1
.end method

.method public sendRequestDialog()V
    .locals 4

    .prologue
    .line 3953
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 3954
    const-string v1, "message"

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080080

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 3956
    new-instance v1, Lcom/facebook/widget/WebDialog$RequestsDialogBuilder;

    invoke-static {}, Lcom/facebook/Session;->getActiveSession()Lcom/facebook/Session;

    move-result-object v2

    invoke-direct {v1, p0, v2, v0}, Lcom/facebook/widget/WebDialog$RequestsDialogBuilder;-><init>(Landroid/content/Context;Lcom/facebook/Session;Landroid/os/Bundle;)V

    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$49;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$49;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v1, v0}, Lcom/facebook/widget/WebDialog$RequestsDialogBuilder;->setOnCompleteListener(Lcom/facebook/widget/WebDialog$OnCompleteListener;)Lcom/facebook/widget/WebDialog$BuilderBase;

    move-result-object v0

    check-cast v0, Lcom/facebook/widget/WebDialog$RequestsDialogBuilder;

    invoke-virtual {v0}, Lcom/facebook/widget/WebDialog$RequestsDialogBuilder;->build()Lcom/facebook/widget/WebDialog;

    move-result-object v0

    .line 3963
    invoke-virtual {v0}, Lcom/facebook/widget/WebDialog;->show()V

    .line 3964
    return-void
.end method

.method setBottomTabBackground()V
    .locals 3

    .prologue
    const v2, 0x7f06001b

    const v1, 0x7f02007a

    .line 3347
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlaylists:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3348
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnNewsfeed:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3349
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDiscover:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3350
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDJs:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3351
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnSettings:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3353
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlaylists:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700d5

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3354
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3355
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlaylists:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700d4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3356
    const v1, 0x7f0200f1

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3358
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnNewsfeed:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700d9

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3359
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3360
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnNewsfeed:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700d8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3361
    const v1, 0x7f0200e9

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3363
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDiscover:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700dc

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3364
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3365
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDiscover:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700db

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3366
    const v1, 0x7f020101

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3368
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDJs:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700e0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3369
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3370
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDJs:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700df

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3371
    const v1, 0x7f0200d6

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3373
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnSettings:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700e3

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3374
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3375
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnSettings:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700e2

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3376
    const v1, 0x7f020106

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3377
    return-void
.end method

.method public setDJs(I)V
    .locals 4

    .prologue
    .line 3216
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 3217
    const-string v1, "tab"

    const-string v2, "navFriends"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3218
    const-string v1, "action:main_tab_nav"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 3219
    const/4 v0, 0x2

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3221
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_5

    .line 3222
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3223
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    if-eq p1, v0, :cond_2

    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->getChildCount()I

    move-result v0

    if-nez v0, :cond_4

    .line 3226
    :cond_2
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayDJs:Ljava/util/List;

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;

    new-instance v2, Lorg/json/JSONObject;

    const-string v3, "{\"type\":\"divider\",\"title\":\"\"}"

    invoke-direct {v2, v3}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-direct {v1, v2, p0}, Lcom/mixerbox/mixerbox3b/classes/DividerVectorItem;-><init>(Lorg/json/JSONObject;Landroid/content/Context;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3227
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->loadContent()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 3230
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    if-eqz v0, :cond_3

    .line 3231
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDJs:Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/DJsFragment;->lv:Lcom/handmark/pulltorefresh/library/PullToRefreshListView;

    invoke-virtual {v0}, Lcom/handmark/pulltorefresh/library/PullToRefreshListView;->setRefreshing()V

    .line 3233
    :cond_3
    :try_start_1
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getDJs(Landroid/content/Context;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 3242
    :cond_4
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDJs:Landroid/widget/RelativeLayout;

    const v1, 0x7f02007c

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3244
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDJs:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700e0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3245
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060018

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3246
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDJs:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700df

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3247
    const v1, 0x7f0200d7

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3248
    return-void

    .line 3240
    :cond_5
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setSignUp()V

    goto :goto_1

    .line 3235
    :catch_0
    move-exception v0

    goto :goto_1

    :catch_1
    move-exception v0

    goto :goto_0
.end method

.method public varargs setDiscover([Z)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 3150
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_0

    .line 3151
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/EmptyVectorItem;

    invoke-direct {v1}, Lcom/mixerbox/mixerbox3b/classes/EmptyVectorItem;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3154
    :cond_0
    const v0, 0x7f0700dd

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3155
    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v1

    if-nez v1, :cond_1

    .line 3156
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 3157
    const v0, 0x7f0700e4

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3158
    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 3161
    :cond_1
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 3162
    const-string v1, "tab"

    const-string v2, "navSearch"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3163
    const-string v1, "action:main_tab_nav"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 3164
    iput v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3166
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arraySystemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-gt v0, v4, :cond_3

    .line 3168
    :cond_2
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 3170
    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getSystemListUrl(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/MainPage$42;

    invoke-direct {v2, p0, p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$42;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;[Z)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 3206
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentDiscover:Lcom/mixerbox/mixerbox3b/fragments/DiscoverFragment;

    invoke-virtual {p0, v0, v3}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3207
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDiscover:Landroid/widget/RelativeLayout;

    const v1, 0x7f02007c

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3209
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDiscover:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700dc

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3210
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060018

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3211
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnDiscover:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700db

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3212
    const v1, 0x7f020102

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3213
    return-void
.end method

.method public setFragment(Landroid/support/v4/app/Fragment;Z)V
    .locals 7

    .prologue
    const v6, 0x7f0700d0

    const v5, 0x7f0700b6

    const/4 v4, 0x3

    const/4 v2, -0x1

    .line 3380
    invoke-virtual {p0, v6}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 3381
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v1, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 3382
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    const-string v3, "WebFragment"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 3383
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 3384
    invoke-virtual {v1, v4, v5}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 3385
    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 3392
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 3393
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->empty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 3394
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v4/app/Fragment;

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentTransaction;->hide(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 3396
    :cond_0
    if-nez p2, :cond_3

    .line 3397
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->clear()V

    .line 3398
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->stackCurrentFragmentId:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->clear()V

    .line 3399
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->changeToNormalActionBar(Landroid/content/Context;)V

    .line 3400
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setBottomTabBackground()V

    .line 3405
    :goto_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 3407
    invoke-virtual {p1}, Landroid/support/v4/app/Fragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 3408
    invoke-virtual {v1, p1}, Landroid/support/v4/app/FragmentTransaction;->show(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 3412
    :goto_2
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 3413
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 3415
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0, p1}, Ljava/util/Stack;->add(Ljava/lang/Object;)Z

    .line 3416
    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->stackCurrentFragmentId:Ljava/util/Stack;

    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/Stack;->add(Ljava/lang/Object;)Z

    .line 3417
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->menu:Lcom/actionbarsherlock/view/Menu;

    if-eqz v0, :cond_1

    .line 3418
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->menu:Lcom/actionbarsherlock/view/Menu;

    sget-object v0, Lcom/mixerbox/mixerbox3b/MainPage;->stackCurrentFragmentId:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {v1, v0, p0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->setActionBarItems(Lcom/actionbarsherlock/view/Menu;ILandroid/content/Context;)V

    .line 3419
    :cond_1
    return-void

    .line 3387
    :cond_2
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 3388
    const/4 v2, 0x2

    const v3, 0x7f0700d1

    invoke-virtual {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 3389
    invoke-virtual {v1, v4, v5}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 3390
    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    .line 3402
    :cond_3
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/ActionBarSettings;->changeToBackActionBar(Landroid/content/Context;)V

    goto :goto_1

    .line 3410
    :cond_4
    invoke-virtual {v1, v6, p1}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    goto :goto_2
.end method

.method setFullScreen()V
    .locals 6

    .prologue
    const/16 v5, 0x400

    const/4 v4, -0x1

    const/16 v3, 0x8

    .line 1590
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->isShown()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1591
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->performClick()Z

    .line 1624
    :goto_0
    return-void

    .line 1594
    :cond_0
    const/4 v0, 0x6

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setRequestedOrientation(I)V

    .line 1595
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->adView:Lcom/google/android/gms/ads/AdView;

    invoke-virtual {v0, v3}, Lcom/google/android/gms/ads/AdView;->setVisibility(I)V

    .line 1596
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnFullScreen:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f02010f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1597
    const/4 v0, 0x2

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    .line 1599
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-ge v0, v1, :cond_1

    .line 1600
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v5, v5}, Landroid/view/Window;->setFlags(II)V

    .line 1614
    :goto_1
    const v0, 0x7f0700d0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 1615
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v1

    invoke-virtual {v1}, Lcom/actionbarsherlock/app/ActionBar;->hide()V

    .line 1616
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1617
    invoke-virtual {v0, v3}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 1618
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v4, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 1619
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1621
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->showPopupMenu()V

    .line 1623
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:setScreenSize("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0

    .line 1604
    :cond_1
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 1605
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setSystemUiVisibility(I)V

    goto :goto_1
.end method

.method public setLocalNotification()V
    .locals 13

    .prologue
    .line 1838
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getShouldSendLocalNotification(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1883
    :cond_0
    return-void

    .line 1841
    :cond_1
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v4

    .line 1842
    const-string v0, "alarm"

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 1843
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 1844
    new-instance v6, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/services/LocalNotificationReceiver;

    invoke-direct {v6, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1847
    const/4 v1, 0x2

    .line 1848
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getHasSetLocalNotification(Landroid/content/Context;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 1849
    const/4 v1, 0x1

    invoke-static {p0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putHasSetLocalNotification(Landroid/content/Context;Z)V

    .line 1850
    const/4 v1, 0x0

    move v2, v1

    .line 1853
    :goto_0
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v3, 0x7f0d0001

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v7

    .line 1854
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v3, 0x7f0d0000

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v8

    .line 1855
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v3, 0x7f0d0002

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v9

    move v3, v2

    .line 1857
    :goto_1
    const/16 v1, 0x9

    if-ge v3, v1, :cond_0

    .line 1858
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    invoke-virtual {v4, v10, v11}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 1859
    const-string v1, "serviceId"

    sget-object v10, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->LOCAL_NOTIFICATION_ID:[I

    aget v10, v10, v3

    invoke-virtual {v5, v1, v10}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1860
    const/16 v1, 0xc

    const/16 v10, 0xc

    invoke-virtual {v4, v10}, Ljava/util/Calendar;->get(I)I

    move-result v10

    sget-object v11, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->LOCAL_NOTIFICATION_TIME:[I

    aget v11, v11, v3

    add-int/2addr v10, v11

    invoke-virtual {v4, v1, v10}, Ljava/util/Calendar;->set(II)V

    .line 1861
    const-string v1, "sound"

    const/4 v10, 0x0

    invoke-virtual {v5, v1, v10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 1862
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    sub-int v10, v3, v2

    if-le v1, v10, :cond_2

    .line 1863
    const-string v1, "type"

    const/4 v10, 0x0

    invoke-virtual {v5, v1, v10}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1864
    const-string v10, "artist"

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    sub-int v11, v3, v2

    invoke-virtual {v1, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v10, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1865
    const-string v10, "playlistName"

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    sub-int v11, v3, v2

    invoke-virtual {v1, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v10, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1866
    const-string v10, "playlistId"

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    sub-int v11, v3, v2

    invoke-virtual {v1, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v10, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1867
    const-string v10, "artistId"

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    sub-int v11, v3, v2

    invoke-virtual {v1, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v10, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1868
    const-string v10, "itemCount"

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    sub-int v11, v3, v2

    invoke-virtual {v1, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v10, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1869
    const-string v10, "url"

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    sub-int v11, v3, v2

    invoke-virtual {v1, v11}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5, v10, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1870
    const-string v1, "tab"

    const/4 v10, 0x2

    invoke-virtual {v5, v1, v10}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1878
    :goto_2
    invoke-virtual {v6, v5}, Landroid/content/Intent;->replaceExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 1879
    sget-object v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->LOCAL_NOTIFICATION_ID:[I

    aget v1, v1, v3

    const/high16 v10, 0x8000000

    invoke-static {p0, v1, v6, v10}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 1881
    const/4 v10, 0x1

    invoke-virtual {v4}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v11

    invoke-virtual {v0, v10, v11, v12, v1}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 1857
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto/16 :goto_1

    .line 1872
    :cond_2
    const-string v1, "type"

    const/4 v10, 0x1

    invoke-virtual {v5, v1, v10}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1873
    const-string v1, "smallTitle"

    aget-object v10, v8, v3

    invoke-virtual {v5, v1, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1874
    const-string v1, "smallContext"

    aget-object v10, v7, v3

    invoke-virtual {v5, v1, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1875
    const-string v1, "context"

    aget-object v10, v9, v3

    invoke-virtual {v5, v1, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1876
    const-string v1, "tab"

    sget-object v10, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->LOCAL_NOTIFICATION_TAB:[I

    aget v10, v10, v3

    invoke-virtual {v5, v1, v10}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    goto :goto_2

    :cond_3
    move v2, v1

    goto/16 :goto_0
.end method

.method public setLocalNotificationList()V
    .locals 9

    .prologue
    const/16 v8, 0x9

    const/4 v1, 0x0

    .line 3893
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lt v0, v8, :cond_1

    .line 3926
    :cond_0
    return-void

    .line 3897
    :cond_1
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getShouldSendLocalNotification(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3900
    new-instance v3, Ljava/util/ArrayList;

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    invoke-direct {v3, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 3902
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v4, v0, [I

    move v0, v1

    .line 3903
    :goto_0
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 3904
    aput v0, v4, v0

    .line 3903
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 3905
    :cond_2
    new-instance v2, Ljava/util/Random;

    invoke-direct {v2}, Ljava/util/Random;-><init>()V

    move v0, v1

    .line 3906
    :goto_1
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ge v0, v5, :cond_3

    .line 3907
    add-int/lit8 v5, v0, 0x1

    invoke-virtual {v2, v5}, Ljava/util/Random;->nextInt(I)I

    move-result v5

    .line 3908
    aget v6, v4, v5

    .line 3909
    aget v7, v4, v0

    aput v7, v4, v5

    .line 3910
    aput v6, v4, v0

    .line 3906
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_3
    move v2, v1

    .line 3914
    :goto_2
    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 3915
    aget v0, v4, v1

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ge v0, v5, :cond_5

    aget v0, v4, v1

    if-ltz v0, :cond_5

    .line 3916
    aget v0, v4, v1

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getIsAlbum()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 3918
    add-int/lit8 v2, v2, 0x1

    .line 3919
    aget v0, v4, v1

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerId()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getArtistAlbums(Landroid/content/Context;Ljava/lang/String;)V

    .line 3920
    const/16 v0, 0xa

    if-gt v2, v0, :cond_0

    .line 3921
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayLocalNotificationList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v0, v8, :cond_0

    :cond_5
    move v0, v2

    .line 3924
    add-int/lit8 v1, v1, 0x1

    move v2, v0

    goto :goto_2
.end method

.method public setMP3()V
    .locals 2

    .prologue
    .line 3339
    const/16 v0, 0xe

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3340
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;-><init>()V

    .line 3341
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3342
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/MP3Fragment;->loadContent()V

    .line 3343
    return-void
.end method

.method setNewsfeed()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 3064
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 3065
    const-string v1, "tab"

    const-string v2, "navNewsFeed"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3066
    const-string v1, "action:main_tab_nav"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 3068
    const/16 v0, 0xc

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3069
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentNewsfeed:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-virtual {p0, v0, v5}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3071
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnNewsfeed:Landroid/widget/RelativeLayout;

    const v1, 0x7f02007c

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3072
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnNewsfeed:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700d9

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3073
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060018

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3074
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnNewsfeed:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700d8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3075
    const v1, 0x7f0200ea

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3077
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x5

    if-gt v0, v1, :cond_0

    .line 3078
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 3079
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/EmptyVectorItem;

    invoke-direct {v1}, Lcom/mixerbox/mixerbox3b/classes/EmptyVectorItem;-><init>()V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 3082
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v1, 0x1

    if-gt v0, v1, :cond_2

    .line 3085
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->getLastPushed()Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    move-result-object v0

    .line 3086
    if-eqz v0, :cond_1

    .line 3087
    new-instance v1, Lorg/json/JSONObject;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "{margin: true,type: \"general\",views: {header: {mainText: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080112

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\"},main: {mainLink: {type: \"playlist\",ref: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\",title: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\",owner: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\",size: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\",thumbnail: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\",thumbnailHQ: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\",ownerId: \"\"},mainText: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\",subText: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\",sideText: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\",thumbnail: {style: \"square\",url: \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\"}},footer: {bgColor: true,links: [{type: \"button\",title: \""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800e7

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\",action: \"subscribe\",switch: {type: \"button\",title: \""

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800e8

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\",action: \"unsubscribe\"}},{type: \"dummy\"},{type: \"dummy\"}]}}}"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 3100
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayNewsfeed:Ljava/util/List;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-static {v0, v1, p0, v2, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->addMyItemToArray(Ljava/util/List;Lorg/json/JSONObject;Landroid/content/Context;II)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 3106
    :cond_1
    :goto_0
    invoke-static {p0, v5}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->getNewsfeedUrl(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 3107
    const/4 v1, 0x0

    new-instance v2, Lcom/mixerbox/mixerbox3b/MainPage$41;

    invoke-direct {v2, p0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$41;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;)V

    invoke-static {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->get(Ljava/lang/String;Lcom/loopj/android/http/RequestParams;Lcom/loopj/android/http/AsyncHttpResponseHandler;)V

    .line 3147
    :cond_2
    return-void

    .line 3102
    :catch_0
    move-exception v0

    .line 3103
    invoke-virtual {v0}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public varargs declared-synchronized setOnboardingGuide(I[Z)Z
    .locals 14

    .prologue
    .line 744
    monitor-enter p0

    :try_start_0
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxClient;->isConnectingToInternet(Landroid/content/Context;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-nez v1, :cond_0

    .line 745
    const/4 v1, 0x0

    .line 1044
    :goto_0
    monitor-exit p0

    return v1

    .line 747
    :cond_0
    :try_start_1
    const-string v1, "window"

    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    move-object v0, v1

    check-cast v0, Landroid/view/WindowManager;

    move-object v10, v0

    .line 748
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    .line 750
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xd

    if-lt v2, v3, :cond_1

    .line 751
    new-instance v2, Landroid/util/DisplayMetrics;

    invoke-direct {v2}, Landroid/util/DisplayMetrics;-><init>()V

    .line 752
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 753
    iget v4, v2, Landroid/util/DisplayMetrics;->heightPixels:I

    .line 754
    iget v3, v2, Landroid/util/DisplayMetrics;->widthPixels:I

    .line 761
    :goto_1
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->isShown()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 762
    const/4 v1, 0x0

    goto :goto_0

    .line 756
    :cond_1
    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    .line 757
    invoke-virtual {v1}, Landroid/view/Display;->getHeight()I

    move-result v4

    .line 758
    invoke-virtual {v1}, Landroid/view/Display;->getWidth()I

    move-result v3

    goto :goto_1

    .line 764
    :cond_2
    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    .line 765
    const-string v9, ""

    .line 767
    const/4 v1, 0x1

    .line 768
    if-le v3, v4, :cond_28

    .line 769
    const/4 v1, 0x0

    move v12, v1

    .line 771
    :goto_2
    new-instance v2, Landroid/util/TypedValue;

    invoke-direct {v2}, Landroid/util/TypedValue;-><init>()V

    .line 772
    const/4 v1, 0x0

    .line 773
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getTheme()Landroid/content/res/Resources$Theme;

    move-result-object v8

    const v11, 0x10102eb

    const/4 v13, 0x1

    invoke-virtual {v8, v11, v2, v13}, Landroid/content/res/Resources$Theme;->resolveAttribute(ILandroid/util/TypedValue;Z)Z

    move-result v8

    if-eqz v8, :cond_27

    .line 774
    iget v1, v2, Landroid/util/TypedValue;->data:I

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/TypedValue;->complexToDimensionPixelSize(ILandroid/util/DisplayMetrics;)I

    move-result v1

    move v11, v1

    .line 777
    :goto_3
    const/4 v1, 0x1

    if-ne p1, v1, :cond_a

    .line 778
    const-string v2, ""

    const-string v5, ""

    .line 779
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->name:Ljava/util/ArrayList;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->name:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-nez v1, :cond_5

    .line 781
    :cond_3
    const/4 v1, 0x0

    move-object v8, v2

    move-object v2, v5

    .line 790
    :goto_4
    if-eqz v12, :cond_7

    .line 791
    const/high16 v5, 0x42980000    # 76.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v5, v6

    float-to-double v5, v5

    const-wide/high16 v12, 0x3ff4000000000000L    # 1.25

    mul-double/2addr v5, v12

    double-to-int v7, v5

    .line 792
    int-to-double v5, v7

    const-wide v12, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v5, v12

    double-to-int v5, v5

    .line 793
    iget v6, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    add-int/2addr v6, v7

    add-int/2addr v6, v11

    .line 799
    :goto_5
    const/4 v9, 0x1

    if-ne v1, v9, :cond_8

    .line 800
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v9, 0x7f08012c

    invoke-virtual {v2, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "\n"

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v11, 0x7f080136

    invoke-virtual {v9, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v2, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v9, 0x2

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v11, 0x0

    iget-object v12, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v12

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v9, v11

    const/4 v11, 0x1

    aput-object v8, v9, v11

    invoke-static {v2, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    .line 996
    :cond_4
    :goto_6
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/DrawView;

    move-object v2, p0

    move v8, p1

    invoke-direct/range {v1 .. v9}, Lcom/mixerbox/mixerbox3b/classes/DrawView;-><init>(Landroid/content/Context;IIIIIILjava/lang/String;)V

    iput-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    .line 997
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->invalidate()V

    .line 999
    new-instance v2, Landroid/view/WindowManager$LayoutParams;

    const/16 v5, 0x7d3

    const/16 v6, 0x8

    const/4 v7, -0x3

    invoke-direct/range {v2 .. v7}, Landroid/view/WindowManager$LayoutParams;-><init>(IIIII)V

    .line 1001
    const/4 v1, 0x0

    iput v1, v2, Landroid/view/WindowManager$LayoutParams;->x:I

    .line 1002
    const/4 v1, 0x0

    iput v1, v2, Landroid/view/WindowManager$LayoutParams;->y:I

    .line 1003
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-interface {v10, v1, v2}, Landroid/view/WindowManager;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 1005
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    new-instance v2, Lcom/mixerbox/mixerbox3b/MainPage$10;

    invoke-direct {v2, p0, v10}, Lcom/mixerbox/mixerbox3b/MainPage$10;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/view/WindowManager;)V

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1044
    const/4 v1, 0x1

    goto/16 :goto_0

    .line 782
    :cond_5
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->name:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    const/4 v2, 0x1

    if-ne v1, v2, :cond_6

    .line 783
    const/4 v2, 0x1

    .line 784
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->name:Ljava/util/ArrayList;

    const/4 v6, 0x0

    invoke-virtual {v1, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    move-object v8, v1

    move v1, v2

    move-object v2, v5

    goto/16 :goto_4

    .line 786
    :cond_6
    const/4 v5, 0x2

    .line 787
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->name:Ljava/util/ArrayList;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 788
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->name:Ljava/util/ArrayList;

    const/4 v6, 0x1

    invoke-virtual {v2, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    move-object v8, v1

    move v1, v5

    goto/16 :goto_4

    .line 795
    :cond_7
    const/high16 v5, 0x42980000    # 76.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v5, v6

    float-to-double v5, v5

    const-wide/high16 v12, 0x3ff4000000000000L    # 1.25

    mul-double/2addr v5, v12

    double-to-int v7, v5

    .line 796
    int-to-double v5, v7

    const-wide v12, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v5, v12

    double-to-int v5, v5

    .line 797
    add-int v6, v7, v11

    goto/16 :goto_5

    .line 803
    :cond_8
    const/4 v9, 0x2

    if-ne v1, v9, :cond_9

    .line 804
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    const v11, 0x7f08012c

    invoke-virtual {v9, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v1, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "\n"

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    const v12, 0x7f080137

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v11, 0x3

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    iget-object v13, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v13}, Ljava/util/ArrayList;->size()I

    move-result v13

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x1

    aput-object v8, v11, v12

    const/4 v8, 0x2

    aput-object v2, v11, v8

    invoke-static {v9, v11}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 808
    :cond_9
    const-string v9, ""

    goto/16 :goto_6

    .line 810
    :cond_a
    const/4 v1, 0x2

    if-ne p1, v1, :cond_c

    .line 811
    if-eqz v12, :cond_b

    .line 812
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getHeight()I

    move-result v1

    .line 813
    int-to-double v1, v1

    const-wide v5, 0x3feccccccccccccdL    # 0.9

    mul-double/2addr v1, v5

    double-to-int v1, v1

    .line 814
    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v2, v2, 0x5

    int-to-double v5, v2

    const-wide v7, 0x3fe3333333333333L    # 0.6

    mul-double/2addr v5, v7

    double-to-int v7, v5

    .line 815
    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    sub-int v6, v2, v1

    .line 816
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v1, v1, 0x5

    int-to-double v1, v1

    const-wide/high16 v8, 0x3ff8000000000000L    # 1.5

    mul-double/2addr v1, v8

    double-to-int v5, v1

    .line 824
    :goto_7
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080138

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 818
    :cond_b
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getHeight()I

    move-result v1

    .line 819
    int-to-double v1, v1

    const-wide v5, 0x3feccccccccccccdL    # 0.9

    mul-double/2addr v1, v5

    double-to-int v1, v1

    .line 820
    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    div-int/lit8 v2, v2, 0x5

    int-to-double v5, v2

    const-wide v7, 0x3fe3333333333333L    # 0.6

    mul-double/2addr v5, v7

    double-to-int v7, v5

    .line 821
    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    sub-int v6, v2, v1

    .line 822
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    div-int/lit8 v1, v1, 0x5

    int-to-double v1, v1

    const-wide/high16 v8, 0x3ff8000000000000L    # 1.5

    mul-double/2addr v1, v8

    double-to-int v5, v1

    goto :goto_7

    .line 825
    :cond_c
    const/4 v1, 0x3

    if-ne p1, v1, :cond_f

    .line 826
    if-eqz v12, :cond_e

    .line 827
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    int-to-double v1, v1

    const-wide v5, 0x3fd1eb851eb851ecL    # 0.28

    mul-double/2addr v1, v5

    double-to-int v7, v1

    .line 828
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    int-to-double v1, v1

    const-wide/high16 v5, 0x3fd0000000000000L    # 0.25

    mul-double/2addr v1, v5

    double-to-int v5, v1

    .line 829
    add-int v6, v7, v11

    .line 830
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_d

    .line 831
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    add-int/2addr v6, v1

    .line 838
    :cond_d
    :goto_8
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080139

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 834
    :cond_e
    const/high16 v1, 0x42980000    # 76.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    float-to-double v1, v1

    const-wide/high16 v5, 0x3ff4000000000000L    # 1.25

    mul-double/2addr v1, v5

    double-to-int v7, v1

    .line 835
    int-to-double v1, v7

    const-wide v5, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v1, v5

    double-to-int v5, v1

    .line 836
    add-int v6, v7, v11

    goto :goto_8

    .line 839
    :cond_f
    const/4 v1, 0x4

    if-ne p1, v1, :cond_11

    .line 840
    if-eqz v12, :cond_10

    .line 841
    int-to-double v1, v11

    const-wide v5, 0x3fe3333333333333L    # 0.6

    mul-double/2addr v1, v5

    double-to-int v7, v1

    .line 842
    div-int/lit8 v6, v11, 0x2

    .line 843
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    int-to-double v1, v1

    int-to-double v8, v11

    const-wide/high16 v11, 0x3ff8000000000000L    # 1.5

    mul-double/2addr v8, v11

    sub-double/2addr v1, v8

    const/high16 v5, 0x41500000    # 13.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v8

    iget v8, v8, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v5, v8

    float-to-double v8, v5

    sub-double/2addr v1, v8

    double-to-int v5, v1

    .line 849
    :goto_9
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08013a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 845
    :cond_10
    int-to-double v1, v11

    const-wide v5, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v1, v5

    double-to-int v7, v1

    .line 846
    div-int/lit8 v6, v11, 0x2

    .line 847
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    int-to-double v1, v1

    int-to-double v8, v11

    const-wide/high16 v11, 0x3ff8000000000000L    # 1.5

    mul-double/2addr v8, v11

    sub-double/2addr v1, v8

    const/high16 v5, 0x41a80000    # 21.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v8

    iget v8, v8, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v5, v8

    float-to-double v8, v5

    sub-double/2addr v1, v8

    double-to-int v5, v1

    goto :goto_9

    .line 850
    :cond_11
    const/4 v1, 0x5

    if-ne p1, v1, :cond_14

    .line 851
    if-eqz v12, :cond_13

    .line 852
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v5, v1, 0x6

    .line 853
    int-to-float v1, v11

    const/high16 v2, 0x41b00000    # 22.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 854
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v1, v1, 0x6

    int-to-double v1, v1

    const-wide v7, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v1, v7

    double-to-int v7, v1

    .line 855
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_12

    .line 856
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    add-int/2addr v6, v1

    .line 862
    :cond_12
    :goto_a
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08013b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 858
    :cond_13
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    div-int/lit8 v5, v1, 0x6

    .line 859
    int-to-float v1, v11

    const/high16 v2, 0x41b00000    # 22.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 860
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    div-int/lit8 v1, v1, 0x6

    int-to-double v1, v1

    const-wide v7, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v1, v7

    double-to-int v7, v1

    goto :goto_a

    .line 863
    :cond_14
    const/4 v1, 0x6

    if-ne p1, v1, :cond_17

    .line 864
    if-eqz v12, :cond_16

    .line 865
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v5, v1, 0x6

    .line 866
    int-to-float v1, v11

    const/high16 v2, 0x41b00000    # 22.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 867
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v1, v1, 0x6

    int-to-double v1, v1

    const-wide v7, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v1, v7

    double-to-int v7, v1

    .line 868
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_15

    .line 869
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    add-int/2addr v6, v1

    .line 875
    :cond_15
    :goto_b
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08013c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 871
    :cond_16
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    div-int/lit8 v5, v1, 0x6

    .line 872
    int-to-float v1, v11

    const/high16 v2, 0x41b00000    # 22.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 873
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    div-int/lit8 v1, v1, 0x6

    int-to-double v1, v1

    const-wide v7, 0x3fe999999999999aL    # 0.8

    mul-double/2addr v1, v7

    double-to-int v7, v1

    goto :goto_b

    .line 876
    :cond_17
    const/4 v1, 0x7

    if-ne p1, v1, :cond_19

    .line 877
    if-eqz v12, :cond_18

    .line 878
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getHeight()I

    move-result v1

    .line 879
    int-to-double v1, v1

    const-wide v5, 0x3feccccccccccccdL    # 0.9

    mul-double/2addr v1, v5

    double-to-int v1, v1

    .line 880
    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v2, v2, 0x5

    int-to-double v5, v2

    const-wide v7, 0x3fe3333333333333L    # 0.6

    mul-double/2addr v5, v7

    double-to-int v7, v5

    .line 881
    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    sub-int v6, v2, v1

    .line 882
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v1, v1, 0x5

    int-to-double v1, v1

    const-wide/high16 v8, 0x3fe0000000000000L    # 0.5

    mul-double/2addr v1, v8

    double-to-int v5, v1

    .line 890
    :goto_c
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08013d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 884
    :cond_18
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getHeight()I

    move-result v1

    .line 885
    int-to-double v1, v1

    const-wide v5, 0x3feccccccccccccdL    # 0.9

    mul-double/2addr v1, v5

    double-to-int v1, v1

    .line 886
    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    div-int/lit8 v2, v2, 0x5

    int-to-double v5, v2

    const-wide v7, 0x3fe3333333333333L    # 0.6

    mul-double/2addr v5, v7

    double-to-int v7, v5

    .line 887
    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    sub-int v6, v2, v1

    .line 888
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    div-int/lit8 v1, v1, 0x5

    int-to-double v1, v1

    const-wide/high16 v8, 0x3fe0000000000000L    # 0.5

    mul-double/2addr v1, v8

    double-to-int v5, v1

    goto :goto_c

    .line 891
    :cond_19
    const/16 v1, 0x8

    if-ne p1, v1, :cond_1a

    .line 893
    int-to-double v1, v11

    const-wide v5, 0x3ffccccccccccccdL    # 1.8

    mul-double/2addr v1, v5

    double-to-int v5, v1

    .line 898
    int-to-double v1, v11

    const-wide/high16 v6, 0x3fe0000000000000L    # 0.5

    mul-double/2addr v1, v6

    double-to-int v6, v1

    .line 899
    int-to-double v1, v11

    const-wide v7, 0x3fe6666666666666L    # 0.7

    mul-double/2addr v1, v7

    double-to-int v7, v1

    .line 901
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08013e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 902
    :cond_1a
    const/16 v1, 0x9

    if-ne p1, v1, :cond_1d

    .line 903
    if-eqz v12, :cond_1c

    .line 904
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    int-to-float v1, v1

    const/high16 v2, 0x41980000    # 19.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v5

    sub-float/2addr v1, v2

    float-to-int v5, v1

    .line 905
    const/high16 v1, 0x41700000    # 15.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->scaledDensity:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42b40000    # 90.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    int-to-float v2, v11

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 907
    const/high16 v1, 0x41c80000    # 25.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    float-to-int v7, v1

    .line 908
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_1b

    .line 909
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    add-int/2addr v6, v1

    .line 916
    :cond_1b
    :goto_d
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08013f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 911
    :cond_1c
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    int-to-float v1, v1

    const/high16 v2, 0x41980000    # 19.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v5

    sub-float/2addr v1, v2

    float-to-int v5, v1

    .line 912
    const/high16 v1, 0x41700000    # 15.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->scaledDensity:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42b40000    # 90.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    int-to-float v2, v11

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 914
    const/high16 v1, 0x41c80000    # 25.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    float-to-int v7, v1

    goto :goto_d

    .line 917
    :cond_1d
    const/16 v1, 0xa

    if-ne p1, v1, :cond_21

    .line 918
    if-eqz v12, :cond_20

    .line 919
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    int-to-float v1, v1

    const/high16 v2, 0x41880000    # 17.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v5

    sub-float/2addr v1, v2

    float-to-int v5, v1

    .line 920
    const/high16 v1, 0x41900000    # 18.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->scaledDensity:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42960000    # 75.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    int-to-float v2, v11

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 922
    const/high16 v1, 0x41f00000    # 30.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    float-to-int v7, v1

    .line 923
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v1

    if-nez v1, :cond_1e

    .line 924
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    add-int/2addr v6, v1

    .line 925
    :cond_1e
    if-eqz p2, :cond_1f

    const/4 v1, 0x0

    aget-boolean v1, p2, v1

    if-eqz v1, :cond_1f

    .line 926
    const/high16 v1, 0x41900000    # 18.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->scaledDensity:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42c80000    # 100.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v8

    iget v8, v8, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v8

    add-float/2addr v1, v2

    float-to-int v1, v1

    .line 928
    add-int/2addr v6, v1

    .line 941
    :cond_1f
    :goto_e
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080140

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 931
    :cond_20
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    int-to-float v1, v1

    const/high16 v2, 0x41880000    # 17.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v5

    iget v5, v5, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v5

    sub-float/2addr v1, v2

    float-to-int v5, v1

    .line 932
    const/high16 v1, 0x41900000    # 18.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->scaledDensity:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42960000    # 75.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    int-to-float v2, v11

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 934
    const/high16 v1, 0x41f00000    # 30.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    float-to-int v7, v1

    .line 935
    if-eqz p2, :cond_1f

    const/4 v1, 0x0

    aget-boolean v1, p2, v1

    if-eqz v1, :cond_1f

    .line 936
    const/high16 v1, 0x41700000    # 15.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->scaledDensity:F

    mul-float/2addr v1, v2

    const/high16 v2, 0x42c80000    # 100.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v8

    iget v8, v8, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v8

    add-float/2addr v1, v2

    float-to-int v1, v1

    .line 938
    add-int/2addr v6, v1

    goto :goto_e

    .line 942
    :cond_21
    const/16 v1, 0xc

    if-ne p1, v1, :cond_23

    .line 943
    if-eqz v12, :cond_22

    .line 944
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 945
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 946
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 947
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 948
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v5, 0x7f0200db

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 949
    const/high16 v1, 0x41880000    # 17.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v2, v2, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    float-to-int v7, v1

    .line 950
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    sub-int v5, v1, v7

    .line 951
    add-int v6, v11, v7

    .line 955
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080141

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 953
    :cond_22
    const/4 v1, 0x0

    goto/16 :goto_0

    .line 956
    :cond_23
    const/16 v1, 0xd

    if-ne p1, v1, :cond_25

    .line 957
    if-eqz v12, :cond_24

    .line 958
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 959
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 960
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 961
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 962
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v5, 0x7f0200d3

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 963
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v7, v1, 0xa

    .line 964
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v5, v1, 0x2

    .line 965
    int-to-float v1, v11

    const/high16 v2, 0x42500000    # 52.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 969
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080142

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    goto/16 :goto_6

    .line 967
    :cond_24
    const/4 v1, 0x0

    goto/16 :goto_0

    .line 970
    :cond_25
    const/16 v1, 0xe

    if-ne p1, v1, :cond_4

    .line 971
    if-eqz v12, :cond_26

    .line 972
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 973
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 974
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 975
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 976
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v5, 0x7f0200d3

    invoke-virtual {v2, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 977
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v7, v1, 0x6

    .line 978
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    div-int/lit8 v5, v1, 0x5

    .line 979
    int-to-float v1, v11

    const/high16 v2, 0x42500000    # 52.0f

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v6

    iget v6, v6, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v2, v6

    add-float/2addr v1, v2

    float-to-int v6, v1

    .line 983
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080143

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v9

    goto/16 :goto_6

    .line 981
    :cond_26
    const/4 v1, 0x0

    goto/16 :goto_0

    .line 744
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    :cond_27
    move v11, v1

    goto/16 :goto_3

    :cond_28
    move v12, v1

    goto/16 :goto_2
.end method

.method public setPlaylists(Z)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 3030
    const v0, 0x7f0700d6

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3031
    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    .line 3032
    const v1, 0x7f0700e4

    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 3033
    invoke-virtual {v1, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 3034
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 3036
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 3037
    const-string v1, "tab"

    const-string v2, "navPlaylists"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3038
    const-string v1, "action:main_tab_nav"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 3039
    iput v3, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3040
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    .line 3042
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {p0, v0, p1}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3043
    if-nez p1, :cond_1

    .line 3044
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlaylists:Landroid/widget/RelativeLayout;

    const v1, 0x7f02007c

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3045
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlaylists:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700d5

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3046
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060018

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3047
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlaylists:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700d4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3048
    const v1, 0x7f0200f3

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3051
    :cond_1
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getOnboardingFinish(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipSecondPlaylist(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 3053
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->menu:Lcom/actionbarsherlock/view/Menu;

    if-eqz v0, :cond_2

    .line 3054
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->menu:Lcom/actionbarsherlock/view/Menu;

    const/16 v1, 0x3e7

    invoke-interface {v0, v1}, Lcom/actionbarsherlock/view/Menu;->findItem(I)Lcom/actionbarsherlock/view/MenuItem;

    move-result-object v0

    .line 3055
    if-eqz v0, :cond_2

    invoke-interface {v0}, Lcom/actionbarsherlock/view/MenuItem;->isActionViewExpanded()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 3056
    invoke-interface {v0}, Lcom/actionbarsherlock/view/MenuItem;->collapseActionView()Z

    .line 3059
    :cond_2
    const/4 v0, 0x4

    new-array v1, v3, [Z

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    .line 3061
    :cond_3
    return-void
.end method

.method public setReorder()V
    .locals 2

    .prologue
    .line 3311
    new-instance v1, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;

    invoke-direct {v1}, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;-><init>()V

    .line 3313
    :try_start_0
    iput-object p0, v1, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->ctx:Landroid/content/Context;

    .line 3314
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->currentPlaylist:Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->pid:Ljava/lang/String;

    .line 3315
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->stack:Ljava/util/Stack;

    invoke-virtual {v0}, Ljava/util/Stack;->lastElement()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;->adapter:Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/adapters/SongAdapter;->array:Ljava/util/ArrayList;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->array:Ljava/util/ArrayList;

    .line 3316
    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SortFragment;->setListAdapter()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 3321
    const/16 v0, 0xb

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3322
    const/4 v0, 0x1

    invoke-virtual {p0, v1, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3323
    const-string v0, "action:rearrange"

    invoke-static {v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 3324
    :goto_0
    return-void

    .line 3318
    :catch_0
    move-exception v0

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f080048

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto :goto_0
.end method

.method setSettings()V
    .locals 3

    .prologue
    .line 3251
    const v0, 0x7f0700e4

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3252
    invoke-virtual {v0}, Landroid/widget/ImageView;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    .line 3253
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 3256
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 3257
    const-string v1, "tab"

    const-string v2, "navSettings"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3258
    const-string v1, "action:main_tab_nav"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 3259
    const/4 v0, 0x3

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3260
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3262
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->loadContent()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 3266
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnSettings:Landroid/widget/RelativeLayout;

    const v1, 0x7f02007c

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 3267
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnSettings:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700e3

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 3268
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f060018

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setTextColor(I)V

    .line 3269
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnSettings:Landroid/widget/RelativeLayout;

    const v1, 0x7f0700e2

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 3270
    const v1, 0x7f020107

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 3271
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method setSignUp()V
    .locals 2

    .prologue
    .line 3328
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSignUp:Lcom/mixerbox/mixerbox3b/fragments/SignUpFragment;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3329
    return-void
.end method

.method public setSong(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/SongFragment;
    .locals 3

    .prologue
    .line 3275
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/SongFragment;-><init>()V

    .line 3277
    const-string v1, "page:playlist"

    invoke-static {v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;)V

    .line 3278
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 3279
    const/4 v1, 0x4

    iput v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3284
    :goto_0
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3286
    const-string v1, "PLAYLISTHISTORYID"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->myPlaylists:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "PLAYLISTMP3ID"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "PLAYLISTMP3PLAYLISTID"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "PLAYLISTMP3ALBUMID"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "PLAYLISTMP3ARTISTID"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstOthersPlaylist(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 3290
    const/4 v1, 0x6

    const/4 v2, 0x0

    new-array v2, v2, [Z

    invoke-virtual {p0, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    .line 3293
    :cond_0
    return-object v0

    .line 3280
    :cond_1
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    invoke-virtual {v1, p1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 3281
    const/4 v1, 0x5

    iput v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    goto :goto_0

    .line 3283
    :cond_2
    const/4 v1, 0x7

    iput v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    goto :goto_0
.end method

.method public setSongTime(I)V
    .locals 2

    .prologue
    .line 1907
    const v0, 0x7f0700cb

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 1908
    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongTime(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1910
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->seekbar:Landroid/widget/SeekBar;

    invoke-virtual {v0, p1}, Landroid/widget/SeekBar;->setMax(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1914
    :goto_0
    return-void

    .line 1912
    :catch_0
    move-exception v0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->seekbar:Landroid/widget/SeekBar;

    const/16 v1, 0x258

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setMax(I)V

    goto :goto_0
.end method

.method setUnFullScreen(Z)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1627
    if-eqz p1, :cond_0

    .line 1628
    invoke-virtual {p0, v4}, Lcom/mixerbox/mixerbox3b/MainPage;->setRequestedOrientation(I)V

    .line 1629
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->adView:Lcom/google/android/gms/ads/AdView;

    invoke-virtual {v0, v3}, Lcom/google/android/gms/ads/AdView;->setVisibility(I)V

    .line 1630
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnFullScreen:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200dc

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1631
    iput v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    .line 1633
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-ge v0, v1, :cond_2

    .line 1634
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x400

    invoke-virtual {v0, v1}, Landroid/view/Window;->clearFlags(I)V

    .line 1645
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:setScreenSize("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1646
    const v0, 0x7f0700d0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 1647
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    const/16 v2, 0x8

    if-eq v1, v2, :cond_1

    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    const/16 v2, 0x9

    if-eq v1, v2, :cond_1

    .line 1648
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->llBottomtab:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1650
    :cond_1
    invoke-virtual {v0, v3}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 1651
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v1, -0x1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playerHeight:I

    invoke-direct {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 1652
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1653
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getSupportActionBar()Lcom/actionbarsherlock/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Lcom/actionbarsherlock/app/ActionBar;->show()V

    .line 1654
    return-void

    .line 1637
    :cond_2
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    .line 1638
    invoke-virtual {v0, v3}, Landroid/view/View;->setSystemUiVisibility(I)V

    goto :goto_0
.end method

.method public setVector(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;
    .locals 3

    .prologue
    .line 3297
    const/16 v0, 0xa

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3298
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-direct {v0}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;-><init>()V

    .line 3299
    iput-object p1, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorId:Ljava/lang/String;

    .line 3300
    iput-object p2, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorType:Ljava/lang/String;

    .line 3301
    iput p3, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->vectorPageType:I

    .line 3302
    iput-object p4, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->title:Ljava/lang/String;

    .line 3303
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3304
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 3305
    const-string v2, "vectorId"

    invoke-interface {v1, v2, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3306
    const-string v2, "page:vector"

    invoke-static {v2, v1}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 3307
    return-object v0
.end method

.method public setVideoPlayer()V
    .locals 11
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled"
        }
    .end annotation

    .prologue
    const/16 v3, 0x8

    const/4 v9, 0x2

    const/4 v8, -0x1

    const/4 v7, 0x0

    const/4 v6, 0x1

    .line 1253
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    if-nez v0, :cond_0

    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getEnableBackgroundPlay(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1254
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1255
    const-string v1, "messenger"

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->messenger:Landroid/os/Messenger;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 1256
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->conn:Landroid/content/ServiceConnection;

    invoke-virtual {p0, v0, v1, v6}, Lcom/mixerbox/mixerbox3b/MainPage;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 1260
    :cond_0
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    if-le v0, v1, :cond_5

    .line 1261
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    .line 1262
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    move v10, v0

    move v0, v1

    move v1, v10

    .line 1268
    :goto_0
    const/16 v2, 0x5dc

    if-le v0, v2, :cond_6

    .line 1269
    div-int/lit8 v0, v0, 0x5

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playerHeight:I

    .line 1273
    :goto_1
    const v0, 0x7f0700cd

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvSwitch:Landroid/widget/TextView;

    .line 1274
    const v0, 0x7f0700ce

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvNoNet:Landroid/widget/TextView;

    .line 1275
    const v0, 0x7f0700e5

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlHint:Landroid/widget/RelativeLayout;

    .line 1276
    const v0, 0x7f0700bf

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    .line 1277
    const v0, 0x7f0700bb

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    .line 1278
    const v0, 0x7f0700c5

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    .line 1280
    const v0, 0x7f0700b6

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    .line 1281
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playerHeight:I

    invoke-direct {v0, v8, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 1282
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v0}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 1283
    const v0, 0x7f0700b7

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/webkit/WebView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    .line 1284
    const v0, 0x7f0700b8

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivWebViewCover:Landroid/widget/ImageView;

    .line 1285
    const v0, 0x7f0700b9

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->ivSoundCloud:Landroid/widget/ImageView;

    .line 1288
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getPlayerType(Landroid/content/Context;)I

    move-result v0

    .line 1289
    sput v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    if-nez v0, :cond_1

    .line 1290
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x11

    if-lt v0, v2, :cond_7

    .line 1291
    invoke-static {p0, v6}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPlayerType(Landroid/content/Context;I)V

    .line 1292
    sput v6, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    .line 1297
    :cond_1
    :goto_2
    sget v0, Lcom/mixerbox/mixerbox3b/MainPage;->playerType:I

    if-ne v0, v9, :cond_8

    .line 1298
    const-string v0, "http://static.mixerbox.com/yt_android.min.b.v7.html"

    .line 1299
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1300
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1301
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setWebViewTouchListener()V

    .line 1307
    :goto_3
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvSwitch:Landroid/widget/TextView;

    new-instance v3, Lcom/mixerbox/mixerbox3b/MainPage$16;

    invoke-direct {v3, p0}, Lcom/mixerbox/mixerbox3b/MainPage$16;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1321
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v2}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    .line 1322
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x11

    if-lt v3, v4, :cond_2

    .line 1323
    invoke-virtual {v2, v7}, Landroid/webkit/WebSettings;->setMediaPlaybackRequiresUserGesture(Z)V

    .line 1324
    :cond_2
    invoke-virtual {v2, v6}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 1325
    new-instance v3, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;

    invoke-direct {v3, p0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MyJavaScriptInterface;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;)V

    .line 1326
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    const-string v5, "AndroidFunction"

    invoke-virtual {v4, v3, v5}, Landroid/webkit/WebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 1327
    invoke-virtual {v2, v6}, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V

    .line 1328
    invoke-virtual {v2, v6}, Landroid/webkit/WebSettings;->setDatabaseEnabled(Z)V

    .line 1329
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0x12

    if-ge v3, v4, :cond_3

    .line 1330
    sget-object v3, Landroid/webkit/WebSettings$PluginState;->ON:Landroid/webkit/WebSettings$PluginState;

    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setPluginState(Landroid/webkit/WebSettings$PluginState;)V

    .line 1331
    :cond_3
    invoke-virtual {v2, v9}, Landroid/webkit/WebSettings;->setCacheMode(I)V

    .line 1332
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v2, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1333
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v2, Landroid/webkit/WebViewClient;

    invoke-direct {v2}, Landroid/webkit/WebViewClient;-><init>()V

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 1334
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v2, Landroid/webkit/WebChromeClient;

    invoke-direct {v2}, Landroid/webkit/WebChromeClient;-><init>()V

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 1335
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v7, v7, v7, v7}, Landroid/webkit/WebView;->setPadding(IIII)V

    .line 1336
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/webkit/WebSettings;->setLoadWithOverviewMode(Z)V

    .line 1337
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/webkit/WebSettings;->setUseWideViewPort(Z)V

    .line 1338
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v7}, Landroid/webkit/WebView;->setVerticalScrollBarEnabled(Z)V

    .line 1339
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    invoke-virtual {v0, v7}, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V

    .line 1340
    iput v8, p0, Lcom/mixerbox/mixerbox3b/MainPage;->videoState:I

    .line 1341
    sput v6, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_REPEAT:I

    .line 1342
    sput-boolean v7, Lcom/mixerbox/mixerbox3b/MainPage;->PLAYER_SHUFFLE:Z

    .line 1343
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    .line 1344
    iput v6, p0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    .line 1346
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playerHeight:I

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    .line 1347
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playerHeight:I

    int-to-double v2, v0

    const-wide/high16 v4, 0x4030000000000000L    # 16.0

    mul-double/2addr v2, v4

    const-wide/high16 v4, 0x4022000000000000L    # 9.0

    div-double/2addr v2, v4

    double-to-int v0, v2

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W:I

    .line 1349
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W:I

    if-ge v1, v0, :cond_4

    .line 1350
    iput v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W:I

    .line 1352
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->wv:Landroid/webkit/WebView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "javascript:setScreenSize("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 1354
    const v0, 0x7f0700bd

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    .line 1355
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$17;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$17;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1371
    const v0, 0x7f0700bc

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 1372
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$18;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$18;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1383
    const v0, 0x7f0700c7

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    .line 1384
    const v0, 0x7f0700cc

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/SeekBar;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->seekbar:Landroid/widget/SeekBar;

    .line 1386
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnPlay:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$19;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$19;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1392
    const v0, 0x7f0700c8

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 1393
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$20;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$20;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1401
    const v0, 0x7f0700c6

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 1402
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$21;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$21;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1417
    const v0, 0x7f0700c3

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnAdd:Landroid/widget/ImageButton;

    .line 1418
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnAdd:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$22;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$22;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1427
    const v0, 0x7f0700c1

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 1428
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$23;

    invoke-direct {v1, p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage$23;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/widget/ImageButton;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1445
    const v0, 0x7f0700c0

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 1446
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$24;

    invoke-direct {v1, p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage$24;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/widget/ImageButton;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1469
    const v0, 0x7f0700c9

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnFullScreen:Landroid/widget/ImageButton;

    .line 1470
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnFullScreen:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$25;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$25;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1481
    const v0, 0x7f0700c2

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnQuality:Landroid/widget/ImageButton;

    .line 1482
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getHighQuality(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 1483
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnQuality:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200dd

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 1487
    :goto_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnQuality:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$26;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$26;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1516
    const v0, 0x7f0700c4

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnShare:Landroid/widget/ImageButton;

    .line 1517
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnShare:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$27;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$27;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1537
    const v0, 0x7f0700ca

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvTimeStart:Landroid/widget/TextView;

    .line 1539
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->seekbar:Landroid/widget/SeekBar;

    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$28;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/MainPage$28;-><init>(Lcom/mixerbox/mixerbox3b/MainPage;)V

    invoke-virtual {v0, v1}, Landroid/widget/SeekBar;->setOnSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 1575
    return-void

    .line 1264
    :cond_5
    iget v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_W_F:I

    .line 1265
    iget v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->JS_Player_H_F:I

    move v10, v0

    move v0, v1

    move v1, v10

    goto/16 :goto_0

    .line 1271
    :cond_6
    const/16 v0, 0xdc

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playerHeight:I

    goto/16 :goto_1

    .line 1294
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvSwitch:Landroid/widget/TextView;

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_2

    .line 1303
    :cond_8
    const-string v0, "http://static.mixerbox.com/yt_android.min.a.v7.html"

    .line 1304
    invoke-direct {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->setWebViewTouchListener()V

    goto/16 :goto_3

    .line 1485
    :cond_9
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnQuality:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f02010d

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_4
.end method

.method public setWeb(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 3332
    const/16 v0, 0xd

    iput v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentFragment:I

    .line 3333
    invoke-static {p1}, Lcom/mixerbox/mixerbox3b/fragments/WebFragment;->newInstance(Ljava/lang/String;)Lcom/mixerbox/mixerbox3b/fragments/WebFragment;

    move-result-object v0

    .line 3334
    const/4 v1, 0x1

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setFragment(Landroid/support/v4/app/Fragment;Z)V

    .line 3335
    return-void
.end method

.method public showPopupMenu()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 3944
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    invoke-virtual {v0, v4}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 3945
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    const-wide/16 v1, 0xfa0

    invoke-virtual {v0, v4, v1, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 3946
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 3947
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelBottom:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 3948
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 3949
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->btnExpand:Landroid/widget/ImageButton;

    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0200d3

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 3950
    return-void
.end method

.method public stopPlayer()V
    .locals 2

    .prologue
    .line 1886
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    if-eqz v0, :cond_0

    .line 1887
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->binder:Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService$MyBinder;->pauseMusic()V

    .line 1889
    :cond_0
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_1

    .line 1890
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->pause()V

    .line 1891
    :cond_1
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_2

    .line 1892
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->reset()V

    .line 1893
    :cond_2
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    if-eqz v0, :cond_3

    .line 1894
    sget-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    invoke-virtual {v0}, Landroid/media/MediaPlayer;->release()V

    .line 1895
    :cond_3
    const/4 v0, 0x0

    sput-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 1896
    new-instance v0, Landroid/media/MediaPlayer;

    invoke-direct {v0}, Landroid/media/MediaPlayer;-><init>()V

    sput-object v0, Lcom/mixerbox/mixerbox3b/services/MyService;->mediaPlayer:Landroid/media/MediaPlayer;

    .line 1897
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/services/PlayerService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopService(Landroid/content/Intent;)Z

    .line 1898
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/services/WindowPlayerService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopService(Landroid/content/Intent;)Z

    .line 1899
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/mixerbox/mixerbox3b/services/MyService;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/MainPage;->stopService(Landroid/content/Intent;)Z

    .line 1901
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->nm:Landroid/app/NotificationManager;

    const/16 v1, 0x10

    invoke-virtual {v0, v1}, Landroid/app/NotificationManager;->cancel(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1904
    :goto_0
    return-void

    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method public subscribePlaylist(Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;Z)V
    .locals 11

    .prologue
    const/4 v8, 0x2

    .line 3858
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->isLogIn:Z

    if-eqz v0, :cond_1

    .line 3859
    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0, p2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->subsPlaylist(Landroid/content/Context;Ljava/lang/String;Z)V

    .line 3880
    :cond_0
    :goto_0
    return-void

    .line 3861
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->DB:Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistSubsCount()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getIsAlbum()Z

    move-result v9

    invoke-virtual/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSQLite;->addPlaylist(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    .line 3865
    iget-object v10, p0, Lcom/mixerbox/mixerbox3b/MainPage;->arrayMySubsPlaylists:Ljava/util/ArrayList;

    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistOwnerName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistItemCount()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistSubsCount()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistCover()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getIsAlbum()Z

    move-result v9

    invoke-direct/range {v0 .. v9}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)V

    invoke-virtual {v10, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3869
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->mySubscriptions:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/mixerbox/mixerbox3b/classes/PlaylistItem;->getPlaylistId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3871
    if-eqz p2, :cond_0

    .line 3872
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0800e9

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 3873
    new-instance v0, Ljava/lang/Thread;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rLocalNotificationList:Ljava/lang/Runnable;

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 3874
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentPlaylists:Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/PlaylistsFragment;->loadContent()V

    .line 3875
    invoke-static {p0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getTipFirstSubscribe(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 3876
    const/4 v0, 0x7

    const/4 v1, 0x0

    new-array v1, v1, [Z

    invoke-virtual {p0, v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setOnboardingGuide(I[Z)Z

    goto/16 :goto_0
.end method

.method public updateTime(I)V
    .locals 4

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x2

    .line 1919
    iput p1, p0, Lcom/mixerbox/mixerbox3b/MainPage;->currentTime:I

    .line 1920
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->seekbar:Landroid/widget/SeekBar;

    invoke-virtual {v0}, Landroid/widget/SeekBar;->getMax()I

    move-result v0

    if-lt v0, p1, :cond_0

    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canUpdateSeekbar:Z

    if-eqz v0, :cond_0

    .line 1921
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->seekbar:Landroid/widget/SeekBar;

    invoke-virtual {v0, p1}, Landroid/widget/SeekBar;->setProgress(I)V

    .line 1922
    :cond_0
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->canUpdateSeekbar:Z

    if-eqz v0, :cond_1

    .line 1923
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->tvTimeStart:Landroid/widget/TextView;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongTime(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 1924
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelTop:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-ne v0, v3, :cond_2

    .line 1925
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->rlPanelPopup:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 1926
    :cond_2
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldCheckNotificationBtn:Z

    if-eqz v0, :cond_5

    const/4 v0, 0x1

    if-eq p1, v0, :cond_3

    if-ne p1, v2, :cond_5

    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    const/4 v1, 0x3

    if-eq v0, v1, :cond_4

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->playingSong:Lcom/mixerbox/mixerbox3b/classes/SongItem;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/SongItem;->getSongSource()I

    move-result v0

    if-ne v0, v2, :cond_5

    .line 1930
    :cond_4
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/MainPage;->shouldCheckNotificationBtn:Z

    .line 1931
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/MainPage;->sendNotification()V

    .line 1933
    :cond_5
    return-void
.end method
