.class public Lld;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Lnn;

.field private b:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lnn;)V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    iput-object p2, p0, Lld;->a:Lnn;

    .line 18
    iput-object p1, p0, Lld;->b:Landroid/content/Context;

    .line 19
    return-void
.end method

.method static synthetic a(Lld;)Lnn;
    .locals 1

    .prologue
    .line 10
    iget-object v0, p0, Lld;->a:Lnn;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 22
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lld;->b:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 23
    const-string v1, "<font face = \'Sans-Serif\'>We\'re sorry. This service is being \nupdated. Please check back soon.</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const-string v2, "<font face = \'Sans-Serif\'>Okay</font>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lld$1;

    invoke-direct {v3, p0}, Lld$1;-><init>(Lld;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 33
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 34
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 35
    return-void
.end method
