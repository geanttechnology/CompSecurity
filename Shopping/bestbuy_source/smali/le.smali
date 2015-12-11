.class public Lle;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Landroid/support/v4/app/Fragment;

.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;)V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lle;->b:Landroid/content/Context;

    .line 19
    iput-object p2, p0, Lle;->a:Landroid/support/v4/app/Fragment;

    .line 20
    return-void
.end method

.method static synthetic a(Lle;)Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 11
    iget-object v0, p0, Lle;->a:Landroid/support/v4/app/Fragment;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 23
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lle;->b:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 24
    const-string v1, "<font face = \'Sans-Serif\'>Are you sure you want to sign out?</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const-string v2, "<font face = \'Sans-Serif\'>Sign Out</font>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lle$2;

    invoke-direct {v3, p0}, Lle$2;-><init>(Lle;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const-string v2, "<font face = \'Sans-Serif\'>Cancel</font>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lle$1;

    invoke-direct {v3, p0}, Lle$1;-><init>(Lle;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 45
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 46
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 47
    return-void
.end method
