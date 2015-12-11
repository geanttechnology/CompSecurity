.class Lwu$1;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lwu;->a()V
.end annotation


# instance fields
.field final synthetic a:Lwu;


# direct methods
.method constructor <init>(Lwu;)V
    .locals 0

    iput-object p1, p0, Lwu$1;->a:Lwu;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    iget-object v0, p0, Lwu$1;->a:Lwu;

    invoke-virtual {v0}, Lwu;->b()Landroid/content/Intent;

    move-result-object v0

    iget-object v1, p0, Lwu$1;->a:Lwu;

    invoke-static {v1}, Lwu;->a(Lwu;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    return-void
.end method
