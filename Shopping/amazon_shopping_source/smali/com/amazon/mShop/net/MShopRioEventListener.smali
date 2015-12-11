.class public Lcom/amazon/mShop/net/MShopRioEventListener;
.super Ljava/lang/Object;
.source "MShopRioEventListener.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/RioEventListener;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getRioEventListener()Lcom/amazon/rio/j2me/client/services/RioEventListener;
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    return-object v0
.end method


# virtual methods
.method public connectionFailed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 59
    return-void
.end method

.method public connectionSucceeded(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 49
    return-void
.end method
