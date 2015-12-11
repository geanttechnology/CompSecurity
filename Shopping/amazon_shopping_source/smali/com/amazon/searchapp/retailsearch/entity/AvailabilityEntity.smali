.class public Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;
.super Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;
.source "AvailabilityEntity.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/model/Availability;


# instance fields
.field private fastTrack:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end field

.field private generalAvailability:Ljava/lang/String;

.field private lowStockMessage:Ljava/lang/String;

.field private secondaryAvailability:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/entity/RetailSearchEntity;-><init>()V

    return-void
.end method


# virtual methods
.method public getFastTrack()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;->fastTrack:Ljava/util/List;

    return-object v0
.end method

.method public getGeneralAvailability()Ljava/lang/String;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;->generalAvailability:Ljava/lang/String;

    return-object v0
.end method

.method public getLowStockMessage()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;->lowStockMessage:Ljava/lang/String;

    return-object v0
.end method

.method public getSecondaryAvailability()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;->secondaryAvailability:Ljava/lang/String;

    return-object v0
.end method

.method public setFastTrack(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 82
    .local p1, "fastTrack":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;->fastTrack:Ljava/util/List;

    .line 83
    return-void
.end method

.method public setGeneralAvailability(Ljava/lang/String;)V
    .locals 0
    .param p1, "generalAvailability"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;->generalAvailability:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setLowStockMessage(Ljava/lang/String;)V
    .locals 0
    .param p1, "lowStockMessage"    # Ljava/lang/String;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;->lowStockMessage:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setSecondaryAvailability(Ljava/lang/String;)V
    .locals 0
    .param p1, "secondaryAvailability"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/searchapp/retailsearch/entity/AvailabilityEntity;->secondaryAvailability:Ljava/lang/String;

    .line 63
    return-void
.end method
