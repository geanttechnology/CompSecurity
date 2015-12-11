.class final enum Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;
.super Ljava/lang/Enum;
.source "ViewItItemView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/viewit/ViewItItemView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "ItemShowType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

.field public static final enum ITEM_SHOW_IN_ALL_MATCHES:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

.field public static final enum ITME_SHOW_AS_GROUP:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 38
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    const-string/jumbo v1, "ITME_SHOW_AS_GROUP"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITME_SHOW_AS_GROUP:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    .line 39
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    const-string/jumbo v1, "ITEM_SHOW_IN_ALL_MATCHES"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITEM_SHOW_IN_ALL_MATCHES:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    .line 37
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    sget-object v1, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITME_SHOW_AS_GROUP:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->ITEM_SHOW_IN_ALL_MATCHES:Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->$VALUES:[Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

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
    .line 37
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 37
    const-class v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->$VALUES:[Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    invoke-virtual {v0}, [Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/search/viewit/ViewItItemView$ItemShowType;

    return-object v0
.end method
