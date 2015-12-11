.class Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;
.super Ljava/lang/Object;
.source "FilterableProgramCollectionFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->getOnProgramClickListener()Landroid/widget/AdapterView$OnItemClickListener;
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
    .line 146
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;"
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;->this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
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
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 150
    .local p0, "this":Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;, "Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;"
    .local p1, "adapter":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;->this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    iput p3, v1, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->positionOfLastClickedItem:I

    .line 152
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    .line 154
    .local v0, "item":Ljava/lang/Object;, "TT;"
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment$2;->this$0:Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;

    invoke-virtual {v1, v0}, Lcom/comcast/cim/android/view/common/FilterableProgramCollectionFragment;->itemClicked(Ljava/lang/Object;)V

    .line 155
    return-void
.end method
