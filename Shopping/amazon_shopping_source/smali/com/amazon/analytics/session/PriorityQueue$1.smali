.class Lcom/amazon/analytics/session/PriorityQueue$1;
.super Ljava/lang/Object;
.source "PriorityQueue.java"

# interfaces
.implements Ljava/util/Comparator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/analytics/session/PriorityQueue;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/Comparator",
        "<",
        "Lcom/amazon/analytics/util/Message;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/analytics/session/PriorityQueue;


# direct methods
.method constructor <init>(Lcom/amazon/analytics/session/PriorityQueue;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/analytics/session/PriorityQueue$1;->this$0:Lcom/amazon/analytics/session/PriorityQueue;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public compare(Lcom/amazon/analytics/util/Message;Lcom/amazon/analytics/util/Message;)I
    .locals 4
    .param p1, "left"    # Lcom/amazon/analytics/util/Message;
    .param p2, "right"    # Lcom/amazon/analytics/util/Message;

    .prologue
    .line 48
    invoke-virtual {p1}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "TimeStamp"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 49
    .local v0, "leftTs":Ljava/lang/Long;
    invoke-virtual {p2}, Lcom/amazon/analytics/util/Message;->getExtras()Ljava/util/Map;

    move-result-object v2

    const-string/jumbo v3, "TimeStamp"

    invoke-interface {v2, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 51
    .local v1, "rightTs":Ljava/lang/Long;
    if-nez v0, :cond_0

    if-nez v1, :cond_0

    .line 52
    const/4 v2, 0x0

    .line 58
    :goto_0
    return v2

    .line 53
    :cond_0
    if-nez v0, :cond_1

    .line 54
    const/4 v2, 0x1

    goto :goto_0

    .line 55
    :cond_1
    if-nez v1, :cond_2

    .line 56
    const/4 v2, -0x1

    goto :goto_0

    .line 58
    :cond_2
    invoke-virtual {v0, v1}, Ljava/lang/Long;->compareTo(Ljava/lang/Long;)I

    move-result v2

    goto :goto_0
.end method

.method public bridge synthetic compare(Ljava/lang/Object;Ljava/lang/Object;)I
    .locals 1
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 45
    check-cast p1, Lcom/amazon/analytics/util/Message;

    .end local p1    # "x0":Ljava/lang/Object;
    check-cast p2, Lcom/amazon/analytics/util/Message;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/analytics/session/PriorityQueue$1;->compare(Lcom/amazon/analytics/util/Message;Lcom/amazon/analytics/util/Message;)I

    move-result v0

    return v0
.end method
