.class public Lcom/newrelic/agent/android/transport/TransportException;
.super Ljava/lang/Exception;
.source "TransportException.java"


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field private final statusCode:I


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "statusCode"    # I
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 19
    invoke-direct {p0, p2}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 20
    iput p1, p0, Lcom/newrelic/agent/android/transport/TransportException;->statusCode:I

    .line 21
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/String;)V

    .line 15
    const/4 v0, 0x0

    iput v0, p0, Lcom/newrelic/agent/android/transport/TransportException;->statusCode:I

    .line 16
    return-void
.end method

.method public constructor <init>(Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "cause"    # Ljava/lang/Throwable;

    .prologue
    .line 9
    invoke-direct {p0, p1}, Ljava/lang/Exception;-><init>(Ljava/lang/Throwable;)V

    .line 10
    const/4 v0, 0x0

    iput v0, p0, Lcom/newrelic/agent/android/transport/TransportException;->statusCode:I

    .line 11
    return-void
.end method


# virtual methods
.method public getStatusCode()I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/newrelic/agent/android/transport/TransportException;->statusCode:I

    return v0
.end method
