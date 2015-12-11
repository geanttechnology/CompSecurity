.class public Lcom/poshmark/utils/CustomLinkMovementMethod;
.super Landroid/text/method/ScrollingMovementMethod;
.source "CustomLinkMovementMethod.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/utils/CustomLinkMovementMethod$TextClickedListener;
    }
.end annotation


# static fields
.field private static final CLICK:I = 0x1

.field private static final DOWN:I = 0x3

.field private static FROM_BELOW:Ljava/lang/Object; = null

.field private static final UP:I = 0x2

.field private static sInstance:Lcom/poshmark/utils/CustomLinkMovementMethod;


# instance fields
.field listener:Lcom/poshmark/utils/CustomLinkMovementMethod$TextClickedListener;

.field private tappedOnNonLinkText:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 271
    new-instance v0, Landroid/text/NoCopySpan$Concrete;

    invoke-direct {v0}, Landroid/text/NoCopySpan$Concrete;-><init>()V

    sput-object v0, Lcom/poshmark/utils/CustomLinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Landroid/text/method/ScrollingMovementMethod;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/utils/CustomLinkMovementMethod;->tappedOnNonLinkText:Z

    .line 30
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/utils/CustomLinkMovementMethod;->listener:Lcom/poshmark/utils/CustomLinkMovementMethod$TextClickedListener;

    return-void
.end method

