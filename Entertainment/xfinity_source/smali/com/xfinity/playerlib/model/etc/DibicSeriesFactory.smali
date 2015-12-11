.class public Lcom/xfinity/playerlib/model/etc/DibicSeriesFactory;
.super Ljava/lang/Object;
.source "DibicSeriesFactory.java"

# interfaces
.implements Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic create()Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .locals 1

    .prologue
    .line 5
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/etc/DibicSeriesFactory;->create()Lcom/xfinity/playerlib/model/dibic/DibicSeries;

    move-result-object v0

    return-object v0
.end method

.method public create()Lcom/xfinity/playerlib/model/dibic/DibicSeries;
    .locals 1

    .prologue
    .line 8
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicSeries;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/dibic/DibicSeries;-><init>()V

    return-object v0
.end method
