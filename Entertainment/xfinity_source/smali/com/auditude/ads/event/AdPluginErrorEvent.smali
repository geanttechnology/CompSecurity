.class public Lcom/auditude/ads/event/AdPluginErrorEvent;
.super Lcom/auditude/ads/event/AdPluginEvent;
.source "AdPluginErrorEvent.java"


# instance fields
.field private error:Ljava/lang/Throwable;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 13
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/auditude/ads/event/AdPluginErrorEvent;-><init>(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/HashMap;)V

    .line 14
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/HashMap;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "error"    # Ljava/lang/Throwable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Throwable;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 18
    .local p3, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-direct {p0, p1, p3}, Lcom/auditude/ads/event/AdPluginEvent;-><init>(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 19
    iput-object p2, p0, Lcom/auditude/ads/event/AdPluginErrorEvent;->error:Ljava/lang/Throwable;

    .line 20
    return-void
.end method
