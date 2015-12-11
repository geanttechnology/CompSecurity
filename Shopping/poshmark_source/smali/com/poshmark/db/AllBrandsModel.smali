.class public Lcom/poshmark/db/AllBrandsModel;
.super Lcom/poshmark/data_model/models/PMData;
.source "AllBrandsModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/db/AllBrandsModel$LastUpdateDTM;
    }
.end annotation


# instance fields
.field public data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Brand;",
            ">;"
        }
    .end annotation
.end field

.field public meta:Lcom/poshmark/db/AllBrandsModel$LastUpdateDTM;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMData;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/db/AllBrandsModel;->data:Ljava/util/List;

    .line 17
    return-void
.end method
