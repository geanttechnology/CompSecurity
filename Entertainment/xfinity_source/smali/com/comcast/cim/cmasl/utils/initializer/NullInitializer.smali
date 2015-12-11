.class public Lcom/comcast/cim/cmasl/utils/initializer/NullInitializer;
.super Ljava/lang/Object;
.source "NullInitializer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/initializer/Initializer;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/initializer/Initializer",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/initializer/NullInitializer;, "Lcom/comcast/cim/cmasl/utils/initializer/NullInitializer<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public initialize(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/initializer/NullInitializer;, "Lcom/comcast/cim/cmasl/utils/initializer/NullInitializer<TT;>;"
    .local p1, "object":Ljava/lang/Object;, "TT;"
    return-void
.end method
