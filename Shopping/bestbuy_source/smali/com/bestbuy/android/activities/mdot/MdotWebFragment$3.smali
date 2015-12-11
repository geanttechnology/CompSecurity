.class Lcom/bestbuy/android/activities/mdot/MdotWebFragment$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->onRefresh()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)V
    .locals 0

    .prologue
    .line 456
    iput-object p1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$3;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 459
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$3;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->f(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setRefreshing(Z)V

    .line 460
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$3;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->a(Lcom/bestbuy/android/activities/mdot/MdotWebFragment;)Landroid/widget/ImageView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 461
    iget-object v0, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$3;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 462
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$3;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 463
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 464
    const-string v2, "bb.prevPageLink"

    const-string v3, "From Web Page: Blue Assist"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 465
    sget-object v2, Llu;->aT:Ljava/lang/String;

    invoke-static {v2, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 466
    iget-object v1, p0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment$3;->a:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->startActivity(Landroid/content/Intent;)V

    .line 468
    :cond_0
    return-void
.end method
