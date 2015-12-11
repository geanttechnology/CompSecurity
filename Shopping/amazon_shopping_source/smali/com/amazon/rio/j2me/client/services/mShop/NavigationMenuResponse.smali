.class public Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;
.super Ljava/lang/Object;
.source "NavigationMenuResponse.java"


# instance fields
.field private menuItems:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMenuItems()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;",
            ">;"
        }
    .end annotation

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;->menuItems:Ljava/util/List;

    return-object v0
.end method

.method public setMenuItems(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 22
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/NavMenuItem;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuResponse;->menuItems:Ljava/util/List;

    .line 23
    return-void
.end method
