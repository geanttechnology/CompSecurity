.class public abstract Lcom/amazon/identity/auth/device/framework/RetryLogic;
.super Ljava/lang/Object;
.source "RetryLogic.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract shouldRetry(Ljava/net/HttpURLConnection;ILcom/amazon/identity/auth/device/framework/Tracer;)Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation
.end method
