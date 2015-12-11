.class Lea$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lea;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field final synthetic b:Lea;


# direct methods
.method constructor <init>(Lea;Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V
    .locals 0

    .prologue
    .line 128
    iput-object p1, p0, Lea$1;->b:Lea;

    iput-object p2, p0, Lea$1;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 131
    iget-object v0, p0, Lea$1;->b:Lea;

    invoke-static {v0}, Lea;->a(Lea;)Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 132
    iget-object v0, p0, Lea$1;->b:Lea;

    invoke-static {v0}, Lea;->a(Lea;)Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    move-result-object v0

    iget-object v1, p0, Lea$1;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c(Ljava/lang/String;)V

    .line 134
    :cond_0
    return-void
.end method
