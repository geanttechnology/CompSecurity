.class final Lcom/google/analytics/tracking/android/t;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/analytics/tracking/android/g;


# instance fields
.field final synthetic a:Lcom/google/analytics/tracking/android/s;


# direct methods
.method constructor <init>(Lcom/google/analytics/tracking/android/s;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/google/analytics/tracking/android/t;->a:Lcom/google/analytics/tracking/android/s;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a(Z)V
    .locals 2

    .prologue
    .line 60
    iget-object v0, p0, Lcom/google/analytics/tracking/android/t;->a:Lcom/google/analytics/tracking/android/s;

    iget-object v1, p0, Lcom/google/analytics/tracking/android/t;->a:Lcom/google/analytics/tracking/android/s;

    invoke-static {v1}, Lcom/google/analytics/tracking/android/s;->a(Lcom/google/analytics/tracking/android/s;)Z

    move-result v1

    invoke-virtual {v0, p1, v1}, Lcom/google/analytics/tracking/android/s;->a(ZZ)V

    .line 61
    return-void
.end method
