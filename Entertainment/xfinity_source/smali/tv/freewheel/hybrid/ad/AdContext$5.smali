.class Ltv/freewheel/hybrid/ad/AdContext$5;
.super Ljava/lang/Object;
.source "AdContext.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/ad/AdContext;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/ad/AdContext;

.field final synthetic val$event:Ltv/freewheel/hybrid/ad/interfaces/IEvent;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/ad/AdContext;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    .locals 0

    .prologue
    .line 1002
    iput-object p1, p0, Ltv/freewheel/hybrid/ad/AdContext$5;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    iput-object p2, p0, Ltv/freewheel/hybrid/ad/AdContext$5;->val$event:Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1005
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/AdContext$5;->this$0:Ltv/freewheel/hybrid/ad/AdContext;

    iget-object v1, p0, Ltv/freewheel/hybrid/ad/AdContext$5;->val$event:Ltv/freewheel/hybrid/ad/interfaces/IEvent;

    # invokes: Ltv/freewheel/hybrid/utils/events/EventDispatcher;->dispatchEvent(Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/ad/AdContext;->access$601(Ltv/freewheel/hybrid/ad/AdContext;Ltv/freewheel/hybrid/ad/interfaces/IEvent;)V

    .line 1006
    return-void
.end method
