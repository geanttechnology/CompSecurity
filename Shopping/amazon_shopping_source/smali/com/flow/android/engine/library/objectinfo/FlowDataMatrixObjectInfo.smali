.class public Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;
.super Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;
.source "FlowDataMatrixObjectInfo.java"


# direct methods
.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
    .locals 0
    .param p1, "a_objectInfo"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .prologue
    .line 13
    invoke-direct {p0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 14
    return-void
.end method


# virtual methods
.method public getDataMatrixCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowDataMatrixObjectInfo;->m_objectInfo:Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    invoke-virtual {v0}, Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;->getContent()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
