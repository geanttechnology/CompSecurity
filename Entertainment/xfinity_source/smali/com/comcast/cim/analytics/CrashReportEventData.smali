.class public Lcom/comcast/cim/analytics/CrashReportEventData;
.super Lcom/comcast/cim/analytics/XfinityEventData;
.source "CrashReportEventData.java"


# direct methods
.method public constructor <init>(Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 3
    .param p1, "thread"    # Ljava/lang/Thread;
    .param p2, "throwable"    # Ljava/lang/Throwable;
    .param p3, "appVersion"    # Ljava/lang/String;

    .prologue
    .line 12
    const-string v1, "appCrash"

    invoke-direct {p0, v1}, Lcom/comcast/cim/analytics/XfinityEventData;-><init>(Ljava/lang/String;)V

    .line 13
    const-string v1, "thread"

    invoke-virtual {p1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/comcast/cim/analytics/CrashReportEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 14
    invoke-direct {p0, p2}, Lcom/comcast/cim/analytics/CrashReportEventData;->getFinalCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;

    move-result-object v0

    .line 15
    .local v0, "finalCause":Ljava/lang/Throwable;
    const-string v1, "exceptionType"

    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/comcast/cim/analytics/CrashReportEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 16
    const-string v1, "stacktrace"

    invoke-direct {p0, v0}, Lcom/comcast/cim/analytics/CrashReportEventData;->createRelevantStackTraceItem(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/comcast/cim/analytics/CrashReportEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 17
    const-string v1, "message"

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/comcast/cim/analytics/CrashReportEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 18
    const-string v1, "appVersion"

    invoke-virtual {p0, v1, p3}, Lcom/comcast/cim/analytics/CrashReportEventData;->addData(Ljava/lang/String;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method private createRelevantStackTraceItem(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 8
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    const/4 v5, 0x0

    .line 31
    invoke-virtual {p1}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v2

    .line 32
    .local v2, "elements":[Ljava/lang/StackTraceElement;
    const/4 v1, 0x0

    .line 33
    .local v1, "elementString":Ljava/lang/String;
    const/4 v3, 0x0

    .line 34
    .local v3, "found":Z
    array-length v6, v2

    move v4, v5

    :goto_0
    if-ge v4, v6, :cond_1

    aget-object v0, v2, v4

    .line 35
    .local v0, "element":Ljava/lang/StackTraceElement;
    invoke-virtual {v0}, Ljava/lang/StackTraceElement;->toString()Ljava/lang/String;

    move-result-object v1

    .line 36
    const-string v7, "com.comcast"

    invoke-virtual {v1, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    const-string v7, "com.xfinity"

    .line 37
    invoke-virtual {v1, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    const-string v7, "com.commonsware"

    .line 38
    invoke-virtual {v1, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    const-string v7, "com.devsmart"

    .line 39
    invoke-virtual {v1, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_0

    const-string v7, "com.ijsbrandslob"

    .line 40
    invoke-virtual {v1, v7}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 41
    :cond_0
    const/4 v3, 0x1

    .line 46
    .end local v0    # "element":Ljava/lang/StackTraceElement;
    :cond_1
    if-nez v3, :cond_2

    array-length v4, v2

    if-lez v4, :cond_2

    .line 49
    aget-object v4, v2, v5

    invoke-virtual {v4}, Ljava/lang/StackTraceElement;->toString()Ljava/lang/String;

    move-result-object v1

    .line 52
    :cond_2
    return-object v1

    .line 34
    .restart local v0    # "element":Ljava/lang/StackTraceElement;
    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_0
.end method

.method private getFinalCause(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    .locals 2
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 22
    move-object v0, p1

    .line 23
    .local v0, "finalCause":Ljava/lang/Throwable;
    :goto_0
    invoke-virtual {v0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 24
    invoke-virtual {v0}, Ljava/lang/Throwable;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    goto :goto_0

    .line 27
    :cond_0
    return-object v0
.end method
