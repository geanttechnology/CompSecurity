.class final Lcom/wishabi/flipp/app/j;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/i;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/i;)V
    .locals 0

    .prologue
    .line 100
    iput-object p1, p0, Lcom/wishabi/flipp/app/j;->a:Lcom/wishabi/flipp/app/i;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 2

    .prologue
    .line 103
    iget-object v0, p0, Lcom/wishabi/flipp/app/j;->a:Lcom/wishabi/flipp/app/i;

    invoke-static {v0}, Lcom/wishabi/flipp/app/i;->a(Lcom/wishabi/flipp/app/i;)Lcom/wishabi/flipp/app/k;

    move-result-object v0

    if-nez v0, :cond_0

    .line 113
    :goto_0
    return-void

    .line 106
    :cond_0
    packed-switch p2, :pswitch_data_0

    goto :goto_0

    .line 108
    :pswitch_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/j;->a:Lcom/wishabi/flipp/app/i;

    invoke-static {v0}, Lcom/wishabi/flipp/app/i;->a(Lcom/wishabi/flipp/app/i;)Lcom/wishabi/flipp/app/k;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/j;->a:Lcom/wishabi/flipp/app/i;

    invoke-static {v1}, Lcom/wishabi/flipp/app/i;->b(Lcom/wishabi/flipp/app/i;)I

    move-result v1

    invoke-interface {v0, v1}, Lcom/wishabi/flipp/app/k;->a(I)V

    goto :goto_0

    .line 106
    nop

    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_0
    .end packed-switch
.end method
