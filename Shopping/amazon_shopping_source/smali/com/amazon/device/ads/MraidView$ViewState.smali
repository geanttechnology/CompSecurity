.class public final enum Lcom/amazon/device/ads/MraidView$ViewState;
.super Ljava/lang/Enum;
.source "MraidView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ViewState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/MraidView$ViewState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/MraidView$ViewState;

.field public static final enum DEFAULT:Lcom/amazon/device/ads/MraidView$ViewState;

.field public static final enum EXPANDED:Lcom/amazon/device/ads/MraidView$ViewState;

.field public static final enum HIDDEN:Lcom/amazon/device/ads/MraidView$ViewState;

.field public static final enum LOADING:Lcom/amazon/device/ads/MraidView$ViewState;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 110
    new-instance v0, Lcom/amazon/device/ads/MraidView$ViewState;

    const-string/jumbo v1, "LOADING"

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/MraidView$ViewState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$ViewState;->LOADING:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 111
    new-instance v0, Lcom/amazon/device/ads/MraidView$ViewState;

    const-string/jumbo v1, "DEFAULT"

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/ads/MraidView$ViewState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$ViewState;->DEFAULT:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 112
    new-instance v0, Lcom/amazon/device/ads/MraidView$ViewState;

    const-string/jumbo v1, "EXPANDED"

    invoke-direct {v0, v1, v4}, Lcom/amazon/device/ads/MraidView$ViewState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$ViewState;->EXPANDED:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 113
    new-instance v0, Lcom/amazon/device/ads/MraidView$ViewState;

    const-string/jumbo v1, "HIDDEN"

    invoke-direct {v0, v1, v5}, Lcom/amazon/device/ads/MraidView$ViewState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$ViewState;->HIDDEN:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 109
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/amazon/device/ads/MraidView$ViewState;

    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->LOADING:Lcom/amazon/device/ads/MraidView$ViewState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->DEFAULT:Lcom/amazon/device/ads/MraidView$ViewState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->EXPANDED:Lcom/amazon/device/ads/MraidView$ViewState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/device/ads/MraidView$ViewState;->HIDDEN:Lcom/amazon/device/ads/MraidView$ViewState;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/device/ads/MraidView$ViewState;->$VALUES:[Lcom/amazon/device/ads/MraidView$ViewState;

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
    .line 109
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/MraidView$ViewState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 109
    const-class v0, Lcom/amazon/device/ads/MraidView$ViewState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/MraidView$ViewState;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/MraidView$ViewState;
    .locals 1

    .prologue
    .line 109
    sget-object v0, Lcom/amazon/device/ads/MraidView$ViewState;->$VALUES:[Lcom/amazon/device/ads/MraidView$ViewState;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/MraidView$ViewState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/MraidView$ViewState;

    return-object v0
.end method
