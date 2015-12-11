.class public final enum Lcom/amazon/device/ads/AdRenderer$AdState;
.super Ljava/lang/Enum;
.source "AdRenderer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdRenderer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "AdState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/AdRenderer$AdState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/AdRenderer$AdState;

.field public static final enum EXPANDED:Lcom/amazon/device/ads/AdRenderer$AdState;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 45
    new-instance v0, Lcom/amazon/device/ads/AdRenderer$AdState;

    const-string/jumbo v1, "EXPANDED"

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/AdRenderer$AdState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/AdRenderer$AdState;->EXPANDED:Lcom/amazon/device/ads/AdRenderer$AdState;

    .line 43
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/amazon/device/ads/AdRenderer$AdState;

    sget-object v1, Lcom/amazon/device/ads/AdRenderer$AdState;->EXPANDED:Lcom/amazon/device/ads/AdRenderer$AdState;

    aput-object v1, v0, v2

    sput-object v0, Lcom/amazon/device/ads/AdRenderer$AdState;->$VALUES:[Lcom/amazon/device/ads/AdRenderer$AdState;

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
    .line 43
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/AdRenderer$AdState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 43
    const-class v0, Lcom/amazon/device/ads/AdRenderer$AdState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/AdRenderer$AdState;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/AdRenderer$AdState;
    .locals 1

    .prologue
    .line 43
    sget-object v0, Lcom/amazon/device/ads/AdRenderer$AdState;->$VALUES:[Lcom/amazon/device/ads/AdRenderer$AdState;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/AdRenderer$AdState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/AdRenderer$AdState;

    return-object v0
.end method
