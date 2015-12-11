.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/lang/String;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Ljava/util/HashMap;

.field final synthetic c:Ljava/lang/String;

.field final synthetic d:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 752
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->d:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->b:Ljava/util/HashMap;

    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->c:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 756
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->a:Ljava/lang/String;

    .line 757
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->b:Ljava/util/HashMap;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->b:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->b:Ljava/util/HashMap;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->a:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 758
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->b:Ljava/util/HashMap;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 760
    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->d:Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->c:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;->a:Ljava/lang/String;

    invoke-static {v1, v2, v3, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 761
    return-void
.end method
