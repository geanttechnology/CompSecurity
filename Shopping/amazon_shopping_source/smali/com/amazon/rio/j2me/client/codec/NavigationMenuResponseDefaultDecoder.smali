.class public Lcom/amazon/rio/j2me/client/codec/NavigationMenuResponseDefaultDecoder;
.super Ljava/lang/Object;
.source "NavigationMenuResponseDefaultDecoder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/codec/Decoder;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/amazon/rio/j2me/client/codec/Decoder",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;
    .locals 4
    .param p1, "dis"    # Ljava/io/DataInputStream;
    .param p2, "ignored"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;-><init>()V

    .line 26
    .local v1, "record":Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;
    new-instance v2, Lcom/amazon/rio/j2me/client/codec/NavMenuItemDefaultDecoder;

    invoke-direct {v2}, Lcom/amazon/rio/j2me/client/codec/NavMenuItemDefaultDecoder;-><init>()V

    invoke-static {v2}, Lcom/amazon/rio/j2me/client/codec/DefaultDecoder;->getArrayInstance(Lcom/amazon/rio/j2me/client/codec/Decoder;)Lcom/amazon/rio/j2me/client/codec/Decoder;

    move-result-object v2

    const/4 v3, 0x0

    invoke-interface {v2, p1, v3}, Lcom/amazon/rio/j2me/client/codec/Decoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 27
    .local v0, "data":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;>;"
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;->setMenuItems(Ljava/util/List;)V

    .line 29
    return-object v1
.end method

.method public bridge synthetic decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Ljava/io/DataInputStream;
    .param p2, "x1"    # Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 17
    invoke-virtual {p0, p1, p2}, Lcom/amazon/rio/j2me/client/codec/NavigationMenuResponseDefaultDecoder;->decode(Ljava/io/DataInputStream;Lcom/amazon/rio/j2me/client/codec/StreamedResponseListener;)Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;

    move-result-object v0

    return-object v0
.end method
