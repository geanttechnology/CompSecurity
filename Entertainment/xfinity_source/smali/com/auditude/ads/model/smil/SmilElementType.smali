.class public final enum Lcom/auditude/ads/model/smil/SmilElementType;
.super Ljava/lang/Enum;
.source "SmilElementType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/auditude/ads/model/smil/SmilElementType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic ENUM$VALUES:[Lcom/auditude/ads/model/smil/SmilElementType;

.field public static final enum LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

.field public static final enum NON_LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

.field public static final enum UNKNOWN:Lcom/auditude/ads/model/smil/SmilElementType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 5
    new-instance v0, Lcom/auditude/ads/model/smil/SmilElementType;

    const-string v1, "LINEAR"

    invoke-direct {v0, v1, v2}, Lcom/auditude/ads/model/smil/SmilElementType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    .line 6
    new-instance v0, Lcom/auditude/ads/model/smil/SmilElementType;

    const-string v1, "NON_LINEAR"

    invoke-direct {v0, v1, v3}, Lcom/auditude/ads/model/smil/SmilElementType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/model/smil/SmilElementType;->NON_LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    .line 7
    new-instance v0, Lcom/auditude/ads/model/smil/SmilElementType;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v4}, Lcom/auditude/ads/model/smil/SmilElementType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/auditude/ads/model/smil/SmilElementType;->UNKNOWN:Lcom/auditude/ads/model/smil/SmilElementType;

    .line 3
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/auditude/ads/model/smil/SmilElementType;

    sget-object v1, Lcom/auditude/ads/model/smil/SmilElementType;->LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/auditude/ads/model/smil/SmilElementType;->NON_LINEAR:Lcom/auditude/ads/model/smil/SmilElementType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/auditude/ads/model/smil/SmilElementType;->UNKNOWN:Lcom/auditude/ads/model/smil/SmilElementType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/auditude/ads/model/smil/SmilElementType;->ENUM$VALUES:[Lcom/auditude/ads/model/smil/SmilElementType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/auditude/ads/model/smil/SmilElementType;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/auditude/ads/model/smil/SmilElementType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/SmilElementType;

    return-object v0
.end method

.method public static values()[Lcom/auditude/ads/model/smil/SmilElementType;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/auditude/ads/model/smil/SmilElementType;->ENUM$VALUES:[Lcom/auditude/ads/model/smil/SmilElementType;

    array-length v1, v0

    new-array v2, v1, [Lcom/auditude/ads/model/smil/SmilElementType;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
