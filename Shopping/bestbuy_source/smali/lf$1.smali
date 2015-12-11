.class Llf$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Llf;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Llf;


# direct methods
.method constructor <init>(Llf;)V
    .locals 0

    .prologue
    .line 36
    iput-object p1, p0, Llf$1;->a:Llf;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 2

    .prologue
    .line 38
    iget-object v0, p0, Llf$1;->a:Llf;

    invoke-virtual {v0}, Llf;->dismiss()V

    .line 39
    iget-object v0, p0, Llf$1;->a:Llf;

    invoke-static {v0}, Llf;->a(Llf;)Llg;

    move-result-object v0

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Llg;->a(Z)V

    .line 40
    return-void
.end method
