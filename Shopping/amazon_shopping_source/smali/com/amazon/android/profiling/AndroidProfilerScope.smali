.class public Lcom/amazon/android/profiling/AndroidProfilerScope;
.super Ljava/lang/Object;
.source "AndroidProfilerScope.java"

# interfaces
.implements Lcom/amazon/profiling/ProfilerScope;


# instance fields
.field public final method:Z

.field public final name:Ljava/lang/String;

.field public final start:J


# direct methods
.method public constructor <init>(ZLjava/lang/String;J)V
    .locals 0
    .param p1, "method"    # Z
    .param p2, "name"    # Ljava/lang/String;
    .param p3, "start"    # J

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    iput-boolean p1, p0, Lcom/amazon/android/profiling/AndroidProfilerScope;->method:Z

    .line 28
    iput-object p2, p0, Lcom/amazon/android/profiling/AndroidProfilerScope;->name:Ljava/lang/String;

    .line 29
    iput-wide p3, p0, Lcom/amazon/android/profiling/AndroidProfilerScope;->start:J

    .line 30
    return-void
.end method
