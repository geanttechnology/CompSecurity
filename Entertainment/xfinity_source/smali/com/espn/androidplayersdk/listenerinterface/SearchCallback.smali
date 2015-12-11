.class public interface abstract Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;
.super Ljava/lang/Object;
.source "SearchCallback.java"


# virtual methods
.method public abstract onSearchFailed(I)V
.end method

.method public abstract onSearchSuccess(Ljava/util/ArrayList;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/espn/androidplayersdk/datamanager/EPEvents;",
            ">;)V"
        }
    .end annotation
.end method
