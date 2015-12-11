.class Ltv/freewheel/renderers/html/MRAIDWebView$4;
.super Ljava/lang/Object;
.source "MRAIDWebView.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/renderers/html/MRAIDWebView;->init(Ltv/freewheel/renderers/html/HTMLRenderer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/html/MRAIDWebView;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/html/MRAIDWebView;)V
    .locals 0

    .prologue
    .line 321
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView$4;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 2

    .prologue
    .line 324
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$4;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    invoke-virtual {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 325
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$4;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    const/4 v1, 0x1

    # setter for: Ltv/freewheel/renderers/html/MRAIDWebView;->pageShown:Z
    invoke-static {v0, v1}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$802(Ltv/freewheel/renderers/html/MRAIDWebView;Z)Z

    .line 326
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView$4;->this$0:Ltv/freewheel/renderers/html/MRAIDWebView;

    # invokes: Ltv/freewheel/renderers/html/MRAIDWebView;->tryTriggerLoaded()V
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->access$700(Ltv/freewheel/renderers/html/MRAIDWebView;)V

    .line 327
    return-void
.end method
