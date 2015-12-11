.class public Lcom/comcast/cim/cmasl/utils/container/RightEither;
.super Lcom/comcast/cim/cmasl/utils/container/Either;
.source "RightEither.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T1:",
        "Ljava/lang/Object;",
        "T2:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/utils/container/Either",
        "<TT1;TT2;>;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/Object;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT2;)V"
        }
    .end annotation

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/RightEither;, "Lcom/comcast/cim/cmasl/utils/container/RightEither<TT1;TT2;>;"
    .local p1, "e2":Ljava/lang/Object;, "TT2;"
    const/4 v0, 0x0

    invoke-direct {p0, v0, p1}, Lcom/comcast/cim/cmasl/utils/container/Either;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 6
    return-void
.end method
