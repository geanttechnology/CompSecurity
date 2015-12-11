.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->b()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;)V
    .locals 0

    .prologue
    .line 274
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    const/4 v1, 0x1

    .line 277
    new-instance v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v0, v1, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 278
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 279
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f080055

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    iget-object v3, v3, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->d:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080315

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 281
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V

    .line 282
    return-void
.end method
