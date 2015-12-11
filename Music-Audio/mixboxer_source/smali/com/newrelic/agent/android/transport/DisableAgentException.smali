.class public Lcom/newrelic/agent/android/transport/DisableAgentException;
.super Lcom/newrelic/agent/android/transport/TransportException;
.source "DisableAgentException.java"


# static fields
.field private static final serialVersionUID:J = 0x1L


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 7
    const-string v0, "The collector has asked the agent to disable itself"

    invoke-direct {p0, v0}, Lcom/newrelic/agent/android/transport/TransportException;-><init>(Ljava/lang/String;)V

    .line 8
    return-void
.end method
