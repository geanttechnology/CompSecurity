.class Ljf$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljf;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljf;


# direct methods
.method constructor <init>(Ljf;)V
    .locals 0

    .prologue
    .line 72
    iput-object p1, p0, Ljf$2;->a:Ljf;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 75
    const/4 v0, 0x0

    invoke-static {v0}, Ljf;->a(I)I

    .line 76
    iget-object v0, p0, Ljf$2;->a:Ljf;

    invoke-static {v0}, Ljf;->a(Ljf;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-nez v0, :cond_0

    .line 77
    iget-object v0, p0, Ljf$2;->a:Ljf;

    invoke-static {v0}, Ljf;->b(Ljf;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 78
    :cond_0
    return-void
.end method
