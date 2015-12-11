.class public interface abstract Lcom/amazon/searchapp/retailsearch/model/Shipping;
.super Ljava/lang/Object;
.source "Shipping.java"


# virtual methods
.method public abstract getAddOn()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
.end method

.method public abstract getAdditionalStatus()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;",
            ">;"
        }
    .end annotation
.end method

.method public abstract getCod()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
.end method

.method public abstract getFba()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
.end method

.method public abstract getPreOrder()Z
.end method

.method public abstract getPrime()Lcom/amazon/searchapp/retailsearch/model/ShippingStatus;
.end method

.method public abstract getSss()Ljava/util/List;
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
