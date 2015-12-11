.class public Lcom/conviva/session/EventQueue;
.super Ljava/lang/Object;


# instance fields
.field private _events:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field private _nextSeqNumber:I


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/conviva/session/EventQueue;->_events:Ljava/util/List;

    const/4 v0, 0x0

    iput v0, p0, Lcom/conviva/session/EventQueue;->_nextSeqNumber:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/conviva/session/EventQueue;->_events:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public enqueueEvent(Ljava/lang/String;Ljava/util/Map;I)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;I)V"
        }
    .end annotation

    const-string v0, "t"

    invoke-interface {p2, v0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "st"

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p2, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "seq"

    iget v1, p0, Lcom/conviva/session/EventQueue;->_nextSeqNumber:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {p2, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget v0, p0, Lcom/conviva/session/EventQueue;->_nextSeqNumber:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/conviva/session/EventQueue;->_nextSeqNumber:I

    iget-object v0, p0, Lcom/conviva/session/EventQueue;->_events:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public flushEvents()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation

    iget-object v0, p0, Lcom/conviva/session/EventQueue;->_events:Ljava/util/List;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/conviva/session/EventQueue;->_events:Ljava/util/List;

    return-object v0
.end method

.method public size()I
    .locals 1

    iget-object v0, p0, Lcom/conviva/session/EventQueue;->_events:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method
