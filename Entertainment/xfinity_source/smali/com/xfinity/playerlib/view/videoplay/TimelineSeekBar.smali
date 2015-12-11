.class public Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;
.super Landroid/widget/SeekBar;
.source "TimelineSeekBar.java"


# instance fields
.field private duration:J

.field private highlightMarker:Landroid/graphics/Bitmap;

.field private marker:Landroid/graphics/Bitmap;

.field private playerTimeline:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Landroid/widget/SeekBar;-><init>(Landroid/content/Context;)V

    .line 24
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$drawable;->ad_break:I

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->marker:Landroid/graphics/Bitmap;

    .line 25
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$drawable;->ad_break_light:I

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->highlightMarker:Landroid/graphics/Bitmap;

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Landroid/widget/SeekBar;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 30
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$drawable;->ad_break:I

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->marker:Landroid/graphics/Bitmap;

    .line 31
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$drawable;->ad_break_light:I

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->highlightMarker:Landroid/graphics/Bitmap;

    .line 32
    return-void
.end method


# virtual methods
.method protected declared-synchronized onDraw(Landroid/graphics/Canvas;)V
    .locals 14
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 41
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1}, Landroid/widget/SeekBar;->onDraw(Landroid/graphics/Canvas;)V

    .line 43
    iget-object v7, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->playerTimeline:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    if-eqz v7, :cond_2

    .line 44
    iget-object v7, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->playerTimeline:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    invoke-virtual {v7}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;->timelineMarkers()Ljava/util/Iterator;

    move-result-object v1

    .line 45
    .local v1, "markerIterator":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    .line 46
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;

    .line 47
    .local v2, "next":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    invoke-virtual {v2}, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->getTime()J

    move-result-wide v4

    .line 48
    .local v4, "position":J
    iget-wide v8, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->duration:J

    cmp-long v7, v4, v8

    if-gtz v7, :cond_0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getWidth()I

    move-result v7

    if-lez v7, :cond_0

    .line 49
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getWidth()I

    move-result v7

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getThumbOffset()I

    move-result v8

    mul-int/lit8 v8, v8, 0x2

    sub-int/2addr v7, v8

    int-to-double v8, v7

    long-to-double v10, v4

    iget-wide v12, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->duration:J

    long-to-double v12, v12

    div-double/2addr v10, v12

    mul-double/2addr v8, v10

    .line 51
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getThumbOffset()I

    move-result v7

    int-to-double v10, v7

    add-double/2addr v8, v10

    double-to-int v0, v8

    .line 53
    .local v0, "leftPosition":I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getWidth()I

    move-result v7

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getThumbOffset()I

    move-result v8

    mul-int/lit8 v8, v8, 0x2

    sub-int/2addr v7, v8

    int-to-double v8, v7

    .line 54
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getProgress()I

    move-result v7

    int-to-double v10, v7

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getMax()I

    move-result v7

    int-to-double v12, v7

    div-double/2addr v10, v12

    mul-double/2addr v8, v10

    .line 55
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getThumbOffset()I

    move-result v7

    int-to-double v10, v7

    add-double/2addr v8, v10

    double-to-int v3, v8

    .line 57
    .local v3, "progressPosition":I
    if-le v3, v0, :cond_1

    .line 59
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getHeight()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    iget-object v8, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->highlightMarker:Landroid/graphics/Bitmap;

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    sub-int/2addr v7, v8

    add-int/lit8 v6, v7, -0x1

    .line 60
    .local v6, "topPosition":I
    iget-object v7, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->highlightMarker:Landroid/graphics/Bitmap;

    int-to-float v8, v0

    int-to-float v9, v6

    const/4 v10, 0x0

    invoke-virtual {p1, v7, v8, v9, v10}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 41
    .end local v0    # "leftPosition":I
    .end local v1    # "markerIterator":Ljava/util/Iterator;
    .end local v2    # "next":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    .end local v3    # "progressPosition":I
    .end local v4    # "position":J
    .end local v6    # "topPosition":I
    :catchall_0
    move-exception v7

    monitor-exit p0

    throw v7

    .line 62
    .restart local v0    # "leftPosition":I
    .restart local v1    # "markerIterator":Ljava/util/Iterator;
    .restart local v2    # "next":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    .restart local v3    # "progressPosition":I
    .restart local v4    # "position":J
    :cond_1
    :try_start_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->getHeight()I

    move-result v7

    div-int/lit8 v7, v7, 0x2

    iget-object v8, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->marker:Landroid/graphics/Bitmap;

    invoke-virtual {v8}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v8

    div-int/lit8 v8, v8, 0x2

    sub-int/2addr v7, v8

    add-int/lit8 v6, v7, -0x1

    .line 63
    .restart local v6    # "topPosition":I
    iget-object v7, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->marker:Landroid/graphics/Bitmap;

    int-to-float v8, v0

    int-to-float v9, v6

    const/4 v10, 0x0

    invoke-virtual {p1, v7, v8, v9, v10}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 68
    .end local v0    # "leftPosition":I
    .end local v1    # "markerIterator":Ljava/util/Iterator;
    .end local v2    # "next":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    .end local v3    # "progressPosition":I
    .end local v4    # "position":J
    .end local v6    # "topPosition":I
    :cond_2
    monitor-exit p0

    return-void
.end method

.method public setMarkersAndDuration(Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;J)V
    .locals 0
    .param p1, "playerTimeline"    # Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    .param p2, "duration"    # J

    .prologue
    .line 35
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->playerTimeline:Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    .line 36
    iput-wide p2, p0, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;->duration:J

    .line 37
    return-void
.end method
