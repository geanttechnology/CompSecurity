.class Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$3;
.super Ljava/lang/Object;
.source "FilterableProgramCollectionFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getOnProgramLongClickListener()Landroid/widget/AdapterView$OnItemLongClickListener;
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
    .line 160
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$3;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$3;"
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$3;->this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .line 164
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$3;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$3;"
    .local p1, "adapter":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 165
    .local v0, "item":Ljava/lang/Object;, "TT;"
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$3;->this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->itemLongClicked(Ljava/lang/Object;)V

    .line 167
    const/4 v1, 0x1

    return v1
.end method
