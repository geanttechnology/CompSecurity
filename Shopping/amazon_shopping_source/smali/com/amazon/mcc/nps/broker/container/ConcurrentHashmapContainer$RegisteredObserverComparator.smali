.class Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;
.super Ljava/lang/Object;
.source "ConcurrentHashmapContainer.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "RegisteredObserverComparator"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;",
        ">;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 161
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$1;

    .prologue
    .line 161
    invoke-direct {p0}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;)I
    .locals 3
    .param p1, "o1"    # Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;
    .param p2, "o2"    # Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;

    .prologue
    const/4 v2, 0x0

    .line 167
    if-nez p1, :cond_1

    move v0, v2

    .line 168
    .local v0, "o1Priority":I
    :goto_0
    if-nez p2, :cond_2

    move v1, v2

    .line 175
    .local v1, "o2Priority":I
    :goto_1
    if-le v0, v1, :cond_3

    .line 176
    const/4 v2, -0x1

    .line 180
    :cond_0
    :goto_2
    return v2

    .line 167
    .end local v0    # "o1Priority":I
    .end local v1    # "o2Priority":I
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->getPriority()I

    move-result v0

    goto :goto_0

    .line 168
    .restart local v0    # "o1Priority":I
    :cond_2
    invoke-virtual {p2}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;->getPriority()I

    move-result v1

    goto :goto_1

    .line 177
    .restart local v1    # "o2Priority":I
    :cond_3
    if-ge v0, v1, :cond_0

    .line 178
    const/4 v2, 0x1

    goto :goto_2
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 161
    check-cast p1, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserverComparator;->compare(Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;Lcom/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer$RegisteredObserver;)I

    move-result v0

    return v0
.end method
