.class final enum Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;
.super Ljava/lang/Enum;
.source "WidgetDatabaseHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "DealCategory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

.field public static final enum FEATURED:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

.field public static final enum S9:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 104
    new-instance v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    const-string/jumbo v1, "FEATURED"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;->FEATURED:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    new-instance v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    const-string/jumbo v1, "S9"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;->S9:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    .line 103
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    sget-object v1, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;->FEATURED:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;->S9:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;->$VALUES:[Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

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
    .line 103
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 103
    const-class v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;
    .locals 1

    .prologue
    .line 103
    sget-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;->$VALUES:[Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    invoke-virtual {v0}, [Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory;

    return-object v0
.end method
