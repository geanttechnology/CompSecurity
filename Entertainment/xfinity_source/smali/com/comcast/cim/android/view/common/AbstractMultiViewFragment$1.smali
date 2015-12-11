.class Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;
.super Ljava/lang/Object;
.source "AbstractMultiViewFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->setupLoadingViewDelegate(Landroid/view/ViewGroup;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

    .prologue
    .line 71
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;"
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;->this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onReady()V
    .locals 1

    .prologue
    .line 74
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;"
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$1;->this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;->loadResources()V

    .line 75
    return-void
.end method
