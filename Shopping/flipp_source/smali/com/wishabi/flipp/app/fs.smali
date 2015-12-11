.class final Lcom/wishabi/flipp/app/fs;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/media/MediaPlayer$OnPreparedListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/fr;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/fr;)V
    .locals 0

    .prologue
    .line 88
    iput-object p1, p0, Lcom/wishabi/flipp/app/fs;->a:Lcom/wishabi/flipp/app/fr;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onPrepared(Landroid/media/MediaPlayer;)V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 91
    iget-object v0, p0, Lcom/wishabi/flipp/app/fs;->a:Lcom/wishabi/flipp/app/fr;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fr;->a(Lcom/wishabi/flipp/app/fr;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 92
    iget-object v0, p0, Lcom/wishabi/flipp/app/fs;->a:Lcom/wishabi/flipp/app/fr;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fr;->b(Lcom/wishabi/flipp/app/fr;)Landroid/widget/TextView;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 93
    iget-object v0, p0, Lcom/wishabi/flipp/app/fs;->a:Lcom/wishabi/flipp/app/fr;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fr;->c(Lcom/wishabi/flipp/app/fr;)Landroid/widget/MediaController;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/MediaController;->show()V

    .line 94
    return-void
.end method
