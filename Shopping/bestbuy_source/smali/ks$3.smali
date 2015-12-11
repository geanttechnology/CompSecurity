.class Lks$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lks;->a()V
.end annotation


# instance fields
.field final synthetic a:Lks;


# direct methods
.method constructor <init>(Lks;)V
    .locals 0

    .prologue
    .line 61
    iput-object p1, p0, Lks$3;->a:Lks;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lks$3;->a:Lks;

    invoke-static {v0}, Lks;->b(Lks;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->c()V

    .line 65
    return-void
.end method
