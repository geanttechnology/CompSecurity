.class Lek$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lek;->getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;

.field final synthetic b:Lek;


# direct methods
.method constructor <init>(Lek;Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;)V
    .locals 0

    .prologue
    .line 531
    iput-object p1, p0, Lek$4;->b:Lek;

    iput-object p2, p0, Lek$4;->a:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 535
    iget-object v0, p0, Lek$4;->b:Lek;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://www.bestbuy.com"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lek$4;->a:Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieSpecifications;->getLink()Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdpmovies/MovieLink;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lek;->a(Lek;Ljava/lang/String;)V

    .line 536
    return-void
.end method
