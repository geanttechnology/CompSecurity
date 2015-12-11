.class Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;
.super Ljava/lang/Object;
.source "PlayNowBrowseProgramsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->addViews(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;

.field final synthetic val$filterValue:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;

    .prologue
    .line 267
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;->this$1:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;->val$filterValue:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 270
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;->val$filterValue:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->setHideLockOn(Z)V

    .line 271
    return-void
.end method
