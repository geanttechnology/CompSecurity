.class public Lcom/amazon/mcc/record/android/RecordLogger;
.super Lcom/amazon/mcc/record/BasicRecorder;
.source "RecordLogger.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/amazon/mcc/record/BasicRecorder;-><init>()V

    .line 26
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mcc/record/RecordableContext;)V
    .locals 0
    .param p1, "context"    # Lcom/amazon/mcc/record/RecordableContext;

    .prologue
    .line 34
    invoke-direct {p0, p1}, Lcom/amazon/mcc/record/BasicRecorder;-><init>(Lcom/amazon/mcc/record/RecordableContext;)V

    .line 35
    return-void
.end method


# virtual methods
.method public e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 69
    new-instance v0, Lcom/amazon/mcc/record/android/LogRecord;

    sget-object v1, Lcom/amazon/mcc/record/android/AndroidLogLevel;->ERROR:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    invoke-direct {v0, v1, p1, p2}, Lcom/amazon/mcc/record/android/LogRecord;-><init>(Lcom/amazon/mcc/record/android/AndroidLogLevel;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mcc/record/android/RecordLogger;->record(Lcom/amazon/mcc/record/Recordable;)V

    .line 70
    return-void
.end method

.method public e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;
    .param p3, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 82
    new-instance v0, Lcom/amazon/mcc/record/android/LogRecord;

    sget-object v1, Lcom/amazon/mcc/record/android/AndroidLogLevel;->ERROR_THROWABLE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    invoke-direct {v0, v1, p1, p2, p3}, Lcom/amazon/mcc/record/android/LogRecord;-><init>(Lcom/amazon/mcc/record/android/AndroidLogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mcc/record/android/RecordLogger;->record(Lcom/amazon/mcc/record/Recordable;)V

    .line 83
    return-void
.end method

.method public i(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 93
    new-instance v0, Lcom/amazon/mcc/record/android/LogRecord;

    sget-object v1, Lcom/amazon/mcc/record/android/AndroidLogLevel;->INFO:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    invoke-direct {v0, v1, p1, p2}, Lcom/amazon/mcc/record/android/LogRecord;-><init>(Lcom/amazon/mcc/record/android/AndroidLogLevel;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mcc/record/android/RecordLogger;->record(Lcom/amazon/mcc/record/Recordable;)V

    .line 94
    return-void
.end method

.method public v(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 130
    new-instance v0, Lcom/amazon/mcc/record/android/LogRecord;

    sget-object v1, Lcom/amazon/mcc/record/android/AndroidLogLevel;->VERBOSE:Lcom/amazon/mcc/record/android/AndroidLogLevel;

    invoke-direct {v0, v1, p1, p2}, Lcom/amazon/mcc/record/android/LogRecord;-><init>(Lcom/amazon/mcc/record/android/AndroidLogLevel;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mcc/record/android/RecordLogger;->record(Lcom/amazon/mcc/record/Recordable;)V

    .line 131
    return-void
.end method
