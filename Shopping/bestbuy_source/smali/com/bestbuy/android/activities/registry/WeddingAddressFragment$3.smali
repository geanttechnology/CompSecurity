.class Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/text/InputFilter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)V
    .locals 0

    .prologue
    .line 442
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$3;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public filter(Ljava/lang/CharSequence;IILandroid/text/Spanned;II)Ljava/lang/CharSequence;
    .locals 3

    .prologue
    .line 446
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment$3;->a:Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->i(Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;)Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 447
    const-string v0, ""

    .line 449
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
