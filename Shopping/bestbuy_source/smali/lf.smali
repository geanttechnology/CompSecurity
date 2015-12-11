.class public Llf;
.super Landroid/app/Dialog;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Landroid/content/Context;

.field private b:Landroid/net/Uri;

.field private c:Ljava/lang/String;

.field private d:Llg;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;Llg;)V
    .locals 1

    .prologue
    .line 23
    const v0, 0x7f0e002b

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 24
    iput-object p1, p0, Llf;->a:Landroid/content/Context;

    .line 25
    iput-object p2, p0, Llf;->b:Landroid/net/Uri;

    .line 26
    iput-object p3, p0, Llf;->c:Ljava/lang/String;

    .line 27
    iput-object p4, p0, Llf;->d:Llg;

    .line 28
    return-void
.end method

.method static synthetic a(Llf;)Llg;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Llf;->d:Llg;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 47
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c03bc

    if-ne v0, v1, :cond_2

    .line 48
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 49
    iget-object v1, p0, Llf;->b:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 50
    iget-object v1, p0, Llf;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->resolveActivity(Landroid/content/pm/PackageManager;)Landroid/content/ComponentName;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 51
    iget-object v1, p0, Llf;->a:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 53
    :cond_0
    invoke-virtual {p0}, Llf;->dismiss()V

    .line 54
    iget-object v0, p0, Llf;->d:Llg;

    invoke-interface {v0, v3}, Llg;->a(Z)V

    .line 68
    :cond_1
    :goto_0
    return-void

    .line 56
    :cond_2
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c03bd

    if-ne v0, v1, :cond_3

    .line 57
    iget-object v0, p0, Llf;->a:Landroid/content/Context;

    const-string v1, "clipboard"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ClipboardManager;

    .line 58
    const-string v1, "StoreAddress"

    iget-object v2, p0, Llf;->c:Ljava/lang/String;

    invoke-static {v1, v2}, Landroid/content/ClipData;->newPlainText(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/content/ClipData;

    move-result-object v1

    .line 59
    invoke-virtual {v0, v1}, Landroid/content/ClipboardManager;->setPrimaryClip(Landroid/content/ClipData;)V

    .line 60
    invoke-virtual {p0}, Llf;->dismiss()V

    .line 61
    iget-object v0, p0, Llf;->d:Llg;

    invoke-interface {v0, v3}, Llg;->a(Z)V

    goto :goto_0

    .line 63
    :cond_3
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c00a4

    if-ne v0, v1, :cond_1

    .line 64
    invoke-virtual {p0}, Llf;->dismiss()V

    .line 65
    iget-object v0, p0, Llf;->d:Llg;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Llg;->a(Z)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 31
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 32
    const v0, 0x7f0300f6

    invoke-virtual {p0, v0}, Llf;->setContentView(I)V

    .line 33
    const v0, 0x7f0c03bc

    invoke-virtual {p0, v0}, Llf;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 34
    const v0, 0x7f0c03bd

    invoke-virtual {p0, v0}, Llf;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 35
    const v0, 0x7f0c00a4

    invoke-virtual {p0, v0}, Llf;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 36
    new-instance v0, Llf$1;

    invoke-direct {v0, p0}, Llf$1;-><init>(Llf;)V

    invoke-virtual {p0, v0}, Llf;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 43
    return-void
.end method
