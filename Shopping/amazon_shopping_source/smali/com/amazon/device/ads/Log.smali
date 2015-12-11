.class Lcom/amazon/device/ads/Log;
.super Ljava/lang/Object;
.source "Log.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/Log$1;,
        Lcom/amazon/device/ads/Log$LogcatLogger;
    }
.end annotation


# static fields
.field protected static final LOGTAG:Ljava/lang/String; = "AmazonMobileAds "

.field private static logger:Lcom/amazon/device/ads/ILog;

.field private static loggingEnabled_:Z


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 115
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/device/ads/Log;->loggingEnabled_:Z

    .line 116
    new-instance v0, Lcom/amazon/device/ads/Log$LogcatLogger;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/amazon/device/ads/Log$LogcatLogger;-><init>(Lcom/amazon/device/ads/Log$1;)V

    sput-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    return-void
.end method

.method constructor <init>()V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    return-void
.end method

.method public static canLog()Z
    .locals 2

    .prologue
    .line 139
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    if-nez v0, :cond_0

    .line 140
    const/4 v0, 0x0

    .line 142
    :goto_0
    return v0

    :cond_0
    const-string/jumbo v0, "debug.logging"

    sget-boolean v1, Lcom/amazon/device/ads/Log;->loggingEnabled_:Z

    invoke-static {v0, v1}, Lcom/amazon/device/ads/DebugProperties;->getDebugPropertyAsBoolean(Ljava/lang/String;Z)Z

    move-result v0

    goto :goto_0
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 169
    const/4 v0, 0x0

    invoke-static {v0, p0, p1}, Lcom/amazon/device/ads/Log;->d(ZLjava/lang/String;Ljava/lang/String;)V

    .line 170
    return-void
.end method

