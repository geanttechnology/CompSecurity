.class public Lcom/auditude/ads/reporting/ReportingHelper;
.super Ljava/lang/Object;
.source "ReportingHelper.java"

# interfaces
.implements Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;
.implements Lcom/auditude/ads/util/event/IEventListener;


# static fields
.field private static synthetic $SWITCH_TABLE$com$auditude$ads$event$SMILEvent$SMILEventType:[I

.field private static synthetic $SWITCH_TABLE$com$auditude$ads$view$AdViewEvent$AdViewEventType:[I


# instance fields
.field private api:Lcom/auditude/ads/core/APIBridge;

.field private isInitialized:Z

.field private par:Lcom/auditude/ads/model/smil/Par;

.field private pendingTimeouts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/util/TimeoutUtil;",
            ">;"
        }
    .end annotation
.end field

.field private sequence:Lcom/auditude/ads/model/smil/Sequence;

.field private submissions:Lcom/auditude/ads/model/tracking/Submissions;


# direct methods
.method static synthetic $SWITCH_TABLE$com$auditude$ads$event$SMILEvent$SMILEventType()[I
    .locals 3

    .prologue
    .line 34
    sget-object v0, Lcom/auditude/ads/reporting/ReportingHelper;->$SWITCH_TABLE$com$auditude$ads$event$SMILEvent$SMILEventType:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->values()[Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->PAR_BEGIN:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_3

    :goto_1
    :try_start_1
    sget-object v1, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->PAR_END:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_2

    :goto_2
    :try_start_2
    sget-object v1, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->SEQUENCE_BEGIN:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_1

    :goto_3
    :try_start_3
    sget-object v1, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->SEQUENCE_END:Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_0

    :goto_4
    sput-object v0, Lcom/auditude/ads/reporting/ReportingHelper;->$SWITCH_TABLE$com$auditude$ads$event$SMILEvent$SMILEventType:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_4

    :catch_1
    move-exception v1

    goto :goto_3

    :catch_2
    move-exception v1

    goto :goto_2

    :catch_3
    move-exception v1

    goto :goto_1
.end method

.method static synthetic $SWITCH_TABLE$com$auditude$ads$view$AdViewEvent$AdViewEventType()[I
    .locals 3

    .prologue
    .line 34
    sget-object v0, Lcom/auditude/ads/reporting/ReportingHelper;->$SWITCH_TABLE$com$auditude$ads$view$AdViewEvent$AdViewEventType:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->values()[Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_CLICK:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/16 v2, 0xb

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_d

    :goto_1
    :try_start_1
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_COMPLETE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_c

    :goto_2
    :try_start_2
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_ERROR:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/16 v2, 0xa

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_b

    :goto_3
    :try_start_3
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_LOAD:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_a

    :goto_4
    :try_start_4
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_LOG:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/16 v2, 0x9

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_9

    :goto_5
    :try_start_5
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_PAUSE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_8

    :goto_6
    :try_start_6
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_PROGRESS:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_7

    :goto_7
    :try_start_7
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_REPLAY:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_6

    :goto_8
    :try_start_8
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_RESUME:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_5

    :goto_9
    :try_start_9
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_SKIP:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/16 v2, 0xe

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_4

    :goto_a
    :try_start_a
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_START:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_3

    :goto_b
    :try_start_b
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_STOP:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_2

    :goto_c
    :try_start_c
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_USER_CLOSE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/16 v2, 0xd

    aput v2, v0, v1
    :try_end_c
    .catch Ljava/lang/NoSuchFieldError; {:try_start_c .. :try_end_c} :catch_1

    :goto_d
    :try_start_d
    sget-object v1, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->AD_VOLUME_CHANGE:Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    const/16 v2, 0xc

    aput v2, v0, v1
    :try_end_d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_d .. :try_end_d} :catch_0

    :goto_e
    sput-object v0, Lcom/auditude/ads/reporting/ReportingHelper;->$SWITCH_TABLE$com$auditude$ads$view$AdViewEvent$AdViewEventType:[I

    goto/16 :goto_0

    :catch_0
    move-exception v1

    goto :goto_e

    :catch_1
    move-exception v1

    goto :goto_d

    :catch_2
    move-exception v1

    goto :goto_c

    :catch_3
    move-exception v1

    goto :goto_b

    :catch_4
    move-exception v1

    goto :goto_a

    :catch_5
    move-exception v1

    goto :goto_9

    :catch_6
    move-exception v1

    goto :goto_8

    :catch_7
    move-exception v1

    goto :goto_7

    :catch_8
    move-exception v1

    goto :goto_6

    :catch_9
    move-exception v1

    goto :goto_5

    :catch_a
    move-exception v1

    goto :goto_4

    :catch_b
    move-exception v1

    goto/16 :goto_3

    :catch_c
    move-exception v1

    goto/16 :goto_2

    :catch_d
    move-exception v1

    goto/16 :goto_1
.end method

.method public constructor <init>(Lcom/auditude/ads/core/APIBridge;)V
    .locals 2
    .param p1, "api"    # Lcom/auditude/ads/core/APIBridge;

    .prologue
    const/16 v1, 0x64

    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 40
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->isInitialized:Z

    .line 42
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->pendingTimeouts:Ljava/util/ArrayList;

    .line 56
    iput-object p1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->api:Lcom/auditude/ads/core/APIBridge;

    .line 58
    const-string v0, "adViewEvent"

    invoke-virtual {p1, v0, p0, v1}, Lcom/auditude/ads/core/APIBridge;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;I)V

    .line 59
    const-string v0, "smilEvent"

    invoke-virtual {p1, v0, p0, v1}, Lcom/auditude/ads/core/APIBridge;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;I)V

    .line 60
    const-string v0, "playerError"

    invoke-virtual {p1, v0, p0, v1}, Lcom/auditude/ads/core/APIBridge;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;I)V

    .line 61
    return-void
.end method

.method private getErrorSubmissionUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    .line 549
    const-string v0, "http://"

    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "https://"

    invoke-virtual {p1, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    if-nez v0, :cond_1

    .line 551
    :cond_0
    const-string v0, "http://ad.auditude.com/adserver/e?type=playererror"

    .line 554
    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://ad."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/adserver/e?type=playererror"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private getProgressState(ILjava/lang/String;)Ljava/util/HashMap;
    .locals 3
    .param p1, "progress"    # I
    .param p2, "unit"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 508
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 509
    .local v0, "state":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v1, "progress"

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 510
    const-string v1, "unit"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 511
    return-object v0
.end method

.method private getSubmissionState()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 609
    iget-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    invoke-virtual {v0}, Lcom/auditude/ads/model/tracking/Submissions;->getState()Ljava/util/HashMap;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 7
    .param p1, "element"    # Lcom/auditude/ads/model/BaseElement;
    .param p2, "sequence"    # Lcom/auditude/ads/model/smil/Sequence;
    .param p3, "par"    # Lcom/auditude/ads/model/smil/Par;
    .param p4, "trackingType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/auditude/ads/model/BaseElement;",
            "Lcom/auditude/ads/model/smil/Sequence;",
            "Lcom/auditude/ads/model/smil/Par;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 326
    .local p5, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-direct/range {v0 .. v6}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;Z)V

    .line 327
    return-void
.end method

.method private logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;Z)V
    .locals 8
    .param p1, "element"    # Lcom/auditude/ads/model/BaseElement;
    .param p2, "sequence"    # Lcom/auditude/ads/model/smil/Sequence;
    .param p3, "par"    # Lcom/auditude/ads/model/smil/Par;
    .param p4, "trackingType"    # Ljava/lang/String;
    .param p6, "force"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/auditude/ads/model/BaseElement;",
            "Lcom/auditude/ads/model/smil/Sequence;",
            "Lcom/auditude/ads/model/smil/Par;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .local p5, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v5, 0x0

    .line 331
    if-nez p1, :cond_1

    .line 355
    :cond_0
    return-void

    .line 336
    :cond_1
    invoke-virtual {p1, p4}, Lcom/auditude/ads/model/BaseElement;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v1

    .line 337
    .local v1, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v4

    if-eqz v4, :cond_0

    invoke-virtual {v1}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_0

    .line 339
    invoke-direct {p0}, Lcom/auditude/ads/reporting/ReportingHelper;->getSubmissionState()Ljava/util/HashMap;

    move-result-object v7

    .line 340
    if-eqz p2, :cond_2

    invoke-virtual {p2}, Lcom/auditude/ads/model/smil/Sequence;->getState()Ljava/util/HashMap;

    move-result-object v4

    move-object v6, v4

    :goto_0
    if-eqz p3, :cond_3

    invoke-virtual {p3}, Lcom/auditude/ads/model/smil/Par;->getState()Ljava/util/HashMap;

    move-result-object v4

    :goto_1
    invoke-static {v6, v4}, Lcom/auditude/ads/util/ObjectUtil;->merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v4

    .line 339
    invoke-static {v7, v4}, Lcom/auditude/ads/util/ObjectUtil;->merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v0

    .line 341
    .local v0, "podData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {v0, p5}, Lcom/auditude/ads/util/ObjectUtil;->merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v2

    .line 343
    .local v2, "trackingParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v1}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 345
    .local v3, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    instance-of v6, v3, Lcom/auditude/ads/model/tracking/Submission;

    if-eqz v6, :cond_4

    .line 347
    invoke-virtual {v3, p6, v2}, Lcom/auditude/ads/model/tracking/TrackingUrl;->log(ZLjava/util/HashMap;)V

    goto :goto_2

    .end local v0    # "podData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "trackingParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    :cond_2
    move-object v6, v5

    .line 340
    goto :goto_0

    :cond_3
    move-object v4, v5

    goto :goto_1

    .line 351
    .restart local v0    # "podData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v2    # "trackingParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v3    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    :cond_4
    invoke-virtual {v3, p6, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;->log(ZLjava/util/HashMap;)V

    goto :goto_2
.end method

.method private logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 1
    .param p1, "element"    # Lcom/auditude/ads/model/BaseElement;
    .param p2, "trackingType"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/auditude/ads/model/BaseElement;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 480
    .local p3, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;Z)V

    .line 481
    return-void
.end method

.method private logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;Z)V
    .locals 5
    .param p1, "element"    # Lcom/auditude/ads/model/BaseElement;
    .param p2, "trackingType"    # Ljava/lang/String;
    .param p4, "force"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/auditude/ads/model/BaseElement;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 485
    .local p3, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p1, :cond_1

    .line 504
    :cond_0
    return-void

    .line 487
    :cond_1
    invoke-virtual {p1, p2}, Lcom/auditude/ads/model/BaseElement;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v0

    .line 488
    .local v0, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v0}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 490
    invoke-virtual {p0}, Lcom/auditude/ads/reporting/ReportingHelper;->currentPodState()Ljava/util/HashMap;

    move-result-object v3

    invoke-static {v3, p3}, Lcom/auditude/ads/util/ObjectUtil;->merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v1

    .line 492
    .local v1, "trackingParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v0}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 494
    .local v2, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    instance-of v4, v2, Lcom/auditude/ads/model/tracking/Submission;

    if-eqz v4, :cond_2

    .line 496
    invoke-virtual {v2, p4, v1}, Lcom/auditude/ads/model/tracking/TrackingUrl;->log(ZLjava/util/HashMap;)V

    goto :goto_0

    .line 500
    :cond_2
    const/4 v4, 0x0

    invoke-virtual {v2, p4, v4}, Lcom/auditude/ads/model/tracking/TrackingUrl;->log(ZLjava/util/HashMap;)V

    goto :goto_0
