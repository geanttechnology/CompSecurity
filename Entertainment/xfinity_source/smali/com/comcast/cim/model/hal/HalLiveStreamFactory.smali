.class public Lcom/comcast/cim/model/hal/HalLiveStreamFactory;
.super Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;
.source "HalLiveStreamFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
        "<TT;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/model/hal/HalLiveStreamFactory;, "Lcom/comcast/cim/model/hal/HalLiveStreamFactory<TT;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic get()Lcom/comcast/cim/cmasl/hal/model/HalParseable;
    .locals 1

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/model/hal/HalLiveStreamFactory;, "Lcom/comcast/cim/model/hal/HalLiveStreamFactory<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/hal/HalLiveStreamFactory;->get()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    return-object v0
.end method

.method protected get()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .locals 1

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/model/hal/HalLiveStreamFactory;, "Lcom/comcast/cim/model/hal/HalLiveStreamFactory<TT;>;"
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;-><init>()V

    return-object v0
.end method
