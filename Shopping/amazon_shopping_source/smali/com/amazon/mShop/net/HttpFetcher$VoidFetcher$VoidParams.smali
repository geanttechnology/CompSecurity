.class final Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher$VoidParams;
.super Lcom/amazon/mShop/net/HttpFetcher$Params;
.source "HttpFetcher.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/HttpFetcher$VoidFetcher;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1a
    name = "VoidParams"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/net/HttpFetcher$Params",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 388
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/net/HttpFetcher$Params;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 389
    return-void
.end method


# virtual methods
.method public final getServiceCallIdentifier()Lcom/amazon/mShop/net/ServiceCallIdentifier;
    .locals 1

    .prologue
    .line 398
    const/4 v0, 0x0

    return-object v0
.end method

.method public final getSubscriber()Lcom/amazon/mShop/net/HttpFetcher$Subscriber;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
            "<",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation

    .prologue
    .line 393
    const/4 v0, 0x0

    return-object v0
.end method
