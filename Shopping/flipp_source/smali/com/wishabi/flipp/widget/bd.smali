.class final Lcom/wishabi/flipp/widget/bd;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/SeekBar$OnSeekBarChangeListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/FlyerToolbar;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/FlyerToolbar;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lcom/wishabi/flipp/widget/bd;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onProgressChanged(Landroid/widget/SeekBar;IZ)V
    .locals 2

    .prologue
    .line 68
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bd;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->a(Lcom/wishabi/flipp/widget/FlyerToolbar;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bd;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->b(Lcom/wishabi/flipp/widget/FlyerToolbar;)V

    .line 74
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bd;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->c(Lcom/wishabi/flipp/widget/FlyerToolbar;)Lcom/wishabi/flipp/widget/bh;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 75
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bd;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->c(Lcom/wishabi/flipp/widget/FlyerToolbar;)Lcom/wishabi/flipp/widget/bh;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/bd;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-interface {v0, v1, p2}, Lcom/wishabi/flipp/widget/bh;->a(Lcom/wishabi/flipp/widget/FlyerToolbar;I)V

    .line 78
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/bd;->a:Lcom/wishabi/flipp/widget/FlyerToolbar;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/FlyerToolbar;->d(Lcom/wishabi/flipp/widget/FlyerToolbar;)V

    .line 79
    return-void
.end method

.method public final onStartTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0

    .prologue
    .line 82
    return-void
.end method

.method public final onStopTrackingTouch(Landroid/widget/SeekBar;)V
    .locals 0

    .prologue
    .line 85
    return-void
.end method
