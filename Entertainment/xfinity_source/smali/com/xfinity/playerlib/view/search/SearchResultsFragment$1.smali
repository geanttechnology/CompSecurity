.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;
.super Ljava/lang/Object;
.source "SearchResultsFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .prologue
    .line 171
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
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
    .line 174
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .line 175
    .local v0, "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    iget-object v1, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->showProgramDetail(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    .line 176
    return-void
.end method
