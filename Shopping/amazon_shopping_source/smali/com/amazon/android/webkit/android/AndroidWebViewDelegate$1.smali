.class Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$1;
.super Landroid/webkit/WebView;
.source "AndroidWebViewDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;-><init>(Lcom/amazon/android/webkit/AmazonWebView;ILjava/util/concurrent/atomic/AtomicReference;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;


# direct methods
.method constructor <init>(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;Landroid/content/Context;)V
    .locals 0
    .param p2, "x0"    # Landroid/content/Context;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$1;->this$0:Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

    invoke-direct {p0, p2}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected onScrollChanged(IIII)V
    .locals 1
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "oldl"    # I
    .param p4, "oldt"    # I

    .prologue
    .line 134
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$1;->this$0:Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

    # invokes: Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onWebViewScrollChanged(II)V
    invoke-static {v0, p1, p2}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->access$200(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;II)V

    .line 135
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebView;->onScrollChanged(IIII)V

    .line 136
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 140
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$1;->this$0:Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

    # invokes: Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onWebViewTouchEvent(Landroid/view/MotionEvent;)Z
    invoke-static {v0, p1}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->access$300(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;Landroid/view/MotionEvent;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0, p1}, Landroid/webkit/WebView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public overScrollBy(IIIIIIIIZ)Z
    .locals 10
    .param p1, "deltaX"    # I
    .param p2, "deltaY"    # I
    .param p3, "scrollX"    # I
    .param p4, "scrollY"    # I
    .param p5, "scrollRangeX"    # I
    .param p6, "scrollRangeY"    # I
    .param p7, "maxOverScrollX"    # I
    .param p8, "maxOverScrollY"    # I
    .param p9, "isTouchEvent"    # Z

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$1;->this$0:Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

    move v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move v5, p5

    move/from16 v6, p6

    move/from16 v7, p7

    move/from16 v8, p8

    move/from16 v9, p9

    # invokes: Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onWebViewOverScrollBy(IIIIIIIIZ)V
    invoke-static/range {v0 .. v9}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->access$000(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;IIIIIIIIZ)V

    .line 126
    iget-object v0, p0, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate$1;->this$0:Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;

    # invokes: Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->onWebViewScrolling(IIII)V
    invoke-static {v0, p1, p2, p3, p4}, Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;->access$100(Lcom/amazon/android/webkit/android/AndroidWebViewDelegate;IIII)V

    .line 129
    invoke-super/range {p0 .. p9}, Landroid/webkit/WebView;->overScrollBy(IIIIIIIIZ)Z

    move-result v0

    return v0
.end method
