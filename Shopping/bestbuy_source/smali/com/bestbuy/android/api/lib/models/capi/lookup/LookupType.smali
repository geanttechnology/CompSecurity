.class public final enum Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

.field public static final enum CAPIOrderLookupBBY:Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

.field public static final enum CAPIOrderLookupCustomer:Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 11
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    const-string v1, "CAPIOrderLookupCustomer"

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;->CAPIOrderLookupCustomer:Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    .line 12
    new-instance v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    const-string v1, "CAPIOrderLookupBBY"

    invoke-direct {v0, v1, v3}, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;->CAPIOrderLookupBBY:Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    .line 10
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;->CAPIOrderLookupCustomer:Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;->CAPIOrderLookupBBY:Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;->$VALUES:[Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

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

.method public static valueOf(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;
    .locals 1

    .prologue
    .line 10
    const-class v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    return-object v0
.end method

.method public static values()[Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;->$VALUES:[Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    invoke-virtual {v0}, [Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/bestbuy/android/api/lib/models/capi/lookup/LookupType;

    return-object v0
.end method
