.class Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;
.super Ljava/lang/Object;
.source "PlayNowBrowseProgramsFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->addItemsForFilterMap(Landroid/view/LayoutInflater;Landroid/widget/LinearLayout;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Ljava/util/Map;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;

.field final synthetic val$entry:Ljava/util/Map$Entry;

.field final synthetic val$filterValue:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

.field final synthetic val$searchCategory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Ljava/util/Map$Entry;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;

    .prologue
    .line 319
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;->this$1:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;->val$filterValue:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;->val$entry:Ljava/util/Map$Entry;

    iput-object p4, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;->val$searchCategory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 321
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;->val$filterValue:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;->val$entry:Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;->val$searchCategory:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {v1, v0, v2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->removeFromSelectedList(Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 322
    return-void
.end method
