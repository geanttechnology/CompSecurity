.class public Lcom/amazon/avod/contentrestriction/MShopPinEntryActivityProxy;
.super Lcom/amazon/mShop/android/platform/app/ProxyActivity;
.source "MShopPinEntryActivityProxy.java"

# interfaces
.implements Lcom/amazon/avod/clickstream/PageInfoSource;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/app/ProxyActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public getPageInfo()Lcom/amazon/avod/clickstream/PageInfo;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/avod/contentrestriction/MShopPinEntryActivityProxy;->getActivityDelegate()Lcom/amazon/mShop/android/platform/app/ActivityDelegateBase;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/clickstream/PageInfoSource;

    invoke-interface {v0}, Lcom/amazon/avod/clickstream/PageInfoSource;->getPageInfo()Lcom/amazon/avod/clickstream/PageInfo;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 4

    .prologue
    .line 24
    const-string/jumbo v0, "%s@%x (%s)"

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    invoke-virtual {p0}, Lcom/amazon/avod/contentrestriction/MShopPinEntryActivityProxy;->getPageInfo()Lcom/amazon/avod/clickstream/PageInfo;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
