.class final Lcom/wishabi/flipp/widget/cl;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ck;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ck;)V
    .locals 0

    .prologue
    .line 187
    iput-object p1, p0, Lcom/wishabi/flipp/widget/cl;->a:Lcom/wishabi/flipp/widget/ck;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final afterTextChanged(Landroid/text/Editable;)V
    .locals 2

    .prologue
    .line 198
    if-nez p1, :cond_0

    .line 199
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cl;->a:Lcom/wishabi/flipp/widget/ck;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/wishabi/flipp/widget/ck;->e:Ljava/lang/String;

    .line 204
    :goto_0
    return-void

    .line 203
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cl;->a:Lcom/wishabi/flipp/widget/ck;

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/widget/ck;->e:Ljava/lang/String;

    goto :goto_0
.end method

.method public final beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 190
    return-void
.end method

.method public final onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 194
    return-void
.end method
