.class final Lcom/google/analytics/tracking/android/ad;
.super Ljava/util/TimerTask;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/google/analytics/tracking/android/v;


# direct methods
.method private constructor <init>(Lcom/google/analytics/tracking/android/v;)V
    .locals 0

    .prologue
    .line 412
    iput-object p1, p0, Lcom/google/analytics/tracking/android/ad;->a:Lcom/google/analytics/tracking/android/v;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/analytics/tracking/android/v;B)V
    .locals 0

    .prologue
    .line 412
    invoke-direct {p0, p1}, Lcom/google/analytics/tracking/android/ad;-><init>(Lcom/google/analytics/tracking/android/v;)V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 415
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ad;->a:Lcom/google/analytics/tracking/android/v;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/v;->h()V

    .line 416
    return-void
.end method
