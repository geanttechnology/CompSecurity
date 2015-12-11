.class public Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;
.super Landroid/widget/TextView;
.source "CCPreviewTextView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView$1;
    }
.end annotation


# instance fields
.field private edgeColor:I

.field private edgeType:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

.field private final outlinePaint:Landroid/graphics/Paint;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 12
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    .line 21
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 12
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    .line 26
    return-void
.end method


# virtual methods
.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->edgeType:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->UNIFORM:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->edgeType:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->RAISED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->edgeType:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->DEPRESSED:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    if-ne v0, v1, :cond_1

    .line 50
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 51
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Join;->ROUND:Landroid/graphics/Paint$Join;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeJoin(Landroid/graphics/Paint$Join;)V

    .line 52
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/comcast/cim/cmasl/android708compatlib/R$dimen;->cc_preview_outline_stroke_width:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    int-to-float v1, v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 53
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    iget v1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->edgeColor:I

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setColor(I)V

    .line 54
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    sget-object v1, Landroid/graphics/Paint$Style;->FILL_AND_STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 55
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->getTextSize()F

    move-result v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 56
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 58
    sget-object v0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge:[I

    iget-object v1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->edgeType:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 71
    :cond_1
    :goto_0
    invoke-super {p0, p1}, Landroid/widget/TextView;->onDraw(Landroid/graphics/Canvas;)V

    .line 72
    return-void

    .line 60
    :pswitch_0
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->getBaseline()I

    move-result v2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_0

    .line 63
    :pswitch_1
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const/high16 v1, -0x40000000    # -2.0f

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->getBaseline()I

    move-result v2

    add-int/lit8 v2, v2, -0x2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_0

    .line 66
    :pswitch_2
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const/high16 v1, 0x40000000    # 2.0f

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->getBaseline()I

    move-result v2

    int-to-float v2, v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->outlinePaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_0

    .line 58
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public setEdge(Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;I)V
    .locals 5
    .param p1, "edgeType"    # Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;
    .param p2, "edgeColor"    # I

    .prologue
    const/high16 v4, 0x41200000    # 10.0f

    const/high16 v3, 0x40000000    # 2.0f

    const/4 v2, 0x0

    .line 29
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->edgeType:Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;

    .line 30
    iput p2, p0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->edgeColor:I

    .line 31
    sget-object v0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView$1;->$SwitchMap$com$comcast$playerplatform$primetime$android$util$ClosedCaptionsFormat$FontEdge:[I

    invoke-virtual {p1}, Lcom/comcast/playerplatform/primetime/android/util/ClosedCaptionsFormat$FontEdge;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 39
    const/4 v0, 0x0

    invoke-virtual {p0, v2, v2, v2, v0}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->setShadowLayer(FFFI)V

    .line 42
    :goto_0
    return-void

    .line 33
    :pswitch_0
    invoke-virtual {p0, v4, v3, v3, p2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->setShadowLayer(FFFI)V

    goto :goto_0

    .line 36
    :pswitch_1
    const/high16 v0, -0x40000000    # -2.0f

    invoke-virtual {p0, v4, v0, v3, p2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewTextView;->setShadowLayer(FFFI)V

    goto :goto_0

    .line 31
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
