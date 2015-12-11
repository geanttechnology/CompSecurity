.class public Lcom/xfinity/playerlib/model/etc/EditorialMovieFactory;
.super Ljava/lang/Object;
.source "EditorialMovieFactory.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory",
        "<",
        "Lcom/xfinity/playerlib/model/EditorialMovie;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public create()Lcom/xfinity/playerlib/model/EditorialMovie;
    .locals 1

    .prologue
    .line 9
    new-instance v0, Lcom/xfinity/playerlib/model/EditorialMovie;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/EditorialMovie;-><init>()V

    return-object v0
.end method

.method public bridge synthetic create()Lcom/xfinity/playerlib/model/EditorialProgram;
    .locals 1

    .prologue
    .line 6
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/etc/EditorialMovieFactory;->create()Lcom/xfinity/playerlib/model/EditorialMovie;

    move-result-object v0

    return-object v0
.end method
