.class public Lcy;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

.field private b:Landroid/widget/EditText;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 182
    iput-object p1, p0, Lcy;->a:Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 183
    iput-object p2, p0, Lcy;->b:Landroid/widget/EditText;

    .line 184
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2

    .prologue
    .line 199
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 200
    iget-object v1, p0, Lcy;->b:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 208
    :goto_0
    return-void

    .line 202
    :pswitch_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 203
    iget-object v0, p0, Lcy;->a:Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a(Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;Z)Z

    goto :goto_0

    .line 205
    :cond_0
    iget-object v0, p0, Lcy;->a:Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a(Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;Z)Z

    goto :goto_0

    .line 200
    :pswitch_data_0
    .packed-switch 0x7f0c012a
        :pswitch_0
    .end packed-switch
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 189
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 195
    return-void
.end method
