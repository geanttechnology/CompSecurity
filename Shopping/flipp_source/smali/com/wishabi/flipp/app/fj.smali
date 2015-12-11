.class final Lcom/wishabi/flipp/app/fj;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic a:Landroid/content/SharedPreferences;

.field final synthetic b:Landroid/view/ViewGroup;

.field final synthetic c:Lcom/wishabi/flipp/app/fg;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/fg;Landroid/content/SharedPreferences;Landroid/view/ViewGroup;)V
    .locals 0

    .prologue
    .line 98
    iput-object p1, p0, Lcom/wishabi/flipp/app/fj;->c:Lcom/wishabi/flipp/app/fg;

    iput-object p2, p0, Lcom/wishabi/flipp/app/fj;->a:Landroid/content/SharedPreferences;

    iput-object p3, p0, Lcom/wishabi/flipp/app/fj;->b:Landroid/view/ViewGroup;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onClick(Landroid/content/DialogInterface;I)V
    .locals 6

    .prologue
    .line 100
    iget-object v0, p0, Lcom/wishabi/flipp/app/fj;->c:Lcom/wishabi/flipp/app/fg;

    invoke-static {v0}, Lcom/wishabi/flipp/app/fg;->b(Lcom/wishabi/flipp/app/fg;)Landroid/widget/EditText;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v0

    .line 101
    iget-object v1, p0, Lcom/wishabi/flipp/app/fj;->c:Lcom/wishabi/flipp/app/fg;

    invoke-static {v1}, Lcom/wishabi/flipp/app/fg;->c(Lcom/wishabi/flipp/app/fg;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    .line 102
    iget-object v1, p0, Lcom/wishabi/flipp/app/fj;->c:Lcom/wishabi/flipp/app/fg;

    invoke-static {v1}, Lcom/wishabi/flipp/app/fg;->d(Lcom/wishabi/flipp/app/fg;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v3

    .line 103
    if-eqz v0, :cond_0

    if-eqz v2, :cond_0

    if-nez v3, :cond_1

    .line 132
    :cond_0
    :goto_0
    return-void

    .line 107
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    .line 108
    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    .line 109
    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 111
    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 112
    iget-object v0, p0, Lcom/wishabi/flipp/app/fj;->a:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v4, "email"

    invoke-interface {v0, v4, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 114
    :cond_2
    invoke-virtual {v3}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 115
    iget-object v0, p0, Lcom/wishabi/flipp/app/fj;->a:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v4, "twitter_handle"

    invoke-interface {v0, v4, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 118
    :cond_3
    iget-object v0, p0, Lcom/wishabi/flipp/app/fj;->b:Landroid/view/ViewGroup;

    const v4, 0x7f0b013a

    invoke-virtual {v0, v4}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    .line 120
    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v4

    .line 121
    iget-object v0, p0, Lcom/wishabi/flipp/app/fj;->b:Landroid/view/ViewGroup;

    const v5, 0x7f0b013e

    invoke-virtual {v0, v5}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    .line 123
    invoke-virtual {v0}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v5

    .line 126
    new-instance v0, Lcom/wishabi/flipp/b/au;

    invoke-direct/range {v0 .. v5}, Lcom/wishabi/flipp/b/au;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/b/au;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 129
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget-object v2, Lcom/wishabi/flipp/b/t;->a:Lcom/wishabi/flipp/b/t;

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;Lcom/wishabi/flipp/b/t;)V

    goto :goto_0
.end method
