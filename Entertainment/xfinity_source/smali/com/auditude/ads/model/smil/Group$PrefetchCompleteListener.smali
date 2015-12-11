.class public interface abstract Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;
.super Ljava/lang/Object;
.source "Group.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/model/smil/Group;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "PrefetchCompleteListener"
.end annotation


# virtual methods
.method public abstract onPrefetchComplete(Ljava/util/ArrayList;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/event/AdPluginEvent;",
            ">;)V"
        }
    .end annotation
.end method
