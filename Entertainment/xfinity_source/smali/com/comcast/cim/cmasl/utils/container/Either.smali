.class public abstract Lcom/comcast/cim/cmasl/utils/container/Either;
.super Lcom/comcast/cim/cmasl/utils/container/Tuple;
.source "Either.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T1:",
        "Ljava/lang/Object;",
        "T2:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<TT1;TT2;>;"
    }
.end annotation


# direct methods
.method protected constructor <init>(Ljava/lang/Object;Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT1;TT2;)V"
        }
    .end annotation

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<TT1;TT2;>;"
    .local p1, "e1":Ljava/lang/Object;, "TT1;"
    .local p2, "e2":Ljava/lang/Object;, "TT2;"
    invoke-direct {p0, p1, p2}, Lcom/comcast/cim/cmasl/utils/container/Tuple;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 6
    return-void
.end method
