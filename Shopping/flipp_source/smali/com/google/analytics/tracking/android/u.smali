.class final Lcom/google/analytics/tracking/android/u;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/Handler$Callback;


# instance fields
.field final synthetic a:Lcom/google/analytics/tracking/android/s;


# direct methods
.method constructor <init>(Lcom/google/analytics/tracking/android/s;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/google/analytics/tracking/android/u;->a:Lcom/google/analytics/tracking/android/s;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)Z
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 109
    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v4, v0, :cond_0

    invoke-static {}, Lcom/google/analytics/tracking/android/s;->e()Ljava/lang/Object;

    move-result-object v0

    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v0

    invoke-virtual {v0, v4}, Lcom/google/analytics/tracking/android/ai;->a(Z)V

    .line 111
    iget-object v0, p0, Lcom/google/analytics/tracking/android/u;->a:Lcom/google/analytics/tracking/android/s;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/s;->c()V

    .line 112
    invoke-static {}, Lcom/google/analytics/tracking/android/ai;->a()Lcom/google/analytics/tracking/android/ai;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/analytics/tracking/android/ai;->a(Z)V

    .line 113
    iget-object v0, p0, Lcom/google/analytics/tracking/android/u;->a:Lcom/google/analytics/tracking/android/s;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/s;->b(Lcom/google/analytics/tracking/android/s;)I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/google/analytics/tracking/android/u;->a:Lcom/google/analytics/tracking/android/s;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/s;->c(Lcom/google/analytics/tracking/android/s;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/google/analytics/tracking/android/u;->a:Lcom/google/analytics/tracking/android/s;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/s;->d(Lcom/google/analytics/tracking/android/s;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/google/analytics/tracking/android/u;->a:Lcom/google/analytics/tracking/android/s;

    invoke-static {v1}, Lcom/google/analytics/tracking/android/s;->d(Lcom/google/analytics/tracking/android/s;)Landroid/os/Handler;

    move-result-object v1

    invoke-static {}, Lcom/google/analytics/tracking/android/s;->e()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v4, v2}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    iget-object v2, p0, Lcom/google/analytics/tracking/android/u;->a:Lcom/google/analytics/tracking/android/s;

    invoke-static {v2}, Lcom/google/analytics/tracking/android/s;->b(Lcom/google/analytics/tracking/android/s;)I

    move-result v2

    mul-int/lit16 v2, v2, 0x3e8

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 119
    :cond_0
    return v4
.end method
