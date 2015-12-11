.class public final enum Lcom/amazon/device/ads/AdData$AAXCreative;
.super Ljava/lang/Enum;
.source "AdData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "AAXCreative"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/AdData$AAXCreative;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/AdData$AAXCreative;

.field public static final enum HTML:Lcom/amazon/device/ads/AdData$AAXCreative;

.field public static final enum INTERSTITIAL:Lcom/amazon/device/ads/AdData$AAXCreative;

.field public static final enum MRAID1:Lcom/amazon/device/ads/AdData$AAXCreative;


# instance fields
.field private final id:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 53
    new-instance v0, Lcom/amazon/device/ads/AdData$AAXCreative;

    const-string/jumbo v1, "HTML"

    const/16 v2, 0x3ef

    invoke-direct {v0, v1, v3, v2}, Lcom/amazon/device/ads/AdData$AAXCreative;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->HTML:Lcom/amazon/device/ads/AdData$AAXCreative;

    .line 54
    new-instance v0, Lcom/amazon/device/ads/AdData$AAXCreative;

    const-string/jumbo v1, "MRAID1"

    const/16 v2, 0x3f8

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/device/ads/AdData$AAXCreative;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->MRAID1:Lcom/amazon/device/ads/AdData$AAXCreative;

    .line 55
    new-instance v0, Lcom/amazon/device/ads/AdData$AAXCreative;

    const-string/jumbo v1, "INTERSTITIAL"

    const/16 v2, 0x3f0

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/device/ads/AdData$AAXCreative;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->INTERSTITIAL:Lcom/amazon/device/ads/AdData$AAXCreative;

    .line 51
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/amazon/device/ads/AdData$AAXCreative;

    sget-object v1, Lcom/amazon/device/ads/AdData$AAXCreative;->HTML:Lcom/amazon/device/ads/AdData$AAXCreative;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/device/ads/AdData$AAXCreative;->MRAID1:Lcom/amazon/device/ads/AdData$AAXCreative;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/device/ads/AdData$AAXCreative;->INTERSTITIAL:Lcom/amazon/device/ads/AdData$AAXCreative;

    aput-object v1, v0, v5

    sput-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->$VALUES:[Lcom/amazon/device/ads/AdData$AAXCreative;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "id"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 60
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 61
    iput p3, p0, Lcom/amazon/device/ads/AdData$AAXCreative;->id:I

    .line 62
    return-void
.end method

.method static getCreative(I)Lcom/amazon/device/ads/AdData$AAXCreative;
    .locals 1
    .param p0, "id"    # I

    .prologue
    .line 71
    sparse-switch p0, :sswitch_data_0

    .line 80
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 74
    :sswitch_0
    sget-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->HTML:Lcom/amazon/device/ads/AdData$AAXCreative;

    goto :goto_0

    .line 76
    :sswitch_1
    sget-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->MRAID1:Lcom/amazon/device/ads/AdData$AAXCreative;

    goto :goto_0

    .line 78
    :sswitch_2
    sget-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->INTERSTITIAL:Lcom/amazon/device/ads/AdData$AAXCreative;

    goto :goto_0

    .line 71
    :sswitch_data_0
    .sparse-switch
        0x3ef -> :sswitch_0
        0x3f0 -> :sswitch_2
        0x3f8 -> :sswitch_1
    .end sparse-switch
.end method

.method static getTopCreative(Ljava/util/Set;)Lcom/amazon/device/ads/AdData$AAXCreative;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/device/ads/AdData$AAXCreative;",
            ">;)",
            "Lcom/amazon/device/ads/AdData$AAXCreative;"
        }
    .end annotation

    .prologue
    .line 91
    .local p0, "creatives":Ljava/util/Set;, "Ljava/util/Set<Lcom/amazon/device/ads/AdData$AAXCreative;>;"
    const/4 v0, 0x0

    .line 92
    .local v0, "creative":Lcom/amazon/device/ads/AdData$AAXCreative;
    sget-object v1, Lcom/amazon/device/ads/AdData$AAXCreative;->MRAID1:Lcom/amazon/device/ads/AdData$AAXCreative;

    invoke-interface {p0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 94
    sget-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->MRAID1:Lcom/amazon/device/ads/AdData$AAXCreative;

    .line 100
    :cond_0
    :goto_0
    return-object v0

    .line 96
    :cond_1
    sget-object v1, Lcom/amazon/device/ads/AdData$AAXCreative;->HTML:Lcom/amazon/device/ads/AdData$AAXCreative;

    invoke-interface {p0, v1}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 98
    sget-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->HTML:Lcom/amazon/device/ads/AdData$AAXCreative;

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/AdData$AAXCreative;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 51
    const-class v0, Lcom/amazon/device/ads/AdData$AAXCreative;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/AdData$AAXCreative;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/AdData$AAXCreative;
    .locals 1

    .prologue
    .line 51
    sget-object v0, Lcom/amazon/device/ads/AdData$AAXCreative;->$VALUES:[Lcom/amazon/device/ads/AdData$AAXCreative;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/AdData$AAXCreative;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/AdData$AAXCreative;

    return-object v0
.end method


# virtual methods
.method public getId()I
    .locals 1

    .prologue
    .line 66
    iget v0, p0, Lcom/amazon/device/ads/AdData$AAXCreative;->id:I

    return v0
.end method
