.class final Lcom/google/analytics/tracking/android/x;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/google/analytics/tracking/android/v;


# direct methods
.method constructor <init>(Lcom/google/analytics/tracking/android/v;)V
    .locals 0

    .prologue
    .line 242
    iput-object p1, p0, Lcom/google/analytics/tracking/android/x;->a:Lcom/google/analytics/tracking/android/v;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 245
    iget-object v0, p0, Lcom/google/analytics/tracking/android/x;->a:Lcom/google/analytics/tracking/android/v;

    invoke-virtual {v0}, Lcom/google/analytics/tracking/android/v;->f()V

    .line 246
    return-void
.end method
