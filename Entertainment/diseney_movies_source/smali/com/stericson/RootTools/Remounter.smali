.class Lcom/stericson/RootTools/Remounter;
.super Ljava/lang/Object;
.source "Remounter.java"


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private findMountPointRecursive(Ljava/lang/String;)Lcom/stericson/RootTools/Mount;
    .locals 7
    .param p1, "file"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 139
    :try_start_0
    invoke-static {}, Lcom/stericson/RootTools/RootTools;->getMounts()Ljava/util/ArrayList;

    move-result-object v2

    .line 140
    .local v2, "mounts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/stericson/RootTools/Mount;>;"
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .local v3, "path":Ljava/io/File;
    :cond_0
    if-nez v3, :cond_1

    move-object v1, v4

    .line 155
    .end local v2    # "mounts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/stericson/RootTools/Mount;>;"
    .end local v3    # "path":Ljava/io/File;
    :goto_0
    return-object v1

    .line 141
    .restart local v2    # "mounts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/stericson/RootTools/Mount;>;"
    .restart local v3    # "path":Ljava/io/File;
    :cond_1
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/stericson/RootTools/Mount;

    .line 142
    .local v1, "mount":Lcom/stericson/RootTools/Mount;
    invoke-virtual {v1}, Lcom/stericson/RootTools/Mount;->getMountPoint()Ljava/io/File;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/io/File;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result v6

    if-eqz v6, :cond_2

    goto :goto_0

    .line 148
    .end local v1    # "mount":Lcom/stericson/RootTools/Mount;
    .end local v2    # "mounts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/stericson/RootTools/Mount;>;"
    .end local v3    # "path":Ljava/io/File;
    :catch_0
    move-exception v0

    .line 149
    .local v0, "e":Ljava/io/IOException;
    new-instance v4, Ljava/lang/RuntimeException;

    invoke-direct {v4, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 150
    .end local v0    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v0

    .line 151
    .local v0, "e":Ljava/lang/Exception;
    sget-boolean v5, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v5, :cond_3

    .line 152
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    :cond_3
    move-object v1, v4

    .line 155
    goto :goto_0
.end method


# virtual methods
.method protected remount(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 13
    .param p1, "file"    # Ljava/lang/String;
    .param p2, "mountType"    # Ljava/lang/String;

    .prologue
    .line 56
    const-string v5, ""

    .line 58
    .local v5, "util":Ljava/lang/String;
    const-string v6, "busybox"

    invoke-static {v6}, Lcom/stericson/RootTools/RootTools;->checkUtil(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 60
    sget-object v5, Lcom/stericson/RootTools/RootTools;->utilPath:Ljava/lang/String;

    .line 68
    :cond_0
    :goto_0
    const-string v6, "/"

    invoke-virtual {p1, v6}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 69
    const/4 v6, 0x0

    const-string v7, "/"

    invoke-virtual {p1, v7}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v7

    invoke-virtual {p1, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object p1

    .line 72
    :cond_1
    const/4 v1, 0x0

    .line 73
    .local v1, "foundMount":Z
    :cond_2
    :goto_1
    if-eqz v1, :cond_5

    .line 98
    invoke-direct {p0, p1}, Lcom/stericson/RootTools/Remounter;->findMountPointRecursive(Ljava/lang/String;)Lcom/stericson/RootTools/Mount;

    move-result-object v4

    .line 100
    .local v4, "mountPoint":Lcom/stericson/RootTools/Mount;
    sget-object v6, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Remounting "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getMountPoint()Ljava/io/File;

    move-result-object v8

    invoke-virtual {v8}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " as "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 101
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getFlags()Ljava/util/Set;

    move-result-object v6

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    .line 103
    .local v2, "isMountMode":Z
    if-nez v2, :cond_3

    .line 106
    :try_start_0
    new-instance v6, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v6}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    .line 108
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " mount -o remount,%s %s %s"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    .line 109
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    .line 110
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getDevice()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x2

    .line 111
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getMountPoint()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    .line 107
    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x1

    .line 113
    const-string v9, "mount -o remount,%s %s %s"

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    .line 114
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    .line 115
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getDevice()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x2

    .line 116
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getMountPoint()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    .line 112
    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x2

    .line 118
    const-string v9, "/system/bin/toolbox mount -o remount,%s %s %s"

    const/4 v10, 0x3

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    .line 119
    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    .line 120
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getDevice()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x2

    .line 121
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getMountPoint()Ljava/io/File;

    move-result-object v12

    invoke-virtual {v12}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    .line 117
    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    .line 122
    const/4 v8, -0x1

    .line 106
    invoke-virtual {v6, v7, v8}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_2

    .line 124
    :goto_2
    invoke-direct {p0, p1}, Lcom/stericson/RootTools/Remounter;->findMountPointRecursive(Ljava/lang/String;)Lcom/stericson/RootTools/Mount;

    move-result-object v4

    .line 127
    :cond_3
    sget-object v6, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getFlags()Ljava/util/Set;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " AND "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 128
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getFlags()Ljava/util/Set;

    move-result-object v6

    invoke-virtual {p2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v6, v7}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 129
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getFlags()Ljava/util/Set;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 130
    const/4 v6, 0x1

    .line 133
    .end local v2    # "isMountMode":Z
    .end local v4    # "mountPoint":Lcom/stericson/RootTools/Mount;
    :goto_3
    return v6

    .line 62
    .end local v1    # "foundMount":Z
    :cond_4
    const-string v6, "toolbox"

    invoke-static {v6}, Lcom/stericson/RootTools/RootTools;->checkUtil(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 64
    sget-object v5, Lcom/stericson/RootTools/RootTools;->utilPath:Ljava/lang/String;

    goto/16 :goto_0

    .line 75
    .restart local v1    # "foundMount":Z
    :cond_5
    :try_start_1
    invoke-static {}, Lcom/stericson/RootTools/RootTools;->getMounts()Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_6
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result v7

    if-nez v7, :cond_7

    .line 89
    :goto_4
    if-nez v1, :cond_2

    .line 91
    :try_start_2
    new-instance v6, Ljava/io/File;

    invoke-direct {v6, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/io/File;->getParent()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object p1

    goto/16 :goto_1

    .line 75
    :cond_7
    :try_start_3
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/stericson/RootTools/Mount;

    .line 76
    .local v3, "mount":Lcom/stericson/RootTools/Mount;
    invoke-virtual {v3}, Lcom/stericson/RootTools/Mount;->getMountPoint()Ljava/io/File;

    move-result-object v7

    invoke-virtual {v7}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 78
    invoke-virtual {v3}, Lcom/stericson/RootTools/Mount;->getMountPoint()Ljava/io/File;

    move-result-object v7

    invoke-virtual {v7}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p1, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    move-result v7

    if-eqz v7, :cond_6

    .line 79
    const/4 v1, 0x1

    .line 80
    goto :goto_4

    .line 83
    .end local v3    # "mount":Lcom/stericson/RootTools/Mount;
    :catch_0
    move-exception v0

    .line 84
    .local v0, "e":Ljava/lang/Exception;
    sget-boolean v6, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v6, :cond_8

    .line 85
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 87
    :cond_8
    const/4 v6, 0x0

    goto :goto_3

    .line 92
    .end local v0    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v0

    .line 93
    .restart local v0    # "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 94
    const/4 v6, 0x0

    goto :goto_3

    .line 132
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v2    # "isMountMode":Z
    .restart local v4    # "mountPoint":Lcom/stericson/RootTools/Mount;
    :cond_9
    invoke-virtual {v4}, Lcom/stericson/RootTools/Mount;->getFlags()Ljava/util/Set;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 133
    const/4 v6, 0x0

    goto :goto_3

    .line 123
    :catch_2
    move-exception v6

    goto/16 :goto_2
.end method
