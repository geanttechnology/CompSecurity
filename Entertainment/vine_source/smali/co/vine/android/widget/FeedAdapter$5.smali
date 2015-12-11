.class Lco/vine/android/widget/FeedAdapter$5;
.super Ljava/lang/Object;
.source "FeedAdapter.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/widget/FeedAdapter;->newView()Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/widget/FeedAdapter;


# direct methods
.method constructor <init>(Lco/vine/android/widget/FeedAdapter;)V
    .locals 0

    .prologue
    .line 555
    iput-object p1, p0, Lco/vine/android/widget/FeedAdapter$5;->this$0:Lco/vine/android/widget/FeedAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 8
    .param p1, "view"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v5, 0x1

    .line 558
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v6

    if-nez v6, :cond_1

    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter$5;->this$0:Lco/vine/android/widget/FeedAdapter;

    iget-object v6, v6, Lco/vine/android/widget/FeedAdapter;->mListView:Landroid/widget/ListView;

    instance-of v6, v6, Lco/vine/android/widget/PinnedHeaderListView;

    if-eqz v6, :cond_1

    .line 559
    new-instance v3, Lco/vine/android/widget/TooltipOverlayView;

    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter$5;->this$0:Lco/vine/android/widget/FeedAdapter;

    iget-object v6, v6, Lco/vine/android/widget/FeedAdapter;->mContext:Landroid/content/Context;

    const v7, 0x7f0e0134

    invoke-direct {v3, v6, v7}, Lco/vine/android/widget/TooltipOverlayView;-><init>(Landroid/content/Context;I)V

    .line 560
    .local v3, "tooltip":Lco/vine/android/widget/TooltipOverlayView;
    iget-object v6, p0, Lco/vine/android/widget/FeedAdapter$5;->this$0:Lco/vine/android/widget/FeedAdapter;

    iget-object v1, v6, Lco/vine/android/widget/FeedAdapter;->mListView:Landroid/widget/ListView;

    check-cast v1, Lco/vine/android/widget/PinnedHeaderListView;

    .line 561
    .local v1, "listView":Lco/vine/android/widget/PinnedHeaderListView;
    invoke-virtual {v1, p2}, Lco/vine/android/widget/PinnedHeaderListView;->isAbsoluteTouchInPinnedHeader(Landroid/view/MotionEvent;)Z

    move-result v4

    .line 562
    .local v4, "touchedPinned":Z
    const/4 v6, 0x2

    new-array v0, v6, [I

    .line 563
    .local v0, "absoluteLoc":[I
    invoke-virtual {p1, v0}, Landroid/view/View;->getLocationInWindow([I)V

    .line 564
    if-eqz v4, :cond_0

    invoke-virtual {v1}, Lco/vine/android/widget/PinnedHeaderListView;->getPinnedHeaderBottomAbs()I

    move-result v2

    .line 566
    .local v2, "offset":I
    :goto_0
    invoke-virtual {v3, v2}, Lco/vine/android/widget/TooltipOverlayView;->showTooltip(I)V

    .line 569
    .end local v0    # "absoluteLoc":[I
    .end local v1    # "listView":Lco/vine/android/widget/PinnedHeaderListView;
    .end local v2    # "offset":I
    .end local v3    # "tooltip":Lco/vine/android/widget/TooltipOverlayView;
    .end local v4    # "touchedPinned":Z
    :goto_1
    return v5

    .line 564
    .restart local v0    # "absoluteLoc":[I
    .restart local v1    # "listView":Lco/vine/android/widget/PinnedHeaderListView;
    .restart local v3    # "tooltip":Lco/vine/android/widget/TooltipOverlayView;
    .restart local v4    # "touchedPinned":Z
    :cond_0
    aget v6, v0, v5

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v7

    add-int v2, v6, v7

    goto :goto_0

    .line 569
    .end local v0    # "absoluteLoc":[I
    .end local v1    # "listView":Lco/vine/android/widget/PinnedHeaderListView;
    .end local v3    # "tooltip":Lco/vine/android/widget/TooltipOverlayView;
    .end local v4    # "touchedPinned":Z
    :cond_1
    const/4 v5, 0x0

    goto :goto_1
.end method
