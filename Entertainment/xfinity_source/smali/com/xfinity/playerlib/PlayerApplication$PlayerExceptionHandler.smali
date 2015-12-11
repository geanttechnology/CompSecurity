.class Lcom/xfinity/playerlib/PlayerApplication$PlayerExceptionHandler;
.super Ljava/lang/Object;
.source "PlayerApplication.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/PlayerApplication;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "PlayerExceptionHandler"
.end annotation


# instance fields
.field private defaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

.field final synthetic this$0:Lcom/xfinity/playerlib/PlayerApplication;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/PlayerApplication;)V
    .locals 1

    .prologue
    .line 155
    iput-object p1, p0, Lcom/xfinity/playerlib/PlayerApplication$PlayerExceptionHandler;->this$0:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 156
    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/PlayerApplication$PlayerExceptionHandler;->defaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    .line 157
    return-void
.end method


# virtual methods
.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "thread"    # Ljava/lang/Thread;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 162
    :try_start_0
    new-instance v0, Lcom/comcast/cim/analytics/CrashReportEventData;

    iget-object v1, p0, Lcom/xfinity/playerlib/PlayerApplication$PlayerExceptionHandler;->this$0:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionNumber()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, p2, v1}, Lcom/comcast/cim/analytics/CrashReportEventData;-><init>(Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;)V

    .line 163
    .local v0, "data":Lcom/comcast/cim/cmasl/analytics/EventData;
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getSplunkLogger()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v1

    invoke-interface {v1, v0}, Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;->logData(Lcom/comcast/cim/cmasl/analytics/EventData;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 167
    .end local v0    # "data":Lcom/comcast/cim/cmasl/analytics/EventData;
    :goto_0
    iget-object v1, p0, Lcom/xfinity/playerlib/PlayerApplication$PlayerExceptionHandler;->defaultHandler:Ljava/lang/Thread$UncaughtExceptionHandler;

    invoke-interface {v1, p1, p2}, Ljava/lang/Thread$UncaughtExceptionHandler;->uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V

    .line 168
    return-void

    .line 164
    :catch_0
    move-exception v1

    goto :goto_0
.end method
