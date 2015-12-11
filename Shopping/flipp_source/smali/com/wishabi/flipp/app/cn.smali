.class public final Lcom/wishabi/flipp/app/cn;
.super Landroid/app/Fragment;
.source "SourceFile"


# instance fields
.field a:Lcom/wishabi/flipp/app/cv;

.field b:Ljava/lang/String;

.field private c:Landroid/widget/Button;

.field private d:Landroid/widget/EditText;

.field private e:Landroid/widget/ProgressBar;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 155
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 162
    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/cn;)Landroid/widget/ProgressBar;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->e:Landroid/widget/ProgressBar;

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/cn;)Lcom/wishabi/flipp/app/cv;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->a:Lcom/wishabi/flipp/app/cv;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/cn;)Landroid/widget/Button;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->c:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/cn;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 155
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->d:Landroid/widget/EditText;

    if-eqz v0, :cond_1

    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iget-object v0, v0, Lcom/wishabi/flipp/b/a;->b:Landroid/content/Context;

    const-string v1, "com.wishabi.flipp.preferences"

    invoke-virtual {v0, v1, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "tutorialComplete"

    const-string v2, "no"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "no"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "tutorialComplete"

    const-string v2, "yes"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->d:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "\\s"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->d(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cn;->getActivity()Landroid/app/Activity;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-static {v1}, Lcom/wishabi/flipp/util/g;->a(Landroid/app/Activity;)V

    iget-object v1, p0, Lcom/wishabi/flipp/app/cn;->e:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    sget-object v1, Lcom/wishabi/flipp/b/u;->a:Lcom/wishabi/flipp/b/u;

    new-instance v2, Lcom/wishabi/flipp/app/co;

    invoke-direct {v2, p0, v0}, Lcom/wishabi/flipp/app/co;-><init>(Lcom/wishabi/flipp/app/cn;Ljava/lang/String;)V

    invoke-virtual {v1, v0, v2}, Lcom/wishabi/flipp/b/u;->a(Ljava/lang/String;Lcom/wishabi/flipp/b/x;)I

    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->a:Lcom/wishabi/flipp/app/cv;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->a:Lcom/wishabi/flipp/app/cv;

    invoke-interface {v0}, Lcom/wishabi/flipp/app/cv;->a()V

    :cond_1
    return-void
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/cn;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 155
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->d:Landroid/widget/EditText;

    return-object v0
.end method


# virtual methods
.method public final onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v2, 0x0

    .line 236
    invoke-super {p0, p1, p2, p3}, Landroid/app/Fragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 238
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/cn;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 239
    if-nez v1, :cond_0

    move-object v0, v2

    .line 351
    :goto_0
    return-object v0

    .line 242
    :cond_0
    invoke-static {v1}, Lcom/google/android/gms/common/g;->a(Landroid/content/Context;)I

    move-result v0

    if-nez v0, :cond_1

    const v0, 0x7f030043

    :goto_1
    invoke-virtual {p1, v0, p2, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 248
    if-nez v3, :cond_2

    move-object v0, v2

    .line 249
    goto :goto_0

    .line 242
    :cond_1
    const v0, 0x7f030042

    goto :goto_1

    .line 251
    :cond_2
    const v0, 0x7f0b00f9

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 252
    const v4, 0x7f0e00c3

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {}, Lcom/wishabi/flipp/util/q;->b()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v1, v4, v5}, Landroid/app/Activity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 255
    const v0, 0x7f0b00fc

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cn;->e:Landroid/widget/ProgressBar;

    .line 257
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->e:Landroid/widget/ProgressBar;

    if-nez v0, :cond_3

    move-object v0, v2

    .line 258
    goto :goto_0

    .line 260
    :cond_3
    const v0, 0x7f0b00fa

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cn;->d:Landroid/widget/EditText;

    .line 261
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->d:Landroid/widget/EditText;

    if-nez v0, :cond_4

    move-object v0, v2

    .line 262
    goto :goto_0

    .line 264
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->d:Landroid/widget/EditText;

    const v4, 0x12000002

    invoke-virtual {v0, v4}, Landroid/widget/EditText;->setImeOptions(I)V

    .line 268
    const-string v0, "com.wishabi.flipp.preferences"

    invoke-virtual {v1, v0, v7}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "postal_code"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 271
    if-nez v0, :cond_7

    .line 272
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->b:Ljava/lang/String;

    move-object v1, v0

    .line 273
    :goto_2
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->d:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 275
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->d:Landroid/widget/EditText;

    new-instance v4, Lcom/wishabi/flipp/app/cp;

    invoke-direct {v4, p0}, Lcom/wishabi/flipp/app/cp;-><init>(Lcom/wishabi/flipp/app/cn;)V

    invoke-virtual {v0, v4}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 292
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->d:Landroid/widget/EditText;

    new-instance v4, Lcom/wishabi/flipp/app/cq;

    invoke-direct {v4, p0}, Lcom/wishabi/flipp/app/cq;-><init>(Lcom/wishabi/flipp/app/cn;)V

    invoke-virtual {v0, v4}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 302
    const v0, 0x7f0b00fd

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 303
    if-eqz v0, :cond_5

    .line 304
    new-instance v4, Lcom/wishabi/flipp/app/cr;

    invoke-direct {v4, p0}, Lcom/wishabi/flipp/app/cr;-><init>(Lcom/wishabi/flipp/app/cn;)V

    invoke-virtual {v0, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 339
    :cond_5
    const v0, 0x7f0b00fb

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/wishabi/flipp/app/cn;->c:Landroid/widget/Button;

    .line 340
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->c:Landroid/widget/Button;

    if-nez v0, :cond_6

    move-object v0, v2

    .line 341
    goto/16 :goto_0

    .line 343
    :cond_6
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->c:Landroid/widget/Button;

    new-instance v2, Lcom/wishabi/flipp/app/cu;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/cu;-><init>(Lcom/wishabi/flipp/app/cn;)V

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 349
    iget-object v0, p0, Lcom/wishabi/flipp/app/cn;->c:Landroid/widget/Button;

    invoke-static {v1}, Lcom/wishabi/flipp/util/k;->d(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setEnabled(Z)V

    move-object v0, v3

    .line 351
    goto/16 :goto_0

    :cond_7
    move-object v1, v0

    goto :goto_2
.end method
