.class Ldq$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ldq;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Ldq;


# direct methods
.method constructor <init>(Ldq;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Ldq$1;->a:Ldq;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Ldq$1;->a:Ldq;

    invoke-static {v0}, Ldq;->a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Ldq$1;->a:Ldq;

    invoke-static {v0}, Ldq;->a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_0

    .line 150
    iget-object v0, p0, Ldq$1;->a:Ldq;

    invoke-static {v0}, Ldq;->a(Ldq;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->c()V

    .line 152
    :cond_0
    return-void
.end method
