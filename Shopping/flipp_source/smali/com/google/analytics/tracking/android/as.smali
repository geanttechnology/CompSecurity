.class final Lcom/google/analytics/tracking/android/as;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/analytics/tracking/android/m;


# instance fields
.field final synthetic a:Lcom/google/analytics/tracking/android/ar;


# direct methods
.method constructor <init>(Lcom/google/analytics/tracking/android/ar;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Lcom/google/analytics/tracking/android/as;->a:Lcom/google/analytics/tracking/android/ar;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a()J
    .locals 2

    .prologue
    .line 115
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    return-wide v0
.end method
