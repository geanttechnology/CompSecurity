.class final Lcom/wishabi/flipp/app/cc;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/wishabi/flipp/app/bx;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/bx;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 364
    iput-object p1, p0, Lcom/wishabi/flipp/app/cc;->b:Lcom/wishabi/flipp/app/bx;

    iput-object p2, p0, Lcom/wishabi/flipp/app/cc;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 367
    iget-object v0, p0, Lcom/wishabi/flipp/app/cc;->b:Lcom/wishabi/flipp/app/bx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bx;->g(Lcom/wishabi/flipp/app/bx;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 373
    :cond_0
    :goto_0
    return-void

    .line 368
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/cc;->b:Lcom/wishabi/flipp/app/bx;

    invoke-static {v0}, Lcom/wishabi/flipp/app/bx;->h(Lcom/wishabi/flipp/app/bx;)Z

    .line 369
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "geo:0,0?q="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/wishabi/flipp/app/cc;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 371
    iget-object v1, p0, Lcom/wishabi/flipp/app/cc;->b:Lcom/wishabi/flipp/app/bx;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/bx;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->resolveActivity(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 372
    iget-object v1, p0, Lcom/wishabi/flipp/app/cc;->b:Lcom/wishabi/flipp/app/bx;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/app/bx;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method
