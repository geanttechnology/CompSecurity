.class Lkw$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkw;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lkw;


# direct methods
.method constructor <init>(Lkw;)V
    .locals 0

    .prologue
    .line 34
    iput-object p1, p0, Lkw$1;->a:Lkw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 36
    iget-object v0, p0, Lkw$1;->a:Lkw;

    invoke-virtual {v0}, Lkw;->dismiss()V

    .line 37
    return-void
.end method
