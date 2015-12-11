.class public Lcs;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field a:Landroid/widget/EditText;

.field final synthetic b:Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcs;->b:Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 196
    iput-object p2, p0, Lcs;->a:Landroid/widget/EditText;

    .line 197
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 3

    .prologue
    .line 208
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 209
    iget-object v1, p0, Lcs;->a:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getId()I

    move-result v1

    const v2, 0x7f0c00e6

    if-ne v1, v2, :cond_0

    .line 210
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 211
    iget-object v0, p0, Lcs;->b:Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a(Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;Z)Z

    .line 216
    :cond_0
    :goto_0
    return-void

    .line 213
    :cond_1
    iget-object v0, p0, Lcs;->b:Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;->a(Lcom/bestbuy/android/activities/registry/EditListDetailsFragment;Z)Z

    goto :goto_0
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 201
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 205
    return-void
.end method