.method private action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z
    .locals 26
    .param p1, "what"    # I
    .param p2, "widget"    # Landroid/widget/TextView;
    .param p3, "buffer"    # Landroid/text/Spannable;

    .prologue
    .line 89
    const/4 v13, 0x0

    .line 91
    .local v13, "handled":Z
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v16

    .line 93
    .local v16, "layout":Landroid/text/Layout;
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getTotalPaddingTop()I

    move-result v24

    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getTotalPaddingBottom()I

    move-result v25

    add-int v20, v24, v25

    .line 95
    .local v20, "padding":I
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getScrollY()I

    move-result v6

    .line 96
    .local v6, "areatop":I
    invoke-virtual/range {p2 .. p2}, Landroid/widget/TextView;->getHeight()I

    move-result v24

    add-int v24, v24, v6

    sub-int v5, v24, v20

    .line 98
    .local v5, "areabot":I
    move-object/from16 v0, v16

    invoke-virtual {v0, v6}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v18

    .line 99
    .local v18, "linetop":I
    move-object/from16 v0, v16

    invoke-virtual {v0, v5}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v17

    .line 101
    .local v17, "linebot":I
    move-object/from16 v0, v16

    move/from16 v1, v18

    invoke-virtual {v0, v1}, Landroid/text/Layout;->getLineStart(I)I

    move-result v12

    .line 102
    .local v12, "first":I
    invoke-virtual/range {v16 .. v17}, Landroid/text/Layout;->getLineEnd(I)I

    move-result v15

    .line 104
    .local v15, "last":I
    const-class v24, Landroid/text/style/ClickableSpan;

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-interface {v0, v12, v15, v1}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v10

    check-cast v10, [Landroid/text/style/ClickableSpan;

    .line 106
    .local v10, "candidates":[Landroid/text/style/ClickableSpan;
    invoke-static/range {p3 .. p3}, Landroid/text/Selection;->getSelectionStart(Ljava/lang/CharSequence;)I

    move-result v4

    .line 107
    .local v4, "a":I
    invoke-static/range {p3 .. p3}, Landroid/text/Selection;->getSelectionEnd(Ljava/lang/CharSequence;)I

    move-result v7

    .line 109
    .local v7, "b":I
    invoke-static {v4, v7}, Ljava/lang/Math;->min(II)I

    move-result v22

    .line 110
    .local v22, "selStart":I
    invoke-static {v4, v7}, Ljava/lang/Math;->max(II)I

    move-result v21

    .line 112
    .local v21, "selEnd":I
    if-gez v22, :cond_0

    .line 113
    sget-object v24, Lcom/poshmark/utils/CustomLinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v24

    if-ltz v24, :cond_0

    .line 114
    invoke-interface/range {p3 .. p3}, Landroid/text/Spannable;->length()I

    move-result v21

    move/from16 v22, v21

    .line 118
    :cond_0
    move/from16 v0, v22

    if-le v0, v15, :cond_1

    .line 119
    const v21, 0x7fffffff

    move/from16 v22, v21

    .line 120
    :cond_1
    move/from16 v0, v21

    if-ge v0, v12, :cond_2

    .line 121
    const/16 v21, -0x1

    move/from16 v22, v21

    .line 123
    :cond_2
    packed-switch p1, :pswitch_data_0

    .line 184
    :cond_3
    :goto_0
    const/16 v24, 0x0

    :goto_1
    return v24

    .line 125
    :pswitch_0
    move/from16 v0, v22

    move/from16 v1, v21

    if-ne v0, v1, :cond_4

    .line 126
    const/16 v24, 0x0

    goto :goto_1

    .line 129
    :cond_4
    const-class v24, Landroid/text/style/ClickableSpan;

    move-object/from16 v0, p3

    move/from16 v1, v22

    move/from16 v2, v21

    move-object/from16 v3, v24

    invoke-interface {v0, v1, v2, v3}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v19

    check-cast v19, [Landroid/text/style/ClickableSpan;

    .line 131
    .local v19, "link":[Landroid/text/style/ClickableSpan;
    move-object/from16 v0, v19

    array-length v0, v0

    move/from16 v24, v0

    const/16 v25, 0x1

    move/from16 v0, v24

    move/from16 v1, v25

    if-eq v0, v1, :cond_5

    .line 132
    const/16 v24, 0x0

    goto :goto_1

    .line 134
    :cond_5
    const/16 v24, 0x0

    aget-object v24, v19, v24

    move-object/from16 v0, v24

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Landroid/text/style/ClickableSpan;->onClick(Landroid/view/View;)V

    goto :goto_0

    .line 140
    .end local v19    # "link":[Landroid/text/style/ClickableSpan;
    :pswitch_1
    const/4 v9, -0x1

    .line 141
    .local v9, "beststart":I
    const/4 v8, -0x1

    .line 143
    .local v8, "bestend":I
    const/4 v14, 0x0

    .local v14, "i":I
    :goto_2
    array-length v0, v10

    move/from16 v24, v0

    move/from16 v0, v24

    if-ge v14, v0, :cond_8

    .line 144
    aget-object v24, v10, v14

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v11

    .line 146
    .local v11, "end":I
    move/from16 v0, v21

    if-lt v11, v0, :cond_6

    move/from16 v0, v22

    move/from16 v1, v21

    if-ne v0, v1, :cond_7

    .line 147
    :cond_6
    if-le v11, v8, :cond_7

    .line 148
    aget-object v24, v10, v14

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v9

    .line 149
    move v8, v11

    .line 143
    :cond_7
    add-int/lit8 v14, v14, 0x1

    goto :goto_2

    .line 154
    .end local v11    # "end":I
    :cond_8
    if-ltz v9, :cond_3

    .line 155
    move-object/from16 v0, p3

    invoke-static {v0, v8, v9}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;II)V

    .line 156
    const/16 v24, 0x1

    goto :goto_1

    .line 162
    .end local v8    # "bestend":I
    .end local v9    # "beststart":I
    .end local v14    # "i":I
    :pswitch_2
    const v9, 0x7fffffff

    .line 163
    .restart local v9    # "beststart":I
    const v8, 0x7fffffff

    .line 165
    .restart local v8    # "bestend":I
    const/4 v14, 0x0

    .restart local v14    # "i":I
    :goto_3
    array-length v0, v10

    move/from16 v24, v0

    move/from16 v0, v24

    if-ge v14, v0, :cond_b

    .line 166
    aget-object v24, v10, v14

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v23

    .line 168
    .local v23, "start":I
    move/from16 v0, v23

    move/from16 v1, v22

    if-gt v0, v1, :cond_9

    move/from16 v0, v22

    move/from16 v1, v21

    if-ne v0, v1, :cond_a

    .line 169
    :cond_9
    move/from16 v0, v23

    if-ge v0, v9, :cond_a

    .line 170
    move/from16 v9, v23

    .line 171
    aget-object v24, v10, v14

    move-object/from16 v0, p3

    move-object/from16 v1, v24

    invoke-interface {v0, v1}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v8

    .line 165
    :cond_a
    add-int/lit8 v14, v14, 0x1

    goto :goto_3

    .line 176
    .end local v23    # "start":I
    :cond_b
    const v24, 0x7fffffff

    move/from16 v0, v24

    if-ge v8, v0, :cond_3

    .line 177
    move-object/from16 v0, p3

    invoke-static {v0, v9, v8}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;II)V

    .line 178
    const/16 v24, 0x1

    goto/16 :goto_1

    .line 123
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static getInstance()Landroid/text/method/MovementMethod;
    .locals 1

    .prologue
    .line 260
    sget-object v0, Lcom/poshmark/utils/CustomLinkMovementMethod;->sInstance:Lcom/poshmark/utils/CustomLinkMovementMethod;

    if-nez v0, :cond_0

    .line 261
    new-instance v0, Lcom/poshmark/utils/CustomLinkMovementMethod;

    invoke-direct {v0}, Lcom/poshmark/utils/CustomLinkMovementMethod;-><init>()V

    sput-object v0, Lcom/poshmark/utils/CustomLinkMovementMethod;->sInstance:Lcom/poshmark/utils/CustomLinkMovementMethod;

    .line 263
    :cond_0
    sget-object v0, Lcom/poshmark/utils/CustomLinkMovementMethod;->sInstance:Lcom/poshmark/utils/CustomLinkMovementMethod;

    return-object v0
.end method


# virtual methods
.method public didUserTapOnNonLinkSpan()Z
    .locals 1

    .prologue
    .line 267
    iget-boolean v0, p0, Lcom/poshmark/utils/CustomLinkMovementMethod;->tappedOnNonLinkText:Z

    return v0
.end method

.method protected down(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .locals 1
    .param p1, "widget"    # Landroid/widget/TextView;
    .param p2, "buffer"    # Landroid/text/Spannable;

    .prologue
    .line 63
    const/4 v0, 0x3

    invoke-direct {p0, v0, p1, p2}, Lcom/poshmark/utils/CustomLinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    const/4 v0, 0x1

    .line 67
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->down(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_0
.end method

.method public initialize(Landroid/widget/TextView;Landroid/text/Spannable;)V
    .locals 1
    .param p1, "widget"    # Landroid/widget/TextView;
    .param p2, "text"    # Landroid/text/Spannable;

    .prologue
    .line 245
    invoke-static {p2}, Landroid/text/Selection;->removeSelection(Landroid/text/Spannable;)V

    .line 246
    sget-object v0, Lcom/poshmark/utils/CustomLinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    invoke-interface {p2, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    .line 247
    return-void
.end method

.method protected left(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .locals 1
    .param p1, "widget"    # Landroid/widget/TextView;
    .param p2, "buffer"    # Landroid/text/Spannable;

    .prologue
    .line 72
    const/4 v0, 0x2

    invoke-direct {p0, v0, p1, p2}, Lcom/poshmark/utils/CustomLinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    const/4 v0, 0x1

    .line 76
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->left(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_0
.end method

.method public onKeyDown(Landroid/widget/TextView;Landroid/text/Spannable;ILandroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "widget"    # Landroid/widget/TextView;
    .param p2, "buffer"    # Landroid/text/Spannable;
    .param p3, "keyCode"    # I
    .param p4, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x1

    .line 39
    sparse-switch p3, :sswitch_data_0

    .line 49
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Landroid/text/method/ScrollingMovementMethod;->onKeyDown(Landroid/widget/TextView;Landroid/text/Spannable;ILandroid/view/KeyEvent;)Z

    move-result v0

    :goto_0
    return v0

    .line 42
    :sswitch_0
    invoke-virtual {p4}, Landroid/view/KeyEvent;->getRepeatCount()I

    move-result v1

    if-nez v1, :cond_0

    .line 43
    invoke-direct {p0, v0, p1, p2}, Lcom/poshmark/utils/CustomLinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v1

    if-eqz v1, :cond_0

    goto :goto_0

    .line 39
    :sswitch_data_0
    .sparse-switch
        0x17 -> :sswitch_0
        0x42 -> :sswitch_0
    .end sparse-switch
.end method

.method public onKeyUp(Landroid/widget/TextView;Landroid/text/Spannable;ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "widget"    # Landroid/widget/TextView;
    .param p2, "buffer"    # Landroid/text/Spannable;
    .param p3, "keyCode"    # I
    .param p4, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 189
    const/4 v0, 0x0

    return v0
.end method

.method public onTakeFocus(Landroid/widget/TextView;Landroid/text/Spannable;I)V
    .locals 3
    .param p1, "view"    # Landroid/widget/TextView;
    .param p2, "text"    # Landroid/text/Spannable;
    .param p3, "dir"    # I

    .prologue
    const/4 v2, 0x0

    .line 250
    invoke-static {p2}, Landroid/text/Selection;->removeSelection(Landroid/text/Spannable;)V

    .line 252
    and-int/lit8 v0, p3, 0x1

    if-eqz v0, :cond_0

    .line 253
    sget-object v0, Lcom/poshmark/utils/CustomLinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    const/16 v1, 0x22

    invoke-interface {p2, v0, v2, v2, v1}, Landroid/text/Spannable;->setSpan(Ljava/lang/Object;III)V

    .line 257
    :goto_0
    return-void

    .line 255
    :cond_0
    sget-object v0, Lcom/poshmark/utils/CustomLinkMovementMethod;->FROM_BELOW:Ljava/lang/Object;

    invoke-interface {p2, v0}, Landroid/text/Spannable;->removeSpan(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/widget/TextView;Landroid/text/Spannable;Landroid/view/MotionEvent;)Z
    .locals 10
    .param p1, "widget"    # Landroid/widget/TextView;
    .param p2, "buffer"    # Landroid/text/Spannable;
    .param p3, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 195
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 197
    .local v0, "action":I
    if-nez v0, :cond_0

    .line 198
    iput-boolean v7, p0, Lcom/poshmark/utils/CustomLinkMovementMethod;->tappedOnNonLinkText:Z

    .line 200
    :cond_0
    if-eq v0, v8, :cond_1

    if-nez v0, :cond_3

    .line 202
    :cond_1
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    float-to-int v5, v9

    .line 203
    .local v5, "x":I
    invoke-virtual {p3}, Landroid/view/MotionEvent;->getY()F

    move-result v9

    float-to-int v6, v9

    .line 205
    .local v6, "y":I
    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingLeft()I

    move-result v9

    sub-int/2addr v5, v9

    .line 206
    invoke-virtual {p1}, Landroid/widget/TextView;->getTotalPaddingTop()I

    move-result v9

    sub-int/2addr v6, v9

    .line 208
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollX()I

    move-result v9

    add-int/2addr v5, v9

    .line 209
    invoke-virtual {p1}, Landroid/widget/TextView;->getScrollY()I

    move-result v9

    add-int/2addr v6, v9

    .line 211
    invoke-virtual {p1}, Landroid/widget/TextView;->getLayout()Landroid/text/Layout;

    move-result-object v1

    .line 212
    .local v1, "layout":Landroid/text/Layout;
    invoke-virtual {v1, v6}, Landroid/text/Layout;->getLineForVertical(I)I

    move-result v2

    .line 213
    .local v2, "line":I
    int-to-float v9, v5

    invoke-virtual {v1, v2, v9}, Landroid/text/Layout;->getOffsetForHorizontal(IF)I

    move-result v4

    .line 215
    .local v4, "off":I
    const-class v9, Landroid/text/style/ClickableSpan;

    invoke-interface {p2, v4, v4, v9}, Landroid/text/Spannable;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v3

    check-cast v3, [Landroid/text/style/ClickableSpan;

    .line 217
    .local v3, "link":[Landroid/text/style/ClickableSpan;
    array-length v9, v3

    if-eqz v9, :cond_5

    .line 218
    if-ne v0, v8, :cond_4

    .line 219
    aget-object v7, v3, v7

    invoke-virtual {v7, p1}, Landroid/text/style/ClickableSpan;->onClick(Landroid/view/View;)V

    :cond_2
    :goto_0
    move v7, v8

    .line 239
    .end local v1    # "layout":Landroid/text/Layout;
    .end local v2    # "line":I
    .end local v3    # "link":[Landroid/text/style/ClickableSpan;
    .end local v4    # "off":I
    .end local v5    # "x":I
    .end local v6    # "y":I
    :cond_3
    :goto_1
    return v7

    .line 220
    .restart local v1    # "layout":Landroid/text/Layout;
    .restart local v2    # "line":I
    .restart local v3    # "link":[Landroid/text/style/ClickableSpan;
    .restart local v4    # "off":I
    .restart local v5    # "x":I
    .restart local v6    # "y":I
    :cond_4
    if-nez v0, :cond_2

    .line 221
    aget-object v9, v3, v7

    invoke-interface {p2, v9}, Landroid/text/Spannable;->getSpanStart(Ljava/lang/Object;)I

    move-result v9

    aget-object v7, v3, v7

    invoke-interface {p2, v7}, Landroid/text/Spannable;->getSpanEnd(Ljava/lang/Object;)I

    move-result v7

    invoke-static {p2, v9, v7}, Landroid/text/Selection;->setSelection(Landroid/text/Spannable;II)V

    goto :goto_0

    .line 228
    :cond_5
    invoke-static {p2}, Landroid/text/Selection;->removeSelection(Landroid/text/Spannable;)V

    .line 229
    iput-boolean v8, p0, Lcom/poshmark/utils/CustomLinkMovementMethod;->tappedOnNonLinkText:Z

    goto :goto_1
.end method

.method protected right(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .locals 1
    .param p1, "widget"    # Landroid/widget/TextView;
    .param p2, "buffer"    # Landroid/text/Spannable;

    .prologue
    .line 81
    const/4 v0, 0x3

    invoke-direct {p0, v0, p1, p2}, Lcom/poshmark/utils/CustomLinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 82
    const/4 v0, 0x1

    .line 85
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->right(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_0
.end method

.method public setOnTextClickListener(Lcom/poshmark/utils/CustomLinkMovementMethod$TextClickedListener;)V
    .locals 0
    .param p1, "listen"    # Lcom/poshmark/utils/CustomLinkMovementMethod$TextClickedListener;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/poshmark/utils/CustomLinkMovementMethod;->listener:Lcom/poshmark/utils/CustomLinkMovementMethod$TextClickedListener;

    .line 34
    return-void
.end method

.method protected up(Landroid/widget/TextView;Landroid/text/Spannable;)Z
    .locals 1
    .param p1, "widget"    # Landroid/widget/TextView;
    .param p2, "buffer"    # Landroid/text/Spannable;

    .prologue
    .line 54
    const/4 v0, 0x2

    invoke-direct {p0, v0, p1, p2}, Lcom/poshmark/utils/CustomLinkMovementMethod;->action(ILandroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    const/4 v0, 0x1

    .line 58
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/text/method/ScrollingMovementMethod;->up(Landroid/widget/TextView;Landroid/text/Spannable;)Z

    move-result v0

    goto :goto_0
.end method
