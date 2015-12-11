.class Lorg/simpleframework/xml/stream/NodeReader;
.super Ljava/lang/Object;
.source "NodeReader.java"


# instance fields
.field private final reader:Lorg/simpleframework/xml/stream/EventReader;

.field private final stack:Lorg/simpleframework/xml/stream/InputStack;


# direct methods
.method public constructor <init>(Lorg/simpleframework/xml/stream/EventReader;)V
    .locals 1
    .param p1, "reader"    # Lorg/simpleframework/xml/stream/EventReader;

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    new-instance v0, Lorg/simpleframework/xml/stream/InputStack;

    invoke-direct {v0}, Lorg/simpleframework/xml/stream/InputStack;-><init>()V

    iput-object v0, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    .line 55
    iput-object p1, p0, Lorg/simpleframework/xml/stream/NodeReader;->reader:Lorg/simpleframework/xml/stream/EventReader;

    .line 56
    return-void
.end method

.method private isName(Lorg/simpleframework/xml/stream/EventNode;Ljava/lang/String;)Z
    .locals 2
    .param p1, "node"    # Lorg/simpleframework/xml/stream/EventNode;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 188
    invoke-interface {p1}, Lorg/simpleframework/xml/stream/EventNode;->getName()Ljava/lang/String;

    move-result-object v0

    .line 190
    .local v0, "local":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 191
    const/4 v1, 0x0

    .line 193
    :goto_0
    return v1

    :cond_0
    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    goto :goto_0
.end method

.method private readStart(Lorg/simpleframework/xml/stream/InputNode;Lorg/simpleframework/xml/stream/EventNode;)Lorg/simpleframework/xml/stream/InputNode;
    .locals 2
    .param p1, "from"    # Lorg/simpleframework/xml/stream/InputNode;
    .param p2, "event"    # Lorg/simpleframework/xml/stream/EventNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 169
    new-instance v0, Lorg/simpleframework/xml/stream/InputElement;

    invoke-direct {v0, p1, p0, p2}, Lorg/simpleframework/xml/stream/InputElement;-><init>(Lorg/simpleframework/xml/stream/InputNode;Lorg/simpleframework/xml/stream/NodeReader;Lorg/simpleframework/xml/stream/EventNode;)V

    .line 171
    .local v0, "input":Lorg/simpleframework/xml/stream/InputElement;
    invoke-interface {p2}, Lorg/simpleframework/xml/stream/EventNode;->isStart()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 172
    iget-object v1, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v1, v0}, Lorg/simpleframework/xml/stream/InputStack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lorg/simpleframework/xml/stream/InputNode;

    .line 174
    :goto_0
    return-object v1

    :cond_0
    move-object v1, v0

    goto :goto_0
.end method


