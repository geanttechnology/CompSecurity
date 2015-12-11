.class final enum Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;
.super Ljava/lang/Enum;
.source "MShopWearListenerService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wearable/wear/MShopWearListenerService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "Requirement"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

.field public static final enum AUTH:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

.field public static final enum ONE_CLICK_ENABLED:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

.field public static final enum US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 584
    new-instance v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    const-string/jumbo v1, "US_LOCALE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    new-instance v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    const-string/jumbo v1, "AUTH"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->AUTH:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    new-instance v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    const-string/jumbo v1, "ONE_CLICK_ENABLED"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->ONE_CLICK_ENABLED:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    .line 583
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->US_LOCALE:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->AUTH:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->ONE_CLICK_ENABLED:Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->$VALUES:[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 583
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 583
    const-class v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;
    .locals 1

    .prologue
    .line 583
    sget-object v0, Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->$VALUES:[Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    invoke-virtual {v0}, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/wearable/wear/MShopWearListenerService$Requirement;

    return-object v0
.end method
