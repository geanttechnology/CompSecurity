.class final Landroid/support/v7/widget/i;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Ljava/util/ArrayList;

.field final synthetic b:Landroid/support/v7/widget/g;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/g;Ljava/util/ArrayList;)V
    .locals 0

    .prologue
    .line 140
    iput-object p1, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/g;

    iput-object p2, p0, Landroid/support/v7/widget/i;->a:Ljava/util/ArrayList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 11

    .prologue
    const/4 v2, 0x0

    const/4 v10, 0x0

    .line 143
    iget-object v0, p0, Landroid/support/v7/widget/i;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/support/v7/widget/p;

    .line 144
    iget-object v5, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/g;

    iget-object v1, v0, Landroid/support/v7/widget/p;->a:Landroid/support/v7/widget/bi;

    if-nez v1, :cond_2

    move-object v1, v2

    :goto_1
    iget-object v3, v0, Landroid/support/v7/widget/p;->b:Landroid/support/v7/widget/bi;

    if-eqz v3, :cond_3

    iget-object v3, v3, Landroid/support/v7/widget/bi;->a:Landroid/view/View;

    :goto_2
    if-eqz v1, :cond_1

    iget-object v6, v5, Landroid/support/v7/widget/g;->g:Ljava/util/ArrayList;

    iget-object v7, v0, Landroid/support/v7/widget/p;->a:Landroid/support/v7/widget/bi;

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v1}, Landroid/support/v4/view/ap;->o(Landroid/view/View;)Landroid/support/v4/view/cj;

    move-result-object v1

    iget-wide v6, v5, Landroid/support/v7/widget/aq;->l:J

    invoke-virtual {v1, v6, v7}, Landroid/support/v4/view/cj;->a(J)Landroid/support/v4/view/cj;

    move-result-object v1

    iget v6, v0, Landroid/support/v7/widget/p;->e:I

    iget v7, v0, Landroid/support/v7/widget/p;->c:I

    sub-int/2addr v6, v7

    int-to-float v6, v6

    invoke-virtual {v1, v6}, Landroid/support/v4/view/cj;->b(F)Landroid/support/v4/view/cj;

    iget v6, v0, Landroid/support/v7/widget/p;->f:I

    iget v7, v0, Landroid/support/v7/widget/p;->d:I

    sub-int/2addr v6, v7

    int-to-float v6, v6

    invoke-virtual {v1, v6}, Landroid/support/v4/view/cj;->c(F)Landroid/support/v4/view/cj;

    invoke-virtual {v1, v10}, Landroid/support/v4/view/cj;->a(F)Landroid/support/v4/view/cj;

    move-result-object v6

    new-instance v7, Landroid/support/v7/widget/n;

    invoke-direct {v7, v5, v0, v1}, Landroid/support/v7/widget/n;-><init>(Landroid/support/v7/widget/g;Landroid/support/v7/widget/p;Landroid/support/v4/view/cj;)V

    invoke-virtual {v6, v7}, Landroid/support/v4/view/cj;->a(Landroid/support/v4/view/cw;)Landroid/support/v4/view/cj;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/view/cj;->b()V

    :cond_1
    if-eqz v3, :cond_0

    iget-object v1, v5, Landroid/support/v7/widget/g;->g:Ljava/util/ArrayList;

    iget-object v6, v0, Landroid/support/v7/widget/p;->b:Landroid/support/v7/widget/bi;

    invoke-virtual {v1, v6}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    invoke-static {v3}, Landroid/support/v4/view/ap;->o(Landroid/view/View;)Landroid/support/v4/view/cj;

    move-result-object v1

    invoke-virtual {v1, v10}, Landroid/support/v4/view/cj;->b(F)Landroid/support/v4/view/cj;

    move-result-object v6

    invoke-virtual {v6, v10}, Landroid/support/v4/view/cj;->c(F)Landroid/support/v4/view/cj;

    move-result-object v6

    iget-wide v8, v5, Landroid/support/v7/widget/aq;->l:J

    invoke-virtual {v6, v8, v9}, Landroid/support/v4/view/cj;->a(J)Landroid/support/v4/view/cj;

    move-result-object v6

    const/high16 v7, 0x3f800000    # 1.0f

    invoke-virtual {v6, v7}, Landroid/support/v4/view/cj;->a(F)Landroid/support/v4/view/cj;

    move-result-object v6

    new-instance v7, Landroid/support/v7/widget/o;

    invoke-direct {v7, v5, v0, v1, v3}, Landroid/support/v7/widget/o;-><init>(Landroid/support/v7/widget/g;Landroid/support/v7/widget/p;Landroid/support/v4/view/cj;Landroid/view/View;)V

    invoke-virtual {v6, v7}, Landroid/support/v4/view/cj;->a(Landroid/support/v4/view/cw;)Landroid/support/v4/view/cj;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/view/cj;->b()V

    goto :goto_0

    :cond_2
    iget-object v1, v1, Landroid/support/v7/widget/bi;->a:Landroid/view/View;

    goto :goto_1

    :cond_3
    move-object v3, v2

    goto :goto_2

    .line 146
    :cond_4
    iget-object v0, p0, Landroid/support/v7/widget/i;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 147
    iget-object v0, p0, Landroid/support/v7/widget/i;->b:Landroid/support/v7/widget/g;

    iget-object v0, v0, Landroid/support/v7/widget/g;->c:Ljava/util/ArrayList;

    iget-object v1, p0, Landroid/support/v7/widget/i;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 148
    return-void
.end method
