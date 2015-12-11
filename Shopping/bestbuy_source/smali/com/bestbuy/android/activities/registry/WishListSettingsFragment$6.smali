.class Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->e()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;)V
    .locals 0

    .prologue
    .line 282
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment$6;->a:Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0

    .prologue
    .line 285
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 286
    return-void
.end method
