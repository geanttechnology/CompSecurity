.class final Lcom/amazon/mShop/mobileads/AdsHelper$1;
.super Ljava/util/HashMap;
.source "AdsHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mobileads/AdsHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>(I)V
    .locals 2
    .param p1, "x0"    # I

    .prologue
    .line 52
    invoke-direct {p0, p1}, Ljava/util/HashMap;-><init>(I)V

    .line 55
    const-string/jumbo v0, "en_US"

    const-string/jumbo v1, "US"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/mobileads/AdsHelper$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    const-string/jumbo v0, "ja_JP"

    const-string/jumbo v1, "JP"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/mobileads/AdsHelper$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    const-string/jumbo v0, "de_DE"

    const-string/jumbo v1, "DE"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/mobileads/AdsHelper$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 58
    const-string/jumbo v0, "fr_FR"

    const-string/jumbo v1, "FR"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/mobileads/AdsHelper$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    const-string/jumbo v0, "en_GB"

    const-string/jumbo v1, "UK"

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/mobileads/AdsHelper$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 60
    return-void
.end method
