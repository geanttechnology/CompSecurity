.class public final Ltv/freewheel/hybrid/ad/Constants;
.super Ljava/lang/Object;
.source "Constants.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IConstants;


# static fields
.field public static _USER_ACTION_PAUSE_BUTTON_CLICKED:I

.field public static _USER_ACTION_RESUME_BUTTON_CLICKED:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 210
    const/4 v0, 0x1

    sput v0, Ltv/freewheel/hybrid/ad/Constants;->_USER_ACTION_PAUSE_BUTTON_CLICKED:I

    .line 211
    const/4 v0, 0x2

    sput v0, Ltv/freewheel/hybrid/ad/Constants;->_USER_ACTION_RESUME_BUTTON_CLICKED:I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final ACTIVITY_CALLBACK_PAUSE()I
    .locals 1

    .prologue
    .line 405
    const/4 v0, 0x4

    return v0
.end method

.method public final ACTIVITY_CALLBACK_RESUME()I
    .locals 1

    .prologue
    .line 410
    const/4 v0, 0x5

    return v0
.end method

.method public final CAPABILITY_STATUS_OFF()I
    .locals 1

    .prologue
    .line 220
    const/4 v0, 0x1

    return v0
.end method

.method public final CAPABILITY_STATUS_ON()I
    .locals 1

    .prologue
    .line 215
    const/4 v0, 0x0

    return v0
.end method

.method public final ERROR_INVALID_SLOT()Ljava/lang/String;
    .locals 1

    .prologue
    .line 940
    const-string v0, "_e_invalid-slot"

    return-object v0
.end method

.method public final ERROR_INVALID_VALUE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 930
    const-string v0, "_e_invalid-value"

    return-object v0
.end method

.method public final ERROR_IO()Ljava/lang/String;
    .locals 1

    .prologue
    .line 890
    const-string v0, "_e_io"

    return-object v0
.end method

.method public final ERROR_NO_AD_AVAILABLE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 920
    const-string v0, "_e_no-ad"

    return-object v0
.end method

.method public final ERROR_NULL_ASSET()Ljava/lang/String;
    .locals 1

    .prologue
    .line 900
    const-string v0, "_e_null-asset"

    return-object v0
.end method

.method public final ERROR_PARSE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 925
    const-string v0, "_e_parse"

    return-object v0
.end method

.method public final ERROR_RENDERER_INIT()Ljava/lang/String;
    .locals 1

    .prologue
    .line 950
    const-string v0, "_e_renderer_init"

    return-object v0
.end method

.method public final ERROR_TIMEOUT()Ljava/lang/String;
    .locals 1

    .prologue
    .line 895
    const-string v0, "_e_timeout"

    return-object v0
.end method

.method public final ERROR_UNKNOWN()Ljava/lang/String;
    .locals 1

    .prologue
    .line 910
    const-string v0, "_e_unknown"

    return-object v0
.end method

.method public final ERROR_UNSUPPORTED_3P_FEATURE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 945
    const-string v0, "_e_unsupp-3p-feature"

    return-object v0
.end method

.method public final EVENT_ACTIVITY_STATE_CHANGED()Ljava/lang/String;
    .locals 1

    .prologue
    .line 460
    const-string v0, "activityStateChanged"

    return-object v0
.end method

.method public final EVENT_AD_ACCEPT_INVITATION()Ljava/lang/String;
    .locals 1

    .prologue
    .line 679
    const-string v0, "_accept-invitation"

    return-object v0
.end method

.method public final EVENT_AD_CLICK()Ljava/lang/String;
    .locals 1

    .prologue
    .line 639
    const-string v0, "defaultClick"

    return-object v0
.end method

.method public final EVENT_AD_CLOSE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 684
    const-string v0, "_close"

    return-object v0
.end method

.method public final EVENT_AD_COLLAPSE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 654
    const-string v0, "_collapse"

    return-object v0
.end method

.method public final EVENT_AD_COMPLETE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 634
    const-string v0, "complete"

    return-object v0
.end method

.method public final EVENT_AD_EXPAND()Ljava/lang/String;
    .locals 1

    .prologue
    .line 659
    const-string v0, "_expand"

    return-object v0
