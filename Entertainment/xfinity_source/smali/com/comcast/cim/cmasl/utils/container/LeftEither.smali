.class public Lcom/comcast/cim/cmasl/utils/container/LeftEither;
.super Lcom/comcast/cim/cmasl/utils/container/Either;
.source "LeftEither.java"


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
            "(TT1;)V"
        }
    .end annotation

    .prologue
    .line 5
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/container/LeftEither;, "Lcom/comcast/cim/cmasl/utils/container/LeftEither<TT1;TT2;>;"
    .local p1, "e1":Ljava/lang/Object;, "TT1;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/comcast/cim/cmasl/utils/container/Either;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 6
    return-void
.end method
