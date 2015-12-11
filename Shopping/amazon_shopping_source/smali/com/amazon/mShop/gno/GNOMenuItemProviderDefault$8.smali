.class Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$8;
.super Ljava/lang/Object;
.source "GNOMenuItemProviderDefault.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->getAIVItem(Landroid/content/Context;)Lcom/amazon/mShop/gno/GNODrawerItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/util/concurrent/Callable",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;)V
    .locals 0

    .prologue
    .line 379
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$8;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public call()Ljava/lang/Boolean;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 382
    const-string/jumbo v0, "en_US"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic call()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 379
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$8;->call()Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