.end method

.method public final EVENT_AD_FIRST_QUARTILE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 619
    const-string v0, "firstQuartile"

    return-object v0
.end method

.method public final EVENT_AD_IMPRESSION()Ljava/lang/String;
    .locals 1

    .prologue
    .line 604
    const-string v0, "defaultImpression"

    return-object v0
.end method

.method public final EVENT_AD_LOADED()Ljava/lang/String;
    .locals 1

    .prologue
    .line 694
    const-string v0, "loaded"

    return-object v0
.end method

.method public final EVENT_AD_MIDPOINT()Ljava/lang/String;
    .locals 1

    .prologue
    .line 624
    const-string v0, "midPoint"

    return-object v0
.end method

.method public final EVENT_AD_MUTE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 644
    const-string v0, "_mute"

    return-object v0
.end method

.method public final EVENT_AD_PAUSE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 664
    const-string v0, "_pause"

    return-object v0
.end method

.method public final EVENT_AD_QUARTILE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 614
    const-string v0, "quartile"

    return-object v0
.end method

.method public final EVENT_AD_RESUME()Ljava/lang/String;
    .locals 1

    .prologue
    .line 669
    const-string v0, "_resume"

    return-object v0
.end method

.method public final EVENT_AD_REWIND()Ljava/lang/String;
    .locals 1

    .prologue
    .line 674
    const-string v0, "_rewind"

    return-object v0
.end method

.method public final EVENT_AD_STARTED()Ljava/lang/String;
    .locals 1

    .prologue
    .line 699
    const-string v0, "started"

    return-object v0
.end method

.method public final EVENT_AD_STOPPED()Ljava/lang/String;
    .locals 1

    .prologue
    .line 704
    const-string v0, "stopped"

    return-object v0
.end method

.method public final EVENT_AD_THIRD_QUARTILE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 629
    const-string v0, "thirdQuartile"

    return-object v0
.end method

.method public final EVENT_AD_UNMUTE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 649
    const-string v0, "_un-mute"

    return-object v0
.end method

.method public final EVENT_ERROR()Ljava/lang/String;
    .locals 1

    .prologue
    .line 709
    const-string v0, "_e_unknown"

    return-object v0
.end method

.method public EVENT_PROGRESS_UPDATE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1090
    const-string v0, "EVENT_PRORESS_UPDATE"

    return-object v0
.end method

.method public final EVENT_REQUEST_COMPLETE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 425
    const-string v0, "requestComplete"

    return-object v0
.end method

.method public final EVENT_REQUEST_CONTENT_VIDEO_PAUSE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 430
    const-string v0, "requestContentVideoPause"

    return-object v0
.end method

.method public final EVENT_REQUEST_CONTENT_VIDEO_RESUME()Ljava/lang/String;
    .locals 1

    .prologue
    .line 435
    const-string v0, "requestContentVideoResume"

    return-object v0
.end method

.method public final EVENT_SLOT_ENDED()Ljava/lang/String;
    .locals 1

    .prologue
    .line 445
    const-string v0, "slotEnded"

    return-object v0
.end method

.method public final EVENT_SLOT_STARTED()Ljava/lang/String;
    .locals 1

    .prologue
    .line 440
    const-string v0, "slotStarted"

    return-object v0
.end method

.method public final EVENT_TYPE_CLICK()Ljava/lang/String;
    .locals 1

    .prologue
    .line 729
    const-string v0, "CLICK"

    return-object v0
.end method

.method public final EVENT_TYPE_CLICK_TRACKING()Ljava/lang/String;
    .locals 1

    .prologue
    .line 719
    const-string v0, "CLICKTRACKING"

    return-object v0
.end method

.method public final EVENT_TYPE_IMPRESSION()Ljava/lang/String;
    .locals 1

    .prologue
    .line 724
    const-string v0, "IMPRESSION"

    return-object v0
.end method

.method public final EVENT_TYPE_STANDARD()Ljava/lang/String;
    .locals 1

    .prologue
    .line 734
    const-string v0, "STANDARD"

    return-object v0
.end method

.method public final EVENT_USER_ACTION_NOTIFIED()Ljava/lang/String;
    .locals 1

    .prologue
    .line 455
    const-string v0, "userActionNotified"

    return-object v0
