.class Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView$1;
.super Ljava/lang/Object;
.source "MRAIDCustomViewBackgroundView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;-><init>(Landroid/app/Activity;Landroid/webkit/WebChromeClient;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;


# direct methods
.method constructor <init>(Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;)V
    .locals 0

    .prologue
    .line 28
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView$1;->this$0:Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 30
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView$1;->this$0:Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->logger:Ltv/freewheel/utils/Logger;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->access$000(Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    const-string v1, "onClick"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 31
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView$1;->this$0:Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;

    # getter for: Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->webChromeClient:Landroid/webkit/WebChromeClient;
    invoke-static {v0}, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;->access$100(Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;)Landroid/webkit/WebChromeClient;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebChromeClient;->onHideCustomView()V

    .line 32
    return-void
.end method
