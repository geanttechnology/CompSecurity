.class final enum Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;
.super Ljava/lang/Enum;
.source "GNOItemAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNOItemAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "DividerType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

.field public static final enum DIVIDER:Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

.field public static final enum SUB_DIVIDER:Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;


# instance fields
.field private mValue:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 74
    new-instance v0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    const-string/jumbo v1, "DIVIDER"

    invoke-direct {v0, v1, v2, v2}, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->DIVIDER:Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    .line 75
    new-instance v0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    const-string/jumbo v1, "SUB_DIVIDER"

    invoke-direct {v0, v1, v3, v3}, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->SUB_DIVIDER:Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    .line 73
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    sget-object v1, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->DIVIDER:Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->SUB_DIVIDER:Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->$VALUES:[Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "value"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 79
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 80
    iput p3, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->mValue:I

    .line 81
    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    .prologue
    .line 73
    iget v0, p0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->mValue:I

    return v0
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 73
    const-class v0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;
    .locals 1

    .prologue
    .line 73
    sget-object v0, Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->$VALUES:[Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/gno/GNOItemAdapter$DividerType;

    return-object v0
.end method
