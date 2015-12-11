.class public final Lcom/amazon/sdk/availability/Logger;
.super Ljava/lang/Object;
.source "Logger.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/sdk/availability/Logger$1;,
        Lcom/amazon/sdk/availability/Logger$LogcatLogObserver;,
        Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;
    }
.end annotation


# static fields
.field private static logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 12
    new-instance v0, Lcom/amazon/sdk/availability/Logger$LogcatLogObserver;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/sdk/availability/Logger$LogcatLogObserver;-><init>(Lcom/amazon/sdk/availability/Logger$1;)V

    sput-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 426
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 427
    return-void
.end method

.method public static e(Ljava/lang/String;)V
    .locals 1
    .param p0, "message"    # Ljava/lang/String;

    .prologue
    .line 311
    sget-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    invoke-interface {v0, p0}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->e(Ljava/lang/String;)V

    .line 312
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 322
    sget-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    invoke-interface {v0, p0, p1}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 323
    return-void
.end method

.method public static i(Ljava/lang/String;)V
    .locals 1
    .param p0, "message"    # Ljava/lang/String;

    .prologue
    .line 269
    sget-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    invoke-interface {v0, p0}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->i(Ljava/lang/String;)V

    .line 270
    return-void
.end method

.method public static measurementRecorded(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "measurementName"    # Ljava/lang/String;
    .param p1, "clientId"    # Ljava/lang/String;

    .prologue
    .line 409
    sget-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    invoke-interface {v0, p0, p1}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->measurementRecorded(Ljava/lang/String;Ljava/lang/String;)V

    .line 410
    return-void
.end method

.method public static measurementsSubmitted(ZJLjava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p0, "isSuccessful"    # Z
    .param p1, "numMeasurements"    # J
    .param p3, "s3Bucket"    # Ljava/lang/String;
    .param p4, "s3Key"    # Ljava/lang/String;

    .prologue
    .line 380
    sget-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    move v1, p0

    move-wide v2, p1

    move-object v4, p3

    move-object v5, p4

    invoke-interface/range {v0 .. v5}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->measurementsSubmitted(ZJLjava/lang/String;Ljava/lang/String;)V

    .line 381
    return-void
.end method

.method public static syncConfigurationScheduled(Ljava/lang/Long;Z)V
    .locals 3
    .param p0, "nextSyncTime"    # Ljava/lang/Long;
    .param p1, "isRepeating"    # Z

    .prologue
    .line 392
    if-nez p0, :cond_0

    .line 393
    const-wide/16 v0, 0x0

    .line 398
    .local v0, "t":J
    :goto_0
    sget-object v2, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    invoke-interface {v2, v0, v1, p1}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->syncConfigurationScheduled(JZ)V

    .line 399
    return-void

    .line 395
    .end local v0    # "t":J
    :cond_0
    invoke-virtual {p0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .restart local v0    # "t":J
    goto :goto_0
.end method

.method public static v(Ljava/lang/String;)V
    .locals 1
    .param p0, "message"    # Ljava/lang/String;

    .prologue
    .line 332
    sget-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    invoke-interface {v0, p0}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->v(Ljava/lang/String;)V

    .line 333
    return-void
.end method

.method public static v(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 343
    sget-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    invoke-interface {v0, p0, p1}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->v(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 344
    return-void
.end method

.method public static w(Ljava/lang/String;)V
    .locals 1
    .param p0, "message"    # Ljava/lang/String;

    .prologue
    .line 353
    sget-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    invoke-interface {v0, p0}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->w(Ljava/lang/String;)V

    .line 354
    return-void
.end method

.method public static w(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 364
    sget-object v0, Lcom/amazon/sdk/availability/Logger;->logObserver:Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;

    invoke-interface {v0, p0, p1}, Lcom/amazon/sdk/availability/Logger$AvailabilityLogObserver;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 365
    return-void
.end method
