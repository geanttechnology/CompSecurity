.class public Lcom/poshmark/data_model/models/SizeFilter;
.super Ljava/lang/Object;
.source "SizeFilter.java"


# instance fields
.field include:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field my_size_v2:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/SizeFilter;->my_size_v2:Z

    .line 21
    return-void
.end method

.method public constructor <init>(Lcom/poshmark/data_model/models/SizeFilter;)V
    .locals 2
    .param p1, "size"    # Lcom/poshmark/data_model/models/SizeFilter;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/SizeFilter;->my_size_v2:Z

    .line 14
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/SizeFilter;->getSizes()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 15
    new-instance v0, Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/SizeFilter;->getSizes()Ljava/util/List;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/poshmark/data_model/models/SizeFilter;->include:Ljava/util/List;

    .line 17
    :cond_0
    iget-boolean v0, p1, Lcom/poshmark/data_model/models/SizeFilter;->my_size_v2:Z

    iput-boolean v0, p0, Lcom/poshmark/data_model/models/SizeFilter;->my_size_v2:Z

    .line 18
    return-void
.end method


# virtual methods
.method public addSize(Ljava/lang/String;)V
    .locals 1
    .param p1, "sizeLabel"    # Ljava/lang/String;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/poshmark/data_model/models/SizeFilter;->include:Ljava/util/List;

    if-nez v0, :cond_0

    .line 25
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/SizeFilter;->include:Ljava/util/List;

    .line 27
    :cond_0
    iget-object v0, p0, Lcom/poshmark/data_model/models/SizeFilter;->include:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 28
    return-void
.end method

.method public enableMySize(Z)V
    .locals 0
    .param p1, "enabled"    # Z

    .prologue
    .line 35
    iput-boolean p1, p0, Lcom/poshmark/data_model/models/SizeFilter;->my_size_v2:Z

    .line 36
    return-void
.end method

.method public getMySizeFlag()Z
    .locals 1

    .prologue
    .line 39
    iget-boolean v0, p0, Lcom/poshmark/data_model/models/SizeFilter;->my_size_v2:Z

    return v0
.end method

.method public getSizes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lcom/poshmark/data_model/models/SizeFilter;->include:Ljava/util/List;

    return-object v0
.end method
