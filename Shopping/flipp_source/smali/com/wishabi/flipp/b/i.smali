.class final Lcom/wishabi/flipp/b/i;
.super Ljava/util/TimerTask;
.source "SourceFile"


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/wishabi/flipp/b/a;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/a;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 395
    iput-object p1, p0, Lcom/wishabi/flipp/b/i;->b:Lcom/wishabi/flipp/b/a;

    iput-object p2, p0, Lcom/wishabi/flipp/b/i;->a:Ljava/lang/String;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 4

    .prologue
    .line 398
    iget-object v0, p0, Lcom/wishabi/flipp/b/i;->b:Lcom/wishabi/flipp/b/a;

    invoke-static {v0}, Lcom/wishabi/flipp/b/a;->j(Lcom/wishabi/flipp/b/a;)Lcom/google/analytics/tracking/android/ay;

    move-result-object v0

    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v1

    sget-object v2, Lcom/google/analytics/tracking/android/aj;->ak:Lcom/google/analytics/tracking/android/aj;

    invoke-virtual {v1, v2}, Lcom/google/analytics/tracking/android/ai;->a(Lcom/google/analytics/tracking/android/aj;)V

    new-instance v1, Lcom/google/analytics/tracking/android/aq;

    invoke-direct {v1}, Lcom/google/analytics/tracking/android/aq;-><init>()V

    const-string v2, "&t"

    const-string v3, "appview"

    invoke-virtual {v1, v2, v3}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    const-string v2, "&cd"

    iget-object v3, p0, Lcom/wishabi/flipp/b/i;->a:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/google/analytics/tracking/android/aq;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/google/analytics/tracking/android/aq;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/analytics/tracking/android/aq;->a()Ljava/util/Map;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/analytics/tracking/android/ay;->a(Ljava/util/Map;)V

    .line 401
    return-void
.end method
