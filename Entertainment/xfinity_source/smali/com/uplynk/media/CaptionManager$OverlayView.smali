.class Lcom/uplynk/media/CaptionManager$OverlayView;
.super Landroid/view/View;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "OverlayView"
.end annotation


# static fields
.field protected static final CLEAR_MSG:I = 0x1

.field private static final STREAM_ROW:S = 0xes


# instance fields
.field _backgroundPaint:Landroid/graphics/Paint;

.field _density:F

.field _handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

.field private _hasContent:Z

.field _lineBuff:Ljava/lang/StringBuffer;

.field _mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

.field _previewColumn:I

.field _previewRow:I

.field _previewText:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field _rowCount:S

.field _rowY:Landroid/util/SparseIntArray;

.field _rows:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/uplynk/media/CaptionEvent$CaptionRow;",
            ">;"
        }
    .end annotation
.end field

.field _style:Lcom/uplynk/media/CaptionStyle;

.field _textDebugPaint:Landroid/graphics/Paint;

.field _textEffect1Paint:Landroid/graphics/Paint;

.field _textEffect2Paint:Landroid/graphics/Paint;

.field _textPadding:I

.field _textPaint:Landroid/graphics/Paint;

.field _textSize:F

.field _windowPaint:Landroid/graphics/Paint;

.field final synthetic this$0:Lcom/uplynk/media/CaptionManager;


