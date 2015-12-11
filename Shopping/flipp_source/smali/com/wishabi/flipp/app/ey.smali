.class final Lcom/wishabi/flipp/app/ey;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/TextView$OnEditorActionListener;


# instance fields
.field final synthetic a:Lcom/wishabi/flipp/app/ShoppingListFragment;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/app/ShoppingListFragment;)V
    .locals 0

    .prologue
    .line 210
    iput-object p1, p0, Lcom/wishabi/flipp/app/ey;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final onEditorAction(Landroid/widget/TextView;ILandroid/view/KeyEvent;)Z
    .locals 6

    .prologue
    const/4 v0, 0x0

    const/4 v2, 0x1

    .line 214
    packed-switch p2, :pswitch_data_0

    .line 219
    :cond_0
    :goto_0
    return v0

    .line 216
    :pswitch_0
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 217
    iget-object v3, p0, Lcom/wishabi/flipp/app/ey;->a:Lcom/wishabi/flipp/app/ShoppingListFragment;

    check-cast p1, Landroid/widget/EditText;

    invoke-virtual {p1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    const-string v1, ""

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    const v0, 0x7f0e0019

    invoke-virtual {v3, v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Ljava/lang/String;)V

    move v0, v2

    goto :goto_0

    :cond_1
    iget-object v1, v3, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v1}, Lcom/wishabi/flipp/content/ShoppingList;->b()I

    move-result v1

    const/16 v5, 0x12c

    if-ne v1, v5, :cond_2

    const v0, 0x7f0e0161

    invoke-virtual {v3, v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/wishabi/flipp/app/ShoppingListFragment;->a(Ljava/lang/String;)V

    move v0, v2

    goto :goto_0

    :cond_2
    iget-object v1, v3, Lcom/wishabi/flipp/app/ShoppingListFragment;->a:Lcom/wishabi/flipp/content/ShoppingList;

    invoke-virtual {v1, v4}, Lcom/wishabi/flipp/content/ShoppingList;->a(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_4

    invoke-static {v0}, Lcom/wishabi/flipp/util/q;->d(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    :goto_1
    iput-wide v0, v3, Lcom/wishabi/flipp/app/ShoppingListFragment;->c:J

    const-string v0, ""

    invoke-virtual {p1, v0}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    iget-object v0, v3, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    if-eqz v0, :cond_3

    iget-object v0, v3, Lcom/wishabi/flipp/app/ShoppingListFragment;->b:Lcom/wishabi/flipp/app/ff;

    invoke-interface {v0, v4}, Lcom/wishabi/flipp/app/ff;->a(Ljava/lang/String;)V

    :cond_3
    sget-object v0, Lcom/wishabi/flipp/b/a;->a:Lcom/wishabi/flipp/b/a;

    sget v1, Lcom/wishabi/flipp/b/s;->a:I

    const/4 v3, -0x1

    invoke-virtual {v0, v4, v1, v3}, Lcom/wishabi/flipp/b/a;->a(Ljava/lang/String;II)V

    move v0, v2

    goto :goto_0

    :cond_4
    const-wide/16 v0, -0x1

    goto :goto_1

    .line 214
    :pswitch_data_0
    .packed-switch 0x6
        :pswitch_0
    .end packed-switch
.end method
