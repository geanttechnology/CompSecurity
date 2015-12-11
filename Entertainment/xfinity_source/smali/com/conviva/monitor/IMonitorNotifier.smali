.class public interface abstract Lcom/conviva/monitor/IMonitorNotifier;
.super Ljava/lang/Object;


# virtual methods
.method public abstract Log(Ljava/lang/String;)V
.end method

.method public abstract OnError(Lcom/conviva/StreamerError;)V
.end method

.method public abstract OnMetadata(Ljava/util/Map;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract SetPlayingState(I)V
.end method
