.class public Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;
.super Landroid/widget/ExpandableListView;
.source "AnimatedExpandableListView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$1;,
        Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$ExpandAnimation;,
        Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$DummyView;,
        Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;,
        Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$GroupInfo;
    }
.end annotation


# static fields
.field private static final ANIMATION_DURATION:I = 0x12c


# instance fields
.field private adapter:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 107
    invoke-direct {p0, p1}, Landroid/widget/ExpandableListView;-><init>(Landroid/content/Context;)V

    .line 108
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 111
    invoke-direct {p0, p1, p2}, Landroid/widget/ExpandableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 112
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 115
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ExpandableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 116
    return-void
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getAnimationDuration()I

    move-result v0

    return v0
.end method

.method private getAnimationDuration()I
    .locals 1

    .prologue
    .line 215
    const/16 v0, 0x12c

    return v0
.end method


# virtual methods
.method public collapseGroupWithAnimation(I)Z
    .locals 10
    .param p1, "groupPos"    # I

    .prologue
    const/4 v9, -0x1

    .line 174
    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getPackedPositionForGroup(I)J

    move-result-wide v7

    invoke-virtual {p0, v7, v8}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getFlatListPosition(J)I

    move-result v3

    .line 175
    .local v3, "groupFlatPos":I
    if-eq v3, v9, :cond_1

    .line 176
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getFirstVisiblePosition()I

    move-result v7

    sub-int v0, v3, v7

    .line 177
    .local v0, "childIndex":I
    if-ltz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getChildCount()I

    move-result v7

    if-ge v0, v7, :cond_0

    .line 179
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    .line 180
    .local v6, "v":Landroid/view/View;
    if-eqz v6, :cond_1

    invoke-virtual {v6}, Landroid/view/View;->getBottom()I

    move-result v7

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getBottom()I

    move-result v8

    if-lt v7, v8, :cond_1

    .line 185
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->collapseGroup(I)Z

    move-result v7

    .line 211
    .end local v0    # "childIndex":I
    .end local v6    # "v":Landroid/view/View;
    :goto_0
    return v7

    .line 190
    .restart local v0    # "childIndex":I
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->collapseGroup(I)Z

    move-result v7

    goto :goto_0

    .line 195
    .end local v0    # "childIndex":I
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getFirstVisiblePosition()I

    move-result v7

    invoke-virtual {p0, v7}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getExpandableListPosition(I)J

    move-result-wide v4

    .line 196
    .local v4, "packedPos":J
    invoke-static {v4, v5}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getPackedPositionChild(J)I

    move-result v1

    .line 197
    .local v1, "firstChildPos":I
    invoke-static {v4, v5}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getPackedPositionGroup(J)I

    move-result v2

    .line 203
    .local v2, "firstGroupPos":I
    if-eq v1, v9, :cond_2

    if-eq v2, p1, :cond_3

    :cond_2
    const/4 v1, 0x0

    .line 207
    :cond_3
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->adapter:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    # invokes: Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->startCollapseAnimation(II)V
    invoke-static {v7, p1, v1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->access$200(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;II)V

    .line 210
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->adapter:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    invoke-virtual {v7}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->notifyDataSetChanged()V

    .line 211
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->isGroupExpanded(I)Z

    move-result v7

    goto :goto_0
.end method

.method public expandGroupWithAnimation(I)Z
    .locals 5
    .param p1, "groupPos"    # I

    .prologue
    .line 140
    invoke-static {p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getPackedPositionForGroup(I)J

    move-result-wide v3

    invoke-virtual {p0, v3, v4}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getFlatListPosition(J)I

    move-result v1

    .line 141
    .local v1, "groupFlatPos":I
    const/4 v3, -0x1

    if-eq v1, v3, :cond_0

    .line 142
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getFirstVisiblePosition()I

    move-result v3

    sub-int v0, v1, v3

    .line 143
    .local v0, "childIndex":I
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getChildCount()I

    move-result v3

    if-ge v0, v3, :cond_0

    .line 145
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 146
    .local v2, "v":Landroid/view/View;
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Landroid/view/View;->getBottom()I

    move-result v3

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->getBottom()I

    move-result v4

    if-lt v3, v4, :cond_0

    .line 154
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->adapter:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    invoke-virtual {v3, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->notifyGroupExpanded(I)V

    .line 155
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->expandGroup(I)Z

    move-result v3

    .line 164
    .end local v0    # "childIndex":I
    .end local v2    # "v":Landroid/view/View;
    :goto_0
    return v3

    .line 161
    :cond_0
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->adapter:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    const/4 v4, 0x0

    # invokes: Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->startExpandAnimation(II)V
    invoke-static {v3, p1, v4}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->access$100(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;II)V

    .line 164
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->expandGroup(I)Z

    move-result v3

    goto :goto_0
.end method

.method public setAdapter(Landroid/widget/ExpandableListAdapter;)V
    .locals 3
    .param p1, "adapter"    # Landroid/widget/ExpandableListAdapter;

    .prologue
    .line 122
    invoke-super {p0, p1}, Landroid/widget/ExpandableListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 125
    instance-of v0, p1, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    if-eqz v0, :cond_0

    .line 126
    check-cast p1, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    .end local p1    # "adapter":Landroid/widget/ExpandableListAdapter;
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->adapter:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    .line 127
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;->adapter:Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;

    # invokes: Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->setParent(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;)V
    invoke-static {v0, p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;->access$000(Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;)V

    .line 131
    return-void

    .line 129
    .restart local p1    # "adapter":Landroid/widget/ExpandableListAdapter;
    :cond_0
    new-instance v0, Ljava/lang/ClassCastException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " must implement AnimatedExpandableListAdapter"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/ClassCastException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
