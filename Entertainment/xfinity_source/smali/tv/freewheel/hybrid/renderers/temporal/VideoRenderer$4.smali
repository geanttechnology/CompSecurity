.class Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$4;
.super Ljava/util/TimerTask;
.source "VideoRenderer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->startQuartileImpressionAndTimeoutTimer()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;)V
    .locals 0

    .prologue
    .line 678
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$4;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 681
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer$4;->this$0:Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;

    # invokes: Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->onImprTimer()V
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;->access$100(Ltv/freewheel/hybrid/renderers/temporal/VideoRenderer;)V

    .line 682
    return-void
.end method
