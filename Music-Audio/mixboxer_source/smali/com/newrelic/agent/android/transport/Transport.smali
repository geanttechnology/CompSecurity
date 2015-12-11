.class public interface abstract Lcom/newrelic/agent/android/transport/Transport;
.super Ljava/lang/Object;
.source "Transport.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/newrelic/agent/android/transport/Transport$MessageType;
    }
.end annotation


# virtual methods
.method public abstract send(Lcom/newrelic/agent/android/transport/Transport$MessageType;Ljava/lang/String;J)Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/InterruptedIOException;,
            Lcom/newrelic/agent/android/transport/DisableAgentException;,
            Lcom/newrelic/agent/android/transport/DisconnectAgentException;,
            Lcom/newrelic/agent/android/transport/FlushTransactionDataException;,
            Lcom/newrelic/agent/android/transport/TransportException;
        }
    .end annotation
.end method
