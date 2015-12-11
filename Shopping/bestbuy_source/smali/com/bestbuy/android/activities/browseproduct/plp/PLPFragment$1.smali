.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V
    .locals 0

    .prologue
    .line 301
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 304
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 305
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const/16 v2, 0x1388

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 306
    return-void
.end method
