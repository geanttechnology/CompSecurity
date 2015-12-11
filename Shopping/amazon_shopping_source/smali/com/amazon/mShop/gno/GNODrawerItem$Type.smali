.class public final enum Lcom/amazon/mShop/gno/GNODrawerItem$Type;
.super Ljava/lang/Enum;
.source "GNODrawerItem.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/gno/GNODrawerItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Type"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/gno/GNODrawerItem$Type;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/gno/GNODrawerItem$Type;

.field public static final enum APPSTORE_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

.field public static final enum AUTHENTICATION:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

.field public static final enum CHARITY:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

.field public static final enum FAKE_GROUP_ANIMATION:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

.field public static final enum SIMPLE_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

.field public static final enum SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

.field public static final enum SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

.field public static final enum SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;


# instance fields
.field private mResId:I


# direct methods
.method static constructor <clinit>()V
    .locals 9

    .prologue
    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 95
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    const-string/jumbo v1, "SIMPLE_ITEM"

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_simple:I

    invoke-direct {v0, v1, v4, v2}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SIMPLE_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 96
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    const-string/jumbo v1, "SUB_ITEM"

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_sub_item:I

    invoke-direct {v0, v1, v5, v2}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 97
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    const-string/jumbo v1, "SUB_HEADER"

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_sub_header:I

    invoke-direct {v0, v1, v6, v2}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 98
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    const-string/jumbo v1, "SUB_SUB_HEADER"

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_sub_sub_header:I

    invoke-direct {v0, v1, v7, v2}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 99
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    const-string/jumbo v1, "AUTHENTICATION"

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_simple:I

    invoke-direct {v0, v1, v8, v2}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->AUTHENTICATION:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 100
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    const-string/jumbo v1, "CHARITY"

    const/4 v2, 0x5

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_simple:I

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->CHARITY:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 101
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    const-string/jumbo v1, "APPSTORE_HEADER"

    const/4 v2, 0x6

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->gno_drawer_item_appstore_header:I

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->APPSTORE_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 105
    new-instance v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    const-string/jumbo v1, "FAKE_GROUP_ANIMATION"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2, v4}, Lcom/amazon/mShop/gno/GNODrawerItem$Type;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->FAKE_GROUP_ANIMATION:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    .line 94
    const/16 v0, 0x8

    new-array v0, v0, [Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    sget-object v1, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SIMPLE_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    aput-object v1, v0, v4

    sget-object v1, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_ITEM:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    aput-object v1, v0, v5

    sget-object v1, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    aput-object v1, v0, v6

    sget-object v1, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->SUB_SUB_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    aput-object v1, v0, v7

    sget-object v1, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->AUTHENTICATION:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->CHARITY:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->APPSTORE_HEADER:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->FAKE_GROUP_ANIMATION:Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    aput-object v2, v0, v1

    sput-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->$VALUES:[Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "resourceId"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 110
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 111
    iput p3, p0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->mResId:I

    .line 112
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 94
    const-class v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/gno/GNODrawerItem$Type;
    .locals 1

    .prologue
    .line 94
    sget-object v0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->$VALUES:[Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    invoke-virtual {v0}, [Lcom/amazon/mShop/gno/GNODrawerItem$Type;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/gno/GNODrawerItem$Type;

    return-object v0
.end method


# virtual methods
.method public getLayoutId()I
    .locals 1

    .prologue
    .line 115
    iget v0, p0, Lcom/amazon/mShop/gno/GNODrawerItem$Type;->mResId:I

    return v0
.end method
