.class Ltv/freewheel/ad/AdContext$5;
.super Ljava/lang/Object;
.source "AdContext.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/ad/AdContext;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/ad/AdContext;

.field final synthetic val$event:Ltv/freewheel/ad/interfaces/IEvent;


# direct methods
.method constructor <init>(Ltv/freewheel/ad/AdContext;Ltv/freewheel/ad/interfaces/IEvent;)V
    .locals 0

    .prologue
    .line 956
    iput-object p1, p0, Ltv/freewheel/ad/AdContext$5;->this$0:Ltv/freewheel/ad/AdContext;

    iput-object p2, p0, Ltv/freewheel/ad/AdContext$5;->val$event:Ltv/freewheel/ad/interfaces/IEvent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 958
    iget-object v0, p0, Ltv/freewheel/ad/AdContext$5;->this$0:Ltv/freewheel/ad/AdContext;

    iget-object v1, p0, Ltv/freewheel/ad/AdContext$5;->val$event:Ltv/freewheel/ad/interfaces/IEvent;

    # invokes: Ltv/freewheel/utils/events/EventDispatcher;->dispatchEvent(Ltv/freewheel/ad/interfaces/IEvent;)V
    invoke-static {v0, v1}, Ltv/freewheel/ad/AdContext;->access$601(Ltv/freewheel/ad/AdContext;Ltv/freewheel/ad/interfaces/IEvent;)V

    .line 959
    return-void
.end method
