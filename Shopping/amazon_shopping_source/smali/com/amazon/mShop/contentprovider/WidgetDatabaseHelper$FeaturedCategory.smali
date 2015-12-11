.class enum Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;
.super Ljava/lang/Enum;
.source "WidgetDatabaseHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x400a
    name = "FeaturedCategory"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

.field public static final enum AIV_CONTENT_CATEGORY:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

.field public static final enum MSHOP_CONTENT_CATEGORY:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 78
    new-instance v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory$1;

    const-string/jumbo v1, "MSHOP_CONTENT_CATEGORY"

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory$1;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->MSHOP_CONTENT_CATEGORY:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    .line 84
    new-instance v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory$2;

    const-string/jumbo v1, "AIV_CONTENT_CATEGORY"

    invoke-direct {v0, v1, v3}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory$2;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->AIV_CONTENT_CATEGORY:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    .line 77
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    sget-object v1, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->MSHOP_CONTENT_CATEGORY:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->AIV_CONTENT_CATEGORY:Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->$VALUES:[Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

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
    .line 77
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;ILcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$1;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/String;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$1;

    .prologue
    .line 77
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 77
    const-class v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    return-object v0
.end method

.method public static values()[Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;
    .locals 1

    .prologue
    .line 77
    sget-object v0, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->$VALUES:[Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    invoke-virtual {v0}, [Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;

    return-object v0
.end method
