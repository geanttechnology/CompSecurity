.class public Lco/vine/android/util/CrashUtil;
.super Ljava/lang/Object;
.source "CrashUtil.java"


# static fields
.field private static final sEnv:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private static final sLock:[I

.field private static sLogsOn:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lco/vine/android/util/CrashUtil;->sEnv:Ljava/util/HashMap;

    .line 28
    const/4 v0, 0x0

    new-array v0, v0, [I

    sput-object v0, Lco/vine/android/util/CrashUtil;->sLock:[I

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static collectLogs(II)V
    .locals 17
    .param p0, "lineCount"    # I
    .param p1, "ignoreCount"    # I

    .prologue
    .line 127
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    .line 128
    .local v10, "start":J
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 129
    .local v1, "commandLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    const-string v13, "logcat"

    invoke-virtual {v1, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 130
    const-string v13, "-d"

    invoke-virtual {v1, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 131
    const-string v13, "V"

    invoke-virtual {v1, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 132
    add-int v13, p0, p1

    new-array v5, v13, [Ljava/lang/String;

    .line 133
    .local v5, "last":[Ljava/lang/String;
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v14

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v13

    new-array v13, v13, [Ljava/lang/String;

    invoke-virtual {v1, v13}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v13

    check-cast v13, [Ljava/lang/String;

    invoke-virtual {v14, v13}, Ljava/lang/Runtime;->exec([Ljava/lang/String;)Ljava/lang/Process;

    move-result-object v9

    .line 134
    .local v9, "process":Ljava/lang/Process;
    new-instance v0, Ljava/io/BufferedReader;

    new-instance v13, Ljava/io/InputStreamReader;

    invoke-virtual {v9}, Ljava/lang/Process;->getInputStream()Ljava/io/InputStream;

    move-result-object v14

    invoke-direct {v13, v14}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v0, v13}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 135
    .local v0, "bufferedReader":Ljava/io/BufferedReader;
    const/4 v7, 0x0

    .line 136
    .local v7, "n":I
    const/4 v3, 0x0

    .line 139
    .local v3, "hasMore":Z
    :cond_0
    :goto_0
    :try_start_1
    invoke-virtual {v0}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v6

    .local v6, "line":Ljava/lang/String;
    if-eqz v6, :cond_1

    .line 140
    aput-object v6, v5, v7

    .line 141
    add-int/lit8 v7, v7, 0x1

    .line 142
    array-length v13, v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-ne v7, v13, :cond_0

    .line 143
    const/4 v3, 0x1

    .line 144
    const/4 v7, 0x0

    goto :goto_0

    .line 148
    :cond_1
    :try_start_2
    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    .line 150
    if-eqz v3, :cond_4

    move/from16 v12, p0

    .line 151
    .local v12, "total":I
    :goto_1
    const/4 v8, 0x0

    .line 152
    .local v8, "outputStream":Ljava/io/PrintStream;
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_2
    if-ge v4, v12, :cond_6

    .line 153
    sget-boolean v13, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v13, :cond_5

    .line 154
    if-nez v8, :cond_2

    .line 155
    new-instance v8, Ljava/io/PrintStream;

    .end local v8    # "outputStream":Ljava/io/PrintStream;
    new-instance v13, Ljava/io/FileOutputStream;

    new-instance v14, Ljava/io/File;

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v15

    const-string v16, "vine_logs.txt"

    invoke-direct/range {v14 .. v16}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    invoke-direct {v13, v14}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v8, v13}, Ljava/io/PrintStream;-><init>(Ljava/io/OutputStream;)V

    .line 157
    .restart local v8    # "outputStream":Ljava/io/PrintStream;
    :cond_2
    aget-object v13, v5, v7

    invoke-virtual {v8, v13}, Ljava/io/PrintStream;->print(Ljava/lang/String;)V

    .line 158
    invoke-virtual {v8}, Ljava/io/PrintStream;->println()V

    .line 162
    :goto_3
    add-int/lit8 v7, v7, 0x1

    .line 163
    array-length v13, v5

    if-ne v7, v13, :cond_3

    .line 164
    const/4 v7, 0x0

    .line 152
    :cond_3
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 148
    .end local v4    # "i":I
    .end local v6    # "line":Ljava/lang/String;
    .end local v8    # "outputStream":Ljava/io/PrintStream;
    .end local v12    # "total":I
    :catchall_0
    move-exception v13

    invoke-virtual {v0}, Ljava/io/BufferedReader;->close()V

    throw v13
    :try_end_2
    .catch Ljava/lang/Throwable; {:try_start_2 .. :try_end_2} :catch_0

    .line 172
    .end local v0    # "bufferedReader":Ljava/io/BufferedReader;
    .end local v1    # "commandLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .end local v3    # "hasMore":Z
    .end local v5    # "last":[Ljava/lang/String;
    .end local v7    # "n":I
    .end local v9    # "process":Ljava/lang/Process;
    .end local v10    # "start":J
    :catch_0
    move-exception v2

    .line 173
    .local v2, "e":Ljava/lang/Throwable;
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "Failed to print out the last few lines: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 175
    .end local v2    # "e":Ljava/lang/Throwable;
    :goto_4
    return-void

    .restart local v0    # "bufferedReader":Ljava/io/BufferedReader;
    .restart local v1    # "commandLine":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    .restart local v3    # "hasMore":Z
    .restart local v5    # "last":[Ljava/lang/String;
    .restart local v6    # "line":Ljava/lang/String;
    .restart local v7    # "n":I
    .restart local v9    # "process":Ljava/lang/Process;
    .restart local v10    # "start":J
    :cond_4
    move v12, v7

    .line 150
    goto :goto_1

    .line 160
    .restart local v4    # "i":I
    .restart local v8    # "outputStream":Ljava/io/PrintStream;
    .restart local v12    # "total":I
    :cond_5
    :try_start_3
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "[adb] "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    aget-object v14, v5, v7

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_3

    .line 167
    :cond_6
    if-eqz v8, :cond_7

    .line 168
    invoke-virtual {v8}, Ljava/io/PrintStream;->flush()V

    .line 169
    invoke-virtual {v8}, Ljava/io/PrintStream;->close()V

    .line 171
    :cond_7
    const-string v13, "Collecting logs took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v14

    sub-long/2addr v14, v10

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v14

    invoke-static {v13, v14}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_3
    .catch Ljava/lang/Throwable; {:try_start_3 .. :try_end_3} :catch_0

    goto :goto_4
.end method

.method public static getDefaultIgnoreCountForLogCollection(Ljava/lang/Throwable;)I
    .locals 2
    .param p0, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 178
    const/4 v0, 0x4

    .line 179
    .local v0, "ignoreCount":I
    if-eqz p0, :cond_0

    .line 180
    invoke-virtual {p0}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v1

    .line 181
    .local v1, "st":[Ljava/lang/StackTraceElement;
    if-eqz v1, :cond_0

    .line 182
    array-length v0, v1

    .line 185
    .end local v1    # "st":[Ljava/lang/StackTraceElement;
    :cond_0
    return v0
.end method

.method public static getStackTraceAsString(Ljava/lang/Throwable;)Ljava/lang/String;
    .locals 3
    .param p0, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 86
    new-instance v1, Ljava/io/StringWriter;

    invoke-direct {v1}, Ljava/io/StringWriter;-><init>()V

    .line 87
    .local v1, "sw":Ljava/io/StringWriter;
    new-instance v0, Ljava/io/PrintWriter;

    const/4 v2, 0x1

    invoke-direct {v0, v1, v2}, Ljava/io/PrintWriter;-><init>(Ljava/io/Writer;Z)V

    .line 88
    .local v0, "pw":Ljava/io/PrintWriter;
    invoke-virtual {p0, v0}, Ljava/lang/Throwable;->printStackTrace(Ljava/io/PrintWriter;)V

    .line 89
    invoke-virtual {v1}, Ljava/io/StringWriter;->getBuffer()Ljava/lang/StringBuffer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static log(Ljava/lang/String;)V
    .locals 1
    .param p0, "log"    # Ljava/lang/String;

    .prologue
    .line 53
    sget-boolean v0, Lco/vine/android/util/CrashUtil;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 54
    invoke-static {p0}, Lcom/edisonwang/android/slog/SLog;->i2(Ljava/lang/String;)V

    .line 58
    :goto_0
    return-void

    .line 56
    :cond_0
    invoke-static {p0}, Lcom/crashlytics/android/Crashlytics;->log(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static varargs log(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 2
    .param p0, "message"    # Ljava/lang/String;
    .param p1, "objects"    # [Ljava/lang/Object;

    .prologue
    .line 61
    invoke-static {p0, p1}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v1

    invoke-virtual {v1}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v0

    .line 62
    .local v0, "log":Ljava/lang/String;
    sget-boolean v1, Lco/vine/android/util/CrashUtil;->sLogsOn:Z

    if-eqz v1, :cond_0

    .line 63
    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->i2(Ljava/lang/String;)V

    .line 67
    :goto_0
    return-void

    .line 65
    :cond_0
    invoke-static {v0}, Lcom/crashlytics/android/Crashlytics;->log(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static logException(Ljava/lang/Throwable;)V
    .locals 2
    .param p0, "e"    # Ljava/lang/Throwable;

    .prologue
    .line 44
    sget-boolean v0, Lco/vine/android/util/CrashUtil;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 45
    const-string v0, "Exception was logged."

    invoke-static {v0, p0}, Lcom/edisonwang/android/slog/SLog;->e2(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 50
    :goto_0
    return-void

    .line 47
    :cond_0
    invoke-static {p0}, Lcom/crashlytics/android/Crashlytics;->logException(Ljava/lang/Throwable;)V

    .line 48
    const-string v0, "LastException"

    invoke-static {p0}, Lco/vine/android/util/CrashUtil;->getStackTraceAsString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/crashlytics/android/Crashlytics;->setString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static varargs logException(Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 6
    .param p0, "e"    # Ljava/lang/Throwable;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "objects"    # [Ljava/lang/Object;

    .prologue
    .line 70
    invoke-static {p1, p2}, Lcom/edisonwang/android/slog/MessageFormatter;->format(Ljava/lang/String;[Ljava/lang/Object;)Lcom/edisonwang/android/slog/FormattingTuple;

    move-result-object v3

    invoke-virtual {v3}, Lcom/edisonwang/android/slog/FormattingTuple;->getMessage()Ljava/lang/String;

    move-result-object v2

    .line 71
    .local v2, "log":Ljava/lang/String;
    sget-boolean v3, Lco/vine/android/util/CrashUtil;->sLogsOn:Z

    if-eqz v3, :cond_1

    .line 72
    sget-object v4, Lco/vine/android/util/CrashUtil;->sLock:[I

    monitor-enter v4

    .line 73
    :try_start_0
    const-string v3, "logException triggered: "

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 74
    sget-object v3, Lco/vine/android/util/CrashUtil;->sEnv:Ljava/util/HashMap;

    invoke-virtual {v3}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 75
    .local v1, "key":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, ": "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v5, Lco/vine/android/util/CrashUtil;->sEnv:Ljava/util/HashMap;

    invoke-virtual {v5, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    goto :goto_0

    .line 77
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "key":Ljava/lang/String;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 78
    invoke-static {v2, p0}, Lcom/edisonwang/android/slog/SLog;->e2(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 83
    .end local v0    # "i$":Ljava/util/Iterator;
    :goto_1
    return-void

    .line 80
    :cond_1
    invoke-static {v2}, Lcom/crashlytics/android/Crashlytics;->log(Ljava/lang/String;)V

    .line 81
    invoke-static {p0}, Lcom/crashlytics/android/Crashlytics;->logException(Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public static logOrThrowInDebug(Ljava/lang/Exception;)V
    .locals 2
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    .line 35
    sget-boolean v0, Lco/vine/android/util/CrashUtil;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 36
    new-instance v0, Ljava/lang/RuntimeException;

    invoke-direct {v0, p0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    .line 38
    :cond_0
    invoke-static {p0}, Lcom/crashlytics/android/Crashlytics;->logException(Ljava/lang/Throwable;)V

    .line 39
    const-string v0, "LastException"

    invoke-static {p0}, Lco/vine/android/util/CrashUtil;->getStackTraceAsString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/crashlytics/android/Crashlytics;->setString(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    return-void
.end method

.method public static set(Ljava/lang/String;I)V
    .locals 1
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # I

    .prologue
    .line 104
    sget-boolean v0, Lco/vine/android/util/CrashUtil;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 105
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {p0, v0}, Lco/vine/android/util/CrashUtil;->setEnv(Ljava/lang/String;Ljava/lang/Object;)V

    .line 109
    :goto_0
    return-void

    .line 107
    :cond_0
    invoke-static {p0, p1}, Lcom/crashlytics/android/Crashlytics;->setInt(Ljava/lang/String;I)V

    goto :goto_0
.end method

.method public static set(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 93
    if-nez p1, :cond_0

    .line 94
    const-string p1, "null"

    .line 96
    :cond_0
    sget-boolean v0, Lco/vine/android/util/CrashUtil;->sLogsOn:Z

    if-eqz v0, :cond_1

    .line 97
    invoke-static {p0, p1}, Lco/vine/android/util/CrashUtil;->setEnv(Ljava/lang/String;Ljava/lang/Object;)V

    .line 101
    :goto_0
    return-void

    .line 99
    :cond_1
    invoke-static {p0, p1}, Lcom/crashlytics/android/Crashlytics;->setString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static setEnv(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 2
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 112
    sget-object v1, Lco/vine/android/util/CrashUtil;->sLock:[I

    monitor-enter v1

    .line 113
    :try_start_0
    sget-object v0, Lco/vine/android/util/CrashUtil;->sEnv:Ljava/util/HashMap;

    invoke-virtual {v0, p0, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 114
    monitor-exit v1

    .line 115
    return-void

    .line 114
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static setup(Z)V
    .locals 0
    .param p0, "logsOn"    # Z

    .prologue
    .line 31
    sput-boolean p0, Lco/vine/android/util/CrashUtil;->sLogsOn:Z

    .line 32
    return-void
.end method

.method public static start(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 118
    sget-boolean v0, Lco/vine/android/util/CrashUtil;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 119
    const-string v0, "Crashlytics will be started now if this is running with logs off."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 123
    :goto_0
    return-void

    .line 121
    :cond_0
    invoke-static {p0}, Lcom/crashlytics/android/Crashlytics;->start(Landroid/content/Context;)V

    goto :goto_0
.end method
