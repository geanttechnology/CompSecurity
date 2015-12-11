.class public Lcom/comcast/cim/model/hal/HalMovieFactory;
.super Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;
.source "HalMovieFactory.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
        "<TT;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/model/hal/HalMovieFactory;, "Lcom/comcast/cim/model/hal/HalMovieFactory<TT;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic get()Lcom/comcast/cim/cmasl/hal/model/HalParseable;
    .locals 1

    .prologue
    .line 6
    .local p0, "this":Lcom/comcast/cim/model/hal/HalMovieFactory;, "Lcom/comcast/cim/model/hal/HalMovieFactory<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/hal/HalMovieFactory;->get()Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    move-result-object v0

    return-object v0
.end method

.method protected get()Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
    .locals 1

    .prologue
    .line 9
    .local p0, "this":Lcom/comcast/cim/model/hal/HalMovieFactory;, "Lcom/comcast/cim/model/hal/HalMovieFactory<TT;>;"
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;-><init>()V

    return-object v0
.end method
