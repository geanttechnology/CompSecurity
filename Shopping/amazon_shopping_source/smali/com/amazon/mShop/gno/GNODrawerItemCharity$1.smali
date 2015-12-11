.class Lcom/amazon/mShop/gno/GNODrawerItemCharity$1;
.super Ljava/lang/Object;
.source "GNODrawerItemCharity.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNODrawerItemCharity;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/Callable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNODrawerItemCharity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNODrawerItemCharity;)V
    .locals 0

    .prologue
    .line 45
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNODrawerItemCharity$1;->this$0:Lcom/amazon/mShop/gno/GNODrawerItemCharity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 2
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 48
    sget-object v0, Lcom/amazon/mShop/navigation/AppNavigator$Target;->charity:Lcom/amazon/mShop/navigation/AppNavigator$Target;

    const/4 v1, 0x0

    invoke-static {p1, v0, v1}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;Ljava/util/Map;)V

    .line 49
    return-void
.end method