.end method

.method public final INFO_KEY_ACTIVITY_STATE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 861
    const-string v0, "activityState"

    return-object v0
.end method

.method public final INFO_KEY_AD_ID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 841
    const-string v0, "adId"

    return-object v0
.end method

.method public final INFO_KEY_CUSTOM_ID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 812
    const-string v0, "customId"

    return-object v0
.end method

.method public final INFO_KEY_ERROR_CODE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 876
    const-string v0, "errorCode"

    return-object v0
.end method

.method public final INFO_KEY_ERROR_INFO()Ljava/lang/String;
    .locals 1

    .prologue
    .line 881
    const-string v0, "errorInfo"

    return-object v0
.end method

.method public final INFO_KEY_EXTRA_INFO()Ljava/lang/String;
    .locals 1

    .prologue
    .line 832
    const-string v0, "extraInfo"

    return-object v0
.end method

.method public final INFO_KEY_MESSAGE()Ljava/lang/String;
    .locals 1

    .prologue
    .line 817
    const-string v0, "message"

    return-object v0
.end method

.method public final INFO_KEY_REPLICA_ID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 851
    const-string v0, "replicaId"

    return-object v0
.end method

.method public INFO_KEY_SUCCESS()Ljava/lang/String;
    .locals 1

    .prologue
    .line 970
    const-string v0, "success"

    return-object v0
.end method

.method public final INFO_KEY_URL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 807
    const-string v0, "url"

    return-object v0
.end method

.method public final INFO_KEY_USER_ACTION()Ljava/lang/String;
    .locals 1

    .prologue
    .line 856
    const-string v0, "userAction"

    return-object v0
.end method

.method public final PARAMETER_LEVEL_GLOBAL()I
    .locals 1

    .prologue
    .line 320
    const/4 v0, 0x1

    return v0
.end method

.method public final PARAMETER_LEVEL_OVERRIDE()I
    .locals 1

    .prologue
    .line 340
    const/4 v0, 0x5

    return v0
.end method

.method public final PARAMETER_REQUEST_ALTERNATIVE_URL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 739
    const-string v0, "_fw_request_alternative_url"

    return-object v0
.end method

.method public final SLOT_TYPE_TEMPORAL()I
    .locals 1

    .prologue
    .line 300
    const/4 v0, 0x0

    return v0
.end method

.method public final TIME_POSITION_CLASS_DISPLAY()I
    .locals 1

    .prologue
    .line 530
    const/4 v0, 0x5

    return v0
.end method

.method public final TIME_POSITION_CLASS_MIDROLL()I
    .locals 1

    .prologue
    .line 515
    const/4 v0, 0x2

    return v0
.end method

.method public final TIME_POSITION_CLASS_OVERLAY()I
    .locals 1

    .prologue
    .line 525
    const/4 v0, 0x4

    return v0
.end method

.method public final TIME_POSITION_CLASS_PAUSE_MIDROLL()I
    .locals 1

    .prologue
    .line 535
    const/4 v0, 0x6

    return v0
.end method

.method public final TIME_POSITION_CLASS_POSTROLL()I
    .locals 1

    .prologue
    .line 520
    const/4 v0, 0x3

    return v0
.end method

.method public final TIME_POSITION_CLASS_PREROLL()I
    .locals 1

    .prologue
    .line 510
    const/4 v0, 0x1

    return v0
.end method

.method public TIME_POSITION_STRING()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1085
    const-string v0, "TIME_POTISION"

    return-object v0
.end method

.method public USER_ACTION_PAUSE_BUTTON_CLICKED()I
    .locals 1

    .prologue
    .line 1075
    sget v0, Ltv/freewheel/hybrid/ad/Constants;->_USER_ACTION_PAUSE_BUTTON_CLICKED:I

    return v0
.end method

.method public USER_ACTION_RESUME_BUTTON_CLICKED()I
    .locals 1

    .prologue
    .line 1080
    sget v0, Ltv/freewheel/hybrid/ad/Constants;->_USER_ACTION_RESUME_BUTTON_CLICKED:I

    return v0
.end method
