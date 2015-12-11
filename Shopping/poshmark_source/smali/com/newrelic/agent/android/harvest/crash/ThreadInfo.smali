.class public Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;
.super Lcom/newrelic/agent/android/harvest/type/HarvestableObject;
.source "ThreadInfo.java"


# instance fields
.field private crashed:Z

.field private stackTrace:[Ljava/lang/StackTraceElement;

.field private state:Ljava/lang/String;

.field private threadId:J

.field private threadName:Ljava/lang/String;

.field private threadPriority:I


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableObject;-><init>()V

    .line 28
    return-void
.end method

.method public constructor <init>(Ljava/lang/Thread;[Ljava/lang/StackTraceElement;)V
    .locals 2
    .param p1, "thread"    # Ljava/lang/Thread;
    .param p2, "stackTrace"    # [Ljava/lang/StackTraceElement;

    .prologue
    .line 44
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableObject;-><init>()V

    .line 46
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->crashed:Z

    .line 47
    invoke-virtual {p1}, Ljava/lang/Thread;->getId()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadId:J

    .line 48
    invoke-virtual {p1}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadName:Ljava/lang/String;

    .line 49
    invoke-virtual {p1}, Ljava/lang/Thread;->getPriority()I

    move-result v0

    iput v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadPriority:I

    .line 50
    iput-object p2, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->stackTrace:[Ljava/lang/StackTraceElement;

    .line 51
    invoke-virtual {p1}, Ljava/lang/Thread;->getState()Ljava/lang/Thread$State;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread$State;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->state:Ljava/lang/String;

    .line 52
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 2
    .param p1, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/type/HarvestableObject;-><init>()V

    .line 35
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->crashed:Z

    .line 36
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getId()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadId:J

    .line 37
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadName:Ljava/lang/String;

    .line 38
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getPriority()I

    move-result v0

    iput v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadPriority:I

    .line 39
    invoke-virtual {p1}, Ljava/lang/Throwable;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->stackTrace:[Ljava/lang/StackTraceElement;

    .line 40
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->getState()Ljava/lang/Thread$State;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread$State;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->state:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public static extractThreads(Ljava/lang/Throwable;)Ljava/util/List;
    .locals 10
    .param p0, "throwable"    # Ljava/lang/Throwable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 59
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 60
    .local v7, "threads":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;>;"
    new-instance v0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;

    invoke-direct {v0, p0}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;-><init>(Ljava/lang/Throwable;)V

    .line 61
    .local v0, "crashedThread":Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;
    invoke-virtual {v0}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->getThreadId()J

    move-result-wide v2

    .line 63
    .local v2, "crashedThreadId":J
    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 65
    invoke-static {}, Ljava/lang/Thread;->getAllStackTraces()Ljava/util/Map;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/Map$Entry;

    .line 66
    .local v5, "threadEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Thread;[Ljava/lang/StackTraceElement;>;"
    invoke-interface {v5}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Thread;

    .line 67
    .local v4, "thread":Ljava/lang/Thread;
    invoke-interface {v5}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Ljava/lang/StackTraceElement;

    .line 69
    .local v6, "threadStackTrace":[Ljava/lang/StackTraceElement;
    invoke-virtual {v4}, Ljava/lang/Thread;->getId()J

    move-result-wide v8

    cmp-long v8, v8, v2

    if-eqz v8, :cond_0

    .line 70
    new-instance v8, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;

    invoke-direct {v8, v4, v6}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;-><init>(Ljava/lang/Thread;[Ljava/lang/StackTraceElement;)V

    invoke-interface {v7, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 74
    .end local v4    # "thread":Ljava/lang/Thread;
    .end local v5    # "threadEntry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Thread;[Ljava/lang/StackTraceElement;>;"
    .end local v6    # "threadStackTrace":[Ljava/lang/StackTraceElement;
    :cond_1
    return-object v7
.end method

.method private getStackAsJson()Lcom/newrelic/com/google/gson/JsonArray;
    .locals 8

    .prologue
    .line 139
    new-instance v1, Lcom/newrelic/com/google/gson/JsonArray;

    invoke-direct {v1}, Lcom/newrelic/com/google/gson/JsonArray;-><init>()V

    .line 141
    .local v1, "data":Lcom/newrelic/com/google/gson/JsonArray;
    iget-object v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->stackTrace:[Ljava/lang/StackTraceElement;

    .local v0, "arr$":[Ljava/lang/StackTraceElement;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v4, 0x0

    .local v4, "i$":I
    :goto_0
    if-ge v4, v5, :cond_1

    aget-object v2, v0, v4

    .line 142
    .local v2, "element":Ljava/lang/StackTraceElement;
    new-instance v3, Lcom/newrelic/com/google/gson/JsonObject;

    invoke-direct {v3}, Lcom/newrelic/com/google/gson/JsonObject;-><init>()V

    .line 144
    .local v3, "elementJson":Lcom/newrelic/com/google/gson/JsonObject;
    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v6

    if-eqz v6, :cond_0

    .line 145
    const-string v6, "fileName"

    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getFileName()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 148
    :cond_0
    const-string v6, "className"

    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 149
    const-string v6, "methodName"

    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 150
    const-string v6, "lineNumber"

    invoke-virtual {v2}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-static {v7}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v7

    invoke-virtual {v3, v6, v7}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 152
    invoke-virtual {v1, v3}, Lcom/newrelic/com/google/gson/JsonArray;->add(Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 141
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 155
    .end local v2    # "element":Ljava/lang/StackTraceElement;
    .end local v3    # "elementJson":Lcom/newrelic/com/google/gson/JsonObject;
    :cond_1
    return-object v1
.end method

.method public static newFromJson(Lcom/newrelic/com/google/gson/JsonObject;)Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;
    .locals 4
    .param p0, "jsonObject"    # Lcom/newrelic/com/google/gson/JsonObject;

    .prologue
    .line 92
    new-instance v0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;

    invoke-direct {v0}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;-><init>()V

    .line 94
    .local v0, "info":Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;
    const-string v1, "crashed"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsBoolean()Z

    move-result v1

    iput-boolean v1, v0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->crashed:Z

    .line 95
    const-string v1, "state"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->state:Ljava/lang/String;

    .line 96
    const-string v1, "threadNumber"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsLong()J

    move-result-wide v2

    iput-wide v2, v0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadId:J

    .line 97
    const-string v1, "threadId"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadName:Ljava/lang/String;

    .line 98
    const-string v1, "priority"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsInt()I

    move-result v1

    iput v1, v0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadPriority:I

    .line 99
    const-string v1, "stack"

    invoke-virtual {p0, v1}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v1

    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonArray()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v1

    invoke-static {v1}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->stackTraceFromJson(Lcom/newrelic/com/google/gson/JsonArray;)[Ljava/lang/StackTraceElement;

    move-result-object v1

    iput-object v1, v0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->stackTrace:[Ljava/lang/StackTraceElement;

    .line 101
    return-object v0
.end method

.method public static newListFromJson(Lcom/newrelic/com/google/gson/JsonArray;)Ljava/util/List;
    .locals 4
    .param p0, "jsonArray"    # Lcom/newrelic/com/google/gson/JsonArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/newrelic/com/google/gson/JsonArray;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 129
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 131
    .local v2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;>;"
    invoke-virtual {p0}, Lcom/newrelic/com/google/gson/JsonArray;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/newrelic/com/google/gson/JsonElement;

    .line 132
    .local v1, "jsonElement":Lcom/newrelic/com/google/gson/JsonElement;
    invoke-virtual {v1}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v3

    invoke-static {v3}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->newFromJson(Lcom/newrelic/com/google/gson/JsonObject;)Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 135
    .end local v1    # "jsonElement":Lcom/newrelic/com/google/gson/JsonElement;
    :cond_0
    return-object v2
.end method

.method public static stackTraceFromJson(Lcom/newrelic/com/google/gson/JsonArray;)[Ljava/lang/StackTraceElement;
    .locals 12
    .param p0, "jsonArray"    # Lcom/newrelic/com/google/gson/JsonArray;

    .prologue
    .line 105
    invoke-virtual {p0}, Lcom/newrelic/com/google/gson/JsonArray;->size()I

    move-result v10

    new-array v8, v10, [Ljava/lang/StackTraceElement;

    .line 106
    .local v8, "stack":[Ljava/lang/StackTraceElement;
    const/4 v2, 0x0

    .line 108
    .local v2, "i":I
    invoke-virtual {p0}, Lcom/newrelic/com/google/gson/JsonArray;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/newrelic/com/google/gson/JsonElement;

    .line 109
    .local v5, "jsonElement":Lcom/newrelic/com/google/gson/JsonElement;
    const-string v1, "unknown"

    .line 111
    .local v1, "fileName":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v10

    const-string v11, "fileName"

    invoke-virtual {v10, v11}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v10

    if-eqz v10, :cond_0

    .line 112
    invoke-virtual {v5}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v10

    const-string v11, "fileName"

    invoke-virtual {v10, v11}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v10

    invoke-virtual {v10}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v1

    .line 115
    :cond_0
    invoke-virtual {v5}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v10

    const-string v11, "className"

    invoke-virtual {v10, v11}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v10

    invoke-virtual {v10}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v0

    .line 116
    .local v0, "className":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v10

    const-string v11, "methodName"

    invoke-virtual {v10, v11}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v10

    invoke-virtual {v10}, Lcom/newrelic/com/google/gson/JsonElement;->getAsString()Ljava/lang/String;

    move-result-object v7

    .line 117
    .local v7, "methodName":Ljava/lang/String;
    invoke-virtual {v5}, Lcom/newrelic/com/google/gson/JsonElement;->getAsJsonObject()Lcom/newrelic/com/google/gson/JsonObject;

    move-result-object v10

    const-string v11, "lineNumber"

    invoke-virtual {v10, v11}, Lcom/newrelic/com/google/gson/JsonObject;->get(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonElement;

    move-result-object v10

    invoke-virtual {v10}, Lcom/newrelic/com/google/gson/JsonElement;->getAsInt()I

    move-result v6

    .line 119
    .local v6, "lineNumber":I
    new-instance v9, Ljava/lang/StackTraceElement;

    invoke-direct {v9, v0, v7, v1, v6}, Ljava/lang/StackTraceElement;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 121
    .local v9, "stackTraceElement":Ljava/lang/StackTraceElement;
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "i":I
    .local v3, "i":I
    aput-object v9, v8, v2

    move v2, v3

    .line 122
    .end local v3    # "i":I
    .restart local v2    # "i":I
    goto :goto_0

    .line 124
    .end local v0    # "className":Ljava/lang/String;
    .end local v1    # "fileName":Ljava/lang/String;
    .end local v5    # "jsonElement":Lcom/newrelic/com/google/gson/JsonElement;
    .end local v6    # "lineNumber":I
    .end local v7    # "methodName":Ljava/lang/String;
    .end local v9    # "stackTraceElement":Ljava/lang/StackTraceElement;
    :cond_1
    return-object v8
.end method


# virtual methods
.method public asJsonObject()Lcom/newrelic/com/google/gson/JsonObject;
    .locals 4

    .prologue
    .line 79
    new-instance v0, Lcom/newrelic/com/google/gson/JsonObject;

    invoke-direct {v0}, Lcom/newrelic/com/google/gson/JsonObject;-><init>()V

    .line 81
    .local v0, "data":Lcom/newrelic/com/google/gson/JsonObject;
    const-string v1, "crashed"

    iget-boolean v2, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->crashed:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Boolean;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 82
    const-string v1, "state"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->state:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 83
    const-string v1, "threadNumber"

    iget-wide v2, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 84
    const-string v1, "threadId"

    iget-object v2, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadName:Ljava/lang/String;

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/String;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 85
    const-string v1, "priority"

    iget v2, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadPriority:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v2}, Lcom/newrelic/agent/android/util/SafeJsonPrimitive;->factory(Ljava/lang/Number;)Lcom/newrelic/com/google/gson/JsonPrimitive;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 86
    const-string v1, "stack"

    invoke-direct {p0}, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->getStackAsJson()Lcom/newrelic/com/google/gson/JsonArray;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/newrelic/com/google/gson/JsonObject;->add(Ljava/lang/String;Lcom/newrelic/com/google/gson/JsonElement;)V

    .line 88
    return-object v0
.end method

.method public getThreadId()J
    .locals 2

    .prologue
    .line 55
    iget-wide v0, p0, Lcom/newrelic/agent/android/harvest/crash/ThreadInfo;->threadId:J

    return-wide v0
.end method
