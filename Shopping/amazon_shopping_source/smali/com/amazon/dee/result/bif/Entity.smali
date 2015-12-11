.class public Lcom/amazon/dee/result/bif/Entity;
.super Ljava/lang/Object;
.source "Entity.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mName:Ljava/lang/String;

.field private mResolvedEntities:Lcom/amazon/dee/result/bif/ResolvedEntities;

.field private mTokenSpan:Lcom/amazon/dee/result/bif/Span;

.field private mTokens:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;"
        }
    .end annotation
.end field

.field private mValue:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v1, 0x0

    .line 118
    move-object v0, p0

    move-object v2, v1

    move-object v3, v1

    move-object v4, v1

    move-object v5, v1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/Entity;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/dee/result/bif/Span;Ljava/util/List;Lcom/amazon/dee/result/bif/ResolvedEntities;)V

    .line 119
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    const/4 v3, 0x0

    .line 79
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, v3

    move-object v5, v3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/Entity;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/dee/result/bif/Span;Ljava/util/List;Lcom/amazon/dee/result/bif/ResolvedEntities;)V

    .line 80
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/dee/result/bif/Span;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "span"    # Lcom/amazon/dee/result/bif/Span;

    .prologue
    const/4 v4, 0x0

    .line 95
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/Entity;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/dee/result/bif/Span;Ljava/util/List;Lcom/amazon/dee/result/bif/ResolvedEntities;)V

    .line 96
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/dee/result/bif/Span;Ljava/util/List;Lcom/amazon/dee/result/bif/ResolvedEntities;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "span"    # Lcom/amazon/dee/result/bif/Span;
    .param p5, "resolvedEntities"    # Lcom/amazon/dee/result/bif/ResolvedEntities;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/dee/result/bif/Span;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;",
            "Lcom/amazon/dee/result/bif/ResolvedEntities;",
            ")V"
        }
    .end annotation

    .prologue
    .line 57
    .local p4, "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Entity;->mName:Ljava/lang/String;

    .line 59
    iput-object p2, p0, Lcom/amazon/dee/result/bif/Entity;->mValue:Ljava/lang/String;

    .line 60
    iput-object p3, p0, Lcom/amazon/dee/result/bif/Entity;->mTokenSpan:Lcom/amazon/dee/result/bif/Span;

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    .line 62
    if-eqz p4, :cond_0

    .line 64
    invoke-virtual {p0, p4}, Lcom/amazon/dee/result/bif/Entity;->addTokens(Ljava/util/List;)V

    .line 66
    :cond_0
    iput-object p5, p0, Lcom/amazon/dee/result/bif/Entity;->mResolvedEntities:Lcom/amazon/dee/result/bif/ResolvedEntities;

    .line 67
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    const/4 v3, 0x0

    .line 110
    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p3

    move-object v5, v3

    invoke-direct/range {v0 .. v5}, Lcom/amazon/dee/result/bif/Entity;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/dee/result/bif/Span;Ljava/util/List;Lcom/amazon/dee/result/bif/ResolvedEntities;)V

    .line 111
    return-void
.end method


# virtual methods
.method public final addToken(Lcom/amazon/dee/result/bif/Token;)V
    .locals 1
    .param p1, "token"    # Lcom/amazon/dee/result/bif/Token;

    .prologue
    .line 251
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 252
    return-void
.end method

