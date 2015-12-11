.class synthetic Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;
.super Ljava/lang/Object;
.source "PrimeTimePlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState:[I

.field static final synthetic $SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType:[I

.field static final synthetic $SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow:[I

.field static final synthetic $SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 1217
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->values()[Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    :try_start_0
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->BITRATE_PARAMS:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_f

    :goto_0
    :try_start_1
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->INITIAL_BITRATE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_e

    :goto_1
    :try_start_2
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->BITRATE_RANGE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_d

    :goto_2
    :try_start_3
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTION_FORMAT:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_c

    :goto_3
    :try_start_4
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTIONS_ENABLED:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_b

    :goto_4
    :try_start_5
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTIONS_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_a

    :goto_5
    :try_start_6
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$player$PlayerSettings$Setting:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AUDIO_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_9

    .line 1070
    :goto_6
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->values()[Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow:[I

    :try_start_7
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->STREAMING:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_8

    :goto_7
    :try_start_8
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->LOCAL:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_7

    :goto_8
    :try_start_9
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$comcast$playerplatform$primetime$android$enums$DrmWorkflow:[I

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->WHITE_LIST:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_6

    .line 895
    :goto_9
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;->values()[Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType:[I

    :try_start_a
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType:[I

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;->ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_5

    :goto_a
    :try_start_b
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayerNotification$EntryType:[I

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;->WARN:Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayerNotification$EntryType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_4

    .line 783
    :goto_b
    invoke-static {}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->values()[Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState:[I

    :try_start_c
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState:[I

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_c
    .catch Ljava/lang/NoSuchFieldError; {:try_start_c .. :try_end_c} :catch_3

    :goto_c
    :try_start_d
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState:[I

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_d .. :try_end_d} :catch_2

    :goto_d
    :try_start_e
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState:[I

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_e
    .catch Ljava/lang/NoSuchFieldError; {:try_start_e .. :try_end_e} :catch_1

    :goto_e
    :try_start_f
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/primetime/PrimeTimePlayer$9;->$SwitchMap$com$adobe$mediacore$MediaPlayer$PlayerState:[I

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_f
    .catch Ljava/lang/NoSuchFieldError; {:try_start_f .. :try_end_f} :catch_0

    :goto_f
    return-void

    :catch_0
    move-exception v0

    goto :goto_f

    :catch_1
    move-exception v0

    goto :goto_e

    :catch_2
    move-exception v0

    goto :goto_d

    :catch_3
    move-exception v0

    goto :goto_c

    .line 895
    :catch_4
    move-exception v0

    goto :goto_b

    :catch_5
    move-exception v0

    goto :goto_a

    .line 1070
    :catch_6
    move-exception v0

    goto :goto_9

    :catch_7
    move-exception v0

    goto :goto_8

    :catch_8
    move-exception v0

    goto :goto_7

    .line 1217
    :catch_9
    move-exception v0

    goto/16 :goto_6

    :catch_a
    move-exception v0

    goto/16 :goto_5

    :catch_b
    move-exception v0

    goto/16 :goto_4

    :catch_c
    move-exception v0

    goto/16 :goto_3

    :catch_d
    move-exception v0

    goto/16 :goto_2

    :catch_e
    move-exception v0

    goto/16 :goto_1

    :catch_f
    move-exception v0

    goto/16 :goto_0
.end method
