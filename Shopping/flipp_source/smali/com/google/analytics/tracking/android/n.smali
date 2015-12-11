.class final Lcom/google/analytics/tracking/android/n;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/analytics/tracking/android/ao;


# instance fields
.field private a:Lcom/google/analytics/tracking/android/ap;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    sget-object v0, Lcom/google/analytics/tracking/android/ap;->b:Lcom/google/analytics/tracking/android/ap;

    iput-object v0, p0, Lcom/google/analytics/tracking/android/n;->a:Lcom/google/analytics/tracking/android/ap;

    .line 21
    return-void
.end method

.method private static e(Ljava/lang/String;)Ljava/lang/String;
    .locals 2

    .prologue
    .line 69
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ": "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public final a()Lcom/google/analytics/tracking/android/ap;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/google/analytics/tracking/android/n;->a:Lcom/google/analytics/tracking/android/ap;

    return-object v0
.end method

.method public final a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 25
    iget-object v0, p0, Lcom/google/analytics/tracking/android/n;->a:Lcom/google/analytics/tracking/android/ap;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/ap;->ordinal()I

    move-result v0

    sget-object v1, Lcom/google/analytics/tracking/android/ap;->a:Lcom/google/analytics/tracking/android/ap;

    invoke-virtual {v1}, Lcom/google/analytics/tracking/android/ap;->ordinal()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 26
    const-string v0, "GAV3"

    invoke-static {p1}, Lcom/google/analytics/tracking/android/n;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 28
    :cond_0
    return-void
.end method

.method public final b(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 32
    iget-object v0, p0, Lcom/google/analytics/tracking/android/n;->a:Lcom/google/analytics/tracking/android/ap;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/ap;->ordinal()I

    move-result v0

    sget-object v1, Lcom/google/analytics/tracking/android/ap;->b:Lcom/google/analytics/tracking/android/ap;

    invoke-virtual {v1}, Lcom/google/analytics/tracking/android/ap;->ordinal()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 33
    const-string v0, "GAV3"

    invoke-static {p1}, Lcom/google/analytics/tracking/android/n;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 35
    :cond_0
    return-void
.end method

.method public final c(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 39
    iget-object v0, p0, Lcom/google/analytics/tracking/android/n;->a:Lcom/google/analytics/tracking/android/ap;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/ap;->ordinal()I

    move-result v0

    sget-object v1, Lcom/google/analytics/tracking/android/ap;->c:Lcom/google/analytics/tracking/android/ap;

    invoke-virtual {v1}, Lcom/google/analytics/tracking/android/ap;->ordinal()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 40
    const-string v0, "GAV3"

    invoke-static {p1}, Lcom/google/analytics/tracking/android/n;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 42
    :cond_0
    return-void
.end method

.method public final d(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Lcom/google/analytics/tracking/android/n;->a:Lcom/google/analytics/tracking/android/ap;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/ap;->ordinal()I

    move-result v0

    sget-object v1, Lcom/google/analytics/tracking/android/ap;->d:Lcom/google/analytics/tracking/android/ap;

    invoke-virtual {v1}, Lcom/google/analytics/tracking/android/ap;->ordinal()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 47
    const-string v0, "GAV3"

    invoke-static {p1}, Lcom/google/analytics/tracking/android/n;->e(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    :cond_0
    return-void
.end method
