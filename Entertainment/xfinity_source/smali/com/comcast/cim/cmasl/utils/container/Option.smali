.class public Lcom/comcast/cim/cmasl/utils/container/Option;
.super Ljava/lang/Object;
.source "Option.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final value:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 13
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Option;, "Lcom/comcast/cim/cmasl/utils/container/Option<TT;>;"
    .local p1, "value":Ljava/lang/Object;, "TT;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    .line 15
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Option;, "Lcom/comcast/cim/cmasl/utils/container/Option<TT;>;"
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 23
    if-ne p0, p1, :cond_1

    .line 33
    :cond_0
    :goto_0
    return v1

    .line 26
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 27
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 29
    check-cast v0, Lcom/comcast/cim/cmasl/utils/container/Option;

    .line 30
    .local v0, "option":Lcom/comcast/cim/cmasl/utils/container/Option;
    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    iget-object v4, v0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 31
    goto :goto_0

    .line 30
    :cond_4
    iget-object v3, v0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public getValue()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 18
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Option;, "Lcom/comcast/cim/cmasl/utils/container/Option<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 38
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Option;, "Lcom/comcast/cim/cmasl/utils/container/Option<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 43
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Option;, "Lcom/comcast/cim/cmasl/utils/container/Option<TT;>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/utils/container/Option;->value:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
