.class public Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnScrollListener;
.super Ljava/lang/Object;
.source "AccessibilityUtil.java"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "AccessibleOnScrollListener"
.end annotation


# instance fields
.field private description:Ljava/lang/String;

.field final synthetic this$0:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;


# direct methods
.method protected constructor <init>(Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .prologue
    .line 147
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnScrollListener;->this$0:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 2
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "firstVisibleItem"    # I
    .param p3, "lastVisibleItem"    # I
    .param p4, "totalCount"    # I

    .prologue
    .line 166
    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnScrollListener;->description:Ljava/lang/String;

    invoke-static {p1, v1, p2, p3, p4}, Lcom/comcast/cim/utils/UIPresentationUtil;->getAbsListStateDescription(Landroid/view/View;Ljava/lang/String;III)Ljava/lang/String;

    move-result-object v0

    .line 170
    .local v0, "content_description":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/widget/AbsListView;->getTag()Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 171
    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 173
    :cond_0
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0
    .param p1, "absListView"    # Landroid/widget/AbsListView;
    .param p2, "i"    # I

    .prologue
    .line 158
    return-void
.end method

.method public setDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "description"    # Ljava/lang/String;

    .prologue
    .line 152
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnScrollListener;->description:Ljava/lang/String;

    .line 153
    return-void
.end method
