.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b()V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 332
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$5;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$5;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 335
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0, v1, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 336
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 337
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$5;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "http://www.bestbuy.com"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$5;->a:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 339
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$5;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V

    .line 340
    return-void
.end method
