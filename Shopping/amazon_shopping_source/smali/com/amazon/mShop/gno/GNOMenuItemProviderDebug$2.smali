.class Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$2;
.super Ljava/lang/Object;
.source "GNOMenuItemProviderDebug.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->buildItems(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$2;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 3
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 103
    invoke-static {}, Lamazon/android/dexload/SupplementalDexLoader;->getInstance()Lamazon/android/dexload/SupplementalDexLoader;

    move-result-object v1

    invoke-virtual {v1}, Lamazon/android/dexload/SupplementalDexLoader;->waitForLoad()V

    .line 104
    invoke-static {}, Lamazon/android/dexload/SupplementalDexLoader;->getInstance()Lamazon/android/dexload/SupplementalDexLoader;

    move-result-object v1

    const-string/jumbo v2, "com.amazon.venezia.web.BaseUrlOverrideActivity"

    invoke-virtual {v1, v2}, Lamazon/android/dexload/SupplementalDexLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 105
    .local v0, "c":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1, p1, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p1, v1}, Lcom/amazon/mShop/AmazonActivity;->startActivity(Landroid/content/Intent;)V

    .line 106
    return-void
.end method
