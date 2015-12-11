.class public final Lcom/google/android/gms/internal/cj;
.super Landroid/widget/FrameLayout;

# interfaces
.implements Landroid/media/MediaPlayer$OnCompletionListener;
.implements Landroid/media/MediaPlayer$OnErrorListener;
.implements Landroid/media/MediaPlayer$OnPreparedListener;


# instance fields
.field final a:Lcom/google/android/gms/internal/ew;

.field final b:Landroid/widget/MediaController;

.field final c:Lcom/google/android/gms/internal/ck;

.field final d:Landroid/widget/VideoView;

.field e:J

.field f:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/ew;)V
    .locals 3

    const/4 v2, -0x1

    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object p2, p0, Lcom/google/android/gms/internal/cj;->a:Lcom/google/android/gms/internal/ew;

    new-instance v0, Landroid/widget/VideoView;

    invoke-direct {v0, p1}, Landroid/widget/VideoView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    const/16 v1, 0x11

    invoke-direct {v0, v2, v2, v1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    iget-object v1, p0, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {p0, v1, v0}, Lcom/google/android/gms/internal/cj;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    new-instance v0, Landroid/widget/MediaController;

    invoke-direct {v0, p1}, Landroid/widget/MediaController;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/cj;->b:Landroid/widget/MediaController;

    new-instance v0, Lcom/google/android/gms/internal/ck;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/ck;-><init>(Lcom/google/android/gms/internal/cj;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/cj;->c:Lcom/google/android/gms/internal/ck;

    iget-object v0, p0, Lcom/google/android/gms/internal/cj;->c:Lcom/google/android/gms/internal/ck;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/ck;->a()V

    iget-object v0, p0, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v0, p0}, Landroid/widget/VideoView;->setOnCompletionListener(Landroid/media/MediaPlayer$OnCompletionListener;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v0, p0}, Landroid/widget/VideoView;->setOnPreparedListener(Landroid/media/MediaPlayer$OnPreparedListener;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v0, p0}, Landroid/widget/VideoView;->setOnErrorListener(Landroid/media/MediaPlayer$OnErrorListener;)V

    return-void
.end method

.method public static a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    if-nez p2, :cond_1

    const/4 v0, 0x1

    :goto_0
    new-instance v2, Ljava/util/HashMap;

    if-eqz v0, :cond_2

    const/4 v1, 0x2

    :goto_1
    invoke-direct {v2, v1}, Ljava/util/HashMap;-><init>(I)V

    const-string v1, "what"

    invoke-virtual {v2, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    if-nez v0, :cond_0

    const-string v0, "extra"

    invoke-virtual {v2, v0, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    const-string v0, "error"

    invoke-static {p0, v0, v2}, Lcom/google/android/gms/internal/cj;->a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/util/Map;)V

    return-void

    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :cond_2
    const/4 v1, 0x3

    goto :goto_1
.end method

.method static a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    new-instance v0, Ljava/util/HashMap;

    const/4 v1, 0x2

    invoke-direct {v0, v1}, Ljava/util/HashMap;-><init>(I)V

    invoke-virtual {v0, p2, p3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-static {p0, p1, v0}, Lcom/google/android/gms/internal/cj;->a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method

.method private static a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/util/Map;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/ew;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    const-string v0, "event"

    invoke-interface {p2, v0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "onVideoEvent"

    invoke-virtual {p0, v0, p2}, Lcom/google/android/gms/internal/ew;->a(Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method


# virtual methods
.method public final onCompletion(Landroid/media/MediaPlayer;)V
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/internal/cj;->a:Lcom/google/android/gms/internal/ew;

    const-string v1, "ended"

    new-instance v2, Ljava/util/HashMap;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/HashMap;-><init>(I)V

    invoke-static {v0, v1, v2}, Lcom/google/android/gms/internal/cj;->a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/util/Map;)V

    return-void
.end method

.method public final onError(Landroid/media/MediaPlayer;II)Z
    .locals 3

    iget-object v0, p0, Lcom/google/android/gms/internal/cj;->a:Lcom/google/android/gms/internal/ew;

    invoke-static {p2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {p3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/google/android/gms/internal/cj;->a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x1

    return v0
.end method

.method public final onPrepared(Landroid/media/MediaPlayer;)V
    .locals 4

    iget-object v0, p0, Lcom/google/android/gms/internal/cj;->d:Landroid/widget/VideoView;

    invoke-virtual {v0}, Landroid/widget/VideoView;->getDuration()I

    move-result v0

    int-to-float v0, v0

    const/high16 v1, 0x447a0000    # 1000.0f

    div-float/2addr v0, v1

    iget-object v1, p0, Lcom/google/android/gms/internal/cj;->a:Lcom/google/android/gms/internal/ew;

    const-string v2, "canplaythrough"

    const-string v3, "duration"

    invoke-static {v0}, Ljava/lang/String;->valueOf(F)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v2, v3, v0}, Lcom/google/android/gms/internal/cj;->a(Lcom/google/android/gms/internal/ew;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method
