.class public Lcom/comcast/cim/cmasl/utils/container/Tuple;
.super Ljava/lang/Object;
.source "Tuple.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T1:",
        "Ljava/lang/Object;",
        "T2:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Ljava/io/Serializable;"
    }
.end annotation


# instance fields
.field public final e1:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT1;"
        }
    .end annotation
.end field

.field public final e2:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT2;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT1;TT2;)V"
        }
    .end annotation

    .prologue
    .line 10
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    .local p1, "e1":Ljava/lang/Object;, "TT1;"
    .local p2, "e2":Ljava/lang/Object;, "TT2;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    iput-object p1, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    .line 12
    iput-object p2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    .line 13
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 17
    if-ne p0, p1, :cond_1

    .line 33
    :cond_0
    :goto_0
    return v1

    .line 20
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 21
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 24
    check-cast v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .line 26
    .local v0, "tuple":Lcom/comcast/cim/cmasl/utils/container/Tuple;
    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    iget-object v4, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    .line 27
    goto :goto_0

    .line 26
    :cond_5
    iget-object v3, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    if-nez v3, :cond_4

    .line 29
    :cond_6
    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    if-eqz v3, :cond_7

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    iget-object v4, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 30
    goto :goto_0

    .line 29
    :cond_7
    iget-object v3, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    const/4 v1, 0x0

    .line 38
    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 39
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 40
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 38
    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 45
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<TT1;TT2;>;"
    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    if-eqz v2, :cond_0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 46
    .local v0, "e1Desc":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    if-eqz v2, :cond_1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 47
    .local v1, "e2desc":Ljava/lang/String;
    :goto_1
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 45
    .end local v0    # "e1Desc":Ljava/lang/String;
    .end local v1    # "e2desc":Ljava/lang/String;
    :cond_0
    const-string v0, "null"

    goto :goto_0

    .line 46
    .restart local v0    # "e1Desc":Ljava/lang/String;
    :cond_1
    const-string v1, "null"

    goto :goto_1
.end method
