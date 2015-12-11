.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 263
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$1;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$1;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 266
    .line 267
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$1;->a:Ljava/lang/String;

    const-string v1, "refurbished"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 268
    new-instance v0, Llb;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$1;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    const v2, 0x7f080229

    const v3, 0x7f080228

    invoke-direct {v0, v1, v2, v3}, Llb;-><init>(Landroid/content/Context;II)V

    .line 272
    :goto_0
    invoke-virtual {v0}, Llb;->show()V

    .line 273
    return-void

    .line 270
    :cond_0
    new-instance v0, Llb;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$1;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    const v2, 0x7f08022b

    const v3, 0x7f080227

    invoke-direct {v0, v1, v2, v3}, Llb;-><init>(Landroid/content/Context;II)V

    goto :goto_0
.end method
