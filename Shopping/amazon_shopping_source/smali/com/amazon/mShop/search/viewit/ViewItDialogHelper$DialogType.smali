.class public final enum Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
.super Ljava/lang/Enum;
.source "ViewItDialogHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "DialogType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field public static final enum ERROR_FLOW_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field public static final enum ERROR_MSHOP_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field public static final enum ERROR_NETWORK:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field public static final enum ERROR_NO_MATCHED_ITEM:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field public static final enum ERROR_NO_OBJECT_FOUND:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field public static final enum ERROR_PAUSE:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field public static final enum ERROR_UNAUTHORIZED:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field public static final enum ERROR_UNKNOWN:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

.field public static final enum PUBLIC_DATA_MATRIX_INFO:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 83
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    const-string/jumbo v1, "ERROR_NETWORK"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NETWORK:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 84
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    const-string/jumbo v1, "ERROR_UNAUTHORIZED"

    invoke-direct {v0, v1, v4}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_UNAUTHORIZED:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 85
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    const-string/jumbo v1, "ERROR_FLOW_SERVER"

    invoke-direct {v0, v1, v5}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_FLOW_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 86
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    const-string/jumbo v1, "ERROR_MSHOP_SERVER"

    invoke-direct {v0, v1, v6}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_MSHOP_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 87
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    const-string/jumbo v1, "ERROR_NO_MATCHED_ITEM"

    invoke-direct {v0, v1, v7}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NO_MATCHED_ITEM:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 88
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    const-string/jumbo v1, "ERROR_NO_OBJECT_FOUND"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NO_OBJECT_FOUND:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 89
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    const-string/jumbo v1, "ERROR_PAUSE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_PAUSE:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 90
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    const-string/jumbo v1, "ERROR_UNKNOWN"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_UNKNOWN:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 91
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    const-string/jumbo v1, "PUBLIC_DATA_MATRIX_INFO"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->PUBLIC_DATA_MATRIX_INFO:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    .line 82
    const/16 v0, 0x9

    new-array v0, v0, [Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    sget-object v1, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NETWORK:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_UNAUTHORIZED:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_FLOW_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_MSHOP_SERVER:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NO_MATCHED_ITEM:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NO_OBJECT_FOUND:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_PAUSE:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_UNKNOWN:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->PUBLIC_DATA_MATRIX_INFO:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->$VALUES:[Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

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
    .line 82
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 82
    const-class v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;
    .locals 1

    .prologue
    .line 82
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->$VALUES:[Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    return-object v0
.end method
