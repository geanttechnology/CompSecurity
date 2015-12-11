.class public final enum Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
.super Ljava/lang/Enum;
.source "SMILResource.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/authorization/SMILResource;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AdsType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

.field public static final enum AUDITUDE_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

.field public static final enum C3_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

.field public static final enum NO_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 15
    new-instance v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    const-string v1, "NO_ADS"

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->NO_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    .line 16
    new-instance v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    const-string v1, "AUDITUDE_ADS"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->AUDITUDE_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    .line 17
    new-instance v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    const-string v1, "C3_ADS"

    invoke-direct {v0, v1, v4}, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->C3_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    .line 14
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    sget-object v1, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->NO_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->AUDITUDE_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->C3_ADS:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->$VALUES:[Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

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
    .line 14
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 14
    const-class v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    .locals 1

    .prologue
    .line 14
    sget-object v0, Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->$VALUES:[Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    return-object v0
.end method
