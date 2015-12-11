.class Ltv/freewheel/renderers/temporal/VideoRenderer$1;
.super Ljava/lang/Object;
.source "VideoRenderer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/renderers/temporal/VideoRenderer;->onRedirectUrlChecked(Ljava/lang/String;Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/temporal/VideoRenderer;)V
    .locals 0

    .prologue
    .line 427
    iput-object p1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$1;->this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 429
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$1;->this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;

    # getter for: Ltv/freewheel/renderers/temporal/VideoRenderer;->slot:Ltv/freewheel/ad/interfaces/ISlot;
    invoke-static {v0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->access$100(Ltv/freewheel/renderers/temporal/VideoRenderer;)Ltv/freewheel/ad/interfaces/ISlot;

    move-result-object v0

    invoke-interface {v0}, Ltv/freewheel/ad/interfaces/ISlot;->getBase()Landroid/view/ViewGroup;

    move-result-object v0

    iget-object v1, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$1;->this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;

    # getter for: Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;
    invoke-static {v1}, Ltv/freewheel/renderers/temporal/VideoRenderer;->access$000(Ltv/freewheel/renderers/temporal/VideoRenderer;)Ltv/freewheel/renderers/temporal/VideoAdView;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 430
    iget-object v0, p0, Ltv/freewheel/renderers/temporal/VideoRenderer$1;->this$0:Ltv/freewheel/renderers/temporal/VideoRenderer;

    # getter for: Ltv/freewheel/renderers/temporal/VideoRenderer;->videoAdView:Ltv/freewheel/renderers/temporal/VideoAdView;
    invoke-static {v0}, Ltv/freewheel/renderers/temporal/VideoRenderer;->access$000(Ltv/freewheel/renderers/temporal/VideoRenderer;)Ltv/freewheel/renderers/temporal/VideoAdView;

    move-result-object v0

    invoke-virtual {v0}, Ltv/freewheel/renderers/temporal/VideoAdView;->bringToFront()V

    .line 431
    return-void
.end method
