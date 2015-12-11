.class Lhj$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhj;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhj;


# direct methods
.method constructor <init>(Lhj;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Lhj$2;->a:Lhj;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 75
    iget-object v0, p0, Lhj$2;->a:Lhj;

    invoke-static {v0}, Lhj;->a(Lhj;)Landroid/app/Activity;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_1

    .line 76
    iget-object v0, p0, Lhj$2;->a:Lhj;

    invoke-static {v0}, Lhj;->b(Lhj;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 80
    :cond_0
    :goto_0
    return-void

    .line 77
    :cond_1
    iget-object v0, p0, Lhj$2;->a:Lhj;

    invoke-static {v0}, Lhj;->c(Lhj;)Landroid/app/Activity;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lhj$2;->a:Lhj;

    invoke-static {v0}, Lhj;->d(Lhj;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->onBackPressed()V

    goto :goto_0
.end method
