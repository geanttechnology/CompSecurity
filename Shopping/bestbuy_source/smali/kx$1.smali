.class Lkx$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkx;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lkx;


# direct methods
.method constructor <init>(Lkx;)V
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lkx$1;->a:Lkx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lkx$1;->a:Lkx;

    invoke-virtual {v0}, Lkx;->dismiss()V

    .line 41
    return-void
.end method
