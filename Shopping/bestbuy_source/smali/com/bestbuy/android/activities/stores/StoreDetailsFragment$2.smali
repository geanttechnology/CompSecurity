.class Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)V
    .locals 0

    .prologue
    .line 324
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$2;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4

    .prologue
    .line 328
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.CALL"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "tel:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$2;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-static {v3}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d(Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;)Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v3

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getPhone()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 329
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$2;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 330
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 331
    return-void
.end method
