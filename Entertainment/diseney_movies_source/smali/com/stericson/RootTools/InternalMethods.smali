.class Lcom/stericson/RootTools/InternalMethods;
.super Ljava/lang/Object;
.source "InternalMethods.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/stericson/RootTools/InternalMethods$Worker;
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected doExec([Ljava/lang/String;I)V
    .locals 4
    .param p1, "commands"    # [Ljava/lang/String;
    .param p2, "timeout"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    .line 48
    new-instance v1, Lcom/stericson/RootTools/InternalMethods$Worker;

    const/4 v2, 0x0

    invoke-direct {v1, p1, v2}, Lcom/stericson/RootTools/InternalMethods$Worker;-><init>([Ljava/lang/String;Lcom/stericson/RootTools/InternalMethods$Worker;)V

    .line 49
    .local v1, "worker":Lcom/stericson/RootTools/InternalMethods$Worker;
    invoke-virtual {v1}, Lcom/stericson/RootTools/InternalMethods$Worker;->start()V

    .line 53
    const/4 v2, -0x1

    if-ne p2, v2, :cond_0

    .line 55
    const p2, 0x493e0

    .line 58
    :cond_0
    int-to-long v2, p2

    :try_start_0
    invoke-virtual {v1, v2, v3}, Lcom/stericson/RootTools/InternalMethods$Worker;->join(J)V

    .line 61
    sget v2, Lcom/stericson/RootTools/RootTools;->shellDelay:I

    int-to-long v2, v2

    invoke-static {v2, v3}, Ljava/lang/Thread;->sleep(J)V

    .line 63
    iget v2, v1, Lcom/stericson/RootTools/InternalMethods$Worker;->exit:I

    const/16 v3, -0x38f

    if-eq v2, v3, :cond_1

    .line 64
    return-void

    .line 66
    :cond_1
    new-instance v2, Ljava/util/concurrent/TimeoutException;

    invoke-direct {v2}, Ljava/util/concurrent/TimeoutException;-><init>()V

    throw v2
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 68
    :catch_0
    move-exception v0

    .line 70
    .local v0, "ex":Ljava/lang/InterruptedException;
    invoke-virtual {v1}, Lcom/stericson/RootTools/InternalMethods$Worker;->interrupt()V

    .line 71
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Thread;->interrupt()V

    .line 72
    new-instance v2, Ljava/util/concurrent/TimeoutException;

    invoke-direct {v2}, Ljava/util/concurrent/TimeoutException;-><init>()V

    throw v2
.end method

.method protected getConvertedSpace(Ljava/lang/String;)J
    .locals 8
    .param p1, "spaceStr"    # Ljava/lang/String;

    .prologue
    .line 231
    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    .line 233
    .local v3, "multiplier":D
    :try_start_0
    new-instance v5, Ljava/lang/StringBuffer;

    invoke-direct {v5}, Ljava/lang/StringBuffer;-><init>()V

    .line 234
    .local v5, "sb":Ljava/lang/StringBuffer;
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v6

    if-lt v2, v6, :cond_1

    .line 246
    :cond_0
    :goto_1
    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v6

    mul-double/2addr v6, v3

    invoke-static {v6, v7}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v6

    double-to-long v6, v6

    .line 250
    .end local v2    # "i":I
    .end local v5    # "sb":Ljava/lang/StringBuffer;
    :goto_2
    return-wide v6

    .line 235
    .restart local v2    # "i":I
    .restart local v5    # "sb":Ljava/lang/StringBuffer;
    :cond_1
    invoke-virtual {p1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v0

    .line 236
    .local v0, "c":C
    invoke-static {v0}, Ljava/lang/Character;->isDigit(C)Z

    move-result v6

    if-nez v6, :cond_5

    const/16 v6, 0x2e

    if-eq v0, v6, :cond_5

    .line 237
    const/16 v6, 0x6d

    if-eq v0, v6, :cond_2

    const/16 v6, 0x4d

    if-ne v0, v6, :cond_3

    .line 238
    :cond_2
    const-wide/high16 v3, 0x4090000000000000L    # 1024.0

    goto :goto_1

    .line 239
    :cond_3
    const/16 v6, 0x67

    if-eq v0, v6, :cond_4

    const/16 v6, 0x47

    if-ne v0, v6, :cond_0

    .line 240
    :cond_4
    const-wide/high16 v3, 0x4130000000000000L    # 1048576.0

    .line 242
    goto :goto_1

    .line 244
    :cond_5
    invoke-virtual {p1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 234
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 248
    .end local v0    # "c":C
    .end local v2    # "i":I
    .end local v5    # "sb":Ljava/lang/StringBuffer;
    :catch_0
    move-exception v1

    .line 250
    .local v1, "e":Ljava/lang/Exception;
    const-wide/16 v6, -0x1

    goto :goto_2
.end method

.method protected getMounts()Ljava/util/ArrayList;
    .locals 9
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
            Ljava/io/FileNotFoundException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 108
    const/4 v2, 0x0

    .line 110
    .local v2, "lnr":Ljava/io/LineNumberReader;
    new-instance v2, Ljava/io/LineNumberReader;

    .end local v2    # "lnr":Ljava/io/LineNumberReader;
    new-instance v4, Ljava/io/FileReader;

    const-string v5, "/proc/mounts"

    invoke-direct {v4, v5}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    invoke-direct {v2, v4}, Ljava/io/LineNumberReader;-><init>(Ljava/io/Reader;)V

    .line 112
    .restart local v2    # "lnr":Ljava/io/LineNumberReader;
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 113
    .local v3, "mounts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/stericson/RootTools/Mount;>;"
    :goto_0
    invoke-virtual {v2}, Ljava/io/LineNumberReader;->readLine()Ljava/lang/String;

    move-result-object v1

    .local v1, "line":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 125
    return-object v3

    .line 115
    :cond_0
    invoke-static {v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 117
    const-string v4, " "

    invoke-virtual {v1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 118
    .local v0, "fields":[Ljava/lang/String;
    new-instance v4, Lcom/stericson/RootTools/Mount;

    .line 119
    new-instance v5, Ljava/io/File;

    const/4 v6, 0x0

    aget-object v6, v0, v6

    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 120
    new-instance v6, Ljava/io/File;

    const/4 v7, 0x1

    aget-object v7, v0, v7

    invoke-direct {v6, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 121
    const/4 v7, 0x2

    aget-object v7, v0, v7

    .line 122
    const/4 v8, 0x3

    aget-object v8, v0, v8

    invoke-direct {v4, v5, v6, v7, v8}, Lcom/stericson/RootTools/Mount;-><init>(Ljava/io/File;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method protected getPermissions(Ljava/lang/String;)Lcom/stericson/RootTools/Permissions;
    .locals 11
    .param p1, "line"    # Ljava/lang/String;

    .prologue
    const/4 v10, 0x4

    const/4 v9, 0x2

    const/16 v8, 0x2d

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 155
    const-string v4, " "

    invoke-virtual {p1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 156
    .local v1, "lineArray":[Ljava/lang/String;
    aget-object v3, v1, v6

    .line 158
    .local v3, "rawPermissions":Ljava/lang/String;
    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    const/16 v5, 0xa

    if-ne v4, v5, :cond_3

    invoke-virtual {v3, v6}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-eq v4, v8, :cond_0

    invoke-virtual {v3, v6}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x64

    if-eq v4, v5, :cond_0

    .line 159
    invoke-virtual {v3, v6}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x6c

    if-ne v4, v5, :cond_3

    :cond_0
    invoke-virtual {v3, v7}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-eq v4, v8, :cond_1

    invoke-virtual {v3, v7}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x72

    if-ne v4, v5, :cond_3

    .line 160
    :cond_1
    invoke-virtual {v3, v9}, Ljava/lang/String;->charAt(I)C

    move-result v4

    if-eq v4, v8, :cond_2

    invoke-virtual {v3, v9}, Ljava/lang/String;->charAt(I)C

    move-result v4

    const/16 v5, 0x77

    if-ne v4, v5, :cond_3

    .line 162
    :cond_2
    invoke-static {v3}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 164
    new-instance v2, Lcom/stericson/RootTools/Permissions;

    invoke-direct {v2}, Lcom/stericson/RootTools/Permissions;-><init>()V

    .line 166
    .local v2, "permissions":Lcom/stericson/RootTools/Permissions;
    invoke-virtual {v3, v6, v7}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/stericson/RootTools/Permissions;->setType(Ljava/lang/String;)V

    .line 168
    invoke-virtual {v2}, Lcom/stericson/RootTools/Permissions;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 170
    invoke-virtual {v3, v7, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/stericson/RootTools/Permissions;->setUserPermissions(Ljava/lang/String;)V

    .line 172
    invoke-virtual {v2}, Lcom/stericson/RootTools/Permissions;->getUserPermissions()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 174
    const/4 v4, 0x7

    invoke-virtual {v3, v10, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/stericson/RootTools/Permissions;->setGroupPermissions(Ljava/lang/String;)V

    .line 176
    invoke-virtual {v2}, Lcom/stericson/RootTools/Permissions;->getGroupPermissions()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 178
    const/4 v4, 0x7

    const/16 v5, 0xa

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/stericson/RootTools/Permissions;->setOtherPermissions(Ljava/lang/String;)V

    .line 180
    invoke-virtual {v2}, Lcom/stericson/RootTools/Permissions;->getOtherPermissions()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 184
    invoke-virtual {v2}, Lcom/stericson/RootTools/Permissions;->getUserPermissions()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/stericson/RootTools/InternalMethods;->parsePermissions(Ljava/lang/String;)I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    .line 185
    .local v0, "finalPermissions":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/stericson/RootTools/Permissions;->getGroupPermissions()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/stericson/RootTools/InternalMethods;->parsePermissions(Ljava/lang/String;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 186
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/stericson/RootTools/Permissions;->getOtherPermissions()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/stericson/RootTools/InternalMethods;->parsePermissions(Ljava/lang/String;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 188
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {v2, v4}, Lcom/stericson/RootTools/Permissions;->setPermissions(I)V

    .line 193
    .end local v0    # "finalPermissions":Ljava/lang/String;
    .end local v2    # "permissions":Lcom/stericson/RootTools/Permissions;
    :goto_0
    return-object v2

    :cond_3
    const/4 v2, 0x0

    goto :goto_0
.end method

.method protected getSymLinks()Ljava/util/ArrayList;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/stericson/RootTools/Symlink;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 132
    const/4 v2, 0x0

    .line 134
    .local v2, "lnr":Ljava/io/LineNumberReader;
    new-instance v2, Ljava/io/LineNumberReader;

    .end local v2    # "lnr":Ljava/io/LineNumberReader;
    new-instance v4, Ljava/io/FileReader;

    const-string v5, "/data/local/symlinks.txt"

    invoke-direct {v4, v5}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    invoke-direct {v2, v4}, Ljava/io/LineNumberReader;-><init>(Ljava/io/Reader;)V

    .line 136
    .restart local v2    # "lnr":Ljava/io/LineNumberReader;
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 137
    .local v3, "symlink":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/stericson/RootTools/Symlink;>;"
    :goto_0
    invoke-virtual {v2}, Ljava/io/LineNumberReader;->readLine()Ljava/lang/String;

    move-result-object v1

    .local v1, "line":Ljava/lang/String;
    if-nez v1, :cond_0

    .line 147
    return-object v3

    .line 139
    :cond_0
    invoke-static {v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 141
    const-string v4, " "

    invoke-virtual {v1, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 142
    .local v0, "fields":[Ljava/lang/String;
    new-instance v4, Lcom/stericson/RootTools/Symlink;

    .line 143
    new-instance v5, Ljava/io/File;

    array-length v6, v0

    add-int/lit8 v6, v6, -0x3

    aget-object v6, v0, v6

    invoke-direct {v5, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 144
    new-instance v6, Ljava/io/File;

    array-length v7, v0

    add-int/lit8 v7, v7, -0x1

    aget-object v7, v0, v7

    invoke-direct {v6, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-direct {v4, v5, v6}, Lcom/stericson/RootTools/Symlink;-><init>(Ljava/io/File;Ljava/io/File;)V

    .line 142
    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method protected parsePermissions(Ljava/lang/String;)I
    .locals 6
    .param p1, "permission"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 199
    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v2, 0x72

    if-ne v1, v2, :cond_0

    .line 200
    const/4 v0, 0x4

    .line 204
    .local v0, "tmp":I
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "permission "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 205
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "character "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v3}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 207
    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v2, 0x77

    if-ne v1, v2, :cond_1

    .line 208
    add-int/lit8 v0, v0, 0x2

    .line 212
    :goto_1
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "permission "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 213
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "character "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v4}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 215
    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v1

    const/16 v2, 0x78

    if-ne v1, v2, :cond_2

    .line 216
    add-int/lit8 v0, v0, 0x1

    .line 220
    :goto_2
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "permission "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 221
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "character "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {p1, v5}, Ljava/lang/String;->charAt(I)C

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 223
    return v0

    .line 202
    .end local v0    # "tmp":I
    :cond_0
    const/4 v0, 0x0

    .restart local v0    # "tmp":I
    goto/16 :goto_0

    .line 210
    :cond_1
    add-int/lit8 v0, v0, 0x0

    goto :goto_1

    .line 218
    :cond_2
    add-int/lit8 v0, v0, 0x0

    goto :goto_2
.end method

.method protected returnPath()Z
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/concurrent/TimeoutException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 77
    new-instance v4, Ljava/io/File;

    const-string v7, "/data/local/tmp"

    invoke-direct {v4, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 78
    .local v4, "tmpDir":Ljava/io/File;
    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v7

    if-nez v7, :cond_0

    .line 79
    new-array v7, v5, [Ljava/lang/String;

    const-string v8, "mkdir /data/local/tmp"

    aput-object v8, v7, v6

    sget v8, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    invoke-virtual {p0, v7, v8}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V

    .line 82
    :cond_0
    :try_start_0
    new-instance v7, Ljava/util/HashSet;

    invoke-direct {v7}, Ljava/util/HashSet;-><init>()V

    sput-object v7, Lcom/stericson/RootTools/InternalVariables;->path:Ljava/util/Set;

    .line 84
    const/4 v2, 0x0

    .line 85
    .local v2, "lnr":Ljava/io/LineNumberReader;
    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    const-string v9, "dd if=/init.rc of=/data/local/tmp/init.rc"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    .line 86
    const-string v9, "chmod 0777 /data/local/tmp/init.rc"

    aput-object v9, v7, v8

    sget v8, Lcom/stericson/RootTools/InternalVariables;->timeout:I

    .line 85
    invoke-virtual {p0, v7, v8}, Lcom/stericson/RootTools/InternalMethods;->doExec([Ljava/lang/String;I)V

    .line 87
    new-instance v2, Ljava/io/LineNumberReader;

    .end local v2    # "lnr":Ljava/io/LineNumberReader;
    new-instance v7, Ljava/io/FileReader;

    const-string v8, "/data/local/tmp/init.rc"

    invoke-direct {v7, v8}, Ljava/io/FileReader;-><init>(Ljava/lang/String;)V

    invoke-direct {v2, v7}, Ljava/io/LineNumberReader;-><init>(Ljava/io/Reader;)V

    .line 89
    .restart local v2    # "lnr":Ljava/io/LineNumberReader;
    :cond_1
    invoke-virtual {v2}, Ljava/io/LineNumberReader;->readLine()Ljava/lang/String;

    move-result-object v1

    .local v1, "line":Ljava/lang/String;
    if-nez v1, :cond_2

    move v5, v6

    .line 103
    .end local v1    # "line":Ljava/lang/String;
    .end local v2    # "lnr":Ljava/io/LineNumberReader;
    :goto_0
    return v5

    .line 90
    .restart local v1    # "line":Ljava/lang/String;
    .restart local v2    # "lnr":Ljava/io/LineNumberReader;
    :cond_2
    invoke-static {v1}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 91
    const-string v7, "export PATH"

    invoke-virtual {v1, v7}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 92
    const-string v7, "/"

    invoke-virtual {v1, v7}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    .line 93
    .local v3, "tmp":I
    new-instance v7, Ljava/util/HashSet;

    invoke-virtual {v1, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    const-string v9, ":"

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    sput-object v7, Lcom/stericson/RootTools/InternalVariables;->path:Ljava/util/Set;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 98
    .end local v1    # "line":Ljava/lang/String;
    .end local v2    # "lnr":Ljava/io/LineNumberReader;
    .end local v3    # "tmp":I
    :catch_0
    move-exception v0

    .line 99
    .local v0, "e":Ljava/lang/Exception;
    sget-boolean v5, Lcom/stericson/RootTools/RootTools;->debugMode:Z

    if-eqz v5, :cond_3

    .line 100
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v7, "Error: "

    invoke-direct {v5, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/stericson/RootTools/RootTools;->log(Ljava/lang/String;)V

    .line 101
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    :cond_3
    move v5, v6

    .line 103
    goto :goto_0
.end method
