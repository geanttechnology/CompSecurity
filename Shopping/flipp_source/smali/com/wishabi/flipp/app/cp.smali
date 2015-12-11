.class final Lcom/wishabi/flipp/app/cp;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cn;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cn;)V
    .locals 0

    .prologue
    .line 275
    iput-object p1, p0, Lcom/wishabi/flipp/app/cp;->a:Lcom/wishabi/flipp/app/cn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final afterTextChanged(Landroid/text/Editable;)V
    .locals 0

    .prologue
    .line 290
    return-void
.end method

.method public final beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 278
    return-void
.end method

.method public final onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 2

    .prologue
    .line 283
    iget-object v0, p0, Lcom/wishabi/flipp/app/cp;->a:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->c(Lcom/wishabi/flipp/app/cn;)Landroid/widget/Button;

    move-result-object v0

    if-nez v0, :cond_0

    .line 287
    :goto_0
    return-void

    .line 286
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/cp;->a:Lcom/wishabi/flipp/app/cn;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cn;->c(Lcom/wishabi/flipp/app/cn;)Landroid/widget/Button;

    move-result-object v0

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/wishabi/flipp/util/k;->d(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    goto :goto_0
.end method
