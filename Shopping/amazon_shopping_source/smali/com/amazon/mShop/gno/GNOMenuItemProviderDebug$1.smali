.class final Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$1;
.super Ljava/lang/Object;
.source "GNOMenuItemProviderDebug.java"

# interfaces
.implements Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;->startActivity(Ljava/lang/Class;)Lcom/amazon/mShop/gno/GNODrawerItemSimple$GNOItemOnClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$clazz:Ljava/lang/Class;


# direct methods
.method constructor <init>(Ljava/lang/Class;)V
    .locals 0

    .prologue
    .line 49
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$1;->val$clazz:Ljava/lang/Class;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 3
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 52
    iget-object v1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$1;->val$clazz:Ljava/lang/Class;

    const/4 v2, -0x1

    invoke-static {p1, v1, v2}, Lcom/amazon/mShop/util/ActivityUtils;->getStartActivityIntent(Landroid/content/Context;Ljava/lang/Class;I)Landroid/content/Intent;

    move-result-object v0

    .line 53
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonActivity;->startActivity(Landroid/content/Intent;)V

    .line 54
    return-void
.end method
