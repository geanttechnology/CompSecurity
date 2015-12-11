.class final enum Lcom/amazon/device/ads/MraidView$ExpansionStyle;
.super Ljava/lang/Enum;
.source "MraidView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "ExpansionStyle"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/MraidView$ExpansionStyle;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/MraidView$ExpansionStyle;

.field public static final enum DISABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

.field public static final enum ENABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 117
    new-instance v0, Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    const-string/jumbo v1, "ENABLED"

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/MraidView$ExpansionStyle;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->ENABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    .line 118
    new-instance v0, Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    const-string/jumbo v1, "DISABLED"

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/ads/MraidView$ExpansionStyle;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->DISABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    .line 116
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    sget-object v1, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->ENABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->DISABLED:Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->$VALUES:[Lcom/amazon/device/ads/MraidView$ExpansionStyle;

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
    .line 116
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/MraidView$ExpansionStyle;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 116
    const-class v0, Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/MraidView$ExpansionStyle;
    .locals 1

    .prologue
    .line 116
    sget-object v0, Lcom/amazon/device/ads/MraidView$ExpansionStyle;->$VALUES:[Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/MraidView$ExpansionStyle;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/MraidView$ExpansionStyle;

    return-object v0
.end method
