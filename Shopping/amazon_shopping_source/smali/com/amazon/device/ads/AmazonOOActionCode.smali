.class public final enum Lcom/amazon/device/ads/AmazonOOActionCode;
.super Ljava/lang/Enum;
.source "AmazonOOActionCode.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/AmazonOOActionCode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/AmazonOOActionCode;

.field public static final enum DISPLAY:Lcom/amazon/device/ads/AmazonOOActionCode;

.field public static final enum HANDLED:Lcom/amazon/device/ads/AmazonOOActionCode;

.field public static final enum REJECT:Lcom/amazon/device/ads/AmazonOOActionCode;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 10
    new-instance v0, Lcom/amazon/device/ads/AmazonOOActionCode;

    const-string/jumbo v1, "REJECT"

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/AmazonOOActionCode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->REJECT:Lcom/amazon/device/ads/AmazonOOActionCode;

    .line 11
    new-instance v0, Lcom/amazon/device/ads/AmazonOOActionCode;

    const-string/jumbo v1, "DISPLAY"

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/ads/AmazonOOActionCode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->DISPLAY:Lcom/amazon/device/ads/AmazonOOActionCode;

    .line 12
    new-instance v0, Lcom/amazon/device/ads/AmazonOOActionCode;

    const-string/jumbo v1, "HANDLED"

    invoke-direct {v0, v1, v4}, Lcom/amazon/device/ads/AmazonOOActionCode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->HANDLED:Lcom/amazon/device/ads/AmazonOOActionCode;

    .line 9
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/device/ads/AmazonOOActionCode;

    sget-object v1, Lcom/amazon/device/ads/AmazonOOActionCode;->REJECT:Lcom/amazon/device/ads/AmazonOOActionCode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/device/ads/AmazonOOActionCode;->DISPLAY:Lcom/amazon/device/ads/AmazonOOActionCode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/device/ads/AmazonOOActionCode;->HANDLED:Lcom/amazon/device/ads/AmazonOOActionCode;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->$VALUES:[Lcom/amazon/device/ads/AmazonOOActionCode;

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

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/AmazonOOActionCode;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/amazon/device/ads/AmazonOOActionCode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/AmazonOOActionCode;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/AmazonOOActionCode;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->$VALUES:[Lcom/amazon/device/ads/AmazonOOActionCode;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/AmazonOOActionCode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/AmazonOOActionCode;

    return-object v0
.end method