.method public static varargs d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "params"    # [Ljava/lang/Object;

    .prologue
    .line 177
    const/4 v0, 0x0

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/device/ads/Log;->d(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 178
    return-void
.end method

.method public static d(ZLjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 173
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Lcom/amazon/device/ads/ILog;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 174
    :cond_1
    return-void
.end method

.method public static varargs d(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "format"    # Ljava/lang/String;
    .param p3, "params"    # [Ljava/lang/Object;

    .prologue
    .line 181
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Lcom/amazon/device/ads/ILog;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 182
    :cond_1
    return-void
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 186
    const/4 v0, 0x0

    invoke-static {v0, p0, p1}, Lcom/amazon/device/ads/Log;->e(ZLjava/lang/String;Ljava/lang/String;)V

    .line 187
    return-void
.end method

.method public static varargs e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "params"    # [Ljava/lang/Object;

    .prologue
    .line 194
    const/4 v0, 0x0

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/device/ads/Log;->e(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 195
    return-void
.end method

.method public static e(ZLjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 190
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Lcom/amazon/device/ads/ILog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    :cond_1
    return-void
.end method

.method public static varargs e(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "format"    # Ljava/lang/String;
    .param p3, "params"    # [Ljava/lang/Object;

    .prologue
    .line 198
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Lcom/amazon/device/ads/ILog;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 199
    :cond_1
    return-void
.end method

.method public static enableLogging(Z)V
    .locals 0
    .param p0, "enabled"    # Z

    .prologue
    .line 147
    sput-boolean p0, Lcom/amazon/device/ads/Log;->loggingEnabled_:Z

    .line 148
    return-void
.end method

.method public static final enableLoggingWithSetterNotification(Ljava/lang/String;Z)V
    .locals 4
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "enable"    # Z

    .prologue
    .line 261
    if-nez p1, :cond_0

    .line 263
    const-string/jumbo v0, "Debug logging"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {p0, v0, v1}, Lcom/amazon/device/ads/Log;->logSetterNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 266
    :cond_0
    invoke-static {p1}, Lcom/amazon/device/ads/Log;->enableLogging(Z)V

    .line 268
    if-eqz p1, :cond_1

    .line 270
    const-string/jumbo v0, "Debug logging"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {p0, v0, v1}, Lcom/amazon/device/ads/Log;->logSetterNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 271
    const-string/jumbo v0, "Amazon Mobile Ads API Version: %s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {}, Lcom/amazon/device/ads/Version;->getRawSDKVersion()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {p0, v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 273
    :cond_1
    return-void
.end method

.method public static getLogger()Lcom/amazon/device/ads/ILog;
    .locals 1

    .prologue
    .line 133
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    return-object v0
.end method

.method public static i(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 203
    const/4 v0, 0x0

    invoke-static {v0, p0, p1}, Lcom/amazon/device/ads/Log;->i(ZLjava/lang/String;Ljava/lang/String;)V

    .line 204
    return-void
.end method

.method public static varargs i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "params"    # [Ljava/lang/Object;

    .prologue
    .line 211
    const/4 v0, 0x0

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/device/ads/Log;->i(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 212
    return-void
.end method

.method public static i(ZLjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 207
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Lcom/amazon/device/ads/ILog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    :cond_1
    return-void
.end method

.method public static varargs i(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "format"    # Ljava/lang/String;
    .param p3, "params"    # [Ljava/lang/Object;

    .prologue
    .line 215
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Lcom/amazon/device/ads/ILog;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 216
    :cond_1
    return-void
.end method

.method public static final logSetterNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 5
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "capitalizedSingularPropertyName"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v2, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 287
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    .line 301
    .end local p2    # "value":Ljava/lang/Object;
    :goto_0
    return-void

    .line 293
    .restart local p2    # "value":Ljava/lang/Object;
    :cond_0
    instance-of v0, p2, Ljava/lang/Boolean;

    if-eqz v0, :cond_2

    .line 295
    const-string/jumbo v1, "%s has been %s."

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v3

    check-cast p2, Ljava/lang/Boolean;

    .end local p2    # "value":Ljava/lang/Object;
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    const-string/jumbo v0, "enabled"

    :goto_1
    aput-object v0, v2, v4

    invoke-static {p0, v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0

    :cond_1
    const-string/jumbo v0, "disabled"

    goto :goto_1

    .line 299
    .restart local p2    # "value":Ljava/lang/Object;
    :cond_2
    const-string/jumbo v0, "%s has been set: %s"

    new-array v1, v2, [Ljava/lang/Object;

    aput-object p1, v1, v3

    invoke-static {p2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {p0, v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static setLogger(Lcom/amazon/device/ads/ILog;)V
    .locals 0
    .param p0, "newLogger"    # Lcom/amazon/device/ads/ILog;

    .prologue
    .line 124
    sput-object p0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    .line 125
    return-void
.end method

.method static split(Ljava/lang/String;I)Ljava/lang/Iterable;
    .locals 4
    .param p0, "input"    # Ljava/lang/String;
    .param p1, "maxLength"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "I)",
            "Ljava/lang/Iterable",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 237
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 238
    .local v1, "output":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-nez v2, :cond_1

    .line 246
    :cond_0
    return-object v1

    .line 242
    :cond_1
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 244
    invoke-virtual {p0}, Ljava/lang/String;->length()I

    move-result v2

    add-int v3, v0, p1

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v2

    invoke-virtual {p0, v0, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 242
    add-int/2addr v0, p1

    goto :goto_0
.end method

.method public static v(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 152
    const/4 v0, 0x0

    invoke-static {v0, p0, p1}, Lcom/amazon/device/ads/Log;->v(ZLjava/lang/String;Ljava/lang/String;)V

    .line 153
    return-void
.end method

.method public static varargs v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "params"    # [Ljava/lang/Object;

    .prologue
    .line 160
    const/4 v0, 0x0

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/device/ads/Log;->v(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 161
    return-void
.end method

.method public static v(ZLjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 156
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Lcom/amazon/device/ads/ILog;->v(Ljava/lang/String;Ljava/lang/String;)V

    .line 157
    :cond_1
    return-void
.end method

.method public static varargs v(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "format"    # Ljava/lang/String;
    .param p3, "params"    # [Ljava/lang/Object;

    .prologue
    .line 164
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Lcom/amazon/device/ads/ILog;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 165
    :cond_1
    return-void
.end method

.method public static w(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 220
    const/4 v0, 0x0

    invoke-static {v0, p0, p1}, Lcom/amazon/device/ads/Log;->w(ZLjava/lang/String;Ljava/lang/String;)V

    .line 221
    return-void
.end method

.method public static varargs w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p0, "tag"    # Ljava/lang/String;
    .param p1, "format"    # Ljava/lang/String;
    .param p2, "params"    # [Ljava/lang/Object;

    .prologue
    .line 228
    const/4 v0, 0x0

    invoke-static {v0, p0, p1, p2}, Lcom/amazon/device/ads/Log;->w(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 229
    return-void
.end method

.method public static w(ZLjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "msg"    # Ljava/lang/String;

    .prologue
    .line 224
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Lcom/amazon/device/ads/ILog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 225
    :cond_1
    return-void
.end method

.method public static varargs w(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 3
    .param p0, "force"    # Z
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "format"    # Ljava/lang/String;
    .param p3, "params"    # [Ljava/lang/Object;

    .prologue
    .line 232
    invoke-static {}, Lcom/amazon/device/ads/Log;->canLog()Z

    move-result v0

    if-nez v0, :cond_0

    if-eqz p0, :cond_1

    :cond_0
    sget-object v0, Lcom/amazon/device/ads/Log;->logger:Lcom/amazon/device/ads/ILog;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "AmazonMobileAds "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Lcom/amazon/device/ads/ILog;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 233
    :cond_1
    return-void
.end method
