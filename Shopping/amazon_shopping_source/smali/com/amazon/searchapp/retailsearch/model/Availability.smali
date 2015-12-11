.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/Availability;
.super Ljava/lang/Object;
.source "Availability.java"


# virtual methods
.method public abstract getFastTrack()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/StyledText;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getGeneralAvailability()Ljava/lang/String;
.end method

.method public abstract getLowStockMessage()Ljava/lang/String;
.end method

.method public abstract getSecondaryAvailability()Ljava/lang/String;
.end method
