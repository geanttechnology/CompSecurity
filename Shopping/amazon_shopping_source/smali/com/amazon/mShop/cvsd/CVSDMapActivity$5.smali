.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$5;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->requestUserConfigLocationProvider()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V
    .locals 0

    .prologue
    .line 370
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$5;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 373
    const/4 v3, -0x2

    if-ne p2, v3, :cond_1

    .line 374
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$5;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->createSearchOptionDialog()V
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$000(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    .line 390
    :cond_0
    :goto_0
    return-void

    .line 377
    :cond_1
    const/4 v3, -0x1

    if-ne p2, v3, :cond_0

    .line 378
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v3, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 380
    .local v1, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$5;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 381
    .local v2, "packageMgr":Landroid/content/pm/PackageManager;
    const/high16 v3, 0x10000

    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 383
    .local v0, "activities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    if-eqz v0, :cond_2

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_2

    .line 384
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$5;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    const/16 v4, 0x9

    invoke-virtual {v3, v1, v4}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 386
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$5;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->showDialogRequestingUserToConfigLocationSettingsManually()V
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$500(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)V

    goto :goto_0
.end method
