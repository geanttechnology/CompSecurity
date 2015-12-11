.class public final enum Lcom/flow/android/engine/library/constants/ConnectionType;
.super Ljava/lang/Enum;
.source "ConnectionType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/flow/android/engine/library/constants/ConnectionType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/flow/android/engine/library/constants/ConnectionType;

.field public static final enum CELL_25G:Lcom/flow/android/engine/library/constants/ConnectionType;

.field public static final enum CELL_2G:Lcom/flow/android/engine/library/constants/ConnectionType;

.field public static final enum CELL_3G:Lcom/flow/android/engine/library/constants/ConnectionType;

.field public static final enum CELL_4G:Lcom/flow/android/engine/library/constants/ConnectionType;

.field public static final enum UNKNOWN:Lcom/flow/android/engine/library/constants/ConnectionType;

.field public static final enum WIFI:Lcom/flow/android/engine/library/constants/ConnectionType;


# instance fields
.field private final networkName:Ljava/lang/String;

.field private final networkSubTypeGroup:[I

.field private final networkType:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 16

    .prologue
    const/4 v15, 0x3

    const/4 v14, 0x2

    const/4 v4, 0x0

    const/4 v7, 0x1

    const/4 v2, 0x0

    .line 14
    new-instance v0, Lcom/flow/android/engine/library/constants/ConnectionType;

    const-string/jumbo v1, "UNKNOWN"

    const-string/jumbo v3, "Unknown"

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/flow/android/engine/library/constants/ConnectionType;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[I)V

    sput-object v0, Lcom/flow/android/engine/library/constants/ConnectionType;->UNKNOWN:Lcom/flow/android/engine/library/constants/ConnectionType;

    new-instance v5, Lcom/flow/android/engine/library/constants/ConnectionType;

    const-string/jumbo v6, "WIFI"

    const-string/jumbo v8, "wifi"

    move-object v9, v4

    move-object v10, v4

    invoke-direct/range {v5 .. v10}, Lcom/flow/android/engine/library/constants/ConnectionType;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[I)V

    sput-object v5, Lcom/flow/android/engine/library/constants/ConnectionType;->WIFI:Lcom/flow/android/engine/library/constants/ConnectionType;

    .line 15
    new-instance v8, Lcom/flow/android/engine/library/constants/ConnectionType;

    const-string/jumbo v9, "CELL_2G"

    const-string/jumbo v11, "cellular"

    const-string/jumbo v12, "2G"

    new-array v13, v15, [I

    fill-array-data v13, :array_0

    move v10, v14

    invoke-direct/range {v8 .. v13}, Lcom/flow/android/engine/library/constants/ConnectionType;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[I)V

    sput-object v8, Lcom/flow/android/engine/library/constants/ConnectionType;->CELL_2G:Lcom/flow/android/engine/library/constants/ConnectionType;

    .line 16
    new-instance v8, Lcom/flow/android/engine/library/constants/ConnectionType;

    const-string/jumbo v9, "CELL_25G"

    const-string/jumbo v11, "cellular"

    const-string/jumbo v12, "2.5G"

    new-array v13, v7, [I

    aput v14, v13, v2

    move v10, v15

    invoke-direct/range {v8 .. v13}, Lcom/flow/android/engine/library/constants/ConnectionType;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[I)V

    sput-object v8, Lcom/flow/android/engine/library/constants/ConnectionType;->CELL_25G:Lcom/flow/android/engine/library/constants/ConnectionType;

    .line 18
    new-instance v8, Lcom/flow/android/engine/library/constants/ConnectionType;

    const-string/jumbo v9, "CELL_3G"

    const/4 v10, 0x4

    const-string/jumbo v11, "cellular"

    const-string/jumbo v12, "3G"

    const/4 v0, 0x7

    new-array v13, v0, [I

    fill-array-data v13, :array_1

    invoke-direct/range {v8 .. v13}, Lcom/flow/android/engine/library/constants/ConnectionType;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[I)V

    sput-object v8, Lcom/flow/android/engine/library/constants/ConnectionType;->CELL_3G:Lcom/flow/android/engine/library/constants/ConnectionType;

    .line 21
    new-instance v8, Lcom/flow/android/engine/library/constants/ConnectionType;

    const-string/jumbo v9, "CELL_4G"

    const/4 v10, 0x5

    const-string/jumbo v11, "cellular"

    const-string/jumbo v12, "4G"

    new-array v13, v7, [I

    const/16 v0, 0xd

    aput v0, v13, v2

    invoke-direct/range {v8 .. v13}, Lcom/flow/android/engine/library/constants/ConnectionType;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[I)V

    sput-object v8, Lcom/flow/android/engine/library/constants/ConnectionType;->CELL_4G:Lcom/flow/android/engine/library/constants/ConnectionType;

    .line 13
    const/4 v0, 0x6

    new-array v0, v0, [Lcom/flow/android/engine/library/constants/ConnectionType;

    sget-object v1, Lcom/flow/android/engine/library/constants/ConnectionType;->UNKNOWN:Lcom/flow/android/engine/library/constants/ConnectionType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/flow/android/engine/library/constants/ConnectionType;->WIFI:Lcom/flow/android/engine/library/constants/ConnectionType;

    aput-object v1, v0, v7

    sget-object v1, Lcom/flow/android/engine/library/constants/ConnectionType;->CELL_2G:Lcom/flow/android/engine/library/constants/ConnectionType;

    aput-object v1, v0, v14

    sget-object v1, Lcom/flow/android/engine/library/constants/ConnectionType;->CELL_25G:Lcom/flow/android/engine/library/constants/ConnectionType;

    aput-object v1, v0, v15

    const/4 v1, 0x4

    sget-object v2, Lcom/flow/android/engine/library/constants/ConnectionType;->CELL_3G:Lcom/flow/android/engine/library/constants/ConnectionType;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    sget-object v2, Lcom/flow/android/engine/library/constants/ConnectionType;->CELL_4G:Lcom/flow/android/engine/library/constants/ConnectionType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/flow/android/engine/library/constants/ConnectionType;->$VALUES:[Lcom/flow/android/engine/library/constants/ConnectionType;

    return-void

    .line 15
    nop

    :array_0
    .array-data 4
        0x1
        0x4
        0x7
    .end array-data

    .line 18
    :array_1
    .array-data 4
        0xe
        0x8
        0x9
        0x3
        0x5
        0x6
        0xc
    .end array-data
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[I)V
    .locals 0
    .param p3, "networkName"    # Ljava/lang/String;
    .param p4, "networkType"    # Ljava/lang/String;
    .param p5, "networkSubTypeGroup"    # [I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "[I)V"
        }
    .end annotation

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 28
    iput-object p5, p0, Lcom/flow/android/engine/library/constants/ConnectionType;->networkSubTypeGroup:[I

    .line 29
    iput-object p3, p0, Lcom/flow/android/engine/library/constants/ConnectionType;->networkName:Ljava/lang/String;

    .line 30
    iput-object p4, p0, Lcom/flow/android/engine/library/constants/ConnectionType;->networkType:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public static findGroupByTypeSubtypeId(II)Lcom/flow/android/engine/library/constants/ConnectionType;
    .locals 9
    .param p0, "networkTypeId"    # I
    .param p1, "networkSubTypeGroupId"    # I

    .prologue
    .line 34
    const/4 v8, 0x1

    if-ne p0, v8, :cond_1

    .line 35
    sget-object v2, Lcom/flow/android/engine/library/constants/ConnectionType;->WIFI:Lcom/flow/android/engine/library/constants/ConnectionType;

    .line 47
    :cond_0
    :goto_0
    return-object v2

    .line 37
    :cond_1
    invoke-static {}, Lcom/flow/android/engine/library/constants/ConnectionType;->values()[Lcom/flow/android/engine/library/constants/ConnectionType;

    move-result-object v0

    .local v0, "arr$":[Lcom/flow/android/engine/library/constants/ConnectionType;
    array-length v5, v0

    .local v5, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    move v4, v3

    .end local v0    # "arr$":[Lcom/flow/android/engine/library/constants/ConnectionType;
    .end local v3    # "i$":I
    .end local v5    # "len$":I
    .local v4, "i$":I
    :goto_1
    if-ge v4, v5, :cond_3

    aget-object v2, v0, v4

    .line 38
    .local v2, "conectionType":Lcom/flow/android/engine/library/constants/ConnectionType;
    iget-object v8, v2, Lcom/flow/android/engine/library/constants/ConnectionType;->networkSubTypeGroup:[I

    if-eqz v8, :cond_2

    iget-object v8, v2, Lcom/flow/android/engine/library/constants/ConnectionType;->networkSubTypeGroup:[I

    array-length v8, v8

    if-lez v8, :cond_2

    .line 39
    iget-object v1, v2, Lcom/flow/android/engine/library/constants/ConnectionType;->networkSubTypeGroup:[I

    .local v1, "arr$":[I
    array-length v6, v1

    .local v6, "len$":I
    const/4 v3, 0x0

    .end local v4    # "i$":I
    .restart local v3    # "i$":I
    :goto_2
    if-ge v3, v6, :cond_2

    aget v7, v1, v3

    .line 40
    .local v7, "typeId":I
    if-eq v7, p1, :cond_0

    .line 39
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 37
    .end local v1    # "arr$":[I
    .end local v3    # "i$":I
    .end local v6    # "len$":I
    .end local v7    # "typeId":I
    :cond_2
    add-int/lit8 v3, v4, 0x1

    .restart local v3    # "i$":I
    move v4, v3

    .end local v3    # "i$":I
    .restart local v4    # "i$":I
    goto :goto_1

    .line 47
    .end local v2    # "conectionType":Lcom/flow/android/engine/library/constants/ConnectionType;
    :cond_3
    sget-object v2, Lcom/flow/android/engine/library/constants/ConnectionType;->UNKNOWN:Lcom/flow/android/engine/library/constants/ConnectionType;

    goto :goto_0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/flow/android/engine/library/constants/ConnectionType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/flow/android/engine/library/constants/ConnectionType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/flow/android/engine/library/constants/ConnectionType;

    return-object v0
.end method

.method public static values()[Lcom/flow/android/engine/library/constants/ConnectionType;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/flow/android/engine/library/constants/ConnectionType;->$VALUES:[Lcom/flow/android/engine/library/constants/ConnectionType;

    invoke-virtual {v0}, [Lcom/flow/android/engine/library/constants/ConnectionType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/flow/android/engine/library/constants/ConnectionType;

    return-object v0
.end method


# virtual methods
.method public getNetworkName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/flow/android/engine/library/constants/ConnectionType;->networkName:Ljava/lang/String;

    return-object v0
.end method

.method public getNetworkType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/flow/android/engine/library/constants/ConnectionType;->networkType:Ljava/lang/String;

    return-object v0
.end method
