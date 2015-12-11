.class Lcom/bestbuy/android/activities/home/HomeFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/home/HomeFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/HomeFragment;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    const v3, 0x7f080275

    .line 161
    check-cast p1, Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {p1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 162
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08027b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->b(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08032c

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->c(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setText(Ljava/lang/CharSequence;)V

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->d(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080283

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setText(Ljava/lang/CharSequence;)V

    .line 171
    :cond_0
    :goto_0
    return-void

    .line 166
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08027a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 168
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->f(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->e(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$1;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;Z)V

    goto :goto_0
.end method
