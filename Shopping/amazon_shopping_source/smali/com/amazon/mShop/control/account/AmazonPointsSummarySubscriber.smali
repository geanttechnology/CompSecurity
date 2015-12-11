.class public interface abstract Lcom/amazon/mShop/control/account/AmazonPointsSummarySubscriber;
.super Ljava/lang/Object;
.source "AmazonPointsSummarySubscriber.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserSubscriber;


# virtual methods
.method public abstract onReceiveAmazonPointsSummary(Ljava/util/List;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/KeyValuePair;",
            ">;)V"
        }
    .end annotation
.end method
