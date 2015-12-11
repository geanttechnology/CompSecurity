.class public Ldd;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/TextWatcher;


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

.field private b:Landroid/widget/EditText;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 739
    iput-object p1, p0, Ldd;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 740
    iput-object p2, p0, Ldd;->b:Landroid/widget/EditText;

    .line 741
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 2

    .prologue
    .line 756
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 757
    iget-object v1, p0, Ldd;->b:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 765
    :goto_0
    return-void

    .line 759
    :pswitch_0
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 760
    iget-object v0, p0, Ldd;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;Z)Z

    goto :goto_0

    .line 762
    :cond_0
    iget-object v0, p0, Ldd;->a:Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;Z)Z

    goto :goto_0

    .line 757
    :pswitch_data_0
    .packed-switch 0x7f0c012a
        :pswitch_0
    .end packed-switch
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 746
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0

    .prologue
    .line 752
    return-void
.end method
