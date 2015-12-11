.class Lcom/amazon/mShop/AmazonApplication$2;
.super Ljava/lang/Object;
.source "AmazonApplication.java"

# interfaces
.implements Landroid/content/ComponentCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/AmazonApplication;->setConfigCallbackForViewRoot()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/AmazonApplication;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonApplication;)V
    .locals 0

    .prologue
    .line 387
    iput-object p1, p0, Lcom/amazon/mShop/AmazonApplication$2;->this$0:Lcom/amazon/mShop/AmazonApplication;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 393
    invoke-static {p1}, Lcom/amazon/mShop/util/LocaleUtils;->ensureConfigLocale(Landroid/content/res/Configuration;)V

    .line 397
    iget-object v0, p0, Lcom/amazon/mShop/AmazonApplication$2;->this$0:Lcom/amazon/mShop/AmazonApplication;

    invoke-static {v0}, Lcom/amazon/mShop/util/LocaleUtils;->ensureAppLocale(Landroid/content/Context;)V

    .line 398
    return-void
.end method

.method public onLowMemory()V
    .locals 0

    .prologue
    .line 402
    return-void
.end method
