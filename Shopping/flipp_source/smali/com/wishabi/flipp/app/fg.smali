.class public final Lcom/wishabi/flipp/app/fg;
.super Landroid/app/DialogFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/widget/EditText;

.field private b:Landroid/widget/EditText;

.field private c:Landroid/widget/EditText;

.field private d:Landroid/widget/CheckBox;

.field private e:Landroid/app/AlertDialog;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    return-void
.end method

.method static synthetic a(Lcom/wishabi/flipp/app/fg;)Landroid/widget/CheckBox;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->d:Landroid/widget/CheckBox;

    return-object v0
.end method

.method static synthetic b(Lcom/wishabi/flipp/app/fg;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->a:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic c(Lcom/wishabi/flipp/app/fg;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->b:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic d(Lcom/wishabi/flipp/app/fg;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->c:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic e(Lcom/wishabi/flipp/app/fg;)V
    .locals 2

    .prologue
    .line 28
    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->e:Landroid/app/AlertDialog;

    const/4 v1, -0x1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->getButton(I)Landroid/widget/Button;

    move-result-object v1

    if-eqz v1, :cond_1

    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->a:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_2

    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->d:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->b:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-gtz v0, :cond_0

    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->c:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_2

    :cond_0
    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/Button;->setEnabled(Z)V

    :cond_1
    return-void

    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 8

    .prologue
    const/4 v7, 0x0

    const/4 v2, 0x0

    .line 42
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fg;->getActivity()Landroid/app/Activity;

    move-result-object v3

    .line 43
    if-nez v3, :cond_0

    move-object v0, v2

    .line 175
    :goto_0
    return-object v0

    .line 46
    :cond_0
    new-instance v4, Landroid/app/AlertDialog$Builder;

    invoke-direct {v4, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 47
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fg;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    .line 49
    const v1, 0x7f030051

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 51
    if-nez v0, :cond_1

    move-object v0, v2

    .line 52
    goto :goto_0

    .line 54
    :cond_1
    const v1, 0x7f0b013b

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 55
    const v1, 0x7f0b013a

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/CheckBox;

    iput-object v1, p0, Lcom/wishabi/flipp/app/fg;->d:Landroid/widget/CheckBox;

    .line 57
    if-eqz v5, :cond_2

    .line 58
    iget-object v1, p0, Lcom/wishabi/flipp/app/fg;->d:Landroid/widget/CheckBox;

    new-instance v6, Lcom/wishabi/flipp/app/fh;

    invoke-direct {v6, p0, v5}, Lcom/wishabi/flipp/app/fh;-><init>(Lcom/wishabi/flipp/app/fg;Landroid/view/View;)V

    invoke-virtual {v1, v6}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 68
    :cond_2
    const v1, 0x7f0b00be

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/wishabi/flipp/app/fg;->a:Landroid/widget/EditText;

    .line 70
    const v1, 0x7f0b013c

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/wishabi/flipp/app/fg;->b:Landroid/widget/EditText;

    .line 71
    const v1, 0x7f0b013d

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/EditText;

    iput-object v1, p0, Lcom/wishabi/flipp/app/fg;->c:Landroid/widget/EditText;

    .line 74
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/fg;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-string v5, "com.wishabi.flipp.preferences"

    invoke-virtual {v1, v5, v7}, Landroid/app/Activity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 78
    const-string v5, "email"

    invoke-interface {v1, v5, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 79
    const-string v6, "twitter_handle"

    invoke-interface {v1, v6, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 81
    iget-object v6, p0, Lcom/wishabi/flipp/app/fg;->b:Landroid/widget/EditText;

    invoke-virtual {v6, v5}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 82
    iget-object v5, p0, Lcom/wishabi/flipp/app/fg;->c:Landroid/widget/EditText;

    invoke-virtual {v5, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 84
    invoke-virtual {v3}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 85
    invoke-virtual {v3}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    .line 86
    if-eqz v2, :cond_3

    .line 89
    const/4 v5, 0x0

    :try_start_0
    invoke-virtual {v2, v3, v5}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    iget-object v2, v2, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 92
    :cond_3
    :goto_1
    const v2, 0x7f0e0115

    invoke-virtual {v4, v2}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/app/AlertDialog$Builder;->setView(Landroid/view/View;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    const v3, 0x7f0e0123

    new-instance v5, Lcom/wishabi/flipp/app/fj;

    invoke-direct {v5, p0, v1, v0}, Lcom/wishabi/flipp/app/fj;-><init>(Lcom/wishabi/flipp/app/fg;Landroid/content/SharedPreferences;Landroid/view/ViewGroup;)V

    invoke-virtual {v2, v3, v5}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const/high16 v1, 0x1040000

    new-instance v2, Lcom/wishabi/flipp/app/fi;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/fi;-><init>(Lcom/wishabi/flipp/app/fg;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 139
    invoke-virtual {v4}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/wishabi/flipp/app/fg;->e:Landroid/app/AlertDialog;

    .line 140
    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->e:Landroid/app/AlertDialog;

    new-instance v1, Lcom/wishabi/flipp/app/fk;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/fk;-><init>(Lcom/wishabi/flipp/app/fg;)V

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->setOnShowListener(Landroid/content/DialogInterface$OnShowListener;)V

    .line 147
    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->d:Landroid/widget/CheckBox;

    new-instance v1, Lcom/wishabi/flipp/app/fl;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/app/fl;-><init>(Lcom/wishabi/flipp/app/fg;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 156
    new-instance v0, Lcom/wishabi/flipp/app/fm;

    invoke-direct {v0, p0}, Lcom/wishabi/flipp/app/fm;-><init>(Lcom/wishabi/flipp/app/fg;)V

    .line 171
    iget-object v1, p0, Lcom/wishabi/flipp/app/fg;->a:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 172
    iget-object v1, p0, Lcom/wishabi/flipp/app/fg;->b:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 173
    iget-object v1, p0, Lcom/wishabi/flipp/app/fg;->c:Landroid/widget/EditText;

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 175
    iget-object v0, p0, Lcom/wishabi/flipp/app/fg;->e:Landroid/app/AlertDialog;

    goto/16 :goto_0

    :catch_0
    move-exception v2

    goto :goto_1
.end method
