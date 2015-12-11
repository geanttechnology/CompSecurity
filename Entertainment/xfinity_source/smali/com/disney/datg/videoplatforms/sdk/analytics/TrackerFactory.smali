.class public Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory;
.super Ljava/lang/Object;
.source "TrackerFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$1;,
        Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;
    }
.end annotation


# direct methods
.method public static getTracker(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    .locals 8
    .param p0, "type"    # Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "configuration"    # Lcom/disney/datg/videoplatforms/sdk/media/Configuration;

    .prologue
    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 16
    sget-object v3, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackerFactory$TrackerType:[I

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackerFactory$TrackerType;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 36
    const/4 v1, 0x0

    :goto_0
    return-object v1

    .line 18
    :pswitch_0
    const/4 v1, 0x0

    .line 20
    .local v1, "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    :try_start_0
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;

    invoke-direct {v2, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/omniture/OmnitureTracker;-><init>(Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .end local v1    # "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    .local v2, "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    move-object v1, v2

    .line 23
    .end local v2    # "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    .restart local v1    # "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    goto :goto_0

    .line 21
    :catch_0
    move-exception v0

    .line 22
    .local v0, "e":Ljava/lang/Exception;
    const-string v3, "TrackerFactory"

    const-string v4, "OmnitureTracker instantiationFailure - %s"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 27
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    :pswitch_1
    const/4 v1, 0x0

    .line 29
    .restart local v1    # "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    :try_start_1
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;

    invoke-direct {v2, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;-><init>(Landroid/app/Activity;Lcom/disney/datg/videoplatforms/sdk/media/Configuration;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .end local v1    # "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    .restart local v2    # "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    move-object v1, v2

    .line 32
    .end local v2    # "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    .restart local v1    # "trackerInstance":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    goto :goto_0

    .line 30
    :catch_1
    move-exception v0

    .line 31
    .restart local v0    # "e":Ljava/lang/Exception;
    const-string v3, "TrackerFactory"

    const-string v4, "SloggerTracker instantiationFailure - %s"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGE(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 16
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
