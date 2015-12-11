.class public Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory;
.super Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;
.source "HalLiveStreamResourceFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
        "<TT;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory;, "Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory<TT;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic get()Lcom/comcast/cim/cmasl/hal/model/HalParseable;
    .locals 1

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory;, "Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory;->get()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    move-result-object v0

    return-object v0
.end method

.method protected get()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    .locals 1

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory;, "Lcom/comcast/cim/model/hal/HalLiveStreamResourceFactory<TT;>;"
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;-><init>()V

    return-object v0
.end method
