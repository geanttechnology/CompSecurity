.class public Lco/vine/android/recorder/SwVineFrameRecorder$Exception;
.super Ljava/lang/Exception;
.source "SwVineFrameRecorder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/SwVineFrameRecorder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Exception"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 1259
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 1260
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 1263
    invoke-direct {p0, p1, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 1264
    return-void
.end method
