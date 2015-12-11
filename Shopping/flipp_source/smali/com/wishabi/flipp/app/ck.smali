.class final Lcom/wishabi/flipp/app/ck;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/view/cd;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/widget/ViewPagerIndicator;

.field final synthetic b:Lcom/wishabi/flipp/app/HelpActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/HelpActivity;Lcom/wishabi/flipp/widget/ViewPagerIndicator;)V
    .locals 0

    .prologue
    .line 434
    iput-object p1, p0, Lcom/wishabi/flipp/app/ck;->b:Lcom/wishabi/flipp/app/HelpActivity;

    iput-object p2, p0, Lcom/wishabi/flipp/app/ck;->a:Lcom/wishabi/flipp/widget/ViewPagerIndicator;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 3

    .prologue
    .line 438
    iget-object v0, p0, Lcom/wishabi/flipp/app/ck;->b:Lcom/wishabi/flipp/app/HelpActivity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/app/HelpActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 440
    iget-object v1, p0, Lcom/wishabi/flipp/app/ck;->b:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/HelpActivity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    .line 441
    if-eqz v1, :cond_0

    .line 442
    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 445
    :cond_0
    return-void
.end method

.method public final a(I)V
    .locals 3

    .prologue
    .line 449
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "TutorialScreen"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;)V

    .line 450
    iget-object v0, p0, Lcom/wishabi/flipp/app/ck;->a:Lcom/wishabi/flipp/widget/ViewPagerIndicator;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ViewPagerIndicator;->invalidate()V

    .line 451
    return-void
.end method
