.class Lcom/comcast/cim/utils/TextFlowHelper$MyLeadingMarginSpan2;
.super Ljava/lang/Object;
.source "TextFlowHelper.java"

# interfaces
.implements Landroid/text/style/LeadingMarginSpan$LeadingMarginSpan2;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/utils/TextFlowHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MyLeadingMarginSpan2"
.end annotation


# instance fields
.field private lines:I

.field private margin:I


# direct methods
.method public constructor <init>(II)V
    .locals 0
    .param p1, "lines"    # I
    .param p2, "margin"    # I

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 50
    iput p2, p0, Lcom/comcast/cim/utils/TextFlowHelper$MyLeadingMarginSpan2;->margin:I

    .line 51
    iput p1, p0, Lcom/comcast/cim/utils/TextFlowHelper$MyLeadingMarginSpan2;->lines:I

    .line 52
    return-void
.end method


# virtual methods
.method public drawLeadingMargin(Landroid/graphics/Canvas;Landroid/graphics/Paint;IIIIILjava/lang/CharSequence;IIZLandroid/text/Layout;)V
    .locals 0
    .param p1, "c"    # Landroid/graphics/Canvas;
    .param p2, "p"    # Landroid/graphics/Paint;
    .param p3, "x"    # I
    .param p4, "dir"    # I
    .param p5, "top"    # I
    .param p6, "baseline"    # I
    .param p7, "bottom"    # I
    .param p8, "text"    # Ljava/lang/CharSequence;
    .param p9, "start"    # I
    .param p10, "end"    # I
    .param p11, "first"    # Z
    .param p12, "layout"    # Landroid/text/Layout;

    .prologue
    .line 67
    return-void
.end method

.method public getLeadingMargin(Z)I
    .locals 1
    .param p1, "first"    # Z

    .prologue
    .line 56
    if-eqz p1, :cond_0

    iget v0, p0, Lcom/comcast/cim/utils/TextFlowHelper$MyLeadingMarginSpan2;->margin:I

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLeadingMarginLineCount()I
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/comcast/cim/utils/TextFlowHelper$MyLeadingMarginSpan2;->lines:I

    return v0
.end method
