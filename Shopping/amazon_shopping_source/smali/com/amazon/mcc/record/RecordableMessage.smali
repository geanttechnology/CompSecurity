.class public Lcom/amazon/mcc/record/RecordableMessage;
.super Lcom/amazon/mcc/nps/Message;
.source "RecordableMessage.java"

# interfaces
.implements Lcom/amazon/mcc/record/PropertyMap;


# instance fields
.field private final context:Lcom/amazon/mcc/record/RecordableContext;

.field private final recordable:Lcom/amazon/mcc/record/Recordable;


# direct methods
.method public constructor <init>(Lcom/amazon/mcc/record/Recordable;Lcom/amazon/mcc/record/RecordableContext;)V
    .locals 0
    .param p1, "recordable"    # Lcom/amazon/mcc/record/Recordable;
    .param p2, "context"    # Lcom/amazon/mcc/record/RecordableContext;

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/amazon/mcc/nps/Message;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/amazon/mcc/record/RecordableMessage;->recordable:Lcom/amazon/mcc/record/Recordable;

    .line 31
    iput-object p2, p0, Lcom/amazon/mcc/record/RecordableMessage;->context:Lcom/amazon/mcc/record/RecordableContext;

    .line 32
    return-void
.end method


# virtual methods
.method public containsKey(Ljava/lang/Object;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/amazon/mcc/record/RecordableMessage;->context:Lcom/amazon/mcc/record/RecordableContext;

    invoke-interface {v0}, Lcom/amazon/mcc/record/RecordableContext;->getProperties()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mcc/record/RecordableMessage;->recordable:Lcom/amazon/mcc/record/Recordable;

    invoke-interface {v0}, Lcom/amazon/mcc/record/Recordable;->getProperties()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public get(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "key"    # Ljava/lang/Object;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mcc/record/RecordableMessage;->recordable:Lcom/amazon/mcc/record/Recordable;

    invoke-interface {v0}, Lcom/amazon/mcc/record/Recordable;->getProperties()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 49
    iget-object v0, p0, Lcom/amazon/mcc/record/RecordableMessage;->recordable:Lcom/amazon/mcc/record/Recordable;

    invoke-interface {v0}, Lcom/amazon/mcc/record/Recordable;->getProperties()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 51
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mcc/record/RecordableMessage;->context:Lcom/amazon/mcc/record/RecordableContext;

    invoke-interface {v0}, Lcom/amazon/mcc/record/RecordableContext;->getProperties()Ljava/util/Map;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0
.end method

.method public getAsClass(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;
    .locals 3
    .param p2, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<+",
            "Ljava/lang/Object;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/Object;"
        }
    .end annotation

    .prologue
    .local p1, "cls":Ljava/lang/Class;, "Ljava/lang/Class<+Ljava/lang/Object;>;"
    const/4 v1, 0x0

    .line 91
    invoke-virtual {p0, p2}, Lcom/amazon/mcc/record/RecordableMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 92
    .local v0, "o":Ljava/lang/Object;
    if-nez v0, :cond_1

    move-object v0, v1

    .line 98
    .end local v0    # "o":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-object v0

    .line 95
    .restart local v0    # "o":Ljava/lang/Object;
    :cond_1
    invoke-virtual {p1, v0}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    move-object v0, v1

    .line 98
    goto :goto_0
.end method

.method public keySet()Ljava/util/Set;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 61
    new-instance v0, Ljava/util/HashSet;

    iget-object v1, p0, Lcom/amazon/mcc/record/RecordableMessage;->context:Lcom/amazon/mcc/record/RecordableContext;

    invoke-interface {v1}, Lcom/amazon/mcc/record/RecordableContext;->getProperties()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 62
    .local v0, "ret":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/mcc/record/RecordableMessage;->recordable:Lcom/amazon/mcc/record/Recordable;

    invoke-interface {v1}, Lcom/amazon/mcc/record/Recordable;->getProperties()Ljava/util/Map;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 63
    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 73
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 74
    .local v2, "str":Ljava/lang/StringBuilder;
    const-string/jumbo v3, "PropertyMap:{ "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 75
    invoke-virtual {p0}, Lcom/amazon/mcc/record/RecordableMessage;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 76
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 77
    const-string/jumbo v3, ":"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 78
    invoke-virtual {p0, v1}, Lcom/amazon/mcc/record/RecordableMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    if-nez v3, :cond_0

    .line 79
    const-string/jumbo v3, "null"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 83
    :goto_1
    const-string/jumbo v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 81
    :cond_0
    invoke-virtual {p0, v1}, Lcom/amazon/mcc/record/RecordableMessage;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 85
    .end local v1    # "key":Ljava/lang/String;
    :cond_1
    const-string/jumbo v3, "};"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 86
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method
