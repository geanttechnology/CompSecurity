.class public abstract Lco/vine/android/recorder/AbstractEncodingRunnable;
.super Ljava/lang/Object;
.source "AbstractEncodingRunnable.java"

# interfaces
.implements Ljava/lang/Runnable;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract setAsyncTask(Lco/vine/android/recorder/BaseFinishProcessTask;)V
.end method

.method public abstract terminate()V
.end method
