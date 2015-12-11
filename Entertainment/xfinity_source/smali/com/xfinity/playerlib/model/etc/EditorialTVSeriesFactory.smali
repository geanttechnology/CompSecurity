.class public Lcom/xfinity/playerlib/model/etc/EditorialTVSeriesFactory;
.super Ljava/lang/Object;
.source "EditorialTVSeriesFactory.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/xfinity/playerlib/model/etc/EditorialProgramFactory",
        "<",
        "Lcom/xfinity/playerlib/model/EditorialTVSeries;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic create()Lcom/xfinity/playerlib/model/EditorialProgram;
    .locals 1

    .prologue
    .line 5
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/etc/EditorialTVSeriesFactory;->create()Lcom/xfinity/playerlib/model/EditorialTVSeries;

    move-result-object v0

    return-object v0
.end method

.method public create()Lcom/xfinity/playerlib/model/EditorialTVSeries;
    .locals 1

    .prologue
    .line 8
    new-instance v0, Lcom/xfinity/playerlib/model/EditorialTVSeries;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/EditorialTVSeries;-><init>()V

    return-object v0
.end method
