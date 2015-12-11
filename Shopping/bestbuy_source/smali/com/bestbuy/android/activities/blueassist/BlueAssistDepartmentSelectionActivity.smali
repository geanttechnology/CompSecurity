.class public Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Lnb;

.field private b:Landroid/widget/RelativeLayout;

.field private c:Landroid/widget/ImageView;

.field private d:Landroid/widget/ImageView;

.field private e:Landroid/widget/RelativeLayout;

.field private f:Lcom/bestbuy/android/bbyobjects/BBYTextView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 0

    .prologue
    .line 73
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onBackPressed()V

    .line 74
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->finish()V

    .line 75
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->b:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_1

    .line 53
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 62
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->startActivity(Landroid/content/Intent;)V

    .line 69
    :cond_0
    :goto_0
    return-void

    .line 63
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->d:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_2

    .line 64
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->finish()V

    goto :goto_0

    .line 65
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->c:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_0

    .line 66
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->finish()V

    .line 67
    const v0, 0x7f040005

    const v1, 0x7f040008

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 28
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 29
    const v0, 0x7f03002d

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->setContentView(I)V

    .line 30
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->a:Lnb;

    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->a:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->i(Z)V

    .line 32
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xffc7a1

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 33
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 34
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 35
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 36
    const v0, 0x7f0c00b7

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->b:Landroid/widget/RelativeLayout;

    .line 37
    const v0, 0x7f0c0067

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->c:Landroid/widget/ImageView;

    .line 38
    const v0, 0x7f0c0068

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->d:Landroid/widget/ImageView;

    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->c:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->d:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->b:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 42
    const v0, 0x7f0c0020

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->e:Landroid/widget/RelativeLayout;

    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->e:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c015e

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->e:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c015f

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 45
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->f:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v2, 0x7f08021f

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 46
    const v1, 0x7f0802f9

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistDepartmentSelectionActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 47
    sget-object v0, Llu;->aL:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 48
    return-void
.end method
