.class Lek$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lek;->getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/pdp/Track;

.field final synthetic b:Lek;


# direct methods
.method constructor <init>(Lek;Lcom/bestbuy/android/api/lib/models/pdp/Track;)V
    .locals 0

    .prologue
    .line 648
    iput-object p1, p0, Lek$5;->b:Lek;

    iput-object p2, p0, Lek$5;->a:Lcom/bestbuy/android/api/lib/models/pdp/Track;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 652
    iget-object v0, p0, Lek$5;->a:Lcom/bestbuy/android/api/lib/models/pdp/Track;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Track;->getPlayURL()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lek$5;->a:Lcom/bestbuy/android/api/lib/models/pdp/Track;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Track;->getPlayURL()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 653
    iget-object v0, p0, Lek$5;->a:Lcom/bestbuy/android/api/lib/models/pdp/Track;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Track;->getPlayURL()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 654
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 655
    const-string v2, "audio/*"

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 656
    iget-object v0, p0, Lek$5;->b:Lek;

    invoke-static {v0}, Lek;->a(Lek;)Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 658
    :cond_0
    return-void
.end method
