.class final Lcom/google/analytics/tracking/android/ah;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/analytics/tracking/android/ae;


# direct methods
.method constructor <init>(Lcom/google/analytics/tracking/android/ae;)V
    .locals 0

    .prologue
    .line 269
    iput-object p1, p0, Lcom/google/analytics/tracking/android/ah;->a:Lcom/google/analytics/tracking/android/ae;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/google/analytics/tracking/android/ah;->a:Lcom/google/analytics/tracking/android/ae;

    invoke-static {v0}, Lcom/google/analytics/tracking/android/ae;->f(Lcom/google/analytics/tracking/android/ae;)Lcom/google/analytics/tracking/android/aw;

    move-result-object v0

    invoke-interface {v0}, Lcom/google/analytics/tracking/android/aw;->d()V

    .line 273
    return-void
.end method
