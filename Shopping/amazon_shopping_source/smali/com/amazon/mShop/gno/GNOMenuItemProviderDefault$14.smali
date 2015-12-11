.class Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$14;
.super Ljava/lang/Object;
.source "GNOMenuItemProviderDefault.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->navigateOnClick(Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;

.field final synthetic val$params:Ljava/util/Map;

.field final synthetic val$target:Lcom/amazon/mShop/navigation/AppNavigator$Target;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 614
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$14;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$14;->val$target:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    iput-object p3, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$14;->val$params:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 2
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 617
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$14;->val$target:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$14;->val$params:Ljava/util/Map;

    invoke-static {p1, v0, v1}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    .line 618
    return-void
.end method
