.class public Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnHorizontalScrollListener;
.super Ljava/lang/Object;
.source "AccessibilityUtil.java"

# interfaces
.implements Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "AccessibleOnHorizontalScrollListener"
.end annotation


# instance fields
.field private description:Ljava/lang/String;


# virtual methods
.method public onScroll(Lit/sephiroth/android/library/widget/AbsHListView;III)V
    .locals 2
    .param p1, "absListView"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "lastVisibleItem"    # I
    .param p4, "totalCount"    # I

    .prologue
    .line 137
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnHorizontalScrollListener;->description:Ljava/lang/String;

    invoke-static {p1, v1, p2, p3, p4}, Lcom/comcast/cim/utils/UIPresentationUtil;->getAbsListStateDescription(Landroid/view/View;Ljava/lang/String;III)Ljava/lang/String;

    move-result-object v0

    .line 141
    .local v0, "content_description":Ljava/lang/String;
    invoke-virtual {p1}, Lit/sephiroth/android/library/widget/AbsHListView;->getTag()Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 142
    invoke-virtual {p1, v0}, Lit/sephiroth/android/library/widget/AbsHListView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 144
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Lit/sephiroth/android/library/widget/AbsHListView;I)V
    .locals 0
    .param p1, "absListView"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "i"    # I

    .prologue
    .line 129
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnHorizontalScrollListener;->description:Ljava/lang/String;

    .line 124
    return-void
.end method
