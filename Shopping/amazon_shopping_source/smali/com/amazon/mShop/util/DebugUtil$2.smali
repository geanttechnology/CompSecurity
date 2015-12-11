.class final Lcom/amazon/mShop/util/DebugUtil$2;
.super Ljava/lang/Object;
.source "DebugUtil.java"

# interfaces
.implements Lcom/amazon/mShop/feature/FeatureStateSubscriber;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/util/DebugUtil;->requestNewWeblabAssignment(Landroid/content/Context;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$context:Landroid/content/Context;

.field final synthetic val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/AmazonAlertDialog;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 84
    iput-object p1, p0, Lcom/amazon/mShop/util/DebugUtil$2;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    iput-object p2, p0, Lcom/amazon/mShop/util/DebugUtil$2;->val$context:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel()V
    .locals 2

    .prologue
    .line 102
    iget-object v0, p0, Lcom/amazon/mShop/util/DebugUtil$2;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 103
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/feature/Features;->removeFeatureStateSubscriber(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V

    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/util/DebugUtil$2;->val$context:Landroid/content/Context;

    const-string/jumbo v1, "onCancel"

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;Ljava/lang/String;)V

    .line 105
    return-void
.end method

.method public onError(Ljava/lang/Exception;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 95
    iget-object v0, p0, Lcom/amazon/mShop/util/DebugUtil$2;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 96
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/feature/Features;->removeFeatureStateSubscriber(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V

    .line 97
    iget-object v0, p0, Lcom/amazon/mShop/util/DebugUtil$2;->val$context:Landroid/content/Context;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "Error "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;Ljava/lang/String;)V

    .line 98
    return-void
.end method

.method public onFeatureStateReceived(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Feature;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 88
    .local p1, "features":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Feature;>;"
    iget-object v0, p0, Lcom/amazon/mShop/util/DebugUtil$2;->val$dialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 89
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/feature/Features;->removeFeatureStateSubscriber(Lcom/amazon/mShop/feature/FeatureStateSubscriber;)V

    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/util/DebugUtil$2;->val$context:Landroid/content/Context;

    const-string/jumbo v1, "OK: Weblab Assignment Done!"

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;Ljava/lang/String;)V

    .line 91
    return-void
.end method
