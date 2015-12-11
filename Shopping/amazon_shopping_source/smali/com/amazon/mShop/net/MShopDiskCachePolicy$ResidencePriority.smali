.class public final enum Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
.super Ljava/lang/Enum;
.source "MShopDiskCachePolicy.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/net/MShopDiskCachePolicy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ResidencePriority"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

.field public static final enum RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

.field public static final enum RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 68
    new-instance v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    const-string/jumbo v1, "RESIDENCE_PRIORITY_0"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .line 69
    new-instance v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    const-string/jumbo v1, "RESIDENCE_PRIORITY_1"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    .line 67
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    sget-object v1, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_0:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->RESIDENCE_PRIORITY_1:Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->$VALUES:[Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

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
    .line 67
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 67
    const-class v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;
    .locals 1

    .prologue
    .line 67
    sget-object v0, Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->$VALUES:[Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    invoke-virtual {v0}, [Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/net/MShopDiskCachePolicy$ResidencePriority;

    return-object v0
.end method
