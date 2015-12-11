.class public Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;
.super Ljava/lang/Object;
.source "PlayNowBrowseProgramsFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "SortButtonOnTouchListener"
.end annotation


# instance fields
.field private final sortType:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;
    .param p2, "sortType"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 399
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.SortButtonOnTouchListener;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 400
    iput-object p2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;->sortType:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .line 401
    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment<TRT;>.SortButtonOnTouchListener;"
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 405
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    if-nez v2, :cond_0

    .line 418
    .end local p1    # "v":Landroid/view/View;
    :goto_0
    return v0

    .line 408
    .restart local p1    # "v":Landroid/view/View;
    :cond_0
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v2

    if-eq v2, v0, :cond_1

    move v0, v1

    .line 409
    goto :goto_0

    .line 412
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;->sortType:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->setCurrentSortType(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 413
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;->sortType:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->updateSortButtonStates(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 415
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v2

    check-cast p1, Landroid/view/ViewGroup;

    .end local p1    # "v":Landroid/view/View;
    invoke-virtual {p1, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getContentDescription()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v2, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 417
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$SortButtonOnTouchListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->applyFilter()V

    goto :goto_0
.end method
