.class Ldy$1$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ldy$1;->onClick(Landroid/view/View;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

.field final synthetic b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

.field final synthetic c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

.field final synthetic d:Ldy$1;


# direct methods
.method constructor <init>(Ldy$1;Lcom/bestbuy/android/activities/home/HomeTabFragment;Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)V
    .locals 0

    .prologue
    .line 163
    iput-object p1, p0, Ldy$1$1;->d:Ldy$1;

    iput-object p2, p0, Ldy$1$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    iput-object p3, p0, Ldy$1$1;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    iput-object p4, p0, Ldy$1$1;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 166
    iget-object v0, p0, Ldy$1$1;->a:Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 167
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    iget-object v1, p0, Ldy$1$1;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 168
    iget-object v0, p0, Ldy$1$1;->b:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    iget-object v1, p0, Ldy$1$1;->c:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 169
    return-void
.end method
