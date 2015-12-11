.class public Lcom/wishabi/flipp/app/dp;
.super Landroid/app/DialogFragment;
.source "SourceFile"


# instance fields
.field a:Lcom/wishabi/flipp/app/dq;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    .line 9
    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/wishabi/flipp/app/dp;->a:Lcom/wishabi/flipp/app/dq;

    if-eqz v0, :cond_0

    .line 22
    iget-object v0, p0, Lcom/wishabi/flipp/app/dp;->a:Lcom/wishabi/flipp/app/dq;

    invoke-interface {v0, p0}, Lcom/wishabi/flipp/app/dq;->a(Lcom/wishabi/flipp/app/dp;)V

    .line 24
    :cond_0
    invoke-super {p0, p1}, Landroid/app/DialogFragment;->onDismiss(Landroid/content/DialogInterface;)V

    .line 25
    return-void
.end method
