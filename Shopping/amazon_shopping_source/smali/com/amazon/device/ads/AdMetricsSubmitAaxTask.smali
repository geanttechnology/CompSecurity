.class Lcom/amazon/device/ads/AdMetricsSubmitAaxTask;
.super Landroid/os/AsyncTask;
.source "AdMetricsTasks.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AdMetricsSubmitAaxTask$1;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Lcom/amazon/device/ads/WebRequest;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String; = "AdMetricsSubmitTask"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 48
    return-void
.end method


# virtual methods
.method public bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 16
    check-cast p1, [Lcom/amazon/device/ads/WebRequest;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/device/ads/AdMetricsSubmitAaxTask;->doInBackground([Lcom/amazon/device/ads/WebRequest;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public varargs doInBackground([Lcom/amazon/device/ads/WebRequest;)Ljava/lang/Void;
    .locals 11
    .param p1, "webRequests"    # [Lcom/amazon/device/ads/WebRequest;

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 22
    move-object v0, p1

    .local v0, "arr$":[Lcom/amazon/device/ads/WebRequest;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v4, v0, v2

    .line 26
    .local v4, "webRequest":Lcom/amazon/device/ads/WebRequest;
    :try_start_0
    invoke-virtual {v4}, Lcom/amazon/device/ads/WebRequest;->makeCall()Lcom/amazon/device/ads/WebRequest$WebResponse;
    :try_end_0
    .catch Lcom/amazon/device/ads/WebRequest$WebRequestException; {:try_start_0 .. :try_end_0} :catch_0

    .line 22
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 31
    :catch_0
    move-exception v1

    .line 33
    .local v1, "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    sget-object v5, Lcom/amazon/device/ads/AdMetricsSubmitAaxTask$1;->$SwitchMap$com$amazon$device$ads$WebRequest$WebRequestStatus:[I

    invoke-virtual {v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;->getStatus()Lcom/amazon/device/ads/WebRequest$WebRequestStatus;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/device/ads/WebRequest$WebRequestStatus;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    goto :goto_1

    .line 36
    :pswitch_0
    const-string/jumbo v5, "AdMetricsSubmitTask"

    const-string/jumbo v6, "Unable to submit metrics for ad due to an Invalid Client Protocol, msg: %s"

    new-array v7, v10, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 39
    :pswitch_1
    const-string/jumbo v5, "AdMetricsSubmitTask"

    const-string/jumbo v6, "Unable to submit metrics for ad due to Network Failure, msg: %s"

    new-array v7, v10, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 42
    :pswitch_2
    const-string/jumbo v5, "AdMetricsSubmitTask"

    const-string/jumbo v6, "Unable to submit metrics for ad due to a Malformed Pixel URL, msg: %s"

    new-array v7, v10, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 44
    :pswitch_3
    const-string/jumbo v5, "AdMetricsSubmitTask"

    const-string/jumbo v6, "Unable to submit metrics for ad because of unsupported character encoding, msg: %s"

    new-array v7, v10, [Ljava/lang/Object;

    invoke-virtual {v1}, Lcom/amazon/device/ads/WebRequest$WebRequestException;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v9

    invoke-static {v5, v6, v7}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 54
    .end local v1    # "e":Lcom/amazon/device/ads/WebRequest$WebRequestException;
    .end local v4    # "webRequest":Lcom/amazon/device/ads/WebRequest;
    :cond_0
    const/4 v5, 0x0

    return-object v5

    .line 33
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method
