.class Llj$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Llj;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Llj;


# direct methods
.method constructor <init>(Llj;)V
    .locals 0

    .prologue
    .line 32
    iput-object p1, p0, Llj$1;->a:Llj;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Llj$1;->a:Llj;

    invoke-virtual {v0}, Llj;->dismiss()V

    .line 35
    return-void
.end method
