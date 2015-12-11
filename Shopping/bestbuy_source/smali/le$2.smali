.class Lle$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lle;->a()V
.end annotation


# instance fields
.field final synthetic a:Lle;


# direct methods
.method constructor <init>(Lle;)V
    .locals 0

    .prologue
    .line 26
    iput-object p1, p0, Lle$2;->a:Lle;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lle$2;->a:Lle;

    invoke-static {v0}, Lle;->a(Lle;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    if-eqz v0, :cond_0

    .line 30
    iget-object v0, p0, Lle$2;->a:Lle;

    invoke-static {v0}, Lle;->a(Lle;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->c()V

    .line 34
    :cond_0
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 35
    return-void
.end method
