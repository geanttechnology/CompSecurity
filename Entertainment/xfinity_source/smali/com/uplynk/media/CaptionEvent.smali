.class public Lcom/uplynk/media/CaptionEvent;
.super Ljava/lang/Object;
.source "CaptionEvent.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/uplynk/media/CaptionEvent$CaptionCharacter;,
        Lcom/uplynk/media/CaptionEvent$CaptionEventType;,
        Lcom/uplynk/media/CaptionEvent$CaptionMode;,
        Lcom/uplynk/media/CaptionEvent$CaptionRow;
    }
.end annotation


# instance fields
.field public character:Lcom/uplynk/media/CaptionEvent$CaptionCharacter;

.field public eventType:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

.field public mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

.field public rowCount:S

.field public rows:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/uplynk/media/CaptionEvent$CaptionRow;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method protected constructor <init>(Lcom/uplynk/media/CaptionEvent$CaptionMode;Lcom/uplynk/media/CaptionEvent$CaptionEventType;)V
    .locals 2
    .param p1, "mode"    # Lcom/uplynk/media/CaptionEvent$CaptionMode;
    .param p2, "type"    # Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/uplynk/media/CaptionEvent;->mode:Lcom/uplynk/media/CaptionEvent$CaptionMode;

    .line 27
    iput-object p2, p0, Lcom/uplynk/media/CaptionEvent;->eventType:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    .line 29
    sget-object v0, Lcom/uplynk/media/CaptionEvent$CaptionEventType;->TEXT:Lcom/uplynk/media/CaptionEvent$CaptionEventType;

    if-ne p2, v0, :cond_0

    .line 30
    new-instance v0, Landroid/util/SparseArray;

    const/16 v1, 0xf

    invoke-direct {v0, v1}, Landroid/util/SparseArray;-><init>(I)V

    iput-object v0, p0, Lcom/uplynk/media/CaptionEvent;->rows:Landroid/util/SparseArray;

    .line 31
    :cond_0
    return-void
.end method

.method protected constructor <init>(Lcom/uplynk/media/CaptionEvent$CaptionMode;Lcom/uplynk/media/CaptionEvent$CaptionEventType;S)V
    .locals 0
    .param p1, "mode"    # Lcom/uplynk/media/CaptionEvent$CaptionMode;
    .param p2, "type"    # Lcom/uplynk/media/CaptionEvent$CaptionEventType;
    .param p3, "rowCount"    # S

    .prologue
    .line 20
    invoke-direct {p0, p1, p2}, Lcom/uplynk/media/CaptionEvent;-><init>(Lcom/uplynk/media/CaptionEvent$CaptionMode;Lcom/uplynk/media/CaptionEvent$CaptionEventType;)V

    .line 21
    iput-short p3, p0, Lcom/uplynk/media/CaptionEvent;->rowCount:S

    .line 22
    return-void
.end method
