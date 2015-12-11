.class Lhh$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lhh;->c()V
.end annotation


# instance fields
.field final synthetic a:Lhh;


# direct methods
.method constructor <init>(Lhh;)V
    .locals 0

    .prologue
    .line 64
    iput-object p1, p0, Lhh$2;->a:Lhh;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lhh$2;->a:Lhh;

    invoke-static {v0}, Lhh;->a(Lhh;)Landroid/app/Activity;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_1

    .line 68
    iget-object v0, p0, Lhh$2;->a:Lhh;

    invoke-static {v0}, Lhh;->b(Lhh;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 72
    :cond_0
    :goto_0
    return-void

    .line 69
    :cond_1
    iget-object v0, p0, Lhh$2;->a:Lhh;

    invoke-static {v0}, Lhh;->c(Lhh;)Landroid/app/Activity;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lhh$2;->a:Lhh;

    invoke-static {v0}, Lhh;->d(Lhh;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/ScannedItemActivity;->onBackPressed()V

    goto :goto_0
.end method
