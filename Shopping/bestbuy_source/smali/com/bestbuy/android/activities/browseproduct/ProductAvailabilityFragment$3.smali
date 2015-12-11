.class Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 483
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$3;->b:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$3;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 486
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://www.bestbuy.com"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$3;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 487
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 488
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$3;->b:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->startActivity(Landroid/content/Intent;)V

    .line 489
    return-void
.end method
