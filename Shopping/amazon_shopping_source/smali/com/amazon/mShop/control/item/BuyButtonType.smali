.class public final Lcom/amazon/mShop/control/item/BuyButtonType;
.super Ljava/lang/Object;
.source "BuyButtonType.java"


# static fields
.field public static final ADD_TO_CART:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final ADD_TO_WISH_LIST:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final BUY_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final BUY_NOW_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final BUY_NOW_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final FRIEND_APP_BUTTON:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final PRE_ORDER_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final PRE_ORDER_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final PRE_ORDER_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final SEE_MORE_BUYING_OPTIONS:Lcom/amazon/mShop/control/item/BuyButtonType;

.field public static final SUBSCRIBER_AND_SAVE:Lcom/amazon/mShop/control/item/BuyButtonType;


# instance fields
.field private final type:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/16 v2, 0x41

    .line 78
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    const/16 v1, 0x42

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 84
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    const/16 v1, 0x22

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 94
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    const/16 v1, 0x222

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 101
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    invoke-direct {v0, v2}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 106
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    const/16 v1, 0x21

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 116
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    const/16 v1, 0x221

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 124
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    const/16 v1, 0x104

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->SEE_MORE_BUYING_OPTIONS:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 129
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    const/16 v1, 0x84

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->ADD_TO_CART:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 134
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    const/16 v1, 0x110

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->ADD_TO_WISH_LIST:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 139
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    const/16 v1, 0x108

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->FRIEND_APP_BUTTON:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 145
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonType;

    invoke-direct {v0, v2}, Lcom/amazon/mShop/control/item/BuyButtonType;-><init>(I)V

    sput-object v0, Lcom/amazon/mShop/control/item/BuyButtonType;->SUBSCRIBER_AND_SAVE:Lcom/amazon/mShop/control/item/BuyButtonType;

    return-void
.end method

.method private constructor <init>(I)V
    .locals 0
    .param p1, "type"    # I

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 8
    iput p1, p0, Lcom/amazon/mShop/control/item/BuyButtonType;->type:I

    .line 9
    return-void
.end method


# virtual methods
.method public getActionIcon()I
    .locals 1

    .prologue
    .line 15
    iget v0, p0, Lcom/amazon/mShop/control/item/BuyButtonType;->type:I

    and-int/lit16 v0, v0, 0x1e0

    return v0
.end method

.method public getStyleColor()I
    .locals 1

    .prologue
    .line 22
    iget v0, p0, Lcom/amazon/mShop/control/item/BuyButtonType;->type:I

    and-int/lit8 v0, v0, 0x1f

    return v0
.end method
