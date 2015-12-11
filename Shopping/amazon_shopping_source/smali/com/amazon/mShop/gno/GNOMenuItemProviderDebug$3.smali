.class Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$3;
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
    .line 80
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug$3;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDebug;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/gno/GNODrawer;)V
    .locals 0
    .param p1, "callingActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "drawer"    # Lcom/amazon/mShop/gno/GNODrawer;

    .prologue
    .line 83
    invoke-static {p1}, Lcom/amazon/mShop/util/DebugUtil;->overrideWeblabAssignment(Landroid/content/Context;)V

    .line 84
    return-void
.end method
