.class final Lcom/wishabi/flipp/app/cj;
.super Landroid/support/v13/app/h;
.source "SourceFile"


# instance fields
.field final synthetic b:Lcom/wishabi/flipp/app/HelpActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/HelpActivity;Landroid/app/FragmentManager;)V
    .locals 0

    .prologue
    .line 403
    iput-object p1, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-direct {p0, p2}, Landroid/support/v13/app/h;-><init>(Landroid/app/FragmentManager;)V

    return-void
.end method


# virtual methods
.method public final a(I)Landroid/app/Fragment;
    .locals 2

    .prologue
    .line 406
    sget-object v0, Lcom/wishabi/flipp/app/do;->a:Lcom/wishabi/flipp/app/do;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/do;->b()[I

    move-result-object v0

    .line 408
    iget-object v1, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v1}, Lcom/wishabi/flipp/app/HelpActivity;->a(Lcom/wishabi/flipp/app/HelpActivity;)[Landroid/view/View;

    move-result-object v1

    array-length v1, v1

    if-ge p1, v1, :cond_0

    .line 409
    aget v0, v0, p1

    iget-object v1, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v1}, Lcom/wishabi/flipp/app/HelpActivity;->a(Lcom/wishabi/flipp/app/HelpActivity;)[Landroid/view/View;

    move-result-object v1

    aget-object v1, v1, p1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/cm;->a(ILandroid/view/View;)Lcom/wishabi/flipp/app/cm;

    move-result-object v0

    .line 418
    :goto_0
    return-object v0

    .line 412
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    new-instance v1, Lcom/wishabi/flipp/app/cn;

    invoke-direct {v1}, Lcom/wishabi/flipp/app/cn;-><init>()V

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/HelpActivity;->a(Lcom/wishabi/flipp/app/HelpActivity;Lcom/wishabi/flipp/app/cn;)Lcom/wishabi/flipp/app/cn;

    .line 413
    iget-object v0, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/HelpActivity;->c(Lcom/wishabi/flipp/app/HelpActivity;)Lcom/wishabi/flipp/app/cn;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v1}, Lcom/wishabi/flipp/app/HelpActivity;->b(Lcom/wishabi/flipp/app/HelpActivity;)Lcom/wishabi/flipp/app/cv;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/app/cn;->a:Lcom/wishabi/flipp/app/cv;

    .line 416
    iget-object v0, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/HelpActivity;->d(Lcom/wishabi/flipp/app/HelpActivity;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 417
    iget-object v0, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/HelpActivity;->c(Lcom/wishabi/flipp/app/HelpActivity;)Lcom/wishabi/flipp/app/cn;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v1}, Lcom/wishabi/flipp/app/HelpActivity;->d(Lcom/wishabi/flipp/app/HelpActivity;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/wishabi/flipp/app/cn;->b:Ljava/lang/String;

    .line 418
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/HelpActivity;->c(Lcom/wishabi/flipp/app/HelpActivity;)Lcom/wishabi/flipp/app/cn;

    move-result-object v0

    goto :goto_0
.end method

.method public final c()I
    .locals 1

    .prologue
    .line 423
    iget-object v0, p0, Lcom/wishabi/flipp/app/cj;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v0}, Lcom/wishabi/flipp/app/HelpActivity;->a(Lcom/wishabi/flipp/app/HelpActivity;)[Landroid/view/View;

    move-result-object v0

    array-length v0, v0

    add-int/lit8 v0, v0, 0x1

    return v0
.end method
