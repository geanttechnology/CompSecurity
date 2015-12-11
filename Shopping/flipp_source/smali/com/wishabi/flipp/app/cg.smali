.class final Lcom/wishabi/flipp/app/cg;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/app/cv;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/HelpActivity;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/HelpActivity;)V
    .locals 0

    .prologue
    .line 52
    iput-object p1, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 55
    iget-object v0, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/wishabi/flipp/app/HelpActivity;->a(Lcom/wishabi/flipp/app/HelpActivity;Z)Z

    .line 56
    return-void
.end method

.method public final a(Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v2, 0x0

    const/4 v3, 0x3

    .line 60
    iget-object v0, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-static {v0, v2}, Lcom/wishabi/flipp/app/HelpActivity;->a(Lcom/wishabi/flipp/app/HelpActivity;Z)Z

    .line 62
    if-nez p1, :cond_0

    .line 63
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v1, 0x7f0e00bb

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x104000a

    new-instance v2, Lcom/wishabi/flipp/app/ch;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/ch;-><init>(Lcom/wishabi/flipp/app/cg;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 102
    :goto_0
    return-void

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    const-string v1, "com.wishabi.flipp.preferences"

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/app/HelpActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "postal_code"

    invoke-interface {v0, v1, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 82
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    iput-object p1, v0, Lcom/wishabi/flipp/b/a;->k:Ljava/lang/String;

    .line 85
    sget-object v0, Lcom/wishabi/flipp/app/do;->a:Lcom/wishabi/flipp/app/do;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/do;->a()I

    move-result v0

    .line 88
    sget-object v1, Lcom/wishabi/flipp/app/do;->a:Lcom/wishabi/flipp/app/do;

    invoke-virtual {v1}, Lcom/wishabi/flipp/app/do;->a()I

    move-result v2

    if-eq v2, v3, :cond_1

    invoke-static {}, Lcom/wishabi/flipp/util/p;->a()Landroid/content/SharedPreferences;

    move-result-object v2

    if-eqz v2, :cond_1

    iput v3, v1, Lcom/wishabi/flipp/app/do;->b:I

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string v2, "last_onboarding_version"

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 90
    :cond_1
    if-nez v0, :cond_2

    .line 91
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    const-class v2, Lcom/wishabi/flipp/app/MainActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 92
    iget-object v1, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/app/HelpActivity;->startActivity(Landroid/content/Intent;)V

    .line 93
    iget-object v0, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/HelpActivity;->finish()V

    goto :goto_0

    .line 97
    :cond_2
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    const-class v2, Lcom/wishabi/flipp/app/MainActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 98
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 99
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 100
    iget-object v1, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-virtual {v1, v0}, Lcom/wishabi/flipp/app/HelpActivity;->startActivity(Landroid/content/Intent;)V

    .line 101
    iget-object v0, p0, Lcom/wishabi/flipp/app/cg;->a:Lcom/wishabi/flipp/app/HelpActivity;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/HelpActivity;->finish()V

    goto :goto_0
.end method
