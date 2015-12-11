.class final Lcom/wishabi/flipp/app/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/p;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ClippingsFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ClippingsFragment;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Landroid/view/ActionMode;IJZ)V
    .locals 6

    .prologue
    .line 233
    iget-object v0, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0d0006

    iget-object v2, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v2}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemCount()I

    move-result v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v5}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v5

    invoke-virtual {v5}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemCount()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/ActionMode;->setTitle(Ljava/lang/CharSequence;)V

    .line 236
    return-void
.end method

.method public final onActionItemClicked(Landroid/view/ActionMode;Landroid/view/MenuItem;)Z
    .locals 12

    .prologue
    .line 152
    iget-object v0, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 153
    iget-object v0, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 155
    if-eqz v0, :cond_0

    if-nez v1, :cond_1

    .line 156
    :cond_0
    const/4 v0, 0x1

    .line 222
    :goto_0
    return v0

    .line 158
    :cond_1
    invoke-virtual {v1}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    .line 159
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 160
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 162
    invoke-interface {p2}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    const v2, 0x7f0b015a

    if-ne v1, v2, :cond_5

    .line 163
    iget-object v1, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v1

    invoke-virtual {v1}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v6

    .line 165
    invoke-virtual {v6}, Landroid/util/SparseBooleanArray;->size()I

    move-result v1

    if-nez v1, :cond_2

    .line 166
    iget-object v0, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->a()V

    .line 167
    const/4 v0, 0x1

    goto :goto_0

    .line 170
    :cond_2
    iget-object v1, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ClippingsFragment;->b(Lcom/wishabi/flipp/app/ClippingsFragment;)Landroid/database/Cursor;

    move-result-object v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ClippingsFragment;->c(Lcom/wishabi/flipp/app/ClippingsFragment;)Landroid/database/Cursor;

    move-result-object v1

    if-nez v1, :cond_4

    .line 171
    :cond_3
    const/4 v0, 0x1

    goto :goto_0

    .line 173
    :cond_4
    iget-object v1, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ClippingsFragment;->b(Lcom/wishabi/flipp/app/ClippingsFragment;)Landroid/database/Cursor;

    move-result-object v1

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v7

    .line 174
    iget-object v1, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ClippingsFragment;->c(Lcom/wishabi/flipp/app/ClippingsFragment;)Landroid/database/Cursor;

    move-result-object v1

    const-string v2, "_id"

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v8

    .line 176
    const/4 v1, 0x0

    invoke-virtual {v6}, Landroid/util/SparseBooleanArray;->size()I

    move-result v9

    move v2, v1

    :goto_1
    if-ge v2, v9, :cond_7

    .line 177
    invoke-virtual {v6, v2}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v1

    .line 178
    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/g;->getItemViewType(I)I

    move-result v10

    packed-switch v10, :pswitch_data_0

    .line 190
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Clipping adapter is reporting tap for untappable item"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 180
    :pswitch_0
    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/g;->a(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/database/Cursor;

    .line 181
    invoke-interface {v1, v8}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 176
    :goto_2
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_1

    .line 185
    :pswitch_1
    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/g;->a(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/database/Cursor;

    .line 186
    invoke-interface {v1, v7}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v5, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 194
    :cond_5
    invoke-interface {p2}, Landroid/view/MenuItem;->getItemId()I

    move-result v1

    const v2, 0x7f0b0159

    if-ne v1, v2, :cond_7

    .line 196
    const/4 v1, 0x0

    iget v2, v0, Lcom/wishabi/flipp/widget/da;->j:I

    move v0, v1

    :goto_3
    if-ge v0, v2, :cond_6

    .line 197
    iget-object v1, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v1

    const/4 v3, 0x1

    invoke-virtual {v1, v0, v3}, Lcom/wishabi/flipp/widget/CollectionView;->a(IZ)V

    .line 196
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 199
    :cond_6
    const/4 v0, 0x1

    goto/16 :goto_0

    .line 202
    :cond_7
    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-virtual {v5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 203
    const/4 v0, 0x1

    goto/16 :goto_0

    .line 205
    :cond_8
    invoke-virtual {v4}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_9

    .line 206
    invoke-static {v4}, Lcom/wishabi/flipp/util/q;->a(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v0

    .line 207
    sget-object v1, Lcom/wishabi/flipp/content/i;->g:Landroid/net/Uri;

    const-string v2, "_id"

    invoke-static {v2, v0}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v1, v2, v0}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 211
    :cond_9
    invoke-virtual {v5}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_a

    .line 212
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 213
    const-string v1, "clipped"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 215
    invoke-static {v5}, Lcom/wishabi/flipp/util/q;->a(Ljava/util/List;)[Ljava/lang/String;

    move-result-object v1

    .line 216
    sget-object v2, Lcom/wishabi/flipp/content/i;->t:Landroid/net/Uri;

    const-string v4, "_id"

    invoke-static {v4, v1}, Lcom/wishabi/flipp/util/f;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v0, v4, v1}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 221
    :cond_a
    invoke-virtual {p1}, Landroid/view/ActionMode;->finish()V

    .line 222
    const/4 v0, 0x1

    goto/16 :goto_0

    .line 178
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final onCreateActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 2

    .prologue
    .line 131
    invoke-virtual {p1}, Landroid/view/ActionMode;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 132
    if-nez v0, :cond_0

    .line 133
    const/4 v0, 0x0

    .line 136
    :goto_0
    return v0

    .line 135
    :cond_0
    const v1, 0x7f100003

    invoke-virtual {v0, v1, p2}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 136
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public final onDestroyActionMode(Landroid/view/ActionMode;)V
    .locals 2

    .prologue
    .line 227
    iget-object v0, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;Z)V

    .line 228
    return-void
.end method

.method public final onPrepareActionMode(Landroid/view/ActionMode;Landroid/view/Menu;)Z
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 141
    iget-object v0, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/ClippingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0d0006

    iget-object v2, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v2}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemCount()I

    move-result v2

    new-array v3, v6, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v4}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;)Lcom/wishabi/flipp/widget/CollectionView;

    move-result-object v4

    invoke-virtual {v4}, Lcom/wishabi/flipp/widget/CollectionView;->getActivatedItemCount()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/view/ActionMode;->setTitle(Ljava/lang/CharSequence;)V

    .line 145
    iget-object v0, p0, Lcom/wishabi/flipp/app/f;->a:Lcom/wishabi/flipp/app/ClippingsFragment;

    invoke-static {v0, v6}, Lcom/wishabi/flipp/app/ClippingsFragment;->a(Lcom/wishabi/flipp/app/ClippingsFragment;Z)V

    .line 146
    return v5
.end method
