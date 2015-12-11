.class public Lcom/poshmark/data_model/models/ShowroomGroup;
.super Ljava/lang/Object;
.source "ShowroomGroup.java"


# instance fields
.field collections:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Showroom;",
            ">;"
        }
    .end annotation
.end field

.field display_name:Ljava/lang/String;

.field tag:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShowroomGroup;->collections:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public getCollections()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Showroom;",
            ">;"
        }
    .end annotation

    .prologue
    .line 16
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShowroomGroup;->collections:Ljava/util/List;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShowroomGroup;->display_name:Ljava/lang/String;

    return-object v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShowroomGroup;->tag:Ljava/lang/String;

    return-object v0
.end method
