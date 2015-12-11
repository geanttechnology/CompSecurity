.class final Lcom/wishabi/flipp/app/fm;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/fg;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/fg;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/wishabi/flipp/app/fm;->a:Lcom/wishabi/flipp/app/fg;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final afterTextChanged(Landroid/text/Editable;)V
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/wishabi/flipp/app/fm;->a:Lcom/wishabi/flipp/app/fg;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fg;->e(Lcom/wishabi/flipp/app/fg;)V

    .line 160
    return-void
.end method

.method public final beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 164
    return-void
.end method

.method public final onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 168
    return-void
.end method
