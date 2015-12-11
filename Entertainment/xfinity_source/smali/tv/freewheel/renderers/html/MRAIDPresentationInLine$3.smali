.class Ltv/freewheel/renderers/html/MRAIDPresentationInLine$3;
.super Ljava/lang/Object;
.source "MRAIDPresentationInLine.java"

# interfaces
.implements Landroid/view/ViewGroup$OnHierarchyChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/renderers/html/MRAIDPresentationInLine;->show()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/html/MRAIDPresentationInLine;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/html/MRAIDPresentationInLine;)V
    .locals 0

    .prologue
    .line 176
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDPresentationInLine$3;->this$0:Ltv/freewheel/renderers/html/MRAIDPresentationInLine;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onChildViewAdded(Landroid/view/View;Landroid/view/View;)V
    .locals 2
    .param p1, "parent"    # Landroid/view/View;
    .param p2, "child"    # Landroid/view/View;

    .prologue
    .line 179
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDPresentationInLine$3;->this$0:Ltv/freewheel/renderers/html/MRAIDPresentationInLine;

    # getter for: Ltv/freewheel/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDPresentationInLine;->access$100(Ltv/freewheel/renderers/html/MRAIDPresentationInLine;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    const-string v1, "onChildViewAdded"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 180
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDPresentationInLine$3;->this$0:Ltv/freewheel/renderers/html/MRAIDPresentationInLine;

    # getter for: Ltv/freewheel/renderers/html/MRAIDPresentationInLine;->alphaHolder:Landroid/widget/FrameLayout;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDPresentationInLine;->access$000(Ltv/freewheel/renderers/html/MRAIDPresentationInLine;)Landroid/widget/FrameLayout;

    move-result-object v0

    if-eq v0, p2, :cond_0

    .line 182
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDPresentationInLine$3;->this$0:Ltv/freewheel/renderers/html/MRAIDPresentationInLine;

    invoke-virtual {v0}, Ltv/freewheel/renderers/html/MRAIDPresentationInLine;->refresh()V

    .line 184
    :cond_0
    return-void
.end method

.method public onChildViewRemoved(Landroid/view/View;Landroid/view/View;)V
    .locals 2
    .param p1, "parent"    # Landroid/view/View;
    .param p2, "child"    # Landroid/view/View;

    .prologue
    .line 188
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDPresentationInLine$3;->this$0:Ltv/freewheel/renderers/html/MRAIDPresentationInLine;

    # getter for: Ltv/freewheel/renderers/html/MRAIDPresentationInLine;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDPresentationInLine;->access$100(Ltv/freewheel/renderers/html/MRAIDPresentationInLine;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    const-string v1, "onChildViewRemoved, do nothing"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 189
    return-void
.end method
