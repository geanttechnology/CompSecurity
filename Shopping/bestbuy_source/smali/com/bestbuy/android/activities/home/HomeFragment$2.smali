.class Lcom/bestbuy/android/activities/home/HomeFragment$2;
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
    .line 174
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    const v3, 0x7f080356

    const/4 v5, 0x0

    .line 178
    check-cast p1, Lcom/bestbuy/android/bbyobjects/BBYButton;

    invoke-virtual {p1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    .line 179
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080392

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->b(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0801d1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->c(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08027a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setText(Ljava/lang/CharSequence;)V

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->d(Lcom/bestbuy/android/activities/home/HomeFragment;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setText(Ljava/lang/CharSequence;)V

    .line 201
    :cond_0
    :goto_0
    return-void

    .line 183
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 184
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 185
    const-string v1, "market://details?id=com.bestbuy.android"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 187
    :try_start_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->startActivity(Landroid/content/Intent;)V

    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->f(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->e(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 189
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;Z)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 190
    :catch_0
    move-exception v0

    .line 191
    const-string v1, "HomeFragment.java"

    invoke-static {v1, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 192
    const-string v1, "HomeFragment.java"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Not able to find Market Activity: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 194
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080283

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/home/HomeFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->l()Ljava/lang/String;

    move-result-object v0

    .line 196
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Best Buy Mobile App Feedback v"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 197
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    const-string v3, "onlinestore@bestbuy.com"

    const-string v4, ""

    invoke-virtual {v2, v3, v0, v4}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->startActivity(Landroid/content/Intent;)V

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->f(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->e(Lcom/bestbuy/android/activities/home/HomeFragment;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/HomeFragment$2;->a:Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-static {v0, v5}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/activities/home/HomeFragment;Z)V

    goto/16 :goto_0
.end method
