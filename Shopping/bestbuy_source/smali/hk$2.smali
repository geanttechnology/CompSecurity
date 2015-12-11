.class Lhk$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhk;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhk;


# direct methods
.method constructor <init>(Lhk;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lhk$2;->a:Lhk;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 58
    const/4 v0, 0x0

    invoke-static {v0}, Lhk;->a(I)I

    .line 59
    iget-object v0, p0, Lhk$2;->a:Lhk;

    invoke-static {v0}, Lhk;->a(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    .line 60
    iget-object v0, p0, Lhk$2;->a:Lhk;

    invoke-static {v0}, Lhk;->b(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v0, :cond_1

    .line 61
    iget-object v0, p0, Lhk$2;->a:Lhk;

    invoke-static {v0}, Lhk;->c(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b()V

    .line 66
    :cond_0
    :goto_0
    return-void

    .line 62
    :cond_1
    iget-object v0, p0, Lhk$2;->a:Lhk;

    invoke-static {v0}, Lhk;->d(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Lhk$2;->a:Lhk;

    invoke-static {v0}, Lhk;->e(Lhk;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b()V

    goto :goto_0
.end method
