.class public Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;
.super Lcom/amazon/device/analytics/events/UniqueIdResolverChain;
.source "RandomUniqueIdResolver.java"

# interfaces
.implements Lcom/amazon/device/analytics/util/JSONSerializable;


# static fields
.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private uniqueId:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;->logger:Lcom/amazon/device/analytics/log/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;-><init>()V

    .line 17
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;->uniqueId:Ljava/lang/String;

    .line 21
    sget-object v0, Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v1, "Generating a random UUID for uniqueId"

    invoke-virtual {v0, v1}, Lcom/amazon/device/analytics/log/Logger;->v(Ljava/lang/String;)V

    .line 22
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;->uniqueId:Ljava/lang/String;

    .line 23
    return-void
.end method


# virtual methods
.method protected tryResolve()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;->uniqueId:Ljava/lang/String;

    return-object v0
.end method

.method protected tryStore(Ljava/lang/String;)Z
    .locals 1
    .param p1, "uniqueId"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/amazon/device/analytics/events/RandomUniqueIdResolver;->uniqueId:Ljava/lang/String;

    .line 32
    const/4 v0, 0x1

    return v0
.end method
