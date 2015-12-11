.class public Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;
.super Ljava/lang/Object;
.source "WebResponseHeaders.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mHeaderNames:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mHeaders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mStatusCode:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const-class v0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mHeaders:Ljava/util/Map;

    .line 24
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mHeaderNames:Ljava/util/List;

    .line 25
    const-wide/16 v0, 0xc8

    iput-wide v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mStatusCode:J

    .line 26
    return-void
.end method


# virtual methods
.method public addHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 78
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 80
    :cond_0
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "WebResponseHeaders: addHeader: Header cannot be added. Name or value was null."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 86
    :goto_0
    return-void

    .line 84
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mHeaderNames:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 85
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mHeaders:Ljava/util/Map;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public getHeaderByName(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 63
    if-nez p1, :cond_0

    .line 65
    const/4 v0, 0x0

    .line 68
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mHeaders:Ljava/util/Map;

    sget-object v1, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p1, v1}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public getHeaderName(J)Ljava/lang/String;
    .locals 2
    .param p1, "index"    # J

    .prologue
    .line 40
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->getNumHeaders()J

    move-result-wide v0

    cmp-long v0, p1, v0

    if-ltz v0, :cond_0

    .line 42
    sget-object v0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "WebResponseHeaders: getHeaderName: index out of range"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    const/4 v0, 0x0

    .line 46
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mHeaderNames:Ljava/util/List;

    long-to-int v1, p1

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public getHeaderValue(J)Ljava/lang/String;
    .locals 3
    .param p1, "index"    # J

    .prologue
    .line 51
    invoke-virtual {p0}, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->getNumHeaders()J

    move-result-wide v1

    cmp-long v1, p1, v1

    if-ltz v1, :cond_0

    .line 53
    sget-object v1, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "WebResponseHeaders: getHeaderValue: index out of range"

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    const/4 v1, 0x0

    .line 58
    :goto_0
    return-object v1

    .line 57
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mHeaderNames:Ljava/util/List;

    long-to-int v2, p1

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 58
    .local v0, "name":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mHeaders:Ljava/util/Map;

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v0, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    goto :goto_0
.end method

.method public getNumHeaders()J
    .locals 2

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mHeaderNames:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    int-to-long v0, v0

    return-wide v0
.end method

.method public getStatusCode()J
    .locals 2

    .prologue
    .line 30
    iget-wide v0, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mStatusCode:J

    return-wide v0
.end method

.method public setStatusCode(J)V
    .locals 0
    .param p1, "statusCode"    # J

    .prologue
    .line 73
    iput-wide p1, p0, Lcom/amazon/identity/kcpsdk/common/WebResponseHeaders;->mStatusCode:J

    .line 74
    return-void
.end method
