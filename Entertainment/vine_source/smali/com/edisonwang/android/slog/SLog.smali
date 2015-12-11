.class public Lcom/edisonwang/android/slog/SLog;
.super Ljava/lang/Object;
.source "SLog.java"


# static fields
.field private static final TAG:Ljava/lang/String; = "Playback_"

.field private static sAuthority:Ljava/lang/String;

.field public static sIsAmazon:Z

.field public static sLogsOn:Z

.field private static sRandom:Ljava/util/Random;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    sput-object v0, Lcom/edisonwang/android/slog/SLog;->sRandom:Ljava/util/Random;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static b(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # Ljava/lang/Object;

    .prologue
    .line 104
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;Ljava/lang/Object;Z)V

    .line 105
    return-void
.end method

.method public static b(Ljava/lang/String;Ljava/lang/Object;Z)V
    .locals 3
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # Ljava/lang/Object;
    .param p2, "error"    # Z

    .prologue
    .line 86
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 87
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 88
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    if-eqz p2, :cond_1

    .line 89
    const-string v1, "Playback_[Benchmark]"

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 93
    :goto_0
    if-eqz p2, :cond_0

    sget-object v1, Lcom/edisonwang/android/slog/SLog;->sRandom:Ljava/util/Random;

    const/16 v2, 0x64

    invoke-virtual {v1, v2}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    const/16 v2, 0xa

    if-ge v1, v2, :cond_0

    .line 94
    new-instance v1, Ljava/lang/IllegalMonitorStateException;

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalMonitorStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 97
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void

    .line 91
    .restart local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_1
    const-string v1, "Playback_[Benchmark]"

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static b(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # [Ljava/lang/Object;

    .prologue
    .line 100
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/edisonwang/android/slog/SLog;->b(Ljava/lang/String;[Ljava/lang/Object;Z)V

    .line 101
    return-void
.end method

.method public static b(Ljava/lang/String;[Ljava/lang/Object;Z)V
    .locals 3
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # [Ljava/lang/Object;
    .param p2, "error"    # Z

    .prologue
    .line 72
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 73
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 74
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    if-eqz p2, :cond_1

    .line 75
    const-string v1, "Playback_[Benchmark]"

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 79
    :goto_0
    if-eqz p2, :cond_0

    sget-object v1, Lcom/edisonwang/android/slog/SLog;->sRandom:Ljava/util/Random;

    const/16 v2, 0x64

    invoke-virtual {v1, v2}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    const/16 v2, 0xa

    if-ge v1, v2, :cond_0

    .line 80
    new-instance v1, Ljava/lang/IllegalMonitorStateException;

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalMonitorStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 83
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void

    .line 77
    .restart local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_1
    const-string v1, "Playback_[Benchmark]"

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static d(Ljava/lang/String;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;

    .prologue
    .line 108
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 109
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 111
    :cond_0
    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # Ljava/lang/Object;

    .prologue
    .line 114
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 115
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 116
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 118
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 149
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 150
    invoke-static {p0, p1, p2}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 151
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 153
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;
    .param p3, "arg3"    # Ljava/lang/Object;

    .prologue
    .line 142
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 143
    invoke-static {p0, p1, p2, p3}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 144
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 146
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;
    .param p3, "arg3"    # Ljava/lang/Throwable;

    .prologue
    .line 135
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 136
    invoke-static {p0, p1, p2}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 137
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 139
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 128
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 129
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 130
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 132
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 163
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 164
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 166
    :cond_0
    return-void
.end method

.method public static d(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 156
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 157
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 158
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 160
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static d(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 121
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 122
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 123
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 125
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static dWithTag(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 66
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 67
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {p0, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 69
    :cond_0
    return-void
.end method

.method public static e(Ljava/lang/String;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;

    .prologue
    .line 256
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 257
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 259
    :cond_0
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # Ljava/lang/Object;

    .prologue
    .line 262
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 263
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 264
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 266
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 269
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 270
    invoke-static {p0, p1, p2}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 271
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 273
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # Ljava/lang/Object;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 283
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 284
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 285
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 287
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 297
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 298
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 300
    :cond_0
    return-void
.end method

.method public static e(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 290
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 291
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 292
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 294
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static e(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # [Ljava/lang/Object;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 276
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 277
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 278
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 280
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static e2(Ljava/lang/String;Ljava/lang/Exception;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 335
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 336
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass2()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine2()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 338
    :cond_0
    return-void
.end method

.method public static e2(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;
    .param p1, "e"    # Ljava/lang/Throwable;

    .prologue
    .line 347
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 348
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass2()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine2()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 350
    :cond_0
    return-void
.end method

.method public static getAuthority()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/edisonwang/android/slog/SLog;->sAuthority:Ljava/lang/String;

    return-object v0
.end method

.method private static getCallingClass()Ljava/lang/String;
    .locals 4

    .prologue
    .line 303
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v2

    const/4 v3, 0x4

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v0

    .line 304
    .local v0, "className":Ljava/lang/String;
    const/16 v2, 0x2e

    invoke-virtual {v0, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    .line 305
    .local v1, "lastPeriod":I
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-lt v1, v2, :cond_1

    .line 306
    const-string v0, ""

    .line 310
    :cond_0
    :goto_0
    return-object v0

    .line 307
    :cond_1
    if-ltz v1, :cond_0

    .line 308
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static getCallingClass2()Ljava/lang/String;
    .locals 4

    .prologue
    .line 324
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v2

    const/4 v3, 0x5

    aget-object v2, v2, v3

    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v0

    .line 325
    .local v0, "className":Ljava/lang/String;
    const/16 v2, 0x2e

    invoke-virtual {v0, v2}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v1

    .line 326
    .local v1, "lastPeriod":I
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-lt v1, v2, :cond_1

    .line 327
    const-string v0, ""

    .line 331
    :cond_0
    :goto_0
    return-object v0

    .line 328
    :cond_1
    if-ltz v1, :cond_0

    .line 329
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static getCallingLine()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v2, 0x4

    .line 314
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    aget-object v1, v1, v2

    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "()"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    aget-object v1, v1, v2

    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private static getCallingLine2()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v2, 0x5

    .line 319
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    aget-object v1, v1, v2

    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "()"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ":"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    aget-object v1, v1, v2

    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " - "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static i(Ljava/lang/String;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;

    .prologue
    .line 169
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 170
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 172
    :cond_0
    return-void
.end method

.method public static i(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # Ljava/lang/Object;

    .prologue
    .line 175
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 176
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 177
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 179
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static i(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 189
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 190
    invoke-static {p0, p1, p2}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 191
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 193
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static i(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;
    .param p3, "arg3"    # Ljava/lang/Object;

    .prologue
    .line 196
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 197
    invoke-static {p0, p1, p2, p3}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 198
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 200
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static i(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 182
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 183
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 184
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 186
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static i(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 210
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 211
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 213
    :cond_0
    return-void
.end method

.method public static i(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 203
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 204
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 205
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 207
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static i2(Ljava/lang/String;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;

    .prologue
    .line 341
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 342
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass2()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine2()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 344
    :cond_0
    return-void
.end method

.method public static setup(ZZLjava/lang/String;)V
    .locals 1
    .param p0, "logsOn"    # Z
    .param p1, "isAmazon"    # Z
    .param p2, "authority"    # Ljava/lang/String;

    .prologue
    .line 22
    sput-boolean p0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    .line 23
    sput-boolean p1, Lcom/edisonwang/android/slog/SLog;->sIsAmazon:Z

    .line 24
    sput-object p2, Lcom/edisonwang/android/slog/SLog;->sAuthority:Ljava/lang/String;

    .line 25
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    sput-object v0, Lcom/edisonwang/android/slog/SLog;->sRandom:Ljava/util/Random;

    .line 26
    return-void
.end method

.method public static v(Ljava/lang/String;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;

    .prologue
    .line 33
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 34
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 36
    :cond_0
    return-void
.end method

.method public static v(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # Ljava/lang/Object;

    .prologue
    .line 39
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 40
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 41
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 43
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static v(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 46
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 47
    invoke-static {p0, p1, p2}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 48
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 50
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static v(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 60
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 61
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 63
    :cond_0
    return-void
.end method

.method public static v(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 53
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 54
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 55
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 57
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static w(Ljava/lang/String;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;

    .prologue
    .line 216
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 217
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 219
    :cond_0
    return-void
.end method

.method public static w(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg"    # Ljava/lang/Object;

    .prologue
    .line 222
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 223
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 224
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 226
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static w(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # Ljava/lang/Object;
    .param p2, "arg2"    # Ljava/lang/Object;

    .prologue
    .line 236
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 237
    invoke-static {p0, p1, p2}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 238
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 240
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static w(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p0, "msg"    # Ljava/lang/String;
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 250
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 251
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Playback_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 253
    :cond_0
    return-void
.end method

.method public static w(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "args"    # [Ljava/lang/Object;

    .prologue
    .line 229
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 230
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 231
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 233
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method

.method public static w(Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 4
    .param p0, "format"    # Ljava/lang/String;
    .param p1, "arg1"    # [Ljava/lang/Object;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 243
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 244
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v0

    .line 245
    .local v0, "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Playback_"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingClass()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/edisonwang/android/slog/SLog;->getCallingLine()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, p2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 247
    .end local v0    # "ft":Lcom/edisonwang/android/slog/FormattingTuple;
    :cond_0
    return-void
.end method
