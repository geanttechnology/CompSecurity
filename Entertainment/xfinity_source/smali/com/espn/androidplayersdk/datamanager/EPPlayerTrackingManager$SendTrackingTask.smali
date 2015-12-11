.class Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;
.super Landroid/os/AsyncTask;
.source "EPPlayerTrackingManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SendTrackingTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType:[I


# instance fields
.field epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

.field mTrackingType:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;


# direct methods
.method static synthetic $SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType()[I
    .locals 3

    .prologue
    .line 489
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->$SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->values()[Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AD_COMPLETE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0xd

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_10

    :goto_1
    :try_start_1
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0xc

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_f

    :goto_2
    :try_start_2
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AUTH_ATTEMPT:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_e

    :goto_3
    :try_start_3
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AUTH_SUCCESS:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_d

    :goto_4
    :try_start_4
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->EVENT_CONCLUDED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_c

    :goto_5
    :try_start_5
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MAP_AFFILIATE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0xe

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_b

    :goto_6
    :try_start_6
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MILESTONE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_a

    :goto_7
    :try_start_7
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0xa

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_9

    :goto_8
    :try_start_8
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->UNMUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0xb

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_8

    :goto_9
    :try_start_9
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_7

    :goto_a
    :try_start_a
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_PLAY_FROM_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0x9

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_6

    :goto_b
    :try_start_b
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_SCRUBBED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_5

    :goto_c
    :try_start_c
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_c
    .catch Ljava/lang/NoSuchFieldError; {:try_start_c .. :try_end_c} :catch_4

    :goto_d
    :try_start_d
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_STOP:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_d .. :try_end_d} :catch_3

    :goto_e
    :try_start_e
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_END:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0x11

    aput v2, v0, v1
    :try_end_e
    .catch Ljava/lang/NoSuchFieldError; {:try_start_e .. :try_end_e} :catch_2

    :goto_f
    :try_start_f
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_MID:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0x10

    aput v2, v0, v1
    :try_end_f
    .catch Ljava/lang/NoSuchFieldError; {:try_start_f .. :try_end_f} :catch_1

    :goto_10
    :try_start_10
    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v1

    const/16 v2, 0xf

    aput v2, v0, v1
    :try_end_10
    .catch Ljava/lang/NoSuchFieldError; {:try_start_10 .. :try_end_10} :catch_0

    :goto_11
    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->$SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType:[I

    goto/16 :goto_0

    :catch_0
    move-exception v1

    goto :goto_11

    :catch_1
    move-exception v1

    goto :goto_10

    :catch_2
    move-exception v1

    goto :goto_f

    :catch_3
    move-exception v1

    goto :goto_e

    :catch_4
    move-exception v1

    goto :goto_d

    :catch_5
    move-exception v1

    goto :goto_c

    :catch_6
    move-exception v1

    goto :goto_b

    :catch_7
    move-exception v1

    goto :goto_a

    :catch_8
    move-exception v1

    goto :goto_9

    :catch_9
    move-exception v1

    goto :goto_8

    :catch_a
    move-exception v1

    goto :goto_7

    :catch_b
    move-exception v1

    goto/16 :goto_6

    :catch_c
    move-exception v1

    goto/16 :goto_5

    :catch_d
    move-exception v1

    goto/16 :goto_4

    :catch_e
    move-exception v1

    goto/16 :goto_3

    :catch_f
    move-exception v1

    goto/16 :goto_2

    :catch_10
    move-exception v1

    goto/16 :goto_1
.end method

.method private constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;)V
    .locals 0
    .param p2, "pTrackingType"    # Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;
    .param p3, "event"    # Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .prologue
    .line 494
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 495
    iput-object p2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->mTrackingType:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    .line 496
    iput-object p3, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    .line 497
    return-void
.end method

.method synthetic constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;)V
    .locals 0

    .prologue
    .line 494
    invoke-direct {p0, p1, p2, p3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;-><init>(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;Lcom/espn/androidplayersdk/datamanager/EPEvents;)V

    return-void
.end method

.method private sendPingsToServer(Ljava/lang/String;)V
    .locals 7
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 624
    const/4 v1, 0x0

    .line 626
    .local v1, "conn":Ljava/net/HttpURLConnection;
    :try_start_0
    new-instance v3, Ljava/net/URL;

    invoke-direct {v3, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 627
    .local v3, "mURL":Ljava/net/URL;
    invoke-virtual {v3}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v4

    move-object v0, v4

    check-cast v0, Ljava/net/HttpURLConnection;

    move-object v1, v0

    .line 628
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v4

    const/16 v5, 0xc8

    if-ne v4, v5, :cond_0

    .line 629
    const-string v4, "Tracking ping sent"

    const/4 v5, 0x2

    const/4 v6, 0x0

    invoke-static {v4, v5, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 636
    :cond_0
    if-eqz v1, :cond_1

    .line 637
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 639
    .end local v3    # "mURL":Ljava/net/URL;
    :cond_1
    :goto_0
    return-void

    .line 631
    :catch_0
    move-exception v2

    .line 632
    .local v2, "e":Ljava/net/MalformedURLException;
    :try_start_1
    const-string v4, "unable to send traking ping"

    const/4 v5, 0x5

    invoke-static {v4, v5, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 636
    if-eqz v1, :cond_1

    .line 637
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_0

    .line 633
    .end local v2    # "e":Ljava/net/MalformedURLException;
    :catch_1
    move-exception v2

    .line 634
    .local v2, "e":Ljava/io/IOException;
    :try_start_2
    const-string v4, "unable to send traking ping"

    const/4 v5, 0x5

    invoke-static {v4, v5, v2}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 636
    if-eqz v1, :cond_1

    .line 637
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_0

    .line 635
    .end local v2    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    .line 636
    if-eqz v1, :cond_2

    .line 637
    invoke-virtual {v1}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 638
    :cond_2
    throw v4
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/String;

    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->doInBackground([Ljava/lang/String;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/String;)Ljava/lang/Void;
    .locals 5
    .param p1, "params"    # [Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 502
    :try_start_0
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->$SWITCH_TABLE$com$espn$androidplayersdk$datamanager$EPPlayerTrackingManager$TrackingType()[I

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->mTrackingType:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ordinal()I

    move-result v2

    aget v1, v1, v2

    packed-switch v1, :pswitch_data_0

    .line 554
    :goto_0
    return-object v4

    .line 504
    :pswitch_0
    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-virtual {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->videoStartParams(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 551
    :catch_0
    move-exception v0

    .line 552
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "player tracking ping failed "

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    .line 507
    .end local v0    # "e":Ljava/lang/Exception;
    :pswitch_1
    :try_start_1
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->milestoneParam()V

    goto :goto_0

    .line 510
    :pswitch_2
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->eventConcluded()V

    goto :goto_0

    .line 513
    :pswitch_3
    const/4 v1, 0x0

    aget-object v1, p1, v1

    invoke-virtual {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->videoStop(Ljava/lang/String;)V

    goto :goto_0

    .line 516
    :pswitch_4
    const-string v1, "watchespn_pause"

    const-string v2, "event78"

    const/4 v3, 0x0

    invoke-virtual {p0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->videoEventParams(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 519
    :pswitch_5
    const-string v1, "watchespn_scrub"

    const-string v2, "event79"

    const/4 v3, 0x0

    invoke-virtual {p0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->videoEventParams(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 522
    :pswitch_6
    const-string v1, "watchespn_play"

    const-string v2, "event80"

    const/4 v3, 0x0

    invoke-virtual {p0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->videoEventParams(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 525
    :pswitch_7
    const-string v1, "watchespn_mute"

    const-string v2, "event81"

    const/4 v3, 0x0

    invoke-virtual {p0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->videoEventParams(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 528
    :pswitch_8
    const-string v1, "watchespn_unmute"

    const-string v2, "event81"

    const/4 v3, 0x0

    invoke-virtual {p0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->videoEventParams(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 531
    :pswitch_9
    const-string v1, "adStart"

    const-string v2, "event39"

    const/4 v3, 0x0

    aget-object v3, p1, v3

    invoke-virtual {p0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->videoEventParams(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 534
    :pswitch_a
    const-string v1, "adComplete"

    const-string v2, "event40"

    const/4 v3, 0x0

    aget-object v3, p1, v3

    invoke-virtual {p0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->videoEventParams(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 537
    :pswitch_b
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->setAffiliateCode()V

    goto :goto_0

    .line 540
    :pswitch_c
    const-string v1, "event1"

    invoke-virtual {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->vodTrackingParam(Ljava/lang/String;)V

    goto :goto_0

    .line 543
    :pswitch_d
    const-string v1, "event11"

    invoke-virtual {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->vodTrackingParam(Ljava/lang/String;)V

    goto :goto_0

    .line 546
    :pswitch_e
    const-string v1, "event9"

    invoke-virtual {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->vodTrackingParam(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 502
    :pswitch_data_0
    .packed-switch 0x3
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
        :pswitch_e
        :pswitch_d
    .end packed-switch
.end method

.method eventConcluded()V
    .locals 3

    .prologue
    .line 693
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->callback:Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$8(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;

    move-result-object v1

    invoke-interface {v1}, Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;->trackingParam()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->getCommonOmniValues(Ljava/lang/String;)Lcom/espn/androidplayersdk/datamanager/Omniture;

    move-result-object v0

    .line 694
    .local v0, "omniValues":Lcom/espn/androidplayersdk/datamanager/Omniture;
    const-string v1, "watchespn:end program"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pev2:Ljava/lang/String;

    .line 695
    const-string v1, "event10,event23,event11"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->events:Ljava/lang/String;

    .line 696
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, ";;;;event10="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->getMinsPastSinceBeaconFired()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->products:Ljava/lang/String;

    .line 697
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar58:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop58:Ljava/lang/String;

    .line 698
    const-string v1, "400"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar30:Ljava/lang/String;

    .line 699
    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->urlbuilder(Lcom/espn/androidplayersdk/datamanager/Omniture;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->sendPingsToServer(Ljava/lang/String;)V

    .line 700
    return-void
.end method

.method getCommonOmniValues(Ljava/lang/String;)Lcom/espn/androidplayersdk/datamanager/Omniture;
    .locals 5
    .param p1, "segmentInterval"    # Ljava/lang/String;

    .prologue
    .line 720
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/Omniture;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/Omniture;-><init>()V

    .line 721
    .local v0, "omniValues":Lcom/espn/androidplayersdk/datamanager/Omniture;
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar2:Ljava/lang/String;

    .line 722
    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->srcApp:Ljava/lang/String;
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$5()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->srcApp:Ljava/lang/String;
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$5()Ljava/lang/String;

    move-result-object v1

    :goto_0
    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar3:Ljava/lang/String;

    .line 723
    const-string v1, "watchespn Player"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar11:Ljava/lang/String;

    .line 724
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$9(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar17:Ljava/lang/String;

    .line 725
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getSport()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar19:Ljava/lang/String;

    .line 726
    const-string v1, "no league set"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar21:Ljava/lang/String;

    .line 727
    const-string v1, "live"

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 728
    const-string v1, "live"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar31:Ljava/lang/String;

    .line 731
    :goto_1
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getAffiliateID()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar32:Ljava/lang/String;

    .line 732
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar33:Ljava/lang/String;

    .line 733
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getNetworkId()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar34:Ljava/lang/String;

    .line 734
    const-string v1, ""

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar37:Ljava/lang/String;

    .line 735
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getSportCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getprogramingCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar39:Ljava/lang/String;

    .line 737
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v1}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar45:Ljava/lang/String;

    .line 738
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getStartTime()Ljava/lang/String;

    move-result-object v2

    const-string v3, "T"

    const-string v4, "|"

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "|"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getSport()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "|"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getLeagueName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "|"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 739
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getSportCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "|"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getprogramingCode()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "|"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "|"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "|"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 740
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getNetworkId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 738
    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar47:Ljava/lang/String;

    .line 741
    const-string v1, "watchespn Player"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar52:Ljava/lang/String;

    .line 742
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn Player:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$9(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar53:Ljava/lang/String;

    .line 743
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn Player:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$9(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "na"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar54:Ljava/lang/String;

    .line 744
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn Player:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getAffiliateID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar55:Ljava/lang/String;

    .line 745
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn Player:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$9(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getAffiliateID()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar56:Ljava/lang/String;

    .line 746
    const-string v1, "watchespn Player:no league set"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar57:Ljava/lang/String;

    .line 747
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn Player:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$9(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "no league set"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar58:Ljava/lang/String;

    .line 748
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn Player:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    iget-object v2, v2, Lcom/espn/androidplayersdk/datamanager/EPEvents;->eventId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar59:Ljava/lang/String;

    .line 749
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn Player:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$9(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    iget-object v2, v2, Lcom/espn/androidplayersdk/datamanager/EPEvents;->eventId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar60:Ljava/lang/String;

    .line 750
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getAffiliateID()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":authenticated"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar68:Ljava/lang/String;

    .line 751
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getAiringId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar71:Ljava/lang/String;

    .line 752
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->swid:Ljava/lang/String;
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$2(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop2:Ljava/lang/String;

    .line 753
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar2:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop3:Ljava/lang/String;

    .line 754
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar11:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop4:Ljava/lang/String;

    .line 755
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn:watchespn Player:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->partnerName:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$9(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop5:Ljava/lang/String;

    .line 756
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar19:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop25:Ljava/lang/String;

    .line 757
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar21:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop26:Ljava/lang/String;

    .line 758
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar45:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop28:Ljava/lang/String;

    .line 759
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar39:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar37:Ljava/lang/String;

    .line 760
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar19:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop25:Ljava/lang/String;

    .line 761
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar17:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop42:Ljava/lang/String;

    .line 762
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar32:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop43:Ljava/lang/String;

    .line 763
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar34:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop45:Ljava/lang/String;

    .line 764
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar39:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop51:Ljava/lang/String;

    .line 765
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar52:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop52:Ljava/lang/String;

    .line 766
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar53:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop53:Ljava/lang/String;

    .line 767
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar54:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop54:Ljava/lang/String;

    .line 768
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar55:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop55:Ljava/lang/String;

    .line 769
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar56:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop56:Ljava/lang/String;

    .line 770
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar57:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop57:Ljava/lang/String;

    .line 771
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar59:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop59:Ljava/lang/String;

    .line 772
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar60:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop60:Ljava/lang/String;

    .line 773
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar68:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop68:Ljava/lang/String;

    .line 774
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar71:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop71:Ljava/lang/String;

    .line 776
    return-object v0

    .line 722
    :cond_0
    const/4 v1, 0x0

    goto/16 :goto_0

    .line 730
    :cond_1
    const-string v1, "replay"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar31:Ljava/lang/String;

    goto/16 :goto_1
.end method

.method getMinsPastSinceBeaconFired()Ljava/lang/String;
    .locals 6

    .prologue
    .line 613
    :try_start_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->beaconFiredTime:Ljava/util/Date;
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$7(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/util/Date;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 614
    new-instance v1, Ljava/text/DecimalFormat;

    const-string v2, "#.####"

    invoke-direct {v1, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    long-to-double v2, v2

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->beaconFiredTime:Ljava/util/Date;
    invoke-static {v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$7(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    long-to-double v4, v4

    sub-double/2addr v2, v4

    const-wide v4, 0x40ed4c0000000000L    # 60000.0

    div-double/2addr v2, v4

    invoke-virtual {v1, v2, v3}, Ljava/text/DecimalFormat;->format(D)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 618
    :goto_0
    return-object v1

    .line 615
    :catch_0
    move-exception v0

    .line 616
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "Unable to calculate beacon fired time"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 618
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_0
    const-string v1, "0"

    goto :goto_0
.end method

.method milestoneParam()V
    .locals 2

    .prologue
    .line 678
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->callback:Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$8(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;

    move-result-object v1

    invoke-interface {v1}, Lcom/espn/androidplayersdk/listenerinterface/EPPlayerTrackingCallBack;->trackingParam()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->getCommonOmniValues(Ljava/lang/String;)Lcom/espn/androidplayersdk/datamanager/Omniture;

    move-result-object v0

    .line 679
    .local v0, "omniValues":Lcom/espn/androidplayersdk/datamanager/Omniture;
    const-string v1, "m_i"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pe:Ljava/lang/String;

    .line 680
    const-string v1, "watchespn:5min"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pev2:Ljava/lang/String;

    .line 681
    const-string v1, "event10,event23"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->events:Ljava/lang/String;

    .line 682
    const-string v1, ";;;;event10=5"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->products:Ljava/lang/String;

    .line 683
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar58:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop58:Ljava/lang/String;

    .line 685
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->setBeaconFiredTimeStamp()V

    .line 686
    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->urlbuilder(Lcom/espn/androidplayersdk/datamanager/Omniture;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->sendPingsToServer(Ljava/lang/String;)V

    .line 687
    return-void
.end method

.method setBeaconFiredTimeStamp()V
    .locals 2

    .prologue
    .line 607
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-static {v0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$6(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;Ljava/util/Date;)V

    .line 608
    return-void
.end method

.method urlbuilder(Lcom/espn/androidplayersdk/datamanager/Omniture;)Ljava/lang/String;
    .locals 6
    .param p1, "omniValues"    # Lcom/espn/androidplayersdk/datamanager/Omniture;

    .prologue
    .line 783
    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->BASE_URL:Ljava/lang/String;
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$10()Ljava/lang/String;

    move-result-object v1

    .line 785
    .local v1, "fullUrl":Ljava/lang/String;
    :try_start_0
    const-string v2, ""

    .line 786
    .local v2, "param":Ljava/lang/String;
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->pe:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 787
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&pe="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->pe:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 788
    :cond_0
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->ch:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 789
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&ch="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->ch:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 790
    :cond_1
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->pev2:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 791
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&pev2="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->pev2:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 792
    :cond_2
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->linkID:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 793
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c9="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->linkID:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 794
    :cond_3
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar2:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 795
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v2="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar2:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 796
    :cond_4
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar3:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 797
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v3="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar3:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 798
    :cond_5
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar9:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_6

    .line 799
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v9="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar9:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 800
    :cond_6
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar11:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_7

    .line 801
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v11="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar11:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 802
    :cond_7
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar16:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_8

    .line 803
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v16="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar16:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 804
    :cond_8
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar17:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_9

    .line 805
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v17="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar17:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 806
    :cond_9
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar19:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_a

    .line 807
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v19="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar19:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 808
    :cond_a
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar20:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_b

    .line 809
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v20="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar20:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 810
    :cond_b
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar21:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_c

    .line 811
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v21="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar21:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 812
    :cond_c
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar29:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_d

    .line 813
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v29="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar29:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 814
    :cond_d
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar30:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_e

    .line 815
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v30="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar30:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 816
    :cond_e
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar31:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_f

    .line 817
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v31="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar31:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 818
    :cond_f
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar32:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_10

    .line 819
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v32="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar32:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 820
    :cond_10
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar33:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_11

    .line 821
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v33="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar33:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 822
    :cond_11
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar34:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_12

    .line 823
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v34="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar34:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 824
    :cond_12
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar37:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_13

    .line 825
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v37="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar37:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 826
    :cond_13
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar39:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_14

    .line 827
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v39="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar39:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 828
    :cond_14
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar45:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_15

    .line 829
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v45="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar45:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 830
    :cond_15
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar47:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_16

    .line 831
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v47="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar47:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 832
    :cond_16
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar52:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_17

    .line 833
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v52="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar52:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 834
    :cond_17
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar53:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_18

    .line 835
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v53="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar53:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 836
    :cond_18
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar54:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_19

    .line 837
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v54="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar54:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 838
    :cond_19
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar55:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1a

    .line 839
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v55="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar55:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 840
    :cond_1a
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar56:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1b

    .line 841
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v56="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar56:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 842
    :cond_1b
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar57:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1c

    .line 843
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v57="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar57:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 844
    :cond_1c
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar58:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1d

    .line 845
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v58="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar58:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 846
    :cond_1d
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar59:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1e

    .line 847
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v59="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar59:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 848
    :cond_1e
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar60:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1f

    .line 849
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v60="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar60:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 850
    :cond_1f
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar61:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_20

    .line 851
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v61="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar61:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 852
    :cond_20
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar62:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_21

    .line 853
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v62="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar62:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 854
    :cond_21
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar63:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_22

    .line 855
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v63="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar63:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 856
    :cond_22
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar64:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_23

    .line 857
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v64="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar64:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 858
    :cond_23
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar65:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_24

    .line 859
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v65="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar65:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 860
    :cond_24
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar66:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_25

    .line 861
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v66="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar66:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 862
    :cond_25
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar67:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_26

    .line 863
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v67="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar67:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 864
    :cond_26
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar68:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_27

    .line 865
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v68="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar68:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 866
    :cond_27
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar71:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_28

    .line 867
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&v71="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar71:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 869
    :cond_28
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->events:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_29

    .line 870
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&events="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->events:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 871
    :cond_29
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->products:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2a

    .line 872
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&products="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->products:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 874
    :cond_2a
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop1:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2b

    .line 875
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c1="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop1:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 876
    :cond_2b
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop2:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2c

    .line 877
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c2="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop2:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 878
    :cond_2c
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop3:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2d

    .line 879
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c3="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop3:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 880
    :cond_2d
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop4:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2e

    .line 881
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c4="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop4:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 882
    :cond_2e
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop5:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_2f

    .line 883
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c5="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop5:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 884
    :cond_2f
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop9:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_30

    .line 885
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c9="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop9:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 886
    :cond_30
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop17:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_31

    .line 887
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c17="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop17:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 888
    :cond_31
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop25:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_32

    .line 889
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c25="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop25:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 890
    :cond_32
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop26:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_33

    .line 891
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c26="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop26:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 892
    :cond_33
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop28:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_34

    .line 893
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c28="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop28:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 894
    :cond_34
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop35:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_35

    .line 895
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c35="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop35:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 896
    :cond_35
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop42:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_36

    .line 897
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c42="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop42:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 898
    :cond_36
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop43:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_37

    .line 899
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c43="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop43:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 900
    :cond_37
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop45:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_38

    .line 901
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c45="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop45:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 902
    :cond_38
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop47:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_39

    .line 903
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c47="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop47:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 904
    :cond_39
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop48:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3a

    .line 905
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c48="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop48:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 906
    :cond_3a
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop51:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3b

    .line 907
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c51="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop51:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 908
    :cond_3b
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop52:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3c

    .line 909
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c52="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop52:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 910
    :cond_3c
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop53:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3d

    .line 911
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c53="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop53:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 912
    :cond_3d
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop54:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3e

    .line 913
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c54="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop54:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 914
    :cond_3e
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop55:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3f

    .line 915
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c55="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop55:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 916
    :cond_3f
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop56:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_40

    .line 917
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c56="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop56:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 918
    :cond_40
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop57:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_41

    .line 919
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c57="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop57:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 920
    :cond_41
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop58:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_42

    .line 921
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c58="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop58:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 922
    :cond_42
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop59:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_43

    .line 923
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c59="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop59:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 924
    :cond_43
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop60:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_44

    .line 925
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c60="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop60:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 926
    :cond_44
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop61:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_45

    .line 927
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c61="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop61:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 928
    :cond_45
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop62:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_46

    .line 929
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c62="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop62:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 930
    :cond_46
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop63:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_47

    .line 931
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c63="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop63:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 932
    :cond_47
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop64:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_48

    .line 933
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c64="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop64:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 934
    :cond_48
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop65:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_49

    .line 935
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c65="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop65:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 936
    :cond_49
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop66:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4a

    .line 937
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c66="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop66:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 938
    :cond_4a
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop67:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4b

    .line 939
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c67="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop67:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 940
    :cond_4b
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop68:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4c

    .line 941
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c68="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop68:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 942
    :cond_4c
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop71:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4d

    .line 943
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c71="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop71:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 944
    :cond_4d
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop72:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4e

    .line 945
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c72="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop72:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 946
    :cond_4e
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop73:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_4f

    .line 947
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c73="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop73:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 948
    :cond_4f
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop74:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_50

    .line 949
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c74="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop74:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 950
    :cond_50
    iget-object v3, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop75:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_51

    .line 951
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "&c75="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p1, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop75:Ljava/lang/String;

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 953
    :cond_51
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "AQB=1&ndh=1&vid="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getUUID()Ljava/lang/String;

    move-result-object v4

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&t="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # invokes: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->getTimeForOmniture()Ljava/lang/String;
    invoke-static {v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$11(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "UTF-8"

    invoke-static {v4, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 954
    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # invokes: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->endOfUrl()Ljava/lang/String;
    invoke-static {v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$12(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 953
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 958
    .end local v2    # "param":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 955
    :catch_0
    move-exception v0

    .line 956
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    const-string v3, "Tracking ping failed"

    const/4 v4, 0x5

    invoke-static {v3, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method videoEventParams(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "playerAction"    # Ljava/lang/String;
    .param p2, "omniEvent"    # Ljava/lang/String;
    .param p3, "AdId"    # Ljava/lang/String;

    .prologue
    .line 646
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/Omniture;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/Omniture;-><init>()V

    .line 647
    .local v0, "omniValues":Lcom/espn/androidplayersdk/datamanager/Omniture;
    const-string v1, "lnk_o"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pe:Ljava/lang/String;

    .line 648
    iput-object p1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pev2:Ljava/lang/String;

    .line 649
    iput-object p1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->linkID:Ljava/lang/String;

    .line 650
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar2:Ljava/lang/String;

    .line 651
    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->srcApp:Ljava/lang/String;
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$5()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->srcApp:Ljava/lang/String;
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$5()Ljava/lang/String;

    move-result-object v1

    :goto_0
    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar3:Ljava/lang/String;

    .line 652
    iput-object p2, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->events:Ljava/lang/String;

    .line 653
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getShowName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop3:Ljava/lang/String;

    .line 654
    if-eqz p3, :cond_0

    invoke-virtual {p3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 655
    iput-object p3, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar29:Ljava/lang/String;

    .line 656
    :cond_0
    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->urlbuilder(Lcom/espn/androidplayersdk/datamanager/Omniture;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->sendPingsToServer(Ljava/lang/String;)V

    .line 657
    return-void

    .line 651
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method videoStartParams(Ljava/lang/String;)V
    .locals 2
    .param p1, "segmentInterval"    # Ljava/lang/String;

    .prologue
    .line 663
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->getCommonOmniValues(Ljava/lang/String;)Lcom/espn/androidplayersdk/datamanager/Omniture;

    move-result-object v0

    .line 664
    .local v0, "omniValues":Lcom/espn/androidplayersdk/datamanager/Omniture;
    const-string v1, "m_s"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pe:Ljava/lang/String;

    .line 665
    const-string v1, "watchespn:streamstart"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pev2:Ljava/lang/String;

    .line 666
    const-string v1, "event10,event23,event1"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->events:Ljava/lang/String;

    .line 667
    const-string v1, ";;;;event10=0"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->products:Ljava/lang/String;

    .line 668
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar58:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop58:Ljava/lang/String;

    .line 669
    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->urlbuilder(Lcom/espn/androidplayersdk/datamanager/Omniture;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->sendPingsToServer(Ljava/lang/String;)V

    .line 670
    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->setBeaconFiredTimeStamp()V

    .line 671
    return-void
.end method

.method videoStop(Ljava/lang/String;)V
    .locals 3
    .param p1, "segmentInterval"    # Ljava/lang/String;

    .prologue
    .line 706
    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->getCommonOmniValues(Ljava/lang/String;)Lcom/espn/androidplayersdk/datamanager/Omniture;

    move-result-object v0

    .line 707
    .local v0, "omniValues":Lcom/espn/androidplayersdk/datamanager/Omniture;
    const-string v1, "m_i"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pe:Ljava/lang/String;

    .line 708
    const-string v1, "event10,event23"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->events:Ljava/lang/String;

    .line 709
    const-string v1, "watchespn:videostopped"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pev2:Ljava/lang/String;

    .line 710
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, ";;;;event10="

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->getMinsPastSinceBeaconFired()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->products:Ljava/lang/String;

    .line 711
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar58:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop58:Ljava/lang/String;

    .line 712
    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->urlbuilder(Lcom/espn/androidplayersdk/datamanager/Omniture;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->sendPingsToServer(Ljava/lang/String;)V

    .line 713
    return-void
.end method

.method vodTrackingParam(Ljava/lang/String;)V
    .locals 3
    .param p1, "event"    # Ljava/lang/String;

    .prologue
    .line 559
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->videoStartType:Ljava/lang/String;
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$0(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_1

    .line 603
    :cond_0
    :goto_0
    return-void

    .line 562
    :cond_1
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/Omniture;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/Omniture;-><init>()V

    .line 563
    .local v0, "omniValues":Lcom/espn/androidplayersdk/datamanager/Omniture;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":video:start"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->pev2:Ljava/lang/String;

    .line 564
    iput-object p1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->events:Ljava/lang/String;

    .line 565
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->ch:Ljava/lang/String;

    .line 566
    const-string v1, "watchespn"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop1:Ljava/lang/String;

    .line 567
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "video:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getcoverageType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar11:Ljava/lang/String;

    .line 568
    const-string v1, "vod"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop35:Ljava/lang/String;

    .line 569
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "video:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getcoverageType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop4:Ljava/lang/String;

    .line 570
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getSport()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar19:Ljava/lang/String;

    .line 571
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getSport()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop25:Ljava/lang/String;

    .line 572
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getLeagueName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar21:Ljava/lang/String;

    .line 573
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getLeagueName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop26:Ljava/lang/String;

    .line 574
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->swid:Ljava/lang/String;
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$2(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop2:Ljava/lang/String;

    .line 575
    const-string v1, "en"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop17:Ljava/lang/String;

    .line 576
    const-string v1, "en"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar9:Ljava/lang/String;

    .line 577
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "watchespn:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->appVersion:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$3(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop47:Ljava/lang/String;

    .line 578
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop48:Ljava/lang/String;

    .line 579
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->isAuthenticated:Z
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$4(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 580
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getAffiliateID()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop42:Ljava/lang/String;

    .line 581
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getAffiliateID()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar17:Ljava/lang/String;

    .line 582
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getAffiliateID()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop43:Ljava/lang/String;

    .line 583
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getAffiliateID()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar32:Ljava/lang/String;

    .line 584
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getAffiliateID()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":authenticated:vod"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar68:Ljava/lang/String;

    .line 592
    :goto_1
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar2:Ljava/lang/String;

    .line 593
    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->srcApp:Ljava/lang/String;
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$5()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->srcApp:Ljava/lang/String;
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$5()Ljava/lang/String;

    move-result-object v1

    :goto_2
    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar3:Ljava/lang/String;

    .line 594
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->epEvents:Lcom/espn/androidplayersdk/datamanager/EPEvents;

    invoke-virtual {v2}, Lcom/espn/androidplayersdk/datamanager/EPEvents;->getEventName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop3:Ljava/lang/String;

    .line 595
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->videoStartType:Ljava/lang/String;
    invoke-static {v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$0(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar16:Ljava/lang/String;

    .line 596
    const-string v1, ""

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar20:Ljava/lang/String;

    .line 597
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":VOD"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop52:Ljava/lang/String;

    .line 598
    new-instance v1, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->this$0:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;

    # getter for: Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->platform:Ljava/lang/String;
    invoke-static {v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;->access$1(Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, ":VOD"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar52:Ljava/lang/String;

    .line 599
    const-string v1, "VOD"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop45:Ljava/lang/String;

    .line 600
    const-string v1, "VOD"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar34:Ljava/lang/String;

    .line 601
    iget-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar68:Ljava/lang/String;

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop68:Ljava/lang/String;

    .line 602
    invoke-virtual {p0, v0}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->urlbuilder(Lcom/espn/androidplayersdk/datamanager/Omniture;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$SendTrackingTask;->sendPingsToServer(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 586
    :cond_2
    const-string v1, "vod:not auth"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop42:Ljava/lang/String;

    .line 587
    const-string v1, "vod:not auth"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar17:Ljava/lang/String;

    .line 588
    const-string v1, "vod:not auth"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->prop43:Ljava/lang/String;

    .line 589
    const-string v1, "vod:not auth"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar32:Ljava/lang/String;

    .line 590
    const-string v1, "vod:not auth"

    iput-object v1, v0, Lcom/espn/androidplayersdk/datamanager/Omniture;->eVar68:Ljava/lang/String;

    goto/16 :goto_1

    .line 593
    :cond_3
    const/4 v1, 0x0

    goto/16 :goto_2
.end method
