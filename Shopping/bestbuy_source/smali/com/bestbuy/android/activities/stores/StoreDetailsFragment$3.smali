.class Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$3;
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
    .line 333
    iput-object p1, p0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment$3;->a:Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 337
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 338
    return-void
.end method
