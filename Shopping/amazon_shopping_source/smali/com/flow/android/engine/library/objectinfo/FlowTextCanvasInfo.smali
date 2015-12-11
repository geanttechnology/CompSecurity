.class public Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;
.super Ljava/lang/Object;
.source "FlowTextCanvasInfo.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo$ContactInfo;
    }
.end annotation


# instance fields
.field private m_sessionId:I

.field protected m_textCanvasInfo:Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

.field private m_uniqueId:Ljava/lang/String;


# direct methods
.method public constructor <init>(ILjava/lang/String;)V
    .locals 0
    .param p1, "a_sessionId"    # I
    .param p2, "a_uniqueId"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput p1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;->m_sessionId:I

    .line 42
    iput-object p2, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;->m_uniqueId:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;)V
    .locals 1
    .param p1, "a_textCanvasInfo"    # Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;->m_textCanvasInfo:Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;

    .line 35
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->getId()I

    move-result v0

    iput v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;->m_sessionId:I

    .line 36
    invoke-virtual {p1}, Lcom/a9/vs/mobile/library/impl/jni/TextCanvasInfo;->getUniqueID()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextCanvasInfo;->m_uniqueId:Ljava/lang/String;

    .line 37
    return-void
.end method
