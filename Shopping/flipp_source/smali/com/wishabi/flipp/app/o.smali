.class final Lcom/wishabi/flipp/app/o;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/wishabi/flipp/widget/ae;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/n;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/n;)V
    .locals 0

    .prologue
    .line 148
    iput-object p1, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()V
    .locals 3

    .prologue
    .line 209
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    const-class v1, Lcom/wishabi/flipp/app/z;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/wishabi/flipp/app/n;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 210
    return-void
.end method

.method public final a(I)V
    .locals 4

    .prologue
    .line 168
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 169
    if-nez v0, :cond_1

    .line 183
    :cond_0
    :goto_0
    return-void

    .line 172
    :cond_1
    iget-object v1, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v1}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;)Lcom/wishabi/flipp/widget/aa;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 175
    iget-object v1, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v1}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;)Lcom/wishabi/flipp/widget/aa;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/wishabi/flipp/widget/aa;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v1

    .line 176
    if-eqz v1, :cond_0

    .line 180
    const/4 v2, 0x1

    sget-object v3, Lcom/wishabi/flipp/b/p;->e:Lcom/wishabi/flipp/b/p;

    invoke-static {v1, v2, v3}, Lcom/wishabi/flipp/content/a;->a(Lcom/wishabi/flipp/content/c;ZLcom/wishabi/flipp/b/p;)Z

    .line 182
    invoke-static {}, Lcom/wishabi/flipp/app/PrintCouponActivity;->a()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public final a(II)V
    .locals 3

    .prologue
    .line 214
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v1

    .line 215
    if-nez v1, :cond_1

    .line 242
    :cond_0
    :goto_0
    return-void

    .line 218
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;)Lcom/wishabi/flipp/widget/aa;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 221
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->b(Lcom/wishabi/flipp/app/n;)Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 224
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;)Lcom/wishabi/flipp/widget/aa;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/aa;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v0

    .line 225
    if-eqz v0, :cond_0

    .line 228
    iget-object v2, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v2}, Lcom/wishabi/flipp/app/n;->b(Lcom/wishabi/flipp/app/n;)Ljava/util/HashMap;

    move-result-object v2

    iget v0, v0, Lcom/wishabi/flipp/content/c;->a:I

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 231
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 234
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge p2, v2, :cond_0

    .line 237
    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/content/o;

    .line 239
    new-instance v2, Lcom/wishabi/flipp/content/FlyerActivityIntent;

    invoke-direct {v2, v1, v0}, Lcom/wishabi/flipp/content/FlyerActivityIntent;-><init>(Landroid/content/Context;Lcom/wishabi/flipp/content/o;)V

    invoke-virtual {v1, v2}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 240
    const v0, 0x7f040001

    const v2, 0x7f040002

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0
.end method

.method public final a(IZ)V
    .locals 2

    .prologue
    .line 151
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 152
    if-nez v0, :cond_1

    .line 164
    :cond_0
    :goto_0
    return-void

    .line 155
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;)Lcom/wishabi/flipp/widget/aa;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;)Lcom/wishabi/flipp/widget/aa;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/aa;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v0

    .line 159
    if-eqz v0, :cond_0

    .line 162
    sget-object v1, Lcom/wishabi/flipp/b/p;->e:Lcom/wishabi/flipp/b/p;

    invoke-static {v0, p2, v1}, Lcom/wishabi/flipp/content/a;->a(Lcom/wishabi/flipp/content/c;ZLcom/wishabi/flipp/b/p;)Z

    goto :goto_0
.end method

.method public final b(I)V
    .locals 4

    .prologue
    .line 187
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 188
    if-nez v0, :cond_1

    .line 205
    :cond_0
    :goto_0
    return-void

    .line 191
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;)Lcom/wishabi/flipp/widget/aa;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 194
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-static {v0}, Lcom/wishabi/flipp/app/n;->a(Lcom/wishabi/flipp/app/n;)Lcom/wishabi/flipp/widget/aa;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/aa;->d(I)Lcom/wishabi/flipp/content/c;

    move-result-object v0

    .line 195
    if-eqz v0, :cond_0

    .line 198
    sget-object v1, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget-object v2, Lcom/wishabi/flipp/b/q;->b:Lcom/wishabi/flipp/b/q;

    sget-object v3, Lcom/wishabi/flipp/b/p;->e:Lcom/wishabi/flipp/b/p;

    invoke-virtual {v1, v0, v2, v3}, Lcom/wishabi/flipp/b/a;->a(Lcom/wishabi/flipp/content/c;Lcom/wishabi/flipp/b/q;Lcom/wishabi/flipp/b/p;)V

    .line 202
    iget-object v0, v0, Lcom/wishabi/flipp/content/c;->n:Ljava/lang/String;

    invoke-static {v0}, Lcom/wishabi/flipp/app/e;->a(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 204
    iget-object v1, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    const-class v2, Lcom/wishabi/flipp/app/e;

    invoke-virtual {v1, v2, v0}, Lcom/wishabi/flipp/app/n;->a(Ljava/lang/Class;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public final c(I)V
    .locals 3

    .prologue
    .line 246
    iget-object v0, p0, Lcom/wishabi/flipp/app/o;->a:Lcom/wishabi/flipp/app/n;

    invoke-virtual {v0}, Lcom/wishabi/flipp/app/n;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 247
    if-nez v0, :cond_0

    .line 275
    :goto_0
    return-void

    .line 255
    :cond_0
    new-instance v1, Landroid/app/AlertDialog$Builder;

    invoke-direct {v1, v0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 256
    const v0, 0x7f0e0084

    invoke-virtual {v1, v0}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0e0082

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0e0083

    new-instance v2, Lcom/wishabi/flipp/app/q;

    invoke-direct {v2, p0, p1}, Lcom/wishabi/flipp/app/q;-><init>(Lcom/wishabi/flipp/app/o;I)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0e0081

    new-instance v2, Lcom/wishabi/flipp/app/p;

    invoke-direct {v2, p0}, Lcom/wishabi/flipp/app/p;-><init>(Lcom/wishabi/flipp/app/o;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 274
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_0
.end method
