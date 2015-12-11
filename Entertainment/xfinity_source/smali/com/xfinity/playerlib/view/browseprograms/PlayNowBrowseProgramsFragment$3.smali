.class Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;
.super Ljava/lang/Object;
.source "PlayNowBrowseProgramsFragment.java"

# interfaces
.implements Landroid/view/MenuItem$OnMenuItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
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
    .line 377
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "menuItem"    # Landroid/view/MenuItem;

    .prologue
    .line 381
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->filterRequestObserver:Lcom/comcast/cim/android/view/flow/FilterRequestObserver;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->access$200(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)Lcom/comcast/cim/android/view/flow/FilterRequestObserver;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getFilterBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/view/flow/FilterRequestObserver;->showFilter(Landroid/os/Bundle;)V

    .line 382
    const/4 v0, 0x0

    return v0
.end method
