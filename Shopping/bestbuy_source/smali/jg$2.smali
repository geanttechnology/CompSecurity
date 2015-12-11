.class Ljg$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljg;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljg;


# direct methods
.method constructor <init>(Ljg;)V
    .locals 0

    .prologue
    .line 75
    iput-object p1, p0, Ljg$2;->a:Ljg;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 78
    const/4 v0, 0x0

    invoke-static {v0}, Ljg;->a(I)I

    .line 79
    iget-object v0, p0, Ljg$2;->a:Ljg;

    invoke-static {v0}, Ljg;->a(Ljg;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-nez v0, :cond_0

    .line 80
    iget-object v0, p0, Ljg$2;->a:Ljg;

    invoke-static {v0}, Ljg;->b(Ljg;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->onBackPressed()V

    .line 81
    :cond_0
    return-void
.end method
