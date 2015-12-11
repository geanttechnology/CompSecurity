.class public final Lcom/wishabi/flipp/widget/am;
.super Lcom/wishabi/flipp/widget/eh;
.source "SourceFile"


# instance fields
.field private final a:Landroid/content/Context;

.field private final b:Lcom/wishabi/flipp/widget/CollectionView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/wishabi/flipp/widget/CollectionView;)V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/eh;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/wishabi/flipp/widget/am;->a:Landroid/content/Context;

    .line 19
    iput-object p2, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    .line 20
    return-void
.end method


# virtual methods
.method public final a()I
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/al;

    .line 26
    if-nez v0, :cond_0

    .line 27
    const/4 v0, 0x0

    .line 29
    :goto_0
    return v0

    :cond_0
    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/al;->b()I

    move-result v0

    goto :goto_0
.end method

.method public final a(I)I
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/al;

    .line 36
    if-nez v0, :cond_0

    .line 37
    const/4 v0, 0x0

    .line 39
    :goto_0
    return v0

    :cond_0
    iget-object v0, v0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/util/l;->b(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v0

    goto :goto_0
.end method

.method public final a(II)I
    .locals 2

    .prologue
    .line 134
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/al;

    .line 136
    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/am;->a:Landroid/content/Context;

    if-nez v1, :cond_1

    .line 137
    :cond_0
    const/4 v0, 0x0

    .line 145
    :goto_0
    return v0

    .line 139
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/al;->c(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 147
    :pswitch_0
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 141
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredHeight()I

    move-result v0

    const/16 v1, 0x30

    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v1

    sub-int/2addr v0, v1

    goto :goto_0

    .line 145
    :pswitch_2
    const/16 v0, 0x104

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 139
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public final a(ILandroid/graphics/Rect;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 64
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/al;

    .line 66
    iget-object v1, p0, Lcom/wishabi/flipp/widget/am;->a:Landroid/content/Context;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 67
    :cond_0
    invoke-virtual {p2, v2, v2, v2, v2}, Landroid/graphics/Rect;->set(IIII)V

    .line 79
    :goto_0
    return-void

    .line 71
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/al;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 81
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 73
    :pswitch_0
    invoke-virtual {p2, v2, v2, v2, v2}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_0

    .line 77
    :pswitch_1
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    .line 78
    invoke-virtual {p2, v0, v2, v0, v0}, Landroid/graphics/Rect;->set(IIII)V

    goto :goto_0

    .line 71
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public final b(I)I
    .locals 2

    .prologue
    .line 44
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/al;

    .line 47
    iget-object v1, p0, Lcom/wishabi/flipp/widget/am;->a:Landroid/content/Context;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 48
    :cond_0
    const/4 v0, 0x0

    .line 55
    :goto_0
    return v0

    .line 50
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/al;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 58
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 52
    :pswitch_0
    const/4 v0, 0x1

    goto :goto_0

    .line 55
    :pswitch_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v0

    const/16 v1, 0xb4

    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v1

    div-int/2addr v0, v1

    const/4 v1, 0x2

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v0

    goto :goto_0

    .line 50
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public final b(II)I
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/al;

    .line 157
    if-nez v0, :cond_0

    .line 158
    const/4 v0, -0x1

    .line 160
    :goto_0
    return v0

    :cond_0
    invoke-virtual {v0, p1, p2}, Lcom/wishabi/flipp/widget/al;->a(II)I

    move-result v0

    goto :goto_0
.end method

.method public final c(I)I
    .locals 3

    .prologue
    .line 87
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 88
    invoke-virtual {p0, p1, v0}, Lcom/wishabi/flipp/widget/am;->a(ILandroid/graphics/Rect;)V

    .line 89
    invoke-virtual {p0, p1}, Lcom/wishabi/flipp/widget/am;->b(I)I

    move-result v1

    .line 90
    iget-object v2, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v2}, Lcom/wishabi/flipp/widget/CollectionView;->getMeasuredWidth()I

    move-result v2

    iget v0, v0, Landroid/graphics/Rect;->left:I

    mul-int/lit8 v0, v0, 0x2

    sub-int v0, v2, v0

    div-int/2addr v0, v1

    return v0
.end method

.method public final d(I)I
    .locals 2

    .prologue
    .line 95
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/al;

    .line 98
    iget-object v1, p0, Lcom/wishabi/flipp/widget/am;->a:Landroid/content/Context;

    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 99
    :cond_0
    const/4 v0, 0x0

    .line 106
    :goto_0
    return v0

    .line 101
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/al;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 108
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 103
    :pswitch_0
    const/16 v0, 0x30

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 106
    :pswitch_1
    const/16 v0, 0x1a

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 101
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public final e(I)I
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 114
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/al;

    .line 117
    iget-object v2, p0, Lcom/wishabi/flipp/widget/am;->a:Landroid/content/Context;

    if-eqz v2, :cond_0

    if-nez v0, :cond_1

    :cond_0
    move v0, v1

    .line 125
    :goto_0
    return v0

    .line 120
    :cond_1
    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/al;->b(I)I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 127
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string v1, "Bad section requested"

    invoke-direct {v0, v1}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 122
    :pswitch_0
    invoke-static {v1}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 125
    :pswitch_1
    const/4 v0, 0x5

    invoke-static {v0}, Lcom/wishabi/flipp/util/i;->a(I)I

    move-result v0

    goto :goto_0

    .line 120
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public final f(I)I
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/wishabi/flipp/widget/am;->b:Lcom/wishabi/flipp/widget/CollectionView;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/CollectionView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/al;

    .line 167
    if-nez v0, :cond_0

    .line 168
    const/4 v0, -0x1

    .line 170
    :goto_0
    return v0

    :cond_0
    iget-object v0, v0, Lcom/wishabi/flipp/widget/al;->a:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0}, Lcom/wishabi/flipp/util/l;->c()I

    move-result v0

    add-int/2addr v0, p1

    goto :goto_0
.end method
