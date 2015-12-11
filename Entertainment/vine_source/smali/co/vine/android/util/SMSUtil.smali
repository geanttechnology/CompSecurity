.class public Lco/vine/android/util/SMSUtil;
.super Ljava/lang/Object;
.source "SMSUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static sendSMS(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 8
    .param p0, "dest"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    const/16 v2, 0x8c

    const/4 v7, 0x0

    .line 10
    invoke-static {}, Landroid/telephony/SmsManager;->getDefault()Landroid/telephony/SmsManager;

    move-result-object v0

    .line 11
    .local v0, "defaultManager":Landroid/telephony/SmsManager;
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-le v1, v2, :cond_0

    .line 12
    invoke-virtual {p1, v7, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 13
    const-string v1, "Message is truncated."

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 15
    :cond_0
    if-eqz v0, :cond_1

    .line 17
    const/4 v2, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    move-object v1, p0

    move-object v3, p1

    :try_start_0
    invoke-virtual/range {v0 .. v5}, Landroid/telephony/SmsManager;->sendTextMessage(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/app/PendingIntent;Landroid/app/PendingIntent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 21
    :goto_0
    const/4 v1, 0x1

    .line 23
    :goto_1
    return v1

    .line 18
    :catch_0
    move-exception v6

    .line 19
    .local v6, "e":Ljava/lang/Exception;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Failed to send: {"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-array v2, v7, [Ljava/lang/Object;

    invoke-static {v6, v1, v2}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    .end local v6    # "e":Ljava/lang/Exception;
    :cond_1
    move v1, v7

    .line 23
    goto :goto_1
.end method
