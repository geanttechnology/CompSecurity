.class public Lcom/stericson/RootTools/RootTools;
.super Ljava/lang/Object;
.source "RootTools.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/stericson/RootTools/RootTools$Result;
    }
.end annotation


# static fields
.field public static debugMode:Z

.field public static lastExitCode:I

.field public static lastFoundBinaryPaths:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public static shellDelay:I

.field public static utilPath:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 60
    sput-boolean v1, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/stericson/RootTools/RootTools;->lastFoundBinaryPaths:Ljava/util/List;

    .line 65
    sput v1, Lcom/stericson/RootTools/RootTools;->shellDelay:I

    .line 41
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 41
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkUtil(Ljava/lang/String;)Z
    .locals 6
    .param p0, "util"    # Ljava/lang/String;

    .prologue
    .line 146
    invoke-static {p0}, Lcom/stericson/RootTools/RootTools;->findBinary(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 148
    sget-object v3, Lcom/stericson/RootTools/RootTools;->lastFoundBinaryPaths:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_2

    .line 165
    :cond_1
    const/4 v3, 0x0

    :goto_0
    return v3

    .line 148
    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 150
    .local v0, "path":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/stericson/RootTools/RootTools;->getFilePermissions(Ljava/lang/String;)Lcom/stericson/RootTools/Permissions;

    move-result-object v2

    .line 152
    .local v2, "permissions":Lcom/stericson/RootTools/Permissions;
    if-eqz v2, :cond_0

    .line 154
    invoke-virtual {v2}, Lcom/stericson/RootTools/Permissions;->getPermissions()I

    move-result v1

    .line 156
    .local v1, "permission":I
    const/16 v4, 0x2f3

    if-eq v1, v4, :cond_3

    const/16 v4, 0x309

    if-eq v1, v4, :cond_3

    const/16 v4, 0x307

    if-ne v1, v4, :cond_0

    .line 158
    :cond_3
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, "/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    sput-object v3, Lcom/stericson/RootTools/RootTools;->utilPath:Ljava/lang/String;

    .line 159
    const/4 v3, 0x1

    goto :goto_0
.end method

.method public static checkUtils([Ljava/lang/String;)Z
    .locals 5
    .param p0, "utils"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 113
    array-length v3, p0

    move v2, v1

    :goto_0
    if-lt v2, v3, :cond_1

    .line 132
    const/4 v1, 0x1

    :cond_0
    return v1

    .line 113
    :cond_1
    aget-object v0, p0, v2

    .line 115
    .local v0, "util":Ljava/lang/String;
    invoke-static {v0}, Lcom/stericson/RootTools/RootTools;->checkUtil(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 117
    const-string v4, "busybox"

    invoke-static {v4}, Lcom/stericson/RootTools/RootTools;->checkUtil(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 119
    sget-object v4, Lcom/stericson/RootTools/RootTools;->utilPath:Ljava/lang/String;

    invoke-static {v0, v4}, Lcom/stericson/RootTools/RootTools;->fixUtil(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    :cond_2
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 121
    :cond_3
    const-string v4, "toolbox"

    invoke-static {v4}, Lcom/stericson/RootTools/RootTools;->checkUtil(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 123
    sget-object v4, Lcom/stericson/RootTools/RootTools;->utilPath:Ljava/lang/String;

    invoke-static {v0, v4}, Lcom/stericson/RootTools/RootTools;->fixUtil(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public static findBinary(Ljava/lang/String;)Z
    .locals 11
    .param p0, "binaryName"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x0

    .line 375
    const/4 v3, 0x0

    .line 376
    .local v3, "found":Z
    sget-object v8, Lcom/stericson/RootTools/RootTools;->lastFoundBinaryPaths:Ljava/util/List;

    invoke-interface {v8}, Ljava/util/List;->clear()V

    .line 378
    sget-object v8, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Checking for "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 381
    :try_start_0
    invoke-static {}, Lcom/stericson/RootTools/RootTools;->getPath()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z
    :try_end_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result v9

    if-nez v9, :cond_1

    .line 403
    :goto_1
    if-nez v3, :cond_0

    .line 405
    sget-object v8, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v9, "Trying second method"

    invoke-static {v8, v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 406
    sget-object v8, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "Checking for "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 407
    const/16 v8, 0x8

    new-array v5, v8, [Ljava/lang/String;

    const-string v8, "/sbin/"

    aput-object v8, v5, v7

    const/4 v8, 0x1

    const-string v9, "/system/bin/"

    aput-object v9, v5, v8

    const/4 v8, 0x2

    const-string v9, "/system/xbin/"

    aput-object v9, v5, v8

    const/4 v8, 0x3

    .line 408
    const-string v9, "/data/local/xbin/"

    aput-object v9, v5, v8

    const/4 v8, 0x4

    const-string v9, "/data/local/bin/"

    aput-object v9, v5, v8

    const/4 v8, 0x5

    const-string v9, "/system/sd/xbin/"

    aput-object v9, v5, v8

    const/4 v8, 0x6

    const-string v9, "/system/bin/failsafe/"

    aput-object v9, v5, v8

    const/4 v8, 0x7

    const-string v9, "/data/local/"

    aput-object v9, v5, v8

    .line 409
    .local v5, "places":[Ljava/lang/String;
    array-length v8, v5

    :goto_2
    if-lt v7, v8, :cond_3

    .line 423
    .end local v5    # "places":[Ljava/lang/String;
    :cond_0
    return v3

    .line 381
    :cond_1
    :try_start_1
    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 382
    .local v4, "paths":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, "/"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v2, v9}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 383
    .local v2, "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v9

    if-eqz v9, :cond_2

    .line 384
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " was found here: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 385
    sget-object v9, Lcom/stericson/RootTools/RootTools;->lastFoundBinaryPaths:Ljava/util/List;

    invoke-interface {v9, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 386
    const/4 v3, 0x1

    goto/16 :goto_0

    .line 390
    :cond_2
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " was NOT found here: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 394
    .end local v2    # "file":Ljava/io/File;
    .end local v4    # "paths":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 396
    .local v1, "ex":Ljava/util/concurrent/TimeoutException;
    sget-object v8, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v9, "TimeoutException!!!"

    invoke-static {v8, v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 398
    .end local v1    # "ex":Ljava/util/concurrent/TimeoutException;
    :catch_1
    move-exception v0

    .line 400
    .local v0, "e":Ljava/lang/Exception;
    sget-object v8, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " was not found, more information MAY be available with Debugging on."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 409
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v5    # "places":[Ljava/lang/String;
    :cond_3
    aget-object v6, v5, v7

    .line 410
    .local v6, "where":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-direct {v2, v9}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 411
    .restart local v2    # "file":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v9

    if-eqz v9, :cond_4

    .line 412
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " was found here: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 413
    sget-object v9, Lcom/stericson/RootTools/RootTools;->lastFoundBinaryPaths:Ljava/util/List;

    invoke-interface {v9, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 414
    const/4 v3, 0x1

    .line 409
    :goto_3
    add-int/lit8 v7, v7, 0x1

    goto/16 :goto_2

    .line 418
    :cond_4
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " was NOT found here: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    goto :goto_3
.end method

.method public static fixUtil(Ljava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p0, "util"    # Ljava/lang/String;
    .param p1, "utilPath"    # Ljava/lang/String;

    .prologue
    .line 182
    :try_start_0
    const-string v1, "/system"

    const-string v2, "rw"

    invoke-static {v1, v2}, Lcom/stericson/RootTools/RootTools;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    .line 184
    invoke-static {p0}, Lcom/stericson/RootTools/RootTools;->findBinary(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 186
    sget-object v1, Lcom/stericson/RootTools/RootTools;->lastFoundBinaryPaths:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_1

    .line 189
    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " ln -s "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " /system/bin/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    .line 190
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v4, " chmod 0755 /system/bin/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/16 v2, 0xa

    sget v3, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    .line 189
    invoke-static {v1, v2, v3}, Lcom/stericson/RootTools/RootTools;->sendShell([Ljava/lang/String;II)Ljava/util/List;

    .line 193
    :cond_0
    const-string v1, "/system"

    const-string v2, "ro"

    invoke-static {v1, v2}, Lcom/stericson/RootTools/RootTools;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    .line 196
    :goto_1
    return-void

    .line 186
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 187
    .local v0, "path":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, " rm "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-static {v2, v3}, Lcom/stericson/RootTools/RootTools;->sendShell(Ljava/lang/String;I)Ljava/util/List;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 195
    .end local v0    # "path":Ljava/lang/String;
    :catch_0
    move-exception v1

    goto :goto_1
.end method

.method public static getBusyBoxApplets()Ljava/util/List;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 532
    const-string v1, "busybox --list"

    sget v2, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-static {v1, v2}, Lcom/stericson/RootTools/RootTools;->sendShell(Ljava/lang/String;I)Ljava/util/List;

    move-result-object v0

    .line 533
    .local v0, "commands":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    .line 534
    return-object v0

    .line 536
    :cond_0
    new-instance v1, Ljava/lang/Exception;

    invoke-direct {v1}, Ljava/lang/Exception;-><init>()V

    throw v1
.end method

.method public static getBusyBoxVersion()Ljava/lang/String;
    .locals 6

    .prologue
    .line 510
    sget-object v2, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v3, "Getting BusyBox Version"

    invoke-static {v2, v3}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 511
    const/4 v2, 0x0

    sput-object v2, Lcom/stericson/RootTools/InternalVariables;->busyboxVersion:Ljava/lang/String;

    .line 513
    :try_start_0
    new-instance v2, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v2}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "busybox"

    aput-object v5, v3, v4

    sget v4, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-virtual {v2, v3, v4}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 520
    .local v1, "ex":Ljava/util/concurrent/TimeoutException;
    :goto_0
    sget-object v2, Lcom/stericson/RootTools/InternalVariables;->busyboxVersion:Ljava/lang/String;

    .end local v1    # "ex":Ljava/util/concurrent/TimeoutException;
    :goto_1
    return-object v2

    .line 514
    :catch_0
    move-exception v1

    .line 515
    .restart local v1    # "ex":Ljava/util/concurrent/TimeoutException;
    sget-object v2, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v3, "TimeoutException!!!"

    invoke-static {v2, v3}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 516
    .end local v1    # "ex":Ljava/util/concurrent/TimeoutException;
    :catch_1
    move-exception v0

    .line 517
    .local v0, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v3, "BusyBox was not found, more information MAY be available with Debugging on."

    invoke-static {v2, v3}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 518
    const-string v2, ""

    goto :goto_1
.end method

.method public static getFilePermissions(Ljava/lang/String;)Lcom/stericson/RootTools/Permissions;
    .locals 1
    .param p0, "file"    # Ljava/lang/String;

    .prologue
    .line 503
    invoke-static {p0}, Lcom/stericson/RootTools/RootTools;->getFilePermissionsSymlinks(Ljava/lang/String;)Lcom/stericson/RootTools/Permissions;

    move-result-object v0

    return-object v0
.end method

.method public static getFilePermissionsSymlinks(Ljava/lang/String;)Lcom/stericson/RootTools/Permissions;
    .locals 13
    .param p0, "file"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x0

    .line 437
    sget-object v9, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Checking permissions for "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 438
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p0}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 439
    .local v1, "f":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v9

    if-eqz v9, :cond_1

    .line 441
    const-string v7, ""

    .line 443
    .local v7, "symlink_final":Ljava/lang/String;
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-static {p0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, " was found."

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 446
    const/4 v9, 0x4

    :try_start_0
    new-array v9, v9, [Ljava/lang/String;

    const/4 v10, 0x0

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "ls -l "

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "busybox ls -l "

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x2

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "/system/bin/failsafe/toolbox ls -l "

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x3

    new-instance v11, Ljava/lang/StringBuilder;

    const-string v12, "toolbox ls -l "

    invoke-direct {v11, v12}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x0

    sget v11, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-static {v9, v10, v11}, Lcom/stericson/RootTools/RootTools;->sendShell([Ljava/lang/String;II)Ljava/util/List;

    move-result-object v5

    .line 447
    .local v5, "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-nez v10, :cond_2

    .end local v5    # "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v7    # "symlink_final":Ljava/lang/String;
    :cond_1
    move-object v4, v8

    .line 489
    :goto_1
    return-object v4

    .line 447
    .restart local v5    # "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v7    # "symlink_final":Ljava/lang/String;
    :cond_2
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 449
    .local v2, "line":Ljava/lang/String;
    const-string v10, " "

    invoke-virtual {v2, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 450
    .local v3, "lineArray":[Ljava/lang/String;
    const/4 v10, 0x0

    aget-object v10, v3, v10

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v10

    const/16 v11, 0xa

    if-ne v10, v11, :cond_1

    .line 455
    new-instance v10, Ljava/lang/StringBuilder;

    const-string v11, "Line "

    invoke-direct {v10, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v10, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 459
    :try_start_1
    const-string v10, " "

    invoke-virtual {v2, v10}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 460
    .local v6, "symlink":[Ljava/lang/String;
    array-length v10, v6

    add-int/lit8 v10, v10, -0x2

    aget-object v10, v6, v10

    const-string v11, "->"

    invoke-virtual {v10, v11}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v10

    if-eqz v10, :cond_3

    .line 462
    const-string v10, "Symlink found."

    invoke-static {v10}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 463
    array-length v10, v6

    add-int/lit8 v10, v10, -0x1

    aget-object v7, v6, v10
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 470
    .end local v6    # "symlink":[Ljava/lang/String;
    :cond_3
    :goto_2
    :try_start_2
    new-instance v10, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v10}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    invoke-virtual {v10, v2}, Lcom/stericson/RootTools/InternalMethods;->getPermissions(Ljava/lang/String;)Lcom/stericson/RootTools/Permissions;

    move-result-object v4

    .line 471
    .local v4, "permissions":Lcom/stericson/RootTools/Permissions;
    if-eqz v4, :cond_0

    .line 473
    invoke-virtual {v4, v7}, Lcom/stericson/RootTools/Permissions;->setSymlink(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1

    .line 477
    .end local v4    # "permissions":Lcom/stericson/RootTools/Permissions;
    :catch_0
    move-exception v0

    .line 478
    .local v0, "e":Ljava/lang/Exception;
    :try_start_3
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-static {v10}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 482
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v2    # "line":Ljava/lang/String;
    .end local v3    # "lineArray":[Ljava/lang/String;
    .end local v5    # "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_1
    move-exception v0

    .line 484
    .restart local v0    # "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    move-object v4, v8

    .line 485
    goto :goto_1

    .line 466
    .end local v0    # "e":Ljava/lang/Exception;
    .restart local v2    # "line":Ljava/lang/String;
    .restart local v3    # "lineArray":[Ljava/lang/String;
    .restart local v5    # "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_2
    move-exception v10

    goto :goto_2
.end method

.method public static getMounts()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/stericson/RootTools/Mount;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 230
    new-instance v0, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v0}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    invoke-virtual {v0}, Lcom/stericson/RootTools/InternalMethods;->getMounts()Ljava/util/ArrayList;

    move-result-object v0

    sput-object v0, Lcom/stericson/RootTools/InternalVariables;->mounts:Ljava/util/ArrayList;

    .line 231
    sget-object v0, Lcom/stericson/RootTools/InternalVariables;->mounts:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 232
    sget-object v0, Lcom/stericson/RootTools/InternalVariables;->mounts:Ljava/util/ArrayList;

    return-object v0

    .line 234
    :cond_0
    new-instance v0, Ljava/lang/Exception;

    invoke-direct {v0}, Ljava/lang/Exception;-><init>()V

    throw v0
.end method

.method public static getPath()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 205
    sget-object v0, Lcom/stericson/RootTools/InternalVariables;->path:Ljava/util/Set;

    if-eqz v0, :cond_0

    .line 206
    sget-object v0, Lcom/stericson/RootTools/InternalVariables;->path:Ljava/util/Set;

    .line 209
    :goto_0
    return-object v0

    .line 208
    :cond_0
    new-instance v0, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v0}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    invoke-virtual {v0}, Lcom/stericson/RootTools/InternalMethods;->returnPath()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 209
    sget-object v0, Lcom/stericson/RootTools/InternalVariables;->path:Ljava/util/Set;

    goto :goto_0

    .line 211
    :cond_1
    new-instance v0, Ljava/lang/Exception;

    invoke-direct {v0}, Ljava/lang/Exception;-><init>()V

    throw v0
.end method

.method public static getSpace(Ljava/lang/String;)J
    .locals 10
    .param p0, "path"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 916
    sput-object p0, Lcom/stericson/RootTools/InternalVariables;->getSpaceFor:Ljava/lang/String;

    .line 917
    const/4 v2, 0x0

    .line 918
    .local v2, "found":Z
    const/4 v6, 0x1

    new-array v0, v6, [Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "df "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v0, v5

    .line 920
    .local v0, "commands":[Ljava/lang/String;
    :try_start_0
    new-instance v6, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v6}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    const/4 v7, -0x1

    invoke-virtual {v6, v0, v7}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_0

    .line 923
    :goto_0
    const-string v6, "Looking for Space"

    invoke-static {v6}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 925
    sget-object v6, Lcom/stericson/RootTools/InternalVariables;->space:[Ljava/lang/String;

    if-eqz v6, :cond_1

    .line 926
    const-string v6, "First Method"

    invoke-static {v6}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 928
    sget-object v7, Lcom/stericson/RootTools/InternalVariables;->space:[Ljava/lang/String;

    array-length v8, v7

    move v6, v5

    :goto_1
    if-lt v6, v8, :cond_2

    .line 940
    const/4 v1, 0x0

    .line 941
    .local v1, "count":I
    const/4 v4, 0x3

    .line 943
    .local v4, "targetCount":I
    const-string v6, "Second Method"

    invoke-static {v6}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 945
    sget-object v6, Lcom/stericson/RootTools/InternalVariables;->space:[Ljava/lang/String;

    aget-object v6, v6, v5

    invoke-virtual {v6, p0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 946
    const/4 v4, 0x2

    .line 949
    :cond_0
    sget-object v6, Lcom/stericson/RootTools/InternalVariables;->space:[Ljava/lang/String;

    array-length v7, v6

    :goto_2
    if-lt v5, v7, :cond_5

    .line 961
    .end local v1    # "count":I
    .end local v4    # "targetCount":I
    :cond_1
    const-string v5, "Returning -1, space could not be determined."

    invoke-static {v5}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 962
    const-wide/16 v5, -0x1

    :goto_3
    return-wide v5

    .line 928
    :cond_2
    aget-object v3, v7, v6

    .line 930
    .local v3, "spaceSearch":Ljava/lang/String;
    invoke-static {v3}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 932
    if-eqz v2, :cond_3

    .line 933
    new-instance v5, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v5}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    invoke-virtual {v5, v3}, Lcom/stericson/RootTools/InternalMethods;->getConvertedSpace(Ljava/lang/String;)J

    move-result-wide v5

    goto :goto_3

    .line 934
    :cond_3
    const-string v9, "used,"

    invoke-virtual {v3, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_4

    .line 935
    const/4 v2, 0x1

    .line 928
    :cond_4
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 949
    .end local v3    # "spaceSearch":Ljava/lang/String;
    .restart local v1    # "count":I
    .restart local v4    # "targetCount":I
    :cond_5
    aget-object v3, v6, v5

    .line 951
    .restart local v3    # "spaceSearch":Ljava/lang/String;
    invoke-static {v3}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 952
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_7

    .line 953
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v9, "Valid"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 954
    if-ne v1, v4, :cond_6

    .line 955
    new-instance v5, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v5}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    invoke-virtual {v5, v3}, Lcom/stericson/RootTools/InternalMethods;->getConvertedSpace(Ljava/lang/String;)J

    move-result-wide v5

    goto :goto_3

    .line 957
    :cond_6
    add-int/lit8 v1, v1, 0x1

    .line 949
    :cond_7
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 921
    .end local v1    # "count":I
    .end local v3    # "spaceSearch":Ljava/lang/String;
    .end local v4    # "targetCount":I
    :catch_0
    move-exception v6

    goto/16 :goto_0
.end method

.method public static getSymlink(Ljava/io/File;)Ljava/lang/String;
    .locals 4
    .param p0, "file"    # Ljava/io/File;

    .prologue
    .line 271
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Looking for Symlink for "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0}, Ljava/io/File;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 272
    invoke-virtual {p0}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 274
    const-string v2, "File exists"

    invoke-static {v2}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 278
    :try_start_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "ls -l "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sget v3, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-static {v2, v3}, Lcom/stericson/RootTools/RootTools;->sendShell(Ljava/lang/String;I)Ljava/util/List;

    move-result-object v0

    .line 279
    .local v0, "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 280
    .local v1, "symlink":[Ljava/lang/String;
    array-length v2, v1

    add-int/lit8 v2, v2, -0x2

    aget-object v2, v1, v2

    const-string v3, "->"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 282
    const-string v2, "Symlink found."

    invoke-static {v2}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 283
    array-length v2, v1

    add-int/lit8 v2, v2, -0x1

    aget-object v2, v1, v2
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 290
    .end local v0    # "results":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v1    # "symlink":[Ljava/lang/String;
    :goto_0
    return-object v2

    .line 286
    :catch_0
    move-exception v2

    .line 289
    :cond_0
    const-string v2, "Symlink not found"

    invoke-static {v2}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 290
    const-string v2, ""

    goto :goto_0
.end method

.method public static getSymlinks(Ljava/lang/String;)Ljava/util/ArrayList;
    .locals 5
    .param p0, "path"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/stericson/RootTools/Symlink;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 252
    new-instance v0, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v0}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "find "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " -type l -exec ls -l {} \\; > /data/local/symlinks.txt;"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V

    .line 253
    new-instance v0, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v0}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    invoke-virtual {v0}, Lcom/stericson/RootTools/InternalMethods;->getSymLinks()Ljava/util/ArrayList;

    move-result-object v0

    sput-object v0, Lcom/stericson/RootTools/InternalVariables;->symlinks:Ljava/util/ArrayList;

    .line 254
    sget-object v0, Lcom/stericson/RootTools/InternalVariables;->symlinks:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 255
    sget-object v0, Lcom/stericson/RootTools/InternalVariables;->symlinks:Ljava/util/ArrayList;

    return-object v0

    .line 257
    :cond_0
    new-instance v0, Ljava/lang/Exception;

    invoke-direct {v0}, Ljava/lang/Exception;-><init>()V

    throw v0
.end method

.method public static getWorkingToolbox()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    const-string v0, "busybox"

    invoke-static {v0}, Lcom/stericson/RootTools/RootTools;->checkUtil(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 86
    const-string v0, "busybox"

    .line 94
    :goto_0
    return-object v0

    .line 88
    :cond_0
    const-string v0, "toolbox"

    invoke-static {v0}, Lcom/stericson/RootTools/RootTools;->checkUtil(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 90
    const-string v0, "toolbox"

    goto :goto_0

    .line 94
    :cond_1
    const-string v0, ""

    goto :goto_0
.end method

.method public static hasEnoughSpaceOnSdCard(J)Z
    .locals 10
    .param p0, "updateSize"    # J

    .prologue
    const/4 v7, 0x0

    .line 618
    sget-object v8, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v9, "Checking SDcard size and that it is mounted as RW"

    invoke-static {v8, v9}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 619
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v6

    .line 620
    .local v6, "status":Ljava/lang/String;
    const-string v8, "mounted"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 627
    :cond_0
    :goto_0
    return v7

    .line 623
    :cond_1
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v4

    .line 624
    .local v4, "path":Ljava/io/File;
    new-instance v5, Landroid/os/StatFs;

    invoke-virtual {v4}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v5, v8}, Landroid/os/StatFs;-><init>(Ljava/lang/String;)V

    .line 625
    .local v5, "stat":Landroid/os/StatFs;
    invoke-virtual {v5}, Landroid/os/StatFs;->getBlockSize()I

    move-result v8

    int-to-long v2, v8

    .line 626
    .local v2, "blockSize":J
    invoke-virtual {v5}, Landroid/os/StatFs;->getAvailableBlocks()I

    move-result v8

    int-to-long v0, v8

    .line 627
    .local v0, "availableBlocks":J
    mul-long v8, v0, v2

    cmp-long v8, p0, v8

    if-gez v8, :cond_0

    const/4 v7, 0x1

    goto :goto_0
.end method

.method public static installBinary(Landroid/content/Context;ILjava/lang/String;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "sourceId"    # I
    .param p2, "binaryName"    # Ljava/lang/String;

    .prologue
    .line 694
    const-string v0, "700"

    invoke-static {p0, p1, p2, v0}, Lcom/stericson/RootTools/RootTools;->installBinary(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static installBinary(Landroid/content/Context;ILjava/lang/String;Ljava/lang/String;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "sourceId"    # I
    .param p2, "destName"    # Ljava/lang/String;
    .param p3, "mode"    # Ljava/lang/String;

    .prologue
    .line 670
    :try_start_0
    new-instance v1, Lcom/stericson/RootTools/Installer;

    invoke-direct {v1, p0}, Lcom/stericson/RootTools/Installer;-><init>(Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 678
    .local v1, "installer":Lcom/stericson/RootTools/Installer;
    invoke-virtual {v1, p1, p2, p3}, Lcom/stericson/RootTools/Installer;->installBinary(ILjava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .end local v1    # "installer":Lcom/stericson/RootTools/Installer;
    :goto_0
    return v2

    .line 671
    :catch_0
    move-exception v0

    .line 672
    .local v0, "ex":Ljava/io/IOException;
    sget-boolean v2, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v2, :cond_0

    .line 673
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 675
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static isAccessGiven()Z
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 572
    const/16 v2, 0x1f4

    sput v2, Lcom/stericson/RootTools/RootTools;->shellDelay:I

    .line 573
    sget-object v2, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v3, "Checking for Root access"

    invoke-static {v2, v3}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 574
    sput-boolean v1, Lcom/stericson/RootTools/InternalVariables;->accessGiven:Z

    .line 575
    new-instance v2, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v2}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    new-array v3, v0, [Ljava/lang/String;

    const-string v4, "id"

    aput-object v4, v3, v1

    sget v4, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-virtual {v2, v3, v4}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V

    .line 576
    sput v1, Lcom/stericson/RootTools/RootTools;->shellDelay:I

    .line 578
    sget-boolean v2, Lcom/stericson/RootTools/InternalVariables;->accessGiven:Z

    if-eqz v2, :cond_0

    .line 581
    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public static isAppletAvailable(Ljava/lang/String;)Z
    .locals 5
    .param p0, "Applet"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 551
    :try_start_0
    invoke-static {}, Lcom/stericson/RootTools/RootTools;->getBusyBoxApplets()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_1

    .line 563
    :goto_0
    return v2

    .line 551
    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 553
    .local v0, "applet":Ljava/lang/String;
    invoke-virtual {v0, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v4

    if-eqz v4, :cond_0

    .line 555
    const/4 v2, 0x1

    goto :goto_0

    .line 560
    .end local v0    # "applet":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 562
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static isBusyboxAvailable()Z
    .locals 1

    .prologue
    .line 360
    const-string v0, "busybox"

    invoke-static {v0}, Lcom/stericson/RootTools/RootTools;->findBinary(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static isNativeToolsReady(ILandroid/content/Context;)Z
    .locals 5
    .param p0, "nativeToolsId"    # I
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 586
    sget-object v3, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v4, "Preparing Native Tools"

    invoke-static {v3, v4}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 587
    sput-boolean v2, Lcom/stericson/RootTools/InternalVariables;->nativeToolsReady:Z

    .line 591
    :try_start_0
    new-instance v1, Lcom/stericson/RootTools/Installer;

    invoke-direct {v1, p1}, Lcom/stericson/RootTools/Installer;-><init>(Landroid/content/Context;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 599
    .local v1, "installer":Lcom/stericson/RootTools/Installer;
    const-string v2, "nativetools"

    invoke-virtual {v1, v2}, Lcom/stericson/RootTools/Installer;->isBinaryInstalled(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 600
    const/4 v2, 0x1

    sput-boolean v2, Lcom/stericson/RootTools/InternalVariables;->nativeToolsReady:Z

    .line 605
    :goto_0
    sget-boolean v2, Lcom/stericson/RootTools/InternalVariables;->nativeToolsReady:Z

    .end local v1    # "installer":Lcom/stericson/RootTools/Installer;
    :cond_0
    :goto_1
    return v2

    .line 592
    :catch_0
    move-exception v0

    .line 593
    .local v0, "ex":Ljava/io/IOException;
    sget-boolean v3, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v3, :cond_0

    .line 594
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_1

    .line 603
    .end local v0    # "ex":Ljava/io/IOException;
    .restart local v1    # "installer":Lcom/stericson/RootTools/Installer;
    :cond_1
    const-string v2, "nativetools"

    const-string v3, "700"

    invoke-virtual {v1, p0, v2, v3}, Lcom/stericson/RootTools/Installer;->installBinary(ILjava/lang/String;Ljava/lang/String;)Z

    move-result v2

    sput-boolean v2, Lcom/stericson/RootTools/InternalVariables;->nativeToolsReady:Z

    goto :goto_0
.end method

.method public static isProcessRunning(Ljava/lang/String;)Z
    .locals 6
    .param p0, "processName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 747
    sget-object v2, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "Checks if process is running: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 748
    const/4 v2, 0x0

    sput-object v2, Lcom/stericson/RootTools/InternalVariables;->pid:Ljava/lang/String;

    .line 749
    new-instance v2, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v2}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    new-array v3, v0, [Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "busybox pidof "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v1

    sget v4, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-virtual {v2, v3, v4}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V

    .line 751
    sget-object v2, Lcom/stericson/RootTools/InternalVariables;->pid:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 754
    :goto_0
    return v0

    :cond_0
    move v0, v1

    goto :goto_0
.end method

.method public static isRootAvailable()Z
    .locals 1

    .prologue
    .line 353
    const-string v0, "su"

    invoke-static {v0}, Lcom/stericson/RootTools/RootTools;->findBinary(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public static killProcess(Ljava/lang/String;)Z
    .locals 8
    .param p0, "processName"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 718
    sget-object v3, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Killing process "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 719
    const/4 v3, 0x0

    sput-object v3, Lcom/stericson/RootTools/InternalVariables;->pid:Ljava/lang/String;

    .line 721
    :try_start_0
    new-instance v3, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v3}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "busybox pidof "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    sget v5, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-virtual {v3, v4, v5}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_0 .. :try_end_0} :catch_0

    .line 726
    sget-object v3, Lcom/stericson/RootTools/InternalVariables;->pid:Ljava/lang/String;

    if-eqz v3, :cond_0

    .line 728
    :try_start_1
    new-instance v3, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v3}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "busybox kill -9 "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    sget-object v7, Lcom/stericson/RootTools/InternalVariables;->pid:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    sget v5, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-virtual {v3, v4, v5}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V
    :try_end_1
    .catch Ljava/util/concurrent/TimeoutException; {:try_start_1 .. :try_end_1} :catch_1

    .line 735
    :goto_0
    return v1

    .line 722
    :catch_0
    move-exception v0

    .local v0, "e":Ljava/util/concurrent/TimeoutException;
    move v1, v2

    .line 723
    goto :goto_0

    .line 729
    .end local v0    # "e":Ljava/util/concurrent/TimeoutException;
    :catch_1
    move-exception v0

    .restart local v0    # "e":Ljava/util/concurrent/TimeoutException;
    move v1, v2

    .line 730
    goto :goto_0

    .end local v0    # "e":Ljava/util/concurrent/TimeoutException;
    :cond_0
    move v1, v2

    .line 735
    goto :goto_0
.end method

.method public static log(Ljava/lang/String;)V
    .locals 1
    .param p0, "msg"    # Ljava/lang/String;

    .prologue
    .line 979
    const/4 v0, 0x0

    invoke-static {v0, p0}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 980
    return-void
.end method

.method public static log(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "TAG"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 983
    if-eqz p1, :cond_0

    const-string v0, ""

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 984
    sget-boolean v0, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v0, :cond_0

    .line 985
    if-eqz p0, :cond_1

    .line 986
    invoke-static {p0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 992
    :cond_0
    :goto_0
    return-void

    .line 988
    :cond_1
    sget-object v0, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    invoke-static {v0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static offerBusyBox(Landroid/app/Activity;I)Landroid/content/Intent;
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "requestCode"    # I

    .prologue
    .line 314
    sget-object v1, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v2, "Launching Market for BusyBox"

    invoke-static {v1, v2}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 315
    new-instance v0, Landroid/content/Intent;

    .line 316
    const-string v1, "android.intent.action.VIEW"

    const-string v2, "market://details?id=stericson.busybox"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 315
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 317
    .local v0, "i":Landroid/content/Intent;
    invoke-virtual {p0, v0, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 318
    return-object v0
.end method

.method public static offerBusyBox(Landroid/app/Activity;)V
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 299
    sget-object v1, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v2, "Launching Market for BusyBox"

    invoke-static {v1, v2}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 300
    new-instance v0, Landroid/content/Intent;

    .line 301
    const-string v1, "android.intent.action.VIEW"

    const-string v2, "market://details?id=stericson.busybox"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 300
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 302
    .local v0, "i":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 303
    return-void
.end method

.method public static offerSuperUser(Landroid/app/Activity;I)Landroid/content/Intent;
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "requestCode"    # I

    .prologue
    .line 342
    sget-object v1, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v2, "Launching Market for SuperUser"

    invoke-static {v1, v2}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 343
    new-instance v0, Landroid/content/Intent;

    .line 344
    const-string v1, "android.intent.action.VIEW"

    const-string v2, "market://details?id=com.noshufou.android.su"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 343
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 345
    .local v0, "i":Landroid/content/Intent;
    invoke-virtual {p0, v0, p1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 346
    return-object v0
.end method

.method public static offerSuperUser(Landroid/app/Activity;)V
    .locals 3
    .param p0, "activity"    # Landroid/app/Activity;

    .prologue
    .line 327
    sget-object v1, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v2, "Launching Market for SuperUser"

    invoke-static {v1, v2}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 328
    new-instance v0, Landroid/content/Intent;

    .line 329
    const-string v1, "android.intent.action.VIEW"

    const-string v2, "market://details?id=com.noshufou.android.su"

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 328
    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 330
    .local v0, "i":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 331
    return-void
.end method

.method public static remount(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "file"    # Ljava/lang/String;
    .param p1, "mountType"    # Ljava/lang/String;

    .prologue
    .line 648
    new-instance v0, Lcom/stericson/RootTools/Remounter;

    invoke-direct {v0}, Lcom/stericson/RootTools/Remounter;-><init>()V

    .line 650
    .local v0, "remounter":Lcom/stericson/RootTools/Remounter;
    invoke-virtual {v0, p0, p1}, Lcom/stericson/RootTools/Remounter;->remount(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    return v1
.end method

.method public static restartAndroid()V
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 766
    sget-object v0, Lcom/stericson/RootTools/InternalVariables;->TAG:Ljava/lang/String;

    const-string v1, "Restart Android"

    invoke-static {v0, v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;Ljava/lang/String;)V

    .line 767
    new-instance v0, Lcom/stericson/RootTools/InternalMethods;

    invoke-direct {v0}, Lcom/stericson/RootTools/InternalMethods;-><init>()V

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "busybox killall -9 zygote"

    aput-object v3, v1, v2

    sget v2, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-virtual {v0, v1, v2}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V

    .line 768
    return-void
.end method

.method public static runBinary(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "binaryName"    # Ljava/lang/String;
    .param p2, "parameter"    # Ljava/lang/String;

    .prologue
    .line 707
    new-instance v0, Lcom/stericson/RootTools/Runner;

    invoke-direct {v0, p0, p1, p2}, Lcom/stericson/RootTools/Runner;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 708
    .local v0, "runner":Lcom/stericson/RootTools/Runner;
    invoke-virtual {v0}, Lcom/stericson/RootTools/Runner;->start()V

    .line 709
    return-void
.end method

.method public static sendShell(Ljava/lang/String;I)Ljava/util/List;
    .locals 1
    .param p0, "command"    # Ljava/lang/String;
    .param p1, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/stericson/RootTools/RootToolsException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 904
    const/4 v0, 0x0

    invoke-static {p0, v0, p1}, Lcom/stericson/RootTools/RootTools;->sendShell(Ljava/lang/String;Lcom/stericson/RootTools/RootTools$Result;I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static sendShell(Ljava/lang/String;Lcom/stericson/RootTools/RootTools$Result;I)Ljava/util/List;
    .locals 2
    .param p0, "command"    # Ljava/lang/String;
    .param p1, "result"    # Lcom/stericson/RootTools/RootTools$Result;
    .param p2, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/stericson/RootTools/RootTools$Result;",
            "I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/stericson/RootTools/RootToolsException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 879
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/String;

    aput-object p0, v0, v1

    invoke-static {v0, v1, p1, p2}, Lcom/stericson/RootTools/RootTools;->sendShell([Ljava/lang/String;ILcom/stericson/RootTools/RootTools$Result;I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static sendShell([Ljava/lang/String;II)Ljava/util/List;
    .locals 1
    .param p0, "commands"    # [Ljava/lang/String;
    .param p1, "sleepTime"    # I
    .param p2, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "II)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/stericson/RootTools/RootToolsException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 851
    const/4 v0, 0x0

    invoke-static {p0, p1, v0, p2}, Lcom/stericson/RootTools/RootTools;->sendShell([Ljava/lang/String;ILcom/stericson/RootTools/RootTools$Result;I)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static sendShell([Ljava/lang/String;ILcom/stericson/RootTools/RootTools$Result;I)Ljava/util/List;
    .locals 1
    .param p0, "commands"    # [Ljava/lang/String;
    .param p1, "sleepTime"    # I
    .param p2, "result"    # Lcom/stericson/RootTools/RootTools$Result;
    .param p3, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "I",
            "Lcom/stericson/RootTools/RootTools$Result;",
            "I)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/stericson/RootTools/RootToolsException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 794
    const/4 v0, 0x1

    invoke-static {p0, p1, p2, v0, p3}, Lcom/stericson/RootTools/RootTools;->sendShell([Ljava/lang/String;ILcom/stericson/RootTools/RootTools$Result;ZI)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static sendShell([Ljava/lang/String;ILcom/stericson/RootTools/RootTools$Result;ZI)Ljava/util/List;
    .locals 6
    .param p0, "commands"    # [Ljava/lang/String;
    .param p1, "sleepTime"    # I
    .param p2, "result"    # Lcom/stericson/RootTools/RootTools$Result;
    .param p3, "useRoot"    # Z
    .param p4, "timeout"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "([",
            "Ljava/lang/String;",
            "I",
            "Lcom/stericson/RootTools/RootTools$Result;",
            "ZI)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/stericson/RootTools/RootToolsException;,
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 823
    new-instance v0, Lcom/stericson/RootTools/Executer;

    invoke-direct {v0}, Lcom/stericson/RootTools/Executer;-><init>()V

    move-object v1, p0

    move v2, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    invoke-virtual/range {v0 .. v5}, Lcom/stericson/RootTools/Executer;->sendShell([Ljava/lang/String;ILcom/stericson/RootTools/IResult;ZI)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method
