.class public final Lcom/google/android/gms/internal/ah;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/internal/af;


# direct methods
.method public constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static a(Landroid/util/DisplayMetrics;Ljava/util/Map;Ljava/lang/String;I)I
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/util/DisplayMetrics;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "I)I"
        }
    .end annotation

    invoke-interface {p1, p2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-eqz v0, :cond_0

    :try_start_0
    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {p0, v1}, Lcom/google/android/gms/internal/er;->a(Landroid/util/DisplayMetrics;I)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result p3

    :cond_0
    :goto_0
    return p3

    :catch_0
    move-exception v1

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Could not parse "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " in a video GMSG: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public final a(Lcom/google/android/gms/internal/ew;Ljava/util/Map;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/ew;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const/4 v8, -0x1

    const/4 v5, 0x0

    const/4 v4, 0x0

    const-string v0, "action"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-nez v0, :cond_1

    const-string v0, "Action missing from video GMSG."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    invoke-virtual {p1}, Lcom/google/android/gms/internal/ew;->b()Lcom/google/android/gms/internal/cd;

    move-result-object v1

    if-nez v1, :cond_2

    const-string v0, "Could not get ad overlay for a video GMSG."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    const-string v2, "new"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    const-string v3, "position"

    invoke-virtual {v3, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v2, :cond_3

    if-eqz v3, :cond_5

    :cond_3
    invoke-virtual {p1}, Lcom/google/android/gms/internal/ew;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    const-string v3, "x"

    invoke-static {v0, p2, v3, v4}, Lcom/google/android/gms/internal/ah;->a(Landroid/util/DisplayMetrics;Ljava/util/Map;Ljava/lang/String;I)I

    move-result v3

    const-string v5, "y"

    invoke-static {v0, p2, v5, v4}, Lcom/google/android/gms/internal/ah;->a(Landroid/util/DisplayMetrics;Ljava/util/Map;Ljava/lang/String;I)I

    move-result v5

    const-string v6, "w"

    invoke-static {v0, p2, v6, v8}, Lcom/google/android/gms/internal/ah;->a(Landroid/util/DisplayMetrics;Ljava/util/Map;Ljava/lang/String;I)I

    move-result v6

    const-string v7, "h"

    invoke-static {v0, p2, v7, v8}, Lcom/google/android/gms/internal/ah;->a(Landroid/util/DisplayMetrics;Ljava/util/Map;Ljava/lang/String;I)I

    move-result v0

    if-eqz v2, :cond_4

    iget-object v2, v1, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    if-nez v2, :cond_4

    iget-object v2, v1, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    if-nez v2, :cond_0

    new-instance v2, Lcom/google/android/gms/internal/cj;

    iget-object v7, v1, Lcom/google/android/gms/internal/cd;->a:Landroid/app/Activity;

    iget-object v8, v1, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    invoke-direct {v2, v7, v8}, Lcom/google/android/gms/internal/cj;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/ew;)V

    iput-object v2, v1, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    iget-object v2, v1, Lcom/google/android/gms/internal/cd;->g:Landroid/widget/RelativeLayout;

    iget-object v7, v1, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    invoke-static {v3, v5, v6, v0}, Lcom/google/android/gms/internal/cd;->a(IIII)Landroid/widget/RelativeLayout$LayoutParams;

    move-result-object v0

    invoke-virtual {v2, v7, v4, v0}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V

    iget-object v0, v1, Lcom/google/android/gms/internal/cd;->c:Lcom/google/android/gms/internal/ew;

    iget-object v0, v0, Lcom/google/android/gms/internal/ew;->a:Lcom/google/android/gms/internal/ez;

    iput-boolean v4, v0, Lcom/google/android/gms/internal/ez;->h:Z

    goto :goto_0

    :cond_4
    iget-object v2, v1, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    if-eqz v2, :cond_0

    iget-object v1, v1, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    invoke-static {v3, v5, v6, v0}, Lcom/google/android/gms/internal/cd;->a(IIII)Landroid/widget/RelativeLayout$LayoutParams;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/google/android/gms/internal/cj;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    :cond_5
    iget-object v8, v1, Lcom/google/android/gms/internal/cd;->b:Lcom/google/android/gms/internal/cj;

    if-nez v8, :cond_6

    const-string v0, "no_video_view"

    invoke-static {p1, v0, v5}, Lcom/google/android/gms/internal/cj;->a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_6
    const-string v1, "click"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_7

    invoke-virtual {p1}, Lcom/google/android/gms/internal/ew;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    const-string v1, "x"

    invoke-static {v0, p2, v1, v4}, Lcom/google/android/gms/internal/ah;->a(Landroid/util/DisplayMetrics;Ljava/util/Map;Ljava/lang/String;I)I

    move-result v2

    const-string v1, "y"

    invoke-static {v0, p2, v1, v4}, Lcom/google/android/gms/internal/ah;->a(Landroid/util/DisplayMetrics;Ljava/util/Map;Ljava/lang/String;I)I

    move-result v3

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v0

    int-to-float v5, v2

    int-to-float v6, v3

    move-wide v2, v0

    move v7, v4

    invoke-static/range {v0 .. v7}, Landroid/view/MotionEvent;->obtain(JJIFFI)Landroid/view/MotionEvent;

    move-result-object v0

    iget-object v1, v8, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v1, v0}, Landroid/widget/VideoView;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    invoke-virtual {v0}, Landroid/view/MotionEvent;->recycle()V

    goto/16 :goto_0

    :cond_7
    const-string v1, "controls"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_a

    const-string v0, "enabled"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-nez v0, :cond_8

    const-string v0, "Enabled parameter missing from controls video GMSG."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_8
    invoke-static {v0}, Ljava/lang/Boolean;->parseBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    iget-object v0, v8, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    iget-object v1, v8, Lcom/google/android/gms/internal/cj;->b:Landroid/widget/MediaController;

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setMediaController(Landroid/widget/MediaController;)V

    goto/16 :goto_0

    :cond_9
    iget-object v0, v8, Lcom/google/android/gms/internal/cj;->b:Landroid/widget/MediaController;

    invoke-virtual {v0}, Landroid/widget/MediaController;->hide()V

    iget-object v0, v8, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v0, v5}, Landroid/widget/VideoView;->setMediaController(Landroid/widget/MediaController;)V

    goto/16 :goto_0

    :cond_a
    const-string v1, "currentTime"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_c

    const-string v0, "time"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    if-nez v0, :cond_b

    const-string v0, "Time parameter missing from currentTime video GMSG."

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_b
    :try_start_0
    invoke-static {v0}, Ljava/lang/Float;->parseFloat(Ljava/lang/String;)F

    move-result v1

    const/high16 v2, 0x447a0000    # 1000.0f

    mul-float/2addr v1, v2

    float-to-int v1, v1

    iget-object v2, v8, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v2, v1}, Landroid/widget/VideoView;->seekTo(I)V
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    :catch_0
    move-exception v1

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Could not parse time parameter from currentTime video GMSG: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_c
    const-string v1, "hide"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_d

    const/4 v0, 0x4

    invoke-virtual {v8, v0}, Lcom/google/android/gms/internal/cj;->setVisibility(I)V

    goto/16 :goto_0

    :cond_d
    const-string v1, "load"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_f

    iget-object v0, v8, Lcom/google/android/gms/internal/cj;->f:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_e

    iget-object v0, v8, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    iget-object v1, v8, Lcom/google/android/gms/internal/cj;->f:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/VideoView;->setVideoPath(Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_e
    iget-object v0, v8, Lcom/google/android/gms/internal/cj;->a:Lcom/google/android/gms/internal/ew;

    const-string v1, "no_src"

    invoke-static {v0, v1, v5}, Lcom/google/android/gms/internal/cj;->a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_f
    const-string v1, "pause"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_10

    iget-object v0, v8, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->pause()V

    goto/16 :goto_0

    :cond_10
    const-string v1, "play"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_11

    iget-object v0, v8, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->start()V

    goto/16 :goto_0

    :cond_11
    const-string v1, "show"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_12

    invoke-virtual {v8, v4}, Lcom/google/android/gms/internal/cj;->setVisibility(I)V

    goto/16 :goto_0

    :cond_12
    const-string v1, "src"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_13

    const-string v0, "src"

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, v8, Lcom/google/android/gms/internal/cj;->f:Ljava/lang/String;

    goto/16 :goto_0

    :cond_13
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Unknown video action: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/et;->d(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
