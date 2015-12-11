.class public Lkt;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Landroid/content/Context;

.field private b:Lku;

.field private c:Lnb;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lku;)V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 24
    sget-object v0, Lku;->c:Lku;

    iput-object v0, p0, Lkt;->b:Lku;

    .line 34
    iput-object p1, p0, Lkt;->a:Landroid/content/Context;

    .line 35
    iput-object p2, p0, Lkt;->b:Lku;

    .line 36
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lkt;->c:Lnb;

    .line 37
    return-void
.end method

.method static synthetic a(Lkt;)Lnb;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lkt;->c:Lnb;

    return-object v0
.end method

.method static synthetic b(Lkt;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lkt;->a:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    const v8, 0x7f08003d

    const v7, 0x7f08001f

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 40
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lkt;->a:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 41
    iget-object v1, p0, Lkt;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 42
    iget-object v2, p0, Lkt;->b:Lku;

    sget-object v3, Lku;->a:Lku;

    if-ne v2, v3, :cond_1

    .line 43
    iget-object v2, p0, Lkt;->c:Lnb;

    invoke-virtual {v2}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v2

    .line 44
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 45
    iget-object v3, p0, Lkt;->a:Landroid/content/Context;

    const v4, 0x7f08004c

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v6}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 46
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 48
    const v2, 0x7f080186

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    invoke-virtual {v1, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lkt$2;

    invoke-direct {v4, p0, v1}, Lkt$2;-><init>(Lkt;Landroid/content/res/Resources;)V

    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    invoke-virtual {v1, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v3, Lkt$1;

    invoke-direct {v3, p0}, Lkt$1;-><init>(Lkt;)V

    invoke-virtual {v2, v1, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 104
    :goto_0
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 105
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 106
    :cond_0
    return-void

    .line 71
    :cond_1
    iget-object v2, p0, Lkt;->b:Lku;

    sget-object v3, Lku;->b:Lku;

    if-ne v2, v3, :cond_0

    .line 72
    iget-object v2, p0, Lkt;->c:Lnb;

    invoke-virtual {v2}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v2

    .line 73
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 74
    iget-object v3, p0, Lkt;->a:Landroid/content/Context;

    const v4, 0x7f08004d

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v6}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 75
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 77
    const v2, 0x7f080189

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    invoke-virtual {v1, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    new-instance v4, Lkt$4;

    invoke-direct {v4, p0, v1}, Lkt$4;-><init>(Lkt;Landroid/content/res/Resources;)V

    invoke-virtual {v2, v3, v4}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v2

    invoke-virtual {v1, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    new-instance v3, Lkt$3;

    invoke-direct {v3, p0}, Lkt$3;-><init>(Lkt;)V

    invoke-virtual {v2, v1, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    goto :goto_0
.end method
