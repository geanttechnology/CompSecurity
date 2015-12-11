.class public Lcom/xfinity/playerlib/model/etc/DibicMovieFactory;
.super Ljava/lang/Object;
.source "DibicMovieFactory.java"

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
.method public create()Lcom/xfinity/playerlib/model/dibic/DibicMovie;
    .locals 1

    .prologue
    .line 8
    new-instance v0, Lcom/xfinity/playerlib/model/dibic/DibicMovie;

    invoke-direct {v0}, Lcom/xfinity/playerlib/model/dibic/DibicMovie;-><init>()V

    return-object v0
.end method

.method public bridge synthetic create()Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .locals 1

    .prologue
    .line 5
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/etc/DibicMovieFactory;->create()Lcom/xfinity/playerlib/model/dibic/DibicMovie;

    move-result-object v0

    return-object v0
.end method
