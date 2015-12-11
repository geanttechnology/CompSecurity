.class final enum Lcom/amazon/device/ads/InterstitialAd$State;
.super Ljava/lang/Enum;
.source "InterstitialAd.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/InterstitialAd;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "State"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/InterstitialAd$State;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/InterstitialAd$State;

.field public static final enum DISMISSED:Lcom/amazon/device/ads/InterstitialAd$State;

.field public static final enum LOADING:Lcom/amazon/device/ads/InterstitialAd$State;

.field public static final enum READY_TO_LOAD:Lcom/amazon/device/ads/InterstitialAd$State;

.field public static final enum READY_TO_SHOW:Lcom/amazon/device/ads/InterstitialAd$State;

.field public static final enum SHOWING:Lcom/amazon/device/ads/InterstitialAd$State;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 787
    new-instance v0, Lcom/amazon/device/ads/InterstitialAd$State;

    const-string/jumbo v1, "READY_TO_LOAD"

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/InterstitialAd$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_LOAD:Lcom/amazon/device/ads/InterstitialAd$State;

    .line 788
    new-instance v0, Lcom/amazon/device/ads/InterstitialAd$State;

    const-string/jumbo v1, "LOADING"

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/ads/InterstitialAd$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/InterstitialAd$State;->LOADING:Lcom/amazon/device/ads/InterstitialAd$State;

    .line 789
    new-instance v0, Lcom/amazon/device/ads/InterstitialAd$State;

    const-string/jumbo v1, "READY_TO_SHOW"

    invoke-direct {v0, v1, v4}, Lcom/amazon/device/ads/InterstitialAd$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_SHOW:Lcom/amazon/device/ads/InterstitialAd$State;

    .line 790
    new-instance v0, Lcom/amazon/device/ads/InterstitialAd$State;

    const-string/jumbo v1, "SHOWING"

    invoke-direct {v0, v1, v5}, Lcom/amazon/device/ads/InterstitialAd$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/InterstitialAd$State;->SHOWING:Lcom/amazon/device/ads/InterstitialAd$State;

    .line 791
    new-instance v0, Lcom/amazon/device/ads/InterstitialAd$State;

    const-string/jumbo v1, "DISMISSED"

    invoke-direct {v0, v1, v6}, Lcom/amazon/device/ads/InterstitialAd$State;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/InterstitialAd$State;->DISMISSED:Lcom/amazon/device/ads/InterstitialAd$State;

    .line 785
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/amazon/device/ads/InterstitialAd$State;

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_LOAD:Lcom/amazon/device/ads/InterstitialAd$State;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->LOADING:Lcom/amazon/device/ads/InterstitialAd$State;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->READY_TO_SHOW:Lcom/amazon/device/ads/InterstitialAd$State;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->SHOWING:Lcom/amazon/device/ads/InterstitialAd$State;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/device/ads/InterstitialAd$State;->DISMISSED:Lcom/amazon/device/ads/InterstitialAd$State;

    aput-object v1, v0, v6

    sput-object v0, Lcom/amazon/device/ads/InterstitialAd$State;->$VALUES:[Lcom/amazon/device/ads/InterstitialAd$State;

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
    .line 785
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/InterstitialAd$State;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 785
    const-class v0, Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/InterstitialAd$State;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/InterstitialAd$State;
    .locals 1

    .prologue
    .line 785
    sget-object v0, Lcom/amazon/device/ads/InterstitialAd$State;->$VALUES:[Lcom/amazon/device/ads/InterstitialAd$State;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/InterstitialAd$State;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/InterstitialAd$State;

    return-object v0
.end method
