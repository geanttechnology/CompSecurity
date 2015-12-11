.class final Lar;
.super Ljava/lang/Exception;
.source "SourceFile"


# instance fields
.field final a:J


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 44
    const-wide/16 v0, -0x1

    invoke-direct {p0, v0, v1}, Lar;-><init>(J)V

    .line 45
    return-void
.end method

.method constructor <init>(J)V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 40
    iput-wide p1, p0, Lar;->a:J

    .line 41
    return-void
.end method
