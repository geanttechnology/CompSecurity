.class final Lcom/wishabi/flipp/app/eb;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/wishabi/flipp/app/SearchFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/SearchFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 824
    iput-object p1, p0, Lcom/wishabi/flipp/app/eb;->b:Lcom/wishabi/flipp/app/SearchFragment;

    iput-object p2, p0, Lcom/wishabi/flipp/app/eb;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 828
    iget-object v0, p0, Lcom/wishabi/flipp/app/eb;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->o(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/ZeroCaseView;

    move-result-object v0

    const v1, 0x7f0200c4

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setIcon(I)V

    .line 829
    iget-object v0, p0, Lcom/wishabi/flipp/app/eb;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->o(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/ZeroCaseView;

    move-result-object v0

    const v1, 0x7f0e00f5

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(I)V

    .line 830
    iget-object v0, p0, Lcom/wishabi/flipp/app/eb;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->o(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/ZeroCaseView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(Ljava/lang/String;)V

    .line 831
    iget-object v0, p0, Lcom/wishabi/flipp/app/eb;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v0}, Lcom/wishabi/flipp/app/SearchFragment;->o(Lcom/wishabi/flipp/app/SearchFragment;)Lcom/wishabi/flipp/widget/ZeroCaseView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->a()V

    .line 834
    new-instance v0, Lcom/wishabi/flipp/b/au;

    iget-object v1, p0, Lcom/wishabi/flipp/app/eb;->a:Ljava/lang/String;

    invoke-direct {v0, v1}, Lcom/wishabi/flipp/b/au;-><init>(Ljava/lang/String;)V

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/au;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 836
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v1, p0, Lcom/wishabi/flipp/app/eb;->b:Lcom/wishabi/flipp/app/SearchFragment;

    invoke-static {v1}, Lcom/wishabi/flipp/app/SearchFragment;->f(Lcom/wishabi/flipp/app/SearchFragment;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/wishabi/flipp/b/t;->b:Lcom/wishabi/flipp/b/t;

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Lcom/wishabi/flipp/b/t;)V

    .line 838
    return-void
.end method
