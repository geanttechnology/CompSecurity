.class public Lcom/amazon/dee/result/bif/Value;
.super Ljava/lang/Object;
.source "Value.java"


# annotations
.annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnoreProperties;
    ignoreUnknown = true
.end annotation


# instance fields
.field private mValue:Ljava/lang/Object;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/amazon/dee/result/bif/Value;-><init>(Ljava/lang/Object;)V

    .line 39
    return-void
.end method

.method public constructor <init>(Ljava/lang/Object;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Value;->mValue:Ljava/lang/Object;

    .line 31
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 3
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 44
    instance-of v1, p1, Lcom/amazon/dee/result/bif/Value;

    if-eqz v1, :cond_0

    move-object v0, p1

    .line 46
    check-cast v0, Lcom/amazon/dee/result/bif/Value;

    .line 47
    .local v0, "other":Lcom/amazon/dee/result/bif/Value;
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Value;->mValue:Ljava/lang/Object;

    iget-object v2, v0, Lcom/amazon/dee/result/bif/Value;->mValue:Ljava/lang/Object;

    invoke-static {v1, v2}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    .line 51
    .end local v0    # "other":Lcom/amazon/dee/result/bif/Value;
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getValue()Ljava/lang/Object;
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonTypeInfo;
        include = .enum Lcom/fasterxml/jackson/annotation/JsonTypeInfo$As;->PROPERTY:Lcom/fasterxml/jackson/annotation/JsonTypeInfo$As;
        property = "type"
        use = .enum Lcom/fasterxml/jackson/annotation/JsonTypeInfo$Id;->CLASS:Lcom/fasterxml/jackson/annotation/JsonTypeInfo$Id;
    .end annotation

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Value;->mValue:Ljava/lang/Object;

    return-object v0
.end method

.method public getValueAsType(Ljava/lang/Class;)Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)TT;"
        }
    .end annotation

    .prologue
    .line 89
    .local p1, "valueType":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    :try_start_0
    iget-object v1, p0, Lcom/amazon/dee/result/bif/Value;->mValue:Ljava/lang/Object;

    invoke-virtual {p1, v1}, Ljava/lang/Class;->cast(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/ClassCastException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 93
    :goto_0
    return-object v1

    .line 91
    :catch_0
    move-exception v0

    .line 93
    .local v0, "e":Ljava/lang/ClassCastException;
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 58
    const/4 v0, 0x1

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/dee/result/bif/Value;->mValue:Ljava/lang/Object;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public isValueNull()Z
    .locals 1
    .annotation runtime Lcom/fasterxml/jackson/annotation/JsonIgnore;
    .end annotation

    .prologue
    .line 69
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Value;->mValue:Ljava/lang/Object;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setValue(Ljava/lang/Object;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/dee/result/bif/Value;->mValue:Ljava/lang/Object;

    .line 118
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 123
    invoke-virtual {p0}, Lcom/amazon/dee/result/bif/Value;->isValueNull()Z

    move-result v0

    if-eqz v0, :cond_0

    const-string/jumbo v0, "null"

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/dee/result/bif/Value;->mValue:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
