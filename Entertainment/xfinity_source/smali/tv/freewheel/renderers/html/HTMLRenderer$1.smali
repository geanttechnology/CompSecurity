.class Ltv/freewheel/renderers/html/HTMLRenderer$1;
.super Ljava/lang/Object;
.source "HTMLRenderer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/renderers/html/HTMLRenderer;->synchStateToPresentation(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/html/HTMLRenderer;

.field final synthetic val$isResized:Z


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/html/HTMLRenderer;Z)V
    .locals 0

    .prologue
    .line 444
    iput-object p1, p0, Ltv/freewheel/renderers/html/HTMLRenderer$1;->this$0:Ltv/freewheel/renderers/html/HTMLRenderer;

    iput-boolean p2, p0, Ltv/freewheel/renderers/html/HTMLRenderer$1;->val$isResized:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 447
    iget-object v0, p0, Ltv/freewheel/renderers/html/HTMLRenderer$1;->this$0:Ltv/freewheel/renderers/html/HTMLRenderer;

    iget-boolean v1, p0, Ltv/freewheel/renderers/html/HTMLRenderer$1;->val$isResized:Z

    # invokes: Ltv/freewheel/renderers/html/HTMLRenderer;->_synchStateToPresentation(Z)V
    invoke-static {v0, v1}, Ltv/freewheel/renderers/html/HTMLRenderer;->access$000(Ltv/freewheel/renderers/html/HTMLRenderer;Z)V

    .line 448
    return-void
.end method
