.class final Lcom/google/analytics/tracking/android/ab;
.super Ljava/util/TimerTask;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/google/analytics/tracking/android/v;


# direct methods
.method private constructor <init>(Lcom/google/analytics/tracking/android/v;)V
    .locals 0

    .prologue
    .line 402
    iput-object p1, p0, Lcom/google/analytics/tracking/android/ab;->a:Lcom/google/analytics/tracking/android/v;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/analytics/tracking/android/v;B)V
    .locals 0

    .prologue
    .line 402
    invoke-direct {p0, p1}, Lcom/google/analytics/tracking/android/ab;-><init>(Lcom/google/analytics/tracking/android/v;)V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 2

    .prologue
    .line 405
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ab;->a:Lcom/google/analytics/tracking/android/v;

    iget v0, v0, Lcom/google/analytics/tracking/android/v;->b:I

    sget v1, Lcom/google/analytics/tracking/android/z;->a:I

    if-ne v0, v1, :cond_0

    .line 406
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ab;->a:Lcom/google/analytics/tracking/android/v;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/v;->g()V

    .line 409
    :cond_0
    return-void
.end method
