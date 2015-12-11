.class Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;
.super Ljava/lang/Object;
.source "SlideMenuClickListener.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->onRefresh()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)V
    .locals 0

    .prologue
    .line 209
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const-wide/16 v5, 0x5dc

    const/16 v4, 0x8

    const/high16 v3, 0x3f800000    # 1.0f

    const v2, 0x3dcccccd    # 0.1f

    .line 213
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->adapter:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$400(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseListAdapter;->notifyDataSetChanged()V

    .line 214
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->fastBrowseList:Landroid/widget/ListView;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$700(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/widget/ListView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/ListView;->setSelectionAfterHeaderView()V

    .line 215
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->spinnerList:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$800(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;->hide()V

    .line 216
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->iconRight:Landroid/view/View;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$900(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 220
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->position:I
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$1000(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)I

    move-result v1

    if-eqz v1, :cond_0

    .line 222
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    invoke-direct {v0, v2, v3}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 223
    .local v0, "alphaAnimation":Landroid/view/animation/Animation;
    invoke-virtual {v0, v5, v6}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 224
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->iconRight:Landroid/view/View;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$900(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/View;->setAnimation(Landroid/view/animation/Animation;)V

    .line 225
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->iconRight:Landroid/view/View;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$900(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/view/View;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 233
    :goto_0
    return-void

    .line 228
    .end local v0    # "alphaAnimation":Landroid/view/animation/Animation;
    :cond_0
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    invoke-direct {v0, v3, v2}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    .line 229
    .restart local v0    # "alphaAnimation":Landroid/view/animation/Animation;
    invoke-virtual {v0, v5, v6}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 230
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->iconRight:Landroid/view/View;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$900(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/View;->setAnimation(Landroid/view/animation/Animation;)V

    .line 231
    iget-object v1, p0, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener$2;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->iconRight:Landroid/view/View;
    invoke-static {v1}, Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;->access$900(Lcom/amazon/retailsearch/android/fastBrowse/SlideMenuClickListener;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method
