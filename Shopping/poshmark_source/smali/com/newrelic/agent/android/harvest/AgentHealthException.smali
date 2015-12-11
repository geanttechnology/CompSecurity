.class public Lcom/newrelic/agent/android/harvest/AgentHealthException;
.super Lcom/newrelic/agent/android/harvest/type/HarvestableArray;
.source "AgentHealthException.java"


# instance fields
.field private final count:Ljava/util/concurrent/atomic/AtomicLong;

.field private exceptionClass:Ljava/lang/String;

.field private extras:Ljava/util/Map;
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

.field private message:Ljava/lang/String;

.field private stackTrace:[Ljava/lang/StackTraceElement;

.field private threadName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 24
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/newrelic/agent/android/harvest/AgentHealthException;-><init>(Ljava/lang/Exception;Ljava/lang/String;)V

    .line 25
    return-void
.end method

.method public constructor <init>(Ljava/lang/Exception;Ljava/lang/String;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "threadName"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Exception;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v2

    invoke-direct {p0, v0, v1, p2, v2}, Lcom/newrelic/agent/android/harvest/AgentHealthException;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/StackTraceElement;)V

    .line 29
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/StackTraceElement;)V
    .locals 6
    .param p1, "exceptionClass"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "threadName"    # Ljava/lang/String;
    .param p4, "stackTrace"    # [Ljava/lang/StackTraceElement;

    .prologue
    .line 32
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    invoke-direct/range {v0 .. v5}, Lcom/newrelic/agent/android/harvest/AgentHealthException;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/StackTraceElement;Ljava/util/Map;)V

    .line 33
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/StackTraceElement;Ljava/util/Map;)V
    .locals 4
    .param p1, "exceptionClass"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;
    .param p3, "threadName"    # Ljava/lang/String;
    .param p4, "stackTrace"    # [Ljava/lang/StackTraceElement;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/StackTraceElement;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p5, "extras":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableArray;-><init>()V

    .line 20
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    const-wide/16 v2, 0x1

    invoke-direct {v0, v2, v3}, Ljava/util/concurrent/atomic/AtomicLong;-><init>(J)V

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->count:Ljava/util/concurrent/atomic/AtomicLong;

    .line 38
    iput-object p1, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->exceptionClass:Ljava/lang/String;

    .line 39
    iput-object p2, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->message:Ljava/lang/String;

    .line 40
    iput-object p3, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->threadName:Ljava/lang/String;

    .line 41
    iput-object p4, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->stackTrace:[Ljava/lang/StackTraceElement;

    .line 42
    iput-object p5, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->extras:Ljava/util/Map;

    .line 43
    return-void
.end method

.method private extrasToJson()Lcom/newrelic/com/google/gson/JsonObject;
    .locals 5

    .prologue
    .line 110
    new-instance v0, Lcom/newrelic/com/google/gson/JsonObject;

    invoke-direct {v0}, Lcom/newrelic/com/google/gson/JsonObject;-><init>()V

    .line 112
    .local v0, "data":Lcom/newrelic/com/google/gson/JsonObject;
    iget-object v3, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->extras:Ljava/util/Map;

    if-eqz v3, :cond_0

    .line 113
    iget-object v3, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->extras:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/Map$Entry;

    .line 114
    .local v1, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-static {v4}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    goto :goto_0

    .line 118
    .end local v1    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_0
    return-object v0
.end method

.method private stackTraceToJson()Lcom/newrelic/com/google/gson/JsonArray;
    .locals 6

    .prologue
    .line 100
    new-instance v4, Lcom/newrelic/com/google/gson/JsonArray;

    invoke-direct {v4}, Lcom/newrelic/com/google/gson/JsonArray;-><init>()V

    .line 102
    .local v4, "stack":Lcom/newrelic/com/google/gson/JsonArray;
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->stackTrace:[Ljava/lang/StackTraceElement;

    .local v0, "arr$":[Ljava/lang/StackTraceElement;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 103
    .local v1, "element":Ljava/lang/StackTraceElement;
    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 102
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 106
    .end local v1    # "element":Ljava/lang/StackTraceElement;
    :cond_0
    return-object v4
.end method


# virtual methods
.method public asJsonArray()Lcom/newrelic/com/google/gson/JsonArray;
    .locals 4

    .prologue
    .line 87
    new-instance v0, Lcom/newrelic/com/google/gson/JsonArray;

    invoke-direct {v0}, Lcom/newrelic/com/google/gson/JsonArray;-><init>()V

    .line 89
    .local v0, "data":Lcom/newrelic/com/google/gson/JsonArray;
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->exceptionClass:Ljava/lang/String;

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 90
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->message:Ljava/lang/String;

    if-nez v1, :cond_0

    const-string v1, ""

    :goto_0
    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 91
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->threadName:Ljava/lang/String;

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 92
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/AgentHealthException;->stackTraceToJson()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 93
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->count:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v1}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 94
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/AgentHealthException;->extrasToJson()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 96
    return-object v0

    .line 90
    :cond_0
    iget-object v1, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->message:Ljava/lang/String;

    goto :goto_0
.end method

.method public getCount()J
    .locals 2

    .prologue
    .line 70
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->count:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v0

    return-wide v0
.end method

.method public getExceptionClass()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->exceptionClass:Ljava/lang/String;

    return-object v0
.end method

.method public getExtras()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 74
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->extras:Ljava/util/Map;

    return-object v0
.end method

.method public getMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->message:Ljava/lang/String;

    return-object v0
.end method

.method public getSourceClass()Ljava/lang/String;
    .locals 2

    .prologue
    .line 78
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->stackTrace:[Ljava/lang/StackTraceElement;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSourceMethod()Ljava/lang/String;
    .locals 2

    .prologue
    .line 82
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->stackTrace:[Ljava/lang/StackTraceElement;

    const/4 v1, 0x0

    aget-object v0, v0, v1

    invoke-virtual {v0}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getStackTrace()[Ljava/lang/StackTraceElement;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->stackTrace:[Ljava/lang/StackTraceElement;

    return-object v0
.end method

.method public getThreadName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->threadName:Ljava/lang/String;

    return-object v0
.end method

.method public increment()V
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->count:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicLong;->getAndIncrement()J

    .line 47
    return-void
.end method

.method public increment(J)V
    .locals 1
    .param p1, "i"    # J

    .prologue
    .line 50
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/AgentHealthException;->count:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v0, p1, p2}, Ljava/util/concurrent/atomic/AtomicLong;->getAndAdd(J)J

    .line 51
    return-void
.end method
