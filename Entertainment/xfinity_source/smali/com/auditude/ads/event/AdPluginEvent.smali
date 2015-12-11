.class public Lcom/auditude/ads/event/AdPluginEvent;
.super Ljava/lang/Object;
.source "AdPluginEvent.java"


# instance fields
.field private data:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private type:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p2, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/auditude/ads/event/AdPluginEvent;->type:Ljava/lang/String;

    .line 24
    iput-object p2, p0, Lcom/auditude/ads/event/AdPluginEvent;->data:Ljava/util/HashMap;

    .line 25
    return-void
.end method


# virtual methods
.method public final getData()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 34
    iget-object v0, p0, Lcom/auditude/ads/event/AdPluginEvent;->data:Ljava/util/HashMap;

    return-object v0
.end method

.method public final getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/auditude/ads/event/AdPluginEvent;->type:Ljava/lang/String;

    return-object v0
.end method
