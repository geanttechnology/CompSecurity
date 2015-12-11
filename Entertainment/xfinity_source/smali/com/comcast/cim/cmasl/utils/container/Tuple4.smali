.class public Lcom/comcast/cim/cmasl/utils/container/Tuple4;
.super Ljava/lang/Object;
.source "Tuple4.java"

# interfaces
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T1:",
        "Ljava/lang/Object;",
        "T2:",
        "Ljava/lang/Object;",
        "T3:",
        "Ljava/lang/Object;",
        "T4:",
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

.field public final e3:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT3;"
        }
    .end annotation
.end field

.field public final e4:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT4;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT1;TT2;TT3;TT4;)V"
        }
    .end annotation

    .prologue
    .line 12
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    .local p1, "e1":Ljava/lang/Object;, "TT1;"
    .local p2, "e2":Ljava/lang/Object;, "TT2;"
    .local p3, "e3":Ljava/lang/Object;, "TT3;"
    .local p4, "e4":Ljava/lang/Object;, "TT4;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    .line 14
    iput-object p2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    .line 15
    iput-object p3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    .line 16
    iput-object p4, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    .line 17
    return-void
.end method


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 21
    if-ne p0, p1, :cond_1

    .line 43
    :cond_0
    :goto_0
    return v1

    .line 24
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 25
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 28
    check-cast v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    .line 30
    .local v0, "tuple4":Lcom/comcast/cim/cmasl/utils/container/Tuple4;
    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    iget-object v4, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_6

    :cond_4
    move v1, v2

    .line 31
    goto :goto_0

    .line 30
    :cond_5
    iget-object v3, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    if-nez v3, :cond_4

    .line 33
    :cond_6
    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    if-eqz v3, :cond_8

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    iget-object v4, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_9

    :cond_7
    move v1, v2

    .line 34
    goto :goto_0

    .line 33
    :cond_8
    iget-object v3, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    if-nez v3, :cond_7

    .line 36
    :cond_9
    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    if-eqz v3, :cond_b

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    iget-object v4, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_c

    :cond_a
    move v1, v2

    .line 37
    goto :goto_0

    .line 36
    :cond_b
    iget-object v3, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    if-nez v3, :cond_a

    .line 39
    :cond_c
    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    if-eqz v3, :cond_d

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    iget-object v4, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_1
    move v1, v2

    .line 40
    goto :goto_0

    .line 39
    :cond_d
    iget-object v3, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    if-eqz v3, :cond_0

    goto :goto_1
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<TT1;TT2;TT3;TT4;>;"
    const/4 v1, 0x0

    .line 48
    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v0

    .line 49
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 50
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    invoke-virtual {v2}, Ljava/lang/Object;->hashCode()I

    move-result v2

    :goto_2
    add-int v0, v3, v2

    .line 51
    mul-int/lit8 v2, v0, 0x1f

    iget-object v3, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    if-eqz v3, :cond_0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :cond_0
    add-int v0, v2, v1

    .line 52
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 48
    goto :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 49
    goto :goto_1

    :cond_3
    move v2, v1

    .line 50
    goto :goto_2
.end method
