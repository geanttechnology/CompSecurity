.class Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;
.super Ljava/lang/Object;
.source "SideRibbonDelegate.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->adjustMenuTopForNotificationBar(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

.field final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Landroid/view/View;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 304
    iput-object p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    iput-object p2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;->val$view:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 2

    .prologue
    .line 307
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # invokes: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getStatusBarHeight()I
    invoke-static {v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$1000(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)I

    move-result v1

    # setter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->statusBarHeight:I
    invoke-static {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$902(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;I)I

    .line 308
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;->val$view:Landroid/view/View;

    # invokes: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->adjustMenuTopForNotificationBar(Landroid/view/View;)V
    invoke-static {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$1100(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Landroid/view/View;)V

    .line 310
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;->this$0:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    # getter for: Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerParent:Landroid/view/ViewGroup;
    invoke-static {v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->access$1200(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 311
    return-void
.end method
