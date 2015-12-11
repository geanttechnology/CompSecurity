.class final Lcom/wishabi/flipp/app/ft;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/fr;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/fr;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/wishabi/flipp/app/ft;->a:Lcom/wishabi/flipp/app/fr;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/wishabi/flipp/app/ft;->a:Lcom/wishabi/flipp/app/fr;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fr;->c(Lcom/wishabi/flipp/app/fr;)Landroid/widget/MediaController;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lcom/wishabi/flipp/app/ft;->a:Lcom/wishabi/flipp/app/fr;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fr;->c(Lcom/wishabi/flipp/app/fr;)Landroid/widget/MediaController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/MediaController;->show()V

    .line 103
    :cond_0
    const/4 v0, 0x0

    return v0
.end method