# direct methods
.method public constructor <init>(Lcom/uplynk/media/CaptionManager;Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 1897
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    .line 1898
    invoke-direct {p0, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 1871
    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

    .line 1873
    const/high16 v1, 0x3f800000    # 1.0f

    iput v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    .line 1874
    const/high16 v1, 0x41400000    # 12.0f

    iput v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textSize:F

    .line 1875
    iput v3, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    .line 1876
    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    .line 1877
    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    .line 1878
    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 1879
    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    .line 1888
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_lineBuff:Ljava/lang/StringBuffer;

    .line 1890
    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    .line 1891
    const/4 v1, 0x5

    iput v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewColumn:I

    .line 1892
    const/4 v1, 0x7

    iput v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewRow:I

    .line 1894
    iput-boolean v3, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_hasContent:Z

    .line 1899
    invoke-virtual {p0, v3}, Lcom/uplynk/media/CaptionManager$OverlayView;->setFocusable(Z)V

    .line 1900
    invoke-virtual {p0, v3}, Lcom/uplynk/media/CaptionManager$OverlayView;->setWillNotCacheDrawing(Z)V

    .line 1901
    invoke-virtual {p0, v3}, Lcom/uplynk/media/CaptionManager$OverlayView;->setWillNotDraw(Z)V

    .line 1905
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    .line 1906
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_backgroundPaint:Landroid/graphics/Paint;

    .line 1909
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    .local v0, "looper":Landroid/os/Looper;
    if-eqz v0, :cond_0

    .line 1910
    new-instance v1, Lcom/uplynk/media/CaptionManager$OverlayHandler;

    invoke-direct {v1, p1, p0, v0}, Lcom/uplynk/media/CaptionManager$OverlayHandler;-><init>(Lcom/uplynk/media/CaptionManager;Lcom/uplynk/media/CaptionManager$OverlayView;Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

    .line 1916
    :goto_0
    return-void

    .line 1911
    :cond_0
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 1912
    new-instance v1, Lcom/uplynk/media/CaptionManager$OverlayHandler;

    invoke-direct {v1, p1, p0, v0}, Lcom/uplynk/media/CaptionManager$OverlayHandler;-><init>(Lcom/uplynk/media/CaptionManager;Lcom/uplynk/media/CaptionManager$OverlayView;Landroid/os/Looper;)V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

    goto :goto_0

    .line 1914
    :cond_1
    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/uplynk/media/CaptionManager$OverlayView;Z)V
    .locals 0

    .prologue
    .line 1894
    iput-boolean p1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_hasContent:Z

    return-void
.end method

.method private complimentShadeWithAlpha(II)I
    .locals 4
    .param p1, "color"    # I
    .param p2, "alpha"    # I

    .prologue
    const/16 v3, 0xc8

    const/16 v2, 0x32

    .line 1929
    const/4 v0, 0x0

    .line 1930
    .local v0, "max":I
    invoke-static {p1}, Landroid/graphics/Color;->red(I)I

    move-result v1

    if-le v1, v0, :cond_0

    invoke-static {p1}, Landroid/graphics/Color;->red(I)I

    move-result v0

    .line 1931
    :cond_0
    invoke-static {p1}, Landroid/graphics/Color;->green(I)I

    move-result v1

    if-le v1, v0, :cond_1

    invoke-static {p1}, Landroid/graphics/Color;->green(I)I

    move-result v0

    .line 1932
    :cond_1
    invoke-static {p1}, Landroid/graphics/Color;->blue(I)I

    move-result v1

    if-le v1, v0, :cond_2

    invoke-static {p1}, Landroid/graphics/Color;->blue(I)I

    move-result v0

    .line 1935
    :cond_2
    const/16 v1, 0x80

    if-le v0, v1, :cond_3

    .line 1936
    invoke-static {p2, v2, v2, v2}, Landroid/graphics/Color;->argb(IIII)I

    move-result v1

    .line 1938
    :goto_0
    return v1

    :cond_3
    invoke-static {p2, v3, v3, v3}, Landroid/graphics/Color;->argb(IIII)I

    move-result v1

    goto :goto_0
.end method

.method private configureOversizedRowPositions()V
    .locals 14

    .prologue
    .line 2090
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v12, v12, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    const/16 v13, 0x96

    if-eq v12, v13, :cond_1

    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v12, v12, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    const/16 v13, 0xc8

    if-eq v12, v13, :cond_1

    .line 2092
    const/4 v12, 0x0

    iput-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    .line 2185
    :cond_0
    return-void

    .line 2098
    :cond_1
    new-instance v12, Landroid/util/SparseIntArray;

    const/16 v13, 0xf

    invoke-direct {v12, v13}, Landroid/util/SparseIntArray;-><init>(I)V

    iput-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    .line 2099
    const/high16 v12, 0x41200000    # 10.0f

    iget v13, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v12, v13

    float-to-int v10, v12

    .line 2102
    .local v10, "vpad":I
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v13, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v12, v13, :cond_b

    .line 2104
    const/4 v4, 0x0

    .line 2105
    .local v4, "lastRow":I
    const/4 v5, 0x0

    .line 2106
    .local v5, "lastY":I
    const/4 v9, 0x0

    .line 2108
    .local v9, "tmpY":I
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v12, v12, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    const/16 v13, 0x96

    if-ne v12, v13, :cond_4

    const/4 v2, 0x3

    .line 2110
    .local v2, "groupSize":I
    :goto_0
    const/4 v3, 0x1

    .local v3, "i":I
    :goto_1
    const/16 v12, 0xf

    if-le v3, v12, :cond_5

    .line 2157
    .end local v2    # "groupSize":I
    .end local v3    # "i":I
    .end local v4    # "lastRow":I
    .end local v5    # "lastY":I
    .end local v9    # "tmpY":I
    :cond_2
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v13, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v12, v13, :cond_0

    .line 2161
    const/4 v7, 0x0

    .line 2163
    .local v7, "push":I
    const/16 v3, 0xf

    .restart local v3    # "i":I
    :goto_2
    const/4 v12, 0x1

    if-lt v3, v12, :cond_0

    .line 2165
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    invoke-virtual {v12, v3}, Landroid/util/SparseIntArray;->get(I)I

    move-result v11

    .line 2166
    .local v11, "y":I
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccLayoutHeight:I
    invoke-static {v12}, Lcom/uplynk/media/CaptionManager;->access$7(Lcom/uplynk/media/CaptionManager;)I

    move-result v12

    sub-int v1, v12, v11

    .line 2167
    .local v1, "d":I
    const/4 v12, -0x1

    if-eq v11, v12, :cond_3

    const/16 v12, 0x8

    if-ge v3, v12, :cond_d

    .line 2163
    :cond_3
    :goto_3
    add-int/lit8 v3, v3, -0x1

    goto :goto_2

    .line 2108
    .end local v1    # "d":I
    .end local v3    # "i":I
    .end local v7    # "push":I
    .end local v11    # "y":I
    .restart local v4    # "lastRow":I
    .restart local v5    # "lastY":I
    .restart local v9    # "tmpY":I
    :cond_4
    const/4 v2, 0x2

    goto :goto_0

    .line 2112
    .restart local v2    # "groupSize":I
    .restart local v3    # "i":I
    :cond_5
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    invoke-virtual {v12, v3}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/uplynk/media/CaptionEvent$CaptionRow;

    .line 2113
    .local v8, "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    if-eqz v8, :cond_a

    .line 2115
    if-eqz v4, :cond_6

    add-int/lit8 v12, v3, -0x1

    if-ne v4, v12, :cond_6

    .line 2117
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowSize:I
    invoke-static {v12}, Lcom/uplynk/media/CaptionManager;->access$5(Lcom/uplynk/media/CaptionManager;)I

    move-result v12

    add-int v9, v5, v12

    .line 2118
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    invoke-virtual {v12, v3, v9}, Landroid/util/SparseIntArray;->put(II)V

    .line 2120
    move v5, v9

    .line 2138
    :goto_4
    move v4, v3

    .line 2110
    :goto_5
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 2124
    :cond_6
    const/4 v6, 0x0

    .line 2125
    .local v6, "offset":I
    const/4 v12, 0x5

    if-ge v3, v12, :cond_8

    .line 2126
    const/4 v6, 0x1

    .line 2132
    :goto_6
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowSize:I
    invoke-static {v12}, Lcom/uplynk/media/CaptionManager;->access$5(Lcom/uplynk/media/CaptionManager;)I

    move-result v12

    mul-int/2addr v12, v6

    iget-object v13, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I
    invoke-static {v13}, Lcom/uplynk/media/CaptionManager;->access$6(Lcom/uplynk/media/CaptionManager;)I

    move-result v13

    add-int/2addr v12, v13

    mul-int/lit8 v13, v10, 0x2

    add-int v9, v12, v13

    .line 2133
    if-gt v9, v5, :cond_7

    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowSize:I
    invoke-static {v12}, Lcom/uplynk/media/CaptionManager;->access$5(Lcom/uplynk/media/CaptionManager;)I

    move-result v12

    add-int/2addr v12, v5

    mul-int/lit8 v13, v10, 0x2

    add-int v9, v12, v13

    .line 2134
    :cond_7
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    invoke-virtual {v12, v3, v9}, Landroid/util/SparseIntArray;->put(II)V

    .line 2136
    move v5, v9

    goto :goto_4

    .line 2127
    :cond_8
    const/16 v12, 0xa

    if-ge v3, v12, :cond_9

    .line 2128
    mul-int/lit8 v6, v2, 0x2

    goto :goto_6

    .line 2130
    :cond_9
    mul-int/lit8 v6, v2, 0x3

    goto :goto_6

    .line 2141
    .end local v6    # "offset":I
    :cond_a
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    const/4 v13, -0x1

    invoke-virtual {v12, v3, v13}, Landroid/util/SparseIntArray;->put(II)V

    goto :goto_5

    .line 2144
    .end local v2    # "groupSize":I
    .end local v3    # "i":I
    .end local v4    # "lastRow":I
    .end local v5    # "lastY":I
    .end local v8    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    .end local v9    # "tmpY":I
    :cond_b
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v13, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v12, v13, :cond_2

    .line 2146
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccLayoutHeight:I
    invoke-static {v12}, Lcom/uplynk/media/CaptionManager;->access$7(Lcom/uplynk/media/CaptionManager;)I

    move-result v12

    mul-int/lit8 v13, v10, 0x2

    sub-int v9, v12, v13

    .line 2148
    .restart local v9    # "tmpY":I
    const/16 v3, 0xe

    .restart local v3    # "i":I
    iget-short v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    add-int/lit8 v12, v12, -0x1

    rsub-int/lit8 v0, v12, 0xe

    .local v0, "c":I
    :goto_7
    if-lt v3, v0, :cond_2

    .line 2150
    const/16 v12, 0xe

    if-eq v3, v12, :cond_c

    .line 2151
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowSize:I
    invoke-static {v12}, Lcom/uplynk/media/CaptionManager;->access$5(Lcom/uplynk/media/CaptionManager;)I

    move-result v12

    sub-int/2addr v9, v12

    .line 2153
    :cond_c
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    invoke-virtual {v12, v3, v9}, Landroid/util/SparseIntArray;->put(II)V

    .line 2148
    add-int/lit8 v3, v3, -0x1

    goto :goto_7

    .line 2173
    .end local v0    # "c":I
    .end local v9    # "tmpY":I
    .restart local v1    # "d":I
    .restart local v7    # "push":I
    .restart local v11    # "y":I
    :cond_d
    if-gez v1, :cond_e

    .line 2176
    sub-int v7, v1, v10

    .line 2178
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    add-int v13, v11, v7

    invoke-virtual {v12, v3, v13}, Landroid/util/SparseIntArray;->put(II)V

    goto/16 :goto_3

    .line 2182
    :cond_e
    iget-object v12, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    add-int v13, v11, v7

    invoke-virtual {v12, v3, v13}, Landroid/util/SparseIntArray;->put(II)V

    goto/16 :goto_3
.end method

.method private drawRowBackground(Landroid/graphics/Canvas;FFFF)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "x"    # F
    .param p3, "y"    # F
    .param p4, "r"    # F
    .param p5, "b"    # F

    .prologue
    .line 2353
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionStyle;->getBackgroundColor()I

    move-result v0

    invoke-static {v0}, Landroid/graphics/Color;->alpha(I)I

    move-result v0

    if-nez v0, :cond_1

    .line 2356
    :cond_0
    :goto_0
    return-void

    .line 2355
    :cond_1
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_backgroundPaint:Landroid/graphics/Paint;

    move-object v0, p1

    move v1, p2

    move v2, p3

    move v3, p4

    move v4, p5

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    goto :goto_0
.end method

.method private drawRowText(Landroid/graphics/Canvas;FFLjava/lang/String;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "x"    # F
    .param p3, "y"    # F
    .param p4, "text"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x3

    const/high16 v2, 0x40000000    # 2.0f

    const/high16 v3, 0x3f800000    # 1.0f

    .line 2308
    invoke-virtual {p4}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_1

    .line 2311
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v0, v0, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    if-eqz v0, :cond_0

    .line 2313
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v0, v0, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 2315
    iget v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v0, v2

    add-float/2addr v0, p2

    iget v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v1, v2

    add-float/2addr v1, p3

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    invoke-virtual {p1, p4, v0, v1, v2}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 2346
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v0, v0, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    if-eq v0, v4, :cond_1

    .line 2347
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, p4, p2, p3, v0}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 2349
    :cond_1
    return-void

    .line 2317
    :cond_2
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v0, v0, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    if-ne v0, v4, :cond_3

    .line 2330
    iget v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v0, v3

    add-float/2addr v0, p2

    iget v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v1, v2

    sub-float v1, p3, v1

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    invoke-virtual {p1, p4, v0, v1, v2}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 2331
    iget v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v0, v3

    sub-float v0, p2, v0

    iget v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v1, v3

    add-float/2addr v1, p3

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, p4, v0, v1, v2}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_0

    .line 2333
    :cond_3
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v0, v0, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_4

    .line 2335
    iget v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v0, v2

    add-float/2addr v0, p2

    iget v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v1, v2

    add-float/2addr v1, p3

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    invoke-virtual {p1, p4, v0, v1, v2}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    .line 2336
    iget v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v0, v3

    sub-float v0, p2, v0

    iget v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v1, v3

    sub-float v1, p3, v1

    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    invoke-virtual {p1, p4, v0, v1, v2}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_0

    .line 2339
    :cond_4
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v0, v0, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 2341
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    invoke-virtual {p1, p4, p2, p3, v0}, Landroid/graphics/Canvas;->drawText(Ljava/lang/String;FFLandroid/graphics/Paint;)V

    goto :goto_0
.end method

.method private drawRowText(Landroid/graphics/Canvas;FFLjava/util/Vector;)V
    .locals 6
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "x"    # F
    .param p3, "y"    # F
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Canvas;",
            "FF",
            "Ljava/util/Vector",
            "<",
            "Lcom/uplynk/media/CaptionEvent$CaptionCharacter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2286
    .local p4, "characters":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    invoke-virtual {p4}, Ljava/util/Vector;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 2290
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_lineBuff:Ljava/lang/StringBuffer;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_lineBuff:Ljava/lang/StringBuffer;

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->length()I

    move-result v5

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuffer;->delete(II)Ljava/lang/StringBuffer;

    .line 2293
    invoke-virtual {p4}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 2294
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 2300
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_lineBuff:Ljava/lang/StringBuffer;

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v2

    .line 2302
    .local v2, "text":Ljava/lang/String;
    invoke-direct {p0, p1, p2, p3, v2}, Lcom/uplynk/media/CaptionManager$OverlayView;->drawRowText(Landroid/graphics/Canvas;FFLjava/lang/String;)V

    .line 2304
    .end local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    .end local v2    # "text":Ljava/lang/String;
    :cond_0
    return-void

    .line 2296
    .restart local v1    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

    .line 2297
    .local v0, "c":Lcom/uplynk/media/CaptionEvent$CaptionCharacter;
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_lineBuff:Ljava/lang/StringBuffer;

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->character()C

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method private drawWindow(Landroid/graphics/Canvas;F)V
    .locals 27
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "scale"    # F

    .prologue
    .line 2360
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    invoke-virtual {v2}, Lcom/uplynk/media/CaptionStyle;->getWindowColor()I

    move-result v2

    invoke-static {v2}, Landroid/graphics/Color;->alpha(I)I

    move-result v2

    if-nez v2, :cond_1

    .line 2436
    :cond_0
    :goto_0
    return-void

    .line 2362
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowSize:I
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager;->access$5(Lcom/uplynk/media/CaptionManager;)I

    move-result v2

    int-to-float v0, v2

    move/from16 v18, v0

    .line 2363
    .local v18, "rH":F
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccColSize:I
    invoke-static {v2}, Lcom/uplynk/media/CaptionManager;->access$8(Lcom/uplynk/media/CaptionManager;)I

    move-result v2

    int-to-float v8, v2

    .line 2364
    .local v8, "cW":F
    const/high16 v2, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v2, v3

    float-to-int v0, v2

    move/from16 v22, v0

    .line 2365
    .local v22, "vpad":I
    const/high16 v2, 0x40800000    # 4.0f

    move-object/from16 v0, p0

    iget v3, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float v24, v2, v3

    .line 2366
    .local v24, "winMargin":F
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v2, v2, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    const/16 v3, 0x96

    if-eq v2, v3, :cond_9

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v2, v2, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    const/16 v3, 0xc8

    if-eq v2, v3, :cond_9

    const/16 v16, 0x0

    .line 2371
    .local v16, "oversized":Z
    :goto_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v3, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v2, v3, :cond_e

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    if-eqz v2, :cond_e

    .line 2375
    new-instance v19, Ljava/util/Vector;

    invoke-direct/range {v19 .. v19}, Ljava/util/Vector;-><init>()V

    .line 2376
    .local v19, "rects":Ljava/util/Vector;, "Ljava/util/Vector<Landroid/graphics/Rect;>;"
    const/16 v21, 0x0

    .line 2377
    .local v21, "sR":I
    const/16 v25, 0x0

    .line 2378
    .local v25, "x":I
    const/16 v26, 0x0

    .line 2379
    .local v26, "y":I
    const/16 v23, 0x0

    .line 2380
    .local v23, "w":I
    const/4 v9, 0x0

    .line 2383
    .local v9, "h":I
    const/4 v10, 0x1

    .local v10, "i":I
    :goto_2
    const/16 v2, 0xf

    if-gt v10, v2, :cond_0

    .line 2385
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    invoke-virtual {v2, v10}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v20

    check-cast v20, Lcom/uplynk/media/CaptionEvent$CaptionRow;

    .line 2386
    .local v20, "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    if-eqz v20, :cond_4

    .line 2388
    if-nez v21, :cond_2

    .line 2390
    move/from16 v21, v10

    .line 2391
    invoke-virtual/range {v19 .. v19}, Ljava/util/Vector;->clear()V

    .line 2394
    :cond_2
    invoke-virtual/range {v20 .. v20}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getColumn()I

    move-result v2

    invoke-virtual/range {v20 .. v20}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getIndent()I

    move-result v3

    add-int/2addr v2, v3

    int-to-float v2, v2

    mul-float v3, v8, p2

    mul-float/2addr v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I
    invoke-static {v3}, Lcom/uplynk/media/CaptionManager;->access$9(Lcom/uplynk/media/CaptionManager;)I

    move-result v3

    int-to-float v3, v3

    add-float/2addr v2, v3

    float-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-int v0, v2

    move/from16 v25, v0

    .line 2395
    add-int/lit8 v2, v10, -0x1

    int-to-float v2, v2

    mul-float v2, v2, v18

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I
    invoke-static {v3}, Lcom/uplynk/media/CaptionManager;->access$6(Lcom/uplynk/media/CaptionManager;)I

    move-result v3

    int-to-float v3, v3

    add-float/2addr v2, v3

    move/from16 v0, v22

    int-to-float v3, v0

    add-float/2addr v2, v3

    float-to-int v0, v2

    move/from16 v26, v0

    .line 2396
    if-eqz v16, :cond_3

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    invoke-virtual {v2, v10}, Landroid/util/SparseIntArray;->get(I)I

    move-result v2

    int-to-float v2, v2

    sub-float v2, v2, v18

    float-to-int v0, v2

    move/from16 v26, v0

    .line 2397
    :cond_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual/range {v20 .. v20}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v2

    move-object/from16 v0, p0

    iget v3, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    mul-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    add-float/2addr v2, v3

    float-to-int v0, v2

    move/from16 v23, v0

    .line 2398
    move/from16 v0, v18

    float-to-int v9, v0

    .line 2400
    new-instance v2, Landroid/graphics/Rect;

    add-int v3, v25, v23

    add-int v4, v26, v9

    move/from16 v0, v25

    move/from16 v1, v26

    invoke-direct {v2, v0, v1, v3, v4}, Landroid/graphics/Rect;-><init>(IIII)V

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 2403
    :cond_4
    if-eqz v20, :cond_5

    const/16 v2, 0xf

    if-ne v10, v2, :cond_8

    :cond_5
    if-eqz v21, :cond_8

    .line 2405
    const/16 v14, 0x270f

    .line 2406
    .local v14, "minL":I
    const/16 v15, 0x270f

    .line 2407
    .local v15, "minT":I
    const/4 v13, 0x0

    .line 2408
    .local v13, "maxR":I
    const/4 v12, 0x0

    .line 2410
    .local v12, "maxB":I
    if-eqz v19, :cond_7

    invoke-virtual/range {v19 .. v19}, Ljava/util/Vector;->size()I

    move-result v2

    if-lez v2, :cond_7

    .line 2412
    invoke-virtual/range {v19 .. v19}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .line 2413
    .local v11, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/graphics/Rect;>;"
    :cond_6
    :goto_3
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_a

    .line 2421
    int-to-float v2, v14

    sub-float v3, v2, v24

    int-to-float v2, v15

    sub-float v4, v2, v24

    int-to-float v2, v13

    add-float v5, v2, v24

    int-to-float v2, v12

    add-float v6, v2, v24

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_windowPaint:Landroid/graphics/Paint;

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 2424
    .end local v11    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/graphics/Rect;>;"
    :cond_7
    const/16 v21, 0x0

    .line 2425
    invoke-virtual/range {v19 .. v19}, Ljava/util/Vector;->clear()V

    .line 2383
    .end local v12    # "maxB":I
    .end local v13    # "maxR":I
    .end local v14    # "minL":I
    .end local v15    # "minT":I
    :cond_8
    add-int/lit8 v10, v10, 0x1

    goto/16 :goto_2

    .line 2366
    .end local v9    # "h":I
    .end local v10    # "i":I
    .end local v16    # "oversized":Z
    .end local v19    # "rects":Ljava/util/Vector;, "Ljava/util/Vector<Landroid/graphics/Rect;>;"
    .end local v20    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    .end local v21    # "sR":I
    .end local v23    # "w":I
    .end local v25    # "x":I
    .end local v26    # "y":I
    :cond_9
    const/16 v16, 0x1

    goto/16 :goto_1

    .line 2415
    .restart local v9    # "h":I
    .restart local v10    # "i":I
    .restart local v11    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/graphics/Rect;>;"
    .restart local v12    # "maxB":I
    .restart local v13    # "maxR":I
    .restart local v14    # "minL":I
    .restart local v15    # "minT":I
    .restart local v16    # "oversized":Z
    .restart local v19    # "rects":Ljava/util/Vector;, "Ljava/util/Vector<Landroid/graphics/Rect;>;"
    .restart local v20    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    .restart local v21    # "sR":I
    .restart local v23    # "w":I
    .restart local v25    # "x":I
    .restart local v26    # "y":I
    :cond_a
    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Landroid/graphics/Rect;

    .line 2416
    .local v17, "r":Landroid/graphics/Rect;
    move-object/from16 v0, v17

    iget v2, v0, Landroid/graphics/Rect;->left:I

    if-ge v2, v14, :cond_b

    move-object/from16 v0, v17

    iget v14, v0, Landroid/graphics/Rect;->left:I

    .line 2417
    :cond_b
    move-object/from16 v0, v17

    iget v2, v0, Landroid/graphics/Rect;->top:I

    if-ge v2, v15, :cond_c

    move-object/from16 v0, v17

    iget v15, v0, Landroid/graphics/Rect;->top:I

    .line 2418
    :cond_c
    move-object/from16 v0, v17

    iget v2, v0, Landroid/graphics/Rect;->right:I

    if-le v2, v13, :cond_d

    move-object/from16 v0, v17

    iget v13, v0, Landroid/graphics/Rect;->right:I

    .line 2419
    :cond_d
    move-object/from16 v0, v17

    iget v2, v0, Landroid/graphics/Rect;->bottom:I

    if-le v2, v12, :cond_6

    move-object/from16 v0, v17

    iget v12, v0, Landroid/graphics/Rect;->bottom:I

    goto :goto_3

    .line 2429
    .end local v9    # "h":I
    .end local v10    # "i":I
    .end local v11    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/graphics/Rect;>;"
    .end local v12    # "maxB":I
    .end local v13    # "maxR":I
    .end local v14    # "minL":I
    .end local v15    # "minT":I
    .end local v17    # "r":Landroid/graphics/Rect;
    .end local v19    # "rects":Ljava/util/Vector;, "Ljava/util/Vector<Landroid/graphics/Rect;>;"
    .end local v20    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    .end local v21    # "sR":I
    .end local v23    # "w":I
    .end local v25    # "x":I
    .end local v26    # "y":I
    :cond_e
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v3, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v2, v3, :cond_0

    move-object/from16 v0, p0

    iget-short v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    if-lez v2, :cond_0

    .line 2431
    const/high16 v2, 0x41200000    # 10.0f

    mul-float v3, v8, p2

    mul-float/2addr v2, v3

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I
    invoke-static {v3}, Lcom/uplynk/media/CaptionManager;->access$9(Lcom/uplynk/media/CaptionManager;)I

    move-result v3

    int-to-float v3, v3

    add-float v25, v2, v3

    .line 2432
    .local v25, "x":F
    if-eqz v16, :cond_f

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    move-object/from16 v0, p0

    iget-short v3, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    add-int/lit8 v3, v3, -0x1

    rsub-int/lit8 v3, v3, 0xe

    invoke-virtual {v2, v3}, Landroid/util/SparseIntArray;->get(I)I

    move-result v2

    int-to-float v2, v2

    sub-float v26, v2, v18

    .line 2433
    .local v26, "y":F
    :goto_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    const-string v3, "W"

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v2

    const/high16 v3, 0x42000000    # 32.0f

    mul-float/2addr v2, v3

    move-object/from16 v0, p0

    iget v3, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    mul-int/lit8 v3, v3, 0x2

    int-to-float v3, v3

    add-float v23, v2, v3

    .line 2434
    .local v23, "w":F
    sub-float v3, v25, v24

    sub-float v4, v26, v24

    add-float v2, v25, v23

    add-float v5, v2, v24

    move-object/from16 v0, p0

    iget-short v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    int-to-float v2, v2

    mul-float v2, v2, v18

    add-float v2, v2, v26

    add-float v6, v2, v24

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_windowPaint:Landroid/graphics/Paint;

    move-object/from16 v2, p1

    invoke-virtual/range {v2 .. v7}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    goto/16 :goto_0

    .line 2432
    .end local v23    # "w":F
    .end local v26    # "y":F
    :cond_f
    move-object/from16 v0, p0

    iget-short v2, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    rsub-int/lit8 v2, v2, 0xe

    int-to-float v2, v2

    mul-float v2, v2, v18

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I
    invoke-static {v3}, Lcom/uplynk/media/CaptionManager;->access$6(Lcom/uplynk/media/CaptionManager;)I

    move-result v3

    int-to-float v3, v3

    add-float/2addr v2, v3

    move/from16 v0, v22

    int-to-float v3, v0

    add-float v26, v2, v3

    goto :goto_4
.end method

.method private reverseColorsWithAlpha(II)I
    .locals 3
    .param p1, "color"    # I
    .param p2, "alpha"    # I

    .prologue
    .line 1922
    const v1, 0xffffff

    or-int v2, p1, p2

    sub-int/2addr v1, v2

    and-int v2, p1, p2

    or-int v0, v1, v2

    .line 1923
    .local v0, "ret":I
    return v0
.end method


# virtual methods
.method protected clear(Z)V
    .locals 4
    .param p1, "immediate"    # Z

    .prologue
    const/4 v1, 0x1

    .line 2270
    if-eqz p1, :cond_1

    .line 2273
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager$OverlayHandler;->hasMessages(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2274
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

    invoke-virtual {v0, v1}, Lcom/uplynk/media/CaptionManager$OverlayHandler;->removeMessages(I)V

    .line 2276
    :cond_0
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;
    invoke-static {v0}, Lcom/uplynk/media/CaptionManager;->access$2(Lcom/uplynk/media/CaptionManager;)Lcom/uplynk/media/CaptionManager$OverlayView;

    move-result-object v0

    sget-object v1, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iput-object v1, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 2277
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_overlayView:Lcom/uplynk/media/CaptionManager$OverlayView;
    invoke-static {v0}, Lcom/uplynk/media/CaptionManager;->access$2(Lcom/uplynk/media/CaptionManager;)Lcom/uplynk/media/CaptionManager$OverlayView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/uplynk/media/CaptionManager$OverlayView;->invalidate()V

    .line 2278
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_hasContent:Z

    .line 2282
    :goto_0
    return-void

    .line 2281
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

    const-wide/16 v2, 0x7d0

    invoke-virtual {v0, v1, v2, v3}, Lcom/uplynk/media/CaptionManager$OverlayHandler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0
.end method

.method protected hasContent()Z
    .locals 1

    .prologue
    .line 1918
    iget-boolean v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_hasContent:Z

    return v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 39
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 2442
    invoke-super/range {p0 .. p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 2444
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v4, v4, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    const/16 v5, 0x96

    if-eq v4, v5, :cond_6

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v4, v4, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    const/16 v5, 0xc8

    if-eq v4, v5, :cond_6

    const/16 v26, 0x0

    .line 2446
    .local v26, "oversized":Z
    :goto_0
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowSize:I
    invoke-static {v4}, Lcom/uplynk/media/CaptionManager;->access$5(Lcom/uplynk/media/CaptionManager;)I

    move-result v4

    int-to-float v0, v4

    move/from16 v27, v0

    .line 2447
    .local v27, "rH":F
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccColSize:I
    invoke-static {v4}, Lcom/uplynk/media/CaptionManager;->access$8(Lcom/uplynk/media/CaptionManager;)I

    move-result v4

    int-to-float v0, v4

    move/from16 v18, v0

    .line 2449
    .local v18, "cW":F
    const/high16 v17, 0x3f800000    # 1.0f

    .line 2451
    .local v17, "cScale":F
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v4, v4, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    sparse-switch v4, :sswitch_data_0

    .line 2455
    const/high16 v17, 0x3f800000    # 1.0f

    .line 2460
    :goto_1
    const/high16 v4, 0x41200000    # 10.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v4, v5

    float-to-int v0, v4

    move/from16 v35, v0

    .line 2463
    .local v35, "vpad":I
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v17

    invoke-direct {v0, v1, v2}, Lcom/uplynk/media/CaptionManager$OverlayView;->drawWindow(Landroid/graphics/Canvas;F)V

    .line 2467
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v5, Lcom/uplynk/media/CaptionEvent$CaptionMode;->POP_ON:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v4, v5, :cond_9

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    if-eqz v4, :cond_9

    .line 2469
    const/16 v21, 0x0

    .local v21, "i":I
    :goto_2
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    invoke-virtual {v4}, Landroid/util/SparseArray;->size()I

    move-result v4

    move/from16 v0, v21

    if-lt v0, v4, :cond_7

    .line 2497
    const/4 v4, 0x1

    move-object/from16 v0, p0

    iput-boolean v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_hasContent:Z

    .line 2552
    .end local v21    # "i":I
    :cond_0
    :goto_3
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    if-eqz v4, :cond_5

    .line 2554
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    invoke-virtual {v4}, Ljava/util/Vector;->size()I

    move-result v29

    .line 2555
    .local v29, "rowCount":I
    const/4 v4, 0x3

    move/from16 v0, v29

    if-le v0, v4, :cond_1

    const/16 v29, 0x3

    .line 2556
    :cond_1
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewRow:I

    add-int v4, v4, v29

    add-int/lit8 v4, v4, -0x1

    const/16 v5, 0xf

    if-le v4, v5, :cond_2

    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewRow:I

    rsub-int/lit8 v4, v4, 0xf

    add-int/lit8 v29, v4, 0x1

    .line 2558
    :cond_2
    const/high16 v4, 0x40800000    # 4.0f

    move-object/from16 v0, p0

    iget v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float v38, v4, v5

    .line 2559
    .local v38, "winMargin":F
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewColumn:I

    int-to-float v4, v4

    mul-float v5, v18, v17

    mul-float/2addr v4, v5

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager;->access$9(Lcom/uplynk/media/CaptionManager;)I

    move-result v5

    int-to-float v5, v5

    add-float v36, v4, v5

    .line 2560
    .local v36, "wX":F
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewRow:I

    add-int/lit8 v4, v4, -0x1

    int-to-float v4, v4

    mul-float v4, v4, v27

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager;->access$6(Lcom/uplynk/media/CaptionManager;)I

    move-result v5

    int-to-float v5, v5

    add-float/2addr v4, v5

    move/from16 v0, v35

    int-to-float v5, v0

    add-float v37, v4, v5

    .line 2561
    .local v37, "wY":F
    if-eqz v26, :cond_3

    .line 2563
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v4, v4, Lcom/uplynk/media/CaptionStyle;->_textSize:I

    const/16 v5, 0x96

    if-ne v4, v5, :cond_e

    const/16 v20, 0x3

    .line 2565
    .local v20, "groupSize":I
    :goto_4
    const/16 v25, 0x0

    .line 2566
    .local v25, "offset":I
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewRow:I

    const/4 v5, 0x5

    if-ge v4, v5, :cond_f

    .line 2567
    const/16 v25, 0x1

    .line 2573
    :goto_5
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowSize:I
    invoke-static {v4}, Lcom/uplynk/media/CaptionManager;->access$5(Lcom/uplynk/media/CaptionManager;)I

    move-result v4

    mul-int v4, v4, v25

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager;->access$6(Lcom/uplynk/media/CaptionManager;)I

    move-result v5

    add-int/2addr v4, v5

    mul-int/lit8 v5, v35, 0x2

    add-int/2addr v4, v5

    int-to-float v0, v4

    move/from16 v37, v0

    .line 2577
    .end local v20    # "groupSize":I
    .end local v25    # "offset":I
    :cond_3
    const/16 v24, 0x0

    .line 2578
    .local v24, "maxW":F
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    invoke-virtual {v4}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v23

    .local v23, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_4
    :goto_6
    invoke-interface/range {v23 .. v23}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_11

    .line 2585
    sub-float v11, v36, v38

    sub-float v12, v37, v38

    add-float v4, v36, v24

    add-float v4, v4, v38

    move-object/from16 v0, p0

    iget v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    mul-int/lit8 v5, v5, 0x2

    int-to-float v5, v5

    add-float v13, v4, v5

    move/from16 v0, v29

    int-to-float v4, v0

    mul-float v4, v4, v27

    add-float v4, v4, v37

    add-float v14, v4, v38

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_windowPaint:Landroid/graphics/Paint;

    move-object/from16 v10, p1

    invoke-virtual/range {v10 .. v15}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 2588
    const/16 v21, 0x0

    .restart local v21    # "i":I
    :goto_7
    move/from16 v0, v21

    move/from16 v1, v29

    if-lt v0, v1, :cond_12

    .line 2609
    const/4 v4, 0x1

    move-object/from16 v0, p0

    iput-boolean v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_hasContent:Z

    .line 2611
    .end local v21    # "i":I
    .end local v23    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v24    # "maxW":F
    .end local v29    # "rowCount":I
    .end local v36    # "wX":F
    .end local v37    # "wY":F
    .end local v38    # "winMargin":F
    :cond_5
    return-void

    .line 2444
    .end local v17    # "cScale":F
    .end local v18    # "cW":F
    .end local v26    # "oversized":Z
    .end local v27    # "rH":F
    .end local v35    # "vpad":I
    :cond_6
    const/16 v26, 0x1

    goto/16 :goto_0

    .line 2453
    .restart local v17    # "cScale":F
    .restart local v18    # "cW":F
    .restart local v26    # "oversized":Z
    .restart local v27    # "rH":F
    :sswitch_0
    const/high16 v17, 0x3f400000    # 0.75f

    goto/16 :goto_1

    .line 2454
    :sswitch_1
    const v17, 0x3ecccccd    # 0.4f

    goto/16 :goto_1

    .line 2471
    .restart local v21    # "i":I
    .restart local v35    # "vpad":I
    :cond_7
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    move/from16 v0, v21

    invoke-virtual {v4, v0}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v28

    check-cast v28, Lcom/uplynk/media/CaptionEvent$CaptionRow;

    .line 2474
    .local v28, "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual/range {v28 .. v28}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v31

    .line 2475
    .local v31, "tW":F
    const/high16 v4, -0x40800000    # -1.0f

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual {v5}, Landroid/graphics/Paint;->ascent()F

    move-result v5

    mul-float v30, v4, v5

    .line 2477
    .local v30, "tA":F
    invoke-virtual/range {v28 .. v28}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getColumn()I

    move-result v4

    invoke-virtual/range {v28 .. v28}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getIndent()I

    move-result v5

    add-int/2addr v4, v5

    int-to-float v4, v4

    mul-float v5, v18, v17

    mul-float/2addr v4, v5

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager;->access$9(Lcom/uplynk/media/CaptionManager;)I

    move-result v5

    int-to-float v5, v5

    add-float v6, v4, v5

    .line 2479
    .local v6, "x":F
    const/4 v9, 0x0

    .line 2480
    .local v9, "y":F
    if-eqz v26, :cond_8

    .line 2481
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    invoke-virtual/range {v28 .. v28}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getRow()I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/util/SparseIntArray;->get(I)I

    move-result v4

    int-to-float v9, v4

    .line 2488
    :goto_8
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    int-to-float v4, v4

    add-float v32, v6, v4

    .line 2489
    .local v32, "tX":F
    sub-float v4, v9, v27

    add-float v4, v4, v30

    move-object/from16 v0, p0

    iget v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget v7, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    div-float/2addr v5, v7

    add-float v33, v4, v5

    .line 2492
    .local v33, "tY":F
    sub-float v7, v9, v27

    add-float v4, v6, v31

    move-object/from16 v0, p0

    iget v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    mul-int/lit8 v5, v5, 0x2

    int-to-float v5, v5

    add-float v8, v4, v5

    move-object/from16 v4, p0

    move-object/from16 v5, p1

    invoke-direct/range {v4 .. v9}, Lcom/uplynk/media/CaptionManager$OverlayView;->drawRowBackground(Landroid/graphics/Canvas;FFFF)V

    .line 2495
    invoke-virtual/range {v28 .. v28}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getCharacters()Ljava/util/Vector;

    move-result-object v4

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v32

    move/from16 v3, v33

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/uplynk/media/CaptionManager$OverlayView;->drawRowText(Landroid/graphics/Canvas;FFLjava/util/Vector;)V

    .line 2469
    add-int/lit8 v21, v21, 0x1

    goto/16 :goto_2

    .line 2483
    .end local v32    # "tX":F
    .end local v33    # "tY":F
    :cond_8
    invoke-virtual/range {v28 .. v28}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getRow()I

    move-result v4

    int-to-float v4, v4

    mul-float v4, v4, v27

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager;->access$6(Lcom/uplynk/media/CaptionManager;)I

    move-result v5

    int-to-float v5, v5

    add-float/2addr v4, v5

    move/from16 v0, v35

    int-to-float v5, v0

    add-float v9, v4, v5

    goto :goto_8

    .line 2499
    .end local v6    # "x":F
    .end local v9    # "y":F
    .end local v21    # "i":I
    .end local v28    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    .end local v30    # "tA":F
    .end local v31    # "tW":F
    :cond_9
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v5, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v4, v5, :cond_0

    .line 2503
    move-object/from16 v0, p0

    iget-short v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    rsub-int/lit8 v4, v4, 0xe

    add-int/lit8 v21, v4, 0x1

    .restart local v21    # "i":I
    :goto_9
    const/16 v4, 0xe

    move/from16 v0, v21

    if-le v0, v4, :cond_a

    .line 2547
    const/4 v4, 0x1

    move-object/from16 v0, p0

    iput-boolean v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_hasContent:Z

    goto/16 :goto_3

    .line 2505
    :cond_a
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    move/from16 v0, v21

    invoke-virtual {v4, v0}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v28

    check-cast v28, Lcom/uplynk/media/CaptionEvent$CaptionRow;

    .line 2506
    .restart local v28    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    if-eqz v28, :cond_b

    .line 2510
    invoke-virtual/range {v28 .. v28}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getCharacters()Ljava/util/Vector;

    move-result-object v19

    .line 2511
    .local v19, "chars":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    invoke-virtual/range {v19 .. v19}, Ljava/util/Vector;->size()I

    move-result v4

    if-lez v4, :cond_b

    .line 2514
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_lineBuff:Ljava/lang/StringBuffer;

    const/4 v5, 0x0

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_lineBuff:Ljava/lang/StringBuffer;

    invoke-virtual {v7}, Ljava/lang/StringBuffer;->length()I

    move-result v7

    invoke-virtual {v4, v5, v7}, Ljava/lang/StringBuffer;->delete(II)Ljava/lang/StringBuffer;

    .line 2517
    invoke-virtual/range {v19 .. v19}, Ljava/util/Vector;->iterator()Ljava/util/Iterator;

    move-result-object v22

    .line 2518
    .local v22, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    :goto_a
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_c

    .line 2526
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_lineBuff:Ljava/lang/StringBuffer;

    invoke-virtual {v5}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v31

    .line 2527
    .restart local v31    # "tW":F
    const/high16 v4, -0x40800000    # -1.0f

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual {v5}, Landroid/graphics/Paint;->ascent()F

    move-result v5

    mul-float v30, v4, v5

    .line 2529
    .restart local v30    # "tA":F
    const/high16 v4, 0x41200000    # 10.0f

    mul-float v5, v18, v17

    mul-float/2addr v4, v5

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager;->access$9(Lcom/uplynk/media/CaptionManager;)I

    move-result v5

    int-to-float v5, v5

    add-float v6, v4, v5

    .line 2530
    .restart local v6    # "x":F
    const/4 v9, 0x0

    .line 2531
    .restart local v9    # "y":F
    if-eqz v26, :cond_d

    .line 2532
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowY:Landroid/util/SparseIntArray;

    move/from16 v0, v21

    invoke-virtual {v4, v0}, Landroid/util/SparseIntArray;->get(I)I

    move-result v4

    int-to-float v9, v4

    .line 2536
    :goto_b
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    int-to-float v4, v4

    add-float v32, v6, v4

    .line 2537
    .restart local v32    # "tX":F
    sub-float v4, v9, v27

    add-float v4, v4, v30

    move-object/from16 v0, p0

    iget v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget v7, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    div-float/2addr v5, v7

    add-float v33, v4, v5

    .line 2540
    .restart local v33    # "tY":F
    sub-float v7, v9, v27

    add-float v4, v6, v31

    move-object/from16 v0, p0

    iget v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    mul-int/lit8 v5, v5, 0x2

    int-to-float v5, v5

    add-float v8, v4, v5

    move-object/from16 v4, p0

    move-object/from16 v5, p1

    invoke-direct/range {v4 .. v9}, Lcom/uplynk/media/CaptionManager$OverlayView;->drawRowBackground(Landroid/graphics/Canvas;FFFF)V

    .line 2543
    invoke-virtual/range {v28 .. v28}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getCharacters()Ljava/util/Vector;

    move-result-object v4

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v32

    move/from16 v3, v33

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/uplynk/media/CaptionManager$OverlayView;->drawRowText(Landroid/graphics/Canvas;FFLjava/util/Vector;)V

    .line 2503
    .end local v6    # "x":F
    .end local v9    # "y":F
    .end local v19    # "chars":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    .end local v22    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    .end local v30    # "tA":F
    .end local v31    # "tW":F
    .end local v32    # "tX":F
    .end local v33    # "tY":F
    :cond_b
    add-int/lit8 v21, v21, 0x1

    goto/16 :goto_9

    .line 2520
    .restart local v19    # "chars":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    .restart local v22    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    :cond_c
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

    .line 2521
    .local v16, "c":Lcom/uplynk/media/CaptionEvent$CaptionCharacter;
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_lineBuff:Ljava/lang/StringBuffer;

    invoke-virtual/range {v16 .. v16}, Lcom/uplynk/media/CaptionEvent$CaptionCharacter;->character()C

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuffer;->append(C)Ljava/lang/StringBuffer;

    goto/16 :goto_a

    .line 2534
    .end local v16    # "c":Lcom/uplynk/media/CaptionEvent$CaptionCharacter;
    .restart local v6    # "x":F
    .restart local v9    # "y":F
    .restart local v30    # "tA":F
    .restart local v31    # "tW":F
    :cond_d
    move/from16 v0, v21

    int-to-float v4, v0

    mul-float v4, v4, v27

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager;->access$6(Lcom/uplynk/media/CaptionManager;)I

    move-result v5

    int-to-float v5, v5

    add-float/2addr v4, v5

    move/from16 v0, v35

    int-to-float v5, v0

    add-float v9, v4, v5

    goto :goto_b

    .line 2563
    .end local v6    # "x":F
    .end local v9    # "y":F
    .end local v19    # "chars":Ljava/util/Vector;, "Ljava/util/Vector<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    .end local v21    # "i":I
    .end local v22    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/uplynk/media/CaptionEvent$CaptionCharacter;>;"
    .end local v28    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    .end local v30    # "tA":F
    .end local v31    # "tW":F
    .restart local v29    # "rowCount":I
    .restart local v36    # "wX":F
    .restart local v37    # "wY":F
    .restart local v38    # "winMargin":F
    :cond_e
    const/16 v20, 0x2

    goto/16 :goto_4

    .line 2568
    .restart local v20    # "groupSize":I
    .restart local v25    # "offset":I
    :cond_f
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewRow:I

    const/16 v5, 0xa

    if-ge v4, v5, :cond_10

    .line 2569
    mul-int/lit8 v25, v20, 0x2

    goto/16 :goto_5

    .line 2571
    :cond_10
    mul-int/lit8 v25, v20, 0x3

    goto/16 :goto_5

    .line 2580
    .end local v20    # "groupSize":I
    .end local v25    # "offset":I
    .restart local v23    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .restart local v24    # "maxW":F
    :cond_11
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-interface/range {v23 .. v23}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v4}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v34

    .line 2581
    .local v34, "val":F
    cmpl-float v4, v34, v24

    if-lez v4, :cond_4

    move/from16 v24, v34

    goto/16 :goto_6

    .line 2590
    .end local v34    # "val":F
    .restart local v21    # "i":I
    :cond_12
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    move/from16 v0, v21

    invoke-virtual {v4, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v4}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v31

    .line 2591
    .restart local v31    # "tW":F
    const/high16 v4, -0x40800000    # -1.0f

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual {v5}, Landroid/graphics/Paint;->ascent()F

    move-result v5

    mul-float v30, v4, v5

    .line 2593
    .restart local v30    # "tA":F
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewColumn:I

    int-to-float v4, v4

    mul-float v5, v18, v17

    mul-float/2addr v4, v5

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccColOffsetX:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager;->access$9(Lcom/uplynk/media/CaptionManager;)I

    move-result v5

    int-to-float v5, v5

    add-float v6, v4, v5

    .line 2594
    .restart local v6    # "x":F
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewRow:I

    add-int v4, v4, v21

    int-to-float v4, v4

    mul-float v4, v4, v27

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->this$0:Lcom/uplynk/media/CaptionManager;

    # getter for: Lcom/uplynk/media/CaptionManager;->_ccRowOffsetY:I
    invoke-static {v5}, Lcom/uplynk/media/CaptionManager;->access$6(Lcom/uplynk/media/CaptionManager;)I

    move-result v5

    int-to-float v5, v5

    add-float/2addr v4, v5

    move/from16 v0, v35

    int-to-float v5, v0

    add-float v9, v4, v5

    .line 2595
    .restart local v9    # "y":F
    if-eqz v26, :cond_13

    add-int/lit8 v4, v21, 0x1

    int-to-float v4, v4

    mul-float v4, v4, v27

    add-float v9, v37, v4

    .line 2600
    :cond_13
    move-object/from16 v0, p0

    iget v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    int-to-float v4, v4

    add-float v32, v6, v4

    .line 2601
    .restart local v32    # "tX":F
    sub-float v4, v9, v27

    add-float v4, v4, v30

    move-object/from16 v0, p0

    iget v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    int-to-float v5, v5

    move-object/from16 v0, p0

    iget v7, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    div-float/2addr v5, v7

    add-float v33, v4, v5

    .line 2604
    .restart local v33    # "tY":F
    sub-float v7, v9, v27

    add-float v4, v6, v31

    move-object/from16 v0, p0

    iget v5, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    mul-int/lit8 v5, v5, 0x2

    int-to-float v5, v5

    add-float v8, v4, v5

    move-object/from16 v4, p0

    move-object/from16 v5, p1

    invoke-direct/range {v4 .. v9}, Lcom/uplynk/media/CaptionManager$OverlayView;->drawRowBackground(Landroid/graphics/Canvas;FFFF)V

    .line 2607
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    move/from16 v0, v21

    invoke-virtual {v4, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move/from16 v2, v32

    move/from16 v3, v33

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/uplynk/media/CaptionManager$OverlayView;->drawRowText(Landroid/graphics/Canvas;FFLjava/lang/String;)V

    .line 2588
    add-int/lit8 v21, v21, 0x1

    goto/16 :goto_7

    .line 2451
    :sswitch_data_0
    .sparse-switch
        0x96 -> :sswitch_0
        0xc8 -> :sswitch_1
    .end sparse-switch
.end method

.method protected onSizeChanged(IIII)V
    .locals 5
    .param p1, "w"    # I
    .param p2, "h"    # I
    .param p3, "oldw"    # I
    .param p4, "oldh"    # I

    .prologue
    .line 2662
    const-string v0, "upLynkCaptionOverlay"

    const-string v1, "View Size Changed: %dx%d -> %dx%d"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x3

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2663
    invoke-super {p0, p1, p2, p3, p4}, Landroid/view/View;->onSizeChanged(IIII)V

    .line 2664
    return-void
.end method

.method protected renderCaptionEvent(Lcom/uplynk/media/CaptionEvent;)V
    .locals 9
    .param p1, "event"    # Lcom/uplynk/media/CaptionEvent;

    .prologue
    const/4 v8, 0x1

    const/16 v7, 0xe

    .line 2190
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

    invoke-virtual {v5, v8}, Lcom/uplynk/media/CaptionManager$OverlayHandler;->removeMessages(I)V

    .line 2192
    const/4 v2, 0x0

    .line 2194
    .local v2, "needsConfig":Z
    iget-object v5, p1, Lcom/uplynk/media/CaptionEvent;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    sget-object v6, Lcom/uplynk/media/CaptionEvent$CaptionMode;->ROLL_UP:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v5, v6, :cond_b

    .line 2196
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iget-object v6, p1, Lcom/uplynk/media/CaptionEvent;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-eq v5, v6, :cond_0

    .line 2199
    new-instance v5, Landroid/util/SparseArray;

    invoke-direct {v5, v7}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    .line 2203
    :cond_0
    iget-short v5, p1, Lcom/uplynk/media/CaptionEvent;->rowCount:S

    iput-short v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    .line 2205
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iget-object v6, p1, Lcom/uplynk/media/CaptionEvent;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    if-ne v5, v6, :cond_1

    iget-short v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    iget-short v6, p1, Lcom/uplynk/media/CaptionEvent;->rowCount:S

    if-eq v5, v6, :cond_2

    .line 2206
    :cond_1
    const/4 v2, 0x1

    .line 2208
    :cond_2
    iget-object v5, p1, Lcom/uplynk/media/CaptionEvent;->eventType:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    sget-object v6, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->LINEBREAK:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    if-ne v5, v6, :cond_9

    .line 2211
    const/4 v1, 0x1

    .local v1, "i":I
    iget-short v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    rsub-int/lit8 v5, v5, 0xe

    add-int/lit8 v0, v5, 0x1

    .local v0, "count":I
    :goto_0
    if-le v1, v0, :cond_5

    .line 2220
    iget-short v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rowCount:S

    rsub-int/lit8 v5, v5, 0xe

    add-int/lit8 v1, v5, 0x1

    :goto_1
    if-le v1, v7, :cond_7

    .line 2250
    .end local v0    # "count":I
    .end local v1    # "i":I
    :cond_3
    :goto_2
    iget-object v5, p1, Lcom/uplynk/media/CaptionEvent;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iput-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 2252
    if-eqz v2, :cond_4

    .line 2253
    invoke-direct {p0}, Lcom/uplynk/media/CaptionManager$OverlayView;->configureOversizedRowPositions()V

    .line 2255
    :cond_4
    invoke-virtual {p0}, Lcom/uplynk/media/CaptionManager$OverlayView;->postInvalidate()V

    .line 2257
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_handler:Lcom/uplynk/media/CaptionManager$OverlayHandler;

    const-wide/16 v6, 0xfa0

    invoke-virtual {v5, v8, v6, v7}, Lcom/uplynk/media/CaptionManager$OverlayHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 2258
    return-void

    .line 2213
    .restart local v0    # "count":I
    .restart local v1    # "i":I
    :cond_5
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_6

    .line 2216
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->delete(I)V

    .line 2211
    :cond_6
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 2222
    :cond_7
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/uplynk/media/CaptionEvent$CaptionRow;

    .line 2223
    .local v3, "r":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    if-eqz v3, :cond_8

    .line 2225
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    add-int/lit8 v6, v1, -0x1

    invoke-virtual {v5, v6, v3}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 2226
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->delete(I)V

    .line 2220
    :cond_8
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 2231
    .end local v0    # "count":I
    .end local v1    # "i":I
    .end local v3    # "r":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    :cond_9
    iget-object v5, p1, Lcom/uplynk/media/CaptionEvent;->eventType:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    sget-object v6, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    if-ne v5, v6, :cond_3

    .line 2233
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    invoke-virtual {v5, v7}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/uplynk/media/CaptionEvent$CaptionRow;

    .line 2234
    .local v4, "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    if-nez v4, :cond_a

    .line 2236
    new-instance v4, Lcom/uplynk/media/CaptionEvent$CaptionRow;

    .end local v4    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    invoke-direct {v4, p1}, Lcom/uplynk/media/CaptionEvent$CaptionRow;-><init>(Lcom/uplynk/media/CaptionEvent;)V

    .line 2239
    .restart local v4    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    :cond_a
    invoke-virtual {v4}, Lcom/uplynk/media/CaptionEvent$CaptionRow;->getCharacters()Ljava/util/Vector;

    move-result-object v5

    iget-object v6, p1, Lcom/uplynk/media/CaptionEvent;->character:Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

    invoke-virtual {v5, v6}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 2240
    iget-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    invoke-virtual {v5, v7, v4}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    goto :goto_2

    .line 2246
    .end local v4    # "row":Lcom/uplynk/media/CaptionEvent$CaptionRow;
    :cond_b
    iget-object v5, p1, Lcom/uplynk/media/CaptionEvent;->rows:Landroid/util/SparseArray;

    iput-object v5, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_rows:Landroid/util/SparseArray;

    .line 2247
    const/4 v2, 0x1

    goto :goto_2
.end method

.method protected setFontMetrics(FFI)V
    .locals 2
    .param p1, "density"    # F
    .param p2, "textSize"    # F
    .param p3, "textPadding"    # I

    .prologue
    .line 2038
    iput p1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    .line 2039
    iput p2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textSize:F

    .line 2040
    int-to-float v0, p3

    mul-float/2addr v0, p1

    invoke-static {v0}, Ljava/lang/Math;->round(F)I

    move-result v0

    iput v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPadding:I

    .line 2043
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    if-eqz v0, :cond_0

    .line 2044
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    mul-float v1, p2, p1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 2046
    :cond_0
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    if-eqz v0, :cond_1

    .line 2047
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    mul-float v1, p2, p1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 2049
    :cond_1
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    if-eqz v0, :cond_2

    .line 2050
    iget-object v0, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    mul-float v1, p2, p1

    invoke-virtual {v0, v1}, Landroid/graphics/Paint;->setTextSize(F)V

    .line 2051
    :cond_2
    return-void
.end method

.method protected setPreviewText(IILjava/lang/String;)V
    .locals 8
    .param p1, "row"    # I
    .param p2, "column"    # I
    .param p3, "text"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x7

    const/4 v3, 0x5

    const/16 v2, 0x20

    const/4 v6, 0x1

    .line 2055
    monitor-enter p0

    .line 2057
    if-nez p3, :cond_2

    .line 2059
    :try_start_0
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    if-eqz v2, :cond_0

    .line 2060
    iget-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->clear()V

    .line 2061
    :cond_0
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    .line 2062
    const/4 v2, 0x7

    iput v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewRow:I

    .line 2063
    const/4 v2, 0x5

    iput v2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewColumn:I

    .line 2055
    .end local p1    # "row":I
    .end local p2    # "column":I
    :cond_1
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2081
    invoke-virtual {p0}, Lcom/uplynk/media/CaptionManager$OverlayView;->invalidate()V

    .line 2082
    return-void

    .line 2067
    .restart local p1    # "row":I
    .restart local p2    # "column":I
    :cond_2
    if-lt p1, v6, :cond_3

    const/16 v5, 0xf

    if-gt p1, v5, :cond_3

    .end local p1    # "row":I
    :goto_0
    :try_start_1
    iput p1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewRow:I

    .line 2068
    if-lt p2, v6, :cond_4

    if-gt p2, v2, :cond_4

    .end local p2    # "column":I
    :goto_1
    iput p2, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewColumn:I

    .line 2069
    new-instance v3, Ljava/util/Vector;

    invoke-direct {v3}, Ljava/util/Vector;-><init>()V

    iput-object v3, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    .line 2071
    :goto_2
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_1

    .line 2073
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v3

    if-le v3, v2, :cond_5

    move v0, v2

    .line 2074
    .local v0, "len":I
    :goto_3
    const/4 v3, 0x0

    invoke-virtual {p3, v3, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 2075
    .local v1, "tmp":Ljava/lang/String;
    const-string v3, "upLynkCaptionOverlay"

    const-string v4, "Caption Preview {%d} %s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    aput-object v1, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 2076
    iget-object v3, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_previewText:Ljava/util/Vector;

    invoke-virtual {v3, v1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 2077
    invoke-virtual {p3, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object p3

    goto :goto_2

    .end local v0    # "len":I
    .end local v1    # "tmp":Ljava/lang/String;
    .restart local p1    # "row":I
    .restart local p2    # "column":I
    :cond_3
    move p1, v4

    .line 2067
    goto :goto_0

    .end local p1    # "row":I
    :cond_4
    move p2, v3

    .line 2068
    goto :goto_1

    .line 2073
    .end local p2    # "column":I
    :cond_5
    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v0

    goto :goto_3

    .line 2055
    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method

.method protected setStyle(Lcom/uplynk/media/CaptionStyle;)V
    .locals 5
    .param p1, "styles"    # Lcom/uplynk/media/CaptionStyle;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 1943
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    .line 1945
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    .line 1946
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual {v1, v3}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 1947
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual {p1}, Lcom/uplynk/media/CaptionStyle;->getTextColor()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 1948
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textPaint:Landroid/graphics/Paint;

    invoke-virtual {p1}, Lcom/uplynk/media/CaptionStyle;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 1950
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textDebugPaint:Landroid/graphics/Paint;

    .line 1951
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textDebugPaint:Landroid/graphics/Paint;

    const/high16 v2, -0x10000

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 1953
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_backgroundPaint:Landroid/graphics/Paint;

    .line 1954
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_backgroundPaint:Landroid/graphics/Paint;

    invoke-virtual {p1}, Lcom/uplynk/media/CaptionStyle;->getBackgroundColor()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 1956
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_windowPaint:Landroid/graphics/Paint;

    .line 1957
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_windowPaint:Landroid/graphics/Paint;

    invoke-virtual {p1}, Lcom/uplynk/media/CaptionStyle;->getWindowColor()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 1959
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v1, v1, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    if-nez v1, :cond_1

    .line 1961
    iput-object v4, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    .line 1962
    iput-object v4, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    .line 2034
    :cond_0
    :goto_0
    return-void

    .line 1966
    :cond_1
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    .line 1967
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    invoke-virtual {v1, v3}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 1968
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    invoke-virtual {p1}, Lcom/uplynk/media/CaptionStyle;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 1970
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    .line 1971
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    invoke-virtual {v1, v3}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 1972
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    invoke-virtual {p1}, Lcom/uplynk/media/CaptionStyle;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setTypeface(Landroid/graphics/Typeface;)Landroid/graphics/Typeface;

    .line 1974
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v1, v1, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    if-ne v1, v3, :cond_2

    .line 1976
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    const/high16 v2, 0x55000000

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    goto :goto_0

    .line 1981
    :cond_2
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v1, v1, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_3

    .line 2005
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    const v2, 0x66222222

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    goto :goto_0

    .line 2011
    :cond_3
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v1, v1, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_4

    .line 2013
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    const v2, -0x44000001

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    .line 2014
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect2Paint:Landroid/graphics/Paint;

    const v2, -0x66ddddde

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setColor(I)V

    goto :goto_0

    .line 2022
    :cond_4
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_style:Lcom/uplynk/media/CaptionStyle;

    iget v1, v1, Lcom/uplynk/media/CaptionStyle;->_edgeType:I

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    .line 2026
    invoke-virtual {p1}, Lcom/uplynk/media/CaptionStyle;->getTextColor()I

    move-result v1

    const/16 v2, 0xff

    invoke-direct {p0, v1, v2}, Lcom/uplynk/media/CaptionManager$OverlayView;->complimentShadeWithAlpha(II)I

    move-result v0

    .line 2028
    .local v0, "color":I
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    invoke-virtual {v1, v0}, Landroid/graphics/Paint;->setColor(I)V

    .line 2030
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    const/high16 v2, 0x40000000    # 2.0f

    iget v3, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_density:F

    mul-float/2addr v2, v3

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 2031
    iget-object v1, p0, Lcom/uplynk/media/CaptionManager$OverlayView;->_textEffect1Paint:Landroid/graphics/Paint;

    sget-object v2, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v1, v2}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    goto/16 :goto_0
.end method
