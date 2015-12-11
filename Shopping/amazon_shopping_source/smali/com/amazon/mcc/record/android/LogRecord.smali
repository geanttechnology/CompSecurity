.class public Lcom/amazon/mcc/record/android/LogRecord;
.super Lcom/amazon/mcc/record/Record;
.source "LogRecord.java"


# direct methods
.method public constructor <init>(Lcom/amazon/mcc/record/android/AndroidLogLevel;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "logLevel"    # Lcom/amazon/mcc/record/android/AndroidLogLevel;
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;

    .prologue
    .line 41
    const-string/jumbo v0, "Log"

    invoke-direct {p0, v0, p3}, Lcom/amazon/mcc/record/Record;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 42
    const-string/jumbo v0, "Log"

    invoke-virtual {p0, v0}, Lcom/amazon/mcc/record/android/LogRecord;->setType(Ljava/lang/String;)V

    .line 43
    invoke-direct {p0, p2}, Lcom/amazon/mcc/record/android/LogRecord;->setTag(Ljava/lang/String;)V

    .line 44
    invoke-direct {p0, p1}, Lcom/amazon/mcc/record/android/LogRecord;->setLogLevel(Lcom/amazon/mcc/record/android/AndroidLogLevel;)V

    .line 45
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mcc/record/android/AndroidLogLevel;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "logLevel"    # Lcom/amazon/mcc/record/android/AndroidLogLevel;
    .param p2, "tag"    # Ljava/lang/String;
    .param p3, "message"    # Ljava/lang/String;
    .param p4, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 60
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mcc/record/android/LogRecord;-><init>(Lcom/amazon/mcc/record/android/AndroidLogLevel;Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    invoke-direct {p0, p4}, Lcom/amazon/mcc/record/android/LogRecord;->setThrowable(Ljava/lang/Throwable;)V

    .line 62
    return-void
.end method

.method private setLogLevel(Lcom/amazon/mcc/record/android/AndroidLogLevel;)V
    .locals 1
    .param p1, "logLevel"    # Lcom/amazon/mcc/record/android/AndroidLogLevel;

    .prologue
    .line 102
    const-string/jumbo v0, "LogLevel"

    invoke-virtual {p0, v0, p1}, Lcom/amazon/mcc/record/android/LogRecord;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    .line 103
    return-void
.end method

.method private setTag(Ljava/lang/String;)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 84
    const-string/jumbo v0, "LogTag"

    invoke-virtual {p0, v0, p1}, Lcom/amazon/mcc/record/android/LogRecord;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    .line 85
    return-void
.end method

.method private setThrowable(Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "logLevel"    # Ljava/lang/Throwable;

    .prologue
    .line 93
    const-string/jumbo v0, "Throwable"

    invoke-virtual {p0, v0, p1}, Lcom/amazon/mcc/record/android/LogRecord;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    .line 94
    return-void
.end method
