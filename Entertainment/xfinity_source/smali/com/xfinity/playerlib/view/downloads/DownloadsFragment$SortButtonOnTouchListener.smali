.class public Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;
.super Ljava/lang/Object;
.source "DownloadsFragment.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "SortButtonOnTouchListener"
.end annotation


# instance fields
.field private final sortType:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;
    .param p2, "sortType"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 689
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 690
    iput-object p2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;->sortType:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .line 691
    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x1

    .line 695
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_0

    .line 706
    :goto_0
    return v0

    .line 698
    :cond_0
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    if-eq v1, v0, :cond_1

    .line 699
    const/4 v0, 0x0

    goto :goto_0

    .line 702
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    # getter for: Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->access$900(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;->sortType:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->setCurrentSortType(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 703
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;->sortType:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->updateSortButtonStates(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    .line 705
    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->applySort()V

    goto :goto_0
.end method
