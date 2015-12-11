.class public Lcom/comcast/cim/utils/TextFlowHelper;
.super Ljava/lang/Object;
.source "TextFlowHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/utils/TextFlowHelper$MyLeadingMarginSpan2;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    return-void
.end method

.method private static getLeadingMarginSpan(II)Landroid/text/style/LeadingMarginSpan;
    .locals 1
    .param p0, "margin"    # I
    .param p1, "lines"    # I

    .prologue
    .line 42
    new-instance v0, Lcom/comcast/cim/utils/TextFlowHelper$MyLeadingMarginSpan2;

    invoke-direct {v0, p1, p0}, Lcom/comcast/cim/utils/TextFlowHelper$MyLeadingMarginSpan2;-><init>(II)V

    return-object v0
.end method

.method public static tryFlowText(Landroid/view/View;Landroid/widget/TextView;Landroid/view/ViewGroup;)V
    .locals 13
    .param p0, "wrappedView"    # Landroid/view/View;
    .param p1, "textView"    # Landroid/widget/TextView;
    .param p2, "container"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v12, 0x0

    .line 16
    invoke-virtual {p0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 18
    .local v3, "marginLayoutParams":Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-virtual {p2}, Landroid/view/ViewGroup;->getMeasuredWidth()I

    move-result v10

    invoke-virtual {p2}, Landroid/view/ViewGroup;->getMeasuredHeight()I

    move-result v11

    invoke-virtual {p0, v10, v11}, Landroid/view/View;->measure(II)V

    .line 19
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    .line 20
    .local v0, "height":I
    invoke-virtual {p0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v9

    .line 22
    .local v9, "width":I
    invoke-virtual {p2}, Landroid/view/ViewGroup;->getMeasuredWidth()I

    move-result v10

    invoke-virtual {p2}, Landroid/view/ViewGroup;->getMeasuredHeight()I

    move-result v11

    invoke-virtual {p1, v10, v11}, Landroid/widget/TextView;->measure(II)V

    .line 23
    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingTop()I

    move-result v4

    .line 25
    .local v4, "padding":I
    invoke-virtual {p1}, Landroid/widget/TextView;->getPaint()Landroid/text/TextPaint;

    move-result-object v10

    invoke-virtual {v10}, Landroid/text/TextPaint;->getTextSize()F

    move-result v8

    .line 26
    .local v8, "textLineHeight":F
    sub-int v10, v0, v4

    int-to-float v10, v10

    div-float/2addr v10, v8

    invoke-static {v10}, Ljava/lang/Math;->round(F)I

    move-result v1

    .line 27
    .local v1, "lines":I
    iget v10, v3, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    add-int/2addr v10, v9

    iget v11, v3, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    add-int v2, v10, v11

    .line 31
    .local v2, "margin":I
    new-instance v7, Landroid/text/SpannableString;

    invoke-virtual {p1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v10

    invoke-direct {v7, v10}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 32
    .local v7, "ss":Landroid/text/SpannableString;
    invoke-static {v2, v1}, Lcom/comcast/cim/utils/TextFlowHelper;->getLeadingMarginSpan(II)Landroid/text/style/LeadingMarginSpan;

    move-result-object v10

    invoke-virtual {v7}, Landroid/text/SpannableString;->length()I

    move-result v11

    invoke-virtual {v7, v10, v12, v11, v12}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 33
    invoke-virtual {p1, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 36
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v5

    check-cast v5, Landroid/widget/RelativeLayout$LayoutParams;

    .line 37
    .local v5, "params":Landroid/widget/RelativeLayout$LayoutParams;
    invoke-virtual {v5}, Landroid/widget/RelativeLayout$LayoutParams;->getRules()[I

    move-result-object v6

    .line 38
    .local v6, "rules":[I
    const/4 v10, 0x1

    aput v12, v6, v10

    .line 39
    return-void
.end method
