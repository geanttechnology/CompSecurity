.class public Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
.super Ljava/lang/Object;
.source "AccessibilityUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnScrollListener;,
        Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnHorizontalScrollListener;
    }
.end annotation


# instance fields
.field final accessibilityManager:Landroid/view/accessibility/AccessibilityManager;


# direct methods
.method public constructor <init>(Landroid/view/accessibility/AccessibilityManager;)V
    .locals 0
    .param p1, "accessibilityManager"    # Landroid/view/accessibility/AccessibilityManager;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    .line 24
    return-void
.end method

.method private isTalkbackRunning()Z
    .locals 5

    .prologue
    .line 209
    iget-object v2, p0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Landroid/view/accessibility/AccessibilityManager;->getEnabledAccessibilityServiceList(I)Ljava/util/List;

    move-result-object v0

    .line 211
    .local v0, "runningServices":Ljava/util/List;, "Ljava/util/List<Landroid/accessibilityservice/AccessibilityServiceInfo;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/accessibilityservice/AccessibilityServiceInfo;

    .line 212
    .local v1, "service":Landroid/accessibilityservice/AccessibilityServiceInfo;
    invoke-virtual {v1}, Landroid/accessibilityservice/AccessibilityServiceInfo;->getId()Ljava/lang/String;

    move-result-object v3

    const-string v4, "com.google.android.marvin.talkback/.TalkBackService"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 213
    const/4 v2, 0x1

    .line 217
    .end local v1    # "service":Landroid/accessibilityservice/AccessibilityServiceInfo;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public isAccessibilityEnabled()Z
    .locals 1

    .prologue
    .line 204
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->accessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v0}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isTalkbackRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setImportantForAccessibility(Landroid/view/View;I)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "mode"    # I
    .annotation build Landroid/annotation/TargetApi;
        value = 0x10
    .end annotation

    .prologue
    .line 36
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 37
    invoke-virtual {p1, p2}, Landroid/view/View;->setImportantForAccessibility(I)V

    .line 39
    :cond_0
    return-void
.end method

.method public setupAccessibleScrollListener(Landroid/widget/AbsListView;Ljava/lang/String;)V
    .locals 1
    .param p1, "gallery"    # Landroid/widget/AbsListView;
    .param p2, "galleryHeader"    # Ljava/lang/String;

    .prologue
    .line 105
    new-instance v0, Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnScrollListener;

    invoke-direct {v0, p0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnScrollListener;-><init>(Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V

    .line 106
    .local v0, "availableScrollListener":Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnScrollListener;
    invoke-virtual {v0, p2}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil$AccessibleOnScrollListener;->setDescription(Ljava/lang/String;)V

    .line 107
    invoke-virtual {p1, v0}, Landroid/widget/AbsListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 108
    return-void
.end method

.method public toggleScreenFocus(Ljava/util/HashMap;Landroid/view/ViewGroup;Landroid/view/ViewGroup;ZZ)V
    .locals 10
    .param p2, "parentContainer"    # Landroid/view/ViewGroup;
    .param p3, "descendentViewGroup"    # Landroid/view/ViewGroup;
    .param p4, "hideFromTalkBack"    # Z
    .param p5, "triggeredFromFlyout"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Landroid/view/View;",
            "Ljava/lang/Integer;",
            ">;",
            "Landroid/view/ViewGroup;",
            "Landroid/view/ViewGroup;",
            "ZZ)V"
        }
    .end annotation

    .prologue
    .local p1, "focusToggleState":Ljava/util/HashMap;, "Ljava/util/HashMap<Landroid/view/View;Ljava/lang/Integer;>;"
    const/4 v9, 0x2

    const/4 v8, 0x1

    .line 53
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_5

    .line 55
    if-ne p2, p3, :cond_0

    if-eqz p4, :cond_0

    .line 56
    invoke-virtual {p1}, Ljava/util/HashMap;->clear()V

    .line 59
    :cond_0
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_0
    invoke-virtual {p3}, Landroid/view/ViewGroup;->getChildCount()I

    move-result v0

    if-ge v7, v0, :cond_5

    .line 61
    invoke-virtual {p3, v7}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    .line 63
    .local v6, "blockView":Landroid/view/View;
    if-eqz p4, :cond_3

    .line 64
    invoke-virtual {v6}, Landroid/view/View;->getImportantForAccessibility()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {p1, v6, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    invoke-virtual {v6, v9}, Landroid/view/View;->setImportantForAccessibility(I)V

    .line 74
    :goto_1
    instance-of v0, v6, Landroid/view/ViewGroup;

    if-eqz v0, :cond_1

    move-object v3, v6

    .line 75
    check-cast v3, Landroid/view/ViewGroup;

    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move v4, p4

    invoke-virtual/range {v0 .. v5}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->toggleScreenFocus(Ljava/util/HashMap;Landroid/view/ViewGroup;Landroid/view/ViewGroup;ZZ)V

    .line 78
    :cond_1
    if-ne p2, p3, :cond_2

    if-nez v7, :cond_2

    .line 80
    if-eqz p4, :cond_4

    .line 82
    if-eqz p5, :cond_2

    .line 83
    invoke-virtual {v6, v8}, Landroid/view/View;->setFocusable(Z)V

    .line 84
    invoke-virtual {v6, v8}, Landroid/view/View;->setFocusableInTouchMode(Z)V

    .line 85
    invoke-virtual {p0, v6, v8}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 88
    invoke-virtual {p2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/comcast/cim/android/R$string;->content_description_close_menu_instructions:I

    invoke-virtual {v0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 87
    invoke-virtual {v6, v0}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 59
    :cond_2
    :goto_2
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 68
    :cond_3
    :try_start_0
    invoke-virtual {p1, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-virtual {v6, v0}, Landroid/view/View;->setImportantForAccessibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 69
    :catch_0
    move-exception v0

    goto :goto_1

    .line 93
    :cond_4
    const/4 v0, 0x0

    invoke-virtual {v6, v0}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 94
    invoke-virtual {p0, v6, v9}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 96
    invoke-virtual {p1}, Ljava/util/HashMap;->clear()V

    goto :goto_2

    .line 101
    .end local v6    # "blockView":Landroid/view/View;
    .end local v7    # "i":I
    :cond_5
    return-void
.end method
