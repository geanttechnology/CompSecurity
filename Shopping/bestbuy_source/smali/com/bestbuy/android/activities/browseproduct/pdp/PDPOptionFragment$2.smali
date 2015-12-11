.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b(Ljava/util/List;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/util/List;

.field final synthetic b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$2;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$2;->a:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$2;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$2;->a:Ljava/util/List;

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;Ljava/util/List;)V

    .line 200
    return-void
.end method
