.class final Lcom/wishabi/flipp/widget/cm;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/cv;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ck;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/widget/ck;)V
    .locals 0

    .prologue
    .line 221
    iput-object p1, p0, Lcom/wishabi/flipp/widget/cm;->a:Lcom/wishabi/flipp/widget/ck;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Lcom/wishabi/flipp/widget/ct;)V
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 224
    invoke-virtual {p1}, Lcom/wishabi/flipp/widget/ct;->c()I

    move-result v3

    .line 227
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cm;->a:Lcom/wishabi/flipp/widget/ck;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/util/l;->d(I)Lcom/wishabi/flipp/util/m;

    move-result-object v4

    .line 228
    iget-wide v0, v4, Lcom/wishabi/flipp/util/m;->a:J

    long-to-int v5, v0

    .line 231
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cm;->a:Lcom/wishabi/flipp/widget/ck;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, v5}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    move v1, v0

    .line 232
    :goto_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cm;->a:Lcom/wishabi/flipp/widget/ck;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ck;->d:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, v5, v1}, Landroid/util/SparseBooleanArray;->put(IZ)V

    .line 235
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cm;->a:Lcom/wishabi/flipp/widget/ck;

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/widget/ck;->c(I)V

    .line 238
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cm;->a:Lcom/wishabi/flipp/widget/ck;

    iget-object v0, v0, Lcom/wishabi/flipp/widget/ck;->c:Lcom/wishabi/flipp/util/l;

    iget v3, v4, Lcom/wishabi/flipp/util/m;->b:I

    invoke-virtual {v0, v3}, Lcom/wishabi/flipp/util/l;->a(I)Lcom/wishabi/flipp/util/o;

    move-result-object v0

    .line 240
    iget-object v3, v0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_1

    const/4 v0, 0x0

    move-object v2, v0

    .line 241
    :goto_1
    iget-object v0, v2, Lcom/wishabi/flipp/util/m;->e:Ljava/lang/Object;

    check-cast v0, Lcom/wishabi/flipp/widget/cr;

    .line 242
    if-eqz v1, :cond_2

    .line 243
    iget v1, v0, Lcom/wishabi/flipp/widget/cr;->b:I

    add-int/lit8 v1, v1, 0x1

    iput v1, v0, Lcom/wishabi/flipp/widget/cr;->b:I

    .line 248
    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/widget/cm;->a:Lcom/wishabi/flipp/widget/ck;

    iget v1, v2, Lcom/wishabi/flipp/util/m;->c:I

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ck;->c(I)V

    .line 249
    return-void

    :cond_0
    move v1, v2

    .line 231
    goto :goto_0

    .line 240
    :cond_1
    iget-object v0, v0, Lcom/wishabi/flipp/util/o;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/util/m;

    move-object v2, v0

    goto :goto_1

    .line 245
    :cond_2
    iget v1, v0, Lcom/wishabi/flipp/widget/cr;->b:I

    add-int/lit8 v1, v1, -0x1

    iput v1, v0, Lcom/wishabi/flipp/widget/cr;->b:I

    goto :goto_2
.end method
