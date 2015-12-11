.class Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->onAttach(Landroid/app/Activity;)V
.end annotation


# instance fields
.field final synthetic a:Landroid/app/Activity;

.field final synthetic b:Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;->b:Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    iput-object p2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;->a:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 61
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;->b:Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    new-instance v1, Lqn;

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;->a:Landroid/app/Activity;

    invoke-direct {v1, v2}, Lqn;-><init>(Landroid/content/Context;)V

    sget-object v2, Lahy;->a:Lpx;

    invoke-virtual {v1, v2}, Lqn;->a(Lpx;)Lqn;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;->b:Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-virtual {v1, v2}, Lqn;->a(Lqo;)Lqn;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;->b:Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-virtual {v1, v2}, Lqn;->a(Lqp;)Lqn;

    move-result-object v1

    invoke-virtual {v1}, Lqn;->b()Lqm;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a(Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;Lqm;)Lqm;

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;->b:Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a(Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;)Lqm;

    move-result-object v0

    invoke-interface {v0}, Lqm;->b()V

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer$1;->b:Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;->a(Lcom/bestbuy/android/activities/dnm/DNMListFragmentContainer;Z)Z

    .line 66
    return-void
.end method
