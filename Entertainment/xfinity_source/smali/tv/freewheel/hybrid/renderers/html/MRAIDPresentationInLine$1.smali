.class Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$1;
.super Landroid/widget/FrameLayout;
.source "MRAIDPresentationInLine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;-><init>(Landroid/app/Activity;Ltv/freewheel/hybrid/renderers/html/HTMLRenderer;Ltv/freewheel/hybrid/renderers/interfaces/IRendererContext;Ljava/lang/Boolean;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;


# direct methods
.method constructor <init>(Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;Landroid/content/Context;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/Context;

    .prologue
    .line 76
    iput-object p1, p0, Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine$1;->this$0:Ltv/freewheel/hybrid/renderers/html/MRAIDPresentationInLine;

    invoke-direct {p0, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 79
    const/4 v0, 0x0

    return v0
.end method
