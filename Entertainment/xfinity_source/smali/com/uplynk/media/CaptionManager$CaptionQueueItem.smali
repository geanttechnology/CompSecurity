.class public Lcom/uplynk/media/CaptionManager$CaptionQueueItem;
.super Ljava/lang/Object;
.source "CaptionManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/uplynk/media/CaptionManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "CaptionQueueItem"
.end annotation


# instance fields
.field public action:Lcom/uplynk/media/CaptionManager$CaptionAction;

.field public channel:S

.field public mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

.field public pause:Z

.field public rowCount:I

.field final synthetic this$0:Lcom/uplynk/media/CaptionManager;

.field public value:I


# direct methods
.method protected constructor <init>(Lcom/uplynk/media/CaptionManager;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1210
    iput-object p1, p0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->this$0:Lcom/uplynk/media/CaptionManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1212
    sget-object v0, Lcom/uplynk/media/CaptionEvent$CaptionMode;->UNKNOWN:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 1213
    sget-object v0, Lcom/uplynk/media/CaptionManager$CaptionAction;->UNKNOWN:Lcom/uplynk/media/CaptionManager$CaptionAction;

    iput-object v0, p0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->action:Lcom/uplynk/media/CaptionManager$CaptionAction;

    .line 1215
    iput-short v1, p0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->channel:S

    .line 1216
    iput-boolean v1, p0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->pause:Z

    .line 1217
    const/4 v0, 0x1

    iput v0, p0, Lcom/uplynk/media/CaptionManager$CaptionQueueItem;->rowCount:I

    return-void
.end method
