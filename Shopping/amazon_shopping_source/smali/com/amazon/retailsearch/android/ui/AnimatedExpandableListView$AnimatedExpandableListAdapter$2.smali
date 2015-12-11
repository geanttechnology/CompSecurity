.class Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;
.super Ljava/lang/Object;
.source "AnimatedExpandableListView.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

.field final synthetic val$dummyView:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;

.field final synthetic val$groupPosition:I

.field final synthetic val$info:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

.field final synthetic val$listView:Landroid/widget/ExpandableListView;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;ILandroid/widget/ExpandableListView;Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;)V
    .locals 0

    .prologue
    .line 430
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->this$0:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    iput p2, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->val$groupPosition:I

    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->val$listView:Landroid/widget/ExpandableListView;

    iput-object p4, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->val$info:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    iput-object p5, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->val$dummyView:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 434
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->this$0:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->val$groupPosition:I

    # invokes: Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->stopAnimation(I)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->access$600(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;I)V

    .line 435
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->val$listView:Landroid/widget/ExpandableListView;

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->val$groupPosition:I

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->collapseGroup(I)Z

    .line 436
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->this$0:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->notifyDataSetChanged()V

    .line 437
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->val$info:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;

    const/4 v1, -0x1

    iput v1, v0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;->dummyHeight:I

    .line 438
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter$2;->val$dummyView:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;->setTag(Ljava/lang/Object;)V

    .line 439
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 442
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 445
    return-void
.end method
