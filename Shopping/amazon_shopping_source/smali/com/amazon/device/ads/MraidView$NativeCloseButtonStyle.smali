.class final enum Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;
.super Ljava/lang/Enum;
.source "MraidView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "NativeCloseButtonStyle"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

.field public static final enum AD_CONTROLLED:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

.field public static final enum ALWAYS_HIDDEN:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

.field public static final enum ALWAYS_VISIBLE:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 122
    new-instance v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    const-string/jumbo v1, "ALWAYS_VISIBLE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->ALWAYS_VISIBLE:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    .line 123
    new-instance v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    const-string/jumbo v1, "ALWAYS_HIDDEN"

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->ALWAYS_HIDDEN:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    .line 124
    new-instance v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    const-string/jumbo v1, "AD_CONTROLLED"

    invoke-direct {v0, v1, v4}, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->AD_CONTROLLED:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    .line 121
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    sget-object v1, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->ALWAYS_VISIBLE:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->ALWAYS_HIDDEN:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->AD_CONTROLLED:Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    aput-object v1, v0, v4

    sput-object v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->$VALUES:[Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

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
    .line 121
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 121
    const-class v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;
    .locals 1

    .prologue
    .line 121
    sget-object v0, Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->$VALUES:[Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/MraidView$NativeCloseButtonStyle;

    return-object v0
.end method
