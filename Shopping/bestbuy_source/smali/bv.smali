.class public Lbv;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

.field private b:Landroid/widget/EditText;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 228
    iput-object p1, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 229
    iput-object p2, p0, Lbv;->b:Landroid/widget/EditText;

    .line 230
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 244
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 245
    iget-object v3, p0, Lbv;->b:Landroid/widget/EditText;

    invoke-virtual {v3}, Landroid/widget/EditText;->getId()I

    move-result v3

    packed-switch v3, :pswitch_data_0

    .line 262
    :cond_0
    :goto_0
    iget-object v0, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->n(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->o(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->p(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->q(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 264
    iget-object v0, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setEnabled(Z)V

    .line 265
    iget-object v0, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    iget-object v1, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0002

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setTextColor(I)V

    .line 270
    :goto_1
    return-void

    .line 247
    :pswitch_0
    iget-object v3, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_2
    invoke-static {v3, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->b(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z

    goto :goto_0

    :cond_1
    move v0, v2

    goto :goto_2

    .line 250
    :pswitch_1
    iget-object v3, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    move v0, v1

    :goto_3
    invoke-static {v3, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->c(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z

    goto :goto_0

    :cond_2
    move v0, v2

    goto :goto_3

    .line 253
    :pswitch_2
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-virtual {v3, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 254
    iget-object v3, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    move v0, v1

    :goto_4
    invoke-static {v3, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->d(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z

    goto :goto_0

    :cond_3
    move v0, v2

    goto :goto_4

    .line 257
    :pswitch_3
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-virtual {v3, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->c(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 258
    iget-object v3, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    move v0, v1

    :goto_5
    invoke-static {v3, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->e(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;Z)Z

    goto/16 :goto_0

    :cond_4
    move v0, v2

    goto :goto_5

    .line 267
    :cond_5
    iget-object v0, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setEnabled(Z)V

    .line 268
    iget-object v0, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->a(Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;)Lcom/bestbuy/android/bbyobjects/BBYButton;

    move-result-object v0

    iget-object v1, p0, Lbv;->a:Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistUserContactInfoActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0006

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setTextColor(I)V

    goto :goto_1

    .line 245
    :pswitch_data_0
    .packed-switch 0x7f0c002a
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 235
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 240
    return-void
.end method
