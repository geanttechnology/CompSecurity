.class final Lcom/wishabi/flipp/app/g;
.super Lcom/wishabi/flipp/app/dn;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ClippingsFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ClippingsFragment;)V
    .locals 0

    .prologue
    .line 240
    iput-object p1, p0, Lcom/wishabi/flipp/app/g;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-direct {p0}, Lcom/wishabi/flipp/app/dn;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(I)V
    .locals 1

    .prologue
    .line 243
    iget-object v0, p0, Lcom/wishabi/flipp/app/g;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;I)V

    .line 244
    return-void
.end method

.method public final a()Z
    .locals 2

    .prologue
    .line 260
    iget-object v0, p0, Lcom/wishabi/flipp/app/g;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/g;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/CollectionView;->getMultiChoiceModeListener()Lcom/wishabi/flipp/widget/p;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/CollectionView;->startActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    .line 262
    const/4 v0, 0x1

    return v0
.end method

.method public final b(I)V
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/wishabi/flipp/app/g;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v0, p1}, Lcom/wishabi/flipp/app/ClippingsFragment;->b(Lcom/wishabi/flipp/app/ClippingsFragment;I)V

    .line 256
    return-void
.end method
