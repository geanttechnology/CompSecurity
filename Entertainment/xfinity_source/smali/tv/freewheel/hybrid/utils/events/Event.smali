.class public Ltv/freewheel/hybrid/utils/events/Event;
.super Ljava/lang/Object;
.source "Event.java"

# interfaces
.implements Ltv/freewheel/hybrid/ad/interfaces/IEvent;


# instance fields
.field public code:I

.field public data:Ljava/util/HashMap;
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

.field public type:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Ltv/freewheel/hybrid/utils/events/Event;->type:Ljava/lang/String;

    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/utils/events/Event;->data:Ljava/util/HashMap;

    .line 16
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "code"    # I

    .prologue
    .line 19
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;)V

    .line 20
    iput p2, p0, Ltv/freewheel/hybrid/utils/events/Event;->code:I

    .line 21
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "message"    # Ljava/lang/String;

    .prologue
    .line 29
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;)V

    .line 30
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/events/Event;->data:Ljava/util/HashMap;

    const-string v1, "message"

    invoke-virtual {v0, v1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 31
    return-void
.end method

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
    .line 24
    .local p2, "data":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/utils/events/Event;-><init>(Ljava/lang/String;)V

    .line 25
    iput-object p2, p0, Ltv/freewheel/hybrid/utils/events/Event;->data:Ljava/util/HashMap;

    .line 26
    return-void
.end method


# virtual methods
.method public getData()Ljava/util/HashMap;
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
    .line 38
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/events/Event;->data:Ljava/util/HashMap;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/events/Event;->type:Ljava/lang/String;

    return-object v0
.end method
