.class public Lcom/poshmark/data_model/models/ActorUser;
.super Lcom/poshmark/data_model/models/Actor;
.source "ActorUser.java"


# instance fields
.field data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/UserReference;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/poshmark/data_model/models/Actor;-><init>()V

    return-void
.end method


# virtual methods
.method public getAvataar()Ljava/lang/String;
    .locals 2

    .prologue
    .line 23
    iget-object v0, p0, Lcom/poshmark/data_model/models/ActorUser;->data:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/UserReference;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDefaultAvataarImageId()I
    .locals 1

    .prologue
    .line 27
    const v0, 0x7f020116

    return v0
.end method

.method public getId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 20
    iget-object v0, p0, Lcom/poshmark/data_model/models/ActorUser;->data:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/UserReference;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserId()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 2

    .prologue
    .line 16
    iget-object v0, p0, Lcom/poshmark/data_model/models/ActorUser;->data:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/UserReference;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
