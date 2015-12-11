.class public final Lcom/amazon/sdk/availability/Clock;
.super Ljava/lang/Object;
.source "Clock.java"


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    return-void
.end method

.method public static getAdjustedTime(Landroid/content/Context;J)J
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "t"    # J

    .prologue
    .line 37
    invoke-static {p0}, Lcom/amazon/sdk/availability/Clock;->getAdjustment(Landroid/content/Context;)J

    move-result-wide v0

    add-long/2addr v0, p1

    return-wide v0
.end method

.method protected static getAdjustment(Landroid/content/Context;)J
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 62
    const-wide/16 v3, 0x0

    .line 63
    .local v3, "result":J
    if-eqz p0, :cond_0

    .line 64
    new-instance v2, Lcom/amazon/sdk/availability/Preferences;

    invoke-direct {v2, p0}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 65
    .local v2, "preferences":Lcom/amazon/sdk/availability/Preferences;
    const-string/jumbo v5, "timeAdjustment"

    invoke-virtual {v2, v5}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 66
    .local v0, "adjustmentString":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 68
    :try_start_0
    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v3

    .line 74
    .end local v0    # "adjustmentString":Ljava/lang/String;
    .end local v2    # "preferences":Lcom/amazon/sdk/availability/Preferences;
    :cond_0
    :goto_0
    return-wide v3

    .line 69
    .restart local v0    # "adjustmentString":Ljava/lang/String;
    .restart local v2    # "preferences":Lcom/amazon/sdk/availability/Preferences;
    :catch_0
    move-exception v1

    .line 70
    .local v1, "e":Ljava/lang/NumberFormatException;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "invalid adjustment time format: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5, v1}, Lcom/amazon/sdk/availability/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static getCurrentTime(Landroid/content/Context;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 24
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {p0}, Lcom/amazon/sdk/availability/Clock;->getAdjustment(Landroid/content/Context;)J

    move-result-wide v2

    add-long/2addr v0, v2

    return-wide v0
.end method

.method public static updateAdjustment(Landroid/content/Context;J)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serverTime"    # J

    .prologue
    .line 49
    new-instance v0, Lcom/amazon/sdk/availability/Preferences;

    invoke-direct {v0, p0}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    .line 50
    .local v0, "preferences":Lcom/amazon/sdk/availability/Preferences;
    const-string/jumbo v1, "timeAdjustment"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sub-long v2, p1, v2

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    return-void
.end method
