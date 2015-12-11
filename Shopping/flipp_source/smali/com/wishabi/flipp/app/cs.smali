.class final Lcom/wishabi/flipp/app/cs;
.super Lcom/wishabi/flipp/b/ag;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cr;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cr;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 311
    iput-object p1, p0, Lcom/wishabi/flipp/app/cs;->a:Lcom/wishabi/flipp/app/cr;

    invoke-direct {p0, p2}, Lcom/wishabi/flipp/b/ag;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected final a(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 314
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    const/4 v1, 0x5

    if-lt v0, v1, :cond_1

    .line 315
    iget-object v0, p0, Lcom/wishabi/flipp/app/cs;->a:Lcom/wishabi/flipp/app/cr;

    iget-object v0, v0, Lcom/wishabi/flipp/app/cr;->a:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->e(Lcom/wishabi/flipp/app/cn;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 333
    :cond_0
    :goto_0
    return-void

    .line 317
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/cs;->a:Lcom/wishabi/flipp/app/cr;

    iget-object v0, v0, Lcom/wishabi/flipp/app/cr;->a:Lcom/wishabi/flipp/app/cn;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/cn;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 318
    if-eqz v0, :cond_0

    .line 321
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v0, 0x7f0e00c0

    invoke-virtual {v1, v0}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x104000a

    new-instance v2, Lcom/wishabi/flipp/app/ct;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/ct;-><init>(Lcom/wishabi/flipp/app/cs;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_0
.end method