.method public final addTokens(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 262
    .local p1, "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 263
    return-void
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x0

    .line 124
    instance-of v2, p1, Lcom/amazon/dee/result/bif/Entity;

    if-eqz v2, :cond_0

    move-object v0, p1

    .line 126
    check-cast v0, Lcom/amazon/dee/result/bif/Entity;

    .line 127
    .local v0, "other":Lcom/amazon/dee/result/bif/Entity;
    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mName:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Entity;->mName:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mValue:Ljava/lang/String;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Entity;->mValue:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mTokenSpan:Lcom/amazon/dee/result/bif/Span;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Entity;->mTokenSpan:Lcom/amazon/dee/result/bif/Span;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mResolvedEntities:Lcom/amazon/dee/result/bif/ResolvedEntities;

    iget-object v3, v0, Lcom/amazon/dee/result/bif/Entity;->mResolvedEntities:Lcom/amazon/dee/result/bif/ResolvedEntities;

    invoke-static {v2, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 135
    .end local v0    # "other":Lcom/amazon/dee/result/bif/Entity;
    :cond_0
    return v1
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Entity;->mName:Ljava/lang/String;

    return-object v0
.end method

.method public final getResolvedEntities()Lcom/amazon/dee/result/bif/ResolvedEntities;
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Entity;->mResolvedEntities:Lcom/amazon/dee/result/bif/ResolvedEntities;

    return-object v0
.end method

.method public getSpan()Lcom/amazon/dee/result/bif/Span;
    .locals 1

    .prologue
    .line 194
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Entity;->mTokenSpan:Lcom/amazon/dee/result/bif/Span;

    return-object v0
.end method

.method public final getTokens()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;"
        }
    .end annotation

    .prologue
    .line 272
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    return-object v0
.end method

.method public getTokens(Lcom/amazon/dee/result/bif/Intent;)Ljava/util/List;
    .locals 4
    .param p1, "parent"    # Lcom/amazon/dee/result/bif/Intent;
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/dee/result/bif/Intent;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;"
        }
    .end annotation

    .prologue
    .line 231
    if-eqz p1, :cond_0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mTokenSpan:Lcom/amazon/dee/result/bif/Span;

    if-nez v2, :cond_1

    .line 233
    :cond_0
    const/4 v2, 0x0

    .line 239
    :goto_0
    return-object v2

    .line 237
    :cond_1
    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mTokenSpan:Lcom/amazon/dee/result/bif/Span;

    invoke-virtual {v2}, Lcom/amazon/dee/result/bif/Span;->getStart()I

    move-result v1

    .line 238
    .local v1, "start":I
    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mTokenSpan:Lcom/amazon/dee/result/bif/Span;

    invoke-virtual {v2}, Lcom/amazon/dee/result/bif/Span;->getLength()I

    move-result v0

    .line 239
    .local v0, "length":I
    invoke-virtual {p1}, Lcom/amazon/dee/result/bif/Intent;->getTokens()Ljava/util/List;

    move-result-object v2

    add-int v3, v1, v0

    invoke-interface {v2, v1, v3}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v2

    goto :goto_0
.end method

.method public getTokensAsText()Ljava/lang/String;
    .locals 5
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 298
    iget-object v3, p0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    if-nez v3, :cond_0

    const-string/jumbo v3, ""

    .line 304
    :goto_0
    return-object v3

    .line 299
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 300
    .local v1, "sb":Ljava/lang/StringBuilder;
    iget-object v3, p0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/dee/result/bif/Token;

    .line 302
    .local v2, "token":Lcom/amazon/dee/result/bif/Token;
    invoke-virtual {v2}, Lcom/amazon/dee/result/bif/Token;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_1

    .line 304
    .end local v2    # "token":Lcom/amazon/dee/result/bif/Token;
    :cond_1
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    goto :goto_0
.end method

.method public getValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 173
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Entity;->mValue:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 142
    const/4 v0, 0x5

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mName:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mValue:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mTokenSpan:Lcom/amazon/dee/result/bif/Span;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    aput-object v2, v0, v1

    const/4 v1, 0x4

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Entity;->mResolvedEntities:Lcom/amazon/dee/result/bif/ResolvedEntities;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 163
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Entity;->mName:Ljava/lang/String;

    .line 164
    return-void
.end method

.method public final setResolvedEntities(Lcom/amazon/dee/result/bif/ResolvedEntities;)V
    .locals 0
    .param p1, "resolvedEntities"    # Lcom/amazon/dee/result/bif/ResolvedEntities;

    .prologue
    .line 330
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Entity;->mResolvedEntities:Lcom/amazon/dee/result/bif/ResolvedEntities;

    .line 331
    return-void
.end method

.method public setSpan(Lcom/amazon/dee/result/bif/Span;)V
    .locals 0
    .param p1, "span"    # Lcom/amazon/dee/result/bif/Span;

    .prologue
    .line 212
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Entity;->mTokenSpan:Lcom/amazon/dee/result/bif/Span;

    .line 213
    return-void
.end method

.method public final setTokens(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/dee/result/bif/Token;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 283
    .local p1, "tokens":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/dee/result/bif/Token;>;"
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Entity;->mTokens:Ljava/util/List;

    .line 284
    return-void
.end method

.method public setValue(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 184
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Entity;->mValue:Ljava/lang/String;

    .line 185
    return-void
.end method
