.class public final enum Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;
.super Ljava/lang/Enum;
.source "AvailabilityMetaData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/utils/meta_data/AvailabilityMetaData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AVAILABILITY_TYPE"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

.field public static final enum ALL:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

.field public static final enum SOLD:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

.field public static final enum UNSOLD:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 16
    new-instance v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    const-string v1, "ALL"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->ALL:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    new-instance v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    const-string v1, "UNSOLD"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->UNSOLD:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    new-instance v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    const-string v1, "SOLD"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->SOLD:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    sget-object v1, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->ALL:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->UNSOLD:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->SOLD:Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    aput-object v1, v0, v4

    sput-object v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->$VALUES:[Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

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
    .line 16
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 16
    const-class v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;
    .locals 1

    .prologue
    .line 16
    sget-object v0, Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->$VALUES:[Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    invoke-virtual {v0}, [Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/utils/meta_data/AvailabilityMetaData$AVAILABILITY_TYPE;

    return-object v0
.end method
