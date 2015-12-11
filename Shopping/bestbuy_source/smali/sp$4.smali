.class Lsp$4;
.super Landroid/content/BroadcastReceiver;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lsp;->a()V
.end annotation


# instance fields
.field final synthetic a:Lsp;


# direct methods
.method constructor <init>(Lsp;)V
    .locals 0

    iput-object p1, p0, Lsp$4;->a:Lsp;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2

    iget-object v0, p0, Lsp$4;->a:Lsp;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lsp;->b(Z)V

    return-void
.end method
