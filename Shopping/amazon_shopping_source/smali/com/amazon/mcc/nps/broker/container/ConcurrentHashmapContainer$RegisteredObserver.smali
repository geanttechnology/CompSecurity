.class Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;
.super Ljava/lang/Object;
.source "ConcurrentHashmapContainer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RegisteredObserver"
.end annotation


# instance fields
.field private final observer:Lcom/amazon/mcc/nps/Observer;

.field private final properties:Lcom/amazon/mcc/nps/ObserverProperties;


# direct methods
.method public constructor <init>(Lcom/amazon/mcc/nps/Observer;Lcom/amazon/mcc/nps/ObserverProperties;)V
    .locals 0
    .param p1, "observer"    # Lcom/amazon/mcc/nps/Observer;
    .param p2, "properties"    # Lcom/amazon/mcc/nps/ObserverProperties;

    .prologue
    .line 122
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 123
    iput-object p1, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->observer:Lcom/amazon/mcc/nps/Observer;

    .line 124
    iput-object p2, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->properties:Lcom/amazon/mcc/nps/ObserverProperties;

    .line 125
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 145
    if-ne p0, p1, :cond_1

    .line 157
    :cond_0
    :goto_0
    return v1

    .line 147
    :cond_1
    if-nez p1, :cond_2

    move v1, v2

    .line 148
    goto :goto_0

    .line 149
    :cond_2
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    move v1, v2

    .line 150
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 151
    check-cast v0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;

    .line 152
    .local v0, "other":Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;
    iget-object v3, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->observer:Lcom/amazon/mcc/nps/Observer;

    if-nez v3, :cond_4

    .line 153
    iget-object v3, v0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->observer:Lcom/amazon/mcc/nps/Observer;

    if-eqz v3, :cond_0

    move v1, v2

    .line 154
    goto :goto_0

    .line 155
    :cond_4
    iget-object v3, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->observer:Lcom/amazon/mcc/nps/Observer;

    iget-object v4, v0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->observer:Lcom/amazon/mcc/nps/Observer;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    move v1, v2

    .line 156
    goto :goto_0
.end method

.method public getObserver()Lcom/amazon/mcc/nps/Observer;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->observer:Lcom/amazon/mcc/nps/Observer;

    return-object v0
.end method

.method public getPriority()I
    .locals 1

    .prologue
    .line 132
    iget-object v0, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->properties:Lcom/amazon/mcc/nps/ObserverProperties;

    invoke-virtual {v0}, Lcom/amazon/mcc/nps/ObserverProperties;->getPriority()I

    move-result v0

    return v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 137
    const/16 v0, 0x1f

    .line 138
    .local v0, "prime":I
    const/4 v1, 0x1

    .line 139
    .local v1, "result":I
    iget-object v2, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->observer:Lcom/amazon/mcc/nps/Observer;

    if-nez v2, :cond_0

    const/4 v2, 0x0

    :goto_0
    add-int/lit8 v1, v2, 0x1f

    .line 140
    return v1

    .line 139
    :cond_0
    iget-object v2, p0, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->observer:Lcom/amazon/mcc/nps/Observer;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    goto :goto_0
.end method
