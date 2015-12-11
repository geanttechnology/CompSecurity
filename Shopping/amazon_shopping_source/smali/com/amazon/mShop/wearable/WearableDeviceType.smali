.class public final enum Lcom/amazon/mShop/wearable/WearableDeviceType;
.super Ljava/lang/Enum;
.source "WearableDeviceType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/wearable/WearableDeviceType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/wearable/WearableDeviceType;

.field public static final enum AndroidWear:Lcom/amazon/mShop/wearable/WearableDeviceType;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 10
    new-instance v0, Lcom/amazon/mShop/wearable/WearableDeviceType;

    const-string/jumbo v1, "AndroidWear"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/wearable/WearableDeviceType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/wearable/WearableDeviceType;->AndroidWear:Lcom/amazon/mShop/wearable/WearableDeviceType;

    .line 9
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/mShop/wearable/WearableDeviceType;

    sget-object v1, Lcom/amazon/mShop/wearable/WearableDeviceType;->AndroidWear:Lcom/amazon/mShop/wearable/WearableDeviceType;

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/mShop/wearable/WearableDeviceType;->$VALUES:[Lcom/amazon/mShop/wearable/WearableDeviceType;

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
    .line 9
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/wearable/WearableDeviceType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/mShop/wearable/WearableDeviceType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/wearable/WearableDeviceType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/wearable/WearableDeviceType;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/mShop/wearable/WearableDeviceType;->$VALUES:[Lcom/amazon/mShop/wearable/WearableDeviceType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/wearable/WearableDeviceType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/wearable/WearableDeviceType;

    return-object v0
.end method
