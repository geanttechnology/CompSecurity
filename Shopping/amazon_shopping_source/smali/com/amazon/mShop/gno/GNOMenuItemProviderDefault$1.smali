.class Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$1;
.super Ljava/lang/Object;
.source "GNOMenuItemProviderDefault.java"

# interfaces
.implements Ljava/util/concurrent/Callable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;->buildDefaultMenuItems(Landroid/content/Context;)V
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

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 155
    iput-object p1, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$1;->this$0:Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault;

    iput-object p2, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$1;->val$context:Landroid/content/Context;

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
    .line 158
    iget-object v0, p0, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$1;->val$context:Landroid/content/Context;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasGoldbox:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

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
    .line 155
    invoke-virtual {p0}, Lcom/amazon/mShop/gno/GNOMenuItemProviderDefault$1;->call()Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
