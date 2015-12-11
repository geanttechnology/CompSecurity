.class Lcom/aio/downloader/views/TouchImageView$Fling;
.super Ljava/lang/Object;
.source "TouchImageView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/TouchImageView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Fling"
.end annotation


# instance fields
.field currX:I

.field currY:I

.field scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

.field final synthetic this$0:Lcom/aio/downloader/views/TouchImageView;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/TouchImageView;II)V
    .locals 9
    .param p2, "velocityX"    # I
    .param p3, "velocityY"    # I

    .prologue
    .line 1111
    iput-object p1, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->this$0:Lcom/aio/downloader/views/TouchImageView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1112
    sget-object v0, Lcom/aio/downloader/views/TouchImageView$State;->FLING:Lcom/aio/downloader/views/TouchImageView$State;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V
    invoke-static {p1, v0}, Lcom/aio/downloader/views/TouchImageView;->access$10(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$State;)V

    .line 1113
    new-instance v0, Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->context:Landroid/content/Context;
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$24(Lcom/aio/downloader/views/TouchImageView;)Landroid/content/Context;

    move-result-object v3

    invoke-direct {v0, p1, v3}, Lcom/aio/downloader/views/TouchImageView$CompatScroller;-><init>(Lcom/aio/downloader/views/TouchImageView;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    .line 1114
    # getter for: Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$16(Lcom/aio/downloader/views/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v0

    # getter for: Lcom/aio/downloader/views/TouchImageView;->m:[F
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$25(Lcom/aio/downloader/views/TouchImageView;)[F

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/graphics/Matrix;->getValues([F)V

    .line 1116
    # getter for: Lcom/aio/downloader/views/TouchImageView;->m:[F
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$25(Lcom/aio/downloader/views/TouchImageView;)[F

    move-result-object v0

    const/4 v3, 0x2

    aget v0, v0, v3

    float-to-int v1, v0

    .line 1117
    .local v1, "startX":I
    # getter for: Lcom/aio/downloader/views/TouchImageView;->m:[F
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$25(Lcom/aio/downloader/views/TouchImageView;)[F

    move-result-object v0

    const/4 v3, 0x5

    aget v0, v0, v3

    float-to-int v2, v0

    .line 1120
    .local v2, "startY":I
    # invokes: Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$12(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v0

    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewWidth:I
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$11(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v3

    int-to-float v3, v3

    cmpl-float v0, v0, v3

    if-lez v0, :cond_0

    .line 1121
    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewWidth:I
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$11(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v0

    # invokes: Lcom/aio/downloader/views/TouchImageView;->getImageWidth()F
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$12(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v3

    float-to-int v3, v3

    sub-int v5, v0, v3

    .line 1122
    .local v5, "minX":I
    const/4 v6, 0x0

    .line 1128
    .local v6, "maxX":I
    :goto_0
    # invokes: Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$15(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v0

    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewHeight:I
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$14(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v3

    int-to-float v3, v3

    cmpl-float v0, v0, v3

    if-lez v0, :cond_1

    .line 1129
    # getter for: Lcom/aio/downloader/views/TouchImageView;->viewHeight:I
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$14(Lcom/aio/downloader/views/TouchImageView;)I

    move-result v0

    # invokes: Lcom/aio/downloader/views/TouchImageView;->getImageHeight()F
    invoke-static {p1}, Lcom/aio/downloader/views/TouchImageView;->access$15(Lcom/aio/downloader/views/TouchImageView;)F

    move-result v3

    float-to-int v3, v3

    sub-int v7, v0, v3

    .line 1130
    .local v7, "minY":I
    const/4 v8, 0x0

    .line 1136
    .local v8, "maxY":I
    :goto_1
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    move v3, p2

    move v4, p3

    invoke-virtual/range {v0 .. v8}, Lcom/aio/downloader/views/TouchImageView$CompatScroller;->fling(IIIIIIII)V

    .line 1138
    iput v1, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->currX:I

    .line 1139
    iput v2, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->currY:I

    .line 1140
    return-void

    .line 1125
    .end local v5    # "minX":I
    .end local v6    # "maxX":I
    .end local v7    # "minY":I
    .end local v8    # "maxY":I
    :cond_0
    move v6, v1

    .restart local v6    # "maxX":I
    move v5, v1

    .restart local v5    # "minX":I
    goto :goto_0

    .line 1133
    :cond_1
    move v8, v2

    .restart local v8    # "maxY":I
    move v7, v2

    .restart local v7    # "minY":I
    goto :goto_1
.end method


# virtual methods
.method public cancelFling()V
    .locals 2

    .prologue
    .line 1143
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    if-eqz v0, :cond_0

    .line 1144
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->this$0:Lcom/aio/downloader/views/TouchImageView;

    sget-object v1, Lcom/aio/downloader/views/TouchImageView$State;->NONE:Lcom/aio/downloader/views/TouchImageView$State;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->setState(Lcom/aio/downloader/views/TouchImageView$State;)V
    invoke-static {v0, v1}, Lcom/aio/downloader/views/TouchImageView;->access$10(Lcom/aio/downloader/views/TouchImageView;Lcom/aio/downloader/views/TouchImageView$State;)V

    .line 1145
    iget-object v0, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/TouchImageView$CompatScroller;->forceFinished(Z)V

    .line 1147
    :cond_0
    return-void
.end method

.method public run()V
    .locals 7

    .prologue
    .line 1156
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;
    invoke-static {v4}, Lcom/aio/downloader/views/TouchImageView;->access$19(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 1157
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->touchImageViewListener:Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;
    invoke-static {v4}, Lcom/aio/downloader/views/TouchImageView;->access$19(Lcom/aio/downloader/views/TouchImageView;)Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;

    move-result-object v4

    invoke-interface {v4}, Lcom/aio/downloader/views/TouchImageView$OnTouchImageViewListener;->onMove()V

    .line 1160
    :cond_0
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    invoke-virtual {v4}, Lcom/aio/downloader/views/TouchImageView$CompatScroller;->isFinished()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1161
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    .line 1177
    :cond_1
    :goto_0
    return-void

    .line 1165
    :cond_2
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    invoke-virtual {v4}, Lcom/aio/downloader/views/TouchImageView$CompatScroller;->computeScrollOffset()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 1166
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    invoke-virtual {v4}, Lcom/aio/downloader/views/TouchImageView$CompatScroller;->getCurrX()I

    move-result v0

    .line 1167
    .local v0, "newX":I
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->scroller:Lcom/aio/downloader/views/TouchImageView$CompatScroller;

    invoke-virtual {v4}, Lcom/aio/downloader/views/TouchImageView$CompatScroller;->getCurrY()I

    move-result v1

    .line 1168
    .local v1, "newY":I
    iget v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->currX:I

    sub-int v2, v0, v4

    .line 1169
    .local v2, "transX":I
    iget v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->currY:I

    sub-int v3, v1, v4

    .line 1170
    .local v3, "transY":I
    iput v0, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->currX:I

    .line 1171
    iput v1, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->currY:I

    .line 1172
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;
    invoke-static {v4}, Lcom/aio/downloader/views/TouchImageView;->access$16(Lcom/aio/downloader/views/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v4

    int-to-float v5, v2

    int-to-float v6, v3

    invoke-virtual {v4, v5, v6}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 1173
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->fixTrans()V
    invoke-static {v4}, Lcom/aio/downloader/views/TouchImageView;->access$17(Lcom/aio/downloader/views/TouchImageView;)V

    .line 1174
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->this$0:Lcom/aio/downloader/views/TouchImageView;

    iget-object v5, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # getter for: Lcom/aio/downloader/views/TouchImageView;->matrix:Landroid/graphics/Matrix;
    invoke-static {v5}, Lcom/aio/downloader/views/TouchImageView;->access$16(Lcom/aio/downloader/views/TouchImageView;)Landroid/graphics/Matrix;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/aio/downloader/views/TouchImageView;->setImageMatrix(Landroid/graphics/Matrix;)V

    .line 1175
    iget-object v4, p0, Lcom/aio/downloader/views/TouchImageView$Fling;->this$0:Lcom/aio/downloader/views/TouchImageView;

    # invokes: Lcom/aio/downloader/views/TouchImageView;->compatPostOnAnimation(Ljava/lang/Runnable;)V
    invoke-static {v4, p0}, Lcom/aio/downloader/views/TouchImageView;->access$3(Lcom/aio/downloader/views/TouchImageView;Ljava/lang/Runnable;)V

    goto :goto_0
.end method
