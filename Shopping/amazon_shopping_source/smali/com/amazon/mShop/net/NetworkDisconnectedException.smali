.class public Lcom/amazon/mShop/net/NetworkDisconnectedException;
.super Ljava/io/IOException;
.source "NetworkDisconnectedException.java"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    const-string/jumbo v0, "Device is not connected to network"

    invoke-direct {p0, v0}, Lcom/amazon/mShop/net/NetworkDisconnectedException;-><init>(Ljava/lang/String;)V

    .line 14
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "detailMessage"    # Ljava/lang/String;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    .line 18
    return-void
.end method
