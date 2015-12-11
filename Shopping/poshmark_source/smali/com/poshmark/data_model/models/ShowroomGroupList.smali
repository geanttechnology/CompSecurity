.class public Lcom/poshmark/data_model/models/ShowroomGroupList;
.super Lcom/poshmark/data_model/models/PMData;
.source "ShowroomGroupList.java"


# instance fields
.field data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ShowroomGroup;",
            ">;"
        }
    .end annotation
.end field

.field more:Lcom/poshmark/data_model/models/PMData$NextMaxID;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMData;-><init>()V

    .line 12
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShowroomGroupList;->data:Ljava/util/List;

    .line 13
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/data_model/models/ShowroomGroupList;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    return-void
.end method


# virtual methods
.method public getList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/ShowroomGroup;",
            ">;"
        }
    .end annotation

    .prologue
    .line 16
    iget-object v0, p0, Lcom/poshmark/data_model/models/ShowroomGroupList;->data:Ljava/util/List;

    return-object v0
.end method
