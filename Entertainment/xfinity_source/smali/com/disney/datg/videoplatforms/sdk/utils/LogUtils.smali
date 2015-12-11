.class public Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;
.super Ljava/lang/Object;
.source "LogUtils.java"


# static fields
.field private static final LOG_PREFIX_LENGTH:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 30
    const-string v0, "androidSDK_"

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    sput v0, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOG_PREFIX_LENGTH:I

    return-void
.end method

.method public static LOGD(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 64
    if-nez p1, :cond_0

    const-string p1, ""

    .line 65
    :cond_0
    if-eqz p0, :cond_1

    if-eqz p1, :cond_1

    .line 67
    invoke-static {p0, p1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 70
    :cond_1
    return-void
.end method

.method public static LOGE(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 124
    if-nez p1, :cond_0

    const-string p1, ""

    .line 125
    :cond_0
    if-eqz p0, :cond_1

    if-eqz p1, :cond_1

    .line 126
    invoke-static {p0, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 128
    :cond_1
    return-void
.end method

.method public static LOGV(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 82
    if-nez p1, :cond_0

    const-string p1, ""

    .line 83
    :cond_0
    if-eqz p0, :cond_1

    if-eqz p1, :cond_1

    .line 84
    invoke-static {p0, p1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 86
    :cond_1
    return-void
.end method

.method public static LOGW(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 110
    if-nez p1, :cond_0

    const-string p1, ""

    .line 111
    :cond_0
    if-eqz p0, :cond_1

    if-eqz p1, :cond_1

    .line 112
    invoke-static {p0, p1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 114
    :cond_1
    return-void
.end method

.method public static logException(Ljava/lang/Exception;)V
    .locals 0
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    .line 56
    .line 57
    return-void
.end method

.method public static makeLogTag(Ljava/lang/Class;)Ljava/lang/String;
    .locals 1
    .param p0, "cls"    # Ljava/lang/Class;

    .prologue
    .line 60
    invoke-virtual {p0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->makeLogTag(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static makeLogTag(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "str"    # Ljava/lang/String;

    .prologue
    .line 34
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v0

    sget v1, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOG_PREFIX_LENGTH:I

    rsub-int/lit8 v1, v1, 0x23

    if-le v0, v1, :cond_0

    .line 35
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "androidSDK_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/4 v1, 0x0

    sget v2, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOG_PREFIX_LENGTH:I

    rsub-int/lit8 v2, v2, 0x23

    add-int/lit8 v2, v2, -0x1

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 38
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "androidSDK_"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
