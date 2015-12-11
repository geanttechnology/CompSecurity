.class public final enum Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;
.super Ljava/lang/Enum;
.source "AdRestriction.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "RestrictionType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

.field public static final enum NONE:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

.field public static final enum PAUSE:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

.field public static final enum SEEK:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 43
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    const-string v1, "PAUSE"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->PAUSE:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    .line 44
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    const-string v1, "SEEK"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->SEEK:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    .line 45
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    const-string v1, "NONE"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->NONE:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    .line 42
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->PAUSE:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->SEEK:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->NONE:Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

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
    .line 42
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 42
    const-class v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;
    .locals 1

    .prologue
    .line 42
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType;

    return-object v0
.end method