# virtual methods
.method public isEmpty(Lorg/simpleframework/xml/stream/InputNode;)Z
    .locals 2
    .param p1, "from"    # Lorg/simpleframework/xml/stream/InputNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 239
    iget-object v1, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v1}, Lorg/simpleframework/xml/stream/InputStack;->top()Ljava/lang/Object;

    move-result-object v1

    if-ne v1, p1, :cond_0

    .line 240
    iget-object v1, p0, Lorg/simpleframework/xml/stream/NodeReader;->reader:Lorg/simpleframework/xml/stream/EventReader;

    invoke-interface {v1}, Lorg/simpleframework/xml/stream/EventReader;->peek()Lorg/simpleframework/xml/stream/EventNode;

    move-result-object v0

    .line 242
    .local v0, "event":Lorg/simpleframework/xml/stream/EventNode;
    invoke-interface {v0}, Lorg/simpleframework/xml/stream/EventNode;->isEnd()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 243
    const/4 v1, 0x1

    .line 246
    .end local v0    # "event":Lorg/simpleframework/xml/stream/EventNode;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isRoot(Lorg/simpleframework/xml/stream/InputNode;)Z
    .locals 1
    .param p1, "node"    # Lorg/simpleframework/xml/stream/InputNode;

    .prologue
    .line 67
    iget-object v0, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v0}, Lorg/simpleframework/xml/stream/InputStack;->bottom()Ljava/lang/Object;

    move-result-object v0

    if-ne v0, p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public readElement(Lorg/simpleframework/xml/stream/InputNode;)Lorg/simpleframework/xml/stream/InputNode;
    .locals 3
    .param p1, "from"    # Lorg/simpleframework/xml/stream/InputNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 102
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v2, p1}, Lorg/simpleframework/xml/stream/InputStack;->isRelevant(Lorg/simpleframework/xml/stream/InputNode;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 117
    :cond_0
    :goto_0
    return-object v1

    .line 105
    :cond_1
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->reader:Lorg/simpleframework/xml/stream/EventReader;

    invoke-interface {v2}, Lorg/simpleframework/xml/stream/EventReader;->next()Lorg/simpleframework/xml/stream/EventNode;

    move-result-object v0

    .line 107
    .local v0, "event":Lorg/simpleframework/xml/stream/EventNode;
    :goto_1
    if-eqz v0, :cond_0

    .line 108
    invoke-interface {v0}, Lorg/simpleframework/xml/stream/EventNode;->isEnd()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 109
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v2}, Lorg/simpleframework/xml/stream/InputStack;->pop()Ljava/lang/Object;

    move-result-object v2

    if-eq v2, p1, :cond_0

    .line 115
    :cond_2
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->reader:Lorg/simpleframework/xml/stream/EventReader;

    invoke-interface {v2}, Lorg/simpleframework/xml/stream/EventReader;->next()Lorg/simpleframework/xml/stream/EventNode;

    move-result-object v0

    goto :goto_1

    .line 112
    :cond_3
    invoke-interface {v0}, Lorg/simpleframework/xml/stream/EventNode;->isStart()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 113
    invoke-direct {p0, p1, v0}, Lorg/simpleframework/xml/stream/NodeReader;->readStart(Lorg/simpleframework/xml/stream/InputNode;Lorg/simpleframework/xml/stream/EventNode;)Lorg/simpleframework/xml/stream/InputNode;

    move-result-object v1

    goto :goto_0
.end method

.method public readElement(Lorg/simpleframework/xml/stream/InputNode;Ljava/lang/String;)Lorg/simpleframework/xml/stream/InputNode;
    .locals 3
    .param p1, "from"    # Lorg/simpleframework/xml/stream/InputNode;
    .param p2, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 133
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v2, p1}, Lorg/simpleframework/xml/stream/InputStack;->isRelevant(Lorg/simpleframework/xml/stream/InputNode;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 154
    :cond_0
    :goto_0
    return-object v1

    .line 136
    :cond_1
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->reader:Lorg/simpleframework/xml/stream/EventReader;

    invoke-interface {v2}, Lorg/simpleframework/xml/stream/EventReader;->peek()Lorg/simpleframework/xml/stream/EventNode;

    move-result-object v0

    .line 138
    .local v0, "event":Lorg/simpleframework/xml/stream/EventNode;
    :goto_1
    if-eqz v0, :cond_0

    .line 139
    invoke-interface {v0}, Lorg/simpleframework/xml/stream/EventNode;->isEnd()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 140
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v2}, Lorg/simpleframework/xml/stream/InputStack;->top()Ljava/lang/Object;

    move-result-object v2

    if-eq v2, p1, :cond_0

    .line 143
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v2}, Lorg/simpleframework/xml/stream/InputStack;->pop()Ljava/lang/Object;

    .line 151
    :cond_2
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->reader:Lorg/simpleframework/xml/stream/EventReader;

    invoke-interface {v2}, Lorg/simpleframework/xml/stream/EventReader;->next()Lorg/simpleframework/xml/stream/EventNode;

    move-result-object v0

    .line 152
    iget-object v2, p0, Lorg/simpleframework/xml/stream/NodeReader;->reader:Lorg/simpleframework/xml/stream/EventReader;

    invoke-interface {v2}, Lorg/simpleframework/xml/stream/EventReader;->peek()Lorg/simpleframework/xml/stream/EventNode;

    move-result-object v0

    goto :goto_1

    .line 145
    :cond_3
    invoke-interface {v0}, Lorg/simpleframework/xml/stream/EventNode;->isStart()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 146
    invoke-direct {p0, v0, p2}, Lorg/simpleframework/xml/stream/NodeReader;->isName(Lorg/simpleframework/xml/stream/EventNode;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 147
    invoke-virtual {p0, p1}, Lorg/simpleframework/xml/stream/NodeReader;->readElement(Lorg/simpleframework/xml/stream/InputNode;)Lorg/simpleframework/xml/stream/InputNode;

    move-result-object v1

    goto :goto_0
.end method

.method public readRoot()Lorg/simpleframework/xml/stream/InputNode;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 78
    iget-object v1, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v1}, Lorg/simpleframework/xml/stream/InputStack;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 79
    invoke-virtual {p0, v0}, Lorg/simpleframework/xml/stream/NodeReader;->readElement(Lorg/simpleframework/xml/stream/InputNode;)Lorg/simpleframework/xml/stream/InputNode;

    move-result-object v0

    .line 81
    .local v0, "node":Lorg/simpleframework/xml/stream/InputNode;
    if-nez v0, :cond_0

    .line 82
    new-instance v1, Lorg/simpleframework/xml/stream/NodeException;

    const-string v2, "Document has no root element"

    invoke-direct {v1, v2}, Lorg/simpleframework/xml/stream/NodeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 86
    .end local v0    # "node":Lorg/simpleframework/xml/stream/InputNode;
    :cond_0
    return-object v0
