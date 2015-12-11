.class final Lcom/wishabi/flipp/app/dj;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/af;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/MainActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/MainActivity;)V
    .locals 0

    .prologue
    .line 464
    iput-object p1, p0, Lcom/wishabi/flipp/app/dj;->a:Lcom/wishabi/flipp/app/MainActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 4

    .prologue
    .line 474
    iget-object v0, p0, Lcom/wishabi/flipp/app/dj;->a:Lcom/wishabi/flipp/app/MainActivity;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/wishabi/flipp/app/dj;->a:Lcom/wishabi/flipp/app/MainActivity;

    const-class v3, Lcom/wishabi/flipp/app/HelpActivity;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 475
    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 468
    iget-object v0, p0, Lcom/wishabi/flipp/app/dj;->a:Lcom/wishabi/flipp/app/MainActivity;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/app/MainActivity;->a(Ljava/lang/String;)V

    .line 469
    iget-object v0, p0, Lcom/wishabi/flipp/app/dj;->a:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/MainActivity;->b(Lcom/wishabi/flipp/app/MainActivity;)Landroid/support/v4/widget/DrawerLayout;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/widget/DrawerLayout;->a(Z)V

    .line 470
    return-void
.end method

.method public final b()V
    .locals 2

    .prologue
    .line 479
    iget-object v0, p0, Lcom/wishabi/flipp/app/dj;->a:Lcom/wishabi/flipp/app/MainActivity;

    invoke-static {}, Lcom/wishabi/flipp/app/PrintCouponActivity;->a()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/MainActivity;->startActivity(Landroid/content/Intent;)V

    .line 480
    return-void
.end method
