.class Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;
.super Ljava/lang/Object;
.source "AvailabilityAppender.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "LogMessage"
.end annotation


# instance fields
.field private exception:Ljava/lang/Throwable;

.field private level:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field private message:Ljava/lang/String;

.field private timestamp:Ljava/lang/Long;


# direct methods
.method public constructor <init>(Lcom/amazon/device/analytics/log/Logging$LogLevel;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "level"    # Lcom/amazon/device/analytics/log/Logging$LogLevel;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "exception"    # Ljava/lang/Throwable;

    .prologue
    const/4 v0, 0x0

    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->message:Ljava/lang/String;

    .line 48
    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->exception:Ljava/lang/Throwable;

    .line 49
    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->timestamp:Ljava/lang/Long;

    .line 50
    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->level:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 53
    iput-object p1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->level:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 54
    iput-object p2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->message:Ljava/lang/String;

    .line 55
    iput-object p3, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->exception:Ljava/lang/Throwable;

    .line 56
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->timestamp:Ljava/lang/Long;

    .line 57
    return-void
.end method

.method private getThrowableAsString(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 7
    .param p1, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 92
    const-string/jumbo v2, ""

    .line 93
    .local v2, "output":Ljava/lang/String;
    const/4 v3, 0x0

    .line 94
    .local v3, "stream":Ljava/io/PrintStream;
    const/4 v0, 0x0

    .line 96
    .local v0, "outStream":Ljava/io/ByteArrayOutputStream;
    :try_start_0
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 97
    .end local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    .local v1, "outStream":Ljava/io/ByteArrayOutputStream;
    :try_start_1
    new-instance v4, Ljava/io/PrintStream;

    invoke-direct {v4, v1}, Ljava/io/PrintStream;-><init>(Ljava/io/OutputStream;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 98
    .end local v3    # "stream":Ljava/io/PrintStream;
    .local v4, "stream":Ljava/io/PrintStream;
    :try_start_2
    invoke-virtual {p1, v4}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintStream;)V

    .line 99
    invoke-virtual {v4}, Ljava/io/PrintStream;->close()V

    .line 100
    const-string/jumbo v5, "UTF-8"

    invoke-virtual {v1, v5}, Ljava/io/ByteArrayOutputStream;->toString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_5
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-result-object v2

    .line 104
    if-eqz v4, :cond_0

    .line 105
    invoke-virtual {v4}, Ljava/io/PrintStream;->close()V

    .line 108
    :cond_0
    if-eqz v1, :cond_5

    .line 110
    :try_start_3
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0

    move-object v0, v1

    .end local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    move-object v3, v4

    .line 116
    .end local v4    # "stream":Ljava/io/PrintStream;
    .restart local v3    # "stream":Ljava/io/PrintStream;
    :cond_1
    :goto_0
    return-object v2

    .line 111
    .end local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    .end local v3    # "stream":Ljava/io/PrintStream;
    .restart local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "stream":Ljava/io/PrintStream;
    :catch_0
    move-exception v5

    move-object v0, v1

    .end local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    move-object v3, v4

    .line 113
    .end local v4    # "stream":Ljava/io/PrintStream;
    .restart local v3    # "stream":Ljava/io/PrintStream;
    goto :goto_0

    .line 101
    :catch_1
    move-exception v5

    .line 104
    :goto_1
    if-eqz v3, :cond_2

    .line 105
    invoke-virtual {v3}, Ljava/io/PrintStream;->close()V

    .line 108
    :cond_2
    if-eqz v0, :cond_1

    .line 110
    :try_start_4
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_0

    .line 111
    :catch_2
    move-exception v5

    goto :goto_0

    .line 104
    :catchall_0
    move-exception v5

    :goto_2
    if-eqz v3, :cond_3

    .line 105
    invoke-virtual {v3}, Ljava/io/PrintStream;->close()V

    .line 108
    :cond_3
    if-eqz v0, :cond_4

    .line 110
    :try_start_5
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 113
    :cond_4
    :goto_3
    throw v5

    .line 111
    :catch_3
    move-exception v6

    goto :goto_3

    .line 104
    .end local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    :catchall_1
    move-exception v5

    move-object v0, v1

    .end local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    goto :goto_2

    .end local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    .end local v3    # "stream":Ljava/io/PrintStream;
    .restart local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "stream":Ljava/io/PrintStream;
    :catchall_2
    move-exception v5

    move-object v0, v1

    .end local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    move-object v3, v4

    .end local v4    # "stream":Ljava/io/PrintStream;
    .restart local v3    # "stream":Ljava/io/PrintStream;
    goto :goto_2

    .line 101
    .end local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    :catch_4
    move-exception v5

    move-object v0, v1

    .end local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    goto :goto_1

    .end local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    .end local v3    # "stream":Ljava/io/PrintStream;
    .restart local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "stream":Ljava/io/PrintStream;
    :catch_5
    move-exception v5

    move-object v0, v1

    .end local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    move-object v3, v4

    .end local v4    # "stream":Ljava/io/PrintStream;
    .restart local v3    # "stream":Ljava/io/PrintStream;
    goto :goto_1

    .end local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    .end local v3    # "stream":Ljava/io/PrintStream;
    .restart local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v4    # "stream":Ljava/io/PrintStream;
    :cond_5
    move-object v0, v1

    .end local v1    # "outStream":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "outStream":Ljava/io/ByteArrayOutputStream;
    move-object v3, v4

    .end local v4    # "stream":Ljava/io/PrintStream;
    .restart local v3    # "stream":Ljava/io/PrintStream;
    goto :goto_0
.end method


# virtual methods
.method public toJSON()Lorg/json/JSONObject;
    .locals 3

    .prologue
    .line 60
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 62
    .local v0, "output":Lorg/json/JSONObject;
    iget-object v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->level:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    if-eqz v1, :cond_0

    .line 64
    :try_start_0
    const-string/jumbo v1, "logLevel"

    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->level:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {v2}, Lcom/amazon/device/analytics/log/Logging$LogLevel;->name()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_3

    .line 70
    :cond_0
    :goto_0
    :try_start_1
    const-string/jumbo v1, "timestamp"

    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->timestamp:Ljava/lang/Long;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_2

    .line 74
    :goto_1
    iget-object v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->message:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 76
    :try_start_2
    const-string/jumbo v1, "message"

    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->message:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_1

    .line 81
    :cond_1
    :goto_2
    iget-object v1, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->exception:Ljava/lang/Throwable;

    if-eqz v1, :cond_2

    .line 83
    :try_start_3
    const-string/jumbo v1, "exception"

    iget-object v2, p0, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->exception:Ljava/lang/Throwable;

    invoke-direct {p0, v2}, Lcom/amazon/device/analytics/log/appenders/AvailabilityAppender$LogMessage;->getThrowableAsString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_0

    .line 88
    :cond_2
    :goto_3
    return-object v0

    .line 84
    :catch_0
    move-exception v1

    goto :goto_3

    .line 77
    :catch_1
    move-exception v1

    goto :goto_2

    .line 71
    :catch_2
    move-exception v1

    goto :goto_1

    .line 65
    :catch_3
    move-exception v1

    goto :goto_0
.end method
