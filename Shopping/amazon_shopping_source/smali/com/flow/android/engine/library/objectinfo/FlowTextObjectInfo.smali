.class public Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;
.super Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;
.source "FlowTextObjectInfo.java"


# instance fields
.field private m_asins:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V
    .locals 1
    .param p1, "a_objectInfo"    # Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Lcom/flow/android/engine/library/objectinfo/FlowObjectInfo;-><init>(Lcom/a9/vs/mobile/library/impl/jni/ObjectInfo;)V

    .line 14
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/flow/android/engine/library/objectinfo/FlowTextObjectInfo;->m_asins:Ljava/util/List;

    .line 18
    return-void
.end method
