.class synthetic Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$25;
.super Ljava/lang/Object;
.source "MShopWearListenerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1008
    name = null
.end annotation


# static fields
.field static final synthetic $SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement:[I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 589
    invoke-static {}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->values()[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    sput-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$25;->$SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement:[I

    :try_start_0
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$25;->$SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement:[I

    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    invoke-virtual {v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_2

    :goto_0
    :try_start_1
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$25;->$SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement:[I

    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->ONE_CLICK_ENABLED:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    invoke-virtual {v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_1

    :goto_1
    :try_start_2
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$25;->$SwitchMap$com$amazon$mShop$wearable$wear$MShopWearListenerService$Requirement:[I

    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->AUTH:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    invoke-virtual {v1}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_0

    :goto_2
    return-void

    :catch_0
    move-exception v0

    goto :goto_2

    :catch_1
    move-exception v0

    goto :goto_1

    :catch_2
    move-exception v0

    goto :goto_0
.end method
