.class final enum Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory$1;
.super Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;
.source "WidgetDatabaseHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4008
    name = null
.end annotation


# direct methods
.method constructor <init>(Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 78
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory;-><init>(Ljava/lang/String;ILcom/amazon/mShop/contentprovider/WidgetDatabaseHelper$1;)V

    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    const-string/jumbo v0, "mshop_shoveler_item"

    return-object v0
.end method
