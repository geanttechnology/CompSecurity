.class Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;)V
    .locals 0

    .prologue
    .line 491
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 494
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 495
    return-void
.end method
