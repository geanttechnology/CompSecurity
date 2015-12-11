.class final Lcom/wishabi/flipp/app/ad;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/DrawerFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/DrawerFragment;)V
    .locals 0

    .prologue
    .line 253
    iput-object p1, p0, Lcom/wishabi/flipp/app/ad;->a:Lcom/wishabi/flipp/app/DrawerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lcom/wishabi/flipp/app/ad;->a:Lcom/wishabi/flipp/app/DrawerFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/DrawerFragment;->b(Lcom/wishabi/flipp/app/DrawerFragment;)Lcom/wishabi/flipp/app/af;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 257
    iget-object v0, p0, Lcom/wishabi/flipp/app/ad;->a:Lcom/wishabi/flipp/app/DrawerFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/DrawerFragment;->b(Lcom/wishabi/flipp/app/DrawerFragment;)Lcom/wishabi/flipp/app/af;

    move-result-object v0

    invoke-interface {v0}, Lcom/wishabi/flipp/app/af;->a()V

    .line 258
    :cond_0
    return-void
.end method
