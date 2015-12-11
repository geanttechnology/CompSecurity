.class public Lco/vine/android/views/FlowLayout;
.super Landroid/view/ViewGroup;
.source "FlowLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/views/FlowLayout$LayoutParams;
    }
.end annotation


# static fields
.field public static final HORIZONTAL:I = 0x0

.field public static final VERTICAL:I = 0x1


# instance fields
.field private debugDraw:Z

.field private horizontalSpacing:I

.field private orientation:I

.field private verticalSpacing:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 18
    invoke-direct {p0, p1}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;)V

    .line 12
    iput v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    .line 13
    iput v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    .line 14
    iput v0, p0, Lco/vine/android/views/FlowLayout;->orientation:I

    .line 15
    iput-boolean v0, p0, Lco/vine/android/views/FlowLayout;->debugDraw:Z

    .line 20
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lco/vine/android/views/FlowLayout;->readStyleParameters(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 21
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attributeSet"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, 0x0

    .line 24
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 12
    iput v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    .line 13
    iput v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    .line 14
    iput v0, p0, Lco/vine/android/views/FlowLayout;->orientation:I

    .line 15
    iput-boolean v0, p0, Lco/vine/android/views/FlowLayout;->debugDraw:Z

    .line 26
    invoke-direct {p0, p1, p2}, Lco/vine/android/views/FlowLayout;->readStyleParameters(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attributeSet"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v0, 0x0

    .line 30
    invoke-direct {p0, p1, p2, p3}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 12
    iput v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    .line 13
    iput v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    .line 14
    iput v0, p0, Lco/vine/android/views/FlowLayout;->orientation:I

    .line 15
    iput-boolean v0, p0, Lco/vine/android/views/FlowLayout;->debugDraw:Z

    .line 32
    invoke-direct {p0, p1, p2}, Lco/vine/android/views/FlowLayout;->readStyleParameters(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 33
    return-void
.end method

.method private createPaint(I)Landroid/graphics/Paint;
    .locals 2
    .param p1, "color"    # I

    .prologue
    .line 265
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    .line 266
    .local v0, "paint":Landroid/graphics/Paint;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 267
    invoke-virtual {v0, p1}, Landroid/graphics/Paint;->setColor(I)V

    .line 268
    const/high16 v1, 0x40000000    # 2.0f

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 269
    return-object v0
.end method

.method private drawDebugInfo(Landroid/graphics/Canvas;Landroid/view/View;)V
    .locals 15
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "child"    # Landroid/view/View;

    .prologue
    .line 213
    iget-boolean v0, p0, Lco/vine/android/views/FlowLayout;->debugDraw:Z

    if-nez v0, :cond_1

    .line 262
    :cond_0
    :goto_0
    return-void

    .line 217
    :cond_1
    const/16 v0, -0x100

    invoke-direct {p0, v0}, Lco/vine/android/views/FlowLayout;->createPaint(I)Landroid/graphics/Paint;

    move-result-object v5

    .line 218
    .local v5, "childPaint":Landroid/graphics/Paint;
    const v0, -0xff0100

    invoke-direct {p0, v0}, Lco/vine/android/views/FlowLayout;->createPaint(I)Landroid/graphics/Paint;

    move-result-object v12

    .line 219
    .local v12, "layoutPaint":Landroid/graphics/Paint;
    const/high16 v0, -0x10000

    invoke-direct {p0, v0}, Lco/vine/android/views/FlowLayout;->createPaint(I)Landroid/graphics/Paint;

    move-result-object v14

    .line 221
    .local v14, "newLinePaint":Landroid/graphics/Paint;
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v13

    check-cast v13, Lco/vine/android/views/FlowLayout$LayoutParams;

    .line 223
    .local v13, "lp":Lco/vine/android/views/FlowLayout$LayoutParams;
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$200(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    if-lez v0, :cond_4

    .line 224
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getRight()I

    move-result v0

    int-to-float v1, v0

    .line 225
    .local v1, "x":F
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTop()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getHeight()I

    move-result v3

    int-to-float v3, v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float v2, v0, v3

    .line 226
    .local v2, "y":F
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$200(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float v3, v1, v0

    move-object/from16 v0, p1

    move v4, v2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 227
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$200(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float/2addr v0, v1

    const/high16 v3, 0x40800000    # 4.0f

    sub-float v7, v0, v3

    const/high16 v0, 0x40800000    # 4.0f

    sub-float v8, v2, v0

    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$200(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float v9, v1, v0

    move-object/from16 v6, p1

    move v10, v2

    move-object v11, v5

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 228
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$200(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float/2addr v0, v1

    const/high16 v3, 0x40800000    # 4.0f

    sub-float v7, v0, v3

    const/high16 v0, 0x40800000    # 4.0f

    add-float v8, v2, v0

    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$200(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float v9, v1, v0

    move-object/from16 v6, p1

    move v10, v2

    move-object v11, v5

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 237
    .end local v1    # "x":F
    .end local v2    # "y":F
    :cond_2
    :goto_1
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$100(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    if-lez v0, :cond_5

    .line 238
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getLeft()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getWidth()I

    move-result v3

    int-to-float v3, v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float v1, v0, v3

    .line 239
    .restart local v1    # "x":F
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getBottom()I

    move-result v0

    int-to-float v2, v0

    .line 240
    .restart local v2    # "y":F
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$100(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float v4, v2, v0

    move-object/from16 v0, p1

    move v3, v1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 241
    const/high16 v0, 0x40800000    # 4.0f

    sub-float v7, v1, v0

    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$100(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float/2addr v0, v2

    const/high16 v3, 0x40800000    # 4.0f

    sub-float v8, v0, v3

    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$100(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float v10, v2, v0

    move-object/from16 v6, p1

    move v9, v1

    move-object v11, v5

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 242
    const/high16 v0, 0x40800000    # 4.0f

    add-float v7, v1, v0

    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$100(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float/2addr v0, v2

    const/high16 v3, 0x40800000    # 4.0f

    sub-float v8, v0, v3

    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$100(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    int-to-float v0, v0

    add-float v10, v2, v0

    move-object/from16 v6, p1

    move v9, v1

    move-object v11, v5

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 251
    .end local v1    # "x":F
    .end local v2    # "y":F
    :cond_3
    :goto_2
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->newLine:Z
    invoke-static {v13}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$000(Lco/vine/android/views/FlowLayout$LayoutParams;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 252
    iget v0, p0, Lco/vine/android/views/FlowLayout;->orientation:I

    if-nez v0, :cond_6

    .line 253
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getLeft()I

    move-result v0

    int-to-float v1, v0

    .line 254
    .restart local v1    # "x":F
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTop()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getHeight()I

    move-result v3

    int-to-float v3, v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float v2, v0, v3

    .line 255
    .restart local v2    # "y":F
    const/high16 v0, 0x40c00000    # 6.0f

    sub-float v8, v2, v0

    const/high16 v0, 0x40c00000    # 6.0f

    add-float v10, v2, v0

    move-object/from16 v6, p1

    move v7, v1

    move v9, v1

    move-object v11, v14

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 229
    .end local v1    # "x":F
    .end local v2    # "y":F
    :cond_4
    iget v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    if-lez v0, :cond_2

    .line 230
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getRight()I

    move-result v0

    int-to-float v1, v0

    .line 231
    .restart local v1    # "x":F
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTop()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getHeight()I

    move-result v3

    int-to-float v3, v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float v2, v0, v3

    .line 232
    .restart local v2    # "y":F
    iget v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    int-to-float v0, v0

    add-float v9, v1, v0

    move-object/from16 v6, p1

    move v7, v1

    move v8, v2

    move v10, v2

    move-object v11, v12

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 233
    iget v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    int-to-float v0, v0

    add-float/2addr v0, v1

    const/high16 v3, 0x40800000    # 4.0f

    sub-float v7, v0, v3

    const/high16 v0, 0x40800000    # 4.0f

    sub-float v8, v2, v0

    iget v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    int-to-float v0, v0

    add-float v9, v1, v0

    move-object/from16 v6, p1

    move v10, v2

    move-object v11, v12

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 234
    iget v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    int-to-float v0, v0

    add-float/2addr v0, v1

    const/high16 v3, 0x40800000    # 4.0f

    sub-float v7, v0, v3

    const/high16 v0, 0x40800000    # 4.0f

    add-float v8, v2, v0

    iget v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    int-to-float v0, v0

    add-float v9, v1, v0

    move-object/from16 v6, p1

    move v10, v2

    move-object v11, v12

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto/16 :goto_1

    .line 243
    .end local v1    # "x":F
    .end local v2    # "y":F
    :cond_5
    iget v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    if-lez v0, :cond_3

    .line 244
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getLeft()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getWidth()I

    move-result v3

    int-to-float v3, v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float v1, v0, v3

    .line 245
    .restart local v1    # "x":F
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getBottom()I

    move-result v0

    int-to-float v2, v0

    .line 246
    .restart local v2    # "y":F
    iget v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    int-to-float v0, v0

    add-float v10, v2, v0

    move-object/from16 v6, p1

    move v7, v1

    move v8, v2

    move v9, v1

    move-object v11, v12

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 247
    const/high16 v0, 0x40800000    # 4.0f

    sub-float v7, v1, v0

    iget v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    int-to-float v0, v0

    add-float/2addr v0, v2

    const/high16 v3, 0x40800000    # 4.0f

    sub-float v8, v0, v3

    iget v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    int-to-float v0, v0

    add-float v10, v2, v0

    move-object/from16 v6, p1

    move v9, v1

    move-object v11, v12

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 248
    const/high16 v0, 0x40800000    # 4.0f

    add-float v7, v1, v0

    iget v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    int-to-float v0, v0

    add-float/2addr v0, v2

    const/high16 v3, 0x40800000    # 4.0f

    sub-float v8, v0, v3

    iget v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    int-to-float v0, v0

    add-float v10, v2, v0

    move-object/from16 v6, p1

    move v9, v1

    move-object v11, v12

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto/16 :goto_2

    .line 257
    .end local v1    # "x":F
    .end local v2    # "y":F
    :cond_6
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getLeft()I

    move-result v0

    int-to-float v0, v0

    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getWidth()I

    move-result v3

    int-to-float v3, v3

    const/high16 v4, 0x40000000    # 2.0f

    div-float/2addr v3, v4

    add-float v1, v0, v3

    .line 258
    .restart local v1    # "x":F
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTop()I

    move-result v0

    int-to-float v2, v0

    .line 259
    .restart local v2    # "y":F
    const/high16 v0, 0x40c00000    # 6.0f

    sub-float v7, v1, v0

    const/high16 v0, 0x40c00000    # 6.0f

    add-float v9, v1, v0

    move-object/from16 v6, p1

    move v8, v2

    move v10, v2

    move-object v11, v14

    invoke-virtual/range {v6 .. v11}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    goto/16 :goto_0
.end method

.method private getHorizontalSpacing(Lco/vine/android/views/FlowLayout$LayoutParams;)I
    .locals 2
    .param p1, "lp"    # Lco/vine/android/views/FlowLayout$LayoutParams;

    .prologue
    .line 160
    invoke-virtual {p1}, Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacingSpecified()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 161
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->horizontalSpacing:I
    invoke-static {p1}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$200(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    .line 165
    .local v0, "hSpacing":I
    :goto_0
    return v0

    .line 163
    .end local v0    # "hSpacing":I
    :cond_0
    iget v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    .restart local v0    # "hSpacing":I
    goto :goto_0
.end method

.method private getVerticalSpacing(Lco/vine/android/views/FlowLayout$LayoutParams;)I
    .locals 2
    .param p1, "lp"    # Lco/vine/android/views/FlowLayout$LayoutParams;

    .prologue
    .line 150
    invoke-virtual {p1}, Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacingSpecified()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 151
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->verticalSpacing:I
    invoke-static {p1}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$100(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v0

    .line 155
    .local v0, "vSpacing":I
    :goto_0
    return v0

    .line 153
    .end local v0    # "vSpacing":I
    :cond_0
    iget v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    .restart local v0    # "vSpacing":I
    goto :goto_0
.end method

.method private readStyleParameters(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attributeSet"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v0, 0x0

    .line 206
    iput v0, p0, Lco/vine/android/views/FlowLayout;->horizontalSpacing:I

    .line 207
    iput v0, p0, Lco/vine/android/views/FlowLayout;->verticalSpacing:I

    .line 208
    iput v0, p0, Lco/vine/android/views/FlowLayout;->orientation:I

    .line 209
    iput-boolean v0, p0, Lco/vine/android/views/FlowLayout;->debugDraw:Z

    .line 210
    return-void
.end method


# virtual methods
.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 187
    instance-of v0, p1, Lco/vine/android/views/FlowLayout$LayoutParams;

    return v0
.end method

.method protected drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "child"    # Landroid/view/View;
    .param p3, "drawingTime"    # J

    .prologue
    .line 180
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/ViewGroup;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    move-result v0

    .line 181
    .local v0, "more":Z
    invoke-direct {p0, p1, p2}, Lco/vine/android/views/FlowLayout;->drawDebugInfo(Landroid/graphics/Canvas;Landroid/view/View;)V

    .line 182
    return v0
.end method

.method protected bridge synthetic generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 1

    .prologue
    .line 9
    invoke-virtual {p0}, Lco/vine/android/views/FlowLayout;->generateDefaultLayoutParams()Lco/vine/android/views/FlowLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected generateDefaultLayoutParams()Lco/vine/android/views/FlowLayout$LayoutParams;
    .locals 2

    .prologue
    const/4 v1, -0x2

    .line 192
    new-instance v0, Lco/vine/android/views/FlowLayout$LayoutParams;

    invoke-direct {v0, v1, v1}, Lco/vine/android/views/FlowLayout$LayoutParams;-><init>(II)V

    return-object v0
.end method

.method public bridge synthetic generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "x0"    # Landroid/util/AttributeSet;

    .prologue
    .line 9
    invoke-virtual {p0, p1}, Lco/vine/android/views/FlowLayout;->generateLayoutParams(Landroid/util/AttributeSet;)Lco/vine/android/views/FlowLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "x0"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 9
    invoke-virtual {p0, p1}, Lco/vine/android/views/FlowLayout;->generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Lco/vine/android/views/FlowLayout$LayoutParams;

    move-result-object v0

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Lco/vine/android/views/FlowLayout$LayoutParams;
    .locals 2
    .param p1, "attributeSet"    # Landroid/util/AttributeSet;

    .prologue
    .line 197
    new-instance v0, Lco/vine/android/views/FlowLayout$LayoutParams;

    invoke-virtual {p0}, Lco/vine/android/views/FlowLayout;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lco/vine/android/views/FlowLayout$LayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Lco/vine/android/views/FlowLayout$LayoutParams;
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 202
    new-instance v0, Lco/vine/android/views/FlowLayout$LayoutParams;

    invoke-direct {v0, p1}, Lco/vine/android/views/FlowLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method protected onLayout(ZIIII)V
    .locals 9
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 170
    invoke-virtual {p0}, Lco/vine/android/views/FlowLayout;->getChildCount()I

    move-result v1

    .line 171
    .local v1, "count":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_0

    .line 172
    invoke-virtual {p0, v2}, Lco/vine/android/views/FlowLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 173
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Lco/vine/android/views/FlowLayout$LayoutParams;

    .line 174
    .local v3, "lp":Lco/vine/android/views/FlowLayout$LayoutParams;
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->x:I
    invoke-static {v3}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$300(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v4

    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->y:I
    invoke-static {v3}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$400(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v5

    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->x:I
    invoke-static {v3}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$300(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v6

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    add-int/2addr v6, v7

    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->y:I
    invoke-static {v3}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$400(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v7

    invoke-virtual {v0}, Landroid/view/View;->getMeasuredHeight()I

    move-result v8

    add-int/2addr v7, v8

    invoke-virtual {v0, v4, v5, v6, v7}, Landroid/view/View;->layout(IIII)V

    .line 171
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 176
    .end local v0    # "child":Landroid/view/View;
    .end local v3    # "lp":Lco/vine/android/views/FlowLayout$LayoutParams;
    :cond_0
    return-void
.end method

.method protected onMeasure(II)V
    .locals 34
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 37
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v31

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingRight()I

    move-result v32

    sub-int v31, v31, v32

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingLeft()I

    move-result v32

    sub-int v27, v31, v32

    .line 38
    .local v27, "sizeWidth":I
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v31

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingTop()I

    move-result v32

    sub-int v31, v31, v32

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingBottom()I

    move-result v32

    sub-int v26, v31, v32

    .line 40
    .local v26, "sizeHeight":I
    invoke-static/range {p1 .. p1}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v20

    .line 41
    .local v20, "modeWidth":I
    invoke-static/range {p2 .. p2}, Landroid/view/View$MeasureSpec;->getMode(I)I

    move-result v19

    .line 46
    .local v19, "modeHeight":I
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/FlowLayout;->orientation:I

    move/from16 v31, v0

    if-nez v31, :cond_0

    .line 47
    move/from16 v25, v27

    .line 48
    .local v25, "size":I
    move/from16 v18, v20

    .line 54
    .local v18, "mode":I
    :goto_0
    const/16 v16, 0x0

    .line 55
    .local v16, "lineThicknessWithSpacing":I
    const/4 v15, 0x0

    .line 56
    .local v15, "lineThickness":I
    const/4 v14, 0x0

    .line 59
    .local v14, "lineLengthWithSpacing":I
    const/16 v24, 0x0

    .line 61
    .local v24, "prevLinePosition":I
    const/4 v8, 0x0

    .line 62
    .local v8, "controlMaxLength":I
    const/4 v9, 0x0

    .line 64
    .local v9, "controlMaxThickness":I
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getChildCount()I

    move-result v10

    .line 65
    .local v10, "count":I
    const/4 v12, 0x0

    .local v12, "i":I
    :goto_1
    if-ge v12, v10, :cond_7

    .line 66
    move-object/from16 v0, p0

    invoke-virtual {v0, v12}, Lco/vine/android/views/FlowLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    .line 67
    .local v3, "child":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getVisibility()I

    move-result v31

    const/16 v32, 0x8

    move/from16 v0, v31

    move/from16 v1, v32

    if-ne v0, v1, :cond_1

    .line 65
    :goto_2
    add-int/lit8 v12, v12, 0x1

    goto :goto_1

    .line 50
    .end local v3    # "child":Landroid/view/View;
    .end local v8    # "controlMaxLength":I
    .end local v9    # "controlMaxThickness":I
    .end local v10    # "count":I
    .end local v12    # "i":I
    .end local v14    # "lineLengthWithSpacing":I
    .end local v15    # "lineThickness":I
    .end local v16    # "lineThicknessWithSpacing":I
    .end local v18    # "mode":I
    .end local v24    # "prevLinePosition":I
    .end local v25    # "size":I
    :cond_0
    move/from16 v25, v26

    .line 51
    .restart local v25    # "size":I
    move/from16 v18, v19

    .restart local v18    # "mode":I
    goto :goto_0

    .line 71
    .restart local v3    # "child":Landroid/view/View;
    .restart local v8    # "controlMaxLength":I
    .restart local v9    # "controlMaxThickness":I
    .restart local v10    # "count":I
    .restart local v12    # "i":I
    .restart local v14    # "lineLengthWithSpacing":I
    .restart local v15    # "lineThickness":I
    .restart local v16    # "lineThicknessWithSpacing":I
    .restart local v24    # "prevLinePosition":I
    :cond_1
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v17

    check-cast v17, Lco/vine/android/views/FlowLayout$LayoutParams;

    .line 73
    .local v17, "lp":Lco/vine/android/views/FlowLayout$LayoutParams;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingLeft()I

    move-result v31

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingRight()I

    move-result v32

    add-int v31, v31, v32

    move-object/from16 v0, v17

    iget v0, v0, Lco/vine/android/views/FlowLayout$LayoutParams;->width:I

    move/from16 v32, v0

    move/from16 v0, p1

    move/from16 v1, v31

    move/from16 v2, v32

    invoke-static {v0, v1, v2}, Lco/vine/android/views/FlowLayout;->getChildMeasureSpec(III)I

    move-result v31

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingTop()I

    move-result v32

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingBottom()I

    move-result v33

    add-int v32, v32, v33

    move-object/from16 v0, v17

    iget v0, v0, Lco/vine/android/views/FlowLayout$LayoutParams;->height:I

    move/from16 v33, v0

    move/from16 v0, p2

    move/from16 v1, v32

    move/from16 v2, v33

    invoke-static {v0, v1, v2}, Lco/vine/android/views/FlowLayout;->getChildMeasureSpec(III)I

    move-result v32

    move/from16 v0, v31

    move/from16 v1, v32

    invoke-virtual {v3, v0, v1}, Landroid/view/View;->measure(II)V

    .line 78
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1}, Lco/vine/android/views/FlowLayout;->getHorizontalSpacing(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v11

    .line 79
    .local v11, "hSpacing":I
    move-object/from16 v0, p0

    move-object/from16 v1, v17

    invoke-direct {v0, v1}, Lco/vine/android/views/FlowLayout;->getVerticalSpacing(Lco/vine/android/views/FlowLayout$LayoutParams;)I

    move-result v30

    .line 81
    .local v30, "vSpacing":I
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredWidth()I

    move-result v7

    .line 82
    .local v7, "childWidth":I
    invoke-virtual {v3}, Landroid/view/View;->getMeasuredHeight()I

    move-result v4

    .line 89
    .local v4, "childHeight":I
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/FlowLayout;->orientation:I

    move/from16 v31, v0

    if-nez v31, :cond_4

    .line 90
    move v5, v7

    .line 91
    .local v5, "childLength":I
    move v6, v4

    .line 92
    .local v6, "childThickness":I
    move/from16 v28, v11

    .line 93
    .local v28, "spacingLength":I
    move/from16 v29, v30

    .line 101
    .local v29, "spacingThickness":I
    :goto_3
    add-int v13, v14, v5

    .line 102
    .local v13, "lineLength":I
    add-int v14, v13, v28

    .line 104
    # getter for: Lco/vine/android/views/FlowLayout$LayoutParams;->newLine:Z
    invoke-static/range {v17 .. v17}, Lco/vine/android/views/FlowLayout$LayoutParams;->access$000(Lco/vine/android/views/FlowLayout$LayoutParams;)Z

    move-result v31

    if-nez v31, :cond_2

    if-eqz v18, :cond_5

    move/from16 v0, v25

    if-le v13, v0, :cond_5

    :cond_2
    const/16 v21, 0x1

    .line 105
    .local v21, "newLine":Z
    :goto_4
    if-eqz v21, :cond_3

    .line 106
    add-int v24, v24, v16

    .line 108
    move v15, v6

    .line 109
    move v13, v5

    .line 110
    add-int v16, v6, v29

    .line 111
    add-int v14, v13, v28

    .line 114
    :cond_3
    add-int v31, v6, v29

    move/from16 v0, v16

    move/from16 v1, v31

    invoke-static {v0, v1}, Ljava/lang/Math;->max(II)I

    move-result v16

    .line 115
    invoke-static {v15, v6}, Ljava/lang/Math;->max(II)I

    move-result v15

    .line 119
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/FlowLayout;->orientation:I

    move/from16 v31, v0

    if-nez v31, :cond_6

    .line 120
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingLeft()I

    move-result v31

    add-int v31, v31, v13

    sub-int v22, v31, v5

    .line 121
    .local v22, "posX":I
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingTop()I

    move-result v31

    add-int v23, v31, v24

    .line 126
    .local v23, "posY":I
    :goto_5
    move-object/from16 v0, v17

    move/from16 v1, v22

    move/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lco/vine/android/views/FlowLayout$LayoutParams;->setPosition(II)V

    .line 128
    invoke-static {v8, v13}, Ljava/lang/Math;->max(II)I

    move-result v8

    .line 129
    add-int v9, v24, v15

    goto/16 :goto_2

    .line 95
    .end local v5    # "childLength":I
    .end local v6    # "childThickness":I
    .end local v13    # "lineLength":I
    .end local v21    # "newLine":Z
    .end local v22    # "posX":I
    .end local v23    # "posY":I
    .end local v28    # "spacingLength":I
    .end local v29    # "spacingThickness":I
    :cond_4
    move v5, v4

    .line 96
    .restart local v5    # "childLength":I
    move v6, v7

    .line 97
    .restart local v6    # "childThickness":I
    move/from16 v28, v30

    .line 98
    .restart local v28    # "spacingLength":I
    move/from16 v29, v11

    .restart local v29    # "spacingThickness":I
    goto :goto_3

    .line 104
    .restart local v13    # "lineLength":I
    :cond_5
    const/16 v21, 0x0

    goto :goto_4

    .line 123
    .restart local v21    # "newLine":Z
    :cond_6
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingLeft()I

    move-result v31

    add-int v22, v31, v24

    .line 124
    .restart local v22    # "posX":I
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingTop()I

    move-result v31

    add-int v31, v31, v13

    sub-int v23, v31, v4

    .restart local v23    # "posY":I
    goto :goto_5

    .line 133
    .end local v3    # "child":Landroid/view/View;
    .end local v4    # "childHeight":I
    .end local v5    # "childLength":I
    .end local v6    # "childThickness":I
    .end local v7    # "childWidth":I
    .end local v11    # "hSpacing":I
    .end local v13    # "lineLength":I
    .end local v17    # "lp":Lco/vine/android/views/FlowLayout$LayoutParams;
    .end local v21    # "newLine":Z
    .end local v22    # "posX":I
    .end local v23    # "posY":I
    .end local v28    # "spacingLength":I
    .end local v29    # "spacingThickness":I
    .end local v30    # "vSpacing":I
    :cond_7
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/FlowLayout;->orientation:I

    move/from16 v31, v0

    if-nez v31, :cond_8

    .line 134
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingLeft()I

    move-result v31

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingRight()I

    move-result v32

    add-int v31, v31, v32

    add-int v8, v8, v31

    .line 135
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingBottom()I

    move-result v31

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingTop()I

    move-result v32

    add-int v31, v31, v32

    add-int v9, v9, v31

    .line 141
    :goto_6
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/views/FlowLayout;->orientation:I

    move/from16 v31, v0

    if-nez v31, :cond_9

    .line 142
    move/from16 v0, p1

    invoke-static {v8, v0}, Lco/vine/android/views/FlowLayout;->resolveSize(II)I

    move-result v31

    move/from16 v0, p2

    invoke-static {v9, v0}, Lco/vine/android/views/FlowLayout;->resolveSize(II)I

    move-result v32

    move-object/from16 v0, p0

    move/from16 v1, v31

    move/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Lco/vine/android/views/FlowLayout;->setMeasuredDimension(II)V

    .line 146
    :goto_7
    return-void

    .line 137
    :cond_8
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingBottom()I

    move-result v31

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingTop()I

    move-result v32

    add-int v31, v31, v32

    add-int v8, v8, v31

    .line 138
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingLeft()I

    move-result v31

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/views/FlowLayout;->getPaddingRight()I

    move-result v32

    add-int v31, v31, v32

    add-int v9, v9, v31

    goto :goto_6

    .line 144
    :cond_9
    move/from16 v0, p1

    invoke-static {v9, v0}, Lco/vine/android/views/FlowLayout;->resolveSize(II)I

    move-result v31

    move/from16 v0, p2

    invoke-static {v8, v0}, Lco/vine/android/views/FlowLayout;->resolveSize(II)I

    move-result v32

    move-object/from16 v0, p0

    move/from16 v1, v31

    move/from16 v2, v32

    invoke-virtual {v0, v1, v2}, Lco/vine/android/views/FlowLayout;->setMeasuredDimension(II)V

    goto :goto_7
.end method
