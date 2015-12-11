.class public final enum Lcom/comcast/cim/android/view/common/SortType;
.super Ljava/lang/Enum;
.source "SortType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/cim/android/view/common/SortType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/cim/android/view/common/SortType;

.field public static final enum HD:Lcom/comcast/cim/android/view/common/SortType;

.field public static final enum PRICE:Lcom/comcast/cim/android/view/common/SortType;

.field public static final enum RANK:Lcom/comcast/cim/android/view/common/SortType;

.field public static final enum RELEASE_DATE:Lcom/comcast/cim/android/view/common/SortType;

.field public static final enum TITLE:Lcom/comcast/cim/android/view/common/SortType;

.field public static final enum YEAR:Lcom/comcast/cim/android/view/common/SortType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 4
    new-instance v0, Lcom/comcast/cim/android/view/common/SortType;

    const-string v1, "TITLE"

    invoke-direct {v0, v1, v3}, Lcom/comcast/cim/android/view/common/SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/view/common/SortType;->TITLE:Lcom/comcast/cim/android/view/common/SortType;

    .line 5
    new-instance v0, Lcom/comcast/cim/android/view/common/SortType;

    const-string v1, "RANK"

    invoke-direct {v0, v1, v4}, Lcom/comcast/cim/android/view/common/SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/view/common/SortType;->RANK:Lcom/comcast/cim/android/view/common/SortType;

    .line 6
    new-instance v0, Lcom/comcast/cim/android/view/common/SortType;

    const-string v1, "PRICE"

    invoke-direct {v0, v1, v5}, Lcom/comcast/cim/android/view/common/SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/view/common/SortType;->PRICE:Lcom/comcast/cim/android/view/common/SortType;

    .line 7
    new-instance v0, Lcom/comcast/cim/android/view/common/SortType;

    const-string v1, "HD"

    invoke-direct {v0, v1, v6}, Lcom/comcast/cim/android/view/common/SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/view/common/SortType;->HD:Lcom/comcast/cim/android/view/common/SortType;

    .line 8
    new-instance v0, Lcom/comcast/cim/android/view/common/SortType;

    const-string v1, "YEAR"

    invoke-direct {v0, v1, v7}, Lcom/comcast/cim/android/view/common/SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/view/common/SortType;->YEAR:Lcom/comcast/cim/android/view/common/SortType;

    .line 9
    new-instance v0, Lcom/comcast/cim/android/view/common/SortType;

    const-string v1, "RELEASE_DATE"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/android/view/common/SortType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/android/view/common/SortType;->RELEASE_DATE:Lcom/comcast/cim/android/view/common/SortType;

    .line 3
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/comcast/cim/android/view/common/SortType;

    sget-object v1, Lcom/comcast/cim/android/view/common/SortType;->TITLE:Lcom/comcast/cim/android/view/common/SortType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/cim/android/view/common/SortType;->RANK:Lcom/comcast/cim/android/view/common/SortType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/cim/android/view/common/SortType;->PRICE:Lcom/comcast/cim/android/view/common/SortType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/cim/android/view/common/SortType;->HD:Lcom/comcast/cim/android/view/common/SortType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/cim/android/view/common/SortType;->YEAR:Lcom/comcast/cim/android/view/common/SortType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/cim/android/view/common/SortType;->RELEASE_DATE:Lcom/comcast/cim/android/view/common/SortType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/cim/android/view/common/SortType;->$VALUES:[Lcom/comcast/cim/android/view/common/SortType;

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
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/SortType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/comcast/cim/android/view/common/SortType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/view/common/SortType;

    return-object v0
.end method

.method public static values()[Lcom/comcast/cim/android/view/common/SortType;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/comcast/cim/android/view/common/SortType;->$VALUES:[Lcom/comcast/cim/android/view/common/SortType;

    invoke-virtual {v0}, [Lcom/comcast/cim/android/view/common/SortType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/android/view/common/SortType;

    return-object v0
.end method
