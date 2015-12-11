.class public Lorg/apache/commons/io/FilenameUtils;
.super Ljava/lang/Object;
.source "FilenameUtils.java"


# static fields
.field public static final EXTENSION_SEPARATOR_STR:Ljava/lang/String;

.field private static final OTHER_SEPARATOR:C

.field private static final SYSTEM_SEPARATOR:C


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 104
    const/16 v0, 0x2e

    invoke-static {v0}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lorg/apache/commons/io/FilenameUtils;->EXTENSION_SEPARATOR_STR:Ljava/lang/String;

    .line 119
    sget-char v0, Ljava/io/File;->separatorChar:C

    sput-char v0, Lorg/apache/commons/io/FilenameUtils;->SYSTEM_SEPARATOR:C

    .line 126
    invoke-static {}, Lorg/apache/commons/io/FilenameUtils;->isSystemWindows()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 127
    const/16 v0, 0x2f

    sput-char v0, Lorg/apache/commons/io/FilenameUtils;->OTHER_SEPARATOR:C

    .line 131
    :goto_0
    return-void

    .line 129
    :cond_0
    const/16 v0, 0x5c

    sput-char v0, Lorg/apache/commons/io/FilenameUtils;->OTHER_SEPARATOR:C

    goto :goto_0
.end method

.method static isSystemWindows()Z
    .locals 2

    .prologue
    .line 147
    sget-char v0, Lorg/apache/commons/io/FilenameUtils;->SYSTEM_SEPARATOR:C

    const/16 v1, 0x5c

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
