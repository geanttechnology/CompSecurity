.class public Lcom/xfinity/playerlib/view/browseprograms/DefaultDibicProgramFilterFactory;
.super Ljava/lang/Object;
.source "DefaultDibicProgramFilterFactory.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilterFactory;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createDefaultFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 2

    .prologue
    .line 8
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;-><init>()V

    .line 9
    .local v0, "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->setHideLockOn(Z)V

    .line 10
    return-object v0
.end method

.method public createNetworkFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .locals 2

    .prologue
    .line 15
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;-><init>()V

    .line 16
    .local v0, "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->setHideLockOn(Z)V

    .line 17
    return-object v0
.end method
