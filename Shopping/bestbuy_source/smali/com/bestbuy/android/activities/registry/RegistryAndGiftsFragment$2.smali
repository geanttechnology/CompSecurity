.class Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->a(Z)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;)V
    .locals 0

    .prologue
    .line 322
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment$2;->a:Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 325
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 326
    return-void
.end method
