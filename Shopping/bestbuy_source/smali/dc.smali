.class public Ldc;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

.field private b:Landroid/widget/EditText;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 157
    iput-object p1, p0, Ldc;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 158
    iput-object p2, p0, Ldc;->b:Landroid/widget/EditText;

    .line 159
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 173
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 174
    iget-object v1, p0, Ldc;->b:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 182
    :goto_0
    iget-object v0, p0, Ldc;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->c(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 183
    iget-object v0, p0, Ldc;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;Z)Z

    .line 186
    :goto_1
    return-void

    .line 176
    :pswitch_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Ldc;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;Z)Z

    goto :goto_0

    .line 179
    :cond_0
    iget-object v0, p0, Ldc;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v0, v3}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->a(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;Z)Z

    goto :goto_0

    .line 185
    :cond_1
    iget-object v0, p0, Ldc;->a:Lcom/bestbuy/android/activities/registry/WeddingDateFragment;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/registry/WeddingDateFragment;->b(Lcom/bestbuy/android/activities/registry/WeddingDateFragment;Z)Z

    goto :goto_1

    .line 174
    nop

    :pswitch_data_0
    .packed-switch 0x7f0c03f4
        :pswitch_0
    .end packed-switch
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 164
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 169
    return-void
.end method
