.class Lcom/amazon/device/crashmanager/AppFileArtifactSource;
.super Ljava/lang/Object;
.source "AppFileArtifactSource.java"

# interfaces
.implements Lcom/amazon/device/crashmanager/ArtifactSource;


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mCrashDetailsCollectable:Lcom/amazon/device/crashmanager/CrashDetailsCollectable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/amazon/device/crashmanager/AppFileArtifactSource;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/crashmanager/CrashDetailsCollectable;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "crashDetailsCollector"    # Lcom/amazon/device/crashmanager/CrashDetailsCollectable;

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    if-nez p1, :cond_0

    .line 39
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Context must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 41
    :cond_0
    if-nez p2, :cond_1

    .line 42
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Crash details collector must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 44
    :cond_1
    iput-object p1, p0, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->mContext:Landroid/content/Context;

    .line 45
    iput-object p2, p0, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->mCrashDetailsCollectable:Lcom/amazon/device/crashmanager/CrashDetailsCollectable;

    .line 46
    return-void
.end method

.method private addDetailToCrashReport(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "builder"    # Ljava/lang/StringBuilder;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 189
    invoke-virtual {p1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 190
    return-void
.end method


# virtual methods
.method deleteCrashReportFile()Z
    .locals 2

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "crashlog.v2.amzcl"

    invoke-virtual {v0, v1}, Landroid/content/Context;->deleteFile(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method generateCrashReport(Ljava/util/Map;)Ljava/lang/String;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 130
    .local p1, "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 133
    .local v0, "builder":Ljava/lang/StringBuilder;
    const-string/jumbo v5, "CrashTimeUTC"

    const-string/jumbo v4, "CrashTimeUTC"

    invoke-interface {p1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-direct {p0, v0, v5, v4}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->addDetailToCrashReport(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    const-string/jumbo v4, "CrashType"

    const-string/jumbo v5, "data_app_crash"

    invoke-direct {p0, v0, v4, v5}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->addDetailToCrashReport(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    const-string/jumbo v4, "ContentType"

    const-string/jumbo v5, "ThirdPartyJavaCrash"

    invoke-direct {p0, v0, v4, v5}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->addDetailToCrashReport(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    const-string/jumbo v5, "Process"

    const-string/jumbo v4, "packageName"

    invoke-interface {p1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-direct {p0, v0, v5, v4}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->addDetailToCrashReport(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    const-string/jumbo v5, "Version"

    const-string/jumbo v4, "packageVersionName"

    invoke-interface {p1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-direct {p0, v0, v5, v4}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->addDetailToCrashReport(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 138
    const-string/jumbo v5, "OsBuildNumber"

    const-string/jumbo v4, "androidBuildVersion"

    invoke-interface {p1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-direct {p0, v0, v5, v4}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->addDetailToCrashReport(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 139
    const-string/jumbo v4, "\n"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 140
    const-string/jumbo v4, "stackTrace"

    invoke-interface {p1, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 141
    const-string/jumbo v4, "=== Complete details ===\n\n"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 143
    new-instance v3, Ljava/util/ArrayList;

    invoke-interface {p1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 144
    .local v3, "keys":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-static {v3}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 146
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 147
    .local v2, "key":Ljava/lang/String;
    invoke-interface {p1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-direct {p0, v0, v2, v4}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->addDetailToCrashReport(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 150
    .end local v2    # "key":Ljava/lang/String;
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method getCrashReportFile()Ljava/io/File;
    .locals 2

    .prologue
    .line 112
    iget-object v0, p0, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->mContext:Landroid/content/Context;

    const-string/jumbo v1, "crashlog.v2.amzcl"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method public getNextArtifact(Lcom/amazon/client/metrics/MetricEvent;)Lcom/amazon/device/crashmanager/Artifact;
    .locals 8
    .param p1, "uploadMetricEvent"    # Lcom/amazon/client/metrics/MetricEvent;

    .prologue
    const/4 v3, 0x0

    .line 58
    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->getCrashReportFile()Ljava/io/File;

    move-result-object v1

    .line 59
    .local v1, "crashReportFile":Ljava/io/File;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_1

    :cond_0
    move-object v0, v3

    .line 72
    :goto_0
    return-object v0

    .line 64
    :cond_1
    :try_start_0
    new-instance v0, Lcom/amazon/device/crashmanager/Artifact;

    const-string/jumbo v4, "data_app_crash"

    new-instance v5, Ljava/io/FileInputStream;

    invoke-direct {v5, v1}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-virtual {v1}, Ljava/io/File;->lastModified()J

    move-result-wide v6

    invoke-direct {v0, v4, v5, v6, v7}, Lcom/amazon/device/crashmanager/Artifact;-><init>(Ljava/lang/String;Ljava/io/InputStream;J)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 69
    .local v0, "crashArtifact":Lcom/amazon/device/crashmanager/Artifact;
    goto :goto_0

    .line 70
    .end local v0    # "crashArtifact":Lcom/amazon/device/crashmanager/Artifact;
    :catch_0
    move-exception v2

    .line 71
    .local v2, "fnfe":Ljava/io/FileNotFoundException;
    sget-object v4, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Could not find crash file."

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move-object v0, v3

    .line 72
    goto :goto_0
.end method

.method public saveCrash(Ljava/lang/Throwable;)V
    .locals 5
    .param p1, "ex"    # Ljava/lang/Throwable;

    .prologue
    .line 97
    sget-object v3, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "========================="

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 98
    sget-object v3, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "CRASH HAS OCCURRED"

    invoke-static {v3, v4, p1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 99
    sget-object v3, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Collecting details and saving to disk"

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 100
    sget-object v3, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "========================="

    invoke-static {v3, v4}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 103
    :try_start_0
    iget-object v3, p0, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->mCrashDetailsCollectable:Lcom/amazon/device/crashmanager/CrashDetailsCollectable;

    invoke-interface {v3, p1}, Lcom/amazon/device/crashmanager/CrashDetailsCollectable;->collect(Ljava/lang/Throwable;)Ljava/util/Map;

    move-result-object v1

    .line 104
    .local v1, "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0, v1}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->generateCrashReport(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    .line 105
    .local v0, "crashReport":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->saveCrashReportToFile(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 109
    .end local v0    # "crashReport":Ljava/lang/String;
    .end local v1    # "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return-void

    .line 106
    :catch_0
    move-exception v2

    .line 107
    .local v2, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Could not handle uncaught exception"

    invoke-static {v3, v4, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method saveCrashReportToFile(Ljava/lang/String;)V
    .locals 8
    .param p1, "crashReport"    # Ljava/lang/String;

    .prologue
    .line 158
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_1

    .line 186
    :cond_0
    :goto_0
    return-void

    .line 169
    :cond_1
    :try_start_0
    sget-object v2, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Saving crash report to file: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->mContext:Landroid/content/Context;

    const-string/jumbo v7, "crashlog.v2.amzcl"

    invoke-virtual {v6, v7}, Landroid/content/Context;->getFileStreamPath(Ljava/lang/String;)Ljava/io/File;

    move-result-object v6

    invoke-virtual {v6}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 172
    const-class v3, Lcom/amazon/device/crashmanager/AppFileArtifactSource;

    monitor-enter v3
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    .line 173
    :try_start_1
    iget-object v2, p0, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->mContext:Landroid/content/Context;

    const-string/jumbo v4, "crashlog.v2.amzcl"

    const/4 v5, 0x0

    invoke-virtual {v2, v4, v5}, Landroid/content/Context;->openFileOutput(Ljava/lang/String;I)Ljava/io/FileOutputStream;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    .line 176
    .local v0, "crashLog":Ljava/io/FileOutputStream;
    :try_start_2
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/io/FileOutputStream;->write([B)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 178
    :try_start_3
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V

    .line 180
    monitor-exit v3

    goto :goto_0

    .end local v0    # "crashLog":Ljava/io/FileOutputStream;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v2
    :try_end_4
    .catch Ljava/io/FileNotFoundException; {:try_start_4 .. :try_end_4} :catch_0
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_1

    .line 181
    :catch_0
    move-exception v1

    .line 182
    .local v1, "e":Ljava/io/FileNotFoundException;
    sget-object v2, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Could not save crash report to file"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 178
    .end local v1    # "e":Ljava/io/FileNotFoundException;
    .restart local v0    # "crashLog":Ljava/io/FileOutputStream;
    :catchall_1
    move-exception v2

    :try_start_5
    invoke-virtual {v0}, Ljava/io/FileOutputStream;->close()V

    throw v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 183
    .end local v0    # "crashLog":Ljava/io/FileOutputStream;
    :catch_1
    move-exception v1

    .line 184
    .local v1, "e":Ljava/io/IOException;
    sget-object v2, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v3, "Could not save crash report to file"

    invoke-static {v2, v3, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public saveCurrentIndex()V
    .locals 3

    .prologue
    .line 80
    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->getCrashReportFile()Ljava/io/File;

    move-result-object v0

    .line 81
    .local v0, "crashReportFile":Ljava/io/File;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-nez v1, :cond_1

    .line 89
    :cond_0
    :goto_0
    return-void

    .line 86
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->deleteCrashReportFile()Z

    move-result v1

    if-nez v1, :cond_0

    .line 87
    sget-object v1, Lcom/amazon/device/crashmanager/AppFileArtifactSource;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Failed to delete crash report."

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
