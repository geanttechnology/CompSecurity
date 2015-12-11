.class final Lcom/wishabi/flipp/app/ec;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/r;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/SearchFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchFragment;)V
    .locals 0

    .prologue
    .line 950
    iput-object p1, p0, Lcom/wishabi/flipp/app/ec;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/wishabi/flipp/widget/CollectionView;I)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 955
    iget-object v0, p0, Lcom/wishabi/flipp/app/ec;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->p(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/ec;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->q(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/ci;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 956
    iget-object v0, p0, Lcom/wishabi/flipp/app/ec;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->q(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/ci;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/widget/ci;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/app/ec;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->q(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/ci;

    move-result-object v1

    invoke-virtual {v1, p2}, Lcom/wishabi/flipp/widget/ci;->getItemViewType(I)I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 957
    :cond_0
    :goto_0
    return-void

    .line 956
    :pswitch_0
    check-cast v0, Landroid/database/Cursor;

    const-string v1, "flyer_id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/ec;->a:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1, v0, v2, v2}, Lcom/wishabi/flipp/app/SearchFragment;->a(Lcom/wishabi/flipp/app/SearchFragment;ILandroid/graphics/RectF;Ljava/lang/Boolean;)Lcom/wishabi/flipp/content/Flyer$Model;

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
