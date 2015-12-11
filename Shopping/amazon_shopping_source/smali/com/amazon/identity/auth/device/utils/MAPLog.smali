.class public final Lcom/amazon/identity/auth/device/utils/MAPLog;
.super Ljava/lang/Object;
.source "MAPLog.java"


# static fields
.field private static volatile sMyUserTag:Ljava/lang/String;

.field private static volatile sPackageName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 14
    const-string/jumbo v0, ""

    sput-object v0, Lcom/amazon/identity/auth/device/utils/MAPLog;->sMyUserTag:Ljava/lang/String;

    .line 16
    const-string/jumbo v0, "Unknown"

    sput-object v0, Lcom/amazon/identity/auth/device/utils/MAPLog;->sPackageName:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    return-void
.end method

.method public static accountNotRegisteredError(Ljava/lang/String;Ljava/lang/String;Ljava/util/Collection;)V
    .locals 5
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 208
    .local p2, "registeredDirectedIds":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "Account not registered: "

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 209
    .local v1, "message":Ljava/lang/StringBuilder;
    if-nez p1, :cond_0

    .line 211
    const-string/jumbo v3, "null"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 218
    :goto_0
    if-eqz p2, :cond_1

    .line 220
    const-string/jumbo v3, ". Registered accounts are:"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 221
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 223
    .local v2, "registeredDirectedId":Ljava/lang/String;
    const/16 v3, 0x20

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 224
    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->appendMaskedDirectedId(Ljava/lang/StringBuilder;Ljava/lang/String;)V

    goto :goto_1

    .line 215
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "registeredDirectedId":Ljava/lang/String;
    :cond_0
    invoke-static {v1, p1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->appendMaskedDirectedId(Ljava/lang/StringBuilder;Ljava/lang/String;)V

    goto :goto_0

    .line 228
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/IllegalArgumentException;

    invoke-direct {v4}, Ljava/lang/IllegalArgumentException;-><init>()V

    invoke-static {p0, v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 229
    return-void
.end method

.method private static appendMaskedDirectedId(Ljava/lang/StringBuilder;Ljava/lang/String;)V
    .locals 4
    .param p0, "message"    # Ljava/lang/StringBuilder;
    .param p1, "directedId"    # Ljava/lang/String;

    .prologue
    .line 233
    const-string/jumbo v0, "***"

    invoke-virtual {p0, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x2

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v3

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 234
    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 50
    const/4 v0, 0x3

    const/4 v1, 0x0

    invoke-static {v0, p0, p1, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 51
    return-void
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "exception"    # Ljava/lang/Throwable;

    .prologue
    .line 59
    const/4 v0, 0x3

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 60
    return-void
.end method

.method public static varargs d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 41
    const/4 v0, 0x3

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 42
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 172
    const/4 v0, 0x6

    const/4 v1, 0x0

    invoke-static {v0, p0, p1, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 173
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "exception"    # Ljava/lang/Throwable;

    .prologue
    .line 182
    const/4 v0, 0x6

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 183
    return-void
.end method

.method public static varargs e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 162
    const/4 v0, 0x6

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 163
    return-void
.end method

.method public static i(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 111
    const/4 v0, 0x4

    const/4 v1, 0x0

    invoke-static {v0, p0, p1, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 112
    return-void
.end method

.method public static i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "exception"    # Ljava/lang/Throwable;

    .prologue
    .line 122
    const/4 v0, 0x4

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 123
    return-void
.end method

.method public static varargs i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 103
    const/4 v0, 0x4

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 104
    return-void
.end method

.method public static pii(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 81
    const/4 v0, 0x3

    const/4 v1, 0x0

    invoke-static {v0, p0, p1, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 82
    return-void
.end method

.method public static pii(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "exception"    # Ljava/lang/Throwable;

    .prologue
    .line 92
    const/4 v0, 0x3

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 93
    return-void
.end method

.method public static varargs pii(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 70
    const/4 v0, 0x3

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 71
    return-void
.end method

.method public static setPackageName(Ljava/lang/String;)V
    .locals 0
    .param p0, "packageName"    # Ljava/lang/String;

    .prologue
    .line 27
    sput-object p0, Lcom/amazon/identity/auth/device/utils/MAPLog;->sPackageName:Ljava/lang/String;

    .line 28
    return-void
.end method

.method public static setUserId(I)V
    .locals 2
    .param p0, "myUser"    # I

    .prologue
    .line 32
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "["

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/MAPLog;->sMyUserTag:Ljava/lang/String;

    .line 33
    return-void
.end method

.method public static verboseError(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 193
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    return-void
.end method

.method public static w(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 142
    const/4 v0, 0x5

    const/4 v1, 0x0

    invoke-static {v0, p0, p1, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 143
    return-void
.end method

.method public static w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "exception"    # Ljava/lang/Throwable;

    .prologue
    .line 152
    const/4 v0, 0x5

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 153
    return-void
.end method

.method public static varargs w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "args"    # [Ljava/lang/Object;

    .prologue
    .line 132
    const/4 v0, 0x5

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 133
    return-void
.end method

.method private static writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 3
    .param p0, "type"    # I
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "exception"    # Ljava/lang/Throwable;

    .prologue
    .line 248
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/amazon/identity/auth/device/utils/MAPLog;->sPackageName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/16 v2, 0x2f

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/amazon/identity/auth/device/utils/MAPLog;->sMyUserTag:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 250
    .local v0, "packageContextualTag":Ljava/lang/String;
    invoke-static {p0, v0, p2}, Landroid/util/Log;->println(ILjava/lang/String;Ljava/lang/String;)I

    .line 252
    if-eqz p3, :cond_0

    .line 254
    invoke-static {p3}, Landroid/util/Log;->getStackTraceString(Ljava/lang/Throwable;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p0, v0, v1}, Landroid/util/Log;->println(ILjava/lang/String;Ljava/lang/String;)I

    .line 256
    :cond_0
    return-void
.end method

.method private static varargs writeToLogcat(ILjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 2
    .param p0, "type"    # I
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "args"    # [Ljava/lang/Object;

    .prologue
    .line 238
    invoke-static {p2, p3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {p0, p1, v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->writeToLogcat(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 239
    return-void
.end method
