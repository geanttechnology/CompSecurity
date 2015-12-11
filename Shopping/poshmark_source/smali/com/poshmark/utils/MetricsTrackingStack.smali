.class public Lcom/poshmark/utils/MetricsTrackingStack;
.super Ljava/lang/Object;
.source "MetricsTrackingStack.java"


# static fields
.field private static final metricsStack:Lcom/poshmark/utils/MetricsTrackingStack;


# instance fields
.field MAX_SIZE:I

.field count:I

.field currentScreensInStack:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/util/UUID;",
            ">;"
        }
    .end annotation
.end field

.field stack:Ljava/util/Deque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Deque",
            "<",
            "Lcom/poshmark/utils/VisitedScreen;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    new-instance v0, Lcom/poshmark/utils/MetricsTrackingStack;

    invoke-direct {v0}, Lcom/poshmark/utils/MetricsTrackingStack;-><init>()V

    sput-object v0, Lcom/poshmark/utils/MetricsTrackingStack;->metricsStack:Lcom/poshmark/utils/MetricsTrackingStack;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/16 v0, 0xa

    iput v0, p0, Lcom/poshmark/utils/MetricsTrackingStack;->MAX_SIZE:I

    .line 16
    const/4 v0, 0x0

    iput v0, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    .line 17
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/MetricsTrackingStack;->stack:Ljava/util/Deque;

    .line 18
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/poshmark/utils/MetricsTrackingStack;->currentScreensInStack:Ljava/util/Set;

    .line 23
    return-void
.end method


# virtual methods
.method public addToEndOfStack(Ljava/util/UUID;Ljava/lang/String;)V
    .locals 2
    .param p1, "fragmentId"    # Ljava/util/UUID;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 68
    invoke-virtual {p0, p1}, Lcom/poshmark/utils/MetricsTrackingStack;->removeFromStack(Ljava/util/UUID;)V

    .line 69
    new-instance v0, Lcom/poshmark/utils/VisitedScreen;

    invoke-direct {v0, p1, p2}, Lcom/poshmark/utils/VisitedScreen;-><init>(Ljava/util/UUID;Ljava/lang/String;)V

    .line 70
    .local v0, "screen":Lcom/poshmark/utils/VisitedScreen;
    iget-object v1, p0, Lcom/poshmark/utils/MetricsTrackingStack;->currentScreensInStack:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 71
    iget-object v1, p0, Lcom/poshmark/utils/MetricsTrackingStack;->stack:Ljava/util/Deque;

    invoke-interface {v1, v0}, Ljava/util/Deque;->addLast(Ljava/lang/Object;)V

    .line 72
    iget v1, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    .line 73
    return-void
.end method

.method public addToStack(Ljava/util/UUID;Ljava/lang/String;)V
    .locals 4
    .param p1, "id"    # Ljava/util/UUID;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 29
    iget-object v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->currentScreensInStack:Ljava/util/Set;

    invoke-interface {v2, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 30
    iget v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    iget v3, p0, Lcom/poshmark/utils/MetricsTrackingStack;->MAX_SIZE:I

    if-ne v2, v3, :cond_0

    .line 32
    iget-object v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->stack:Ljava/util/Deque;

    invoke-interface {v2}, Ljava/util/Deque;->removeLast()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/VisitedScreen;

    .line 33
    .local v0, "lastScreen":Lcom/poshmark/utils/VisitedScreen;
    iget-object v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->currentScreensInStack:Ljava/util/Set;

    iget-object v3, v0, Lcom/poshmark/utils/VisitedScreen;->fragmentID:Ljava/util/UUID;

    invoke-interface {v2, v3}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 34
    iget v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    .line 36
    .end local v0    # "lastScreen":Lcom/poshmark/utils/VisitedScreen;
    :cond_0
    new-instance v1, Lcom/poshmark/utils/VisitedScreen;

    invoke-direct {v1, p1, p2}, Lcom/poshmark/utils/VisitedScreen;-><init>(Ljava/util/UUID;Ljava/lang/String;)V

    .line 37
    .local v1, "screen":Lcom/poshmark/utils/VisitedScreen;
    iget-object v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->stack:Ljava/util/Deque;

    invoke-interface {v2, v1}, Ljava/util/Deque;->addFirst(Ljava/lang/Object;)V

    .line 38
    iget-object v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->currentScreensInStack:Ljava/util/Set;

    invoke-interface {v2, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 39
    iget v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    .line 41
    .end local v1    # "screen":Lcom/poshmark/utils/VisitedScreen;
    :cond_1
    return-void
.end method

.method public clearStack()V
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/poshmark/utils/MetricsTrackingStack;->stack:Ljava/util/Deque;

    invoke-interface {v0}, Ljava/util/Deque;->clear()V

    .line 48
    iget-object v0, p0, Lcom/poshmark/utils/MetricsTrackingStack;->currentScreensInStack:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 49
    return-void
.end method

.method public isOnStack()Z
    .locals 1

    .prologue
    .line 42
    const/4 v0, 0x0

    return v0
.end method

.method public removeFromStack(Ljava/util/UUID;)V
    .locals 4
    .param p1, "fragmentId"    # Ljava/util/UUID;

    .prologue
    .line 53
    iget-object v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->currentScreensInStack:Ljava/util/Set;

    invoke-interface {v2, p1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 54
    iget-object v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->stack:Ljava/util/Deque;

    invoke-interface {v2}, Ljava/util/Deque;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 55
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/utils/VisitedScreen;>;"
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 56
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/utils/VisitedScreen;

    .line 57
    .local v1, "screen":Lcom/poshmark/utils/VisitedScreen;
    iget-object v2, v1, Lcom/poshmark/utils/VisitedScreen;->fragmentID:Ljava/util/UUID;

    if-ne v2, p1, :cond_0

    .line 58
    invoke-interface {v0}, Ljava/util/Iterator;->remove()V

    .line 59
    iget-object v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->currentScreensInStack:Ljava/util/Set;

    iget-object v3, v1, Lcom/poshmark/utils/VisitedScreen;->fragmentID:Ljava/util/UUID;

    invoke-interface {v2, v3}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 60
    iget v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/poshmark/utils/MetricsTrackingStack;->count:I

    .line 65
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/utils/VisitedScreen;>;"
    .end local v1    # "screen":Lcom/poshmark/utils/VisitedScreen;
    :cond_1
    return-void
.end method

.method public serializeStack()Ljava/lang/String;
    .locals 1

    .prologue
    .line 44
    const/4 v0, 0x0

    return-object v0
.end method
