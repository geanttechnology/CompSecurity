.class final Lcom/wishabi/flipp/widget/co;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/cn;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/cn;)V
    .locals 0

    .prologue
    .line 62
    iput-object p1, p0, Lcom/wishabi/flipp/widget/co;->a:Lcom/wishabi/flipp/widget/cn;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 1

    .prologue
    .line 66
    packed-switch p2, :pswitch_data_0

    .line 72
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 68
    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/co;->a:Lcom/wishabi/flipp/widget/cn;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/cn;->n:Lcom/wishabi/flipp/widget/cw;

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/widget/co;->a:Lcom/wishabi/flipp/widget/cn;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/cn;->n:Lcom/wishabi/flipp/widget/cw;

    invoke-interface {v0}, Lcom/wishabi/flipp/widget/cw;->a()V

    .line 70
    :cond_0
    const/4 v0, 0x1

    goto :goto_0

    .line 66
    :pswitch_data_0
    .packed-switch 0x6
        :pswitch_0
    .end packed-switch
.end method
