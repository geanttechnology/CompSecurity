.class public final enum Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

.field public static final enum CAPIOrderHistory12Month:Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

.field public static final enum CAPIOrderHistory3Month:Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

.field public static final enum CAPIOrderHistory6Month:Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 11
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    const-string v1, "CAPIOrderHistory3Month"

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;->CAPIOrderHistory3Month:Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    .line 12
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    const-string v1, "CAPIOrderHistory6Month"

    invoke-direct {v0, v1, v3}, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;->CAPIOrderHistory6Month:Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    .line 13
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    const-string v1, "CAPIOrderHistory12Month"

    invoke-direct {v0, v1, v4}, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;->CAPIOrderHistory12Month:Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    .line 10
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;->CAPIOrderHistory3Month:Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;->CAPIOrderHistory6Month:Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;->CAPIOrderHistory12Month:Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;->$VALUES:[Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

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
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;
    .locals 1

    .prologue
    .line 10
    const-class v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    return-object v0
.end method

.method public static values()[Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;->$VALUES:[Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    invoke-virtual {v0}, [Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/bestbuy/android/api/lib/models/capi/lookup/OrderHistoryType;

    return-object v0
.end method
