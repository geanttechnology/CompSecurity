.class public final enum Lcom/amazon/avod/sdk/CacheLevel;
.super Ljava/lang/Enum;
.source "CacheLevel.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/avod/sdk/CacheLevel;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/avod/sdk/CacheLevel;

.field public static final enum L1:Lcom/amazon/avod/sdk/CacheLevel;

.field public static final enum L2:Lcom/amazon/avod/sdk/CacheLevel;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 18
    new-instance v0, Lcom/amazon/avod/sdk/CacheLevel;

    const-string/jumbo v1, "L1"

    invoke-direct {v0, v1, v2}, Lcom/amazon/avod/sdk/CacheLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/avod/sdk/CacheLevel;->L1:Lcom/amazon/avod/sdk/CacheLevel;

    .line 24
    new-instance v0, Lcom/amazon/avod/sdk/CacheLevel;

    const-string/jumbo v1, "L2"

    invoke-direct {v0, v1, v3}, Lcom/amazon/avod/sdk/CacheLevel;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/avod/sdk/CacheLevel;->L2:Lcom/amazon/avod/sdk/CacheLevel;

    .line 13
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/avod/sdk/CacheLevel;

    sget-object v1, Lcom/amazon/avod/sdk/CacheLevel;->L1:Lcom/amazon/avod/sdk/CacheLevel;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/avod/sdk/CacheLevel;->L2:Lcom/amazon/avod/sdk/CacheLevel;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/avod/sdk/CacheLevel;->$VALUES:[Lcom/amazon/avod/sdk/CacheLevel;

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
    .line 13
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/avod/sdk/CacheLevel;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/amazon/avod/sdk/CacheLevel;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/avod/sdk/CacheLevel;

    return-object v0
.end method

.method public static values()[Lcom/amazon/avod/sdk/CacheLevel;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/amazon/avod/sdk/CacheLevel;->$VALUES:[Lcom/amazon/avod/sdk/CacheLevel;

    invoke-virtual {v0}, [Lcom/amazon/avod/sdk/CacheLevel;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/avod/sdk/CacheLevel;

    return-object v0
.end method
