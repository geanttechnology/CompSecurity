.class public final enum Lcom/amazon/device/ads/AdTargetingOptions$Gender;
.super Ljava/lang/Enum;
.source "AdTargetingOptions.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdTargetingOptions;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Gender"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/AdTargetingOptions$Gender;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/AdTargetingOptions$Gender;

.field public static final enum FEMALE:Lcom/amazon/device/ads/AdTargetingOptions$Gender;

.field public static final enum MALE:Lcom/amazon/device/ads/AdTargetingOptions$Gender;

.field public static final enum UNKNOWN:Lcom/amazon/device/ads/AdTargetingOptions$Gender;


# instance fields
.field final gender:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 201
    new-instance v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    const-string/jumbo v1, "UNKNOWN"

    const-string/jumbo v2, "unknown"

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/device/ads/AdTargetingOptions$Gender;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->UNKNOWN:Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    .line 202
    new-instance v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    const-string/jumbo v1, "MALE"

    const-string/jumbo v2, "male"

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/device/ads/AdTargetingOptions$Gender;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->MALE:Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    .line 203
    new-instance v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    const-string/jumbo v1, "FEMALE"

    const-string/jumbo v2, "female"

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/device/ads/AdTargetingOptions$Gender;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->FEMALE:Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    .line 199
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    sget-object v1, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->UNKNOWN:Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->MALE:Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->FEMALE:Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->$VALUES:[Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .param p3, "gender"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 208
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 209
    iput-object p3, p0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->gender:Ljava/lang/String;

    .line 210
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/AdTargetingOptions$Gender;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 199
    const-class v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/AdTargetingOptions$Gender;
    .locals 1

    .prologue
    .line 199
    sget-object v0, Lcom/amazon/device/ads/AdTargetingOptions$Gender;->$VALUES:[Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/AdTargetingOptions$Gender;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/AdTargetingOptions$Gender;

    return-object v0
.end method
