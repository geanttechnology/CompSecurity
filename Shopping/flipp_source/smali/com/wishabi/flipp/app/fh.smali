.class final Lcom/wishabi/flipp/app/fh;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Landroid/view/View;

.field final synthetic b:Lcom/wishabi/flipp/app/fg;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/fg;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 58
    iput-object p1, p0, Lcom/wishabi/flipp/app/fh;->b:Lcom/wishabi/flipp/app/fg;

    iput-object p2, p0, Lcom/wishabi/flipp/app/fh;->a:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 61
    iget-object v1, p0, Lcom/wishabi/flipp/app/fh;->a:Landroid/view/View;

    iget-object v0, p0, Lcom/wishabi/flipp/app/fh;->b:Lcom/wishabi/flipp/app/fg;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fg;->a(Lcom/wishabi/flipp/app/fg;)Landroid/widget/CheckBox;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    invoke-virtual {v1, v0}, Landroid/view/View;->setVisibility(I)V

    .line 63
    return-void

    .line 61
    :cond_0
    const/16 v0, 0x8

    goto :goto_0
.end method
