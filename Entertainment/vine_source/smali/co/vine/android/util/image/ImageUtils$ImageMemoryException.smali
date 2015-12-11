.class public Lco/vine/android/util/image/ImageUtils$ImageMemoryException;
.super Ljava/lang/Exception;
.source "ImageUtils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/image/ImageUtils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ImageMemoryException"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/OutOfMemoryError;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/OutOfMemoryError;

    .prologue
    .line 208
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/Throwable;)V

    .line 209
    return-void
.end method
