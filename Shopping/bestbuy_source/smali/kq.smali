.class public Lkq;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Lno;

.field private c:Lnn;

.field private d:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lkq;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lkq;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lno;Lnn;)V
    .locals 2

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p2, p0, Lkq;->b:Lno;

    .line 24
    iput-object p3, p0, Lkq;->c:Lnn;

    .line 25
    iput-object p1, p0, Lkq;->d:Landroid/content/Context;

    .line 29
    sget-object v0, Lkq;->a:Ljava/lang/String;

    const-string v1, "No Connectivity called - Callstack"

    invoke-static {v0, v1}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 30
    sget-object v0, Lkq;->a:Ljava/lang/String;

    new-instance v1, Ljava/lang/Exception;

    invoke-direct {v1}, Ljava/lang/Exception;-><init>()V

    invoke-static {v0, v1}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    .line 31
    return-void
.end method

.method static synthetic a(Lkq;)Lnn;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lkq;->c:Lnn;

    return-object v0
.end method

.method static synthetic b(Lkq;)Lno;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lkq;->b:Lno;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 34
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lkq;->d:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 35
    const-string v1, "<font face = \'Sans-Serif\'>\nThe service is not responding.\n Please reload or check back soon.\n</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const-string v2, "<font face = \'Sans-Serif\'><b> Reload </b></font>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lkq$2;

    invoke-direct {v3, p0}, Lkq$2;-><init>(Lkq;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const-string v2, "<font face = \'Sans-Serif\'>Cancel</font>"

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lkq$1;

    invoke-direct {v3, p0}, Lkq$1;-><init>(Lkq;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 56
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 57
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 58
    return-void
.end method
