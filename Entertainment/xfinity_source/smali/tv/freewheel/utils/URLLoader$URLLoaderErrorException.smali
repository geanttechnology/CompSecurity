.class public final Ltv/freewheel/utils/URLLoader$URLLoaderErrorException;
.super Ljava/lang/Exception;
.source "URLLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltv/freewheel/utils/URLLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "URLLoaderErrorException"
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 65
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 66
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "throwable"    # Ljava/lang/Throwable;

    .prologue
    .line 68
    invoke-direct {p0, p1, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 69
    return-void
.end method
