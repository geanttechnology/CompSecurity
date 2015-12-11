.class Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$7;
.super Ljava/lang/Object;
.source "HTMLRenderer.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->mraidClose()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)V
    .locals 0

    .prologue
    .line 775
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$7;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 777
    iget-object v0, p0, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer$7;->this$0:Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;

    # invokes: Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->_close()V
    invoke-static {v0}, Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;->access$1900(Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;)V

    .line 778
    return-void
.end method
