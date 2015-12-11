.class final Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$1;
.super Ljava/util/HashMap;
.source "SloggerTracker.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/HashMap",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 2

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/util/HashMap;-><init>()V

    .line 67
    const-string v0, "001"

    sget v1, Lcom/disney/datg/videoplatforms/sdk/R$string;->slogger_001:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 68
    const-string v0, "002"

    sget v1, Lcom/disney/datg/videoplatforms/sdk/R$string;->slogger_002:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 69
    const-string v0, "004"

    sget v1, Lcom/disney/datg/videoplatforms/sdk/R$string;->slogger_004:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 70
    const-string v0, "008"

    sget v1, Lcom/disney/datg/videoplatforms/sdk/R$string;->slogger_008:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    const-string v0, "009"

    sget v1, Lcom/disney/datg/videoplatforms/sdk/R$string;->slogger_009:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerTracker$1;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 72
    return-void
.end method