.end method

.method public readValue(Lorg/simpleframework/xml/stream/InputNode;)Ljava/lang/String;
    .locals 5
    .param p1, "from"    # Lorg/simpleframework/xml/stream/InputNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 207
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 209
    .local v2, "value":Ljava/lang/StringBuilder;
    :goto_0
    iget-object v4, p0, Lorg/simpleframework/xml/stream/NodeReader;->stack:Lorg/simpleframework/xml/stream/InputStack;

    invoke-virtual {v4}, Lorg/simpleframework/xml/stream/InputStack;->top()Ljava/lang/Object;

    move-result-object v4

    if-ne v4, p1, :cond_0

    .line 210
    iget-object v4, p0, Lorg/simpleframework/xml/stream/NodeReader;->reader:Lorg/simpleframework/xml/stream/EventReader;

    invoke-interface {v4}, Lorg/simpleframework/xml/stream/EventReader;->peek()Lorg/simpleframework/xml/stream/EventNode;

    move-result-object v1

    .line 212
    .local v1, "event":Lorg/simpleframework/xml/stream/EventNode;
    invoke-interface {v1}, Lorg/simpleframework/xml/stream/EventNode;->isText()Z

    move-result v4

    if-nez v4, :cond_2

    .line 213
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    if-nez v4, :cond_1

    .line 223
    .end local v1    # "event":Lorg/simpleframework/xml/stream/EventNode;
    :cond_0
    :goto_1
    return-object v3

    .line 216
    .restart local v1    # "event":Lorg/simpleframework/xml/stream/EventNode;
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    goto :goto_1

    .line 218
    :cond_2
    invoke-interface {v1}, Lorg/simpleframework/xml/stream/EventNode;->getValue()Ljava/lang/String;

    move-result-object v0

    .line 220
    .local v0, "data":Ljava/lang/String;
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 221
    iget-object v4, p0, Lorg/simpleframework/xml/stream/NodeReader;->reader:Lorg/simpleframework/xml/stream/EventReader;

    invoke-interface {v4}, Lorg/simpleframework/xml/stream/EventReader;->next()Lorg/simpleframework/xml/stream/EventNode;

    goto :goto_0
.end method

.method public skipElement(Lorg/simpleframework/xml/stream/InputNode;)V
    .locals 1
    .param p1, "from"    # Lorg/simpleframework/xml/stream/InputNode;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 258
    :cond_0
    invoke-virtual {p0, p1}, Lorg/simpleframework/xml/stream/NodeReader;->readElement(Lorg/simpleframework/xml/stream/InputNode;)Lorg/simpleframework/xml/stream/InputNode;

    move-result-object v0

    if-nez v0, :cond_0

    .line 259
    return-void
.end method
