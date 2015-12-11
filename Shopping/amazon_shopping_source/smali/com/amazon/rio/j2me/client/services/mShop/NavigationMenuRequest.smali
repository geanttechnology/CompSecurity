.class public Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;
.super Ljava/lang/Object;
.source "NavigationMenuRequest.java"


# instance fields
.field private menuId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMenuId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;->menuId:Ljava/lang/String;

    return-object v0
.end method

.method public setMenuId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 22
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/NavigationMenuRequest;->menuId:Ljava/lang/String;

    .line 23
    return-void
.end method
