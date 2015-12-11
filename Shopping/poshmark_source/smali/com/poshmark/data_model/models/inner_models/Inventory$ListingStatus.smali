.class public final enum Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
.super Ljava/lang/Enum;
.source "Inventory.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/poshmark/data_model/models/inner_models/Inventory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ListingStatus"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

.field public static final enum AVAILABLE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

.field public static final enum NOT_FOR_SALE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

.field public static final enum RESERVED:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

.field public static final enum SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 6
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    const-string v1, "AVAILABLE"

    invoke-direct {v0, v1, v2}, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->AVAILABLE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    .line 7
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    const-string v1, "SOLD"

    invoke-direct {v0, v1, v3}, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    .line 8
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    const-string v1, "RESERVED"

    invoke-direct {v0, v1, v4}, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->RESERVED:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    .line 9
    new-instance v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    const-string v1, "NOT_FOR_SALE"

    invoke-direct {v0, v1, v5}, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->NOT_FOR_SALE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    .line 5
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->AVAILABLE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    aput-object v1, v0, v2

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->SOLD:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->RESERVED:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->NOT_FOR_SALE:Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    aput-object v1, v0, v5

    sput-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->$VALUES:[Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

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
    .line 5
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 5
    const-class v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    return-object v0
.end method

.method public static values()[Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;
    .locals 1

    .prologue
    .line 5
    sget-object v0, Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->$VALUES:[Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    invoke-virtual {v0}, [Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/poshmark/data_model/models/inner_models/Inventory$ListingStatus;

    return-object v0
.end method
