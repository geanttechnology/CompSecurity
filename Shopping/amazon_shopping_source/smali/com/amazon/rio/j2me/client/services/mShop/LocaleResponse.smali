.class public Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponse;
.super Ljava/lang/Object;
.source "LocaleResponse.java"


# instance fields
.field private availableLocales:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/LocaleInfo;",
            ">;"
        }
    .end annotation
.end field

.field private currentCode:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getCurrentCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponse;->currentCode:Ljava/lang/String;

    return-object v0
.end method

.method public setAvailableLocales(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/LocaleInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 39
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/LocaleInfo;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponse;->availableLocales:Ljava/util/List;

    .line 40
    return-void
.end method

.method public setCurrentCode(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/LocaleResponse;->currentCode:Ljava/lang/String;

    .line 27
    return-void
.end method
