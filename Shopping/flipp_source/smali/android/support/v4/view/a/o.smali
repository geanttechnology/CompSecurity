.class final Landroid/support/v4/view/a/o;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(II)Ljava/lang/Object;
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 41
    invoke-static {p0, p1, v0, v0}, Landroid/view/accessibility/AccessibilityNodeInfo$CollectionInfo;->obtain(IIZI)Landroid/view/accessibility/AccessibilityNodeInfo$CollectionInfo;

    move-result-object v0

    return-object v0
.end method

.method public static a(IIIIZ)Ljava/lang/Object;
    .locals 6

    .prologue
    .line 47
    const/4 v5, 0x0

    move v0, p0

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    invoke-static/range {v0 .. v5}, Landroid/view/accessibility/AccessibilityNodeInfo$CollectionItemInfo;->obtain(IIIIZZ)Landroid/view/accessibility/AccessibilityNodeInfo$CollectionItemInfo;

    move-result-object v0

    return-object v0
.end method
