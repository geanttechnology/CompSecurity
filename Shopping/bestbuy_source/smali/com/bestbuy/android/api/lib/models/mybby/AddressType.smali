.class public final enum Lcom/bestbuy/android/api/lib/models/mybby/AddressType;
.super Ljava/lang/Enum;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/bestbuy/android/api/lib/models/mybby/AddressType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

.field public static final enum rzEmail:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

.field public static final enum rzPhone:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

.field public static final enum rzPostal:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

.field public static final enum rzUnknown:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 11
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    const-string v1, "rzUnknown"

    invoke-direct {v0, v1, v2}, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->rzUnknown:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    .line 12
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    const-string v1, "rzPostal"

    invoke-direct {v0, v1, v3}, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->rzPostal:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    .line 13
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    const-string v1, "rzEmail"

    invoke-direct {v0, v1, v4}, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->rzEmail:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    .line 14
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    const-string v1, "rzPhone"

    invoke-direct {v0, v1, v5}, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->rzPhone:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    .line 10
    const/4 v0, 0x4

    new-array v0, v0, [Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    sget-object v1, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->rzUnknown:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->rzPostal:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->rzEmail:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->rzPhone:Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->$VALUES:[Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

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

.method public static valueOf(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/mybby/AddressType;
    .locals 1

    .prologue
    .line 10
    const-class v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    return-object v0
.end method

.method public static values()[Lcom/bestbuy/android/api/lib/models/mybby/AddressType;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->$VALUES:[Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    invoke-virtual {v0}, [Lcom/bestbuy/android/api/lib/models/mybby/AddressType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/bestbuy/android/api/lib/models/mybby/AddressType;

    return-object v0
.end method
