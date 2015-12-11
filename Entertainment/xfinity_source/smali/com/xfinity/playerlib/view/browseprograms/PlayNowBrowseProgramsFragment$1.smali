.class Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;
.super Ljava/lang/Object;
.source "PlayNowBrowseProgramsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getFilterButtonOnClickListener()Landroid/view/View$OnClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 225
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 228
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->filterButton:Landroid/view/View;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->access$000(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/View;->setSelected(Z)V

    .line 229
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->filterRequestObserver:Lcom/comcast/cim/android/view/flow/FilterRequestObserver;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->access$100(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lcom/comcast/cim/android/view/flow/FilterRequestObserver;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getFilterBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/view/flow/FilterRequestObserver;->showFilter(Landroid/os/Bundle;)V

    .line 230
    return-void
.end method
