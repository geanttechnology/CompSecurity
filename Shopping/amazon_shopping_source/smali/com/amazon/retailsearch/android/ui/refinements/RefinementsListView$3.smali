.class Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$3;
.super Ljava/lang/Object;
.source "RefinementsListView.java"

# interfaces
.implements Landroid/widget/ExpandableListView$OnGroupCollapseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->createListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)V
    .locals 0

    .prologue
    .line 168
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$3;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGroupCollapse(I)V
    .locals 1
    .param p1, "groupPosition"    # I

    .prologue
    .line 172
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$3;->this$0:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    # invokes: Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->notifyItemCountChanged()V
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->access$500(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)V

    .line 173
    return-void
.end method
