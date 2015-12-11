.class public final Lcom/wishabi/flipp/util/l;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Iterable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Ljava/lang/Iterable",
        "<",
        "Lcom/wishabi/flipp/util/o;",
        ">;"
    }
.end annotation


# instance fields
.field public final a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/wishabi/flipp/util/o;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/wishabi/flipp/util/m;",
            ">;"
        }
    .end annotation
.end field

.field private final c:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/wishabi/flipp/util/o;",
            ">;"
        }
    .end annotation
.end field

.field private final d:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/wishabi/flipp/util/o;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 228
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/l;->b:Ljava/util/HashMap;

    .line 229
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/l;->c:Ljava/util/HashMap;

    .line 230
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/l;->d:Landroid/util/SparseArray;

    .line 231
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    return-void
.end method


# virtual methods
.method public final a(J)Lcom/wishabi/flipp/util/m;
    .locals 3

    .prologue
    .line 334
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->b:Ljava/util/HashMap;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/m;

    return-object v0
.end method

.method public final a(I)Lcom/wishabi/flipp/util/o;
    .locals 1

    .prologue
    .line 256
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->d:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/o;

    return-object v0
.end method

.method public final a()V
    .locals 1

    .prologue
    .line 283
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->b:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 284
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->d:Landroid/util/SparseArray;

    invoke-virtual {v0}, Landroid/util/SparseArray;->clear()V

    .line 285
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->c:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 286
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 287
    return-void
.end method

.method public final a(Lcom/wishabi/flipp/util/o;)V
    .locals 6

    .prologue
    .line 238
    invoke-virtual {p0}, Lcom/wishabi/flipp/util/l;->c()I

    move-result v1

    .line 240
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 241
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->d:Landroid/util/SparseArray;

    iget v2, p1, Lcom/wishabi/flipp/util/o;->b:I

    invoke-virtual {v0, v2, p1}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 242
    iput v1, p1, Lcom/wishabi/flipp/util/o;->c:I

    .line 243
    iget-object v0, p1, Lcom/wishabi/flipp/util/o;->e:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->c:Ljava/util/HashMap;

    iget-object v2, p1, Lcom/wishabi/flipp/util/o;->e:Ljava/lang/String;

    invoke-virtual {v0, v2, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 246
    :cond_0
    const/4 v0, 0x0

    :goto_0
    invoke-virtual {p1}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v2

    if-ge v0, v2, :cond_2

    .line 247
    invoke-virtual {p1, v0}, Lcom/wishabi/flipp/util/o;->b(I)Lcom/wishabi/flipp/util/m;

    move-result-object v3

    .line 248
    if-eqz v3, :cond_1

    .line 249
    add-int/lit8 v2, v1, 0x1

    iput v1, v3, Lcom/wishabi/flipp/util/m;->c:I

    .line 251
    iget-object v1, p0, Lcom/wishabi/flipp/util/l;->b:Ljava/util/HashMap;

    iget-wide v4, v3, Lcom/wishabi/flipp/util/m;->a:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v1, v4, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move v1, v2

    .line 246
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 253
    :cond_2
    return-void
.end method

.method public final b()I
    .locals 3

    .prologue
    .line 294
    const/4 v0, 0x0

    .line 295
    iget-object v1, p0, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/o;

    .line 296
    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->b()I

    move-result v0

    add-int/2addr v0, v1

    move v1, v0

    goto :goto_0

    .line 298
    :cond_0
    return v1
.end method

.method public final b(I)Lcom/wishabi/flipp/util/o;
    .locals 1

    .prologue
    .line 264
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/o;

    return-object v0
.end method

.method public final b(J)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 338
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/util/l;->a(J)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    if-nez v0, :cond_0

    .line 339
    const/4 v0, 0x0

    .line 341
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/util/l;->a(J)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    iget-object v0, v0, Lcom/wishabi/flipp/util/m;->e:Ljava/lang/Object;

    goto :goto_0
.end method

.method public final c()I
    .locals 3

    .prologue
    .line 302
    const/4 v0, 0x0

    .line 303
    iget-object v1, p0, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/o;

    .line 304
    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v0

    add-int/2addr v0, v1

    move v1, v0

    goto :goto_0

    .line 306
    :cond_0
    return v1
.end method

.method public final c(J)I
    .locals 1

    .prologue
    .line 345
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/util/l;->a(J)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    if-nez v0, :cond_0

    .line 346
    const/4 v0, -0x1

    .line 348
    :goto_0
    return v0

    :cond_0
    invoke-virtual {p0, p1, p2}, Lcom/wishabi/flipp/util/l;->a(J)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    iget v0, v0, Lcom/wishabi/flipp/util/m;->c:I

    goto :goto_0
.end method

.method public final c(I)Lcom/wishabi/flipp/util/o;
    .locals 4

    .prologue
    .line 268
    const/4 v0, 0x0

    .line 269
    iget-object v1, p0, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/o;

    .line 270
    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v3

    add-int/2addr v3, v1

    if-ge p1, v3, :cond_0

    .line 275
    :goto_1
    return-object v0

    .line 272
    :cond_0
    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v0

    add-int/2addr v0, v1

    move v1, v0

    .line 273
    goto :goto_0

    .line 275
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public final d(I)Lcom/wishabi/flipp/util/m;
    .locals 4

    .prologue
    .line 316
    const/4 v0, 0x0

    .line 317
    iget-object v1, p0, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/o;

    .line 318
    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v3

    add-int/2addr v3, v1

    if-ge p1, v3, :cond_0

    .line 319
    sub-int v1, p1, v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/util/o;->b(I)Lcom/wishabi/flipp/util/m;

    move-result-object v0

    .line 323
    :goto_1
    return-object v0

    .line 320
    :cond_0
    invoke-virtual {v0}, Lcom/wishabi/flipp/util/o;->a()I

    move-result v0

    add-int/2addr v0, v1

    move v1, v0

    .line 321
    goto :goto_0

    .line 323
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public final iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Lcom/wishabi/flipp/util/o;",
            ">;"
        }
    .end annotation

    .prologue
    .line 234
    iget-object v0, p0, Lcom/wishabi/flipp/util/l;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method
