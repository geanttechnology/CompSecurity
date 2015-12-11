.class Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$2;
.super Ljava/lang/Object;
.source "HTMLRenderer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->load(Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

.field final synthetic val$rendererContextFinalRef:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V
    .locals 0

    .prologue
    .line 528
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$2;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    iput-object p2, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$2;->val$rendererContextFinalRef:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 531
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$2;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    iget-object v1, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$2;->val$rendererContextFinalRef:Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;

    # invokes: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->_load(Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V
    invoke-static {v0, v1}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$100(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;)V

    .line 532
    return-void
.end method
