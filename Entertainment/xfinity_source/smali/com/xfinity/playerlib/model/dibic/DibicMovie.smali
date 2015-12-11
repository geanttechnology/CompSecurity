.class public Lcom/xfinity/playerlib/model/dibic/DibicMovie;
.super Lcom/xfinity/playerlib/model/dibic/DibicProgram;
.source "DibicMovie.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;-><init>()V

    return-void
.end method


# virtual methods
.method public getMerlinIdNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    return-object v0
.end method

.method public isMovie()Z
    .locals 1

    .prologue
    .line 9
    const/4 v0, 0x1

    return v0
.end method
