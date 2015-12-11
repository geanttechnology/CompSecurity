.class public Lcom/comcast/cim/cmasl/utils/provider/NullProvider;
.super Ljava/lang/Object;
.source "NullProvider.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/provider/Provider;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/utils/provider/Provider",
        "<TT;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/provider/NullProvider;, "Lcom/comcast/cim/cmasl/utils/provider/NullProvider<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public get()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/cmasl/utils/provider/NullProvider;, "Lcom/comcast/cim/cmasl/utils/provider/NullProvider<TT;>;"
    const/4 v0, 0x0

    return-object v0
.end method
