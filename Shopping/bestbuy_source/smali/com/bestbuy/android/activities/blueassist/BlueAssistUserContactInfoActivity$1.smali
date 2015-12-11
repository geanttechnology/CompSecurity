.class Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)V
    .locals 0

    .prologue
    .line 134
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    invoke-virtual {v0, v9}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setEnabled(Z)V

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->c(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->c(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->e(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Ljava/lang/String;)Ljava/lang/String;

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->f(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->f(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z

    .line 144
    new-instance v0, Lhy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->g(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v3}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->h(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v4}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->i(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v5}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->j(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v6}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->f(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v6

    invoke-direct/range {v0 .. v6}, Lhy;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-array v1, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhy;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 149
    :goto_0
    return-void

    .line 146
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0, v9}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z

    .line 147
    new-instance v0, Lhu;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v2}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->g(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v3}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->h(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v4}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->i(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v5}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->k(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v6}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->l(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v7}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->j(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v7

    iget-object v8, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity$1;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v8}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->m(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Ljava/lang/String;

    move-result-object v8

    invoke-direct/range {v0 .. v8}, Lhu;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-array v1, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhu;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
