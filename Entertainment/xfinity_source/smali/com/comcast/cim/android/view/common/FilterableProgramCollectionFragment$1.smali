.class Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$1;
.super Ljava/lang/Object;
.source "FilterableProgramCollectionFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    .prologue
    .line 86
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$1;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$1;"
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$1;->this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onReady()V
    .locals 1

    .prologue
    .line 89
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$1;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$1;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$1;->this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->applyFilter()V

    .line 90
    return-void
.end method