.end method

.method private logSequenceProgress(Lcom/auditude/ads/model/smil/Sequence;Ljava/lang/String;Z)V
    .locals 7
    .param p1, "seq"    # Lcom/auditude/ads/model/smil/Sequence;
    .param p2, "eventType"    # Ljava/lang/String;
    .param p3, "advancePattern"    # Z

    .prologue
    const/4 v4, 0x0

    .line 207
    iget-object v5, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    if-eqz v5, :cond_0

    if-nez p1, :cond_1

    .line 226
    :cond_0
    :goto_0
    return-void

    .line 209
    :cond_1
    const/4 v0, 0x0

    .line 210
    .local v0, "submission":Lcom/auditude/ads/model/tracking/Submission;
    iget-object v5, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    if-eqz v5, :cond_3

    iget-object v5, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Sequence;->getSubmissionId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/auditude/ads/model/tracking/Submissions;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v2

    .line 211
    .local v2, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    :goto_1
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_2

    .line 213
    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v5

    const/4 v6, 0x0

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 214
    .local v1, "tempVar":Lcom/auditude/ads/model/tracking/TrackingUrl;
    instance-of v5, v1, Lcom/auditude/ads/model/tracking/Submission;

    if-eqz v5, :cond_4

    move-object v0, v1

    .end local v0    # "submission":Lcom/auditude/ads/model/tracking/Submission;
    :goto_2
    check-cast v0, Lcom/auditude/ads/model/tracking/Submission;

    .line 217
    .end local v1    # "tempVar":Lcom/auditude/ads/model/tracking/TrackingUrl;
    .restart local v0    # "submission":Lcom/auditude/ads/model/tracking/Submission;
    :cond_2
    if-eqz v0, :cond_0

    .line 219
    invoke-direct {p0}, Lcom/auditude/ads/reporting/ReportingHelper;->getSubmissionState()Ljava/util/HashMap;

    move-result-object v4

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Sequence;->getState()Ljava/util/HashMap;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/auditude/ads/util/ObjectUtil;->merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v3

    .line 220
    .local v3, "trackingParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v4, "event"

    invoke-virtual {v3, v4, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 221
    const-string v5, "advancepattern"

    if-eqz p3, :cond_5

    const-string v4, "1"

    :goto_3
    invoke-virtual {v3, v5, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 224
    const/4 v4, 0x1

    invoke-virtual {v0, v4, v3}, Lcom/auditude/ads/model/tracking/Submission;->log(ZLjava/util/HashMap;)V

    goto :goto_0

    .end local v2    # "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    .end local v3    # "trackingParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_3
    move-object v2, v4

    .line 210
    goto :goto_1

    .restart local v1    # "tempVar":Lcom/auditude/ads/model/tracking/TrackingUrl;
    .restart local v2    # "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    :cond_4
    move-object v0, v4

    .line 214
    goto :goto_2

    .line 221
    .end local v1    # "tempVar":Lcom/auditude/ads/model/tracking/TrackingUrl;
    .restart local v3    # "trackingParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_5
    const-string v4, "0"

    goto :goto_3
.end method

.method private onAdClick(Lcom/auditude/ads/view/AdViewEvent;)V
    .locals 4
    .param p1, "e"    # Lcom/auditude/ads/view/AdViewEvent;

    .prologue
    const/4 v1, 0x0

    .line 383
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/model/IAsset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 385
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/model/IAsset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v0

    instance-of v0, v0, Lcom/auditude/ads/model/Click;

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/model/IAsset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v0

    :goto_0
    check-cast v0, Lcom/auditude/ads/model/Click;

    const-string v2, "click"

    const/4 v3, 0x1

    invoke-direct {p0, v0, v2, v1, v3}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;Z)V

    .line 387
    :cond_0
    return-void

    :cond_1
    move-object v0, v1

    .line 385
    goto :goto_0
.end method

.method private onAdComplete(Lcom/auditude/ads/view/AdViewEvent;)V
    .locals 5
    .param p1, "e"    # Lcom/auditude/ads/view/AdViewEvent;

    .prologue
    const/4 v1, 0x0

    .line 373
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 375
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    instance-of v0, v0, Lcom/auditude/ads/model/Asset;

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    :goto_0
    check-cast v0, Lcom/auditude/ads/model/Asset;

    const-string v2, "complete"

    const/16 v3, 0x64

    const-string v4, "percent"

    invoke-direct {p0, v3, v4}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v3

    invoke-direct {p0, v0, v2, v3}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    .line 376
    invoke-static {v1}, Lcom/auditude/ads/util/AuditudeUtil;->setAssetURI(Ljava/lang/String;)V

    .line 378
    :cond_0
    return-void

    :cond_1
    move-object v0, v1

    .line 375
    goto :goto_0
.end method

.method private onAdError(Lcom/auditude/ads/view/AdViewEvent;)V
    .locals 7
    .param p1, "e"    # Lcom/auditude/ads/view/AdViewEvent;

    .prologue
    const/4 v6, 0x0

    .line 452
    const/16 v1, 0x190

    .line 453
    .local v1, "errorCode":I
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v4

    invoke-interface {v4}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 455
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v4

    invoke-interface {v4}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v4

    instance-of v4, v4, Lcom/auditude/ads/model/NonLinearAsset;

    if-eqz v4, :cond_0

    .line 457
    const/16 v1, 0x1f4

    .line 460
    :cond_0
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v4

    invoke-interface {v4}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Asset;

    .line 461
    .local v0, "asset":Lcom/auditude/ads/model/Asset;
    if-eqz v0, :cond_1

    .line 464
    const-string v4, "vasterror"

    invoke-virtual {v0, v4}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v2

    .line 465
    .local v2, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 467
    invoke-virtual {v0}, Lcom/auditude/ads/model/Asset;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/auditude/ads/util/AuditudeUtil;->setAssetURI(Ljava/lang/String;)V

    .line 468
    invoke-virtual {v2}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_2

    .line 472
    invoke-static {v6}, Lcom/auditude/ads/util/AuditudeUtil;->setAssetURI(Ljava/lang/String;)V

    .line 476
    .end local v0    # "asset":Lcom/auditude/ads/model/Asset;
    .end local v2    # "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    :cond_1
    return-void

    .line 468
    .restart local v0    # "asset":Lcom/auditude/ads/model/Asset;
    .restart local v2    # "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    :cond_2
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 470
    .local v3, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    const/4 v5, 0x0

    invoke-virtual {v3, v5, v6, v1}, Lcom/auditude/ads/model/tracking/TrackingUrl;->log(ZLjava/util/HashMap;I)V

    goto :goto_0
.end method

.method private onAdProgress(Lcom/auditude/ads/view/AdViewEvent;)V
    .locals 13
    .param p1, "e"    # Lcom/auditude/ads/view/AdViewEvent;

    .prologue
    const/4 v7, 0x0

    const/high16 v12, 0x42c80000    # 100.0f

    const/high16 v11, 0x42960000    # 75.0f

    const/high16 v10, 0x42480000    # 50.0f

    const/high16 v9, 0x41c80000    # 25.0f

    .line 399
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v8

    if-eqz v8, :cond_2

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v8

    invoke-interface {v8}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v8

    instance-of v8, v8, Lcom/auditude/ads/model/Asset;

    if-eqz v8, :cond_0

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v7

    invoke-interface {v7}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v7

    :cond_0
    check-cast v7, Lcom/auditude/ads/model/Asset;

    move-object v0, v7

    .line 400
    .local v0, "asset":Lcom/auditude/ads/model/Asset;
    :goto_0
    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getView()Lcom/auditude/ads/view/IAdView;

    move-result-object v7

    if-nez v7, :cond_3

    .line 448
    :cond_1
    return-void

    .end local v0    # "asset":Lcom/auditude/ads/model/Asset;
    :cond_2
    move-object v0, v7

    .line 399
    goto :goto_0

    .line 402
    .restart local v0    # "asset":Lcom/auditude/ads/model/Asset;
    :cond_3
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getView()Lcom/auditude/ads/view/IAdView;

    move-result-object v7

    invoke-interface {v7}, Lcom/auditude/ads/view/IAdView;->getDuration()I

    move-result v1

    .line 403
    .local v1, "duration":I
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getView()Lcom/auditude/ads/view/IAdView;

    move-result-object v7

    invoke-interface {v7}, Lcom/auditude/ads/view/IAdView;->getPosition()I

    move-result v3

    .line 407
    .local v3, "position":I
    if-gtz v1, :cond_8

    const/4 v2, 0x0

    .line 411
    .local v2, "percentComplete":F
    :goto_1
    cmpg-float v7, v2, v9

    if-gez v7, :cond_9

    .line 413
    const-string v7, "start"

    const/4 v8, 0x0

    const-string v9, "percent"

    invoke-direct {p0, v8, v9}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v8

    invoke-direct {p0, v0, v7, v8}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    .line 432
    :cond_4
    :goto_2
    const-string v7, "progress"

    invoke-virtual {v0, v7}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v4

    .line 433
    .local v4, "progressEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v4, :cond_1

    .line 435
    invoke-virtual {v4}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_5
    :goto_3
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 437
    .local v6, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->isLogged()Z

    move-result v8

    if-nez v8, :cond_5

    .line 439
    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getOffsetIsPercent()Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    if-eqz v8, :cond_6

    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getOffset()I

    move-result v8

    int-to-float v8, v8

    cmpl-float v8, v2, v8

    if-gez v8, :cond_7

    :cond_6
    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getOffsetIsPercent()Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v8

    if-nez v8, :cond_5

    invoke-virtual {v6}, Lcom/auditude/ads/model/tracking/TrackingUrl;->getOffset()I

    move-result v8

    if-lt v3, v8, :cond_5

    .line 441
    :cond_7
    invoke-virtual {p0}, Lcom/auditude/ads/reporting/ReportingHelper;->currentPodState()Ljava/util/HashMap;

    move-result-object v8

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v9

    const-string v10, "percent"

    invoke-direct {p0, v9, v10}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/auditude/ads/util/ObjectUtil;->merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v5

    .line 442
    .local v5, "trackingParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v8, 0x1

    invoke-virtual {v6, v8, v5}, Lcom/auditude/ads/model/tracking/TrackingUrl;->log(ZLjava/util/HashMap;)V

    goto :goto_3

    .line 407
    .end local v2    # "percentComplete":F
    .end local v4    # "progressEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    .end local v5    # "trackingParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v6    # "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    :cond_8
    mul-int/lit8 v7, v3, 0x64

    div-int/2addr v7, v1

    int-to-float v2, v7

    goto :goto_1

    .line 415
    .restart local v2    # "percentComplete":F
    :cond_9
    cmpl-float v7, v2, v9

    if-ltz v7, :cond_a

    cmpg-float v7, v2, v10

    if-gez v7, :cond_a

    .line 417
    const-string v7, "firstquartile"

    const/16 v8, 0x19

    const-string v9, "percent"

    invoke-direct {p0, v8, v9}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v8

    invoke-direct {p0, v0, v7, v8}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_2

    .line 419
    :cond_a
    cmpl-float v7, v2, v10

    if-ltz v7, :cond_b

    cmpg-float v7, v2, v11

    if-gez v7, :cond_b

    .line 421
    const-string v7, "midpoint"

    const/16 v8, 0x32

    const-string v9, "percent"

    invoke-direct {p0, v8, v9}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v8

    invoke-direct {p0, v0, v7, v8}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_2

    .line 423
    :cond_b
    cmpl-float v7, v2, v11

    if-ltz v7, :cond_c

    cmpg-float v7, v2, v12

    if-gez v7, :cond_c

    .line 425
    const-string v7, "thirdquartile"

    const/16 v8, 0x4b

    const-string v9, "percent"

    invoke-direct {p0, v8, v9}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v8

    invoke-direct {p0, v0, v7, v8}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_2

    .line 427
    :cond_c
    cmpl-float v7, v2, v12

    if-ltz v7, :cond_4

    .line 429
    const-string v7, "complete"

    const/16 v8, 0x64

    const-string v9, "percent"

    invoke-direct {p0, v8, v9}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v8

    invoke-direct {p0, v0, v7, v8}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_2
.end method

.method private onAdSkip(Lcom/auditude/ads/view/AdViewEvent;)V
    .locals 3
    .param p1, "e"    # Lcom/auditude/ads/view/AdViewEvent;

    .prologue
    .line 391
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 393
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v0

    invoke-interface {v0}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/Asset;

    const-string v1, "skip"

    const/4 v2, 0x0

    invoke-direct {p0, v0, v1, v2}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    .line 395
    :cond_0
    return-void
.end method

.method private onAdStart(Lcom/auditude/ads/view/AdViewEvent;)V
    .locals 4
    .param p1, "e"    # Lcom/auditude/ads/view/AdViewEvent;

    .prologue
    const/4 v2, 0x0

    .line 359
    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v1

    invoke-interface {v1}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v1

    instance-of v1, v1, Lcom/auditude/ads/model/Asset;

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getSource()Lcom/auditude/ads/view/model/IAdViewSource;

    move-result-object v1

    invoke-interface {v1}, Lcom/auditude/ads/view/model/IAdViewSource;->getAsset()Lcom/auditude/ads/model/IAsset;

    move-result-object v1

    :goto_0
    check-cast v1, Lcom/auditude/ads/model/Asset;

    move-object v0, v1

    .line 362
    .local v0, "asset":Lcom/auditude/ads/model/Asset;
    :goto_1
    instance-of v1, v0, Lcom/auditude/ads/model/IOnPageAsset;

    if-eqz v1, :cond_2

    invoke-virtual {v0}, Lcom/auditude/ads/model/Asset;->getFormat()Ljava/lang/String;

    move-result-object v1

    const-string v3, "onpage"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 369
    :goto_2
    return-void

    .end local v0    # "asset":Lcom/auditude/ads/model/Asset;
    :cond_0
    move-object v1, v2

    .line 359
    goto :goto_0

    :cond_1
    move-object v0, v2

    goto :goto_1

    .line 366
    .restart local v0    # "asset":Lcom/auditude/ads/model/Asset;
    :cond_2
    invoke-virtual {v0}, Lcom/auditude/ads/model/Asset;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/auditude/ads/util/AuditudeUtil;->setAssetURI(Ljava/lang/String;)V

    .line 367
    const-string v1, "creativeview"

    invoke-direct {p0, v0, v1, v2}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    .line 368
    const-string v1, "start"

    const/4 v2, 0x0

    const-string v3, "percent"

    invoke-direct {p0, v2, v3}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_2
.end method

.method private onAdViewEvent(Lcom/auditude/ads/view/AdViewEvent;)V
    .locals 2
    .param p1, "e"    # Lcom/auditude/ads/view/AdViewEvent;

    .prologue
    .line 580
    if-nez p1, :cond_0

    .line 605
    :goto_0
    return-void

    .line 582
    :cond_0
    invoke-static {}, Lcom/auditude/ads/reporting/ReportingHelper;->$SWITCH_TABLE$com$auditude$ads$view$AdViewEvent$AdViewEventType()[I

    move-result-object v0

    invoke-virtual {p1}, Lcom/auditude/ads/view/AdViewEvent;->getType()Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/view/AdViewEvent$AdViewEventType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    .line 585
    :pswitch_1
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdStart(Lcom/auditude/ads/view/AdViewEvent;)V

    goto :goto_0

    .line 588
    :pswitch_2
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdProgress(Lcom/auditude/ads/view/AdViewEvent;)V

    goto :goto_0

    .line 591
    :pswitch_3
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdComplete(Lcom/auditude/ads/view/AdViewEvent;)V

    goto :goto_0

    .line 594
    :pswitch_4
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdClick(Lcom/auditude/ads/view/AdViewEvent;)V

    goto :goto_0

    .line 597
    :pswitch_5
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdError(Lcom/auditude/ads/view/AdViewEvent;)V

    goto :goto_0

    .line 600
    :pswitch_6
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdSkip(Lcom/auditude/ads/view/AdViewEvent;)V

    goto :goto_0

    .line 582
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_5
        :pswitch_4
        :pswitch_0
        :pswitch_0
        :pswitch_6
    .end packed-switch
.end method

.method private onErrorEvent(Lcom/auditude/ads/event/PlayerErrorEvent;)V
    .locals 3
    .param p1, "e"    # Lcom/auditude/ads/event/PlayerErrorEvent;

    .prologue
    .line 532
    iget-object v1, p1, Lcom/auditude/ads/event/PlayerErrorEvent;->exception:Lcom/auditude/ads/exception/PlayerException;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    if-nez v1, :cond_1

    .line 545
    :cond_0
    :goto_0
    return-void

    .line 534
    :cond_1
    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    const-string v2, "playererror"

    invoke-virtual {v1, v2}, Lcom/auditude/ads/model/tracking/Submissions;->getSubmissionById(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/Submission;

    move-result-object v0

    .line 535
    .local v0, "submission":Lcom/auditude/ads/model/tracking/Submission;
    if-nez v0, :cond_2

    .line 537
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/core/AdSettings;->getDomain()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/auditude/ads/reporting/ReportingHelper;->getErrorSubmissionUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "playererror"

    invoke-static {v1, v2}, Lcom/auditude/ads/model/tracking/Submission;->newSubmission(Ljava/lang/String;Ljava/lang/String;)Lcom/auditude/ads/model/tracking/Submission;

    move-result-object v0

    .line 541
    :cond_2
    if-eqz v0, :cond_0

    .line 543
    const/4 v1, 0x1

    iget-object v2, p1, Lcom/auditude/ads/event/PlayerErrorEvent;->exception:Lcom/auditude/ads/exception/PlayerException;

    invoke-virtual {v2}, Lcom/auditude/ads/exception/PlayerException;->toParams()Ljava/util/HashMap;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/auditude/ads/model/tracking/Submission;->log(ZLjava/util/HashMap;)V

    goto :goto_0
.end method

.method private onParBegin(Lcom/auditude/ads/event/SMILEvent;)V
    .locals 1
    .param p1, "e"    # Lcom/auditude/ads/event/SMILEvent;

    .prologue
    .line 197
    invoke-virtual {p1}, Lcom/auditude/ads/event/SMILEvent;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->par:Lcom/auditude/ads/model/smil/Par;

    .line 198
    return-void
.end method

.method private onParEnd(Lcom/auditude/ads/event/SMILEvent;)V
    .locals 1
    .param p1, "e"    # Lcom/auditude/ads/event/SMILEvent;

    .prologue
    .line 202
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->par:Lcom/auditude/ads/model/smil/Par;

    .line 203
    return-void
.end method

.method private onSMILEvent(Lcom/auditude/ads/event/SMILEvent;)V
    .locals 2
    .param p1, "e"    # Lcom/auditude/ads/event/SMILEvent;

    .prologue
    .line 559
    invoke-static {}, Lcom/auditude/ads/reporting/ReportingHelper;->$SWITCH_TABLE$com$auditude$ads$event$SMILEvent$SMILEventType()[I

    move-result-object v0

    invoke-virtual {p1}, Lcom/auditude/ads/event/SMILEvent;->getType()Lcom/auditude/ads/event/SMILEvent$SMILEventType;

    move-result-object v1

    invoke-virtual {v1}, Lcom/auditude/ads/event/SMILEvent$SMILEventType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 576
    :goto_0
    return-void

    .line 562
    :pswitch_0
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onSequenceBegin(Lcom/auditude/ads/event/SMILEvent;)V

    goto :goto_0

    .line 565
    :pswitch_1
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onSequenceEnd(Lcom/auditude/ads/event/SMILEvent;)V

    goto :goto_0

    .line 568
    :pswitch_2
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onParBegin(Lcom/auditude/ads/event/SMILEvent;)V

    goto :goto_0

    .line 571
    :pswitch_3
    invoke-direct {p0, p1}, Lcom/auditude/ads/reporting/ReportingHelper;->onParEnd(Lcom/auditude/ads/event/SMILEvent;)V

    goto :goto_0

    .line 559
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private onSequenceBegin(Lcom/auditude/ads/event/SMILEvent;)V
    .locals 5
    .param p1, "e"    # Lcom/auditude/ads/event/SMILEvent;

    .prologue
    .line 113
    invoke-virtual {p1}, Lcom/auditude/ads/event/SMILEvent;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v1

    iput-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    .line 115
    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    if-eqz v1, :cond_0

    .line 117
    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    invoke-virtual {v1}, Lcom/auditude/ads/model/smil/Sequence;->getType()Lcom/auditude/ads/model/smil/SmilElementType;

    move-result-object v1

    sget-object v2, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    if-eq v1, v2, :cond_1

    .line 122
    new-instance v0, Lcom/auditude/ads/util/TimeoutUtil;

    invoke-direct {v0, p1}, Lcom/auditude/ads/util/TimeoutUtil;-><init>(Ljava/lang/Object;)V

    .line 123
    .local v0, "timeoutUtil":Lcom/auditude/ads/util/TimeoutUtil;
    invoke-virtual {v0, p0}, Lcom/auditude/ads/util/TimeoutUtil;->addTimeoutCompleteListener(Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;)V

    .line 125
    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->pendingTimeouts:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 126
    const-wide/16 v2, 0xbb8

    invoke-virtual {v0, v2, v3}, Lcom/auditude/ads/util/TimeoutUtil;->Begin(J)V

    .line 135
    .end local v0    # "timeoutUtil":Lcom/auditude/ads/util/TimeoutUtil;
    :cond_0
    :goto_0
    return-void

    .line 130
    :cond_1
    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    const-string v2, "start"

    invoke-virtual {p1}, Lcom/auditude/ads/event/SMILEvent;->getAdvancePattern()Z

    move-result v3

    invoke-direct {p0, v1, v2, v3}, Lcom/auditude/ads/reporting/ReportingHelper;->logSequenceProgress(Lcom/auditude/ads/model/smil/Sequence;Ljava/lang/String;Z)V

    .line 132
    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    const-string v2, "start"

    const/4 v3, 0x0

    const-string v4, "percent"

    invoke-direct {p0, v3, v4}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v3

    invoke-direct {p0, v1, v2, v3}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0
.end method

.method private onSequenceEnd(Lcom/auditude/ads/event/SMILEvent;)V
    .locals 4
    .param p1, "e"    # Lcom/auditude/ads/event/SMILEvent;

    .prologue
    .line 174
    invoke-virtual {p1}, Lcom/auditude/ads/event/SMILEvent;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 176
    invoke-virtual {p1}, Lcom/auditude/ads/event/SMILEvent;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v0

    const-string v1, "complete"

    invoke-virtual {p1}, Lcom/auditude/ads/event/SMILEvent;->getAdvancePattern()Z

    move-result v2

    invoke-direct {p0, v0, v1, v2}, Lcom/auditude/ads/reporting/ReportingHelper;->logSequenceProgress(Lcom/auditude/ads/model/smil/Sequence;Ljava/lang/String;Z)V

    .line 177
    iget-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    const-string v1, "complete"

    const/16 v2, 0x64

    const-string v3, "percent"

    invoke-direct {p0, v2, v3}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v2

    invoke-direct {p0, v0, v1, v2}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    .line 180
    :cond_0
    invoke-virtual {p1}, Lcom/auditude/ads/event/SMILEvent;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v0

    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    if-ne v0, v1, :cond_1

    .line 182
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    .line 184
    :cond_1
    return-void
.end method


# virtual methods
.method public final currentAdState()Ljava/util/HashMap;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 108
    iget-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Sequence;->getState()Ljava/util/HashMap;

    move-result-object v0

    :goto_0
    iget-object v2, p0, Lcom/auditude/ads/reporting/ReportingHelper;->par:Lcom/auditude/ads/model/smil/Par;

    if-eqz v2, :cond_0

    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->par:Lcom/auditude/ads/model/smil/Par;

    invoke-virtual {v1}, Lcom/auditude/ads/model/smil/Par;->getState()Ljava/util/HashMap;

    move-result-object v1

    :cond_0
    invoke-static {v0, v1}, Lcom/auditude/ads/util/ObjectUtil;->merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v0

    return-object v0

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public final currentPodState()Ljava/util/HashMap;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 103
    invoke-direct {p0}, Lcom/auditude/ads/reporting/ReportingHelper;->getSubmissionState()Ljava/util/HashMap;

    move-result-object v2

    iget-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Sequence;->getState()Ljava/util/HashMap;

    move-result-object v0

    :goto_0
    iget-object v3, p0, Lcom/auditude/ads/reporting/ReportingHelper;->par:Lcom/auditude/ads/model/smil/Par;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->par:Lcom/auditude/ads/model/smil/Par;

    invoke-virtual {v1}, Lcom/auditude/ads/model/smil/Par;->getState()Ljava/util/HashMap;

    move-result-object v1

    :cond_0
    invoke-static {v0, v1}, Lcom/auditude/ads/util/ObjectUtil;->merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/auditude/ads/util/ObjectUtil;->merge(Ljava/util/HashMap;Ljava/util/HashMap;)Ljava/util/HashMap;

    move-result-object v0

    return-object v0

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public final init()V
    .locals 1

    .prologue
    .line 65
    iget-boolean v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->isInitialized:Z

    if-nez v0, :cond_0

    .line 67
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/auditude/ads/reporting/ReportingHelper;->isInitialized:Z

    .line 71
    :cond_0
    invoke-virtual {p0}, Lcom/auditude/ads/reporting/ReportingHelper;->reset()V

    .line 72
    return-void
.end method

.method public onAdClick(Lcom/auditude/ads/model/smil/Ref;)V
    .locals 8
    .param p1, "ref"    # Lcom/auditude/ads/model/smil/Ref;

    .prologue
    const/4 v5, 0x0

    .line 248
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v7

    .line 249
    .local v7, "asset":Lcom/auditude/ads/model/Asset;
    if-eqz v7, :cond_0

    invoke-virtual {v7}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 251
    invoke-virtual {v7}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v0

    instance-of v0, v0, Lcom/auditude/ads/model/Click;

    if-eqz v0, :cond_1

    invoke-virtual {v7}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v1

    :goto_0
    check-cast v1, Lcom/auditude/ads/model/Click;

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    const-string v4, "click"

    const/4 v6, 0x1

    move-object v0, p0

    invoke-direct/range {v0 .. v6}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;Z)V

    .line 253
    :cond_0
    return-void

    :cond_1
    move-object v1, v5

    .line 251
    goto :goto_0
.end method

.method public onAdComplete(Lcom/auditude/ads/model/smil/Ref;)V
    .locals 6
    .param p1, "ref"    # Lcom/auditude/ads/model/smil/Ref;

    .prologue
    .line 242
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v1

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    const-string v4, "complete"

    const/16 v0, 0x64

    const-string v5, "percent"

    invoke-direct {p0, v0, v5}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;)V

    .line 243
    return-void
.end method

.method public onAdError(Lcom/auditude/ads/model/smil/Ref;)V
    .locals 9
    .param p1, "ref"    # Lcom/auditude/ads/model/smil/Ref;

    .prologue
    const/4 v8, 0x0

    .line 288
    if-eqz p1, :cond_3

    .line 290
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v0

    .line 291
    .local v0, "asset":Lcom/auditude/ads/model/Asset;
    if-eqz v0, :cond_0

    .line 294
    const-string v5, "vasterror"

    invoke-virtual {v0, v5}, Lcom/auditude/ads/model/Asset;->getTrackingEventByType(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/TrackingEvent;

    move-result-object v3

    .line 295
    .local v3, "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    if-eqz v3, :cond_0

    invoke-virtual {v3}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 297
    invoke-virtual {v0}, Lcom/auditude/ads/model/Asset;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/auditude/ads/util/AuditudeUtil;->setAssetURI(Ljava/lang/String;)V

    .line 298
    invoke-virtual {v3}, Lcom/auditude/ads/model/tracking/TrackingEvent;->getTrackingUrls()Ljava/util/ArrayList;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_4

    .line 302
    invoke-static {v8}, Lcom/auditude/ads/util/AuditudeUtil;->setAssetURI(Ljava/lang/String;)V

    .line 306
    .end local v3    # "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    :cond_0
    iget-object v5, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    if-eqz v5, :cond_3

    .line 308
    iget-object v5, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    const-string v6, "playererror"

    invoke-virtual {v5, v6}, Lcom/auditude/ads/model/tracking/Submissions;->getSubmissionById(Ljava/lang/String;)Lcom/auditude/ads/model/tracking/Submission;

    move-result-object v2

    .line 309
    .local v2, "submission":Lcom/auditude/ads/model/tracking/Submission;
    if-nez v2, :cond_1

    .line 311
    invoke-static {}, Lcom/auditude/ads/core/AuditudeEnv;->getInstance()Lcom/auditude/ads/core/AuditudeEnv;

    move-result-object v5

    invoke-virtual {v5}, Lcom/auditude/ads/core/AuditudeEnv;->getAdSettings()Lcom/auditude/ads/core/AdSettings;

    move-result-object v5

    invoke-virtual {v5}, Lcom/auditude/ads/core/AdSettings;->getDomain()Ljava/lang/String;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/auditude/ads/reporting/ReportingHelper;->getErrorSubmissionUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "playererror"

    invoke-static {v5, v6}, Lcom/auditude/ads/model/tracking/Submission;->newSubmission(Ljava/lang/String;Ljava/lang/String;)Lcom/auditude/ads/model/tracking/Submission;

    move-result-object v2

    .line 313
    :cond_1
    if-eqz v2, :cond_3

    .line 315
    new-instance v1, Lcom/auditude/ads/exception/AssetException;

    const/16 v5, 0x46b

    const-string v6, "asset failed to load"

    invoke-direct {v1, v5, v6}, Lcom/auditude/ads/exception/AssetException;-><init>(ILjava/lang/String;)V

    .line 316
    .local v1, "exception":Lcom/auditude/ads/exception/AssetException;
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v5

    if-eqz v5, :cond_2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v5

    invoke-virtual {v5}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v5

    iput-object v5, v1, Lcom/auditude/ads/exception/AssetException;->adId:Ljava/lang/String;

    .line 317
    :cond_2
    const/4 v5, 0x1

    invoke-virtual {v1}, Lcom/auditude/ads/exception/AssetException;->toParams()Ljava/util/HashMap;

    move-result-object v6

    invoke-virtual {v2, v5, v6}, Lcom/auditude/ads/model/tracking/Submission;->log(ZLjava/util/HashMap;)V

    .line 322
    .end local v0    # "asset":Lcom/auditude/ads/model/Asset;
    .end local v1    # "exception":Lcom/auditude/ads/exception/AssetException;
    .end local v2    # "submission":Lcom/auditude/ads/model/tracking/Submission;
    :cond_3
    return-void

    .line 298
    .restart local v0    # "asset":Lcom/auditude/ads/model/Asset;
    .restart local v3    # "trackingEvent":Lcom/auditude/ads/model/tracking/TrackingEvent;
    :cond_4
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/auditude/ads/model/tracking/TrackingUrl;

    .line 300
    .local v4, "trackingUrl":Lcom/auditude/ads/model/tracking/TrackingUrl;
    const/4 v6, 0x0

    const/16 v7, 0x190

    invoke-virtual {v4, v6, v8, v7}, Lcom/auditude/ads/model/tracking/TrackingUrl;->log(ZLjava/util/HashMap;I)V

    goto :goto_0
.end method

.method public onAdProgress(Lcom/auditude/ads/model/smil/Ref;II)V
    .locals 7
    .param p1, "ref"    # Lcom/auditude/ads/model/smil/Ref;
    .param p2, "duration"    # I
    .param p3, "position"    # I

    .prologue
    const/high16 v5, 0x42c80000    # 100.0f

    const/high16 v4, 0x42960000    # 75.0f

    const/high16 v3, 0x42480000    # 50.0f

    const/high16 v2, 0x41c80000    # 25.0f

    .line 257
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v1

    .line 258
    .local v1, "asset":Lcom/auditude/ads/model/Asset;
    if-nez v1, :cond_1

    .line 284
    :cond_0
    :goto_0
    return-void

    .line 263
    :cond_1
    if-gtz p2, :cond_2

    const/4 v6, 0x0

    .line 265
    .local v6, "percentComplete":F
    :goto_1
    cmpg-float v0, v6, v2

    if-gez v0, :cond_3

    .line 267
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    const-string v4, "start"

    const/4 v0, 0x0

    const-string v5, "percent"

    invoke-direct {p0, v0, v5}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 263
    .end local v6    # "percentComplete":F
    :cond_2
    mul-int/lit8 v0, p3, 0x64

    div-int/2addr v0, p2

    int-to-float v6, v0

    goto :goto_1

    .line 269
    .restart local v6    # "percentComplete":F
    :cond_3
    cmpl-float v0, v6, v2

    if-ltz v0, :cond_4

    cmpg-float v0, v6, v3

    if-gez v0, :cond_4

    .line 271
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    const-string v4, "firstquartile"

    const/16 v0, 0x19

    const-string v5, "percent"

    invoke-direct {p0, v0, v5}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 273
    :cond_4
    cmpl-float v0, v6, v3

    if-ltz v0, :cond_5

    cmpg-float v0, v6, v4

    if-gez v0, :cond_5

    .line 274
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    const-string v4, "midpoint"

    const/16 v0, 0x32

    const-string v5, "percent"

    invoke-direct {p0, v0, v5}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0

    .line 276
    :cond_5
    cmpl-float v0, v6, v4

    if-ltz v0, :cond_6

    cmpg-float v0, v6, v5

    if-gez v0, :cond_6

    .line 278
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    const-string v4, "thirdquartile"

    const/16 v0, 0x4b

    const-string v5, "percent"

    invoke-direct {p0, v0, v5}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 280
    :cond_6
    cmpl-float v0, v6, v5

    if-ltz v0, :cond_0

    .line 282
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    const-string v4, "complete"

    const/16 v0, 0x64

    const-string v5, "percent"

    invoke-direct {p0, v0, v5}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0
.end method

.method public onAdStart(Lcom/auditude/ads/model/smil/Ref;)V
    .locals 6
    .param p1, "ref"    # Lcom/auditude/ads/model/smil/Ref;

    .prologue
    .line 230
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v1

    .line 232
    .local v1, "asset":Lcom/auditude/ads/model/Asset;
    instance-of v0, v1, Lcom/auditude/ads/model/IOnPageAsset;

    if-eqz v0, :cond_0

    invoke-virtual {v1}, Lcom/auditude/ads/model/Asset;->getFormat()Ljava/lang/String;

    move-result-object v0

    const-string v2, "onpage"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 238
    :goto_0
    return-void

    .line 236
    :cond_0
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    const-string v4, "creativeview"

    const/4 v5, 0x0

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;)V

    .line 237
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Par;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Ref;->getPar()Lcom/auditude/ads/model/smil/Par;

    move-result-object v3

    const-string v4, "start"

    const/4 v0, 0x0

    const-string v5, "percent"

    invoke-direct {p0, v0, v5}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v5

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Lcom/auditude/ads/model/smil/Sequence;Lcom/auditude/ads/model/smil/Par;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0
.end method

.method public onEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 516
    const-string v0, "adViewEvent"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    instance-of v0, p2, Lcom/auditude/ads/view/AdViewEvent;

    if-eqz v0, :cond_1

    .line 518
    check-cast p2, Lcom/auditude/ads/view/AdViewEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-direct {p0, p2}, Lcom/auditude/ads/reporting/ReportingHelper;->onAdViewEvent(Lcom/auditude/ads/view/AdViewEvent;)V

    .line 528
    :cond_0
    :goto_0
    return-void

    .line 520
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_1
    const-string v0, "smilEvent"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    instance-of v0, p2, Lcom/auditude/ads/event/SMILEvent;

    if-eqz v0, :cond_2

    .line 522
    check-cast p2, Lcom/auditude/ads/event/SMILEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-direct {p0, p2}, Lcom/auditude/ads/reporting/ReportingHelper;->onSMILEvent(Lcom/auditude/ads/event/SMILEvent;)V

    goto :goto_0

    .line 524
    .restart local p2    # "event":Ljava/lang/Object;
    :cond_2
    const-string v0, "playerError"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    instance-of v0, p2, Lcom/auditude/ads/event/PlayerErrorEvent;

    if-eqz v0, :cond_0

    .line 526
    check-cast p2, Lcom/auditude/ads/event/PlayerErrorEvent;

    .end local p2    # "event":Ljava/lang/Object;
    invoke-direct {p0, p2}, Lcom/auditude/ads/reporting/ReportingHelper;->onErrorEvent(Lcom/auditude/ads/event/PlayerErrorEvent;)V

    goto :goto_0
.end method

.method public onSequenceBegin(Lcom/auditude/ads/model/smil/Sequence;)V
    .locals 3
    .param p1, "seq"    # Lcom/auditude/ads/model/smil/Sequence;

    .prologue
    const/4 v2, 0x0

    .line 139
    if-eqz p1, :cond_0

    .line 141
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Sequence;->resetTrackingEvents()V

    .line 142
    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Sequence;->getType()Lcom/auditude/ads/model/smil/SmilElementType;

    move-result-object v0

    sget-object v1, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    if-eq v0, v1, :cond_1

    .line 144
    const-string v0, "start"

    const/4 v1, 0x1

    invoke-direct {p0, p1, v0, v1}, Lcom/auditude/ads/reporting/ReportingHelper;->logSequenceProgress(Lcom/auditude/ads/model/smil/Sequence;Ljava/lang/String;Z)V

    .line 152
    :cond_0
    :goto_0
    return-void

    .line 148
    :cond_1
    const-string v0, "start"

    invoke-direct {p0, p1, v0, v2}, Lcom/auditude/ads/reporting/ReportingHelper;->logSequenceProgress(Lcom/auditude/ads/model/smil/Sequence;Ljava/lang/String;Z)V

    .line 149
    const-string v0, "start"

    const-string v1, "percent"

    invoke-direct {p0, v2, v1}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0
.end method

.method public onSequenceEnd(Lcom/auditude/ads/model/smil/Sequence;)V
    .locals 3
    .param p1, "seq"    # Lcom/auditude/ads/model/smil/Sequence;

    .prologue
    .line 188
    if-eqz p1, :cond_0

    .line 190
    const-string v1, "complete"

    invoke-virtual {p1}, Lcom/auditude/ads/model/smil/Sequence;->getType()Lcom/auditude/ads/model/smil/SmilElementType;

    move-result-object v0

    sget-object v2, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    if-ne v0, v2, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-direct {p0, p1, v1, v0}, Lcom/auditude/ads/reporting/ReportingHelper;->logSequenceProgress(Lcom/auditude/ads/model/smil/Sequence;Ljava/lang/String;Z)V

    .line 191
    const-string v0, "complete"

    const/16 v1, 0x64

    const-string v2, "percent"

    invoke-direct {p0, v1, v2}, Lcom/auditude/ads/reporting/ReportingHelper;->getProgressState(ILjava/lang/String;)Ljava/util/HashMap;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lcom/auditude/ads/reporting/ReportingHelper;->logAdTrackingUrl(Lcom/auditude/ads/model/BaseElement;Ljava/lang/String;Ljava/util/HashMap;)V

    .line 193
    :cond_0
    return-void

    .line 190
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onTimeoutComplete(Lcom/auditude/ads/util/TimeoutUtil;)V
    .locals 5
    .param p1, "timeoutUtil"    # Lcom/auditude/ads/util/TimeoutUtil;

    .prologue
    const/4 v0, 0x0

    .line 156
    if-eqz p1, :cond_2

    .line 158
    invoke-virtual {p1, v0}, Lcom/auditude/ads/util/TimeoutUtil;->addTimeoutCompleteListener(Lcom/auditude/ads/util/TimeoutUtil$TimeoutCompleteListener;)V

    .line 159
    iget-object v2, p0, Lcom/auditude/ads/reporting/ReportingHelper;->pendingTimeouts:Ljava/util/ArrayList;

    invoke-virtual {v2, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 161
    invoke-virtual {p1}, Lcom/auditude/ads/util/TimeoutUtil;->getIsCanceled()Z

    move-result v2

    if-nez v2, :cond_1

    invoke-virtual {p1}, Lcom/auditude/ads/util/TimeoutUtil;->getData()Ljava/lang/Object;

    move-result-object v2

    instance-of v2, v2, Lcom/auditude/ads/event/SMILEvent;

    if-eqz v2, :cond_1

    .line 163
    invoke-virtual {p1}, Lcom/auditude/ads/util/TimeoutUtil;->getData()Ljava/lang/Object;

    move-result-object v1

    .line 164
    .local v1, "tempVar":Ljava/lang/Object;
    instance-of v2, v1, Lcom/auditude/ads/event/SMILEvent;

    if-eqz v2, :cond_0

    move-object v0, v1

    :cond_0
    check-cast v0, Lcom/auditude/ads/event/SMILEvent;

    .line 165
    .local v0, "smilArgs":Lcom/auditude/ads/event/SMILEvent;
    invoke-virtual {v0}, Lcom/auditude/ads/event/SMILEvent;->getSequence()Lcom/auditude/ads/model/smil/Sequence;

    move-result-object v2

    const-string v3, "start"

    invoke-virtual {v0}, Lcom/auditude/ads/event/SMILEvent;->getAdvancePattern()Z

    move-result v4

    invoke-direct {p0, v2, v3, v4}, Lcom/auditude/ads/reporting/ReportingHelper;->logSequenceProgress(Lcom/auditude/ads/model/smil/Sequence;Ljava/lang/String;Z)V

    .line 168
    .end local v0    # "smilArgs":Lcom/auditude/ads/event/SMILEvent;
    .end local v1    # "tempVar":Ljava/lang/Object;
    :cond_1
    invoke-virtual {p1}, Lcom/auditude/ads/util/TimeoutUtil;->dispose()V

    .line 170
    :cond_2
    return-void
.end method

.method public final reset()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 76
    iput-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    .line 77
    iput-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->sequence:Lcom/auditude/ads/model/smil/Sequence;

    .line 78
    iput-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->par:Lcom/auditude/ads/model/smil/Par;

    .line 80
    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->pendingTimeouts:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 88
    iget-object v1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->pendingTimeouts:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->clear()V

    .line 89
    return-void

    .line 80
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/util/TimeoutUtil;

    .line 82
    .local v0, "util":Lcom/auditude/ads/util/TimeoutUtil;
    if-eqz v0, :cond_0

    .line 84
    invoke-virtual {v0}, Lcom/auditude/ads/util/TimeoutUtil;->dispose()V

    goto :goto_0
.end method

.method public final setSubmissions(Lcom/auditude/ads/model/tracking/Submissions;)V
    .locals 0
    .param p1, "value"    # Lcom/auditude/ads/model/tracking/Submissions;

    .prologue
    .line 98
    iput-object p1, p0, Lcom/auditude/ads/reporting/ReportingHelper;->submissions:Lcom/auditude/ads/model/tracking/Submissions;

    .line 99
    return-void
.end method
