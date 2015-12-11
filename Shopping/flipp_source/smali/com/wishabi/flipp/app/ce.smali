.class final Lcom/wishabi/flipp/app/ce;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnKeyListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cd;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cd;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/wishabi/flipp/app/ce;->a:Lcom/wishabi/flipp/app/cd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onKey(Landroid/content/DialogInterface;ILandroid/view/KeyEvent;)Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 80
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    const/4 v2, 0x4

    if-ne v1, v2, :cond_1

    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-ne v1, v0, :cond_1

    .line 82
    iget-object v1, p0, Lcom/wishabi/flipp/app/ce;->a:Lcom/wishabi/flipp/app/cd;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/cd;->getChildFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->popBackStackImmediate()Z

    move-result v1

    if-nez v1, :cond_0

    .line 83
    iget-object v1, p0, Lcom/wishabi/flipp/app/ce;->a:Lcom/wishabi/flipp/app/cd;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/cd;->getDialog()Landroid/app/Dialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Dialog;->dismiss()V

    .line 86
    :cond_0
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
