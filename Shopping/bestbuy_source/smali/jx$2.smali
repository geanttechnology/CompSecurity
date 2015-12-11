.class Ljx$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lnn;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ljx;->c()V
.end annotation


# instance fields
.field final synthetic a:Ljx;


# direct methods
.method constructor <init>(Ljx;)V
    .locals 0

    .prologue
    .line 60
    iput-object p1, p0, Ljx$2;->a:Ljx;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 63
    const/4 v0, 0x0

    invoke-static {v0}, Ljx;->a(I)I

    .line 64
    iget-object v0, p0, Ljx$2;->a:Ljx;

    invoke-static {v0}, Ljx;->a(Ljx;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 65
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabContainer;

    if-eqz v1, :cond_0

    .line 66
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    const-string v1, "STORES"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Ljava/lang/String;)Z

    .line 68
    :cond_0
    return-void
.end method
