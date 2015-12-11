.class Lcom/aio/downloader/activity/FunGifActivity$5;
.super Ljava/lang/Object;
.source "FunGifActivity.java"

# interfaces
.implements Landroid/view/GestureDetector$OnDoubleTapListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunGifActivity;->setListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunGifActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunGifActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunGifActivity$5;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    .line 274
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDoubleTap(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 292
    const/4 v0, 0x0

    return v0
.end method

.method public onDoubleTapEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 286
    const/4 v0, 0x0

    return v0
.end method

.method public onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 279
    iget-object v0, p0, Lcom/aio/downloader/activity/FunGifActivity$5;->this$0:Lcom/aio/downloader/activity/FunGifActivity;

    invoke-virtual {v0}, Lcom/aio/downloader/activity/FunGifActivity;->finish()V

    .line 280
    const/4 v0, 0x0

    return v0
.end method
