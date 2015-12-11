.class final Lcom/wishabi/flipp/app/dd;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/cx;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/cx;)V
    .locals 0

    .prologue
    .line 754
    iput-object p1, p0, Lcom/wishabi/flipp/app/dd;->a:Lcom/wishabi/flipp/app/cx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 757
    iget-object v0, p0, Lcom/wishabi/flipp/app/dd;->a:Lcom/wishabi/flipp/app/cx;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/cx;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 758
    if-nez v0, :cond_1

    .line 768
    :cond_0
    :goto_0
    return-void

    .line 761
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/dd;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cx;->d(Lcom/wishabi/flipp/app/cx;)Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/dd;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cx;->d(Lcom/wishabi/flipp/app/cx;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 764
    iget-object v0, p0, Lcom/wishabi/flipp/app/dd;->a:Lcom/wishabi/flipp/app/cx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/cx;->d(Lcom/wishabi/flipp/app/cx;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-static {v0}, Lcom/wishabi/flipp/content/a;->a(Ljava/util/ArrayList;)[I

    move-result-object v0

    .line 765
    iget-object v1, p0, Lcom/wishabi/flipp/app/dd;->a:Lcom/wishabi/flipp/app/cx;

    const-class v2, Lcom/wishabi/flipp/app/n;

    const/4 v3, 0x0

    sget-object v4, Lcom/wishabi/flipp/b/p;->b:Lcom/wishabi/flipp/b/p;

    invoke-static {v0, v3, v4}, Lcom/wishabi/flipp/app/n;->a([IZLcom/wishabi/flipp/b/p;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Lcom/wishabi/flipp/app/cx;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    goto :goto_0
.end method
