.class Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->j()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;)V
    .locals 0

    .prologue
    .line 574
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$3;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 576
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.LOCATION_SOURCE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 577
    iget-object v1, p0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment$3;->a:Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d:Landroid/app/Activity;

    const/16 v2, 0x3e8

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 578
    return-void
.end method
