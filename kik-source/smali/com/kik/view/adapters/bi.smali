.class final Lcom/kik/view/adapters/bi;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lkik/android/net/a/b;

.field final synthetic b:Lcom/kik/view/adapters/bf$b;

.field final synthetic c:Lkik/android/widget/ProgressWidget;

.field final synthetic d:Lkik/a/d/f;

.field final synthetic e:Lkik/a/d/s;

.field final synthetic f:Lcom/kik/view/adapters/bf;


# direct methods
.method constructor <init>(Lcom/kik/view/adapters/bf;Lkik/android/net/a/b;Lcom/kik/view/adapters/bf$b;Lkik/android/widget/ProgressWidget;Lkik/a/d/f;Lkik/a/d/s;)V
    .locals 0

    .prologue
    .line 538
    iput-object p1, p0, Lcom/kik/view/adapters/bi;->f:Lcom/kik/view/adapters/bf;

    iput-object p2, p0, Lcom/kik/view/adapters/bi;->a:Lkik/android/net/a/b;

    iput-object p3, p0, Lcom/kik/view/adapters/bi;->b:Lcom/kik/view/adapters/bf$b;

    iput-object p4, p0, Lcom/kik/view/adapters/bi;->c:Lkik/android/widget/ProgressWidget;

    iput-object p5, p0, Lcom/kik/view/adapters/bi;->d:Lkik/a/d/f;

    iput-object p6, p0, Lcom/kik/view/adapters/bi;->e:Lkik/a/d/s;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    .line 542
    iget-object v0, p0, Lcom/kik/view/adapters/bi;->f:Lcom/kik/view/adapters/bf;

    iget-object v0, v0, Lcom/kik/view/adapters/bf;->e:Lcom/kik/android/a;

    const-string v1, "Content Upload Cancelled"

    invoke-virtual {v0, v1}, Lcom/kik/android/a;->b(Ljava/lang/String;)Lcom/kik/android/a$f;

    move-result-object v0

    invoke-virtual {v0}, Lcom/kik/android/a$f;->b()V

    .line 544
    iget-object v0, p0, Lcom/kik/view/adapters/bi;->a:Lkik/android/net/a/b;

    if-eqz v0, :cond_0

    .line 545
    iget-object v0, p0, Lcom/kik/view/adapters/bi;->f:Lcom/kik/view/adapters/bf;

    iget-object v1, p0, Lcom/kik/view/adapters/bi;->a:Lkik/android/net/a/b;

    iget-object v2, p0, Lcom/kik/view/adapters/bi;->b:Lcom/kik/view/adapters/bf$b;

    iget-object v2, v2, Lcom/kik/view/adapters/bf$b;->s:Landroid/widget/ImageView;

    iget-object v3, p0, Lcom/kik/view/adapters/bi;->c:Lkik/android/widget/ProgressWidget;

    iget-object v4, p0, Lcom/kik/view/adapters/bi;->d:Lkik/a/d/f;

    iget-object v5, p0, Lcom/kik/view/adapters/bi;->e:Lkik/a/d/s;

    invoke-virtual {v5}, Lkik/a/d/s;->b()Ljava/lang/String;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Lcom/kik/view/adapters/bf;->a(Lkik/android/net/a/b;Landroid/widget/ImageView;Lkik/android/widget/ProgressWidget;Lkik/a/d/f;Ljava/lang/String;)V

    .line 547
    :cond_0
    return-void
.end method
