.class public final Lcom/wishabi/flipp/widget/h;
.super Lcom/wishabi/flipp/widget/eh;
.source "SourceFile"


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lcom/wishabi/flipp/widget/CollectionView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/wishabi/flipp/widget/CollectionView;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/eh;-><init>()V

    .line 17
    iput-object p1, p0, Lcom/wishabi/flipp/widget/h;->a:Landroid/content/Context;

    .line 18
    iput-object p2, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    .line 19
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 25
    if-nez v0, :cond_0

    .line 26
    const/4 v0, 0x0

    .line 28
    :goto_0
    return v0

    :cond_0
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/g;->b()I

    move-result v0

    goto :goto_0
.end method

.method public final a(I)I
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 35
    if-nez v0, :cond_0

    .line 36
    const/4 v0, 0x0

    .line 38
    :goto_0
    return v0

    :cond_0
    iget-object v0, v0, Lcom/wishabi/flipp/widget/g;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v0

    goto :goto_0
.end method

.method public final a(II)I
    .locals 10

    .prologue
    const/4 v1, 0x0

    .line 130
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 132
    if-eqz v0, :cond_0

    iget-object v2, p0, Lcom/wishabi/flipp/widget/h;->a:Landroid/content/Context;

    if-nez v2, :cond_1

    .line 148
    :cond_0
    :goto_0
    return v1

    .line 135
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->b(I)I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 150
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 137
    :pswitch_0
    const/16 v2, 0xa

    invoke-static {v2}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v2

    .line 138
    const/16 v3, 0xf

    invoke-static {v3}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v3

    .line 139
    const/16 v4, 0x32

    invoke-static {v4}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v4

    .line 140
    iget-object v5, v0, Lcom/wishabi/flipp/widget/g;->f:[F

    aget v5, v5, p2

    const v6, 0x3f8ccccd    # 1.1f

    invoke-static {v5, v6}, Ljava/lang/Math;->min(FF)F

    move-result v5

    .line 141
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/h;->c(I)I

    move-result v6

    sub-int v2, v6, v2

    int-to-float v2, v2

    .line 142
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->b(I)I

    move-result v6

    packed-switch v6, :pswitch_data_1

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Invalid section height"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_1
    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->c:Ljava/util/HashMap;

    if-eqz v6, :cond_2

    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    if-nez v6, :cond_3

    :cond_2
    move v0, v1

    :goto_1
    if-eqz v0, :cond_a

    const/16 v0, 0x37

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 144
    :goto_2
    mul-float v1, v2, v5

    float-to-int v1, v1

    invoke-static {v1, v4}, Ljava/lang/Math;->max(II)I

    move-result v1

    add-int/2addr v1, v3

    add-int/2addr v1, v0

    goto :goto_0

    .line 142
    :cond_3
    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    invoke-interface {v6, p2}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v6

    if-nez v6, :cond_4

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Couldn\'t move cursor to position "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->c:Ljava/util/HashMap;

    iget-object v7, v0, Lcom/wishabi/flipp/widget/g;->a:Landroid/database/Cursor;

    iget v0, v0, Lcom/wishabi/flipp/widget/g;->h:I

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    invoke-static {v0}, Lcom/wishabi/flipp/widget/aw;->a(Ljava/util/ArrayList;)Z

    move-result v0

    goto :goto_1

    :pswitch_2
    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->d:Ljava/util/HashMap;

    if-eqz v6, :cond_5

    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    if-nez v6, :cond_6

    :cond_5
    move v0, v1

    goto :goto_1

    :cond_6
    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    invoke-interface {v6, p2}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v6

    if-nez v6, :cond_7

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Couldn\'t move cursor to position "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_7
    iget-object v6, v0, Lcom/wishabi/flipp/widget/g;->d:Ljava/util/HashMap;

    iget-object v7, v0, Lcom/wishabi/flipp/widget/g;->b:Landroid/database/Cursor;

    iget v0, v0, Lcom/wishabi/flipp/widget/g;->i:I

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    if-eqz v0, :cond_8

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_9

    :cond_8
    move v0, v1

    goto/16 :goto_1

    :cond_9
    const/4 v0, 0x1

    goto/16 :goto_1

    :cond_a
    move v0, v1

    goto/16 :goto_2

    .line 148
    :pswitch_3
    const/16 v0, 0x104

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v1

    goto/16 :goto_0

    .line 135
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_3
    .end packed-switch

    .line 142
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public final a(ILandroid/graphics/Rect;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 64
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 67
    iget-object v1, p0, Lcom/wishabi/flipp/widget/h;->a:Landroid/content/Context;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 68
    :cond_0
    invoke-virtual {p2, v2, v2, v2, v2}, Landroid/graphics/Rect;->set(IIII)V

    .line 77
    :goto_0
    return-void

    .line 72
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 79
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 75
    :pswitch_0
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 76
    invoke-virtual {p2, v0, v2, v0, v0}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_0

    .line 72
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public final b(I)I
    .locals 3

    .prologue
    .line 43
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 46
    iget-object v1, p0, Lcom/wishabi/flipp/widget/h;->a:Landroid/content/Context;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 47
    :cond_0
    const/4 v0, 0x0

    .line 56
    :goto_0
    return v0

    .line 49
    :cond_1
    invoke-static {}, Lcom/wishabi/flipp/util/i;->a()I

    move-result v1

    div-int/lit16 v1, v1, 0xb4

    const/4 v2, 0x2

    invoke-static {v1, v2}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 52
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 58
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    move v0, v1

    .line 54
    goto :goto_0

    :pswitch_1
    move v0, v1

    .line 56
    goto :goto_0

    .line 52
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final b(II)I
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 160
    if-nez v0, :cond_0

    .line 161
    const/4 v0, -0x1

    .line 163
    :goto_0
    return v0

    :cond_0
    invoke-virtual {v0, p1, p2}, Lcom/wishabi/flipp/widget/g;->a(II)I

    move-result v0

    goto :goto_0
.end method

.method public final c(I)I
    .locals 3

    .prologue
    .line 85
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->a:Landroid/content/Context;

    if-nez v0, :cond_0

    .line 86
    const/4 v0, 0x0

    .line 90
    :goto_0
    return v0

    .line 88
    :cond_0
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 89
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/h;->b(I)I

    move-result v1

    .line 90
    iget-object v2, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v2

    mul-int/lit8 v0, v0, 0x2

    sub-int v0, v2, v0

    div-int/2addr v0, v1

    goto :goto_0
.end method

.method public final d(I)I
    .locals 2

    .prologue
    .line 95
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 98
    iget-object v1, p0, Lcom/wishabi/flipp/widget/h;->a:Landroid/content/Context;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 99
    :cond_0
    const/4 v0, 0x0

    .line 104
    :goto_0
    return v0

    .line 101
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 106
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 104
    :pswitch_0
    const/16 v0, 0x1a

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 101
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public final e(I)I
    .locals 2

    .prologue
    .line 112
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 115
    iget-object v1, p0, Lcom/wishabi/flipp/widget/h;->a:Landroid/content/Context;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 116
    :cond_0
    const/4 v0, 0x0

    .line 121
    :goto_0
    return v0

    .line 118
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/g;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 123
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 121
    :pswitch_0
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 118
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method

.method public final f(I)I
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/wishabi/flipp/widget/h;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/g;

    .line 170
    if-nez v0, :cond_0

    .line 171
    const/4 v0, -0x1

    .line 173
    :goto_0
    return v0

    :cond_0
    iget-object v0, v0, Lcom/wishabi/flipp/widget/g;->e:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->c()I

    move-result v0

    add-int/2addr v0, p1

    goto :goto_0
.end method
