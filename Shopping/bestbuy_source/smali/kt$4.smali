.class Lkt$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lkt;->a()V
.end annotation


# instance fields
.field final synthetic a:Landroid/content/res/Resources;

.field final synthetic b:Lkt;


# direct methods
.method constructor <init>(Lkt;Landroid/content/res/Resources;)V
    .locals 0

    .prologue
    .line 81
    iput-object p1, p0, Lkt$4;->b:Lkt;

    iput-object p2, p0, Lkt$4;->a:Landroid/content/res/Resources;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3

    .prologue
    .line 85
    iget-object v0, p0, Lkt$4;->b:Lkt;

    invoke-static {v0}, Lkt;->a(Lkt;)Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 86
    iget-object v1, p0, Lkt$4;->a:Landroid/content/res/Resources;

    const v2, 0x7f08008a

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 87
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 88
    iget-object v0, p0, Lkt$4;->b:Lkt;

    invoke-static {v0}, Lkt;->b(Lkt;)Landroid/content/Context;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Llq;->a(Landroid/content/Context;Ljava/util/ArrayList;)V

    .line 90
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 91
    return-void
.end method
