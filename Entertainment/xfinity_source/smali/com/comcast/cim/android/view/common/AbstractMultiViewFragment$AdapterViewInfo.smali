.class public Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;
.super Ljava/lang/Object;
.source "AbstractMultiViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "AdapterViewInfo"
.end annotation


# instance fields
.field public final adapter:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter",
            "<TI;*>;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

.field public view:Landroid/view/ViewGroup;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter",
            "<TI;*>;)V"
        }
    .end annotation

    .prologue
    .line 149
    .local p0, "this":Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;, "Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment<TI;TT;>.AdapterViewInfo;"
    .local p2, "adapter":Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter<TI;*>;"
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->this$0:Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 150
    iput-object p2, p0, Lcom/comcast/cim/android/view/common/AbstractMultiViewFragment$AdapterViewInfo;->adapter:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView$EntityGridViewAdapter;

    .line 151
    return-void
.end method
